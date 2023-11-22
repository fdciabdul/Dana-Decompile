package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public final class ObservableBlockingSubscribe {
    private ObservableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void PlaceComponentResult(ObservableSource<? extends T> observableSource, Observer<? super T> observer) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        observer.onSubscribe(blockingObserver);
        observableSource.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (InterruptedException e) {
                    blockingObserver.dispose();
                    observer.onError(e);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || poll == BlockingObserver.TERMINATED || NotificationLite.acceptFull(poll, observer)) {
                return;
            }
        }
    }

    public static <T> void getAuthRequestContext(ObservableSource<? extends T> observableSource) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.PlaceComponentResult(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.PlaceComponentResult());
        observableSource.subscribe(lambdaObserver);
        BlockingHelper.KClassImpl$Data$declaredNonStaticMembers$2(blockingIgnoringReceiver, lambdaObserver);
        Throwable th = blockingIgnoringReceiver.getAuthRequestContext;
        if (th != null) {
            throw ExceptionHelper.MyBillsEntityDataFactory(th);
        }
    }

    public static <T> void MyBillsEntityDataFactory(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.PlaceComponentResult(consumer, "onNext is null");
        ObjectHelper.PlaceComponentResult(consumer2, "onError is null");
        ObjectHelper.PlaceComponentResult(action, "onComplete is null");
        PlaceComponentResult(observableSource, new LambdaObserver(consumer, consumer2, action, Functions.PlaceComponentResult()));
    }
}
