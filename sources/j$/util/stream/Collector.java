package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Set;

/* loaded from: classes.dex */
public interface Collector<T, A, R> {

    /* loaded from: classes.dex */
    public enum Characteristics {
        CONCURRENT,
        UNORDERED,
        IDENTITY_FINISH
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class VivifiedWrapper implements Collector {
        final /* synthetic */ java.util.stream.Collector getAuthRequestContext;

        private /* synthetic */ VivifiedWrapper(java.util.stream.Collector collector) {
            this.getAuthRequestContext = collector;
        }

        public static /* synthetic */ Collector PlaceComponentResult(java.util.stream.Collector collector) {
            if (collector == null) {
                return null;
            }
            return collector instanceof Wrapper ? Collector.this : new VivifiedWrapper(collector);
        }

        @Override // j$.util.stream.Collector
        public final /* synthetic */ Supplier BuiltInFictitiousFunctionClassFactory() {
            return Supplier.VivifiedWrapper.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.supplier());
        }

        @Override // j$.util.stream.Collector
        public final /* synthetic */ Set KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext.characteristics();
        }

        @Override // j$.util.stream.Collector
        public final /* synthetic */ Function MyBillsEntityDataFactory() {
            return Function.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.finisher());
        }

        @Override // j$.util.stream.Collector
        public final /* synthetic */ BinaryOperator PlaceComponentResult() {
            return BinaryOperator.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.combiner());
        }

        @Override // j$.util.stream.Collector
        public final /* synthetic */ BiConsumer getAuthRequestContext() {
            return BiConsumer.VivifiedWrapper.getAuthRequestContext(this.getAuthRequestContext.accumulator());
        }
    }

    /* loaded from: classes6.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.Collector {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.Collector MyBillsEntityDataFactory(Collector collector) {
            if (collector == null) {
                return null;
            }
            return collector instanceof VivifiedWrapper ? ((VivifiedWrapper) collector).getAuthRequestContext : new Wrapper();
        }

        @Override // java.util.stream.Collector
        public final /* synthetic */ java.util.function.BiConsumer accumulator() {
            return BiConsumer.Wrapper.KClassImpl$Data$declaredNonStaticMembers$2(Collector.this.getAuthRequestContext());
        }

        @Override // java.util.stream.Collector
        public final /* synthetic */ Set characteristics() {
            return Collector.this.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // java.util.stream.Collector
        public final /* synthetic */ java.util.function.BinaryOperator combiner() {
            return BinaryOperator.Wrapper.BuiltInFictitiousFunctionClassFactory(Collector.this.PlaceComponentResult());
        }

        @Override // java.util.stream.Collector
        public final /* synthetic */ java.util.function.Function finisher() {
            return Function.Wrapper.getAuthRequestContext(Collector.this.MyBillsEntityDataFactory());
        }

        @Override // java.util.stream.Collector
        public final /* synthetic */ java.util.function.Supplier supplier() {
            return Supplier.Wrapper.BuiltInFictitiousFunctionClassFactory(Collector.this.BuiltInFictitiousFunctionClassFactory());
        }
    }

    Supplier BuiltInFictitiousFunctionClassFactory();

    Set KClassImpl$Data$declaredNonStaticMembers$2();

    Function MyBillsEntityDataFactory();

    BinaryOperator PlaceComponentResult();

    BiConsumer getAuthRequestContext();
}
