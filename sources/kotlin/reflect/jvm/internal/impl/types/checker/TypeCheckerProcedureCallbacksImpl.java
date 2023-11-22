package kotlin.reflect.jvm.internal.impl.types.checker;

import id.dana.danah5.constant.BridgeName;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* loaded from: classes.dex */
class TypeCheckerProcedureCallbacksImpl implements TypeCheckingProcedureCallbacks {
    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = BridgeName.CAPTURE;
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedureCallbacks
    public boolean assertEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        if (typeConstructor == null) {
            $$$reportNull$$$0(3);
        }
        if (typeConstructor2 == null) {
            $$$reportNull$$$0(4);
        }
        return typeConstructor.equals(typeConstructor2);
    }
}
