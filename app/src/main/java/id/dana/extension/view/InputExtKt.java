package id.dana.extension.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.R;
import id.dana.utils.TextUtil;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a6\u0010\b\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0011\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n\u001a&\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0015H\u0086\bø\u0001\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\n\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\n\u001a\n\u0010\u001a\u001a\u00020\u0007*\u00020\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"addEmojiFilter", "", "Landroid/widget/EditText;", "clearText", "Landroid/widget/TextView;", "containsEmoji", "", "", "createColoredSpan", "color", "", "spanText", "", "isUnderlineText", "onClick", "Lkotlin/Function0;", "focusAndShowKeyboard", "isMinLength", SecurityConstants.KEY_MINLENGTH, "onTextAfterChanged", "action", "Lkotlin/Function1;", "setBackgroundTint", "resId", "setMaxLength", SecurityConstants.KEY_MAXLENGTH, "toCleanUrl", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputExtKt {
    public static final void PlaceComponentResult(EditText editText, int i) {
        Intrinsics.checkNotNullParameter(editText, "");
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        InputFilter[] filters = editText.getFilters();
        Intrinsics.checkNotNullExpressionValue(filters, "");
        spreadBuilder.addSpread(filters);
        spreadBuilder.add(new InputFilter.LengthFilter(i));
        editText.setFilters((InputFilter[]) spreadBuilder.toArray(new InputFilter[spreadBuilder.size()]));
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "");
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "");
        return (text.length() > 0) && textView.getText().length() >= 3;
    }

    public static final void BuiltInFictitiousFunctionClassFactory(EditText editText, int i) {
        Intrinsics.checkNotNullParameter(editText, "");
        DrawableCompat.MyBillsEntityDataFactory(editText.getBackground(), ContextCompat.BuiltInFictitiousFunctionClassFactory(editText.getContext(), i));
    }

    public static final void MyBillsEntityDataFactory(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "");
        textView.setText("");
    }

    public static /* synthetic */ void PlaceComponentResult(TextView textView, String str, boolean z, Function0 function0, int i) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.extension.view.InputExtKt$createColoredSpan$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        getAuthRequestContext(textView, R.color.f22912131099753, str, z, function0);
    }

    public static final void getAuthRequestContext(TextView textView, int i, String str, final boolean z, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(textView, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function0, "");
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.extension.view.InputExtKt$createColoredSpan$2
            @Override // android.text.style.ClickableSpan
            public final void onClick(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                function0.invoke();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public final void updateDrawState(TextPaint p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.updateDrawState(p0);
                p0.setUnderlineText(z);
            }
        };
        int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), i);
        CharSequence text = textView.getText();
        String obj = text != null ? text.toString() : null;
        TextUtil.MyBillsEntityDataFactory(textView, clickableSpan, BuiltInFictitiousFunctionClassFactory, obj != null ? obj : "", str);
    }

    public static final CharSequence BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        String str = StringsKt.contains$default(charSequence, (CharSequence) SemanticAttributes.FaasTriggerValues.HTTP, false, 2, (Object) null) || StringsKt.contains$default(charSequence, (CharSequence) "https", false, 2, (Object) null) ? null : "https://m.dana.id";
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append((Object) charSequence);
            String obj = sb.toString();
            return obj != null ? obj : charSequence;
        }
        return charSequence;
    }

    public static final void PlaceComponentResult(EditText editText) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(editText, "");
        editText.requestFocus();
        editText.setSelection(editText.getText().length());
        Context context = editText.getContext();
        Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 1);
        }
    }

    private static boolean MyBillsEntityDataFactory(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            byte type = (byte) Character.getType(charSequence.charAt(i));
            if (type == 19 || type == 28) {
                break;
            }
            i++;
        }
        return i != -1;
    }

    public static /* synthetic */ CharSequence PlaceComponentResult(CharSequence charSequence) {
        Intrinsics.checkNotNullExpressionValue(charSequence, "");
        return MyBillsEntityDataFactory(charSequence) ? "" : null;
    }
}
