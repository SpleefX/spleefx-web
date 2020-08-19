> **Page Index**:
> 1. [Prerequisites](https://github.com/SpleefX/SpleefX/wiki/Leaderboards#prerequisites)
> 2. [Enable the leaderboards](https://github.com/SpleefX/SpleefX/wiki/Leaderboards#enable-the-leaderboards)
> 3. [Access leaderboards](https://github.com/SpleefX/SpleefX/wiki/Leaderboards#access-leaderboards)
> 4. [Customize the format](https://github.com/SpleefX/SpleefX/wiki/Leaderboards#customize-the-format)
---
This page will include information on how to create access the leaderboards features of SpleefX

# Prerequisites

 - [PlaceholderAPI](https://www.spigotmc.org/resources/6245/)
 - *For SpleefX below 3.8.5-BETA*: [SpleefX-PAPI](https://api.extendedclip.com/expansions/spleefx-papi/): Must be 1.3-SNAPSHOT or newer!

# Enable the leaderboards
Since leaderboards are still in beta and may have performance issues (not visible with servers less than 2000 player-base), they are a use-at-your-own-risk, and must be enabled manually.

 1. Go to **/plugins/SpleefX/config.yml**
 2. Head to the section `Leaderboards`
    ```yml
      # This is in beta, enable at your own risk!!  
      #  
      # Note that this section requires PlaceholderAPI
      Leaderboards:  
      
      # Whether should the plugin allow leaderboards.  
      #
      # This is not perfectly safe, and may cause the plugin to take some time loading the plugin data.  
      Enabled: false
    ```
3. Set `Enabled` to **true**.

# Access leaderboards
After installing the latest version of SpleefX-PAPI and ensuring that you have PlaceholderAPI and leaderboards enabled, you can access the leaderboards through PlaceholderAPI, using the following format:

```%spleefx_<statistic>_<leaderboard position>:<mode, or global>:<request>```

 - **statistic**: The game statistic you want to sort by. For example, if you want to get the leaderboards of wins, `<statistic>` would be `wins`.
 - **leaderboard position**: The position of the player you want to fetch. For example, the \#1 player will have `<leaderboard position>` set to `1`.
    - **Note**: Any invalid number, such as -1, 0, etc., will parse to the very last player in the leaderboard.
- **mode**: The mode you want the top players in. 
   - For example, Spleef leaderboards would have this set to `spleef`.
   - If you want global statistics, this would be `global`.
- **request**: The *thing* you want from the top #n player. Requests are constant operations:
- 
| Request | Description |
|--|--|
| name | The name of the player holding this position |
| pos | The position of this player in the leaderboard |
| stat | The statistic of this player in this leaderboard. For example, if they have 10 wins, this would be 10. |
| format | A format which can combine all the above. This format can be specified in the config.yml. See the section directly below. |

# Customize the format
If you have a plugin which you might want to display all things about the player in (such as their position, name and score), then you can use the `format` request, and customize how it looks in the **config.yml**:
```yml
Leaderboards:
  
   # The format, in which PlaceholderAPI will replace the placeholder with.  
   #  
   # This is used in the <i>format</i> PAPI request (see below).  
   #  
   # An example PAPI expression: %spleefx_wins_1:<request>%  
   #  
   # There are 3 requests through PAPI:  
   # ==  
   # name: The name of the top #n in the stat  
   # pos: The position of the top #n in the stat  
   # score: The score of the top #n in the stat  
   # format: The format below (to allow more than 1 thing in a single request)  
   # ==  
   #  
   # Inner placeholders:  
   # {pos} - The player position  
   # {player} - The player name  
   # {score} - The player's score in this stat  
   Format: "&d#{pos} &e{player} &7- &b{score}"
``` 

**Acceptable placeholders in formats**:
| Placeholder | Description |
|--|--|
| {pos} | The player position in the leaderboard |
| {player} | The player name |
| {score} | The player's score in the leaderboard. |

*Colors will be automatically parsed.*