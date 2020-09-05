This page will cover how to configure and use the triple arrows ability in bow spleef.

> **Page Index**:
> 1. [Components](Triple-Arrows#components)
> 2. [Scoreboards](Triple-Arrows#scoreboards)
> 3. [Issues](Triple-Arrows#issues)
---

# Components
| Component | Description |
|--|--|
| enabled | Whether is the ability enabled at all |
| defaultAmount | The amount of triple-arrows each player gets to use |
| actionsToTrigger | The actions that are done in order to trigger the ability. See [this](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/block/Action.html) for allowed values. |
| requiredMaterials | The materials in which the player has to execute the above action with in order to trigger the ability. See [this](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html) for allowed values|
| cooldown | The ability cooldown use. |

# Scoreboards
Triple arrows introduces the following delegate placeholder: **`{triple_arrows}`**. This placeholder will represent the amount of triple-arrows the player can use

# Issues
This ability can have some issues, mainly due to the limitations in Bukkit and Vanilla. Such issues are:

 - **`LEFT_CLICK_BLOCK`** may not work much as intended
 - When shoot in a certain angle, 2 arrows out of the 3 may be close to each other
 - Arrows get launched super quickly