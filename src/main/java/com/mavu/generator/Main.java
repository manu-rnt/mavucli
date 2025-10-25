package com.mavu.generator;

import com.mavu.generator.cli.GeneratorCLI;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new GeneratorCLI()).execute(args);
        System.exit(exitCode);
    }
}