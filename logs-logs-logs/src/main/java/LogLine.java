import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLine {
    String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String regex = "\\[([A-Z]+)\\]:";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(logLine);
        matcher.find();
        return LogLevel.getLogLevel(matcher.group(1));
    }

    public String getOutputForShortLog() {
        return getLogLevel().getLogLevel() + ":" + logLine.split(":")[1].trim();
    }
}
