import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueChat = true;

        while (continueChat) {
            // Greet the user
            System.out.println("Hello, World!");
            System.out.print("How are you today? (respond with 'good', 'bad', or 'okay'): ");
            String response = scanner.nextLine();

            // Respond based on user input
            switch (response.toLowerCase()) {
                case "good":
                    System.out.println("I'm glad to hear that! What would you like to do today?");
                    break;
                case "bad":
                    System.out.println("I'm sorry to hear that. I hope things get better! Would you like to chat or do something else?");
                    break;
                case "okay":
                    System.out.println("Okay is good! Would you like to do some math with me?");
                    break;
                default:
                    System.out.println("That's interesting! Let's do something fun. How about some math?");
                    break;
            }

            // Ask if the user wants to perform math
            System.out.print("Would you like to do some math? (yes/no): ");
            String mathResponse = scanner.nextLine();

            if (mathResponse.equalsIgnoreCase("yes")) {
                performMath(scanner);
            } else {
                System.out.println("Okay, maybe next time! Would you like to hear a fun fact? (yes/no)");
                String factResponse = scanner.nextLine();
                if (factResponse.equalsIgnoreCase("yes")) {
                    tellFunFact();
                }
            }

            // Check if user wants to continue
            System.out.print("Would you like to continue the conversation? (yes/no): ");
            String continueResponse = scanner.nextLine();
            continueChat = continueResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for chatting! Have a great day!");
        scanner.close();
    }

    private static void performMath(Scanner scanner) {
        System.out.print("What operation would you like to perform? (add/subtract/multiply/divide): ");
        String operation = scanner.nextLine();

        System.out.print("Enter the first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double b = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline

        switch (operation.toLowerCase()) {
            case "add":
                System.out.println("The sum of " + a + " and " + b + " is " + add(a, b) + ".");
                break;
            case "subtract":
                System.out.println("The difference between " + a + " and " + b + " is " + subtract(a, b) + ".");
                break;
            case "multiply":
                System.out.println("The product of " + a + " and " + b + " is " + multiply(a, b) + ".");
                break;
            case "divide":
                if (b != 0) {
                    System.out.println("The quotient of " + a + " divided by " + b + " is " + divide(a, b) + ".");
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
    }

    public static String tellFunFact() {
        String[] funFacts = {
                "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3000 years old and still edible!",
                "A group of flamingos is called a 'flamboyance'.",
                "Bananas are berries, but strawberries are not.",
                "Octopuses have three hearts!",
                "Wombat poop is cube-shaped."
        };
        int randomIndex = (int) (Math.random() * funFacts.length);
        return funFacts[randomIndex];
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
}