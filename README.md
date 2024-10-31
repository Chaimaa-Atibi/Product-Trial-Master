# Product Trial Master
Ce projet consiste en le développement d’un back-end pour la gestion de produits en utilisant Java/Spring Boot.

# Description
Le back-end permet de gérer des produits avec plusieurs endpoints d'API pour la création, la récupération, la mise à jour et la suppression de produits.

# API Endpoints

| Resource           | POST                  | GET                            | PATCH                                    | PUT | DELETE           |
| ------------------ | --------------------- | ------------------------------ | ---------------------------------------- | --- | ---------------- |
| **/products**      | Create a new product  | Retrieve all products          | X                                        | X   |     X            |
| **/products/:id**  | X                     | Retrieve details for product 1 | Update details of product 1 if it exists | X   | Remove product 1 |

# Structure du Produit
Un produit contient les attributs suivants :

``` typescript
class Product {
  id: number;
  code: string;
  name: string;
  description: string;
  image: string;
  category: string;
  price: number;
  quantity: number;
  internalReference: string;
  shellId: number;
  inventoryStatus: "INSTOCK" | "LOWSTOCK" | "OUTOFSTOCK";
  rating: number;
  createdAt: number;
  updatedAt: number;
}
```
# Prérequis
- Java 8
- Maven
- Spring Boot
- MySQL
- JUnit

# Installation de MySQL
1. Vérifiez si MySQL est installé sur votre machine :

- Ouvrez votre terminal (ou invite de commandes) et exécutez : mysql --version
- Si MySQL n'est pas installé, téléchargez et installez-le depuis le site officiel de MySQL.

2. Lancez MySQL Workbench et connectez-vous à votre instance MySQL.

# Création de la base de données
Dans MySQL Workbench, exécutez la commande suivante pour créer la base de données : CREATE DATABASE product_trial_master;

# Installation
- Clonez le dépôt :
git clone https://github.com/Chaimaa-Atibi/Product-Trial-Master.git

- Naviguez dans le répertoire du projet :
cd product_trial_master

- Compilez le projet :
mvn clean install

# Exécution
Pour lancer l'application, exécutez la classe ProductManagementApplication en tant qu'application Java. Dans votre IDE Eclipse :

- Localisez la classe ProductManagementApplication dans le package com.product.trial.master.
- Clic droit sur la classe et sélectionnez "Run as Java Application".

# Tests JUnit
Exécutez la commande suivante pour lancer les tests JUnit : mvn test

# Exécution des Tests dans l'IDE
Vous pouvez également exécuter les tests directement depuis votre IDE Eclipse :

- Localisez le classes de test dans le répertoire src/test/java : ProductControllerTest.
- Clic droit sur la classe de test ou la méthode de test et sélectionnez "Run as JUnit Test".

# Exemple de Requêtes API
Créer un produit: 

POST /products
{
    "code": "P001",
    "name": "Produit 1",
    "description": "Description du produit 1",
    "image": "url_image",
    "category": "Catégorie A",
    "price": 100.0,
    "quantity": 10,
    "internalReference": "INT001",
    "shellId": 1,
    "inventoryStatus": "INSTOCK",
    "rating": 4.5,
    "createdAt": 1634089287000,
    "updatedAt": 1634089287000
}
