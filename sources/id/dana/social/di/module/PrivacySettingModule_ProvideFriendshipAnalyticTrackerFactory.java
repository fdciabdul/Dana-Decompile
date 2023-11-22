package id.dana.social.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PrivacySettingModule_ProvideFriendshipAnalyticTrackerFactory implements Factory<FriendshipAnalyticTracker> {
    private final Provider<Context> MyBillsEntityDataFactory;
    private final PrivacySettingModule getAuthRequestContext;

    private PrivacySettingModule_ProvideFriendshipAnalyticTrackerFactory(PrivacySettingModule privacySettingModule, Provider<Context> provider) {
        this.getAuthRequestContext = privacySettingModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static PrivacySettingModule_ProvideFriendshipAnalyticTrackerFactory PlaceComponentResult(PrivacySettingModule privacySettingModule, Provider<Context> provider) {
        return new PrivacySettingModule_ProvideFriendshipAnalyticTrackerFactory(privacySettingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FriendshipAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
