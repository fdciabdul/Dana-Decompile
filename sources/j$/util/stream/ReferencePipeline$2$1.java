package j$.util.stream;

import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import j$.util.stream.IntPipeline;
import j$.util.stream.ReferencePipeline;
import j$.util.stream.Sink;

/* loaded from: classes.dex */
final class ReferencePipeline$2$1 extends Sink.ChainedReference {
    public final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ AbstractPipeline PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReferencePipeline$2$1(AbstractPipeline abstractPipeline, Sink sink, int i) {
        super(sink);
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.PlaceComponentResult = abstractPipeline;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i == 0) {
            if (((Predicate) ((IntPipeline.AnonymousClass4) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).test(obj)) {
                this.MyBillsEntityDataFactory.accept((Sink) obj);
            }
        } else if (i == 1) {
            ((Consumer) ((IntPipeline.AnonymousClass4) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).accept(obj);
            this.MyBillsEntityDataFactory.accept((Sink) obj);
        } else if (i == 2) {
            this.MyBillsEntityDataFactory.accept((Sink) ((ReferencePipeline.AnonymousClass3) this.PlaceComponentResult).moveToNextValue.apply(obj));
        } else if (i == 3) {
            this.MyBillsEntityDataFactory.accept(((ToIntFunction) ((IntPipeline.AnonymousClass3) this.PlaceComponentResult).scheduleImpl).MyBillsEntityDataFactory(obj));
        } else if (i == 4) {
            this.MyBillsEntityDataFactory.accept(((ToLongFunction) ((IntPipeline.AnonymousClass5) this.PlaceComponentResult).NetworkUserEntityData$$ExternalSyntheticLambda0).KClassImpl$Data$declaredNonStaticMembers$2(obj));
        } else if (i == 5) {
            this.MyBillsEntityDataFactory.accept(((ToDoubleFunction) ((IntPipeline.AnonymousClass6) this.PlaceComponentResult).moveToNextValue).applyAsDouble(obj));
        } else {
            Stream stream = (Stream) ((ReferencePipeline.AnonymousClass3) this.PlaceComponentResult).moveToNextValue.apply(obj);
            if (stream != null) {
                try {
                    ((Stream) stream.scheduleImpl()).PlaceComponentResult(this.MyBillsEntityDataFactory);
                } catch (Throwable th) {
                    try {
                        stream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            if (stream != null) {
                stream.close();
            }
        }
    }

    @Override // j$.util.stream.Sink
    public final void begin(long j) {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i == 0) {
            this.MyBillsEntityDataFactory.begin(-1L);
        } else if (i != 6) {
            this.MyBillsEntityDataFactory.begin(j);
        } else {
            this.MyBillsEntityDataFactory.begin(-1L);
        }
    }
}
