Ambas as API's estão com Spring Boot 3.05, e Java 17. Para o gerenciamento de depêndicias foi utilizado o Maven.

É necessário conter o Docker na máquina.

Bancos de dados utilizados neste exercício foi o MySQL 8 rodando em um container docker. Para a mensageria foi-se utilizado o broker RabbitMQ também rodando em um container docker.

A conexão com o banco de dados e com a mensageria é configurada através do arquivo application.yml, contido na pasta resources das respectivas API's. Porém, alguns parâmetros das configurações são configurados via docker-compose.



Para iniciar ambas os serviços (RabbitMQ, MYSQL, E AS DUAS API'S) é necessário executar o arquivo docker-compose.

O Swagger da API é acessado através da url: http://localhost:8080/swagger-ui/index.html#/

Já a documentação é acessada através da url: http://localhost:8080/v3/api-docs


