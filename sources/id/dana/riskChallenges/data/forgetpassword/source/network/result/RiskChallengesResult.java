package id.dana.riskChallenges.data.forgetpassword.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\u0004\b6\u00107J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012JZ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\u0007R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010%R$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010)R$\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010-R$\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010.\u001a\u0004\b/\u0010\r\"\u0004\b0\u00101R2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00102\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u00105"}, d2 = {"Lid/dana/riskChallenges/data/forgetpassword/source/network/result/RiskChallengesResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/String;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/SecurityInfoResult;", "component3", "()Lid/dana/riskChallenges/data/forgetpassword/source/network/result/SecurityInfoResult;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/UserInfoResult;", "component4", "()Lid/dana/riskChallenges/data/forgetpassword/source/network/result/UserInfoResult;", "Ljava/util/ArrayList;", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/VerificationMethodsResult;", "Lkotlin/collections/ArrayList;", "component5", "()Ljava/util/ArrayList;", "riskSwitch", "riskToken", "securityInfo", "userInfo", "verificationMethods", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/riskChallenges/data/forgetpassword/source/network/result/SecurityInfoResult;Lid/dana/riskChallenges/data/forgetpassword/source/network/result/UserInfoResult;Ljava/util/ArrayList;)Lid/dana/riskChallenges/data/forgetpassword/source/network/result/RiskChallengesResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Boolean;", "getRiskSwitch", "setRiskSwitch", "(Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getRiskToken", "setRiskToken", "(Ljava/lang/String;)V", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/SecurityInfoResult;", "getSecurityInfo", "setSecurityInfo", "(Lid/dana/riskChallenges/data/forgetpassword/source/network/result/SecurityInfoResult;)V", "Lid/dana/riskChallenges/data/forgetpassword/source/network/result/UserInfoResult;", "getUserInfo", "setUserInfo", "(Lid/dana/riskChallenges/data/forgetpassword/source/network/result/UserInfoResult;)V", "Ljava/util/ArrayList;", "getVerificationMethods", "setVerificationMethods", "(Ljava/util/ArrayList;)V", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/riskChallenges/data/forgetpassword/source/network/result/SecurityInfoResult;Lid/dana/riskChallenges/data/forgetpassword/source/network/result/UserInfoResult;Ljava/util/ArrayList;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RiskChallengesResult extends BaseRpcResultAphome {
    @SerializedName("riskSwitch")
    private Boolean riskSwitch;
    @SerializedName("riskToken")
    private String riskToken;
    @SerializedName("securityInfo")
    private SecurityInfoResult securityInfo;
    @SerializedName("userInfo")
    private UserInfoResult userInfo;
    @SerializedName("verificationMethods")
    private ArrayList<VerificationMethodsResult> verificationMethods;

    public RiskChallengesResult() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ RiskChallengesResult copy$default(RiskChallengesResult riskChallengesResult, Boolean bool, String str, SecurityInfoResult securityInfoResult, UserInfoResult userInfoResult, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = riskChallengesResult.riskSwitch;
        }
        if ((i & 2) != 0) {
            str = riskChallengesResult.riskToken;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            securityInfoResult = riskChallengesResult.securityInfo;
        }
        SecurityInfoResult securityInfoResult2 = securityInfoResult;
        if ((i & 8) != 0) {
            userInfoResult = riskChallengesResult.userInfo;
        }
        UserInfoResult userInfoResult2 = userInfoResult;
        ArrayList<VerificationMethodsResult> arrayList2 = arrayList;
        if ((i & 16) != 0) {
            arrayList2 = riskChallengesResult.verificationMethods;
        }
        return riskChallengesResult.copy(bool, str2, securityInfoResult2, userInfoResult2, arrayList2);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getRiskSwitch() {
        return this.riskSwitch;
    }

    /* renamed from: component2  reason: from getter */
    public final String getRiskToken() {
        return this.riskToken;
    }

    /* renamed from: component3  reason: from getter */
    public final SecurityInfoResult getSecurityInfo() {
        return this.securityInfo;
    }

    /* renamed from: component4  reason: from getter */
    public final UserInfoResult getUserInfo() {
        return this.userInfo;
    }

    public final ArrayList<VerificationMethodsResult> component5() {
        return this.verificationMethods;
    }

    public final RiskChallengesResult copy(Boolean riskSwitch, String riskToken, SecurityInfoResult securityInfo, UserInfoResult userInfo, ArrayList<VerificationMethodsResult> verificationMethods) {
        Intrinsics.checkNotNullParameter(verificationMethods, "");
        return new RiskChallengesResult(riskSwitch, riskToken, securityInfo, userInfo, verificationMethods);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RiskChallengesResult) {
            RiskChallengesResult riskChallengesResult = (RiskChallengesResult) other;
            return Intrinsics.areEqual(this.riskSwitch, riskChallengesResult.riskSwitch) && Intrinsics.areEqual(this.riskToken, riskChallengesResult.riskToken) && Intrinsics.areEqual(this.securityInfo, riskChallengesResult.securityInfo) && Intrinsics.areEqual(this.userInfo, riskChallengesResult.userInfo) && Intrinsics.areEqual(this.verificationMethods, riskChallengesResult.verificationMethods);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.riskSwitch;
        int hashCode = bool == null ? 0 : bool.hashCode();
        String str = this.riskToken;
        int hashCode2 = str == null ? 0 : str.hashCode();
        SecurityInfoResult securityInfoResult = this.securityInfo;
        int hashCode3 = securityInfoResult == null ? 0 : securityInfoResult.hashCode();
        UserInfoResult userInfoResult = this.userInfo;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (userInfoResult != null ? userInfoResult.hashCode() : 0)) * 31) + this.verificationMethods.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskChallengesResult(riskSwitch=");
        sb.append(this.riskSwitch);
        sb.append(", riskToken=");
        sb.append(this.riskToken);
        sb.append(", securityInfo=");
        sb.append(this.securityInfo);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getRiskSwitch")
    public final Boolean getRiskSwitch() {
        return this.riskSwitch;
    }

    @JvmName(name = "setRiskSwitch")
    public final void setRiskSwitch(Boolean bool) {
        this.riskSwitch = bool;
    }

    @JvmName(name = "getRiskToken")
    public final String getRiskToken() {
        return this.riskToken;
    }

    @JvmName(name = "setRiskToken")
    public final void setRiskToken(String str) {
        this.riskToken = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ RiskChallengesResult(java.lang.Boolean r9, java.lang.String r10, id.dana.riskChallenges.data.forgetpassword.source.network.result.SecurityInfoResult r11, id.dana.riskChallenges.data.forgetpassword.source.network.result.UserInfoResult r12, java.util.ArrayList r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r8 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L7
            r15 = r0
            goto L8
        L7:
            r15 = r9
        L8:
            r9 = r14 & 2
            if (r9 == 0) goto Le
            r1 = r0
            goto Lf
        Le:
            r1 = r10
        Lf:
            r9 = r14 & 4
            if (r9 == 0) goto L1f
            id.dana.riskChallenges.data.forgetpassword.source.network.result.SecurityInfoResult r11 = new id.dana.riskChallenges.data.forgetpassword.source.network.result.SecurityInfoResult
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            goto L20
        L1f:
            r2 = r11
        L20:
            r9 = r14 & 8
            if (r9 == 0) goto L2a
            id.dana.riskChallenges.data.forgetpassword.source.network.result.UserInfoResult r12 = new id.dana.riskChallenges.data.forgetpassword.source.network.result.UserInfoResult
            r9 = 3
            r12.<init>(r0, r0, r9, r0)
        L2a:
            r0 = r12
            r9 = r14 & 16
            if (r9 == 0) goto L34
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L34:
            r14 = r13
            r9 = r8
            r10 = r15
            r11 = r1
            r12 = r2
            r13 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.data.forgetpassword.source.network.result.RiskChallengesResult.<init>(java.lang.Boolean, java.lang.String, id.dana.riskChallenges.data.forgetpassword.source.network.result.SecurityInfoResult, id.dana.riskChallenges.data.forgetpassword.source.network.result.UserInfoResult, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getSecurityInfo")
    public final SecurityInfoResult getSecurityInfo() {
        return this.securityInfo;
    }

    @JvmName(name = "setSecurityInfo")
    public final void setSecurityInfo(SecurityInfoResult securityInfoResult) {
        this.securityInfo = securityInfoResult;
    }

    @JvmName(name = "getUserInfo")
    public final UserInfoResult getUserInfo() {
        return this.userInfo;
    }

    @JvmName(name = "setUserInfo")
    public final void setUserInfo(UserInfoResult userInfoResult) {
        this.userInfo = userInfoResult;
    }

    @JvmName(name = "getVerificationMethods")
    public final ArrayList<VerificationMethodsResult> getVerificationMethods() {
        return this.verificationMethods;
    }

    @JvmName(name = "setVerificationMethods")
    public final void setVerificationMethods(ArrayList<VerificationMethodsResult> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "");
        this.verificationMethods = arrayList;
    }

    public RiskChallengesResult(Boolean bool, String str, SecurityInfoResult securityInfoResult, UserInfoResult userInfoResult, ArrayList<VerificationMethodsResult> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "");
        this.riskSwitch = bool;
        this.riskToken = str;
        this.securityInfo = securityInfoResult;
        this.userInfo = userInfoResult;
        this.verificationMethods = arrayList;
    }
}
