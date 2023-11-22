package id.dana.toggle;

import dagger.internal.Factory;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class TrafficTypeUserProxy_Factory implements Factory<TrafficTypeUserProxy> {
    private final Provider<BaseTrafficType> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<LoginLogoutSubject> MyBillsEntityDataFactory;
    private final Provider<PreferenceAccountEntityData> PlaceComponentResult;
    private final Provider<LoginLogoutObserver> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TrafficTypeUserProxy(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
