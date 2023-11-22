package id.dana.data.otp.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J2\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/data/otp/repository/source/network/result/AttributeOneKlikOtpResult;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "processingStatus", "queryAgain", "sourcePlatform", "copy", "(Ljava/lang/String;ZLjava/lang/String;)Lid/dana/data/otp/repository/source/network/result/AttributeOneKlikOtpResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getProcessingStatus", "Z", "getQueryAgain", "getSourcePlatform", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AttributeOneKlikOtpResult {
    @SerializedName("processingStatus")
    private final String processingStatus;
    private final boolean queryAgain;
    private final String sourcePlatform;

    public static /* synthetic */ AttributeOneKlikOtpResult copy$default(AttributeOneKlikOtpResult attributeOneKlikOtpResult, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attributeOneKlikOtpResult.processingStatus;
        }
        if ((i & 2) != 0) {
            z = attributeOneKlikOtpResult.queryAgain;
        }
        if ((i & 4) != 0) {
            str2 = attributeOneKlikOtpResult.sourcePlatform;
        }
        return attributeOneKlikOtpResult.copy(str, z, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getQueryAgain() {
        return this.queryAgain;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSourcePlatform() {
        return this.sourcePlatform;
    }

    public final AttributeOneKlikOtpResult copy(String processingStatus, boolean queryAgain, String sourcePlatform) {
        return new AttributeOneKlikOtpResult(processingStatus, queryAgain, sourcePlatform);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AttributeOneKlikOtpResult) {
            AttributeOneKlikOtpResult attributeOneKlikOtpResult = (AttributeOneKlikOtpResult) other;
            return Intrinsics.areEqual(this.processingStatus, attributeOneKlikOtpResult.processingStatus) && this.queryAgain == attributeOneKlikOtpResult.queryAgain && Intrinsics.areEqual(this.sourcePlatform, attributeOneKlikOtpResult.sourcePlatform);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.processingStatus;
        int hashCode = str == null ? 0 : str.hashCode();
        boolean z = this.queryAgain;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str2 = this.sourcePlatform;
        return (((hashCode * 31) + i) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeOneKlikOtpResult(processingStatus=");
        sb.append(this.processingStatus);
        sb.append(", queryAgain=");
        sb.append(this.queryAgain);
        sb.append(", sourcePlatform=");
        sb.append(this.sourcePlatform);
        sb.append(')');
        return sb.toString();
    }

    public AttributeOneKlikOtpResult(String str, boolean z, String str2) {
        this.processingStatus = str;
        this.queryAgain = z;
        this.sourcePlatform = str2;
    }

    @JvmName(name = "getProcessingStatus")
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    @JvmName(name = "getQueryAgain")
    public final boolean getQueryAgain() {
        return this.queryAgain;
    }

    @JvmName(name = "getSourcePlatform")
    public final String getSourcePlatform() {
        return this.sourcePlatform;
    }
}
