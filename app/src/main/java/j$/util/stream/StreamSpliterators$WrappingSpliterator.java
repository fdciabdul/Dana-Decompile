package j$.util.stream;

import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.stream.Node;

/* loaded from: classes.dex */
final class StreamSpliterators$WrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator {
    private StreamSpliterators$WrappingSpliterator(Node.CC cc, Spliterator spliterator, boolean z) {
        super(cc, spliterator, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$WrappingSpliterator(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        super(cc, collectors$$ExternalSyntheticLambda25, z);
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final StreamSpliterators$AbstractWrappingSpliterator BuiltInFictitiousFunctionClassFactory(Spliterator spliterator) {
        return new StreamSpliterators$WrappingSpliterator(this.scheduleImpl, spliterator, this.MyBillsEntityDataFactory);
    }

    @Override // j$.util.Spliterator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
        Object obj;
        boolean scheduleImpl = scheduleImpl();
        if (scheduleImpl) {
            SpinedBuffer spinedBuffer = (SpinedBuffer) this.BuiltInFictitiousFunctionClassFactory;
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (spinedBuffer.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                if (j < spinedBuffer.s_()) {
                    for (int i = 0; i <= spinedBuffer.KClassImpl$Data$declaredNonStaticMembers$2; i++) {
                        long j2 = spinedBuffer.PlaceComponentResult[i];
                        Object[] objArr = spinedBuffer.moveToNextValue[i];
                        if (j < objArr.length + j2) {
                            obj = objArr[(int) (j - j2)];
                        }
                    }
                    throw new IndexOutOfBoundsException(Long.toString(j));
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else if (j >= spinedBuffer.getAuthRequestContext) {
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else {
                obj = spinedBuffer.BuiltInFictitiousFunctionClassFactory[(int) j];
            }
            consumer.accept(obj);
        }
        return scheduleImpl;
    }

    @Override // j$.util.Spliterator
    public final void getAuthRequestContext(Consumer consumer) {
        if (this.BuiltInFictitiousFunctionClassFactory != null || this.PlaceComponentResult) {
            do {
            } while (KClassImpl$Data$declaredNonStaticMembers$2(consumer));
            return;
        }
        lookAheadTest();
        this.scheduleImpl.PlaceComponentResult(this.moveToNextValue, new StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda0(consumer, 1));
        this.PlaceComponentResult = true;
    }

    @Override // j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator
    final void initRecordTimeStamp() {
        SpinedBuffer spinedBuffer = new SpinedBuffer();
        this.BuiltInFictitiousFunctionClassFactory = spinedBuffer;
        this.getAuthRequestContext = this.scheduleImpl.getAuthRequestContext(new StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda0(spinedBuffer, 0));
        this.lookAheadTest = new Collectors$$ExternalSyntheticLambda25(8, this);
    }
}
