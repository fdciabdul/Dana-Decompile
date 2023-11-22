package j$.util.stream;

import j$.util.function.LongConsumer;
import j$.util.function.LongFunction;
import j$.util.function.LongPredicate;
import j$.util.function.LongToDoubleFunction;
import j$.util.function.LongToIntFunction;
import j$.util.function.LongUnaryOperator;
import j$.util.stream.IntPipeline;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class LongPipeline$1$1 extends Sink.ChainedLong {
    public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ AbstractPipeline PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LongPipeline$1$1(AbstractPipeline abstractPipeline, Sink sink, int i) {
        super(sink);
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.PlaceComponentResult = abstractPipeline;
    }

    @Override // j$.util.stream.Sink
    public final void begin(long j) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i == 5) {
            this.getAuthRequestContext.begin(-1L);
        } else if (i != 6) {
            this.getAuthRequestContext.begin(j);
        } else {
            this.getAuthRequestContext.begin(-1L);
        }
    }

    @Override // j$.util.stream.Sink.OfLong, j$.util.stream.Sink
    public final void accept(long j) {
        switch (this.BuiltInFictitiousFunctionClassFactory) {
            case 0:
                this.getAuthRequestContext.accept(j);
                return;
            case 1:
                this.getAuthRequestContext.accept(((LongUnaryOperator) ((IntPipeline.AnonymousClass5) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).getAuthRequestContext(j));
                return;
            case 2:
                this.getAuthRequestContext.accept((Sink) ((LongFunction) ((IntPipeline.AnonymousClass4) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory(j));
                return;
            case 3:
                this.getAuthRequestContext.accept(((LongToIntFunction.VivifiedWrapper) ((LongToIntFunction) ((IntPipeline.AnonymousClass3) this.PlaceComponentResult).scheduleImpl)).BuiltInFictitiousFunctionClassFactory.applyAsInt(j));
                return;
            case 4:
                this.getAuthRequestContext.accept(((LongToDoubleFunction.VivifiedWrapper) ((LongToDoubleFunction) ((IntPipeline.AnonymousClass6) this.PlaceComponentResult).moveToNextValue)).MyBillsEntityDataFactory.applyAsDouble(j));
                return;
            case 5:
                LongStream longStream = (LongStream) ((LongFunction) ((IntPipeline.AnonymousClass5) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory(j);
                if (longStream != null) {
                    try {
                        longStream.getSupportButtonTintMode().PlaceComponentResult(new LongPipeline$$ExternalSyntheticLambda11(1, this));
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
                    return;
                }
                return;
            case 6:
                if (((LongPredicate.VivifiedWrapper) ((LongPredicate) ((IntPipeline.AnonymousClass5) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0)).BuiltInFictitiousFunctionClassFactory(j)) {
                    this.getAuthRequestContext.accept(j);
                    return;
                }
                return;
            default:
                ((LongConsumer) ((IntPipeline.AnonymousClass5) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).accept(j);
                this.getAuthRequestContext.accept(j);
                return;
        }
    }
}
