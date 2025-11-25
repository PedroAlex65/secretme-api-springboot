☕ SecretMe API RESTful (Backend)

 Visão Geral e Objetivo

Este repositório contém o serviço de Back-end para a aplicação SecretMe, implementado em Java com Spring Boot. O projeto representa a **migração e modernização** de uma arquitetura legada (Node.js) para o ecossistema Java, demonstrando proficiência em **serviços RESTful desacoplados**.

Esta API é responsável por gerenciar a **geração de tokens de autorização** e a **persistência de mensagens anônimas**.

---

🏛️ Arquitetura e Estrutura

O projeto adota a Arquitetura em Camadas (Controller/Service/Repository) e utiliza o princípio de Inversão de Controle (IoC) para baixo acoplamento.

| Camada | Tecnologia | Responsabilidade Principal |
| :--- | :--- | :--- |
| **Controller** | `@RestController` | Roteamento HTTP, consumo de DTOs e validação de requisições. |
| **Service** | `@Service` | **Regra de Negócio** (Geração de `secretToken` usando `UUID` e lógica de autorização). |
| **Repository** | `Spring Data JPA` | Abstração da persistência ORM para as Entidades. |
| **Persistência** | `@Entity` / PostgreSQL | Mapeamento e gerenciamento do schema (`Usuario`, `Mensagem`). |

---

✨ Destaques Técnicos

O desenvolvimento deste projeto validou os seguintes desafios de nível de produção:

1.  **Resolução de CORS em Produção:** Configuração do `@CrossOrigin` para permitir o domínio público do Front-end (Vercel/Netlify), resolvendo falhas de *preflight* em ambientes Full-Stack.
2.  **Mecanismos de Autorização:** Implementação do `secretToken` (gerado por `UUID`) como chave de acesso para identificar e autorizar o dono do link.
3.  **Persistência Robusta:** Utilização do `spring.jpa.hibernate.ddl-auto=none` em produção, assumindo um **schema** estável no PostgreSQL.
4.  **Mapeamento ORM:** Gerenciamento do relacionamento **`@ManyToOne`** entre `Mensagem` e `Usuario` para rastreamento de destinatários.

---

🔗 Endpoints da API REST

A API utiliza a URL base: `https://secretme-api-springboot.onrender.com`

| Método | Recurso | Descrição |
| :--- | :--- | :--- |
| **`POST`** | `/usuario` | Cria um novo usuário e retorna o `secretToken` exclusivo. (Requer DTO: `nick`) |
| **`POST`** | `/api/mensagens?token={token}` | Envio anônimo de mensagem. O token identifica o destinatário. |
| **`GET`** | `/api/mensagens/recebidas?token={token}` | Retorna todas as mensagens recebidas pelo dono do link. (Requer autorização via token). |

---

⚙️ Deploy e Execução

O Back-end está hospedado no Render.

1.  **Build System:** Maven (com *skip tests* no *build*).
2.  **Containerização:** Imagem final leve baseada em OpenJDK JRE.
3.  **Conexão DB:** Variáveis de ambiente injetadas pelo Render (`DATABASE_URL`, `DATABASE_USER`, etc.).
