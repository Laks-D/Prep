import java.util.HashMap;
import java.util.Map;

class CacheManager {
    // Private raw data map
    private final Map<String, String> storage = new HashMap<>();
    
    // Private metrics tracking internal state
    private int hitCount = 0;
    private int missCount = 0;

    // Data Modification via controlled method
    public void put(String key, String value) {
        if (key != null && value != null) {
            storage.put(key, value);
        }
    }

    // Data Access that tracks internal state implicitly
    public String get(String key) {
        if (storage.containsKey(key)) {
            hitCount++; // Mutating private tracking variable
            return storage.get(key);
        }
        missCount++;
        return null;
    }

    // Read-Only Accessors: No setters exist for hits, misses, or hit rate!
    public int getHitCount() { return this.hitCount; }
    public int getMissCount() { return this.missCount; }

    // Calculated Property: Derived on demand from private state
    public double getHitSuccessRate() {
        int totalRequests = hitCount + missCount;
        if (totalRequests == 0) return 0.0;
        return ((double) hitCount / totalRequests) * 100;
    }
}
