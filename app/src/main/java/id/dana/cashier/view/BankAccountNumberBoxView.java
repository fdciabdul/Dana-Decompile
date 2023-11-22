package id.dana.cashier.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.TextViewCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.textfield.TextInputEditText;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewBankAccountNumberBoxBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010$\u001a\u00020 \u0012\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b\"\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007R*\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R.\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001b"}, d2 = {"Lid/dana/cashier/view/BankAccountNumberBoxView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewBankAccountNumberBoxBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewBankAccountNumberBoxBinding;", "", "MyBillsEntityDataFactory", "()V", "setup", "", "value", "getAuthRequestContext", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "errorMessage", "Lkotlin/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "getInputBankNumberChangedListener", "()Lkotlin/jvm/functions/Function1;", "setInputBankNumberChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "inputBankNumberChangedListener", "", "Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankAccountNumberBoxView extends BaseViewBindingRichView<ViewBankAccountNumberBoxBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Function1<? super String, Unit> inputBankNumberChangedListener;
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String errorMessage;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankAccountNumberBoxView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankAccountNumberBoxView(Context context, AttributeSet attributeSet) {
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
    public BankAccountNumberBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.errorMessage = "";
        this.inputBankNumberChangedListener = BankAccountNumberBoxView$inputBankNumberChangedListener$1.INSTANCE;
    }

    public /* synthetic */ BankAccountNumberBoxView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankAccountNumberBoxView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.errorMessage = "";
        this.inputBankNumberChangedListener = BankAccountNumberBoxView$inputBankNumberChangedListener$1.INSTANCE;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewBankAccountNumberBoxBinding inflateViewBinding() {
        ViewBankAccountNumberBoxBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewBankAccountNumberBoxBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "getErrorMessage")
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @JvmName(name = "setErrorMessage")
    public final void setErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.errorMessage = str;
        AppCompatTextView appCompatTextView = getBinding().getAuthRequestContext;
        appCompatTextView.setText(this.errorMessage);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(this.errorMessage.length() > 0 ? 0 : 4);
        MyBillsEntityDataFactory();
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
    public final void setup() {
        TextInputEditText textInputEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "");
        TextInputEditText textInputEditText2 = textInputEditText;
        textInputEditText2.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.view.BankAccountNumberBoxView$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                BankAccountNumberBoxView.this.getInputBankNumberChangedListener().invoke(String.valueOf(p0));
            }
        });
        textInputEditText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.cashier.view.BankAccountNumberBoxView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                BankAccountNumberBoxView.$r8$lambda$iOLa5i4239oIWbwX31hTV2z0kq8(BankAccountNumberBoxView.this, view, z);
            }
        });
    }

    private final void MyBillsEntityDataFactory() {
        Integer valueOf;
        Integer valueOf2;
        if (this.errorMessage.length() > 0) {
            valueOf = Integer.valueOf((int) R.style.f49812132017435);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_red_50);
        } else if (this.MyBillsEntityDataFactory) {
            valueOf = Integer.valueOf((int) R.style.f49822132017436);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_yellow_50);
        } else {
            valueOf = Integer.valueOf((int) R.style.f49862132017440);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_grey_20);
        }
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().getAuthRequestContext, valueOf.intValue());
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), valueOf2.intValue(), null));
    }

    public static /* synthetic */ void $r8$lambda$iOLa5i4239oIWbwX31hTV2z0kq8(BankAccountNumberBoxView bankAccountNumberBoxView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(bankAccountNumberBoxView, "");
        bankAccountNumberBoxView.MyBillsEntityDataFactory = z;
        bankAccountNumberBoxView.MyBillsEntityDataFactory();
    }
}
