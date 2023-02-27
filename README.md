# testPaxPrimavera
Teste Pax Primavera

O código resolve o seguinte desafio:
https://github.com/pax-primavera/desafio-backend/blob/v1/README.md#ser%C3%A1-avaliado

No arquivo "aplication.propeties" do projeto, o banco de dados está inicializado com as seguintes configurações: 
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=1234

Talves haja necessidade de alterar o username (postgres) e password (1234) e talves o nome data base (postgres). 


FLAYWAY
A ferramente flayway foi integrada para criar e popular as tabelas.

ENDPOINTS-PLANOS
GET - http://localhost:8080/api/planos 
*retorna todos os planos cadastrados

GET - http://localhost:8080/api/planos/{id}
*retorna o plano especificado caso exista

GET - http://localhost:8080/api/planos?descricao={"descrição"}page={page}&size={size}&sort={"sort"}
*Retorna os Planos de acordo com o termo passado via querystring e paginação

PUT - http://localhost:8080/api/planos/{id}
*Atualiza os dados do plano

POST - http://localhost:8080/api/planos
*Adiciona um novo plano(não há necessidade de passar o id, pois já é agragado automaticamente pelo BD)

DELETE http://localhost:8080/api/planos/{id}
*Apagar o cadastro do plano

ENDPOINTS-CLIENTES
GET - http://localhost:8080/api/clientes
*retorna todos os clientes cadastrados

GET - http://localhost:8080/api/clientes/{id}
*retorna o clientes especificado caso exista

GET - http://localhost:8080/api/clientes?nome={"nome"}page={page}&size={size}&sort={"sort"}
*Retorna os Clientes de acordo com o termo passado via querystring e paginação

PUT - http://localhost:8080/api/clientes/{id}
*Atualiza os dados do clientes

POST - http://localhost:8080/api/clientes
*Adiciona um novo clientes(não há necessidade de passar o id, pois já é agragado automaticamente pelo BD)

DELETE http://localhost:8080/api/clientes/{id}
*Apagar o cadastro do clientes

LINK PARA ACESSAR SWAGGER
http://localhost:8080/swagger-ui/index.html#/

IMAGEM DA MODELAGEM DO BANCO DE DADOS
![Modelagem do Bancos de Dados](https://user-images.githubusercontent.com/58486678/221475291-5dd4fcf9-52c6-4ac9-9cd2-33386bf2073b.jpeg)
