package id.dana.social.view;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/social/view/ClickableMovementMethod;", "Landroid/text/method/BaseMovementMethod;", "", "canSelectArbitrarily", "()Z", "Landroid/widget/TextView;", "p0", "Landroid/text/Spannable;", "p1", "", "initialize", "(Landroid/widget/TextView;Landroid/text/Spannable;)V", "Landroid/view/MotionEvent;", "p2", "onTouchEvent", "(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClickableMovementMethod extends BaseMovementMethod {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ClickableMovementMethod KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean canSelectArbitrarily() {
        return false;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView p0, Spannable p1, MotionEvent p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        int actionMasked = p2.getActionMasked();
        if (actionMasked == 0 || actionMasked == 1) {
            Layout layout = p0.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) p2.getY()), p2.getX());
            Object[] spans = p1.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "");
            Object[] objArr = (ClickableSpan[]) spans;
            if ((!(objArr.length == 0)) == true) {
                if (actionMasked == 1) {
                    objArr[0].onClick(p0);
                } else {
                    Selection.setSelection(p1, p1.getSpanStart(objArr[0]), p1.getSpanEnd(objArr[0]));
                }
                return true;
            }
            Selection.removeSelection(p1);
        }
        return false;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final void initialize(TextView p0, Spannable p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Selection.removeSelection(p1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/view/ClickableMovementMethod$Companion;", "", "Lid/dana/social/view/ClickableMovementMethod;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/view/ClickableMovementMethod;", "MyBillsEntityDataFactory", "()Lid/dana/social/view/ClickableMovementMethod;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        public static ClickableMovementMethod MyBillsEntityDataFactory() {
            if (ClickableMovementMethod.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                ClickableMovementMethod.KClassImpl$Data$declaredNonStaticMembers$2 = new ClickableMovementMethod();
            }
            ClickableMovementMethod clickableMovementMethod = ClickableMovementMethod.KClassImpl$Data$declaredNonStaticMembers$2;
            if (clickableMovementMethod == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            }
            return clickableMovementMethod;
        }
    }
}
