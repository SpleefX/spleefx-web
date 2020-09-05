This page will cover the plugin's use of Bukkit vectors. **This is not a physics class!** It will include information on how to appropriately use them.

> **Page Index**:
> 1. [Format](Understand-vectors#format)
> 2. [Useful resources](Understand-vectors#Useful-resources)
---

# Format
| Element | Description |
|--|--|
| x* | A fixed X vector component. |
| y* | A fixed Y vector component |
| z* | A fixed Z vector component |
| usePlayerOriginalVector | Whether should the vector use the player's original looking vector. If true, the above values will not be used, and you will need to use the operations below to create a relative vector |
| multiply | Number to multiply the vector by. |
| divide | Number to divide the vector by |
| addition | Number to add to the vector |
| subtract | Number to subtract from the vector |

\* This element will NOT be used if **usePlayerOriginalVector** is set to **`true`**

# Useful resources
The links below contain useful places which could give you handy information when dealing with vectors.

 - **Spigot Docs**: [https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)
 
 - **[Tutorial] How to calculate vectors (Bukkit Forums)**: [https://bukkit.org/threads/tutorial-how-to-calculate-vectors.138849/](https://bukkit.org/threads/tutorial-how-to-calculate-vectors.138849/)
 
 - **Vector Programming for Beginners (Spigot Wiki)**: [https://www.spigotmc.org/wiki/vector-programming-for-beginners/](https://www.spigotmc.org/wiki/vector-programming-for-beginners/)