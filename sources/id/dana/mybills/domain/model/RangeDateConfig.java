package id.dana.mybills.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/RangeDateConfig;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "goodsType", "datePickerStart", "datePickerEnd", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/domain/model/RangeDateConfig;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDatePickerEnd", "getDatePickerStart", "getGoodsType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RangeDateConfig {
    private final String datePickerEnd;
    private final String datePickerStart;
    private final String goodsType;

    public static /* synthetic */ RangeDateConfig copy$default(RangeDateConfig rangeDateConfig, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rangeDateConfig.goodsType;
        }
        if ((i & 2) != 0) {
            str2 = rangeDateConfig.datePickerStart;
        }
        if ((i & 4) != 0) {
            str3 = rangeDateConfig.datePickerEnd;
        }
        return rangeDateConfig.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDatePickerStart() {
        return this.datePickerStart;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDatePickerEnd() {
        return this.datePickerEnd;
    }

    public final RangeDateConfig copy(String goodsType, String datePickerStart, String datePickerEnd) {
        Intrinsics.checkNotNullParameter(goodsType, "");
        Intrinsics.checkNotNullParameter(datePickerStart, "");
        Intrinsics.checkNotNullParameter(datePickerEnd, "");
        return new RangeDateConfig(goodsType, datePickerStart, datePickerEnd);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof RangeDateConfig) {
            RangeDateConfig rangeDateConfig = (RangeDateConfig) other;
            return Intrinsics.areEqual(this.goodsType, rangeDateConfig.goodsType) && Intrinsics.areEqual(this.datePickerStart, rangeDateConfig.datePickerStart) && Intrinsics.areEqual(this.datePickerEnd, rangeDateConfig.datePickerEnd);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.goodsType.hashCode() * 31) + this.datePickerStart.hashCode()) * 31) + this.datePickerEnd.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RangeDateConfig(goodsType=");
        sb.append(this.goodsType);
        sb.append(", datePickerStart=");
        sb.append(this.datePickerStart);
        sb.append(", datePickerEnd=");
        sb.append(this.datePickerEnd);
        sb.append(')');
        return sb.toString();
    }

    public RangeDateConfig(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.goodsType = str;
        this.datePickerStart = str2;
        this.datePickerEnd = str3;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getDatePickerStart")
    public final String getDatePickerStart() {
        return this.datePickerStart;
    }

    @JvmName(name = "getDatePickerEnd")
    public final String getDatePickerEnd() {
        return this.datePickerEnd;
    }
}
