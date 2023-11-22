package id.dana.data.playstorereview.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.playstorereview.PlayStoreReviewEntityData;
import id.dana.data.playstorereview.repository.source.local.PlayStoreReviewPreference;
import id.dana.data.playstorereview.repository.source.local.PreferencePlayStoreReviewEntityData;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PlayStoreReviewDataFactory extends AbstractEntityDataFactory<PlayStoreReviewEntityData> {
    private final PlayStoreReviewPreference playStoreReviewPreference;

    @Inject
    public PlayStoreReviewDataFactory(PlayStoreReviewPreference playStoreReviewPreference) {
        this.playStoreReviewPreference = playStoreReviewPreference;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public PlayStoreReviewEntityData createData2(String str) {
        return new PreferencePlayStoreReviewEntityData(this.playStoreReviewPreference);
    }
}
