package j$.util.function;

/* loaded from: classes.dex */
public interface LongPredicate {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongPredicate {
        final /* synthetic */ java.util.function.LongPredicate MyBillsEntityDataFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongPredicate longPredicate) {
            this.MyBillsEntityDataFactory = longPredicate;
        }

        public static /* synthetic */ LongPredicate BuiltInFictitiousFunctionClassFactory(java.util.function.LongPredicate longPredicate) {
            if (longPredicate == null) {
                return null;
            }
            return longPredicate instanceof Wrapper ? LongPredicate.this : new VivifiedWrapper(longPredicate);
        }

        public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(long j) {
            return this.MyBillsEntityDataFactory.test(j);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.LongPredicate {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.LongPredicate BuiltInFictitiousFunctionClassFactory(LongPredicate longPredicate) {
            if (longPredicate == null) {
                return null;
            }
            return longPredicate instanceof VivifiedWrapper ? ((VivifiedWrapper) longPredicate).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.LongPredicate
        public final /* synthetic */ boolean test(long j) {
            return ((VivifiedWrapper) LongPredicate.this).BuiltInFictitiousFunctionClassFactory(j);
        }

        @Override // java.util.function.LongPredicate
        public final /* synthetic */ java.util.function.LongPredicate and(java.util.function.LongPredicate longPredicate) {
            java.util.function.LongPredicate wrapper;
            LongPredicate longPredicate2 = LongPredicate.this;
            LongPredicate BuiltInFictitiousFunctionClassFactory = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate);
            java.util.function.LongPredicate longPredicate3 = ((VivifiedWrapper) longPredicate2).MyBillsEntityDataFactory;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                wrapper = null;
            } else {
                wrapper = BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory : new Wrapper();
            }
            LongPredicate BuiltInFictitiousFunctionClassFactory2 = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate3.and(wrapper));
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory2 instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory2).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.LongPredicate
        public final /* synthetic */ java.util.function.LongPredicate negate() {
            LongPredicate BuiltInFictitiousFunctionClassFactory = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(((VivifiedWrapper) LongPredicate.this).MyBillsEntityDataFactory.negate());
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.LongPredicate
        public final /* synthetic */ java.util.function.LongPredicate or(java.util.function.LongPredicate longPredicate) {
            java.util.function.LongPredicate wrapper;
            LongPredicate longPredicate2 = LongPredicate.this;
            LongPredicate BuiltInFictitiousFunctionClassFactory = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate);
            java.util.function.LongPredicate longPredicate3 = ((VivifiedWrapper) longPredicate2).MyBillsEntityDataFactory;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                wrapper = null;
            } else {
                wrapper = BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).MyBillsEntityDataFactory : new Wrapper();
            }
            LongPredicate BuiltInFictitiousFunctionClassFactory2 = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longPredicate3.or(wrapper));
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory2 instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory2).MyBillsEntityDataFactory : new Wrapper();
        }
    }
}
