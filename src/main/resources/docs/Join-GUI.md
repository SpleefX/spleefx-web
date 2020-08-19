> **Page Index**:
> 1. [What is the join GUI?](https://github.com/SpleefX/SpleefX/wiki/Join-GUI#what-is-the-join-gui)
> 2. [Display the join GUI](https://github.com/SpleefX/SpleefX/wiki/Join-GUI#display-the-join-gui)
> 3. [Customize the join GUI](https://github.com/SpleefX/SpleefX/wiki/Join-GUI#customize-the-join-gui)
> 4. [Reload the join GUI](https://github.com/SpleefX/SpleefX/wiki/Join-GUI#reload-the-join-gui)
---

# What is the join GUI?
The join GUI is a menu that contains joinable (and non-joinable, depends on customization) arenas, with a special item that represents each arena stage (running, waiting, regenerating, etc.)

# Display the join GUI
To display the join GUI, run the following command:
> /<mode> joingui
>
> Example: /splegg joingui

**Permission**: <mode command>.joingui (Allowed by default)

# Customize the join GUI
The Join GUI settings can be controlled through `/plugins/SpleefX/gui/join-gui.json`. 

| Key | Description |
|--|--|
| title | The title of the inventory. Can accept **`{extension}`** as a placeholder for the extension's display name |
| rows | The amount of rows this menu has |
| stagesToDisplay | The arena stages that can be displayed in the GUI |
| items | The GUI items, each one assigned to a specific arena stage. See [this](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#items) to understand the format |

You can also use [arena placeholders](https://github.com/SpleefX/SpleefX/wiki/What-is-an-arena?#arena-placeholders) in the item's display name and/or lore.

**Arena stages (case sensitive!)**:

   - **NEEDS_SETUP**: The arena is not fully setup. Appears when:
      - the arena's team count is less than 2 (in case of teams mode)
      - the arena's minimum player count is less than 2 (in FFA mode).
      - not all spawn-points are defined.
   - **WAITING**: The arena is waiting for players to join
   - **COUNTDOWN**: The arena is in countdown. Players are allowed to join as long as the arena is not full
   - **ACTIVE**: The arena is currently active and occupied
   - **REGENERATING**: The arena is regenerating to its original structure. Regenerating is an extremely quick process hence this stage is rarely spotted.
   - **DISABLED**: The arena and/or the extension is/are disabled.

# Reload the join GUI
To reload the join GUI, run the following command:

> /spleefx reload joinGuiFile
>
> **Permission**: spleefx.admin.reload