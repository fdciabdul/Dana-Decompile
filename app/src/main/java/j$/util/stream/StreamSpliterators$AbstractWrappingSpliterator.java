package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Supplier;
import j$.util.stream.Node;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class StreamSpliterators$AbstractWrappingSpliterator implements Spliterator {
    AbstractSpinedBuffer BuiltInFictitiousFunctionClassFactory;
    long KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean MyBillsEntityDataFactory;
    boolean PlaceComponentResult;
    Sink getAuthRequestContext;
    private Supplier getErrorConfigVersion;
    Collectors$$ExternalSyntheticLambda25 lookAheadTest;
    Spliterator moveToNextValue;
    final Node.CC scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$AbstractWrappingSpliterator(Node.CC cc, Spliterator spliterator, boolean z) {
        this.scheduleImpl = cc;
        this.getErrorConfigVersion = null;
        this.moveToNextValue = spliterator;
        this.MyBillsEntityDataFactory = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$AbstractWrappingSpliterator(Node.CC cc, Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25, boolean z) {
        this.scheduleImpl = cc;
        this.getErrorConfigVersion = collectors$$ExternalSyntheticLambda25;
        this.moveToNextValue = null;
        this.MyBillsEntityDataFactory = z;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        StreamSpliterators$AbstractWrappingSpliterator streamSpliterators$AbstractWrappingSpliterator;
        while (this.BuiltInFictitiousFunctionClassFactory.s_() == 0) {
            if (!this.getAuthRequestContext.cancellationRequested()) {
                Collectors$$ExternalSyntheticLambda25 collectors$$ExternalSyntheticLambda25 = this.lookAheadTest;
                int i = collectors$$ExternalSyntheticLambda25.getAuthRequestContext;
                if (i == 5) {
                    streamSpliterators$AbstractWrappingSpliterator = (StreamSpliterators$DoubleWrappingSpliterator) collectors$$ExternalSyntheticLambda25.PlaceComponentResult;
                } else if (i != 6) {
                    Object obj = collectors$$ExternalSyntheticLambda25.PlaceComponentResult;
                    streamSpliterators$AbstractWrappingSpliterator = i != 7 ? (StreamSpliterators$WrappingSpliterator) obj : (StreamSpliterators$LongWrappingSpliterator) obj;
                } else {
                    streamSpliterators$AbstractWrappingSpliterator = (StreamSpliterators$IntWrappingSpliterator) collectors$$ExternalSyntheticLambda25.PlaceComponentResult;
                }
                if (streamSpliterators$AbstractWrappingSpliterator.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(streamSpliterators$AbstractWrappingSpliterator.getAuthRequestContext)) {
                    continue;
                }
            }
            if (this.PlaceComponentResult) {
                return false;
            }
            this.getAuthRequestContext.end();
            this.PlaceComponentResult = true;
        }
        return true;
    }

    abstract StreamSpliterators$AbstractWrappingSpliterator BuiltInFictitiousFunctionClassFactory(Spliterator spliterator);

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
    }

    @Override // j$.util.Spliterator
    public final Comparator getAuthRequestContext() {
        if (Objects.BuiltInFictitiousFunctionClassFactory(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    abstract void initRecordTimeStamp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void lookAheadTest() {
        if (this.moveToNextValue == null) {
            this.moveToNextValue = (Spliterator) this.getErrorConfigVersion.get();
            this.getErrorConfigVersion = null;
        }
    }

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.moveToNextValue);
    }

    @Override // j$.util.Spliterator
    public final int BuiltInFictitiousFunctionClassFactory() {
        if (this.moveToNextValue == null) {
            this.moveToNextValue = (Spliterator) this.getErrorConfigVersion.get();
            this.getErrorConfigVersion = null;
        }
        int streamFlags = StreamOpFlag.toStreamFlags(this.scheduleImpl.getAuthRequestContext()) & StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK;
        return (streamFlags & 64) != 0 ? (streamFlags & (-16449)) | (this.moveToNextValue.BuiltInFictitiousFunctionClassFactory() & 16448) : streamFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean scheduleImpl() {
        AbstractSpinedBuffer abstractSpinedBuffer = this.BuiltInFictitiousFunctionClassFactory;
        if (abstractSpinedBuffer != null) {
            long j = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
            boolean z = j < abstractSpinedBuffer.s_();
            if (z) {
                return z;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
            this.BuiltInFictitiousFunctionClassFactory.t_();
            return NetworkUserEntityData$$ExternalSyntheticLambda0();
        } else if (this.PlaceComponentResult) {
            return false;
        } else {
            if (this.moveToNextValue == null) {
                this.moveToNextValue = (Spliterator) this.getErrorConfigVersion.get();
                this.getErrorConfigVersion = null;
            }
            initRecordTimeStamp();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
            this.getAuthRequestContext.begin(this.moveToNextValue.PlaceComponentResult());
            return NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    @Override // j$.util.Spliterator
    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.moveToNextValue == null) {
            this.moveToNextValue = (Spliterator) this.getErrorConfigVersion.get();
            this.getErrorConfigVersion = null;
        }
        return this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // j$.util.Spliterator
    public final long PlaceComponentResult() {
        if (this.moveToNextValue == null) {
            this.moveToNextValue = (Spliterator) this.getErrorConfigVersion.get();
            this.getErrorConfigVersion = null;
        }
        if (StreamOpFlag.SIZED.isKnown(this.scheduleImpl.getAuthRequestContext())) {
            return this.moveToNextValue.PlaceComponentResult();
        }
        return -1L;
    }

    @Override // j$.util.Spliterator
    /* renamed from: MyBillsEntityDataFactory */
    public Spliterator moveToNextValue() {
        if (!this.MyBillsEntityDataFactory || this.PlaceComponentResult) {
            return null;
        }
        if (this.moveToNextValue == null) {
            this.moveToNextValue = (Spliterator) this.getErrorConfigVersion.get();
            this.getErrorConfigVersion = null;
        }
        Spliterator moveToNextValue = this.moveToNextValue.moveToNextValue();
        if (moveToNextValue == null) {
            return null;
        }
        return BuiltInFictitiousFunctionClassFactory(moveToNextValue);
    }
}
