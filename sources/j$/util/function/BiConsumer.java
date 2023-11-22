package j$.util.function;

/* loaded from: classes.dex */
public interface BiConsumer<T, U> {

    /* renamed from: j$.util.function.BiConsumer$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<T, U> {
        public static BiConsumer getAuthRequestContext(BiConsumer biConsumer, BiConsumer biConsumer2) {
            return new Consumer$$ExternalSyntheticLambda0(2, biConsumer, biConsumer2);
        }
    }

    void accept(T t, U u);

    BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> biConsumer);

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements BiConsumer {
        final /* synthetic */ java.util.function.BiConsumer KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiConsumer biConsumer) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biConsumer;
        }

        public static /* synthetic */ BiConsumer getAuthRequestContext(java.util.function.BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof Wrapper ? BiConsumer.this : new VivifiedWrapper(biConsumer);
        }

        @Override // j$.util.function.BiConsumer
        public final /* synthetic */ void accept(Object obj, Object obj2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.accept(obj, obj2);
        }

        @Override // j$.util.function.BiConsumer
        public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
            java.util.function.BiConsumer<T, U> andThen = this.KClassImpl$Data$declaredNonStaticMembers$2.andThen(Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(biConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? BiConsumer.this : new VivifiedWrapper(andThen);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.BiConsumer {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.BiConsumer KClassImpl$Data$declaredNonStaticMembers$2(BiConsumer biConsumer) {
            if (biConsumer == null) {
                return null;
            }
            return biConsumer instanceof VivifiedWrapper ? ((VivifiedWrapper) biConsumer).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.BiConsumer
        public final /* synthetic */ void accept(Object obj, Object obj2) {
            BiConsumer.this.accept(obj, obj2);
        }

        @Override // java.util.function.BiConsumer
        public final /* synthetic */ java.util.function.BiConsumer andThen(java.util.function.BiConsumer biConsumer) {
            BiConsumer<T, U> andThen = BiConsumer.this.andThen(VivifiedWrapper.getAuthRequestContext(biConsumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof VivifiedWrapper ? ((VivifiedWrapper) andThen).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }
    }
}
