# Latice

## Overview

<table>
  <tr>
    <td>
      <img alt="Latice DxD Logo" src="src/main/resources/Logo.png" width="200px"/>
    </td>
    <td>
      <p>Latice is a Java-based application that showcases a board game with interactive elements. The project is structured to demonstrate various aspects of Java programming, including object-oriented design, GUI development with JavaFX, and handling game logic. This Latice is based on the DxD anime series.
    </td>
  </tr>
</table>

## Key Components
- **Game Logic**: Core game functionalities are implemented in Java, focusing on the rules and mechanics of the board game.
  - [`Game.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/application/Game.java)
- **Graphical User Interface**: The project uses JavaFX for its GUI, providing an interactive and user-friendly interface.
  - [`BoardFX.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/ihm/view/BoardFX.java)
  - [`MenuFX.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/ihm/view/MenuFX.java)
  - [`PlayFX.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/ihm/view/PlayFX.java)
- **Controllers**: Various controllers handle different aspects of the game, such as drag-and-drop functionality, game parameters, and player actions.
  - [`DnDController.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/ihm/controller/DnDController.java)
  - [`ParametersController.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/ihm/controller/ParametersController.java)
- **Model**: The model part of the application includes the representation of the board, players, and tiles.
  - [`Player.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/model/Player.java)
  - [`Board.java`](https://github.com/paul-rezzonico/latice/blob/main/src/main/java/latice/model/board/Board.java)

## Resources
The project includes various resources such as images and music to enhance the user experience.
- Images: Tiles, board backgrounds, and other graphical elements based on DxD Characters.
- Music: Background music and sound effects for different game scenarios.

## Getting Started
To run the project:
1. Clone the repository.
2. Open the project in an IDE that supports Java and JavaFX.
3. Run the `Latice.java` file.

## Screenshots

The main menu of the application allows the user to start a new game, change the game parameters, or exit the application.
<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1tFANLzBuUfeicgTjfzuUDCRSsVoTWRM-" width="700" >
</p>

----

This is the starting screen of the game. The user can drag and drop tiles onto the board to make a move.
<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1V1qH5NkXLE7ABwu66QpSiOsdvheNIWiS" width="700" >
</p>

----

You can put tile alongside other tiles if they match the color or shape of the adjacent tiles.

<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1QKyg1SlyK5zd6VHH7rWclm9LXnH52VO4" width="700" >
  <img src="https://drive.google.com/uc?export=view&id=1kHP8lZpqUiqap3fU-8vLwgSXOlxfk3cC" width="700" >
</p>

---- 

There are other rules to the game such as changing the rack of tiles, instead of placing a tile on the board. 
<p align="center">
  <img src="https://drive.google.com/uc?export=view&id=1L6L9VlzdaG3m6Dg9lxODjBcTE69DA05D" width="700" >
</p>

----

The game ends when a player has no more tiles left in their hand or if the time runs out. The player with the lower tile left in their hand wins the game.

## Technologies used
- Java 8 ![Java](https://img.shields.io/badge/Java-8-blue)
- JavaFX ![JavaFX](https://img.shields.io/badge/JavaFX-8-blue)
- Maven ![Maven](https://img.shields.io/badge/Maven-0C7D9D?style=flat&logo=apache-maven&logoColor=white)
- JUnit ![JUnit](https://img.shields.io/badge/JUnit-02303A?style=flat&logo=junit5&logoColor=white)
- Git ![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white)
- IntelliJ IDEA ![IntelliJ](https://img.shields.io/badge/IntelliJ-000000?style=flat&logo=intellij-idea&logoColor=white)

## RNCP referential

| Skill | Description | How it's used in the project |
| :---: | :---------: | :--------------------------: |
| **![RNCP35475BC01](https://img.shields.io/badge/RNCP35475BC01-1-00BFFF?style=flat)** | Perform an application development | With this project, I was able to develop a Java application from scratch. I used the JavaFX library to create the GUI and implemented the game logic in Java. |
| **![RNCP35475BC02](https://img.shields.io/badge/RNCP35475BC02-1-00BFFF?style=flat)** | Optimize IT applications | I used Test and Debugging techniques to ensure the application runs smoothly. |
| **![RNCP35475BC05](https://img.shields.io/badge/RNCP35475BC05-1-00BFFF?style=flat)** | Conduct a project | We start the project by defining the requirements and the specifications. We then developed the application and tested it. |
| **![RNCP35475BC06](https://img.shields.io/badge/RNCP35475BC06-1-00BFFF?style=flat)** | Working in an IT team | I worked with a partner to develop this project. We used Git to manage the project. |

----

Thank you for reading this far. I hope you enjoyed the game.
