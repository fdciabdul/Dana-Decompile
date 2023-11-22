package j$.util.function;

import j$.util.function.Function;

/* loaded from: classes2.dex */
public interface UnaryOperator<T> extends Function<T, T> {

    /* loaded from: classes3.dex */
    public final /* synthetic */ class VivifiedWrapper implements UnaryOperator {
        final /* synthetic */ java.util.function.UnaryOperator MyBillsEntityDataFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.UnaryOperator unaryOperator) {
            this.MyBillsEntityDataFactory = unaryOperator;
        }

        public static /* synthetic */ UnaryOperator BuiltInFictitiousFunctionClassFactory(java.util.function.UnaryOperator unaryOperator) {
            if (unaryOperator == null) {
                return null;
            }
            return new VivifiedWrapper(unaryOperator);
        }

        @Override // j$.util.function.Function
        /* renamed from: andThen */
        public final /* synthetic */ Function mo3169andThen(Function function) {
            return Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.andThen(Function.Wrapper.getAuthRequestContext(function)));
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Object apply(Object obj) {
            return this.MyBillsEntityDataFactory.apply(obj);
        }

        @Override // j$.util.function.Function
        public final /* synthetic */ Function compose(Function function) {
            return Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.compose(Function.Wrapper.getAuthRequestContext(function)));
        }
    }
}
