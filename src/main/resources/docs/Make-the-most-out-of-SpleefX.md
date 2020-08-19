This page will contain tips alongside with advised additional plugins in order to help make the best use out of SpleefX.

> **Page Index**:
> 1. [Server configuration](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#server-configuration)
> 2. [FastAsyncWorldEdit](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#fastasyncworldedit)
> 3. [WorldGuard](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#worldguard)
> 4. [WorldGuard - Extra Flags](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#worldguard---extraflags)
> 5. [Command aliasing plugins](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#command-aliasing-plugins)
> 6. [Citizens + CommandNPC](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#citizens--commandnpc)
> 7. [LuckPerms](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#luckperms)
> 8. [Placeholder API](https://github.com/SpleefX/SpleefX/wiki/Make-the-most-out-of-SpleefX#placeholder-api)
---
# Server configuration

 - **PaperSpigot**: It is heavily recommended to use PaperSpigot over Spigot or bare-boned CraftBukkit. This is due to the helpful API provided by PaperSpigot, as well as the many performance improvements offered by Paper.

 - **Server version 1.12.2+**: 1.12.2 is seen by many (including me) as one of the most stable versions Minecraft has ever released. It is recommended to use 1.12.2+ since it offers a lot of additions that would reduce the cache the plugin has to store.

# FastAsyncWorldEdit
FastAsyncWorldEdit is a fork of WorldEdit which aims to be much faster and optimized. Since SpleefX uses the WorldEdit API to handle arena regeneration, FAWE can help increase the speed of regenerating.

# WorldGuard
WorldGuard offers a lot of useful regions and flags, which can be used to improve the user experience. Such useful use can be:

 - **Prevent users from leaving arenas** by disabling the `exit` flag
 - **Prevent entities from spawning** by disabling the `mob-spawning` flag
 - **Protect arenas from explosions** by disabling the `other-explosion` flag (or any other individual flags)
 - **Stop leaves blocks from decaying** by disabling the `leaf-decay` flag
 - **Stop fire from spreading** by disabling the `fire-spread` flag.

See a list of all WorldGuard flags [here](https://worldguard.enginehub.org/en/latest/regions/flags/#flag-listing).

# WorldGuard - ExtraFlags 
[**WorldGuardExtraFlags**](https://www.spigotmc.org/resources/worldguard-extra-flags.4823/) is an add-on to WorldGuard which adds more customizable flags, such as **allow-block-break** and **deny-block-break**. You can use these flags to further improve your SpleefX experience!

# Command aliasing plugins
Command aliasing can be handy especially for global-statistics commands. 

**Example case**:
> /spleef stats [player] global
>  
>  Aliased to: /stats [player]

# Citizens + CommandNPC
It is possible to use Citizens alongside with CommandNPC to create simple yet creative NPCs that execute commands. Such cases are:

* An NPC that when clicked, displays all available arenas in a GUI, by executing `/<mode> joingui`
* An NPC that when clicked, joins the player to the arena that is waiting but has the most players, by executing `/<mode> join`
* An NPC that when clicked, displays the player statistics, either global by executing `/spleef stats global`, or game-specific by executing `/<mode> stats`

# LuckPerms
LuckPerms is considered to be the best permission-handling plugin out there. While it is very recommended, any permissions plugin should be able to do the job.

Such useful permissions are:

 - **spleefx.<mode>.listarenas**: List all arenas for a specific mode
 - **spleefx.<mode>.stats.others**: Get statistics for other players
 - **spleefx.arena.command-exempt**: Bypass the disallowed commands check and execute any command while in-game
 - **spleefx.create_arena_sign**: Create signs for arenas
 - **spleefx.admin.messages**: Use the `/spleefx messages` command and edit messages

# Placeholder API
Placeholder API provides a united platform to access data from other plugins. Through the [SpleefX-PAPI](https://github.com/SpleefX/SpleefX-PAPI) expansion, it is possible to access player statistics through SpleefX and display them on other elements such as scoreboards.

See [this page](https://github.com/SpleefX/SpleefX/wiki/SpleefX-PAPI) for more information about integrating with PlaceholderAPI.