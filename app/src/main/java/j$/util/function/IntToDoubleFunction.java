package j$.util.function;

/* loaded from: classes.dex */
public interface IntToDoubleFunction {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntToDoubleFunction {
        public final /* synthetic */ java.util.function.IntToDoubleFunction PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntToDoubleFunction intToDoubleFunction) {
            this.PlaceComponentResult = intToDoubleFunction;
        }

        public static /* synthetic */ IntToDoubleFunction KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.IntToDoubleFunction intToDoubleFunction) {
            if (intToDoubleFunction == null) {
                return null;
            }
            return intToDoubleFunction instanceof Wrapper ? IntToDoubleFunction.this : new VivifiedWrapper(intToDoubleFunction);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.IntToDoubleFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntToDoubleFunction getAuthRequestContext(IntToDoubleFunction intToDoubleFunction) {
            if (intToDoubleFunction == null) {
                return null;
            }
            return intToDoubleFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) intToDoubleFunction).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.IntToDoubleFunction
        public final /* synthetic */ double applyAsDouble(int i) {
            return ((VivifiedWrapper) IntToDoubleFunction.this).PlaceComponentResult.applyAsDouble(i);
        }
    }
}
