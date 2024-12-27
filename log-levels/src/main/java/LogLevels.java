public class LogLevels {
    
    public static String message(String logLine) {
        String[] message = logLine.split(":");
        return message[1].trim();
    }

    public static String logLevel(String logLine) {
        return switch (logLine) {
            case String s when s.contains("ERROR") -> "error";
            case String s when s.contains("INFO") -> "info";
            case String s when s.contains("WARNING") -> "warning";
            default -> throw new RuntimeException("Panic! value not valid");
        };
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)",message(logLine), logLevel(logLine));
    }
}
