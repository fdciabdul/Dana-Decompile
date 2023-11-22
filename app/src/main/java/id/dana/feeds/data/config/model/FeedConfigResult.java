package id.dana.feeds.data.config.model;

import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.ShareActivityConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b<\u0010=J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004JÄ\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b,\u0010-J\r\u0010/\u001a\u00020.¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u001c\u00104\u001a\u0004\b5\u0010\u0007R\u001c\u0010 \u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00104\u001a\u0004\b6\u0010\u0007R\u001c\u0010%\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00104\u001a\u0004\b7\u0010\u0007R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00104\u001a\u0004\b8\u0010\u0007R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00109\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00109\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00109\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00109\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00109\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00109\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010:\u001a\u0004\b;\u0010\r"}, d2 = {"Lid/dana/feeds/data/config/model/FeedConfigResult;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Boolean;", "", "component10", "()Ljava/lang/Integer;", "component11", "component12", "component13", "Lid/dana/domain/social/model/ShareActivityConfig;", "component14", "()Lid/dana/domain/social/model/ShareActivityConfig;", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "isRealtimeFeedEnabled", "isAddFriendEnabled", "isReplyCommentEnabled", "isFeedEnabled", "interval", "activitiesPerRequest", "isFeedWidgetEnabled", "isFeedCommentEnabled", "isFeedNotificationEnabled", "feedVersion", "isReciprocalFeedEnabled", "isCreateActivityEnabled", "isMaintenance", "shareActivity", "homeFeedVersion", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/domain/social/model/ShareActivityConfig;Ljava/lang/Integer;)Lid/dana/feeds/data/config/model/FeedConfigResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lid/dana/domain/social/model/FeedConfig;", "toFeedConfig", "()Lid/dana/domain/social/model/FeedConfig;", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getActivitiesPerRequest", "getFeedVersion", "getHomeFeedVersion", "getInterval", "Ljava/lang/Boolean;", "Lid/dana/domain/social/model/ShareActivityConfig;", "getShareActivity", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/domain/social/model/ShareActivityConfig;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeedConfigResult implements Serializable {
    public Integer activitiesPerRequest;
    public Integer feedVersion;
    public Integer homeFeedVersion;
    public Integer interval;
    public Boolean isAddFriendEnabled;
    public Boolean isCreateActivityEnabled;
    public Boolean isFeedCommentEnabled;
    public Boolean isFeedEnabled;
    public Boolean isFeedNotificationEnabled;
    public Boolean isFeedWidgetEnabled;
    public Boolean isMaintenance;
    public Boolean isRealtimeFeedEnabled;
    public Boolean isReciprocalFeedEnabled;
    public Boolean isReplyCommentEnabled;
    public ShareActivityConfig shareActivity;

    public FeedConfigResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getIsRealtimeFeedEnabled() {
        return this.isRealtimeFeedEnabled;
    }

    /* renamed from: component10  reason: from getter */
    public final Integer getFeedVersion() {
        return this.feedVersion;
    }

    /* renamed from: component11  reason: from getter */
    public final Boolean getIsReciprocalFeedEnabled() {
        return this.isReciprocalFeedEnabled;
    }

    /* renamed from: component12  reason: from getter */
    public final Boolean getIsCreateActivityEnabled() {
        return this.isCreateActivityEnabled;
    }

    /* renamed from: component13  reason: from getter */
    public final Boolean getIsMaintenance() {
        return this.isMaintenance;
    }

    /* renamed from: component14  reason: from getter */
    public final ShareActivityConfig getShareActivity() {
        return this.shareActivity;
    }

    /* renamed from: component15  reason: from getter */
    public final Integer getHomeFeedVersion() {
        return this.homeFeedVersion;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getIsAddFriendEnabled() {
        return this.isAddFriendEnabled;
    }

    /* renamed from: component3  reason: from getter */
    public final Boolean getIsReplyCommentEnabled() {
        return this.isReplyCommentEnabled;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getIsFeedEnabled() {
        return this.isFeedEnabled;
    }

    /* renamed from: component5  reason: from getter */
    public final Integer getInterval() {
        return this.interval;
    }

    /* renamed from: component6  reason: from getter */
    public final Integer getActivitiesPerRequest() {
        return this.activitiesPerRequest;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getIsFeedWidgetEnabled() {
        return this.isFeedWidgetEnabled;
    }

    /* renamed from: component8  reason: from getter */
    public final Boolean getIsFeedCommentEnabled() {
        return this.isFeedCommentEnabled;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getIsFeedNotificationEnabled() {
        return this.isFeedNotificationEnabled;
    }

    public final FeedConfigResult copy(Boolean isRealtimeFeedEnabled, Boolean isAddFriendEnabled, Boolean isReplyCommentEnabled, Boolean isFeedEnabled, Integer interval, Integer activitiesPerRequest, Boolean isFeedWidgetEnabled, Boolean isFeedCommentEnabled, Boolean isFeedNotificationEnabled, Integer feedVersion, Boolean isReciprocalFeedEnabled, Boolean isCreateActivityEnabled, Boolean isMaintenance, ShareActivityConfig shareActivity, Integer homeFeedVersion) {
        return new FeedConfigResult(isRealtimeFeedEnabled, isAddFriendEnabled, isReplyCommentEnabled, isFeedEnabled, interval, activitiesPerRequest, isFeedWidgetEnabled, isFeedCommentEnabled, isFeedNotificationEnabled, feedVersion, isReciprocalFeedEnabled, isCreateActivityEnabled, isMaintenance, shareActivity, homeFeedVersion);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FeedConfigResult) {
            FeedConfigResult feedConfigResult = (FeedConfigResult) other;
            return Intrinsics.areEqual(this.isRealtimeFeedEnabled, feedConfigResult.isRealtimeFeedEnabled) && Intrinsics.areEqual(this.isAddFriendEnabled, feedConfigResult.isAddFriendEnabled) && Intrinsics.areEqual(this.isReplyCommentEnabled, feedConfigResult.isReplyCommentEnabled) && Intrinsics.areEqual(this.isFeedEnabled, feedConfigResult.isFeedEnabled) && Intrinsics.areEqual(this.interval, feedConfigResult.interval) && Intrinsics.areEqual(this.activitiesPerRequest, feedConfigResult.activitiesPerRequest) && Intrinsics.areEqual(this.isFeedWidgetEnabled, feedConfigResult.isFeedWidgetEnabled) && Intrinsics.areEqual(this.isFeedCommentEnabled, feedConfigResult.isFeedCommentEnabled) && Intrinsics.areEqual(this.isFeedNotificationEnabled, feedConfigResult.isFeedNotificationEnabled) && Intrinsics.areEqual(this.feedVersion, feedConfigResult.feedVersion) && Intrinsics.areEqual(this.isReciprocalFeedEnabled, feedConfigResult.isReciprocalFeedEnabled) && Intrinsics.areEqual(this.isCreateActivityEnabled, feedConfigResult.isCreateActivityEnabled) && Intrinsics.areEqual(this.isMaintenance, feedConfigResult.isMaintenance) && Intrinsics.areEqual(this.shareActivity, feedConfigResult.shareActivity) && Intrinsics.areEqual(this.homeFeedVersion, feedConfigResult.homeFeedVersion);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.isRealtimeFeedEnabled;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.isAddFriendEnabled;
        int hashCode2 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.isReplyCommentEnabled;
        int hashCode3 = bool3 == null ? 0 : bool3.hashCode();
        Boolean bool4 = this.isFeedEnabled;
        int hashCode4 = bool4 == null ? 0 : bool4.hashCode();
        Integer num = this.interval;
        int hashCode5 = num == null ? 0 : num.hashCode();
        Integer num2 = this.activitiesPerRequest;
        int hashCode6 = num2 == null ? 0 : num2.hashCode();
        Boolean bool5 = this.isFeedWidgetEnabled;
        int hashCode7 = bool5 == null ? 0 : bool5.hashCode();
        Boolean bool6 = this.isFeedCommentEnabled;
        int hashCode8 = bool6 == null ? 0 : bool6.hashCode();
        Boolean bool7 = this.isFeedNotificationEnabled;
        int hashCode9 = bool7 == null ? 0 : bool7.hashCode();
        Integer num3 = this.feedVersion;
        int hashCode10 = num3 == null ? 0 : num3.hashCode();
        Boolean bool8 = this.isReciprocalFeedEnabled;
        int hashCode11 = bool8 == null ? 0 : bool8.hashCode();
        Boolean bool9 = this.isCreateActivityEnabled;
        int hashCode12 = bool9 == null ? 0 : bool9.hashCode();
        Boolean bool10 = this.isMaintenance;
        int hashCode13 = bool10 == null ? 0 : bool10.hashCode();
        ShareActivityConfig shareActivityConfig = this.shareActivity;
        int hashCode14 = shareActivityConfig == null ? 0 : shareActivityConfig.hashCode();
        Integer num4 = this.homeFeedVersion;
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + (num4 != null ? num4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedConfigResult(isRealtimeFeedEnabled=");
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

    public FeedConfigResult(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Integer num, Integer num2, Boolean bool5, Boolean bool6, Boolean bool7, Integer num3, Boolean bool8, Boolean bool9, Boolean bool10, ShareActivityConfig shareActivityConfig, Integer num4) {
        this.isRealtimeFeedEnabled = bool;
        this.isAddFriendEnabled = bool2;
        this.isReplyCommentEnabled = bool3;
        this.isFeedEnabled = bool4;
        this.interval = num;
        this.activitiesPerRequest = num2;
        this.isFeedWidgetEnabled = bool5;
        this.isFeedCommentEnabled = bool6;
        this.isFeedNotificationEnabled = bool7;
        this.feedVersion = num3;
        this.isReciprocalFeedEnabled = bool8;
        this.isCreateActivityEnabled = bool9;
        this.isMaintenance = bool10;
        this.shareActivity = shareActivityConfig;
        this.homeFeedVersion = num4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ FeedConfigResult(java.lang.Boolean r17, java.lang.Boolean r18, java.lang.Boolean r19, java.lang.Boolean r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.Boolean r23, java.lang.Boolean r24, java.lang.Boolean r25, java.lang.Integer r26, java.lang.Boolean r27, java.lang.Boolean r28, java.lang.Boolean r29, id.dana.domain.social.model.ShareActivityConfig r30, java.lang.Integer r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.config.model.FeedConfigResult.<init>(java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, id.dana.domain.social.model.ShareActivityConfig, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "isRealtimeFeedEnabled")
    public final Boolean isRealtimeFeedEnabled() {
        return this.isRealtimeFeedEnabled;
    }

    @JvmName(name = "isAddFriendEnabled")
    public final Boolean isAddFriendEnabled() {
        return this.isAddFriendEnabled;
    }

    @JvmName(name = "isReplyCommentEnabled")
    public final Boolean isReplyCommentEnabled() {
        return this.isReplyCommentEnabled;
    }

    @JvmName(name = "isFeedEnabled")
    public final Boolean isFeedEnabled() {
        return this.isFeedEnabled;
    }

    @JvmName(name = "getInterval")
    public final Integer getInterval() {
        return this.interval;
    }

    @JvmName(name = "getActivitiesPerRequest")
    public final Integer getActivitiesPerRequest() {
        return this.activitiesPerRequest;
    }

    @JvmName(name = "isFeedWidgetEnabled")
    public final Boolean isFeedWidgetEnabled() {
        return this.isFeedWidgetEnabled;
    }

    @JvmName(name = "isFeedCommentEnabled")
    public final Boolean isFeedCommentEnabled() {
        return this.isFeedCommentEnabled;
    }

    @JvmName(name = "isFeedNotificationEnabled")
    public final Boolean isFeedNotificationEnabled() {
        return this.isFeedNotificationEnabled;
    }

    @JvmName(name = "getFeedVersion")
    public final Integer getFeedVersion() {
        return this.feedVersion;
    }

    @JvmName(name = "isReciprocalFeedEnabled")
    public final Boolean isReciprocalFeedEnabled() {
        return this.isReciprocalFeedEnabled;
    }

    @JvmName(name = "isCreateActivityEnabled")
    public final Boolean isCreateActivityEnabled() {
        return this.isCreateActivityEnabled;
    }

    @JvmName(name = "isMaintenance")
    public final Boolean isMaintenance() {
        return this.isMaintenance;
    }

    @JvmName(name = "getShareActivity")
    public final ShareActivityConfig getShareActivity() {
        return this.shareActivity;
    }

    @JvmName(name = "getHomeFeedVersion")
    public final Integer getHomeFeedVersion() {
        return this.homeFeedVersion;
    }

    public final FeedConfig toFeedConfig() {
        Boolean bool = this.isRealtimeFeedEnabled;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Boolean bool2 = this.isAddFriendEnabled;
        boolean booleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Boolean bool3 = this.isReplyCommentEnabled;
        boolean booleanValue3 = bool3 != null ? bool3.booleanValue() : false;
        Boolean bool4 = this.isFeedEnabled;
        boolean booleanValue4 = bool4 != null ? bool4.booleanValue() : false;
        Integer num = this.interval;
        int intValue = num != null ? num.intValue() : 30000;
        Integer num2 = this.activitiesPerRequest;
        int intValue2 = num2 != null ? num2.intValue() : 10;
        Boolean bool5 = this.isFeedWidgetEnabled;
        boolean booleanValue5 = bool5 != null ? bool5.booleanValue() : false;
        Boolean bool6 = this.isFeedCommentEnabled;
        boolean booleanValue6 = bool6 != null ? bool6.booleanValue() : false;
        Boolean bool7 = this.isFeedNotificationEnabled;
        boolean booleanValue7 = bool7 != null ? bool7.booleanValue() : false;
        Integer num3 = this.feedVersion;
        int intValue3 = num3 != null ? num3.intValue() : 3;
        Boolean bool8 = this.isReciprocalFeedEnabled;
        boolean booleanValue8 = bool8 != null ? bool8.booleanValue() : false;
        Boolean bool9 = this.isCreateActivityEnabled;
        boolean booleanValue9 = bool9 != null ? bool9.booleanValue() : false;
        Boolean bool10 = this.isMaintenance;
        boolean booleanValue10 = bool10 != null ? bool10.booleanValue() : false;
        ShareActivityConfig shareActivityConfig = this.shareActivity;
        ShareActivityConfig shareActivityConfig2 = shareActivityConfig == null ? new ShareActivityConfig(false, 0, false, 7, null) : shareActivityConfig;
        Integer num4 = this.homeFeedVersion;
        return new FeedConfig(booleanValue, booleanValue2, booleanValue3, booleanValue4, intValue, intValue2, booleanValue5, booleanValue6, booleanValue7, intValue3, booleanValue8, booleanValue9, booleanValue10, shareActivityConfig2, num4 != null ? num4.intValue() : 4);
    }
}
