package id.dana.domain.nearbyme.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u0017R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\u0017"}, d2 = {"Lid/dana/domain/nearbyme/model/PromoLimitInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "limitType", "limitCount", "limitRangeType", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/nearbyme/model/PromoLimitInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getLimitCount", "setLimitCount", "(Ljava/lang/String;)V", "getLimitRangeType", "setLimitRangeType", "getLimitType", "setLimitType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PromoLimitInfo {
    private String limitCount;
    private String limitRangeType;
    private String limitType;

    public PromoLimitInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PromoLimitInfo copy$default(PromoLimitInfo promoLimitInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = promoLimitInfo.limitType;
        }
        if ((i & 2) != 0) {
            str2 = promoLimitInfo.limitCount;
        }
        if ((i & 4) != 0) {
            str3 = promoLimitInfo.limitRangeType;
        }
        return promoLimitInfo.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLimitType() {
        return this.limitType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLimitCount() {
        return this.limitCount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getLimitRangeType() {
        return this.limitRangeType;
    }

    public final PromoLimitInfo copy(String limitType, String limitCount, String limitRangeType) {
        return new PromoLimitInfo(limitType, limitCount, limitRangeType);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PromoLimitInfo) {
            PromoLimitInfo promoLimitInfo = (PromoLimitInfo) other;
            return Intrinsics.areEqual(this.limitType, promoLimitInfo.limitType) && Intrinsics.areEqual(this.limitCount, promoLimitInfo.limitCount) && Intrinsics.areEqual(this.limitRangeType, promoLimitInfo.limitRangeType);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.limitType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.limitCount;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.limitRangeType;
        return (((hashCode * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PromoLimitInfo(limitType=");
        sb.append(this.limitType);
        sb.append(", limitCount=");
        sb.append(this.limitCount);
        sb.append(", limitRangeType=");
        sb.append(this.limitRangeType);
        sb.append(')');
        return sb.toString();
    }

    public PromoLimitInfo(String str, String str2, String str3) {
        this.limitType = str;
        this.limitCount = str2;
        this.limitRangeType = str3;
    }

    public /* synthetic */ PromoLimitInfo(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getLimitType")
    public final String getLimitType() {
        return this.limitType;
    }

    @JvmName(name = "setLimitType")
    public final void setLimitType(String str) {
        this.limitType = str;
    }

    @JvmName(name = "getLimitCount")
    public final String getLimitCount() {
        return this.limitCount;
    }

    @JvmName(name = "setLimitCount")
    public final void setLimitCount(String str) {
        this.limitCount = str;
    }

    @JvmName(name = "getLimitRangeType")
    public final String getLimitRangeType() {
        return this.limitRangeType;
    }

    @JvmName(name = "setLimitRangeType")
    public final void setLimitRangeType(String str) {
        this.limitRangeType = str;
    }
}
