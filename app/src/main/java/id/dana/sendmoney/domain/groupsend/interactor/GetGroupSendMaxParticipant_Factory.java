package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetGroupSendMaxParticipant_Factory implements Factory<GetGroupSendMaxParticipant> {
    private final Provider<GroupSendRepository> PlaceComponentResult;

    private GetGroupSendMaxParticipant_Factory(Provider<GroupSendRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetGroupSendMaxParticipant_Factory PlaceComponentResult(Provider<GroupSendRepository> provider) {
        return new GetGroupSendMaxParticipant_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetGroupSendMaxParticipant(this.PlaceComponentResult.get());
    }
}
