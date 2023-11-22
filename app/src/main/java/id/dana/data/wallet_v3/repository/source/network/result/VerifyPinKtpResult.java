package id.dana.data.wallet_v3.repository.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B7\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/VerifyPinKtpResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "identifyFailedCount", "Ljava/lang/Integer;", "getIdentifyFailedCount", "()Ljava/lang/Integer;", "setIdentifyFailedCount", "(Ljava/lang/Integer;)V", "", "lastFailedTime", "Ljava/lang/Long;", "getLastFailedTime", "()Ljava/lang/Long;", "setLastFailedTime", "(Ljava/lang/Long;)V", "lockedExpireSeconds", "getLockedExpireSeconds", "setLockedExpireSeconds", "maxFailed", "getMaxFailed", "setMaxFailed", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VerifyPinKtpResult extends BaseRpcResult {
    @SerializedName("identifyFailedCount")
    private Integer identifyFailedCount;
    @SerializedName("lastFailedTime")
    private Long lastFailedTime;
    @SerializedName("lockedExpireSeconds")
    private Long lockedExpireSeconds;
    @SerializedName("maxFailed")
    private Integer maxFailed;

    public VerifyPinKtpResult() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ VerifyPinKtpResult(Long l, Integer num, Integer num2, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? null : l2);
    }

    @JvmName(name = "getLockedExpireSeconds")
    public final Long getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    @JvmName(name = "setLockedExpireSeconds")
    public final void setLockedExpireSeconds(Long l) {
        this.lockedExpireSeconds = l;
    }

    @JvmName(name = "getIdentifyFailedCount")
    public final Integer getIdentifyFailedCount() {
        return this.identifyFailedCount;
    }

    @JvmName(name = "setIdentifyFailedCount")
    public final void setIdentifyFailedCount(Integer num) {
        this.identifyFailedCount = num;
    }

    @JvmName(name = "getMaxFailed")
    public final Integer getMaxFailed() {
        return this.maxFailed;
    }

    @JvmName(name = "setMaxFailed")
    public final void setMaxFailed(Integer num) {
        this.maxFailed = num;
    }

    @JvmName(name = "getLastFailedTime")
    public final Long getLastFailedTime() {
        return this.lastFailedTime;
    }

    @JvmName(name = "setLastFailedTime")
    public final void setLastFailedTime(Long l) {
        this.lastFailedTime = l;
    }

    public VerifyPinKtpResult(@JSONField(name = "lockedExpireSeconds") Long l, @JSONField(name = "identifyFailedCount") Integer num, @JSONField(name = "maxFailed") Integer num2, @JSONField(name = "lastFailedTime") Long l2) {
        this.lockedExpireSeconds = l;
        this.identifyFailedCount = num;
        this.maxFailed = num2;
        this.lastFailedTime = l2;
    }
}
