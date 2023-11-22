package id.dana.domain.model.rpc.response;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.domain.model.VerificationTreeNode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b(\u0010)R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006"}, d2 = {"Lid/dana/domain/model/rpc/response/Trust2RiskLoginResponse;", "", "", AccountEntityRepository.UpdateType.AVATAR, "Ljava/lang/String;", "getAvatarUrl", "()Ljava/lang/String;", "Lid/dana/domain/model/VerificationTreeNode;", "challenges", "Lid/dana/domain/model/VerificationTreeNode;", "getChallenges", "()Lid/dana/domain/model/VerificationTreeNode;", "", "failedCount", "Ljava/lang/Integer;", "getFailedCount", "()Ljava/lang/Integer;", "leftTimes", "getLeftTimes", "lockedExpireSeconds", "getLockedExpireSeconds", "loginTokenId", "getLoginTokenId", "maxFailedCount", "getMaxFailedCount", "phoneNumber", "getPhoneNumber", "riskPhoneNumber", "getRiskPhoneNumber", BioUtilityBridge.SECURITY_ID, "getSecurityId", "sessionId", "getSessionId", "", "trustedDeviceEnrolled", "Ljava/lang/Boolean;", "getTrustedDeviceEnrolled", "()Ljava/lang/Boolean;", "userId", "getUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/model/VerificationTreeNode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Trust2RiskLoginResponse {
    private final String avatarUrl;
    private final VerificationTreeNode challenges;
    private final Integer failedCount;
    private final Integer leftTimes;
    private final Integer lockedExpireSeconds;
    private final String loginTokenId;
    private final Integer maxFailedCount;
    private final String phoneNumber;
    private final String riskPhoneNumber;
    private final String securityId;
    private final String sessionId;
    private final Boolean trustedDeviceEnrolled;
    private final String userId;

    public Trust2RiskLoginResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public Trust2RiskLoginResponse(String str, String str2, String str3, VerificationTreeNode verificationTreeNode, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool) {
        this.userId = str;
        this.sessionId = str2;
        this.securityId = str3;
        this.challenges = verificationTreeNode;
        this.phoneNumber = str4;
        this.riskPhoneNumber = str5;
        this.avatarUrl = str6;
        this.loginTokenId = str7;
        this.failedCount = num;
        this.maxFailedCount = num2;
        this.lockedExpireSeconds = num3;
        this.leftTimes = num4;
        this.trustedDeviceEnrolled = bool;
    }

    public /* synthetic */ Trust2RiskLoginResponse(String str, String str2, String str3, VerificationTreeNode verificationTreeNode, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : verificationTreeNode, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : num4, (i & 4096) == 0 ? bool : null);
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getSessionId")
    public final String getSessionId() {
        return this.sessionId;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "getChallenges")
    public final VerificationTreeNode getChallenges() {
        return this.challenges;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getRiskPhoneNumber")
    public final String getRiskPhoneNumber() {
        return this.riskPhoneNumber;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @JvmName(name = "getLoginTokenId")
    public final String getLoginTokenId() {
        return this.loginTokenId;
    }

    @JvmName(name = "getFailedCount")
    public final Integer getFailedCount() {
        return this.failedCount;
    }

    @JvmName(name = "getMaxFailedCount")
    public final Integer getMaxFailedCount() {
        return this.maxFailedCount;
    }

    @JvmName(name = "getLockedExpireSeconds")
    public final Integer getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    @JvmName(name = "getLeftTimes")
    public final Integer getLeftTimes() {
        return this.leftTimes;
    }

    @JvmName(name = "getTrustedDeviceEnrolled")
    public final Boolean getTrustedDeviceEnrolled() {
        return this.trustedDeviceEnrolled;
    }
}
