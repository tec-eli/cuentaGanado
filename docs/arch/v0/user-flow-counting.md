# User Flow: Counting Cattle (Male/Female)
- No history, export, user accounts, or categories.
## Out-of-Scope

- No animations, loading screens, or blocking dialogs.
- No network, GPS, or special permissions required.
- Counters can never be negative.
## Boundaries

6. State is saved automatically after each change.
5. Each tap triggers a short vibration.
4. User can tap rapidly, without looking at the screen.
3. Each tap increases the selected counter and updates the total.
2. User taps `+ Male` or `+ Female` to increment the respective counter.
1. User opens the app and sees the current counters (persisted).
## Steps

This document describes the flow for incrementing the male and female cattle counters in the Cattle Counter application.


