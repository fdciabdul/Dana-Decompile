package id.dana.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.feeds.ui.tracker.FriendshipMixpanelTracker;
import id.dana.myprofile.SettingMoreContract;
import id.dana.myprofile.SettingMorePresenter;

@Module
/* loaded from: classes4.dex */
public class SubMenuModule {
    private SettingMoreContract.View BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SettingMoreContract.Presenter BuiltInFictitiousFunctionClassFactory(SettingMorePresenter settingMorePresenter) {
        return settingMorePresenter;
    }

    public SubMenuModule(SettingMoreContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SettingMoreContract.View getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public FriendshipAnalyticTracker PlaceComponentResult(Context context) {
        return new FriendshipMixpanelTracker(context);
    }
}
