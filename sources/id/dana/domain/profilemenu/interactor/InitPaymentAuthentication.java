package id.dana.domain.profilemenu.interactor;

import id.dana.domain.PostExecutionThread;
import id.dana.domain.UseCase;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.profilemenu.model.PaymentSecurityInit;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class InitPaymentAuthentication extends UseCase<PaymentSecurityInit, Void> {
    private final SettingRepository settingRepository;

    @Inject
    public InitPaymentAuthentication(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, SettingRepository settingRepository) {
        super(threadExecutor, postExecutionThread);
        this.settingRepository = settingRepository;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.domain.UseCase
    public Observable<PaymentSecurityInit> buildUseCaseObservable(Void r1) {
        return this.settingRepository.getPaymentSecurityInit();
    }
}
