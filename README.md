# Projeto SunnyMeter - Energia

Este projeto fornece uma API REST para gerenciar clientes, instalações, contratos, consumo e produção de energia, utilizando o Spring Boot, Maven e banco de dados MySQL para persistência. A aplicação foi desenvolvida para a concessionária de energia CPEEL, visando otimizar o monitoramento de consumo e a geração distribuída de energia elétrica.

## Integrantes
- **Guilherme Silva dos Santos** - RM551168
- **Samuel Ramos de Almeida** - RM99134

##  Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.x**
- **Maven 3.x**
- **MySQL 8.x**
- **JPA / Hibernate** (para persistência de dados)

## Como executar o Projeto

### Pré-requisitos

- **JDK 17+**: Instale [aqui](https://adoptopenjdk.net/)
- **Maven**: Instale [aqui](https://maven.apache.org/install.html) ou utilize o wrapper incluso no projeto (./mvnw no Linux/macOS ou mvnw.bat no Windows)
- **MySQL**: Instale [aqui](https://dev.mysql.com/downloads/installer/)

### Configuração do Banco de Dados

Este projeto utiliza o banco de dados **MySQL**. A configuração do banco está no arquivo `application.properties` dentro do diretório `src/main/resources`:

\`\`\`properties
spring.datasource.url=jdbc:mysql://localhost:3306/sunnymeter
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
\`\`\`

### Executando o Projeto

1. **No terminal**, navegue até o diretório do projeto:
    \`\`\`bash
    cd /caminho/para/seu/projeto
    \`\`\`

2. **Execute o comando para iniciar o servidor**:
    \`\`\`bash
    ./mvnw spring-boot:run
    \`\`\`

3. Acesse a aplicação em: [http://localhost:8080](http://localhost:8080)

### Acessando o Banco de Dados MySQL

Se necessário, você pode acessar o banco de dados MySQL diretamente utilizando as credenciais configuradas no `application.properties`:
- **JDBC URL**: `jdbc:mysql://localhost:3306/sunnymeter`
- **Username**: `root`
- **Password**: `root`

---

## Rotas 

### Contratos
- **Criar Contrato**
    - `POST /contratos`
    - **Exemplo de Body**:
      \`\`\`json
      {
        "instalacao_uuid": "5567185a-87dd-4bfc-b3c4-d0b111b3c8ac",
        "cliente_uuid": "e57aed04-268e-43d3-aa56-198f59b130bf",
        "timeframe": 180
      }
      \`\`\`

- **Buscar Contrato por UUID**
    - `GET /contratos/{contrato_uuid}`
    - **Exemplo de Consulta**:
      `GET /contratos/10ea3582-000d-4546-afdf-8677bc58e606`
    - **Exemplo de Resposta**:
      \`\`\`json
      {
        "instalacao_uuid": "5567185a-87dd-4bfc-b3c4-d0b111b3c8ac",
        "cliente_uuid": "e57aed04-268e-43d3-aa56-198f59b130bf",
        "contrato_uuid": "10ea3582-000d-4546-afdf-8677bc58e606",
        "timeframe": 180,
        "status": "Ativo",
        "contrato_inicio_timestamp": 1728990000
      }
      \`\`\`

- **Deletar Contrato (Lógica)**
    - `DELETE /contratos/{contrato_uuid}`
    - **Exemplo de Resposta após Deleção**:
      \`\`\`json
      {
        "instalacao_uuid": "5567185a-87dd-4bfc-b3c4-d0b111b3c8ac",
        "cliente_uuid": "e57aed04-268e-43d3-aa56-198f59b130bf",
        "contrato_uuid": "10ea3582-000d-4546-afdf-8677bc58e606",
        "status": "Cancelado",
        "contrato_inicio_timestamp": 1728990000
      }
      \`\`\`

---

### Consumo
- **Registrar Consumo**
    - `POST /consumo`
    - **Exemplo de Body**:
      \`\`\`json
      {
        "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
        "consumo_kwh": 410.90,
        "medicao_timestamp": 1731284100
      }
      \`\`\`

- **Obter Consumo Mensal**
    - `GET /consumo/{instalacao_uuid}`
    - **Exemplo de Consulta**:
      `GET /consumo/7da41106-5109-45f4-8d09-9ca405c33e5c`
    - **Exemplo de Resposta**:
      \`\`\`json
      {
        "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
        "timestamp_calculo": 1731445100,
        "dia_referencia": "12",
        "mes_referencia": "Novembro",
        "ano_referencia": "2024",
        "dias_para_acabar_o_mes": "18",
        "consumo_mensal_medio_kwh": 44.4,
        "consumo_diario_medio_kwh": 3.7,
        "consumo_mensal_estimado_kwh": 111.0
      }
      \`\`\`

---

### Produção
- **Registrar Produção**
    - `POST /producao`
    - **Exemplo de Body**:
      \`\`\`json
      {
        "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
        "producao_kwh": 10.47,
        "medicao_timestamp": 1731284100
      }
      \`\`\`

- **Obter Produção Mensal**
    - `GET /producao/{instalacao_uuid}`
    - **Exemplo de Consulta**:
      `GET /producao/7da41106-5109-45f4-8d09-9ca405c33e5c`
    - **Exemplo de Resposta**:
      \`\`\`json
      {
        "registro_producao_uuid": "17a71709-5c16-4fc8-9517-0151bbf514a1",
        "instalacao_uuid": "7da41106-5109-45f4-8d09-9ca405c33e5c",
        "producao_kwh": 10.47,
        "medicao_timestamp": 1731284100,
        "created_at": 1731284180
      }
      \`\`\`

---

## Regras de Negócio

### Cliente
- A deleção de um cliente é feita de forma lógica, ou seja, a flag `ativo` é modificada para `false`, e não excluímos fisicamente o registro.

### Instalação
- As instalações também seguem a regra de deleção lógica, com a modificação da flag `ativo`.

### Contrato
- Contratos só podem ser múltiplos de 90 dias (entre 90 e 810 dias).
- Apenas um contrato ativo pode existir por cliente e instalação.
- O contrato se torna inativo após o término do período.

### Consumo e Produção
- O consumo deve ser sempre maior que o último valor registrado.
- O consumo mensal é calculado subtraindo o primeiro registro do mês do último.
- O mesmo se aplica à produção de energia.

---

Este projeto tem como objetivo gerenciar e monitorar o consumo e a produção de energia de forma eficiente e sustentável, implementando a geração distribuída através do SunnyMeter, com todas as funcionalidades descritas, implementadas e testadas.
