package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.response.authface.VerificationMethodInfoEntity;
import id.dana.network.response.autoroute.SecurityContextResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJR\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0007R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u000b"}, d2 = {"Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "", "Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "component3", "()Ljava/util/List;", "component4", "Lid/dana/network/response/autoroute/SecurityContextResult;", "component5", "()Lid/dana/network/response/autoroute/SecurityContextResult;", "invitationId", "userInvited", "verificationMethodInfoList", BioUtilityBridge.SECURITY_ID, "securityContext", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Lid/dana/network/response/autoroute/SecurityContextResult;)Lid/dana/data/familyaccount/model/result/InviteMembersResultEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getInvitationId", "Lid/dana/network/response/autoroute/SecurityContextResult;", "getSecurityContext", "getSecurityId", "Ljava/lang/Boolean;", "getUserInvited", "Ljava/util/List;", "getVerificationMethodInfoList", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Lid/dana/network/response/autoroute/SecurityContextResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InviteMembersResultEntity extends BaseRpcResult {
    private final String invitationId;
    private final SecurityContextResult securityContext;
    private final String securityId;
    private final Boolean userInvited;
    private final List<VerificationMethodInfoEntity> verificationMethodInfoList;

    public static /* synthetic */ InviteMembersResultEntity copy$default(InviteMembersResultEntity inviteMembersResultEntity, String str, Boolean bool, List list, String str2, SecurityContextResult securityContextResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inviteMembersResultEntity.invitationId;
        }
        if ((i & 2) != 0) {
            bool = inviteMembersResultEntity.userInvited;
        }
        Boolean bool2 = bool;
        List<VerificationMethodInfoEntity> list2 = list;
        if ((i & 4) != 0) {
            list2 = inviteMembersResultEntity.verificationMethodInfoList;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            str2 = inviteMembersResultEntity.securityId;
        }
        String str3 = str2;
        if ((i & 16) != 0) {
            securityContextResult = inviteMembersResultEntity.securityContext;
        }
        return inviteMembersResultEntity.copy(str, bool2, list3, str3, securityContextResult);
    }

    /* renamed from: component1  reason: from getter */
    public final String getInvitationId() {
        return this.invitationId;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getUserInvited() {
        return this.userInvited;
    }

    public final List<VerificationMethodInfoEntity> component3() {
        return this.verificationMethodInfoList;
    }

    /* renamed from: component4  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component5  reason: from getter */
    public final SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    public final InviteMembersResultEntity copy(String invitationId, Boolean userInvited, List<VerificationMethodInfoEntity> verificationMethodInfoList, String securityId, SecurityContextResult securityContext) {
        return new InviteMembersResultEntity(invitationId, userInvited, verificationMethodInfoList, securityId, securityContext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InviteMembersResultEntity) {
            InviteMembersResultEntity inviteMembersResultEntity = (InviteMembersResultEntity) other;
            return Intrinsics.areEqual(this.invitationId, inviteMembersResultEntity.invitationId) && Intrinsics.areEqual(this.userInvited, inviteMembersResultEntity.userInvited) && Intrinsics.areEqual(this.verificationMethodInfoList, inviteMembersResultEntity.verificationMethodInfoList) && Intrinsics.areEqual(this.securityId, inviteMembersResultEntity.securityId) && Intrinsics.areEqual(this.securityContext, inviteMembersResultEntity.securityContext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.invitationId;
        int hashCode = str == null ? 0 : str.hashCode();
        Boolean bool = this.userInvited;
        int hashCode2 = bool == null ? 0 : bool.hashCode();
        List<VerificationMethodInfoEntity> list = this.verificationMethodInfoList;
        int hashCode3 = list == null ? 0 : list.hashCode();
        String str2 = this.securityId;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        SecurityContextResult securityContextResult = this.securityContext;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (securityContextResult != null ? securityContextResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InviteMembersResultEntity(invitationId=");
        sb.append(this.invitationId);
        sb.append(", userInvited=");
        sb.append(this.userInvited);
        sb.append(", verificationMethodInfoList=");
        sb.append(this.verificationMethodInfoList);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", securityContext=");
        sb.append(this.securityContext);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getInvitationId")
    public final String getInvitationId() {
        return this.invitationId;
    }

    @JvmName(name = "getUserInvited")
    public final Boolean getUserInvited() {
        return this.userInvited;
    }

    @JvmName(name = "getVerificationMethodInfoList")
    public final List<VerificationMethodInfoEntity> getVerificationMethodInfoList() {
        return this.verificationMethodInfoList;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    public InviteMembersResultEntity(String str, Boolean bool, List<VerificationMethodInfoEntity> list, String str2, SecurityContextResult securityContextResult) {
        this.invitationId = str;
        this.userInvited = bool;
        this.verificationMethodInfoList = list;
        this.securityId = str2;
        this.securityContext = securityContextResult;
    }
}
