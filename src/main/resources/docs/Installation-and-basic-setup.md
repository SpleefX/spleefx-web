> **Page Index**:
> 1. [Prerequisites](https://github.com/SpleefX/SpleefX/wiki/Installation-and-basic-setup#prerequisites)
> 2. [Installation](https://github.com/SpleefX/SpleefX/wiki/Installation-and-basic-setup#installation)
> 3. [Plugin files](https://github.com/SpleefX/SpleefX/wiki/Installation-and-basic-setup#plugin-files)
---

# Prerequisites:

- Java 8 or higher. **The plugin uses a lot of features which were introduced in Java 8, including lambdas, Streams API and functional interfaces!**
 - WorldEdit (or any of its forks, such as FastAsyncWorldEdit or AsyncWorldEdit.)
 - Bukkit, Spigot, PaperSpigot, or any of their forks which support the minimal Bukkit API. **It's always recommended to use PaperSpigot to make the most out of both your server AND SpleefX!**

 - Minecraft version ranging from **1.8** to **1.16+**. Any versions older than 1.8 are *not supported!*
    *  Any version newer than **1.16+**, unless officially announced to be supported, may **or** may not work.

# Installation
 1. Download the appropriate version of WorldEdit (or its forks). **WorldEdit is required for the plugin to function!**
    * If WorldEdit is not found, SpleefX will print the appropriate version for your server, then it will be disabled.

 2.  Download the latest version of SpleefX and drop it in **<your server's workspace>/plugins/**
 3. Restart your server in order to get the plugin to load. This will also allow the default file configuration(s) to be generated.

# Plugin files
| Operation | config.yml | messages.json | statistics-gui.json | join-gui.json | arenas.json
|--|--|--|--|--|--|
| **Reloading** | Supported | Supported | Supported | Supported | Possible, but not recommended
| **Editing at runtime** | Supported | Unsupported from file, supported through in-game GUI| Supported | Supported |  Possible, but not recommended
|**Commands**| /spleefx reload | /spleefx messages | /spleefx reload statsFile | /spleefx reload joinGuiFile | /spleefx reload arenas*

\* This command requires confirmation, and any issues that resulted from it can be resolved simply by restarting.
