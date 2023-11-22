package j$.util;

import java.util.NoSuchElementException;

/* loaded from: classes6.dex */
public abstract class OptionalConversions {
    public static OptionalInt BuiltInFictitiousFunctionClassFactory(java.util.OptionalInt optionalInt) {
        OptionalInt optionalInt2;
        if (optionalInt == null) {
            return null;
        }
        if (optionalInt.isPresent()) {
            return OptionalInt.MyBillsEntityDataFactory(optionalInt.getAsInt());
        }
        optionalInt2 = OptionalInt.getAuthRequestContext;
        return optionalInt2;
    }

    public static Optional KClassImpl$Data$declaredNonStaticMembers$2(java.util.Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.MyBillsEntityDataFactory(optional.get()) : Optional.MyBillsEntityDataFactory();
    }

    public static OptionalLong KClassImpl$Data$declaredNonStaticMembers$2(java.util.OptionalLong optionalLong) {
        OptionalLong optionalLong2;
        if (optionalLong == null) {
            return null;
        }
        if (optionalLong.isPresent()) {
            return OptionalLong.PlaceComponentResult(optionalLong.getAsLong());
        }
        optionalLong2 = OptionalLong.MyBillsEntityDataFactory;
        return optionalLong2;
    }

    public static OptionalDouble MyBillsEntityDataFactory(java.util.OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? OptionalDouble.KClassImpl$Data$declaredNonStaticMembers$2(optionalDouble.getAsDouble()) : OptionalDouble.PlaceComponentResult();
    }

    public static java.util.Optional MyBillsEntityDataFactory(Optional optional) {
        if (optional == null) {
            return null;
        }
        if (optional.KClassImpl$Data$declaredNonStaticMembers$2()) {
            Object obj = optional.PlaceComponentResult;
            if (obj != null) {
                return java.util.Optional.of(obj);
            }
            throw new NoSuchElementException("No value present");
        }
        return java.util.Optional.empty();
    }

    public static java.util.OptionalDouble PlaceComponentResult(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        if (optionalDouble.BuiltInFictitiousFunctionClassFactory()) {
            if (optionalDouble.getAuthRequestContext) {
                return java.util.OptionalDouble.of(optionalDouble.PlaceComponentResult);
            }
            throw new NoSuchElementException("No value present");
        }
        return java.util.OptionalDouble.empty();
    }

    public static java.util.OptionalInt KClassImpl$Data$declaredNonStaticMembers$2(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        if (optionalInt.PlaceComponentResult()) {
            if (optionalInt.BuiltInFictitiousFunctionClassFactory) {
                return java.util.OptionalInt.of(optionalInt.MyBillsEntityDataFactory);
            }
            throw new NoSuchElementException("No value present");
        }
        return java.util.OptionalInt.empty();
    }

    public static java.util.OptionalLong getAuthRequestContext(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        if (optionalLong.MyBillsEntityDataFactory()) {
            if (optionalLong.PlaceComponentResult) {
                return java.util.OptionalLong.of(optionalLong.getAuthRequestContext);
            }
            throw new NoSuchElementException("No value present");
        }
        return java.util.OptionalLong.empty();
    }
}
