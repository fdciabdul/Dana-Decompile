package id.dana.data.config.source;

import id.dana.data.config.model.FeedCacheData;
import id.dana.data.config.source.sharedpreference.SocialFeedWrapperModelEntityData;
import id.dana.data.config.source.sharedpreference.ThirdPartyServiceEntityData;
import id.dana.domain.social.InitStatus;
import id.dana.domain.social.model.FeedConfig;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/config/source/HomeWidgetEntityData;", "", "Lid/dana/data/config/model/FeedCacheData;", "getFeedData", "()Lid/dana/data/config/model/FeedCacheData;", "", "Lid/dana/data/config/source/sharedpreference/ThirdPartyServiceEntityData;", "getServices", "()Ljava/util/List;", "Lid/dana/domain/social/model/FeedConfig;", "feedConfig", "", "saveFeedHomeConfig", "(Lid/dana/domain/social/model/FeedConfig;)V", "Lid/dana/domain/social/InitStatus;", "initStatus", "saveFeedInitState", "(Lid/dana/domain/social/InitStatus;)V", "thirdPartyServices", "saveServices", "(Ljava/util/List;)V", "Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "socialFeed", "saveSocialFeed", "(Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface HomeWidgetEntityData {
    FeedCacheData getFeedData();

    List<ThirdPartyServiceEntityData> getServices();

    void saveFeedHomeConfig(FeedConfig feedConfig);

    void saveFeedInitState(InitStatus initStatus);

    void saveServices(List<ThirdPartyServiceEntityData> thirdPartyServices);

    void saveSocialFeed(SocialFeedWrapperModelEntityData socialFeed);
}
