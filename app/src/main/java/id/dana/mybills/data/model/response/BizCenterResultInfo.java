package id.dana.mybills.data.model.response;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJd\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R%\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\n"}, d2 = {"Lid/dana/mybills/data/model/response/BizCenterResultInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Boolean;", "", "component6", "()Ljava/util/Map;", "resultCode", "resultCodeId", "resultMsg", "resultStatus", "retryable", "extendInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Lid/dana/mybills/data/model/response/BizCenterResultInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "getExtendInfo", "Ljava/lang/String;", "getResultCode", "getResultCodeId", "getResultMsg", "getResultStatus", "Ljava/lang/Boolean;", "getRetryable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizCenterResultInfo {
    private final Map<String, Object> extendInfo;
    private final String resultCode;
    private final String resultCodeId;
    private final String resultMsg;
    private final String resultStatus;
    private final Boolean retryable;

    public BizCenterResultInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ BizCenterResultInfo copy$default(BizCenterResultInfo bizCenterResultInfo, String str, String str2, String str3, String str4, Boolean bool, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bizCenterResultInfo.resultCode;
        }
        if ((i & 2) != 0) {
            str2 = bizCenterResultInfo.resultCodeId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = bizCenterResultInfo.resultMsg;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = bizCenterResultInfo.resultStatus;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            bool = bizCenterResultInfo.retryable;
        }
        Boolean bool2 = bool;
        Map<String, Object> map2 = map;
        if ((i & 32) != 0) {
            map2 = bizCenterResultInfo.extendInfo;
        }
        return bizCenterResultInfo.copy(str, str5, str6, str7, bool2, map2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getResultCode() {
        return this.resultCode;
    }

    /* renamed from: component2  reason: from getter */
    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getResultMsg() {
        return this.resultMsg;
    }

    /* renamed from: component4  reason: from getter */
    public final String getResultStatus() {
        return this.resultStatus;
    }

    /* renamed from: component5  reason: from getter */
    public final Boolean getRetryable() {
        return this.retryable;
    }

    public final Map<String, Object> component6() {
        return this.extendInfo;
    }

    public final BizCenterResultInfo copy(String resultCode, String resultCodeId, String resultMsg, String resultStatus, Boolean retryable, Map<String, ? extends Object> extendInfo) {
        return new BizCenterResultInfo(resultCode, resultCodeId, resultMsg, resultStatus, retryable, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizCenterResultInfo) {
            BizCenterResultInfo bizCenterResultInfo = (BizCenterResultInfo) other;
            return Intrinsics.areEqual(this.resultCode, bizCenterResultInfo.resultCode) && Intrinsics.areEqual(this.resultCodeId, bizCenterResultInfo.resultCodeId) && Intrinsics.areEqual(this.resultMsg, bizCenterResultInfo.resultMsg) && Intrinsics.areEqual(this.resultStatus, bizCenterResultInfo.resultStatus) && Intrinsics.areEqual(this.retryable, bizCenterResultInfo.retryable) && Intrinsics.areEqual(this.extendInfo, bizCenterResultInfo.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.resultCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.resultCodeId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.resultMsg;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.resultStatus;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.retryable;
        int hashCode5 = bool == null ? 0 : bool.hashCode();
        Map<String, Object> map = this.extendInfo;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizCenterResultInfo(resultCode=");
        sb.append(this.resultCode);
        sb.append(", resultCodeId=");
        sb.append(this.resultCodeId);
        sb.append(", resultMsg=");
        sb.append(this.resultMsg);
        sb.append(", resultStatus=");
        sb.append(this.resultStatus);
        sb.append(", retryable=");
        sb.append(this.retryable);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public BizCenterResultInfo(String str, String str2, String str3, String str4, Boolean bool, Map<String, ? extends Object> map) {
        this.resultCode = str;
        this.resultCodeId = str2;
        this.resultMsg = str3;
        this.resultStatus = str4;
        this.retryable = bool;
        this.extendInfo = map;
    }

    public /* synthetic */ BizCenterResultInfo(String str, String str2, String str3, String str4, Boolean bool, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : map);
    }

    @JvmName(name = "getResultCode")
    public final String getResultCode() {
        return this.resultCode;
    }

    @JvmName(name = "getResultCodeId")
    public final String getResultCodeId() {
        return this.resultCodeId;
    }

    @JvmName(name = "getResultMsg")
    public final String getResultMsg() {
        return this.resultMsg;
    }

    @JvmName(name = "getResultStatus")
    public final String getResultStatus() {
        return this.resultStatus;
    }

    @JvmName(name = "getRetryable")
    public final Boolean getRetryable() {
        return this.retryable;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, Object> getExtendInfo() {
        return this.extendInfo;
    }
}
