{
  description = "Flake for CS 3305 Data Structures - Go";

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
              pkgs.go
              pkgs.gopls
            ];

            commands = [
              {
                name = "run";
                category = "app";
                help = "Run the current Go module";
                command = "go run . \"$@\"";
              }
              {
                name = "build";
                category = "app";
                help = "Build the current Go module";
                command = "go build ./...";
              }
              {
                name = "clean";
                category = "app";
                help = "Remove build artifacts";
                command = "go clean ./...";
              }
              {
                name = "fmt";
                category = "quality";
                help = "Format Go sources";
                command = "gofmt -l -w .";
              }
              {
                name = "test";
                category = "quality";
                help = "Run tests";
                command = "go test ./...";
              }
            ];
          };
        }
      );

      formatter = eachSystem ({ pkgs, ... }: pkgs.nixfmt);
    };
}
