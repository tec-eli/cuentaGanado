# User Flow: Persistence and Continuity

This document describes the flow for state persistence and continuity in the Cattle Counter application.

## Steps
1. If the app is closed, the state remains saved.
2. On reopening, counters display the last saved values.

## Boundaries
- Counters can never be negative.
- No network, GPS, or special permissions required.
- No animations, loading screens, or blocking dialogs.

## Out-of-Scope
- No history, export, user accounts, or categories.

