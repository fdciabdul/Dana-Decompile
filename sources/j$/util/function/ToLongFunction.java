package j$.util.function;

/* loaded from: classes.dex */
public interface ToLongFunction<T> {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements ToLongFunction {
        final /* synthetic */ java.util.function.ToLongFunction BuiltInFictitiousFunctionClassFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.ToLongFunction toLongFunction) {
            this.BuiltInFictitiousFunctionClassFactory = toLongFunction;
        }

        public static /* synthetic */ ToLongFunction MyBillsEntityDataFactory(java.util.function.ToLongFunction toLongFunction) {
            if (toLongFunction == null) {
                return null;
            }
            return toLongFunction instanceof Wrapper ? ToLongFunction.this : new VivifiedWrapper(toLongFunction);
        }

        @Override // j$.util.function.ToLongFunction
        public final /* synthetic */ long KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            return this.BuiltInFictitiousFunctionClassFactory.applyAsLong(obj);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.ToLongFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.ToLongFunction PlaceComponentResult(ToLongFunction toLongFunction) {
            if (toLongFunction == null) {
                return null;
            }
            return toLongFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) toLongFunction).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }

        @Override // java.util.function.ToLongFunction
        public final /* synthetic */ long applyAsLong(Object obj) {
            return ToLongFunction.this.KClassImpl$Data$declaredNonStaticMembers$2(obj);
        }
    }

    long KClassImpl$Data$declaredNonStaticMembers$2(T t);
}
