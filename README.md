![Docker](https://github.com/SpleefX/spleefx-web/workflows/Docker/badge.svg)
# SpleefX Web API
This repository represents the source code (and deployment) of the web API for SpleefX. Written in [SpringBoot](https://spring.io/) and [Kotlin](http://kotlinlang.org/), it allows to exchange data between an independent web API and the plugin for better user experience.

# Building
The web API uses SpringBoot, Kotlin and Gradle.

1. Clone the repository
```
git clone https://github.com/SpleefX/spleefx-web.git
```
2. Run `gradle build` (or `gradlew build` if you do not have Gradle installed) which will produce a fat JAR with all the dependencies
