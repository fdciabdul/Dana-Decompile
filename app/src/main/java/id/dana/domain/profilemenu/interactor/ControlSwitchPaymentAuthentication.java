package id.dana.domain.profilemenu.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.model.PaymentSecuritySwitch;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ControlSwitchPaymentAuthentication extends UseCase<PaymentSecuritySwitch, Params> {
    private final SettingRepository settingRepository;

    @Inject
    public ControlSwitchPaymentAuthentication(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SettingRepository settingRepository) {
        super(threadExecutor, postExecutionThread);
        this.settingRepository = settingRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<PaymentSecuritySwitch> buildUseCaseObservable(Params params) {
        return this.settingRepository.getPaymentSecuritySwitch(params.authenticationStatus, params.authenticationType, params.securityId, params.pin, params.pubKey);
    }

    /* loaded from: classes4.dex */
    public static class Params {
        boolean authenticationStatus;
        String authenticationType;
        String pin;
        String pubKey;
        String securityId;

        private Params(boolean z, String str, String str2, String str3, String str4) {
            this.authenticationStatus = z;
            this.securityId = str2;
            this.authenticationType = str;
            this.pin = str3;
            this.pubKey = str4;
        }

        public static Params forPaymentSecuritySwitchOn(boolean z, String str) {
            return new Params(z, str, null, "", "");
        }

        public static Params forPaymentSecuritySwitchOff(boolean z, String str, String str2, String str3, String str4) {
            return new Params(z, str2, str3, str, str4);
        }
    }
}
