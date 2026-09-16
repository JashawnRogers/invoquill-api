package com.jashawnbuilds.invoquill_api.shared.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a valid US Phone Number conforming to the NANP standard with an optional extension.
 */
public record UsPhoneNumber(
        String areaCode,
        String centralOfficeCode,
        String lineNumber,
        String extension
) {
    private static final Pattern CLEAN_PATTERN = Pattern
            .compile("^\\+?1?(\\d{10})(?:(?:ext|x|ext\\.)(\\d+))?$");
    private static final Pattern COMPONENT_PATTERN = Pattern
            .compile("^(\\d{3})(\\d{3})(\\d{4})$");

    public UsPhoneNumber {
        if (areaCode == null || areaCode.isBlank())
            throw new RuntimeException();

        if (centralOfficeCode == null || centralOfficeCode.isBlank())
            throw new RuntimeException();

        if (lineNumber == null || lineNumber.isBlank())
            throw new RuntimeException();

        if (areaCode.length() != 3 || centralOfficeCode.length() != 3 || lineNumber.length() != 4)
            throw new RuntimeException();
    }

    /**
     * Factory method parsing raw string input into a structured UsPhoneNumber.
     * Handles inputs like "+1 (555) 123-4567 ext 123", "5551234567x99", or "555-123-4567".
     */
    public static UsPhoneNumber of(String rawInput) {
        if (rawInput == null || rawInput.isBlank())
            throw new RuntimeException();

        // Lowercase and strip common formatting characters but preserve extension indicators (x, ext)
        String sanitizedInput = rawInput.toLowerCase().replaceAll("[\\s()\\-.]", "");

        Matcher matcher = CLEAN_PATTERN.matcher(sanitizedInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid US phone number format: " + rawInput);
        }

        String tenDigits = matcher.group(1);
        String ext = matcher.group(2); // Will be null if no extension is matched

        Matcher parts = COMPONENT_PATTERN.matcher(tenDigits);
        if (parts.matches()) {
            return new UsPhoneNumber(parts.group(1), parts.group(2), parts.group(3), ext);
        }

        throw new IllegalArgumentException("Could not parse phone number digits.");
    }

    public static String generateString(UsPhoneNumber value) {
        String base = String.format("(%s) %s-%s", value.areaCode(), value.centralOfficeCode(), value.lineNumber());
        return value.hasExtension() ? base + " ext. " + value.extension() : base;
    }

    public boolean hasExtension() {
        return extension != null && !extension.isBlank();
    }

    @Override
    public String toString() {
        String base = String.format("(%s) %s-%s", areaCode, centralOfficeCode, lineNumber);
        String phoneNumber = hasExtension() ? base + " ext. " + extension : base;
        return "[phone number=" + phoneNumber + "]";
    }
}
