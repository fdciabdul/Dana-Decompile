package id.dana.riskChallenges.data.verifypassword.source.network.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u00022\b\b\u0003\u0010\t\u001a\u00020\u00022\b\b\u0003\u0010\n\u001a\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/data/verifypassword/source/network/request/VerifyPasswordRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "validateData", CashierKeyParams.VERIFICATION_METHOD, "sendStrategy", "verifyScene", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/riskChallenges/data/verifypassword/source/network/request/VerifyPasswordRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSendStrategy", "getValidateData", "getVerificationMethod", "getVerifyScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VerifyPasswordRequest extends BaseRpcRequest {
    @SerializedName("sendStrategy")
    private final String sendStrategy;
    @SerializedName("validateData")
    private final String validateData;
    @SerializedName(CashierKeyParams.VERIFICATION_METHOD)
    private final String verificationMethod;
    @SerializedName("verifyScene")
    private final String verifyScene;

    public static /* synthetic */ VerifyPasswordRequest copy$default(VerifyPasswordRequest verifyPasswordRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyPasswordRequest.validateData;
        }
        if ((i & 2) != 0) {
            str2 = verifyPasswordRequest.verificationMethod;
        }
        if ((i & 4) != 0) {
            str3 = verifyPasswordRequest.sendStrategy;
        }
        if ((i & 8) != 0) {
            str4 = verifyPasswordRequest.verifyScene;
        }
        return verifyPasswordRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    /* renamed from: component4  reason: from getter */
    public final String getVerifyScene() {
        return this.verifyScene;
    }

    public final VerifyPasswordRequest copy(@JSONField(name = "validateData") String validateData, @JSONField(name = "verificationMethod") String verificationMethod, @JSONField(name = "sendStrategy") String sendStrategy, @JSONField(name = "verifyScene") String verifyScene) {
        Intrinsics.checkNotNullParameter(validateData, "");
        Intrinsics.checkNotNullParameter(verificationMethod, "");
        Intrinsics.checkNotNullParameter(sendStrategy, "");
        Intrinsics.checkNotNullParameter(verifyScene, "");
        return new VerifyPasswordRequest(validateData, verificationMethod, sendStrategy, verifyScene);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyPasswordRequest) {
            VerifyPasswordRequest verifyPasswordRequest = (VerifyPasswordRequest) other;
            return Intrinsics.areEqual(this.validateData, verifyPasswordRequest.validateData) && Intrinsics.areEqual(this.verificationMethod, verifyPasswordRequest.verificationMethod) && Intrinsics.areEqual(this.sendStrategy, verifyPasswordRequest.sendStrategy) && Intrinsics.areEqual(this.verifyScene, verifyPasswordRequest.verifyScene);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.validateData.hashCode() * 31) + this.verificationMethod.hashCode()) * 31) + this.sendStrategy.hashCode()) * 31) + this.verifyScene.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPasswordRequest(validateData=");
        sb.append(this.validateData);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", sendStrategy=");
        sb.append(this.sendStrategy);
        sb.append(", verifyScene=");
        sb.append(this.verifyScene);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getSendStrategy")
    public final String getSendStrategy() {
        return this.sendStrategy;
    }

    @JvmName(name = "getVerifyScene")
    public final String getVerifyScene() {
        return this.verifyScene;
    }

    public VerifyPasswordRequest(@JSONField(name = "validateData") String str, @JSONField(name = "verificationMethod") String str2, @JSONField(name = "sendStrategy") String str3, @JSONField(name = "verifyScene") String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.validateData = str;
        this.verificationMethod = str2;
        this.sendStrategy = str3;
        this.verifyScene = str4;
    }
}
