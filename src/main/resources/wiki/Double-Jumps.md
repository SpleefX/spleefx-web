This page will cover details on how to completely customize the double-jumps system in extensions

>**Page Index**:
> 1. [What are double jumps?](Double-Jumps#what-are-double-jumps)
> 2. [Components](Double-Jumps#components)
> 3. [Items](Double-Jumps#items)
> 4. [Scoreboards](Double-Jumps#scoreboards)
---

# What are double jumps?
Double jumps are a simple but fun mechanic in games, where players would be able to jump twice in air as a mean to get launched into the air with a velocity. 

Each player will have a specific amount of double jumps in each game, with a cooldown between using them.

# Components
| Component key | Description |
|--|--|
| enabled | Whether should double jumps be enabled in this extension or not |
| defaultAmount | The amount of double-jumps each player starts with when the game starts |
| cooldownBetween | The cooldown between double jumps |
| playSoundOnJump | A sound to play when the player double jumps. Can be `null`. |
| doubleJumpItems | Items which double-jump the player when they left/right click on them. See `Items` below. |
| launchVelocity | The velocity which controls how the player is launched. See [Understand vectors](Understand-vectors#Useful-resources) for more information. |

# Items
Represents items which, if available, double jump the player when they right/left click with them.

**There are 2 sections of these items**:

 1. **onAvailable**: This item takes the slot when the player can double-jump
 2. **onUnavailable**: This item takes the slot when the player cannot double jump, either because of running out of double jumps, or because they must wait for the cooldown.

For information on items format, see the [Special formats -> Items](Understand-extensions#items) section.

| Component key | Description |
|--|--|
| enabled | Whether should these items be enabled or not |
| slot | The slot in which these items should be in |
| onAvailable | See above |
| onUnavailable | See above |

# Scoreboards
Double jumps introduces the following delegate placeholder: **`{double_jumps}`**. This placeholder will represent the amount of double jumps the player has