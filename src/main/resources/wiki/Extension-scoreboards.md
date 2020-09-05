This page will cover details on how to completely customize the scoreboard in extensions.

**Note**: The scoreboard feature is still in beta! Bugs may occur.

> **Page Index**:
> 1. [Components](Extension-scoreboards#components)
> 2. [Placeholders](Extension-scoreboards#placeholders)
---
# Components
| Component key | Description
|--|--|
| enabled | Whether should the scoreboard be displayed or not |
| title | The scoreboard title |
| text | The scoreboard text, each assigned with the line (score). The score is displayed from *highest to lowest*. |

# Placeholders
A scoreboard can accept the following placeholders:
* **`{double_jumps}`**: The amount of double-jumps the player has
* **`{triple_arrows}`**: The triple arrows ability count the player can use **(Bow spleef only!)**
* **Any PlaceholderAPI placeholders**
* [**Message placeholders**](Edit-messages#message-placeholders)