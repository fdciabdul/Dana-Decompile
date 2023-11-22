package j$.util.function;

/* loaded from: classes.dex */
public interface IntUnaryOperator {

    /* loaded from: classes.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntUnaryOperator {
        public final /* synthetic */ java.util.function.IntUnaryOperator getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntUnaryOperator intUnaryOperator) {
            this.getAuthRequestContext = intUnaryOperator;
        }

        public static /* synthetic */ IntUnaryOperator getAuthRequestContext(java.util.function.IntUnaryOperator intUnaryOperator) {
            if (intUnaryOperator == null) {
                return null;
            }
            return intUnaryOperator instanceof Wrapper ? IntUnaryOperator.this : new VivifiedWrapper(intUnaryOperator);
        }
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.IntUnaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntUnaryOperator BuiltInFictitiousFunctionClassFactory(IntUnaryOperator intUnaryOperator) {
            if (intUnaryOperator == null) {
                return null;
            }
            return intUnaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) intUnaryOperator).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.IntUnaryOperator
        public final /* synthetic */ java.util.function.IntUnaryOperator andThen(java.util.function.IntUnaryOperator intUnaryOperator) {
            java.util.function.IntUnaryOperator wrapper;
            IntUnaryOperator intUnaryOperator2 = IntUnaryOperator.this;
            IntUnaryOperator authRequestContext = VivifiedWrapper.getAuthRequestContext(intUnaryOperator);
            java.util.function.IntUnaryOperator intUnaryOperator3 = ((VivifiedWrapper) intUnaryOperator2).getAuthRequestContext;
            if (authRequestContext == null) {
                wrapper = null;
            } else {
                wrapper = authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).getAuthRequestContext : new Wrapper();
            }
            IntUnaryOperator authRequestContext2 = VivifiedWrapper.getAuthRequestContext(intUnaryOperator3.andThen(wrapper));
            if (authRequestContext2 == null) {
                return null;
            }
            return authRequestContext2 instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext2).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.IntUnaryOperator
        public final /* synthetic */ int applyAsInt(int i) {
            return ((VivifiedWrapper) IntUnaryOperator.this).getAuthRequestContext.applyAsInt(i);
        }

        @Override // java.util.function.IntUnaryOperator
        public final /* synthetic */ java.util.function.IntUnaryOperator compose(java.util.function.IntUnaryOperator intUnaryOperator) {
            java.util.function.IntUnaryOperator wrapper;
            IntUnaryOperator intUnaryOperator2 = IntUnaryOperator.this;
            IntUnaryOperator authRequestContext = VivifiedWrapper.getAuthRequestContext(intUnaryOperator);
            java.util.function.IntUnaryOperator intUnaryOperator3 = ((VivifiedWrapper) intUnaryOperator2).getAuthRequestContext;
            if (authRequestContext == null) {
                wrapper = null;
            } else {
                wrapper = authRequestContext instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext).getAuthRequestContext : new Wrapper();
            }
            IntUnaryOperator authRequestContext2 = VivifiedWrapper.getAuthRequestContext(intUnaryOperator3.compose(wrapper));
            if (authRequestContext2 == null) {
                return null;
            }
            return authRequestContext2 instanceof VivifiedWrapper ? ((VivifiedWrapper) authRequestContext2).getAuthRequestContext : new Wrapper();
        }
    }
}
