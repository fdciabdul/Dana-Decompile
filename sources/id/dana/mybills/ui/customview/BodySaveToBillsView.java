package id.dana.mybills.ui.customview;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewAddToMyBillsBinding;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import id.dana.mybills.utils.AddNewBillsUtils;
import id.dana.mybills.utils.MyBillsCalendarUtil;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002@AB/\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010<\u001a\u00020;\u0012\b\b\u0002\u0010=\u001a\u00020;¢\u0006\u0004\b>\u0010?J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u0005J\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00122\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b \u0010\u0014J(\u0010$\u001a\u00020\u00122\u0019\u0010#\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010!¢\u0006\u0002\b\"\u0012\u0004\u0012\u00020\u00120\u0019¢\u0006\u0004\b$\u0010\u001cJ\u0015\u0010'\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0010¢\u0006\u0004\b*\u0010\u0014J\u0015\u0010,\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0010¢\u0006\u0004\b,\u0010\u0014R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00104R\u0018\u0010\u0013\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/mybills/ui/customview/BodySaveToBillsView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewAddToMyBillsBinding;", "", "getBillsName", "()Ljava/lang/String;", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "Lid/dana/mybills/ui/customview/CustomDropdownView;", "getDropDownPaymentType", "()Lid/dana/mybills/ui/customview/CustomDropdownView;", "getSelectedDate", "getSelectedPaymentType", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewAddToMyBillsBinding;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Lkotlin/ranges/IntRange;", "rangeDate", "setDatePickerRange", "(Lkotlin/ranges/IntRange;)V", "Lkotlin/Function1;", "onSeletedDateNotInRange", "setDatePickerRangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setDefaultValue", "()V", "enabled", "setIsSaveToMyBillsActive", "Landroid/view/View;", "Lkotlin/ParameterName;", "onClick", "setOnIconInfoClick", "Lid/dana/mybills/ui/customview/BodySaveToBillsView$OnToggleAddToMyBillsChecked;", "onToggleAddToMyBillsChecked", "setOnToggleCheckedChanged", "(Lid/dana/mybills/ui/customview/BodySaveToBillsView$OnToggleAddToMyBillsChecked;)V", CustomDialogKey.Response.IS_CHECKED, "setSwitchAddToMyBillsChecked", "isVisible", "setToggleSaveToMyBillsVisible", "PlaceComponentResult", "Ljava/util/Calendar;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lkotlin/ranges/IntRange;", "getAuthRequestContext", "Z", "Lkotlin/jvm/functions/Function1;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/mybills/ui/customview/BodySaveToBillsView$OnToggleAddToMyBillsChecked;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnToggleAddToMyBillsChecked"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BodySaveToBillsView extends BaseViewBindingRichView<ViewAddToMyBillsBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super IntRange, Unit> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private IntRange getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private OnToggleAddToMyBillsChecked BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Calendar KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final IntRange BuiltInFictitiousFunctionClassFactory = new IntRange(1, 30);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/ui/customview/BodySaveToBillsView$OnToggleAddToMyBillsChecked;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnToggleAddToMyBillsChecked {
        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BodySaveToBillsView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BodySaveToBillsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BodySaveToBillsView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ BodySaveToBillsView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodySaveToBillsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = new Function1<IntRange, Unit>() { // from class: id.dana.mybills.ui.customview.BodySaveToBillsView$onSeletedDateNotInRange$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(IntRange intRange) {
                Intrinsics.checkNotNullParameter(intRange, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(IntRange intRange) {
                invoke2(intRange);
                return Unit.INSTANCE;
            }
        };
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        Intrinsics.checkNotNullExpressionValue(calendar, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = calendar;
        ViewAddToMyBillsBinding binding = getBinding();
        CustomEditTextView customEditTextView = binding.BuiltInFictitiousFunctionClassFactory;
        String string = customEditTextView.getContext().getResources().getString(R.string.my_bills_label_bill_date);
        Intrinsics.checkNotNullExpressionValue(string, "");
        customEditTextView.setLabelText(string);
        customEditTextView.setRightImage(R.drawable.ic_calendar_grey);
        customEditTextView.setOnEditTextClickListener(new Function0<Unit>() { // from class: id.dana.mybills.ui.customview.BodySaveToBillsView$initViews$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                BodySaveToBillsView.access$showCalendar(BodySaveToBillsView.this);
            }
        });
        customEditTextView.setDisabled();
        CustomEditTextView customEditTextView2 = binding.getAuthRequestContext;
        String string2 = customEditTextView2.getResources().getString(R.string.my_bills_label_bill_name);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        customEditTextView2.setLabelText(string2);
        String string3 = customEditTextView2.getResources().getString(R.string.res_0x7f130f31_networkuserentitydata_externalsyntheticlambda3);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        customEditTextView2.setHint(string3);
        final CustomDropdownView customDropdownView = binding.MyBillsEntityDataFactory;
        String string4 = binding.scheduleImpl.getContext().getString(R.string.my_bills_label_payment_type);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        customDropdownView.setTitle(string4);
        AddNewBillsUtils addNewBillsUtils = AddNewBillsUtils.INSTANCE;
        Context context2 = customDropdownView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        customDropdownView.setOptions(AddNewBillsUtils.MyBillsEntityDataFactory(context2));
        customDropdownView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.BodySaveToBillsView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BodySaveToBillsView.$r8$lambda$MER5rgOXvs30GsK8XnCEN8KlSq0(CustomDropdownView.this, view);
            }
        });
        customDropdownView.setListenerItemSelected(new CustomDropdownView.OnItemSelectedListener() { // from class: id.dana.mybills.ui.customview.BodySaveToBillsView$initViews$1$3$2
            @Override // id.dana.mybills.ui.customview.CustomDropdownView.OnItemSelectedListener
            public final void BuiltInFictitiousFunctionClassFactory(DropdownOptionsModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (Intrinsics.areEqual(p0.getId(), RecurringType.REMINDER)) {
                    CustomDropdownView customDropdownView2 = CustomDropdownView.this;
                    String string5 = customDropdownView2.getContext().getString(R.string.my_bills_label_payment_type_manual);
                    Intrinsics.checkNotNullExpressionValue(string5, "");
                    customDropdownView2.setLabelInformation(string5);
                    return;
                }
                CustomDropdownView customDropdownView3 = CustomDropdownView.this;
                String string6 = customDropdownView3.getContext().getString(R.string.my_bills_label_payment_type_automatic);
                Intrinsics.checkNotNullExpressionValue(string6, "");
                customDropdownView3.setLabelInformation(string6);
            }
        });
        binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.mybills.ui.customview.BodySaveToBillsView$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                BodySaveToBillsView.$r8$lambda$Lz32nDSrSzBwURNodcGROqaJVY0(BodySaveToBillsView.this, compoundButton, z);
            }
        });
        setDefaultValue();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewAddToMyBillsBinding inflateViewBinding() {
        ViewAddToMyBillsBinding PlaceComponentResult = ViewAddToMyBillsBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final CustomDropdownView getDropDownPaymentType() {
        CustomDropdownView customDropdownView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
        return customDropdownView;
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        ViewAddToMyBillsBinding binding = getBinding();
        CustomEditTextView customEditTextView = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(customEditTextView, "");
        customEditTextView.setVisibility(p0 ? 0 : 8);
        CustomEditTextView customEditTextView2 = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(customEditTextView2, "");
        customEditTextView2.setVisibility(p0 ? 0 : 8);
        CustomDropdownView customDropdownView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(customDropdownView, "");
        customDropdownView.setVisibility(p0 ? 0 : 8);
        OnToggleAddToMyBillsChecked onToggleAddToMyBillsChecked = this.BuiltInFictitiousFunctionClassFactory;
        if (onToggleAddToMyBillsChecked != null) {
            onToggleAddToMyBillsChecked.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        }
    }

    public final String getBillsName() {
        return getBinding().getAuthRequestContext.getText();
    }

    public final String getSelectedDate() {
        return getBinding().BuiltInFictitiousFunctionClassFactory.getText();
    }

    /* renamed from: getCalendar  reason: from getter */
    public final Calendar getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String getSelectedPaymentType() {
        return String.valueOf(getBinding().MyBillsEntityDataFactory.getNetworkUserEntityData$$ExternalSyntheticLambda0().getId());
    }

    public final void setOnToggleCheckedChanged(OnToggleAddToMyBillsChecked onToggleAddToMyBillsChecked) {
        Intrinsics.checkNotNullParameter(onToggleAddToMyBillsChecked, "");
        this.BuiltInFictitiousFunctionClassFactory = onToggleAddToMyBillsChecked;
    }

    public final void setDatePickerRangeListener(Function1<? super IntRange, Unit> onSeletedDateNotInRange) {
        Intrinsics.checkNotNullParameter(onSeletedDateNotInRange, "");
        this.PlaceComponentResult = onSeletedDateNotInRange;
    }

    public final void setDatePickerRange(IntRange rangeDate) {
        this.getAuthRequestContext = rangeDate;
        if (rangeDate != null) {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2.get(5);
            if (rangeDate.contains(i) || this.MyBillsEntityDataFactory) {
                return;
            }
            this.MyBillsEntityDataFactory = true;
            MyBillsCalendarUtil myBillsCalendarUtil = MyBillsCalendarUtil.INSTANCE;
            if (i > MyBillsCalendarUtil.MyBillsEntityDataFactory(rangeDate).get(5) && this.KClassImpl$Data$declaredNonStaticMembers$2.get(2) == 11) {
                Calendar calendar = this.KClassImpl$Data$declaredNonStaticMembers$2;
                calendar.set(1, calendar.get(1) + 1);
            }
            MyBillsCalendarUtil myBillsCalendarUtil2 = MyBillsCalendarUtil.INSTANCE;
            this.KClassImpl$Data$declaredNonStaticMembers$2.set(5, MyBillsCalendarUtil.BuiltInFictitiousFunctionClassFactory(rangeDate).get(5));
            getBinding().BuiltInFictitiousFunctionClassFactory.setText(String.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.get(5)));
        }
    }

    public final void setDefaultValue() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, 1);
        Intrinsics.checkNotNullExpressionValue(calendar, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = calendar;
        getBinding().BuiltInFictitiousFunctionClassFactory.setText(String.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2.get(5)));
        CustomDropdownView customDropdownView = getBinding().MyBillsEntityDataFactory;
        AddNewBillsUtils addNewBillsUtils = AddNewBillsUtils.INSTANCE;
        Context context = customDropdownView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        customDropdownView.setSelected((DropdownOptionsModel) CollectionsKt.first((List) AddNewBillsUtils.MyBillsEntityDataFactory(context)));
        String string = customDropdownView.getContext().getString(R.string.my_bills_label_payment_type_manual);
        Intrinsics.checkNotNullExpressionValue(string, "");
        customDropdownView.setLabelInformation(string);
    }

    public final void setIsSaveToMyBillsActive(boolean enabled) {
        ViewAddToMyBillsBinding binding = getBinding();
        if (!enabled) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(binding.moveToNextValue, R.style.KClassImpl$Data$declaredNonStaticMembers$2);
            binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setChecked(false);
            binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setEnabled(false);
            return;
        }
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(binding.moveToNextValue, R.style.getAuthRequestContext);
        binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setEnabled(true);
    }

    public final void setSwitchAddToMyBillsChecked(boolean isChecked) {
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setChecked(isChecked);
        BuiltInFictitiousFunctionClassFactory(isChecked);
    }

    public final void setToggleSaveToMyBillsVisible(boolean isVisible) {
        ConstraintLayout constraintLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(isVisible ? 0 : 8);
    }

    public final void setOnIconInfoClick(final Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "");
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.BodySaveToBillsView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BodySaveToBillsView.$r8$lambda$8cvW4uqYqv4XYcxsmuOiMFbpARM(Function1.this, view);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/ui/customview/BodySaveToBillsView$Companion;", "", "Lkotlin/ranges/IntRange;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/ranges/IntRange;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlin/ranges/IntRange;", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$8cvW4uqYqv4XYcxsmuOiMFbpARM(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullExpressionValue(view, "");
        function1.invoke(view);
    }

    public static /* synthetic */ void $r8$lambda$Lz32nDSrSzBwURNodcGROqaJVY0(BodySaveToBillsView bodySaveToBillsView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(bodySaveToBillsView, "");
        bodySaveToBillsView.BuiltInFictitiousFunctionClassFactory(z);
    }

    public static /* synthetic */ void $r8$lambda$MER5rgOXvs30GsK8XnCEN8KlSq0(CustomDropdownView customDropdownView, View view) {
        Intrinsics.checkNotNullParameter(customDropdownView, "");
        customDropdownView.showOptions(!customDropdownView.isOptionsVisible());
    }

    public static /* synthetic */ void $r8$lambda$veNUPGx5PPGR6JjsUadEfGlbS64(IntRange intRange, BodySaveToBillsView bodySaveToBillsView, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(intRange, "");
        Intrinsics.checkNotNullParameter(bodySaveToBillsView, "");
        if (intRange.contains(i3)) {
            bodySaveToBillsView.KClassImpl$Data$declaredNonStaticMembers$2.set(1, i);
            bodySaveToBillsView.KClassImpl$Data$declaredNonStaticMembers$2.set(2, i2);
            bodySaveToBillsView.KClassImpl$Data$declaredNonStaticMembers$2.set(5, i3);
            bodySaveToBillsView.getBinding().BuiltInFictitiousFunctionClassFactory.setText(String.valueOf(i3));
            return;
        }
        bodySaveToBillsView.PlaceComponentResult.invoke(intRange);
    }

    public static final /* synthetic */ void access$showCalendar(final BodySaveToBillsView bodySaveToBillsView) {
        final IntRange intRange = bodySaveToBillsView.getAuthRequestContext;
        if (intRange != null) {
            DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: id.dana.mybills.ui.customview.BodySaveToBillsView$$ExternalSyntheticLambda3
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    BodySaveToBillsView.$r8$lambda$veNUPGx5PPGR6JjsUadEfGlbS64(IntRange.this, bodySaveToBillsView, datePicker, i, i2, i3);
                }
            };
            MyBillsCalendarUtil myBillsCalendarUtil = MyBillsCalendarUtil.INSTANCE;
            Calendar BuiltInFictitiousFunctionClassFactory2 = MyBillsCalendarUtil.BuiltInFictitiousFunctionClassFactory(intRange);
            MyBillsCalendarUtil myBillsCalendarUtil2 = MyBillsCalendarUtil.INSTANCE;
            Calendar MyBillsEntityDataFactory = MyBillsCalendarUtil.MyBillsEntityDataFactory(intRange);
            DatePickerDialog datePickerDialog = new DatePickerDialog(bodySaveToBillsView.getContext(), R.style.getErrorConfigVersion, onDateSetListener, bodySaveToBillsView.KClassImpl$Data$declaredNonStaticMembers$2.get(1), bodySaveToBillsView.KClassImpl$Data$declaredNonStaticMembers$2.get(2), bodySaveToBillsView.KClassImpl$Data$declaredNonStaticMembers$2.get(5));
            datePickerDialog.getDatePicker().setMinDate(BuiltInFictitiousFunctionClassFactory2.getTimeInMillis());
            datePickerDialog.getDatePicker().setMaxDate(MyBillsEntityDataFactory.getTimeInMillis());
            datePickerDialog.show();
        }
    }
}
