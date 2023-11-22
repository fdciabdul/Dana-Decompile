package id.dana.data.featureswitch;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.featureswitch.repository.source.FeatureNonAMCSEntityData;
import id.dana.data.featureswitch.repository.source.local.DefaultFeatureNonAMCSData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class FeatureNonAMCSEntityDataFactory extends AbstractEntityDataFactory<FeatureNonAMCSEntityData> {
    private final DefaultFeatureNonAMCSData defaultFeatureNonAMCSData;

    @Inject
    public FeatureNonAMCSEntityDataFactory(DefaultFeatureNonAMCSData defaultFeatureNonAMCSData) {
        this.defaultFeatureNonAMCSData = defaultFeatureNonAMCSData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    public FeatureNonAMCSEntityData createData(String str) {
        return this.defaultFeatureNonAMCSData;
    }
}
