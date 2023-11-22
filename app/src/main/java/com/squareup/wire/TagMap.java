package com.squareup.wire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes3.dex */
abstract class TagMap<T> {
    private static final Comparator<? super Map.Entry<Integer, ?>> COMPARATOR = new Comparator<Map.Entry<Integer, ?>>() { // from class: com.squareup.wire.TagMap.1
        @Override // java.util.Comparator
        public final int compare(Map.Entry<Integer, ?> entry, Map.Entry<Integer, ?> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    };
    private static final float RATIO_THRESHOLD = 0.75f;
    private static final int SIZE_THRESHOLD = 64;
    List<T> values;

    private static boolean isCompact(int i, int i2) {
        return i2 <= 64 || ((float) i) / ((float) i2) > RATIO_THRESHOLD;
    }

    public abstract boolean containsKey(int i);

    public abstract T get(int i);

    public static <T> TagMap<T> of(Map<Integer, T> map) {
        int maxTag = maxTag(map);
        if (isCompact(map.size(), maxTag)) {
            return Compact.compactTagMapOf(map, maxTag);
        }
        return Sparse.sparseTagMapOf(map);
    }

    private static <T> int maxTag(Map<Integer, T> map) {
        Iterator<Integer> it = map.keySet().iterator();
        int i = -1;
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue > i) {
                i = intValue;
            }
        }
        return i;
    }

    private static <T> List<T> sortedValues(Map<Integer, T> map) {
        TreeSet treeSet = new TreeSet(COMPARATOR);
        treeSet.addAll(map.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    protected TagMap(Map<Integer, T> map) {
        this.values = sortedValues(map);
    }

    public Collection<T> values() {
        return this.values;
    }

    /* loaded from: classes3.dex */
    static final class Compact<T> extends TagMap<T> {
        Object[] elementsByTag;
        int maxTag;

        public static <T> Compact<T> compactTagMapOf(Map<Integer, T> map, int i) {
            return new Compact<>(map, i);
        }

        private Compact(Map<Integer, T> map, int i) {
            super(map);
            this.maxTag = i;
            this.elementsByTag = new Object[i + 1];
            for (Map.Entry<Integer, T> entry : map.entrySet()) {
                Integer key = entry.getKey();
                if (key.intValue() <= 0) {
                    throw new IllegalArgumentException("Input map key is negative or zero");
                }
                this.elementsByTag[key.intValue()] = entry.getValue();
            }
        }

        @Override // com.squareup.wire.TagMap
        public final T get(int i) {
            if (i > this.maxTag) {
                return null;
            }
            return (T) this.elementsByTag[i];
        }

        @Override // com.squareup.wire.TagMap
        public final boolean containsKey(int i) {
            return i <= this.maxTag && this.elementsByTag[i] != null;
        }
    }

    /* loaded from: classes3.dex */
    static final class Sparse<T> extends TagMap<T> {
        Map<Integer, T> map;

        public static <T> Sparse<T> sparseTagMapOf(Map<Integer, T> map) {
            return new Sparse<>(map);
        }

        private Sparse(Map<Integer, T> map) {
            super(map);
            this.map = map;
        }

        @Override // com.squareup.wire.TagMap
        public final T get(int i) {
            return this.map.get(Integer.valueOf(i));
        }

        @Override // com.squareup.wire.TagMap
        public final boolean containsKey(int i) {
            return this.map.containsKey(Integer.valueOf(i));
        }
    }
}
