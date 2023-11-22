package id.dana.contract.user;

import id.dana.contract.user.GetProfilePictureContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.UploadAvatar;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes8.dex */
public class GetProfilePicturePresenter implements GetProfilePictureContract.Presenter {
    private final GetProfilePictureContract.View BuiltInFictitiousFunctionClassFactory;
    private final UploadAvatar KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetAvatarUrl getAuthRequestContext;

    @Inject
    public GetProfilePicturePresenter(GetProfilePictureContract.View view, GetAvatarUrl getAvatarUrl, UploadAvatar uploadAvatar) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.getAuthRequestContext = getAvatarUrl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uploadAvatar;
    }

    /* renamed from: id.dana.contract.user.GetProfilePicturePresenter$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass1 extends DefaultObserver<String> {
        final /* synthetic */ GetProfilePicturePresenter KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            String str = (String) obj;
            GetProfilePictureContract.View unused = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.onError(th.getMessage());
        }
    }

    /* renamed from: id.dana.contract.user.GetProfilePicturePresenter$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass2 extends DefaultObserver<String> {
        final /* synthetic */ GetProfilePicturePresenter KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            String str = (String) obj;
            GetProfilePictureContract.View unused = this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.onError(th.getMessage());
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
