package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Consumer;
import java.util.Comparator;

/* loaded from: classes.dex */
final class StreamSpliterators$DistinctSpliterator implements Spliterator, Consumer {
    static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private Object BuiltInFictitiousFunctionClassFactory;
    private final Spliterator MyBillsEntityDataFactory;
    final ConcurrentHashMap PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamSpliterators$DistinctSpliterator(Spliterator spliterator) {
        this(spliterator, new ConcurrentHashMap());
    }

    private StreamSpliterators$DistinctSpliterator(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.MyBillsEntityDataFactory = spliterator;
        this.PlaceComponentResult = concurrentHashMap;
    }

    @Override // j$.util.Spliterator
    public final int BuiltInFictitiousFunctionClassFactory() {
        return (this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory() & (-16469)) | 1;
    }

    @Override // j$.util.Spliterator
    public final long KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return Objects.BuiltInFictitiousFunctionClassFactory(this, i);
    }

    @Override // j$.util.Spliterator
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Consumer consumer) {
        while (this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this)) {
            ConcurrentHashMap concurrentHashMap = this.PlaceComponentResult;
            Object obj = this.BuiltInFictitiousFunctionClassFactory;
            if (obj == null) {
                obj = KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (concurrentHashMap.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.BuiltInFictitiousFunctionClassFactory);
                this.BuiltInFictitiousFunctionClassFactory = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    /* renamed from: MyBillsEntityDataFactory */
    public final Spliterator moveToNextValue() {
        Spliterator moveToNextValue = this.MyBillsEntityDataFactory.moveToNextValue();
        if (moveToNextValue != null) {
            return new StreamSpliterators$DistinctSpliterator(moveToNextValue, this.PlaceComponentResult);
        }
        return null;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long PlaceComponentResult() {
        return Objects.getAuthRequestContext(this);
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        this.BuiltInFictitiousFunctionClassFactory = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getAuthRequestContext();
    }

    @Override // j$.util.Spliterator
    public final void getAuthRequestContext(Consumer consumer) {
        this.MyBillsEntityDataFactory.getAuthRequestContext(new MatchOps$$ExternalSyntheticLambda0(6, this, consumer));
    }
}
