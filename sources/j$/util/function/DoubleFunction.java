package j$.util.function;

/* loaded from: classes.dex */
public interface DoubleFunction {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleFunction {
        final /* synthetic */ java.util.function.DoubleFunction KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleFunction doubleFunction) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleFunction;
        }

        public static /* synthetic */ DoubleFunction KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.DoubleFunction doubleFunction) {
            if (doubleFunction == null) {
                return null;
            }
            return doubleFunction instanceof Wrapper ? DoubleFunction.this : new VivifiedWrapper(doubleFunction);
        }

        @Override // j$.util.function.DoubleFunction
        public final /* synthetic */ Object BuiltInFictitiousFunctionClassFactory(double d) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.apply(d);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.DoubleFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.DoubleFunction PlaceComponentResult(DoubleFunction doubleFunction) {
            if (doubleFunction == null) {
                return null;
            }
            return doubleFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleFunction).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.DoubleFunction
        public final /* synthetic */ Object apply(double d) {
            return DoubleFunction.this.BuiltInFictitiousFunctionClassFactory(d);
        }
    }

    Object BuiltInFictitiousFunctionClassFactory(double d);
}
