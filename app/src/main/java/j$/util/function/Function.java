package j$.util.function;

import j$.time.LocalDateTime$$ExternalSyntheticLambda6;

/* loaded from: classes.dex */
public interface Function<T, R> {

    /* renamed from: j$.util.function.Function$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC<T, R> {
        public static <T> Function<T, T> BuiltInFictitiousFunctionClassFactory() {
            return new LocalDateTime$$ExternalSyntheticLambda6();
        }

        public static Function KClassImpl$Data$declaredNonStaticMembers$2(Function function, Function function2) {
            return new Function$$ExternalSyntheticLambda0(function, function2, 1);
        }

        public static Function getAuthRequestContext(Function function, Function function2) {
            return new Function$$ExternalSyntheticLambda0(function, function2, 0);
        }
    }

    /* renamed from: andThen */
    <V> Function<T, V> mo3169andThen(Function<? super R, ? extends V> function);

    R apply(T t);

    <V> Function<V, R> compose(Function<? super V, ? extends T> function);

    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements Function {
        final /* synthetic */ java.util.function.Function MyBillsEntityDataFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.Function function) {
            this.MyBillsEntityDataFactory = function;
        }

        public static /* synthetic */ Function KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.Function function) {
            if (function == null) {
                return null;
            }
            return function instanceof Wrapper ? Function.this : new VivifiedWrapper(function);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Object apply(Object obj) {
            return this.MyBillsEntityDataFactory.apply(obj);
        }

        @Override // j$.util.function.Function
        /* renamed from: andThen */
        public final /* synthetic */ Function mo3169andThen(Function function) {
            java.util.function.Function andThen = this.MyBillsEntityDataFactory.andThen(Wrapper.getAuthRequestContext(function));
            if (andThen == null) {
                return null;
            }
            return andThen instanceof Wrapper ? Function.this : new VivifiedWrapper(andThen);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function compose(Function function) {
            java.util.function.Function compose = this.MyBillsEntityDataFactory.compose(Wrapper.getAuthRequestContext(function));
            if (compose == null) {
                return null;
            }
            return compose instanceof Wrapper ? Function.this : new VivifiedWrapper(compose);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.Function {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.Function getAuthRequestContext(Function function) {
            if (function == null) {
                return null;
            }
            return function instanceof VivifiedWrapper ? ((VivifiedWrapper) function).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.Function
        public final /* synthetic */ Object apply(Object obj) {
            return Function.this.apply(obj);
        }

        @Override // java.util.function.Function
        public final /* synthetic */ java.util.function.Function andThen(java.util.function.Function function) {
            Function mo3169andThen = Function.this.mo3169andThen(VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
            if (mo3169andThen == null) {
                return null;
            }
            return mo3169andThen instanceof VivifiedWrapper ? ((VivifiedWrapper) mo3169andThen).MyBillsEntityDataFactory : new Wrapper();
        }

        @Override // java.util.function.Function
        public final /* synthetic */ java.util.function.Function compose(java.util.function.Function function) {
            Function compose = Function.this.compose(VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function));
            if (compose == null) {
                return null;
            }
            return compose instanceof VivifiedWrapper ? ((VivifiedWrapper) compose).MyBillsEntityDataFactory : new Wrapper();
        }
    }
}
