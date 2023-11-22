package androidx.collection;

import androidx.collection.MapCollections;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static Object[] BuiltInFictitiousFunctionClassFactory;
    private static Object[] NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static int getErrorConfigVersion;
    private static int lookAheadTest;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    Object[] PlaceComponentResult;
    private MapCollections<E, E> moveToNextValue;
    private int[] scheduleImpl;
    private static final int[] getAuthRequestContext = new int[0];
    private static final Object[] MyBillsEntityDataFactory = new Object[0];

    final int MyBillsEntityDataFactory(Object obj, int i) {
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 == 0) {
            return -1;
        }
        int BuiltInFictitiousFunctionClassFactory2 = ContainerHelpers.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl, i2, i);
        if (BuiltInFictitiousFunctionClassFactory2 >= 0 && !obj.equals(this.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory2])) {
            int i3 = BuiltInFictitiousFunctionClassFactory2 + 1;
            while (i3 < i2 && this.scheduleImpl[i3] == i) {
                if (obj.equals(this.PlaceComponentResult[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = BuiltInFictitiousFunctionClassFactory2 - 1; i4 >= 0 && this.scheduleImpl[i4] == i; i4--) {
                if (obj.equals(this.PlaceComponentResult[i4])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    final int PlaceComponentResult() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 0) {
            return -1;
        }
        int BuiltInFictitiousFunctionClassFactory2 = ContainerHelpers.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl, i, 0);
        if (BuiltInFictitiousFunctionClassFactory2 >= 0 && this.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory2] != null) {
            int i2 = BuiltInFictitiousFunctionClassFactory2 + 1;
            while (i2 < i && this.scheduleImpl[i2] == 0) {
                if (this.PlaceComponentResult[i2] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = BuiltInFictitiousFunctionClassFactory2 - 1; i3 >= 0 && this.scheduleImpl[i3] == 0; i3--) {
                if (this.PlaceComponentResult[i3] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    private void PlaceComponentResult(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (objArr != null) {
                    this.PlaceComponentResult = objArr;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = (Object[]) objArr[0];
                    this.scheduleImpl = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    lookAheadTest--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = BuiltInFictitiousFunctionClassFactory;
                if (objArr2 != null) {
                    this.PlaceComponentResult = objArr2;
                    BuiltInFictitiousFunctionClassFactory = (Object[]) objArr2[0];
                    this.scheduleImpl = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    getErrorConfigVersion--;
                    return;
                }
            }
        }
        this.scheduleImpl = new int[i];
        this.PlaceComponentResult = new Object[i];
    }

    private static void MyBillsEntityDataFactory(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (lookAheadTest < 10) {
                    objArr[0] = NetworkUserEntityData$$ExternalSyntheticLambda0;
                    objArr[1] = iArr;
                    while (true) {
                        i--;
                        if (i < 2) {
                            break;
                        }
                        objArr[i] = null;
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = objArr;
                    lookAheadTest++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (getErrorConfigVersion < 10) {
                    objArr[0] = BuiltInFictitiousFunctionClassFactory;
                    objArr[1] = iArr;
                    while (true) {
                        i--;
                        if (i < 2) {
                            break;
                        }
                        objArr[i] = null;
                    }
                    BuiltInFictitiousFunctionClassFactory = objArr;
                    getErrorConfigVersion++;
                }
            }
        }
    }

    public ArraySet() {
        this(0);
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.scheduleImpl = getAuthRequestContext;
            this.PlaceComponentResult = MyBillsEntityDataFactory;
        } else {
            PlaceComponentResult(i);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0) {
            MyBillsEntityDataFactory(this.scheduleImpl, this.PlaceComponentResult, i);
            this.scheduleImpl = getAuthRequestContext;
            this.PlaceComponentResult = MyBillsEntityDataFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e) {
        int i;
        int MyBillsEntityDataFactory2;
        if (e == null) {
            MyBillsEntityDataFactory2 = PlaceComponentResult();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(e, hashCode);
        }
        if (MyBillsEntityDataFactory2 >= 0) {
            return false;
        }
        int i2 = MyBillsEntityDataFactory2 ^ (-1);
        int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int[] iArr = this.scheduleImpl;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.PlaceComponentResult;
            PlaceComponentResult(i4);
            int[] iArr2 = this.scheduleImpl;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.PlaceComponentResult, 0, objArr.length);
            }
            MyBillsEntityDataFactory(iArr, objArr, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 < i5) {
            int[] iArr3 = this.scheduleImpl;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.PlaceComponentResult;
            System.arraycopy(objArr2, i2, objArr2, i6, this.KClassImpl$Data$declaredNonStaticMembers$2 - i2);
        }
        this.scheduleImpl[i2] = i;
        this.PlaceComponentResult[i2] = e;
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
        return true;
    }

    public final E KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        Object[] objArr = this.PlaceComponentResult;
        E e = (E) objArr[i];
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 <= 1) {
            MyBillsEntityDataFactory(this.scheduleImpl, objArr, i2);
            this.scheduleImpl = getAuthRequestContext;
            this.PlaceComponentResult = MyBillsEntityDataFactory;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        } else {
            int[] iArr = this.scheduleImpl;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                PlaceComponentResult(i2 > 8 ? i2 + (i2 >> 1) : 8);
                this.KClassImpl$Data$declaredNonStaticMembers$2--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.scheduleImpl, 0, i);
                    System.arraycopy(objArr, 0, this.PlaceComponentResult, 0, i);
                }
                int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i < i3) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.scheduleImpl, i, i3 - i);
                    System.arraycopy(objArr, i4, this.PlaceComponentResult, i, this.KClassImpl$Data$declaredNonStaticMembers$2 - i);
                }
            } else {
                int i5 = i2 - 1;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
                if (i < i5) {
                    int i6 = i + 1;
                    System.arraycopy(iArr, i6, iArr, i, i5 - i);
                    Object[] objArr2 = this.PlaceComponentResult;
                    System.arraycopy(objArr2, i6, objArr2, i, this.KClassImpl$Data$declaredNonStaticMembers$2 - i);
                }
                this.PlaceComponentResult[this.KClassImpl$Data$declaredNonStaticMembers$2] = null;
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Object[] objArr = new Object[i];
        System.arraycopy(this.PlaceComponentResult, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.KClassImpl$Data$declaredNonStaticMembers$2) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
        System.arraycopy(this.PlaceComponentResult, 0, tArr, 0, this.KClassImpl$Data$declaredNonStaticMembers$2);
        int length = tArr.length;
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                try {
                    if (!set.contains(this.PlaceComponentResult[i])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.scheduleImpl;
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.KClassImpl$Data$declaredNonStaticMembers$2 * 14);
        sb.append('{');
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.PlaceComponentResult[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2 + collection.size();
        int[] iArr = this.scheduleImpl;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.PlaceComponentResult;
            PlaceComponentResult(size);
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.scheduleImpl, 0, i);
                System.arraycopy(objArr, 0, this.PlaceComponentResult, 0, this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            MyBillsEntityDataFactory(iArr, objArr, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.KClassImpl$Data$declaredNonStaticMembers$2 - 1; i >= 0; i--) {
            if (!collection.contains(this.PlaceComponentResult[i])) {
                KClassImpl$Data$declaredNonStaticMembers$2(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? PlaceComponentResult() : MyBillsEntityDataFactory(obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<E> iterator() {
        if (this.moveToNextValue == null) {
            this.moveToNextValue = new MapCollections<E, E>() { // from class: androidx.collection.ArraySet.1
                @Override // androidx.collection.MapCollections
                protected final int PlaceComponentResult() {
                    return ArraySet.this.KClassImpl$Data$declaredNonStaticMembers$2;
                }

                @Override // androidx.collection.MapCollections
                protected final Object MyBillsEntityDataFactory(int i, int i2) {
                    return ArraySet.this.PlaceComponentResult[i];
                }

                @Override // androidx.collection.MapCollections
                protected final int PlaceComponentResult(Object obj) {
                    ArraySet arraySet = ArraySet.this;
                    return obj == null ? arraySet.PlaceComponentResult() : arraySet.MyBillsEntityDataFactory(obj, obj.hashCode());
                }

                @Override // androidx.collection.MapCollections
                protected final int MyBillsEntityDataFactory(Object obj) {
                    ArraySet arraySet = ArraySet.this;
                    return obj == null ? arraySet.PlaceComponentResult() : arraySet.MyBillsEntityDataFactory(obj, obj.hashCode());
                }

                @Override // androidx.collection.MapCollections
                protected final Map<E, E> MyBillsEntityDataFactory() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                protected final void BuiltInFictitiousFunctionClassFactory(E e, E e2) {
                    ArraySet.this.add(e);
                }

                @Override // androidx.collection.MapCollections
                protected final E BuiltInFictitiousFunctionClassFactory(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // androidx.collection.MapCollections
                protected final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                    ArraySet.this.KClassImpl$Data$declaredNonStaticMembers$2(i);
                }

                @Override // androidx.collection.MapCollections
                protected final void getAuthRequestContext() {
                    ArraySet.this.clear();
                }
            };
        }
        MapCollections<E, E> mapCollections = this.moveToNextValue;
        if (mapCollections.getAuthRequestContext == null) {
            mapCollections.getAuthRequestContext = new MapCollections.KeySet();
        }
        return mapCollections.getAuthRequestContext.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int PlaceComponentResult = obj == null ? PlaceComponentResult() : MyBillsEntityDataFactory(obj, obj.hashCode());
        if (PlaceComponentResult >= 0) {
            KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult);
            return true;
        }
        return false;
    }
}
