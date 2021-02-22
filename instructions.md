<h2>Documentação API Pedidos</h2>

<h3>1.0 - Requisitos da app PEDIDOS</h3>
<p>- Java 8</p>
<p>- Spring Boot versão 2.4.2</p>
<p>- Banco de dados H2</p>
<p>- Swagger versão: 3.0.0</p>
<p>- Lombok</p>
<p>- Modelmapper versão 2.3.0</p>

<h3>2.0 – Descrição Funcional</h3>
<p>A aplicação realiza permite o CRUD de pedidos com seu itens.</p>
<p>Essa API possui 2 rest controlles:</p>
 → /api/pedido: Permite inserir, editar, buscar pelo pedido e excluir o pedido com seus devidos itens;</br>
 → /api/status: Permite a aprovação ou reprovação de pedido

<h3>3.0 – Acesso a API</h3>
<p>Subir a aplicação <b>mvnw spring-boot:run</b></p>
A API pedidos pode ser acessado para devidos testes entre outros pelo POSTMAN ou SWAGGER.

<h4>Url para acesso pelo swagger</h4>
<p>→ url: http://localhost:9000/swagger-ui/#/</p>

<h4>Pelo POSTMAN, digitar na área de request a url localhost:9000/api/pedidos</h4>
<p><b>Para Pedidos</b></p>
<p>POST</p>
localhost:9000/api/pedido<br>
{
  "numPedido":"123456-N",
  "itens": [
  {
    "descricao": "Televisor 14'",
    "precoUnitario": 1250,
    "quantidade": 2
  },
  {
    "descricao": "Geladeira",
    "precoUnitario": 5,
    "quantidade": 2
  }
  ]
}

<p>PUT</p>
localhost:9000/api/pedido/123456-N<br>
{
  "itens": [
    {
        "descricao": "Televisão 8'",
        "precoUnitario": 1510,
        "quantidade": 5
    }

  ]
}

<p>GET</p>
localhost:9000/api/pedido/123456-N<br>

<p>DELETE</p>
localhost:9000/api/pedido/123456-N<br>

<p><b>Para Status do Pedido</b></p>
<p>POST</p>
localhost:9000/api/status</br>
{
  "status":"APROVADO",
  "itensAprovados": 3,
  "valorAprovado": 2511,
  "pedido": "123456-N"
}




<h2>4.0 – Banco de Dados</h2>
<p>H2</p>

<h3>4.1 -  Acesso</h3>
   <p>→ Url: http://localhost:9000/h2</p>
   <p>→ Login: sa</p>
   <p>→password: deixar em branco </p>
	