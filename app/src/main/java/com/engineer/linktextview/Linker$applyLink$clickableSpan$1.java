package com.engineer.linktextview;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lcom/engineer/linktextview/Linker$applyLink$clickableSpan$1;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", "p0", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "updateDrawState", "(Landroid/text/TextPaint;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes7.dex */
public final class Linker$applyLink$clickableSpan$1 extends ClickableSpan {
    @Override // android.text.style.ClickableSpan
    public final void onClick(View p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
    }

    Linker$applyLink$clickableSpan$1() {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        p0.setColor(-7829368);
        p0.setUnderlineText(false);
    }
}
