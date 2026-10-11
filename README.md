# CS3305 - Data Structures

Assignments for CS 3305 (Data Structures) at Kennesaw State University, Fall 2026. Coursework is assigned in Java, but
I'm reimplementing each assignment in multiple languages for learning purposes.

## What's here

- `java/`, `go/`, `rust/` - my work, one directory per language.
- `assignments/` - assignment sheets and starter files from Brightspace.
- `materials/` - course slides, handouts, and class works, organized by module.

See [COURSE_MATERIALS.md](COURSE_MATERIALS.md) for what was downloaded and what wasn't.

## Languages

- `java/`
- `go/`
- `rust/`

Each language directory has its own Nix flake (`flake.nix`) providing a
devshell for that language's toolchain:

```sh
cd <language>
nix develop
```
