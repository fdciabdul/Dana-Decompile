package androidx.collection;

/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    public static final Object getAuthRequestContext = new Object();
    public Object[] BuiltInFictitiousFunctionClassFactory;
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public long[] PlaceComponentResult;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.MyBillsEntityDataFactory = false;
        if (i == 0) {
            this.PlaceComponentResult = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2;
            this.BuiltInFictitiousFunctionClassFactory = ContainerHelpers.BuiltInFictitiousFunctionClassFactory;
            return;
        }
        int MyBillsEntityDataFactory = ContainerHelpers.MyBillsEntityDataFactory(i);
        this.PlaceComponentResult = new long[MyBillsEntityDataFactory];
        this.BuiltInFictitiousFunctionClassFactory = new Object[MyBillsEntityDataFactory];
    }

    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public final LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.PlaceComponentResult = (long[]) this.PlaceComponentResult.clone();
            longSparseArray.BuiltInFictitiousFunctionClassFactory = (Object[]) this.BuiltInFictitiousFunctionClassFactory.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final E MyBillsEntityDataFactory(long j, E e) {
        E e2;
        int KClassImpl$Data$declaredNonStaticMembers$2 = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, j);
        return (KClassImpl$Data$declaredNonStaticMembers$2 < 0 || (e2 = (E) this.BuiltInFictitiousFunctionClassFactory[KClassImpl$Data$declaredNonStaticMembers$2]) == getAuthRequestContext) ? e : e2;
    }

    public final void PlaceComponentResult(long j) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, j);
        if (KClassImpl$Data$declaredNonStaticMembers$2 >= 0) {
            Object[] objArr = this.BuiltInFictitiousFunctionClassFactory;
            Object obj = objArr[KClassImpl$Data$declaredNonStaticMembers$2];
            Object obj2 = getAuthRequestContext;
            if (obj != obj2) {
                objArr[KClassImpl$Data$declaredNonStaticMembers$2] = obj2;
                this.MyBillsEntityDataFactory = true;
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        long[] jArr = this.PlaceComponentResult;
        Object[] objArr = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != getAuthRequestContext) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.MyBillsEntityDataFactory = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
    }

    public final void getAuthRequestContext(long j, E e) {
        int KClassImpl$Data$declaredNonStaticMembers$2 = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, j);
        if (KClassImpl$Data$declaredNonStaticMembers$2 >= 0) {
            this.BuiltInFictitiousFunctionClassFactory[KClassImpl$Data$declaredNonStaticMembers$2] = e;
            return;
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 ^ (-1);
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i < i2) {
            Object[] objArr = this.BuiltInFictitiousFunctionClassFactory;
            if (objArr[i] == getAuthRequestContext) {
                this.PlaceComponentResult[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.MyBillsEntityDataFactory && i2 >= this.PlaceComponentResult.length) {
            BuiltInFictitiousFunctionClassFactory();
            i = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, j) ^ (-1);
        }
        int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i3 >= this.PlaceComponentResult.length) {
            int MyBillsEntityDataFactory = ContainerHelpers.MyBillsEntityDataFactory(i3 + 1);
            long[] jArr = new long[MyBillsEntityDataFactory];
            Object[] objArr2 = new Object[MyBillsEntityDataFactory];
            long[] jArr2 = this.PlaceComponentResult;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.BuiltInFictitiousFunctionClassFactory;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.PlaceComponentResult = jArr;
            this.BuiltInFictitiousFunctionClassFactory = objArr2;
        }
        int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2 - i;
        if (i4 != 0) {
            long[] jArr3 = this.PlaceComponentResult;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4);
            Object[] objArr4 = this.BuiltInFictitiousFunctionClassFactory;
            System.arraycopy(objArr4, i, objArr4, i5, this.KClassImpl$Data$declaredNonStaticMembers$2 - i);
        }
        this.PlaceComponentResult[i] = j;
        this.BuiltInFictitiousFunctionClassFactory[i] = e;
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
    }

    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.MyBillsEntityDataFactory) {
            BuiltInFictitiousFunctionClassFactory();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void getAuthRequestContext() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Object[] objArr = this.BuiltInFictitiousFunctionClassFactory;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.MyBillsEntityDataFactory = false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(long j, E e) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0 && j <= this.PlaceComponentResult[i - 1]) {
            getAuthRequestContext(j, e);
            return;
        }
        if (this.MyBillsEntityDataFactory && i >= this.PlaceComponentResult.length) {
            BuiltInFictitiousFunctionClassFactory();
        }
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 >= this.PlaceComponentResult.length) {
            int MyBillsEntityDataFactory = ContainerHelpers.MyBillsEntityDataFactory(i2 + 1);
            long[] jArr = new long[MyBillsEntityDataFactory];
            Object[] objArr = new Object[MyBillsEntityDataFactory];
            long[] jArr2 = this.PlaceComponentResult;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.BuiltInFictitiousFunctionClassFactory;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.PlaceComponentResult = jArr;
            this.BuiltInFictitiousFunctionClassFactory = objArr;
        }
        this.PlaceComponentResult[i2] = j;
        this.BuiltInFictitiousFunctionClassFactory[i2] = e;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2 + 1;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        if (this.MyBillsEntityDataFactory) {
            BuiltInFictitiousFunctionClassFactory();
        }
        return ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, j) >= 0;
    }

    public final boolean PlaceComponentResult() {
        if (this.MyBillsEntityDataFactory) {
            BuiltInFictitiousFunctionClassFactory();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2 == 0;
    }

    public String toString() {
        if (this.MyBillsEntityDataFactory) {
            BuiltInFictitiousFunctionClassFactory();
        }
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            if (this.MyBillsEntityDataFactory) {
                BuiltInFictitiousFunctionClassFactory();
            }
            sb.append(this.PlaceComponentResult[i2]);
            sb.append('=');
            if (this.MyBillsEntityDataFactory) {
                BuiltInFictitiousFunctionClassFactory();
            }
            Object obj = this.BuiltInFictitiousFunctionClassFactory[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
