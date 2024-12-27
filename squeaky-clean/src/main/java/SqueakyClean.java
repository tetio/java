import java.util.stream.IntStream;

class SqueakyClean {
    static String clean(String identifier) {
        char[] chars = identifier.toCharArray();
        IntStream.range(0, chars.length)
                .forEach(n -> {
                    chars[n] = leetspeak2normal(chars[n]);
                    chars[n] = (n > 0 && chars[n - 1] == '-') ? Character.toUpperCase(chars[n]) : chars[n];
                });
        return new String(chars).replaceAll("[^a-zA-Z_]+", "");

    }

    static char leetspeak2normal(char c) {
        return switch (c) {
            case '4' -> 'a';
            case '3' -> 'e';
            case '0' -> 'o';
            case '1' -> 'l';
            case '7' -> 't';
            case ' ' -> '_';
            default -> c;
        };
    }
}
