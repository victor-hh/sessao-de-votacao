## Pré-requisitos

Para rodar a aplicação é necessário:
- Docker
- Java 17

Para executar o banco de dados, execute este comando no seu terminal:

docker run -p 5432:5432 -v /tmp/database:/var/lib/postgresql/data -e POSTGRES_PASSWORD=1234 -d postgres

O projeto foi feito no IntelliJ IDEA, basta abrir o projeto e rodar, caso haja dificuldade para rodar o docker, pode ser rodado em H2, apenas alterar o perfil no application.yml

Há uma collection postman na raiz do projeto com exemplos de uso de todos os endpoints da API.