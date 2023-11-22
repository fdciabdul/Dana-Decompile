package id.dana.domain.user;

import id.dana.danah5.constant.BridgeName;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.homeinfo.KybResponse;
import id.dana.domain.homeinfo.KycResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001BÙ\u0001\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u000b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010)\u001a\u00020\b\u0012\b\b\u0002\u0010*\u001a\u00020\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u00100\u001a\u00020\u0005\u0012\b\b\u0002\u00101\u001a\u00020\u0005¢\u0006\u0004\bj\u0010kJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\rJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0007J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0007Jâ\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010#\u001a\u00020\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00100\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b2\u00103J\u001a\u00105\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00108\u001a\u000207HÖ\u0001¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u000b¢\u0006\u0004\b:\u0010\rJ\r\u0010;\u001a\u00020\u000b¢\u0006\u0004\b;\u0010\rJ\u0010\u0010<\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b<\u0010\u0007R$\u0010-\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010=\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010@R\"\u00101\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010=\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010@R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010C\u001a\u0004\bD\u0010\u0004\"\u0004\bE\u0010FR\"\u0010+\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010G\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010JR\"\u0010*\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010G\u001a\u0004\b*\u0010\r\"\u0004\bK\u0010JR\"\u0010,\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010G\u001a\u0004\b,\u0010\r\"\u0004\bL\u0010JR\"\u0010#\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010G\u001a\u0004\b#\u0010\r\"\u0004\bM\u0010JR$\u0010!\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010=\u001a\u0004\bN\u0010\u0007\"\u0004\bO\u0010@R$\u0010 \u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010=\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010@R$\u0010\"\u001a\u0004\u0018\u00010\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010R\u001a\u0004\bS\u0010\u0019\"\u0004\bT\u0010UR$\u0010$\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010@R\"\u0010)\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010X\u001a\u0004\bY\u0010\n\"\u0004\bZ\u0010[R\"\u0010%\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010=\u001a\u0004\b\\\u0010\u0007\"\u0004\b]\u0010@R$\u0010.\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010=\u001a\u0004\b^\u0010\u0007\"\u0004\b_\u0010@R\"\u0010&\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010=\u001a\u0004\b`\u0010\u0007\"\u0004\ba\u0010@R$\u0010'\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010=\u001a\u0004\bb\u0010\u0007\"\u0004\bc\u0010@R$\u0010(\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010=\u001a\u0004\bd\u0010\u0007\"\u0004\be\u0010@R$\u0010/\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010=\u001a\u0004\bf\u0010\u0007\"\u0004\bg\u0010@R\"\u00100\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010=\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010@"}, d2 = {"Lid/dana/domain/user/UserInfoResponse;", "", "Lid/dana/domain/user/CurrencyAmount;", "component1", "()Lid/dana/domain/user/CurrencyAmount;", "", "component10", "()Ljava/lang/String;", "Lid/dana/domain/homeinfo/KycResponse;", "component11", "()Lid/dana/domain/homeinfo/KycResponse;", "", "component12", "()Z", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "Lid/dana/domain/homeinfo/KybResponse;", "component4", "()Lid/dana/domain/homeinfo/KybResponse;", "component5", "component6", "component7", "component8", "component9", "balance", "ktpName", "ktpId", "kybResponse", "isKycCertified", "kycInfo", BranchLinkConstant.Params.LOGIN_ID, "nickname", "pendingTransaction", "userPan", "kycResponse", "isFaceLoginEnabled", "hasFaceLoginEnrolled", "isFaceLoginReady", "accountStatus", "loginStatus", "userStatus", "username", AccountEntityRepository.UpdateType.AVATAR, "copy", "(Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/homeinfo/KybResponse;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/homeinfo/KycResponse;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/user/UserInfoResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isPremiumUser", "isUserAndAccountStatusEnable", "toString", "Ljava/lang/String;", "getAccountStatus", "setAccountStatus", "(Ljava/lang/String;)V", "getAvatarUrl", "setAvatarUrl", "Lid/dana/domain/user/CurrencyAmount;", "getBalance", "setBalance", "(Lid/dana/domain/user/CurrencyAmount;)V", "Z", "getHasFaceLoginEnrolled", "setHasFaceLoginEnrolled", "(Z)V", "setFaceLoginEnabled", "setFaceLoginReady", "setKycCertified", "getKtpId", "setKtpId", "getKtpName", "setKtpName", "Lid/dana/domain/homeinfo/KybResponse;", "getKybResponse", "setKybResponse", "(Lid/dana/domain/homeinfo/KybResponse;)V", "getKycInfo", "setKycInfo", "Lid/dana/domain/homeinfo/KycResponse;", "getKycResponse", "setKycResponse", "(Lid/dana/domain/homeinfo/KycResponse;)V", "getLoginId", "setLoginId", "getLoginStatus", "setLoginStatus", "getNickname", "setNickname", "getPendingTransaction", "setPendingTransaction", "getUserPan", "setUserPan", "getUserStatus", "setUserStatus", BridgeName.GET_USERNAME, "setUsername", "<init>", "(Lid/dana/domain/user/CurrencyAmount;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/homeinfo/KybResponse;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/homeinfo/KycResponse;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserInfoResponse {
    private String accountStatus;
    private String avatarUrl;
    private CurrencyAmount balance;
    private boolean hasFaceLoginEnrolled;
    private boolean isFaceLoginEnabled;
    private boolean isFaceLoginReady;
    private boolean isKycCertified;
    private String ktpId;
    private String ktpName;
    private KybResponse kybResponse;
    private String kycInfo;
    private KycResponse kycResponse;
    private String loginId;
    private String loginStatus;
    private String nickname;
    private String pendingTransaction;
    private String userPan;
    private String userStatus;
    private String username;

    public UserInfoResponse() {
        this(null, null, null, null, false, null, null, null, null, null, null, false, false, false, null, null, null, null, null, 524287, null);
    }

    /* renamed from: component1  reason: from getter */
    public final CurrencyAmount getBalance() {
        return this.balance;
    }

    /* renamed from: component10  reason: from getter */
    public final String getUserPan() {
        return this.userPan;
    }

    /* renamed from: component11  reason: from getter */
    public final KycResponse getKycResponse() {
        return this.kycResponse;
    }

    /* renamed from: component12  reason: from getter */
    public final boolean getIsFaceLoginEnabled() {
        return this.isFaceLoginEnabled;
    }

    /* renamed from: component13  reason: from getter */
    public final boolean getHasFaceLoginEnrolled() {
        return this.hasFaceLoginEnrolled;
    }

    /* renamed from: component14  reason: from getter */
    public final boolean getIsFaceLoginReady() {
        return this.isFaceLoginReady;
    }

    /* renamed from: component15  reason: from getter */
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    /* renamed from: component16  reason: from getter */
    public final String getLoginStatus() {
        return this.loginStatus;
    }

    /* renamed from: component17  reason: from getter */
    public final String getUserStatus() {
        return this.userStatus;
    }

    /* renamed from: component18  reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* renamed from: component19  reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component2  reason: from getter */
    public final String getKtpName() {
        return this.ktpName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getKtpId() {
        return this.ktpId;
    }

    /* renamed from: component4  reason: from getter */
    public final KybResponse getKybResponse() {
        return this.kybResponse;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getIsKycCertified() {
        return this.isKycCertified;
    }

    /* renamed from: component6  reason: from getter */
    public final String getKycInfo() {
        return this.kycInfo;
    }

    /* renamed from: component7  reason: from getter */
    public final String getLoginId() {
        return this.loginId;
    }

    /* renamed from: component8  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component9  reason: from getter */
    public final String getPendingTransaction() {
        return this.pendingTransaction;
    }

    public final UserInfoResponse copy(CurrencyAmount balance, String ktpName, String ktpId, KybResponse kybResponse, boolean isKycCertified, String kycInfo, String loginId, String nickname, String pendingTransaction, String userPan, KycResponse kycResponse, boolean isFaceLoginEnabled, boolean hasFaceLoginEnrolled, boolean isFaceLoginReady, String accountStatus, String loginStatus, String userStatus, String username, String avatarUrl) {
        Intrinsics.checkNotNullParameter(loginId, "");
        Intrinsics.checkNotNullParameter(nickname, "");
        Intrinsics.checkNotNullParameter(kycResponse, "");
        Intrinsics.checkNotNullParameter(username, "");
        Intrinsics.checkNotNullParameter(avatarUrl, "");
        return new UserInfoResponse(balance, ktpName, ktpId, kybResponse, isKycCertified, kycInfo, loginId, nickname, pendingTransaction, userPan, kycResponse, isFaceLoginEnabled, hasFaceLoginEnrolled, isFaceLoginReady, accountStatus, loginStatus, userStatus, username, avatarUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserInfoResponse) {
            UserInfoResponse userInfoResponse = (UserInfoResponse) other;
            return Intrinsics.areEqual(this.balance, userInfoResponse.balance) && Intrinsics.areEqual(this.ktpName, userInfoResponse.ktpName) && Intrinsics.areEqual(this.ktpId, userInfoResponse.ktpId) && Intrinsics.areEqual(this.kybResponse, userInfoResponse.kybResponse) && this.isKycCertified == userInfoResponse.isKycCertified && Intrinsics.areEqual(this.kycInfo, userInfoResponse.kycInfo) && Intrinsics.areEqual(this.loginId, userInfoResponse.loginId) && Intrinsics.areEqual(this.nickname, userInfoResponse.nickname) && Intrinsics.areEqual(this.pendingTransaction, userInfoResponse.pendingTransaction) && Intrinsics.areEqual(this.userPan, userInfoResponse.userPan) && Intrinsics.areEqual(this.kycResponse, userInfoResponse.kycResponse) && this.isFaceLoginEnabled == userInfoResponse.isFaceLoginEnabled && this.hasFaceLoginEnrolled == userInfoResponse.hasFaceLoginEnrolled && this.isFaceLoginReady == userInfoResponse.isFaceLoginReady && Intrinsics.areEqual(this.accountStatus, userInfoResponse.accountStatus) && Intrinsics.areEqual(this.loginStatus, userInfoResponse.loginStatus) && Intrinsics.areEqual(this.userStatus, userInfoResponse.userStatus) && Intrinsics.areEqual(this.username, userInfoResponse.username) && Intrinsics.areEqual(this.avatarUrl, userInfoResponse.avatarUrl);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        CurrencyAmount currencyAmount = this.balance;
        int hashCode = currencyAmount == null ? 0 : currencyAmount.hashCode();
        String str = this.ktpName;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.ktpId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        KybResponse kybResponse = this.kybResponse;
        int hashCode4 = kybResponse == null ? 0 : kybResponse.hashCode();
        boolean z = this.isKycCertified;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str3 = this.kycInfo;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        int hashCode6 = this.loginId.hashCode();
        int hashCode7 = this.nickname.hashCode();
        String str4 = this.pendingTransaction;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.userPan;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        int hashCode10 = this.kycResponse.hashCode();
        boolean z2 = this.isFaceLoginEnabled;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        boolean z3 = this.hasFaceLoginEnrolled;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        boolean z4 = this.isFaceLoginReady;
        int i4 = z4 ? 1 : z4 ? 1 : 0;
        String str6 = this.accountStatus;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.loginStatus;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.userStatus;
        return (((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + hashCode11) * 31) + hashCode12) * 31) + (str8 != null ? str8.hashCode() : 0)) * 31) + this.username.hashCode()) * 31) + this.avatarUrl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserInfoResponse(balance=");
        sb.append(this.balance);
        sb.append(", ktpName=");
        sb.append(this.ktpName);
        sb.append(", ktpId=");
        sb.append(this.ktpId);
        sb.append(", kybResponse=");
        sb.append(this.kybResponse);
        sb.append(", isKycCertified=");
        sb.append(this.isKycCertified);
        sb.append(", kycInfo=");
        sb.append(this.kycInfo);
        sb.append(", loginId=");
        sb.append(this.loginId);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", pendingTransaction=");
        sb.append(this.pendingTransaction);
        sb.append(", userPan=");
        sb.append(this.userPan);
        sb.append(", kycResponse=");
        sb.append(this.kycResponse);
        sb.append(", isFaceLoginEnabled=");
        sb.append(this.isFaceLoginEnabled);
        sb.append(", hasFaceLoginEnrolled=");
        sb.append(this.hasFaceLoginEnrolled);
        sb.append(", isFaceLoginReady=");
        sb.append(this.isFaceLoginReady);
        sb.append(", accountStatus=");
        sb.append(this.accountStatus);
        sb.append(", loginStatus=");
        sb.append(this.loginStatus);
        sb.append(", userStatus=");
        sb.append(this.userStatus);
        sb.append(", username=");
        sb.append(this.username);
        sb.append(", avatarUrl=");
        sb.append(this.avatarUrl);
        sb.append(')');
        return sb.toString();
    }

    public UserInfoResponse(CurrencyAmount currencyAmount, String str, String str2, KybResponse kybResponse, boolean z, String str3, String str4, String str5, String str6, String str7, KycResponse kycResponse, boolean z2, boolean z3, boolean z4, String str8, String str9, String str10, String str11, String str12) {
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(kycResponse, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        this.balance = currencyAmount;
        this.ktpName = str;
        this.ktpId = str2;
        this.kybResponse = kybResponse;
        this.isKycCertified = z;
        this.kycInfo = str3;
        this.loginId = str4;
        this.nickname = str5;
        this.pendingTransaction = str6;
        this.userPan = str7;
        this.kycResponse = kycResponse;
        this.isFaceLoginEnabled = z2;
        this.hasFaceLoginEnrolled = z3;
        this.isFaceLoginReady = z4;
        this.accountStatus = str8;
        this.loginStatus = str9;
        this.userStatus = str10;
        this.username = str11;
        this.avatarUrl = str12;
    }

    @JvmName(name = "getBalance")
    public final CurrencyAmount getBalance() {
        return this.balance;
    }

    @JvmName(name = "setBalance")
    public final void setBalance(CurrencyAmount currencyAmount) {
        this.balance = currencyAmount;
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

    @JvmName(name = "getKybResponse")
    public final KybResponse getKybResponse() {
        return this.kybResponse;
    }

    @JvmName(name = "setKybResponse")
    public final void setKybResponse(KybResponse kybResponse) {
        this.kybResponse = kybResponse;
    }

    @JvmName(name = "isKycCertified")
    public final boolean isKycCertified() {
        return this.isKycCertified;
    }

    @JvmName(name = "setKycCertified")
    public final void setKycCertified(boolean z) {
        this.isKycCertified = z;
    }

    @JvmName(name = "getKycInfo")
    public final String getKycInfo() {
        return this.kycInfo;
    }

    @JvmName(name = "setKycInfo")
    public final void setKycInfo(String str) {
        this.kycInfo = str;
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "setLoginId")
    public final void setLoginId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.loginId = str;
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "setNickname")
    public final void setNickname(String str) {
        Intrinsics.checkNotNullParameter(str, "");
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

    @JvmName(name = "getUserPan")
    public final String getUserPan() {
        return this.userPan;
    }

    @JvmName(name = "setUserPan")
    public final void setUserPan(String str) {
        this.userPan = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ UserInfoResponse(id.dana.domain.user.CurrencyAmount r21, java.lang.String r22, java.lang.String r23, id.dana.domain.homeinfo.KybResponse r24, boolean r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, id.dana.domain.homeinfo.KycResponse r31, boolean r32, boolean r33, boolean r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.user.UserInfoResponse.<init>(id.dana.domain.user.CurrencyAmount, java.lang.String, java.lang.String, id.dana.domain.homeinfo.KybResponse, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, id.dana.domain.homeinfo.KycResponse, boolean, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getKycResponse")
    public final KycResponse getKycResponse() {
        return this.kycResponse;
    }

    @JvmName(name = "setKycResponse")
    public final void setKycResponse(KycResponse kycResponse) {
        Intrinsics.checkNotNullParameter(kycResponse, "");
        this.kycResponse = kycResponse;
    }

    @JvmName(name = "isFaceLoginEnabled")
    public final boolean isFaceLoginEnabled() {
        return this.isFaceLoginEnabled;
    }

    @JvmName(name = "setFaceLoginEnabled")
    public final void setFaceLoginEnabled(boolean z) {
        this.isFaceLoginEnabled = z;
    }

    @JvmName(name = "getHasFaceLoginEnrolled")
    public final boolean getHasFaceLoginEnrolled() {
        return this.hasFaceLoginEnrolled;
    }

    @JvmName(name = "setHasFaceLoginEnrolled")
    public final void setHasFaceLoginEnrolled(boolean z) {
        this.hasFaceLoginEnrolled = z;
    }

    @JvmName(name = "isFaceLoginReady")
    public final boolean isFaceLoginReady() {
        return this.isFaceLoginReady;
    }

    @JvmName(name = "setFaceLoginReady")
    public final void setFaceLoginReady(boolean z) {
        this.isFaceLoginReady = z;
    }

    @JvmName(name = "getAccountStatus")
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    @JvmName(name = "setAccountStatus")
    public final void setAccountStatus(String str) {
        this.accountStatus = str;
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

    @JvmName(name = BridgeName.GET_USERNAME)
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "setUsername")
    public final void setUsername(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.username = str;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @JvmName(name = "setAvatarUrl")
    public final void setAvatarUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.avatarUrl = str;
    }

    public final boolean isPremiumUser() {
        return Intrinsics.areEqual("KYC2", this.kycResponse.getLevel()) && this.isKycCertified;
    }

    public final boolean isUserAndAccountStatusEnable() {
        return Intrinsics.areEqual("ENABLE", this.accountStatus) && Intrinsics.areEqual("ENABLE", this.userStatus);
    }
}
