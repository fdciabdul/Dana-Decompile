package j$.util.function;

/* loaded from: classes2.dex */
public interface DoubleBinaryOperator {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleBinaryOperator {
        final /* synthetic */ java.util.function.DoubleBinaryOperator KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleBinaryOperator;
        }

        public static /* synthetic */ DoubleBinaryOperator getAuthRequestContext(java.util.function.DoubleBinaryOperator doubleBinaryOperator) {
            if (doubleBinaryOperator == null) {
                return null;
            }
            return doubleBinaryOperator instanceof Wrapper ? DoubleBinaryOperator.this : new VivifiedWrapper(doubleBinaryOperator);
        }

        @Override // j$.util.function.DoubleBinaryOperator
        public final /* synthetic */ double PlaceComponentResult(double d, double d2) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.applyAsDouble(d, d2);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.DoubleBinaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.DoubleBinaryOperator getAuthRequestContext(DoubleBinaryOperator doubleBinaryOperator) {
            if (doubleBinaryOperator == null) {
                return null;
            }
            return doubleBinaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleBinaryOperator).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.DoubleBinaryOperator
        public final /* synthetic */ double applyAsDouble(double d, double d2) {
            return DoubleBinaryOperator.this.PlaceComponentResult(d, d2);
        }
    }

    double PlaceComponentResult(double d, double d2);
}
