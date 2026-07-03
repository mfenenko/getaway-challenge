# ROCK-SCISSORS-PAPER GAME

## 🛠️ Built With & Technologies

- **Build System:** Gradle 9.6
- **Language Runtime:** Java 25 (Target)
- **Ecosystem Frameworks & Plugins Applied:**
  - `JavaPlugin`
  - `ApplicationPlugin`

## 📦 Primary Dependencies

- `org.junit.jupiter:junit-jupiter:6.1.1`

## 🚀 Available Operational Commands

Run these commands from your root terminal using the Gradle Wrapper:

### 🔹 `./gradlew run`
Runs this project as a JVM application
Two users are created automatically: Mark and Olivia
By default they will play 100 games and results are printed in the console.
Custom amount of games can be specified by an application argument in the following way:
./gradlew run --args="7"

### 🔹 `./gradlew build`
Assembles and tests this project.

### 🔹 `./gradlew test`
Runs the unit tests.
