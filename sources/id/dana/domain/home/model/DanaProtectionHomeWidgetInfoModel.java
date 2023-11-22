package id.dana.domain.home.model;

import id.dana.danah5.danaprotection.DanaProtectionKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\"\u0010\u000b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "", "", "component1", "()I", "component2", "component3", "component4", DanaProtectionKey.DanaProtectionResultParamsKey.PROTECTED_ACTIVITY, "suspiciousActivity", "timeRange", "recommendationCount", "copy", "(IIII)Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getProtectedActivity", "getRecommendationCount", "setRecommendationCount", "(I)V", "getSuspiciousActivity", "getTimeRange", "<init>", "(IIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DanaProtectionHomeWidgetInfoModel {
    public int protectedActivity;
    public int recommendationCount;
    public int suspiciousActivity;
    public int timeRange;

    public DanaProtectionHomeWidgetInfoModel() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ DanaProtectionHomeWidgetInfoModel copy$default(DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = danaProtectionHomeWidgetInfoModel.protectedActivity;
        }
        if ((i5 & 2) != 0) {
            i2 = danaProtectionHomeWidgetInfoModel.suspiciousActivity;
        }
        if ((i5 & 4) != 0) {
            i3 = danaProtectionHomeWidgetInfoModel.timeRange;
        }
        if ((i5 & 8) != 0) {
            i4 = danaProtectionHomeWidgetInfoModel.recommendationCount;
        }
        return danaProtectionHomeWidgetInfoModel.copy(i, i2, i3, i4);
    }

    /* renamed from: component1  reason: from getter */
    public final int getProtectedActivity() {
        return this.protectedActivity;
    }

    /* renamed from: component2  reason: from getter */
    public final int getSuspiciousActivity() {
        return this.suspiciousActivity;
    }

    /* renamed from: component3  reason: from getter */
    public final int getTimeRange() {
        return this.timeRange;
    }

    /* renamed from: component4  reason: from getter */
    public final int getRecommendationCount() {
        return this.recommendationCount;
    }

    public final DanaProtectionHomeWidgetInfoModel copy(int protectedActivity, int suspiciousActivity, int timeRange, int recommendationCount) {
        return new DanaProtectionHomeWidgetInfoModel(protectedActivity, suspiciousActivity, timeRange, recommendationCount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DanaProtectionHomeWidgetInfoModel) {
            DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel = (DanaProtectionHomeWidgetInfoModel) other;
            return this.protectedActivity == danaProtectionHomeWidgetInfoModel.protectedActivity && this.suspiciousActivity == danaProtectionHomeWidgetInfoModel.suspiciousActivity && this.timeRange == danaProtectionHomeWidgetInfoModel.timeRange && this.recommendationCount == danaProtectionHomeWidgetInfoModel.recommendationCount;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.protectedActivity * 31) + this.suspiciousActivity) * 31) + this.timeRange) * 31) + this.recommendationCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DanaProtectionHomeWidgetInfoModel(protectedActivity=");
        sb.append(this.protectedActivity);
        sb.append(", suspiciousActivity=");
        sb.append(this.suspiciousActivity);
        sb.append(", timeRange=");
        sb.append(this.timeRange);
        sb.append(", recommendationCount=");
        sb.append(this.recommendationCount);
        sb.append(')');
        return sb.toString();
    }

    public DanaProtectionHomeWidgetInfoModel(int i, int i2, int i3, int i4) {
        this.protectedActivity = i;
        this.suspiciousActivity = i2;
        this.timeRange = i3;
        this.recommendationCount = i4;
    }

    public /* synthetic */ DanaProtectionHomeWidgetInfoModel(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    @JvmName(name = "getProtectedActivity")
    public final int getProtectedActivity() {
        return this.protectedActivity;
    }

    @JvmName(name = "getSuspiciousActivity")
    public final int getSuspiciousActivity() {
        return this.suspiciousActivity;
    }

    @JvmName(name = "getTimeRange")
    public final int getTimeRange() {
        return this.timeRange;
    }

    @JvmName(name = "getRecommendationCount")
    public final int getRecommendationCount() {
        return this.recommendationCount;
    }

    @JvmName(name = "setRecommendationCount")
    public final void setRecommendationCount(int i) {
        this.recommendationCount = i;
    }
}
