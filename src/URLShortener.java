import java.util.Map;
import java.util.HashMap;

public class URLShortener {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;
    private int counter;

    public URLShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
        counter = 1;
    }

    public String shortenURL(String longURL) {
        String shortURL = generateShortURL(longURL);
        shortToLongMap.put(shortURL, longURL);
        longToShortMap.put(longURL, shortURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        return shortToLongMap.get(shortURL);
    }

    private String generateShortURL(String longURL) {
        return "short.ly/" + counter++;
    }
}
