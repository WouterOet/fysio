# Fysio

A demo project for a question tree/graph for the purpose of faster processing of patients.

A question has the following properties:
- id, an unique identifier
- content, the actual question to the patient
- answers, the answers to the question

An answer has the following properties:
- id, an unique identifier
- content, the actual answer to the question
- next, an optional next question

The project only has 2 endpoints:
- One for the initial request
- One for responding to answers to questions

Thus you could look into:
- Changing to using HTTP POST instead of GET
- Storing a list of given answers
- A good data-structure
- Not responding the "next" question with an answer
- Having some business logic