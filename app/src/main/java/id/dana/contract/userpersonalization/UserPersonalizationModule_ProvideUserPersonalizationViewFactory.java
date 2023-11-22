package id.dana.contract.userpersonalization;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.userpersonalization.UserPersonalizationContract;

/* loaded from: classes4.dex */
public final class UserPersonalizationModule_ProvideUserPersonalizationViewFactory implements Factory<UserPersonalizationContract.View> {
    private final UserPersonalizationModule PlaceComponentResult;

    private UserPersonalizationModule_ProvideUserPersonalizationViewFactory(UserPersonalizationModule userPersonalizationModule) {
        this.PlaceComponentResult = userPersonalizationModule;
    }

    public static UserPersonalizationModule_ProvideUserPersonalizationViewFactory BuiltInFictitiousFunctionClassFactory(UserPersonalizationModule userPersonalizationModule) {
        return new UserPersonalizationModule_ProvideUserPersonalizationViewFactory(userPersonalizationModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserPersonalizationContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
