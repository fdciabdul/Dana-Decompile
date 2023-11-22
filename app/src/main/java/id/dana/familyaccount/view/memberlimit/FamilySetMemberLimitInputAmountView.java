package id.dana.familyaccount.view.memberlimit;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewSetMemberLimitInputAmountBinding;
import id.dana.extension.view.InputExtKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocaleUtil;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B/\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010'\u001a\u00020%¢\u0006\u0004\b(\u0010)J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0012\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitInputAmountView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewSetMemberLimitInputAmountBinding;", "", "clear", "()V", "inflateViewBinding", "()Lid/dana/databinding/ViewSetMemberLimitInputAmountBinding;", "", "amount", "setEditTextAmount", "(J)V", "Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitInputAmountView$OnAmountChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitInputAmountView$OnAmountChangeListener;)V", "setMaxAmount", "setup", "PlaceComponentResult", "Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitInputAmountView$OnAmountChangeListener;", "getAuthRequestContext", "", "Z", "MyBillsEntityDataFactory", "Lid/dana/core/ui/richview/CurrencyEditText;", "p0", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/richview/CurrencyEditText;", "getEtAmount", "()Lid/dana/core/ui/richview/CurrencyEditText;", "etAmount", "KClassImpl$Data$declaredNonStaticMembers$2", "J", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnAmountChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilySetMemberLimitInputAmountView extends BaseViewBindingRichView<ViewSetMemberLimitInputAmountBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private CurrencyEditText etAmount;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private long PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private OnAmountChangeListener getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/view/memberlimit/FamilySetMemberLimitInputAmountView$OnAmountChangeListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(J)V", "", "PlaceComponentResult", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnAmountChangeListener {
        void BuiltInFictitiousFunctionClassFactory(long p0);

        void PlaceComponentResult(boolean p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitInputAmountView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitInputAmountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitInputAmountView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FamilySetMemberLimitInputAmountView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = 2000000L;
    }

    public /* synthetic */ FamilySetMemberLimitInputAmountView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getEtAmount")
    public final CurrencyEditText getEtAmount() {
        return this.etAmount;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewSetMemberLimitInputAmountBinding inflateViewBinding() {
        ViewSetMemberLimitInputAmountBinding PlaceComponentResult = ViewSetMemberLimitInputAmountBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        this.etAmount = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        KeyboardHelper.PlaceComponentResult(getRootView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                FamilySetMemberLimitInputAmountView.access$setFieldState(FamilySetMemberLimitInputAmountView.this, R.color.getErrorConfigVersion_res_0x7f060305);
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                FamilySetMemberLimitInputAmountView.access$setFieldState(FamilySetMemberLimitInputAmountView.this, R.color.f23962131099992);
            }
        });
        final CurrencyEditText currencyEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        currencyEditText.setUsePrefix(false);
        currencyEditText.setListener(new CurrencyEditText.Listener() { // from class: id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView$setupViews$1$1
            @Override // id.dana.core.ui.richview.CurrencyEditText.Listener
            public final void PlaceComponentResult() {
                CurrencyEditText.this.clearFocus();
            }
        });
        currencyEditText.setTextHint("0");
        currencyEditText.setTextHintColor(R.color.f25492131100161);
        currencyEditText.setAllowEmpty(true);
        final CurrencyEditText currencyEditText2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        currencyEditText2.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean authRequestContext;
                authRequestContext = FamilySetMemberLimitInputAmountView.getAuthRequestContext(CurrencyEditText.this, motionEvent);
                return authRequestContext;
            }
        });
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        final CurrencyEditText currencyEditText3 = currencyEditText;
        if (ViewCompat.C(currencyEditText3)) {
            LifecycleOwner PlaceComponentResult = C0207ViewKt.PlaceComponentResult(currencyEditText3);
            if (PlaceComponentResult != null) {
                FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1(this, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult));
            }
        } else {
            currencyEditText3.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView$setupViews$lambda-2$$inlined$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    currencyEditText3.removeOnAttachStateChangeListener(this);
                    Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                    LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(currencyEditText);
                    if (PlaceComponentResult2 != null) {
                        FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new FamilySetMemberLimitInputAmountView$setupViews$1$2$1$1(this, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2));
                    }
                }
            });
        }
        getBinding().getAuthRequestContext.setText("Rp");
    }

    public final void setListener(OnAmountChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        this.getAuthRequestContext = r2;
    }

    public final void setMaxAmount(long amount) {
        String format;
        this.PlaceComponentResult = amount;
        StringBuilder sb = new StringBuilder();
        sb.append("Rp");
        format = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format(amount);
        sb.append(format);
        getBinding().MyBillsEntityDataFactory.setText(getContext().getString(R.string.family_member_transaction_limit_input_amount_note, sb.toString()));
    }

    public final void setEditTextAmount(long amount) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setPrefixedAmount(amount);
    }

    public static final boolean getAuthRequestContext(CurrencyEditText currencyEditText, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(currencyEditText, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        if (currencyEditText.getCompoundDrawables()[2] != null && motionEvent.getRawX() >= currencyEditText.getRight() - currencyEditText.getCompoundDrawables()[2].getBounds().width() && currencyEditText.getText() != null) {
            InputExtKt.MyBillsEntityDataFactory(currencyEditText);
            return true;
        }
        currencyEditText.performClick();
        return false;
    }

    public final void clear() {
        CurrencyEditText currencyEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        if (currencyEditText != null) {
            InputExtKt.MyBillsEntityDataFactory(currencyEditText);
        }
    }

    public static final /* synthetic */ void access$setClearTextIcon(FamilySetMemberLimitInputAmountView familySetMemberLimitInputAmountView, String str) {
        if (familySetMemberLimitInputAmountView.MyBillsEntityDataFactory) {
            return;
        }
        familySetMemberLimitInputAmountView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setCompoundDrawablesWithIntrinsicBounds(0, 0, (!(str.length() > 0) || str.contentEquals("0")) ? 0 : R.drawable.ic_close_filled_grey, 0);
    }

    public static final /* synthetic */ void access$setFieldState(FamilySetMemberLimitInputAmountView familySetMemberLimitInputAmountView, int i) {
        Drawable background;
        CurrencyEditText currencyEditText = familySetMemberLimitInputAmountView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        if (currencyEditText == null || (background = currencyEditText.getBackground()) == null) {
            return;
        }
        background.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(familySetMemberLimitInputAmountView.getContext(), i), PorterDuff.Mode.SRC_IN);
    }

    public static final /* synthetic */ void access$validateAmount(FamilySetMemberLimitInputAmountView familySetMemberLimitInputAmountView, MoneyViewModel moneyViewModel) {
        OnAmountChangeListener onAmountChangeListener;
        OnAmountChangeListener onAmountChangeListener2;
        OnAmountChangeListener onAmountChangeListener3 = familySetMemberLimitInputAmountView.getAuthRequestContext;
        if (onAmountChangeListener3 != null) {
            String cleanAll = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
            if (cleanAll == null) {
                cleanAll = "0";
            }
            Long longOrNull = StringsKt.toLongOrNull(cleanAll);
            onAmountChangeListener3.BuiltInFictitiousFunctionClassFactory(longOrNull != null ? longOrNull.longValue() : 0L);
        }
        String cleanAll2 = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
        if (cleanAll2 == null) {
            cleanAll2 = "0";
        }
        Long longOrNull2 = StringsKt.toLongOrNull(cleanAll2);
        long longValue = longOrNull2 != null ? longOrNull2.longValue() : 0L;
        boolean z = false;
        if (longValue > 0) {
            String cleanAll3 = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
            Long longOrNull3 = StringsKt.toLongOrNull(cleanAll3 != null ? cleanAll3 : "0");
            if ((longOrNull3 != null ? longOrNull3.longValue() : 0L) <= familySetMemberLimitInputAmountView.PlaceComponentResult) {
                if (!familySetMemberLimitInputAmountView.BuiltInFictitiousFunctionClassFactory && (onAmountChangeListener2 = familySetMemberLimitInputAmountView.getAuthRequestContext) != null) {
                    onAmountChangeListener2.PlaceComponentResult(true);
                }
                z = true;
                familySetMemberLimitInputAmountView.BuiltInFictitiousFunctionClassFactory = z;
            }
        }
        if (familySetMemberLimitInputAmountView.BuiltInFictitiousFunctionClassFactory && (onAmountChangeListener = familySetMemberLimitInputAmountView.getAuthRequestContext) != null) {
            onAmountChangeListener.PlaceComponentResult(false);
        }
        familySetMemberLimitInputAmountView.BuiltInFictitiousFunctionClassFactory = z;
    }
}
