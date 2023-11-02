# `ASYS technical assignment - MDC` README

## Prerequisits

- **(Only for Windows)** Install WSL command. Open PowerShell or Windows Command Prompt in administrator mode, enter `wsl --install command`, then restart your machine.
- Download Docker desktop for your operating system:
  [Docker desktop download](https://www.docker.com/products/docker-desktop/)
- Download and install Java JDK 21, and set JAVA_HOME env variable
- Download and install Maven

## Build/Run

- navigate to `\asys_technical`
- `mvn clean install spring-boot:run`

## Using the application with postman

**Request body should be in json object, Example:**

### CreateCar request example

#### HTTP

`localhost:8080/api/createCar`

#### Body

```JSON
{
    "make": "Audi",
    "model": "A3",
    "mileage": 214354
}
```

Response:

```Text
Succesfully created car:
Audi A3
with VIN: 632a5c05-a62c-450e-8fb8-a5f687645ff0
and mileage: 214354
created at: 2023-11-02T22:22:11.862591+01:00
```

- Using the VIN number generated, other requests are able to be made:

### Update request example

#### HTTP

`localhost:8080/api/updateCar/632a5c05-a62c-450e-8fb8-a5f687645ff0`

#### Body

```JSON
{
    "make": "Volvo",
    "model": "XC90",
    "mileage": 934412
}
```

Response:

```Text
Succesfully updated car to:
Volvo XC90
```
