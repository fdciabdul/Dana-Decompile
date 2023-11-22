package id.dana.core.ui.extension;

import android.os.Build;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u001aK\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"createColoredSpan", "", "Landroid/widget/TextView;", "color", "", "spanText", "", "isUnderlineText", "", "onClick", "Lkotlin/Function0;", "setCustomizableText", "text", "textAppearance", "contentDescription", "isVisible", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "core-ui_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TextViewExtKt {
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(TextView textView, String str, Integer num, Integer num2, String str2, Boolean bool, int i) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            bool = null;
        }
        Intrinsics.checkNotNullParameter(textView, "");
        if (str != null) {
            textView.setText(str);
        }
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
        if (num2 != null) {
            int intValue = num2.intValue();
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(intValue);
            } else {
                textView.setTextAppearance(textView.getContext(), intValue);
            }
        }
        if (str2 != null) {
            textView.setContentDescription(str2);
        }
        if (bool != null) {
            textView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public static final void PlaceComponentResult(TextView textView, int i, String str, final boolean z, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(textView, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function0, "");
        SpannableString spannableString = new SpannableString(textView.getText());
        CharSequence text = textView.getText();
        Intrinsics.checkNotNullExpressionValue(text, "");
        int indexOf$default = StringsKt.indexOf$default(text, str, 0, false, 6, (Object) null);
        spannableString.setSpan(new ClickableSpan() { // from class: id.dana.core.ui.extension.TextViewExtKt$createColoredSpan$2$clickableSpan$1
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
        }, indexOf$default, str.length() + indexOf$default, 0);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView.getContext(), i)), indexOf$default, str.length() + indexOf$default, 0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setFocusable(false);
        textView.setText(spannableString);
    }
}
