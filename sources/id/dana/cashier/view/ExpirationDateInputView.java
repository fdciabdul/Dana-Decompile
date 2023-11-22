package id.dana.cashier.view;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import id.dana.R;
import id.dana.cashier.view.ExpirationDateInputView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewExpirationDateInputBinding;
import id.dana.extension.view.InputExtKt;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.SplashSpan;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002./B'\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*B+\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010+\u001a\u00020\u0005\u0012\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\b)\u0010-J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\rR*\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\""}, d2 = {"Lid/dana/cashier/view/ExpirationDateInputView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewExpirationDateInputBinding;", "Landroid/text/Editable;", "expiryDate", "", SecurityConstants.KEY_MAXLENGTH, "", "formatExpiryDate", "(Landroid/text/Editable;I)V", "inflateViewBinding", "()Lid/dana/databinding/ViewExpirationDateInputBinding;", "resetValue", "()V", "", "value", "setValue", "(Ljava/lang/String;)V", "setup", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getCardDateOCR", "()Ljava/lang/String;", "setCardDateOCR", "cardDateOCR", "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "Lid/dana/cashier/view/ExpirationDateInputView$OnInputDateListener;", "Lid/dana/cashier/view/ExpirationDateInputView$OnInputDateListener;", "getListener", "()Lid/dana/cashier/view/ExpirationDateInputView$OnInputDateListener;", "setListener", "(Lid/dana/cashier/view/ExpirationDateInputView$OnInputDateListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnInputDateListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExpirationDateInputView extends BaseViewBindingRichView<ViewExpirationDateInputBinding> {
    public static final String CONVERT_EXPIRY_DATE_FORMAT = "MM/yy";
    public static final String EXPIRY_DATE_FORMAT = "MMyy";
    public static final int EXPIRY_DATE_MAX_LENGTH = 5;
    public static final String REGEX = "^([2-9])";
    public static final int SLASH_START_INDEX = 2;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String cardDateOCR;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnInputDateListener listener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/view/ExpirationDateInputView$OnInputDateListener;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "p1", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnInputDateListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

        void PlaceComponentResult(String p0);

        void getAuthRequestContext(String p0, String p1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpirationDateInputView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpirationDateInputView(Context context, AttributeSet attributeSet) {
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
    public ExpirationDateInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.cardDateOCR = "";
    }

    public /* synthetic */ ExpirationDateInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpirationDateInputView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.cardDateOCR = "";
    }

    @JvmName(name = "getListener")
    public final OnInputDateListener getListener() {
        return this.listener;
    }

    @JvmName(name = "setListener")
    public final void setListener(OnInputDateListener onInputDateListener) {
        this.listener = onInputDateListener;
    }

    @JvmName(name = "getCardDateOCR")
    public final String getCardDateOCR() {
        return this.cardDateOCR;
    }

    @JvmName(name = "setCardDateOCR")
    public final void setCardDateOCR(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.cardDateOCR = str;
        TextInputEditText textInputEditText = getBinding().MyBillsEntityDataFactory;
        String str2 = this.cardDateOCR;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        textInputEditText.setText(obj);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewExpirationDateInputBinding inflateViewBinding() {
        ViewExpirationDateInputBinding authRequestContext = ViewExpirationDateInputBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        TextInputEditText textInputEditText = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "");
        final TextInputEditText textInputEditText2 = textInputEditText;
        textInputEditText2.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.view.ExpirationDateInputView$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                ViewExpirationDateInputBinding binding;
                if (p0 != null) {
                    AppCompatEditText appCompatEditText = AppCompatEditText.this;
                    ExpirationDateInputView expirationDateInputView = this;
                    if (Pattern.compile(ExpirationDateInputView.REGEX).matcher(p0).find()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append('0');
                        sb.append((Object) p0);
                        appCompatEditText.setText(sb.toString());
                        Editable text = appCompatEditText.getText();
                        binding = expirationDateInputView.getBinding();
                        Selection.setSelection(text, binding.MyBillsEntityDataFactory.length());
                    }
                    ExpirationDateInputView.access$checkInputtedExpiryDate(expirationDateInputView, p0);
                    ExpirationDateInputView.OnInputDateListener listener = expirationDateInputView.getListener();
                    if (listener != null) {
                        listener.PlaceComponentResult(p0.toString());
                    }
                }
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                if (p0 != null) {
                    this.formatExpiryDate(p0, 5);
                }
            }
        });
    }

    public final void formatExpiryDate(Editable expiryDate, int maxLength) {
        Intrinsics.checkNotNullParameter(expiryDate, "");
        int length = expiryDate.length();
        Object[] spans = expiryDate.getSpans(0, expiryDate.length(), SplashSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "");
        for (SplashSpan splashSpan : (SplashSpan[]) spans) {
            expiryDate.removeSpan(splashSpan);
        }
        if (maxLength > 0 && length > maxLength - 1) {
            expiryDate.replace(maxLength, length, "");
            length--;
        }
        int i = (length - 1) / 2;
        if (i <= 0) {
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = (i2 * 2) + 1;
            expiryDate.setSpan(new SplashSpan(), i3 - 1, i3, 33);
            if (i2 == i) {
                return;
            }
            i2++;
        }
    }

    public final void resetValue() {
        ViewExpirationDateInputBinding binding = getBinding();
        TextInputEditText textInputEditText = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "");
        InputExtKt.MyBillsEntityDataFactory(textInputEditText);
        binding.BuiltInFictitiousFunctionClassFactory.setError(null);
    }

    public final void setValue(String value) {
        Intrinsics.checkNotNullParameter(value, "");
        getBinding().MyBillsEntityDataFactory.setText(value);
    }

    public static final /* synthetic */ void access$checkInputtedExpiryDate(ExpirationDateInputView expirationDateInputView, CharSequence charSequence) {
        boolean z;
        ViewExpirationDateInputBinding binding = expirationDateInputView.getBinding();
        if (charSequence.length() == 4) {
            expirationDateInputView.MyBillsEntityDataFactory = true;
            String MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(EXPIRY_DATE_FORMAT, CONVERT_EXPIRY_DATE_FORMAT, LocaleUtil.getAuthRequestContext(), charSequence.toString());
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            List split$default = StringsKt.split$default((CharSequence) MyBillsEntityDataFactory, new String[]{"/"}, false, 0, 6, (Object) null);
            OnInputDateListener onInputDateListener = expirationDateInputView.listener;
            if (onInputDateListener != null) {
                onInputDateListener.getAuthRequestContext((String) split$default.get(0), (String) split$default.get(1));
            }
            z = DateTimeUtil.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, CONVERT_EXPIRY_DATE_FORMAT, LocaleUtil.getAuthRequestContext());
        } else {
            z = false;
        }
        if (z || charSequence.length() < 4) {
            if (expirationDateInputView.MyBillsEntityDataFactory) {
                binding.BuiltInFictitiousFunctionClassFactory.setError(expirationDateInputView.getContext().getString(R.string.incorrect_expiry_date));
            }
            OnInputDateListener onInputDateListener2 = expirationDateInputView.listener;
            if (onInputDateListener2 != null) {
                onInputDateListener2.KClassImpl$Data$declaredNonStaticMembers$2(false);
                return;
            }
            return;
        }
        if (charSequence.length() == 0) {
            binding.BuiltInFictitiousFunctionClassFactory.setError(null);
            OnInputDateListener onInputDateListener3 = expirationDateInputView.listener;
            if (onInputDateListener3 != null) {
                onInputDateListener3.KClassImpl$Data$declaredNonStaticMembers$2(false);
                return;
            }
            return;
        }
        binding.BuiltInFictitiousFunctionClassFactory.setError(null);
        OnInputDateListener onInputDateListener4 = expirationDateInputView.listener;
        if (onInputDateListener4 != null) {
            onInputDateListener4.KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
    }
}
