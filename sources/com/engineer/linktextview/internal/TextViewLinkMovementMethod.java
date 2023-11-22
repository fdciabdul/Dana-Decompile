package com.engineer.linktextview.internal;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\r"}, d2 = {"Lcom/engineer/linktextview/internal/TextViewLinkMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "MyBillsEntityDataFactory", "()Lcom/engineer/linktextview/internal/TextViewLinkMovementMethod;", "Landroid/widget/TextView;", "p0", "Landroid/text/Spannable;", "p1", "Landroid/view/MotionEvent;", "p2", "", "onTouchEvent", "(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z", "Lcom/engineer/linktextview/internal/TextViewLinkMovementMethod;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes7.dex */
public final class TextViewLinkMovementMethod extends LinkMovementMethod {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private TextViewLinkMovementMethod PlaceComponentResult;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView p0, Spannable p1, MotionEvent p2) {
        if (p2 == null) {
            Intrinsics.throwNpe();
        }
        int action = p2.getAction();
        if (action == 1 || action == 0) {
            int x = (int) p2.getX();
            int y = (int) p2.getY();
            if (p0 == null) {
                Intrinsics.throwNpe();
            }
            int totalPaddingLeft = p0.getTotalPaddingLeft();
            int totalPaddingTop = p0.getTotalPaddingTop();
            int scrollX = (x - totalPaddingLeft) + p0.getScrollX();
            int scrollY = p0.getScrollY();
            Layout layout = p0.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - totalPaddingTop) + scrollY), scrollX);
            int primaryHorizontal = (int) layout.getPrimaryHorizontal(offsetForHorizontal);
            CharSequence text = p0.getText();
            Intrinsics.checkExpressionValueIsNotNull(text, "");
            if (scrollX > primaryHorizontal + (text.length() > 0 ? (int) p0.getPaint().measureText(String.valueOf(p0.getText().charAt(0))) : 0)) {
                return true;
            }
            if (p1 == null) {
                Intrinsics.throwNpe();
            }
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) p1.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            Intrinsics.checkExpressionValueIsNotNull(clickableSpanArr, "");
            if ((!(clickableSpanArr.length == 0)) != false) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(p0);
                }
                return true;
            }
        }
        return super.onTouchEvent(p0, p1, p2);
    }

    public final TextViewLinkMovementMethod MyBillsEntityDataFactory() {
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new TextViewLinkMovementMethod();
        }
        TextViewLinkMovementMethod textViewLinkMovementMethod = this.PlaceComponentResult;
        if (textViewLinkMovementMethod != null) {
            return textViewLinkMovementMethod;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.engineer.linktextview.internal.TextViewLinkMovementMethod");
    }
}
