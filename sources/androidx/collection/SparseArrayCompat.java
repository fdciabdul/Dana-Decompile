package androidx.collection;

/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object BuiltInFictitiousFunctionClassFactory = new Object();
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private Object[] MyBillsEntityDataFactory;
    private int[] PlaceComponentResult;
    private boolean getAuthRequestContext;

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int i) {
        this.getAuthRequestContext = false;
        if (i == 0) {
            this.PlaceComponentResult = ContainerHelpers.MyBillsEntityDataFactory;
            this.MyBillsEntityDataFactory = ContainerHelpers.BuiltInFictitiousFunctionClassFactory;
            return;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(i);
        this.PlaceComponentResult = new int[KClassImpl$Data$declaredNonStaticMembers$2];
        this.MyBillsEntityDataFactory = new Object[KClassImpl$Data$declaredNonStaticMembers$2];
    }

    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.PlaceComponentResult = (int[]) this.PlaceComponentResult.clone();
            sparseArrayCompat.MyBillsEntityDataFactory = (Object[]) this.MyBillsEntityDataFactory.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public E BuiltInFictitiousFunctionClassFactory(int i) {
        return getAuthRequestContext(i, null);
    }

    public E getAuthRequestContext(int i, E e) {
        E e2;
        int BuiltInFictitiousFunctionClassFactory2 = ContainerHelpers.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        return (BuiltInFictitiousFunctionClassFactory2 < 0 || (e2 = (E) this.MyBillsEntityDataFactory[BuiltInFictitiousFunctionClassFactory2]) == BuiltInFictitiousFunctionClassFactory) ? e : e2;
    }

    public void getAuthRequestContext(int i) {
        int BuiltInFictitiousFunctionClassFactory2 = ContainerHelpers.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        if (BuiltInFictitiousFunctionClassFactory2 >= 0) {
            Object[] objArr = this.MyBillsEntityDataFactory;
            Object obj = objArr[BuiltInFictitiousFunctionClassFactory2];
            Object obj2 = BuiltInFictitiousFunctionClassFactory;
            if (obj != obj2) {
                objArr[BuiltInFictitiousFunctionClassFactory2] = obj2;
                this.getAuthRequestContext = true;
            }
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        Object[] objArr = this.MyBillsEntityDataFactory;
        Object obj = objArr[i];
        Object obj2 = BuiltInFictitiousFunctionClassFactory;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.getAuthRequestContext = true;
        }
    }

    public E KClassImpl$Data$declaredNonStaticMembers$2(int i, E e) {
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(i);
        if (MyBillsEntityDataFactory >= 0) {
            Object[] objArr = this.MyBillsEntityDataFactory;
            E e2 = (E) objArr[MyBillsEntityDataFactory];
            objArr[MyBillsEntityDataFactory] = e;
            return e2;
        }
        return null;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int[] iArr = this.PlaceComponentResult;
        Object[] objArr = this.MyBillsEntityDataFactory;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != BuiltInFictitiousFunctionClassFactory) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.getAuthRequestContext = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
    }

    public void PlaceComponentResult(int i, E e) {
        int BuiltInFictitiousFunctionClassFactory2 = ContainerHelpers.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, i);
        if (BuiltInFictitiousFunctionClassFactory2 >= 0) {
            this.MyBillsEntityDataFactory[BuiltInFictitiousFunctionClassFactory2] = e;
            return;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory2 ^ (-1);
        int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 < i3) {
            Object[] objArr = this.MyBillsEntityDataFactory;
            if (objArr[i2] == BuiltInFictitiousFunctionClassFactory) {
                this.PlaceComponentResult[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.getAuthRequestContext && i3 >= this.PlaceComponentResult.length) {
            KClassImpl$Data$declaredNonStaticMembers$2();
            i2 = ContainerHelpers.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, i) ^ (-1);
        }
        int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i4 >= this.PlaceComponentResult.length) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(i4 + 1);
            int[] iArr = new int[KClassImpl$Data$declaredNonStaticMembers$2];
            Object[] objArr2 = new Object[KClassImpl$Data$declaredNonStaticMembers$2];
            int[] iArr2 = this.PlaceComponentResult;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.MyBillsEntityDataFactory;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.PlaceComponentResult = iArr;
            this.MyBillsEntityDataFactory = objArr2;
        }
        int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2 - i2;
        if (i5 != 0) {
            int[] iArr3 = this.PlaceComponentResult;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5);
            Object[] objArr4 = this.MyBillsEntityDataFactory;
            System.arraycopy(objArr4, i2, objArr4, i6, this.KClassImpl$Data$declaredNonStaticMembers$2 - i2);
        }
        this.PlaceComponentResult[i2] = i;
        this.MyBillsEntityDataFactory[i2] = e;
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
    }

    public int MyBillsEntityDataFactory() {
        if (this.getAuthRequestContext) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public boolean BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory() == 0;
    }

    public int PlaceComponentResult(int i) {
        if (this.getAuthRequestContext) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return this.PlaceComponentResult[i];
    }

    public E lookAheadTest(int i) {
        if (this.getAuthRequestContext) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return (E) this.MyBillsEntityDataFactory[i];
    }

    public int MyBillsEntityDataFactory(int i) {
        if (this.getAuthRequestContext) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return ContainerHelpers.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, i);
    }

    public int PlaceComponentResult(E e) {
        if (this.getAuthRequestContext) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
            if (this.MyBillsEntityDataFactory[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean KClassImpl$Data$declaredNonStaticMembers$2(E e) {
        return PlaceComponentResult((SparseArrayCompat<E>) e) >= 0;
    }

    public void PlaceComponentResult() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Object[] objArr = this.MyBillsEntityDataFactory;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.getAuthRequestContext = false;
    }

    public void MyBillsEntityDataFactory(int i, E e) {
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 != 0 && i <= this.PlaceComponentResult[i2 - 1]) {
            PlaceComponentResult(i, e);
            return;
        }
        if (this.getAuthRequestContext && i2 >= this.PlaceComponentResult.length) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i3 >= this.PlaceComponentResult.length) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = ContainerHelpers.KClassImpl$Data$declaredNonStaticMembers$2(i3 + 1);
            int[] iArr = new int[KClassImpl$Data$declaredNonStaticMembers$2];
            Object[] objArr = new Object[KClassImpl$Data$declaredNonStaticMembers$2];
            int[] iArr2 = this.PlaceComponentResult;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.MyBillsEntityDataFactory;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.PlaceComponentResult = iArr;
            this.MyBillsEntityDataFactory = objArr;
        }
        this.PlaceComponentResult[i3] = i;
        this.MyBillsEntityDataFactory[i3] = e;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i3 + 1;
    }

    public String toString() {
        if (MyBillsEntityDataFactory() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.KClassImpl$Data$declaredNonStaticMembers$2 * 28);
        sb.append('{');
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(PlaceComponentResult(i));
            sb.append('=');
            E lookAheadTest = lookAheadTest(i);
            if (lookAheadTest != this) {
                sb.append(lookAheadTest);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
