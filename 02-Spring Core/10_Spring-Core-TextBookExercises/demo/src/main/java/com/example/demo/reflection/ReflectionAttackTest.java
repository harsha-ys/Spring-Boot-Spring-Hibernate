package com.example.demo.reflection;

import java.lang.reflect.Constructor;

// 1. The Singleton class equipped with our architectural guard
class ProtectedSingleton {

    private ProtectedSingleton() {
        // Guard Clause
        if (SingletonHelper.INSTANCE != null) {
            throw new RuntimeException("Reflective access blocked! Object creation denied.");
        }
        System.out.println("-> Constructor executed successfully.");
    }

    private static class SingletonHelper {
        private static final ProtectedSingleton INSTANCE = new ProtectedSingleton();
    }

    public static ProtectedSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

// 2. The Execution class containing the test logic
public class ReflectionAttackTest {
    public static void main(String[] args) {
        System.out.println("--- Starting Test ---");

        // Step 1: Access the Singleton normally
        System.out.println("\n[Action] Accessing instance normally via getInstance()...");
        ProtectedSingleton instanceOne = ProtectedSingleton.getInstance();
        System.out.println("Result: instanceOne hashcode = " + instanceOne.hashCode());


        // Step 2: Attempt the Reflection Attack
        System.out.println("\n[Action] Setting up Reflection attack to bypass 'private' modifier...");
        try {
            // Grab the private constructor definition from the class blueprint
            Constructor<ProtectedSingleton> reflectionConstructor = ProtectedSingleton.class.getDeclaredConstructor();

            // MAGIC STEP: Force Java to ignore the 'private' modifier access barrier
            reflectionConstructor.setAccessible(true);

            System.out.println("[Action] Invoking private constructor forcefully using newInstance()...");
            // This line triggers the constructor code a second time
            ProtectedSingleton instanceTwo = reflectionConstructor.newInstance();

            System.out.println("SUCCESS: Attack bypassed privacy! instanceTwo hashcode = " + instanceTwo.hashCode());

        } catch (Exception e) {
            System.out.println("\n[GUARD TRIGGERED] Reflection Attack Failed as expected!");
            // Print the actual exception thrown by our constructor guard
            System.out.println("Exception Cause: " + e.getCause());
        }

        System.out.println("\n--- Test Complete ---");
    }
}