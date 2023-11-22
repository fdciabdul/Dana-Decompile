package j$.util.function;

/* loaded from: classes.dex */
public interface LongConsumer {
    void accept(long j);

    LongConsumer andThen(LongConsumer longConsumer);

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements LongConsumer {
        final /* synthetic */ java.util.function.LongConsumer getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.function.LongConsumer longConsumer) {
            this.getAuthRequestContext = longConsumer;
        }

        public static /* synthetic */ LongConsumer BuiltInFictitiousFunctionClassFactory(java.util.function.LongConsumer longConsumer) {
            if (longConsumer == null) {
                return null;
            }
            return longConsumer instanceof Wrapper ? LongConsumer.this : new VivifiedWrapper(longConsumer);
        }

        @Override // j$.util.function.LongConsumer
        public final /* synthetic */ void accept(long j) {
            this.getAuthRequestContext.accept(j);
        }

        @Override // j$.util.function.LongConsumer
        public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
            java.util.function.LongConsumer andThen = this.getAuthRequestContext.andThen(Wrapper.getAuthRequestContext(longConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? LongConsumer.this : new VivifiedWrapper(andThen);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.LongConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.LongConsumer getAuthRequestContext(LongConsumer longConsumer) {
            if (longConsumer == null) {
                return null;
            }
            return longConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) longConsumer).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.function.LongConsumer
        public final /* synthetic */ void accept(long j) {
            LongConsumer.this.accept(j);
        }

        @Override // java.util.function.LongConsumer
        public final /* synthetic */ java.util.function.LongConsumer andThen(java.util.function.LongConsumer longConsumer) {
            LongConsumer andThen = LongConsumer.this.andThen(VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(longConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof VivifiedWrapper ? ((VivifiedWrapper) andThen).getAuthRequestContext : new Wrapper();
        }
    }
}
