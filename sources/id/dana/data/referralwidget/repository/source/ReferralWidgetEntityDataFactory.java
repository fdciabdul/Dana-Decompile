package id.dana.data.referralwidget.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.referralwidget.repository.source.local.DefaultReferralWidgetEntityData;
import id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ReferralWidgetEntityDataFactory extends AbstractEntityDataFactory<ReferralWidgetEntityData> {
    private final DefaultReferralWidgetEntityData defaultReferralPageEntityData;
    private final SplitReferralWidgetEntityData splitReferralWidgetEntityData;

    @Inject
    public ReferralWidgetEntityDataFactory(SplitReferralWidgetEntityData splitReferralWidgetEntityData, DefaultReferralWidgetEntityData defaultReferralWidgetEntityData) {
        this.defaultReferralPageEntityData = defaultReferralWidgetEntityData;
        this.splitReferralWidgetEntityData = splitReferralWidgetEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public ReferralWidgetEntityData createData2(String str) {
        str.hashCode();
        if (str.equals("local")) {
            return this.defaultReferralPageEntityData;
        }
        return this.splitReferralWidgetEntityData;
    }
}
