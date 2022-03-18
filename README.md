# Animopoly

A fun animal purchasing board game with **absolutely no relation to Monopoly whatsoever!**

Completed as a team of 3 for a college project.

The code may be messy or repeated at parts because we **may or may not** have run out of time towards the end.

## Gameplay Instructions

The Animopoly game consists of buying, upgrading and hopefully not having to sell them back to stay alive.

Players will each be given the option of their name and token that will represent them and will start with a total of §1500. This money can be used to purchase tiles that you land on, or upgrade ones that you already own! Purchasing tiles around the board will allow you to earn money off of any players that land on them, with the fee doubling with each level.

Players will 'die' on their farm if their money falls to zero, and will be forced to sell off any of their animals in order to buy their soul back from the devil.

Cards will be pulled any time a player rolls a double and they can have devastating effects on the player who rolled them, or maybe the God(s) will look kindly upon you.

As soon as all but one player have sold all of their tiles and run out of money the game is over and a victor is crowned! Congrats on your Animopoly!

Have fun :)

## Setup

1. Clone this repo: `git clone https://github.com/obfuscatedgenerated/animopoly.git`
2. Install the dependencies using Maven: `mvn install`

## Packaging to JAR

1. Use Maven Shade to package with dependencies: `mvn package`

## Running the JAR

1. Run the JAR in Java: `java -jar <path>`
