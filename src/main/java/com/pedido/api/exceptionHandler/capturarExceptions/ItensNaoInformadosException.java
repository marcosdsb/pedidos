package com.pedido.api.exceptionHandler.capturarExceptions;

public class ItensNaoInformadosException extends RuntimeException{

    public ItensNaoInformadosException(String message) {
        super(message);
    }

}
