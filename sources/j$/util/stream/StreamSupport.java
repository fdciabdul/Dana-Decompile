package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Supplier;
import j$.util.stream.DoublePipeline;
import j$.util.stream.IntPipeline;
import j$.util.stream.LongPipeline;
import j$.util.stream.ReferencePipeline;

/* loaded from: classes.dex */
public final class StreamSupport {
    public static <T> Stream<T> MyBillsEntityDataFactory(Supplier<? extends Spliterator<T>> supplier) {
        return new ReferencePipeline.Head(supplier, StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK & 16);
    }

    public static LongStream PlaceComponentResult(Spliterator.OfLong ofLong) {
        return new LongPipeline.Head(ofLong, StreamOpFlag.fromCharacteristics(ofLong));
    }

    public static Stream PlaceComponentResult(Spliterator spliterator, boolean z) {
        return new ReferencePipeline.Head(spliterator, StreamOpFlag.fromCharacteristics(spliterator), z);
    }

    public static DoubleStream getAuthRequestContext(Spliterator.OfDouble ofDouble) {
        return new DoublePipeline.Head(ofDouble, StreamOpFlag.fromCharacteristics(ofDouble));
    }

    public static IntStream getAuthRequestContext(Spliterator.OfInt ofInt) {
        return new IntPipeline.Head(ofInt, StreamOpFlag.fromCharacteristics(ofInt));
    }
}
