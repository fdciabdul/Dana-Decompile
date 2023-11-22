package j$.util.function;

/* loaded from: classes.dex */
public interface IntToLongFunction {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntToLongFunction {
        final /* synthetic */ java.util.function.IntToLongFunction MyBillsEntityDataFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntToLongFunction intToLongFunction) {
            this.MyBillsEntityDataFactory = intToLongFunction;
        }

        public static /* synthetic */ IntToLongFunction MyBillsEntityDataFactory(java.util.function.IntToLongFunction intToLongFunction) {
            if (intToLongFunction == null) {
                return null;
            }
            return intToLongFunction instanceof Wrapper ? IntToLongFunction.this : new VivifiedWrapper(intToLongFunction);
        }

        @Override // j$.util.function.IntToLongFunction
        public final /* synthetic */ long getAuthRequestContext(int i) {
            return this.MyBillsEntityDataFactory.applyAsLong(i);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.IntToLongFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntToLongFunction BuiltInFictitiousFunctionClassFactory(IntToLongFunction intToLongFunction) {
            if (intToLongFunction == null) {
                return null;
            }
            return intToLongFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) intToLongFunction).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.IntToLongFunction
        public final /* synthetic */ long applyAsLong(int i) {
            return IntToLongFunction.this.getAuthRequestContext(i);
        }
    }

    long getAuthRequestContext(int i);
}
