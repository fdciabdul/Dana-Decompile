package id.dana.familyaccount.contract;

import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.familyaccount.interactor.ActivateFamilyAccount;
import id.dana.domain.familyaccount.model.CreateFamilyAccountResult;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.familyaccount.contract.FamilyActivationContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\u0005\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/familyaccount/contract/FamilyActivationPresenter;", "Lid/dana/familyaccount/contract/FamilyActivationContract$Presenter;", "Lid/dana/domain/user/UserInfoResponse;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/user/UserInfoResponse;Ljava/lang/String;)V", "()V", "onDestroy", "Lid/dana/domain/familyaccount/interactor/ActivateFamilyAccount;", "Lid/dana/domain/familyaccount/interactor/ActivateFamilyAccount;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "getAuthRequestContext", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/familyaccount/contract/FamilyActivationContract$View;", "PlaceComponentResult", "Lid/dana/familyaccount/contract/FamilyActivationContract$View;", "MyBillsEntityDataFactory", "p2", "p3", "<init>", "(Lid/dana/familyaccount/contract/FamilyActivationContract$View;Lid/dana/domain/user/interactor/GetUserInfo;Lid/dana/domain/account/interactor/GetPhoneNumber;Lid/dana/domain/familyaccount/interactor/ActivateFamilyAccount;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyActivationPresenter implements FamilyActivationContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetUserInfo KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ActivateFamilyAccount BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FamilyActivationContract.View MyBillsEntityDataFactory;
    private final GetPhoneNumber getAuthRequestContext;

    @Inject
    public FamilyActivationPresenter(FamilyActivationContract.View view, GetUserInfo getUserInfo, GetPhoneNumber getPhoneNumber, ActivateFamilyAccount activateFamilyAccount) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        Intrinsics.checkNotNullParameter(getPhoneNumber, "");
        Intrinsics.checkNotNullParameter(activateFamilyAccount, "");
        this.MyBillsEntityDataFactory = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getUserInfo;
        this.getAuthRequestContext = getPhoneNumber;
        this.BuiltInFictitiousFunctionClassFactory = activateFamilyAccount;
    }

    @Override // id.dana.familyaccount.contract.FamilyActivationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.familyaccount.contract.FamilyActivationPresenter$checkKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                GetUserInfo getUserInfo;
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                FamilyActivationPresenter.BuiltInFictitiousFunctionClassFactory(FamilyActivationPresenter.this, userInfoResponse);
                getUserInfo = FamilyActivationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                getUserInfo.dispose();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyActivationPresenter$checkKycLevel$2
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
                FamilyActivationContract.View view;
                GetUserInfo getUserInfo;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, th.toString());
                view = FamilyActivationPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                getUserInfo = FamilyActivationPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                getUserInfo.dispose();
            }
        });
    }

    @Override // id.dana.familyaccount.contract.FamilyActivationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final UserInfoResponse p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<CreateFamilyAccountResult, Unit>() { // from class: id.dana.familyaccount.contract.FamilyActivationPresenter$activateFamilyAccount$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CreateFamilyAccountResult createFamilyAccountResult) {
                invoke2(createFamilyAccountResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CreateFamilyAccountResult createFamilyAccountResult) {
                FamilyActivationContract.View view;
                FamilyActivationContract.View view2;
                Intrinsics.checkNotNullParameter(createFamilyAccountResult, "");
                view = FamilyActivationPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = FamilyActivationPresenter.this.MyBillsEntityDataFactory;
                view2.getAuthRequestContext(p0, p1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.familyaccount.contract.FamilyActivationPresenter$activateFamilyAccount$2
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
                FamilyActivationContract.View view;
                FamilyActivationContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FamilyActivationPresenter.this.MyBillsEntityDataFactory;
                view.dismissProgress();
                view2 = FamilyActivationPresenter.this.MyBillsEntityDataFactory;
                view2.PlaceComponentResult(String.valueOf(th.getMessage()));
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final FamilyActivationPresenter familyActivationPresenter, final UserInfoResponse userInfoResponse) {
        if (StringsKt.equals$default(userInfoResponse.getKycInfo(), "KYC2", false, 2, null)) {
            Intrinsics.checkNotNullParameter(userInfoResponse, "");
            familyActivationPresenter.MyBillsEntityDataFactory.showProgress();
            familyActivationPresenter.getAuthRequestContext.execute(new DefaultObserver<String>() { // from class: id.dana.familyaccount.contract.FamilyActivationPresenter$getPhoneNumber$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    FamilyActivationContract.View view;
                    GetPhoneNumber getPhoneNumber;
                    String str = (String) obj;
                    Intrinsics.checkNotNullParameter(str, "");
                    view = FamilyActivationPresenter.this.MyBillsEntityDataFactory;
                    view.PlaceComponentResult(userInfoResponse, str);
                    getPhoneNumber = FamilyActivationPresenter.this.getAuthRequestContext;
                    getPhoneNumber.dispose();
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable p0) {
                    FamilyActivationContract.View view;
                    GetPhoneNumber getPhoneNumber;
                    Intrinsics.checkNotNullParameter(p0, "");
                    view = FamilyActivationPresenter.this.MyBillsEntityDataFactory;
                    view.dismissProgress();
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, p0.toString());
                    getPhoneNumber = FamilyActivationPresenter.this.getAuthRequestContext;
                    getPhoneNumber.dispose();
                }
            });
            return;
        }
        familyActivationPresenter.MyBillsEntityDataFactory.dismissProgress();
        familyActivationPresenter.MyBillsEntityDataFactory.getAuthRequestContext();
    }
}
