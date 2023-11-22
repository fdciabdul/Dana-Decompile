package com.afollestad.materialdialogs.internal.message;

import android.text.style.URLSpan;
import android.view.View;
import id.dana.danah5.share.ShareToFeedBridge;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lcom/afollestad/materialdialogs/internal/message/CustomUrlSpan;", "Landroid/text/style/URLSpan;", "Landroid/view/View;", ShareToFeedBridge.WIDGET, "", "onClick", "(Landroid/view/View;)V", "Lkotlin/Function1;", "", "onLinkClick", "Lkotlin/jvm/functions/Function1;", "url", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class CustomUrlSpan extends URLSpan {
    private final Function1<String, Unit> onLinkClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CustomUrlSpan(String str, Function1<? super String, Unit> function1) {
        super(str);
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(function1, "");
        this.onLinkClick = function1;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public final void onClick(View widget) {
        Intrinsics.checkParameterIsNotNull(widget, "");
        Function1<String, Unit> function1 = this.onLinkClick;
        String url = getURL();
        Intrinsics.checkExpressionValueIsNotNull(url, "");
        function1.invoke(url);
    }
}
