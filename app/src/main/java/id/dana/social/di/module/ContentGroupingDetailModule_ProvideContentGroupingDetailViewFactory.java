package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.ContentGroupingDetailContract;

/* loaded from: classes5.dex */
public final class ContentGroupingDetailModule_ProvideContentGroupingDetailViewFactory implements Factory<ContentGroupingDetailContract.View> {
    private final ContentGroupingDetailModule getAuthRequestContext;

    public static ContentGroupingDetailContract.View KClassImpl$Data$declaredNonStaticMembers$2(ContentGroupingDetailModule contentGroupingDetailModule) {
        return (ContentGroupingDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(contentGroupingDetailModule.getGetAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ContentGroupingDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
