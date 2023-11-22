package j$.util.function;

/* loaded from: classes2.dex */
public interface LongBinaryOperator {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongBinaryOperator {
        final /* synthetic */ java.util.function.LongBinaryOperator KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongBinaryOperator longBinaryOperator) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = longBinaryOperator;
        }

        public static /* synthetic */ LongBinaryOperator KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.LongBinaryOperator longBinaryOperator) {
            if (longBinaryOperator == null) {
                return null;
            }
            return longBinaryOperator instanceof Wrapper ? LongBinaryOperator.this : new VivifiedWrapper(longBinaryOperator);
        }

        @Override // j$.util.function.LongBinaryOperator
        public final /* synthetic */ long BuiltInFictitiousFunctionClassFactory(long j, long j2) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.applyAsLong(j, j2);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.LongBinaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.LongBinaryOperator PlaceComponentResult(LongBinaryOperator longBinaryOperator) {
            if (longBinaryOperator == null) {
                return null;
            }
            return longBinaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) longBinaryOperator).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.LongBinaryOperator
        public final /* synthetic */ long applyAsLong(long j, long j2) {
            return LongBinaryOperator.this.BuiltInFictitiousFunctionClassFactory(j, j2);
        }
    }

    long BuiltInFictitiousFunctionClassFactory(long j, long j2);
}
