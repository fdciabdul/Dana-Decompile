package j$.util.function;

/* loaded from: classes.dex */
public interface DoubleToIntFunction {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleToIntFunction {
        public final /* synthetic */ java.util.function.DoubleToIntFunction PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleToIntFunction doubleToIntFunction) {
            this.PlaceComponentResult = doubleToIntFunction;
        }

        public static /* synthetic */ DoubleToIntFunction KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.DoubleToIntFunction doubleToIntFunction) {
            if (doubleToIntFunction == null) {
                return null;
            }
            return doubleToIntFunction instanceof Wrapper ? DoubleToIntFunction.this : new VivifiedWrapper(doubleToIntFunction);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.DoubleToIntFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.DoubleToIntFunction BuiltInFictitiousFunctionClassFactory(DoubleToIntFunction doubleToIntFunction) {
            if (doubleToIntFunction == null) {
                return null;
            }
            return doubleToIntFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleToIntFunction).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.DoubleToIntFunction
        public final /* synthetic */ int applyAsInt(double d) {
            return ((VivifiedWrapper) DoubleToIntFunction.this).PlaceComponentResult.applyAsInt(d);
        }
    }
}
