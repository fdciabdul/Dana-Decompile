package j$.util.stream;

import j$.time.DayOfWeek$$ExternalSyntheticOutline0;
import j$.time.format.SignStyle$EnumUnboxingLocalUtility;
import j$.util.Collection;
import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.BinaryOperator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.DoubleConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntConsumer;
import j$.util.function.IntConsumer$$ExternalSyntheticLambda0;
import j$.util.function.IntFunction;
import j$.util.function.LongConsumer;
import j$.util.function.LongConsumer$$ExternalSyntheticLambda0;
import j$.util.function.LongFunction;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import j$.util.stream.SpinedBuffer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes.dex */
public abstract class Nodes implements TerminalOp {
    private static final EmptyNode.OfRef moveToNextValue = new EmptyNode.OfRef();
    private static final Node.OfInt KClassImpl$Data$declaredNonStaticMembers$2 = new EmptyNode.OfInt();
    private static final Node.OfLong scheduleImpl = new EmptyNode.OfLong();
    private static final Node.OfDouble getAuthRequestContext = new EmptyNode.OfDouble();
    private static final int[] PlaceComponentResult = new int[0];
    private static final long[] BuiltInFictitiousFunctionClassFactory = new long[0];
    private static final double[] MyBillsEntityDataFactory = new double[0];

