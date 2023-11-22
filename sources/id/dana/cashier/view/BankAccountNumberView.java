package id.dana.cashier.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.textfield.TextInputEditText;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewBankAccountNumberInputBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 B+\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010!\u001a\u00020\u001d\u0012\u0006\u0010\"\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R*\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/cashier/view/BankAccountNumberView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewBankAccountNumberInputBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewBankAccountNumberInputBinding;", "", "setup", "()V", "", "value", "getAuthRequestContext", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "errorMessage", "Lkotlin/Function1;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "getInputBankNumberChangedListener", "()Lkotlin/jvm/functions/Function1;", "setInputBankNumberChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "inputBankNumberChangedListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankAccountNumberView extends BaseViewBindingRichView<ViewBankAccountNumberInputBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function1<? super String, Unit> inputBankNumberChangedListener;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String errorMessage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankAccountNumberView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankAccountNumberView(Context context, AttributeSet attributeSet) {
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
    public BankAccountNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.errorMessage = "";
        this.inputBankNumberChangedListener = BankAccountNumberView$inputBankNumberChangedListener$1.INSTANCE;
    }

    public /* synthetic */ BankAccountNumberView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankAccountNumberView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.errorMessage = "";
        this.inputBankNumberChangedListener = BankAccountNumberView$inputBankNumberChangedListener$1.INSTANCE;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @JvmName(name = "setErrorMessage")
    public final void setErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.errorMessage = str;
        AppCompatTextView appCompatTextView = getBinding().PlaceComponentResult;
        appCompatTextView.setText(this.errorMessage);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(this.errorMessage.length() > 0 ? 0 : 4);
    }

    @JvmName(name = "getInputBankNumberChangedListener")
    public final Function1<String, Unit> getInputBankNumberChangedListener() {
        return this.inputBankNumberChangedListener;
    }

    @JvmName(name = "setInputBankNumberChangedListener")
    public final void setInputBankNumberChangedListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.inputBankNumberChangedListener = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewBankAccountNumberInputBinding inflateViewBinding() {
        ViewBankAccountNumberInputBinding MyBillsEntityDataFactory = ViewBankAccountNumberInputBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        TextInputEditText textInputEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "");
        textInputEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.view.BankAccountNumberView$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                BankAccountNumberView.this.getInputBankNumberChangedListener().invoke(String.valueOf(p0));
            }
        });
    }
}
