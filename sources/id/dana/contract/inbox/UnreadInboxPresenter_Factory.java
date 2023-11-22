package id.dana.contract.inbox;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.inbox.UnreadInboxContract;
import id.dana.domain.notificationcenter.interactor.HasNewInbox;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class UnreadInboxPresenter_Factory implements Factory<UnreadInboxPresenter> {
    private final Provider<UnreadInboxContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<HasNewInbox> KClassImpl$Data$declaredNonStaticMembers$2;

    private UnreadInboxPresenter_Factory(Provider<UnreadInboxContract.View> provider, Provider<HasNewInbox> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static UnreadInboxPresenter_Factory PlaceComponentResult(Provider<UnreadInboxContract.View> provider, Provider<HasNewInbox> provider2) {
        return new UnreadInboxPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UnreadInboxPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
