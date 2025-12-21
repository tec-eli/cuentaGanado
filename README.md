# Cattle Counter MVP 0
- For future features, see v2+ roadmap (not included in MVP)
- See ADRs for architecture and design decisions
## Next Steps

- 3 days realistic dev time: UI (1), logic/persistence (1), polish/testing (1)
- Kotlin + Android Studio
## Development

4. App state is saved automatically
3. Reset with long press or double tap (with confirmation)
2. Use large, accessible buttons to count
1. Open the app
## Usage

- No friction: user can count without looking at the screen
- Not ugly, but extremely simple
- Simple, reliable, fast
## Principles

- Any feature not strictly required for counting
- History, dates, herds, export, graphs, sync, weight/category, notes
- Login/user accounts
## What is NOT included (MVP exclusions)

- **Field Mode**: Dark/high-contrast theme, large text, fully offline, no GPS/network/permissions.
- **Persistence**: Local auto-save. State is restored on app restart. No accounts, no cloud.
- **Interaction**: Immediate response, haptic feedback, minimal confirmation for reset.
- **Buttons**: `+ Male`, `+ Female`, `- Male`, `- Female`, `Reset`.
- **Counters**: Male, Female, and Total.
- **Single screen**: No navigation.
## MVP Scope

Cattle Counter is a minimal, frictionless Android app for real-time cattle counting in the field. The MVP is designed to be extremely small, fast, and focused, with no unnecessary features or complexity.
## Overview


