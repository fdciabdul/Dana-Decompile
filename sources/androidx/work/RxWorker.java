package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class RxWorker extends ListenableWorker {
    static final Executor INSTANT_EXECUTOR = new SynchronousExecutor();
    private SingleFutureAdapter<ListenableWorker.Result> mSingleFutureObserverAdapter;

    public abstract Single<ListenableWorker.Result> createWork();

    public RxWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.mSingleFutureObserverAdapter = new SingleFutureAdapter<>();
        Scheduler backgroundScheduler = getBackgroundScheduler();
        Single<ListenableWorker.Result> createWork = createWork();
        ObjectHelper.PlaceComponentResult(backgroundScheduler, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(createWork, backgroundScheduler));
        Scheduler BuiltInFictitiousFunctionClassFactory2 = Schedulers.BuiltInFictitiousFunctionClassFactory(getTaskExecutor().MyBillsEntityDataFactory());
        ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, "scheduler is null");
        RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2)).MyBillsEntityDataFactory((SingleObserver) this.mSingleFutureObserverAdapter);
        return this.mSingleFutureObserverAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    protected Scheduler getBackgroundScheduler() {
        return Schedulers.BuiltInFictitiousFunctionClassFactory(getBackgroundExecutor());
    }

    @Deprecated
    public final Single<Void> setProgress(Data data) {
        return Single.PlaceComponentResult(setProgressAsync(data));
    }

    public final Completable setCompletableProgress(Data data) {
        return Completable.MyBillsEntityDataFactory(setProgressAsync(data));
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        SingleFutureAdapter<ListenableWorker.Result> singleFutureAdapter = this.mSingleFutureObserverAdapter;
        if (singleFutureAdapter != null) {
            Disposable disposable = singleFutureAdapter.BuiltInFictitiousFunctionClassFactory;
            if (disposable != null) {
                disposable.dispose();
            }
            this.mSingleFutureObserverAdapter = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SingleFutureAdapter<T> implements SingleObserver<T>, Runnable {
        Disposable BuiltInFictitiousFunctionClassFactory;
        final SettableFuture<T> KClassImpl$Data$declaredNonStaticMembers$2;

        SingleFutureAdapter() {
            SettableFuture<T> PlaceComponentResult = SettableFuture.PlaceComponentResult();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
            PlaceComponentResult.addListener(this, RxWorker.INSTANT_EXECUTOR);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            this.BuiltInFictitiousFunctionClassFactory = disposable;
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((SettableFuture<T>) t);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable;
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.isCancelled() || (disposable = this.BuiltInFictitiousFunctionClassFactory) == null) {
                return;
            }
            disposable.dispose();
        }
    }
}
