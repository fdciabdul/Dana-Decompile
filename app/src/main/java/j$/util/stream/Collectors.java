package j$.util.stream;

import j$.util.function.BiConsumer;
import j$.util.function.BinaryOperator;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.stream.Collector;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class Collectors {
    static final Set KClassImpl$Data$declaredNonStaticMembers$2;
    static final Set MyBillsEntityDataFactory;
    static final Set getAuthRequestContext;

    /* loaded from: classes.dex */
    public final class CollectorImpl implements Collector {
        private final BiConsumer BuiltInFictitiousFunctionClassFactory;
        private final Function KClassImpl$Data$declaredNonStaticMembers$2;
        private final Set MyBillsEntityDataFactory;
        private final BinaryOperator PlaceComponentResult;
        private final Supplier getAuthRequestContext;

        CollectorImpl(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator, Function function, Set set) {
            this.getAuthRequestContext = supplier;
            this.BuiltInFictitiousFunctionClassFactory = biConsumer;
            this.PlaceComponentResult = binaryOperator;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = function;
            this.MyBillsEntityDataFactory = set;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        CollectorImpl(SliceOps$$ExternalSyntheticLambda0 sliceOps$$ExternalSyntheticLambda0, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
            this(sliceOps$$ExternalSyntheticLambda0, biConsumer, binaryOperator, new FindOps$$ExternalSyntheticLambda1(3), set);
            Set set2 = Collectors.getAuthRequestContext;
        }

        @Override // j$.util.stream.Collector
        public final Supplier BuiltInFictitiousFunctionClassFactory() {
            return this.getAuthRequestContext;
        }

        @Override // j$.util.stream.Collector
        public final Set KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // j$.util.stream.Collector
        public final Function MyBillsEntityDataFactory() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // j$.util.stream.Collector
        public final BinaryOperator PlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        @Override // j$.util.stream.Collector
        public final BiConsumer getAuthRequestContext() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
    }

    static {
        Collector.Characteristics characteristics = Collector.Characteristics.CONCURRENT;
        Collector.Characteristics characteristics2 = Collector.Characteristics.UNORDERED;
        Collector.Characteristics characteristics3 = Collector.Characteristics.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2, characteristics3));
        Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2));
        getAuthRequestContext = Collections.unmodifiableSet(EnumSet.of(characteristics3));
        MyBillsEntityDataFactory = Collections.unmodifiableSet(EnumSet.of(characteristics2, characteristics3));
        KClassImpl$Data$declaredNonStaticMembers$2 = Collections.emptySet();
    }

    public static <T> Collector<T, ?, Set<T>> KClassImpl$Data$declaredNonStaticMembers$2() {
        return new CollectorImpl(new SliceOps$$ExternalSyntheticLambda0(25), new SliceOps$$ExternalSyntheticLambda0(26), new FindOps$$ExternalSyntheticLambda1(5), MyBillsEntityDataFactory);
    }

    public static <T, K, U> Collector<T, ?, Map<K, U>> KClassImpl$Data$declaredNonStaticMembers$2(Function<? super T, ? extends K> function, Function<? super T, ? extends U> function2) {
        FindOps$$ExternalSyntheticLambda1 findOps$$ExternalSyntheticLambda1 = new FindOps$$ExternalSyntheticLambda1(2);
        return new CollectorImpl(new SliceOps$$ExternalSyntheticLambda0(21), new Collectors$$ExternalSyntheticLambda41(function, function2, findOps$$ExternalSyntheticLambda1), new Collectors$$ExternalSyntheticLambda25(0, findOps$$ExternalSyntheticLambda1), getAuthRequestContext);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
    }

    public static <T> Collector<T, ?, List<T>> MyBillsEntityDataFactory() {
        return new CollectorImpl(new SliceOps$$ExternalSyntheticLambda0(22), new SliceOps$$ExternalSyntheticLambda0(23), new FindOps$$ExternalSyntheticLambda1(4), getAuthRequestContext);
    }

    public static Collector<CharSequence, ?, String> PlaceComponentResult(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new CollectorImpl(new Collectors$$ExternalSyntheticLambda41(charSequence, charSequence2, charSequence3), new SliceOps$$ExternalSyntheticLambda0(17), new SliceOps$$ExternalSyntheticLambda0(18), new SliceOps$$ExternalSyntheticLambda0(19), KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
