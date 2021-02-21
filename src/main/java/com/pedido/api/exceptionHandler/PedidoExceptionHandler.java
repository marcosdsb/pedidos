package com.pedido.api.exceptionHandler;

import com.pedido.api.enums.StatusEnum;
import com.pedido.api.exceptionHandler.capturarExceptions.ItensNaoInformadosException;
import com.pedido.api.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class PedidoExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<MensagemErro> erros = criarListaErros( ex.getBindingResult() );

        return handleExceptionInternal(ex, erros , headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
        PedidoInValido pedidoInValido = new  PedidoInValido(StatusEnum.CODIGO_PEDIDO_INVALIDO.toString());
        return handleExceptionInternal(ex, pedidoInValido , new HttpHeaders(), HttpStatus.NOT_FOUND, request);

    }

   @ExceptionHandler({ItensNaoInformadosException.class})
   public ResponseEntity<Object> handleItensNaoInformadosException(ItensNaoInformadosException e) {
      String mensagemUsuario = messageSource.getMessage(Constants.CAMPO_NAO_INFORMADO,  new Object[] {e.getMessage()}, LocaleContextHolder.getLocale());
      String mensagemDesenvolvedor = e.toString();
      MensagemErro erros = new MensagemErro(mensagemUsuario+": "+e.getMessage().toString(), mensagemDesenvolvedor);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
   }


    private List<MensagemErro> criarListaErros(BindingResult bindingResult){
        List<MensagemErro> erros = new ArrayList<>();

        for(FieldError fieldError : bindingResult.getFieldErrors()) {

            String mensagemUsuario = messageSource.getMessage(fieldError , LocaleContextHolder.getLocale());
            String mensagemDesenvolvedor = fieldError.toString();
            erros.add( new MensagemErro(mensagemUsuario, mensagemDesenvolvedor)  );
        }

        return erros;
    }


    public static class MensagemErro {

        private String mensagemUsuario;
        private String mensagemDesenvolvedor;

        public MensagemErro(String mensagemUsuario, String mensagemDesenvolvedor) {
            this.mensagemUsuario = mensagemUsuario;
            this.mensagemDesenvolvedor = mensagemDesenvolvedor;
        }

        public String getMensagemUsuario() {
            return mensagemUsuario;
        }

        public String getMensagemDesenvolvedor() {
            return mensagemDesenvolvedor;
        }

    }

    public static class PedidoInValido{

        private String status;

        public PedidoInValido(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }


}
