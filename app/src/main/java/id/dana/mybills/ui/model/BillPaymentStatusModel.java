package id.dana.mybills.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.animation.HomeTabActivity;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.mybills.data.model.response.ExtInfo;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.ui.constant.BillTypeState;
import id.dana.mybills.ui.model.PaidStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b*\b\u0086\b\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0083\u0001B«\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010>\u001a\u00020\u0016\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010@\u001a\u00020\u001b\u0012\b\b\u0002\u0010A\u001a\u00020\u0002\u0012\b\b\u0002\u0010B\u001a\u00020\u000b\u0012\b\b\u0002\u0010C\u001a\u00020!\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0012\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b&\u0010\rJ\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0004J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0012\u0010)\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b)\u0010\u0015J\u0012\u0010*\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b*\u0010\u0015J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u0004J²\u0002\u0010E\u001a\u00020\u00002\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010>\u001a\u00020\u00162\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010@\u001a\u00020\u001b2\b\b\u0002\u0010A\u001a\u00020\u00022\b\b\u0002\u0010B\u001a\u00020\u000b2\b\b\u0002\u0010C\u001a\u00020!2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020!HÖ\u0001¢\u0006\u0004\bG\u0010#J\u001a\u0010J\u001a\u00020\u000b2\b\u0010I\u001a\u0004\u0018\u00010HHÖ\u0003¢\u0006\u0004\bJ\u0010KJ\r\u0010M\u001a\u00020L¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020!HÖ\u0001¢\u0006\u0004\bO\u0010#J\r\u0010P\u001a\u00020\u000b¢\u0006\u0004\bP\u0010 J\r\u0010Q\u001a\u00020\u000b¢\u0006\u0004\bQ\u0010 J\r\u0010R\u001a\u00020\u000b¢\u0006\u0004\bR\u0010 J\r\u0010S\u001a\u00020\u000b¢\u0006\u0004\bS\u0010 J\r\u0010T\u001a\u00020\u000b¢\u0006\u0004\bT\u0010 J\u0010\u0010U\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bU\u0010\u0004J \u0010Z\u001a\u00020Y2\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020!HÖ\u0001¢\u0006\u0004\bZ\u0010[R\u0019\u0010-\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b-\u0010\\\u001a\u0004\b]\u0010\u0004R\u001c\u0010.\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\\\u001a\u0004\b^\u0010\u0004R\u001c\u0010<\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010_\u001a\u0004\b`\u0010\u0012R\u001c\u0010/\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010a\u001a\u0004\bb\u0010\rR\u001c\u00109\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010a\u001a\u0004\bc\u0010\rR\u001a\u0010@\u001a\u00020\u001b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010d\u001a\u0004\be\u0010\u001dR\u001c\u0010=\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010f\u001a\u0004\bg\u0010\u0015R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\\\u001a\u0004\bh\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\\\u001a\u0004\bi\u0010\u0004R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\\\u001a\u0004\bj\u0010\u0004R\"\u0010B\u001a\u00020\u000b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010k\u001a\u0004\bB\u0010 \"\u0004\bl\u0010mR\u001c\u0010D\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\\\u001a\u0004\bn\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010f\u001a\u0004\bo\u0010\u0015R\u001c\u00102\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010f\u001a\u0004\bp\u0010\u0015R\u001c\u00106\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010q\u001a\u0004\br\u0010\u0007R\u001a\u0010>\u001a\u00020\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010s\u001a\u0004\bt\u0010\u0018R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\\\u001a\u0004\bu\u0010\u0004R\u001a\u0010A\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010\\\u001a\u0004\bv\u0010\u0004R\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\\\u001a\u0004\bw\u0010\u0004R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010\\\u001a\u0004\bx\u0010\u0004R\u001c\u0010?\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010\\\u001a\u0004\by\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010\\\u001a\u0004\bz\u0010\u0004R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\\\u001a\u0004\b{\u0010\u0004R\u001c\u00105\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010q\u001a\u0004\b|\u0010\u0007R#\u0010C\u001a\u00020!8\u0007@\u0007X\u0087\u000e¢\u0006\u0013\n\u0004\bC\u0010}\u001a\u0004\b~\u0010#\"\u0005\b\u007f\u0010\u0080\u0001"}, d2 = {"Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "component10", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "component11", "component12", "component13", "", "component14", "()Ljava/lang/Boolean;", "component15", "component16", "Lid/dana/mybills/domain/model/BizProductDestination;", "component17", "()Lid/dana/mybills/domain/model/BizProductDestination;", "", "component18", "()Ljava/lang/Long;", "Lid/dana/mybills/ui/model/PaidStatus;", "component19", "()Lid/dana/mybills/ui/model/PaidStatus;", "component2", "component20", "Lid/dana/mybills/data/model/response/ExtInfo;", "component21", "()Lid/dana/mybills/data/model/response/ExtInfo;", "component22", "component23", "()Z", "", "component24", "()I", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "subscriptionId", "actionRedirectUrl", "billId", "canBePaid", "goodsType", "iconUrl", "nextScheduleTime", "nextScheduleDaysCount", "subscriptionTitle", "totalAmount", "paidAmount", "recurringType", "goodsId", "canInquiry", "payStatus", HomeTabActivity.WALLET_SECTION, "bizProductDestination", "gmtDueDate", "paidStatus", "status", "extInfo", InvoiceConstant.PAYMENT_METHOD, "isSelected", "viewType", "lastPayStatus", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/BizProductDestination;Ljava/lang/Long;Lid/dana/mybills/ui/model/PaidStatus;Ljava/lang/String;Lid/dana/mybills/data/model/response/ExtInfo;Ljava/lang/String;ZILjava/lang/String;)Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "describeContents", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lid/dana/mybills/ui/constant/BillTypeState;", "getBillState", "()Lid/dana/mybills/ui/constant/BillTypeState;", "hashCode", "isBillCanBeEditWithoutChangeTheProduct", "isBillCanBePaid", "isDigitalVoucher", "isGNExternalMerchant", "isPaylater", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getActionRedirectUrl", "getBillId", "Lid/dana/mybills/domain/model/BizProductDestination;", "getBizProductDestination", "Ljava/lang/Boolean;", "getCanBePaid", "getCanInquiry", "Lid/dana/mybills/data/model/response/ExtInfo;", "getExtInfo", "Ljava/lang/Long;", "getGmtDueDate", "getGoodsId", "getGoodsType", "getIconUrl", "Z", "setSelected", "(Z)V", "getLastPayStatus", "getNextScheduleDaysCount", "getNextScheduleTime", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getPaidAmount", "Lid/dana/mybills/ui/model/PaidStatus;", "getPaidStatus", "getPayStatus", "getPaymentMethod", "getRecurringType", "getSection", "getStatus", "getSubscriptionId", "getSubscriptionTitle", "getTotalAmount", "I", "getViewType", "setViewType", "(I)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/domain/model/BizProductDestination;Ljava/lang/Long;Lid/dana/mybills/ui/model/PaidStatus;Ljava/lang/String;Lid/dana/mybills/data/model/response/ExtInfo;Ljava/lang/String;ZILjava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BillPaymentStatusModel implements Parcelable {
    public static final int BILLS_SHIMMER_HOME = 4;
    public static final int BILLS_SHIMMER_MANAGE = 3;
    public static final int BILLS_TYPE_HOME = 0;
    public static final int BILLS_TYPE_MANAGE = 1;
    public static final int BILLS_TYPE_PAYMENT_CONFIRM = 2;
    public static final String INIT = "INIT";
    public static final String PAYMENT_PROCESS = "PAYMENT_PROCESS";
    public static final String SCHEDULED = "SCHEDULED";
    private final String actionRedirectUrl;
    private final String billId;
    private final BizProductDestination bizProductDestination;
    private final Boolean canBePaid;
    private final Boolean canInquiry;
    private final ExtInfo extInfo;
    private final Long gmtDueDate;
    private final String goodsId;
    private final String goodsType;
    private final String iconUrl;
    private boolean isSelected;
    private final String lastPayStatus;
    private final Long nextScheduleDaysCount;
    private final Long nextScheduleTime;
    private final MoneyViewModel paidAmount;
    private final PaidStatus paidStatus;
    private final String payStatus;
    private final String paymentMethod;
    private final String recurringType;
    private final String section;
    private final String status;
    private final String subscriptionId;
    private final String subscriptionTitle;
    private final MoneyViewModel totalAmount;
    private int viewType;
    public static final Parcelable.Creator<BillPaymentStatusModel> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<BillPaymentStatusModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BillPaymentStatusModel createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString6 = parcel.readString();
            MoneyViewModel createFromParcel = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel2 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new BillPaymentStatusModel(readString, readString2, readString3, valueOf, readString4, readString5, valueOf3, valueOf4, readString6, createFromParcel, createFromParcel2, readString7, readString8, valueOf2, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : BizProductDestination.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), (PaidStatus) parcel.readParcelable(BillPaymentStatusModel.class.getClassLoader()), parcel.readString(), ExtInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BillPaymentStatusModel[] newArray(int i) {
            return new BillPaymentStatusModel[i];
        }
    }

    public BillPaymentStatusModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, null, 33554431, null);
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
    public final Boolean getCanInquiry() {
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
    public final PaidStatus getPaidStatus() {
        return this.paidStatus;
    }

    /* renamed from: component2  reason: from getter */
    public final String getActionRedirectUrl() {
        return this.actionRedirectUrl;
    }

    /* renamed from: component20  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component21  reason: from getter */
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    /* renamed from: component22  reason: from getter */
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    /* renamed from: component23  reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: component24  reason: from getter */
    public final int getViewType() {
        return this.viewType;
    }

    /* renamed from: component25  reason: from getter */
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
    public final Long getNextScheduleDaysCount() {
        return this.nextScheduleDaysCount;
    }

    /* renamed from: component9  reason: from getter */
    public final String getSubscriptionTitle() {
        return this.subscriptionTitle;
    }

    public final BillPaymentStatusModel copy(String subscriptionId, String actionRedirectUrl, String billId, Boolean canBePaid, String goodsType, String iconUrl, Long nextScheduleTime, Long nextScheduleDaysCount, String subscriptionTitle, MoneyViewModel totalAmount, MoneyViewModel paidAmount, String recurringType, String goodsId, Boolean canInquiry, String payStatus, String section, BizProductDestination bizProductDestination, Long gmtDueDate, PaidStatus paidStatus, String status, ExtInfo extInfo, String paymentMethod, boolean isSelected, int viewType, String lastPayStatus) {
        Intrinsics.checkNotNullParameter(paidStatus, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        Intrinsics.checkNotNullParameter(paymentMethod, "");
        return new BillPaymentStatusModel(subscriptionId, actionRedirectUrl, billId, canBePaid, goodsType, iconUrl, nextScheduleTime, nextScheduleDaysCount, subscriptionTitle, totalAmount, paidAmount, recurringType, goodsId, canInquiry, payStatus, section, bizProductDestination, gmtDueDate, paidStatus, status, extInfo, paymentMethod, isSelected, viewType, lastPayStatus);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillPaymentStatusModel) {
            BillPaymentStatusModel billPaymentStatusModel = (BillPaymentStatusModel) other;
            return Intrinsics.areEqual(this.subscriptionId, billPaymentStatusModel.subscriptionId) && Intrinsics.areEqual(this.actionRedirectUrl, billPaymentStatusModel.actionRedirectUrl) && Intrinsics.areEqual(this.billId, billPaymentStatusModel.billId) && Intrinsics.areEqual(this.canBePaid, billPaymentStatusModel.canBePaid) && Intrinsics.areEqual(this.goodsType, billPaymentStatusModel.goodsType) && Intrinsics.areEqual(this.iconUrl, billPaymentStatusModel.iconUrl) && Intrinsics.areEqual(this.nextScheduleTime, billPaymentStatusModel.nextScheduleTime) && Intrinsics.areEqual(this.nextScheduleDaysCount, billPaymentStatusModel.nextScheduleDaysCount) && Intrinsics.areEqual(this.subscriptionTitle, billPaymentStatusModel.subscriptionTitle) && Intrinsics.areEqual(this.totalAmount, billPaymentStatusModel.totalAmount) && Intrinsics.areEqual(this.paidAmount, billPaymentStatusModel.paidAmount) && Intrinsics.areEqual(this.recurringType, billPaymentStatusModel.recurringType) && Intrinsics.areEqual(this.goodsId, billPaymentStatusModel.goodsId) && Intrinsics.areEqual(this.canInquiry, billPaymentStatusModel.canInquiry) && Intrinsics.areEqual(this.payStatus, billPaymentStatusModel.payStatus) && Intrinsics.areEqual(this.section, billPaymentStatusModel.section) && Intrinsics.areEqual(this.bizProductDestination, billPaymentStatusModel.bizProductDestination) && Intrinsics.areEqual(this.gmtDueDate, billPaymentStatusModel.gmtDueDate) && Intrinsics.areEqual(this.paidStatus, billPaymentStatusModel.paidStatus) && Intrinsics.areEqual(this.status, billPaymentStatusModel.status) && Intrinsics.areEqual(this.extInfo, billPaymentStatusModel.extInfo) && Intrinsics.areEqual(this.paymentMethod, billPaymentStatusModel.paymentMethod) && this.isSelected == billPaymentStatusModel.isSelected && this.viewType == billPaymentStatusModel.viewType && Intrinsics.areEqual(this.lastPayStatus, billPaymentStatusModel.lastPayStatus);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.subscriptionId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.actionRedirectUrl;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.billId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.canBePaid;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str4 = this.goodsType;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.iconUrl;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        Long l = this.nextScheduleTime;
        int hashCode7 = l == null ? 0 : l.hashCode();
        Long l2 = this.nextScheduleDaysCount;
        int hashCode8 = l2 == null ? 0 : l2.hashCode();
        String str6 = this.subscriptionTitle;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        MoneyViewModel moneyViewModel = this.totalAmount;
        int hashCode10 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        MoneyViewModel moneyViewModel2 = this.paidAmount;
        int hashCode11 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        String str7 = this.recurringType;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.goodsId;
        int hashCode13 = str8 == null ? 0 : str8.hashCode();
        Boolean bool2 = this.canInquiry;
        int hashCode14 = bool2 == null ? 0 : bool2.hashCode();
        String str9 = this.payStatus;
        int hashCode15 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.section;
        int hashCode16 = str10 == null ? 0 : str10.hashCode();
        BizProductDestination bizProductDestination = this.bizProductDestination;
        int hashCode17 = bizProductDestination == null ? 0 : bizProductDestination.hashCode();
        Long l3 = this.gmtDueDate;
        int hashCode18 = l3 == null ? 0 : l3.hashCode();
        int hashCode19 = this.paidStatus.hashCode();
        String str11 = this.status;
        int hashCode20 = str11 == null ? 0 : str11.hashCode();
        int hashCode21 = this.extInfo.hashCode();
        int hashCode22 = this.paymentMethod.hashCode();
        boolean z = this.isSelected;
        int i = z ? 1 : z ? 1 : 0;
        int i2 = this.viewType;
        String str12 = this.lastPayStatus;
        return (((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + i) * 31) + i2) * 31) + (str12 != null ? str12.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillPaymentStatusModel(subscriptionId=");
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
        sb.append(", paidStatus=");
        sb.append(this.paidStatus);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append(", paymentMethod=");
        sb.append(this.paymentMethod);
        sb.append(", isSelected=");
        sb.append(this.isSelected);
        sb.append(", viewType=");
        sb.append(this.viewType);
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
        Long l2 = this.nextScheduleDaysCount;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        parcel.writeString(this.subscriptionTitle);
        MoneyViewModel moneyViewModel = this.totalAmount;
        if (moneyViewModel == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            moneyViewModel.writeToParcel(parcel, flags);
        }
        MoneyViewModel moneyViewModel2 = this.paidAmount;
        if (moneyViewModel2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            moneyViewModel2.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.recurringType);
        parcel.writeString(this.goodsId);
        Boolean bool2 = this.canInquiry;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.payStatus);
        parcel.writeString(this.section);
        BizProductDestination bizProductDestination = this.bizProductDestination;
        if (bizProductDestination == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bizProductDestination.writeToParcel(parcel, flags);
        }
        Long l3 = this.gmtDueDate;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeParcelable(this.paidStatus, flags);
        parcel.writeString(this.status);
        this.extInfo.writeToParcel(parcel, flags);
        parcel.writeString(this.paymentMethod);
        parcel.writeInt(this.isSelected ? 1 : 0);
        parcel.writeInt(this.viewType);
        parcel.writeString(this.lastPayStatus);
    }

    public BillPaymentStatusModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Long l, Long l2, String str6, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str7, String str8, Boolean bool2, String str9, String str10, BizProductDestination bizProductDestination, Long l3, PaidStatus paidStatus, String str11, ExtInfo extInfo, String str12, boolean z, int i, String str13) {
        Intrinsics.checkNotNullParameter(paidStatus, "");
        Intrinsics.checkNotNullParameter(extInfo, "");
        Intrinsics.checkNotNullParameter(str12, "");
        this.subscriptionId = str;
        this.actionRedirectUrl = str2;
        this.billId = str3;
        this.canBePaid = bool;
        this.goodsType = str4;
        this.iconUrl = str5;
        this.nextScheduleTime = l;
        this.nextScheduleDaysCount = l2;
        this.subscriptionTitle = str6;
        this.totalAmount = moneyViewModel;
        this.paidAmount = moneyViewModel2;
        this.recurringType = str7;
        this.goodsId = str8;
        this.canInquiry = bool2;
        this.payStatus = str9;
        this.section = str10;
        this.bizProductDestination = bizProductDestination;
        this.gmtDueDate = l3;
        this.paidStatus = paidStatus;
        this.status = str11;
        this.extInfo = extInfo;
        this.paymentMethod = str12;
        this.isSelected = z;
        this.viewType = i;
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
    public final Long getNextScheduleDaysCount() {
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
    public final Boolean getCanInquiry() {
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

    public /* synthetic */ BillPaymentStatusModel(String str, String str2, String str3, Boolean bool, String str4, String str5, Long l, Long l2, String str6, MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, String str7, String str8, Boolean bool2, String str9, String str10, BizProductDestination bizProductDestination, Long l3, PaidStatus paidStatus, String str11, ExtInfo extInfo, String str12, boolean z, int i, String str13, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : l, (i2 & 128) != 0 ? null : l2, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? null : moneyViewModel, (i2 & 1024) != 0 ? null : moneyViewModel2, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? null : bool2, (i2 & 16384) != 0 ? null : str9, (i2 & 32768) != 0 ? null : str10, (i2 & 65536) != 0 ? null : bizProductDestination, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : l3, (i2 & 262144) != 0 ? PaidStatus.Confirm.INSTANCE : paidStatus, (i2 & 524288) != 0 ? null : str11, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? new ExtInfo(null, null, null, null, null, 31, null) : extInfo, (i2 & 2097152) != 0 ? "BALANCE" : str12, (i2 & 4194304) != 0 ? false : z, (i2 & 8388608) == 0 ? i : 0, (i2 & 16777216) != 0 ? null : str13);
    }

    @JvmName(name = "getPaidStatus")
    public final PaidStatus getPaidStatus() {
        return this.paidStatus;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getExtInfo")
    public final ExtInfo getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "getPaymentMethod")
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @JvmName(name = "isSelected")
    public final boolean isSelected() {
        return this.isSelected;
    }

    @JvmName(name = "setSelected")
    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @JvmName(name = "getViewType")
    public final int getViewType() {
        return this.viewType;
    }

    @JvmName(name = "setViewType")
    public final void setViewType(int i) {
        this.viewType = i;
    }

    @JvmName(name = "getLastPayStatus")
    public final String getLastPayStatus() {
        return this.lastPayStatus;
    }

    public final boolean isGNExternalMerchant() {
        return Intrinsics.areEqual(this.goodsType, "GN_MERCHANT") || Intrinsics.areEqual(this.goodsType, "EXTERNAL_MERCHANT");
    }

    public final boolean isPaylater() {
        return Intrinsics.areEqual(this.goodsType, "CICIL");
    }

    public final boolean isDigitalVoucher() {
        return Intrinsics.areEqual(this.goodsType, "GAME_VOUCHER");
    }

    public final boolean isBillCanBePaid() {
        boolean z = !Intrinsics.areEqual(this.status, PAYMENT_PROCESS) && Intrinsics.areEqual(this.lastPayStatus, "INIT");
        boolean z2 = Intrinsics.areEqual(this.canBePaid, Boolean.TRUE) && !Intrinsics.areEqual(this.status, PAYMENT_PROCESS);
        BizProductDestination bizProductDestination = this.bizProductDestination;
        boolean z3 = (bizProductDestination == null || bizProductDestination.isInquiryGot25And26()) ? false : true;
        if (!z || z3) {
            return z2 && z3 && !z;
        }
        return true;
    }

    public final boolean isBillCanBeEditWithoutChangeTheProduct() {
        if (Intrinsics.areEqual(this.status, PAYMENT_PROCESS) || Intrinsics.areEqual(this.lastPayStatus, "INIT")) {
            return false;
        }
        BizProductDestination bizProductDestination = this.bizProductDestination;
        return bizProductDestination != null && !bizProductDestination.isInquiryGot25And26();
    }

    public final BillTypeState getBillState() {
        if (isGNExternalMerchant()) {
            return BillTypeState.BillGNMerchant.INSTANCE;
        }
        MoneyViewModel moneyViewModel = this.totalAmount;
        if (!Intrinsics.areEqual(moneyViewModel != null ? moneyViewModel.getAmount() : null, "0")) {
            MoneyViewModel moneyViewModel2 = this.totalAmount;
            String amount = moneyViewModel2 != null ? moneyViewModel2.getAmount() : null;
            if (!(amount == null || amount.length() == 0)) {
                if (Intrinsics.areEqual(this.status, SCHEDULED)) {
                    return BillTypeState.BillSchedule.INSTANCE;
                }
                if (Intrinsics.areEqual(this.status, PAYMENT_PROCESS)) {
                    return BillTypeState.BillTrxInProgress.INSTANCE;
                }
                if (isBillCanBePaid()) {
                    return BillTypeState.BillNotIssued.INSTANCE;
                }
                return BillTypeState.BillSchedule.INSTANCE;
            }
        }
        return BillTypeState.BillNullAmount.INSTANCE;
    }
}
