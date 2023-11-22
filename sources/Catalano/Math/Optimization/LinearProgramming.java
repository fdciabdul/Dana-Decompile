package Catalano.Math.Optimization;

import Catalano.Math.Optimization.Constraint;

/* loaded from: classes6.dex */
public class LinearProgramming {

    /* loaded from: classes6.dex */
    public enum Objective {
        Minimize,
        Maximize
    }

    /* renamed from: Catalano.Math.Optimization.LinearProgramming$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Constraint.Symbol.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Constraint.Symbol.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Constraint.Symbol.EQUAL_TO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Constraint.Symbol.GREATER_THAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
