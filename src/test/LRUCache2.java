package test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2<k,v> extends LinkedHashMap<k,v> {
    private static final int MAX_ENTRIES = 3;
    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size()>MAX_ENTRIES;
    }

    public LRUCache2() {
        super(MAX_ENTRIES, 0.75f,true);
    }
}
