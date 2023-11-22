package id.dana.danah5.locationpicker;

import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.danah5.locationpicker.contract.MapPageContract;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MapPageActivity_MembersInjector implements MembersInjector<MapPageActivity> {
    private final Provider<AppLifeCycleObserver> appLifeCycleObserverProvider;
    private final Provider<ConnectionStatusReceiver> connectionStatusReceiverProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<MapPageContract.Presenter> presenterProvider;

    public MapPageActivity_MembersInjector(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<MapPageContract.Presenter> provider4) {
        this.appLifeCycleObserverProvider = provider;
        this.connectionStatusReceiverProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
        this.presenterProvider = provider4;
    }

    public static MembersInjector<MapPageActivity> create(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<MapPageContract.Presenter> provider4) {
        return new MapPageActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public final void injectMembers(MapPageActivity mapPageActivity) {
        ((BaseActivity) mapPageActivity).appLifeCycleObserver = this.appLifeCycleObserverProvider.get();
        BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(mapPageActivity, DoubleCheck.MyBillsEntityDataFactory(this.connectionStatusReceiverProvider));
        BaseActivity_MembersInjector.MyBillsEntityDataFactory(mapPageActivity, DoubleCheck.MyBillsEntityDataFactory(this.featureConfigRepositoryProvider));
        injectPresenter(mapPageActivity, this.presenterProvider.get());
    }

    public static void injectPresenter(MapPageActivity mapPageActivity, MapPageContract.Presenter presenter) {
        mapPageActivity.presenter = presenter;
    }
}
