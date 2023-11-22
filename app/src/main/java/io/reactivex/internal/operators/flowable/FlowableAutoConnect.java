package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableAutoConnect<T> extends Flowable<T> {
    final ConnectableFlowable<? extends T> BuiltInFictitiousFunctionClassFactory;
    final int KClassImpl$Data$declaredNonStaticMembers$2;
    final AtomicInteger MyBillsEntityDataFactory;
    final Consumer<? super Disposable> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super T> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.subscribe(subscriber);
        if (this.MyBillsEntityDataFactory.incrementAndGet() == this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.getAuthRequestContext);
        }
    }
}
