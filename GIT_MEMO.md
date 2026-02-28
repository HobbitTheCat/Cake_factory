# Git Memo V2

## Table des matières

- [En bref, comment nous travaillons](#en-bref-comment-nous-travaillons)
- [Règles de l'équipe](#regles-de-lequipe)
- [Mise à jour de votre branche](#mise-à-jour-de-votre-branche-à-partir-de-main)
- [Commits](#commits)
- [Nommage des branches](#nommage-des-branches)
- [Branches](#passage-dune-branche-à-lautre)
- [Conflits](#conflits)
- [Demande de fusion](#demande-de-fusion)
- [Ce qui ne doit pas figurer dans le `commit`](#ce-qui-ne-doit-pas-figurer-dans-le-commit)


## En bref, comment nous travaillons
1. Avant de commencer [voir Mise à jour de votre branche](#mise-à-jour-de-votre-branche-à-partir-de-main)
	- `git switch main` ← passer à main
	- `git pull --rebase` ← récupérer les modifications
2. Nouvelle tâche - nouvelle branche [voir Branches](#passage-dune-branche-à-lautre)
	- `git switch -c feature/login-form` ← création d'une nouvelle branche et passage à celle-ci
3. Nous apportons des modifications →  `commit` par petites portions [voir Commits](#commits)
	- `git status`
	- `git add <files>`
	- `git commit -m "feature/login-form: Ajouté le marquage du formulaire d'entrée"`
	- `git push -u origin feature/login-form`
4. Mettre à jour sa branche si `main` a pris de l'avance ou avant la demande de fusion  [voir Mise à jour de la branche](#mise-à-jour-de-votre-branche-à-partir-de-main)
	- `git switch main && git pull --rebase`
	- `git switch feature/login-form`
	- `git rebase main`
	- En cas de [conflits](#conflits), corrigez les fichiers, puis : `git add .` → `git rebase --continue`
5. Merge uniquement via Merge Request [voir Merge Request](#demande-de-fusion)
	- Avant Merge Request, mettez à jour votre branche 


## Regles de l'equipe

1. `main` protégé : modification uniquement via Merge Request
2. Une tâche - une branche - un Merge Request
3. D'abord `pull`, puis travailler. **Nous commençons chaque jour par** `git pull --rebase` dans `main`
4. Ne mélangez pas le refactoring et la fonctionnalité/correction dans une seule demande de fusion.
5. Ne `push` pas dans les branches d'autres personnes sans accord préalable.

## Mise à jour de votre branche à partir de `main`
```
git switch main
git pull --rebase
git switch feature/<name>
git rebase main
# en cas de conflits : corriger les fichiers → git add . → git rebase --continue
```
##### Que font les commandes ?
`git switch main` - passer vers `main`
`git pull --rebase` - mise à jour de la branche locale `main` afin qu'elle corresponde à la branche distante
Après cela, notre `main` locale est la plus récente, mais la branche de travail `feature/login-form` n'a pas été mise à jour automatiquement.
`git switch feature/login-form`
`git rebase main`
Ces commandes tirent les commits vers la dernière version de `main`.

Autrement dit, **les deux étapes sont nécessaires** : la première pour que votre `main` soit à jour, la seconde pour que votre branche « rattrape » cette dernière version de `main`.

Cela permettra d'éviter les conflits.

## Commits

### Format du message
`<Nom de la branche> : <En bref, ce qui a été fait>`
#### Exemples :
- `« feature/login-form : ajout du balisage du formulaire de connexion »`
- `« refactor/auth : transfert de la vérification du jeton vers le middleware »`
- `« test/cart : ajout d'un test pour la suppression d'un produit »`

### Règles
- Un commit = une modification logique
- Ne pas faire de `git push -f main` sans raison - cela force l'ajout des modifications ce qui peut compmromettre le projet

### Commandes utiles
`git add <FILES>` # ajoute des fichiers
`git status` # affiche ce qui a été ajouté dans l'add actuel
`git reset` # annule le commit
`git commit -m "<Nom-de-la-branche> : <En bref, ce qui a été fait>"`
`git push -u origin <Nom-de-la-branche> # envoie vers le dépôt distant`

## Nommage des branches
- Branche principale - `main` (protégée, personne ne peut la modifier directement)
- À partir de `main`, nous créons une branche pour la tâche. Espaces → `-`
```
feature/<feature-name> # pour ajouter une fonctionnalité
fix/<bug-desc> # pour corriger un bug
refactor/<scope> # pour refactoriser sans modifier les fonctions
docs/<target> # pour la documentation
chore/<task> # pour les scripts, les configurations, CI
test/<scope> # pour les tests nouveaux/réécrits
```
[voir Branches](#passage-dune-branche-à-lautre)

## Passage d'une branche à l'autre
[voir Nommage des branches](#nommage-des-branches)

`git switch main` # passer à la branche principale
`git switch -c feature/<name>` # créer une nouvelle branche et y passer 
`git branch feature/<name>` # créer une nouvelle branche sans y passer
`git switch feature/<name>` # passer à une branche existante

#### Commandes utiles
`git branch` # affiche la liste des branches locales
`git branch -a` # affiche la liste de toutes les branches
`git branch --show-current` # affiche la branche actuelle

#### Création d'une branche (problème de localisation)
[voir Nommage des branches](#nommage-des-branches)

`git switch -c feature/<name>` # création d'une nouvelle branche et passage à celle-ci
Tant que vous ne l'avez pas poussée, la branche n'existe que localement chez vous. Effectuez le premier push.
`git push -u origin feature/<name>`
- `-u` mémorisera la connexion « branche locale ↔ origin/feature/\<name> » , puis vous pourrez simplement utiliser `git push` / `git pull`

Que fait le partenaire pour voir et passer à la branche
1. Mettre à jour la liste des branches à partir du serveur
`git fetch origin`
2. Passer à la branche en créant une branche locale qui la suit
`git switch --track origin/feature/<name>`
\# ou plus court (git comprendra tout seul après fetch) :
`git switch feature/<name>`

#### Que faire si une branche superflue a été créée ?
1. Si la branche est vide, essayer `git branch -d feature/<name>`
2. Si quelque chose se trouve dans la branche mais que vous devez tout de même la supprimer, essayez `git branch -D feature/<name>`.

### Comment travailler à deux sur une même branche (non recommandé)
- À chaque fois avant de commencer à travailler :
`git pull --rebase`
- Répéter régulièrement `git pull --rebase` afin de récupérer les modifications apportées par votre partenaire.

## Conflits

### Comment réduire les risques de conflits
- Commencez la journée avec `git pull --rebase` dans `main`
- Créez de petites branches avec MR, un bloc logique à la fois
- Ne touchez pas au code des autres sans synchronisation
- Si possible, une personne, une branche

### Comment résoudre un conflit
##### 0. Comprendre l'opération en cours
	git status
Vous verrez : _« You are currently merging/rebasing »_ — ceci est important pour choisir la bonne commande « continuer/revenir en arrière ».
##### 1. Voir ce qui est en conflit
	git status
	git diff --name-only --diff-filter=U # uniquement les fichiers en conflit
##### 2. Ouvrir les fichiers en conflit et comprendre
À l'intérieur, vous verrez des marqueurs :
```
<<<<<<< HEAD # « notre » version (branche actuelle lors de la fusion)...
nos modifications ...
=======...
leurs modifications ...
>>>>>>> feature/other # « leur » version (branche fusionnée)
```
##### 3. Prendre une décision pour chaque conflit
- Conserver le nôtre (`--ours`)
- Conserver le leur (`--theirs`)
- Fusionner manuellement (meilleure option)
##### 4. Marquer le fichier comme résolu
Après les modifications, supprimez `<<<<<<< ======= >>>>>>>`, enregistrez le fichier et :
`git add <file>`
##### 5. Continuer l'opération
`git merge --continue`
`git rebase --continue`
##### 6. Répéter pour tous les conflits
##### 7. Pousser les modifications
- Après **rebase**, l'historique est réécrit, donc `git push --force-with-lease`
**Uniquement si la branche a déjà été poussée. Informez l'équipe afin que personne ne perde son travail**
- Après **merge**, il suffit généralement de `git push`

### Commandes utiles
`git checkout --ours path/to/file` # prendre notre version du fichier
`git checkout --theirs path/to/file` # prendre leur version du fichier
### Comment annuler l'opération si tout ne s'est pas passé comme prévu
`git merge --abort`
`git rebase --abort`


## Demande de fusion

1. Ouvrir une demande de fusion dans GitLab
	- Accédez au référentiel sur GitLab → onglet Demandes de fusion → Nouvelle demande de fusion
	- Sélectionnez :
		- Branche source = `feature/<name>`
		- Branche cible = `main`
2. Remplissez la demande de fusion
	- Titre : en bref, « quoi et où » (`llogin-form : balisage + validation de l'adresse e-mail`)
	- Description
		- Ce qui a été fait
		- Comment vérifier
		- Y a-t-il des risques/particularités
3. Désigner un réviseur (au minimum Semenov Egor)
4. Avant la fusion, mettre à jour la branche [voir Mise à jour de votre branche](#mise-à-jour-de-votre-branche-à-partir-de-main)
5. Attendre l'approbation

### Important à savoir
- Une demande de fusion est toujours liée à une branche
- Si vous ajoutez de nouveaux commits à la même branche, GitLab met automatiquement à jour la MR.
- N'ouvrez pas de nouvelle demande de fusion, utilisez celle qui a déjà été créée

## Ce qui ne doit pas figurer dans le `commit`
```
# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.nar
*.ear
*.zip
*.tar.gz
*.rar

# Files from IDE 
.idea/
```
Après avoir exécuté `git add .`, vérifiez que les fichiers superflus n'ont pas été ajoutés à l'aide de `git status` et, si c'est le cas, exécutez soit `git reset` , soit `git reset <filename>`.



## Comment ce document a été créé (exemple de processus de travail)
```
git switch main # passage à main
git pull --rebase # obtention des dernières modifications
git branch # vérification des branches existantes
git switch -c docs/git-memo # création d'une nouvelle branche et passage à celle-ci
git branch # vérification de la création de la branche et du passage à celle-ci

git add GIT_MEMO.md # ajouté le fichier
git status # vérifié que rien de superflu n'avait été ajouté
git commit -m "docs/git-memo: Ajout de conseils pour travailler avec git" # commit avec le commentaire approprié
git push -u origin docs/git-memo # envoyé les modifications au serveur
```
Dans GitLab, j'ai ouvert une MR, rempli les informations nécessaires et ajouté un réviseur.
La modification a été intégrée dans `main`.
