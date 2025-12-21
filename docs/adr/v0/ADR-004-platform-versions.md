# ADR-004: Platform Versions and Stack

## Status
Accepted

## Context
We need maximum backward compatibility, stability, and low risk, while meeting Play Store requirements. Experimental APIs and unstable dependencies are excluded.

## Decision
- Android levels: minSdk 26, targetSdk 34, compileSdk 34
- Languages/toolchain: Kotlin 1.9.x (stable), Java target 17 (LTS)
- UI: Jetpack Compose (stable BOM), Material Design 3 (stable)
- Architecture: Single Activity, minimal MVVM (ViewModel + immutable state)
- Persistence: Room (SQLite)
- Haptics: VibrationEffect (API 26+)
- Dependency rules: stable only; no `@Experimental`, `@OptIn`, preview SDKs, or alpha/beta Compose/Material
- Avoided: Firebase, Google APIs, Analytics, Ads, background services, WorkManager

## Consequences
- Broad device coverage (>95%), stable haptics and Jetpack support
- Meets Play Store policy with target/compile 34 while remaining backward compatible
- Minimal complexity (single activity, MVVM) for a single-screen app
- Offline-first with reliable persistence via Room
- Reduced risk by excluding experimental/preview artifacts and non-essential services
- Clear path to evolve (e.g., history/export later) without changing the base stack

## References
- See `docs/arch/v0/platform-spec.md` for detailed rationale and summary table.

