package id.dana.data.foundation.facade;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.utils.config.DeviceInformation;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApSecurityFacade_Factory implements Factory<ApSecurityFacade> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<DeviceInformation> MyBillsEntityDataFactory;

    private ApSecurityFacade_Factory(Provider<Context> provider, Provider<DeviceInformation> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static ApSecurityFacade_Factory PlaceComponentResult(Provider<Context> provider, Provider<DeviceInformation> provider2) {
        return new ApSecurityFacade_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ApSecurityFacade(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
