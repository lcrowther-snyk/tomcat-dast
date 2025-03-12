# Tomcat DAST Demo

## Purpose

The purpose of this project is to demonstrate a Dynamic Application Security Testing (DAST) scenario where the code has no Static Application Security Testing (SAST) issues. However, due to a configuration in Tomcat, the `JSESSIONID` is fixed and in clear text, allowing an attacker to perform a man-in-the-middle attack and spoof a session.

## Project Overview

This project is a simple Spring Boot application with the following features:
- A login form for users to enter their username and password.
- An in-memory database to store user credentials.
- Session management to restrict access to an admin page.

## Configuration

The Tomcat configuration is set up in such a way that the `JSESSIONID` is fixed and transmitted in clear text. This configuration is intentionally insecure to demonstrate the potential for a man-in-the-middle attack.

## Running the Application

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd tomcat-dast
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

4. Access the application at `http://localhost:8081`.

## Demonstration

1. Open the application in a web browser and navigate to the login page.
2. Enter the username and password (default credentials are `user` and `password`).
3. Upon successful login, you will be redirected to the admin page.
4. Observe the `JSESSIONID` in the browser's cookies. Note that it is fixed and in clear text.
5. Use a tool like Wireshark to capture the network traffic and demonstrate how an attacker can intercept the `JSESSIONID` and spoof the session.

## Security Implications

This project highlights the importance of secure session management and the risks associated with transmitting session identifiers in clear text. It demonstrates how an attacker can exploit insecure configurations to perform man-in-the-middle attacks and gain unauthorized access to sensitive information.

## Disclaimer

This project is for educational purposes only. Do not use this insecure configuration in a production environment.