package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J4\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "defaultValue", "maxValue", "minValue", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getDefaultValue", "getMaxValue", "getMinValue", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DailyLimitAmountConf {
    private final Integer defaultValue;
    private final Integer maxValue;
    private final Integer minValue;

    public static /* synthetic */ DailyLimitAmountConf copy$default(DailyLimitAmountConf dailyLimitAmountConf, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = dailyLimitAmountConf.defaultValue;
        }
        if ((i & 2) != 0) {
            num2 = dailyLimitAmountConf.maxValue;
        }
        if ((i & 4) != 0) {
            num3 = dailyLimitAmountConf.minValue;
        }
        return dailyLimitAmountConf.copy(num, num2, num3);
    }

    /* renamed from: component1  reason: from getter */
    public final Integer getDefaultValue() {
        return this.defaultValue;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getMaxValue() {
        return this.maxValue;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getMinValue() {
        return this.minValue;
    }

    public final DailyLimitAmountConf copy(Integer defaultValue, Integer maxValue, Integer minValue) {
        return new DailyLimitAmountConf(defaultValue, maxValue, minValue);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DailyLimitAmountConf) {
            DailyLimitAmountConf dailyLimitAmountConf = (DailyLimitAmountConf) other;
            return Intrinsics.areEqual(this.defaultValue, dailyLimitAmountConf.defaultValue) && Intrinsics.areEqual(this.maxValue, dailyLimitAmountConf.maxValue) && Intrinsics.areEqual(this.minValue, dailyLimitAmountConf.minValue);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.defaultValue;
        int hashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.maxValue;
        int hashCode2 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.minValue;
        return (((hashCode * 31) + hashCode2) * 31) + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DailyLimitAmountConf(defaultValue=");
        sb.append(this.defaultValue);
        sb.append(", maxValue=");
        sb.append(this.maxValue);
        sb.append(", minValue=");
        sb.append(this.minValue);
        sb.append(')');
        return sb.toString();
    }

    public DailyLimitAmountConf(Integer num, Integer num2, Integer num3) {
        this.defaultValue = num;
        this.maxValue = num2;
        this.minValue = num3;
    }

    @JvmName(name = "getDefaultValue")
    public final Integer getDefaultValue() {
        return this.defaultValue;
    }

    @JvmName(name = "getMaxValue")
    public final Integer getMaxValue() {
        return this.maxValue;
    }

    @JvmName(name = "getMinValue")
    public final Integer getMinValue() {
        return this.minValue;
    }
}
