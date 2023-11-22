package id.dana.data.authcode;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.UrlParam;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010#\u001a\u00020\t¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J¶\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020\t2\b\b\u0002\u0010#\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u0004R\"\u0010\u0019\u001a\u00020\t8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010.\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u00101R\"\u0010\u0016\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u00102\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u00105R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00102\u001a\u0004\b6\u0010\u0004\"\u0004\b7\u00105R\"\u0010\"\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010.\u001a\u0004\b\"\u0010\u000b\"\u0004\b8\u00101R\"\u0010#\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010.\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u00101R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00102\u001a\u0004\b;\u0010\u0004\"\u0004\b<\u00105R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00102\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u00105R\"\u0010\u0015\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u00102\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u00105R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u00102\u001a\u0004\bA\u0010\u0004\"\u0004\bB\u00105R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00102\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u00105R\"\u0010\u0017\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u00102\u001a\u0004\bE\u0010\u0004\"\u0004\bF\u00105R$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00102\u001a\u0004\bG\u0010\u0004\"\u0004\bH\u00105R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00102\u001a\u0004\bI\u0010\u0004\"\u0004\bJ\u00105R\"\u0010\u0018\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u00102\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u00105R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00102\u001a\u0004\bM\u0010\u0004\"\u0004\bN\u00105"}, d2 = {"Lid/dana/data/authcode/AuthRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "", "component14", "()Z", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "redirectUrl", "clientId", "scopes", "state", "agreed", UrlParam.REQUEST_ID, BioUtilityBridge.SECURITY_ID, "codeChallenge", "requestSourceType", BranchLinkConstant.OauthParams.NET_AUTH_ID, "subMerchantId", "signatureCode", "originalAuthUrl", "isNeedMobileToken", ApiDowngradeConstant.ActionType.MINI_PROGRAM, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lid/dana/data/authcode/AuthRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getAgreed", "setAgreed", "(Z)V", "Ljava/lang/String;", "getClientId", "setClientId", "(Ljava/lang/String;)V", "getCodeChallenge", "setCodeChallenge", "setNeedMobileToken", "getMiniProgram", "setMiniProgram", "getNetAuthId", "setNetAuthId", "getOriginalAuthUrl", "setOriginalAuthUrl", "getRedirectUrl", "setRedirectUrl", "getRequestId", "setRequestId", "getRequestSourceType", "setRequestSourceType", "getScopes", "setScopes", "getSecurityId", "setSecurityId", "getSignatureCode", "setSignatureCode", "getState", "setState", "getSubMerchantId", "setSubMerchantId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AuthRequest extends BaseRpcRequest {
    private boolean agreed;
    private String clientId;
    private String codeChallenge;
    private boolean isNeedMobileToken;
    private boolean miniProgram;
    private String netAuthId;
    private String originalAuthUrl;
    private String redirectUrl;
    private String requestId;
    private String requestSourceType;
    private String scopes;
    private String securityId;
    private String signatureCode;
    private String state;
    private String subMerchantId;

    public AuthRequest() {
        this(null, null, null, null, false, null, null, null, null, null, null, null, null, false, false, 32767, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component10  reason: from getter */
    public final String getNetAuthId() {
        return this.netAuthId;
    }

    /* renamed from: component11  reason: from getter */
    public final String getSubMerchantId() {
        return this.subMerchantId;
    }

    /* renamed from: component12  reason: from getter */
    public final String getSignatureCode() {
        return this.signatureCode;
    }

    /* renamed from: component13  reason: from getter */
    public final String getOriginalAuthUrl() {
        return this.originalAuthUrl;
    }

    /* renamed from: component14  reason: from getter */
    public final boolean getIsNeedMobileToken() {
        return this.isNeedMobileToken;
    }

    /* renamed from: component15  reason: from getter */
    public final boolean getMiniProgram() {
        return this.miniProgram;
    }

    /* renamed from: component2  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component4  reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getAgreed() {
        return this.agreed;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    /* renamed from: component9  reason: from getter */
    public final String getRequestSourceType() {
        return this.requestSourceType;
    }

    public final AuthRequest copy(String redirectUrl, String clientId, String scopes, String state, boolean agreed, String requestId, String securityId, String codeChallenge, String requestSourceType, String netAuthId, String subMerchantId, String signatureCode, String originalAuthUrl, boolean isNeedMobileToken, boolean miniProgram) {
        Intrinsics.checkNotNullParameter(redirectUrl, "");
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(scopes, "");
        Intrinsics.checkNotNullParameter(state, "");
        return new AuthRequest(redirectUrl, clientId, scopes, state, agreed, requestId, securityId, codeChallenge, requestSourceType, netAuthId, subMerchantId, signatureCode, originalAuthUrl, isNeedMobileToken, miniProgram);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AuthRequest) {
            AuthRequest authRequest = (AuthRequest) other;
            return Intrinsics.areEqual(this.redirectUrl, authRequest.redirectUrl) && Intrinsics.areEqual(this.clientId, authRequest.clientId) && Intrinsics.areEqual(this.scopes, authRequest.scopes) && Intrinsics.areEqual(this.state, authRequest.state) && this.agreed == authRequest.agreed && Intrinsics.areEqual(this.requestId, authRequest.requestId) && Intrinsics.areEqual(this.securityId, authRequest.securityId) && Intrinsics.areEqual(this.codeChallenge, authRequest.codeChallenge) && Intrinsics.areEqual(this.requestSourceType, authRequest.requestSourceType) && Intrinsics.areEqual(this.netAuthId, authRequest.netAuthId) && Intrinsics.areEqual(this.subMerchantId, authRequest.subMerchantId) && Intrinsics.areEqual(this.signatureCode, authRequest.signatureCode) && Intrinsics.areEqual(this.originalAuthUrl, authRequest.originalAuthUrl) && this.isNeedMobileToken == authRequest.isNeedMobileToken && this.miniProgram == authRequest.miniProgram;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.redirectUrl.hashCode();
        int hashCode2 = this.clientId.hashCode();
        int hashCode3 = this.scopes.hashCode();
        int hashCode4 = this.state.hashCode();
        boolean z = this.agreed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str = this.requestId;
        int hashCode5 = str == null ? 0 : str.hashCode();
        String str2 = this.securityId;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.codeChallenge;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.requestSourceType;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.netAuthId;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.subMerchantId;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.signatureCode;
        int hashCode11 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.originalAuthUrl;
        int hashCode12 = str8 != null ? str8.hashCode() : 0;
        boolean z2 = this.isNeedMobileToken;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.miniProgram;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        return (((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + i2) * 31) + i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AuthRequest(redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", agreed=");
        sb.append(this.agreed);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", codeChallenge=");
        sb.append(this.codeChallenge);
        sb.append(", requestSourceType=");
        sb.append(this.requestSourceType);
        sb.append(", netAuthId=");
        sb.append(this.netAuthId);
        sb.append(", subMerchantId=");
        sb.append(this.subMerchantId);
        sb.append(", signatureCode=");
        sb.append(this.signatureCode);
        sb.append(", originalAuthUrl=");
        sb.append(this.originalAuthUrl);
        sb.append(", isNeedMobileToken=");
        sb.append(this.isNeedMobileToken);
        sb.append(", miniProgram=");
        sb.append(this.miniProgram);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ AuthRequest(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) == 0 ? str12 : null, (i & 8192) != 0 ? false : z2, (i & 16384) == 0 ? z3 : false);
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "setRedirectUrl")
    public final void setRedirectUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.redirectUrl = str;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.clientId = str;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "setScopes")
    public final void setScopes(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.scopes = str;
    }

    @JvmName(name = "getState")
    public final String getState() {
        return this.state;
    }

    @JvmName(name = "setState")
    public final void setState(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.state = str;
    }

    @JvmName(name = "getAgreed")
    public final boolean getAgreed() {
        return this.agreed;
    }

    @JvmName(name = "setAgreed")
    public final void setAgreed(boolean z) {
        this.agreed = z;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "setRequestId")
    public final void setRequestId(String str) {
        this.requestId = str;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getCodeChallenge")
    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    @JvmName(name = "setCodeChallenge")
    public final void setCodeChallenge(String str) {
        this.codeChallenge = str;
    }

    @JvmName(name = "getRequestSourceType")
    public final String getRequestSourceType() {
        return this.requestSourceType;
    }

    @JvmName(name = "setRequestSourceType")
    public final void setRequestSourceType(String str) {
        this.requestSourceType = str;
    }

    @JvmName(name = "getNetAuthId")
    public final String getNetAuthId() {
        return this.netAuthId;
    }

    @JvmName(name = "setNetAuthId")
    public final void setNetAuthId(String str) {
        this.netAuthId = str;
    }

    @JvmName(name = "getSubMerchantId")
    public final String getSubMerchantId() {
        return this.subMerchantId;
    }

    @JvmName(name = "setSubMerchantId")
    public final void setSubMerchantId(String str) {
        this.subMerchantId = str;
    }

    @JvmName(name = "getSignatureCode")
    public final String getSignatureCode() {
        return this.signatureCode;
    }

    @JvmName(name = "setSignatureCode")
    public final void setSignatureCode(String str) {
        this.signatureCode = str;
    }

    @JvmName(name = "getOriginalAuthUrl")
    public final String getOriginalAuthUrl() {
        return this.originalAuthUrl;
    }

    @JvmName(name = "setOriginalAuthUrl")
    public final void setOriginalAuthUrl(String str) {
        this.originalAuthUrl = str;
    }

    @JvmName(name = "isNeedMobileToken")
    public final boolean isNeedMobileToken() {
        return this.isNeedMobileToken;
    }

    @JvmName(name = "setNeedMobileToken")
    public final void setNeedMobileToken(boolean z) {
        this.isNeedMobileToken = z;
    }

    @JvmName(name = "getMiniProgram")
    public final boolean getMiniProgram() {
        return this.miniProgram;
    }

    @JvmName(name = "setMiniProgram")
    public final void setMiniProgram(boolean z) {
        this.miniProgram = z;
    }

    public AuthRequest(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.redirectUrl = str;
        this.clientId = str2;
        this.scopes = str3;
        this.state = str4;
        this.agreed = z;
        this.requestId = str5;
        this.securityId = str6;
        this.codeChallenge = str7;
        this.requestSourceType = str8;
        this.netAuthId = str9;
        this.subMerchantId = str10;
        this.signatureCode = str11;
        this.originalAuthUrl = str12;
        this.isNeedMobileToken = z2;
        this.miniProgram = z3;
    }
}
