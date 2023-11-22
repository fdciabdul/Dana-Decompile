package id.dana.sendmoney.ui.groupsend.summary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ViewGroupSendInputAmountBinding;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00016B/\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0011\u0012\b\b\u0002\u00103\u001a\u00020\u0011¢\u0006\u0004\b4\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u00020\n*\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010'R\u0016\u0010)\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010(R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010+\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010'R\u0016\u0010-\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendInputAmountView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/sendmoney/databinding/ViewGroupSendInputAmountBinding;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ViewGroupSendInputAmountBinding;", "Lid/dana/core/ui/model/CurrencyAmountModel;", "minPayeeAmount", "maxPayeeAmount", "totalAmount", "remainingAmount", "", "setLimit", "(Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;Lid/dana/core/ui/model/CurrencyAmountModel;)V", "Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendInputAmountView$OnAmountChangeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendInputAmountView$OnAmountChangeListener;)V", "", "memberCount", "setMemberCount", "(I)V", "", "amountValue", "setPrefixedAmount", "(J)V", "", CustomDialogKey.Response.IS_CHECKED, "setSameAmount", "(Z)V", "setup", "()V", "p0", "PlaceComponentResult", "(Lid/dana/core/ui/model/CurrencyAmountModel;Z)V", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendInputAmountView$OnAmountChangeListener;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "Lid/dana/core/ui/model/CurrencyAmountModel;", "I", "BuiltInFictitiousFunctionClassFactory", "lookAheadTest", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnAmountChangeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendInputAmountView extends BaseViewBindingRichView<ViewGroupSendInputAmountBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private CurrencyAmountModel MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnAmountChangeListener getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private CurrencyAmountModel getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private CurrencyAmountModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private CurrencyAmountModel scheduleImpl;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/GroupSendInputAmountView$OnAmountChangeListener;", "", "", "p0", "Lid/dana/core/ui/model/CurrencyAmountModel;", "p1", "", "PlaceComponentResult", "(ZLid/dana/core/ui/model/CurrencyAmountModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnAmountChangeListener {
        void PlaceComponentResult(boolean p0, CurrencyAmountModel p1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupSendInputAmountView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupSendInputAmountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupSendInputAmountView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ GroupSendInputAmountView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSendInputAmountView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        boolean z = false;
        int i3 = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.MyBillsEntityDataFactory = new CurrencyAmountModel("1", "Rp", z, i3, defaultConstructorMarker);
        boolean z2 = false;
        int i4 = 4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CurrencyAmountModel("20000000", "Rp", z2, i4, defaultConstructorMarker2);
        this.getErrorConfigVersion = new CurrencyAmountModel("50000000", "Rp", z, i3, defaultConstructorMarker);
        this.scheduleImpl = new CurrencyAmountModel("50000000", "Rp", z2, i4, defaultConstructorMarker2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewGroupSendInputAmountBinding inflateViewBinding() {
        ViewGroupSendInputAmountBinding authRequestContext = ViewGroupSendInputAmountBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().PlaceComponentResult.setContentDescription(getContext().getString(R.string.lbl_error_limit));
        final CurrencyEditText currencyEditText = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(currencyEditText, R.style.lookAheadTest);
        currencyEditText.setUsePrefix(true);
        currencyEditText.setPrefixedAmount(0L);
        currencyEditText.disableSoftKeyboard();
        final CurrencyEditText currencyEditText2 = currencyEditText;
        if (ViewCompat.C(currencyEditText2)) {
            LifecycleOwner PlaceComponentResult = C0207ViewKt.PlaceComponentResult(currencyEditText2);
            if (PlaceComponentResult != null) {
                FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new GroupSendInputAmountView$setup$1$1$1$1(this, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult));
                return;
            }
            return;
        }
        currencyEditText2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.GroupSendInputAmountView$setup$lambda-2$$inlined$doOnAttach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                currencyEditText2.removeOnAttachStateChangeListener(this);
                Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(currencyEditText);
                if (PlaceComponentResult2 != null) {
                    FlowKt.launchIn(FlowKt.onEach(currencyEditText.listenOriginalValue(), new GroupSendInputAmountView$setup$1$1$1$1(this, null)), LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2));
                }
            }
        });
    }

    public final void setListener(OnAmountChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.getAuthRequestContext = listener;
    }

    public final void setPrefixedAmount(long amountValue) {
        getBinding().BuiltInFictitiousFunctionClassFactory.setPrefixedAmount(amountValue);
    }

    public final void setLimit(CurrencyAmountModel minPayeeAmount, CurrencyAmountModel maxPayeeAmount, CurrencyAmountModel totalAmount, CurrencyAmountModel remainingAmount) {
        Intrinsics.checkNotNullParameter(minPayeeAmount, "");
        Intrinsics.checkNotNullParameter(maxPayeeAmount, "");
        Intrinsics.checkNotNullParameter(totalAmount, "");
        Intrinsics.checkNotNullParameter(remainingAmount, "");
        this.MyBillsEntityDataFactory = minPayeeAmount;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = maxPayeeAmount;
        this.getErrorConfigVersion = totalAmount;
        this.scheduleImpl = remainingAmount;
    }

    public final void setMemberCount(int memberCount) {
        this.BuiltInFictitiousFunctionClassFactory = memberCount;
    }

    public final void setSameAmount(boolean isChecked) {
        this.PlaceComponentResult = isChecked;
        PlaceComponentResult(new CurrencyAmountModel(getBinding().BuiltInFictitiousFunctionClassFactory.getAmount(), "Rp", false, 4, null), isChecked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(CurrencyAmountModel currencyAmountModel, boolean z) {
        CurrencyAmountModel currencyAmountModel2;
        if (z) {
            String unformatedAmount = currencyAmountModel.getUnformatedAmount();
            currencyAmountModel2 = new CurrencyAmountModel(String.valueOf(unformatedAmount != null ? Long.valueOf(Long.parseLong(unformatedAmount) * this.BuiltInFictitiousFunctionClassFactory) : null), "Rp", false, 4, null);
        } else {
            currencyAmountModel2 = currencyAmountModel;
        }
        if (currencyAmountModel.isLessThan(this.MyBillsEntityDataFactory) && !Intrinsics.areEqual(currencyAmountModel.getAmount(), "0")) {
            TextView textView = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            String string = textView.getResources().getString(R.string.res_0x7f1306fa_flowviewutil_textchanges_2);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.MyBillsEntityDataFactory.getCurrencyAndAmountValue()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
            OnAmountChangeListener onAmountChangeListener = this.getAuthRequestContext;
            if (onAmountChangeListener != null) {
                onAmountChangeListener.PlaceComponentResult(false, currencyAmountModel);
            }
        } else if (currencyAmountModel.isMoreThan(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            TextView textView2 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            textView2.setVisibility(0);
            String string2 = textView2.getResources().getString(R.string.error_message_max_limit);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.KClassImpl$Data$declaredNonStaticMembers$2.getCurrencyAndAmountValue()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "");
            textView2.setText(format2);
            OnAmountChangeListener onAmountChangeListener2 = this.getAuthRequestContext;
            if (onAmountChangeListener2 != null) {
                onAmountChangeListener2.PlaceComponentResult(false, currencyAmountModel);
            }
        } else if (!z && currencyAmountModel.isMoreThan(this.scheduleImpl)) {
            TextView textView3 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView3, "");
            textView3.setVisibility(0);
            String string3 = textView3.getResources().getString(R.string.error_message_max_limit);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{this.getErrorConfigVersion.getCurrencyAndAmountValue()}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "");
            textView3.setText(format3);
            OnAmountChangeListener onAmountChangeListener3 = this.getAuthRequestContext;
            if (onAmountChangeListener3 != null) {
                onAmountChangeListener3.PlaceComponentResult(false, currencyAmountModel);
            }
        } else if (z && currencyAmountModel2.isMoreThan(this.getErrorConfigVersion)) {
            TextView textView4 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView4, "");
            textView4.setVisibility(0);
            String string4 = textView4.getResources().getString(R.string.error_message_total_limit);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            String format4 = String.format(string4, Arrays.copyOf(new Object[]{this.getErrorConfigVersion.getCurrencyAndAmountValue()}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "");
            textView4.setText(format4);
            OnAmountChangeListener onAmountChangeListener4 = this.getAuthRequestContext;
            if (onAmountChangeListener4 != null) {
                onAmountChangeListener4.PlaceComponentResult(false, currencyAmountModel);
            }
        } else if (currencyAmountModel.isAmountLessThanOne()) {
            OnAmountChangeListener onAmountChangeListener5 = this.getAuthRequestContext;
            if (onAmountChangeListener5 != null) {
                onAmountChangeListener5.PlaceComponentResult(false, currencyAmountModel);
            }
            TextView textView5 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView5, "");
            textView5.setVisibility(4);
        } else {
            OnAmountChangeListener onAmountChangeListener6 = this.getAuthRequestContext;
            if (onAmountChangeListener6 != null) {
                onAmountChangeListener6.PlaceComponentResult(true, currencyAmountModel);
            }
            TextView textView6 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView6, "");
            textView6.setVisibility(4);
        }
    }
}
