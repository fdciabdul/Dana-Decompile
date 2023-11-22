package id.dana.mybills.ui.customview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.messaging.Constants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.TextUtil;
import id.dana.data.util.DateTimeUtil;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewHeaderDetailBillsBinding;
import id.dana.mybills.databinding.ViewSinglePayBodyBinding;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.customview.BodySaveToBillsView;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.BillPaymentStatusModelKt;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.v2.billdetail.util.BillDetailUtil;
import id.dana.mybills.ui.v2.billdetail.view.BillDetailView;
import id.dana.mybills.utils.AddNewBillsUtils;
import id.dana.mybills.utils.MyBillsCalendarUtil;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0089\u0001B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0010\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u0014H\u0002J\u001a\u0010R\u001a\u0004\u0018\u00010\u00142\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010TH\u0002J\u0006\u0010V\u001a\u00020WJ\b\u0010X\u001a\u00020\u0002H\u0016J\b\u0010Y\u001a\u00020@H\u0002J\u0010\u0010Z\u001a\u00020@2\u0006\u0010[\u001a\u000209H\u0002J\u0010\u0010\\\u001a\u00020@2\u0006\u0010[\u001a\u000209H\u0002J\u0010\u0010]\u001a\u00020@2\u0006\u0010[\u001a\u000209H\u0002J$\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u0002092\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010a\u001a\u000209J\b\u0010b\u001a\u000209H\u0002J\u0010\u0010c\u001a\u00020@2\u0006\u0010[\u001a\u000209H\u0002J\u001c\u0010d\u001a\u00020@2\u0006\u0010[\u001a\u0002092\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010e\u001a\u00020@2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020g0TJ\u0010\u0010h\u001a\u00020@2\u0006\u0010i\u001a\u00020-H\u0002J\u0010\u0010j\u001a\u00020@2\b\u0010k\u001a\u0004\u0018\u00010/J\u001a\u0010l\u001a\u00020@2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020@0HJ\"\u0010m\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?J\b\u0010K\u001a\u00020@H\u0002J\u0006\u0010n\u001a\u00020@J\u0012\u0010o\u001a\u00020@2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0014J\b\u0010p\u001a\u00020@H\u0002J\u000e\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020rJ\b\u0010t\u001a\u00020@H\u0002JG\u0010u\u001a\u00020@*\u00020;2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u00142\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010y\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0002¢\u0006\u0002\u0010zJA\u0010u\u001a\u00020@*\u00020;2\b\b\u0001\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u00142\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010y\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0002¢\u0006\u0002\u0010{J\f\u0010|\u001a\u00020-*\u00020rH\u0002J\f\u0010}\u001a\u00020-*\u00020rH\u0002J\f\u0010~\u001a\u00020-*\u00020rH\u0002J\f\u0010\u007f\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0080\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0081\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0082\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0083\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0084\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0085\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0086\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0087\u0001\u001a\u00020-*\u00020rH\u0002J\r\u0010\u0088\u0001\u001a\u00020-*\u00020rH\u0002R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R#\u0010%\u001a\n '*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00100\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b5\u00103R\u0011\u00106\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b7\u00103R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010:\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?X\u0082.¢\u0006\u0002\n\u0000R\"\u0010B\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020@0HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010\u0018R \u0010L\u001a\b\u0012\u0004\u0012\u00020@0?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010D\"\u0004\bN\u0010FR\u000e\u0010O\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lid/dana/mybills/ui/customview/BodySinglePayView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewSinglePayBodyBinding;", HummerConstants.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "billDateReminder", "getBillDateReminder", "()I", "setBillDateReminder", "(I)V", "billMonthReminder", "getBillMonthReminder", "setBillMonthReminder", "billName", "", "getBillName", "()Ljava/lang/String;", "setBillName", "(Ljava/lang/String;)V", "billNewDenom", "getBillNewDenom", "setBillNewDenom", "billNewTotalAmount", "Lid/dana/mybills/ui/model/MoneyViewModel;", "getBillNewTotalAmount", "()Lid/dana/mybills/ui/model/MoneyViewModel;", "setBillNewTotalAmount", "(Lid/dana/mybills/ui/model/MoneyViewModel;)V", "billSelectedGoodsId", "getBillSelectedGoodsId", "setBillSelectedGoodsId", "billsCalendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getBillsCalendar", "()Ljava/util/Calendar;", "billsCalendar$delegate", "Lkotlin/Lazy;", "builder", "Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView$Builder;", "dateRange", "Lkotlin/ranges/IntRange;", "dropdownBillAmount", "Lid/dana/mybills/ui/customview/CustomDropdownView;", "getDropdownBillAmount", "()Lid/dana/mybills/ui/customview/CustomDropdownView;", "dropdownBillType", "getDropdownBillType", "dropdownProduct", "getDropdownProduct", "firstTimeFlag", "", "llBillDetail", "Landroidx/appcompat/widget/LinearLayoutCompat;", "getLlBillDetail", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "onCancelButtonClicked", "Lkotlin/Function0;", "", "onEditButtonClicked", "onProductFieldClicked", "getOnProductFieldClicked", "()Lkotlin/jvm/functions/Function0;", "setOnProductFieldClicked", "(Lkotlin/jvm/functions/Function0;)V", "onSeletedDateNotInRange", "Lkotlin/Function1;", "serviceType", "getServiceType", "setServiceType", "toastCopy", "getToastCopy", "setToastCopy", "typePage", "copyToClipboard", "targetCopy", "getFormatPeriod", "period", "", "", "getHeader", "Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "inflateViewBinding", "initViews", "isAmountFieldEditable", "isEditable", "isBillBillingDateFieldEditable", "isBillNameFieldEditable", "isEditEnabled", "enabled", "source", "canEditTheProduct", "isGNExternalMerchant", "isPaymentTypeFieldEditable", "isProductFieldEditable", "mapProducts", "products", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "setBillDetailExtraProperties", "billDetailView", "setDatePickerRange", "rangeDate", "setDatePickerRangeListener", "setListenerStateEditAndCancel", "setStatePageDetailUi", "setStatePageEditUi", "setupTitleSection", ContainerUIProvider.KEY_SHOW, "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "billPaymentModel", "showCalendar", "addViewBillDetail", Constants.ScionAnalytics.PARAM_LABEL, "value", "icon", "onClickIconListener", "(Landroidx/appcompat/widget/LinearLayoutCompat;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "(Landroidx/appcompat/widget/LinearLayoutCompat;ILjava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "setBpjsView", "setDefaultBillDetail", "setElectricityView", "setGNExternalMerchant", "setGameVoucher", "setInstallmentView", "setInsuranceView", "setInternetDigitalTvView", "setMobilePostpaidView", "setPgnView", "setPulsaPrepaidView", "setTelkomView", "setWaterView", "Companion", "feature-mybills_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BodySinglePayView extends BaseViewBindingRichView<ViewSinglePayBodyBinding> {
    public static final String COPY_LABEL = "ICON_DESC_COPY";
    public static final String DATE_FORMAT_DD_MMMM_YYYY = "dd MMMM yyyy";
    public static final String DATE_FORMAT_MMMyy = "MMMyy";
    private String BuiltInFictitiousFunctionClassFactory;
    private String DatabaseTableConfigUtil;
    private Function1<? super IntRange, Unit> GetContactSyncConfig;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Function0<Unit> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Function0<Unit> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private Function0<Unit> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String PlaceComponentResult;
    private MoneyViewModel getAuthRequestContext;
    private BillDetailView.Builder getErrorConfigVersion;
    private Function0<Unit> initRecordTimeStamp;
    private IntRange lookAheadTest;
    private final Lazy moveToNextValue;
    private String newProxyInstance;
    private String scheduleImpl;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BodySinglePayView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BodySinglePayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BodySinglePayView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ BodySinglePayView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodySinglePayView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        IntRange intRange;
        Intrinsics.checkNotNullParameter(context, "");
        this.DatabaseTableConfigUtil = "";
        this.PlaceComponentResult = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
        this.MyBillsEntityDataFactory = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Function0<Unit>() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$toastCopy$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.newProxyInstance = "TYPE_PAGE_DETAIL";
        this.GetContactSyncConfig = new Function1<IntRange, Unit>() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$onSeletedDateNotInRange$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(IntRange intRange2) {
                Intrinsics.checkNotNullParameter(intRange2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(IntRange intRange2) {
                invoke2(intRange2);
                return Unit.INSTANCE;
            }
        };
        BodySaveToBillsView.Companion companion = BodySaveToBillsView.INSTANCE;
        intRange = BodySaveToBillsView.BuiltInFictitiousFunctionClassFactory;
        this.lookAheadTest = intRange;
        this.moveToNextValue = LazyKt.lazy(new Function0<Calendar>() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$billsCalendar$2
            @Override // kotlin.jvm.functions.Function0
            public final Calendar invoke() {
                Calendar calendar = Calendar.getInstance();
                calendar.add(5, 1);
                return calendar;
            }
        });
    }

    @JvmName(name = "getServiceType")
    /* renamed from: getServiceType  reason: from getter */
    public final String getDatabaseTableConfigUtil() {
        return this.DatabaseTableConfigUtil;
    }

    @JvmName(name = "setServiceType")
    public final void setServiceType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.DatabaseTableConfigUtil = str;
    }

    @JvmName(name = "getBillName")
    /* renamed from: getBillName  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "setBillName")
    public final void setBillName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
    }

    @JvmName(name = "getBillDateReminder")
    /* renamed from: getBillDateReminder  reason: from getter */
    public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "setBillDateReminder")
    public final void setBillDateReminder(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @JvmName(name = "getBillMonthReminder")
    /* renamed from: getBillMonthReminder  reason: from getter */
    public final int getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "setBillMonthReminder")
    public final void setBillMonthReminder(int i) {
        this.MyBillsEntityDataFactory = i;
    }

    @JvmName(name = "getBillSelectedGoodsId")
    /* renamed from: getBillSelectedGoodsId  reason: from getter */
    public final String getScheduleImpl() {
        return this.scheduleImpl;
    }

    @JvmName(name = "setBillSelectedGoodsId")
    public final void setBillSelectedGoodsId(String str) {
        this.scheduleImpl = str;
    }

    @JvmName(name = "getBillNewTotalAmount")
    /* renamed from: getBillNewTotalAmount  reason: from getter */
    public final MoneyViewModel getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "setBillNewTotalAmount")
    public final void setBillNewTotalAmount(MoneyViewModel moneyViewModel) {
        this.getAuthRequestContext = moneyViewModel;
    }

    @JvmName(name = "getBillNewDenom")
    /* renamed from: getBillNewDenom  reason: from getter */
    public final String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "setBillNewDenom")
    public final void setBillNewDenom(String str) {
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    @JvmName(name = "getToastCopy")
    public final Function0<Unit> getToastCopy() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    @JvmName(name = "setToastCopy")
    public final void setToastCopy(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = function0;
    }

    @JvmName(name = "getOnProductFieldClicked")
    public final Function0<Unit> getOnProductFieldClicked() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @JvmName(name = "setOnProductFieldClicked")
    public final void setOnProductFieldClicked(Function0<Unit> function0) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = function0;
    }

    @JvmName(name = "getDropdownBillAmount")
    public final CustomDropdownView getDropdownBillAmount() {
        CustomDropdownView customDropdownView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
        return customDropdownView;
    }

    @JvmName(name = "getDropdownBillType")
    public final CustomDropdownView getDropdownBillType() {
        CustomDropdownView customDropdownView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
        return customDropdownView;
    }

    @JvmName(name = "getDropdownProduct")
    public final CustomDropdownView getDropdownProduct() {
        CustomDropdownView customDropdownView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
        return customDropdownView;
    }

    @JvmName(name = "getLlBillDetail")
    public final LinearLayoutCompat getLlBillDetail() {
        LinearLayoutCompat linearLayoutCompat = getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "");
        return linearLayoutCompat;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewSinglePayBodyBinding inflateViewBinding() {
        ViewSinglePayBodyBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewSinglePayBodyBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1044:0x0025, code lost:
    
        if (r0.equals("INTERNET") == false) goto L1490;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1056:0x0077, code lost:
    
        if (r0.equals("ELECTRICITY_POST") == false) goto L1490;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1323:0x0606, code lost:
    
        if (r0.equals("GN_MERCHANT") == false) goto L1490;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1326:0x0610, code lost:
    
        if (r0.equals("EXTERNAL_MERCHANT") != false) goto L1327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1327:0x0612, code lost:
    
        r0 = KClassImpl$Data$declaredNonStaticMembers$2(r19);
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r19.getExtInfo().getGOODS_NAME();
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(id.dana.mybills.R.string.res_0x7f130fa3_access_throwillegalargumenttype), r19.getExtInfo().getGOODS_NAME());
     */
    /* JADX WARN: Code restructure failed: missing block: B:1344:0x06ac, code lost:
    
        if (r0.equals("ELECTRICITY") != false) goto L1345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1345:0x06ae, code lost:
    
        r0 = KClassImpl$Data$declaredNonStaticMembers$2(r19);
        r5 = id.dana.mybills.R.string.mybills_edit_customer_name_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1346:0x06b8, code lost:
    
        if (r6 == null) goto L1348;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1347:0x06ba, code lost:
    
        r6 = r6.getCustomerName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1348:0x06bf, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1349:0x06c0, code lost:
    
        if (r6 != null) goto L1351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1350:0x06c2, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1351:0x06c3, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_edit_customer_id_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1352:0x06d5, code lost:
    
        if (r6 == null) goto L1354;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1353:0x06d7, code lost:
    
        r6 = r6.getBillId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1354:0x06dc, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1355:0x06dd, code lost:
    
        if (r6 != null) goto L1357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1356:0x06df, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1357:0x06e0, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_detail_label_base_amount;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1358:0x06ef, code lost:
    
        if (r6 == null) goto L1362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1359:0x06f1, code lost:
    
        r6 = r6.getBaseAmount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1360:0x06f5, code lost:
    
        if (r6 == null) goto L1362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1361:0x06f7, code lost:
    
        r6 = id.dana.mybills.ui.model.BillPaymentStatusModelKt.toMoneyViewModel(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1362:0x06fc, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1363:0x06fd, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_edit_bill_admin_fee_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1364:0x070c, code lost:
    
        if (r6 == null) goto L1368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1365:0x070e, code lost:
    
        r6 = r6.getAdminFee();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1366:0x0712, code lost:
    
        if (r6 == null) goto L1368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1367:0x0714, code lost:
    
        r6 = id.dana.mybills.ui.model.BillPaymentStatusModelKt.toMoneyViewModel(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1368:0x0719, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1369:0x071a, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_edit_fine_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1370:0x0729, code lost:
    
        if (r6 == null) goto L1374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1371:0x072b, code lost:
    
        r6 = r6.getFineAmount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1372:0x072f, code lost:
    
        if (r6 == null) goto L1374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1373:0x0731, code lost:
    
        r6 = id.dana.mybills.ui.model.BillPaymentStatusModelKt.toMoneyViewModel(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1374:0x0736, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1375:0x0737, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_edit_bill_provider_name_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1376:0x0746, code lost:
    
        if (r6 == null) goto L1378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1377:0x0748, code lost:
    
        r6 = r6.getProviderName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1378:0x074d, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1379:0x074e, code lost:
    
        if (r6 != null) goto L1381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1380:0x0750, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1381:0x0751, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_edit_bill_period_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1382:0x0760, code lost:
    
        if (r6 == null) goto L1384;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1383:0x0762, code lost:
    
        r6 = r6.getPeriod();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1384:0x0767, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1385:0x0768, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), PlaceComponentResult(r6));
        r5 = id.dana.mybills.R.string.mybills_detail_label_energy_total;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1386:0x077b, code lost:
    
        if (r6 == null) goto L1388;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1387:0x077d, code lost:
    
        r6 = r6.getTotalEnergy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1388:0x0782, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1389:0x0783, code lost:
    
        if (r6 != null) goto L1391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1390:0x0785, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1391:0x0786, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_edit_total_bill_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1392:0x0795, code lost:
    
        if (r6 == null) goto L1396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1393:0x0797, code lost:
    
        r6 = r6.getPeriod();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1394:0x079b, code lost:
    
        if (r6 == null) goto L1396;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1395:0x079d, code lost:
    
        r6 = r6.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1396:0x07a2, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1397:0x07a3, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), java.lang.Integer.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:1454:0x08d4, code lost:
    
        if (r0.equals(id.dana.mybills.ui.constant.BizProductCode.DIGITAL_TV) != false) goto L1455;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1455:0x08d6, code lost:
    
        r0 = KClassImpl$Data$declaredNonStaticMembers$2(r19);
        r5 = id.dana.mybills.R.string.mybills_edit_customer_name_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1456:0x08e0, code lost:
    
        if (r6 == null) goto L1458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1457:0x08e2, code lost:
    
        r6 = r6.getCustomerName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1458:0x08e7, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1459:0x08e8, code lost:
    
        if (r6 != null) goto L1461;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1460:0x08ea, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1461:0x08eb, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory.put(java.lang.Integer.valueOf(r5), r6);
        r5 = id.dana.mybills.R.string.mybills_edit_customer_id_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1462:0x08fd, code lost:
    
        if (r6 == null) goto L1464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1463:0x08ff, code lost:
    
        r6 = r6.getBillId();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1464:0x0904, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1465:0x0905, code lost:
    
        if (r6 != null) goto L1467;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1466:0x0907, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1467:0x0908, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory(r5, r6);
        r5 = id.dana.mybills.R.string.mybills_edit_bill_period_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1468:0x0912, code lost:
    
        if (r6 == null) goto L1470;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1469:0x0914, code lost:
    
        r6 = r6.getPeriod();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1470:0x0919, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1471:0x091a, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory(r5, PlaceComponentResult(r6));
        r5 = id.dana.mybills.R.string.mybills_detail_bill_price_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1472:0x0928, code lost:
    
        if (r6 == null) goto L1476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1473:0x092a, code lost:
    
        r6 = r6.getBaseAmount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1474:0x092e, code lost:
    
        if (r6 == null) goto L1476;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1475:0x0930, code lost:
    
        r6 = id.dana.mybills.ui.model.BillPaymentStatusModelKt.toMoneyViewModel(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1476:0x0935, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1477:0x0936, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory(r5, r6);
        r5 = id.dana.mybills.R.string.mybills_edit_bill_admin_fee_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1478:0x0940, code lost:
    
        if (r6 == null) goto L1482;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1479:0x0942, code lost:
    
        r6 = r6.getAdminFee();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1480:0x0946, code lost:
    
        if (r6 == null) goto L1482;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1481:0x0948, code lost:
    
        r6 = id.dana.mybills.ui.model.BillPaymentStatusModelKt.toMoneyViewModel(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1482:0x094d, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1483:0x094e, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory(r5, r6);
        r5 = id.dana.mybills.R.string.mybills_edit_fine_label;
        r6 = r19.getBizProductDestination();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1484:0x0958, code lost:
    
        if (r6 == null) goto L1488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1485:0x095a, code lost:
    
        r6 = r6.getFineAmount();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1486:0x095e, code lost:
    
        if (r6 == null) goto L1488;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1487:0x0960, code lost:
    
        r6 = id.dana.mybills.ui.model.BillPaymentStatusModelKt.toMoneyViewModel(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1488:0x0965, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1489:0x0966, code lost:
    
        r0 = r0.BuiltInFictitiousFunctionClassFactory(r5, r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:1493:0x0980  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.mybills.ui.model.BillPaymentStatusModel show(id.dana.mybills.ui.model.BillPaymentStatusModel r19) {
        /*
            Method dump skipped, instructions count: 2932
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.customview.BodySinglePayView.show(id.dana.mybills.ui.model.BillPaymentStatusModel):id.dana.mybills.ui.model.BillPaymentStatusModel");
    }

    static /* synthetic */ void addViewBillDetail$default(BodySinglePayView bodySinglePayView, LinearLayoutCompat linearLayoutCompat, int i, String str, Integer num, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        BuiltInFictitiousFunctionClassFactory(linearLayoutCompat, i, str, num, function0);
    }

    private static void BuiltInFictitiousFunctionClassFactory(LinearLayoutCompat linearLayoutCompat, int i, String str, Integer num, Function0<Unit> function0) {
        Context context = linearLayoutCompat.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        String string = linearLayoutCompat.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory(linearLayoutCompat, context, string, str, num, function0);
    }

    public final void setListenerStateEditAndCancel(Function0<Unit> onEditButtonClicked, Function0<Unit> onCancelButtonClicked) {
        Intrinsics.checkNotNullParameter(onEditButtonClicked, "");
        Intrinsics.checkNotNullParameter(onCancelButtonClicked, "");
        this.initRecordTimeStamp = onEditButtonClicked;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = onCancelButtonClicked;
    }

    public final void setStatePageDetailUi() {
        this.newProxyInstance = "TYPE_PAGE_DETAIL";
        ViewSinglePayBodyBinding binding = getBinding();
        KClassImpl$Data$declaredNonStaticMembers$2(false);
        isProductFieldEditable$default(this, false, null, 2, null);
        MyBillsEntityDataFactory(false);
        getAuthRequestContext(false);
        DanaButtonSecondaryView danaButtonSecondaryView = binding.scheduleImpl.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(8);
        DanaButtonPrimaryView danaButtonPrimaryView = binding.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(0);
        MyBillsEntityDataFactory();
        PlaceComponentResult(false);
    }

    public static /* synthetic */ void setStatePageEditUi$default(BodySinglePayView bodySinglePayView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        bodySinglePayView.setStatePageEditUi(str);
    }

    public final void setStatePageEditUi(String source) {
        this.newProxyInstance = "TYPE_PAGE_EDIT";
        ViewSinglePayBodyBinding binding = getBinding();
        KClassImpl$Data$declaredNonStaticMembers$2(true);
        BuiltInFictitiousFunctionClassFactory(true, source);
        MyBillsEntityDataFactory(true);
        DanaButtonSecondaryView danaButtonSecondaryView = binding.scheduleImpl.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(0);
        DanaButtonPrimaryView danaButtonPrimaryView = binding.scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(8);
        MyBillsEntityDataFactory();
        if (BuiltInFictitiousFunctionClassFactory()) {
            PlaceComponentResult(false);
            getAuthRequestContext(false);
            return;
        }
        PlaceComponentResult(true);
        getAuthRequestContext(true);
    }

    private final void MyBillsEntityDataFactory() {
        CustomDropdownView customDropdownView = getBinding().PlaceComponentResult;
        String string = customDropdownView.getContext().getString(R.string.mybills_edit_bill_type_label);
        Intrinsics.checkNotNullExpressionValue(string, "");
        customDropdownView.setTitle(string);
        String string2 = customDropdownView.getContext().getString(R.string.res_0x7f130f47_verifypinstatemanager_executeriskchallenge_2_2);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        customDropdownView.setHintDropdown(string2);
        AddNewBillsUtils addNewBillsUtils = AddNewBillsUtils.INSTANCE;
        Context context = customDropdownView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        customDropdownView.setOptions(AddNewBillsUtils.MyBillsEntityDataFactory(context));
        BillDetailView.Builder builder = this.getErrorConfigVersion;
        if (Intrinsics.areEqual(builder != null ? builder.lookAheadTest : null, RecurringType.AUTO_DEDUCTION)) {
            AddNewBillsUtils addNewBillsUtils2 = AddNewBillsUtils.INSTANCE;
            Context context2 = customDropdownView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            DropdownOptionsModel dropdownOptionsModel = (DropdownOptionsModel) CollectionsKt.getOrNull(AddNewBillsUtils.MyBillsEntityDataFactory(context2), 1);
            if (dropdownOptionsModel != null) {
                customDropdownView.setSelected(dropdownOptionsModel);
                this.DatabaseTableConfigUtil = String.valueOf(dropdownOptionsModel.getId());
            }
        } else {
            AddNewBillsUtils addNewBillsUtils3 = AddNewBillsUtils.INSTANCE;
            Context context3 = customDropdownView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "");
            DropdownOptionsModel dropdownOptionsModel2 = (DropdownOptionsModel) CollectionsKt.firstOrNull((List) AddNewBillsUtils.MyBillsEntityDataFactory(context3));
            if (dropdownOptionsModel2 != null) {
                customDropdownView.setSelected(dropdownOptionsModel2);
                this.DatabaseTableConfigUtil = String.valueOf(dropdownOptionsModel2.getId());
            }
        }
        customDropdownView.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$setServiceType$1$3
            @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
            public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BodySinglePayView.this.setServiceType(String.valueOf(p0.getId()));
            }
        });
    }

    private final void PlaceComponentResult(boolean z) {
        if (z) {
            final CustomDropdownView customDropdownView = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
            CustomDropdownView.isDropDownViewActivated$default(customDropdownView, true, false, 2, null);
            customDropdownView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BodySinglePayView.$r8$lambda$7A24qWLP3TU6gynPSjZnjUpRcj0(BodySinglePayView.this, customDropdownView, view);
                }
            });
            return;
        }
        CustomDropdownView customDropdownView2 = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(customDropdownView2, "");
        CustomDropdownView.isDropDownViewActivated$default(customDropdownView2, false, false, 2, null);
    }

    static /* synthetic */ void isProductFieldEditable$default(BodySinglePayView bodySinglePayView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        bodySinglePayView.BuiltInFictitiousFunctionClassFactory(z, str);
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean z, final String str) {
        if (z) {
            final CustomDropdownView customDropdownView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
            CustomDropdownView.isDropDownViewActivated$default(customDropdownView, true, false, 2, null);
            customDropdownView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BodySinglePayView.$r8$lambda$ME1Mu8pgrZgusskrQs2y4UKvGSU(BodySinglePayView.this, str, customDropdownView, view);
                }
            });
            return;
        }
        CustomDropdownView customDropdownView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(customDropdownView2, "");
        CustomDropdownView.isDropDownViewActivated$default(customDropdownView2, false, false, 2, null);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (z) {
            CustomDropdownView customDropdownView = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
            CustomDropdownView.isDropDownViewActivated$default(customDropdownView, false, false, 2, null);
            return;
        }
        CustomDropdownView customDropdownView2 = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(customDropdownView2, "");
        CustomDropdownView.isDropDownViewActivated$default(customDropdownView2, false, false, 2, null);
        customDropdownView2.showOptions(false);
    }

    private final void MyBillsEntityDataFactory(boolean z) {
        if (z) {
            CustomEditTextView customEditTextView = getBinding().BuiltInFictitiousFunctionClassFactory;
            customEditTextView.setEnabled();
            customEditTextView.isEditTextActivated(true);
            return;
        }
        CustomEditTextView customEditTextView2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        customEditTextView2.setDisabled();
        customEditTextView2.isEditTextActivated(false);
    }

    private final void getAuthRequestContext(boolean z) {
        if (z) {
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.isEditTextActivated(true);
        } else {
            getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.isEditTextActivated(false);
        }
    }

    public final void mapProducts(List<DropdownOptionsModel> products) {
        Object obj;
        Intrinsics.checkNotNullParameter(products, "");
        CustomDropdownView customDropdownView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        customDropdownView.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$mapProducts$1$1
            @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
            public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BodySinglePayView.this.setBillSelectedGoodsId(p0.getId());
                BodySinglePayView.this.setBillNewTotalAmount(p0.getPrice());
                BodySinglePayView bodySinglePayView = BodySinglePayView.this;
                String value = p0.getValue();
                bodySinglePayView.setBillNewDenom(value != null ? StringsKt.replace$default(value, "Rp", "", false, 4, (Object) null) : null);
            }
        });
        Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
        customDropdownView.setVisibility(0);
        customDropdownView.setOptions(products);
        String string = customDropdownView.getContext().getString(R.string.mybills_edit_product_label);
        Intrinsics.checkNotNullExpressionValue(string, "");
        customDropdownView.setTitle(string);
        Iterator<T> it = products.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String id2 = ((DropdownOptionsModel) next).getId();
            BillDetailView.Builder builder = this.getErrorConfigVersion;
            if (Intrinsics.areEqual(id2, builder != null ? builder.moveToNextValue : null)) {
                obj = next;
                break;
            }
        }
        DropdownOptionsModel dropdownOptionsModel = (DropdownOptionsModel) obj;
        if (dropdownOptionsModel != null) {
            customDropdownView.setSelected(dropdownOptionsModel);
        }
    }

    public final ViewHeaderDetailBillsBinding getHeader() {
        ViewHeaderDetailBillsBinding viewHeaderDetailBillsBinding = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(viewHeaderDetailBillsBinding, "");
        return viewHeaderDetailBillsBinding;
    }

    public static /* synthetic */ void isEditEnabled$default(BodySinglePayView bodySinglePayView, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        bodySinglePayView.isEditEnabled(z, str, z2);
    }

    public final void isEditEnabled(boolean enabled, final String source, boolean canEditTheProduct) {
        getBinding().scheduleImpl.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BodySinglePayView.$r8$lambda$klRDcFACNc4Gu2i6Xn_oQEgxYYw(BodySinglePayView.this, view);
            }
        });
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().scheduleImpl.BuiltInFictitiousFunctionClassFactory;
        if (enabled) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BodySinglePayView.$r8$lambda$Dm28_MUC5oFsZnliWZOuKgAbdOc(BodySinglePayView.this, source, view);
                }
            });
            danaButtonPrimaryView.setActiveButton(danaButtonPrimaryView.getContext().getString(R.string.edit_item_manage_bills), null);
        } else {
            danaButtonPrimaryView.setDisabled(danaButtonPrimaryView.getContext().getString(R.string.edit_item_manage_bills));
        }
        CustomDropdownView.isDropDownViewActivated$default(getDropdownProduct(), canEditTheProduct, false, 2, null);
    }

    private final BillDetailView.Builder KClassImpl$Data$declaredNonStaticMembers$2(final BillPaymentStatusModel billPaymentStatusModel) {
        BillDetailView.Builder builder = new BillDetailView.Builder(null, null, null, null, null, null, null, null, null, null, 1023, null);
        builder.getErrorConfigVersion = billPaymentStatusModel.getIconUrl();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = billPaymentStatusModel.getGoodsType();
        builder.moveToNextValue = billPaymentStatusModel.getGoodsId();
        BillDetailUtil billDetailUtil = BillDetailUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = BillDetailUtil.getAuthRequestContext(context, billPaymentStatusModel);
        builder.PlaceComponentResult = billPaymentStatusModel.getBillId();
        builder.MyBillsEntityDataFactory = billPaymentStatusModel.getTotalAmount();
        builder.scheduleImpl = billPaymentStatusModel.getSubscriptionTitle();
        builder.lookAheadTest = billPaymentStatusModel.getRecurringType();
        builder.getAuthRequestContext = billPaymentStatusModel.getGmtDueDate();
        int i = R.string.mybills_detail_label_subscription_id;
        String subscriptionId = billPaymentStatusModel.getSubscriptionId();
        if (subscriptionId == null) {
            subscriptionId = "";
        }
        builder.BuiltInFictitiousFunctionClassFactory.put(Integer.valueOf(i), new BillDetailView.Copyable(subscriptionId, R.drawable.initRecordTimeStamp, new Function0<Unit>() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$setDefaultBillDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BodySinglePayView bodySinglePayView = BodySinglePayView.this;
                String subscriptionId2 = billPaymentStatusModel.getSubscriptionId();
                if (subscriptionId2 == null) {
                    subscriptionId2 = "";
                }
                BodySinglePayView.access$copyToClipboard(bodySinglePayView, subscriptionId2);
                BodySinglePayView.this.getToastCopy().invoke();
            }
        }));
        int i2 = R.string.res_0x7f130fa3_access_throwillegalargumenttype;
        BillDetailUtil billDetailUtil2 = BillDetailUtil.INSTANCE;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        builder.BuiltInFictitiousFunctionClassFactory.put(Integer.valueOf(i2), BillDetailUtil.getAuthRequestContext(context2, billPaymentStatusModel));
        int i3 = R.string.mybills_detail_label_next_payment_date;
        DateTimeUtil dateTimeUtil = DateTimeUtil.INSTANCE;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        Long gmtDueDate = billPaymentStatusModel.getGmtDueDate();
        builder.BuiltInFictitiousFunctionClassFactory.put(Integer.valueOf(i3), dateTimeUtil.getDateTimeString(DATE_FORMAT_DD_MMMM_YYYY, locale, gmtDueDate != null ? gmtDueDate.longValue() : 0L));
        int i4 = R.string.mybills_detail_label_payment_method;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "");
        builder.BuiltInFictitiousFunctionClassFactory.put(Integer.valueOf(i4), BillPaymentStatusModelKt.getPaymentMethodString(billPaymentStatusModel, context3));
        return builder;
    }

    private static String PlaceComponentResult(List<Long> list) {
        if (list != null) {
            try {
                return CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new Function1<Long, CharSequence>() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$getFormatPeriod$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ CharSequence invoke(Long l) {
                        return invoke(l.longValue());
                    }

                    public final CharSequence invoke(long j) {
                        DateTimeUtil dateTimeUtil = DateTimeUtil.INSTANCE;
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "");
                        return dateTimeUtil.getDateTimeString(BodySinglePayView.DATE_FORMAT_MMMyy, locale, j);
                    }
                }, 30, null);
            } catch (NullPointerException unused) {
                return "";
            }
        }
        return null;
    }

    public static void MyBillsEntityDataFactory(LinearLayoutCompat linearLayoutCompat, Context context, String str, String str2, Integer num, Function0<Unit> function0) {
        CustomBillDetailTextView customBillDetailTextView = new CustomBillDetailTextView(context, null, 0, 6, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        customBillDetailTextView.setLayoutParams(layoutParams);
        customBillDetailTextView.setCustomBillDetail(str, str2);
        if (!(str2.length() > 0) || num == null) {
            num = null;
        }
        customBillDetailTextView.setDescIcon(num);
        if (function0 != null) {
            customBillDetailTextView.setOnClickDescIcon(function0);
        }
        linearLayoutCompat.addView(customBillDetailTextView);
    }

    public final void setDatePickerRangeListener(Function1<? super IntRange, Unit> onSeletedDateNotInRange) {
        Intrinsics.checkNotNullParameter(onSeletedDateNotInRange, "");
        this.GetContactSyncConfig = onSeletedDateNotInRange;
    }

    public final void setDatePickerRange(IntRange rangeDate) {
        this.lookAheadTest = rangeDate;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        BillDetailView.Builder builder = this.getErrorConfigVersion;
        if (!Intrinsics.areEqual(builder != null ? builder.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, "GN_MERCHANT")) {
            BillDetailView.Builder builder2 = this.getErrorConfigVersion;
            if (!Intrinsics.areEqual(builder2 != null ? builder2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, "EXTERNAL_MERCHANT")) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ void $r8$lambda$7A24qWLP3TU6gynPSjZnjUpRcj0(BodySinglePayView bodySinglePayView, CustomDropdownView customDropdownView, View view) {
        Intrinsics.checkNotNullParameter(bodySinglePayView, "");
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        if (Intrinsics.areEqual(bodySinglePayView.newProxyInstance, "TYPE_PAGE_EDIT")) {
            customDropdownView.showOptions(!customDropdownView.isOptionsVisible());
        }
    }

    public static /* synthetic */ void $r8$lambda$Dm28_MUC5oFsZnliWZOuKgAbdOc(BodySinglePayView bodySinglePayView, String str, View view) {
        Intrinsics.checkNotNullParameter(bodySinglePayView, "");
        bodySinglePayView.setStatePageEditUi(str);
        Function0<Unit> function0 = bodySinglePayView.initRecordTimeStamp;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            function0 = null;
        }
        function0.invoke();
    }

    /* renamed from: $r8$lambda$FYAE2AogoNWJM_q-2zsmsuW-elI */
    public static /* synthetic */ void m2677$r8$lambda$FYAE2AogoNWJM_q2zsmsuWelI(IntRange intRange, BodySinglePayView bodySinglePayView, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(intRange, "");
        Intrinsics.checkNotNullParameter(bodySinglePayView, "");
        if (intRange.contains(i3)) {
            ((Calendar) bodySinglePayView.moveToNextValue.getValue()).set(1, i);
            ((Calendar) bodySinglePayView.moveToNextValue.getValue()).set(2, i2);
            ((Calendar) bodySinglePayView.moveToNextValue.getValue()).set(5, i3);
            bodySinglePayView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(String.valueOf(i3));
            bodySinglePayView.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
            bodySinglePayView.MyBillsEntityDataFactory = i2;
            return;
        }
        bodySinglePayView.GetContactSyncConfig.invoke(intRange);
    }

    public static /* synthetic */ void $r8$lambda$ME1Mu8pgrZgusskrQs2y4UKvGSU(BodySinglePayView bodySinglePayView, String str, CustomDropdownView customDropdownView, View view) {
        Intrinsics.checkNotNullParameter(bodySinglePayView, "");
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        if (Intrinsics.areEqual(bodySinglePayView.newProxyInstance, "TYPE_PAGE_EDIT") && !Intrinsics.areEqual(str, "GAME_VOUCHER")) {
            customDropdownView.showOptions(!customDropdownView.isOptionsVisible());
            return;
        }
        Function0<Unit> function0 = bodySinglePayView.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void $r8$lambda$klRDcFACNc4Gu2i6Xn_oQEgxYYw(BodySinglePayView bodySinglePayView, View view) {
        Intrinsics.checkNotNullParameter(bodySinglePayView, "");
        Function0<Unit> function0 = bodySinglePayView.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            function0 = null;
        }
        function0.invoke();
    }

    public static final /* synthetic */ void access$copyToClipboard(BodySinglePayView bodySinglePayView, String str) {
        TextUtil textUtil = TextUtil.INSTANCE;
        Context context = bodySinglePayView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        TextUtil.getAuthRequestContext(context, COPY_LABEL, str);
    }

    public static final /* synthetic */ void access$showCalendar(final BodySinglePayView bodySinglePayView) {
        final IntRange intRange = bodySinglePayView.lookAheadTest;
        if (intRange != null) {
            DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: id.dana.mybills.ui.customview.BodySinglePayView$$ExternalSyntheticLambda0
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    BodySinglePayView.m2677$r8$lambda$FYAE2AogoNWJM_q2zsmsuWelI(IntRange.this, bodySinglePayView, datePicker, i, i2, i3);
                }
            };
            MyBillsCalendarUtil myBillsCalendarUtil = MyBillsCalendarUtil.INSTANCE;
            Calendar BuiltInFictitiousFunctionClassFactory = MyBillsCalendarUtil.BuiltInFictitiousFunctionClassFactory(intRange);
            MyBillsCalendarUtil myBillsCalendarUtil2 = MyBillsCalendarUtil.INSTANCE;
            Calendar MyBillsEntityDataFactory = MyBillsCalendarUtil.MyBillsEntityDataFactory(intRange);
            DatePickerDialog datePickerDialog = new DatePickerDialog(bodySinglePayView.getContext(), R.style.getErrorConfigVersion, onDateSetListener, ((Calendar) bodySinglePayView.moveToNextValue.getValue()).get(1), ((Calendar) bodySinglePayView.moveToNextValue.getValue()).get(2), ((Calendar) bodySinglePayView.moveToNextValue.getValue()).get(5));
            datePickerDialog.getDatePicker().setMinDate(BuiltInFictitiousFunctionClassFactory.getTimeInMillis());
            datePickerDialog.getDatePicker().setMaxDate(MyBillsEntityDataFactory.getTimeInMillis());
            datePickerDialog.show();
        }
    }
}
