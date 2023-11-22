package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.SocialWidgetContract;

/* loaded from: classes5.dex */
public final class SocialWidgetModule_ProvideSocialWidgetViewFactory implements Factory<SocialWidgetContract.View> {
    private final SocialWidgetModule getAuthRequestContext;

    private SocialWidgetModule_ProvideSocialWidgetViewFactory(SocialWidgetModule socialWidgetModule) {
        this.getAuthRequestContext = socialWidgetModule;
    }

    public static SocialWidgetModule_ProvideSocialWidgetViewFactory MyBillsEntityDataFactory(SocialWidgetModule socialWidgetModule) {
        return new SocialWidgetModule_ProvideSocialWidgetViewFactory(socialWidgetModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SocialWidgetContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
