package id.dana.data.globalnetwork.model;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\"\u0010\u0007\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0018R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0004\"\u0004\b\u001c\u0010\u0018"}, d2 = {"Lid/dana/data/globalnetwork/model/GnConsultResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "result", "sdkResponseHeader", "sdkResponseData", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/globalnetwork/model/GnConsultResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getResult", "setResult", "(Ljava/lang/String;)V", "getSdkResponseData", "setSdkResponseData", "getSdkResponseHeader", "setSdkResponseHeader", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GnConsultResult extends BaseRpcResult {
    private String result;
    private String sdkResponseData;
    private String sdkResponseHeader;

    public GnConsultResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ GnConsultResult copy$default(GnConsultResult gnConsultResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gnConsultResult.result;
        }
        if ((i & 2) != 0) {
            str2 = gnConsultResult.sdkResponseHeader;
        }
        if ((i & 4) != 0) {
            str3 = gnConsultResult.sdkResponseData;
        }
        return gnConsultResult.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSdkResponseHeader() {
        return this.sdkResponseHeader;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSdkResponseData() {
        return this.sdkResponseData;
    }

    public final GnConsultResult copy(String result, String sdkResponseHeader, String sdkResponseData) {
        Intrinsics.checkNotNullParameter(result, "");
        Intrinsics.checkNotNullParameter(sdkResponseHeader, "");
        Intrinsics.checkNotNullParameter(sdkResponseData, "");
        return new GnConsultResult(result, sdkResponseHeader, sdkResponseData);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GnConsultResult) {
            GnConsultResult gnConsultResult = (GnConsultResult) other;
            return Intrinsics.areEqual(this.result, gnConsultResult.result) && Intrinsics.areEqual(this.sdkResponseHeader, gnConsultResult.sdkResponseHeader) && Intrinsics.areEqual(this.sdkResponseData, gnConsultResult.sdkResponseData);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.result.hashCode() * 31) + this.sdkResponseHeader.hashCode()) * 31) + this.sdkResponseData.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GnConsultResult(result=");
        sb.append(this.result);
        sb.append(", sdkResponseHeader=");
        sb.append(this.sdkResponseHeader);
        sb.append(", sdkResponseData=");
        sb.append(this.sdkResponseData);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ GnConsultResult(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getResult")
    public final String getResult() {
        return this.result;
    }

    @JvmName(name = "setResult")
    public final void setResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.result = str;
    }

    @JvmName(name = "getSdkResponseHeader")
    public final String getSdkResponseHeader() {
        return this.sdkResponseHeader;
    }

    @JvmName(name = "setSdkResponseHeader")
    public final void setSdkResponseHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.sdkResponseHeader = str;
    }

    @JvmName(name = "getSdkResponseData")
    public final String getSdkResponseData() {
        return this.sdkResponseData;
    }

    @JvmName(name = "setSdkResponseData")
    public final void setSdkResponseData(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.sdkResponseData = str;
    }

    public GnConsultResult(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.result = str;
        this.sdkResponseHeader = str2;
        this.sdkResponseData = str3;
    }
}
