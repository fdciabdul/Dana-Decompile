package id.dana.domain.familyaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0017\u0010\u0010\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010\fR\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b#\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/FamilyAccountMemberInfoResult;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/familyaccount/model/MemberInfoResult;", "component2", "()Lid/dana/domain/familyaccount/model/MemberInfoResult;", "component3", "component4", "Lid/dana/domain/familyaccount/model/LimitInfoResult;", "component5", "()Lid/dana/domain/familyaccount/model/LimitInfoResult;", "organizerUserId", "member", "invitationStatus", "invitationId", "limitInfo", "copy", "(Ljava/lang/String;Lid/dana/domain/familyaccount/model/MemberInfoResult;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/familyaccount/model/LimitInfoResult;)Lid/dana/domain/familyaccount/model/FamilyAccountMemberInfoResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getInvitationId", "getInvitationStatus", "Lid/dana/domain/familyaccount/model/LimitInfoResult;", "getLimitInfo", "Lid/dana/domain/familyaccount/model/MemberInfoResult;", "getMember", "getOrganizerUserId", "<init>", "(Ljava/lang/String;Lid/dana/domain/familyaccount/model/MemberInfoResult;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/familyaccount/model/LimitInfoResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FamilyAccountMemberInfoResult {
    private final String invitationId;
    private final String invitationStatus;
    private final LimitInfoResult limitInfo;
    private final MemberInfoResult member;
    private final String organizerUserId;

    public static /* synthetic */ FamilyAccountMemberInfoResult copy$default(FamilyAccountMemberInfoResult familyAccountMemberInfoResult, String str, MemberInfoResult memberInfoResult, String str2, String str3, LimitInfoResult limitInfoResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = familyAccountMemberInfoResult.organizerUserId;
        }
        if ((i & 2) != 0) {
            memberInfoResult = familyAccountMemberInfoResult.member;
        }
        MemberInfoResult memberInfoResult2 = memberInfoResult;
        if ((i & 4) != 0) {
            str2 = familyAccountMemberInfoResult.invitationStatus;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = familyAccountMemberInfoResult.invitationId;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            limitInfoResult = familyAccountMemberInfoResult.limitInfo;
        }
        return familyAccountMemberInfoResult.copy(str, memberInfoResult2, str4, str5, limitInfoResult);
    }

    /* renamed from: component1  reason: from getter */
    public final String getOrganizerUserId() {
        return this.organizerUserId;
    }

    /* renamed from: component2  reason: from getter */
    public final MemberInfoResult getMember() {
        return this.member;
    }

    /* renamed from: component3  reason: from getter */
    public final String getInvitationStatus() {
        return this.invitationStatus;
    }

    /* renamed from: component4  reason: from getter */
    public final String getInvitationId() {
        return this.invitationId;
    }

    /* renamed from: component5  reason: from getter */
    public final LimitInfoResult getLimitInfo() {
        return this.limitInfo;
    }

    public final FamilyAccountMemberInfoResult copy(String organizerUserId, MemberInfoResult member, String invitationStatus, String invitationId, LimitInfoResult limitInfo) {
        Intrinsics.checkNotNullParameter(organizerUserId, "");
        Intrinsics.checkNotNullParameter(member, "");
        Intrinsics.checkNotNullParameter(invitationStatus, "");
        Intrinsics.checkNotNullParameter(invitationId, "");
        Intrinsics.checkNotNullParameter(limitInfo, "");
        return new FamilyAccountMemberInfoResult(organizerUserId, member, invitationStatus, invitationId, limitInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FamilyAccountMemberInfoResult) {
            FamilyAccountMemberInfoResult familyAccountMemberInfoResult = (FamilyAccountMemberInfoResult) other;
            return Intrinsics.areEqual(this.organizerUserId, familyAccountMemberInfoResult.organizerUserId) && Intrinsics.areEqual(this.member, familyAccountMemberInfoResult.member) && Intrinsics.areEqual(this.invitationStatus, familyAccountMemberInfoResult.invitationStatus) && Intrinsics.areEqual(this.invitationId, familyAccountMemberInfoResult.invitationId) && Intrinsics.areEqual(this.limitInfo, familyAccountMemberInfoResult.limitInfo);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.organizerUserId.hashCode() * 31) + this.member.hashCode()) * 31) + this.invitationStatus.hashCode()) * 31) + this.invitationId.hashCode()) * 31) + this.limitInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FamilyAccountMemberInfoResult(organizerUserId=");
        sb.append(this.organizerUserId);
        sb.append(", member=");
        sb.append(this.member);
        sb.append(", invitationStatus=");
        sb.append(this.invitationStatus);
        sb.append(", invitationId=");
        sb.append(this.invitationId);
        sb.append(", limitInfo=");
        sb.append(this.limitInfo);
        sb.append(')');
        return sb.toString();
    }

    public FamilyAccountMemberInfoResult(String str, MemberInfoResult memberInfoResult, String str2, String str3, LimitInfoResult limitInfoResult) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(memberInfoResult, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(limitInfoResult, "");
        this.organizerUserId = str;
        this.member = memberInfoResult;
        this.invitationStatus = str2;
        this.invitationId = str3;
        this.limitInfo = limitInfoResult;
    }

    @JvmName(name = "getOrganizerUserId")
    public final String getOrganizerUserId() {
        return this.organizerUserId;
    }

    @JvmName(name = "getMember")
    public final MemberInfoResult getMember() {
        return this.member;
    }

    @JvmName(name = "getInvitationStatus")
    public final String getInvitationStatus() {
        return this.invitationStatus;
    }

    @JvmName(name = "getInvitationId")
    public final String getInvitationId() {
        return this.invitationId;
    }

    @JvmName(name = "getLimitInfo")
    public final LimitInfoResult getLimitInfo() {
        return this.limitInfo;
    }
}
