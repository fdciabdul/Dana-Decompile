package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import j$.util.stream.LongPipeline;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators$SliceSpliterator;
import j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SliceOps$3 extends LongPipeline.StatefulOp {
    public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory = 0;
    final /* synthetic */ long NetworkUserEntityData$$ExternalSyntheticLambda0;
    final /* synthetic */ long moveToNextValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliceOps$3(AbstractPipeline abstractPipeline, int i, long j, long j2) {
        super(abstractPipeline, i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = j;
        this.moveToNextValue = j2;
    }

    private static Spliterator.OfLong BuiltInFictitiousFunctionClassFactory(Spliterator.OfLong ofLong, long j, long j2, long j3) {
        long j4;
        long j5;
        if (j <= j3) {
            long j6 = j3 - j;
            j5 = j2 >= 0 ? Math.min(j2, j6) : j6;
            j4 = 0;
        } else {
            j4 = j;
            j5 = j2;
        }
        return new StreamSpliterators$UnorderedSliceSpliterator.OfLong(ofLong, j4, j5);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
        long authRequestContext = abstractPipeline.getAuthRequestContext(spliterator);
        return (authRequestContext <= 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) ? !StreamOpFlag.ORDERED.isKnown(abstractPipeline.getAuthRequestContext()) ? Nodes.MyBillsEntityDataFactory(this, BuiltInFictitiousFunctionClassFactory((Spliterator.OfLong) abstractPipeline.PlaceComponentResult(spliterator), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, authRequestContext), true) : (Node) new SliceOps$SliceTask(this, abstractPipeline, spliterator, intFunction, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue).invoke() : Nodes.MyBillsEntityDataFactory(abstractPipeline, Node.CC.PlaceComponentResult(abstractPipeline.PlaceComponentResult(), spliterator, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractPipeline
    public final Sink getAuthRequestContext(int i, Sink sink) {
        return new Sink.ChainedLong(sink) { // from class: j$.util.stream.SliceOps$3.1
            long BuiltInFictitiousFunctionClassFactory;
            long KClassImpl$Data$declaredNonStaticMembers$2;

            {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = SliceOps$3.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                long j = SliceOps$3.this.moveToNextValue;
                this.BuiltInFictitiousFunctionClassFactory = j < 0 ? LongCompanionObject.MAX_VALUE : j;
            }

            @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
            public final void accept(long j) {
                long j2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (j2 != 0) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = j2 - 1;
                    return;
                }
                long j3 = this.BuiltInFictitiousFunctionClassFactory;
                if (j3 > 0) {
                    this.BuiltInFictitiousFunctionClassFactory = j3 - 1;
                    this.getAuthRequestContext.accept(j);
                }
            }

            @Override // j$.util.stream.Sink
            public final void begin(long j) {
                this.getAuthRequestContext.begin(Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(j, SliceOps$3.this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory));
            }

            @Override // j$.util.stream.Sink.ChainedLong, j$.util.stream.Sink
            public final boolean cancellationRequested() {
                return this.BuiltInFictitiousFunctionClassFactory == 0 || this.getAuthRequestContext.cancellationRequested();
            }
        };
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator MyBillsEntityDataFactory(AbstractPipeline abstractPipeline, Spliterator spliterator) {
        long authRequestContext = abstractPipeline.getAuthRequestContext(spliterator);
        if (authRequestContext <= 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) {
            return !StreamOpFlag.ORDERED.isKnown(abstractPipeline.getAuthRequestContext()) ? BuiltInFictitiousFunctionClassFactory((Spliterator.OfLong) abstractPipeline.PlaceComponentResult(spliterator), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, authRequestContext) : ((Node) new SliceOps$SliceTask(this, abstractPipeline, spliterator, new SliceOps$$ExternalSyntheticLambda0(12), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue).invoke()).KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Spliterator.OfLong ofLong = (Spliterator.OfLong) abstractPipeline.PlaceComponentResult(spliterator);
        long j = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        long j2 = this.moveToNextValue;
        long j3 = j2 >= 0 ? j2 + j : Long.MAX_VALUE;
        if (j3 < 0) {
            j3 = Long.MAX_VALUE;
        }
        return new StreamSpliterators$SliceSpliterator.OfLong(ofLong, j, j3);
    }
}
