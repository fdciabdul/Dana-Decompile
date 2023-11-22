package id.dana.cashier.domain.model;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.cashier.utils.CashierKeyParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJn\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\nR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b'\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b(\u0010\u0004R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b)\u0010\u000e"}, d2 = {"Lid/dana/cashier/domain/model/RiskVerificationMethod;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Boolean;", "", "Lid/dana/cashier/domain/model/OneKlikPhones;", "component6", "()Ljava/util/List;", "component7", "result", RecordError.KEY_PUB_KEY, CashierKeyParams.VERIFICATION_METHOD, "maskPhoneNumber", "needResendButton", "phoneList", "verifyElements", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lid/dana/cashier/domain/model/RiskVerificationMethod;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getMaskPhoneNumber", "Ljava/lang/Boolean;", "getNeedResendButton", "Ljava/util/List;", "getPhoneList", "getPubKey", "getResult", "getVerificationMethod", "getVerifyElements", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RiskVerificationMethod {
    private final String maskPhoneNumber;
    private final Boolean needResendButton;
    private final List<OneKlikPhones> phoneList;
    private final String pubKey;
    private final String result;
    private final String verificationMethod;
    private final List<String> verifyElements;

    public static /* synthetic */ RiskVerificationMethod copy$default(RiskVerificationMethod riskVerificationMethod, String str, String str2, String str3, String str4, Boolean bool, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = riskVerificationMethod.result;
        }
        if ((i & 2) != 0) {
            str2 = riskVerificationMethod.pubKey;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = riskVerificationMethod.verificationMethod;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = riskVerificationMethod.maskPhoneNumber;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            bool = riskVerificationMethod.needResendButton;
        }
        Boolean bool2 = bool;
        List<OneKlikPhones> list3 = list;
        if ((i & 32) != 0) {
            list3 = riskVerificationMethod.phoneList;
        }
        List list4 = list3;
        List<String> list5 = list2;
        if ((i & 64) != 0) {
            list5 = riskVerificationMethod.verifyElements;
        }
        return riskVerificationMethod.copy(str, str5, str6, str7, bool2, list4, list5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPubKey() {
        return this.pubKey;
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

    public final List<OneKlikPhones> component6() {
        return this.phoneList;
    }

    public final List<String> component7() {
        return this.verifyElements;
    }

    public final RiskVerificationMethod copy(String result, String pubKey, String verificationMethod, String maskPhoneNumber, Boolean needResendButton, List<OneKlikPhones> phoneList, List<String> verifyElements) {
        Intrinsics.checkNotNullParameter(verifyElements, "");
        return new RiskVerificationMethod(result, pubKey, verificationMethod, maskPhoneNumber, needResendButton, phoneList, verifyElements);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RiskVerificationMethod) {
            RiskVerificationMethod riskVerificationMethod = (RiskVerificationMethod) other;
            return Intrinsics.areEqual(this.result, riskVerificationMethod.result) && Intrinsics.areEqual(this.pubKey, riskVerificationMethod.pubKey) && Intrinsics.areEqual(this.verificationMethod, riskVerificationMethod.verificationMethod) && Intrinsics.areEqual(this.maskPhoneNumber, riskVerificationMethod.maskPhoneNumber) && Intrinsics.areEqual(this.needResendButton, riskVerificationMethod.needResendButton) && Intrinsics.areEqual(this.phoneList, riskVerificationMethod.phoneList) && Intrinsics.areEqual(this.verifyElements, riskVerificationMethod.verifyElements);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.result;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.pubKey;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.verificationMethod;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.maskPhoneNumber;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.needResendButton;
        int hashCode5 = bool == null ? 0 : bool.hashCode();
        List<OneKlikPhones> list = this.phoneList;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (list != null ? list.hashCode() : 0)) * 31) + this.verifyElements.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskVerificationMethod(result=");
        sb.append(this.result);
        sb.append(", pubKey=");
        sb.append(this.pubKey);
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

    public RiskVerificationMethod(String str, String str2, String str3, String str4, Boolean bool, List<OneKlikPhones> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list2, "");
        this.result = str;
        this.pubKey = str2;
        this.verificationMethod = str3;
        this.maskPhoneNumber = str4;
        this.needResendButton = bool;
        this.phoneList = list;
        this.verifyElements = list2;
    }

    @JvmName(name = "getResult")
    public final String getResult() {
        return this.result;
    }

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
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

    public /* synthetic */ RiskVerificationMethod(String str, String str2, String str3, String str4, Boolean bool, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @JvmName(name = "getPhoneList")
    public final List<OneKlikPhones> getPhoneList() {
        return this.phoneList;
    }

    @JvmName(name = "getVerifyElements")
    public final List<String> getVerifyElements() {
        return this.verifyElements;
    }
}
