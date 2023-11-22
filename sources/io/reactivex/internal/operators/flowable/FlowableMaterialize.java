package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {
    public FlowableMaterialize(Flowable<T> flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super Notification<T>> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new MaterializeSubscriber(subscriber));
    }

    /* loaded from: classes9.dex */
    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long serialVersionUID = -3740826063558713822L;

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber
        public final /* bridge */ /* synthetic */ void onDrop(Object obj) {
            onDrop((Notification) ((Notification) obj));
        }

        MaterializeSubscriber(Subscriber<? super Notification<T>> subscriber) {
            super(subscriber);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            this.produced++;
            this.downstream.onNext(Notification.BuiltInFictitiousFunctionClassFactory(t));
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            complete(Notification.MyBillsEntityDataFactory(th));
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            complete(Notification.MyBillsEntityDataFactory());
        }

        protected final void onDrop(Notification<T> notification) {
            if (notification.PlaceComponentResult()) {
                Object obj = notification.MyBillsEntityDataFactory;
                RxJavaPlugins.PlaceComponentResult(NotificationLite.isError(obj) ? NotificationLite.getError(obj) : null);
            }
        }
    }
}
