package id.dana.network.response.login;

import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.network.base.BaseRpcResultAphome;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0006R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0006R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0006R\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0006R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/network/response/login/LoginRpcResult;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "toString", "()Ljava/lang/String;", "clientKey", "Ljava/lang/String;", "Lid/dana/network/response/login/EvUrlStatusResult;", "evUrlStatusResult", "Lid/dana/network/response/login/EvUrlStatusResult;", "getEvUrlStatusResult", "()Lid/dana/network/response/login/EvUrlStatusResult;", "setEvUrlStatusResult", "(Lid/dana/network/response/login/EvUrlStatusResult;)V", "", "expiredAt", "J", "getExpiredAt", "()J", "setExpiredAt", "(J)V", "", "failedCount", "I", "key", "lastFailedTime", "leftTimes", "lockedExpireSeconds", "maxFailedCount", "pin", BioUtilityBridge.SECURITY_ID, "sessionId", "userId", "Lid/dana/network/response/login/RpcUserInfo;", "userInfo", "Lid/dana/network/response/login/RpcUserInfo;", "", "userInfoCompleted", "Z", "", "verificationMethods", "Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginRpcResult extends BaseRpcResultAphome {
    public String clientKey;
    private EvUrlStatusResult evUrlStatusResult;
    public int failedCount;
    public String key;
    public int leftTimes;
    public int lockedExpireSeconds;
    public int maxFailedCount;
    public String pin;
    public String securityId;
    public String sessionId;
    public String userId;
    public RpcUserInfo userInfo;
    public boolean userInfoCompleted;
    public List<String> verificationMethods;
    public long lastFailedTime = -1;
    private long expiredAt = -1;

    @JvmName(name = "getEvUrlStatusResult")
    public final EvUrlStatusResult getEvUrlStatusResult() {
        return this.evUrlStatusResult;
    }

    @JvmName(name = "setEvUrlStatusResult")
    public final void setEvUrlStatusResult(EvUrlStatusResult evUrlStatusResult) {
        this.evUrlStatusResult = evUrlStatusResult;
    }

    @JvmName(name = "getExpiredAt")
    public final long getExpiredAt() {
        return this.expiredAt;
    }

    @JvmName(name = "setExpiredAt")
    public final void setExpiredAt(long j) {
        this.expiredAt = j;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginRpcResult(userId=");
        sb.append(this.userId);
        sb.append(", sessionId=");
        sb.append(this.sessionId);
        sb.append(", clientKey=");
        sb.append(this.clientKey);
        sb.append(", userInfoCompleted=");
        sb.append(this.userInfoCompleted);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethods=");
        sb.append(this.verificationMethods);
        sb.append(", failedCount=");
        sb.append(this.failedCount);
        sb.append(", leftTimes=");
        sb.append(this.leftTimes);
        sb.append(", maxFailedCount=");
        sb.append(this.maxFailedCount);
        sb.append(", lockedExpireSeconds=");
        sb.append(this.lockedExpireSeconds);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(", evUrlStatusResult=");
        sb.append(this.evUrlStatusResult);
        sb.append(", pin=");
        sb.append(this.pin);
        sb.append(", key=");
        sb.append(this.key);
        sb.append(')');
        return sb.toString();
    }
}
