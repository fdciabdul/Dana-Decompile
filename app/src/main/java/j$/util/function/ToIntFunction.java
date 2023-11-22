package j$.util.function;

/* loaded from: classes.dex */
public interface ToIntFunction<T> {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToIntFunction {
        final /* synthetic */ java.util.function.ToIntFunction PlaceComponentResult;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToIntFunction toIntFunction) {
            this.PlaceComponentResult = toIntFunction;
        }

        public static /* synthetic */ ToIntFunction BuiltInFictitiousFunctionClassFactory(java.util.function.ToIntFunction toIntFunction) {
            if (toIntFunction == null) {
                return null;
            }
            return toIntFunction instanceof Wrapper ? ToIntFunction.this : new VivifiedWrapper(toIntFunction);
        }

        @Override // j$.util.function.ToIntFunction
        public final /* synthetic */ int MyBillsEntityDataFactory(Object obj) {
            return this.PlaceComponentResult.applyAsInt(obj);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.ToIntFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.ToIntFunction BuiltInFictitiousFunctionClassFactory(ToIntFunction toIntFunction) {
            if (toIntFunction == null) {
                return null;
            }
            return toIntFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) toIntFunction).PlaceComponentResult : new Wrapper();
        }

        @Override // java.util.function.ToIntFunction
        public final /* synthetic */ int applyAsInt(Object obj) {
            return ToIntFunction.this.MyBillsEntityDataFactory(obj);
        }
    }

    int MyBillsEntityDataFactory(Object obj);
}
