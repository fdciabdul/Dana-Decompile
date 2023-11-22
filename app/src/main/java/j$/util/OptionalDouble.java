package j$.util;

/* loaded from: classes.dex */
public final class OptionalDouble {
    private static final OptionalDouble KClassImpl$Data$declaredNonStaticMembers$2 = new OptionalDouble();
    final double PlaceComponentResult;
    final boolean getAuthRequestContext;

    private OptionalDouble() {
        this.getAuthRequestContext = false;
        this.PlaceComponentResult = Double.NaN;
    }

    private OptionalDouble(double d) {
        this.getAuthRequestContext = true;
        this.PlaceComponentResult = d;
    }

    public static OptionalDouble KClassImpl$Data$declaredNonStaticMembers$2(double d) {
        return new OptionalDouble(d);
    }

    public static OptionalDouble PlaceComponentResult() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            boolean z = this.getAuthRequestContext;
            if (z && optionalDouble.getAuthRequestContext) {
                if (Double.compare(this.PlaceComponentResult, optionalDouble.PlaceComponentResult) == 0) {
                    return true;
                }
            } else if (z == optionalDouble.getAuthRequestContext) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        if (this.getAuthRequestContext) {
            long doubleToLongBits = Double.doubleToLongBits(this.PlaceComponentResult);
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
        return 0;
    }

    public final String toString() {
        return this.getAuthRequestContext ? String.format("OptionalDouble[%s]", Double.valueOf(this.PlaceComponentResult)) : "OptionalDouble.empty";
    }
}
