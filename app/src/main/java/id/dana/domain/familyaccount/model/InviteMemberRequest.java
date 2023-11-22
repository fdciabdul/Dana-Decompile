package id.dana.domain.familyaccount.model;

import id.dana.challenge.ChallengeControl;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\bR\"\u0010\u0011\u001a\u00020\u00068\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010 R\"\u0010\r\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0004\"\u0004\b#\u0010$R\"\u0010\u000f\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b%\u0010\b\"\u0004\b&\u0010 R\"\u0010\u0010\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010 R\"\u0010\u000e\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010!\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010$R\"\u0010\u0012\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010 R\"\u0010\u0013\u001a\u00020\u00068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010 "}, d2 = {"Lid/dana/domain/familyaccount/model/InviteMemberRequest;", "", "", "component1", "()Z", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "consult", "resendInvitation", "phoneNumber", ChallengeControl.Key.RELATION, "address", BioUtilityBridge.SECURITY_ID, "validateData", "copy", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/familyaccount/model/InviteMemberRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddress", "setAddress", "(Ljava/lang/String;)V", "Z", "getConsult", "setConsult", "(Z)V", "getPhoneNumber", "setPhoneNumber", "getRelation", "setRelation", "getResendInvitation", "setResendInvitation", "getSecurityId", "setSecurityId", "getValidateData", "setValidateData", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InviteMemberRequest {
    private String address;
    private boolean consult;
    private String phoneNumber;
    private String relation;
    private boolean resendInvitation;
    private String securityId;
    private String validateData;

    public static /* synthetic */ InviteMemberRequest copy$default(InviteMemberRequest inviteMemberRequest, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            z = inviteMemberRequest.consult;
        }
        if ((i & 2) != 0) {
            z2 = inviteMemberRequest.resendInvitation;
        }
        boolean z3 = z2;
        if ((i & 4) != 0) {
            str = inviteMemberRequest.phoneNumber;
        }
        String str6 = str;
        if ((i & 8) != 0) {
            str2 = inviteMemberRequest.relation;
        }
        String str7 = str2;
        if ((i & 16) != 0) {
            str3 = inviteMemberRequest.address;
        }
        String str8 = str3;
        if ((i & 32) != 0) {
            str4 = inviteMemberRequest.securityId;
        }
        String str9 = str4;
        if ((i & 64) != 0) {
            str5 = inviteMemberRequest.validateData;
        }
        return inviteMemberRequest.copy(z, z3, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getConsult() {
        return this.consult;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getResendInvitation() {
        return this.resendInvitation;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component4  reason: from getter */
    public final String getRelation() {
        return this.relation;
    }

    /* renamed from: component5  reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    public final InviteMemberRequest copy(boolean consult, boolean resendInvitation, String phoneNumber, String relation, String address, String securityId, String validateData) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(relation, "");
        Intrinsics.checkNotNullParameter(address, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(validateData, "");
        return new InviteMemberRequest(consult, resendInvitation, phoneNumber, relation, address, securityId, validateData);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InviteMemberRequest) {
            InviteMemberRequest inviteMemberRequest = (InviteMemberRequest) other;
            return this.consult == inviteMemberRequest.consult && this.resendInvitation == inviteMemberRequest.resendInvitation && Intrinsics.areEqual(this.phoneNumber, inviteMemberRequest.phoneNumber) && Intrinsics.areEqual(this.relation, inviteMemberRequest.relation) && Intrinsics.areEqual(this.address, inviteMemberRequest.address) && Intrinsics.areEqual(this.securityId, inviteMemberRequest.securityId) && Intrinsics.areEqual(this.validateData, inviteMemberRequest.validateData);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public final int hashCode() {
        boolean z = this.consult;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        boolean z2 = this.resendInvitation;
        return (((((((((((r0 * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.phoneNumber.hashCode()) * 31) + this.relation.hashCode()) * 31) + this.address.hashCode()) * 31) + this.securityId.hashCode()) * 31) + this.validateData.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InviteMemberRequest(consult=");
        sb.append(this.consult);
        sb.append(", resendInvitation=");
        sb.append(this.resendInvitation);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", relation=");
        sb.append(this.relation);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(')');
        return sb.toString();
    }

    public InviteMemberRequest(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.consult = z;
        this.resendInvitation = z2;
        this.phoneNumber = str;
        this.relation = str2;
        this.address = str3;
        this.securityId = str4;
        this.validateData = str5;
    }

    public /* synthetic */ InviteMemberRequest(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? "" : str4, (i & 64) != 0 ? "" : str5);
    }

    @JvmName(name = "getConsult")
    public final boolean getConsult() {
        return this.consult;
    }

    @JvmName(name = "setConsult")
    public final void setConsult(boolean z) {
        this.consult = z;
    }

    @JvmName(name = "getResendInvitation")
    public final boolean getResendInvitation() {
        return this.resendInvitation;
    }

    @JvmName(name = "setResendInvitation")
    public final void setResendInvitation(boolean z) {
        this.resendInvitation = z;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "setPhoneNumber")
    public final void setPhoneNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.phoneNumber = str;
    }

    @JvmName(name = "getRelation")
    public final String getRelation() {
        return this.relation;
    }

    @JvmName(name = "setRelation")
    public final void setRelation(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.relation = str;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "setAddress")
    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.address = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.securityId = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.validateData = str;
    }
}
