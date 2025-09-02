package assignments.module6;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to analyze and manage log entries. Supports filtering, threshold checking, and log
 * modification.
 * 
 * @author muhammadnaseem
 * @version Apr 10, 2025
 */
public class LogAnalyzer {
    private ArrayList<LogEntry> logs;

    /**
     * Constructor that initialize log
     * 
     * @param logLines Array of log entries in string format
     */
    public LogAnalyzer(String[] logLines) {
        logs = new ArrayList<>();
        for (String line : logLines) {
            String[] parts = line.split("\\|", 3);
            if (parts.length == 3) {
                logs.add(new LogEntry(parts[0], parts[1], parts[2]));
            }
        }
    }

    /**
     * This method adds new logs
     * 
     * @param logLine The log line in format: "timestamp|LEVEL|description"
     */
    public void addLogEntry(String logLine) {
        String[] parts = logLine.split("\\|", 3);
        if (parts.length == 3) {
            logs.add(new LogEntry(parts[0], parts[1], parts[2]));
        }
    }

    /**
     * Filters logs by a given error levels
     * 
     * @param level Error
     * @return list of matching log entries
     * @throws IllegalArgumentException if level is INVALID
     */
    public List<String> filterByLevel(String level) {
        ErrorLevel target = ErrorLevel.fromString(level);
        if (target == ErrorLevel.INVALID) {
            throw new IllegalArgumentException("Invalid error level: " + level);
        }

        List<String> result = new ArrayList<>();
        for (LogEntry entry : logs) {
            ErrorLevel entryLevel = entry.getErrorLevel();
            if (entryLevel != null && entryLevel.equals(target)) {
                result.add(entry.toString());
            }
        }
        return result;
    }

    /**
     * Deletes log entries of only DEBUG or INFO
     * 
     * @param level Error level string
     * @return number of entries deleted
     * @throws IllegalArgumentException if level is not DEBUG or INFO
     */
    public int deleteLogEntries(String level) {
        ErrorLevel target = ErrorLevel.fromString(level);
        if (target != ErrorLevel.DEBUG && target != ErrorLevel.INFO) {
            throw new IllegalArgumentException("Only DEBUG and INFO entries can be deleted.");
        }

        int count = 0;
        for (int i = logs.size() - 1; i >= 0; i--) {
            if (logs.get(i).getErrorLevel() == target) {
                logs.remove(i);
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if any log level exceeds its threshold and returns warning message.
     * 
     * @return warning string
     */
    public String checkThreshold() {
        int[] counts = new int[4]; // ERROR=0, WARN=1, INFO=2, DEBUG=3

        for (LogEntry entry : logs) {
            switch (entry.getErrorLevel()) {
            case ERROR:
                counts[0]++;
                break;
            case WARN:
                counts[1]++;
                break;
            case INFO:
                counts[2]++;
                break;
            case DEBUG:
                counts[3]++;
                break;
            default:
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        if (counts[0] > ErrorLevel.ERROR.getThreshold()) {
            result.append("WARNING: Error log level exceeded threshold\n");
        }
        if (counts[1] > ErrorLevel.WARN.getThreshold()) {
            result.append("WARNING: Warn log level exceeded threshold\n");
        }
        return result.toString().isEmpty() ? "No thresholds exceeded." : result.toString();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (ErrorLevel level : new ErrorLevel[] {
            ErrorLevel.ERROR, ErrorLevel.WARN,
            ErrorLevel.INFO, ErrorLevel.DEBUG }) {

            for (LogEntry entry : logs) {
                if (entry.getErrorLevel() == level) {
                    result.append(entry.toString()).append("\n");
                }
            }
        }

        return result.toString();
    }

    /**
     * Extra Credit drawing bar chart in this method
     * 
     * @return string representation of bar chart
     */
    public String drawBarChart() {
        int error = 0;
        int warn = 0;
        int info = 0;
        int debug = 0;
        for (LogEntry entry : logs) {
            switch (entry.getErrorLevel()) {
            case ERROR:
                error++;
                break;
            case WARN:
                warn++;
                break;
            case INFO:
                info++;
                break;
            case DEBUG:
                debug++;
                break;
            default:
                break;
            }
        }

        return String.format(
            "ERROR: %s (%d)\nWARN : %s (%d)\nINFO : %s (%d)\nDEBUG: %s (%d)\n",
            "*".repeat(error), error,
            "*".repeat(warn), warn,
            "*".repeat(info), info,
            "*".repeat(debug), debug);
    }
}
