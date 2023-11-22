package j$.util.function;

/* loaded from: classes.dex */
public interface DoubleToLongFunction {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleToLongFunction {
        final /* synthetic */ java.util.function.DoubleToLongFunction getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleToLongFunction doubleToLongFunction) {
            this.getAuthRequestContext = doubleToLongFunction;
        }

        public static /* synthetic */ DoubleToLongFunction KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.DoubleToLongFunction doubleToLongFunction) {
            if (doubleToLongFunction == null) {
                return null;
            }
            return doubleToLongFunction instanceof Wrapper ? DoubleToLongFunction.this : new VivifiedWrapper(doubleToLongFunction);
        }

        @Override // j$.util.function.DoubleToLongFunction
        public final /* synthetic */ long MyBillsEntityDataFactory(double d) {
            return this.getAuthRequestContext.applyAsLong(d);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.DoubleToLongFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.DoubleToLongFunction PlaceComponentResult(DoubleToLongFunction doubleToLongFunction) {
            if (doubleToLongFunction == null) {
                return null;
            }
            return doubleToLongFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleToLongFunction).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.DoubleToLongFunction
        public final /* synthetic */ long applyAsLong(double d) {
            return DoubleToLongFunction.this.MyBillsEntityDataFactory(d);
        }
    }

    long MyBillsEntityDataFactory(double d);
}
