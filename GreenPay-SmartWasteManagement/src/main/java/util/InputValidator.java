package util;


public class InputValidator {

    public static void validateQuantity(double qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }

    public static void validateText(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
    }
}
