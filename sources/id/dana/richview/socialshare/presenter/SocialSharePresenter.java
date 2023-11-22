package id.dana.richview.socialshare.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.socialshare.interactor.GetSocialMediaCategoryShare;
import id.dana.richview.socialshare.SocialShareContract;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SocialSharePresenter implements SocialShareContract.Presenter {
    GetSocialMediaCategoryShare BuiltInFictitiousFunctionClassFactory;
    SocialShareContract.View PlaceComponentResult;

    @Inject
    public SocialSharePresenter(GetSocialMediaCategoryShare getSocialMediaCategoryShare, SocialShareContract.View view) {
        this.BuiltInFictitiousFunctionClassFactory = getSocialMediaCategoryShare;
        this.PlaceComponentResult = view;
    }

    @Override // id.dana.richview.socialshare.SocialShareContract.Presenter
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<List<String>>() { // from class: id.dana.richview.socialshare.presenter.SocialSharePresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SocialSharePresenter.this.PlaceComponentResult.onSuccessGetSocialMediaCategoryShare((List) obj);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
