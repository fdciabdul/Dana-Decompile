package id.dana.data.devicestats.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/data/devicestats/model/DeviceStatsConfig;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/Integer;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Boolean;", "PlaceComponentResult", "p1", "p2", "p3", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class DeviceStatsConfig {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Integer getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Integer PlaceComponentResult;

    public /* synthetic */ DeviceStatsConfig() {
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof DeviceStatsConfig) {
            DeviceStatsConfig deviceStatsConfig = (DeviceStatsConfig) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, deviceStatsConfig.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, deviceStatsConfig.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, deviceStatsConfig.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, deviceStatsConfig.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Integer num = this.getAuthRequestContext;
        int hashCode2 = num == null ? 0 : num.hashCode();
        Boolean bool2 = this.MyBillsEntityDataFactory;
        int hashCode3 = bool2 == null ? 0 : bool2.hashCode();
        Integer num2 = this.PlaceComponentResult;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (num2 != null ? num2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceStatsConfig(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public DeviceStatsConfig(Boolean bool, Integer num, Boolean bool2, Integer num2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bool;
        this.getAuthRequestContext = num;
        this.MyBillsEntityDataFactory = bool2;
        this.PlaceComponentResult = num2;
    }
}
