package emobi.utilities;

import java.util.*;

public class LinkedProperties extends Properties {
    public static final long serialVersionUID = 1;
    private final HashSet<Object> keys = new LinkedHashSet<Object>();

    public LinkedProperties() {
    }

    public Iterable<Object> orderedKeys() {
        return Collections.list(keys());
    }

    public Enumeration<Object> keys() {
        return Collections.<Object>enumeration(keys);
    }

    public Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);
    }

    @Override
    public void clear() {
        keys.clear();
        super.clear();
    }

    @Override
    public Object remove(Object key) {
        keys.remove(key);
        return super.remove(key);
    }
}
