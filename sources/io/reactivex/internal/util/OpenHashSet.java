package io.reactivex.internal.util;

/* loaded from: classes.dex */
public final class OpenHashSet<T> {
    int BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    public int MyBillsEntityDataFactory;
    public T[] PlaceComponentResult;
    final float getAuthRequestContext;

    public OpenHashSet() {
        this((byte) 0);
    }

    private OpenHashSet(byte b) {
        this.getAuthRequestContext = 0.75f;
        int BuiltInFictitiousFunctionClassFactory = Pow2.BuiltInFictitiousFunctionClassFactory(16);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory - 1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) (BuiltInFictitiousFunctionClassFactory * 0.75f);
        this.PlaceComponentResult = (T[]) new Object[BuiltInFictitiousFunctionClassFactory];
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(T t) {
        T t2;
        T t3;
        T[] tArr = this.PlaceComponentResult;
        int i = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = t.hashCode() * (-1640531527);
        int i2 = (hashCode ^ (hashCode >>> 16)) & i;
        T t4 = tArr[i2];
        if (t4 != null) {
            if (t4.equals(t)) {
                return false;
            }
            do {
                i2 = (i2 + 1) & i;
                t3 = tArr[i2];
                if (t3 == null) {
                }
            } while (!t3.equals(t));
            return false;
        }
        tArr[i2] = t;
        int i3 = this.MyBillsEntityDataFactory + 1;
        this.MyBillsEntityDataFactory = i3;
        if (i3 >= this.KClassImpl$Data$declaredNonStaticMembers$2) {
            T[] tArr2 = this.PlaceComponentResult;
            int length = tArr2.length;
            int i4 = length << 1;
            int i5 = i4 - 1;
            T[] tArr3 = (T[]) new Object[i4];
            while (i3 != 0) {
                do {
                    length--;
                    t2 = tArr2[length];
                } while (t2 == null);
                int hashCode2 = t2.hashCode() * (-1640531527);
                int i6 = (hashCode2 ^ (hashCode2 >>> 16)) & i5;
                if (tArr3[i6] == null) {
                    tArr3[i6] = tArr2[length];
                    i3--;
                }
                do {
                    i6 = (i6 + 1) & i5;
                } while (tArr3[i6] != null);
                tArr3[i6] = tArr2[length];
                i3--;
            }
            this.BuiltInFictitiousFunctionClassFactory = i5;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) (i4 * this.getAuthRequestContext);
            this.PlaceComponentResult = tArr3;
        }
        return true;
    }

    public final boolean getAuthRequestContext(T t) {
        T t2;
        T[] tArr = this.PlaceComponentResult;
        int i = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = t.hashCode() * (-1640531527);
        int i2 = (hashCode ^ (hashCode >>> 16)) & i;
        T t3 = tArr[i2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return BuiltInFictitiousFunctionClassFactory(i2, tArr, i);
        }
        do {
            i2 = (i2 + 1) & i;
            t2 = tArr[i2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return BuiltInFictitiousFunctionClassFactory(i2, tArr, i);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.MyBillsEntityDataFactory--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int hashCode = t.hashCode() * (-1640531527);
                int i5 = (hashCode ^ (hashCode >>> 16)) & i2;
                if (i > i3) {
                    if (i >= i5 && i5 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < i5 && i5 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }
}
