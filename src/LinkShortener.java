import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LinkShortener {
    private Map<String, String> shortToLongMap;
    private Map<String, String> longToShortMap;
    private int counter;

    public LinkShortener() {
        shortToLongMap = new HashMap<>();
        longToShortMap = new HashMap<>();
        counter = 1;
    }

    public String shortenURL(String longURL) {
        // Check for duplicate long URL
        if (checkDuplicateLongURL(longURL)) {
            return "Duplicate long URL"; // Error message
        }

        String shortURL = generateShortURL(longURL);
        shortToLongMap.put(shortURL, longURL);
        longToShortMap.put(longURL, shortURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        // Check for invalid short URL
        if (checkInvalidShortURL(shortURL)) {
            return "Invalid short URL"; // Error message
        }
        return shortToLongMap.get(shortURL);
    }

    public boolean checkDuplicateLongURL(String longURL) {
        return longToShortMap.containsKey(longURL);
    }
    


    public boolean checkInvalidShortURL(String shortURL) {
        return !shortToLongMap.containsKey(shortURL);
    }

    private String generateShortURL(String longURL) {
        try {
            // Create a MessageDigest instance for MD5 hashing
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash value of the long URL
            byte[] hashBytes = md.digest(longURL.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }

            // Return the first 8 characters of the hexadecimal string as the short URL
            return sb.toString().substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where MD5 algorithm is not available
            e.printStackTrace();
            return null;
        }
    }
}
