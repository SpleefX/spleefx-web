This page will include information on troubleshooting the plugin, dealing with common errors and understanding messages presented by the plugin itself.

> **Page Index**:
> 1. [No enum constant org.bukkit.Sound.BLOCK_LEVER_CLICK](https://github.com/SpleefX/SpleefX/wiki/Troubleshooting#no-enum-constant-orgbukkitsoundblock_lever_click)
> 2. [java.lang.BootstrapMethodError: java.lang.NoSuchMethodError: org/bukkit/scheduler/BukkitTask.isCancelled()Z](https://github.com/SpleefX/SpleefX/wiki/Troubleshooting#javalangbootstrapmethoderror-javalangnosuchmethoderror-orgbukkitschedulerbukkittaskiscancelledz)
> 3. ["No sign definition in arena XXX"](https://github.com/SpleefX/SpleefX/wiki/Troubleshooting#no-sign-definition-in-arena-xxx)
> 4. ["Failed to load arena XXX: ..."](https://github.com/SpleefX/SpleefX/wiki/Troubleshooting#failed-to-load-arena-xxx-)
> 5. ["Failed to register arena type" (multiple causes)](https://github.com/SpleefX/SpleefX/wiki/Troubleshooting#failed-to-register-arena-type-multiple-causes)
> 6. ["Unsupported server protocol (1.X)"](https://github.com/SpleefX/SpleefX/wiki/Troubleshooting#unsupported-server-protocol-1x)
> 7. [Material cannot be null / No enum constant org.bukkit.Material.XXX](https://github.com/SpleefX/SpleefX/wiki/Troubleshooting#material-cannot-be-null--no-enum-constant-orgbukkitmaterialxxx)

## No enum constant org.bukkit.Sound.BLOCK_LEVER_CLICK
Assuming you are using 1.8-1.8.8, this error appears when the plugin attempts to load the following value from the `config.yml`:
```yml
Countdown:
  PlaySoundOnEachBroadcast:
    Sound: "BLOCK_LEVER_CLICK"
```
**Problem**: The error appears because it cannot find `BLOCK_LEVER_CLICK`. This is due to the major changing from 1.8 to 1.9, which also changed sounds.

**Fix**: Change the sound to `CLICK` if you want that same sound, or use any other sound from [here](https://helpch.at/docs/1.8.8/org/bukkit/Sound.html).

## java.lang.BootstrapMethodError: java.lang.NoSuchMethodError: org/bukkit/scheduler/BukkitTask.isCancelled()Z

**Problem**: Your Java version is 7 or below.

**Fix**: Update your Java version to be at least Java 8

## "No sign definition in arena XXX"
**Problem**: An arena is using a custom extension which does not exist.

**Fix**: Go to *arenas.json* and change the `extension` key of the arena to be a valid one, or remove the arena

## "Failed to load arena XXX: ..."

**cannot deserialize class io.github.spleefx.arena.api.GameArena subtype named XXX; did you forget to register a subtype?**: 
   - **Problem**: The arena's mode type is invalid, as in, the arena uses an invalid GameArena class
   - **Fix**: Either change it to be a valid one, or register your GameArena subclass in `/plugins/SpleefX/arenas/arena-types.yml`.

## "Failed to register arena type" (multiple causes)
- **"Class not found: XXX"**: 
   - **Problem**: A class in `arena-types.yml` cannot be found
   - **Fix**: Ensure that the class and package name are written correctly
- **Class does not extend GameArena: XXX**:
   - **Problem**: The class in `arena-types.yml` is not a subclass of `io.github.spleefx.arena.api.GameArena`.
   - **Fix**: Make it extend `GameArena`.

## "Unsupported server protocol (1.X)"
**Problem**: Your server is running a server version below 1.8, for example 1.7.10.

**Fix**: Update your server to be at least 1.8.

## Material cannot be null / No enum constant org.bukkit.Material.XXX
**Problem**: In one (or more) extension(s), there is an invalid material `type` (mostly in items formats).
* **Common Problem**: If you get this problem when you install the plugin for the first time, while running a 1.13+ Minecraft server
* **Fix**: Go to **/plugins/SpleefX/extensions/standard/spleef.json**, and replace `DIAMOND_SPADE` with `DIAMOND_SHOVEL`

**Fix**:  Use the appropriate material name.
* **[1.8-1.12.2](https://helpch.at/docs/1.12.2/index.html?org/bukkit/Material.html)**
* **[1.13+](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html)**