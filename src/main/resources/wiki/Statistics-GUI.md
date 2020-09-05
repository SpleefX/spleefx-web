> **Page Index**:
> 1. [What is the statistics GUI?](Statistics-GUI#what-is-the-statistics-gui)
> 2. [Display the statistics GUI](Statistics-GUI#display-the-statistics-gui)
> 3. [Customize the statistics GUI](Statistics-GUI#customize-the-statistics-gui)
> 4. [Placeholders](Statistics-GUI#placeholders)
> 5. [Reload the statistics GUI](Statistics-GUI#reload-the-statistics-gui)
---

# What is the statistics GUI
The statistics GUI is a menu displayed to view all player game statistics tracked by the plugin. Statistics collected are:

 - Games played
 - Wins
 - Losses
 - Draws
 - Blocks mined

# Display the statistics GUI
It's possible to view statistics for each extension, as well as view global/total statistics.

### Extension-specific
> /<mode> stats [player]
>
> Example: /splegg stats
> Example: /splegg stats Flappy

### Global
> /<mode> stats [player] global
>
> Example: /splegg stats global
> Example: /splegg stats Flappy global
> 
> *Note: The behavior for global statistics will remain the same even if the main command changes, hence it is recommended to create a united alias for one of the global statistics command to avoid confusion.*

**Permission**:
  * `spleefx.<mode>.stats` to view self stats
  * `spleefx.<mode>.stats.others` to view other people's statistics

# Customize the statistics GUI
The statistics GUI settings can be customized through `/plugins/SpleefX/gui/statistics-gui.json`. 

| Key | Description |
|--|--|
| title | The title of the inventory. Can accept **`{player}`** as a placeholder for the player's name, and **`{extension}`** as a placeholder for the extension's display name |
| rows | The amount of rows this menu has |
| items | The GUI items. See [this](Understand-extensions#items) to understand the format |

# Placeholders

| Placeholder | Description |
|--|--|
| {games_played} | The games played |
| {wins} | The player wins |
| {losses} | The player losses |
| {draws} | The player draws |
| {blocks_mined} | The blocks mined *(in case of splegg, this will include blocks that were destroyed by projectiles as well.)* |

# Reload the statistics GUI
To reload the statistics GUI, run the following command:

> /spleefx reload statsFile
>
> **Permission**: spleefx.admin.reload