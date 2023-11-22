package id.dana;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.utils.session.SessionExpiredManager;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DanaLocalBroadcastReceiver_Factory implements Factory<DanaLocalBroadcastReceiver> {
    private final Provider<DeviceInformationProvider> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SessionExpiredManager> MyBillsEntityDataFactory;
    private final Provider<QueryPayMethod> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaLocalBroadcastReceiver(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory));
    }
}
