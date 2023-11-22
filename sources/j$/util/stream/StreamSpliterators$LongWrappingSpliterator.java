package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.LongConsumer;
import j$.util.stream.Node;
import j$.util.stream.SpinedBuffer;

/* loaded from: classes.dex */
final class StreamSpliterators$LongWrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator implements Spliterator.OfLong {
    private StreamSpliterators$LongWrappingSpliterator(Node.CC cc, Spliterator spliterator, boolean z) {
        super(cc, spliterator, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$LongWrappingSpliterator(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        super(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final StreamSpliterators$AbstractWrappingSpliterator BuiltInFictitiousFunctionClassFactory(Spliterator spliterator) {
        return new StreamSpliterators$LongWrappingSpliterator(this.scheduleImpl, spliterator, this.MyBillsEntityDataFactory);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public final boolean PlaceComponentResult(LongConsumer longConsumer) {
        boolean scheduleImpl = scheduleImpl();
        if (scheduleImpl) {
            SpinedBuffer.OfLong ofLong = (SpinedBuffer.OfLong) this.BuiltInFictitiousFunctionClassFactory;
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int MyBillsEntityDataFactory = ofLong.MyBillsEntityDataFactory(j);
            longConsumer.accept((ofLong.KClassImpl$Data$declaredNonStaticMembers$2 == 0 && MyBillsEntityDataFactory == 0) ? ((long[]) ofLong.BuiltInFictitiousFunctionClassFactory)[(int) j] : ((long[][]) ofLong.scheduleImpl)[MyBillsEntityDataFactory][(int) (j - ofLong.PlaceComponentResult[MyBillsEntityDataFactory])]);
        }
        return scheduleImpl;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
        return Objects.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void getAuthRequestContext(Consumer consumer) {
        Objects.getAuthRequestContext(this, consumer);
    }

    @Override // j$.util.Spliterator.OfPrimitive
    public final void getAuthRequestContext(LongConsumer longConsumer) {
        if (this.BuiltInFictitiousFunctionClassFactory != null || this.PlaceComponentResult) {
            do {
            } while (PlaceComponentResult(longConsumer));
            return;
        }
        lookAheadTest();
        this.scheduleImpl.PlaceComponentResult(this.moveToNextValue, new StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda1(longConsumer, 1));
        this.PlaceComponentResult = true;
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final void initRecordTimeStamp() {
        SpinedBuffer.OfLong ofLong = new SpinedBuffer.OfLong();
        this.BuiltInFictitiousFunctionClassFactory = ofLong;
        this.getAuthRequestContext = this.scheduleImpl.getAuthRequestContext(new StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda1(ofLong, 0));
        this.lookAheadTest = new Collectors$$ExternalSyntheticLambda25(7, this);
    }

    @Override // j$.util.Spliterator.OfLong
    public final Spliterator.OfLong moveToNextValue() {
        return (Spliterator.OfLong) super.moveToNextValue();
    }

    @Override // j$.util.Spliterator.OfPrimitive
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0 */
    public final /* synthetic */ Spliterator.OfPrimitive moveToNextValue() {
        return (Spliterator.OfLong) super.moveToNextValue();
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator, j$.util.Spliterator
    /* renamed from: MyBillsEntityDataFactory */
    public final /* bridge */ /* synthetic */ Spliterator moveToNextValue() {
        return (Spliterator.OfLong) super.moveToNextValue();
    }
}
