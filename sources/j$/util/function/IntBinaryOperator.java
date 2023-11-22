package j$.util.function;

/* loaded from: classes2.dex */
public interface IntBinaryOperator {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntBinaryOperator {
        final /* synthetic */ java.util.function.IntBinaryOperator getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntBinaryOperator intBinaryOperator) {
            this.getAuthRequestContext = intBinaryOperator;
        }

        public static /* synthetic */ IntBinaryOperator getAuthRequestContext(java.util.function.IntBinaryOperator intBinaryOperator) {
            if (intBinaryOperator == null) {
                return null;
            }
            return intBinaryOperator instanceof Wrapper ? IntBinaryOperator.this : new VivifiedWrapper(intBinaryOperator);
        }

        @Override // j$.util.function.IntBinaryOperator
        public final /* synthetic */ int MyBillsEntityDataFactory(int i, int i2) {
            return this.getAuthRequestContext.applyAsInt(i, i2);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.IntBinaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntBinaryOperator KClassImpl$Data$declaredNonStaticMembers$2(IntBinaryOperator intBinaryOperator) {
            if (intBinaryOperator == null) {
                return null;
            }
            return intBinaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) intBinaryOperator).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.IntBinaryOperator
        public final /* synthetic */ int applyAsInt(int i, int i2) {
            return IntBinaryOperator.this.MyBillsEntityDataFactory(i, i2);
        }
    }

    int MyBillsEntityDataFactory(int i, int i2);
}
