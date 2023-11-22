package id.dana.data.loyalty.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017"}, d2 = {"Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "status", "message", "activityErrorType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/loyalty/repository/source/network/response/LoyaltyResultInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getActivityErrorType", "setActivityErrorType", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getStatus", "setStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class LoyaltyResultInfo {
    private String activityErrorType;
    private String message;
    @SerializedName("status")
    private String status;

    public static /* synthetic */ LoyaltyResultInfo copy$default(LoyaltyResultInfo loyaltyResultInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loyaltyResultInfo.status;
        }
        if ((i & 2) != 0) {
            str2 = loyaltyResultInfo.message;
        }
        if ((i & 4) != 0) {
            str3 = loyaltyResultInfo.activityErrorType;
        }
        return loyaltyResultInfo.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3  reason: from getter */
    public final String getActivityErrorType() {
        return this.activityErrorType;
    }

    public final LoyaltyResultInfo copy(String status, String message, String activityErrorType) {
        return new LoyaltyResultInfo(status, message, activityErrorType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LoyaltyResultInfo) {
            LoyaltyResultInfo loyaltyResultInfo = (LoyaltyResultInfo) other;
            return Intrinsics.areEqual(this.status, loyaltyResultInfo.status) && Intrinsics.areEqual(this.message, loyaltyResultInfo.message) && Intrinsics.areEqual(this.activityErrorType, loyaltyResultInfo.activityErrorType);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.status;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.message;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.activityErrorType;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoyaltyResultInfo(status=");
        sb.append(this.status);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", activityErrorType=");
        sb.append(this.activityErrorType);
        sb.append(')');
        return sb.toString();
    }

    public LoyaltyResultInfo(String str, String str2, String str3) {
        this.status = str;
        this.message = str2;
        this.activityErrorType = str3;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(String str) {
        this.status = str;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "setMessage")
    public final void setMessage(String str) {
        this.message = str;
    }

    @JvmName(name = "getActivityErrorType")
    public final String getActivityErrorType() {
        return this.activityErrorType;
    }

    @JvmName(name = "setActivityErrorType")
    public final void setActivityErrorType(String str) {
        this.activityErrorType = str;
    }
}
