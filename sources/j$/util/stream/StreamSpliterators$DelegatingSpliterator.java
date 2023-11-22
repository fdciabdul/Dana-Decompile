package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.DoubleConsumer;
import j$.util.function.IntConsumer;
import j$.util.function.LongConsumer;
import j$.util.function.Supplier;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class StreamSpliterators$DelegatingSpliterator implements Spliterator {
    private Spliterator KClassImpl$Data$declaredNonStaticMembers$2;
    private final Supplier getAuthRequestContext;

    /* loaded from: classes.dex */
    final class OfDouble extends OfPrimitive implements Spliterator.OfDouble {
        /* JADX INFO: Access modifiers changed from: package-private */
        public OfDouble(Supplier supplier) {
            super(supplier);
        }
    }

    /* loaded from: classes.dex */
    final class OfInt extends OfPrimitive implements Spliterator.OfInt {
        /* JADX INFO: Access modifiers changed from: package-private */
        public OfInt(Supplier supplier) {
            super(supplier);
        }
    }

    /* loaded from: classes.dex */
    final class OfLong extends OfPrimitive implements Spliterator.OfLong {
        /* JADX INFO: Access modifiers changed from: package-private */
        public OfLong(Supplier supplier) {
            super(supplier);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$DelegatingSpliterator(Supplier supplier) {
        this.getAuthRequestContext = supplier;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
    }

    final Spliterator scheduleImpl() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes.dex */
    abstract class OfPrimitive extends StreamSpliterators$DelegatingSpliterator implements Spliterator.OfPrimitive {
        OfPrimitive(Supplier supplier) {
            super(supplier);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            ((Spliterator.OfPrimitive) scheduleImpl()).KClassImpl$Data$declaredNonStaticMembers$2(obj);
        }

        public final /* bridge */ /* synthetic */ boolean MyBillsEntityDataFactory(IntConsumer intConsumer) {
            return PlaceComponentResult((Object) intConsumer);
        }

        @Override // j$.util.Spliterator.OfPrimitive
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final boolean PlaceComponentResult(Object obj) {
            return ((Spliterator.OfPrimitive) scheduleImpl()).PlaceComponentResult(obj);
        }

        public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DoubleConsumer doubleConsumer) {
            ((Spliterator.OfPrimitive) scheduleImpl()).KClassImpl$Data$declaredNonStaticMembers$2(doubleConsumer);
        }

        public final /* synthetic */ void getAuthRequestContext(IntConsumer intConsumer) {
            ((Spliterator.OfPrimitive) scheduleImpl()).KClassImpl$Data$declaredNonStaticMembers$2(intConsumer);
        }

        public final /* synthetic */ void getAuthRequestContext(LongConsumer longConsumer) {
            ((Spliterator.OfPrimitive) scheduleImpl()).KClassImpl$Data$declaredNonStaticMembers$2(longConsumer);
        }
    }

    @Override // j$.util.Spliterator
    public final int BuiltInFictitiousFunctionClassFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // j$.util.Spliterator
    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // j$.util.Spliterator
    public final void getAuthRequestContext(Consumer consumer) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getAuthRequestContext() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    @Override // j$.util.Spliterator
    public final long PlaceComponentResult() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append("]");
        return sb.toString();
    }

    @Override // j$.util.Spliterator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(consumer);
    }

    public final /* synthetic */ Spliterator.OfDouble getErrorConfigVersion() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return (Spliterator.OfDouble) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
    }

    /* renamed from: getErrorConfigVersion  reason: collision with other method in class */
    public final /* synthetic */ Spliterator.OfInt m3172getErrorConfigVersion() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return (Spliterator.OfInt) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
    }

    public final /* synthetic */ Spliterator.OfLong moveToNextValue() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return (Spliterator.OfLong) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
    }

    public final /* synthetic */ Spliterator.OfPrimitive NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return (Spliterator.OfPrimitive) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
    }

    @Override // j$.util.Spliterator
    /* renamed from: MyBillsEntityDataFactory */
    public final Spliterator moveToNextValue() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (Spliterator) this.getAuthRequestContext.get();
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue();
    }
}
