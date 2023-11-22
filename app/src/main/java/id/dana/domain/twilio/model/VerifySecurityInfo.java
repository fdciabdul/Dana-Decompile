package id.dana.domain.twilio.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0007\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0003\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jf\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0011\u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0014\u001a\u00020\u00072\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0014\b\u0003\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000eHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001e\u0010\fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b!\u0010\fR&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b#\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b'\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\t"}, d2 = {"Lid/dana/domain/twilio/model/VerifySecurityInfo;", "", "", "component1", "()I", "component2", "component3", "", "component4", "()Z", "", "component5", "()Ljava/lang/String;", "component6", "", "component7", "()Ljava/util/Map;", "identFailedCount", "maxFailedLimit", "lockedExpireMins", "success", "errorCode", "errorMessage", "extendInfo", "copy", "(IIIZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/twilio/model/VerifySecurityInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Ljava/lang/String;", "getErrorCode", "getErrorMessage", "Ljava/util/Map;", "getExtendInfo", "I", "getIdentFailedCount", "getLockedExpireMins", "getMaxFailedLimit", "Z", "getSuccess", "<init>", "(IIIZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VerifySecurityInfo {
    @SerializedName("errorCode")
    private final String errorCode;
    @SerializedName("errorMessage")
    private final String errorMessage;
    @SerializedName("extendInfo")
    private final Map<String, String> extendInfo;
    @SerializedName("identFailedCount")
    private final int identFailedCount;
    @SerializedName("lockedExpireMins")
    private final int lockedExpireMins;
    @SerializedName("maxFailedLimit")
    private final int maxFailedLimit;
    @SerializedName("success")
    private final boolean success;

    public VerifySecurityInfo() {
        this(0, 0, 0, false, null, null, null, 127, null);
    }

    public static /* synthetic */ VerifySecurityInfo copy$default(VerifySecurityInfo verifySecurityInfo, int i, int i2, int i3, boolean z, String str, String str2, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = verifySecurityInfo.identFailedCount;
        }
        if ((i4 & 2) != 0) {
            i2 = verifySecurityInfo.maxFailedLimit;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = verifySecurityInfo.lockedExpireMins;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            z = verifySecurityInfo.success;
        }
        boolean z2 = z;
        if ((i4 & 16) != 0) {
            str = verifySecurityInfo.errorCode;
        }
        String str3 = str;
        if ((i4 & 32) != 0) {
            str2 = verifySecurityInfo.errorMessage;
        }
        String str4 = str2;
        Map<String, String> map2 = map;
        if ((i4 & 64) != 0) {
            map2 = verifySecurityInfo.extendInfo;
        }
        return verifySecurityInfo.copy(i, i5, i6, z2, str3, str4, map2);
    }

    /* renamed from: component1  reason: from getter */
    public final int getIdentFailedCount() {
        return this.identFailedCount;
    }

    /* renamed from: component2  reason: from getter */
    public final int getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    /* renamed from: component3  reason: from getter */
    public final int getLockedExpireMins() {
        return this.lockedExpireMins;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component5  reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component6  reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Map<String, String> component7() {
        return this.extendInfo;
    }

    public final VerifySecurityInfo copy(@JSONField(name = "identFailedCount") int identFailedCount, @JSONField(name = "maxFailedLimit") int maxFailedLimit, @JSONField(name = "lockedExpireMins") int lockedExpireMins, @JSONField(name = "success") boolean success, @JSONField(name = "errorCode") String errorCode, @JSONField(name = "errorMessage") String errorMessage, @JSONField(name = "extendInfo") Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new VerifySecurityInfo(identFailedCount, maxFailedLimit, lockedExpireMins, success, errorCode, errorMessage, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifySecurityInfo) {
            VerifySecurityInfo verifySecurityInfo = (VerifySecurityInfo) other;
            return this.identFailedCount == verifySecurityInfo.identFailedCount && this.maxFailedLimit == verifySecurityInfo.maxFailedLimit && this.lockedExpireMins == verifySecurityInfo.lockedExpireMins && this.success == verifySecurityInfo.success && Intrinsics.areEqual(this.errorCode, verifySecurityInfo.errorCode) && Intrinsics.areEqual(this.errorMessage, verifySecurityInfo.errorMessage) && Intrinsics.areEqual(this.extendInfo, verifySecurityInfo.extendInfo);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int i = this.identFailedCount;
        int i2 = this.maxFailedLimit;
        int i3 = this.lockedExpireMins;
        boolean z = this.success;
        int i4 = z;
        if (z != 0) {
            i4 = 1;
        }
        String str = this.errorCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.errorMessage;
        return (((((((((((i * 31) + i2) * 31) + i3) * 31) + i4) * 31) + hashCode) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31) + this.extendInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifySecurityInfo(identFailedCount=");
        sb.append(this.identFailedCount);
        sb.append(", maxFailedLimit=");
        sb.append(this.maxFailedLimit);
        sb.append(", lockedExpireMins=");
        sb.append(this.lockedExpireMins);
        sb.append(", success=");
        sb.append(this.success);
        sb.append(", errorCode=");
        sb.append(this.errorCode);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public VerifySecurityInfo(@JSONField(name = "identFailedCount") int i, @JSONField(name = "maxFailedLimit") int i2, @JSONField(name = "lockedExpireMins") int i3, @JSONField(name = "success") boolean z, @JSONField(name = "errorCode") String str, @JSONField(name = "errorMessage") String str2, @JSONField(name = "extendInfo") Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.identFailedCount = i;
        this.maxFailedLimit = i2;
        this.lockedExpireMins = i3;
        this.success = z;
        this.errorCode = str;
        this.errorMessage = str2;
        this.extendInfo = map;
    }

    @JvmName(name = "getIdentFailedCount")
    public final int getIdentFailedCount() {
        return this.identFailedCount;
    }

    @JvmName(name = "getMaxFailedLimit")
    public final int getMaxFailedLimit() {
        return this.maxFailedLimit;
    }

    @JvmName(name = "getLockedExpireMins")
    public final int getLockedExpireMins() {
        return this.lockedExpireMins;
    }

    @JvmName(name = "getSuccess")
    public final boolean getSuccess() {
        return this.success;
    }

    @JvmName(name = "getErrorCode")
    public final String getErrorCode() {
        return this.errorCode;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ VerifySecurityInfo(int i, int i2, int i3, boolean z, String str, String str2, Map map, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) == 0 ? z : false, (i4 & 16) != 0 ? "" : str, (i4 & 32) != 0 ? "" : str2, (i4 & 64) != 0 ? MapsKt.emptyMap() : map);
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
