# 🍰 Cake Factory

**Cake Factory** est un projet de génie logiciel conçu pour démontrer l'application rigoureuse des méthodologies agiles et des principes d'architecture logicielle avancés. L'objectif est de transformer un besoin métier complexe en une solution logicielle évolutive, maintenable et robuste.

---

## 🏗️ Gestion de Projet & Méthodologies Agiles

Le cœur de ce projet réside dans l'application des processus théoriques de gestion de projet. Nous avons adopté le framework **Scrum** pour rythmer notre développement.

### 👥 Rôles et Organisation
* **Product Owner** : Responsable de la vision du produit, de la gestion du *Product Backlog* et de la priorisation des user stories selon la valeur métier.
* **Scrum Master** : Garant du respect des rituels Scrum, facilitateur de l'équipe et responsable de la levée des obstacles techniques ou organisationnels.
* **Équipe de Développement** : Équipe pluridisciplinaire auto-organisée appliquant les standards de qualité technique.

### 🔄 Cycle de Vie (Sprints)
Nous fonctionnons par itérations de 1 semaine, incluant les rituels suivants :
* **Sprint Planning** : Sélection des items du backlog et définition de l'objectif du Sprint.
* **Sprint Review** : Démonstration des incréments logiciels terminés aux parties prenantes.
* **Sprint Retrospective** : Analyse de notre processus interne pour une amélioration continue.

---

## 📐 Architecture & Génie Logiciel

Pour garantir que **Cake Factory** puisse évoluer sans nécessiter de refonte majeure, nous avons appliqué les standards de l'industrie :

### Principes SOLID
Nous respectons les cinq piliers SOLID pour assurer la pérennité du code :
* **S**ingle Responsibility : Chaque classe possède une unique raison de changer.
* **O**pen/Closed : Le système est ouvert à l'extension (ajout de nouvelles recettes/fonctionnalités) mais fermé à la modification.
* **L**iskov Substitution / **I**nterface Segregation : Utilisation judicieuse du polymorphisme et interfaces fines.
* **D**ependency Inversion : Découplage des modules via l'injection de dépendances.

### Design Patterns Appliqués
Le projet implémente plusieurs patrons de conception pour résoudre des problèmes récurrents comme par exemple :
* **Factory / Abstract Factory** : Pour la création dynamique des différents types de gâteaux.
* **Strategy** : Pour isoler les différents modes de cuisson ou de tarification.
* **Observer** : Pour notifier les différents services (stock, livraison) lors de la finalisation d'une commande.
* **Decorator** : Pour l'ajout dynamique de toppings ou d'options sans modifier les classes de base.
* **Build** : Pour simplifier la création final de l'object (DSL).
* **Bridge** : Pour inclure la description des méthodes de la productuion de la tarte.
* **Composite** : Pour créer une hiérarchie.
* **Template** : Pour simplifier l'écriture du code.

Nous avons un total donc 9 Design Pattern pour ce projet.

---

## 📊 Maquette IHM
![Maquette IHM](https://github.com/HobbitTheCat/Cake_factory/blob/main/img/maquette.png)

---

## 🛠️ Qualité Logicielle & Outillage

* **Gestion de version** : Git (Gitlab) avec workflow *Gitflow* (branches `feature/`, `develop`, `main`).
* **Tests** : Approche TDD (Test Driven Development) pour garantir une couverture de tests unitaires et d'intégration maximale.
* **Documentation** : Modélisation UML (Diagrammes de classes, de séquences et de cas d'utilisation) servant de socle avant chaque implémentation, Diagramme de PERT et Diagramme de GANTT.

---

## 👥 L'Équipe
* [Léo Piton](https://github.com/Badoux17) - Scrum Master
* [Egor Semenov](https://github.com/HobbitTheCat) - Product Owner
* [Kelian Texeira De Melo](https://github.com/KelianTDM) - Développeur
* [Enzo Pitoiset](https://github.com/EnzoPit) - Développeur
* [Nicolas Schweblen] - Développeur
* [Louis Ythier] - Développeur

