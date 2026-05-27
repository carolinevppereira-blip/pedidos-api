pedidos-api (porta 8083)
Rodar o projeto: clica no ▶ verde com o pedidos-api aberto.
Criar banco no MySQL Workbench:
sqlUSE pedidos_db;
SELECT * FROM clientes;
SELECT * FROM pedidos;
No Postman — primeiro cria o cliente, depois o pedido:
Criar cliente — POST
URL: http://localhost:8083/clientes
Body (JSON):
{
    "nome": "João Silva",
    "email": "joao@email.com",
    "telefone": "11999999999"
}
Criar pedido — POST
URL: http://localhost:8083/pedidos
Body (JSON):
{
    "cliente": { "id": 1 },
    "descricao": "Pedido de produtos diversos",
    "valor": 350.00
}
Listar clientes — GET
URL: http://localhost:8083/clientes
Listar pedidos — GET
URL: http://localhost:8083/pedidos
Atualizar status do pedido — PUT
URL: http://localhost:8083/pedidos/1
Body (JSON):
{
    "descricao": "Pedido de produtos diversos",
    "valor": 350.00,
    "status": "APROVADO"
}
Deletar pedido — DELETE
URL: http://localhost:8083/pedidos/1






Configuração no Postman
Para todos os requests com Body, lembra de:

Selecionar Body → raw → JSON
Colocar o header Content-Type: application/json
