package j$.util.function;

/* loaded from: classes.dex */
public interface DoubleUnaryOperator {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleUnaryOperator {
        public final /* synthetic */ java.util.function.DoubleUnaryOperator getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleUnaryOperator doubleUnaryOperator) {
            this.getAuthRequestContext = doubleUnaryOperator;
        }

        public static /* synthetic */ DoubleUnaryOperator BuiltInFictitiousFunctionClassFactory(java.util.function.DoubleUnaryOperator doubleUnaryOperator) {
            if (doubleUnaryOperator == null) {
                return null;
            }
            return doubleUnaryOperator instanceof Wrapper ? DoubleUnaryOperator.this : new VivifiedWrapper(doubleUnaryOperator);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.DoubleUnaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.DoubleUnaryOperator PlaceComponentResult(DoubleUnaryOperator doubleUnaryOperator) {
            if (doubleUnaryOperator == null) {
                return null;
            }
            return doubleUnaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleUnaryOperator).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.DoubleUnaryOperator
        public final /* synthetic */ java.util.function.DoubleUnaryOperator andThen(java.util.function.DoubleUnaryOperator doubleUnaryOperator) {
            java.util.function.DoubleUnaryOperator wrapper;
            DoubleUnaryOperator doubleUnaryOperator2 = DoubleUnaryOperator.this;
            DoubleUnaryOperator BuiltInFictitiousFunctionClassFactory = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleUnaryOperator);
            java.util.function.DoubleUnaryOperator doubleUnaryOperator3 = ((VivifiedWrapper) doubleUnaryOperator2).getAuthRequestContext;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                wrapper = null;
            } else {
                wrapper = BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).getAuthRequestContext : new Wrapper();
            }
            DoubleUnaryOperator BuiltInFictitiousFunctionClassFactory2 = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleUnaryOperator3.andThen(wrapper));
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory2 instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory2).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.DoubleUnaryOperator
        public final /* synthetic */ double applyAsDouble(double d) {
            return ((VivifiedWrapper) DoubleUnaryOperator.this).getAuthRequestContext.applyAsDouble(d);
        }

        @Override // java.util.function.DoubleUnaryOperator
        public final /* synthetic */ java.util.function.DoubleUnaryOperator compose(java.util.function.DoubleUnaryOperator doubleUnaryOperator) {
            java.util.function.DoubleUnaryOperator wrapper;
            DoubleUnaryOperator doubleUnaryOperator2 = DoubleUnaryOperator.this;
            DoubleUnaryOperator BuiltInFictitiousFunctionClassFactory = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleUnaryOperator);
            java.util.function.DoubleUnaryOperator doubleUnaryOperator3 = ((VivifiedWrapper) doubleUnaryOperator2).getAuthRequestContext;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                wrapper = null;
            } else {
                wrapper = BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).getAuthRequestContext : new Wrapper();
            }
            DoubleUnaryOperator BuiltInFictitiousFunctionClassFactory2 = VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleUnaryOperator3.compose(wrapper));
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory2 instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory2).getAuthRequestContext : new Wrapper();
        }
    }
}
