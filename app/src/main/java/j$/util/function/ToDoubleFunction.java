package j$.util.function;

/* loaded from: classes.dex */
public interface ToDoubleFunction<T> {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToDoubleFunction {
        final /* synthetic */ java.util.function.ToDoubleFunction PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToDoubleFunction toDoubleFunction) {
            this.PlaceComponentResult = toDoubleFunction;
        }

        public static /* synthetic */ ToDoubleFunction BuiltInFictitiousFunctionClassFactory(java.util.function.ToDoubleFunction toDoubleFunction) {
            if (toDoubleFunction == null) {
                return null;
            }
            return toDoubleFunction instanceof Wrapper ? ToDoubleFunction.this : new VivifiedWrapper(toDoubleFunction);
        }

        @Override // j$.util.function.ToDoubleFunction
        public final /* synthetic */ double applyAsDouble(Object obj) {
            return this.PlaceComponentResult.applyAsDouble(obj);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.ToDoubleFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.ToDoubleFunction BuiltInFictitiousFunctionClassFactory(ToDoubleFunction toDoubleFunction) {
            if (toDoubleFunction == null) {
                return null;
            }
            return toDoubleFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) toDoubleFunction).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.ToDoubleFunction
        public final /* synthetic */ double applyAsDouble(Object obj) {
            return ToDoubleFunction.this.applyAsDouble(obj);
        }
    }

    double applyAsDouble(T t);
}
