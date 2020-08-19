There are 2 ways to edit plugin messages:

* **The messages GUI**: A GUI that is displayed with the ability to view and edit each message easily.

![Messages GUI](https://i.imgur.com/cRPqUEg.png)

* **`messages.json`**: A JSON file where all messages are saved and referenced to. Although it is not recommended and cannot be edited while the server is running.

**Note**: It is possible to stop a specific message from being sent, by setting its text to `{}`.

**Note 2**: The plugin will apply PlaceholderAPI placeholders if PlaceholderAPI is present.

# Message placeholders
### Arena
| Placeholder | Replacement |
|--|--|
| {arena} | The arena key |
| {arena_displayname} | The arena's display name |
| {arena_playercount} | The amount of players in this arena |
| {arena_alive} | The amount of players alive in this arena |
| {arena_maximum} | The maximum amount of players in this arena |
| {arena_stage} | The arena's stage. See [arena components](https://github.com/SpleefX/SpleefX/wiki/What-is-an-arena?#components). |
| {arena_time_left} | The arena time left. If the arena is not active, it will be the arena's time |

### Team
| Placeholder | Replacement |
|--|--|
| {team} | The team's chat value (e.g "§cRed") |
| {team_color} | The team's chat color, e.g "§2". |

### Location
| Placeholder | Replacement |
|--|--|
| {x} | The X position (with only the full number) |
| {y} | The Y position (with only the full number) |
| {z} | The Z position (with only the full number) |

### Player
| Placeholder | Replacement |
|--|--|
| {player} | The player's name |

### Command
| Placeholder | Replacement |
|--|--|
| {command} | The command name |

### Countdown
| Placeholder | Replacement |
|--|--|
| {countdown} | The countdown string/value |
| {plural} | Adds "s" if the countdown is not 1, otherwise becomes an empty string |

### Extension
| Placeholder | Replacement |
|--|--|
| {extension} | The extension's display name |
| {extension_key} | The extension's key |
| {extension_chat_prefix} | The extension's chat prefix |