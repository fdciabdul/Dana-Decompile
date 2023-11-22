package io.opentelemetry.api.internal;

import j$.util.function.BiConsumer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public abstract class ImmutableKeyValuePairs<K, V> {
    private final Object[] data;

    public ImmutableKeyValuePairs(Object[] objArr) {
        this.data = objArr;
    }

    public ImmutableKeyValuePairs(Object[] objArr, Comparator<?> comparator) {
        this(sortAndFilter(objArr, comparator));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Object> data() {
        return Arrays.asList(this.data);
    }

    public final int size() {
        return this.data.length / 2;
    }

    public final boolean isEmpty() {
        return this.data.length == 0;
    }

    public final Map<K, V> asMap() {
        return ReadOnlyArrayMap.wrap(data());
    }

    @Nullable
    public final V get(K k) {
        if (k == null) {
            return null;
        }
        int i = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i >= objArr.length) {
                return null;
            }
            if (k.equals(objArr[i])) {
                return (V) this.data[i + 1];
            }
            i += 2;
        }
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        if (biConsumer == null) {
            return;
        }
        int i = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i >= objArr.length) {
                return;
            }
            biConsumer.accept(objArr[i], objArr[i + 1]);
            i += 2;
        }
    }

    private static Object[] sortAndFilter(Object[] objArr, Comparator<?> comparator) {
        Utils.checkArgument(objArr.length % 2 == 0, "You must provide an even number of key/value pair arguments.");
        if (objArr.length == 0) {
            return objArr;
        }
        mergeSort(objArr, comparator);
        return dedupe(objArr, comparator);
    }

    private static void mergeSort(Object[] objArr, Comparator<?> comparator) {
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        splitAndMerge(objArr2, 0, objArr.length, objArr, comparator);
    }

    private static void splitAndMerge(Object[] objArr, int i, int i2, Object[] objArr2, Comparator<?> comparator) {
        if (i2 - i <= 2) {
            return;
        }
        int i3 = ((i2 + i) / 4) * 2;
        splitAndMerge(objArr2, i, i3, objArr, comparator);
        splitAndMerge(objArr2, i3, i2, objArr, comparator);
        merge(objArr, i, i3, i2, objArr2, comparator);
    }

    private static <K> void merge(Object[] objArr, int i, int i2, int i3, Object[] objArr2, Comparator<K> comparator) {
        int i4 = i;
        int i5 = i2;
        while (i < i3) {
            if (i4 < i2 - 1 && (i5 >= i3 - 1 || compareToNullSafe(objArr[i4], objArr[i5], comparator) <= 0)) {
                objArr2[i] = objArr[i4];
                objArr2[i + 1] = objArr[i4 + 1];
                i4 += 2;
            } else {
                objArr2[i] = objArr[i5];
                objArr2[i + 1] = objArr[i5 + 1];
                i5 += 2;
            }
            i += 2;
        }
    }

    private static <K> int compareToNullSafe(@Nullable K k, @Nullable K k2, Comparator<K> comparator) {
        if (k == null) {
            return k2 == null ? 0 : -1;
        } else if (k2 == null) {
            return 1;
        } else {
            return comparator.compare(k, k2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K> Object[] dedupe(Object[] objArr, Comparator<K> comparator) {
        Object obj = null;
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2 += 2) {
            Object obj2 = objArr[i2];
            Object obj3 = objArr[i2 + 1];
            if (obj2 != null) {
                if (obj != null && comparator.compare(obj2, obj) == 0) {
                    i -= 2;
                }
                if (obj3 == null) {
                    obj = null;
                } else {
                    int i3 = i + 1;
                    objArr[i] = obj2;
                    i = i3 + 1;
                    objArr[i3] = obj3;
                    obj = obj2;
                }
            }
        }
        if (objArr.length != i) {
            Object[] objArr2 = new Object[i];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            return objArr2;
        }
        return objArr;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImmutableKeyValuePairs) {
            return Arrays.equals(this.data, ((ImmutableKeyValuePairs) obj).data);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data) ^ 1000003;
    }

    public String toString() {
        String obj;
        StringBuilder sb = new StringBuilder("{");
        int i = 0;
        while (true) {
            Object[] objArr = this.data;
            if (i >= objArr.length) {
                break;
            }
            Object obj2 = objArr[i + 1];
            if (obj2 instanceof String) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Typography.quote);
                sb2.append((String) obj2);
                sb2.append(Typography.quote);
                obj = sb2.toString();
            } else {
                obj = obj2.toString();
            }
            sb.append(this.data[i]);
            sb.append("=");
            sb.append(obj);
            sb.append(", ");
            i += 2;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }
}
