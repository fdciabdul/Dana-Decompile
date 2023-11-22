package id.dana.danah5.showagreement;

import dagger.MembersInjector;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.services.interactor.GetService;
import id.dana.domain.useragreement.interactor.BuildAgreementContent;
import id.dana.domain.useragreement.interactor.BuildIncompleteUserDataContent;
import id.dana.domain.useragreement.interactor.ConsultAgreement;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import id.dana.domain.useragreement.interactor.RecordAgreement;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ShowAgreementBridge_MembersInjector implements MembersInjector<ShowAgreementBridge> {
    private final Provider<BuildAgreementContent> buildAgreementContentProvider;
    private final Provider<BuildIncompleteUserDataContent> buildIncompleteUserDataContentProvider;
    private final Provider<ConsultAgreement> consultAgreementProvider;
    private final Provider<GetAuthCode> getAuthCodeProvider;
    private final Provider<GetEmptyUserInfo> getEmptyUserInfoProvider;
    private final Provider<GetService> getServiceProvider;
    private final Provider<RecordAgreement> recordAgreementProvider;

    public ShowAgreementBridge_MembersInjector(Provider<GetService> provider, Provider<ConsultAgreement> provider2, Provider<RecordAgreement> provider3, Provider<GetEmptyUserInfo> provider4, Provider<GetAuthCode> provider5, Provider<BuildIncompleteUserDataContent> provider6, Provider<BuildAgreementContent> provider7) {
        this.getServiceProvider = provider;
        this.consultAgreementProvider = provider2;
        this.recordAgreementProvider = provider3;
        this.getEmptyUserInfoProvider = provider4;
        this.getAuthCodeProvider = provider5;
        this.buildIncompleteUserDataContentProvider = provider6;
        this.buildAgreementContentProvider = provider7;
    }

    public static MembersInjector<ShowAgreementBridge> create(Provider<GetService> provider, Provider<ConsultAgreement> provider2, Provider<RecordAgreement> provider3, Provider<GetEmptyUserInfo> provider4, Provider<GetAuthCode> provider5, Provider<BuildIncompleteUserDataContent> provider6, Provider<BuildAgreementContent> provider7) {
        return new ShowAgreementBridge_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public final void injectMembers(ShowAgreementBridge showAgreementBridge) {
        injectGetService(showAgreementBridge, this.getServiceProvider.get());
        injectConsultAgreement(showAgreementBridge, this.consultAgreementProvider.get());
        injectRecordAgreement(showAgreementBridge, this.recordAgreementProvider.get());
        injectGetEmptyUserInfo(showAgreementBridge, this.getEmptyUserInfoProvider.get());
        injectGetAuthCode(showAgreementBridge, this.getAuthCodeProvider.get());
        injectBuildIncompleteUserDataContent(showAgreementBridge, this.buildIncompleteUserDataContentProvider.get());
        injectBuildAgreementContent(showAgreementBridge, this.buildAgreementContentProvider.get());
    }

    public static void injectGetService(ShowAgreementBridge showAgreementBridge, GetService getService) {
        showAgreementBridge.getService = getService;
    }

    public static void injectConsultAgreement(ShowAgreementBridge showAgreementBridge, ConsultAgreement consultAgreement) {
        showAgreementBridge.consultAgreement = consultAgreement;
    }

    public static void injectRecordAgreement(ShowAgreementBridge showAgreementBridge, RecordAgreement recordAgreement) {
        showAgreementBridge.recordAgreement = recordAgreement;
    }

    public static void injectGetEmptyUserInfo(ShowAgreementBridge showAgreementBridge, GetEmptyUserInfo getEmptyUserInfo) {
        showAgreementBridge.getEmptyUserInfo = getEmptyUserInfo;
    }

    public static void injectGetAuthCode(ShowAgreementBridge showAgreementBridge, GetAuthCode getAuthCode) {
        showAgreementBridge.getAuthCode = getAuthCode;
    }

    public static void injectBuildIncompleteUserDataContent(ShowAgreementBridge showAgreementBridge, BuildIncompleteUserDataContent buildIncompleteUserDataContent) {
        showAgreementBridge.buildIncompleteUserDataContent = buildIncompleteUserDataContent;
    }

    public static void injectBuildAgreementContent(ShowAgreementBridge showAgreementBridge, BuildAgreementContent buildAgreementContent) {
        showAgreementBridge.buildAgreementContent = buildAgreementContent;
    }
}
