# Spring_AI_LLM
Spring AI Integration with LLM

--- E:/Spring Projects/Spring AI/Spring_AI_LLM/rep.md
+++ E:/Spring Projects/Spring AI/Spring_AI_LLM/rep.md
@@ -1,1 +1,143 @@
+# Spring_AI_LLM

+Spring AI Integration with LLM
+
+## Project Overview
+
+**Spring AI Integration with LLM** is a demo Spring Boot application that demonstrates integration with Large Language Models (LLMs). The project supports both Ollama and OpenAI models through Spring AI framework.
+
+**Project ID**: `com.ollama:spring.ollama:0.0.1-SNAPSHOT`
+
+## Technical Stack
+
+- **Framework**: Spring Boot 3.5.7
+- **Language**: Java 17
+- **Build Tool**: Maven
+- **AI Framework**: Spring AI 1.0.3
+- **LLM Support**:
+  - Ollama (local models)
+  - OpenAI (API-based)
+
+## Key Dependencies
+
+| Dependency | Purpose |
+|------------|---------|
+| `spring-boot-starter-web` | Web framework for REST APIs |
+| `spring-ai-starter-model-ollama` | Ollama LLM integration |
+| `spring-ai-starter-model-openai` | OpenAI LLM integration |
+| `spring-boot-devtools` | Development tools (hot reload) |
+| `spring-boot-starter-test` | Testing framework |
+
+## Project Structure
+
+```
+Spring_AI_LLM/
+├── src/
+│   ├── main/
+│   │   ├── java/
+│   │   │   └── com/ollama/spring/ollama/
+│   │   │       ├── Application.java          # Main entry point
+│   │   │       └── Controller/
+│   │   │           └── ChatController.java   # Chat API endpoints
+│   │   └── resources/
+│   │       ├── application.properties        # Configuration
+│   │       ├── static/                       # Static resources
+│   │       └── templates/                    # View templates
+│   └── test/
+│       └── java/com/ollama/spring/ollama/
+├── pom.xml                                   # Maven configuration
+├── mvnw, mvnw.cmd                           # Maven wrapper scripts
+└── README.md                                 # Project README
+```
+
+## Main Components
+
+### 1. **Application.java**
+- Main Spring Boot application entry point
+- Excludes OpenAI auto-configuration (Ollama is the primary model)
+- Starts the Spring Application context
+
+### 2. **ChatController.java**
+- REST controller for chat operations
+- **Endpoint**: `GET /chat`
+- **Parameters**:
+  - `q` (String) - User query/prompt
     +- **Response**:
+  - HTTP 200 with AI-generated response content
     +- Uses Spring AI's `ChatClient` for LLM communication
     +- Includes logging via Log4j
+
+## Configuration
+
+### Application Properties (`application.properties`)
+
+| Property | Description | Default/Variable |
+|----------|-------------|-------------------|
+| `spring.application.name` | Application identifier | `spring.ollama` |
+| `spring.port` | Server port | `${PORT}` |
+| `spring.ai.ollama.base-url` | Ollama server URL | `${localhost:port}` |
+| `spring.ai.ollama.chat.options.model` | Default model | `${codellama:latest}` |
+| `spring.ai.ollama.chat.options.temperature` | Response creativity (0-1) | `0.7` |
+| `spring.ai.openai.api-key` | OpenAI API key | `${OPENAI_API_KEY}` |
+| `spring.ai.openai.speech.api-key` | OpenAI speech API key | `${OPENAI_API_KEY}` |
+
+## Getting Started
+
+### Prerequisites
+- Java 17+
+- Maven 3.6+
+- Ollama running locally (for Ollama models) or OpenAI API key
+
+### Build
+```bash
+mvn clean package
+```
+
+### Run
+```bash
+./mvnw spring-boot:run
+```
+
+### Test API
+```bash
+curl "http://localhost:8080/chat?q=Hello%20World"
+```
+
+## API Endpoints
+
+### Chat Endpoint
+- **Method**: `GET`
+- **Path**: `/chat`
+- **Query Parameters**:
+  - `q` (required): The user's query/prompt
     +- **Response**: Plain text response from the LLM
     +- **Example**:
+  ```
+  GET /chat?q=What%20is%20Spring%20AI%3F
+  ```
+
+## Environment Variables
+
+- `PORT` - Server port (default: 8080)
+- `OPENAI_API_KEY` - OpenAI API authentication key
+- Model configuration variables in `application.properties`
+
+## Features
+
+- ✅ REST API for chat interactions with LLMs
+- ✅ Support for multiple AI models (Ollama, OpenAI)
+- ✅ Configurable model options (temperature, model selection)
+- ✅ Spring Boot auto-configuration for AI components
+- ✅ Logging with Log4j2
+
+## Development
+
+- **IDE**: IntelliJ IDEA recommended
+- **Testing**: JUnit 5 (via Spring Boot Test)
+- **Hot Reload**: DevTools included for development convenience
+
+## Notes
+
+- OpenAI auto-configuration is excluded; Ollama is the primary model
+- Temperature is set to 0.7 (balanced between deterministic and creative responses)
+- Requires environment variable configuration for OpenAI integration