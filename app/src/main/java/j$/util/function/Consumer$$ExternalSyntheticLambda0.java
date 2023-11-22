package j$.util.function;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final /* synthetic */ class Consumer$$ExternalSyntheticLambda0 implements BiConsumer, BiFunction, Consumer {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ Object MyBillsEntityDataFactory;
    public final /* synthetic */ Object getAuthRequestContext;

    public /* synthetic */ Consumer$$ExternalSyntheticLambda0(int i, Object obj, Object obj2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.MyBillsEntityDataFactory = obj;
        this.getAuthRequestContext = obj2;
    }

    @Override // j$.util.function.Consumer
    public final void accept(Object obj) {
        Consumer consumer = (Consumer) this.MyBillsEntityDataFactory;
        Consumer consumer2 = (Consumer) this.getAuthRequestContext;
        consumer.accept(obj);
        consumer2.accept(obj);
    }

    @Override // j$.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != 1) {
            BiConsumer biConsumer = (BiConsumer) this.MyBillsEntityDataFactory;
            BiConsumer biConsumer2 = (BiConsumer) this.getAuthRequestContext;
            biConsumer.accept(obj, obj2);
            biConsumer2.accept(obj, obj2);
            return;
        }
        ConcurrentMap concurrentMap = (ConcurrentMap) this.MyBillsEntityDataFactory;
        BiFunction biFunction = (BiFunction) this.getAuthRequestContext;
        while (!concurrentMap.replace(obj, obj2, biFunction.apply(obj, obj2)) && (obj2 = concurrentMap.get(obj)) != null) {
        }
    }

    @Override // j$.util.function.BiConsumer
    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return BiConsumer.CC.getAuthRequestContext(this, biConsumer);
    }

    @Override // j$.util.function.BiFunction
    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.MyBillsEntityDataFactory(this, function);
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.PlaceComponentResult(this, consumer);
    }

    @Override // j$.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((Function) this.getAuthRequestContext).apply(((BiFunction) this.MyBillsEntityDataFactory).apply(obj, obj2));
    }
}
