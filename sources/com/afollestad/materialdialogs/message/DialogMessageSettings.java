package com.afollestad.materialdialogs.message;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.message.LinkTransformationMethod;
import com.afollestad.materialdialogs.utils.MDUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b!\u0010\"J,\u0010\u0007\u001a\u00020\u00002\u001d\b\u0002\u0010\u0006\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 "}, d2 = {"Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "onLinkClick", "html", "(Lkotlin/jvm/functions/Function1;)Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "", "multiplier", "lineSpacing", "(F)Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "", "res", "", "text", "setText$core", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "", "isHtml", "maybeWrapHtml", "(Ljava/lang/CharSequence;Z)Ljava/lang/CharSequence;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "didSetLineSpacing", "Z", "Landroid/widget/TextView;", "messageTextView", "Landroid/widget/TextView;", "getMessageTextView", "()Landroid/widget/TextView;", "<init>", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/widget/TextView;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class DialogMessageSettings {
    private final MaterialDialog dialog;
    private boolean didSetLineSpacing;
    private boolean isHtml;
    private final TextView messageTextView;

    public DialogMessageSettings(MaterialDialog materialDialog, TextView textView) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(textView, "");
        this.dialog = materialDialog;
        this.messageTextView = textView;
    }

    @JvmName(name = "getMessageTextView")
    public final TextView getMessageTextView() {
        return this.messageTextView;
    }

    public final DialogMessageSettings lineSpacing(float multiplier) {
        this.didSetLineSpacing = true;
        this.messageTextView.setLineSpacing(0.0f, multiplier);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DialogMessageSettings html$default(DialogMessageSettings dialogMessageSettings, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return dialogMessageSettings.html(function1);
    }

    public final DialogMessageSettings html(Function1<? super String, Unit> onLinkClick) {
        this.isHtml = true;
        if (onLinkClick != null) {
            this.messageTextView.setTransformationMethod(new LinkTransformationMethod(onLinkClick));
        }
        this.messageTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return this;
    }

    public final void setText$core(Integer res, CharSequence text) {
        if (!this.didSetLineSpacing) {
            lineSpacing(MDUtil.INSTANCE.resolveFloat(this.dialog.getWindowContext(), R.attr.md_line_spacing_body, 1.1f));
        }
        TextView textView = this.messageTextView;
        CharSequence maybeWrapHtml = maybeWrapHtml(text, this.isHtml);
        if (maybeWrapHtml == null) {
            maybeWrapHtml = MDUtil.resolveString$default(MDUtil.INSTANCE, this.dialog, res, (Integer) null, this.isHtml, 4, (Object) null);
        }
        textView.setText(maybeWrapHtml);
    }

    private final CharSequence maybeWrapHtml(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            return null;
        }
        return z ? Html.fromHtml(charSequence.toString()) : charSequence;
    }
}
