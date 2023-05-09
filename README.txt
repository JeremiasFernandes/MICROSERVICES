Ambas as API's estão com Spring Boot 3.05, e Java 17. Para o gerenciamento de depêndicias foi utilizado o Maven.

Bancos de dados utilizados neste exercício foi o MySQL rodando localmente. Para a mensageria foi-se utilizado o broker RabbitMQ.

A conexão com o banco de dados e com a mensageria é configurada através do arquivo application.yml, contido na pasta resources.



Para iniciar ambas os serviços (RabbitMQ, MYSQL, E AS DUAS API'S) é necessário executar o arquivo docker-compose.

O Swagger da API é acessado através da url: http://localhost:8080/swagger-ui/index.html#/

Já a documentação é acessada através da url: http://localhost:8080/v3/api-docs


