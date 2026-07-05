# InvestMind Journal

InvestMind Journal is an AI-assisted investment journal and second opinion REST API built with Spring Boot.

The application allows users to record investment decisions and receive a structured second opinion before investing. It analyzes the submitted decision and returns a score, strengths, missing considerations, follow-up questions, and a short summary.

## Project Purpose

This project was created for the AI-Assisted Development exam. The goal was to build a small software system with the help of an AI development assistant and document the development process, architecture, testing, and challenges.

## Features

- Create a new investment decision
- Generate a second opinion with decision score
- Return strengths, missing considerations, questions, and summary
- Store investment decisions in an H2 database
- List all saved investment decisions
- Get a single investment decision by ID
- Update an existing investment decision
- Recalculate the decision score after update
- Delete an investment decision
- Return 404 Not Found for missing records
- Return 204 No Content after successful delete
- Manual API testing with IntelliJ HTTP Client

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Jakarta Validation
- Lombok
- Maven
- IntelliJ IDEA HTTP Client
- Git and GitHub

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/opinion` | Create a new investment decision and return a second opinion |
| GET | `/api/opinion` | Get all saved investment decisions |
| GET | `/api/opinion/{id}` | Get one investment decision by ID |
| PUT | `/api/opinion/{id}` | Update an existing investment decision |
| DELETE | `/api/opinion/{id}` | Delete an investment decision |

## Example Request

```http
POST http://localhost:8080/api/opinion
Content-Type: application/json

{
  "assetName": "SECO ETF",
  "assetType": "ETF",
  "amount": 100,
  "currency": "EUR",
  "reason": "I want exposure to the semiconductor sector because I believe demand for chips and AI infrastructure will continue to grow.",
  "riskLevel": "High",
  "investmentHorizon": "5 years",
  "exitPlan": "I will sell if the ETF drops below my risk tolerance or if the sector becomes overvalued."
}