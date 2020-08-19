
This page compiles many of the questions which have been repeatedly asked by the community, and users before and after purchasing.

---
> **Page index**:
> * [What versions and platforms does the plugin support?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#what-versions-and-platforms-does-the-plugin-support)
> * [How can I prevent players from getting out of an arena?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-prevent-players-from-getting-out-of-an-arena)
> * [How can I stop players from breaking out of an arena?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-stop-players-from-breaking-out-of-an-arena)
> * [How can I reward winners?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-reward-winners)
> * [How can I change the items and potion effects player get upon start?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-change-the-items-and-potion-effects-player-get-upon-start)
> * [How can I create a join sign?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-create-a-join-sign)
> * [Can I have arena floors built of different materials, and not necessarily snow only?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#can-i-have-arena-floors-built-of-different-materials-and-not-necessarily-snow-only)
> * [Can I build cylindrical/spherical/non-cuboid arenas?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#can-i-build-cylindricalsphericalnon-cuboid-arenas)
> * [How can I remove/change the www.example.com in scoreboards?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-removechange-the-wwwexamplecom-in-scoreboards)
> 
> * [Does SpleefX have a bungee-mode?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#does-spleefx-have-a-bungee-mode)
> * [How can I disable delay in splegg shots?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-disable-delay-in-splegg-shots)
> * [When large arenas start or regenerate, the server freezes and TPS drops. Any solutions?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#when-large-arenas-start-or-regenerate-the-server-freezes-and-tps-drops-any-solutions)
> * [How can I edit the building of an arena after it was made and saved?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#how-can-i-edit-the-building-of-an-arena-after-it-was-made-and-saved)
> * [Any unanswered questions?](https://github.com/SpleefX/SpleefX/wiki/Frequently-Asked-Questions#any-unanswered-questions)

---
## What versions and platforms does the plugin support
* The plugin supports **Minecraft 1.8.8, 1.8.9, 1.12.2, 1.13.2, 1.14.X, 1.15.X**. Any versions *older than 1.8* (for example 1.7.10) are *not* and will most likely *never* be supported. Versions newer than 1.15 will get their support added *as soon as possible*.
* The plugin has been built on the **Spigot API** and the **PaperSpigot API**. Although Bukkit/CraftBukkit should work just fine, the aforementioned platforms are the recommended ones.
* Other platforms, such as Sponge, Thermos, Cauldron, and whatnot, are not supported for now in SpleefX, and may not be any time sooner in the future.

## How can I prevent players from getting out of an arena?
You can achieve this through [WorldGuard](https://dev.bukkit.org/projects/worldguard)'s `exit` flag. Select the playable region, define a region and set the `exit` flag to false

## How can I stop players from breaking out of an arena?

 - **Case 1: Players *mine* their way out of the arena**

SpleefX does not handle anything for block-breaking (excluding Splegg). As in, by default, players can break any breakable block.

On the other hand, SpleefX offers extensive support for both [WorldGuard](https://dev.bukkit.org/projects/worldguard) and [WorldGuard Extra Flags](https://www.spigotmc.org/resources/worldguard-extra-flags.4823/). Through the latter, you can use WorldGuard regions, then use the `allow-block-break` to restrict the breakable blocks only to snow, leaves, etc. *(Check [this](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html) for a list of all valid material names)*

You can also do the opposite, have all blocks breakable by default and `deny-block-break` certain types only.

- **Case 2 (Splegg): Players use the shooting tool to destroy their way out of the arena**

You can define certain blocks as `nonDestroyableBlocks`. The configuration is done inside `/SpleefX/extensions/standard/splegg.json`

## How can I reward winners?
Moved to [Rewards](https://github.com/SpleefX/SpleefX/wiki/Rewards).

## How can I change the items and potion effects players get upon start?
1. Head to **/SpleefX/extensions/<mode type>/<mode>.json**
2. Go to the `itemsToAdd` section
3. Add and remove [items](https://github.com/SpleefX/SpleefX/wiki/Understand-extensions#items).

## How can I create a join sign?
1. Place a sign
2. Write the following:
> `[Spleef]`
> <arena key>

**[Spleef]** is consistent for all arena types, and not only spleef. 

## Can I have arena floors built of different materials, and not necessarily snow only?
Yes you can. Though, make sure to give players the appropriate equipment (and possibly potion effects such as **haste**).

Do know that, you may need to give up snowballs for non-snow blocks.

## Can I build cylindrical/spherical/non-cuboid arenas?
Yes, the arena can be as weird as you want. **But do note that, you cannot use WorldEdit's cylindrical or spherical selection commands.**

**SELECTIONS DONE THROUGH WORLDEDIT ARE STRICTLY CUBOID**. We are limited by this as WorldEdit can only save cuboid schematics (which are used for automated regeneration)

## How can I remove/change the www.example.com in scoreboards?
1. Head to **/SpleefX/extensions/standard/<mode>.json**
2. Go to the `scoreboards` section (often in the bottom).
3. Profit.

## Does SpleefX have a bungee-mode?
 - SpleefX supports any server that runs Spigot or any fork of it, it's up to your configuration to decide how such things are run, but no explicit option for it
 - It's not *directly* possible to create a bungee-mode, by having players leave the whole server after they finish their game, however, you can achieve very similar behavior through **defining a finishing location of an arena which takes them to a Bungee portal**.
 - SpleefX does not offer explicit support for the one-game-per-server style. Having multiple arenas per world is possible however.

## How can I disable delay in splegg shots?
By default, splegg comes with an upgrades system. You can configure delays in **/SpleefX/extensions/standard/splegg.json**, or entirely disable them through `upgradesSystemEnabled` in the same file.

## When large arenas start or regenerate, the server freezes and TPS drops. Any solutions?
1. If the server freezes **when an arena starts**, go to **config.yml** and disable **RegenerateBeforeGameStartsCountdown**
2. If the server freezes **when an arena starts or regenerates**, then [download FastAsyncWorldEdit](https://intellectualsites.github.io/download/fawe.html). It is faster and generally better for server performance than the standard WorldEdit. SpleefX supports both.

## How can I edit the building of an arena after it was made and saved?
See [Edit arena structure](https://github.com/SpleefX/SpleefX/wiki/Edit-arena-structure).

# Any unanswered questions?
Join us on [Discord](https://discord.gg/uwf72ZN) for live and fast support!