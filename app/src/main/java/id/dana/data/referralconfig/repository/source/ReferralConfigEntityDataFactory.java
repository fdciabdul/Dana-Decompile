package id.dana.data.referralconfig.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.referralconfig.repository.source.local.DefaultReferralConfigEntityData;
import id.dana.data.referralconfig.repository.source.split.SplitReferralConfigEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralConfigEntityDataFactory extends AbstractEntityDataFactory<ReferralConfigEntityData> {
    private final DefaultReferralConfigEntityData defaultReferralConfigEntityData;
    private final SplitReferralConfigEntityData splitReferralConfigEntityData;

    @Inject
    public ReferralConfigEntityDataFactory(DefaultReferralConfigEntityData defaultReferralConfigEntityData, SplitReferralConfigEntityData splitReferralConfigEntityData) {
        this.defaultReferralConfigEntityData = defaultReferralConfigEntityData;
        this.splitReferralConfigEntityData = splitReferralConfigEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ReferralConfigEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("split")) {
            return this.splitReferralConfigEntityData;
        }
        return this.defaultReferralConfigEntityData;
    }
}