    /* renamed from: j$.util.stream.Nodes$1 */
    /* loaded from: classes2.dex */
    public abstract /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[SignStyle$EnumUnboxingLocalUtility.KClassImpl$Data$declaredNonStaticMembers$2(4).length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(1)] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(2)] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(3)] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[SignStyle$EnumUnboxingLocalUtility.getAuthRequestContext(4)] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class ArrayNode implements Node {
        final Object[] KClassImpl$Data$declaredNonStaticMembers$2;
        int getAuthRequestContext;

        ArrayNode(long j, IntFunction intFunction) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Object[]) intFunction.MyBillsEntityDataFactory((int) j);
            this.getAuthRequestContext = 0;
        }

        public ArrayNode(Object[] objArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = objArr;
            this.getAuthRequestContext = objArr.length;
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.Node
        public final Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return Spliterators.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.getAuthRequestContext);
        }

        @Override // j$.util.stream.Node
        public final void forEach(Consumer consumer) {
            for (int i = 0; i < this.getAuthRequestContext; i++) {
                consumer.accept(this.KClassImpl$Data$declaredNonStaticMembers$2[i]);
            }
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, j, j2, intFunction);
        }

        @Override // j$.util.stream.Node
        public final void getAuthRequestContext(Object[] objArr, int i) {
            System.arraycopy(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, objArr, i, this.getAuthRequestContext);
        }

        @Override // j$.util.stream.Node
        public final Object[] getAuthRequestContext(IntFunction intFunction) {
            Object[] objArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (objArr.length == this.getAuthRequestContext) {
                return objArr;
            }
            throw new IllegalStateException();
        }

        @Override // j$.util.stream.Node
        public final long s_() {
            return this.getAuthRequestContext;
        }

        public String toString() {
            return String.format("ArrayNode[%d][%s]", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length - this.getAuthRequestContext), Arrays.toString(this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes.dex */
    public final class CollectionNode implements Node {
        private final Collection PlaceComponentResult;

        public CollectionNode(Collection collection) {
            this.PlaceComponentResult = collection;
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.Node
        public final Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return Collection.EL.getAuthRequestContext(this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda2();
        }

        @Override // j$.util.stream.Node
        public final void forEach(Consumer consumer) {
            Collection.EL.getAuthRequestContext(this.PlaceComponentResult, consumer);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, j, j2, intFunction);
        }

        @Override // j$.util.stream.Node
        public final void getAuthRequestContext(Object[] objArr, int i) {
            Iterator it = this.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                objArr[i] = it.next();
                i++;
            }
        }

        @Override // j$.util.stream.Node
        public final Object[] getAuthRequestContext(IntFunction intFunction) {
            java.util.Collection collection = this.PlaceComponentResult;
            return collection.toArray((Object[]) intFunction.MyBillsEntityDataFactory(collection.size()));
        }

        @Override // j$.util.stream.Node
        public final long s_() {
            return this.PlaceComponentResult.size();
        }

        public final String toString() {
            return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.PlaceComponentResult.size()), this.PlaceComponentResult);
        }
    }

    /* loaded from: classes.dex */
    public class CollectorTask extends AbstractTask {
        protected final LongFunction builderFactory;
        protected final BinaryOperator concFactory;
        protected final Node.CC helper;

        /* loaded from: classes.dex */
        public final class OfInt extends CollectorTask {
            public static final /* synthetic */ int $r8$clinit = 0;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public OfInt(int r3, j$.util.Spliterator r4, j$.util.stream.Node.CC r5) {
                /*
                    r2 = this;
                    r0 = 2
                    r1 = 1
                    if (r3 == r1) goto L23
                    if (r3 == r0) goto L16
                    j$.util.stream.SliceOps$$ExternalSyntheticLambda0 r3 = new j$.util.stream.SliceOps$$ExternalSyntheticLambda0
                    r0 = 4
                    r3.<init>(r0)
                    j$.util.stream.SliceOps$$ExternalSyntheticLambda0 r0 = new j$.util.stream.SliceOps$$ExternalSyntheticLambda0
                    r1 = 5
                    r0.<init>(r1)
                L12:
                    r2.<init>(r5, r4, r3, r0)
                    return
                L16:
                    j$.util.stream.SliceOps$$ExternalSyntheticLambda0 r3 = new j$.util.stream.SliceOps$$ExternalSyntheticLambda0
                    r0 = 6
                    r3.<init>(r0)
                    j$.util.stream.SliceOps$$ExternalSyntheticLambda0 r0 = new j$.util.stream.SliceOps$$ExternalSyntheticLambda0
                    r1 = 7
                    r0.<init>(r1)
                    goto L12
                L23:
                    j$.util.stream.SliceOps$$ExternalSyntheticLambda0 r3 = new j$.util.stream.SliceOps$$ExternalSyntheticLambda0
                    r3.<init>(r0)
                    j$.util.stream.SliceOps$$ExternalSyntheticLambda0 r0 = new j$.util.stream.SliceOps$$ExternalSyntheticLambda0
                    r1 = 3
                    r0.<init>(r1)
                    goto L12
                */
                throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.Nodes.CollectorTask.OfInt.<init>(int, j$.util.Spliterator, j$.util.stream.Node$-CC):void");
            }

            public /* synthetic */ OfInt(Spliterator spliterator, IntFunction intFunction, Node.CC cc) {
                super(cc, spliterator, new Collectors$$ExternalSyntheticLambda25(3, intFunction), new SliceOps$$ExternalSyntheticLambda0(8));
            }
        }

        CollectorTask(Node.CC cc, Spliterator spliterator, LongFunction longFunction, SliceOps$$ExternalSyntheticLambda0 sliceOps$$ExternalSyntheticLambda0) {
            super(cc, spliterator);
            this.helper = cc;
            this.builderFactory = longFunction;
            this.concFactory = sliceOps$$ExternalSyntheticLambda0;
        }

        CollectorTask(CollectorTask collectorTask, Spliterator spliterator) {
            super(collectorTask, spliterator);
            this.helper = collectorTask.helper;
            this.builderFactory = collectorTask.builderFactory;
            this.concFactory = collectorTask.concFactory;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractTask
        public final Object doLeaf() {
            Node.Builder builder = (Node.Builder) this.builderFactory.MyBillsEntityDataFactory(this.helper.getAuthRequestContext(this.spliterator));
            this.helper.PlaceComponentResult(this.spliterator, builder);
            return builder.PlaceComponentResult();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // j$.util.stream.AbstractTask
        public final AbstractTask makeChild(Spliterator spliterator) {
            return new CollectorTask(this, spliterator);
        }

        @Override // j$.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter countedCompleter) {
            AbstractTask abstractTask = this.leftChild;
            if (!(abstractTask == null)) {
                setLocalResult((Node) this.concFactory.apply((Node) ((CollectorTask) abstractTask).getLocalResult(), (Node) ((CollectorTask) this.rightChild).getLocalResult()));
            }
            super.onCompletion(countedCompleter);
        }
    }

    /* loaded from: classes.dex */
    public final class DoubleFixedNodeBuilder extends DoubleArrayNode implements Node.Builder.OfDouble {
        DoubleFixedNodeBuilder(long j) {
            super(j);
        }

        @Override // j$.util.stream.Node.Builder
        public final /* synthetic */ Node PlaceComponentResult() {
            getAuthRequestContext();
            return this;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final void accept(double d) {
            int i = this.MyBillsEntityDataFactory;
            double[] dArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= dArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
            }
            this.MyBillsEntityDataFactory = i + 1;
            dArr[i] = d;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.stream.Sink.OfDouble
        public final /* synthetic */ void accept(Double d) {
            Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Double) obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.function.DoubleConsumer
        public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
            return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            if (j != this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
            }
            this.MyBillsEntityDataFactory = 0;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
            if (this.MyBillsEntityDataFactory < this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.MyBillsEntityDataFactory), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
            }
        }

        @Override // j$.util.stream.Node.Builder.OfDouble
        public final Node.OfDouble getAuthRequestContext() {
            if (this.MyBillsEntityDataFactory >= this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.MyBillsEntityDataFactory), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
        }

        @Override // j$.util.stream.Nodes.DoubleArrayNode
        public final String toString() {
            return String.format("DoubleFixedNodeBuilder[%d][%s]", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length - this.MyBillsEntityDataFactory), Arrays.toString(this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes.dex */
    public final class FixedNodeBuilder extends ArrayNode implements Node.Builder {
        FixedNodeBuilder(long j, IntFunction intFunction) {
            super(j, intFunction);
        }

        @Override // j$.util.stream.Node.Builder
        public final Node PlaceComponentResult() {
            if (this.getAuthRequestContext >= this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.getAuthRequestContext), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            int i = this.getAuthRequestContext;
            Object[] objArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i >= objArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
            }
            this.getAuthRequestContext = i + 1;
            objArr[i] = obj;
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            if (j != this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
            }
            this.getAuthRequestContext = 0;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
            if (this.getAuthRequestContext < this.KClassImpl$Data$declaredNonStaticMembers$2.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.getAuthRequestContext), Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length)));
            }
        }

        @Override // j$.util.stream.Nodes.ArrayNode
        public final String toString() {
            return String.format("FixedNodeBuilder[%d][%s]", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length - this.getAuthRequestContext), Arrays.toString(this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    /* loaded from: classes.dex */
    public final class IntFixedNodeBuilder extends IntArrayNode implements Node.Builder.OfInt {
        IntFixedNodeBuilder(long j) {
            super(j);
        }

        @Override // j$.util.stream.Node.Builder
        public final /* synthetic */ Node PlaceComponentResult() {
            getAuthRequestContext();
            return this;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final void accept(int i) {
            int i2 = this.PlaceComponentResult;
            int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
            if (i2 >= iArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.length)));
            }
            this.PlaceComponentResult = i2 + 1;
            iArr[i2] = i;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.stream.Sink.OfInt
        public final /* synthetic */ void accept(Integer num) {
            Node.CC.MyBillsEntityDataFactory(this, num);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Integer) obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.function.IntConsumer
        public final IntConsumer andThen(IntConsumer intConsumer) {
            return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            if (j != this.BuiltInFictitiousFunctionClassFactory.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.length)));
            }
            this.PlaceComponentResult = 0;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
            if (this.PlaceComponentResult < this.BuiltInFictitiousFunctionClassFactory.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.length)));
            }
        }

        @Override // j$.util.stream.Node.Builder.OfInt
        public final Node.OfInt getAuthRequestContext() {
            if (this.PlaceComponentResult >= this.BuiltInFictitiousFunctionClassFactory.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.length)));
        }

        @Override // j$.util.stream.Nodes.IntArrayNode
        public final String toString() {
            return String.format("IntFixedNodeBuilder[%d][%s]", Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.length - this.PlaceComponentResult), Arrays.toString(this.BuiltInFictitiousFunctionClassFactory));
        }
    }

    /* loaded from: classes.dex */
    public abstract class InternalNodeSpliterator implements Spliterator {
        Spliterator BuiltInFictitiousFunctionClassFactory;
        Node KClassImpl$Data$declaredNonStaticMembers$2;
        Spliterator MyBillsEntityDataFactory;
        int PlaceComponentResult;
        ArrayDeque getAuthRequestContext;

        /* loaded from: classes.dex */
        final class OfDouble extends OfPrimitive implements Spliterator.OfDouble {
            OfDouble(Node.OfDouble ofDouble) {
                super(ofDouble);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                Objects.PlaceComponentResult(this, consumer);
            }
        }

        /* loaded from: classes.dex */
        final class OfInt extends OfPrimitive implements Spliterator.OfInt {
            OfInt(Node.OfInt ofInt) {
                super(ofInt);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return Objects.MyBillsEntityDataFactory((Spliterator.OfInt) this, consumer);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
            }
        }

        /* loaded from: classes.dex */
        final class OfLong extends OfPrimitive implements Spliterator.OfLong {
            OfLong(Node.OfLong ofLong) {
                super(ofLong);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                return Objects.PlaceComponentResult(this, consumer);
            }

            @Override // j$.util.Spliterator
            public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
                Objects.getAuthRequestContext(this, consumer);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public abstract class OfPrimitive extends InternalNodeSpliterator implements Spliterator.OfPrimitive {
            OfPrimitive(Node.OfPrimitive ofPrimitive) {
                super(ofPrimitive);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
            public final void getAuthRequestContext(Object obj) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    return;
                }
                if (this.MyBillsEntityDataFactory == null) {
                    Spliterator spliterator = this.BuiltInFictitiousFunctionClassFactory;
                    if (spliterator != null) {
                        ((Spliterator.OfPrimitive) spliterator).getAuthRequestContext(obj);
                        return;
                    }
                    ArrayDeque lookAheadTest = lookAheadTest();
                    while (true) {
                        Node.OfPrimitive ofPrimitive = (Node.OfPrimitive) InternalNodeSpliterator.PlaceComponentResult(lookAheadTest);
                        if (ofPrimitive == null) {
                            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                            return;
                        }
                        ofPrimitive.getAuthRequestContext(obj);
                    }
                }
                do {
                } while (PlaceComponentResult(obj));
            }

            public final /* bridge */ /* synthetic */ boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
                return PlaceComponentResult((Object) intConsumer);
            }

            @Override // j$.util.Spliterator.OfPrimitive
            /* renamed from: MyBillsEntityDataFactory */
            public final boolean PlaceComponentResult(Object obj) {
                Node.OfPrimitive ofPrimitive;
                if (scheduleImpl()) {
                    boolean PlaceComponentResult = ((Spliterator.OfPrimitive) this.MyBillsEntityDataFactory).PlaceComponentResult(obj);
                    if (!PlaceComponentResult) {
                        if (this.BuiltInFictitiousFunctionClassFactory == null && (ofPrimitive = (Node.OfPrimitive) InternalNodeSpliterator.PlaceComponentResult(this.getAuthRequestContext)) != null) {
                            Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0 = ofPrimitive.NetworkUserEntityData$$ExternalSyntheticLambda0();
                            this.MyBillsEntityDataFactory = NetworkUserEntityData$$ExternalSyntheticLambda0;
                            return NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(obj);
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    }
                    return PlaceComponentResult;
                }
                return false;
            }
        }

        /* loaded from: classes.dex */
        final class OfRef extends InternalNodeSpliterator {
            OfRef(Node node) {
                super(node);
            }

            @Override // j$.util.Spliterator
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
                Node PlaceComponentResult;
                if (scheduleImpl()) {
                    boolean KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(consumer);
                    if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                        if (this.BuiltInFictitiousFunctionClassFactory == null && (PlaceComponentResult = InternalNodeSpliterator.PlaceComponentResult(this.getAuthRequestContext)) != null) {
                            Spliterator KClassImpl$Data$declaredNonStaticMembers$22 = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
                            this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$22;
                            return KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2(consumer);
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    }
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
                return false;
            }

            @Override // j$.util.Spliterator
            public final void getAuthRequestContext(Consumer consumer) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    return;
                }
                if (this.MyBillsEntityDataFactory == null) {
                    Spliterator spliterator = this.BuiltInFictitiousFunctionClassFactory;
                    if (spliterator != null) {
                        spliterator.getAuthRequestContext(consumer);
                        return;
                    }
                    ArrayDeque lookAheadTest = lookAheadTest();
                    while (true) {
                        Node PlaceComponentResult = InternalNodeSpliterator.PlaceComponentResult(lookAheadTest);
                        if (PlaceComponentResult == null) {
                            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                            return;
                        }
                        PlaceComponentResult.forEach(consumer);
                    }
                }
                do {
                } while (KClassImpl$Data$declaredNonStaticMembers$2(consumer));
            }
        }

        InternalNodeSpliterator(Node node) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = node;
        }

        protected static Node PlaceComponentResult(ArrayDeque arrayDeque) {
            while (true) {
                Node node = (Node) arrayDeque.pollFirst();
                if (node == null) {
                    return null;
                }
                if (node.BuiltInFictitiousFunctionClassFactory() != 0) {
                    int BuiltInFictitiousFunctionClassFactory = node.BuiltInFictitiousFunctionClassFactory();
                    while (true) {
                        BuiltInFictitiousFunctionClassFactory--;
                        if (BuiltInFictitiousFunctionClassFactory >= 0) {
                            arrayDeque.addFirst(node.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
                        }
                    }
                } else if (node.s_() > 0) {
                    return node;
                }
            }
        }

        @Override // j$.util.Spliterator
        public final int BuiltInFictitiousFunctionClassFactory() {
            return 64;
        }

        @Override // j$.util.Spliterator
        public final long KClassImpl$Data$declaredNonStaticMembers$2() {
            long j = 0;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return 0L;
            }
            Spliterator spliterator = this.BuiltInFictitiousFunctionClassFactory;
            if (spliterator != null) {
                return spliterator.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            for (int i = this.PlaceComponentResult; i < this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(); i++) {
                j += this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(i).s_();
            }
            return j;
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
        }

        @Override // j$.util.Spliterator
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator moveToNextValue() {
            Node node = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (node == null || this.MyBillsEntityDataFactory != null) {
                return null;
            }
            Spliterator spliterator = this.BuiltInFictitiousFunctionClassFactory;
            if (spliterator != null) {
                return spliterator.moveToNextValue();
            }
            if (this.PlaceComponentResult < node.BuiltInFictitiousFunctionClassFactory() - 1) {
                Node node2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                int i = this.PlaceComponentResult;
                this.PlaceComponentResult = i + 1;
                return node2.BuiltInFictitiousFunctionClassFactory(i).KClassImpl$Data$declaredNonStaticMembers$2();
            }
            Node BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
            if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory() == 0) {
                Spliterator KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
                return KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
            }
            Node node3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            this.PlaceComponentResult = 1;
            return node3.BuiltInFictitiousFunctionClassFactory(0).KClassImpl$Data$declaredNonStaticMembers$2();
        }

        public final /* synthetic */ Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return (Spliterator.OfPrimitive) moveToNextValue();
        }

        @Override // j$.util.Spliterator
        public final /* synthetic */ long PlaceComponentResult() {
            return Objects.getAuthRequestContext(this);
        }

        @Override // j$.util.Spliterator
        public final Comparator getAuthRequestContext() {
            throw new IllegalStateException();
        }

        public final /* synthetic */ Spliterator.OfDouble getErrorConfigVersion() {
            return (Spliterator.OfDouble) moveToNextValue();
        }

        /* renamed from: getErrorConfigVersion */
        public final /* synthetic */ Spliterator.OfInt m3170getErrorConfigVersion() {
            return (Spliterator.OfInt) moveToNextValue();
        }

        protected final ArrayDeque lookAheadTest() {
            ArrayDeque arrayDeque = new ArrayDeque(8);
            int BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
            while (true) {
                BuiltInFictitiousFunctionClassFactory--;
                if (BuiltInFictitiousFunctionClassFactory < this.PlaceComponentResult) {
                    return arrayDeque;
                }
                arrayDeque.addFirst(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
            }
        }

        public final /* synthetic */ Spliterator.OfLong moveToNextValue() {
            return (Spliterator.OfLong) moveToNextValue();
        }

        protected final boolean scheduleImpl() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                return false;
            }
            if (this.MyBillsEntityDataFactory == null) {
                Spliterator spliterator = this.BuiltInFictitiousFunctionClassFactory;
                if (spliterator == null) {
                    ArrayDeque lookAheadTest = lookAheadTest();
                    this.getAuthRequestContext = lookAheadTest;
                    Node PlaceComponentResult = PlaceComponentResult(lookAheadTest);
                    if (PlaceComponentResult == null) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                        return false;
                    }
                    spliterator = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                this.MyBillsEntityDataFactory = spliterator;
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class LongFixedNodeBuilder extends LongArrayNode implements Node.Builder.OfLong {
        LongFixedNodeBuilder(long j) {
            super(j);
        }

        @Override // j$.util.stream.Node.Builder.OfLong
        public final Node.OfLong MyBillsEntityDataFactory() {
            if (this.BuiltInFictitiousFunctionClassFactory >= this.getAuthRequestContext.length) {
                return this;
            }
            throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory), Integer.valueOf(this.getAuthRequestContext.length)));
        }

        @Override // j$.util.stream.Node.Builder
        public final /* synthetic */ Node PlaceComponentResult() {
            MyBillsEntityDataFactory();
            return this;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final void accept(long j) {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            long[] jArr = this.getAuthRequestContext;
            if (i >= jArr.length) {
                throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", Integer.valueOf(this.getAuthRequestContext.length)));
            }
            this.BuiltInFictitiousFunctionClassFactory = i + 1;
            jArr[i] = j;
        }

        @Override // j$.util.stream.Sink.OfLong
        public final /* synthetic */ void accept(Long l) {
            Node.CC.PlaceComponentResult(this, l);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Long) obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.function.LongConsumer
        public final LongConsumer andThen(LongConsumer longConsumer) {
            return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            if (j != this.getAuthRequestContext.length) {
                throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", Long.valueOf(j), Integer.valueOf(this.getAuthRequestContext.length)));
            }
            this.BuiltInFictitiousFunctionClassFactory = 0;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
            if (this.BuiltInFictitiousFunctionClassFactory < this.getAuthRequestContext.length) {
                throw new IllegalStateException(String.format("End size %d is less than fixed size %d", Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory), Integer.valueOf(this.getAuthRequestContext.length)));
            }
        }

        @Override // j$.util.stream.Nodes.LongArrayNode
        public final String toString() {
            return String.format("LongFixedNodeBuilder[%d][%s]", Integer.valueOf(this.getAuthRequestContext.length - this.BuiltInFictitiousFunctionClassFactory), Arrays.toString(this.getAuthRequestContext));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class SizedCollectorTask extends CountedCompleter implements Sink {
        protected int fence;
        protected final Node.CC helper;
        protected int index;
        protected long length;
        protected long offset;
        protected final Spliterator spliterator;
        protected final long targetSize;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class OfDouble extends SizedCollectorTask implements Sink.OfDouble {
            private final double[] array;

            OfDouble(Spliterator spliterator, Node.CC cc, double[] dArr) {
                super(dArr.length, spliterator, cc);
                this.array = dArr;
            }

            OfDouble(OfDouble ofDouble, Spliterator spliterator, long j, long j2) {
                super(ofDouble, spliterator, j, j2, ofDouble.array.length);
                this.array = ofDouble.array;
            }

            @Override // j$.util.stream.Nodes.SizedCollectorTask, j$.util.stream.Sink, j$.util.function.DoubleConsumer
            public final void accept(double d) {
                int i = this.index;
                if (i >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                double[] dArr = this.array;
                this.index = i + 1;
                dArr[i] = d;
            }

            @Override // j$.util.stream.Sink.OfDouble
            public final /* synthetic */ void accept(Double d) {
                Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ void accept(Object obj) {
                accept((Double) obj);
            }

            @Override // j$.util.function.DoubleConsumer
            public final DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
                return new DoubleConsumer$$ExternalSyntheticLambda0(this, doubleConsumer);
            }

            @Override // j$.util.stream.Nodes.SizedCollectorTask
            final SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfDouble(this, spliterator, j, j2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class OfInt extends SizedCollectorTask implements Sink.OfInt {
            private final int[] array;

            OfInt(Spliterator spliterator, Node.CC cc, int[] iArr) {
                super(iArr.length, spliterator, cc);
                this.array = iArr;
            }

            OfInt(OfInt ofInt, Spliterator spliterator, long j, long j2) {
                super(ofInt, spliterator, j, j2, ofInt.array.length);
                this.array = ofInt.array;
            }

            @Override // j$.util.stream.Nodes.SizedCollectorTask, j$.util.stream.Sink
            public final void accept(int i) {
                int i2 = this.index;
                if (i2 >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                int[] iArr = this.array;
                this.index = i2 + 1;
                iArr[i2] = i;
            }

            @Override // j$.util.stream.Sink.OfInt
            public final /* synthetic */ void accept(Integer num) {
                Node.CC.MyBillsEntityDataFactory(this, num);
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ void accept(Object obj) {
                accept((Integer) obj);
            }

            @Override // j$.util.function.IntConsumer
            public final IntConsumer andThen(IntConsumer intConsumer) {
                return new IntConsumer$$ExternalSyntheticLambda0(this, intConsumer);
            }

            @Override // j$.util.stream.Nodes.SizedCollectorTask
            final SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfInt(this, spliterator, j, j2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class OfLong extends SizedCollectorTask implements Sink.OfLong {
            private final long[] array;

            OfLong(Spliterator spliterator, Node.CC cc, long[] jArr) {
                super(jArr.length, spliterator, cc);
                this.array = jArr;
            }

            OfLong(OfLong ofLong, Spliterator spliterator, long j, long j2) {
                super(ofLong, spliterator, j, j2, ofLong.array.length);
                this.array = ofLong.array;
            }

            @Override // j$.util.stream.Nodes.SizedCollectorTask, j$.util.stream.Sink
            public final void accept(long j) {
                int i = this.index;
                if (i >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                long[] jArr = this.array;
                this.index = i + 1;
                jArr[i] = j;
            }

            @Override // j$.util.stream.Sink.OfLong
            public final /* synthetic */ void accept(Long l) {
                Node.CC.PlaceComponentResult(this, l);
            }

            @Override // j$.util.function.Consumer
            public final /* synthetic */ void accept(Object obj) {
                accept((Long) obj);
            }

            @Override // j$.util.function.LongConsumer
            public final LongConsumer andThen(LongConsumer longConsumer) {
                return new LongConsumer$$ExternalSyntheticLambda0(this, longConsumer);
            }

            @Override // j$.util.stream.Nodes.SizedCollectorTask
            final SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfLong(this, spliterator, j, j2);
            }
        }

        /* loaded from: classes.dex */
        public final class OfRef extends SizedCollectorTask {
            private final Object[] array;

            OfRef(Spliterator spliterator, Node.CC cc, Object[] objArr) {
                super(objArr.length, spliterator, cc);
                this.array = objArr;
            }

            OfRef(OfRef ofRef, Spliterator spliterator, long j, long j2) {
                super(ofRef, spliterator, j, j2, ofRef.array.length);
                this.array = ofRef.array;
            }

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                int i = this.index;
                if (i >= this.fence) {
                    throw new IndexOutOfBoundsException(Integer.toString(this.index));
                }
                Object[] objArr = this.array;
                this.index = i + 1;
                objArr[i] = obj;
            }

            @Override // j$.util.stream.Nodes.SizedCollectorTask
            final SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2) {
                return new OfRef(this, spliterator, j, j2);
            }
        }

        SizedCollectorTask(int i, Spliterator spliterator, Node.CC cc) {
            this.spliterator = spliterator;
            this.helper = cc;
            this.targetSize = AbstractTask.suggestTargetSize(spliterator.KClassImpl$Data$declaredNonStaticMembers$2());
            this.offset = 0L;
            this.length = i;
        }

        SizedCollectorTask(SizedCollectorTask sizedCollectorTask, Spliterator spliterator, long j, long j2, int i) {
            super(sizedCollectorTask);
            this.spliterator = spliterator;
            this.helper = sizedCollectorTask.helper;
            this.targetSize = sizedCollectorTask.targetSize;
            this.offset = j;
            this.length = j2;
            if (j < 0 || j2 < 0 || (j + j2) - 1 >= i) {
                throw new IllegalArgumentException(String.format("offset and length interval [%d, %d + %d) is not within array size interval [0, %d)", Long.valueOf(j), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)));
            }
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            long j2 = this.length;
            if (j > j2) {
                throw new IllegalStateException("size passed to Sink.begin exceeds array length");
            }
            int i = (int) this.offset;
            this.index = i;
            this.fence = i + ((int) j2);
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Spliterator moveToNextValue;
            Spliterator spliterator = this.spliterator;
            SizedCollectorTask sizedCollectorTask = this;
            while (spliterator.KClassImpl$Data$declaredNonStaticMembers$2() > sizedCollectorTask.targetSize && (moveToNextValue = spliterator.moveToNextValue()) != null) {
                sizedCollectorTask.setPendingCount(1);
                long KClassImpl$Data$declaredNonStaticMembers$2 = moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
                sizedCollectorTask.makeChild(moveToNextValue, sizedCollectorTask.offset, KClassImpl$Data$declaredNonStaticMembers$2).fork();
                sizedCollectorTask = sizedCollectorTask.makeChild(spliterator, sizedCollectorTask.offset + KClassImpl$Data$declaredNonStaticMembers$2, sizedCollectorTask.length - KClassImpl$Data$declaredNonStaticMembers$2);
            }
            sizedCollectorTask.helper.PlaceComponentResult(spliterator, sizedCollectorTask);
            sizedCollectorTask.propagateCompletion();
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void end() {
        }

        abstract SizedCollectorTask makeChild(Spliterator spliterator, long j, long j2);
    }

    /* loaded from: classes.dex */
    public final class SpinedNodeBuilder extends SpinedBuffer implements Node, Node.Builder {
        SpinedNodeBuilder() {
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.Node
        public final Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.SpinedBuffer, j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.Builder
        public final Node PlaceComponentResult() {
            return this;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.stream.SpinedBuffer, j$.util.function.Consumer
        public final void accept(Object obj) {
            super.accept(obj);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            t_();
            MyBillsEntityDataFactory(j);
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
        }

        @Override // j$.util.stream.SpinedBuffer, j$.lang.Iterable
        public final void forEach(Consumer consumer) {
            super.forEach(consumer);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, j, j2, intFunction);
        }

        @Override // j$.util.stream.Node
        public final void getAuthRequestContext(Object[] objArr, int i) {
            long j = i;
            long s_ = s_() + j;
            if (s_ > objArr.length || s_ < j) {
                throw new IndexOutOfBoundsException("does not fit");
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                System.arraycopy(this.BuiltInFictitiousFunctionClassFactory, 0, objArr, i, this.getAuthRequestContext);
                return;
            }
            for (int i2 = 0; i2 < this.KClassImpl$Data$declaredNonStaticMembers$2; i2++) {
                Object[] objArr2 = this.moveToNextValue[i2];
                System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
                i += this.moveToNextValue[i2].length;
            }
            int i3 = this.getAuthRequestContext;
            if (i3 > 0) {
                System.arraycopy(this.BuiltInFictitiousFunctionClassFactory, 0, objArr, i, i3);
            }
        }

        @Override // j$.util.stream.Node
        public final Object[] getAuthRequestContext(IntFunction intFunction) {
            long s_ = s_();
            if (s_ < 2147483639) {
                Object[] objArr = (Object[]) intFunction.MyBillsEntityDataFactory((int) s_);
                getAuthRequestContext(objArr, 0);
                return objArr;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* loaded from: classes.dex */
    public abstract class ToArrayTask extends CountedCompleter {
        protected final Node node;
        protected final int offset;

        /* loaded from: classes.dex */
        public final class OfInt extends OfRef {
            public /* synthetic */ OfInt(Node.OfDouble ofDouble, double[] dArr) {
                super(ofDouble, dArr);
            }

            public /* synthetic */ OfInt(Node.OfInt ofInt, int[] iArr) {
                super(ofInt, iArr);
            }

            public /* synthetic */ OfInt(Node.OfLong ofLong, long[] jArr) {
                super(ofLong, jArr);
            }
        }

        /* loaded from: classes.dex */
        public class OfRef extends ToArrayTask {
            public final /* synthetic */ int $r8$classId;
            private final Object array;

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ OfRef(Node.OfPrimitive ofPrimitive, Object obj) {
                this(ofPrimitive, obj, 1);
                this.$r8$classId = 1;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ OfRef(Node node, Object obj, int i) {
                super(node);
                this.$r8$classId = i;
                this.array = obj;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public /* synthetic */ OfRef(Node node, Object[] objArr) {
                this(node, objArr, 0);
                this.$r8$classId = 0;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OfRef(OfRef ofRef, Node.OfPrimitive ofPrimitive, int i) {
                super(ofRef, ofPrimitive, i);
                this.$r8$classId = 1;
                this.array = ofRef.array;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OfRef(OfRef ofRef, Node node, int i) {
                super(ofRef, node, i);
                this.$r8$classId = 0;
                this.array = (Object[]) ofRef.array;
            }

            @Override // j$.util.stream.Nodes.ToArrayTask
            final void copyNodeToArray() {
                if (this.$r8$classId == 0) {
                    this.node.getAuthRequestContext((Object[]) this.array, this.offset);
                    return;
                }
                ((Node.OfPrimitive) this.node).BuiltInFictitiousFunctionClassFactory(this.offset, this.array);
            }

            @Override // j$.util.stream.Nodes.ToArrayTask
            final OfRef makeChild(int i, int i2) {
                return this.$r8$classId != 0 ? new OfRef(this, ((Node.OfPrimitive) this.node).KClassImpl$Data$declaredNonStaticMembers$2(i), i2) : new OfRef(this, this.node.BuiltInFictitiousFunctionClassFactory(i), i2);
            }
        }

        ToArrayTask(Node node) {
            this.node = node;
            this.offset = 0;
        }

        ToArrayTask(ToArrayTask toArrayTask, Node node, int i) {
            super(toArrayTask);
            this.node = node;
            this.offset = i;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            ToArrayTask toArrayTask = this;
            while (toArrayTask.node.BuiltInFictitiousFunctionClassFactory() != 0) {
                toArrayTask.setPendingCount(toArrayTask.node.BuiltInFictitiousFunctionClassFactory() - 1);
                int i = 0;
                int i2 = 0;
                while (i < toArrayTask.node.BuiltInFictitiousFunctionClassFactory() - 1) {
                    OfRef makeChild = toArrayTask.makeChild(i, toArrayTask.offset + i2);
                    i2 = (int) (i2 + makeChild.node.s_());
                    makeChild.fork();
                    i++;
                }
                toArrayTask = toArrayTask.makeChild(i, toArrayTask.offset + i2);
            }
            toArrayTask.copyNodeToArray();
            toArrayTask.propagateCompletion();
        }

        abstract void copyNodeToArray();

        abstract OfRef makeChild(int i, int i2);
    }

    public static Node.Builder.OfInt BuiltInFictitiousFunctionClassFactory(long j) {
        return (j < 0 || j >= 2147483639) ? new IntSpinedNodeBuilder() : new IntFixedNodeBuilder(j);
    }

    public static Node.Builder BuiltInFictitiousFunctionClassFactory(long j, IntFunction intFunction) {
        return (j < 0 || j >= 2147483639) ? new SpinedNodeBuilder() : new FixedNodeBuilder(j, intFunction);
    }

    public static Node.OfInt BuiltInFictitiousFunctionClassFactory(Node.OfInt ofInt) {
        if (ofInt.BuiltInFictitiousFunctionClassFactory() > 0) {
            long s_ = ofInt.s_();
            if (s_ < 2147483639) {
                int[] iArr = new int[(int) s_];
                new ToArrayTask.OfInt(ofInt, iArr).invoke();
                return new IntArrayNode(iArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return ofInt;
    }

    public static Node BuiltInFictitiousFunctionClassFactory(Node.CC cc, Spliterator spliterator, boolean z, IntFunction intFunction) {
        long authRequestContext = cc.getAuthRequestContext(spliterator);
        if (authRequestContext < 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) {
            Node node = (Node) new CollectorTask.OfInt(spliterator, intFunction, cc).invoke();
            return z ? MyBillsEntityDataFactory(node, intFunction) : node;
        } else if (authRequestContext < 2147483639) {
            Object[] objArr = (Object[]) intFunction.MyBillsEntityDataFactory((int) authRequestContext);
            new SizedCollectorTask.OfRef(spliterator, cc, objArr).invoke();
            return new ArrayNode(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static AbstractConcNode BuiltInFictitiousFunctionClassFactory(int i, Node node, Node node2) {
        int[] iArr = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0) {
            int i2 = iArr[i - 1];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return new ConcNode.OfDouble((Node.OfDouble) node, (Node.OfDouble) node2);
                        }
                        StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Unknown shape ");
                        PlaceComponentResult2.append(DayOfWeek$$ExternalSyntheticOutline0.BuiltInFictitiousFunctionClassFactory(i));
                        throw new IllegalStateException(PlaceComponentResult2.toString());
                    }
                    return new ConcNode.OfLong((Node.OfLong) node, (Node.OfLong) node2);
                }
                return new ConcNode.OfInt((Node.OfInt) node, (Node.OfInt) node2);
            }
            return new ConcNode(node, node2);
        }
        throw null;
    }

    public static Node.Builder.OfLong KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        return (j < 0 || j >= 2147483639) ? new LongSpinedNodeBuilder() : new LongFixedNodeBuilder(j);
    }

    public static Node.Builder.OfDouble MyBillsEntityDataFactory(long j) {
        return (j < 0 || j >= 2147483639) ? new DoubleSpinedNodeBuilder() : new DoubleFixedNodeBuilder(j);
    }

    public static Node.OfDouble MyBillsEntityDataFactory(Node.OfDouble ofDouble) {
        if (ofDouble.BuiltInFictitiousFunctionClassFactory() > 0) {
            long s_ = ofDouble.s_();
            if (s_ < 2147483639) {
                double[] dArr = new double[(int) s_];
                new ToArrayTask.OfInt(ofDouble, dArr).invoke();
                return new DoubleArrayNode(dArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return ofDouble;
    }

    public static Node.OfLong MyBillsEntityDataFactory(Node.CC cc, Spliterator spliterator, boolean z) {
        long authRequestContext = cc.getAuthRequestContext(spliterator);
        if (authRequestContext < 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) {
            Node.OfLong ofLong = (Node.OfLong) new CollectorTask.OfInt(2, spliterator, cc).invoke();
            return z ? getAuthRequestContext(ofLong) : ofLong;
        } else if (authRequestContext < 2147483639) {
            long[] jArr = new long[(int) authRequestContext];
            new SizedCollectorTask.OfLong(spliterator, cc, jArr).invoke();
            return new LongArrayNode(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static Node MyBillsEntityDataFactory(Node node, IntFunction intFunction) {
        if (node.BuiltInFictitiousFunctionClassFactory() > 0) {
            long s_ = node.s_();
            if (s_ < 2147483639) {
                Object[] objArr = (Object[]) intFunction.MyBillsEntityDataFactory((int) s_);
                new ToArrayTask.OfRef(node, objArr).invoke();
                return new ArrayNode(objArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return node;
    }

    public static Node.OfInt PlaceComponentResult(Node.CC cc, Spliterator spliterator, boolean z) {
        long authRequestContext = cc.getAuthRequestContext(spliterator);
        if (authRequestContext < 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) {
            Node.OfInt ofInt = (Node.OfInt) new CollectorTask.OfInt(0, spliterator, cc).invoke();
            return z ? BuiltInFictitiousFunctionClassFactory(ofInt) : ofInt;
        } else if (authRequestContext < 2147483639) {
            int[] iArr = new int[(int) authRequestContext];
            new SizedCollectorTask.OfInt(spliterator, cc, iArr).invoke();
            return new IntArrayNode(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static Node.OfDouble getAuthRequestContext(Node.CC cc, Spliterator spliterator, boolean z) {
        long authRequestContext = cc.getAuthRequestContext(spliterator);
        if (authRequestContext < 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) {
            Node.OfDouble ofDouble = (Node.OfDouble) new CollectorTask.OfInt(1, spliterator, cc).invoke();
            return z ? MyBillsEntityDataFactory(ofDouble) : ofDouble;
        } else if (authRequestContext < 2147483639) {
            double[] dArr = new double[(int) authRequestContext];
            new SizedCollectorTask.OfDouble(spliterator, cc, dArr).invoke();
            return new DoubleArrayNode(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    public static Node.OfLong getAuthRequestContext(Node.OfLong ofLong) {
        if (ofLong.BuiltInFictitiousFunctionClassFactory() > 0) {
            long s_ = ofLong.s_();
            if (s_ < 2147483639) {
                long[] jArr = new long[(int) s_];
                new ToArrayTask.OfInt(ofLong, jArr).invoke();
                return new LongArrayNode(jArr);
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        return ofLong;
    }

    public static EmptyNode getAuthRequestContext(int i) {
        Node.OfPrimitive ofPrimitive;
        int[] iArr = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i != 0) {
            int i2 = iArr[i - 1];
            if (i2 != 1) {
                if (i2 == 2) {
                    ofPrimitive = KClassImpl$Data$declaredNonStaticMembers$2;
                } else if (i2 == 3) {
                    ofPrimitive = scheduleImpl;
                } else if (i2 != 4) {
                    StringBuilder PlaceComponentResult2 = DayOfWeek$$ExternalSyntheticOutline0.PlaceComponentResult("Unknown shape ");
                    PlaceComponentResult2.append(DayOfWeek$$ExternalSyntheticOutline0.BuiltInFictitiousFunctionClassFactory(i));
                    throw new IllegalStateException(PlaceComponentResult2.toString());
                } else {
                    ofPrimitive = getAuthRequestContext;
                }
                return (EmptyNode) ofPrimitive;
            }
            return moveToNextValue;
        }
        throw null;
    }

    @Override // j$.util.stream.TerminalOp
    public /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
        return 0;
    }

    public abstract ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$2();

    @Override // j$.util.stream.TerminalOp
    public final Object MyBillsEntityDataFactory(Node.CC cc, Spliterator spliterator) {
        ReduceOps$AccumulatingSink KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2();
        cc.PlaceComponentResult(spliterator, KClassImpl$Data$declaredNonStaticMembers$22);
        return KClassImpl$Data$declaredNonStaticMembers$22.get();
    }

    @Override // j$.util.stream.TerminalOp
    public final Object getAuthRequestContext(Node.CC cc, Spliterator spliterator) {
        return ((ReduceOps$AccumulatingSink) new ReduceOps$ReduceTask(this, cc, spliterator).invoke()).get();
    }

    /* loaded from: classes.dex */
    public final class ConcNode extends AbstractConcNode {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public abstract class OfPrimitive extends AbstractConcNode implements Node.OfPrimitive {
            OfPrimitive(Node.OfPrimitive ofPrimitive, Node.OfPrimitive ofPrimitive2) {
                super(ofPrimitive, ofPrimitive2);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
                ((Node.OfPrimitive) this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory(i, obj);
                ((Node.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory(i + ((int) ((Node.OfPrimitive) this.BuiltInFictitiousFunctionClassFactory).s_()), obj);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final void getAuthRequestContext(Object obj) {
                ((Node.OfPrimitive) this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(obj);
                ((Node.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(obj);
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ Object[] getAuthRequestContext(IntFunction intFunction) {
                return Node.CC.MyBillsEntityDataFactory(this, intFunction);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Object getErrorConfigVersion() {
                long s_ = s_();
                if (s_ < 2147483639) {
                    Object authRequestContext = getAuthRequestContext((int) s_);
                    BuiltInFictitiousFunctionClassFactory(0, authRequestContext);
                    return authRequestContext;
                }
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }

            public final String toString() {
                return s_() < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(s_()));
            }
        }

        public ConcNode(Node node, Node node2) {
            super(node, node2);
        }

        @Override // j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return new InternalNodeSpliterator.OfRef(this);
        }

        @Override // j$.util.stream.Node
        public final void forEach(Consumer consumer) {
            this.BuiltInFictitiousFunctionClassFactory.forEach(consumer);
            this.KClassImpl$Data$declaredNonStaticMembers$2.forEach(consumer);
        }

        @Override // j$.util.stream.Node
        public final Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            if (j == 0 && j2 == s_()) {
                return this;
            }
            long s_ = this.BuiltInFictitiousFunctionClassFactory.s_();
            return j >= s_ ? this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(j - s_, j2 - s_, intFunction) : j2 <= s_ ? this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(j, j2, intFunction) : Nodes.BuiltInFictitiousFunctionClassFactory(1, this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(j, s_, intFunction), this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(0L, j2 - s_, intFunction));
        }

        @Override // j$.util.stream.Node
        public final void getAuthRequestContext(Object[] objArr, int i) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(objArr, i);
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(objArr, i + ((int) this.BuiltInFictitiousFunctionClassFactory.s_()));
        }

        @Override // j$.util.stream.Node
        public final Object[] getAuthRequestContext(IntFunction intFunction) {
            long s_ = s_();
            if (s_ < 2147483639) {
                Object[] objArr = (Object[]) intFunction.MyBillsEntityDataFactory((int) s_);
                getAuthRequestContext(objArr, 0);
                return objArr;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        public final String toString() {
            return s_() < 32 ? String.format("ConcNode[%s.%s]", this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2) : String.format("ConcNode[size=%d]", Long.valueOf(s_()));
        }

        /* loaded from: classes.dex */
        public final class OfDouble extends OfPrimitive implements Node.OfDouble {
            public OfDouble(Node.OfDouble ofDouble, Node.OfDouble ofDouble2) {
                super(ofDouble, ofDouble2);
            }

            @Override // j$.util.stream.Node
            public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
                return new InternalNodeSpliterator.OfDouble(this);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return new InternalNodeSpliterator.OfDouble(this);
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.getAuthRequestContext(this, consumer);
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
                return Node.CC.MyBillsEntityDataFactory(this, j, j2);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Object getAuthRequestContext(int i) {
                return new double[i];
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
                Node.CC.MyBillsEntityDataFactory(this, (Double[]) objArr, i);
            }
        }

        /* loaded from: classes.dex */
        public final class OfInt extends OfPrimitive implements Node.OfInt {
            public OfInt(Node.OfInt ofInt, Node.OfInt ofInt2) {
                super(ofInt, ofInt2);
            }

            @Override // j$.util.stream.Node
            public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
                return new InternalNodeSpliterator.OfInt(this);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return new InternalNodeSpliterator.OfInt(this);
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.MyBillsEntityDataFactory(this, consumer);
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
                return Node.CC.BuiltInFictitiousFunctionClassFactory(this, j, j2);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Object getAuthRequestContext(int i) {
                return new int[i];
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
                Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Integer[]) objArr, i);
            }
        }

        /* loaded from: classes.dex */
        public final class OfLong extends OfPrimitive implements Node.OfLong {
            public OfLong(Node.OfLong ofLong, Node.OfLong ofLong2) {
                super(ofLong, ofLong2);
            }

            @Override // j$.util.stream.Node
            public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
                return new InternalNodeSpliterator.OfLong(this);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return new InternalNodeSpliterator.OfLong(this);
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.BuiltInFictitiousFunctionClassFactory(this, consumer);
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
                return Node.CC.getAuthRequestContext(this, j, j2);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Object getAuthRequestContext(int i) {
                return new long[i];
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
                Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Long[]) objArr, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class EmptyNode implements Node {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public final class OfRef extends EmptyNode {
            OfRef() {
            }

            @Override // j$.util.stream.Node
            public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
                return Spliterators.MyBillsEntityDataFactory();
            }

            @Override // j$.util.stream.Node
            public final /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
            }

            @Override // j$.util.stream.Node
            public final /* bridge */ /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
            }
        }

        EmptyNode() {
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.Node
        public Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }

        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
        }

        @Override // j$.util.stream.Node
        public /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, j, j2, intFunction);
        }

        public final void getAuthRequestContext(Object obj) {
        }

        @Override // j$.util.stream.Node
        public final Object[] getAuthRequestContext(IntFunction intFunction) {
            return (Object[]) intFunction.MyBillsEntityDataFactory(0);
        }

        @Override // j$.util.stream.Node
        public final long s_() {
            return 0L;
        }

        /* loaded from: classes.dex */
        final class OfDouble extends EmptyNode implements Node.OfDouble {
            OfDouble() {
            }

            @Override // j$.util.stream.Node
            public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
                Spliterator.OfDouble ofDouble;
                ofDouble = Spliterators.getAuthRequestContext;
                return ofDouble;
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                Spliterator.OfDouble ofDouble;
                ofDouble = Spliterators.getAuthRequestContext;
                return ofDouble;
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.getAuthRequestContext(this, consumer);
            }

            @Override // j$.util.stream.Nodes.EmptyNode, j$.util.stream.Node
            public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
                return Node.CC.MyBillsEntityDataFactory(this, j, j2);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Object getErrorConfigVersion() {
                return Nodes.MyBillsEntityDataFactory;
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
                Node.CC.MyBillsEntityDataFactory(this, (Double[]) objArr, i);
            }

            @Override // j$.util.stream.Nodes.EmptyNode, j$.util.stream.Node
            public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
                throw new IndexOutOfBoundsException();
            }
        }

        /* loaded from: classes.dex */
        final class OfInt extends EmptyNode implements Node.OfInt {
            OfInt() {
            }

            @Override // j$.util.stream.Node
            public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
                return Spliterators.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return Spliterators.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.MyBillsEntityDataFactory(this, consumer);
            }

            @Override // j$.util.stream.Nodes.EmptyNode, j$.util.stream.Node
            public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
                return Node.CC.BuiltInFictitiousFunctionClassFactory(this, j, j2);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Object getErrorConfigVersion() {
                return Nodes.PlaceComponentResult;
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
                Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Integer[]) objArr, i);
            }

            @Override // j$.util.stream.Nodes.EmptyNode, j$.util.stream.Node
            public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
                throw new IndexOutOfBoundsException();
            }
        }

        /* loaded from: classes.dex */
        final class OfLong extends EmptyNode implements Node.OfLong {
            OfLong() {
            }

            @Override // j$.util.stream.Node
            public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
                return Spliterators.PlaceComponentResult();
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                throw new IndexOutOfBoundsException();
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
                return Spliterators.PlaceComponentResult();
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void forEach(Consumer consumer) {
                Node.CC.BuiltInFictitiousFunctionClassFactory(this, consumer);
            }

            @Override // j$.util.stream.Nodes.EmptyNode, j$.util.stream.Node
            public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
                return Node.CC.getAuthRequestContext(this, j, j2);
            }

            @Override // j$.util.stream.Node.OfPrimitive
            public final Object getErrorConfigVersion() {
                return Nodes.BuiltInFictitiousFunctionClassFactory;
            }

            @Override // j$.util.stream.Node
            public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
                Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Long[]) objArr, i);
            }

            @Override // j$.util.stream.Nodes.EmptyNode, j$.util.stream.Node
            public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class AbstractConcNode implements Node {
        protected final Node BuiltInFictitiousFunctionClassFactory;
        protected final Node KClassImpl$Data$declaredNonStaticMembers$2;
        private final long PlaceComponentResult;

        AbstractConcNode(Node node, Node node2) {
            this.BuiltInFictitiousFunctionClassFactory = node;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = node2;
            this.PlaceComponentResult = node.s_() + node2.s_();
        }

        @Override // j$.util.stream.Node
        public final int BuiltInFictitiousFunctionClassFactory() {
            return 2;
        }

        @Override // j$.util.stream.Node
        public final Node BuiltInFictitiousFunctionClassFactory(int i) {
            if (i == 0) {
                return this.BuiltInFictitiousFunctionClassFactory;
            }
            if (i == 1) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.Node
        public final long s_() {
            return this.PlaceComponentResult;
        }

        public final /* synthetic */ Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            Node node;
            if (i == 0) {
                node = this.BuiltInFictitiousFunctionClassFactory;
            } else if (i != 1) {
                throw new IndexOutOfBoundsException();
            } else {
                node = this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return (Node.OfPrimitive) node;
        }
    }

    /* loaded from: classes.dex */
    public class DoubleArrayNode implements Node.OfDouble {
        final double[] KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;

        DoubleArrayNode(long j) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new double[(int) j];
            this.MyBillsEntityDataFactory = 0;
        }

        public DoubleArrayNode(double[] dArr) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = dArr;
            this.MyBillsEntityDataFactory = dArr.length;
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            System.arraycopy(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, (double[]) obj, i, this.MyBillsEntityDataFactory);
        }

        @Override // j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return Spliterators.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.MyBillsEntityDataFactory);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return Spliterators.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, 0, this.MyBillsEntityDataFactory);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void forEach(Consumer consumer) {
            Node.CC.getAuthRequestContext(this, consumer);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, j, j2);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final void getAuthRequestContext(Object obj) {
            DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
            for (int i = 0; i < this.MyBillsEntityDataFactory; i++) {
                doubleConsumer.accept(this.KClassImpl$Data$declaredNonStaticMembers$2[i]);
            }
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Object[] getAuthRequestContext(IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, intFunction);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Object getErrorConfigVersion() {
            double[] dArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int length = dArr.length;
            int i = this.MyBillsEntityDataFactory;
            return length != i ? Arrays.copyOf(dArr, i) : dArr;
        }

        @Override // j$.util.stream.Node
        public final long s_() {
            return this.MyBillsEntityDataFactory;
        }

        public String toString() {
            return String.format("DoubleArrayNode[%d][%s]", Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.length - this.MyBillsEntityDataFactory), Arrays.toString(this.KClassImpl$Data$declaredNonStaticMembers$2));
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
            Node.CC.MyBillsEntityDataFactory(this, (Double[]) objArr, i);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* loaded from: classes.dex */
    public final class DoubleSpinedNodeBuilder extends SpinedBuffer.OfDouble implements Node.OfDouble, Node.Builder.OfDouble {
        DoubleSpinedNodeBuilder() {
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            super.BuiltInFictitiousFunctionClassFactory(i, (double[]) obj);
        }

        @Override // j$.util.stream.SpinedBuffer.OfDouble, j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.SpinedBuffer.OfDouble
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator.OfDouble KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.Builder
        public final Node PlaceComponentResult() {
            return this;
        }

        @Override // j$.util.stream.SpinedBuffer.OfDouble, j$.util.function.DoubleConsumer
        public final void accept(double d) {
            super.accept(d);
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.stream.Sink.OfDouble
        public final /* synthetic */ void accept(Double d) {
            Node.CC.BuiltInFictitiousFunctionClassFactory(this, d);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Double) obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            t_();
            BuiltInFictitiousFunctionClassFactory(j);
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
        }

        @Override // j$.util.stream.Node.Builder.OfDouble
        public final Node.OfDouble getAuthRequestContext() {
            return this;
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, j, j2);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final void getAuthRequestContext(Object obj) {
            super.getAuthRequestContext((DoubleConsumer) obj);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Object[] getAuthRequestContext(IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory((Node.OfPrimitive) this, intFunction);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final Object getErrorConfigVersion() {
            return (double[]) super.getErrorConfigVersion();
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
            Node.CC.MyBillsEntityDataFactory(this, (Double[]) objArr, i);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* loaded from: classes.dex */
    public class IntArrayNode implements Node.OfInt {
        final int[] BuiltInFictitiousFunctionClassFactory;
        int PlaceComponentResult;

        IntArrayNode(long j) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.BuiltInFictitiousFunctionClassFactory = new int[(int) j];
            this.PlaceComponentResult = 0;
        }

        public IntArrayNode(int[] iArr) {
            this.BuiltInFictitiousFunctionClassFactory = iArr;
            this.PlaceComponentResult = iArr.length;
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            System.arraycopy(this.BuiltInFictitiousFunctionClassFactory, 0, (int[]) obj, i, this.PlaceComponentResult);
        }

        @Override // j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return Spliterators.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, 0, this.PlaceComponentResult);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return Spliterators.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, 0, this.PlaceComponentResult);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void forEach(Consumer consumer) {
            Node.CC.MyBillsEntityDataFactory(this, consumer);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.BuiltInFictitiousFunctionClassFactory(this, j, j2);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final void getAuthRequestContext(Object obj) {
            IntConsumer intConsumer = (IntConsumer) obj;
            for (int i = 0; i < this.PlaceComponentResult; i++) {
                intConsumer.accept(this.BuiltInFictitiousFunctionClassFactory[i]);
            }
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Object[] getAuthRequestContext(IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, intFunction);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Object getErrorConfigVersion() {
            int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
            int length = iArr.length;
            int i = this.PlaceComponentResult;
            return length != i ? Arrays.copyOf(iArr, i) : iArr;
        }

        @Override // j$.util.stream.Node
        public final long s_() {
            return this.PlaceComponentResult;
        }

        public String toString() {
            return String.format("IntArrayNode[%d][%s]", Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.length - this.PlaceComponentResult), Arrays.toString(this.BuiltInFictitiousFunctionClassFactory));
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
            Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Integer[]) objArr, i);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* loaded from: classes.dex */
    public final class IntSpinedNodeBuilder extends SpinedBuffer.OfInt implements Node.OfInt, Node.Builder.OfInt {
        IntSpinedNodeBuilder() {
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            super.BuiltInFictitiousFunctionClassFactory(i, (int[]) obj);
        }

        @Override // j$.util.stream.SpinedBuffer.OfInt, j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.SpinedBuffer.OfInt
        /* renamed from: MyBillsEntityDataFactory */
        public final Spliterator.OfInt KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.Builder
        public final Node PlaceComponentResult() {
            return this;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.SpinedBuffer.OfInt, j$.util.function.IntConsumer
        public final void accept(int i) {
            super.accept(i);
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(long j) {
            Node.CC.A();
            throw null;
        }

        @Override // j$.util.stream.Sink.OfInt
        public final /* synthetic */ void accept(Integer num) {
            Node.CC.MyBillsEntityDataFactory(this, num);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Integer) obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            t_();
            BuiltInFictitiousFunctionClassFactory(j);
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
        }

        @Override // j$.util.stream.Node.Builder.OfInt
        public final Node.OfInt getAuthRequestContext() {
            return this;
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.BuiltInFictitiousFunctionClassFactory(this, j, j2);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final void getAuthRequestContext(Object obj) {
            super.getAuthRequestContext((IntConsumer) obj);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Object[] getAuthRequestContext(IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, intFunction);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final Object getErrorConfigVersion() {
            return (int[]) super.getErrorConfigVersion();
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
            Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Integer[]) objArr, i);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* loaded from: classes.dex */
    public class LongArrayNode implements Node.OfLong {
        int BuiltInFictitiousFunctionClassFactory;
        final long[] getAuthRequestContext;

        LongArrayNode(long j) {
            if (j >= 2147483639) {
                throw new IllegalArgumentException("Stream size exceeds max array size");
            }
            this.getAuthRequestContext = new long[(int) j];
            this.BuiltInFictitiousFunctionClassFactory = 0;
        }

        public LongArrayNode(long[] jArr) {
            this.getAuthRequestContext = jArr;
            this.BuiltInFictitiousFunctionClassFactory = jArr.length;
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            System.arraycopy(this.getAuthRequestContext, 0, (long[]) obj, i, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return Spliterators.MyBillsEntityDataFactory(this.getAuthRequestContext, 0, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return Spliterators.MyBillsEntityDataFactory(this.getAuthRequestContext, 0, this.BuiltInFictitiousFunctionClassFactory);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void forEach(Consumer consumer) {
            Node.CC.BuiltInFictitiousFunctionClassFactory(this, consumer);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.getAuthRequestContext(this, j, j2);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final void getAuthRequestContext(Object obj) {
            LongConsumer longConsumer = (LongConsumer) obj;
            for (int i = 0; i < this.BuiltInFictitiousFunctionClassFactory; i++) {
                longConsumer.accept(this.getAuthRequestContext[i]);
            }
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Object[] getAuthRequestContext(IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, intFunction);
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Object getErrorConfigVersion() {
            long[] jArr = this.getAuthRequestContext;
            int length = jArr.length;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            return length != i ? Arrays.copyOf(jArr, i) : jArr;
        }

        @Override // j$.util.stream.Node
        public final long s_() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public String toString() {
            return String.format("LongArrayNode[%d][%s]", Integer.valueOf(this.getAuthRequestContext.length - this.BuiltInFictitiousFunctionClassFactory), Arrays.toString(this.getAuthRequestContext));
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
            Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Long[]) objArr, i);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* loaded from: classes.dex */
    public final class LongSpinedNodeBuilder extends SpinedBuffer.OfLong implements Node.OfLong, Node.Builder.OfLong {
        LongSpinedNodeBuilder() {
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
            return 0;
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            super.BuiltInFictitiousFunctionClassFactory(i, (long[]) obj);
        }

        @Override // j$.util.stream.SpinedBuffer.OfLong, j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node
        public final Spliterator KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Node.OfPrimitive KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            throw new IndexOutOfBoundsException();
        }

        @Override // j$.util.stream.Node.Builder.OfLong
        public final Node.OfLong MyBillsEntityDataFactory() {
            return this;
        }

        @Override // j$.util.stream.Node.OfPrimitive
        public final Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node.Builder
        public final Node PlaceComponentResult() {
            return this;
        }

        @Override // j$.util.stream.Sink, j$.util.function.DoubleConsumer
        public final /* synthetic */ void accept(double d) {
            Node.CC.VerifyPinStateManager$executeRiskChallenge$2$1();
            throw null;
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ void accept(int i) {
            Node.CC.C();
            throw null;
        }

        @Override // j$.util.stream.SpinedBuffer.OfLong, j$.util.function.LongConsumer
        public final void accept(long j) {
            super.accept(j);
        }

        @Override // j$.util.stream.Sink.OfLong
        public final /* synthetic */ void accept(Long l) {
            Node.CC.PlaceComponentResult(this, l);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ void accept(Object obj) {
            accept((Long) obj);
        }

        @Override // j$.util.function.Consumer
        public final /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.PlaceComponentResult(this, consumer);
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            t_();
            BuiltInFictitiousFunctionClassFactory(j);
        }

        @Override // j$.util.stream.Sink
        public final /* synthetic */ boolean cancellationRequested() {
            return false;
        }

        @Override // j$.util.stream.Sink
        public final void end() {
        }

        @Override // j$.util.stream.SpinedBuffer.OfLong
        /* renamed from: getAuthRequestContext */
        public final Spliterator.OfLong KClassImpl$Data$declaredNonStaticMembers$2() {
            return super.KClassImpl$Data$declaredNonStaticMembers$2();
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node getAuthRequestContext(long j, long j2, IntFunction intFunction) {
            return Node.CC.getAuthRequestContext(this, j, j2);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final void getAuthRequestContext(Object obj) {
            super.getAuthRequestContext((LongConsumer) obj);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Object[] getAuthRequestContext(IntFunction intFunction) {
            return Node.CC.MyBillsEntityDataFactory(this, intFunction);
        }

        @Override // j$.util.stream.SpinedBuffer.OfPrimitive, j$.util.stream.Node.OfPrimitive
        public final Object getErrorConfigVersion() {
            return (long[]) super.getErrorConfigVersion();
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ void getAuthRequestContext(Object[] objArr, int i) {
            Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, (Long[]) objArr, i);
        }

        @Override // j$.util.stream.Node
        public final /* synthetic */ Node BuiltInFictitiousFunctionClassFactory(int i) {
            throw new IndexOutOfBoundsException();
        }
    }
}
