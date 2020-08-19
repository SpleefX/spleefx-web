This page will contain all details on how to reward winners in arenas.

> **Page Index**:
> 1. [Notes](https://github.com/SpleefX/SpleefX/wiki/Rewards#notes)
> 2. [Add rewards](https://github.com/SpleefX/SpleefX/wiki/Rewards#add-rewards)
> 3. [Examples](https://github.com/SpleefX/SpleefX/wiki/Rewards#examples)
---

# Notes
 - To allow for topmost flexibility, rewards are done **entirely in commands**. You can use this to reward your players in any way you want, such as money, crate keys, in-game items, etc.
 - Rewards are defined **per-game mode only**. For now, per-arena rewards are not possible.
 - You can define different rewards for FFA arenas and Team arenas 
 - You can define different rewards according to the position they won in the game. For example, the 1st winner can have high rewards, while the 2nd winner gets less, and so on.

# Add rewards
1. Head to **/SpleefX/extensions/standard/<mode>.json**
2. Head to the **runCommandsForTeamWinners** or **runCommandsForFFAWinners** (the one you'd like to configure the rewards for)
3. Sections:

| Section | Description |
|--|--|
| **PLAYER** | Commands that are ran by **the winner themselves** |
| **CONSOLE** | Commands that are ran by **the console**. |
Both  sections accept `{player}` as a placeholder for the player name.

4. Each section defines **numbers**. These are the positions of the winner. The real winner would be the 1st, the last survivor would be 2nd, etc.
5.  Each number takes a **JSON array**. Meaning, it can have multiple commands. 

# Examples

### Example \#1: Simple rewards
 - The following defines rewards in FFA games, where it rewards the 1st and 2nd winner
```json
{
  "runCommandsForFFAWinners": {
    "1": {
      "PLAYER": [],
      "CONSOLE": [
        "give {player} diamond 10",
        "give {player} diamond_helmet"
      ]
    },
    "2": { 
      "PLAYER": [],
      "CONSOLE": [
        "give {player} diamond 5",
        "give {player} iron_helmet"
      ]
    }
  }
}
```
What happens:
 - **1st winner** gets 10 diamonds and a diamond helmet
 - **2nd winner** gets 5 diamonds and an iron helmet

### Example \#2: Economy rewards
The following example defines money rewards.
```json
 {
  "runCommandsForFFAWinners": {
    "1": {
      "PLAYER": [],
      "CONSOLE": [
        "eco give {player} 500",
        "msg {player} You received $500 for winning!"
      ]
    },
    "2": {
      "PLAYER": [],
      "CONSOLE": [
        "eco give {player} 100",
        "msg {player} You received $100 for being 2nd place!"
      ]
    }
  }
}
```
What happens:
 - The winner gets paid $500 (assuming you use Essentials Economy)
 - The 2nd place gets $100

### Example \#3: Rewards done through custom plugins/Skript
The following example allows rewards to be done through custom plugins. This allows best flexibility
```json
{
  "runCommandsForFFAWinners": {
    "1": {
      "PLAYER": [],
      "CONSOLE": [
        "customplugin givereward {player}"
      ]
    }
  }
}
```
What happens:
 - Console executes `customplugin givereward (player)`, which does magic through the custom plugin.
