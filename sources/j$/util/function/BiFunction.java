package j$.util.function;

import j$.util.function.Function;

/* loaded from: classes.dex */
public interface BiFunction<T, U, R> {

    /* renamed from: j$.util.function.BiFunction$-CC */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<T, U, R> {
        public static BiFunction MyBillsEntityDataFactory(BiFunction biFunction, Function function) {
            return new Consumer$$ExternalSyntheticLambda0(3, biFunction, function);
        }
    }

    <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> function);

    R apply(T t, U u);

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements BiFunction {
        final /* synthetic */ java.util.function.BiFunction KClassImpl$Data$declaredNonStaticMembers$2;

        private /* synthetic */ VivifiedWrapper(java.util.function.BiFunction biFunction) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = biFunction;
        }

        public static /* synthetic */ BiFunction getAuthRequestContext(java.util.function.BiFunction biFunction) {
            if (biFunction == null) {
                return null;
            }
            return biFunction instanceof Wrapper ? BiFunction.this : new VivifiedWrapper(biFunction);
        }

        @Override // j$.util.function.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.apply(obj, obj2);
        }

        @Override // j$.util.function.BiFunction
        public final /* synthetic */ BiFunction andThen(Function function) {
            java.util.function.BiFunction andThen = this.KClassImpl$Data$declaredNonStaticMembers$2.andThen(Function.Wrapper.getAuthRequestContext(function));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? BiFunction.this : new VivifiedWrapper(andThen);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.BiFunction {
        private /* synthetic */ Wrapper() {
            BiFunction.this = r1;
        }

        public static /* synthetic */ java.util.function.BiFunction getAuthRequestContext(BiFunction biFunction) {
            if (biFunction == null) {
                return null;
            }
            return biFunction instanceof VivifiedWrapper ? ((VivifiedWrapper) biFunction).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }

        @Override // java.util.function.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) {
            return BiFunction.this.apply(obj, obj2);
        }

        @Override // java.util.function.BiFunction
        public final /* synthetic */ java.util.function.BiFunction andThen(java.util.function.Function function) {
            BiFunction andThen = BiFunction.this.andThen(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof VivifiedWrapper ? ((VivifiedWrapper) andThen).KClassImpl$Data$declaredNonStaticMembers$2 : new Wrapper();
        }
    }
}
