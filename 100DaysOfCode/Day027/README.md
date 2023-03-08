# QUIZ APP

The questions are from the open trvia database API.

To change the category of the questions you will need to:

1. Go to the site "https://opentdb.com/api_config.php" and select the category you want. 
2. Click generate api url, it will return something like "https://opentdb.com/api.php?amount=10&category=9&type=boolean".
3. Go to data.py and in the parameters dictionary add a key "category" and place the category you got from the link, like -> "category": 9 in this example it would be the category 9.