# Enterprise Java Bean

## 📌 What is EJB?
EJB = A server-side component for enterprise-level business logic

Works only inside Application Server (ex: JBoss, WebLogic, GlassFish)

✔ Scalability
✔ Security
✔ Transaction Management
✔ Distributed Apps (RMI over IIOP)

## Types of EJB (3 Main Types — Important!)
| Type                                                   | Purpose                         | Example Use     |
| ------------------------------------------------------ | ------------------------------- | --------------- |
| **1️⃣ Session Bean**                                   | Perform business logic          | Payment, Login  |
| **2️⃣ Message Driven Bean (MDB)**                      | Asynchronous message processing | Kafka, JMS      |
| **3️⃣ Entity Bean** ❌ *(Deprecated — replaced by JPA)* | Used to store data              | Old persistence |

## Session Beans — 3 Types
| Type      | Lifetime                | Used for        |
| --------- | ----------------------- | --------------- |
| Stateless | No client-specific data | Login, OTP send |
| Stateful  | Stores client state     | Shopping cart   |
| Singleton | Single instance for app | Caching, Config |

## EJB Annotations (Most Important)
| Annotation      | Use                     |
| --------------- | ----------------------- |
| `@Stateless`    | Stateless Session Bean  |
| `@Stateful`     | Stateful Session Bean   |
| `@Singleton`    | Singleton Bean          |
| `@EJB`          | Inject another EJB      |
| `@Schedule`     | Timer service           |
| `@Asynchronous` | Run parallel processing |
