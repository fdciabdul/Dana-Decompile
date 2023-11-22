package id.dana.data.featureswitch.repository.source;

import id.dana.data.featureswitch.FeatureNonAMCSEntityDataFactory;
import id.dana.domain.featureswitch.FeatureNonAmcsRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class FeatureNonAMCSEntityRepository implements FeatureNonAmcsRepository {
    private final FeatureNonAMCSEntityDataFactory featureNonAMCSEntityDataFactory;

    @Inject
    public FeatureNonAMCSEntityRepository(FeatureNonAMCSEntityDataFactory featureNonAMCSEntityDataFactory) {
        this.featureNonAMCSEntityDataFactory = featureNonAMCSEntityDataFactory;
    }

    private FeatureNonAMCSEntityData createFeatureNonAmcs() {
        return this.featureNonAMCSEntityDataFactory.createData("local");
    }

    @Override // id.dana.domain.featureswitch.FeatureNonAmcsRepository
    public Observable<Boolean> isFeatureNonAMCS(String str) {
        return createFeatureNonAmcs().isFeatureNonAMCS(str);
    }
}
