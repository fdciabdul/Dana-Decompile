package id.dana.feeds.domain.relationship.model;

import id.dana.danah5.constant.BridgeName;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJb\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u000fJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b \u0010\u0004R\"\u0010\u0017\u001a\u00020\r8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010$R\"\u0010\u0016\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010%\u001a\u0004\b\u0016\u0010\f\"\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b(\u0010\u0004R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010+R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b,\u0010\u0004\"\u0004\b-\u0010+R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b.\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b/\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Z", "", "component8", "()I", BranchLinkConstant.Params.LOGIN_ID, "nickName", "status", "userId", "avatar", "username", "isNonReciprocal", "friendCount", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getAvatar", "I", "getFriendCount", "setFriendCount", "(I)V", "Z", "setNonReciprocal", "(Z)V", "getLoginId", "getNickName", "setNickName", "(Ljava/lang/String;)V", "getStatus", "setStatus", "getUserId", BridgeName.GET_USERNAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RelationshipItem {
    private final String avatar;
    private int friendCount;
    private boolean isNonReciprocal;
    private final String loginId;
    private String nickName;
    private String status;
    private final String userId;
    private final String username;

    public RelationshipItem() {
        this(null, null, null, null, null, null, false, 0, 255, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLoginId() {
        return this.loginId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component6  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getIsNonReciprocal() {
        return this.isNonReciprocal;
    }

    /* renamed from: component8  reason: from getter */
    public final int getFriendCount() {
        return this.friendCount;
    }

    public final RelationshipItem copy(String loginId, String nickName, String status, String userId, String avatar, String username, boolean isNonReciprocal, int friendCount) {
        Intrinsics.checkNotNullParameter(loginId, "");
        Intrinsics.checkNotNullParameter(nickName, "");
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(username, "");
        return new RelationshipItem(loginId, nickName, status, userId, avatar, username, isNonReciprocal, friendCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RelationshipItem) {
            RelationshipItem relationshipItem = (RelationshipItem) other;
            return Intrinsics.areEqual(this.loginId, relationshipItem.loginId) && Intrinsics.areEqual(this.nickName, relationshipItem.nickName) && Intrinsics.areEqual(this.status, relationshipItem.status) && Intrinsics.areEqual(this.userId, relationshipItem.userId) && Intrinsics.areEqual(this.avatar, relationshipItem.avatar) && Intrinsics.areEqual(this.username, relationshipItem.username) && this.isNonReciprocal == relationshipItem.isNonReciprocal && this.friendCount == relationshipItem.friendCount;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.loginId.hashCode();
        int hashCode2 = this.nickName.hashCode();
        int hashCode3 = this.status.hashCode();
        int hashCode4 = this.userId.hashCode();
        String str = this.avatar;
        int hashCode5 = str == null ? 0 : str.hashCode();
        int hashCode6 = this.username.hashCode();
        boolean z = this.isNonReciprocal;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + this.friendCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RelationshipItem(loginId=");
        sb.append(this.loginId);
        sb.append(", nickName=");
        sb.append(this.nickName);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(", isNonReciprocal=");
        sb.append(this.isNonReciprocal);
        sb.append(", friendCount=");
        sb.append(this.friendCount);
        sb.append(')');
        return sb.toString();
    }

    public RelationshipItem(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.loginId = str;
        this.nickName = str2;
        this.status = str3;
        this.userId = str4;
        this.avatar = str5;
        this.username = str6;
        this.isNonReciprocal = z;
        this.friendCount = i;
    }

    public /* synthetic */ RelationshipItem(String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) == 0 ? str6 : "", (i2 & 64) != 0 ? false : z, (i2 & 128) == 0 ? i : 0);
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @JvmName(name = "setNickName")
    public final void setNickName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.nickName = str;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.status = str;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "isNonReciprocal")
    public final boolean isNonReciprocal() {
        return this.isNonReciprocal;
    }

    @JvmName(name = "setNonReciprocal")
    public final void setNonReciprocal(boolean z) {
        this.isNonReciprocal = z;
    }

    @JvmName(name = "getFriendCount")
    public final int getFriendCount() {
        return this.friendCount;
    }

    @JvmName(name = "setFriendCount")
    public final void setFriendCount(int i) {
        this.friendCount = i;
    }
}
