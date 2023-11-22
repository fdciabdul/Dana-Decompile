package j$.util.function;

/* loaded from: classes.dex */
public interface IntPredicate {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntPredicate {
        final /* synthetic */ java.util.function.IntPredicate PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntPredicate intPredicate) {
            this.PlaceComponentResult = intPredicate;
        }

        public static /* synthetic */ IntPredicate KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.IntPredicate intPredicate) {
            if (intPredicate == null) {
                return null;
            }
            return intPredicate instanceof Wrapper ? IntPredicate.this : new VivifiedWrapper(intPredicate);
        }

        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return this.PlaceComponentResult.test(i);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.IntPredicate {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntPredicate KClassImpl$Data$declaredNonStaticMembers$2(IntPredicate intPredicate) {
            if (intPredicate == null) {
                return null;
            }
            return intPredicate instanceof VivifiedWrapper ? ((VivifiedWrapper) intPredicate).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.IntPredicate
        public final /* synthetic */ boolean test(int i) {
            return ((VivifiedWrapper) IntPredicate.this).KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // java.util.function.IntPredicate
        public final /* synthetic */ java.util.function.IntPredicate and(java.util.function.IntPredicate intPredicate) {
            java.util.function.IntPredicate wrapper;
            IntPredicate intPredicate2 = IntPredicate.this;
            IntPredicate KClassImpl$Data$declaredNonStaticMembers$2 = VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate);
            java.util.function.IntPredicate intPredicate3 = ((VivifiedWrapper) intPredicate2).PlaceComponentResult;
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                wrapper = null;
            } else {
                wrapper = KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult : new Wrapper();
            }
            IntPredicate KClassImpl$Data$declaredNonStaticMembers$22 = VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate3.and(wrapper));
            if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$22 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$22).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.IntPredicate
        public final /* synthetic */ java.util.function.IntPredicate negate() {
            IntPredicate KClassImpl$Data$declaredNonStaticMembers$2 = VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(((VivifiedWrapper) IntPredicate.this).PlaceComponentResult.negate());
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.IntPredicate
        public final /* synthetic */ java.util.function.IntPredicate or(java.util.function.IntPredicate intPredicate) {
            java.util.function.IntPredicate wrapper;
            IntPredicate intPredicate2 = IntPredicate.this;
            IntPredicate KClassImpl$Data$declaredNonStaticMembers$2 = VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate);
            java.util.function.IntPredicate intPredicate3 = ((VivifiedWrapper) intPredicate2).PlaceComponentResult;
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                wrapper = null;
            } else {
                wrapper = KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult : new Wrapper();
            }
            IntPredicate KClassImpl$Data$declaredNonStaticMembers$22 = VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(intPredicate3.or(wrapper));
            if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$22 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$22).PlaceComponentResult : new Wrapper();
        }
    }
}
