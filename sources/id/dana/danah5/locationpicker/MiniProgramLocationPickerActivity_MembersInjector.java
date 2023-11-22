package id.dana.danah5.locationpicker;

import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.base.BaseActivity;
import id.dana.base.BaseActivity_MembersInjector;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.utils.MapHelper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class MiniProgramLocationPickerActivity_MembersInjector implements MembersInjector<MiniProgramLocationPickerActivity> {
    private final Provider<AppLifeCycleObserver> appLifeCycleObserverProvider;
    private final Provider<ConnectionStatusReceiver> connectionStatusReceiverProvider;
    private final Provider<FeatureConfigRepository> featureConfigRepositoryProvider;
    private final Provider<MapHelper> mapHelperProvider;
    private final Provider<NearbyMerchantLocationSearchPresenter> presenterProvider;

    public MiniProgramLocationPickerActivity_MembersInjector(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<NearbyMerchantLocationSearchPresenter> provider4, Provider<MapHelper> provider5) {
        this.appLifeCycleObserverProvider = provider;
        this.connectionStatusReceiverProvider = provider2;
        this.featureConfigRepositoryProvider = provider3;
        this.presenterProvider = provider4;
        this.mapHelperProvider = provider5;
    }

    public static MembersInjector<MiniProgramLocationPickerActivity> create(Provider<AppLifeCycleObserver> provider, Provider<ConnectionStatusReceiver> provider2, Provider<FeatureConfigRepository> provider3, Provider<NearbyMerchantLocationSearchPresenter> provider4, Provider<MapHelper> provider5) {
        return new MiniProgramLocationPickerActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public final void injectMembers(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity) {
        ((BaseActivity) miniProgramLocationPickerActivity).appLifeCycleObserver = this.appLifeCycleObserverProvider.get();
        BaseActivity_MembersInjector.BuiltInFictitiousFunctionClassFactory(miniProgramLocationPickerActivity, DoubleCheck.MyBillsEntityDataFactory(this.connectionStatusReceiverProvider));
        BaseActivity_MembersInjector.MyBillsEntityDataFactory(miniProgramLocationPickerActivity, DoubleCheck.MyBillsEntityDataFactory(this.featureConfigRepositoryProvider));
        injectPresenter(miniProgramLocationPickerActivity, this.presenterProvider.get());
        injectMapHelper(miniProgramLocationPickerActivity, this.mapHelperProvider.get());
    }

    public static void injectPresenter(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter) {
        miniProgramLocationPickerActivity.presenter = nearbyMerchantLocationSearchPresenter;
    }

    public static void injectMapHelper(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, MapHelper mapHelper) {
        miniProgramLocationPickerActivity.mapHelper = mapHelper;
    }
}
