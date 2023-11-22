package j$.util.function;

import j$.util.function.BiFunction;
import j$.util.function.Function;

/* loaded from: classes.dex */
public interface BinaryOperator<T> extends BiFunction<T, T, T> {

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements BinaryOperator {
        final /* synthetic */ java.util.function.BinaryOperator BuiltInFictitiousFunctionClassFactory;

        private /* synthetic */ VivifiedWrapper(java.util.function.BinaryOperator binaryOperator) {
            this.BuiltInFictitiousFunctionClassFactory = binaryOperator;
        }

        public static /* synthetic */ BinaryOperator KClassImpl$Data$declaredNonStaticMembers$2(java.util.function.BinaryOperator binaryOperator) {
            if (binaryOperator == null) {
                return null;
            }
            return binaryOperator instanceof Wrapper ? BinaryOperator.this : new VivifiedWrapper(binaryOperator);
        }

        @Override // j$.util.function.BiFunction
        public final /* synthetic */ BiFunction andThen(Function function) {
            return BiFunction.VivifiedWrapper.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.andThen(Function.Wrapper.getAuthRequestContext(function)));
        }

        @Override // j$.util.function.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) {
            return this.BuiltInFictitiousFunctionClassFactory.apply(obj, obj2);
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.function.BinaryOperator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.function.BinaryOperator BuiltInFictitiousFunctionClassFactory(BinaryOperator binaryOperator) {
            if (binaryOperator == null) {
                return null;
            }
            return binaryOperator instanceof VivifiedWrapper ? ((VivifiedWrapper) binaryOperator).BuiltInFictitiousFunctionClassFactory : new Wrapper();
        }

        @Override // java.util.function.BiFunction
        public final /* synthetic */ java.util.function.BiFunction andThen(java.util.function.Function function) {
            return BiFunction.Wrapper.getAuthRequestContext(BinaryOperator.this.andThen(Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(function)));
        }

        @Override // java.util.function.BiFunction
        public final /* synthetic */ Object apply(Object obj, Object obj2) {
            return BinaryOperator.this.apply(obj, obj2);
        }
    }
}
