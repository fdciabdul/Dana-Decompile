package id.dana.oauth.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.userprofileinfo.interactor.CheckSkipButtonMerchantList;
import id.dana.domain.userprofileinfo.interactor.UpdateNicknameProfile;
import id.dana.domain.userprofileinfo.response.UserProfileInfoResponse;
import id.dana.oauth.InputNameContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000b\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/oauth/presenter/InputNamePresenter;", "Lid/dana/oauth/InputNameContract$Presenter;", "", "PlaceComponentResult", "()V", "onDestroy", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/domain/userprofileinfo/interactor/CheckSkipButtonMerchantList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/userprofileinfo/interactor/CheckSkipButtonMerchantList;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "Lid/dana/domain/user/interactor/GetUserInfoWithKyc;", "getAuthRequestContext", "Ljava/lang/String;", "Lid/dana/domain/userprofileinfo/interactor/UpdateNicknameProfile;", "Lid/dana/domain/userprofileinfo/interactor/UpdateNicknameProfile;", "Lid/dana/oauth/InputNameContract$View;", "MyBillsEntityDataFactory", "Lid/dana/oauth/InputNameContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/oauth/InputNameContract$View;Lid/dana/domain/userprofileinfo/interactor/UpdateNicknameProfile;Lid/dana/domain/user/interactor/GetUserInfoWithKyc;Lid/dana/domain/userprofileinfo/interactor/CheckSkipButtonMerchantList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputNamePresenter implements InputNameContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final UpdateNicknameProfile KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CheckSkipButtonMerchantList BuiltInFictitiousFunctionClassFactory;
    private final InputNameContract.View MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final GetUserInfoWithKyc getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    @Inject
    public InputNamePresenter(InputNameContract.View view, UpdateNicknameProfile updateNicknameProfile, GetUserInfoWithKyc getUserInfoWithKyc, CheckSkipButtonMerchantList checkSkipButtonMerchantList) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(updateNicknameProfile, "");
        Intrinsics.checkNotNullParameter(getUserInfoWithKyc, "");
        Intrinsics.checkNotNullParameter(checkSkipButtonMerchantList, "");
        this.MyBillsEntityDataFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = updateNicknameProfile;
        this.getAuthRequestContext = getUserInfoWithKyc;
        this.BuiltInFictitiousFunctionClassFactory = checkSkipButtonMerchantList;
        this.PlaceComponentResult = Reflection.getOrCreateKotlinClass(InputNamePresenter.class).getSimpleName();
    }

    @Override // id.dana.oauth.InputNameContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new UpdateNicknameProfile.Params(p0), new Function1<UserProfileInfoResponse, Unit>() { // from class: id.dana.oauth.presenter.InputNamePresenter$updateName$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserProfileInfoResponse userProfileInfoResponse) {
                invoke2(userProfileInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserProfileInfoResponse userProfileInfoResponse) {
                Intrinsics.checkNotNullParameter(userProfileInfoResponse, "");
                final InputNamePresenter inputNamePresenter = InputNamePresenter.this;
                inputNamePresenter.getAuthRequestContext.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.oauth.presenter.InputNamePresenter$getUserInfo$1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final /* synthetic */ void onNext(Object obj) {
                        GetUserInfoWithKyc getUserInfoWithKyc;
                        Intrinsics.checkNotNullParameter((UserInfoResponse) obj, "");
                        InputNamePresenter.PlaceComponentResult(InputNamePresenter.this, true);
                        getUserInfoWithKyc = InputNamePresenter.this.getAuthRequestContext;
                        getUserInfoWithKyc.dispose();
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public final void onError(Throwable p02) {
                        Intrinsics.checkNotNullParameter(p02, "");
                        InputNamePresenter.PlaceComponentResult(InputNamePresenter.this, false);
                    }
                }, GetUserInfoWithKyc.Params.forParams(true));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.oauth.presenter.InputNamePresenter$updateName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                InputNamePresenter.BuiltInFictitiousFunctionClassFactory(InputNamePresenter.this, th.getMessage());
            }
        });
    }

    @Override // id.dana.oauth.InputNameContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Set<? extends String>, Unit>() { // from class: id.dana.oauth.presenter.InputNamePresenter$checkSkipButtonFeature$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Set<? extends String> set) {
                invoke2((Set<String>) set);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Set<String> set) {
                InputNameContract.View view;
                Intrinsics.checkNotNullParameter(set, "");
                view = InputNamePresenter.this.MyBillsEntityDataFactory;
                view.onCheckSkipButtonMerchantList(set);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.oauth.presenter.InputNamePresenter$checkSkipButtonFeature$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String str;
                InputNameContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                str = InputNamePresenter.this.PlaceComponentResult;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
                view = InputNamePresenter.this.MyBillsEntityDataFactory;
                view.onError(th.getMessage());
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(InputNamePresenter inputNamePresenter, String str) {
        inputNamePresenter.MyBillsEntityDataFactory.dismissProgress();
        inputNamePresenter.MyBillsEntityDataFactory.onUpdateNameFailed(str);
    }

    public static final /* synthetic */ void PlaceComponentResult(InputNamePresenter inputNamePresenter, boolean z) {
        inputNamePresenter.MyBillsEntityDataFactory.dismissProgress();
        inputNamePresenter.MyBillsEntityDataFactory.onUpdateNameSuccess(z);
    }
}
