package j$.util;

/* loaded from: classes.dex */
public final class Optional<T> {
    private static final Optional KClassImpl$Data$declaredNonStaticMembers$2 = new Optional();
    public final Object PlaceComponentResult;

    private Optional() {
        this.PlaceComponentResult = null;
    }

    private Optional(Object obj) {
        this.PlaceComponentResult = obj;
    }

    public static <T> Optional<T> MyBillsEntityDataFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static <T> Optional<T> MyBillsEntityDataFactory(T t) {
        return new Optional<>(t);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Optional) {
            return Objects.MyBillsEntityDataFactory(this.PlaceComponentResult, ((Optional) obj).PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.PlaceComponentResult;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        Object obj = this.PlaceComponentResult;
        return obj != null ? String.format("Optional[%s]", obj) : "Optional.empty";
    }

    public static <T> Optional<T> BuiltInFictitiousFunctionClassFactory(T t) {
        if (t == null) {
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return new Optional<>(t);
    }
}
