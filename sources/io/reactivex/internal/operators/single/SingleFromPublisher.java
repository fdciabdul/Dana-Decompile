package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.LongCompanionObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* loaded from: classes9.dex */
public final class SingleFromPublisher<T> extends Single<T> {
    final Publisher<? extends T> getAuthRequestContext;

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super T> singleObserver) {
        this.getAuthRequestContext.subscribe(new ToSingleObserver(singleObserver));
    }

    /* loaded from: classes9.dex */
    static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {
        boolean BuiltInFictitiousFunctionClassFactory;
        Subscription KClassImpl$Data$declaredNonStaticMembers$2;
        volatile boolean MyBillsEntityDataFactory;
        T PlaceComponentResult;
        final SingleObserver<? super T> getAuthRequestContext;

        ToSingleObserver(SingleObserver<? super T> singleObserver) {
            this.getAuthRequestContext = singleObserver;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.KClassImpl$Data$declaredNonStaticMembers$2, subscription)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = subscription;
                this.getAuthRequestContext.onSubscribe(this);
                subscription.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onNext(T t) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            if (this.PlaceComponentResult != null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
                this.BuiltInFictitiousFunctionClassFactory = true;
                this.PlaceComponentResult = null;
                this.getAuthRequestContext.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                return;
            }
            this.PlaceComponentResult = t;
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                RxJavaPlugins.PlaceComponentResult(th);
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            this.PlaceComponentResult = null;
            this.getAuthRequestContext.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return;
            }
            this.BuiltInFictitiousFunctionClassFactory = true;
            T t = this.PlaceComponentResult;
            this.PlaceComponentResult = null;
            if (t == null) {
                this.getAuthRequestContext.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.getAuthRequestContext.onSuccess(t);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.MyBillsEntityDataFactory;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
        }
    }
}
