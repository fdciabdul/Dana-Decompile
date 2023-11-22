package id.dana.data.auth.face.repository.source.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J>\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0007R\"\u0010\n\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u001bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001fR$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001c\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\u001fR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001c\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\u001f"}, d2 = {"Lid/dana/data/auth/face/repository/source/request/FaceAuthenticationEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "component4", "faceAuthNew", BioUtilityBridge.SECURITY_ID, CashierKeyParams.VERIFICATION_METHOD, "validateData", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/auth/face/repository/source/request/FaceAuthenticationEntityRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getFaceAuthNew", "setFaceAuthNew", "(Z)V", "Ljava/lang/String;", "getSecurityId", "setSecurityId", "(Ljava/lang/String;)V", "getValidateData", "setValidateData", "getVerificationMethod", "setVerificationMethod", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FaceAuthenticationEntityRequest extends BaseRpcRequest {
    private boolean faceAuthNew;
    private String securityId;
    private String validateData;
    private String verificationMethod;

    public FaceAuthenticationEntityRequest() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ FaceAuthenticationEntityRequest copy$default(FaceAuthenticationEntityRequest faceAuthenticationEntityRequest, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = faceAuthenticationEntityRequest.faceAuthNew;
        }
        if ((i & 2) != 0) {
            str = faceAuthenticationEntityRequest.securityId;
        }
        if ((i & 4) != 0) {
            str2 = faceAuthenticationEntityRequest.verificationMethod;
        }
        if ((i & 8) != 0) {
            str3 = faceAuthenticationEntityRequest.validateData;
        }
        return faceAuthenticationEntityRequest.copy(z, str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getFaceAuthNew() {
        return this.faceAuthNew;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    public final FaceAuthenticationEntityRequest copy(boolean faceAuthNew, String securityId, String verificationMethod, String validateData) {
        return new FaceAuthenticationEntityRequest(faceAuthNew, securityId, verificationMethod, validateData);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FaceAuthenticationEntityRequest) {
            FaceAuthenticationEntityRequest faceAuthenticationEntityRequest = (FaceAuthenticationEntityRequest) other;
            return this.faceAuthNew == faceAuthenticationEntityRequest.faceAuthNew && Intrinsics.areEqual(this.securityId, faceAuthenticationEntityRequest.securityId) && Intrinsics.areEqual(this.verificationMethod, faceAuthenticationEntityRequest.verificationMethod) && Intrinsics.areEqual(this.validateData, faceAuthenticationEntityRequest.validateData);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean z = this.faceAuthNew;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.securityId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.verificationMethod;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.validateData;
        return (((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FaceAuthenticationEntityRequest(faceAuthNew=");
        sb.append(this.faceAuthNew);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ FaceAuthenticationEntityRequest(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    @JvmName(name = "getFaceAuthNew")
    public final boolean getFaceAuthNew() {
        return this.faceAuthNew;
    }

    @JvmName(name = "setFaceAuthNew")
    public final void setFaceAuthNew(boolean z) {
        this.faceAuthNew = z;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        this.verificationMethod = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        this.validateData = str;
    }

    public FaceAuthenticationEntityRequest(boolean z, String str, String str2, String str3) {
        this.faceAuthNew = z;
        this.securityId = str;
        this.verificationMethod = str2;
        this.validateData = str3;
    }
}
