package id.dana.data.registration.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.account.repository.AccountEntityRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0003\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b)\u0010*R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010("}, d2 = {"Lid/dana/data/registration/source/network/result/Trust2RiskLoginResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", AccountEntityRepository.UpdateType.AVATAR, "Ljava/lang/String;", "getAvatarUrl", "()Ljava/lang/String;", "", "failedCount", "Ljava/lang/Integer;", "getFailedCount", "()Ljava/lang/Integer;", "leftTimes", "getLeftTimes", "lockedExpireSeconds", "getLockedExpireSeconds", "loginTokenId", "getLoginTokenId", "maxFailedCount", "getMaxFailedCount", "phoneNumber", "getPhoneNumber", "riskPhoneNumber", "getRiskPhoneNumber", BioUtilityBridge.SECURITY_ID, "getSecurityId", "sessionId", "getSessionId", "", "trustedDeviceEnrolled", "Ljava/lang/Boolean;", "getTrustedDeviceEnrolled", "()Ljava/lang/Boolean;", "userId", "getUserId", "", "Lid/dana/data/registration/source/network/result/VerificationMethodTrees;", "verificationMethodTrees", "Ljava/util/List;", "getVerificationMethodTrees", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Trust2RiskLoginResult extends BaseRpcResult {
    @SerializedName(AccountEntityRepository.UpdateType.AVATAR)
    private final String avatarUrl;
    @SerializedName("failedCount")
    private final Integer failedCount;
    @SerializedName("leftTimes")
    private final Integer leftTimes;
    @SerializedName("lockedExpireSeconds")
    private final Integer lockedExpireSeconds;
    @SerializedName("loginTokenId")
    private final String loginTokenId;
    @SerializedName("maxFailedCount")
    private final Integer maxFailedCount;
    @SerializedName("phoneNumber")
    private final String phoneNumber;
    @SerializedName("riskPhoneNumber")
    private final String riskPhoneNumber;
    @SerializedName(BioUtilityBridge.SECURITY_ID)
    private final String securityId;
    @SerializedName("sessionId")
    private final String sessionId;
    @SerializedName("trustedDeviceEnrolled")
    private final Boolean trustedDeviceEnrolled;
    @SerializedName("userId")
    private final String userId;
    @SerializedName("verificationMethodTrees")
    private final List<VerificationMethodTrees> verificationMethodTrees;

    public Trust2RiskLoginResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public /* synthetic */ Trust2RiskLoginResult(String str, String str2, String str3, List list, String str4, String str5, String str6, String str7, Integer num, Integer num2, Integer num3, Integer num4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : num4, (i & 4096) == 0 ? bool : null);
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

    @JvmName(name = "getVerificationMethodTrees")
    public final List<VerificationMethodTrees> getVerificationMethodTrees() {
        return this.verificationMethodTrees;
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

    public Trust2RiskLoginResult(@JSONField(name = "userId") String str, @JSONField(name = "sessionId") String str2, @JSONField(name = "securityId") String str3, @JSONField(name = "verificationMethodTrees") List<VerificationMethodTrees> list, @JSONField(name = "phoneNumber") String str4, @JSONField(name = "riskPhoneNumber") String str5, @JSONField(name = "avatarUrl") String str6, @JSONField(name = "loginTokenId") String str7, @JSONField(name = "failedCount") Integer num, @JSONField(name = "maxFailedCount") Integer num2, @JSONField(name = "lockedExpireSeconds") Integer num3, @JSONField(name = "leftTimes") Integer num4, @JSONField(name = "trustedDeviceEnrolled") Boolean bool) {
        this.userId = str;
        this.sessionId = str2;
        this.securityId = str3;
        this.verificationMethodTrees = list;
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
}
