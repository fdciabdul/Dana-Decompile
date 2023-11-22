package j$.util.function;

/* loaded from: classes.dex */
public interface Consumer<T> {

    /* renamed from: j$.util.function.Consumer$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<T> {
        public static Consumer PlaceComponentResult(Consumer consumer, Consumer consumer2) {
            return new Consumer$$ExternalSyntheticLambda0(0, consumer, consumer2);
        }
    }

    void accept(T t);

    Consumer<T> andThen(Consumer<? super T> consumer);

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements Consumer {
        final /* synthetic */ java.util.function.Consumer MyBillsEntityDataFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.Consumer consumer) {
            this.MyBillsEntityDataFactory = consumer;
        }

        public static /* synthetic */ Consumer PlaceComponentResult(java.util.function.Consumer consumer) {
            if (consumer == null) {
                return null;
            }
            return consumer instanceof Wrapper ? Consumer.this : new VivifiedWrapper(consumer);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            this.MyBillsEntityDataFactory.accept(obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            java.util.function.Consumer<T> andThen = this.MyBillsEntityDataFactory.andThen(Wrapper.PlaceComponentResult(consumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? Consumer.this : new VivifiedWrapper(andThen);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.Consumer {
        private /* synthetic */ Wrapper() {
            Consumer.this = r1;
        }

        public static /* synthetic */ java.util.function.Consumer PlaceComponentResult(Consumer consumer) {
            if (consumer == null) {
                return null;
            }
            return consumer instanceof VivifiedWrapper ? ((VivifiedWrapper) consumer).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            Consumer.this.accept(obj);
        }

        @Override // java.util.function.Consumer
        public final /* synthetic */ java.util.function.Consumer andThen(java.util.function.Consumer consumer) {
            Consumer<T> andThen = Consumer.this.andThen(VivifiedWrapper.PlaceComponentResult(consumer));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof VivifiedWrapper ? ((VivifiedWrapper) andThen).MyBillsEntityDataFactory : new Wrapper();
        }
    }
}
