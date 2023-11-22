package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    @CheckForNull
    private final transient Object hashTable;
    private final transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public final boolean isPartialView() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr) {
        return create(i, objArr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr, ImmutableMap.Builder<K, V> builder) {
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            CollectPreconditions.checkEntryNotNull(Objects.requireNonNull(objArr[0]), Objects.requireNonNull(objArr[1]));
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        Object createHashTable = createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0);
        if (createHashTable instanceof Object[]) {
            Object[] objArr2 = (Object[]) createHashTable;
            ImmutableMap.Builder.DuplicateKey duplicateKey = (ImmutableMap.Builder.DuplicateKey) objArr2[2];
            if (builder == null) {
                throw duplicateKey.exception();
            }
            builder.duplicateKey = duplicateKey;
            Object obj = objArr2[0];
            int intValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, intValue * 2);
            createHashTable = obj;
            i = intValue;
        }
        return new RegularImmutableMap<>(createHashTable, objArr, i);
    }

    @CheckForNull
    private static Object createHashTable(Object[] objArr, int i, int i2, int i3) {
        ImmutableMap.Builder.DuplicateKey duplicateKey = null;
        if (i == 1) {
            CollectPreconditions.checkEntryNotNull(Objects.requireNonNull(objArr[i3]), Objects.requireNonNull(objArr[i3 ^ 1]));
            return null;
        }
        int i4 = i2 - 1;
        int i5 = -1;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = (i7 * 2) + i3;
                int i9 = (i6 * 2) + i3;
                Object requireNonNull = Objects.requireNonNull(objArr[i8]);
                Object requireNonNull2 = Objects.requireNonNull(objArr[i8 ^ 1]);
                CollectPreconditions.checkEntryNotNull(requireNonNull, requireNonNull2);
                int smear = Hashing.smear(requireNonNull.hashCode());
                while (true) {
                    int i10 = smear & i4;
                    int i11 = bArr[i10] & 255;
                    if (i11 == 255) {
                        bArr[i10] = (byte) i9;
                        if (i6 < i7) {
                            objArr[i9] = requireNonNull;
                            objArr[i9 ^ 1] = requireNonNull2;
                        }
                        i6++;
                    } else if (requireNonNull.equals(objArr[i11])) {
                        int i12 = i11 ^ 1;
                        ImmutableMap.Builder.DuplicateKey duplicateKey2 = new ImmutableMap.Builder.DuplicateKey(requireNonNull, requireNonNull2, Objects.requireNonNull(objArr[i12]));
                        objArr[i12] = requireNonNull2;
                        duplicateKey = duplicateKey2;
                        break;
                    } else {
                        smear = i10 + 1;
                    }
                }
            }
            return i6 == i ? bArr : new Object[]{bArr, Integer.valueOf(i6), duplicateKey};
        } else if (i2 <= SHORT_MAX_SIZE) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            int i13 = 0;
            for (int i14 = 0; i14 < i; i14++) {
                int i15 = (i14 * 2) + i3;
                int i16 = (i13 * 2) + i3;
                Object requireNonNull3 = Objects.requireNonNull(objArr[i15]);
                Object requireNonNull4 = Objects.requireNonNull(objArr[i15 ^ 1]);
                CollectPreconditions.checkEntryNotNull(requireNonNull3, requireNonNull4);
                int smear2 = Hashing.smear(requireNonNull3.hashCode());
                while (true) {
                    int i17 = smear2 & i4;
                    int i18 = sArr[i17] & SHORT_MASK;
                    if (i18 == SHORT_MASK) {
                        sArr[i17] = (short) i16;
                        if (i13 < i14) {
                            objArr[i16] = requireNonNull3;
                            objArr[i16 ^ 1] = requireNonNull4;
                        }
                        i13++;
                    } else if (requireNonNull3.equals(objArr[i18])) {
                        int i19 = i18 ^ 1;
                        ImmutableMap.Builder.DuplicateKey duplicateKey3 = new ImmutableMap.Builder.DuplicateKey(requireNonNull3, requireNonNull4, Objects.requireNonNull(objArr[i19]));
                        objArr[i19] = requireNonNull4;
                        duplicateKey = duplicateKey3;
                        break;
                    } else {
                        smear2 = i17 + 1;
                    }
                }
            }
            return i13 == i ? sArr : new Object[]{sArr, Integer.valueOf(i13), duplicateKey};
        } else {
            int[] iArr = new int[i2];
            Arrays.fill(iArr, -1);
            int i20 = 0;
            int i21 = 0;
            while (i20 < i) {
                int i22 = (i20 * 2) + i3;
                int i23 = (i21 * 2) + i3;
                Object requireNonNull5 = Objects.requireNonNull(objArr[i22]);
                Object requireNonNull6 = Objects.requireNonNull(objArr[i22 ^ 1]);
                CollectPreconditions.checkEntryNotNull(requireNonNull5, requireNonNull6);
                int smear3 = Hashing.smear(requireNonNull5.hashCode());
                while (true) {
                    int i24 = smear3 & i4;
                    int i25 = iArr[i24];
                    if (i25 == i5) {
                        iArr[i24] = i23;
                        if (i21 < i20) {
                            objArr[i23] = requireNonNull5;
                            objArr[i23 ^ 1] = requireNonNull6;
                        }
                        i21++;
                    } else if (requireNonNull5.equals(objArr[i25])) {
                        int i26 = i25 ^ 1;
                        ImmutableMap.Builder.DuplicateKey duplicateKey4 = new ImmutableMap.Builder.DuplicateKey(requireNonNull5, requireNonNull6, Objects.requireNonNull(objArr[i26]));
                        objArr[i26] = requireNonNull6;
                        duplicateKey = duplicateKey4;
                        break;
                    } else {
                        smear3 = i24 + 1;
                        i5 = -1;
                    }
                }
                i20++;
                i5 = -1;
            }
            return i21 == i ? iArr : new Object[]{iArr, Integer.valueOf(i21), duplicateKey};
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public static Object createHashTableOrThrow(Object[] objArr, int i, int i2, int i3) {
        Object createHashTable = createHashTable(objArr, i, i2, i3);
        if (createHashTable instanceof Object[]) {
            throw ((ImmutableMap.Builder.DuplicateKey) ((Object[]) createHashTable)[2]).exception();
        }
        return createHashTable;
    }

    private RegularImmutableMap(@CheckForNull Object obj, Object[] objArr, int i) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i;
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public final V get(@CheckForNull Object obj) {
        V v = (V) get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
        if (v == null) {
            return null;
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public static Object get(@CheckForNull Object obj, Object[] objArr, int i, int i2, @CheckForNull Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            if (Objects.requireNonNull(objArr[i2]).equals(obj2)) {
                return Objects.requireNonNull(objArr[i2 ^ 1]);
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length;
                int smear = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i3 = smear & (length - 1);
                    int i4 = bArr[i3] & 255;
                    if (i4 == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[i4])) {
                        return objArr[i4 ^ 1];
                    }
                    smear = i3 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length;
                int smear2 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i5 = smear2 & (length2 - 1);
                    int i6 = sArr[i5] & SHORT_MASK;
                    if (i6 == SHORT_MASK) {
                        return null;
                    }
                    if (obj2.equals(objArr[i6])) {
                        return objArr[i6 ^ 1];
                    }
                    smear2 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length;
                int smear3 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i7 = smear3 & (length3 - 1);
                    int i8 = iArr[i7];
                    if (i8 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i8])) {
                        return objArr[i8 ^ 1];
                    }
                    smear3 = i7 + 1;
                }
            }
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    final ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        private final transient int size;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i;
            this.size = i2;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i) {
                    Preconditions.checkElementIndex(i, EntrySet.this.size);
                    int i2 = i * 2;
                    return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i2]), Objects.requireNonNull(EntrySet.this.alternatingKeysAndValues[i2 + (EntrySet.this.keyOffset ^ 1)]));
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.size;
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                return value != null && value.equals(this.map.get(key));
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    final ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    /* loaded from: classes3.dex */
    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i;
            this.size = i2;
        }

        @Override // java.util.List
        public final Object get(int i) {
            Preconditions.checkElementIndex(i, this.size);
            return Objects.requireNonNull(this.alternatingKeysAndValues[(i * 2) + this.offset]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.size;
        }
    }

    /* loaded from: classes3.dex */
    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public final boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public final /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public final UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public final int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public final ImmutableList<K> asList() {
            return this.list;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@CheckForNull Object obj) {
            return this.map.get(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.map.size();
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    final ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }
}
