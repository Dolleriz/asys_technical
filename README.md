# Readme for ASYS technical assignment - MDC

## With docker desktop

### Prerequisits

- **(Only for Windows)** Install WSL command. Open PowerShell or Windows Command Prompt in administrator mode, enter `wsl --install command`, then restart your machine.
- Download Docker desktop for your operating system:
  [Docker desktop download](https://www.docker.com/products/docker-desktop/)
- Download and install Java JDK 21, and set JAVA_HOME env variable
- Download and install Maven

### Build/Run

- navigate to `\asys_technical`
- `mvn clean install spring-boot:run`
