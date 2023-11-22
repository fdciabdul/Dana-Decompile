package id.dana.feeds.domain.detail.model;

import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JN\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0017\u0010\f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/detail/model/AddActivityCommentInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "id", "userId", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "content", "createdTime", "parentCommentId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/domain/detail/model/AddActivityCommentInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActivityId", "getContent", "getCreatedTime", "getId", "getParentCommentId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AddActivityCommentInfo {
    private final String activityId;
    private final String content;
    private final String createdTime;
    private final String id;
    private final String parentCommentId;
    private final String userId;

    public static /* synthetic */ AddActivityCommentInfo copy$default(AddActivityCommentInfo addActivityCommentInfo, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addActivityCommentInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = addActivityCommentInfo.userId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = addActivityCommentInfo.activityId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = addActivityCommentInfo.content;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = addActivityCommentInfo.createdTime;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = addActivityCommentInfo.parentCommentId;
        }
        return addActivityCommentInfo.copy(str, str7, str8, str9, str10, str6);
    }

    /* renamed from: component1  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component6  reason: from getter */
    public final String getParentCommentId() {
        return this.parentCommentId;
    }

    public final AddActivityCommentInfo copy(String id2, String userId, String activityId, String content, String createdTime, String parentCommentId) {
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(activityId, "");
        Intrinsics.checkNotNullParameter(content, "");
        Intrinsics.checkNotNullParameter(createdTime, "");
        return new AddActivityCommentInfo(id2, userId, activityId, content, createdTime, parentCommentId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AddActivityCommentInfo) {
            AddActivityCommentInfo addActivityCommentInfo = (AddActivityCommentInfo) other;
            return Intrinsics.areEqual(this.id, addActivityCommentInfo.id) && Intrinsics.areEqual(this.userId, addActivityCommentInfo.userId) && Intrinsics.areEqual(this.activityId, addActivityCommentInfo.activityId) && Intrinsics.areEqual(this.content, addActivityCommentInfo.content) && Intrinsics.areEqual(this.createdTime, addActivityCommentInfo.createdTime) && Intrinsics.areEqual(this.parentCommentId, addActivityCommentInfo.parentCommentId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.id.hashCode();
        int hashCode2 = this.userId.hashCode();
        int hashCode3 = this.activityId.hashCode();
        int hashCode4 = this.content.hashCode();
        int hashCode5 = this.createdTime.hashCode();
        String str = this.parentCommentId;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AddActivityCommentInfo(id=");
        sb.append(this.id);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", activityId=");
        sb.append(this.activityId);
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", parentCommentId=");
        sb.append(this.parentCommentId);
        sb.append(')');
        return sb.toString();
    }

    public AddActivityCommentInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.id = str;
        this.userId = str2;
        this.activityId = str3;
        this.content = str4;
        this.createdTime = str5;
        this.parentCommentId = str6;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    @JvmName(name = "getContent")
    public final String getContent() {
        return this.content;
    }

    @JvmName(name = "getCreatedTime")
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getParentCommentId")
    public final String getParentCommentId() {
        return this.parentCommentId;
    }
}
