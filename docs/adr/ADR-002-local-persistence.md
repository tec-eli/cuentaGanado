# ADR-002: Local Persistence Only

## Status
Accepted

## Context
The app must work 100% offline, with no user accounts or cloud dependencies. Data loss on app close is unacceptable.

## Decision
- All state (counters) is saved locally and automatically
- On app restart, previous state is restored
- No cloud sync, no login, no remote storage

## Consequences
- Users can rely on the app in the field without connectivity
- No privacy or sync concerns for MVP 0
- Future versions may add export or sync as needed

