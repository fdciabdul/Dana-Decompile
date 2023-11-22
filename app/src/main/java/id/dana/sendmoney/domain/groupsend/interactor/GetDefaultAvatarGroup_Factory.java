package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetDefaultAvatarGroup_Factory implements Factory<GetDefaultAvatarGroup> {
    private final Provider<GroupSendRepository> getAuthRequestContext;

    private GetDefaultAvatarGroup_Factory(Provider<GroupSendRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetDefaultAvatarGroup_Factory BuiltInFictitiousFunctionClassFactory(Provider<GroupSendRepository> provider) {
        return new GetDefaultAvatarGroup_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetDefaultAvatarGroup(this.getAuthRequestContext.get());
    }
}
