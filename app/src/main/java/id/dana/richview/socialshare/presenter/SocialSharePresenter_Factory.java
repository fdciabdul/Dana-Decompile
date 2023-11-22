package id.dana.richview.socialshare.presenter;

import dagger.internal.Factory;
import id.dana.domain.socialshare.interactor.GetSocialMediaCategoryShare;
import id.dana.richview.socialshare.SocialShareContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SocialSharePresenter_Factory implements Factory<SocialSharePresenter> {
    private final Provider<GetSocialMediaCategoryShare> BuiltInFictitiousFunctionClassFactory;
    private final Provider<SocialShareContract.View> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SocialSharePresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
