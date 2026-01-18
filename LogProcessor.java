import java.util.*;

// OOAD: Data Model for a Log Entry
class LogEntry {
    String level; // INFO, ERROR, WARNING
    String message;

    public LogEntry(String level, String message) {
        this.level = level;
        this.message = message;
    }
}

public class LogProcessor {
    public static void main(String[] args) {
        // Data Structure: Using a List to simulate a stream of "Big Data"
        List<LogEntry> logs = new ArrayList<>();
        logs.add(new LogEntry("INFO", "System Started"));
        logs.add(new LogEntry("ERROR", "Database Connection Failed"));
        logs.add(new LogEntry("WARNING", "High Memory Usage"));
        logs.add(new LogEntry("ERROR", "Unauthorized Access Attempt"));
        logs.add(new LogEntry("INFO", "User Logged In"));

        System.out.println("--- Starting Data Processing Engine ---");
        processLogs(logs);
    }

    /**
     * Complexity Analysis:
     * Time Complexity: O(n) - We iterate through the list once.
     * Space Complexity: O(k) - Where k is the number of unique log levels.
     */
    public static void processLogs(List<LogEntry> logs) {
        // Data Structure: HashMap for efficient frequency counting (O(1) average lookup)
        Map<String, Integer> report = new HashMap<>();

        for (LogEntry log : logs) {
            report.put(log.level, report.getOrDefault(log.level, 0) + 1);
        }

        // Output results
        System.out.println("Processing Results:");
        report.forEach((level, count) -> 
            System.out.println("Log Level: " + level + " | Frequency: " + count)
        );

        if (report.getOrDefault("ERROR", 0) > 0) {
            System.out.println("\nCRITICAL: Platform has detected active errors!");
        }
    }
}