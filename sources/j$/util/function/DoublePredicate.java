package j$.util.function;

/* loaded from: classes.dex */
public interface DoublePredicate {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoublePredicate {
        final /* synthetic */ java.util.function.DoublePredicate KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoublePredicate doublePredicate) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = doublePredicate;
        }

        public static /* synthetic */ DoublePredicate MyBillsEntityDataFactory(java.util.function.DoublePredicate doublePredicate) {
            if (doublePredicate == null) {
                return null;
            }
            return doublePredicate instanceof Wrapper ? DoublePredicate.this : new VivifiedWrapper(doublePredicate);
        }

        public final /* synthetic */ boolean MyBillsEntityDataFactory(double d) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.test(d);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.DoublePredicate {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.DoublePredicate PlaceComponentResult(DoublePredicate doublePredicate) {
            if (doublePredicate == null) {
                return null;
            }
            return doublePredicate instanceof VivifiedWrapper ? ((VivifiedWrapper) doublePredicate).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.DoublePredicate
        public final /* synthetic */ boolean test(double d) {
            return ((VivifiedWrapper) DoublePredicate.this).MyBillsEntityDataFactory(d);
        }

        @Override // java.util.function.DoublePredicate
        public final /* synthetic */ java.util.function.DoublePredicate and(java.util.function.DoublePredicate doublePredicate) {
            java.util.function.DoublePredicate wrapper;
            DoublePredicate doublePredicate2 = DoublePredicate.this;
            DoublePredicate MyBillsEntityDataFactory = VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate);
            java.util.function.DoublePredicate doublePredicate3 = ((VivifiedWrapper) doublePredicate2).KClassImpl$Data$declaredNonStaticMembers$2;
            if (MyBillsEntityDataFactory == null) {
                wrapper = null;
            } else {
                wrapper = MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
            }
            DoublePredicate MyBillsEntityDataFactory2 = VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate3.and(wrapper));
            if (MyBillsEntityDataFactory2 == null) {
                return null;
            }
            return MyBillsEntityDataFactory2 instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory2).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.DoublePredicate
        public final /* synthetic */ java.util.function.DoublePredicate negate() {
            DoublePredicate MyBillsEntityDataFactory = VivifiedWrapper.MyBillsEntityDataFactory(((VivifiedWrapper) DoublePredicate.this).KClassImpl$Data$declaredNonStaticMembers$2.negate());
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            return MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.DoublePredicate
        public final /* synthetic */ java.util.function.DoublePredicate or(java.util.function.DoublePredicate doublePredicate) {
            java.util.function.DoublePredicate wrapper;
            DoublePredicate doublePredicate2 = DoublePredicate.this;
            DoublePredicate MyBillsEntityDataFactory = VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate);
            java.util.function.DoublePredicate doublePredicate3 = ((VivifiedWrapper) doublePredicate2).KClassImpl$Data$declaredNonStaticMembers$2;
            if (MyBillsEntityDataFactory == null) {
                wrapper = null;
            } else {
                wrapper = MyBillsEntityDataFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
            }
            DoublePredicate MyBillsEntityDataFactory2 = VivifiedWrapper.MyBillsEntityDataFactory(doublePredicate3.or(wrapper));
            if (MyBillsEntityDataFactory2 == null) {
                return null;
            }
            return MyBillsEntityDataFactory2 instanceof VivifiedWrapper ? ((VivifiedWrapper) MyBillsEntityDataFactory2).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }
    }
}
