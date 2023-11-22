package id.dana.data.referral.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.referral.repository.source.local.LocalMyReferralConsultEntityData;
import id.dana.data.referral.repository.source.network.NetworkMyReferralConsultEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class MyReferralConsultEntityDataFactory extends AbstractEntityDataFactory<MyReferralConsultEntityData> {
    private final LocalMyReferralConsultEntityData localMyReferralConsultEntityData;
    private final NetworkMyReferralConsultEntityData networkMyReferralConsultEntityData;

    @Inject
    public MyReferralConsultEntityDataFactory(NetworkMyReferralConsultEntityData networkMyReferralConsultEntityData, LocalMyReferralConsultEntityData localMyReferralConsultEntityData) {
        this.networkMyReferralConsultEntityData = networkMyReferralConsultEntityData;
        this.localMyReferralConsultEntityData = localMyReferralConsultEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public MyReferralConsultEntityData createData2(String str) {
        if (str.equals("local")) {
            return this.localMyReferralConsultEntityData;
        }
        return this.networkMyReferralConsultEntityData;
    }
}
