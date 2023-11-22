package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.stream.StreamSpliterators$ArrayBuffer;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class StreamSpliterators$UnorderedSliceSpliterator {
    private final long BuiltInFictitiousFunctionClassFactory;
    protected final Spliterator KClassImpl$Data$declaredNonStaticMembers$2;
    protected final boolean PlaceComponentResult;
    private final AtomicLong getAuthRequestContext;

    /* loaded from: classes.dex */
    final class OfDouble extends OfPrimitive implements Spliterator.OfDouble, DoubleConsumer {
        double BuiltInFictitiousFunctionClassFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble(Spliterator.OfDouble ofDouble, long j, long j2) {
            super(ofDouble, j, j2);
        }

        private OfDouble(Spliterator.OfDouble ofDouble, OfDouble ofDouble2) {
            super(ofDouble, ofDouble2);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator.OfPrimitive
        protected final void BuiltInFictitiousFunctionClassFactory(Object obj) {
            ((DoubleConsumer) obj).accept(this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.function.DoubleConsumer
        public final void accept(double d) {
            this.BuiltInFictitiousFunctionClassFactory = d;
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator
        protected final Spliterator getAuthRequestContext(Spliterator spliterator) {
            return new OfDouble((Spliterator.OfDouble) spliterator, this);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator.OfPrimitive
        protected final StreamSpliterators$ArrayBuffer.OfPrimitive scheduleImpl() {
            return new StreamSpliterators$ArrayBuffer.OfDouble();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class OfInt extends OfPrimitive implements Spliterator.OfInt, IntConsumer {
        int getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt(Spliterator.OfInt ofInt, long j, long j2) {
            super(ofInt, j, j2);
        }

        private OfInt(Spliterator.OfInt ofInt, OfInt ofInt2) {
            super(ofInt, ofInt2);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator.OfPrimitive
        protected final void BuiltInFictitiousFunctionClassFactory(Object obj) {
            ((IntConsumer) obj).accept(this.getAuthRequestContext);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.MyBillsEntityDataFactory((Spliterator.OfInt) this, consumer);
        }

        @Override // j$.util.function.IntConsumer
        public final void accept(int i) {
            this.getAuthRequestContext = i;
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator
        protected final Spliterator getAuthRequestContext(Spliterator spliterator) {
            return new OfInt((Spliterator.OfInt) spliterator, this);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator.OfPrimitive
        protected final StreamSpliterators$ArrayBuffer.OfPrimitive scheduleImpl() {
            return new StreamSpliterators$ArrayBuffer.OfInt();
        }
    }

    /* loaded from: classes.dex */
    final class OfLong extends OfPrimitive implements Spliterator.OfLong, LongConsumer {
        long MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong(Spliterator.OfLong ofLong, long j, long j2) {
            super(ofLong, j, j2);
        }

        private OfLong(Spliterator.OfLong ofLong, OfLong ofLong2) {
            super(ofLong, ofLong2);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator.OfPrimitive
        protected final void BuiltInFictitiousFunctionClassFactory(Object obj) {
            ((LongConsumer) obj).accept(this.MyBillsEntityDataFactory);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            return Objects.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.function.LongConsumer
        public final void accept(long j) {
            this.MyBillsEntityDataFactory = j;
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator
        protected final Spliterator getAuthRequestContext(Spliterator spliterator) {
            return new OfLong((Spliterator.OfLong) spliterator, this);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
            Objects.getAuthRequestContext(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator.OfPrimitive
        protected final StreamSpliterators$ArrayBuffer.OfPrimitive scheduleImpl() {
            return new StreamSpliterators$ArrayBuffer.OfLong();
        }
    }

    /* loaded from: classes.dex */
    abstract class OfPrimitive extends StreamSpliterators$UnorderedSliceSpliterator implements Spliterator.OfPrimitive {
        OfPrimitive(Spliterator.OfPrimitive ofPrimitive, long j, long j2) {
            super(ofPrimitive, j, j2);
        }

        OfPrimitive(Spliterator.OfPrimitive ofPrimitive, OfPrimitive ofPrimitive2) {
            super(ofPrimitive, ofPrimitive2);
        }

        protected abstract void BuiltInFictitiousFunctionClassFactory(Object obj);

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final void getAuthRequestContext(Object obj) {
            StreamSpliterators$ArrayBuffer.OfPrimitive ofPrimitive = null;
            while (true) {
                int lookAheadTest = lookAheadTest();
                if (lookAheadTest == 1) {
                    return;
                }
                if (lookAheadTest != 2) {
                    ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(obj);
                    return;
                }
                if (ofPrimitive == null) {
                    ofPrimitive = scheduleImpl();
                } else {
                    ofPrimitive.MyBillsEntityDataFactory = 0;
                }
                long j = 0;
                while (((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(ofPrimitive)) {
                    j++;
                    if (j >= 128) {
                        break;
                    }
                }
                if (j == 0) {
                    return;
                }
                ofPrimitive.BuiltInFictitiousFunctionClassFactory(obj, BuiltInFictitiousFunctionClassFactory(j));
            }
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        public final /* bridge */ /* synthetic */ boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
            return PlaceComponentResult((Object) intConsumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final boolean PlaceComponentResult(Object obj) {
            while (lookAheadTest() != 1 && ((Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(this)) {
                if (BuiltInFictitiousFunctionClassFactory(1L) == 1) {
                    BuiltInFictitiousFunctionClassFactory(obj);
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        protected abstract StreamSpliterators$ArrayBuffer.OfPrimitive scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class OfRef extends StreamSpliterators$UnorderedSliceSpliterator implements Spliterator, Consumer {
        Object BuiltInFictitiousFunctionClassFactory;

        /* JADX INFO: Access modifiers changed from: package-private */
        public OfRef(Spliterator spliterator, long j, long j2) {
            super(spliterator, j, j2);
        }

        private OfRef(Spliterator spliterator, OfRef ofRef) {
            super(spliterator, ofRef);
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
            while (lookAheadTest() != 1 && this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this)) {
                if (BuiltInFictitiousFunctionClassFactory(1L) == 1) {
                    consumer.accept(this.BuiltInFictitiousFunctionClassFactory);
                    this.BuiltInFictitiousFunctionClassFactory = null;
                    return true;
                }
            }
            return false;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            this.BuiltInFictitiousFunctionClassFactory = obj;
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator
        protected final Spliterator getAuthRequestContext(Spliterator spliterator) {
            return new OfRef(spliterator, this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        @Override // j$.util.Spliterator
        public final void getAuthRequestContext(Consumer consumer) {
            StreamSpliterators$ArrayBuffer.OfRef ofRef = null;
            while (true) {
                int lookAheadTest = lookAheadTest();
                if (lookAheadTest == 1) {
                    return;
                }
                if (lookAheadTest != 2) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(consumer);
                    return;
                }
                if (ofRef == null) {
                    ofRef = new StreamSpliterators$ArrayBuffer.OfRef();
                } else {
                    ofRef.PlaceComponentResult = 0;
                }
                long j = 0;
                while (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(ofRef)) {
                    j++;
                    if (j >= 128) {
                        break;
                    }
                }
                if (j == 0) {
                    return;
                }
                long BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(j);
                for (int i = 0; i < BuiltInFictitiousFunctionClassFactory; i++) {
                    consumer.accept(ofRef.BuiltInFictitiousFunctionClassFactory[i]);
                }
            }
        }
    }

    StreamSpliterators$UnorderedSliceSpliterator(Spliterator spliterator, long j, long j2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spliterator;
        this.PlaceComponentResult = j2 < 0;
        this.BuiltInFictitiousFunctionClassFactory = j2 >= 0 ? j2 : 0L;
        this.getAuthRequestContext = new AtomicLong(j2 >= 0 ? j + j2 : j);
    }

    StreamSpliterators$UnorderedSliceSpliterator(Spliterator spliterator, StreamSpliterators$UnorderedSliceSpliterator streamSpliterators$UnorderedSliceSpliterator) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spliterator;
        this.PlaceComponentResult = streamSpliterators$UnorderedSliceSpliterator.PlaceComponentResult;
        this.getAuthRequestContext = streamSpliterators$UnorderedSliceSpliterator.getAuthRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = streamSpliterators$UnorderedSliceSpliterator.BuiltInFictitiousFunctionClassFactory;
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory() & (-16465);
    }

    protected final long BuiltInFictitiousFunctionClassFactory(long j) {
        long j2;
        long min;
        do {
            j2 = this.getAuthRequestContext.get();
            if (j2 != 0) {
                min = Math.min(j2, j);
                if (min <= 0) {
                    break;
                }
            } else if (this.PlaceComponentResult) {
                return j;
            } else {
                return 0L;
            }
        } while (!this.getAuthRequestContext.compareAndSet(j2, j2 - min));
        if (this.PlaceComponentResult) {
            return Math.max(j - min, 0L);
        }
        long j3 = this.BuiltInFictitiousFunctionClassFactory;
        return j2 > j3 ? Math.max(min - (j2 - j3), 0L) : min;
    }

    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final Spliterator MyBillsEntityDataFactory() {
        Spliterator moveToNextValue;
        if (this.getAuthRequestContext.get() == 0 || (moveToNextValue = this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()) == null) {
            return null;
        }
        return getAuthRequestContext(moveToNextValue);
    }

    public final /* synthetic */ Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return (Spliterator.OfPrimitive) MyBillsEntityDataFactory();
    }

    protected abstract Spliterator getAuthRequestContext(Spliterator spliterator);

    public final /* synthetic */ Spliterator.OfDouble getErrorConfigVersion() {
        return (Spliterator.OfDouble) MyBillsEntityDataFactory();
    }

    /* renamed from: getErrorConfigVersion  reason: collision with other method in class */
    public final /* synthetic */ Spliterator.OfInt m3174getErrorConfigVersion() {
        return (Spliterator.OfInt) MyBillsEntityDataFactory();
    }

    protected final int lookAheadTest() {
        if (this.getAuthRequestContext.get() > 0) {
            return 2;
        }
        return this.PlaceComponentResult ? 3 : 1;
    }

    public final /* synthetic */ Spliterator.OfLong moveToNextValue() {
        return (Spliterator.OfLong) MyBillsEntityDataFactory();
    }
}
