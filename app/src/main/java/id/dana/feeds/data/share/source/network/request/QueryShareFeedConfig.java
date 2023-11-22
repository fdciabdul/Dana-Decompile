package id.dana.feeds.data.share.source.network.request;

import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.domain.userconfig.model.QueryConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/share/source/network/request/QueryShareFeedConfig;", "Lid/dana/domain/userconfig/model/QueryConfig;", "Lid/dana/feeds/data/share/source/network/request/UserConfigFeedShareContent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueryShareFeedConfig extends QueryConfig<UserConfigFeedShareContent> {
    public QueryShareFeedConfig() {
        super(UserConfigBizTypeConstant.CONFIG_FRIENDSHIP_SHARE, UserConfigFeedShareContent.class);
    }
}
