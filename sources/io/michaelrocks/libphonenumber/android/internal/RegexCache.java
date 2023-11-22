package io.michaelrocks.libphonenumber.android.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class RegexCache {
    private LRUCache<String, Pattern> cache;

    public RegexCache(int i) {
        this.cache = new LRUCache<>(i);
    }

    public Pattern getPatternForRegex(String str) {
        Pattern pattern = this.cache.get(str);
        if (pattern == null) {
            Pattern compile = Pattern.compile(str);
            this.cache.put(str, compile);
            return compile;
        }
        return pattern;
    }

    boolean containsRegex(String str) {
        return this.cache.containsKey(str);
    }

    /* loaded from: classes6.dex */
    static class LRUCache<K, V> {
        private LinkedHashMap<K, V> map;
        private int size;

        public LRUCache(int i) {
            this.size = i;
            this.map = new LinkedHashMap<K, V>(((i * 4) / 3) + 1, 0.75f, true) { // from class: io.michaelrocks.libphonenumber.android.internal.RegexCache.LRUCache.1
                @Override // java.util.LinkedHashMap
                protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    return size() > LRUCache.this.size;
                }
            };
        }

        public V get(K k) {
            V v;
            synchronized (this) {
                v = this.map.get(k);
            }
            return v;
        }

        public void put(K k, V v) {
            synchronized (this) {
                this.map.put(k, v);
            }
        }

        public boolean containsKey(K k) {
            boolean containsKey;
            synchronized (this) {
                containsKey = this.map.containsKey(k);
            }
            return containsKey;
        }
    }
}
