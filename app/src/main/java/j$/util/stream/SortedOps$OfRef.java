package j$.util.stream;

import j$.util.Collection;
import j$.util.Comparator;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.IntFunction;
import j$.util.stream.Nodes;
import j$.util.stream.ReferencePipeline;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
final class SortedOps$OfRef extends ReferencePipeline.StatefulOp {
    private final Comparator BuiltInFictitiousFunctionClassFactory;
    private final boolean moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SortedOps$OfRef(AbstractPipeline abstractPipeline) {
        super(abstractPipeline, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
        this.moveToNextValue = true;
        this.BuiltInFictitiousFunctionClassFactory = Comparator.CC.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SortedOps$OfRef(AbstractPipeline abstractPipeline, java.util.Comparator comparator) {
        super(abstractPipeline, StreamOpFlag.IS_ORDERED | StreamOpFlag.NOT_SORTED);
        this.moveToNextValue = false;
        this.BuiltInFictitiousFunctionClassFactory = comparator;
    }

    @Override // j$.util.stream.AbstractPipeline
    public final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
        if (StreamOpFlag.SORTED.isKnown(abstractPipeline.getAuthRequestContext()) && this.moveToNextValue) {
            return abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, false, intFunction);
        }
        Object[] authRequestContext = abstractPipeline.BuiltInFictitiousFunctionClassFactory(spliterator, true, intFunction).getAuthRequestContext(intFunction);
        Arrays.sort(authRequestContext, this.BuiltInFictitiousFunctionClassFactory);
        return new Nodes.ArrayNode(authRequestContext);
    }

    @Override // j$.util.stream.AbstractPipeline
    public final Sink getAuthRequestContext(int i, final Sink sink) {
        if (StreamOpFlag.SORTED.isKnown(i) && this.moveToNextValue) {
            return sink;
        }
        if (StreamOpFlag.SIZED.isKnown(i)) {
            final java.util.Comparator comparator = this.BuiltInFictitiousFunctionClassFactory;
            return new SortedOps$AbstractRefSortingSink(sink, comparator) { // from class: j$.util.stream.SortedOps$SizedRefSortingSink
                private int BuiltInFictitiousFunctionClassFactory;
                private Object[] getAuthRequestContext;

                @Override // j$.util.function.Consumer
                public final void accept(Object obj) {
                    Object[] objArr = this.getAuthRequestContext;
                    int i2 = this.BuiltInFictitiousFunctionClassFactory;
                    this.BuiltInFictitiousFunctionClassFactory = i2 + 1;
                    objArr[i2] = obj;
                }

                @Override // j$.util.stream.Sink
                public final void begin(long j) {
                    if (j >= 2147483639) {
                        throw new IllegalArgumentException("Stream size exceeds max array size");
                    }
                    this.getAuthRequestContext = new Object[(int) j];
                }

                @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
                public final void end() {
                    int i2 = 0;
                    Arrays.sort(this.getAuthRequestContext, 0, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.MyBillsEntityDataFactory.begin(this.BuiltInFictitiousFunctionClassFactory);
                    if (this.PlaceComponentResult) {
                        while (i2 < this.BuiltInFictitiousFunctionClassFactory && !this.MyBillsEntityDataFactory.cancellationRequested()) {
                            this.MyBillsEntityDataFactory.accept((Sink) this.getAuthRequestContext[i2]);
                            i2++;
                        }
                    } else {
                        while (i2 < this.BuiltInFictitiousFunctionClassFactory) {
                            this.MyBillsEntityDataFactory.accept((Sink) this.getAuthRequestContext[i2]);
                            i2++;
                        }
                    }
                    this.MyBillsEntityDataFactory.end();
                    this.getAuthRequestContext = null;
                }
            };
        }
        final java.util.Comparator comparator2 = this.BuiltInFictitiousFunctionClassFactory;
        return new SortedOps$AbstractRefSortingSink(sink, comparator2) { // from class: j$.util.stream.SortedOps$RefSortingSink
            private ArrayList getAuthRequestContext;

            @Override // j$.util.function.Consumer
            public final void accept(Object obj) {
                this.getAuthRequestContext.add(obj);
            }

            @Override // j$.util.stream.Sink
            public final void begin(long j) {
                if (j >= 2147483639) {
                    throw new IllegalArgumentException("Stream size exceeds max array size");
                }
                this.getAuthRequestContext = j >= 0 ? new ArrayList((int) j) : new ArrayList();
            }

            @Override // j$.util.stream.Sink.ChainedReference, j$.util.stream.Sink
            public final void end() {
                List.EL.PlaceComponentResult(this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.MyBillsEntityDataFactory.begin(this.getAuthRequestContext.size());
                if (this.PlaceComponentResult) {
                    Iterator it = this.getAuthRequestContext.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (this.MyBillsEntityDataFactory.cancellationRequested()) {
                            break;
                        }
                        this.MyBillsEntityDataFactory.accept((Sink) next);
                    }
                } else {
                    Collection.EL.getAuthRequestContext(this.getAuthRequestContext, new Collectors$$ExternalSyntheticLambda25(4, this.MyBillsEntityDataFactory));
                }
                this.MyBillsEntityDataFactory.end();
                this.getAuthRequestContext = null;
            }
        };
    }
}
