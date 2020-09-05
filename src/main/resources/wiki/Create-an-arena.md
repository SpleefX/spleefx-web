
This page will cover how to create an arena. [Don't know what an arena is?](What-is-an-arena%3F)

>**Page Index**:
> 1. [Prerequisites](Create-an-arena#prerequisites)
> 2. [Create your arena](Create-an-arena#create-your-arena)
---

# Prerequisites
* [WorldEdit (or any of its forks)](https://dev.bukkit.org/projects/worldedit/files) that supports your Bukkit version (1.8+) 

# Create your arena

 1. **Prepare your arena structure**: Magically build or retrieve your arena structure (whether it be using WorldEdit, hand-made, or any other means of accomplishing the task)
 2. **Selection**: Select the arena corners using WorldEdit. *Make sure the whole arena is selected!*
    * *Don't know how to?* [*Watch this video*](https://www.youtube.com/watch?v=M6fk2GQi53w)
 3. **Clipboard**: Copy your selection to your WorldEdit clipboard. *Must involve executing //copy or //cut!*
    * *Don't know how to?* [*Watch this video*](https://www.youtube.com/watch?v=qeCU8C5wHSg)
 4. **Create your arena SpleefX-wise**: After selecting and copying your arena, execute the following command:
> /<mode> arena create <arena key> [arena type] <arena display name>
> 
> *Example: /spleef arena create myarena ffa My Arena*

Command arguments:
1. **Mode**: The arena mode command. Specified in the arena extension file inside `modeCommands`.
2. **Arena key**: A special and unique identifier for the arena. Can be anything that does not contain whitespace (i.e space, etc.)
3. **Arena type**: The arena type. Can be either:
   * **`ffa`**: Stands for **free for all**. In this mode, there are no teams, but all players compete against each other.
   * **`teams`**: In this mode, there can be up to 6 teams (red, green, blue, yellow, pink and gray), and each team can contain at least 1 player. **If no arena type is specified, this type is used by default.**
4. **Arena display name**: The display name of the arena. This is displayed on signs, GUIs and can be referenced to from commands. Can contain any character (even spaces) and can be edited anytime through the GUI or through *arenas.json*.