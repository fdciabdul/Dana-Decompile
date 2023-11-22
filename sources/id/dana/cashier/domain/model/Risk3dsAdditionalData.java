package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001f\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/Risk3dsAdditionalData;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Integer;", "param", "httpMethod", "targetUrl", "contentType", "seq", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lid/dana/cashier/domain/model/Risk3dsAdditionalData;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContentType", "getHttpMethod", "getParam", "Ljava/lang/Integer;", "getSeq", "getTargetUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Risk3dsAdditionalData {
    private final String contentType;
    private final String httpMethod;
    private final String param;
    private final Integer seq;
    private final String targetUrl;

    public Risk3dsAdditionalData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Risk3dsAdditionalData copy$default(Risk3dsAdditionalData risk3dsAdditionalData, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = risk3dsAdditionalData.param;
        }
        if ((i & 2) != 0) {
            str2 = risk3dsAdditionalData.httpMethod;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = risk3dsAdditionalData.targetUrl;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = risk3dsAdditionalData.contentType;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = risk3dsAdditionalData.seq;
        }
        return risk3dsAdditionalData.copy(str, str5, str6, str7, num);
    }

    /* renamed from: component1  reason: from getter */
    public final String getParam() {
        return this.param;
    }

    /* renamed from: component2  reason: from getter */
    public final String getHttpMethod() {
        return this.httpMethod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTargetUrl() {
        return this.targetUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: component5  reason: from getter */
    public final Integer getSeq() {
        return this.seq;
    }

    public final Risk3dsAdditionalData copy(String param, String httpMethod, String targetUrl, String contentType, Integer seq) {
        return new Risk3dsAdditionalData(param, httpMethod, targetUrl, contentType, seq);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Risk3dsAdditionalData) {
            Risk3dsAdditionalData risk3dsAdditionalData = (Risk3dsAdditionalData) other;
            return Intrinsics.areEqual(this.param, risk3dsAdditionalData.param) && Intrinsics.areEqual(this.httpMethod, risk3dsAdditionalData.httpMethod) && Intrinsics.areEqual(this.targetUrl, risk3dsAdditionalData.targetUrl) && Intrinsics.areEqual(this.contentType, risk3dsAdditionalData.contentType) && Intrinsics.areEqual(this.seq, risk3dsAdditionalData.seq);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.param;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.httpMethod;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.targetUrl;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.contentType;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Integer num = this.seq;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Risk3dsAdditionalData(param=");
        sb.append(this.param);
        sb.append(", httpMethod=");
        sb.append(this.httpMethod);
        sb.append(", targetUrl=");
        sb.append(this.targetUrl);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", seq=");
        sb.append(this.seq);
        sb.append(')');
        return sb.toString();
    }

    public Risk3dsAdditionalData(String str, String str2, String str3, String str4, Integer num) {
        this.param = str;
        this.httpMethod = str2;
        this.targetUrl = str3;
        this.contentType = str4;
        this.seq = num;
    }

    public /* synthetic */ Risk3dsAdditionalData(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
    }

    @JvmName(name = "getParam")
    public final String getParam() {
        return this.param;
    }

    @JvmName(name = "getHttpMethod")
    public final String getHttpMethod() {
        return this.httpMethod;
    }

    @JvmName(name = "getTargetUrl")
    public final String getTargetUrl() {
        return this.targetUrl;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "getSeq")
    public final Integer getSeq() {
        return this.seq;
    }
}
