
## Microservicio

El microservicio implementa varios patrones de diseño/arquitectura:

Arquitectura RESTful: define endpoints que representan recursos (/api/bancos), aplicando las operaciones CRUD con los verbos HTTP (GET, POST, PUT, DELETE).

Repository Pattern: EntidadBancariaRepository encapsula el acceso a la base de datos. En lugar de que el controller acceda directo a la DB, lo hace a través del repositorio.

Service Layer Pattern → BancoService centraliza la lógica de negocio, separando responsabilidades del controller y del acceso a datos.

Dependency Injection (IoC) → Spring inyecta dependencias (BancoRepository, WebClient) en los componentes, reduciendo el acoplamiento.

Cliente HTTP interno → el endpoint /self-client/{id} aplica el patrón Client-side HTTP Request (similar a un proxy o API client) para consumir otro endpoint del mismo servicio.

## Tecnologia Utilizadas
- Java 17
- Maven
- Docker
- Kubernetes (kubectl)

## API Endpoints
GET /api/bancos/listar: Obtener todos los bancos.

GET /api/bancos/obtener/{id}: Obtener un banco por ID.

POST /api/bancos/registrar: Crear un nuevo banco.

PUT /api/bancos/actualizar/{id}: Actualizar un banco por ID.

DELETE /api/bancos/eliminar/{id}: Eliminar un banco por ID.

GET /api/cliente/self/{id}: endpoint usado como un cliente interno de sí mismo,
Llama al endpoint de (/api/bancos/obtener/{id})
pero a través de un cliente WebClient.

## Swagger
http://localhost:8080/swagger-ui/index.html#/

## Postman
api-docs-EntidadBancaria.json

### Build the Application
1. Clone the repository:
   git clone <repository-url>  

2. Build the project using Maven:

   mvn clean Package

### Docker Configuration
    Herramienta: Docker Desktop 4.47 
1. Build the Docker image:
   docker build -t entidades-bancarias-api .

   Kubernetes:
3. sh build-push.sh “rutaimagenque se encuentra en el ymal deployment”

2. Run the Docker container:
   docker run -p 8080:8080 entidades-bancarias-api

### Kubernetes Configuration
1. Deploy the application to Kubernetes:
   ```
   kubectl apply -f deployment.yaml
   kubectl apply -f service.yaml

### Se Crea el Diploymet y el servicio

Kubectl créate -f “nombreproyec”.service.ymal
Kubectl create -f “nombreproyec”.deployment.ymal

Para borrar el servicio o diployment
kubectl delete -f “nombreproyec”-service.ymal
kubectl delete -f “nombreproyec”-deployment.ymal