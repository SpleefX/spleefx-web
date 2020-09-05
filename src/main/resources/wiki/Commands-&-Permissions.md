This page contains each command with its corresponding permission.

> **Page index:**
> 1. [Admin commands](Commands-&-Permissions#admin-commands)
> 2. [Arena commands](Commands-&-Permissions#arena-commands)
> 3. [Game commands](Commands-&-Permissions#game-commands)
> 4. [Others](Commands-&-Permissions#others)
--- 
#### **Bracketology**
 - Text in **angled brackets <>** means the parameter is required
 - Text in **squared brackets []** means the parameter is optional
 - Text in **parenthesis ()** means literal text

# Admin commands
| Command | Description | Usage | Permission | Default |
|--|--|--|--|--|
| /spleefx reload | Reload a specific element | /spleefx reload [element] | spleefx.admin.reload | false|
| /spleefx messages | Display the messages GUI | /spleefx messages | spleefx.admin.messages | false|
| /spleefx extension | Enable/Disable/Load/Reload extensions | /spleefx extension <enable/disable/load/reload> <extension key> [type] |  spleefx.admin.extensions | false

# Arena commands
* These are sub-commands of the command `/<mode> arena`, and are not standalone commands.
* Global permission: spleefx.arena.<mode type>
    * for spleef, mode type would be `spleef`
    * for splegg, mode type would be `splegg`
    * for bow spleef, mode type would be `bow_spleef`
    * for arenas with custom extensions, would would be `custom`

| Command | Description | Usage | Permission | Default |
|--|--|--|--|--|
| create | Create a new arena | create <key> (ffa/teams) <display name...> | See above | false |
| remove | Remove a specific arena | remove <key> | See above | false |
| spawnpoint | Set the spawnpoint for a team or slot  | spawnpoint <key> <team/slot> | See above | false |
| settings | Display the settings GUI or edit a specific value | settings [value key] \[new value] | See above | false |
| lobby | Set the arena's lobby | lobby <key>| See above | false |
| removelobby | Remove the arena's lobby | remove <key> | See above | false |
| regenerate | Regenerate the arena | regenerate <key> |  See above | false |

# Game commands
* These are sub-commands to the extension command, as in, these commands are followed after `/<mode>`, for example, `/spleef join`

| Command | Description | Usage | Permission | Default |
|--|--|--|--|--|
| listarenas | List all arenas for a specific mode | listarenas | spleefx.<mode>.listarenas | true |
| join | Join a specific or random arena | join [arena] |spleefx.<mode>.join  | true |
| joingui | Display the [join GUI](Join-GUI) | joingui | spleefx.<mode>.joingui | true |
| leave | Leave your current arena | leave | spleefx.<mode>.leave | true |

# Others
| Command | Description | Usage | Permission | Default |
|--|--|--|--|--|
| help | Get a list of all available commands, or help for a specific command | /<mode> help [sub-command] | spleefx.<mode>.help | true |
| stats | Display the [statistics GUI](Statistics-GUI) for yourself/another player | stats [player] \[(global)] | **Self**: spleefx.<mode>.stats **Other**: spleefx.<mode>.stats.others | **Self**: true **Other**: false |