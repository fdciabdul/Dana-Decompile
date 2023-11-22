package id.dana.data.saving.model;

import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJb\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b \u0010\u0004R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\rR\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b&\u0010\u0004"}, d2 = {"Lid/dana/data/saving/model/TopUpViewEntity;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component2", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "component4", "component5", "", "component6", "()Ljava/util/Map;", "topUpId", "fundAmount", "status", "createdTime", "bizOrderId", "extendInfo", "copy", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/data/saving/model/TopUpViewEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizOrderId", "getCreatedTime", "Ljava/util/Map;", "getExtendInfo", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getFundAmount", "getStatus", "getTopUpId", "<init>", "(Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpViewEntity {
    private final String bizOrderId;
    private final String createdTime;
    private final Map<String, String> extendInfo;
    private final MoneyViewEntity fundAmount;
    private final String status;
    private final String topUpId;

    public static /* synthetic */ TopUpViewEntity copy$default(TopUpViewEntity topUpViewEntity, String str, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topUpViewEntity.topUpId;
        }
        if ((i & 2) != 0) {
            moneyViewEntity = topUpViewEntity.fundAmount;
        }
        MoneyViewEntity moneyViewEntity2 = moneyViewEntity;
        if ((i & 4) != 0) {
            str2 = topUpViewEntity.status;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = topUpViewEntity.createdTime;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = topUpViewEntity.bizOrderId;
        }
        String str7 = str4;
        Map<String, String> map2 = map;
        if ((i & 32) != 0) {
            map2 = topUpViewEntity.extendInfo;
        }
        return topUpViewEntity.copy(str, moneyViewEntity2, str5, str6, str7, map2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTopUpId() {
        return this.topUpId;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyViewEntity getFundAmount() {
        return this.fundAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    public final Map<String, String> component6() {
        return this.extendInfo;
    }

    public final TopUpViewEntity copy(String topUpId, MoneyViewEntity fundAmount, String status, String createdTime, String bizOrderId, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(fundAmount, "");
        return new TopUpViewEntity(topUpId, fundAmount, status, createdTime, bizOrderId, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpViewEntity) {
            TopUpViewEntity topUpViewEntity = (TopUpViewEntity) other;
            return Intrinsics.areEqual(this.topUpId, topUpViewEntity.topUpId) && Intrinsics.areEqual(this.fundAmount, topUpViewEntity.fundAmount) && Intrinsics.areEqual(this.status, topUpViewEntity.status) && Intrinsics.areEqual(this.createdTime, topUpViewEntity.createdTime) && Intrinsics.areEqual(this.bizOrderId, topUpViewEntity.bizOrderId) && Intrinsics.areEqual(this.extendInfo, topUpViewEntity.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.topUpId;
        int hashCode = str == null ? 0 : str.hashCode();
        int hashCode2 = this.fundAmount.hashCode();
        String str2 = this.status;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.createdTime;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.bizOrderId;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        Map<String, String> map = this.extendInfo;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpViewEntity(topUpId=");
        sb.append(this.topUpId);
        sb.append(", fundAmount=");
        sb.append(this.fundAmount);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", bizOrderId=");
        sb.append(this.bizOrderId);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public TopUpViewEntity(String str, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(moneyViewEntity, "");
        this.topUpId = str;
        this.fundAmount = moneyViewEntity;
        this.status = str2;
        this.createdTime = str3;
        this.bizOrderId = str4;
        this.extendInfo = map;
    }

    @JvmName(name = "getTopUpId")
    public final String getTopUpId() {
        return this.topUpId;
    }

    @JvmName(name = "getFundAmount")
    public final MoneyViewEntity getFundAmount() {
        return this.fundAmount;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getCreatedTime")
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getBizOrderId")
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    public /* synthetic */ TopUpViewEntity(String str, MoneyViewEntity moneyViewEntity, String str2, String str3, String str4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, moneyViewEntity, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? new HashMap() : map);
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
