package id.dana.data.referral.repository.source.local;

import id.dana.data.referral.repository.source.MyReferralConsultEntityData;
import id.dana.data.referral.repository.source.network.result.MyReferralConsultEntityResult;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class LocalMyReferralConsultEntityData implements MyReferralConsultEntityData {
    private final ReferralPreferences referralPreferences;

    @Inject
    public LocalMyReferralConsultEntityData(ReferralPreferences referralPreferences) {
        this.referralPreferences = referralPreferences;
    }

    @Override // id.dana.data.referral.repository.source.MyReferralConsultEntityData
    public Observable<MyReferralConsultEntityResult> getMyReferralConsult() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.referral.repository.source.MyReferralConsultEntityData
    public void saveReferralCode(String str) {
        this.referralPreferences.saveReferralCode(str);
    }

    @Override // id.dana.data.referral.repository.source.MyReferralConsultEntityData
    public Observable<String> getReferralCode() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.referral.repository.source.local.LocalMyReferralConsultEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalMyReferralConsultEntityData.this.m1781x374e06a3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralCode$0$id-dana-data-referral-repository-source-local-LocalMyReferralConsultEntityData  reason: not valid java name */
    public /* synthetic */ String m1781x374e06a3() throws Exception {
        String referralCode = this.referralPreferences.getReferralCode();
        if (referralCode != null) {
            return referralCode;
        }
        throw new CallableReturnNullError("LocalMyReferralConsultEntityData#getReferralCode");
    }
}
