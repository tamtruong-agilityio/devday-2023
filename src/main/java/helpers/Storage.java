package helpers;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage class is simple memory class where you can store any data you need.
 * This class should be initialized before use with instantiateStorage() method.
 */
@Getter
@Setter
@NoArgsConstructor
public class Storage {

    //***general***
    private Map<String, Object> mapStorage;
    private Map<String, Response> savedResponse;

    private static ThreadLocal<Storage> storage = new ThreadLocal<>();

    public static Storage getStorage() {
        return storage.get();
    }

    public static void instantiateStorage() {
        storage.set(new Storage());
        storage.get().mapStorage = new HashMap<>();
    }

    public void saveValue(String key, String value) {
        mapStorage.put(key, value);
    }

    public String getValue(String key) {
        return (String) mapStorage.get(key);
    }

    public void saveObjectValue(String key, Object value) {
        mapStorage.put(key, value);
    }

    public Object getObject(String key) {
        return mapStorage.get(key);
    }
}
