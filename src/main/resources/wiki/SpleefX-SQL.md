# This has been discounted! SQL support has been added natively to SpleefX.

>
> **Page Index**:
> 1. [What is SpleefX-SQL](SpleefX-SQL#what-is-spleefx-sql)
> 2. [When to use SpleefX-SQL](SpleefX-SQL#when-to-use-spleefx-sql)
> 3. [Get SpleefX-SQL](SpleefX-SQL#get-spleefx-sql)
> 4. [Why two separate files](SpleefX-SQL#why-two-separate-files)
> 5. [Contribute to SpleefX-SQL](SpleefX-SQL#contribute-to-spleefx-sql)
---

# What is SpleefX-SQL
**SpleefX-SQL** is a basic Bukkit plugin which represents the SQL add-on for **SpleefX**. SpleefX-SQL extends the storage functionality in SpleefX to support **SQLite**. More database platforms may be supported in the future.

# When to use SpleefX-SQL
SpleefX-SQL, by default, is not required for SpleefX to function. However, it is required when the plugin is told to use SQLite.

To enable the SQLite feature in SpleefX, you must change the **StorageType** value in **PlayerGameStatistics** to `SQLITE`:
```yml
# The player's game statistics  
PlayerGameStatistics:  
  StorageType: "SQLITE"
```
# Get SpleefX-SQL
**Source code**: [https://github.com/SpleefX/SpleefX-SQL/](https://github.com/SpleefX/SpleefX-SQL/)

**Releases**: [https://github.com/SpleefX/SpleefX-SQL/releases/](https://github.com/SpleefX/SpleefX-SQL/releases/)

**Download latest**: 
[https://github.com/SpleefX/SpleefX-SQL/releases/latest](https://github.com/SpleefX/SpleefX-SQL/releases/latest)

# Why two separate files?

 - **Database support**: Allows adding support for other types of databases without difficulty, to both the user and the developer.
 - **Size**: The large size of libraries and frameworks *(~7MB)* required for SQLite
 - **Demand**: Due to low number of people who would use this feature
 - **Performance**: SpleefX-SQL uses [HikariCP](https://github.com/brettwooldridge/HikariCP) to queue SQL operations, and due to the size of HikariCP *(~2MB)*.
 - **Open Source and Transparency**: Having separated JARs means separated code. Since this is a tiny part of SpleefX, this allows us to provide as much transparency as possible by making it open source. Had SpleefX-SQL been inside SpleefX, SpleefX-SQL would not have been open-sourced.

# Contribute to SpleefX-SQL
If you would like to contribute to SpleefX-SQL, in order to fix a bug, or add support for a new database, or simply improve performance, feel free to [open a pull request](https://github.com/SpleefX/SpleefX-SQL/compare) with your changes, and they will get looked at as soon as possible.

**Please make sure your code meets the following**:
-   Code cleanliness, readability and format
-   Appropriate JavaDocs
-   Warning-free code
-   Thread-safe implementation
-   Generally abiding by Java's good practices and avoiding bad practices.