package j$.util.function;

/* loaded from: classes.dex */
public interface IntFunction<R> {

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntFunction {
        final /* synthetic */ java.util.function.IntFunction PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntFunction intFunction) {
            this.PlaceComponentResult = intFunction;
        }

        public static /* synthetic */ IntFunction MyBillsEntityDataFactory(java.util.function.IntFunction intFunction) {
            if (intFunction == null) {
                return null;
            }
            return intFunction instanceof Wrapper ? IntFunction.this : new VivifiedWrapper(intFunction);
        }

        @Override // j$.util.function.IntFunction
        public final /* synthetic */ Object MyBillsEntityDataFactory(int i) {
            return this.PlaceComponentResult.apply(i);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.IntFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntFunction getAuthRequestContext(IntFunction intFunction) {
            if (intFunction == null) {
                return null;
            }
            return intFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) intFunction).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.IntFunction
        public final /* synthetic */ Object apply(int i) {
            return IntFunction.this.MyBillsEntityDataFactory(i);
        }
    }

    Object MyBillsEntityDataFactory(int i);
}
