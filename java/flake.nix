{
  description = "Flake for CS 3305 Data Structures - Java";

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
              pkgs.jdk21
              pkgs.maven
            ];

            commands = [
              {
                name = "jrun";
                category = "app";
                help = "Compile and run Main.java";
                command = "javac Main.java && java Main \"$@\"";
              }
              {
                name = "build";
                category = "app";
                help = "Compile all Java sources in the current directory";
                command = "javac *.java";
              }
              {
                name = "clean";
                category = "app";
                help = "Remove compiled .class files";
                command = "rm -f *.class";
              }
              {
                name = "fmt";
                category = "quality";
                help = "Check formatting (requires a formatter plugin if desired)";
                command = "echo 'No formatter configured yet'";
              }
              {
                name = "test";
                category = "quality";
                help = "Run tests with Maven";
                command = "mvn test";
              }
            ];
          };
        }
      );

      formatter = eachSystem ({ pkgs, ... }: pkgs.nixfmt);
    };
}
