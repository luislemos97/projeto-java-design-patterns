## Sistema de Notificações de Pedidos
Este projeto é um sistema de notificações de pedidos desenvolvido com Spring Boot, H2 como banco de dados em memória para testes e implementa os padrões de design Singleton e Strategy. A aplicação permite a criação de pedidos e envia notificações com diferentes estratégias, como e-mail, SMS ou push notification.

### Estrutura do Projeto
````bash
src
└── main
├── java
│   └── com
│       └── exemplo
│           └── sistema_notificacoes
│               ├── SistemaNotificacoesApplication.java    # Classe principal
│               │
│               ├── controller
│               │   └── OrderController.java               # Endpoints REST para pedidos
│               │
│               ├── entity
│               │   ├── Order.java                         # Entidade de pedidos
│               │   └── Notification.java                  # Entidade de notificações
│               │
│               ├── repository
│               │   ├── OrderRepository.java               # Repositório de pedidos
│               │   └── NotificationRepository.java        # Repositório de notificações
│               │
│               ├── service
│               │   ├── OrderService.java                  # Serviço para lógica de pedidos
│               │   └── NotificationManager.java           # Gerenciador de notificações (Singleton)
│               │
│               └── strategy
│                   ├── NotificationStrategy.java          # Interface de estratégia
│                   ├── EmailNotification.java             # Notificação por e-mail
│                   ├── SMSNotification.java               # Notificação por SMS
│                   └── PushNotification.java              # Notificação por push
│
└── resources
├── application.properties                             # Configurações do Spring e H2
└── data.sql                                           # Script opcional para popular dados
````
### Tecnologias Utilizadas
Spring Boot: framework principal para criação da aplicação.
Spring Data JPA: abstração para persistência de dados.
H2 Database: banco de dados em memória para testes.
Singleton e Strategy: padrões de design utilizados na implementação do sistema de notificações.

### Funcionalidades
Criação de pedidos: criação de pedidos com status customizado via parâmetros da URL.
Notificações de pedido: diferentes tipos de notificação podem ser enviados quando um pedido é criado, utilizando o padrão Strategy para alternar entre as estratégias de notificação.
Persistência: o projeto usa H2 para armazenar dados em memória, facilitando o teste e desenvolvimento.

### Instalação
Clone o repositório:

````bash
Copiar código
git clone https://github.com/luislemos97/dio-trilha-java/tree/main/projeto-java-design-patterns-strategy-main
cd java-design-patterns-strategy
````
Compile o projeto: Certifique-se de ter o Maven configurado e execute:

````bash
Copiar código
./mvnw clean install
````

Execute o projeto:

````bash
Copiar código
./mvnw spring-boot:run
````
Acesse o H2 Console:

````bash
URL: http://localhost:8080/h2-console
````
Configurações de conexão:
````bash
Driver: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
Usuário: sa
Senha: (deixe em branco)
Endpoints Principais
Criar Pedido
POST /api/orders?status={status}
````
### Exemplo de requisição para criar um pedido com status Order received:

````bash
POST /api/orders?status=Order%20received
````
### Resposta de sucesso:
````bash
{
"id": 1,
"status": "Order received"
}
````

### Visualizar Pedidos
````bash
GET /api/orders
````

### Retorna todos os pedidos criados.
````bash
[
 {
   "id": 1,
   "status": "Order received"
 },
 {
  "id": 2,
  "status": "Order shipped"
 }
]
````
### Implementação dos Padrões de Projeto
* Singleton: NotificationManager é um singleton que gerencia o envio de notificações, garantindo que uma única instância gerencie todo o fluxo.
* Strategy: NotificationStrategy é uma interface que define o método sendNotification. As classes EmailNotification, SMSNotification e PushNotification implementam diferentes tipos de notificações, e a estratégia de envio é definida em tempo de execução.
* Testes

### Para executar os testes, use o seguinte comando:

````bash
./mvnw test
````

### Os testes estão localizados em src/test/java e incluem:

* OrderServiceTest: Testa a criação de pedidos e a integração com o banco H2.
* NotificationManagerTest: Testa o comportamento das estratégias de notificação.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.