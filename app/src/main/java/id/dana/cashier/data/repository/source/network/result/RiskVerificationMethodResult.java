package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\rHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0010Jn\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\rHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001c\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\fR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b(\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b+\u0010\u0004R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\b,\u0010\u0010"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/cashier/data/repository/source/network/result/SecurityContextResult;", "component2", "()Lid/dana/cashier/data/repository/source/network/result/SecurityContextResult;", "component3", "component4", "", "component5", "()Ljava/lang/Boolean;", "", "Lid/dana/cashier/data/repository/source/network/result/OneKlikPhonesResult;", "component6", "()Ljava/util/List;", "component7", "result", "securityContext", CashierKeyParams.VERIFICATION_METHOD, "maskPhoneNumber", "needResendButton", "phoneList", "verifyElements", "copy", "(Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/SecurityContextResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lid/dana/cashier/data/repository/source/network/result/RiskVerificationMethodResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMaskPhoneNumber", "Ljava/lang/Boolean;", "getNeedResendButton", "Ljava/util/List;", "getPhoneList", "getResult", "Lid/dana/cashier/data/repository/source/network/result/SecurityContextResult;", "getSecurityContext", "getVerificationMethod", "getVerifyElements", "<init>", "(Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/SecurityContextResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RiskVerificationMethodResult {
    private final String maskPhoneNumber;
    private final Boolean needResendButton;
    private final List<OneKlikPhonesResult> phoneList;
    @SerializedName("result")
    private final String result;
    private final SecurityContextResult securityContext;
    private final String verificationMethod;
    private final List<String> verifyElements;

    public RiskVerificationMethodResult() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ RiskVerificationMethodResult copy$default(RiskVerificationMethodResult riskVerificationMethodResult, String str, SecurityContextResult securityContextResult, String str2, String str3, Boolean bool, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = riskVerificationMethodResult.result;
        }
        if ((i & 2) != 0) {
            securityContextResult = riskVerificationMethodResult.securityContext;
        }
        SecurityContextResult securityContextResult2 = securityContextResult;
        if ((i & 4) != 0) {
            str2 = riskVerificationMethodResult.verificationMethod;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = riskVerificationMethodResult.maskPhoneNumber;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            bool = riskVerificationMethodResult.needResendButton;
        }
        Boolean bool2 = bool;
        List<OneKlikPhonesResult> list3 = list;
        if ((i & 32) != 0) {
            list3 = riskVerificationMethodResult.phoneList;
        }
        List list4 = list3;
        List<String> list5 = list2;
        if ((i & 64) != 0) {
            list5 = riskVerificationMethodResult.verifyElements;
        }
        return riskVerificationMethodResult.copy(str, securityContextResult2, str4, str5, bool2, list4, list5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component2  reason: from getter */
    public final SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    /* renamed from: component3  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final String getMaskPhoneNumber() {
        return this.maskPhoneNumber;
    }

    /* renamed from: component5  reason: from getter */
    public final Boolean getNeedResendButton() {
        return this.needResendButton;
    }

    public final List<OneKlikPhonesResult> component6() {
        return this.phoneList;
    }

    public final List<String> component7() {
        return this.verifyElements;
    }

    public final RiskVerificationMethodResult copy(String result, SecurityContextResult securityContext, String verificationMethod, String maskPhoneNumber, Boolean needResendButton, List<OneKlikPhonesResult> phoneList, List<String> verifyElements) {
        Intrinsics.checkNotNullParameter(verifyElements, "");
        return new RiskVerificationMethodResult(result, securityContext, verificationMethod, maskPhoneNumber, needResendButton, phoneList, verifyElements);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RiskVerificationMethodResult) {
            RiskVerificationMethodResult riskVerificationMethodResult = (RiskVerificationMethodResult) other;
            return Intrinsics.areEqual(this.result, riskVerificationMethodResult.result) && Intrinsics.areEqual(this.securityContext, riskVerificationMethodResult.securityContext) && Intrinsics.areEqual(this.verificationMethod, riskVerificationMethodResult.verificationMethod) && Intrinsics.areEqual(this.maskPhoneNumber, riskVerificationMethodResult.maskPhoneNumber) && Intrinsics.areEqual(this.needResendButton, riskVerificationMethodResult.needResendButton) && Intrinsics.areEqual(this.phoneList, riskVerificationMethodResult.phoneList) && Intrinsics.areEqual(this.verifyElements, riskVerificationMethodResult.verifyElements);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.result;
        int hashCode = str == null ? 0 : str.hashCode();
        SecurityContextResult securityContextResult = this.securityContext;
        int hashCode2 = securityContextResult == null ? 0 : securityContextResult.hashCode();
        String str2 = this.verificationMethod;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.maskPhoneNumber;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.needResendButton;
        int hashCode5 = bool == null ? 0 : bool.hashCode();
        List<OneKlikPhonesResult> list = this.phoneList;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (list != null ? list.hashCode() : 0)) * 31) + this.verifyElements.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskVerificationMethodResult(result=");
        sb.append(this.result);
        sb.append(", securityContext=");
        sb.append(this.securityContext);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", maskPhoneNumber=");
        sb.append(this.maskPhoneNumber);
        sb.append(", needResendButton=");
        sb.append(this.needResendButton);
        sb.append(", phoneList=");
        sb.append(this.phoneList);
        sb.append(", verifyElements=");
        sb.append(this.verifyElements);
        sb.append(')');
        return sb.toString();
    }

    public RiskVerificationMethodResult(String str, SecurityContextResult securityContextResult, String str2, String str3, Boolean bool, List<OneKlikPhonesResult> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list2, "");
        this.result = str;
        this.securityContext = securityContextResult;
        this.verificationMethod = str2;
        this.maskPhoneNumber = str3;
        this.needResendButton = bool;
        this.phoneList = list;
        this.verifyElements = list2;
    }

    @JvmName(name = "getResult")
    public final String getResult() {
        return this.result;
    }

    @JvmName(name = "getSecurityContext")
    public final SecurityContextResult getSecurityContext() {
        return this.securityContext;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getMaskPhoneNumber")
    public final String getMaskPhoneNumber() {
        return this.maskPhoneNumber;
    }

    @JvmName(name = "getNeedResendButton")
    public final Boolean getNeedResendButton() {
        return this.needResendButton;
    }

    public /* synthetic */ RiskVerificationMethodResult(String str, SecurityContextResult securityContextResult, String str2, String str3, Boolean bool, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : securityContextResult, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) == 0 ? bool : null, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getPhoneList")
    public final List<OneKlikPhonesResult> getPhoneList() {
        return this.phoneList;
    }

    @JvmName(name = "getVerifyElements")
    public final List<String> getVerifyElements() {
        return this.verifyElements;
    }
}
