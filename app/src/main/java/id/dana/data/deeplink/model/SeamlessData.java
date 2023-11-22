package id.dana.data.deeplink.model;

import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004JL\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004"}, d2 = {"Lid/dana/data/deeplink/model/SeamlessData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", UploadTaskStatusCallback.NETWORK_MOBILE, "verifiedTime", "externalUid", "reqTime", "reqMsgId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/deeplink/model/SeamlessData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getExternalUid", "getMobile", "getReqMsgId", "getReqTime", "getVerifiedTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SeamlessData {
    public String externalUid;
    public String mobile;
    public String reqMsgId;
    public String reqTime;
    public String verifiedTime;

    public /* synthetic */ SeamlessData() {
    }

    public static /* synthetic */ SeamlessData copy$default(SeamlessData seamlessData, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = seamlessData.mobile;
        }
        if ((i & 2) != 0) {
            str2 = seamlessData.verifiedTime;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = seamlessData.externalUid;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = seamlessData.reqTime;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = seamlessData.reqMsgId;
        }
        return seamlessData.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMobile() {
        return this.mobile;
    }

    /* renamed from: component2  reason: from getter */
    public final String getVerifiedTime() {
        return this.verifiedTime;
    }

    /* renamed from: component3  reason: from getter */
    public final String getExternalUid() {
        return this.externalUid;
    }

    /* renamed from: component4  reason: from getter */
    public final String getReqTime() {
        return this.reqTime;
    }

    /* renamed from: component5  reason: from getter */
    public final String getReqMsgId() {
        return this.reqMsgId;
    }

    public final SeamlessData copy(String mobile, String verifiedTime, String externalUid, String reqTime, String reqMsgId) {
        return new SeamlessData(mobile, verifiedTime, externalUid, reqTime, reqMsgId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SeamlessData) {
            SeamlessData seamlessData = (SeamlessData) other;
            return Intrinsics.areEqual(this.mobile, seamlessData.mobile) && Intrinsics.areEqual(this.verifiedTime, seamlessData.verifiedTime) && Intrinsics.areEqual(this.externalUid, seamlessData.externalUid) && Intrinsics.areEqual(this.reqTime, seamlessData.reqTime) && Intrinsics.areEqual(this.reqMsgId, seamlessData.reqMsgId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.mobile;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.verifiedTime;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.externalUid;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.reqTime;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.reqMsgId;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SeamlessData(mobile=");
        sb.append(this.mobile);
        sb.append(", verifiedTime=");
        sb.append(this.verifiedTime);
        sb.append(", externalUid=");
        sb.append(this.externalUid);
        sb.append(", reqTime=");
        sb.append(this.reqTime);
        sb.append(", reqMsgId=");
        sb.append(this.reqMsgId);
        sb.append(')');
        return sb.toString();
    }

    public SeamlessData(String str, String str2, String str3, String str4, String str5) {
        this.mobile = str;
        this.verifiedTime = str2;
        this.externalUid = str3;
        this.reqTime = str4;
        this.reqMsgId = str5;
    }

    @JvmName(name = "getMobile")
    public final String getMobile() {
        return this.mobile;
    }

    @JvmName(name = "getVerifiedTime")
    public final String getVerifiedTime() {
        return this.verifiedTime;
    }

    @JvmName(name = "getExternalUid")
    public final String getExternalUid() {
        return this.externalUid;
    }

    @JvmName(name = "getReqTime")
    public final String getReqTime() {
        return this.reqTime;
    }

    @JvmName(name = "getReqMsgId")
    public final String getReqMsgId() {
        return this.reqMsgId;
    }
}
