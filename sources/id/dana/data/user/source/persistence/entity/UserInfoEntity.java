package id.dana.data.user.source.persistence.entity;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.wallet_v3.constant.WalletConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bg\u0010hJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000eJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u008a\u0002\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00106\u001a\u000205HÖ\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b8\u0010\u0004R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00109\u001a\u0004\b:\u0010\u0004\"\u0004\b;\u0010<R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00109\u001a\u0004\b=\u0010\u0004\"\u0004\b>\u0010<R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00109\u001a\u0004\b?\u0010\u0004\"\u0004\b@\u0010<R$\u0010,\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010A\u001a\u0004\bB\u0010\u000e\"\u0004\bC\u0010DR$\u0010+\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010A\u001a\u0004\bE\u0010\u000e\"\u0004\bF\u0010DR$\u0010-\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010A\u001a\u0004\bG\u0010\u000e\"\u0004\bH\u0010DR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00109\u001a\u0004\bI\u0010\u0004\"\u0004\bJ\u0010<R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00109\u001a\u0004\bK\u0010\u0004\"\u0004\bL\u0010<R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u00109\u001a\u0004\bM\u0010\u0004\"\u0004\bN\u0010<R$\u0010\"\u001a\u0004\u0018\u00010\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010A\u001a\u0004\bO\u0010\u000e\"\u0004\bP\u0010DR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00109\u001a\u0004\bQ\u0010\u0004\"\u0004\bR\u0010<R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u00109\u001a\u0004\bS\u0010\u0004\"\u0004\bT\u0010<R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00109\u001a\u0004\bU\u0010\u0004\"\u0004\bV\u0010<R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00109\u001a\u0004\bW\u0010\u0004\"\u0004\bX\u0010<R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u00109\u001a\u0004\bY\u0010\u0004\"\u0004\bZ\u0010<R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u00109\u001a\u0004\b[\u0010\u0004\"\u0004\b\\\u0010<R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u00109\u001a\u0004\b]\u0010\u0004\"\u0004\b^\u0010<R\"\u0010\u001b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u00109\u001a\u0004\b_\u0010\u0004\"\u0004\b`\u0010<R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00109\u001a\u0004\ba\u0010\u0004\"\u0004\bb\u0010<R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u00109\u001a\u0004\bc\u0010\u0004\"\u0004\bd\u0010<R$\u0010.\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u00109\u001a\u0004\be\u0010\u0004\"\u0004\bf\u0010<"}, d2 = {"Lid/dana/data/user/source/persistence/entity/UserInfoEntity;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "", "component17", "()Ljava/lang/Boolean;", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "userId", "accountStatus", AccountEntityRepository.UpdateType.AVATAR, "balance", "ktpName", "kybInfo", "kyc", "kycCertified", WalletConstant.KYC_LEVEL, "loginStatus", "userStatus", "ncc", BranchLinkConstant.Params.LOGIN_ID, "nickname", "pendingTransaction", "shortcode", "faceAuthStatus", "enrollStatus", "faceLoginReady", "username", "userPan", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/user/source/persistence/entity/UserInfoEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountStatus", "setAccountStatus", "(Ljava/lang/String;)V", "getAvatarUrl", "setAvatarUrl", "getBalance", "setBalance", "Ljava/lang/Boolean;", "getEnrollStatus", "setEnrollStatus", "(Ljava/lang/Boolean;)V", "getFaceAuthStatus", "setFaceAuthStatus", "getFaceLoginReady", "setFaceLoginReady", "getKtpName", "setKtpName", "getKybInfo", "setKybInfo", "getKyc", "setKyc", "getKycCertified", "setKycCertified", "getKycLevel", "setKycLevel", "getLoginId", "setLoginId", "getLoginStatus", "setLoginStatus", "getNcc", "setNcc", "getNickname", "setNickname", "getPendingTransaction", "setPendingTransaction", "getShortcode", "setShortcode", "getUserId", "setUserId", "getUserPan", "setUserPan", "getUserStatus", "setUserStatus", BridgeName.GET_USERNAME, "setUsername", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserInfoEntity {
    private String accountStatus;
    private String avatarUrl;
    private String balance;
    private Boolean enrollStatus;
    private Boolean faceAuthStatus;
    private Boolean faceLoginReady;
    private String ktpName;
    private String kybInfo;
    private String kyc;
    private Boolean kycCertified;
    private String kycLevel;
    private String loginId;
    private String loginStatus;
    private String ncc;
    private String nickname;
    private String pendingTransaction;
    private String shortcode;
    private String userId;
    private String userPan;
    private String userStatus;
    private String username;

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
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
    public final Boolean getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    /* renamed from: component18  reason: from getter */
    public final Boolean getEnrollStatus() {
        return this.enrollStatus;
    }

    /* renamed from: component19  reason: from getter */
    public final Boolean getFaceLoginReady() {
        return this.faceLoginReady;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    /* renamed from: component20  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component21  reason: from getter */
    public final String getUserPan() {
        return this.userPan;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBalance() {
        return this.balance;
    }

    /* renamed from: component5  reason: from getter */
    public final String getKtpName() {
        return this.ktpName;
    }

    /* renamed from: component6  reason: from getter */
    public final String getKybInfo() {
        return this.kybInfo;
    }

    /* renamed from: component7  reason: from getter */
    public final String getKyc() {
        return this.kyc;
    }

    /* renamed from: component8  reason: from getter */
    public final Boolean getKycCertified() {
        return this.kycCertified;
    }

    /* renamed from: component9  reason: from getter */
    public final String getKycLevel() {
        return this.kycLevel;
    }

    public final UserInfoEntity copy(String userId, String accountStatus, String avatarUrl, String balance, String ktpName, String kybInfo, String kyc, Boolean kycCertified, String kycLevel, String loginStatus, String userStatus, String ncc, String loginId, String nickname, String pendingTransaction, String shortcode, Boolean faceAuthStatus, Boolean enrollStatus, Boolean faceLoginReady, String username, String userPan) {
        Intrinsics.checkNotNullParameter(userId, "");
        return new UserInfoEntity(userId, accountStatus, avatarUrl, balance, ktpName, kybInfo, kyc, kycCertified, kycLevel, loginStatus, userStatus, ncc, loginId, nickname, pendingTransaction, shortcode, faceAuthStatus, enrollStatus, faceLoginReady, username, userPan);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserInfoEntity) {
            UserInfoEntity userInfoEntity = (UserInfoEntity) other;
            return Intrinsics.areEqual(this.userId, userInfoEntity.userId) && Intrinsics.areEqual(this.accountStatus, userInfoEntity.accountStatus) && Intrinsics.areEqual(this.avatarUrl, userInfoEntity.avatarUrl) && Intrinsics.areEqual(this.balance, userInfoEntity.balance) && Intrinsics.areEqual(this.ktpName, userInfoEntity.ktpName) && Intrinsics.areEqual(this.kybInfo, userInfoEntity.kybInfo) && Intrinsics.areEqual(this.kyc, userInfoEntity.kyc) && Intrinsics.areEqual(this.kycCertified, userInfoEntity.kycCertified) && Intrinsics.areEqual(this.kycLevel, userInfoEntity.kycLevel) && Intrinsics.areEqual(this.loginStatus, userInfoEntity.loginStatus) && Intrinsics.areEqual(this.userStatus, userInfoEntity.userStatus) && Intrinsics.areEqual(this.ncc, userInfoEntity.ncc) && Intrinsics.areEqual(this.loginId, userInfoEntity.loginId) && Intrinsics.areEqual(this.nickname, userInfoEntity.nickname) && Intrinsics.areEqual(this.pendingTransaction, userInfoEntity.pendingTransaction) && Intrinsics.areEqual(this.shortcode, userInfoEntity.shortcode) && Intrinsics.areEqual(this.faceAuthStatus, userInfoEntity.faceAuthStatus) && Intrinsics.areEqual(this.enrollStatus, userInfoEntity.enrollStatus) && Intrinsics.areEqual(this.faceLoginReady, userInfoEntity.faceLoginReady) && Intrinsics.areEqual(this.username, userInfoEntity.username) && Intrinsics.areEqual(this.userPan, userInfoEntity.userPan);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.userId.hashCode();
        String str = this.accountStatus;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.avatarUrl;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.balance;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.ktpName;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.kybInfo;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.kyc;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        Boolean bool = this.kycCertified;
        int hashCode8 = bool == null ? 0 : bool.hashCode();
        String str7 = this.kycLevel;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.loginStatus;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.userStatus;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.ncc;
        int hashCode12 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.loginId;
        int hashCode13 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.nickname;
        int hashCode14 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.pendingTransaction;
        int hashCode15 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.shortcode;
        int hashCode16 = str14 == null ? 0 : str14.hashCode();
        Boolean bool2 = this.faceAuthStatus;
        int hashCode17 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.enrollStatus;
        int hashCode18 = bool3 == null ? 0 : bool3.hashCode();
        Boolean bool4 = this.faceLoginReady;
        int hashCode19 = bool4 == null ? 0 : bool4.hashCode();
        String str15 = this.username;
        int hashCode20 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.userPan;
        return (((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + (str16 != null ? str16.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfoEntity(userId=");
        sb.append(this.userId);
        sb.append(", accountStatus=");
        sb.append(this.accountStatus);
        sb.append(", avatarUrl=");
        sb.append(this.avatarUrl);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", ktpName=");
        sb.append(this.ktpName);
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
        sb.append(", userPan=");
        sb.append(this.userPan);
        sb.append(')');
        return sb.toString();
    }

    public UserInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Boolean bool2, Boolean bool3, Boolean bool4, String str16, String str17) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userId = str;
        this.accountStatus = str2;
        this.avatarUrl = str3;
        this.balance = str4;
        this.ktpName = str5;
        this.kybInfo = str6;
        this.kyc = str7;
        this.kycCertified = bool;
        this.kycLevel = str8;
        this.loginStatus = str9;
        this.userStatus = str10;
        this.ncc = str11;
        this.loginId = str12;
        this.nickname = str13;
        this.pendingTransaction = str14;
        this.shortcode = str15;
        this.faceAuthStatus = bool2;
        this.enrollStatus = bool3;
        this.faceLoginReady = bool4;
        this.username = str16;
        this.userPan = str17;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userId = str;
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
    public final String getBalance() {
        return this.balance;
    }

    @JvmName(name = "setBalance")
    public final void setBalance(String str) {
        this.balance = str;
    }

    @JvmName(name = "getKtpName")
    public final String getKtpName() {
        return this.ktpName;
    }

    @JvmName(name = "setKtpName")
    public final void setKtpName(String str) {
        this.ktpName = str;
    }

    @JvmName(name = "getKybInfo")
    public final String getKybInfo() {
        return this.kybInfo;
    }

    @JvmName(name = "setKybInfo")
    public final void setKybInfo(String str) {
        this.kybInfo = str;
    }

    @JvmName(name = "getKyc")
    public final String getKyc() {
        return this.kyc;
    }

    @JvmName(name = "setKyc")
    public final void setKyc(String str) {
        this.kyc = str;
    }

    public /* synthetic */ UserInfoEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Boolean bool2, Boolean bool3, Boolean bool4, String str16, String str17, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? Boolean.FALSE : bool, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14, (i & 32768) != 0 ? null : str15, (i & 65536) != 0 ? Boolean.FALSE : bool2, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? Boolean.FALSE : bool3, (i & 262144) != 0 ? Boolean.FALSE : bool4, (i & 524288) != 0 ? "" : str16, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) == 0 ? str17 : null);
    }

    @JvmName(name = "getKycCertified")
    public final Boolean getKycCertified() {
        return this.kycCertified;
    }

    @JvmName(name = "setKycCertified")
    public final void setKycCertified(Boolean bool) {
        this.kycCertified = bool;
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
    public final Boolean getFaceAuthStatus() {
        return this.faceAuthStatus;
    }

    @JvmName(name = "setFaceAuthStatus")
    public final void setFaceAuthStatus(Boolean bool) {
        this.faceAuthStatus = bool;
    }

    @JvmName(name = "getEnrollStatus")
    public final Boolean getEnrollStatus() {
        return this.enrollStatus;
    }

    @JvmName(name = "setEnrollStatus")
    public final void setEnrollStatus(Boolean bool) {
        this.enrollStatus = bool;
    }

    @JvmName(name = "getFaceLoginReady")
    public final Boolean getFaceLoginReady() {
        return this.faceLoginReady;
    }

    @JvmName(name = "setFaceLoginReady")
    public final void setFaceLoginReady(Boolean bool) {
        this.faceLoginReady = bool;
    }

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "setUsername")
    public final void setUsername(String str) {
        this.username = str;
    }

    @JvmName(name = "getUserPan")
    public final String getUserPan() {
        return this.userPan;
    }

    @JvmName(name = "setUserPan")
    public final void setUserPan(String str) {
        this.userPan = str;
    }
}
