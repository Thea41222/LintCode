public class Solution {
    Map<String, String> map = new HashMap<>();
    
    public String encode(String longUrl) {
        // Encodes a URL to a shortened URL.
        String result = Integer.toHexString(longUrl.hashCode());
        map.put(result,longUrl);
        return result;

    }

    
    public String decode(String shortUrl) {
        // Decodes a shortened URL to its original URL.
        return map.get(shortUrl);
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));