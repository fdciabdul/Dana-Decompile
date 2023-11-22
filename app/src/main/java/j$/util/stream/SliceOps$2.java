package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.IntFunction;
import j$.util.stream.IntPipeline;
import j$.util.stream.Node;
import j$.util.stream.Sink;
import j$.util.stream.StreamSpliterators$SliceSpliterator;
import j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class SliceOps$2 extends IntPipeline.StatefulOp {
    public static final /* synthetic */ int moveToNextValue = 0;
    final /* synthetic */ long getErrorConfigVersion;
    final /* synthetic */ long lookAheadTest;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliceOps$2(AbstractPipeline abstractPipeline, int i, long j, long j2) {
        super(abstractPipeline, i);
        this.lookAheadTest = j;
        this.getErrorConfigVersion = j2;
    }

    private static Spliterator.OfInt KClassImpl$Data$declaredNonStaticMembers$2(Spliterator.OfInt ofInt, long j, long j2, long j3) {
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
        return new StreamSpliterators$UnorderedSliceSpliterator.OfInt(ofInt, j4, j5);
    }

    @Override // j$.util.stream.AbstractPipeline
    final Node getAuthRequestContext(Spliterator spliterator, IntFunction intFunction, AbstractPipeline abstractPipeline) {
        long authRequestContext = abstractPipeline.getAuthRequestContext(spliterator);
        return (authRequestContext <= 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) ? !StreamOpFlag.ORDERED.isKnown(abstractPipeline.getAuthRequestContext()) ? Nodes.PlaceComponentResult(this, KClassImpl$Data$declaredNonStaticMembers$2((Spliterator.OfInt) abstractPipeline.PlaceComponentResult(spliterator), this.lookAheadTest, this.getErrorConfigVersion, authRequestContext), true) : (Node) new SliceOps$SliceTask(this, abstractPipeline, spliterator, intFunction, this.lookAheadTest, this.getErrorConfigVersion).invoke() : Nodes.PlaceComponentResult(abstractPipeline, Node.CC.PlaceComponentResult(abstractPipeline.PlaceComponentResult(), spliterator, this.lookAheadTest, this.getErrorConfigVersion), true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // j$.util.stream.AbstractPipeline
    public final Sink getAuthRequestContext(int i, Sink sink) {
        return new Sink.ChainedInt(sink) { // from class: j$.util.stream.SliceOps$2.1
            long PlaceComponentResult;
            long getAuthRequestContext;

            {
                this.getAuthRequestContext = SliceOps$2.this.lookAheadTest;
                long j = SliceOps$2.this.getErrorConfigVersion;
                this.PlaceComponentResult = j < 0 ? LongCompanionObject.MAX_VALUE : j;
            }

            @Override // j$.util.stream.Sink.OfInt, j$.util.stream.Sink
            public final void accept(int i2) {
                long j = this.getAuthRequestContext;
                if (j != 0) {
                    this.getAuthRequestContext = j - 1;
                    return;
                }
                long j2 = this.PlaceComponentResult;
                if (j2 > 0) {
                    this.PlaceComponentResult = j2 - 1;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.accept(i2);
                }
            }

            @Override // j$.util.stream.Sink
            public final void begin(long j) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.begin(Node.CC.KClassImpl$Data$declaredNonStaticMembers$2(j, SliceOps$2.this.lookAheadTest, this.PlaceComponentResult));
            }

            @Override // j$.util.stream.Sink.ChainedInt, j$.util.stream.Sink
            public final boolean cancellationRequested() {
                return this.PlaceComponentResult == 0 || this.KClassImpl$Data$declaredNonStaticMembers$2.cancellationRequested();
            }
        };
    }

    @Override // j$.util.stream.AbstractPipeline
    final Spliterator MyBillsEntityDataFactory(AbstractPipeline abstractPipeline, Spliterator spliterator) {
        long authRequestContext = abstractPipeline.getAuthRequestContext(spliterator);
        if (authRequestContext <= 0 || !spliterator.KClassImpl$Data$declaredNonStaticMembers$2(16384)) {
            return !StreamOpFlag.ORDERED.isKnown(abstractPipeline.getAuthRequestContext()) ? KClassImpl$Data$declaredNonStaticMembers$2((Spliterator.OfInt) abstractPipeline.PlaceComponentResult(spliterator), this.lookAheadTest, this.getErrorConfigVersion, authRequestContext) : ((Node) new SliceOps$SliceTask(this, abstractPipeline, spliterator, new SliceOps$$ExternalSyntheticLambda0(11), this.lookAheadTest, this.getErrorConfigVersion).invoke()).KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Spliterator.OfInt ofInt = (Spliterator.OfInt) abstractPipeline.PlaceComponentResult(spliterator);
        long j = this.lookAheadTest;
        long j2 = this.getErrorConfigVersion;
        long j3 = j2 >= 0 ? j2 + j : Long.MAX_VALUE;
        if (j3 < 0) {
            j3 = Long.MAX_VALUE;
        }
        return new StreamSpliterators$SliceSpliterator.OfInt(ofInt, j, j3);
    }
}
