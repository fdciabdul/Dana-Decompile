package id.dana.domain.social.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u0005¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J¦\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b,\u0010\u0007J\r\u0010-\u001a\u00020\u0002¢\u0006\u0004\b-\u0010\u0004J\r\u0010.\u001a\u00020\u0002¢\u0006\u0004\b.\u0010\u0004J\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101R\u0017\u0010\u001c\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u001c\u00102\u001a\u0004\b3\u0010\u0007R\u001a\u0010 \u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00102\u001a\u0004\b4\u0010\u0007R\u001a\u0010%\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00102\u001a\u0004\b5\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00102\u001a\u0004\b6\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00107\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\"\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00107\u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u001e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00107\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00107\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010$\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u00108\u001a\u0004\b9\u0010\r"}, d2 = {"Lid/dana/domain/social/model/FeedConfig;", "Ljava/io/Serializable;", "", "component1", "()Z", "", "component10", "()I", "component11", "component12", "component13", "Lid/dana/domain/social/model/ShareActivityConfig;", "component14", "()Lid/dana/domain/social/model/ShareActivityConfig;", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "isRealtimeFeedEnabled", "isAddFriendEnabled", "isReplyCommentEnabled", "isFeedEnabled", "interval", "activitiesPerRequest", "isFeedWidgetEnabled", "isFeedCommentEnabled", "isFeedNotificationEnabled", "feedVersion", "isReciprocalFeedEnabled", "isCreateActivityEnabled", "isMaintenance", "shareActivity", "homeFeedVersion", "copy", "(ZZZZIIZZZIZZZLid/dana/domain/social/model/ShareActivityConfig;I)Lid/dana/domain/social/model/FeedConfig;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "isFeedActivityBannerEnable", "isFeedEnabledAndNotMaintenance", "", "toString", "()Ljava/lang/String;", "I", "getActivitiesPerRequest", "getFeedVersion", "getHomeFeedVersion", "getInterval", "Z", "Lid/dana/domain/social/model/ShareActivityConfig;", "getShareActivity", "<init>", "(ZZZZIIZZZIZZZLid/dana/domain/social/model/ShareActivityConfig;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FeedConfig implements Serializable {
    public int activitiesPerRequest;
    public int feedVersion;
    public int homeFeedVersion;
    public int interval;
    public boolean isAddFriendEnabled;
    public boolean isCreateActivityEnabled;
    public boolean isFeedCommentEnabled;
    public boolean isFeedEnabled;
    public boolean isFeedNotificationEnabled;
    public boolean isFeedWidgetEnabled;
    public boolean isMaintenance;
    public boolean isRealtimeFeedEnabled;
    public boolean isReciprocalFeedEnabled;
    public boolean isReplyCommentEnabled;
    public ShareActivityConfig shareActivity;

    public /* synthetic */ FeedConfig() {
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getIsRealtimeFeedEnabled() {
        return this.isRealtimeFeedEnabled;
    }

    /* renamed from: component10  reason: from getter */
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    /* renamed from: component11  reason: from getter */
    public final boolean getIsReciprocalFeedEnabled() {
        return this.isReciprocalFeedEnabled;
    }

    /* renamed from: component12  reason: from getter */
    public final boolean getIsCreateActivityEnabled() {
        return this.isCreateActivityEnabled;
    }

    /* renamed from: component13  reason: from getter */
    public final boolean getIsMaintenance() {
        return this.isMaintenance;
    }

    /* renamed from: component14  reason: from getter */
    public final ShareActivityConfig getShareActivity() {
        return this.shareActivity;
    }

    /* renamed from: component15  reason: from getter */
    public final int getHomeFeedVersion() {
        return this.homeFeedVersion;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getIsAddFriendEnabled() {
        return this.isAddFriendEnabled;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsReplyCommentEnabled() {
        return this.isReplyCommentEnabled;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getIsFeedEnabled() {
        return this.isFeedEnabled;
    }

    /* renamed from: component5  reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* renamed from: component6  reason: from getter */
    public final int getActivitiesPerRequest() {
        return this.activitiesPerRequest;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getIsFeedWidgetEnabled() {
        return this.isFeedWidgetEnabled;
    }

    /* renamed from: component8  reason: from getter */
    public final boolean getIsFeedCommentEnabled() {
        return this.isFeedCommentEnabled;
    }

    /* renamed from: component9  reason: from getter */
    public final boolean getIsFeedNotificationEnabled() {
        return this.isFeedNotificationEnabled;
    }

    public final FeedConfig copy(boolean isRealtimeFeedEnabled, boolean isAddFriendEnabled, boolean isReplyCommentEnabled, boolean isFeedEnabled, int interval, int activitiesPerRequest, boolean isFeedWidgetEnabled, boolean isFeedCommentEnabled, boolean isFeedNotificationEnabled, int feedVersion, boolean isReciprocalFeedEnabled, boolean isCreateActivityEnabled, boolean isMaintenance, ShareActivityConfig shareActivity, int homeFeedVersion) {
        Intrinsics.checkNotNullParameter(shareActivity, "");
        return new FeedConfig(isRealtimeFeedEnabled, isAddFriendEnabled, isReplyCommentEnabled, isFeedEnabled, interval, activitiesPerRequest, isFeedWidgetEnabled, isFeedCommentEnabled, isFeedNotificationEnabled, feedVersion, isReciprocalFeedEnabled, isCreateActivityEnabled, isMaintenance, shareActivity, homeFeedVersion);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FeedConfig) {
            FeedConfig feedConfig = (FeedConfig) other;
            return this.isRealtimeFeedEnabled == feedConfig.isRealtimeFeedEnabled && this.isAddFriendEnabled == feedConfig.isAddFriendEnabled && this.isReplyCommentEnabled == feedConfig.isReplyCommentEnabled && this.isFeedEnabled == feedConfig.isFeedEnabled && this.interval == feedConfig.interval && this.activitiesPerRequest == feedConfig.activitiesPerRequest && this.isFeedWidgetEnabled == feedConfig.isFeedWidgetEnabled && this.isFeedCommentEnabled == feedConfig.isFeedCommentEnabled && this.isFeedNotificationEnabled == feedConfig.isFeedNotificationEnabled && this.feedVersion == feedConfig.feedVersion && this.isReciprocalFeedEnabled == feedConfig.isReciprocalFeedEnabled && this.isCreateActivityEnabled == feedConfig.isCreateActivityEnabled && this.isMaintenance == feedConfig.isMaintenance && Intrinsics.areEqual(this.shareActivity, feedConfig.shareActivity) && this.homeFeedVersion == feedConfig.homeFeedVersion;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.isRealtimeFeedEnabled;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.isAddFriendEnabled;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        ?? r3 = this.isReplyCommentEnabled;
        int i2 = r3;
        if (r3 != 0) {
            i2 = 1;
        }
        ?? r4 = this.isFeedEnabled;
        int i3 = r4;
        if (r4 != 0) {
            i3 = 1;
        }
        int i4 = this.interval;
        int i5 = this.activitiesPerRequest;
        ?? r7 = this.isFeedWidgetEnabled;
        int i6 = r7;
        if (r7 != 0) {
            i6 = 1;
        }
        ?? r8 = this.isFeedCommentEnabled;
        int i7 = r8;
        if (r8 != 0) {
            i7 = 1;
        }
        ?? r9 = this.isFeedNotificationEnabled;
        int i8 = r9;
        if (r9 != 0) {
            i8 = 1;
        }
        int i9 = this.feedVersion;
        ?? r11 = this.isReciprocalFeedEnabled;
        int i10 = r11;
        if (r11 != 0) {
            i10 = 1;
        }
        ?? r12 = this.isCreateActivityEnabled;
        int i11 = r12;
        if (r12 != 0) {
            i11 = 1;
        }
        boolean z2 = this.isMaintenance;
        return (((((((((((((((((((((((((((r0 * 31) + i) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + i8) * 31) + i9) * 31) + i10) * 31) + i11) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.shareActivity.hashCode()) * 31) + this.homeFeedVersion;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedConfig(isRealtimeFeedEnabled=");
        sb.append(this.isRealtimeFeedEnabled);
        sb.append(", isAddFriendEnabled=");
        sb.append(this.isAddFriendEnabled);
        sb.append(", isReplyCommentEnabled=");
        sb.append(this.isReplyCommentEnabled);
        sb.append(", isFeedEnabled=");
        sb.append(this.isFeedEnabled);
        sb.append(", interval=");
        sb.append(this.interval);
        sb.append(", activitiesPerRequest=");
        sb.append(this.activitiesPerRequest);
        sb.append(", isFeedWidgetEnabled=");
        sb.append(this.isFeedWidgetEnabled);
        sb.append(", isFeedCommentEnabled=");
        sb.append(this.isFeedCommentEnabled);
        sb.append(", isFeedNotificationEnabled=");
        sb.append(this.isFeedNotificationEnabled);
        sb.append(", feedVersion=");
        sb.append(this.feedVersion);
        sb.append(", isReciprocalFeedEnabled=");
        sb.append(this.isReciprocalFeedEnabled);
        sb.append(", isCreateActivityEnabled=");
        sb.append(this.isCreateActivityEnabled);
        sb.append(", isMaintenance=");
        sb.append(this.isMaintenance);
        sb.append(", shareActivity=");
        sb.append(this.shareActivity);
        sb.append(", homeFeedVersion=");
        sb.append(this.homeFeedVersion);
        sb.append(')');
        return sb.toString();
    }

    public FeedConfig(boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, boolean z5, boolean z6, boolean z7, int i3, boolean z8, boolean z9, boolean z10, ShareActivityConfig shareActivityConfig, int i4) {
        Intrinsics.checkNotNullParameter(shareActivityConfig, "");
        this.isRealtimeFeedEnabled = z;
        this.isAddFriendEnabled = z2;
        this.isReplyCommentEnabled = z3;
        this.isFeedEnabled = z4;
        this.interval = i;
        this.activitiesPerRequest = i2;
        this.isFeedWidgetEnabled = z5;
        this.isFeedCommentEnabled = z6;
        this.isFeedNotificationEnabled = z7;
        this.feedVersion = i3;
        this.isReciprocalFeedEnabled = z8;
        this.isCreateActivityEnabled = z9;
        this.isMaintenance = z10;
        this.shareActivity = shareActivityConfig;
        this.homeFeedVersion = i4;
    }

    @JvmName(name = "isRealtimeFeedEnabled")
    public final boolean isRealtimeFeedEnabled() {
        return this.isRealtimeFeedEnabled;
    }

    @JvmName(name = "isAddFriendEnabled")
    public final boolean isAddFriendEnabled() {
        return this.isAddFriendEnabled;
    }

    @JvmName(name = "isReplyCommentEnabled")
    public final boolean isReplyCommentEnabled() {
        return this.isReplyCommentEnabled;
    }

    @JvmName(name = "isFeedEnabled")
    public final boolean isFeedEnabled() {
        return this.isFeedEnabled;
    }

    @JvmName(name = "getInterval")
    public final int getInterval() {
        return this.interval;
    }

    @JvmName(name = "getActivitiesPerRequest")
    public final int getActivitiesPerRequest() {
        return this.activitiesPerRequest;
    }

    @JvmName(name = "isFeedWidgetEnabled")
    public final boolean isFeedWidgetEnabled() {
        return this.isFeedWidgetEnabled;
    }

    @JvmName(name = "isFeedCommentEnabled")
    public final boolean isFeedCommentEnabled() {
        return this.isFeedCommentEnabled;
    }

    @JvmName(name = "isFeedNotificationEnabled")
    public final boolean isFeedNotificationEnabled() {
        return this.isFeedNotificationEnabled;
    }

    @JvmName(name = "getFeedVersion")
    public final int getFeedVersion() {
        return this.feedVersion;
    }

    @JvmName(name = "isReciprocalFeedEnabled")
    public final boolean isReciprocalFeedEnabled() {
        return this.isReciprocalFeedEnabled;
    }

    @JvmName(name = "isCreateActivityEnabled")
    public final boolean isCreateActivityEnabled() {
        return this.isCreateActivityEnabled;
    }

    @JvmName(name = "isMaintenance")
    public final boolean isMaintenance() {
        return this.isMaintenance;
    }

    @JvmName(name = "getShareActivity")
    public final ShareActivityConfig getShareActivity() {
        return this.shareActivity;
    }

    @JvmName(name = "getHomeFeedVersion")
    public final int getHomeFeedVersion() {
        return this.homeFeedVersion;
    }

    public final boolean isFeedActivityBannerEnable() {
        return this.isCreateActivityEnabled && this.shareActivity.getFeedOnlineMerchantBanner();
    }

    public final boolean isFeedEnabledAndNotMaintenance() {
        return this.isFeedEnabled && !this.isMaintenance;
    }
}
