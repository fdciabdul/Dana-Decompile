package id.dana.riskChallenges.data.forgetpassword.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/data/forgetpassword/source/network/request/ResetPasswordRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "newPassword", BioUtilityBridge.SECURITY_ID, "riskToken", "bizScene", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/riskChallenges/data/forgetpassword/source/network/request/ResetPasswordRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizScene", "getNewPassword", "getRiskToken", "getSecurityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ResetPasswordRequest extends BaseRpcRequest {
    @SerializedName("bizScene")
    private final String bizScene;
    @SerializedName("newPassword")
    private final String newPassword;
    @SerializedName("riskToken")
    private final String riskToken;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;

    public static /* synthetic */ ResetPasswordRequest copy$default(ResetPasswordRequest resetPasswordRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resetPasswordRequest.newPassword;
        }
        if ((i & 2) != 0) {
            str2 = resetPasswordRequest.securityId;
        }
        if ((i & 4) != 0) {
            str3 = resetPasswordRequest.riskToken;
        }
        if ((i & 8) != 0) {
            str4 = resetPasswordRequest.bizScene;
        }
        return resetPasswordRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getNewPassword() {
        return this.newPassword;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getRiskToken() {
        return this.riskToken;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBizScene() {
        return this.bizScene;
    }

    public final ResetPasswordRequest copy(String newPassword, String securityId, String riskToken, String bizScene) {
        Intrinsics.checkNotNullParameter(newPassword, "");
        Intrinsics.checkNotNullParameter(securityId, "");
        Intrinsics.checkNotNullParameter(riskToken, "");
        Intrinsics.checkNotNullParameter(bizScene, "");
        return new ResetPasswordRequest(newPassword, securityId, riskToken, bizScene);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ResetPasswordRequest) {
            ResetPasswordRequest resetPasswordRequest = (ResetPasswordRequest) other;
            return Intrinsics.areEqual(this.newPassword, resetPasswordRequest.newPassword) && Intrinsics.areEqual(this.securityId, resetPasswordRequest.securityId) && Intrinsics.areEqual(this.riskToken, resetPasswordRequest.riskToken) && Intrinsics.areEqual(this.bizScene, resetPasswordRequest.bizScene);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.newPassword.hashCode() * 31) + this.securityId.hashCode()) * 31) + this.riskToken.hashCode()) * 31) + this.bizScene.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResetPasswordRequest(newPassword=");
        sb.append(this.newPassword);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", riskToken=");
        sb.append(this.riskToken);
        sb.append(", bizScene=");
        sb.append(this.bizScene);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getNewPassword")
    public final String getNewPassword() {
        return this.newPassword;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getRiskToken")
    public final String getRiskToken() {
        return this.riskToken;
    }

    @JvmName(name = "getBizScene")
    public final String getBizScene() {
        return this.bizScene;
    }

    public ResetPasswordRequest(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.newPassword = str;
        this.securityId = str2;
        this.riskToken = str3;
        this.bizScene = str4;
    }
}
