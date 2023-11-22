package j$.util.function;

/* loaded from: classes.dex */
public interface Predicate<T> {

    /* renamed from: j$.util.function.Predicate$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC<T> {
        public static Predicate BuiltInFictitiousFunctionClassFactory(Predicate predicate, Predicate predicate2) {
            return new Predicate$$ExternalSyntheticLambda2(predicate, predicate2, 1);
        }

        public static Predicate KClassImpl$Data$declaredNonStaticMembers$2(Predicate predicate, Predicate predicate2) {
            return new Predicate$$ExternalSyntheticLambda2(predicate, predicate2, 0);
        }

        public static Predicate PlaceComponentResult(Predicate predicate) {
            return new Predicate$$ExternalSyntheticLambda3(0, predicate);
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t);

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements Predicate {
        final /* synthetic */ java.util.function.Predicate getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.function.Predicate predicate) {
            this.getAuthRequestContext = predicate;
        }

        public static /* synthetic */ Predicate BuiltInFictitiousFunctionClassFactory(java.util.function.Predicate predicate) {
            if (predicate == null) {
                return null;
            }
            return predicate instanceof Wrapper ? Predicate.this : new VivifiedWrapper(predicate);
        }

        @Override // j$.util.function.Predicate
        public final /* synthetic */ boolean test(Object obj) {
            return this.getAuthRequestContext.test(obj);
        }

        @Override // j$.util.function.Predicate
        public final /* synthetic */ Predicate and(Predicate predicate) {
            java.util.function.Predicate<T> and = this.getAuthRequestContext.and(Wrapper.MyBillsEntityDataFactory(predicate));
            if (and == null) {
                return null;
            }
            return and instanceof Wrapper ? Predicate.this : new VivifiedWrapper(and);
        }

        @Override // j$.util.function.Predicate
        public final /* synthetic */ Predicate negate() {
            java.util.function.Predicate<T> negate = this.getAuthRequestContext.negate();
            if (negate == null) {
                return null;
            }
            return negate instanceof Wrapper ? Predicate.this : new VivifiedWrapper(negate);
        }

        @Override // j$.util.function.Predicate
        public final /* synthetic */ Predicate or(Predicate predicate) {
            java.util.function.Predicate<T> or = this.getAuthRequestContext.or(Wrapper.MyBillsEntityDataFactory(predicate));
            if (or == null) {
                return null;
            }
            return or instanceof Wrapper ? Predicate.this : new VivifiedWrapper(or);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.Predicate {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.Predicate MyBillsEntityDataFactory(Predicate predicate) {
            if (predicate == null) {
                return null;
            }
            return predicate instanceof VivifiedWrapper ? ((VivifiedWrapper) predicate).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.Predicate
        public final /* synthetic */ boolean test(Object obj) {
            return Predicate.this.test(obj);
        }

        @Override // java.util.function.Predicate
        public final /* synthetic */ java.util.function.Predicate and(java.util.function.Predicate predicate) {
            Predicate<T> and = Predicate.this.and(VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
            if (and == null) {
                return null;
            }
            return and instanceof VivifiedWrapper ? ((VivifiedWrapper) and).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.Predicate
        public final /* synthetic */ java.util.function.Predicate negate() {
            Predicate<T> negate = Predicate.this.negate();
            if (negate == null) {
                return null;
            }
            return negate instanceof VivifiedWrapper ? ((VivifiedWrapper) negate).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.Predicate
        public final /* synthetic */ java.util.function.Predicate or(java.util.function.Predicate predicate) {
            Predicate<T> or = Predicate.this.or(VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(predicate));
            if (or == null) {
                return null;
            }
            return or instanceof VivifiedWrapper ? ((VivifiedWrapper) or).getAuthRequestContext : new Wrapper();
        }
    }
}
