package id.dana.base;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.AppLifeCycleObserver;
import id.dana.ConnectionStatusReceiver;
import id.dana.domain.featureconfig.FeatureConfigRepository;

/* loaded from: classes.dex */
public final class BaseActivity_MembersInjector implements MembersInjector<BaseActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(BaseActivity baseActivity, AppLifeCycleObserver appLifeCycleObserver) {
        baseActivity.appLifeCycleObserver = appLifeCycleObserver;
    }

    public static void BuiltInFictitiousFunctionClassFactory(BaseActivity baseActivity, Lazy<ConnectionStatusReceiver> lazy) {
        baseActivity.connectionStatusReceiver = lazy;
    }

    public static void MyBillsEntityDataFactory(BaseActivity baseActivity, Lazy<FeatureConfigRepository> lazy) {
        baseActivity.featureConfigRepository = lazy;
    }
}
