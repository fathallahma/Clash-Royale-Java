# l2s4-projet-2021 - Groupe 3


# Equipe

- Elias   Frik
- Mohamed-Amine Fathallah
- Mohamed Cherchour
- Ameyes Cherigui

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1

### Atteinte des objectifs

On a crée un UML qui illustre les classes Soldat et ouvrier, les deux personnages des deux jeux , qu'ils éritent de la classe mére (Personnage.java), on a débuté le code , et aussi on a crée dans l UML des classes qu'on va les utiliser prochainement comme outils .

### Difficultés restant à résoudre

les Difficultés qu'on a trouvé c'est comment lier entre la classe Personnage et les deux classes qui éritent d'elle (partie d'heritage du POO)

## Livrable 2

### Atteinte des objectifs

On a crée un UML qui illustre les classes du plateau , les differents types de cellules, qu'ils éritent de la classe mére (Cell.java), on a avancé dans le code  .

### Difficultés restant à résoudre

on a trouvé des Difficultés dans le constructeur de la classe du plateau , on a pas arrivé a mettre la deuxieme condition du plateau ( soit chaque case avoir une case voisine de méme type) , aussi on sait pas si il faut faire de l'heritage dans la production des ressources juste les conciderer comme des String .

## Livrable 3


### Atteinte des objectifs
On a reussi a modeliser les actions a l'aide d'une interface action qui implemente
plusieurs classes qui representent les actions a effectués.On a ajouté dans l'uml
cette interface et pour l'instant la modelisation est coherente.

### Difficultés restant à résoudre
Cependant plusieurs choses restent a redefinir notamment dans la gestion du code
ou certaines methodes sont plus ou moins complexe a realisés. Apres avoir vu avec
le professeur  notre classe Player.java doit etre retravaillé.

## Livrable 4

### Atteinte des objectifs
Action presque terminé la plupart des details ajoutes il ne reste plus qu'a finir la classe game et de faire le main et de tester si le jeu fonctionne correctement. Certaines autres choses restent a etre ajoutés dans certaines classes.

### Difficultés restant à résoudre
Faire le Game en respectant toutes les consignes du jeux.

# Journal de bord

## Semaine 1
Nous avons relu plusieurs fois le sujet afin de mieux assimiler les connaissances qui vont être mis en évidence, on a commencer à modéliser l'ensemble du projet (package, classes). Pour la semaine prochaine, nous devons modéliser sous forme d'un diagramme UML la classe des personnages.
## Semaine 2
nous avons corrigé les erreurs commit l'hors de la construction de l'UML
## Semaine 3
nous somme toujours dans le developpement des calsses des personnages
## Semaine 4
nous allons finir les personnages , et l'UML du plateau, et on vas faire le code du plateau
## Semaine 5
cette semaine ,nous avons commencé à faire les test, puisqu'on a deja avancé dans le code
## Semaine 6
On a reglé les packages dans notre projet , toujours nous sommes en train d'avoir une solution pour compléter la classe du plateau , on a ajouté les ressources .

## Semaine 7
ON a commencé a reflechir a la structure pour mettre en place les actions et on a debuté l'uml.

## Semaine 8
On a terminé l'Uml et on a commencé a mettre en place le code mais on est pas sur de certaines fonctions dans l'Uml.

## Semaine 9
Apres avoir vu avec le professeur nous avons mis en place l'interface action qui implementes les classes  correspondant aux actions.Nous devons retravaille la classe player.Nous avons a coder chacun une classe qui represente une actions.

## Semaine 10

Retour sur certaines classes pour ajouter deds details et action presque finis.

## Semaine 11

On a repris certaines classes et modifies et on a commencés a reflechir a la classe Game.


## Semaine 12
Derniere mise en place termine le projet fonctionne bien.Mise en place du jar.

# ----------------------------------------------------------------------------------------

# Introduction

Nous vous proposons ici la modélisation d’un jeu. Cette modélisation  implémante différents jeux. Les
jeux ont une base commune mais les règles, les types de personnages, la composition du terrain du jeu pourrait varier.
L’objectif est d’obtenir une modélisation qui permette à un développeur de créer un nouveau jeu en se servant de
ce qui est déjà réalisé ou en ajoutant réguliérement des classes pour s’adapter simplement aux spécificités de son jeu.
Il y a un jeu qui gére des ouvriers dans un plateaux avec plusieurs actions à réaliser.
Et l'autre jeu qui est similaire à celui ci qui gère des soldats et des armées avec pour but d'acquérir le maximum de territoire.
* nous avons ajouté une fonctionnalitée qui permet à deux utilisateurs de jouer un contre l'autre sur une meme machine.


### récupération des données

Pour récupérer les données du projet, suivez les étapes suivantes :

