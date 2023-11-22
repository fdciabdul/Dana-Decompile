package j$.util.function;

/* loaded from: classes.dex */
public interface LongFunction {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongFunction {
        final /* synthetic */ java.util.function.LongFunction BuiltInFictitiousFunctionClassFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongFunction longFunction) {
            this.BuiltInFictitiousFunctionClassFactory = longFunction;
        }

        public static /* synthetic */ LongFunction PlaceComponentResult(java.util.function.LongFunction longFunction) {
            if (longFunction == null) {
                return null;
            }
            return longFunction instanceof Wrapper ? LongFunction.this : new VivifiedWrapper(longFunction);
        }

        @Override // j$.util.function.LongFunction
        public final /* synthetic */ Object MyBillsEntityDataFactory(long j) {
            return this.BuiltInFictitiousFunctionClassFactory.apply(j);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.LongFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.LongFunction MyBillsEntityDataFactory(LongFunction longFunction) {
            if (longFunction == null) {
                return null;
            }
            return longFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) longFunction).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }

        @Override // java.util.function.LongFunction
        public final /* synthetic */ Object apply(long j) {
            return LongFunction.this.MyBillsEntityDataFactory(j);
        }
    }

    Object MyBillsEntityDataFactory(long j);
}
