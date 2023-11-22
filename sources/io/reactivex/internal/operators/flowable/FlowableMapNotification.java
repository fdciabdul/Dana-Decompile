package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* loaded from: classes9.dex */
public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends R> KClassImpl$Data$declaredNonStaticMembers$2;
    final Function<? super Throwable, ? extends R> MyBillsEntityDataFactory;
    final Callable<? extends R> getAuthRequestContext;

    @Override // io.reactivex.Flowable
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Subscriber<? super R> subscriber) {
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(new MapNotificationSubscriber(subscriber, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext));
    }

    /* loaded from: classes9.dex */
    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;
        final Callable<? extends R> onCompleteSupplier;
        final Function<? super Throwable, ? extends R> onErrorMapper;
        final Function<? super T, ? extends R> onNextMapper;

        MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Callable<? extends R> callable) {
            super(subscriber);
            this.onNextMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            try {
                Object PlaceComponentResult = ObjectHelper.PlaceComponentResult(this.onNextMapper.apply(t), "The onNext publisher returned is null");
                this.produced++;
                this.downstream.onNext(PlaceComponentResult);
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.downstream.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            try {
                complete(ObjectHelper.PlaceComponentResult(this.onErrorMapper.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                Exceptions.MyBillsEntityDataFactory(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            try {
                complete(ObjectHelper.PlaceComponentResult(this.onCompleteSupplier.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                this.downstream.onError(th);
            }
        }
    }
}
