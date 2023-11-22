package id.dana.data.familyaccount.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.challenge.ChallengeControl;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJd\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\"\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b#\u0010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b$\u0010\u0004\"\u0004\b%\u0010&R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b'\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b(\u0010\b"}, d2 = {"Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/Boolean;", "component2", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "consult", "resendInvitation", "phoneNumber", ChallengeControl.Key.RELATION, "address", BioUtilityBridge.SECURITY_ID, "validateData", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/familyaccount/model/request/InviteMembersRequestEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddress", "Ljava/lang/Boolean;", "getConsult", "getPhoneNumber", "getRelation", "getResendInvitation", "setResendInvitation", "(Ljava/lang/Boolean;)V", "getSecurityId", "getValidateData", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InviteMembersRequestEntity extends BaseRpcRequest {
    private final String address;
    private final Boolean consult;
    private final String phoneNumber;
    private final String relation;
    private Boolean resendInvitation;
    private final String securityId;
    private final String validateData;

    public static /* synthetic */ InviteMembersRequestEntity copy$default(InviteMembersRequestEntity inviteMembersRequestEntity, Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = inviteMembersRequestEntity.consult;
        }
        if ((i & 2) != 0) {
            bool2 = inviteMembersRequestEntity.resendInvitation;
        }
        Boolean bool3 = bool2;
        if ((i & 4) != 0) {
            str = inviteMembersRequestEntity.phoneNumber;
        }
        String str6 = str;
        if ((i & 8) != 0) {
            str2 = inviteMembersRequestEntity.relation;
        }
        String str7 = str2;
        if ((i & 16) != 0) {
            str3 = inviteMembersRequestEntity.address;
        }
        String str8 = str3;
        if ((i & 32) != 0) {
            str4 = inviteMembersRequestEntity.securityId;
        }
        String str9 = str4;
        if ((i & 64) != 0) {
            str5 = inviteMembersRequestEntity.validateData;
        }
        return inviteMembersRequestEntity.copy(bool, bool3, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getConsult() {
        return this.consult;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getResendInvitation() {
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

    public final InviteMembersRequestEntity copy(Boolean consult, Boolean resendInvitation, String phoneNumber, String relation, String address, String securityId, String validateData) {
        return new InviteMembersRequestEntity(consult, resendInvitation, phoneNumber, relation, address, securityId, validateData);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InviteMembersRequestEntity) {
            InviteMembersRequestEntity inviteMembersRequestEntity = (InviteMembersRequestEntity) other;
            return Intrinsics.areEqual(this.consult, inviteMembersRequestEntity.consult) && Intrinsics.areEqual(this.resendInvitation, inviteMembersRequestEntity.resendInvitation) && Intrinsics.areEqual(this.phoneNumber, inviteMembersRequestEntity.phoneNumber) && Intrinsics.areEqual(this.relation, inviteMembersRequestEntity.relation) && Intrinsics.areEqual(this.address, inviteMembersRequestEntity.address) && Intrinsics.areEqual(this.securityId, inviteMembersRequestEntity.securityId) && Intrinsics.areEqual(this.validateData, inviteMembersRequestEntity.validateData);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.consult;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.resendInvitation;
        int hashCode2 = bool2 == null ? 0 : bool2.hashCode();
        String str = this.phoneNumber;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.relation;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.address;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.securityId;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.validateData;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InviteMembersRequestEntity(consult=");
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

    @JvmName(name = "getConsult")
    public final Boolean getConsult() {
        return this.consult;
    }

    @JvmName(name = "getResendInvitation")
    public final Boolean getResendInvitation() {
        return this.resendInvitation;
    }

    @JvmName(name = "setResendInvitation")
    public final void setResendInvitation(Boolean bool) {
        this.resendInvitation = bool;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getRelation")
    public final String getRelation() {
        return this.relation;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    public InviteMembersRequestEntity(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4, String str5) {
        this.consult = bool;
        this.resendInvitation = bool2;
        this.phoneNumber = str;
        this.relation = str2;
        this.address = str3;
        this.securityId = str4;
        this.validateData = str5;
    }
}
