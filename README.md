# JAVA-projects for Java Technology Lab course at university
 
## multiple client chat engine using java socket programming and GUI.

### Introduction:
Java Socket programming is used for communication between the applications running on different JRE. The client in socket programming must know two information: IP Address of Server, and Port number. A socket is simply an endpoint for communications between the machines. The Socket class can be used to create a socket. A chat engine is a system where multiple clients can run communication between each other using a server. Using java socket programming materials, it is possible to create such an environment. Swing is the principal GUI toolkit for the Java programming language. It is a part of the JFC (Java Foundation Classes), which is an API for providing a graphical user interface for Java programs. Using GUI we will be able to give a proper visualization to our environment.

### Objectives:
Our objective is to implement a system where multiple client will be connected to a server. The server socket will contain it’s own IP address and port number. Client can access this server using this port Id. There will be two separate classes for server and client. Namely  the Server_frame and the Client_frame. 
### Processes:
At first we have to start the server. When the server is started, clients can now connect it and send messages. Then the client will give his own username and connect with the server. In order to use for multiple client we have to run the Client_frame class multiple times. After connecting all the clients we can check all of our connected users on the server frame. if we send a message from client one all the other clients as well as the server will receive the message and show. If a client is done with his conversation he can get disconnected from the server. If a client wants then he can connect anonymously with a randomly generated name. If the server messages gets too much it can be cleared. The server can stop the whole system just by clicking end. 
The Program running states are shown below..

![a](https://user-images.githubusercontent.com/25270629/58050105-42df6100-7b70-11e9-913e-aef8cd3be88f.jpg)

	Figure 01: Server frame and client frames when clients are connected by usernames.


![b](https://user-images.githubusercontent.com/25270629/58050195-7ae6a400-7b70-11e9-8e70-4d23b080f1a3.jpg)

  
        Figure 02: Client frames when clients are connected by anonymous usernames.



## Java hangman game.

### Introduction:
A hangman game is an application that  randomly generates a word and prompts the user to guess one letter at a time. Each letter in the word is displayed as an asterisk/blank dash. When the user makes a correct guess, the actual letter is then displayed. When the user finishes a word, the number of misses is displayed.
### Objectives:
Our objective is to write a program that will randomly generate a word from a given source file where a list of word is already given and ask the user/player to guess the word every letter by letter. It is not necessary to guess the letters sequentially. For each wrong guess a part of the drawing of a man hanging from a rope will be visible. The player will win if he/she can guess all the words properly. Otherwise the full drawing will be visible and the player will lose the game.    
### Processes:
When a user runs the program , Main class will initialize an object of HangmanGUI class. HangmanGUI clas will generate a jframe of size 650*500px at first. It will add necessary buttons like  options, start new game , guess etc. A title “Hangman” will be set on the top of the frame. On clicking the button Options, another button Start new game will be appeared with white foreground. The game will start if we click this button. RandomWordGenerator class will be initialized with “words.txt” file and it will read the text file and generate a random word for WordGuesser class object. Then the game will ask the user to guess the word and ask for letters to guess. Only small letters will be legal in this case, otherwise program will throw an exception. The program  will visualize the drawing of a hanged man part by part on each wrong guess. Finally, the player will win if he/she can guess all the letters properly and a message of winning will be shown. Otherwise, the full drawing will be visible and player will lose the game. To start a new game player have to click on start new game again. 
 
 ![c](https://user-images.githubusercontent.com/25270629/58050313-d6189680-7b70-11e9-8c3a-42b30496be02.jpg)
 
    Figure 03: Game condition when player is guessing the letters.

 ![d](https://user-images.githubusercontent.com/25270629/58050314-d6189680-7b70-11e9-94a8-948bb4bff92f.png)
 
    Figure 04: Game state when player have guessed all the letters correctly.
    
![e](https://user-images.githubusercontent.com/25270629/58050315-d6189680-7b70-11e9-820c-4438f5e93d9b.jpg)

    Figure 05: Game state when player could not guess all the letters before the drawing completes.

……………………………………………………………………………………….

