{
  description = "Flake for CS 3305 Data Structures - Rust";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";

    devshell = {
      url = "github:numtide/devshell";
      inputs.nixpkgs.follows = "nixpkgs";
    };
  };

  outputs =
    { nixpkgs, devshell, ... }:
    let
      systems = [
        "aarch64-darwin"
        "aarch64-linux"
        "x86_64-darwin"
        "x86_64-linux"
      ];

      eachSystem =
        f:
        nixpkgs.lib.genAttrs systems (
          system:
          f {
            inherit system;
            pkgs = nixpkgs.legacyPackages.${system};
          }
        );
    in
    {
      devShells = eachSystem (
        { pkgs, system, ... }:
        {
          default = (devshell.legacyPackages.${system}.mkShell) {
            name = "Data_Structures";

            packages = [
              pkgs.cargo
              pkgs.rustc
              pkgs.rust-analyzer
              pkgs.clippy
              pkgs.rustfmt
            ];

            commands = [
              {
                name = "run";
                category = "app";
                help = "Run the current Cargo project";
                command = "cargo run -- \"$@\"";
              }
              {
                name = "build";
                category = "app";
                help = "Build the current Cargo project";
                command = "cargo build";
              }
              {
                name = "clean";
                category = "app";
                help = "Remove build artifacts";
                command = "cargo clean";
              }
              {
                name = "fmt";
                category = "quality";
                help = "Format Rust sources";
                command = "cargo fmt";
              }
              {
                name = "test";
                category = "quality";
                help = "Run tests";
                command = "cargo test";
              }
            ];
          };
        }
      );

      formatter = eachSystem ({ pkgs, ... }: pkgs.nixfmt);
    };
}
