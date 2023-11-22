package id.dana.domain;

import dagger.internal.Preconditions;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

@Deprecated
/* loaded from: classes4.dex */
public abstract class CompletableUseCase<P> {
    protected abstract Completable buildCompletableUseCase(P p);

    public void execute(CompletableObserver completableObserver) {
        execute(completableObserver, null);
    }

    public void execute(CompletableObserver completableObserver, P p) {
        Preconditions.getAuthRequestContext(completableObserver);
        Completable buildCompletableUseCase = buildCompletableUseCase(p);
        Scheduler MyBillsEntityDataFactory = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(buildCompletableUseCase, MyBillsEntityDataFactory));
        Scheduler MyBillsEntityDataFactory2 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory2, "scheduler is null");
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory2)).getAuthRequestContext(completableObserver);
    }
}
