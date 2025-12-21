# User Flow: Resetting All Counters

This document describes the flow for resetting all counters in the Cattle Counter application.

## Steps
1. User performs a long press or double tap on the `Reset` button.
2. Minimal confirmation is shown (visual cue or delay).
3. Both counters and the total are set to zero.
4. Long vibration feedback.
5. State is saved automatically.

## Boundaries
- Counters can never be negative.
- No network, GPS, or special permissions required.
- No animations, loading screens, or blocking dialogs.

## Out-of-Scope
- No history, export, user accounts, or categories.

