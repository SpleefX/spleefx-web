> **Page Index**:
> 1. [What is SpleefX-PAPI](https://github.com/SpleefX/SpleefX/wiki/SpleefX-PAPI#what-is-spleefx-papi)
> 2. [Prerequisites](https://github.com/SpleefX/SpleefX/wiki/SpleefX-PAPI#prerequisites)
> 3. [Get SpleefX-PAPI](https://github.com/SpleefX/SpleefX/wiki/SpleefX-PAPI#get-spleefx-papi)
> 4. [List of SpleefX placeholders
](https://github.com/SpleefX/SpleefX/wiki/SpleefX-PAPI#list-of-spleefx-placeholders)
---

# What is SpleefX-PAPI?
**SpleefX-PAPI** is a [PlaceholderAPI expansion](https://placeholderapi.com) which allows easy data access to SpleefX game statistics (such as the games played, wins, blocks mined, etc.)

# Prerequisites
* **Minecraft 1.8 or higher**
* **SpleefX** to fetch data from
* **Java 8 or higher**
* [**PlaceholderAPI**](https://placeholderapi.com)

# Get SpleefX-PAPI
**Source code**: https://github.com/SpleefX/SpleefX-PAPI

**Releases**: https://github.com/SpleefX/SpleefX-PAPI/releases

**Download latest**: https://github.com/SpleefX/SpleefX-PAPI/releases/latest

# List of SpleefX placeholders

## Global statistics
**General placeholder naming convention**: %spleefx_<statistic>%

| Placeholder | Description |
| -- | -- |
| **%spleefx_games_played%** | The total games played by the player |
| **%spleefx_wins%** | The total games won |
| **%spleefx_losses%** | The total games lost |
| **%spleefx_draws%** | The total draws |
| **%spleefx_blocks_mined%** | The total blocks mined by the player. *This will include blocks destroyed by splegg projectiles*. |

**Note**: Any unknown placeholder (e.g %spleefx_doot%) will default in `0` being returned.

## Mode-specific statistics
**General placeholder naming convention**: %spleefx_<statistic>_<mode>%

**Example**: *%spleefx_wins_splegg%* will return the wins only in the splegg mode.

| Placeholder | Description |
|--|--|
| **%spleefx_games_played_<mode>%** | The games played by the player in this mode. |
| **%spleefx_wins_<mode>%** | The games won in this mode |
| **%spleefx_losses_<mode>%** | The games lost in this mode |
| **%spleefx_draws_<mode>%** | The draws in this mode |
| **%spleefx_blocks_mined_<mode>%** | The blocks mined by the player in this mode. *In case of splegg, this will represent the amount of blocks destroyed by the player's projectiles.* |