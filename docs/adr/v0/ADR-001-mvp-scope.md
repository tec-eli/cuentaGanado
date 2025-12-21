# ADR-001: MVP 0 Scope and Exclusions

## Status
Accepted

## Context
The goal is to deliver a minimal, reliable, and fast cattle counting app for field use. Any feature that is not strictly necessary for real-time counting is excluded from MVP 0.

## Decision
- Only the following features are included:
  - Single screen with male/female/total counters
  - Large, accessible buttons for increment/decrement/reset
  - Haptic feedback for button actions
  - Local persistence (auto-save, restore on restart)
  - Dark/high-contrast theme, large text, offline support
- Explicitly excluded: login, history, export, sync, categories, notes, etc.

## Consequences
- MVP is extremely focused and quick to develop
- No user management or data export until future versions
- Simplicity and reliability are prioritized over feature set

