package com.mt.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/chat") // Base URL for the controller
public class ChatController {
    private final Random random = new Random();
    private final String[] funFacts = {
            "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3000 years old and still edible!",
            "A group of flamingos is called a 'flamboyance'.",
            "Bananas are berries, but strawberries are not.",
            "Octopuses have three hearts!",
            "Wombat poop is cube-shaped."
    };

    // Endpoint to greet the user
    @GetMapping("/greet")
    public String greet() {
        return "Hello, World! How are you today? (respond with 'good', 'bad', or 'okay')";
    }

    // Endpoint to respond to user input
    @PostMapping("/respond")
    public String respond(@RequestParam String userInput) {
        switch (userInput.toLowerCase()) {
            case "good":
                return "I'm glad to hear that! What would you like to do today?";
            case "bad":
                return "I'm sorry to hear that. I hope things get better!";
            case "okay":
                return "Okay is good! Would you like to do some math with me?";
            default:
                return "That's interesting! Let's do something fun. How about some math?";
        }
    }

    // Endpoint for performing math operations
    @PostMapping("/math")
    public String performMath(@RequestParam String operation, @RequestParam double a, @RequestParam double b) {
        switch (operation.toLowerCase()) {
            case "add":
                return "The sum of " + a + " and " + b + " is " + add(a, b) + ".";
            case "subtract":
                return "The difference between " + a + " and " + b + " is " + subtract(a, b) + ".";
            case "multiply":
                return "The product of " + a + " and " + b + " is " + multiply(a, b) + ".";
            case "divide":
                if (b != 0) {
                    return "The quotient of " + a + " divided by " + b + " is " + divide(a, b) + ".";
                } else {
                    return "Cannot divide by zero!";
                }
            default:
                return "Invalid operation!";
        }
    }

    // Endpoint to return a random fun fact
    @GetMapping("/funfact")
    public String tellFunFact() {
        int randomIndex = random.nextInt(funFacts.length);
        return funFacts[randomIndex];
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }
}
