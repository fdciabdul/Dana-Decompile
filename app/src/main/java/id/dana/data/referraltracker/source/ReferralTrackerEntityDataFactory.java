package id.dana.data.referraltracker.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.referraltracker.source.mock.MockReferralTrackerEntityData;
import id.dana.data.referraltracker.source.network.NetworkReferralTrackerEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralTrackerEntityDataFactory extends AbstractEntityDataFactory<ReferralTrackerEntityData> {
    private final MockReferralTrackerEntityData mockReferralTrackerEntityData;
    private final NetworkReferralTrackerEntityData networkReferralTrackerEntityData;

    @Inject
    public ReferralTrackerEntityDataFactory(NetworkReferralTrackerEntityData networkReferralTrackerEntityData, MockReferralTrackerEntityData mockReferralTrackerEntityData) {
        this.networkReferralTrackerEntityData = networkReferralTrackerEntityData;
        this.mockReferralTrackerEntityData = mockReferralTrackerEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ReferralTrackerEntityData createData2(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != 3357066) {
            if (hashCode == 1843485230 && str.equals("network")) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals("mock")) {
                c = 0;
            }
            c = 65535;
        }
        if (c == 0) {
            return this.mockReferralTrackerEntityData;
        }
        return this.networkReferralTrackerEntityData;
    }
}
