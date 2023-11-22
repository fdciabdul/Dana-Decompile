package id.dana.data.familyaccount.model.result;

import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/PayMethodRiskResultEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;", "component4", "()Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;", "result", "maskPhoneNumber", CashierKeyParams.VERIFICATION_METHOD, "securityContext", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;)Lid/dana/data/familyaccount/model/result/PayMethodRiskResultEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMaskPhoneNumber", "getResult", "Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;", "getSecurityContext", "getVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayMethodRiskResultEntity {
    private final String maskPhoneNumber;
    private final String result;
    private final SecurityContextAttributesEntity securityContext;
    private final String verificationMethod;

    public PayMethodRiskResultEntity() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PayMethodRiskResultEntity copy$default(PayMethodRiskResultEntity payMethodRiskResultEntity, String str, String str2, String str3, SecurityContextAttributesEntity securityContextAttributesEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payMethodRiskResultEntity.result;
        }
        if ((i & 2) != 0) {
            str2 = payMethodRiskResultEntity.maskPhoneNumber;
        }
        if ((i & 4) != 0) {
            str3 = payMethodRiskResultEntity.verificationMethod;
        }
        if ((i & 8) != 0) {
            securityContextAttributesEntity = payMethodRiskResultEntity.securityContext;
        }
        return payMethodRiskResultEntity.copy(str, str2, str3, securityContextAttributesEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMaskPhoneNumber() {
        return this.maskPhoneNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final SecurityContextAttributesEntity getSecurityContext() {
        return this.securityContext;
    }

    public final PayMethodRiskResultEntity copy(String result, String maskPhoneNumber, String verificationMethod, SecurityContextAttributesEntity securityContext) {
        return new PayMethodRiskResultEntity(result, maskPhoneNumber, verificationMethod, securityContext);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayMethodRiskResultEntity) {
            PayMethodRiskResultEntity payMethodRiskResultEntity = (PayMethodRiskResultEntity) other;
            return Intrinsics.areEqual(this.result, payMethodRiskResultEntity.result) && Intrinsics.areEqual(this.maskPhoneNumber, payMethodRiskResultEntity.maskPhoneNumber) && Intrinsics.areEqual(this.verificationMethod, payMethodRiskResultEntity.verificationMethod) && Intrinsics.areEqual(this.securityContext, payMethodRiskResultEntity.securityContext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.result;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.maskPhoneNumber;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.verificationMethod;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        SecurityContextAttributesEntity securityContextAttributesEntity = this.securityContext;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (securityContextAttributesEntity != null ? securityContextAttributesEntity.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayMethodRiskResultEntity(result=");
        sb.append(this.result);
        sb.append(", maskPhoneNumber=");
        sb.append(this.maskPhoneNumber);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", securityContext=");
        sb.append(this.securityContext);
        sb.append(')');
        return sb.toString();
    }

    public PayMethodRiskResultEntity(String str, String str2, String str3, SecurityContextAttributesEntity securityContextAttributesEntity) {
        this.result = str;
        this.maskPhoneNumber = str2;
        this.verificationMethod = str3;
        this.securityContext = securityContextAttributesEntity;
    }

    public /* synthetic */ PayMethodRiskResultEntity(String str, String str2, String str3, SecurityContextAttributesEntity securityContextAttributesEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : securityContextAttributesEntity);
    }

    @JvmName(name = "getResult")
    public final String getResult() {
        return this.result;
    }

    @JvmName(name = "getMaskPhoneNumber")
    public final String getMaskPhoneNumber() {
        return this.maskPhoneNumber;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContextAttributesEntity getSecurityContext() {
        return this.securityContext;
    }
}
