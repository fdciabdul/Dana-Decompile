package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.stream.Node;
import j$.util.stream.SpinedBuffer;

/* loaded from: classes.dex */
final class StreamSpliterators$DoubleWrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator implements Spliterator.OfDouble {
    private StreamSpliterators$DoubleWrappingSpliterator(Node.CC cc, Spliterator spliterator, boolean z) {
        super(cc, spliterator, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$DoubleWrappingSpliterator(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        super(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final StreamSpliterators$AbstractWrappingSpliterator BuiltInFictitiousFunctionClassFactory(Spliterator spliterator) {
        return new StreamSpliterators$DoubleWrappingSpliterator(this.scheduleImpl, spliterator, this.MyBillsEntityDataFactory);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final void getAuthRequestContext(DoubleConsumer doubleConsumer) {
        if (this.BuiltInFictitiousFunctionClassFactory != null || this.PlaceComponentResult) {
            do {
            } while (PlaceComponentResult(doubleConsumer));
            return;
        }
        lookAheadTest();
        this.scheduleImpl.PlaceComponentResult(this.moveToNextValue, new StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda0(doubleConsumer, 1));
        this.PlaceComponentResult = true;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
        return Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    public final boolean PlaceComponentResult(DoubleConsumer doubleConsumer) {
        boolean scheduleImpl = scheduleImpl();
        if (scheduleImpl) {
            SpinedBuffer.OfDouble ofDouble = (SpinedBuffer.OfDouble) this.BuiltInFictitiousFunctionClassFactory;
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int MyBillsEntityDataFactory = ofDouble.MyBillsEntityDataFactory(j);
            doubleConsumer.accept((ofDouble.KClassImpl$Data$declaredNonStaticMembers$2 == 0 && MyBillsEntityDataFactory == 0) ? ((double[]) ofDouble.BuiltInFictitiousFunctionClassFactory)[(int) j] : ((double[][]) ofDouble.scheduleImpl)[MyBillsEntityDataFactory][(int) (j - ofDouble.PlaceComponentResult[MyBillsEntityDataFactory])]);
        }
        return scheduleImpl;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
        Objects.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.Spliterator.OfDouble
    public final Spliterator.OfDouble getErrorConfigVersion() {
        return (Spliterator.OfDouble) super.moveToNextValue();
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final void initRecordTimeStamp() {
        SpinedBuffer.OfDouble ofDouble = new SpinedBuffer.OfDouble();
        this.BuiltInFictitiousFunctionClassFactory = ofDouble;
        this.getAuthRequestContext = this.scheduleImpl.getAuthRequestContext(new StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda0(ofDouble, 0));
        this.lookAheadTest = new Collectors$$ExternalSyntheticLambda25(5, this);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0 */
    public final /* synthetic */ Spliterator.OfPrimitive moveToNextValue() {
        return (Spliterator.OfDouble) super.moveToNextValue();
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator, j$.util.Spliterator
    /* renamed from: MyBillsEntityDataFactory */
    public final /* bridge */ /* synthetic */ Spliterator moveToNextValue() {
        return (Spliterator.OfDouble) super.moveToNextValue();
    }
}
