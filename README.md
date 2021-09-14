# My-Knights-and-Princesses-Game

In essence, this game simulates the fight between two characters - the first one controlled by the user and the second one controlled by the computer AI.<br />The narative of the game is set in a fictional kingdom where the hero (the user) embraces the mission to save the Princess and, in order to achieve that, he needs to defeat the Princess's kidnapper.

**NOTE:** All the text in the game is written in Romanian, so playing the game by players of other nations could pe challenging. Adding an English version of the game texts is a future feature I plan to implement.

## Features

1. The user has the ability to play the game as one of the three character classes available in the game - knight, thief, mage;
2. Each character has different strenghts and weaknesses. For example, the knight is very effective when fighting with the sword, he is also good at using magic, but he is less effective when using the bow and arrows. The knight may be resistant to the sword attack, but his life is moderately affected by magic and severely affected by the rain of arrows.
3. The program generates randomly the user's enemy from the three character classes listed above.
4. Both the user and his enemy have a limited amount of 3 life potions, which restores up to 50 points of life.
5. Both the user and his enemy have the ability to attack its opponent in one of the three possible way to attack - sword attack, stealth attack (bow and arrows) and spell attack.
6. Each attack doesn't do a predefined damage to the opponent. The amount of damage is calculated randomly between two margins based on the player's class, the opponent's class and the type of the attack launched.
7. The enemy's AI is pretty basic. It is not aware of its strenghts and weaknesses, so he chooses randomly to attack (including the type of the attack) or to drink a health potion. It is only forced by the code to drink a healing potion when its life drops to 40 pts or bellow this value.

## How To Run The Game

In the repository you will find a .jar version of the game wich can be downloaded to play the game.

## How To Play The Game

1. Press the Enter key when prompted on the screen.
2. Enter the name wich you want to play with.
3. Choose the class of your character by typing the number in front of each class. Additionally, you cand press the 0 key to see detailed information about the effectiveness of each attack depending on your character's class, your opponent's class and the type of attack used.
4. During the fight you can:
    - press 0 to run from the fight;
    - press 1, 2 or 3 to send a specific attack to your opponent;
    - press 4 to drink a healing potion;
    - press 5 to see the options list;
    - press 6 to see the table regarding the effectiveness of each attack.

5. Screenshots

![knights1](https://user-images.githubusercontent.com/90447306/133109179-65d6c4ab-3960-4c94-ae07-6f832250904a.jpg)

![kinghts2](https://user-images.githubusercontent.com/90447306/133109171-f35e5148-c313-4aa0-80ed-b5f78bc28d0f.jpg)

![kinghts3](https://user-images.githubusercontent.com/90447306/133109175-1e70ba69-5ea2-4b28-becf-9b890128868f.jpg)

## Future Features:

1. Adding a GUI to the game;
2. Adding an English version;
3. Improving the AI of the enemy.

