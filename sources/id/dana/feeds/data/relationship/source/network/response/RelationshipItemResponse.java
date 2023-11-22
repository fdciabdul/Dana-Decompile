package id.dana.feeds.data.relationship.source.network.response;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJd\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001f\u0010\bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b%\u0010\bR\u001a\u0010\u0011\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b&\u0010\bR\u001a\u0010\u0012\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b'\u0010\bR\u001a\u0010\u0013\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b(\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b)\u0010\b"}, d2 = {"Lid/dana/feeds/data/relationship/source/network/response/RelationshipItemResponse;", "", "", "component1", "()J", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "component8", "gmtCreate", "gmtModified", BranchLinkConstant.Params.LOGIN_ID, "nickName", "status", "userId", "avatar", "username", "copy", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/feeds/data/relationship/source/network/response/RelationshipItemResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAvatar", "J", "getGmtCreate", "getGmtModified", "getLoginId", "getNickName", "getStatus", "getUserId", BridgeName.GET_USERNAME, "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RelationshipItemResponse {
    private final String avatar;
    private final long gmtCreate;
    private final long gmtModified;
    private final String loginId;
    private final String nickName;
    private final String status;
    private final String userId;
    private final String username;

    /* renamed from: component1  reason: from getter */
    public final long getGmtCreate() {
        return this.gmtCreate;
    }

    /* renamed from: component2  reason: from getter */
    public final long getGmtModified() {
        return this.gmtModified;
    }

    /* renamed from: component3  reason: from getter */
    public final String getLoginId() {
        return this.loginId;
    }

    /* renamed from: component4  reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component8  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final RelationshipItemResponse copy(long gmtCreate, long gmtModified, String loginId, String nickName, String status, String userId, String avatar, String username) {
        Intrinsics.checkNotNullParameter(loginId, "");
        Intrinsics.checkNotNullParameter(nickName, "");
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(userId, "");
        return new RelationshipItemResponse(gmtCreate, gmtModified, loginId, nickName, status, userId, avatar, username);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RelationshipItemResponse) {
            RelationshipItemResponse relationshipItemResponse = (RelationshipItemResponse) other;
            return this.gmtCreate == relationshipItemResponse.gmtCreate && this.gmtModified == relationshipItemResponse.gmtModified && Intrinsics.areEqual(this.loginId, relationshipItemResponse.loginId) && Intrinsics.areEqual(this.nickName, relationshipItemResponse.nickName) && Intrinsics.areEqual(this.status, relationshipItemResponse.status) && Intrinsics.areEqual(this.userId, relationshipItemResponse.userId) && Intrinsics.areEqual(this.avatar, relationshipItemResponse.avatar) && Intrinsics.areEqual(this.username, relationshipItemResponse.username);
        }
        return false;
    }

    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtCreate);
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtModified);
        int hashCode = this.loginId.hashCode();
        int hashCode2 = this.nickName.hashCode();
        int hashCode3 = this.status.hashCode();
        int hashCode4 = this.userId.hashCode();
        String str = this.avatar;
        int hashCode5 = str == null ? 0 : str.hashCode();
        String str2 = this.username;
        return (((((((((((((m * 31) + m2) * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RelationshipItemResponse(gmtCreate=");
        sb.append(this.gmtCreate);
        sb.append(", gmtModified=");
        sb.append(this.gmtModified);
        sb.append(", loginId=");
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
        sb.append(')');
        return sb.toString();
    }

    public RelationshipItemResponse(long j, long j2, String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.gmtCreate = j;
        this.gmtModified = j2;
        this.loginId = str;
        this.nickName = str2;
        this.status = str3;
        this.userId = str4;
        this.avatar = str5;
        this.username = str6;
    }

    public /* synthetic */ RelationshipItemResponse(long j, long j2, String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, str, str2, str3, str4, (i & 64) != 0 ? "" : str5, (i & 128) != 0 ? "" : str6);
    }

    @JvmName(name = "getGmtCreate")
    public final long getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final long getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
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
}
