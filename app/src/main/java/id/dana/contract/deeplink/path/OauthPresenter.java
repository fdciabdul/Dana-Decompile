package id.dana.contract.deeplink.path;

import android.text.TextUtils;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.contract.deeplink.path.OauthPresenter;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetNickname;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.deeplink.model.OauthParams;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.oauth.mapper.OauthParamsModelMapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class OauthPresenter implements OauthContract.Presenter {
    final String BuiltInFictitiousFunctionClassFactory = "OauthPresenter";
    final GetUserInfoWithKyc KClassImpl$Data$declaredNonStaticMembers$2;
    GetWhitelistedSubMerchantId MyBillsEntityDataFactory;
    GetAddingNameWhitelistedMerchantId PlaceComponentResult;
    final OauthContract.View getAuthRequestContext;
    private final GetKycLevel getErrorConfigVersion;
    private final OauthParamsModelMapper moveToNextValue;
    private final GetNickname scheduleImpl;

    /* loaded from: classes4.dex */
    public interface AddingNameSubMerchantIdListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface GetKycStatusCallback {
        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface GetNicknameCallback {
        void PlaceComponentResult(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface WhitelistedSubMerchantIdListener {
        void MyBillsEntityDataFactory();

        void PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public OauthPresenter(OauthContract.View view, OauthParamsModelMapper oauthParamsModelMapper, GetKycLevel getKycLevel, GetUserInfoWithKyc getUserInfoWithKyc, GetNickname getNickname) {
        this.getAuthRequestContext = view;
        this.moveToNextValue = oauthParamsModelMapper;
        this.getErrorConfigVersion = getKycLevel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getUserInfoWithKyc;
        this.scheduleImpl = getNickname;
    }

    @Override // id.dana.contract.deeplink.path.OauthContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(OauthParams oauthParams) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(this.moveToNextValue.apply(oauthParams));
    }

    @Override // id.dana.contract.deeplink.path.OauthContract.Presenter
    public final void MyBillsEntityDataFactory(final GetKycStatusCallback getKycStatusCallback) {
        this.getErrorConfigVersion.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.OauthPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                getKycStatusCallback.MyBillsEntityDataFactory(((String) obj).equals("KYC2"));
                return null;
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.OauthPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final OauthPresenter oauthPresenter = OauthPresenter.this;
                final OauthPresenter.GetKycStatusCallback getKycStatusCallback2 = getKycStatusCallback;
                Throwable th = (Throwable) obj;
                oauthPresenter.getAuthRequestContext.showProgress();
                oauthPresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<UserInfoResponse>() { // from class: id.dana.contract.deeplink.path.OauthPresenter.1
                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public /* synthetic */ void onNext(Object obj2) {
                        UserInfoResponse userInfoResponse = (UserInfoResponse) obj2;
                        if (userInfoResponse.getKycInfo() != null) {
                            getKycStatusCallback2.MyBillsEntityDataFactory(OauthPresenter.KClassImpl$Data$declaredNonStaticMembers$2(userInfoResponse.getKycInfo()));
                        }
                        OauthPresenter.this.getAuthRequestContext.dismissProgress();
                    }

                    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                    public void onError(Throwable th2) {
                        getKycStatusCallback2.PlaceComponentResult();
                        OauthPresenter.this.getAuthRequestContext.dismissProgress();
                    }
                }, GetUserInfoWithKyc.Params.forParams(true));
                return null;
            }
        });
    }

    @Override // id.dana.contract.deeplink.path.OauthContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final GetNicknameCallback getNicknameCallback) {
        this.scheduleImpl.execute(new DefaultObserver<String>() { // from class: id.dana.contract.deeplink.path.OauthPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                getNicknameCallback.PlaceComponentResult(OauthPresenter.PlaceComponentResult((String) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                getNicknameCallback.PlaceComponentResult(false);
                DanaLog.BuiltInFictitiousFunctionClassFactory(OauthPresenter.this.BuiltInFictitiousFunctionClassFactory, th.getMessage());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onComplete() {
                OauthPresenter.this.scheduleImpl.dispose();
            }
        });
    }

    @Override // id.dana.contract.deeplink.path.OauthContract.Presenter
    public final void getAuthRequestContext(final String str, final WhitelistedSubMerchantIdListener whitelistedSubMerchantIdListener) {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.OauthPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OauthPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str, whitelistedSubMerchantIdListener, (List) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.OauthPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                OauthPresenter oauthPresenter = OauthPresenter.this;
                whitelistedSubMerchantIdListener.MyBillsEntityDataFactory();
                DanaLog.BuiltInFictitiousFunctionClassFactory(oauthPresenter.BuiltInFictitiousFunctionClassFactory, ((Throwable) obj).getMessage());
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(String str, WhitelistedSubMerchantIdListener whitelistedSubMerchantIdListener, List list) {
        if (list.contains(str)) {
            whitelistedSubMerchantIdListener.PlaceComponentResult();
            return null;
        }
        whitelistedSubMerchantIdListener.MyBillsEntityDataFactory();
        return null;
    }

    @Override // id.dana.contract.deeplink.path.OauthContract.Presenter
    public final void getAuthRequestContext(final String str, final AddingNameSubMerchantIdListener addingNameSubMerchantIdListener) {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.deeplink.path.OauthPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OauthPresenter.getAuthRequestContext(str, addingNameSubMerchantIdListener, (Set) obj);
            }
        }, new Function1() { // from class: id.dana.contract.deeplink.path.OauthPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                OauthPresenter oauthPresenter = OauthPresenter.this;
                addingNameSubMerchantIdListener.PlaceComponentResult();
                DanaLog.BuiltInFictitiousFunctionClassFactory(oauthPresenter.BuiltInFictitiousFunctionClassFactory, ((Throwable) obj).getMessage());
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit getAuthRequestContext(String str, AddingNameSubMerchantIdListener addingNameSubMerchantIdListener, Set set) {
        if (set.contains(str)) {
            addingNameSubMerchantIdListener.KClassImpl$Data$declaredNonStaticMembers$2();
            return null;
        }
        addingNameSubMerchantIdListener.PlaceComponentResult();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return str.equals("KYC2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !str.matches("^(\\+62|62|0)?8[0-9]*$");
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.scheduleImpl.dispose();
        this.getErrorConfigVersion.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.PlaceComponentResult.dispose();
    }
}
