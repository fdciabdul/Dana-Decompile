package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.IntConsumer;
import j$.util.stream.Node;
import j$.util.stream.SpinedBuffer;

/* loaded from: classes.dex */
final class StreamSpliterators$IntWrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator implements Spliterator.OfInt {
    private StreamSpliterators$IntWrappingSpliterator(Node.CC cc, Spliterator spliterator, boolean z) {
        super(cc, spliterator, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$IntWrappingSpliterator(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        super(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final StreamSpliterators$AbstractWrappingSpliterator BuiltInFictitiousFunctionClassFactory(Spliterator spliterator) {
        return new StreamSpliterators$IntWrappingSpliterator(this.scheduleImpl, spliterator, this.MyBillsEntityDataFactory);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
        return Objects.MyBillsEntityDataFactory((Spliterator.OfInt) this, consumer);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public final boolean PlaceComponentResult(IntConsumer intConsumer) {
        boolean scheduleImpl = scheduleImpl();
        if (scheduleImpl) {
            SpinedBuffer.OfInt ofInt = (SpinedBuffer.OfInt) this.BuiltInFictitiousFunctionClassFactory;
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int MyBillsEntityDataFactory = ofInt.MyBillsEntityDataFactory(j);
            intConsumer.accept((ofInt.KClassImpl$Data$declaredNonStaticMembers$2 == 0 && MyBillsEntityDataFactory == 0) ? ((int[]) ofInt.BuiltInFictitiousFunctionClassFactory)[(int) j] : ((int[][]) ofInt.scheduleImpl)[MyBillsEntityDataFactory][(int) (j - ofInt.PlaceComponentResult[MyBillsEntityDataFactory])]);
        }
        return scheduleImpl;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
        Objects.BuiltInFictitiousFunctionClassFactory(this, consumer);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    public final void getAuthRequestContext(IntConsumer intConsumer) {
        if (this.BuiltInFictitiousFunctionClassFactory != null || this.PlaceComponentResult) {
            do {
            } while (PlaceComponentResult(intConsumer));
            return;
        }
        lookAheadTest();
        this.scheduleImpl.PlaceComponentResult(this.moveToNextValue, new StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda0(intConsumer, 1));
        this.PlaceComponentResult = true;
    }

    @Override // j$.util.Spliterator.OfInt
    /* renamed from: getErrorConfigVersion */
    public final Spliterator.OfInt moveToNextValue() {
        return (Spliterator.OfInt) super.moveToNextValue();
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final void initRecordTimeStamp() {
        SpinedBuffer.OfInt ofInt = new SpinedBuffer.OfInt();
        this.BuiltInFictitiousFunctionClassFactory = ofInt;
        this.getAuthRequestContext = this.scheduleImpl.getAuthRequestContext(new StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda0(ofInt, 0));
        this.lookAheadTest = new Collectors$$ExternalSyntheticLambda25(6, this);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0 */
    public final /* synthetic */ Spliterator.OfPrimitive moveToNextValue() {
        return (Spliterator.OfInt) super.moveToNextValue();
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator, j$.util.Spliterator
    /* renamed from: MyBillsEntityDataFactory */
    public final /* bridge */ /* synthetic */ Spliterator moveToNextValue() {
        return (Spliterator.OfInt) super.moveToNextValue();
    }
}
