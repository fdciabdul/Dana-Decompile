package j$.util.function;

/* loaded from: classes.dex */
public interface LongToIntFunction {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongToIntFunction {
        public final /* synthetic */ java.util.function.LongToIntFunction BuiltInFictitiousFunctionClassFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongToIntFunction longToIntFunction) {
            this.BuiltInFictitiousFunctionClassFactory = longToIntFunction;
        }

        public static /* synthetic */ LongToIntFunction KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.LongToIntFunction longToIntFunction) {
            if (longToIntFunction == null) {
                return null;
            }
            return longToIntFunction instanceof Wrapper ? LongToIntFunction.this : new VivifiedWrapper(longToIntFunction);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.LongToIntFunction {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.LongToIntFunction getAuthRequestContext(LongToIntFunction longToIntFunction) {
            if (longToIntFunction == null) {
                return null;
            }
            return longToIntFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) longToIntFunction).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }

        @Override // java.util.function.LongToIntFunction
        public final /* synthetic */ int applyAsInt(long j) {
            return ((VivifiedWrapper) LongToIntFunction.this).BuiltInFictitiousFunctionClassFactory.applyAsInt(j);
        }
    }
}
