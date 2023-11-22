package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class Streams$StreamBuilderImpl implements Consumer, Spliterator {
    SpinedBuffer BuiltInFictitiousFunctionClassFactory;
    int MyBillsEntityDataFactory = -2;
    Object getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Streams$StreamBuilderImpl(Object obj) {
        this.getAuthRequestContext = obj;
    }

    @Override // j$.util.Spliterator
    public final /* bridge */ /* synthetic */ int BuiltInFictitiousFunctionClassFactory() {
        return 17488;
    }

    @Override // j$.util.Spliterator
    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        return (long) ((-this.MyBillsEntityDataFactory) - 1);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
    }

    @Override // j$.util.Spliterator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
        if (this.MyBillsEntityDataFactory == -2) {
            consumer.accept(this.getAuthRequestContext);
            this.MyBillsEntityDataFactory = -1;
            return true;
        }
        return false;
    }

    @Override // j$.util.Spliterator
    /* renamed from: MyBillsEntityDataFactory */
    public final /* bridge */ /* synthetic */ Spliterator moveToNextValue() {
        return null;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long PlaceComponentResult() {
        return Objects.getAuthRequestContext(this);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.MyBillsEntityDataFactory;
        if (i == 0) {
            this.getAuthRequestContext = obj;
            this.MyBillsEntityDataFactory = i + 1;
        } else if (i <= 0) {
            throw new IllegalStateException();
        } else {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                SpinedBuffer spinedBuffer = new SpinedBuffer();
                this.BuiltInFictitiousFunctionClassFactory = spinedBuffer;
                spinedBuffer.accept(this.getAuthRequestContext);
                this.MyBillsEntityDataFactory++;
            }
            this.BuiltInFictitiousFunctionClassFactory.accept(obj);
        }
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getAuthRequestContext() {
        throw new IllegalStateException();
    }

    @Override // j$.util.Spliterator
    public final void getAuthRequestContext(Consumer consumer) {
        if (this.MyBillsEntityDataFactory == -2) {
            consumer.accept(this.getAuthRequestContext);
            this.MyBillsEntityDataFactory = -1;
        }
    }
}
