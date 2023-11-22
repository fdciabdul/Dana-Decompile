package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.response.authface.VerificationMethodInfoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/familyaccount/model/result/InvitationDecisionResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", BioUtilityBridge.SECURITY_ID, "Ljava/lang/String;", "getSecurityId", "()Ljava/lang/String;", "", "Lid/dana/network/response/authface/VerificationMethodInfoEntity;", "verificationMethodInfoList", "Ljava/util/List;", "getVerificationMethodInfoList", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvitationDecisionResultEntity extends BaseRpcResult {
    private final String securityId;
    private final List<VerificationMethodInfoEntity> verificationMethodInfoList;

    @JvmName(name = "getVerificationMethodInfoList")
    public final List<VerificationMethodInfoEntity> getVerificationMethodInfoList() {
        return this.verificationMethodInfoList;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    public InvitationDecisionResultEntity(List<VerificationMethodInfoEntity> list, String str) {
        this.verificationMethodInfoList = list;
        this.securityId = str;
    }
}
