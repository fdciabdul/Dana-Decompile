package id.dana.feeds.data.share.source.network.request;

import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.domain.userconfig.model.StoreConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/share/source/network/request/StoreFeedShareConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "Lid/dana/feeds/data/share/source/network/request/UserConfigFeedShareContent;", "component1", "()Lid/dana/feeds/data/share/source/network/request/UserConfigFeedShareContent;", "content", "copy", "(Lid/dana/feeds/data/share/source/network/request/UserConfigFeedShareContent;)Lid/dana/feeds/data/share/source/network/request/StoreFeedShareConfig;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/feeds/data/share/source/network/request/UserConfigFeedShareContent;", "getContent", "<init>", "(Lid/dana/feeds/data/share/source/network/request/UserConfigFeedShareContent;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StoreFeedShareConfig extends StoreConfig<UserConfigFeedShareContent> {
    public static final String SYNC_KEY = "feature_sync_share_feed";
    private final UserConfigFeedShareContent content;

    public static /* synthetic */ StoreFeedShareConfig copy$default(StoreFeedShareConfig storeFeedShareConfig, UserConfigFeedShareContent userConfigFeedShareContent, int i, Object obj) {
        if ((i & 1) != 0) {
            userConfigFeedShareContent = storeFeedShareConfig.content;
        }
        return storeFeedShareConfig.copy(userConfigFeedShareContent);
    }

    /* renamed from: component1  reason: from getter */
    public final UserConfigFeedShareContent getContent() {
        return this.content;
    }

    public final StoreFeedShareConfig copy(UserConfigFeedShareContent content) {
        Intrinsics.checkNotNullParameter(content, "");
        return new StoreFeedShareConfig(content);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StoreFeedShareConfig) && Intrinsics.areEqual(this.content, ((StoreFeedShareConfig) other).content);
    }

    public final int hashCode() {
        return this.content.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StoreFeedShareConfig(content=");
        sb.append(this.content);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getContent")
    public final UserConfigFeedShareContent getContent() {
        return this.content;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreFeedShareConfig(UserConfigFeedShareContent userConfigFeedShareContent) {
        super(UserConfigBizTypeConstant.CONFIG_FRIENDSHIP_SHARE, SYNC_KEY, userConfigFeedShareContent);
        Intrinsics.checkNotNullParameter(userConfigFeedShareContent, "");
        this.content = userConfigFeedShareContent;
    }
}
