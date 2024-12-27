import java.util.stream.Collectors;

class ReverseString {
    Boolean esCert(int a, int b) {
        return a % b == 0;
    }

    String reverse(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }
  
}
