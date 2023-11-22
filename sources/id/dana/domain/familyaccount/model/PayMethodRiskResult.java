package id.dana.domain.familyaccount.model;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J@\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "result", "maskPhoneNumber", CashierKeyParams.VERIFICATION_METHOD, RecordError.KEY_PUB_KEY, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/familyaccount/model/PayMethodRiskResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMaskPhoneNumber", "getPubKey", "getResult", "getVerificationMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayMethodRiskResult {
    private final String maskPhoneNumber;
    private final String pubKey;
    private final String result;
    private final String verificationMethod;

    public PayMethodRiskResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PayMethodRiskResult copy$default(PayMethodRiskResult payMethodRiskResult, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payMethodRiskResult.result;
        }
        if ((i & 2) != 0) {
            str2 = payMethodRiskResult.maskPhoneNumber;
        }
        if ((i & 4) != 0) {
            str3 = payMethodRiskResult.verificationMethod;
        }
        if ((i & 8) != 0) {
            str4 = payMethodRiskResult.pubKey;
        }
        return payMethodRiskResult.copy(str, str2, str3, str4);
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
    public final String getPubKey() {
        return this.pubKey;
    }

    public final PayMethodRiskResult copy(String result, String maskPhoneNumber, String verificationMethod, String pubKey) {
        return new PayMethodRiskResult(result, maskPhoneNumber, verificationMethod, pubKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayMethodRiskResult) {
            PayMethodRiskResult payMethodRiskResult = (PayMethodRiskResult) other;
            return Intrinsics.areEqual(this.result, payMethodRiskResult.result) && Intrinsics.areEqual(this.maskPhoneNumber, payMethodRiskResult.maskPhoneNumber) && Intrinsics.areEqual(this.verificationMethod, payMethodRiskResult.verificationMethod) && Intrinsics.areEqual(this.pubKey, payMethodRiskResult.pubKey);
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
        String str4 = this.pubKey;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayMethodRiskResult(result=");
        sb.append(this.result);
        sb.append(", maskPhoneNumber=");
        sb.append(this.maskPhoneNumber);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", pubKey=");
        sb.append(this.pubKey);
        sb.append(')');
        return sb.toString();
    }

    public PayMethodRiskResult(String str, String str2, String str3, String str4) {
        this.result = str;
        this.maskPhoneNumber = str2;
        this.verificationMethod = str3;
        this.pubKey = str4;
    }

    public /* synthetic */ PayMethodRiskResult(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
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

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
    }
}
