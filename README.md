# [![Buy Me a Coffee](https://i.imgur.com/rlatSuk.png)](https://www.buymeacoffee.com/galmitrani1)

# Discord Webhook Tester

## Introduction

**Discord Webhook Tester** is a modern, JavaFX-based desktop utility that allows developers to test and validate Discord Webhook URLs. Built with a stylish dark mode interface and real-time HTTP feedback, the tool supports both silent pinging and rich embedded messages — making it ideal for bot developers, moderators, and API testers.

---

## Features

### 🔗 Webhook Validation
- **Live Status Check** — Sends a real HTTP POST to validate your webhook.
- **Silent Mode** — Option to send a non-visible empty payload.
- **Success/Error Feedback** — Displays `204` for success or styled error messages.

### 💬 Embedded Message Sender
- **Optional Embed** — Toggle a checkbox to include a styled embedded message.
- **Timestamped & Colored** — Adds author, thumbnail, status field, and more using JSON.

### 🎨 UI and UX
- **Dark Mode** — Custom CSS-powered JavaFX interface.
- **Styled Inputs** — Styled text fields, rounded buttons, and animated glow header.
- **Checkbox with Theme** — Custom hover and check styles.
- **Dynamic Result Styling** — TextField color changes based on response.
- **Clickable Icons** — GitHub and LinkedIn logos open in the browser.

---

## Included Project Files

- ✅ `DiscordApiTester.fxml` – UI layout definition.
- ✅ `DiscordApiTesterController.java` – Main controller logic.
- ✅ `style.css` – Themed stylesheet.
- ✅ `ApitesterApp.java` – JavaFX launcher class.
- ✅ `Discord_Webhook_Tester.jar` – Runnable project jar file.
- ✅ `README.md` – You’re reading it.

---

## Prerequisites

1. **JDK 17+**
2. **JavaFX SDK** — Add JavaFX modules to VM args.
3. **Gson Library** — Include `gson.jar` or manage with Maven/Gradle.

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Tapuz97/Discord-webhook-tester.git
   ```

2. Import into your Java IDE.

3. Ensure JavaFX and Gson are included in the classpath.

4. Run:
   ```bash
   java -jar Discord_Webhook_Tester.jar
   ```

---

## License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

---

## Author

**Gal Mitrani**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-galmitrani1-blue?logo=linkedin)](https://www.linkedin.com/in/galmitrani1/)  
[![GitHub](https://img.shields.io/badge/GitHub-Tapuz97-181717?logo=github)](https://github.com/Tapuz97)