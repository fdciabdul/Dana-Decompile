package id.dana.mybills.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.animation.HomeTabActivity;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.mybills.data.model.response.ExtInfo;
import id.dana.mybills.domain.model.BizProductDestination;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b#\b\u0086\b\u0018\u0000 m2\u00020\u0001:\u0001mBá\u0001\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010-\u001a\u00020\u0013\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00100\u001a\u00020\u0005\u0012\b\u00101\u001a\u0004\u0018\u00010\u0002\u0012\b\u00102\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u000b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0010\u0012\b\u00107\u001a\u0004\u0018\u00010\u0013\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00109\u001a\u00020\u0018\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bk\u0010lJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\"\u0010\u0015J\u0010\u0010#\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0088\u0002\u0010<\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010-\u001a\u00020\u00132\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010/\u001a\u00020\u00052\b\b\u0002\u00100\u001a\u00020\u00052\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00103\u001a\u00020\u000b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00105\u001a\u00020\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00109\u001a\u00020\u00182\b\b\u0002\u0010:\u001a\u00020\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b<\u0010=J\u0010\u0010?\u001a\u00020>HÖ\u0001¢\u0006\u0004\b?\u0010@J\u001a\u0010C\u001a\u00020\u000b2\b\u0010B\u001a\u0004\u0018\u00010AHÖ\u0003¢\u0006\u0004\bC\u0010DJ\u0010\u0010E\u001a\u00020>HÖ\u0001¢\u0006\u0004\bE\u0010@J\u0010\u0010F\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bF\u0010\u0004J \u0010K\u001a\u00020J2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020>HÖ\u0001¢\u0006\u0004\bK\u0010LR\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b'\u0010M\u001a\u0004\bN\u0010\u0004R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010M\u001a\u0004\bO\u0010\u0004R\u001c\u00106\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010P\u001a\u0004\bQ\u0010\u0012R\u001c\u0010)\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010R\u001a\u0004\bS\u0010\u001fR\u001a\u00103\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010T\u001a\u0004\bU\u0010\rR\u001a\u00109\u001a\u00020\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010V\u001a\u0004\bW\u0010\u001aR\u001c\u00107\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010X\u001a\u0004\bY\u0010\u0015R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010M\u001a\u0004\bZ\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010M\u001a\u0004\b[\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010M\u001a\u0004\b\\\u0010\u0004R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010M\u001a\u0004\b]\u0010\u0004R\u001a\u0010-\u001a\u00020\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010^\u001a\u0004\b_\u0010$R\u001c\u0010,\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010X\u001a\u0004\b`\u0010\u0015R\u001a\u00100\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010a\u001a\u0004\bb\u0010\u0007R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010M\u001a\u0004\bc\u0010\u0004R\u001a\u0010:\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010M\u001a\u0004\bd\u0010\u0004R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010M\u001a\u0004\be\u0010\u0004R\u001a\u00105\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010M\u001a\u0004\bf\u0010\u0004R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010M\u001a\u0004\bg\u0010\u0004R\u001a\u0010&\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010M\u001a\u0004\bh\u0010\u0004R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010M\u001a\u0004\bi\u0010\u0004R\u001a\u0010/\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010a\u001a\u0004\bj\u0010\u0007"}, d2 = {"Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "component10", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "component11", "component12", "component13", "", "component14", "()Z", "component15", "component16", "Lid/dana/mybills/domain/model/BizProductDestination;", "component17", "()Lid/dana/mybills/domain/model/BizProductDestination;", "", "component18", "()Ljava/lang/Long;", "component19", "component2", "Lid/dana/mybills/data/model/response/ExtInfo;", "component20", "()Lid/dana/mybills/data/model/response/ExtInfo;", "component21", "component22", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "component7", "component8", "()J", "component9", "subscriptionId", "actionRedirectUrl", "billId", "canBePaid", "goodsType", "iconUrl", "nextScheduleTime", "nextScheduleDaysCount", "subscriptionTitle", "totalAmount", "paidAmount", "recurringType", "goodsId", "canInquiry", "payStatus", HomeTabActivity.WALLET_SECTION, "bizProductDestination", "gmtDueDate", "status", "extInfo", InvoiceConstant.PAYMENT_METHOD, "lastPayStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/BizProductDestination;Ljava/lang/Long;Ljava/lang/String;Lid/dana/mybills/data/model/response/ExtInfo;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/ui/model/BillSubscriptionHighlightModel;", "", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getActionRedirectUrl", "getBillId", "Lid/dana/mybills/domain/model/BizProductDestination;", "getBizProductDestination", "Ljava/lang/Boolean;", "getCanBePaid", "Z", "getCanInquiry", "Lid/dana/mybills/data/model/response/ExtInfo;", "getExtInfo", "Ljava/lang/Long;", "getGmtDueDate", "getGoodsId", "getGoodsType", "getIconUrl", "getLastPayStatus", "J", "getNextScheduleDaysCount", "getNextScheduleTime", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getPaidAmount", "getPayStatus", "getPaymentMethod", "getRecurringType", "getSection", "getStatus", "getSubscriptionId", "getSubscriptionTitle", "getTotalAmount", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/BizProductDestination;Ljava/lang/Long;Ljava/lang/String;Lid/dana/mybills/data/model/response/ExtInfo;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BillSubscriptionHighlightModel implements Parcelable {
    public static final String PAYMENT_METHOD_BALANCE = "BALANCE";
    private final String actionRedirectUrl;
    private final String billId;
    private final BizProductDestination bizProductDestination;
    private final Boolean canBePaid;
    private final boolean canInquiry;
    private final ExtInfo extInfo;
    private final Long gmtDueDate;
    private final String goodsId;
    private final String goodsType;
    private final String iconUrl;
    private final String lastPayStatus;
    private final long nextScheduleDaysCount;
    private final Long nextScheduleTime;
    private final MoneyViewModel paidAmount;
    private final String payStatus;
    private final String paymentMethod;
    private final String recurringType;
    private final String section;
    private final String status;
    private final String subscriptionId;
    private final String subscriptionTitle;
    private final MoneyViewModel totalAmount;
    public static final Parcelable.Creator<BillSubscriptionHighlightModel> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<BillSubscriptionHighlightModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BillSubscriptionHighlightModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new BillSubscriptionHighlightModel(readString, readString2, readString3, valueOf, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readLong(), parcel.readString(), MoneyViewModel.CREATOR.createFromParcel(parcel), MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : BizProductDestination.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), ExtInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BillSubscriptionHighlightModel[] newArray(int i) {
            return new BillSubscriptionHighlightModel[i];
        }
    }

    /* renamed from: component1  reason: from getter */
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    /* renamed from: component10  reason: from getter */
    public final MoneyViewModel getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component11  reason: from getter */
    public final MoneyViewModel getPaidAmount() {
        return this.paidAmount;
    }

    /* renamed from: component12  reason: from getter */
    public final String getRecurringType() {
        return this.recurringType;
    }

    /* renamed from: component13  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component14  reason: from getter */
    public final boolean getCanInquiry() {
        return this.canInquiry;
    }

    /* renamed from: component15  reason: from getter */
    public final String getPayStatus() {
        return this.payStatus;
    }

    /* renamed from: component16  reason: from getter */
    public final String getSection() {
        return this.section;
    }

    /* renamed from: component17  reason: from getter */
    public final BizProductDestination getBizProductDestination() {
        return this.bizProductDestination;
    }

    /* renamed from: component18  reason: from getter */
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }

    /* renamed from: component19  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2  reason: from getter */
    public final String getActionRedirectUrl() {
        return this.actionRedirectUrl;
    }

    /* renamed from: component20  reason: from getter */
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    /* renamed from: component21  reason: from getter */
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    /* renamed from: component22  reason: from getter */
    public final String getLastPayStatus() {
        return this.lastPayStatus;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBillId() {
        return this.billId;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getCanBePaid() {
        return this.canBePaid;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: component6  reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component7  reason: from getter */
    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    /* renamed from: component8  reason: from getter */
    public final long getNextScheduleDaysCount() {
        return this.nextScheduleDaysCount;
    }

    /* renamed from: component9  reason: from getter */
    public final String getSubscriptionTitle() {
        return this.subscriptionTitle;
    }

    public final BillSubscriptionHighlightModel copy(String subscriptionId, String actionRedirectUrl, String billId, Boolean canBePaid, String goodsType, String iconUrl, Long nextScheduleTime, long nextScheduleDaysCount, String subscriptionTitle, MoneyViewModel totalAmount, MoneyViewModel paidAmount, String recurringType, String goodsId, boolean canInquiry, String payStatus, String section, BizProductDestination bizProductDestination, Long gmtDueDate, String status, ExtInfo extInfo, String paymentMethod, String lastPayStatus) {
        Intrinsics.checkNotNullParameter(subscriptionId, "");
        Intrinsics.checkNotNullParameter(totalAmount, "");
        Intrinsics.checkNotNullParameter(paidAmount, "");
        Intrinsics.checkNotNullParameter(section, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        Intrinsics.checkNotNullParameter(paymentMethod, "");
        return new BillSubscriptionHighlightModel(subscriptionId, actionRedirectUrl, billId, canBePaid, goodsType, iconUrl, nextScheduleTime, nextScheduleDaysCount, subscriptionTitle, totalAmount, paidAmount, recurringType, goodsId, canInquiry, payStatus, section, bizProductDestination, gmtDueDate, status, extInfo, paymentMethod, lastPayStatus);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillSubscriptionHighlightModel) {
            BillSubscriptionHighlightModel billSubscriptionHighlightModel = (BillSubscriptionHighlightModel) other;
            return Intrinsics.areEqual(this.subscriptionId, billSubscriptionHighlightModel.subscriptionId) && Intrinsics.areEqual(this.actionRedirectUrl, billSubscriptionHighlightModel.actionRedirectUrl) && Intrinsics.areEqual(this.billId, billSubscriptionHighlightModel.billId) && Intrinsics.areEqual(this.canBePaid, billSubscriptionHighlightModel.canBePaid) && Intrinsics.areEqual(this.goodsType, billSubscriptionHighlightModel.goodsType) && Intrinsics.areEqual(this.iconUrl, billSubscriptionHighlightModel.iconUrl) && Intrinsics.areEqual(this.nextScheduleTime, billSubscriptionHighlightModel.nextScheduleTime) && this.nextScheduleDaysCount == billSubscriptionHighlightModel.nextScheduleDaysCount && Intrinsics.areEqual(this.subscriptionTitle, billSubscriptionHighlightModel.subscriptionTitle) && Intrinsics.areEqual(this.totalAmount, billSubscriptionHighlightModel.totalAmount) && Intrinsics.areEqual(this.paidAmount, billSubscriptionHighlightModel.paidAmount) && Intrinsics.areEqual(this.recurringType, billSubscriptionHighlightModel.recurringType) && Intrinsics.areEqual(this.goodsId, billSubscriptionHighlightModel.goodsId) && this.canInquiry == billSubscriptionHighlightModel.canInquiry && Intrinsics.areEqual(this.payStatus, billSubscriptionHighlightModel.payStatus) && Intrinsics.areEqual(this.section, billSubscriptionHighlightModel.section) && Intrinsics.areEqual(this.bizProductDestination, billSubscriptionHighlightModel.bizProductDestination) && Intrinsics.areEqual(this.gmtDueDate, billSubscriptionHighlightModel.gmtDueDate) && Intrinsics.areEqual(this.status, billSubscriptionHighlightModel.status) && Intrinsics.areEqual(this.extInfo, billSubscriptionHighlightModel.extInfo) && Intrinsics.areEqual(this.paymentMethod, billSubscriptionHighlightModel.paymentMethod) && Intrinsics.areEqual(this.lastPayStatus, billSubscriptionHighlightModel.lastPayStatus);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.subscriptionId.hashCode();
        String str = this.actionRedirectUrl;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.billId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        Boolean bool = this.canBePaid;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str3 = this.goodsType;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.iconUrl;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        Long l = this.nextScheduleTime;
        int hashCode7 = l == null ? 0 : l.hashCode();
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.nextScheduleDaysCount);
        String str5 = this.subscriptionTitle;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        int hashCode9 = this.totalAmount.hashCode();
        int hashCode10 = this.paidAmount.hashCode();
        String str6 = this.recurringType;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.goodsId;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        boolean z = this.canInquiry;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str8 = this.payStatus;
        int hashCode13 = str8 == null ? 0 : str8.hashCode();
        int hashCode14 = this.section.hashCode();
        BizProductDestination bizProductDestination = this.bizProductDestination;
        int hashCode15 = bizProductDestination == null ? 0 : bizProductDestination.hashCode();
        Long l2 = this.gmtDueDate;
        int hashCode16 = l2 == null ? 0 : l2.hashCode();
        String str9 = this.status;
        int hashCode17 = str9 == null ? 0 : str9.hashCode();
        int hashCode18 = this.extInfo.hashCode();
        int hashCode19 = this.paymentMethod.hashCode();
        String str10 = this.lastPayStatus;
        return (((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + m) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + i) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + (str10 != null ? str10.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillSubscriptionHighlightModel(subscriptionId=");
        sb.append(this.subscriptionId);
        sb.append(", actionRedirectUrl=");
        sb.append(this.actionRedirectUrl);
        sb.append(", billId=");
        sb.append(this.billId);
        sb.append(", canBePaid=");
        sb.append(this.canBePaid);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", iconUrl=");
        sb.append(this.iconUrl);
        sb.append(", nextScheduleTime=");
        sb.append(this.nextScheduleTime);
        sb.append(", nextScheduleDaysCount=");
        sb.append(this.nextScheduleDaysCount);
        sb.append(", subscriptionTitle=");
        sb.append(this.subscriptionTitle);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", paidAmount=");
        sb.append(this.paidAmount);
        sb.append(", recurringType=");
        sb.append(this.recurringType);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", canInquiry=");
        sb.append(this.canInquiry);
        sb.append(", payStatus=");
        sb.append(this.payStatus);
        sb.append(", section=");
        sb.append(this.section);
        sb.append(", bizProductDestination=");
        sb.append(this.bizProductDestination);
        sb.append(", gmtDueDate=");
        sb.append(this.gmtDueDate);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", lastPayStatus=");
        sb.append(this.lastPayStatus);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.subscriptionId);
        parcel.writeString(this.actionRedirectUrl);
        parcel.writeString(this.billId);
        Boolean bool = this.canBePaid;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.goodsType);
        parcel.writeString(this.iconUrl);
        Long l = this.nextScheduleTime;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeLong(this.nextScheduleDaysCount);
        parcel.writeString(this.subscriptionTitle);
        this.totalAmount.writeToParcel(parcel, flags);
        this.paidAmount.writeToParcel(parcel, flags);
        parcel.writeString(this.recurringType);
        parcel.writeString(this.goodsId);
        parcel.writeInt(this.canInquiry ? 1 : 0);
        parcel.writeString(this.payStatus);
        parcel.writeString(this.section);
        BizProductDestination bizProductDestination = this.bizProductDestination;
        if (bizProductDestination == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bizProductDestination.writeToParcel(parcel, flags);
        }
        Long l2 = this.gmtDueDate;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        parcel.writeString(this.status);
        this.extInfo.writeToParcel(parcel, flags);
        parcel.writeString(this.paymentMethod);
        parcel.writeString(this.lastPayStatus);
    }

    public BillSubscriptionHighlightModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Long l, long j, String str6, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str7, String str8, boolean z, String str9, String str10, BizProductDestination bizProductDestination, Long l2, String str11, ExtInfo extInfo, String str12, String str13) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        Intrinsics.checkNotNullParameter(str12, "");
        this.subscriptionId = str;
        this.actionRedirectUrl = str2;
        this.billId = str3;
        this.canBePaid = bool;
        this.goodsType = str4;
        this.iconUrl = str5;
        this.nextScheduleTime = l;
        this.nextScheduleDaysCount = j;
        this.subscriptionTitle = str6;
        this.totalAmount = moneyViewModel;
        this.paidAmount = moneyViewModel2;
        this.recurringType = str7;
        this.goodsId = str8;
        this.canInquiry = z;
        this.payStatus = str9;
        this.section = str10;
        this.bizProductDestination = bizProductDestination;
        this.gmtDueDate = l2;
        this.status = str11;
        this.extInfo = extInfo;
        this.paymentMethod = str12;
        this.lastPayStatus = str13;
    }

    @JvmName(name = "getSubscriptionId")
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @JvmName(name = "getActionRedirectUrl")
    public final String getActionRedirectUrl() {
        return this.actionRedirectUrl;
    }

    @JvmName(name = "getBillId")
    public final String getBillId() {
        return this.billId;
    }

    @JvmName(name = "getCanBePaid")
    public final Boolean getCanBePaid() {
        return this.canBePaid;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @JvmName(name = "getNextScheduleTime")
    public final Long getNextScheduleTime() {
        return this.nextScheduleTime;
    }

    @JvmName(name = "getNextScheduleDaysCount")
    public final long getNextScheduleDaysCount() {
        return this.nextScheduleDaysCount;
    }

    @JvmName(name = "getSubscriptionTitle")
    public final String getSubscriptionTitle() {
        return this.subscriptionTitle;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyViewModel getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getPaidAmount")
    public final MoneyViewModel getPaidAmount() {
        return this.paidAmount;
    }

    @JvmName(name = "getRecurringType")
    public final String getRecurringType() {
        return this.recurringType;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getCanInquiry")
    public final boolean getCanInquiry() {
        return this.canInquiry;
    }

    @JvmName(name = "getPayStatus")
    public final String getPayStatus() {
        return this.payStatus;
    }

    @JvmName(name = "getSection")
    public final String getSection() {
        return this.section;
    }

    @JvmName(name = "getBizProductDestination")
    public final BizProductDestination getBizProductDestination() {
        return this.bizProductDestination;
    }

    @JvmName(name = "getGmtDueDate")
    public final Long getGmtDueDate() {
        return this.gmtDueDate;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    public /* synthetic */ BillSubscriptionHighlightModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Long l, long j, String str6, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str7, String str8, boolean z, String str9, String str10, BizProductDestination bizProductDestination, Long l2, String str11, ExtInfo extInfo, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, bool, str4, str5, l, j, str6, moneyViewModel, moneyViewModel2, str7, str8, (i & 8192) != 0 ? false : z, (i & 16384) != 0 ? null : str9, (32768 & i) != 0 ? "" : str10, (65536 & i) != 0 ? null : bizProductDestination, l2, str11, (524288 & i) != 0 ? new ExtInfo(null, null, null, null, null, 31, null) : extInfo, (1048576 & i) != 0 ? "BALANCE" : str12, (i & 2097152) != 0 ? null : str13);
    }

    @JvmName(name = "getExtInfo")
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "getPaymentMethod")
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "getLastPayStatus")
    public final String getLastPayStatus() {
        return this.lastPayStatus;
    }
}
