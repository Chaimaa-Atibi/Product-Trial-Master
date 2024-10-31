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
