package id.dana.data.user.source.network.result;

import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.homeinfo.model.KybEntity;
import id.dana.data.homeinfo.model.KycEntity;
import id.dana.data.model.CurrencyAmountResult;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b9\b\u0086\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010'\u001a\u00020\f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00100\u001a\u00020\f\u0012\b\b\u0002\u00101\u001a\u00020\f\u0012\b\b\u0002\u00102\u001a\u00020\f\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\br\u0010sJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004Jø\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010'\u001a\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00100\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\f2\b\b\u0002\u00102\u001a\u00020\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00108\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020:HÖ\u0001¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b=\u0010\u0004R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010>\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u0010AR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010>\u001a\u0004\bB\u0010\u0004\"\u0004\bC\u0010AR$\u0010\"\u001a\u0004\u0018\u00010\u00138\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010D\u001a\u0004\bE\u0010\u0015\"\u0004\bF\u0010GR\"\u00101\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010H\u001a\u0004\bI\u0010\u000e\"\u0004\bJ\u0010KR\"\u00100\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010H\u001a\u0004\bL\u0010\u000e\"\u0004\bM\u0010KR\"\u00102\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010H\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010KR$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010>\u001a\u0004\bP\u0010\u0004\"\u0004\bQ\u0010AR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010>\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u0010AR$\u0010%\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010T\u001a\u0004\bU\u0010\u001a\"\u0004\bV\u0010WR$\u0010&\u001a\u0004\u0018\u00010\u001b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010X\u001a\u0004\bY\u0010\u001d\"\u0004\bZ\u0010[R\"\u0010'\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010H\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010KR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010>\u001a\u0004\b^\u0010\u0004\"\u0004\b_\u0010AR$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010>\u001a\u0004\b`\u0010\u0004\"\u0004\ba\u0010AR$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010>\u001a\u0004\bb\u0010\u0004\"\u0004\bc\u0010AR$\u0010+\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010>\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010AR$\u0010-\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010>\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010AR$\u0010.\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010>\u001a\u0004\bh\u0010\u0004\"\u0004\bi\u0010AR$\u0010/\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010>\u001a\u0004\bj\u0010\u0004\"\u0004\bk\u0010AR\u0011\u0010m\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\bl\u0010\u0004R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010>\u001a\u0004\bn\u0010\u0004\"\u0004\bo\u0010AR$\u00103\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010>\u001a\u0004\bp\u0010\u0004\"\u0004\bq\u0010A"}, d2 = {"Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "", "component17", "()Z", "component18", "component19", "component2", "component20", "Lid/dana/data/model/CurrencyAmountResult;", "component3", "()Lid/dana/data/model/CurrencyAmountResult;", "component4", "component5", "Lid/dana/data/homeinfo/model/KybEntity;", "component6", "()Lid/dana/data/homeinfo/model/KybEntity;", "Lid/dana/data/homeinfo/model/KycEntity;", "component7", "()Lid/dana/data/homeinfo/model/KycEntity;", "component8", "component9", "accountStatus", AccountEntityRepository.UpdateType.AVATAR, "balance", "ktpName", "ktpId", "kybInfo", "kyc", "kycCertified", WalletConstant.KYC_LEVEL, "loginStatus", "userStatus", "ncc", BranchLinkConstant.Params.LOGIN_ID, "nickname", "pendingTransaction", "shortcode", "faceAuthStatus", "enrollStatus", "faceLoginReady", "username", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/data/model/CurrencyAmountResult;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/homeinfo/model/KybEntity;Lid/dana/data/homeinfo/model/KycEntity;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountStatus", "setAccountStatus", "(Ljava/lang/String;)V", "getAvatarUrl", "setAvatarUrl", "Lid/dana/data/model/CurrencyAmountResult;", "getBalance", "setBalance", "(Lid/dana/data/model/CurrencyAmountResult;)V", "Z", "getEnrollStatus", "setEnrollStatus", "(Z)V", "getFaceAuthStatus", "setFaceAuthStatus", "getFaceLoginReady", "setFaceLoginReady", "getKtpId", "setKtpId", "getKtpName", "setKtpName", "Lid/dana/data/homeinfo/model/KybEntity;", "getKybInfo", "setKybInfo", "(Lid/dana/data/homeinfo/model/KybEntity;)V", "Lid/dana/data/homeinfo/model/KycEntity;", "getKyc", "setKyc", "(Lid/dana/data/homeinfo/model/KycEntity;)V", "getKycCertified", "setKycCertified", "getKycLevel", "setKycLevel", "getLoginId", "setLoginId", "getLoginStatus", "setLoginStatus", "getNcc", "setNcc", "getNickname", "setNickname", "getPendingTransaction", "setPendingTransaction", "getShortcode", "setShortcode", "getUserPan", "userPan", "getUserStatus", "setUserStatus", BridgeName.GET_USERNAME, "setUsername", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/data/model/CurrencyAmountResult;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/homeinfo/model/KybEntity;Lid/dana/data/homeinfo/model/KycEntity;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserInfoRpcResult extends BaseRpcResult {
    private String accountStatus;
    private String avatarUrl;
    private CurrencyAmountResult balance;
    private boolean enrollStatus;
    private boolean faceAuthStatus;
    private boolean faceLoginReady;
    private String ktpId;
    private String ktpName;
    private KybEntity kybInfo;
    private KycEntity kyc;
    private boolean kycCertified;
    private String kycLevel;
    private String loginId;
    private String loginStatus;
    private String ncc;
    private String nickname;
    private String pendingTransaction;
    private String shortcode;
    private String userStatus;
    private String username;

    public UserInfoRpcResult() {
        this(null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, false, false, null, 1048575, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    /* renamed from: component10  reason: from getter */
    public final String getLoginStatus() {
        return this.loginStatus;
    }

    /* renamed from: component11  reason: from getter */
    public final String getUserStatus() {
        return this.userStatus;
    }

    /* renamed from: component12  reason: from getter */
    public final String getNcc() {
        return this.ncc;
    }

    /* renamed from: component13  reason: from getter */
    public final String getLoginId() {
        return this.loginId;
    }

    /* renamed from: component14  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component15  reason: from getter */
    public final String getPendingTransaction() {
        return this.pendingTransaction;
    }

    /* renamed from: component16  reason: from getter */
    public final String getShortcode() {
        return this.shortcode;
    }

    /* renamed from: component17  reason: from getter */
    public final boolean getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    /* renamed from: component18  reason: from getter */
    public final boolean getEnrollStatus() {
        return this.enrollStatus;
    }

    /* renamed from: component19  reason: from getter */
    public final boolean getFaceLoginReady() {
        return this.faceLoginReady;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component20  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component3  reason: from getter */
    public final CurrencyAmountResult getBalance() {
        return this.balance;
    }

    /* renamed from: component4  reason: from getter */
    public final String getKtpName() {
        return this.ktpName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getKtpId() {
        return this.ktpId;
    }

    /* renamed from: component6  reason: from getter */
    public final KybEntity getKybInfo() {
        return this.kybInfo;
    }

    /* renamed from: component7  reason: from getter */
    public final KycEntity getKyc() {
        return this.kyc;
    }

    /* renamed from: component8  reason: from getter */
    public final boolean getKycCertified() {
        return this.kycCertified;
    }

    /* renamed from: component9  reason: from getter */
    public final String getKycLevel() {
        return this.kycLevel;
    }

    public final UserInfoRpcResult copy(String accountStatus, String avatarUrl, CurrencyAmountResult balance, String ktpName, String ktpId, KybEntity kybInfo, KycEntity kyc, boolean kycCertified, String kycLevel, String loginStatus, String userStatus, String ncc, String loginId, String nickname, String pendingTransaction, String shortcode, boolean faceAuthStatus, boolean enrollStatus, boolean faceLoginReady, String username) {
        return new UserInfoRpcResult(accountStatus, avatarUrl, balance, ktpName, ktpId, kybInfo, kyc, kycCertified, kycLevel, loginStatus, userStatus, ncc, loginId, nickname, pendingTransaction, shortcode, faceAuthStatus, enrollStatus, faceLoginReady, username);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserInfoRpcResult) {
            UserInfoRpcResult userInfoRpcResult = (UserInfoRpcResult) other;
            return Intrinsics.areEqual(this.accountStatus, userInfoRpcResult.accountStatus) && Intrinsics.areEqual(this.avatarUrl, userInfoRpcResult.avatarUrl) && Intrinsics.areEqual(this.balance, userInfoRpcResult.balance) && Intrinsics.areEqual(this.ktpName, userInfoRpcResult.ktpName) && Intrinsics.areEqual(this.ktpId, userInfoRpcResult.ktpId) && Intrinsics.areEqual(this.kybInfo, userInfoRpcResult.kybInfo) && Intrinsics.areEqual(this.kyc, userInfoRpcResult.kyc) && this.kycCertified == userInfoRpcResult.kycCertified && Intrinsics.areEqual(this.kycLevel, userInfoRpcResult.kycLevel) && Intrinsics.areEqual(this.loginStatus, userInfoRpcResult.loginStatus) && Intrinsics.areEqual(this.userStatus, userInfoRpcResult.userStatus) && Intrinsics.areEqual(this.ncc, userInfoRpcResult.ncc) && Intrinsics.areEqual(this.loginId, userInfoRpcResult.loginId) && Intrinsics.areEqual(this.nickname, userInfoRpcResult.nickname) && Intrinsics.areEqual(this.pendingTransaction, userInfoRpcResult.pendingTransaction) && Intrinsics.areEqual(this.shortcode, userInfoRpcResult.shortcode) && this.faceAuthStatus == userInfoRpcResult.faceAuthStatus && this.enrollStatus == userInfoRpcResult.enrollStatus && this.faceLoginReady == userInfoRpcResult.faceLoginReady && Intrinsics.areEqual(this.username, userInfoRpcResult.username);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.accountStatus;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.avatarUrl;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        CurrencyAmountResult currencyAmountResult = this.balance;
        int hashCode3 = currencyAmountResult == null ? 0 : currencyAmountResult.hashCode();
        String str3 = this.ktpName;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.ktpId;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        KybEntity kybEntity = this.kybInfo;
        int hashCode6 = kybEntity == null ? 0 : kybEntity.hashCode();
        KycEntity kycEntity = this.kyc;
        int hashCode7 = kycEntity == null ? 0 : kycEntity.hashCode();
        boolean z = this.kycCertified;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str5 = this.kycLevel;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.loginStatus;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.userStatus;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.ncc;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.loginId;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.nickname;
        int hashCode13 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.pendingTransaction;
        int hashCode14 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.shortcode;
        int hashCode15 = str12 == null ? 0 : str12.hashCode();
        boolean z2 = this.faceAuthStatus;
        int i2 = z2 ? 1 : z2 ? 1 : 0;
        boolean z3 = this.enrollStatus;
        int i3 = z3 ? 1 : z3 ? 1 : 0;
        boolean z4 = this.faceLoginReady;
        int i4 = !z4 ? z4 ? 1 : 0 : 1;
        String str13 = this.username;
        return (((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + (str13 != null ? str13.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfoRpcResult(accountStatus=");
        sb.append(this.accountStatus);
        sb.append(", avatarUrl=");
        sb.append(this.avatarUrl);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", ktpName=");
        sb.append(this.ktpName);
        sb.append(", ktpId=");
        sb.append(this.ktpId);
        sb.append(", kybInfo=");
        sb.append(this.kybInfo);
        sb.append(", kyc=");
        sb.append(this.kyc);
        sb.append(", kycCertified=");
        sb.append(this.kycCertified);
        sb.append(", kycLevel=");
        sb.append(this.kycLevel);
        sb.append(", loginStatus=");
        sb.append(this.loginStatus);
        sb.append(", userStatus=");
        sb.append(this.userStatus);
        sb.append(", ncc=");
        sb.append(this.ncc);
        sb.append(", loginId=");
        sb.append(this.loginId);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", pendingTransaction=");
        sb.append(this.pendingTransaction);
        sb.append(", shortcode=");
        sb.append(this.shortcode);
        sb.append(", faceAuthStatus=");
        sb.append(this.faceAuthStatus);
        sb.append(", enrollStatus=");
        sb.append(this.enrollStatus);
        sb.append(", faceLoginReady=");
        sb.append(this.faceLoginReady);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserInfoRpcResult(String str, String str2, CurrencyAmountResult currencyAmountResult, String str3, String str4, KybEntity kybEntity, KycEntity kycEntity, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3, boolean z4, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : currencyAmountResult, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : kybEntity, (i & 64) != 0 ? null : kycEntity, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : str9, (i & 8192) != 0 ? null : str10, (i & 16384) != 0 ? null : str11, (i & 32768) != 0 ? null : str12, (i & 65536) != 0 ? false : z2, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? false : z3, (i & 262144) != 0 ? false : z4, (i & 524288) != 0 ? "" : str13);
    }

    @JvmName(name = "getAccountStatus")
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    @JvmName(name = "setAccountStatus")
    public final void setAccountStatus(String str) {
        this.accountStatus = str;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @JvmName(name = "setAvatarUrl")
    public final void setAvatarUrl(String str) {
        this.avatarUrl = str;
    }

    @JvmName(name = "getBalance")
    public final CurrencyAmountResult getBalance() {
        return this.balance;
    }

    @JvmName(name = "setBalance")
    public final void setBalance(CurrencyAmountResult currencyAmountResult) {
        this.balance = currencyAmountResult;
    }

    @JvmName(name = "getKtpName")
    public final String getKtpName() {
        return this.ktpName;
    }

    @JvmName(name = "setKtpName")
    public final void setKtpName(String str) {
        this.ktpName = str;
    }

    @JvmName(name = "getKtpId")
    public final String getKtpId() {
        return this.ktpId;
    }

    @JvmName(name = "setKtpId")
    public final void setKtpId(String str) {
        this.ktpId = str;
    }

    @JvmName(name = "getKybInfo")
    public final KybEntity getKybInfo() {
        return this.kybInfo;
    }

    @JvmName(name = "setKybInfo")
    public final void setKybInfo(KybEntity kybEntity) {
        this.kybInfo = kybEntity;
    }

    @JvmName(name = "getKyc")
    public final KycEntity getKyc() {
        return this.kyc;
    }

    @JvmName(name = "setKyc")
    public final void setKyc(KycEntity kycEntity) {
        this.kyc = kycEntity;
    }

    @JvmName(name = "getKycCertified")
    public final boolean getKycCertified() {
        return this.kycCertified;
    }

    @JvmName(name = "setKycCertified")
    public final void setKycCertified(boolean z) {
        this.kycCertified = z;
    }

    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        return this.kycLevel;
    }

    @JvmName(name = "setKycLevel")
    public final void setKycLevel(String str) {
        this.kycLevel = str;
    }

    @JvmName(name = "getLoginStatus")
    public final String getLoginStatus() {
        return this.loginStatus;
    }

    @JvmName(name = "setLoginStatus")
    public final void setLoginStatus(String str) {
        this.loginStatus = str;
    }

    @JvmName(name = "getUserStatus")
    public final String getUserStatus() {
        return this.userStatus;
    }

    @JvmName(name = "setUserStatus")
    public final void setUserStatus(String str) {
        this.userStatus = str;
    }

    @JvmName(name = "getNcc")
    public final String getNcc() {
        return this.ncc;
    }

    @JvmName(name = "setNcc")
    public final void setNcc(String str) {
        this.ncc = str;
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "setLoginId")
    public final void setLoginId(String str) {
        this.loginId = str;
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "setNickname")
    public final void setNickname(String str) {
        this.nickname = str;
    }

    @JvmName(name = "getPendingTransaction")
    public final String getPendingTransaction() {
        return this.pendingTransaction;
    }

    @JvmName(name = "setPendingTransaction")
    public final void setPendingTransaction(String str) {
        this.pendingTransaction = str;
    }

    @JvmName(name = "getShortcode")
    public final String getShortcode() {
        return this.shortcode;
    }

    @JvmName(name = "setShortcode")
    public final void setShortcode(String str) {
        this.shortcode = str;
    }

    @JvmName(name = "getFaceAuthStatus")
    public final boolean getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    @JvmName(name = "setFaceAuthStatus")
    public final void setFaceAuthStatus(boolean z) {
        this.faceAuthStatus = z;
    }

    @JvmName(name = "getEnrollStatus")
    public final boolean getEnrollStatus() {
        return this.enrollStatus;
    }

    @JvmName(name = "setEnrollStatus")
    public final void setEnrollStatus(boolean z) {
        this.enrollStatus = z;
    }

    @JvmName(name = "getFaceLoginReady")
    public final boolean getFaceLoginReady() {
        return this.faceLoginReady;
    }

    @JvmName(name = "setFaceLoginReady")
    public final void setFaceLoginReady(boolean z) {
        this.faceLoginReady = z;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "setUsername")
    public final void setUsername(String str) {
        this.username = str;
    }

    public UserInfoRpcResult(String str, String str2, CurrencyAmountResult currencyAmountResult, String str3, String str4, KybEntity kybEntity, KycEntity kycEntity, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z2, boolean z3, boolean z4, String str13) {
        this.accountStatus = str;
        this.avatarUrl = str2;
        this.balance = currencyAmountResult;
        this.ktpName = str3;
        this.ktpId = str4;
        this.kybInfo = kybEntity;
        this.kyc = kycEntity;
        this.kycCertified = z;
        this.kycLevel = str5;
        this.loginStatus = str6;
        this.userStatus = str7;
        this.ncc = str8;
        this.loginId = str9;
        this.nickname = str10;
        this.pendingTransaction = str11;
        this.shortcode = str12;
        this.faceAuthStatus = z2;
        this.enrollStatus = z3;
        this.faceLoginReady = z4;
        this.username = str13;
    }

    @JvmName(name = "getUserPan")
    public final String getUserPan() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ncc);
        sb.append(this.shortcode);
        return sb.toString();
    }
}
