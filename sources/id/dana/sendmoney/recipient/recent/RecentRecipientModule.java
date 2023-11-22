package id.dana.sendmoney.recipient.recent;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;

@Module
/* loaded from: classes5.dex */
public class RecentRecipientModule {
    private final RecentRecipientContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RecentRecipientContract.Presenter BuiltInFictitiousFunctionClassFactory(RecentRecipientPresenter recentRecipientPresenter) {
        return recentRecipientPresenter;
    }

    public RecentRecipientModule(RecentRecipientContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RecentRecipientContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
