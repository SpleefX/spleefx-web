
>**Page Index**:
> 1. [Definition](https://github.com/SpleefX/SpleefX/wiki/What-is-an-arena%3F#definition)
> 2. [Components](https://github.com/SpleefX/SpleefX/wiki/What-is-an-arena%3F#components)
> 3. [Arena storage](https://github.com/SpleefX/SpleefX/wiki/What-is-an-arena%3F#arena-storage)
> 4. [Arena placeholders](https://github.com/SpleefX/SpleefX/wiki/What-is-an-arena%3F#arena-placeholders)
---
# Definition
**Arena (əˈrēnə)** *(noun)*: A level area surrounded by seats for spectators, in which sports, entertainments, and other public events are held.

**Arena in SpleefX**: A place with blocks, has spawn-points and basic game rules, and is maintained by the plugin according to how it is configured.

# Components
A basic SpleefX arena consists of:

 - **Region**: Represents the place in which the arena runs, and where the players compete against each other
 - **Key**: Represents the special and unique identifier for the arena. The key is used by commands to refer to the arena, and is used by the plugin to store files for the arena.
 - **Stage**: Represents the current state the arena is. Can be either:
   - **Requires setup**: The arena is not fully setup. Appears when:
      - the arena's team count is less than 2 (in case of teams mode)
      - the arena's minimum player count is less than 2 (in FFA mode).
      - not all spawn-points are defined.
   - **Waiting**: The arena is waiting for players to join
   - **Countdown**: The arena is in countdown. Players are allowed to join as long as the arena is not full
   - **Active**: The arena is currently active and occupied
   - **Regenerating**: The arena is regenerating to its original structure. Regenerating is an extremely quick process hence this stage is rarely spotted.
   - **Disabled**: The arena and/or the extension is/are disabled.
 - **Display name**: Represents the way the arena is displayed. Used in:
     * Signs
     * GUIs
     * Commands
- **Spawn-points**: Represent where each player or team should spawn when the game starts. Spawn-points are also used if no lobby is set.
- **Extension**: Represents where the arena derives all its settings from. Extensions define things such as:
   - Chat prefix
   - Commands to run when a player wins
   - Items to add to the inventory
   - Titles displayed in the game (winning, draws, losses, etc.)
   - Signs and how they are texted
   - Cancelled damage in the game (e.g: cancels PvP)
   - Allowed commands that can be run in the game.
- **Number definitions**: Numbers control a very important aspect in the arena. Such numbers are:
  - **Death level**: The Y axis in which if a player reaches, they lose
  - **Game time**: The time in which a game can run into. If the game does not end in the specified game time, it will result in a draw. Defined in **minutes**.
  - **Minimum player count**: The minimum players required for the game to start. Must be at least 2.
  - **Maximum player count**: The maximum amount of players allowed to join the game. This number is defined as:
	  - **In FFA modes**: The maximum amount specified in the GUI
	  - **In Teams mode**: The amount of members each team can have, *multiplied* by the count of teams.
  - **Members per team (Teams only)**: How many people are allowed in each team
- **Lobby (optional)**: Represents the location where players are teleported when they join the arena.
- **Signs (optional)**: Signs which, if clicked, make the player join the arena. Once written, signs are automatically updated using the sign design defined by the extension. To make a sign, write:
  - `[Spleef]` *(see note below)*
  - **<arena key>**

\* `[Spleef]` is consistent for all extensions, and will be updated by the extension's sign design defined in the extension's JSON file.

# Arena storage

**Arenas folder**: /plugins/SpleefX/arenas/
 * **Arena data**: Stored inside **arenas.json** in the arenas folder
 * **Arena schematic**: Stored as an MCEdit schematic file. Each arena has its schematic defined as `<arena key>.schem`. All schematics are saved inside the arenas folder.

### arenas.json
**arenas.json** is a file that stores all the arenas and their configurations and settings.

A basic arena storage is:

| Key | Description |
|--|--|
| type | The arena's general type. Can be either: **SPLEEF**, **SPLEGG**, **BOW_SPLEEF** or **CUSTOM** for arenas with custom extensions |
| ffaSettings | The settings for the arena's FFA managing. If the arena is not FFA, this will be null|
| enabled | Whether is the arena enabled or not |
| key | The arena key. See above for details |
| displayName | The arena's display name. See above for details |
| arenaType | The type of the arena. Can be either **FREE_FOR_ALL** or **TEAMS**. |
| regenerationPoint | The reference point in which the arena is regenerated from.|
| signs | The signs that refer to this arena |
| teams | The arena teams. If the arena is **FFA**, it will only contain 1 team, however if **teams** it will contain the arena's teams |
| spawnpoints | The spawn-points of the teams or players. See above for details|
| membersPerTeam | The amount of members each team can have. See above for details|
| gameTime | The time the game is allowed to run for. See above for details|
| deathLevel | The Y level which if a player reaches they lose. See above for details |
| minimum | The minimum player count required. See above for details |
| maxPlayerCount | See above for details |
| dropMinedBlocks | Whether should mined or destroyed blocks have their drops dropped. |
| lobby | The arena's lobby. `null` if no lobby is defined. |

# Arena placeholders

| Placeholder | Description |
|--|--|
| {arena} | The arena key |
| {arena_displayname} | The arena display name |
| {arena_playercount} | The current amount of players in the arena |
| {arena_maximum} | The maximum amount of players that can be in the arena |
| {arena_stage} | The arena's current stage |
