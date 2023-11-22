package id.dana.sendmoney.data.repository.groupsend.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LocalGroupSendEntityData_Factory implements Factory<LocalGroupSendEntityData> {
    private final Provider<GroupSendPreference> KClassImpl$Data$declaredNonStaticMembers$2;

    private LocalGroupSendEntityData_Factory(Provider<GroupSendPreference> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static LocalGroupSendEntityData_Factory PlaceComponentResult(Provider<GroupSendPreference> provider) {
        return new LocalGroupSendEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalGroupSendEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
