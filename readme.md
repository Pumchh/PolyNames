
# Project: PolyNames

## Goal

Create a game based on CodeNames


## Modèle relationnel

Words(<u>word_ID</u>, word) \
Cards(<u>cards_ID</u>, *game_ID*, *word_id*, color, is_revealed) \
Game(<u>game_ID</u>, hintMaster, wordMaster, score) \
Round(<u>round_ID</u>, *game_ID*, hint, guess_value, round_score)


