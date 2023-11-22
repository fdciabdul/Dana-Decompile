package id.dana.sendmoney.recipient.recent;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;

/* loaded from: classes5.dex */
public final class RecentRecipientModule_ProvideViewFactory implements Factory<RecentRecipientContract.View> {
    private final RecentRecipientModule MyBillsEntityDataFactory;

    private RecentRecipientModule_ProvideViewFactory(RecentRecipientModule recentRecipientModule) {
        this.MyBillsEntityDataFactory = recentRecipientModule;
    }

    public static RecentRecipientModule_ProvideViewFactory MyBillsEntityDataFactory(RecentRecipientModule recentRecipientModule) {
        return new RecentRecipientModule_ProvideViewFactory(recentRecipientModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (RecentRecipientContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2());
    }
}
