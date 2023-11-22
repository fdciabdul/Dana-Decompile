package id.dana.contract.user;

import dagger.internal.Factory;
import id.dana.contract.user.GetProfilePictureContract;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.UploadAvatar;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetProfilePicturePresenter_Factory implements Factory<GetProfilePicturePresenter> {
    private final Provider<UploadAvatar> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetProfilePictureContract.View> MyBillsEntityDataFactory;
    private final Provider<GetAvatarUrl> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetProfilePicturePresenter(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
