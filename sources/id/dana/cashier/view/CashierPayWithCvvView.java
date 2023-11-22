package id.dana.cashier.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewCashierPayWithCvvBinding;
import id.dana.dialog.CVVInfoDialog;
import id.dana.extension.view.InputExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!B+\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\u001e¢\u0006\u0004\b \u0010$J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R.\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00138\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/cashier/view/CashierPayWithCvvView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewCashierPayWithCvvBinding;", "", "isNeedToClearText", "", "clearText", "(Z)V", "", "getText", "()Ljava/lang/String;", "inflateViewBinding", "()Lid/dana/databinding/ViewCashierPayWithCvvBinding;", "setup", "()V", "Lid/dana/dialog/CVVInfoDialog;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/dialog/CVVInfoDialog;", "getAuthRequestContext", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getCvvInputListener", "()Lkotlin/jvm/functions/Function1;", "setCvvInputListener", "(Lkotlin/jvm/functions/Function1;)V", "cvvInputListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayWithCvvView extends BaseViewBindingRichView<ViewCashierPayWithCvvBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private CVVInfoDialog getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function1<? super String, Unit> cvvInputListener;

    /* renamed from: $r8$lambda$7Sakyg3X2c76oUIhr1ZJY-EZ6QU  reason: not valid java name */
    public static /* synthetic */ void m593$r8$lambda$7Sakyg3X2c76oUIhr1ZJYEZ6QU(DialogInterface dialogInterface) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierPayWithCvvView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierPayWithCvvView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
    public CashierPayWithCvvView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.cvvInputListener = CashierPayWithCvvView$cvvInputListener$1.INSTANCE;
    }

    public /* synthetic */ CashierPayWithCvvView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierPayWithCvvView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.cvvInputListener = CashierPayWithCvvView$cvvInputListener$1.INSTANCE;
    }

    @JvmName(name = "getCvvInputListener")
    public final Function1<String, Unit> getCvvInputListener() {
        return this.cvvInputListener;
    }

    @JvmName(name = "setCvvInputListener")
    public final void setCvvInputListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.cvvInputListener = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCashierPayWithCvvBinding inflateViewBinding() {
        ViewCashierPayWithCvvBinding BuiltInFictitiousFunctionClassFactory = ViewCashierPayWithCvvBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void clearText(boolean isNeedToClearText) {
        if (isNeedToClearText) {
            AppCompatEditText appCompatEditText = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
            InputExtKt.MyBillsEntityDataFactory(appCompatEditText);
        }
    }

    public final String getText() {
        return String.valueOf(getBinding().PlaceComponentResult.getText());
    }

    /* renamed from: $r8$lambda$-PoVUwi4ffvderojTQGOgDKhI4I  reason: not valid java name */
    public static /* synthetic */ void m592$r8$lambda$PoVUwi4ffvderojTQGOgDKhI4I(CashierPayWithCvvView cashierPayWithCvvView, View view) {
        Intrinsics.checkNotNullParameter(cashierPayWithCvvView, "");
        CVVInfoDialog cVVInfoDialog = cashierPayWithCvvView.getAuthRequestContext;
        if (cVVInfoDialog != null) {
            cVVInfoDialog.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$aoAkqWFMSIaYhIBqd4jtm_siGFk(CashierPayWithCvvView cashierPayWithCvvView, View view) {
        Intrinsics.checkNotNullParameter(cashierPayWithCvvView, "");
        CVVInfoDialog cVVInfoDialog = cashierPayWithCvvView.getAuthRequestContext;
        if (cVVInfoDialog != null) {
            cVVInfoDialog.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        Context context = getContext();
        if (context != null) {
            CVVInfoDialog.Builder builder = new CVVInfoDialog.Builder(context, new DialogInterface.OnDismissListener() { // from class: id.dana.cashier.view.CashierPayWithCvvView$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CashierPayWithCvvView.m593$r8$lambda$7Sakyg3X2c76oUIhr1ZJYEZ6QU(dialogInterface);
                }
            });
            String string = context.getString(R.string.dialog_cvv_info_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            builder.MyBillsEntityDataFactory = string;
            String string2 = context.getString(R.string.dialog_cvv_info_description);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            Intrinsics.checkNotNullParameter(string2, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = string2;
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.cashier.view.CashierPayWithCvvView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierPayWithCvvView.m592$r8$lambda$PoVUwi4ffvderojTQGOgDKhI4I(CashierPayWithCvvView.this, view);
                }
            };
            Intrinsics.checkNotNullParameter(onClickListener, "");
            builder.getAuthRequestContext = onClickListener;
            CVVInfoDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            this.getAuthRequestContext = new CVVInfoDialog(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, null);
        }
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.view.CashierPayWithCvvView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CashierPayWithCvvView.$r8$lambda$aoAkqWFMSIaYhIBqd4jtm_siGFk(CashierPayWithCvvView.this, view);
            }
        });
        AppCompatEditText appCompatEditText = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
        appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.view.CashierPayWithCvvView$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                CashierPayWithCvvView.this.getCvvInputListener().invoke(String.valueOf(p0));
            }
        });
    }
}
