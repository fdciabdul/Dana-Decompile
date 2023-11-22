package id.dana.data.referral.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.referral.source.local.LocalReferralEntityData;
import id.dana.data.referral.source.network.NetworkReferralEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralEntityDataFactory extends AbstractEntityDataFactory<ReferralEntityData> {
    private final LocalReferralEntityData localReferralEntityData;
    private final NetworkReferralEntityData networkReferralEntityData;

    @Inject
    public ReferralEntityDataFactory(NetworkReferralEntityData networkReferralEntityData, LocalReferralEntityData localReferralEntityData) {
        this.networkReferralEntityData = networkReferralEntityData;
        this.localReferralEntityData = localReferralEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ReferralEntityData createData2(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 103145323) {
            if (hashCode == 1843485230 && str.equals("network")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("local")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            return this.localReferralEntityData;
        }
        return this.networkReferralEntityData;
    }
}
