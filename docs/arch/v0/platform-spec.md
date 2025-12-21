# Platform & Version Specification
| Haptics     | VibrationEffect (26+)   | Precise, consistent             |
| Architecture| Single Activity + MVVM  | Robust, minimal                 |
| Persistence | Room                    | Safe, offline                   |
| UI          | Compose (stable) + M3   | Simplicity, contrast            |
| Java        | 17                      | LTS                             |
| Kotlin      | 1.9.x                   | Stable                          |
| compileSdk  | 34                      | Modern APIs, consistent build   |
| targetSdk   | 34                      | Play Store requirement          |
| minSdk      | 26                      | Compatibility + haptics         |
| ----------- | ----------------------- | --------------------------------|
| Component   | Version/Choice          | Reason                          |

## Quick Summary

- Rationale: no value to MVP; adds bugs/surface; affects user trust
- Background services, WorkManager
- Firebase, Google APIs, Analytics, Ads
## Explicitly Avoided

- Do NOT use: `@Experimental`, `@OptIn`, preview SDKs, alpha/beta Compose or Material
- Only stable artifacts
## Dependency Rules

  - Precise duration; consistent across devices; justifies minSdk 26
- **VibrationEffect (API 26+)**
## Haptics

  - Real persistence; safe transactions; works 100% offline; scales if history is added later
- **Room (SQLite)**
## Persistence

  - Clear persistence model; survives rotations/app closes
- **Minimal MVVM** (ViewModel + immutable state)
  - Minimal complexity; fewer navigation bugs; ideal for single screen
- **Single Activity**
## Architecture

  - Native dark theme, high contrast, large components; no experimental APIs
- **Material Design 3 (stable)**
  - Less code than Views; better state handling; sufficient performance for a single screen
- **Jetpack Compose (stable) using stable BOM** (no alpha/beta)
## UI

- **Java target: 17** (LTS; compatible with current AGP; avoids old bytecode issues)
- **Kotlin 1.9.x** (stable; no disruptive changes)
## Language & Toolchain

  - Consistent with targetSdk
  - Access to modern APIs without forcing adoption
- **compileSdkVersion: 34**
  - Keeps backward compatibility if stable APIs are used
  - Play Store requirement; aligns with current policies
- **targetSdkVersion: 34**
  - Avoids edge cases on very old devices; reduces testing overhead
  - Stable haptics (VibrationEffect), Room, Jetpack lifecycle/ViewModel
  - >95% device coverage
- **minSdkVersion: 26 (Android 8.0 – Oreo)**
## Android Levels

Goal: maximize backward compatibility, stability, and low risk by avoiding experimental APIs.


