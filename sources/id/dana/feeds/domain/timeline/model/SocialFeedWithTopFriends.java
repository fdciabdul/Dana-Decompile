package id.dana.feeds.domain.timeline.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001a\u0010\u000e\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b"}, d2 = {"Lid/dana/feeds/domain/timeline/model/SocialFeedWithTopFriends;", "", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "component1", "()Lid/dana/feeds/domain/timeline/model/SocialFeed;", "", "Lid/dana/feeds/domain/timeline/model/ActivityResponse;", "component2", "()Ljava/util/List;", "", "component3", "()Ljava/lang/String;", "socialFeed", "topFriends", "userId", "copy", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;Ljava/util/List;Ljava/lang/String;)Lid/dana/feeds/domain/timeline/model/SocialFeedWithTopFriends;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "getSocialFeed", "Ljava/util/List;", "getTopFriends", "Ljava/lang/String;", "getUserId", "<init>", "(Lid/dana/feeds/domain/timeline/model/SocialFeed;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SocialFeedWithTopFriends {
    private final SocialFeed socialFeed;
    private final List<ActivityResponse> topFriends;
    private final String userId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SocialFeedWithTopFriends copy$default(SocialFeedWithTopFriends socialFeedWithTopFriends, SocialFeed socialFeed, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            socialFeed = socialFeedWithTopFriends.socialFeed;
        }
        if ((i & 2) != 0) {
            list = socialFeedWithTopFriends.topFriends;
        }
        if ((i & 4) != 0) {
            str = socialFeedWithTopFriends.userId;
        }
        return socialFeedWithTopFriends.copy(socialFeed, list, str);
    }

    /* renamed from: component1  reason: from getter */
    public final SocialFeed getSocialFeed() {
        return this.socialFeed;
    }

    public final List<ActivityResponse> component2() {
        return this.topFriends;
    }

    /* renamed from: component3  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final SocialFeedWithTopFriends copy(SocialFeed socialFeed, List<ActivityResponse> topFriends, String userId) {
        Intrinsics.checkNotNullParameter(socialFeed, "");
        Intrinsics.checkNotNullParameter(topFriends, "");
        Intrinsics.checkNotNullParameter(userId, "");
        return new SocialFeedWithTopFriends(socialFeed, topFriends, userId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SocialFeedWithTopFriends) {
            SocialFeedWithTopFriends socialFeedWithTopFriends = (SocialFeedWithTopFriends) other;
            return Intrinsics.areEqual(this.socialFeed, socialFeedWithTopFriends.socialFeed) && Intrinsics.areEqual(this.topFriends, socialFeedWithTopFriends.topFriends) && Intrinsics.areEqual(this.userId, socialFeedWithTopFriends.userId);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.socialFeed.hashCode() * 31) + this.topFriends.hashCode()) * 31) + this.userId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialFeedWithTopFriends(socialFeed=");
        sb.append(this.socialFeed);
        sb.append(", topFriends=");
        sb.append(this.topFriends);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(')');
        return sb.toString();
    }

    public SocialFeedWithTopFriends(SocialFeed socialFeed, List<ActivityResponse> list, String str) {
        Intrinsics.checkNotNullParameter(socialFeed, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.socialFeed = socialFeed;
        this.topFriends = list;
        this.userId = str;
    }

    @JvmName(name = "getSocialFeed")
    public final SocialFeed getSocialFeed() {
        return this.socialFeed;
    }

    @JvmName(name = "getTopFriends")
    public final List<ActivityResponse> getTopFriends() {
        return this.topFriends;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }
}
