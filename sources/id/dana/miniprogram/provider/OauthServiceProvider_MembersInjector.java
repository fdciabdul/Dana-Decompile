package id.dana.miniprogram.provider;

import dagger.MembersInjector;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.useragreement.interactor.BuildAgreementContent;
import id.dana.domain.useragreement.interactor.BuildIncompleteUserDataContent;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.RecordAgreement;

/* loaded from: classes5.dex */
public final class OauthServiceProvider_MembersInjector implements MembersInjector<OauthServiceProvider> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider oauthServiceProvider, MiniProgramPreference miniProgramPreference) {
        oauthServiceProvider.miniProgramPreference = miniProgramPreference;
    }

    public static void PlaceComponentResult(OauthServiceProvider oauthServiceProvider, RemoteGnPaymentEntityData remoteGnPaymentEntityData) {
        oauthServiceProvider.remoteGnPaymentEntityData = remoteGnPaymentEntityData;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider oauthServiceProvider, GetEmptyUserInfo getEmptyUserInfo) {
        oauthServiceProvider.checkUserInfo = getEmptyUserInfo;
    }

    public static void getAuthRequestContext(OauthServiceProvider oauthServiceProvider, ConsultAgreement consultAgreement) {
        oauthServiceProvider.consultAgreement = consultAgreement;
    }

    public static void getAuthRequestContext(OauthServiceProvider oauthServiceProvider, RecordAgreement recordAgreement) {
        oauthServiceProvider.recordAgreement = recordAgreement;
    }

    public static void MyBillsEntityDataFactory(OauthServiceProvider oauthServiceProvider, GetAuthCode getAuthCode) {
        oauthServiceProvider.getAuthCode = getAuthCode;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(OauthServiceProvider oauthServiceProvider, SplitFacade splitFacade) {
        oauthServiceProvider.splitFacade = splitFacade;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OauthServiceProvider oauthServiceProvider, BuildIncompleteUserDataContent buildIncompleteUserDataContent) {
        oauthServiceProvider.buildIncompleteUserDataContent = buildIncompleteUserDataContent;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OauthServiceProvider oauthServiceProvider, BuildAgreementContent buildAgreementContent) {
        oauthServiceProvider.buildAgreementContent = buildAgreementContent;
    }
}
