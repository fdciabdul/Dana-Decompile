package id.dana.riskChallenges.data.verifypassword.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0001\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJX\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0016\b\u0003\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b%\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/Integer;", "", "component2", "()Ljava/lang/Long;", "component3", "component4", "", "", "component5", "()Ljava/util/Map;", "identifyFailedCount", "lastFailedTime", "lockedExpireSeconds", "maxFailed", "extendData", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/Map;)Lid/dana/riskChallenges/data/verifypassword/source/network/result/VerifyPasswordResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getExtendData", "Ljava/lang/Integer;", "getIdentifyFailedCount", "Ljava/lang/Long;", "getLastFailedTime", "getLockedExpireSeconds", "getMaxFailed", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class VerifyPasswordResult extends BaseRpcResult {
    @SerializedName("extendData")
    private final Map<String, String> extendData;
    @SerializedName("identifyFailedCount")
    private final Integer identifyFailedCount;
    @SerializedName("lastFailedTime")
    private final Long lastFailedTime;
    @SerializedName("lockedExpireSeconds")
    private final Long lockedExpireSeconds;
    @SerializedName("maxFailed")
    private final Integer maxFailed;

    public static /* synthetic */ VerifyPasswordResult copy$default(VerifyPasswordResult verifyPasswordResult, Integer num, Long l, Long l2, Integer num2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            num = verifyPasswordResult.identifyFailedCount;
        }
        if ((i & 2) != 0) {
            l = verifyPasswordResult.lastFailedTime;
        }
        Long l3 = l;
        if ((i & 4) != 0) {
            l2 = verifyPasswordResult.lockedExpireSeconds;
        }
        Long l4 = l2;
        if ((i & 8) != 0) {
            num2 = verifyPasswordResult.maxFailed;
        }
        Integer num3 = num2;
        Map<String, String> map2 = map;
        if ((i & 16) != 0) {
            map2 = verifyPasswordResult.extendData;
        }
        return verifyPasswordResult.copy(num, l3, l4, num3, map2);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getIdentifyFailedCount() {
        return this.identifyFailedCount;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getLastFailedTime() {
        return this.lastFailedTime;
    }

    /* renamed from: component3  reason: from getter */
    public final Long getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    /* renamed from: component4  reason: from getter */
    public final Integer getMaxFailed() {
        return this.maxFailed;
    }

    public final Map<String, String> component5() {
        return this.extendData;
    }

    public final VerifyPasswordResult copy(@JSONField(name = "identifyFailedCount") Integer identifyFailedCount, @JSONField(name = "lastFailedTime") Long lastFailedTime, @JSONField(name = "lockedExpireSeconds") Long lockedExpireSeconds, @JSONField(name = "maxFailed") Integer maxFailed, @JSONField(name = "extendData") Map<String, String> extendData) {
        return new VerifyPasswordResult(identifyFailedCount, lastFailedTime, lockedExpireSeconds, maxFailed, extendData);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyPasswordResult) {
            VerifyPasswordResult verifyPasswordResult = (VerifyPasswordResult) other;
            return Intrinsics.areEqual(this.identifyFailedCount, verifyPasswordResult.identifyFailedCount) && Intrinsics.areEqual(this.lastFailedTime, verifyPasswordResult.lastFailedTime) && Intrinsics.areEqual(this.lockedExpireSeconds, verifyPasswordResult.lockedExpireSeconds) && Intrinsics.areEqual(this.maxFailed, verifyPasswordResult.maxFailed) && Intrinsics.areEqual(this.extendData, verifyPasswordResult.extendData);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.identifyFailedCount;
        int hashCode = num == null ? 0 : num.hashCode();
        Long l = this.lastFailedTime;
        int hashCode2 = l == null ? 0 : l.hashCode();
        Long l2 = this.lockedExpireSeconds;
        int hashCode3 = l2 == null ? 0 : l2.hashCode();
        Integer num2 = this.maxFailed;
        int hashCode4 = num2 == null ? 0 : num2.hashCode();
        Map<String, String> map = this.extendData;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPasswordResult(identifyFailedCount=");
        sb.append(this.identifyFailedCount);
        sb.append(", lastFailedTime=");
        sb.append(this.lastFailedTime);
        sb.append(", lockedExpireSeconds=");
        sb.append(this.lockedExpireSeconds);
        sb.append(", maxFailed=");
        sb.append(this.maxFailed);
        sb.append(", extendData=");
        sb.append(this.extendData);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getIdentifyFailedCount")
    public final Integer getIdentifyFailedCount() {
        return this.identifyFailedCount;
    }

    @JvmName(name = "getLastFailedTime")
    public final Long getLastFailedTime() {
        return this.lastFailedTime;
    }

    @JvmName(name = "getLockedExpireSeconds")
    public final Long getLockedExpireSeconds() {
        return this.lockedExpireSeconds;
    }

    @JvmName(name = "getMaxFailed")
    public final Integer getMaxFailed() {
        return this.maxFailed;
    }

    @JvmName(name = "getExtendData")
    public final Map<String, String> getExtendData() {
        return this.extendData;
    }

    public VerifyPasswordResult(@JSONField(name = "identifyFailedCount") Integer num, @JSONField(name = "lastFailedTime") Long l, @JSONField(name = "lockedExpireSeconds") Long l2, @JSONField(name = "maxFailed") Integer num2, @JSONField(name = "extendData") Map<String, String> map) {
        this.identifyFailedCount = num;
        this.lastFailedTime = l;
        this.lockedExpireSeconds = l2;
        this.maxFailed = num2;
        this.extendData = map;
    }
}
