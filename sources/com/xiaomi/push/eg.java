package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes8.dex */
public final class eg {
    private static final Comparator getAuthRequestContext = new a(0);

    /* loaded from: classes8.dex */
    static class a implements Comparator {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? eg.getAuthRequestContext((List) obj, (List) obj2) : obj instanceof Set ? eg.BuiltInFictitiousFunctionClassFactory((Set) obj, (Set) obj2) : obj instanceof Map ? eg.MyBillsEntityDataFactory((Map) obj, (Map) obj2) : obj instanceof byte[] ? eg.MyBillsEntityDataFactory((byte[]) obj, (byte[]) obj2) : eg.MyBillsEntityDataFactory((Comparable) obj, (Comparable) obj2);
        }
    }

    public static ByteBuffer BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) {
        return KClassImpl$Data$declaredNonStaticMembers$2(byteBuffer) ? byteBuffer : ByteBuffer.wrap(PlaceComponentResult(byteBuffer));
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static int MyBillsEntityDataFactory(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int PlaceComponentResult(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    public static int PlaceComponentResult(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    public static int getAuthRequestContext(List list, List list2) {
        int size = list.size();
        int size2 = list2.size();
        int i = size < size2 ? -1 : size2 < size ? 1 : 0;
        if (i != 0) {
            return i;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            int compare = getAuthRequestContext.compare(list.get(i2), list2.get(i2));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int MyBillsEntityDataFactory(Map map, Map map2) {
        int size = map.size();
        int size2 = map2.size();
        int i = size < size2 ? -1 : size2 < size ? 1 : 0;
        if (i != 0) {
            return i;
        }
        Comparator comparator = getAuthRequestContext;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            Comparator comparator2 = getAuthRequestContext;
            int compare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static int BuiltInFictitiousFunctionClassFactory(Set set, Set set2) {
        int size = set.size();
        int size2 = set2.size();
        int i = size < size2 ? -1 : size2 < size ? 1 : 0;
        if (i != 0) {
            return i;
        }
        Comparator comparator = getAuthRequestContext;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = getAuthRequestContext.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int MyBillsEntityDataFactory(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        int i = length < length2 ? -1 : length2 < length ? 1 : 0;
        if (i != 0) {
            return i;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            byte b2 = bArr2[i2];
            int i3 = b < b2 ? -1 : b2 < b ? 1 : 0;
            if (i3 != 0) {
                return i3;
            }
        }
        return 0;
    }

    public static void MyBillsEntityDataFactory(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
        for (int i2 = arrayOffset; i2 < i; i2++) {
            if (i2 > arrayOffset) {
                sb.append(" ");
            }
            sb.append(Integer.toHexString((array[i2] | 256) & 511).toUpperCase().substring(1));
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    private static byte[] PlaceComponentResult(ByteBuffer byteBuffer) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, 0, byteBuffer.remaining());
        return bArr;
    }
}
