package id.dana.richview.socialshare;

import id.dana.base.AbstractContract;
import java.util.List;

/* loaded from: classes5.dex */
public interface SocialShareContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void getAuthRequestContext();
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void onSuccessGetSocialMediaCategoryShare(List<String> list);
    }
}
