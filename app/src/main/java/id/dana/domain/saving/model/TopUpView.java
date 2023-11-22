package id.dana.domain.saving.model;

import id.dana.domain.nearbyme.model.MoneyView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJX\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b \u0010\u0004R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\rR\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b$\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b&\u0010\u0004"}, d2 = {"Lid/dana/domain/saving/model/TopUpView;", "", "", "component1", "()Ljava/lang/String;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "component4", "component5", "", "component6", "()Ljava/util/Map;", "topUpId", "fundAmount", "status", "createdTime", "bizOrderId", "extendInfo", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lid/dana/domain/saving/model/TopUpView;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizOrderId", "getCreatedTime", "Ljava/util/Map;", "getExtendInfo", "Lid/dana/domain/nearbyme/model/MoneyView;", "getFundAmount", "getStatus", "getTopUpId", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TopUpView {
    private final String bizOrderId;
    private final String createdTime;
    private final Map<String, String> extendInfo;
    private final MoneyView fundAmount;
    private final String status;
    private final String topUpId;

    public static /* synthetic */ TopUpView copy$default(TopUpView topUpView, String str, MoneyView moneyView, String str2, String str3, String str4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topUpView.topUpId;
        }
        if ((i & 2) != 0) {
            moneyView = topUpView.fundAmount;
        }
        MoneyView moneyView2 = moneyView;
        if ((i & 4) != 0) {
            str2 = topUpView.status;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = topUpView.createdTime;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = topUpView.bizOrderId;
        }
        String str7 = str4;
        Map<String, String> map2 = map;
        if ((i & 32) != 0) {
            map2 = topUpView.extendInfo;
        }
        return topUpView.copy(str, moneyView2, str5, str6, str7, map2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTopUpId() {
        return this.topUpId;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getFundAmount() {
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

    public final TopUpView copy(String topUpId, MoneyView fundAmount, String status, String createdTime, String bizOrderId, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(topUpId, "");
        Intrinsics.checkNotNullParameter(fundAmount, "");
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(createdTime, "");
        Intrinsics.checkNotNullParameter(bizOrderId, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        return new TopUpView(topUpId, fundAmount, status, createdTime, bizOrderId, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TopUpView) {
            TopUpView topUpView = (TopUpView) other;
            return Intrinsics.areEqual(this.topUpId, topUpView.topUpId) && Intrinsics.areEqual(this.fundAmount, topUpView.fundAmount) && Intrinsics.areEqual(this.status, topUpView.status) && Intrinsics.areEqual(this.createdTime, topUpView.createdTime) && Intrinsics.areEqual(this.bizOrderId, topUpView.bizOrderId) && Intrinsics.areEqual(this.extendInfo, topUpView.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.topUpId.hashCode() * 31) + this.fundAmount.hashCode()) * 31) + this.status.hashCode()) * 31) + this.createdTime.hashCode()) * 31) + this.bizOrderId.hashCode()) * 31) + this.extendInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TopUpView(topUpId=");
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

    public TopUpView(String str, MoneyView moneyView, String str2, String str3, String str4, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyView, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.topUpId = str;
        this.fundAmount = moneyView;
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
    public final MoneyView getFundAmount() {
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

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }
}
