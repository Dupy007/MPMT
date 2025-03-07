# Project Management Tool 

## Description
MPMT est une plateforme de gestion de projet collaboratif destinée aux équipes de développement logiciel. L'objectif est de créer une application qui permettra aux équipes de planifier, suivre et collaborer sur des projets de manière efficace.

## Prérequis
Assurez-vous d'avoir les outils suivants installés sur votre machine :
- **Docker** (pour la containerisation)
- **Git**

## Installation et Configuration
### 1. Cloner le dépôt
```bash
git clone https://github.com/Dupy007/MPMT.git
cd MPMT
```

### 1. Cloner les dépôts du backend et du frontend
```bash
git clone https://github.com/Dupy007/MPMT-API.git API
git clone https://github.com/Dupy007/MPMT-FRONT.git FRONT
```
### 2. Modifier le port d'ecoute du frontend
```
cp -r ./env.ts ./FRONT/src
```
### 3. Création des conteneurs
```bash
docker-compose up --build -d
```

### 4.
L'application sera accessible sur `http://localhost:44600`.