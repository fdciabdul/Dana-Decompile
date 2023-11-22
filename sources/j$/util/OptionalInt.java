package j$.util;

/* loaded from: classes.dex */
public final class OptionalInt {
    private static final OptionalInt getAuthRequestContext = new OptionalInt();
    final boolean BuiltInFictitiousFunctionClassFactory;
    final int MyBillsEntityDataFactory;

    private OptionalInt() {
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.MyBillsEntityDataFactory = 0;
    }

    private OptionalInt(int i) {
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.MyBillsEntityDataFactory = i;
    }

    public static OptionalInt MyBillsEntityDataFactory(int i) {
        return new OptionalInt(i);
    }

    public final boolean PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            if (z && optionalInt.BuiltInFictitiousFunctionClassFactory) {
                if (this.MyBillsEntityDataFactory == optionalInt.MyBillsEntityDataFactory) {
                    return true;
                }
            } else if (z == optionalInt.BuiltInFictitiousFunctionClassFactory) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return this.MyBillsEntityDataFactory;
        }
        return 0;
    }

    public final String toString() {
        return this.BuiltInFictitiousFunctionClassFactory ? String.format("OptionalInt[%s]", Integer.valueOf(this.MyBillsEntityDataFactory)) : "OptionalInt.empty";
    }
}
