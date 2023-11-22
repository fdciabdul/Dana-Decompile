package com.afollestad.materialdialogs.internal.message;

import android.graphics.Rect;
import android.text.Spannable;
import android.text.method.TransformationMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\"\u0012\u0019\u0010\u0015\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R'\u0010\u0015\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\u000f0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lcom/afollestad/materialdialogs/internal/message/LinkTransformationMethod;", "Landroid/text/method/TransformationMethod;", "", "source", "Landroid/view/View;", "view", "getTransformation", "(Ljava/lang/CharSequence;Landroid/view/View;)Ljava/lang/CharSequence;", "sourceText", "", "focused", "", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "", "onFocusChanged", "(Landroid/view/View;Ljava/lang/CharSequence;ZILandroid/graphics/Rect;)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "onLinkClick", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class LinkTransformationMethod implements TransformationMethod {
    private final Function1<String, Unit> onLinkClick;

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {
        Intrinsics.checkParameterIsNotNull(view, "");
        Intrinsics.checkParameterIsNotNull(sourceText, "");
        Intrinsics.checkParameterIsNotNull(previouslyFocusedRect, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinkTransformationMethod(Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "");
        this.onLinkClick = function1;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence source, View view) {
        Intrinsics.checkParameterIsNotNull(source, "");
        Intrinsics.checkParameterIsNotNull(view, "");
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getText() == null || !(textView.getText() instanceof Spannable)) {
                return source;
            }
            CharSequence text = textView.getText();
            if (text == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.text.Spannable");
            }
            Spannable spannable = (Spannable) text;
            for (URLSpan uRLSpan : (URLSpan[]) spannable.getSpans(0, textView.length(), URLSpan.class)) {
                int spanStart = spannable.getSpanStart(uRLSpan);
                int spanEnd = spannable.getSpanEnd(uRLSpan);
                Intrinsics.checkExpressionValueIsNotNull(uRLSpan, "");
                String url = uRLSpan.getURL();
                spannable.removeSpan(uRLSpan);
                Intrinsics.checkExpressionValueIsNotNull(url, "");
                spannable.setSpan(new CustomUrlSpan(url, this.onLinkClick), spanStart, spanEnd, 33);
            }
            return spannable;
        }
        return source;
    }
}
