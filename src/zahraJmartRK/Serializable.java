package zahraJmartRK;
import java.util.HashMap;
import java.util.Map;

public class Serializable implements Comparable<Serializable> {
    public final int id;
    private static Map<Class<?>, Integer> mapCounter = new HashMap<>();

    protected Serializable() {
        Class gotClass = getClass();
        if (mapCounter.get(gotClass) == null) {
            mapCounter.put(gotClass, 0);
        } else {
            mapCounter.put(gotClass, mapCounter.get(gotClass) + 1);
        }
        this.id = mapCounter.get(gotClass);
    }

    @Override
    public int compareTo(Serializable other) {
        return (this.id < other.id) ? -1 : ((
                this.id == other.id) ? 0 : 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Serializable) {
            Serializable r = (Serializable) obj;
            if (r.id == this.id) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean equals(Serializable r) {
        if (this.id == r.id) {
            return true;
        } else {
            return false;
        }
    }

    public static <T extends Serializable> int getClosingId(Class<T> clazz) {
        return mapCounter.get(clazz);
    }

    public static <T extends Serializable> int setClosingId(Class<T> clazz, int id) {
        return mapCounter.put(clazz, id);
    }

}