
>**Page Index**:
> 1. [What are extensions?](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#what-are-extensions)
> 2. [What can I configure?](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#what-can-i-configure)
> 3. [Extension types](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#extension-types)
> 4. [Special formats](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#special-formats)
>    * [Potion effects](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#potion-effects)
>    * [Items](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#items)
>    * [Enchantments](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#enchantments)
>    * [Game titles](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#game-titles)
>    * [Game-modes](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#game-modes)
>    * [Cancelled damage](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#cancelled-damage)
---

# What are extensions?
Extensions are your way to add your very own and customized modes to SpleefX. Using JSON files, you can set almost every aspect for your mode (such as signs, items, game titles, etc.)

# What can I configure?
Any extension must have these as a bare minimum:

| Component key | Description |
|--|--|
| enabled | Whether is the extension currently enabled or not. If disabled, all arenas that use this extension will automatically be disabled. |
| key | A unique identifier for the extension. Mostly used internally by the plugin for storage and retrieving, however it is the reference for controlling extensions through commands. |
| displayName | The display name for this extension. Used in GUIs and in placeholders |
| chatPrefix | The chat prefix for this extension. Any message that is related to this extension will be prefixed with this. |
| runCommandsByWinner | Commands that are ran by the winner when the game is over |
| runCommandsByConsoleForWinner | Commands that are ran by the console for the winner when the game is over. It is possible to refer to the winner through the placeholder **`{winner}`** |
| preventItemDropping | Whether should players be allowed to drop items or not |
| givePotionEffects | Potion effects to be added to players when the game starts |
| itemsToAdd | Items to give to players when the game starts |
| gameTitles | Titles that are displayed in the game in specific events, such as winning, losing and draw. |
| signs | The signs formatting for arenas that use this extension |
| waitingMode | The game-mode (survival, adventure, etc.) that players are put in when they join the arena |
| ingameMode | The game-mode (survival, adventure, etc.) that players are put in when the game starts |
| cancelledDamageInWaiting | The damage that is cancelled while the players are waiting in an arena. See [this](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.DamageCause.html) for allowed values (case sensitive!) |
| cancelledDamageInGame | The damage that is cancelled while the players are playing in the game. See [this](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.DamageCause.html) for allowed values (case sensitive!) |
| extensionCommands | The commands that function for the extension, such as arena creation commands and joining commands |
| allowedCommands | Commands that players are allowed to execute when they are in a game. Note that ops or players with permission **`spleefx.arena.command-exempt`** are not affected by this.|
| quitItemSlot | The slot of the item for quitting the arena |
| quitItem | The item in which if the player right clicks on, they leave the arena. |

# Extension types
There are 2 extension types:

 - **Standard extensions**: These include the 3 standard extensions, no more no less:
     - **Spleef**
     - **Bow Spleef**
     - **Splegg** 
 - **Custom extensions**: This includes any customized extension. It is possible to add, remove, and load those without any restrictions.

### Files
- **Standard extensions**: `/plugins/SpleefX/extensions/standard/`
- **Custom extensions**: `/plugins/SpleefX/extensions/custom/`

**Note**: It is possible to exclude an extension from being loaded, simply by prefixing it with `-`. For example, `-sumo.json`.

# Special formats
Some elements in extensions, such as items or potion effects, have special format (for example, a specific string or an object). Each of these formats is clarified below.

### Potion effects
**Format**: [effect key]:[duration in ticks]:[potion amplifier]

**Example**: `REGENERATION:200000:4`
See [this](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/potion/PotionEffectType.html) for potion effects keys.

### Items

| Key | Description |
|--|--|
| type | The item type. See [this](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html) for allowed values |
| count | The item amount |
| enchantments | The item enchantments. See section below for more details |
| displayName | The item display name. Set to `{}` to keep it without modifications |
| lore | The item lore. |
| itemFlags | The item flags. See [this](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/inventory/ItemFlag.html) for allowed values |
| unbreakable | Whether is the item unbreakable or not |
| color (optional) | The dye color (if the item can be colored, for example wool or glass). |

### Enchantments
**Format**: (enchantment name/id):(enchantment level)

**Example**: infinity:1

### Game titles
Each event in an arena has its own title.

**Game events** (case sensitive!):
 - **WIN**: When a player wins. Displayed to all players
    - This title can accept `{winner}` as a placeholder to the winner name.
 - **DRAW**: When the game ends as a draw. Displayed to all players
 - **LOSE**: When a player loses. Displayed ONLY to the player who lost

**Titles**:

| Key | Description |
|--|--|
| enabled | Whether should this title be displayed or not |
| title | The big title displayed. Can be left as blank |
| subtitle | The sub-title displayed. Can be left as blank |
| fadeInTicks | The fade-in ticks for the title |
| displayTicks | The display ticks for the title |
| fadeOutTicks | The fade-out ticks for the title |

### Game-modes
Any reference to game-mode must be derived from [here](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/GameMode.html) (case sensitive!)

### Cancelled damage
Any reference to cancelled damage must be derived from [here](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.DamageCause.html) (case sensitive!)