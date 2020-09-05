This page will cover how to control extensions using commands. [Don't know what an extension is?](Understand-extensions)

> **Page Index**:
> 1. [Load an extension](Extension-commands#load-an-extension)
> 2. [Reload an extension](Extension-commands#reload-an-extension)
> 3. [Enable/Disable an extension](Extension-commands#enabledisable-an-extension)
---

# Load an extension
To load an extension, make sure it:

 1. Has its file name the same as its key. For example, if the extension key is `flap`, the file name **has** to be `flap.json`
 2. It is in the custom extensions directory. As in:
 > /plugins/SpleefX/extensions/custom/
 3. No other extension with the same key exists.

After ensuring the above requirements, you can load the extension using the following command:
> /spleefx extension load <extension key>
>
> Example: /spleefx extension load flap

# Reload an extension
Reloading an extension means to update the extension's settings without having to restart the server.

To reload an extension, run the following command:
> /spleefx extension reload <extension key> [extension type, default "custom"]
> 
> Examples:
> * Standard extension: /spleefx extension reload splegg standard
> * Custom extension: /spleefx extension reload flap

# Enable/Disable an extension
To enable or disable an extension, for reasons such as maintenance, run the following command:

### Enabling
> /spleefx extension enable <extension key>

### Disabling
> /spleefx extension disable <extension key>

Note: Disabling an extension has no "special" effect at all, except that it will disallow players from joining any arenas that use this extension, as it will indicate that the arena is disabled.