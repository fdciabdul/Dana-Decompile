package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveDefaultAvatarGroup_Factory implements Factory<SaveDefaultAvatarGroup> {
    private final Provider<GroupSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private SaveDefaultAvatarGroup_Factory(Provider<GroupSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SaveDefaultAvatarGroup_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GroupSendRepository> provider) {
        return new SaveDefaultAvatarGroup_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveDefaultAvatarGroup(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
