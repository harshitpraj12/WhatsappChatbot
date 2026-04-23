# WhatsApp Chatbot Backend Simulation

This project is a minimal Spring Boot backend application that simulates a webhook endpoint for a WhatsApp chatbot. It listens for incoming POST requests containing JSON message payloads, processes them based on predefined rules, and responds accordingly.

## Features

- **RESTful Webhook Endpoint**: Exposes a `POST /webhook` endpoint to receive messages.
- **Predefined Responses**: Responds intelligently based on the content of the message:
  - `"Hi"` -> `"Hello"`
  - `"Bye"` -> `"Goodbye"`
  - Any other message -> `"I'm sorry, I only understand 'Hi' and 'Bye'."`
- **Structured Logging**: Uses SLF4J to log the incoming sender and message body for tracking and debugging.
- **Java 17 & Spring Boot 3**: Built using modern Java practices and the latest stable Spring Boot 3.2.x features.

## Tech Stack

- **Java**: 17
- **Framework**: Spring Boot 3.2.4
- **Build Tool**: Maven

## Getting Started

### Prerequisites
- JDK 17 or higher
- Maven 3.6+

### Building the Project
To build the project and create an executable JAR file, run the following command in the root directory:

```bash
mvn clean install
```

### Running the Application
You can run the application directly using Maven:

```bash
mvn spring-boot:run
```
Alternatively, you can run the JAR file after building it:
```bash
java -jar target/whatsapp-bot-0.0.1-SNAPSHOT.jar
```
By default, the application will start on `http://localhost:8080`.

## API Documentation

### Webhook Endpoint

**URL**: `/webhook`
**Method**: `POST`
**Content-Type**: `application/json`

#### Request Payload
The endpoint expects a JSON payload containing the `sender` and the `messageBody`:

```json
{
  "sender": "+1234567890",
  "messageBody": "Hi"
}
```

#### Example Usage using `cURL`

```bash
curl -X POST http://localhost:8080/webhook \
     -H "Content-Type: application/json" \
     -d '{"sender":"+1234567890", "messageBody":"Hi"}'
```

#### Responses

- **If `messageBody` is `"Hi"`**:
  - Response: `Hello` (Status: 200 OK)
- **If `messageBody` is `"Bye"`**:
  - Response: `Goodbye` (Status: 200 OK)
- **For any other `messageBody`**:
  - Response: `I'm sorry, I only understand 'Hi' and 'Bye'.` (Status: 200 OK)

## Project Structure

- `WhatsAppMessage.java`: The POJO model representing the structure of the incoming JSON payload.
- `WebhookController.java`: The REST controller that defines the `/webhook` POST mapping, handles incoming requests, logs the data, and returns the appropriate string response.
- `WhatsappBotApplication.java`: The main entry point to start the Spring Boot application.
