package id.dana.network.response.login;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultWithHeader;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/network/response/login/VerifyPasswordRpcResult;", "Lid/dana/network/base/BaseRpcResultWithHeader;", "", "failedCount", "I", "getFailedCount", "()I", "", "lastFailedTime", "J", "getLastFailedTime", "()J", "lockedExpireSeconds", "getLockedExpireSeconds", "maxFailedCount", "getMaxFailedCount", "<init>", "(JIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VerifyPasswordRpcResult extends BaseRpcResultWithHeader {
    @SerializedName("failedCount")
    private final int failedCount;
    @SerializedName("lastFailedTime")
    private final long lastFailedTime;
    @SerializedName("lockedExpireSeconds")
    private final int lockedExpireSeconds;
    @SerializedName("maxFailedCount")
    private final int maxFailedCount;

    @JvmName(name = "getLastFailedTime")
    public final long getLastFailedTime() {
        return this.lastFailedTime;
    }

    @JvmName(name = "getLockedExpireSeconds")
    public final int getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    @JvmName(name = "getFailedCount")
    public final int getFailedCount() {
        return this.failedCount;
    }

    @JvmName(name = "getMaxFailedCount")
    public final int getMaxFailedCount() {
        return this.maxFailedCount;
    }

    public VerifyPasswordRpcResult(@JSONField(name = "lastFailedTime") long j, @JSONField(name = "lockedExpireSeconds") int i, @JSONField(name = "failedCount") int i2, @JSONField(name = "maxFailedCount") int i3) {
        this.lastFailedTime = j;
        this.lockedExpireSeconds = i;
        this.failedCount = i2;
        this.maxFailedCount = i3;
    }
}
