package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.response.authface.VerificationMethodInfoEntity;
import id.dana.network.response.autoroute.SecurityContextResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010!J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010\u0005"}, d2 = {"Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "Lid/dana/network/response/autoroute/SecurityContextResult;", "component3", "()Lid/dana/network/response/autoroute/SecurityContextResult;", "verificationMethodInfoList", BioUtilityBridge.SECURITY_ID, "securityContext", "copy", "(Ljava/util/List;Ljava/lang/String;Lid/dana/network/response/autoroute/SecurityContextResult;)Lid/dana/data/familyaccount/model/result/RemoveFamilyMemberEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/network/response/autoroute/SecurityContextResult;", "getSecurityContext", "Ljava/lang/String;", "getSecurityId", "Ljava/util/List;", "getVerificationMethodInfoList", "<init>", "(Ljava/util/List;Ljava/lang/String;Lid/dana/network/response/autoroute/SecurityContextResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RemoveFamilyMemberEntity extends BaseRpcResult {
    private final SecurityContextResult securityContext;
    private final String securityId;
    private final List<VerificationMethodInfoEntity> verificationMethodInfoList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RemoveFamilyMemberEntity copy$default(RemoveFamilyMemberEntity removeFamilyMemberEntity, List list, String str, SecurityContextResult securityContextResult, int i, Object obj) {
        if ((i & 1) != 0) {
            list = removeFamilyMemberEntity.verificationMethodInfoList;
        }
        if ((i & 2) != 0) {
            str = removeFamilyMemberEntity.securityId;
        }
        if ((i & 4) != 0) {
            securityContextResult = removeFamilyMemberEntity.securityContext;
        }
        return removeFamilyMemberEntity.copy(list, str, securityContextResult);
    }

    public final List<VerificationMethodInfoEntity> component1() {
        return this.verificationMethodInfoList;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component3  reason: from getter */
    public final SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    public final RemoveFamilyMemberEntity copy(List<VerificationMethodInfoEntity> verificationMethodInfoList, String securityId, SecurityContextResult securityContext) {
        return new RemoveFamilyMemberEntity(verificationMethodInfoList, securityId, securityContext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RemoveFamilyMemberEntity) {
            RemoveFamilyMemberEntity removeFamilyMemberEntity = (RemoveFamilyMemberEntity) other;
            return Intrinsics.areEqual(this.verificationMethodInfoList, removeFamilyMemberEntity.verificationMethodInfoList) && Intrinsics.areEqual(this.securityId, removeFamilyMemberEntity.securityId) && Intrinsics.areEqual(this.securityContext, removeFamilyMemberEntity.securityContext);
        }
        return false;
    }

    public final int hashCode() {
        List<VerificationMethodInfoEntity> list = this.verificationMethodInfoList;
        int hashCode = list == null ? 0 : list.hashCode();
        String str = this.securityId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        SecurityContextResult securityContextResult = this.securityContext;
        return (((hashCode * 31) + hashCode2) * 31) + (securityContextResult != null ? securityContextResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RemoveFamilyMemberEntity(verificationMethodInfoList=");
        sb.append(this.verificationMethodInfoList);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", securityContext=");
        sb.append(this.securityContext);
        sb.append(')');
        return sb.toString();
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

    public RemoveFamilyMemberEntity(List<VerificationMethodInfoEntity> list, String str, SecurityContextResult securityContextResult) {
        this.verificationMethodInfoList = list;
        this.securityId = str;
        this.securityContext = securityContextResult;
    }
}
