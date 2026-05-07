# AI Health Assistant 🏥

> AI-powered health assistant with EHR integration, FHIR API, LangChain4j RAG chatbot, Spring Boot backend and React frontend

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-green.svg)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-18.2.0-blue.svg)](https://react.dev/)
[![MongoDB](https://img.shields.io/badge/MongoDB-Latest-brightgreen.svg)](https://www.mongodb.com/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-blue.svg)](https://www.docker.com/)

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Running the Application](#-running-the-application)
- [API Documentation](#-api-documentation)
- [Project Structure](#-project-structure)
- [Contributing](#-contributing)

## ✨ Features

- 🤖 **AI-Powered Chat**: Health assistant chatbot using LangChain4j and OpenAI GPT-4
- 🏥 **EHR Integration**: FHIR R4 compliant integration with Electronic Health Records
- 📊 **Patient Management**: Complete user profile and health data management
- 📅 **Appointment Scheduling**: Book and manage healthcare appointments
- 🔒 **Secure Authentication**: JWT-based authentication and authorization
- 🐳 **Docker Support**: Fully containerized with Docker Compose
- 💾 **MongoDB Database**: NoSQL database for flexible data storage
- 🎨 **Modern UI**: React-based responsive frontend

## 🛠 Tech Stack

### Backend
- **Java 17** - Programming language
- **Spring Boot 3.2.5** - Application framework
- **Spring Security** - Authentication & Authorization
- **Spring Data MongoDB** - Database integration
- **LangChain4j** - AI/RAG framework
- **HAPI FHIR** - EHR integration
- **JWT** - Token-based authentication
- **Maven** - Build tool

### Frontend
- **React 18.2** - UI framework
- **Axios** - HTTP client
- **React Router** - Navigation

### DevOps
- **Docker & Docker Compose** - Containerization
- **MongoDB** - Database
- **Nginx** - Web server (for frontend)

## 📦 Prerequisites

Before running this project, ensure you have:

- **Java 17+** installed
- **Node.js 18+** and npm
- **Docker** and **Docker Compose**
- **MongoDB** (if running without Docker)
- **OpenAI API Key** (for AI features)

## 🚀 Installation

### 1. Clone the Repository

\`\`\`bash
git clone https://github.com/kratikachaudhary298/ai-health-assistant.git
cd ai-health-assistant
\`\`\`

### 2. Set Up Environment Variables

Create a \`.env\` file in the root directory:

\`\`\`bash
OPENAI_API_KEY=your-openai-api-key-here
\`\`\`

## ⚙️ Configuration

### Backend Configuration

Edit \`backend/src/main/resources/application.properties\`:

\`\`\`properties
# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/aihealth

# OpenAI API
app.openai.api-key=${OPENAI_API_KEY}
app.openai.model=gpt-4o

# JWT
app.jwt.secret=your-super-secret-jwt-key-change-this-in-production

# FHIR Server (optional - uses public HAPI server by default)
app.fhir.server-url=http://hapi.fhir.org/baseR4
\`\`\`

### Frontend Configuration

The frontend connects to \`http://localhost:8080\` by default. To change this, edit \`frontend/src/App.js\`.

## 🏃 Running the Application

### Option 1: Using Docker Compose (Recommended)

\`\`\`bash
# Build and run all services
docker-compose up --build

# Run in detached mode
docker-compose up -d

# Stop all services
docker-compose down
\`\`\`

**Access:**
- Frontend: http://localhost:3000
- Backend API: http://localhost:8080
- MongoDB: mongodb://localhost:27017

### Option 2: Running Locally

#### Start Backend

\`\`\`bash
cd backend
mvn clean install
mvn spring-boot:run
\`\`\`

#### Start Frontend

\`\`\`bash
cd frontend
npm install
npm start
\`\`\`

#### Start MongoDB

\`\`\`bash
# Using Docker
docker run -d -p 27017:27017 --name aihealth-mongo mongo:latest

# OR install MongoDB locally
\`\`\`

## 📚 API Documentation

### Authentication

#### Register User
\`\`\`http
POST /api/auth/register
Content-Type: application/json

{
  "email": "patient@example.com",
  "password": "SecurePass123",
  "firstName": "John",
  "lastName": "Doe"
}
\`\`\`

#### Login
\`\`\`http
POST /api/auth/login
Content-Type: application/json

{
  "email": "patient@example.com",
  "password": "SecurePass123"
}
\`\`\`

### AI Chat

#### Ask Health Question
\`\`\`http
POST /api/health/chat
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "message": "What are the symptoms of flu?"
}
\`\`\`

### Appointments

#### Book Appointment
\`\`\`http
POST /api/appointments
Authorization: Bearer {jwt_token}
Content-Type: application/json

{
  "doctorName": "Dr. Smith",
  "specialty": "General Physician",
  "appointmentDateTime": "2026-05-10T10:00:00",
  "reason": "Annual checkup"
}
\`\`\`

## 📁 Project Structure

\`\`\`
ai-health-assistant/
├── backend/
│   ├── src/main/java/com/aihealth/
│   │   ├── AiHealthAssistantApplication.java
│   │   ├── model/
│   │   │   ├── User.java
│   │   │   └── Appointment.java
│   │   ├── repository/
│   │   │   └── UserRepository.java
│   │   ├── service/
│   │   │   └── AiChatService.java
│   │   └── controller/
│   ├── src/main/resources/
│   │   └── application.properties
│   ├── Dockerfile
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── App.js
│   │   ├── index.js
│   │   └── components/
│   ├── public/
│   ├── Dockerfile
│   └── package.json
├── docker-compose.yml
└── README.md
\`\`\`

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (\`git checkout -b feature/AmazingFeature\`)
3. Commit your changes (\`git commit -m 'Add AmazingFeature'\`)
4. Push to the branch (\`git push origin feature/AmazingFeature\`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the MIT License.

## 👩‍💻 Author

**Kratika Chaudhary**
- GitHub: [@kratikachaudhary298](https://github.com/kratikachaudhary298)

## 🙏 Acknowledgments

- Spring Boot for the excellent framework
- LangChain4j for AI integration
- HAPI FHIR for healthcare standards
- OpenAI for powerful language models
- React community for frontend tools

---

⭐ If you find this project helpful, please give it a star!
