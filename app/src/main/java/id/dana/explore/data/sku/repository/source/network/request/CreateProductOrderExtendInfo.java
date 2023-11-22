package id.dana.explore.data.sku.repository.source.network.request;

import com.google.gson.annotations.SerializedName;
import id.dana.explore.data.sku.repository.source.network.response.MultiCurrencyMoney;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b \u0010\u0007"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderExtendInfo;", "", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component1", "()Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "adminFee", "customerName", "fare", "inquiryId", "totalEnergy", "copy", "(Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/explore/data/sku/repository/source/network/request/CreateProductOrderExtendInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "getAdminFee", "Ljava/lang/String;", "getCustomerName", "getFare", "getInquiryId", "getTotalEnergy", "<init>", "(Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CreateProductOrderExtendInfo {
    @SerializedName("adminFee")
    private final MultiCurrencyMoney adminFee;
    @SerializedName("customerName")
    private final String customerName;
    @SerializedName("fare")
    private final String fare;
    @SerializedName("inquiryId")
    private final String inquiryId;
    @SerializedName("totalEnergy")
    private final String totalEnergy;

    public static /* synthetic */ CreateProductOrderExtendInfo copy$default(CreateProductOrderExtendInfo createProductOrderExtendInfo, MultiCurrencyMoney multiCurrencyMoney, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            multiCurrencyMoney = createProductOrderExtendInfo.adminFee;
        }
        if ((i & 2) != 0) {
            str = createProductOrderExtendInfo.customerName;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = createProductOrderExtendInfo.fare;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = createProductOrderExtendInfo.inquiryId;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = createProductOrderExtendInfo.totalEnergy;
        }
        return createProductOrderExtendInfo.copy(multiCurrencyMoney, str5, str6, str7, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final MultiCurrencyMoney getAdminFee() {
        return this.adminFee;
    }

    /* renamed from: component2  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getFare() {
        return this.fare;
    }

    /* renamed from: component4  reason: from getter */
    public final String getInquiryId() {
        return this.inquiryId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getTotalEnergy() {
        return this.totalEnergy;
    }

    public final CreateProductOrderExtendInfo copy(MultiCurrencyMoney adminFee, String customerName, String fare, String inquiryId, String totalEnergy) {
        Intrinsics.checkNotNullParameter(adminFee, "");
        Intrinsics.checkNotNullParameter(customerName, "");
        Intrinsics.checkNotNullParameter(fare, "");
        Intrinsics.checkNotNullParameter(inquiryId, "");
        Intrinsics.checkNotNullParameter(totalEnergy, "");
        return new CreateProductOrderExtendInfo(adminFee, customerName, fare, inquiryId, totalEnergy);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CreateProductOrderExtendInfo) {
            CreateProductOrderExtendInfo createProductOrderExtendInfo = (CreateProductOrderExtendInfo) other;
            return Intrinsics.areEqual(this.adminFee, createProductOrderExtendInfo.adminFee) && Intrinsics.areEqual(this.customerName, createProductOrderExtendInfo.customerName) && Intrinsics.areEqual(this.fare, createProductOrderExtendInfo.fare) && Intrinsics.areEqual(this.inquiryId, createProductOrderExtendInfo.inquiryId) && Intrinsics.areEqual(this.totalEnergy, createProductOrderExtendInfo.totalEnergy);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.adminFee.hashCode() * 31) + this.customerName.hashCode()) * 31) + this.fare.hashCode()) * 31) + this.inquiryId.hashCode()) * 31) + this.totalEnergy.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateProductOrderExtendInfo(adminFee=");
        sb.append(this.adminFee);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(", fare=");
        sb.append(this.fare);
        sb.append(", inquiryId=");
        sb.append(this.inquiryId);
        sb.append(", totalEnergy=");
        sb.append(this.totalEnergy);
        sb.append(')');
        return sb.toString();
    }

    public CreateProductOrderExtendInfo(MultiCurrencyMoney multiCurrencyMoney, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(multiCurrencyMoney, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.adminFee = multiCurrencyMoney;
        this.customerName = str;
        this.fare = str2;
        this.inquiryId = str3;
        this.totalEnergy = str4;
    }

    @JvmName(name = "getAdminFee")
    public final MultiCurrencyMoney getAdminFee() {
        return this.adminFee;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }

    @JvmName(name = "getFare")
    public final String getFare() {
        return this.fare;
    }

    @JvmName(name = "getInquiryId")
    public final String getInquiryId() {
        return this.inquiryId;
    }

    @JvmName(name = "getTotalEnergy")
    public final String getTotalEnergy() {
        return this.totalEnergy;
    }
}
