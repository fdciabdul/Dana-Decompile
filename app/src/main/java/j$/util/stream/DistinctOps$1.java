package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.DoubleConsumer;
import j$.util.function.Function;
import j$.util.function.IntConsumer;
import j$.util.function.IntFunction;
import j$.util.function.LongConsumer;
import j$.util.stream.ForEachOps$ForEachOp;
import j$.util.stream.IntPipeline;
import j$.util.stream.Nodes;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class DistinctOps$1 extends ReferencePipeline.StatefulOp {
    public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory = 0;

    /* renamed from: j$.util.stream.DistinctOps$1$2 */
    /* loaded from: classes.dex */
    final class AnonymousClass2 extends Sink.ChainedReference {
        final /* synthetic */ AbstractPipeline BuiltInFictitiousFunctionClassFactory;
        public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        Object PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DistinctOps$1 distinctOps$1, Sink sink) {
            super(sink);
            this.BuiltInFictitiousFunctionClassFactory = distinctOps$1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(IntPipeline.AnonymousClass3 anonymousClass3, Sink sink) {
            super(sink);
            this.BuiltInFictitiousFunctionClassFactory = anonymousClass3;
            this.PlaceComponentResult = new IntPipeline$$ExternalSyntheticLambda1(0, sink);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(IntPipeline.AnonymousClass5 anonymousClass5, Sink sink) {
            super(sink);
            this.BuiltInFictitiousFunctionClassFactory = anonymousClass5;
            this.PlaceComponentResult = new LongPipeline$$ExternalSyntheticLambda11(0, sink);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(IntPipeline.AnonymousClass6 anonymousClass6, Sink sink) {
            super(sink);
            this.BuiltInFictitiousFunctionClassFactory = anonymousClass6;
            this.PlaceComponentResult = new DoublePipeline$$ExternalSyntheticLambda5(0, sink);
        }

        @Override // j$.util.function.Consumer
        public final void accept(Object obj) {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i == 0) {
                if (((Set) this.PlaceComponentResult).contains(obj)) {
                    return;
                }
                ((Set) this.PlaceComponentResult).add(obj);
                this.MyBillsEntityDataFactory.accept((Sink) obj);
            } else if (i == 1) {
                LongStream longStream = (LongStream) ((Function) ((IntPipeline.AnonymousClass5) this.BuiltInFictitiousFunctionClassFactory).NetworkUserEntityData$$ExternalSyntheticLambda0).apply(obj);
                if (longStream != null) {
                    try {
                        longStream.getSupportButtonTintMode().PlaceComponentResult((LongConsumer) this.PlaceComponentResult);
                    } catch (Throwable th) {
                        try {
                            longStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (longStream != null) {
                    longStream.close();
                }
            } else if (i != 2) {
                DoubleStream doubleStream = (DoubleStream) ((Function) ((IntPipeline.AnonymousClass6) this.BuiltInFictitiousFunctionClassFactory).moveToNextValue).apply(obj);
                if (doubleStream != null) {
                    try {
                        doubleStream.getCallingPid().PlaceComponentResult((DoubleConsumer) this.PlaceComponentResult);
                    } catch (Throwable th3) {
                        try {
                            doubleStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                if (doubleStream != null) {
                    doubleStream.close();
                }
            } else {
                IntStream intStream = (IntStream) ((Function) ((IntPipeline.AnonymousClass3) this.BuiltInFictitiousFunctionClassFactory).scheduleImpl).apply(obj);
                if (intStream != null) {
                    try {
                        intStream.B().KClassImpl$Data$declaredNonStaticMembers$2((IntConsumer) this.PlaceComponentResult);
                    } catch (Throwable th5) {
                        try {
                            intStream.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                if (intStream != null) {
                    intStream.close();
                }
            }
        }

        @Override // j$.util.stream.Sink
        public final void begin(long j) {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i == 0) {
                this.PlaceComponentResult = new HashSet();
            } else if (i != 1) {
            }
            this.MyBillsEntityDataFactory.begin(-1L);
        }

        @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
        public final void end() {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                super.end();
                return;
            }
            this.PlaceComponentResult = null;
            this.MyBillsEntityDataFactory.end();
        }
    }

    public DistinctOps$1(AbstractPipeline abstractPipeline, int i) {
        super(abstractPipeline, i);
    }

    private static Nodes.CollectionNode KClassImpl$Data$declaredNonStaticMembers$2(AbstractPipeline abstractPipeline, Spliterator spliterator) {
        SliceOps$$ExternalSyntheticLambda0 sliceOps$$ExternalSyntheticLambda0 = new SliceOps$$ExternalSyntheticLambda0(27);
        return new Nodes.CollectionNode((Collection) new ReduceOps$1(new SliceOps$$ExternalSyntheticLambda0(29), new SliceOps$$ExternalSyntheticLambda0(28), sliceOps$$ExternalSyntheticLambda0, 3).getAuthRequestContext(abstractPipeline, spliterator));
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator MyBillsEntityDataFactory(AbstractPipeline abstractPipeline, Spliterator spliterator) {
        return StreamOpFlag.DISTINCT.isKnown(abstractPipeline.getAuthRequestContext()) ? abstractPipeline.PlaceComponentResult(spliterator) : StreamOpFlag.ORDERED.isKnown(abstractPipeline.getAuthRequestContext()) ? KClassImpl$Data$declaredNonStaticMembers$2(abstractPipeline, spliterator).KClassImpl$Data$declaredNonStaticMembers$2() : new StreamSpliterators$DistinctSpliterator(abstractPipeline.PlaceComponentResult(spliterator));
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
        if (StreamOpFlag.DISTINCT.isKnown(abstractPipeline.getAuthRequestContext())) {
            return abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, false, intFunction);
        }
        if (StreamOpFlag.ORDERED.isKnown(abstractPipeline.getAuthRequestContext())) {
            return KClassImpl$Data$declaredNonStaticMembers$2(abstractPipeline, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        new ForEachOps$ForEachOp.OfRef(new MatchOps$$ExternalSyntheticLambda0(1, atomicBoolean, concurrentHashMap), false).getAuthRequestContext(abstractPipeline, spliterator);
        Collection keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            HashSet hashSet = new HashSet(keySet);
            hashSet.add(null);
            keySet = hashSet;
        }
        return new Nodes.CollectionNode(keySet);
    }

    @Override // j$.util.stream.AbstractPipeline
    public final Sink getAuthRequestContext(int i, Sink sink) {
        return StreamOpFlag.DISTINCT.isKnown(i) ? sink : StreamOpFlag.SORTED.isKnown(i) ? new Sink.ChainedReference(sink) { // from class: j$.util.stream.DistinctOps$1.1
            Object KClassImpl$Data$declaredNonStaticMembers$2;
            boolean getAuthRequestContext;

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                if (obj == null) {
                    if (this.getAuthRequestContext) {
                        return;
                    }
                    this.getAuthRequestContext = true;
                    Sink sink2 = this.MyBillsEntityDataFactory;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    sink2.accept((Sink) null);
                    return;
                }
                Object obj2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (obj2 == null || !obj.equals(obj2)) {
                    Sink sink3 = this.MyBillsEntityDataFactory;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
                    sink3.accept((Sink) obj);
                }
            }

            @Override // j$.util.stream.Sink
            public final void begin(long j) {
                this.getAuthRequestContext = false;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.MyBillsEntityDataFactory.begin(-1L);
            }

            @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
            public final void end() {
                this.getAuthRequestContext = false;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                this.MyBillsEntityDataFactory.end();
            }
        } : new AnonymousClass2(this, sink);
    }
}
