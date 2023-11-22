package j$.util.function;

/* loaded from: classes.dex */
public interface IntConsumer {
    void accept(int i);

    IntConsumer andThen(IntConsumer intConsumer);

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntConsumer {
        final /* synthetic */ java.util.function.IntConsumer getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.function.IntConsumer intConsumer) {
            this.getAuthRequestContext = intConsumer;
        }

        public static /* synthetic */ IntConsumer BuiltInFictitiousFunctionClassFactory(java.util.function.IntConsumer intConsumer) {
            if (intConsumer == null) {
                return null;
            }
            return intConsumer instanceof Wrapper ? IntConsumer.this : new VivifiedWrapper(intConsumer);
        }

        @Override // j$.util.function.IntConsumer
        public final /* synthetic */ void accept(int i) {
            this.getAuthRequestContext.accept(i);
        }

        @Override // j$.util.function.IntConsumer
        public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
            java.util.function.IntConsumer andThen = this.getAuthRequestContext.andThen(Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(intConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? IntConsumer.this : new VivifiedWrapper(andThen);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.IntConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.IntConsumer KClassImpl$Data$declaredNonStaticMembers$2(IntConsumer intConsumer) {
            if (intConsumer == null) {
                return null;
            }
            return intConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) intConsumer).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.IntConsumer
        public final /* synthetic */ void accept(int i) {
            IntConsumer.this.accept(i);
        }

        @Override // java.util.function.IntConsumer
        public final /* synthetic */ java.util.function.IntConsumer andThen(java.util.function.IntConsumer intConsumer) {
            IntConsumer andThen = IntConsumer.this.andThen(VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(intConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof VivifiedWrapper ? ((VivifiedWrapper) andThen).getAuthRequestContext : new Wrapper();
        }
    }
}
