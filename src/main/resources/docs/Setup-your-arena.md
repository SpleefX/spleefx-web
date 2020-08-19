
This page will cover how to setup an already-made arena. 
* [Don't know what an arena is?](https://github.com/SpleefX/SpleefX/wiki/What-is-an-arena%3F)
* [Don't know how to create an arena?](https://github.com/SpleefX/SpleefX/wiki/Create-an-arena)

>**Page Index**:
> 1. [Set the arena variables](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#set-the-arena-variables)
> 2. [Add teams](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#add-teams)
> 3. [Set spawn-points](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#set-spawn-points)
> 4. [Set the arena lobby](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#set-the-arena-lobby)
> 5. [Extras](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#extras)
>    * [Enable/Disable your arena](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#enabledisable-your-arena)
>    * [Rename your arena](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#rename-your-arena)
>    * [Update arena variables through commands](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#update-arena-variables-through-commands)
>    * [Regenerate an arena manually](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#regenerate-an-arena-manually)
>    * [List all arenas for a specific mode](https://github.com/SpleefX/SpleefX/wiki/Setup-your-arena#list-all-arenas-for-a-specific-mode)
---

# Set the arena variables
A SpleefX arena consists of a bunch of numeric variables which determine most of the arena boundaries.

These variables can be edited through the in-game GUI:

![The settings GUI](https://i.imgur.com/GKAkQqF.png)

*Note 1: middle-clicking on increase/decrease will increase/decrease the value by 5 instead of 1*

*Note 2: Clicking on the descriptive item in the center between increase/decrease (e.g the redstone dust, the iron helmet) will display the current value*

*Note 3: Due to Minecraft limitations, values greater than 64 will be displayed as 64, however their values will be changed nonetheless.*

### Death level

![Death level in the settings GUI](https://i.imgur.com/wyQ5pVi.png)

Represents the Y level in which if a player reaches, they are eliminated from the game.

**Example**: *Player A* is standing on the *Arena X* floor, where the arena death level is 90, and the floor level is 95. *Player B* digs a block under *Player A*, and *Player A* starts to fall. Once *Player A* reaches Y 90, they are eliminated from the game.

### Game time

![Game time in the settings GUI](https://i.imgur.com/a16NJlj.png)

Represents the time that a game can run for (A.K.A  timeout). **Value is defined in minutes**.

**Example**: *Player A* and *Player B* are competing in *Arena X*, where the game time is 1 minute. Once the game starts, the game time starts to go down by each second, and players are warned each time it reaches a specific milestone (e.g 30 seconds, 15 seconds, 10, etc.) **If the game time reaches 0 and no player has won yet, the game ends with a draw.**

### Minimum players required

![Minimum players required in the settings GUI](https://i.imgur.com/qmZVciR.png)

Represents the minimum amount of players required for the game to start. *Must be ≥ 2*


### Members per team (Teams only)

![Player count in the GUI](https://i.imgur.com/gwcVbNH.png)

Represents the amount of players each team can have.

### Maximum player count (FFA only)

![Player count in the GUI](https://i.imgur.com/gwcVbNH.png)

Represents the total maximum amount of players allowed in the game. *Must be ≥ 2*

# Add teams
You can add teams in 2 ways:

 1. **Settings GUI**: To open this GUI, run the following command:
 > /<mode> arena settings <arena key> 

![Add teams](https://i.imgur.com/qr9bmUM.png)
 
 2. **Commands**: To add teams, run the following command:
 > /<mode> arena settings <arena key> teams <teams to add>
 > *Example*: /spleef arena settings myarena teams red green blue

# Set spawn-points
Spawn-points are fixed and defined locations in which the players are teleported to when the game starts (or when they join if no lobby is defined).

### For teams
Go to the desired location and execute the following command:
> /<mode> arena spawnpoint <arena key> <team>
> 
> *Example: /spleef arena spawnpoint myarena green*

### For FFA arenas
Go to the desired location and execute the following command:
> /<mode> arena spawnpoint <arena key> <player index>
> 
> *Example: /spleef arena spawnpoint myarena 1* to set the spawnpoint for *player 1*.

# Set the arena lobby
A lobby is the place where players are teleported to when they join the game. It has the same point of a waiting area. Setting a lobby is not required, and is completely optional.

To set the lobby:

 1. Go to the desired lobby location
 2. Type the following command:
 > /<mode> arena lobby <arena key> 

To remove the arena lobby, run the following command:
 > /<mode> arena removelobby <arena key> 

# Extras
### Enable/Disable your arena
Disabling an arena can be handy if you want to do maintenance on the arena or such.

To enable/disable an arena, run the following command:
  > /<mode> arena settings <arena key> toggle

- If the arena is enabled, this will disable it.
- If the arena is disabled, this will enable it.

### Rename your arena
To rename an already-existing arena using the GUI:

 1. Open the settings GUI for the arena using the following command:
  > /<mode> arena settings <arena key>
 2. Click on the name tag

![Name tag](https://i.imgur.com/R2lnmlL.png)

3. You will be prompted to write the new display name in chat. 
   * To cancel editing, type in chat **`cancel-edit`**.

To rename an already-existing arena using commands, run the following command: 
  > /<mode> arena settings <arena key> displayName <new display name>
  > *Example: /spleef arena settings myarena displayName My Awesome Arena*

### Update arena variables through commands
It's possible to change numeric variables through commands. This has a few advantages, such as allowing to be ran through console and to set to values more quickly.

To change a variable, run the following command:
> /<mode> arena settings <arena key> <setting> <new value>
>
> *Example: /spleef arena settings myarena deathLevel 90*

* Settings can be tabbed when writing the command

Settings keys (case-insensitive):

 - deathLevel
 - teams
 - displayName
 - membersPerTeam
 - gameTime
 - minimum
 - maxPlayerCount

### Regenerate an arena manually
To regenerate an arena, run the following command:
> /<mode> arena regenerate <arena key>

*regenerate can be aliased with `regen`*.

Arena regeneration should take the same exact amount of time it would take to paste the arena structure using WorldEdit (which is how it is actually regenerated.)

### List all arenas for a specific mode
To list all arenas, run the following command:
> /<mode> listarenas

*listarenas can be aliased with `list`*.

For admins, it will be sent like this (each one is clickable):

![List arenas (admins)](https://i.imgur.com/5FEk4ky.png)

For non-admins, it will be displayed like this:

![List arenas (players)](https://i.imgur.com/4A0Tuu1.png)