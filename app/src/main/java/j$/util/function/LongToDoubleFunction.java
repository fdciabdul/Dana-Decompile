package j$.util.function;

/* loaded from: classes.dex */
public interface LongToDoubleFunction {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongToDoubleFunction {
        public final /* synthetic */ java.util.function.LongToDoubleFunction MyBillsEntityDataFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongToDoubleFunction longToDoubleFunction) {
            this.MyBillsEntityDataFactory = longToDoubleFunction;
        }

        public static /* synthetic */ LongToDoubleFunction getAuthRequestContext(java.util.function.LongToDoubleFunction longToDoubleFunction) {
            if (longToDoubleFunction == null) {
                return null;
            }
            return longToDoubleFunction instanceof Wrapper ? LongToDoubleFunction.this : new VivifiedWrapper(longToDoubleFunction);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.LongToDoubleFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.LongToDoubleFunction getAuthRequestContext(LongToDoubleFunction longToDoubleFunction) {
            if (longToDoubleFunction == null) {
                return null;
            }
            return longToDoubleFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) longToDoubleFunction).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.LongToDoubleFunction
        public final /* synthetic */ double applyAsDouble(long j) {
            return ((VivifiedWrapper) LongToDoubleFunction.this).MyBillsEntityDataFactory.applyAsDouble(j);
        }
    }
}
