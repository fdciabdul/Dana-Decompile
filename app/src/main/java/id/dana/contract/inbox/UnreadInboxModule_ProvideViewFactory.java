package id.dana.contract.inbox;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.inbox.UnreadInboxContract;

/* loaded from: classes4.dex */
public final class UnreadInboxModule_ProvideViewFactory implements Factory<UnreadInboxContract.View> {
    private final UnreadInboxModule KClassImpl$Data$declaredNonStaticMembers$2;

    private UnreadInboxModule_ProvideViewFactory(UnreadInboxModule unreadInboxModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = unreadInboxModule;
    }

    public static UnreadInboxModule_ProvideViewFactory PlaceComponentResult(UnreadInboxModule unreadInboxModule) {
        return new UnreadInboxModule_ProvideViewFactory(unreadInboxModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UnreadInboxContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
