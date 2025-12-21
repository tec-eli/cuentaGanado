# ADR-003: UI and User Experience

## Status
Accepted

## Context
The app is used in the field, often without looking at the screen. UI must be extremely simple, fast, and accessible.

## Decision
- Single screen, no navigation
- Large, well-separated buttons for all actions
- Immediate feedback (haptic vibration)
- Minimal confirmation for reset (long press or double tap)
- Dark/high-contrast theme, large text
- Material Design 3 (stable) with Jetpack Compose (stable BOM)

## Consequences
- Users can operate the app by touch alone
- No distractions or unnecessary UI elements
- Accessibility and speed are maximized
- Stable theming and components without experimental APIs
