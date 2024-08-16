# Project Management Tool (Backend)

## Description
Ce projet représente le backend de la plateforme **Project Management Tool (PMT)**. Il a été développé avec **Spring Boot** et gère les fonctionnalités principales telles que l'authentification des utilisateurs, la gestion des projets et des tâches.

## Prérequis
Assurez-vous d'avoir les outils suivants installés sur votre machine :
- **Java 11** ou une version supérieure
- **Maven 3.6+**
- **Docker** (pour la containerisation)
- **PostgreSQL** (ou MySQL, selon votre configuration)
- **Git**

## Installation et Configuration
### 1. Cloner le dépôt
```bash
git clone https://github.com/votre-utilisateur/pmt-backend.git
cd pmt-backend
```

### 2. Configurer la base de données
Assurez-vous que votre base de données PostgreSQL ou MySQL est en cours d'exécution. Créez une base de données nommée `pmt_db`.

Modifiez le fichier `src/main/resources/application.properties` ou `application.yml` pour y ajouter vos configurations de base de données :
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/pmt_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Construire et lancer l'application
```bash
mvn clean install
mvn spring-boot:run
```

L'application sera accessible sur `http://localhost:8080`.

## Dockerisation
### 1. Construire l'image Docker
```bash
docker build -t pmt-backend:latest .
```

### 2. Exécuter l'application via Docker
```bash
docker run -d -p 8080:8080 --name pmt-backend pmt-backend:latest
```

## Tests
Des tests unitaires et d'intégration sont disponibles dans le dossier `src/test/java`. Pour exécuter les tests :
```bash
mvn test
```

## CI/CD
Ce projet est configuré pour utiliser **GitHub Actions**.

## Contribution
Les contributions sont les bienvenues ! Ouvrez une issue ou une pull request pour suggérer des améliorations ou rapporter des bugs.

## Licence
Ce projet est sous licence MIT.
