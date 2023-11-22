package j$.util.function;

/* loaded from: classes.dex */
public interface LongUnaryOperator {
    LongUnaryOperator BuiltInFictitiousFunctionClassFactory(LongUnaryOperator longUnaryOperator);

    LongUnaryOperator KClassImpl$Data$declaredNonStaticMembers$2(LongUnaryOperator longUnaryOperator);

    long getAuthRequestContext(long j);

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongUnaryOperator {
        final /* synthetic */ java.util.function.LongUnaryOperator BuiltInFictitiousFunctionClassFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongUnaryOperator longUnaryOperator) {
            this.BuiltInFictitiousFunctionClassFactory = longUnaryOperator;
        }

        public static /* synthetic */ LongUnaryOperator KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.LongUnaryOperator longUnaryOperator) {
            if (longUnaryOperator == null) {
                return null;
            }
            return longUnaryOperator instanceof Wrapper ? LongUnaryOperator.this : new VivifiedWrapper(longUnaryOperator);
        }

        @Override // j$.util.function.LongUnaryOperator
        public final /* synthetic */ long getAuthRequestContext(long j) {
            return this.BuiltInFictitiousFunctionClassFactory.applyAsLong(j);
        }

        @Override // j$.util.function.LongUnaryOperator
        public final /* synthetic */ LongUnaryOperator KClassImpl$Data$declaredNonStaticMembers$2(LongUnaryOperator longUnaryOperator) {
            java.util.function.LongUnaryOperator andThen = this.BuiltInFictitiousFunctionClassFactory.andThen(Wrapper.BuiltInFictitiousFunctionClassFactory(longUnaryOperator));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? LongUnaryOperator.this : new VivifiedWrapper(andThen);
        }

        @Override // j$.util.function.LongUnaryOperator
        public final /* synthetic */ LongUnaryOperator BuiltInFictitiousFunctionClassFactory(LongUnaryOperator longUnaryOperator) {
            java.util.function.LongUnaryOperator compose = this.BuiltInFictitiousFunctionClassFactory.compose(Wrapper.BuiltInFictitiousFunctionClassFactory(longUnaryOperator));
            if (compose == null) {
                return null;
            }
            return compose instanceof Wrapper ? LongUnaryOperator.this : new VivifiedWrapper(compose);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.LongUnaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.LongUnaryOperator BuiltInFictitiousFunctionClassFactory(LongUnaryOperator longUnaryOperator) {
            if (longUnaryOperator == null) {
                return null;
            }
            return longUnaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) longUnaryOperator).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }

        @Override // java.util.function.LongUnaryOperator
        public final /* synthetic */ long applyAsLong(long j) {
            return LongUnaryOperator.this.getAuthRequestContext(j);
        }

        @Override // java.util.function.LongUnaryOperator
        public final /* synthetic */ java.util.function.LongUnaryOperator andThen(java.util.function.LongUnaryOperator longUnaryOperator) {
            LongUnaryOperator KClassImpl$Data$declaredNonStaticMembers$2 = LongUnaryOperator.this.KClassImpl$Data$declaredNonStaticMembers$2(VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(longUnaryOperator));
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return null;
            }
            return KClassImpl$Data$declaredNonStaticMembers$2 instanceof VivifiedWrapper ? ((VivifiedWrapper) KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }

        @Override // java.util.function.LongUnaryOperator
        public final /* synthetic */ java.util.function.LongUnaryOperator compose(java.util.function.LongUnaryOperator longUnaryOperator) {
            LongUnaryOperator BuiltInFictitiousFunctionClassFactory = LongUnaryOperator.this.BuiltInFictitiousFunctionClassFactory(VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(longUnaryOperator));
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return null;
            }
            return BuiltInFictitiousFunctionClassFactory instanceof VivifiedWrapper ? ((VivifiedWrapper) BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }
    }
}
