package id.dana.myprofile;

import dagger.MembersInjector;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.staticqr.GetStaticQrContract;

/* loaded from: classes5.dex */
public final class ProfileQrisDialogActivity_MembersInjector implements MembersInjector<ProfileQrisDialogActivity> {
    public static void PlaceComponentResult(ProfileQrisDialogActivity profileQrisDialogActivity, GetStaticQrContract.Presenter presenter) {
        profileQrisDialogActivity.getStaticQrPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ProfileQrisDialogActivity profileQrisDialogActivity, GenerateDeepLinkContract.ProfilePresenter profilePresenter) {
        profileQrisDialogActivity.profileQrDeepLinkPresenter = profilePresenter;
    }
}
