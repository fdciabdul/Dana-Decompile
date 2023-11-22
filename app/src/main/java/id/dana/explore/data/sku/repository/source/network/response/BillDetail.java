package id.dana.explore.data.sku.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b?\u0010@J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J¸\u0001\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010+\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u0010\u000fR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010.\u001a\u0004\b0\u0010\u000fR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00101\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u00101\u001a\u0004\b6\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00101\u001a\u0004\b7\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b8\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00101\u001a\u0004\b9\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010.\u001a\u0004\b:\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u00101\u001a\u0004\b;\u0010\u0004R\u001c\u0010#\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010<\u001a\u0004\b=\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010.\u001a\u0004\b>\u0010\u000f"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/response/BillDetail;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "", "component14", "()Ljava/lang/Boolean;", "component2", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component3", "()Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component4", "component5", "component6", "component7", "component8", "component9", "customerName", "invoiceNumber", "amount", "fineAmount", "totalAmount", "amountPaid", "billName", "billDate", "billItemId", "billInfo", "dueDate", "expiredDate", "description", "selected", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/explore/data/sku/repository/source/network/response/BillDetail;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "getAmount", "getAmountPaid", "Ljava/lang/String;", "getBillDate", "getBillInfo", "getBillItemId", "getBillName", "getCustomerName", "getDescription", "getDueDate", "getExpiredDate", "getFineAmount", "getInvoiceNumber", "Ljava/lang/Boolean;", "getSelected", "getTotalAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class BillDetail implements Serializable {
    @SerializedName("amount")
    private final MultiCurrencyMoney amount;
    @SerializedName("amountPaid")
    private final MultiCurrencyMoney amountPaid;
    @SerializedName("billDate")
    private final String billDate;
    @SerializedName("billInfo")
    private final String billInfo;
    @SerializedName("billItemId")
    private final String billItemId;
    @SerializedName("billName")
    private final String billName;
    @SerializedName("customerName")
    private final String customerName;
    @SerializedName("description")
    private final String description;
    @SerializedName("dueDate")
    private final String dueDate;
    @SerializedName("expiredDate")
    private final String expiredDate;
    @SerializedName("fineAmount")
    private final MultiCurrencyMoney fineAmount;
    @SerializedName("invoiceNumber")
    private final String invoiceNumber;
    @SerializedName("selected")
    private final Boolean selected;
    @SerializedName("totalAmount")
    private final MultiCurrencyMoney totalAmount;

    public BillDetail() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component10  reason: from getter */
    public final String getBillInfo() {
        return this.billInfo;
    }

    /* renamed from: component11  reason: from getter */
    public final String getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component12  reason: from getter */
    public final String getExpiredDate() {
        return this.expiredDate;
    }

    /* renamed from: component13  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component14  reason: from getter */
    public final Boolean getSelected() {
        return this.selected;
    }

    /* renamed from: component2  reason: from getter */
    public final String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    /* renamed from: component3  reason: from getter */
    public final MultiCurrencyMoney getAmount() {
        return this.amount;
    }

    /* renamed from: component4  reason: from getter */
    public final MultiCurrencyMoney getFineAmount() {
        return this.fineAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final MultiCurrencyMoney getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final MultiCurrencyMoney getAmountPaid() {
        return this.amountPaid;
    }

    /* renamed from: component7  reason: from getter */
    public final String getBillName() {
        return this.billName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getBillDate() {
        return this.billDate;
    }

    /* renamed from: component9  reason: from getter */
    public final String getBillItemId() {
        return this.billItemId;
    }

    public final BillDetail copy(String customerName, String invoiceNumber, MultiCurrencyMoney amount, MultiCurrencyMoney fineAmount, MultiCurrencyMoney totalAmount, MultiCurrencyMoney amountPaid, String billName, String billDate, String billItemId, String billInfo, String dueDate, String expiredDate, String description, Boolean selected) {
        return new BillDetail(customerName, invoiceNumber, amount, fineAmount, totalAmount, amountPaid, billName, billDate, billItemId, billInfo, dueDate, expiredDate, description, selected);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillDetail) {
            BillDetail billDetail = (BillDetail) other;
            return Intrinsics.areEqual(this.customerName, billDetail.customerName) && Intrinsics.areEqual(this.invoiceNumber, billDetail.invoiceNumber) && Intrinsics.areEqual(this.amount, billDetail.amount) && Intrinsics.areEqual(this.fineAmount, billDetail.fineAmount) && Intrinsics.areEqual(this.totalAmount, billDetail.totalAmount) && Intrinsics.areEqual(this.amountPaid, billDetail.amountPaid) && Intrinsics.areEqual(this.billName, billDetail.billName) && Intrinsics.areEqual(this.billDate, billDetail.billDate) && Intrinsics.areEqual(this.billItemId, billDetail.billItemId) && Intrinsics.areEqual(this.billInfo, billDetail.billInfo) && Intrinsics.areEqual(this.dueDate, billDetail.dueDate) && Intrinsics.areEqual(this.expiredDate, billDetail.expiredDate) && Intrinsics.areEqual(this.description, billDetail.description) && Intrinsics.areEqual(this.selected, billDetail.selected);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.customerName;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.invoiceNumber;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MultiCurrencyMoney multiCurrencyMoney = this.amount;
        int hashCode3 = multiCurrencyMoney == null ? 0 : multiCurrencyMoney.hashCode();
        MultiCurrencyMoney multiCurrencyMoney2 = this.fineAmount;
        int hashCode4 = multiCurrencyMoney2 == null ? 0 : multiCurrencyMoney2.hashCode();
        MultiCurrencyMoney multiCurrencyMoney3 = this.totalAmount;
        int hashCode5 = multiCurrencyMoney3 == null ? 0 : multiCurrencyMoney3.hashCode();
        MultiCurrencyMoney multiCurrencyMoney4 = this.amountPaid;
        int hashCode6 = multiCurrencyMoney4 == null ? 0 : multiCurrencyMoney4.hashCode();
        String str3 = this.billName;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.billDate;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.billItemId;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.billInfo;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.dueDate;
        int hashCode11 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.expiredDate;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.description;
        int hashCode13 = str9 == null ? 0 : str9.hashCode();
        Boolean bool = this.selected;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillDetail(customerName=");
        sb.append(this.customerName);
        sb.append(", invoiceNumber=");
        sb.append(this.invoiceNumber);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", fineAmount=");
        sb.append(this.fineAmount);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", amountPaid=");
        sb.append(this.amountPaid);
        sb.append(", billName=");
        sb.append(this.billName);
        sb.append(", billDate=");
        sb.append(this.billDate);
        sb.append(", billItemId=");
        sb.append(this.billItemId);
        sb.append(", billInfo=");
        sb.append(this.billInfo);
        sb.append(", dueDate=");
        sb.append(this.dueDate);
        sb.append(", expiredDate=");
        sb.append(this.expiredDate);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", selected=");
        sb.append(this.selected);
        sb.append(')');
        return sb.toString();
    }

    public BillDetail(String str, String str2, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, MultiCurrencyMoney multiCurrencyMoney3, MultiCurrencyMoney multiCurrencyMoney4, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool) {
        this.customerName = str;
        this.invoiceNumber = str2;
        this.amount = multiCurrencyMoney;
        this.fineAmount = multiCurrencyMoney2;
        this.totalAmount = multiCurrencyMoney3;
        this.amountPaid = multiCurrencyMoney4;
        this.billName = str3;
        this.billDate = str4;
        this.billItemId = str5;
        this.billInfo = str6;
        this.dueDate = str7;
        this.expiredDate = str8;
        this.description = str9;
        this.selected = bool;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }

    @JvmName(name = "getInvoiceNumber")
    public final String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    @JvmName(name = "getAmount")
    public final MultiCurrencyMoney getAmount() {
        return this.amount;
    }

    @JvmName(name = "getFineAmount")
    public final MultiCurrencyMoney getFineAmount() {
        return this.fineAmount;
    }

    @JvmName(name = "getTotalAmount")
    public final MultiCurrencyMoney getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getAmountPaid")
    public final MultiCurrencyMoney getAmountPaid() {
        return this.amountPaid;
    }

    @JvmName(name = "getBillName")
    public final String getBillName() {
        return this.billName;
    }

    @JvmName(name = "getBillDate")
    public final String getBillDate() {
        return this.billDate;
    }

    @JvmName(name = "getBillItemId")
    public final String getBillItemId() {
        return this.billItemId;
    }

    @JvmName(name = "getBillInfo")
    public final String getBillInfo() {
        return this.billInfo;
    }

    @JvmName(name = "getDueDate")
    public final String getDueDate() {
        return this.dueDate;
    }

    @JvmName(name = "getExpiredDate")
    public final String getExpiredDate() {
        return this.expiredDate;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    public /* synthetic */ BillDetail(String str, String str2, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, MultiCurrencyMoney multiCurrencyMoney3, MultiCurrencyMoney multiCurrencyMoney4, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : multiCurrencyMoney, (i & 8) != 0 ? null : multiCurrencyMoney2, (i & 16) != 0 ? null : multiCurrencyMoney3, (i & 32) == 0 ? multiCurrencyMoney4 : null, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? "" : str4, (i & 256) != 0 ? "" : str5, (i & 512) != 0 ? "" : str6, (i & 1024) != 0 ? "" : str7, (i & 2048) != 0 ? "" : str8, (i & 4096) == 0 ? str9 : "", (i & 8192) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getSelected")
    public final Boolean getSelected() {
        return this.selected;
    }
}
