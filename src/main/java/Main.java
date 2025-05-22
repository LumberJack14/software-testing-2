import math.BaseFunctions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static math.TargetSystem.calculate;
import static math.BaseFunctions.*;

public class Main {

    private static BaseFunctions baseF = new BaseFunctions();
    public static void main(String[] args) {
        makeDong(args);
    }

    private static void makeDong(String[] args) {
        if (args.length < 5) {
            help();
            return;
        }

        try {
            String function = args[0];
            double start = Double.parseDouble(args[1]);
            double end = Double.parseDouble(args[2]);
            double step = Double.parseDouble(args[3]);
            String path = args[4];
            String del = args.length > 5 ? args[5] : ",";
            generateCSV(function, start, end, step, path, del);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please check your input.");
            help();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void generateCSV(String functionName, double start, double end, double step, String filePath, String delimiter) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            StringBuilder sb = new StringBuilder();
            sb.append("x").append(delimiter).append("y\n");

            for (double x = start; x <= end; x += step) {
                double y = 0;
                try {
                    switch (functionName) {
                        case "sin":
                            y = baseF.sin(x);
                            break;
                        case "cos":
                            y = baseF.cos(x);
                            break;
                        case "sec":
                            y = baseF.sec(x);
                            break;
                        case "csc":
                            y = baseF.csc(x);
                            break;
                        case "ln":
                            y = baseF.ln(x);
                            break;
                        case "log2":
                            y = baseF.log(2, x);
                            break;
                        case "log3":
                            y = baseF.log(3, x);
                            break;
                        case "log5":
                            y = baseF.log(5, x);
                            break;
                        case "log10":
                            y = baseF.log(10, x);
                            break;
                        case "target":
                            y = calculate(x);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown function: " + functionName);
                    }
                    sb.append(x).append(delimiter).append(y).append("\n");
                } catch (Exception e) {
                    System.out.println("Function doesn't exist when x = " + x + ": " + e.getMessage());
                }
            }

            writer.write(sb.toString());
            System.out.println("CSV file created at: " + filePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error while creating CSV file: " + e.getMessage());
        }
    }

    private static void help() {
        System.out.println("""
                \033[1mUsage:\033[0m java -jar lab2.jar <function> <start> <end> <step> <filepath> [delimiter]
                        
                \033[1;4mREQUIRED ARGUMENTS:\033[0m
                        
                \033[1mfunction:\033[0m
                    Which function to calculate and generate output CSV file for.
                    \033[3mAvailable options:\033[0m \033[32msin, cos, sec, csc, ln, log2, log3, log5, log10, target\033[0m
                    
                \033[1mstart:\033[0m
                    Value to start the calculation from. (numeric)
                    
                \033[1mend:\033[0m
                    Ending value. (numeric)
                    
                \033[1mstep:\033[0m
                    Step size (increment) between consecutive values.
                    
                \033[1mfilepath:\033[0m
                    Resulting CSV file is going to be stored to the file with this path.
                    
                \033[1;4mOPTIONAL ARGUMENTS:\033[0m
                        
                \033[1mdelimiter:\033[0m
                    Character separating values in resulting CSV file
                    \033[3mDefault:\033[0m ',' (comma)
                """);
    }
}