* Si vous avez déjà une version locale du dépôt Git :
    * il vous suffit d'exécuter la commande shell suivante :
        ``` bash
        $ git pull
        ```
    Vous aurez ensuite accès à tous les fichiers du Projet, et vous pourrez l'ouvrir dans
    un éditeur de texte.


* Si vous n'avez pas encore de version locale du dépôt :
    * Exécutez la commande suivante pour créer une version locale du dépôt dans votre ordinateur :
        ```bash
        $ git clone https://gitlab-etu.fil.univ-lille1.fr/fathallah/l2s4-projet-2021.git
        ```

* Si vous préférez utiliser votre clé SSH (si elle est configurée sur votre compte (git@gitlab-etu.fil.univ-lille1.fr:fathallah/l2s4-projet-2021.git) :
    ```bash
    $ git clone git@gitlab-etu.fil.univ-lille1.fr:fathallah/l2s4-projet-2021.git
    ```
      Vous aurez de cette manière accès aux différents fichiers du projet. Pour mettre à jour ces fichiers, utilisez la commande précisée ci-dessus .


### Generation de la documentation

* Pour gener la documentation,Placez-vous dans le dossier l2s4-projet-2021/src
et passez la commande suivante :
	 ```bash
	 $ javadoc -d ../docs -subpackages game
	 ```

* Pour la consulter, ouvrez le fichier index.html qui se trouve dans le dossier docs.



### Compilation des sources du projet (à faire en premier)


* Pour compiler les sources du projet, placez-vous a la racine du projet et  mettez vous dans le dossier src et passez la commande suivante:
    ```bash
    $ javac Main/*.java -d ../classes
    ```
* pour compiler la classe Armee seule, si vous voulez l'utiliser pour compilier son test(ArmeeTest),passez la commande suivante:
    ```bash
    $ javac game/personnage/*.java -d ../classes
    ```


### Compilation et execution des test


* Pour compiler une classe de test, placez-vous dans la raçine du projet
              et éxécutez la commande suivante:
    ```bash
    $ javac -classpath test-1.7.jar test/NomDeLaClasseDeTest.java
    ```

* exemple: Pour compiler la classe DesertCellTest ,éxécutez la commande :
    ```bash
    $ javac -classpath test-1.7.jar test/DesertCellTest.java
    ```

* Pour executer une classe de test, placez-vous dans la raçine du projet
              et éxécutez la commande suivante:
    ```bash
    $ java -jar test-1.7.jar NomDeLaClasseDeTest
    ```

*  exemple: Pour executer la classe DesertCellTest ,éxécutez la commande :
    ```bash
    $ java -jar test-1.7.jar DesertCellTest
    ```




### Création es fichier d'execution du programme avec le .jar executable
* on se place dans la racine cu fichier et on fait pour le jeu d'ouvrier :
    ```bash
    $ jar cvfm jar/ouvrier.jar jar/manifest-ouvrier src/Main
    ```
* et pour le jeu de guerre :
    ```bash
    $ jar cvfm jar/guerre.jar jar/manifest-guerre src/Main
    ```

* et on a ajouté un main pour jouer soi méme :
    ```bash
    $ jar cvfm jar/interaction.jar jar/manifest-interaction src/Main
    ```


### En utilisant le makeFile
Lancez la commande :
  ```bash
  $ make all
  ```
La commande fait d'abord un clean,puis génére les docs, ensuite génére les fichiers .jar (ouvrier.jar et guerre.jar)


### Execution avec le jar executable
* Nous avons rencontré des problèmes avec la commande qui lance le programme, après l'execution des commandes  en dessous la commande java ne trouve pas les classes "main".
    ```bash
    $ jar -jar jar/guerre.jar
    ```
    ```bash
    $ jar -jar jar/ouvrier.jar
    ```
* donc nous vous conseillons de lancer le programme sans le jar exécutable(lancez les commandes suivantes)

### Execution du jeu d'agricole

* placez vous dans le dossier l2-projet-2021/classes , puis , executez la commande suivante :
    ```bash
    $ java Main.MainOuvrier
    ```

### Execution du jeu de guerre

* placez vous dans le dossier l2-projet-2021/classes , puis , executez la commande suivante :
    ```bash
    $ java Main.MainWar
    ```
### Execution du jeu à travers l'interaction

* Dans la classe Main, nous avons déclaré les deux programmes War et Ouvrier.
* pour lancer le jeu Ouvrier, il faut commenter les lignes de code qui lancent le jeu War.
* inversemment, si vous voulez éxecuter le programme War, il faut commenter les lignes de code qui lancent le jeu     Ouvrier.
    ```bash
    $ java Main.Main
    ```





### FIN
