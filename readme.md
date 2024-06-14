
# Project: PolyNames

## But

Creer un jeu basé sur CodeNames


## Modèle relationnel

Words(<u>word_ID</u>, word) \
Cards(<u>cards_ID</u>, *game_ID*, *word_id*, color, is_revealed) \
Game(<u>game_ID</u>, hintMaster, wordMaster, score) \
Round(<u>round_ID</u>, *game_ID*, hint, guess_value, round_score)

## Diagramme entité association

Disponible dans le fichier DiagrammePolynames.drawio

## Requirement

Activer Apache et MySQL sur le port 3306. \
Lancer le script **polynames_bdd.sql** pour créer la base de donnée, les différentes tables et insérer les données.


