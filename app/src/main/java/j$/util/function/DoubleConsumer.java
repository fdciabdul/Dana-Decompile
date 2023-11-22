package j$.util.function;

/* loaded from: classes.dex */
public interface DoubleConsumer {
    void accept(double d);

    DoubleConsumer andThen(DoubleConsumer doubleConsumer);

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements DoubleConsumer {
        final /* synthetic */ java.util.function.DoubleConsumer KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.function.DoubleConsumer doubleConsumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = doubleConsumer;
        }

        public static /* synthetic */ DoubleConsumer BuiltInFictitiousFunctionClassFactory(java.util.function.DoubleConsumer doubleConsumer) {
            if (doubleConsumer == null) {
                return null;
            }
            return doubleConsumer instanceof Wrapper ? DoubleConsumer.this : new VivifiedWrapper(doubleConsumer);
        }

        @Override // j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.accept(d);
        }

        @Override // j$.util.function.DoubleConsumer
        public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            java.util.function.DoubleConsumer andThen = this.KClassImpl$Data$declaredNonStaticMembers$2.andThen(Wrapper.PlaceComponentResult(doubleConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? DoubleConsumer.this : new VivifiedWrapper(andThen);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.DoubleConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.DoubleConsumer PlaceComponentResult(DoubleConsumer doubleConsumer) {
            if (doubleConsumer == null) {
                return null;
            }
            return doubleConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) doubleConsumer).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            DoubleConsumer.this.accept(d);
        }

        @Override // java.util.function.DoubleConsumer
        public final /* synthetic */ java.util.function.DoubleConsumer andThen(java.util.function.DoubleConsumer doubleConsumer) {
            DoubleConsumer andThen = DoubleConsumer.this.andThen(VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(doubleConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof VivifiedWrapper ? ((VivifiedWrapper) andThen).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }
    }
}
