package id.dana.data.playstorereview.mapper;

import com.alibaba.fastjson.JSONObject;
import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.PlayStoreReviewConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PlayStoreReviewEntityMapper extends BaseMapper<JSONObject, PlayStoreReviewConfig> {
    @Inject
    public PlayStoreReviewEntityMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public PlayStoreReviewConfig map(JSONObject jSONObject) {
        PlayStoreReviewConfig playStoreReviewConfig = new PlayStoreReviewConfig();
        if (jSONObject != null && !jSONObject.isEmpty()) {
            playStoreReviewConfig.setOptionRateCountdown(jSONObject.getInteger(PlayStoreReviewConfig.Key.OPTION_RATE_COUNTDOWN).intValue());
            playStoreReviewConfig.setOptionSkipCountdown(jSONObject.getInteger(PlayStoreReviewConfig.Key.OPTION_SKIP_COUNTDOWN).intValue());
            playStoreReviewConfig.setShowReviewEntrance(jSONObject.getBoolean(PlayStoreReviewConfig.Key.SHOW_REVIEW_ENTRACE).booleanValue());
            playStoreReviewConfig.setShowInAppReview(jSONObject.getBoolean(PlayStoreReviewConfig.Key.SHOW_IN_APP_REVIEW).booleanValue());
        }
        return playStoreReviewConfig;
    }
}
