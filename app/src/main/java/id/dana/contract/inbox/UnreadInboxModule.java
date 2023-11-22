package id.dana.contract.inbox;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.inbox.UnreadInboxContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class UnreadInboxModule {
    private final UnreadInboxContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public UnreadInboxContract.Presenter BuiltInFictitiousFunctionClassFactory(UnreadInboxPresenter unreadInboxPresenter) {
        return unreadInboxPresenter;
    }

    public UnreadInboxModule(UnreadInboxContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public UnreadInboxContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
