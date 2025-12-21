# User Flow: Correcting a Count (Decrement)

This document describes the flow for decrementing the male and female cattle counters in the Cattle Counter application.

## Steps
1. If a mistake is made, user taps `− Male` or `− Female`.
2. The selected counter decreases by 1 (never below zero), and the total is updated.
3. Short vibration feedback.
4. State is saved automatically.

## Boundaries
- Counters can never be negative.
- No network, GPS, or special permissions required.
- No animations, loading screens, or blocking dialogs.

## Out-of-Scope
- No history, export, user accounts, or categories.

