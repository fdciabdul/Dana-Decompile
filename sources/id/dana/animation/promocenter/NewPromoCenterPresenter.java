package id.dana.animation.promocenter;

import dagger.Lazy;
import id.dana.animation.promocenter.NewPromoCenterContract;
import id.dana.base.BasePresenter;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetPromoCenterConfig;
import id.dana.domain.featureconfig.model.PromoCenterConfig;
import id.dana.domain.feeds.model.ActivityData;
import id.dana.domain.feeds.model.Feeds;
import id.dana.domain.home.interactor.GetNewsWidgetActivitiesFromPersistence;
import id.dana.domain.home.interactor.SaveNewsWidgetActivitiesIntoPersistence;
import id.dana.domain.promodiscovery.interactor.GetPromoCenterVersion;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes5.dex */
public class NewPromoCenterPresenter extends BasePresenter implements NewPromoCenterContract.Presenter {
    public static final String MyBillsEntityDataFactory = "NewPromoCenterPresenter";
    final NewPromoCenterContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<GetPromoCenterVersion> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<GetPromoCenterConfig> getErrorConfigVersion;
    private final Lazy<GetNewsWidgetActivitiesFromPersistence> lookAheadTest;
    private final Lazy<SaveNewsWidgetActivitiesIntoPersistence> moveToNextValue;
    private DefaultObserver<PromoCenterConfig> scheduleImpl;
    private final PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
    final PublishSubject<Boolean> BuiltInFictitiousFunctionClassFactory = PublishSubject.PlaceComponentResult();
    boolean getAuthRequestContext = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit getErrorConfigVersion() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit moveToNextValue() {
        return null;
    }

    @Inject
    public NewPromoCenterPresenter(NewPromoCenterContract.View view, Lazy<GetPromoCenterConfig> lazy, Lazy<GetPromoCenterVersion> lazy2, Lazy<GetNewsWidgetActivitiesFromPersistence> lazy3, Lazy<SaveNewsWidgetActivitiesIntoPersistence> lazy4) {
        this.getErrorConfigVersion = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy2;
        this.lookAheadTest = lazy3;
        this.moveToNextValue = lazy4;
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewPromoCenterPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onGetPromoCenterVersion(((Integer) obj).intValue());
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                NewPromoCenterPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onGetPromoCenterVersion(1);
                DanaLog.BuiltInFictitiousFunctionClassFactory(NewPromoCenterPresenter.MyBillsEntityDataFactory, th.getMessage(), th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewPromoCenterPresenter newPromoCenterPresenter = NewPromoCenterPresenter.this;
                List<? extends ActivityData> list = (List) obj;
                newPromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2.onGetFeedNewsModelFromCache(list);
                newPromoCenterPresenter.getAuthRequestContext = list.isEmpty();
                newPromoCenterPresenter.BuiltInFictitiousFunctionClassFactory.onNext(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewPromoCenterPresenter newPromoCenterPresenter = NewPromoCenterPresenter.this;
                Throwable th = (Throwable) obj;
                newPromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2.onGetFeedNewsModelFromCacheError();
                newPromoCenterPresenter.getAuthRequestContext = true;
                newPromoCenterPresenter.BuiltInFictitiousFunctionClassFactory.onNext(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.Presenter
    public final void getAuthRequestContext(Feeds feeds) {
        this.moveToNextValue.get().execute(new SaveNewsWidgetActivitiesIntoPersistence.Params(feeds.getActivities()), new Function0() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewPromoCenterPresenter.moveToNextValue();
            }
        }, new Function1() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return NewPromoCenterPresenter.getErrorConfigVersion();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getErrorConfigVersion.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.lookAheadTest.get().dispose();
        this.moveToNextValue.get().dispose();
        dispose();
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.Presenter
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.onNext(Boolean.TRUE);
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.Presenter
    public final void MyBillsEntityDataFactory() {
        addDisposable(Observable.combineLatest(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory, new BiFunction() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                valueOf = Boolean.valueOf(r0.booleanValue() && r1.booleanValue());
                return valueOf;
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewPromoCenterPresenter newPromoCenterPresenter = NewPromoCenterPresenter.this;
                if (((Boolean) obj).booleanValue()) {
                    newPromoCenterPresenter.PlaceComponentResult();
                    newPromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2();
                    newPromoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2.onFinishCheckSessionAndLoadCache(newPromoCenterPresenter.getAuthRequestContext);
                }
            }
        }));
    }

    @Override // id.dana.home.promocenter.NewPromoCenterContract.Presenter
    public final void PlaceComponentResult() {
        DefaultObserver<PromoCenterConfig> defaultObserver = this.scheduleImpl;
        if (defaultObserver != null) {
            defaultObserver.dispose();
            this.scheduleImpl = null;
        }
        GetPromoCenterConfig getPromoCenterConfig = this.getErrorConfigVersion.get();
        DefaultObserver<PromoCenterConfig> defaultObserver2 = new DefaultObserver<PromoCenterConfig>() { // from class: id.dana.home.promocenter.NewPromoCenterPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                NewPromoCenterPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.onFinishGetPromoCenterConfig((PromoCenterConfig) obj);
            }
        };
        this.scheduleImpl = defaultObserver2;
        getPromoCenterConfig.execute(defaultObserver2);
    }
}
