package kotlin.streams.jdk8;

import j$.util.PrimitiveIterator;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import j$.util.stream.DoubleStream;
import j$.util.stream.IntStream;
import j$.util.stream.LongStream;
import j$.util.stream.Stream;
import j$.util.stream.StreamSupport;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(bv = {}, d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0002*\u00020\b¢\u0006\u0004\b\u0003\u0010\n\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0002*\u00020\u000b¢\u0006\u0004\b\u0003\u0010\r\u001a#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010*\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0013\u001a\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0010*\u00020\b¢\u0006\u0004\b\u0011\u0010\u0014\u001a\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010*\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0015"}, d2 = {"T", "Lj$/util/stream/Stream;", "Lkotlin/sequences/Sequence;", "asSequence", "(Lj$/util/stream/Stream;)Lkotlin/sequences/Sequence;", "Lj$/util/stream/IntStream;", "", "(Lj$/util/stream/IntStream;)Lkotlin/sequences/Sequence;", "Lj$/util/stream/LongStream;", "", "(Lj$/util/stream/LongStream;)Lkotlin/sequences/Sequence;", "Lj$/util/stream/DoubleStream;", "", "(Lj$/util/stream/DoubleStream;)Lkotlin/sequences/Sequence;", "asStream", "(Lkotlin/sequences/Sequence;)Lj$/util/stream/Stream;", "", "toList", "(Lj$/util/stream/Stream;)Ljava/util/List;", "(Lj$/util/stream/IntStream;)Ljava/util/List;", "(Lj$/util/stream/LongStream;)Ljava/util/List;", "(Lj$/util/stream/DoubleStream;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, pn = "")
/* loaded from: classes9.dex */
public final class StreamsKt {
    public static final <T> Sequence<T> asSequence(final Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "");
        return new Sequence<T>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public final Iterator<T> iterator() {
                Iterator<T> DatabaseTableConfigUtil = Stream.this.DatabaseTableConfigUtil();
                Intrinsics.checkNotNullExpressionValue(DatabaseTableConfigUtil, "");
                return DatabaseTableConfigUtil;
            }
        };
    }

    public static final Sequence<Integer> asSequence(final IntStream intStream) {
        Intrinsics.checkNotNullParameter(intStream, "");
        return new Sequence<Integer>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$2
            @Override // kotlin.sequences.Sequence
            public final Iterator<Integer> iterator() {
                PrimitiveIterator.OfInt NetworkUserEntityData$$ExternalSyntheticLambda6 = IntStream.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
                Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda6, "");
                return NetworkUserEntityData$$ExternalSyntheticLambda6;
            }
        };
    }

    public static final Sequence<Long> asSequence(final LongStream longStream) {
        Intrinsics.checkNotNullParameter(longStream, "");
        return new Sequence<Long>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$3
            @Override // kotlin.sequences.Sequence
            public final Iterator<Long> iterator() {
                PrimitiveIterator.OfLong NetworkUserEntityData$$ExternalSyntheticLambda6 = LongStream.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
                Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda6, "");
                return NetworkUserEntityData$$ExternalSyntheticLambda6;
            }
        };
    }

    public static final Sequence<Double> asSequence(final DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter(doubleStream, "");
        return new Sequence<Double>() { // from class: kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$4
            @Override // kotlin.sequences.Sequence
            public final Iterator<Double> iterator() {
                PrimitiveIterator.OfDouble NetworkUserEntityData$$ExternalSyntheticLambda8 = DoubleStream.this.NetworkUserEntityData$$ExternalSyntheticLambda8();
                Intrinsics.checkNotNullExpressionValue(NetworkUserEntityData$$ExternalSyntheticLambda8, "");
                return NetworkUserEntityData$$ExternalSyntheticLambda8;
            }
        };
    }

    public static final <T> Stream<T> asStream(final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Stream<T> MyBillsEntityDataFactory = StreamSupport.MyBillsEntityDataFactory(new Supplier() { // from class: kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                Spliterator m4470asStream$lambda4;
                m4470asStream$lambda4 = StreamsKt.m4470asStream$lambda4(Sequence.this);
                return m4470asStream$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: asStream$lambda-4  reason: not valid java name */
    public static final Spliterator m4470asStream$lambda4(Sequence sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return Spliterators.PlaceComponentResult(sequence.iterator());
    }

    public static final <T> List<T> toList(Stream<T> stream) {
        Intrinsics.checkNotNullParameter(stream, "");
        Object BuiltInFictitiousFunctionClassFactory = stream.BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return (List) BuiltInFictitiousFunctionClassFactory;
    }

    public static final List<Integer> toList(IntStream intStream) {
        Intrinsics.checkNotNullParameter(intStream, "");
        int[] callingPid = intStream.getCallingPid();
        Intrinsics.checkNotNullExpressionValue(callingPid, "");
        return ArraysKt.asList(callingPid);
    }

    public static final List<Long> toList(LongStream longStream) {
        Intrinsics.checkNotNullParameter(longStream, "");
        long[] whenAvailable = longStream.whenAvailable();
        Intrinsics.checkNotNullExpressionValue(whenAvailable, "");
        return ArraysKt.asList(whenAvailable);
    }

    public static final List<Double> toList(DoubleStream doubleStream) {
        Intrinsics.checkNotNullParameter(doubleStream, "");
        double[] supportButtonTintMode = doubleStream.getSupportButtonTintMode();
        Intrinsics.checkNotNullExpressionValue(supportButtonTintMode, "");
        return ArraysKt.asList(supportButtonTintMode);
    }
}
