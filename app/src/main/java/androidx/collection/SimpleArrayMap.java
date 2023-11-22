package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    static int KClassImpl$Data$declaredNonStaticMembers$2;
    static Object[] MyBillsEntityDataFactory;
    static Object[] PlaceComponentResult;
    static int getAuthRequestContext;
    int[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    int getErrorConfigVersion;
    public Object[] moveToNextValue;

    private static int BuiltInFictitiousFunctionClassFactory(int[] iArr, int i, int i2) {
        try {
            return ContainerHelpers.BuiltInFictitiousFunctionClassFactory(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2(Object obj, int i) {
        int i2 = this.getErrorConfigVersion;
        if (i2 == 0) {
            return -1;
        }
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, i2, i);
        if (BuiltInFictitiousFunctionClassFactory >= 0 && !obj.equals(this.moveToNextValue[BuiltInFictitiousFunctionClassFactory << 1])) {
            int i3 = BuiltInFictitiousFunctionClassFactory + 1;
            while (i3 < i2 && this.NetworkUserEntityData$$ExternalSyntheticLambda0[i3] == i) {
                if (obj.equals(this.moveToNextValue[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = BuiltInFictitiousFunctionClassFactory - 1; i4 >= 0 && this.NetworkUserEntityData$$ExternalSyntheticLambda0[i4] == i; i4--) {
                if (obj.equals(this.moveToNextValue[i4 << 1])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final int PlaceComponentResult() {
        int i = this.getErrorConfigVersion;
        if (i == 0) {
            return -1;
        }
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, i, 0);
        if (BuiltInFictitiousFunctionClassFactory >= 0 && this.moveToNextValue[BuiltInFictitiousFunctionClassFactory << 1] != null) {
            int i2 = BuiltInFictitiousFunctionClassFactory + 1;
            while (i2 < i && this.NetworkUserEntityData$$ExternalSyntheticLambda0[i2] == 0) {
                if (this.moveToNextValue[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = BuiltInFictitiousFunctionClassFactory - 1; i3 >= 0 && this.NetworkUserEntityData$$ExternalSyntheticLambda0[i3] == 0; i3--) {
                if (this.moveToNextValue[i3 << 1] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private void BuiltInFictitiousFunctionClassFactory(int i) {
        if (i == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = PlaceComponentResult;
                if (objArr != null) {
                    this.moveToNextValue = objArr;
                    PlaceComponentResult = (Object[]) objArr[0];
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    getAuthRequestContext--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = MyBillsEntityDataFactory;
                if (objArr2 != null) {
                    this.moveToNextValue = objArr2;
                    MyBillsEntityDataFactory = (Object[]) objArr2[0];
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    KClassImpl$Data$declaredNonStaticMembers$2--;
                    return;
                }
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new int[i];
        this.moveToNextValue = new Object[i << 1];
    }

    private static void MyBillsEntityDataFactory(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (getAuthRequestContext < 10) {
                    objArr[0] = PlaceComponentResult;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    PlaceComponentResult = objArr;
                    getAuthRequestContext++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 < 10) {
                    objArr[0] = MyBillsEntityDataFactory;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    MyBillsEntityDataFactory = objArr;
                    KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ContainerHelpers.MyBillsEntityDataFactory;
        this.moveToNextValue = ContainerHelpers.BuiltInFictitiousFunctionClassFactory;
        this.getErrorConfigVersion = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ContainerHelpers.MyBillsEntityDataFactory;
            this.moveToNextValue = ContainerHelpers.BuiltInFictitiousFunctionClassFactory;
        } else {
            BuiltInFictitiousFunctionClassFactory(i);
        }
        this.getErrorConfigVersion = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(simpleArrayMap);
        }
    }

    public void clear() {
        int i = this.getErrorConfigVersion;
        if (i > 0) {
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Object[] objArr = this.moveToNextValue;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ContainerHelpers.MyBillsEntityDataFactory;
            this.moveToNextValue = ContainerHelpers.BuiltInFictitiousFunctionClassFactory;
            this.getErrorConfigVersion = 0;
            MyBillsEntityDataFactory(iArr, objArr, i);
        }
        if (this.getErrorConfigVersion > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void PlaceComponentResult(int i) {
        int i2 = this.getErrorConfigVersion;
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (iArr.length < i) {
            Object[] objArr = this.moveToNextValue;
            BuiltInFictitiousFunctionClassFactory(i);
            if (this.getErrorConfigVersion > 0) {
                System.arraycopy(iArr, 0, this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, i2);
                System.arraycopy(objArr, 0, this.moveToNextValue, 0, i2 << 1);
            }
            MyBillsEntityDataFactory(iArr, objArr, i2);
        }
        if (this.getErrorConfigVersion != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int BuiltInFictitiousFunctionClassFactory(Object obj) {
        int i = this.getErrorConfigVersion * 2;
        Object[] objArr = this.moveToNextValue;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return BuiltInFictitiousFunctionClassFactory(obj) >= 0;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V KClassImpl$Data$declaredNonStaticMembers$2(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.moveToNextValue;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.getErrorConfigVersion <= 0;
    }

    public V put(K k, V v) {
        int i;
        int KClassImpl$Data$declaredNonStaticMembers$22;
        int i2 = this.getErrorConfigVersion;
        if (k == null) {
            KClassImpl$Data$declaredNonStaticMembers$22 = PlaceComponentResult();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(k, hashCode);
        }
        if (KClassImpl$Data$declaredNonStaticMembers$22 >= 0) {
            int i3 = (KClassImpl$Data$declaredNonStaticMembers$22 << 1) + 1;
            Object[] objArr = this.moveToNextValue;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = KClassImpl$Data$declaredNonStaticMembers$22 ^ (-1);
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.moveToNextValue;
            BuiltInFictitiousFunctionClassFactory(i5);
            if (i2 != this.getErrorConfigVersion) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.moveToNextValue, 0, objArr2.length);
            }
            MyBillsEntityDataFactory(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.moveToNextValue;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.getErrorConfigVersion - i4) << 1);
        }
        int i7 = this.getErrorConfigVersion;
        if (i2 == i7) {
            int[] iArr4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.moveToNextValue;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.getErrorConfigVersion = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void KClassImpl$Data$declaredNonStaticMembers$2(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.getErrorConfigVersion;
        PlaceComponentResult(this.getErrorConfigVersion + i);
        if (this.getErrorConfigVersion == 0) {
            if (i > 0) {
                System.arraycopy(simpleArrayMap.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, i);
                System.arraycopy(simpleArrayMap.moveToNextValue, 0, this.moveToNextValue, 0, i << 1);
                this.getErrorConfigVersion = i;
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            Object[] objArr = simpleArrayMap.moveToNextValue;
            int i3 = i2 << 1;
            put(objArr[i3], objArr[i3 + 1]);
        }
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V MyBillsEntityDataFactory(int i) {
        Object[] objArr = this.moveToNextValue;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.getErrorConfigVersion;
        int i4 = 0;
        if (i3 <= 1) {
            MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, objArr, i3);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = ContainerHelpers.MyBillsEntityDataFactory;
            this.moveToNextValue = ContainerHelpers.BuiltInFictitiousFunctionClassFactory;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (iArr.length > 8 && i3 < iArr.length / 3) {
                BuiltInFictitiousFunctionClassFactory(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.getErrorConfigVersion) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0, i);
                    System.arraycopy(objArr, 0, this.moveToNextValue, 0, i2);
                }
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, this.NetworkUserEntityData$$ExternalSyntheticLambda0, i, i7);
                    System.arraycopy(objArr, i6 << 1, this.moveToNextValue, i2, i7 << 1);
                }
            } else {
                if (i < i5) {
                    int i8 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(iArr, i8, iArr, i, i9);
                    Object[] objArr2 = this.moveToNextValue;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i2, i9 << 1);
                }
                Object[] objArr3 = this.moveToNextValue;
                int i10 = i5 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            }
            i4 = i5;
        }
        if (i3 != this.getErrorConfigVersion) {
            throw new ConcurrentModificationException();
        }
        this.getErrorConfigVersion = i4;
        return v;
    }

    public int size() {
        return this.getErrorConfigVersion;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i = 0; i < this.getErrorConfigVersion; i++) {
                try {
                    int i2 = i << 1;
                    Object obj2 = this.moveToNextValue[i2];
                    Object obj3 = this.moveToNextValue[i2 + 1];
                    Object obj4 = simpleArrayMap.get(obj2);
                    if (obj3 == null) {
                        if (obj4 != null || !simpleArrayMap.containsKey(obj2)) {
                            return false;
                        }
                    } else if (!obj3.equals(obj4)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.getErrorConfigVersion; i3++) {
                try {
                    int i4 = i3 << 1;
                    Object obj5 = this.moveToNextValue[i4];
                    Object obj6 = this.moveToNextValue[i4 + 1];
                    Object obj7 = map.get(obj5);
                    if (obj6 == null) {
                        if (obj7 != null || !map.containsKey(obj5)) {
                            return false;
                        }
                    } else if (!obj6.equals(obj7)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Object[] objArr = this.moveToNextValue;
        int i = this.getErrorConfigVersion;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.getErrorConfigVersion * 28);
        sb.append('{');
        for (int i = 0; i < this.getErrorConfigVersion; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = i << 1;
            Object obj = this.moveToNextValue[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object obj2 = this.moveToNextValue[i2 + 1];
            if (obj2 != this) {
                sb.append(obj2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean containsKey(Object obj) {
        return (obj == null ? PlaceComponentResult() : KClassImpl$Data$declaredNonStaticMembers$2(obj, obj.hashCode())) >= 0;
    }

    public V getOrDefault(Object obj, V v) {
        int PlaceComponentResult2 = obj == null ? PlaceComponentResult() : KClassImpl$Data$declaredNonStaticMembers$2(obj, obj.hashCode());
        return PlaceComponentResult2 >= 0 ? (V) this.moveToNextValue[(PlaceComponentResult2 << 1) + 1] : v;
    }

    public V remove(Object obj) {
        int PlaceComponentResult2 = obj == null ? PlaceComponentResult() : KClassImpl$Data$declaredNonStaticMembers$2(obj, obj.hashCode());
        if (PlaceComponentResult2 >= 0) {
            return MyBillsEntityDataFactory(PlaceComponentResult2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int PlaceComponentResult2 = obj == null ? PlaceComponentResult() : KClassImpl$Data$declaredNonStaticMembers$2(obj, obj.hashCode());
        if (PlaceComponentResult2 >= 0) {
            Object obj3 = this.moveToNextValue[(PlaceComponentResult2 << 1) + 1];
            if (obj2 == obj3 || (obj2 != null && obj2.equals(obj3))) {
                MyBillsEntityDataFactory(PlaceComponentResult2);
                return true;
            }
            return false;
        }
        return false;
    }

    public V replace(K k, V v) {
        int PlaceComponentResult2 = k == null ? PlaceComponentResult() : KClassImpl$Data$declaredNonStaticMembers$2(k, k.hashCode());
        if (PlaceComponentResult2 >= 0) {
            return KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, (int) v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int PlaceComponentResult2 = k == null ? PlaceComponentResult() : KClassImpl$Data$declaredNonStaticMembers$2(k, k.hashCode());
        if (PlaceComponentResult2 >= 0) {
            Object obj = this.moveToNextValue[(PlaceComponentResult2 << 1) + 1];
            if (obj == v || (v != null && v.equals(obj))) {
                KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2, (int) v2);
                return true;
            }
            return false;
        }
        return false;
    }
}
