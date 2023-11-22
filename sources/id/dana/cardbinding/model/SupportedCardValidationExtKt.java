package id.dana.cardbinding.model;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.core.content.ContextCompat;
import id.dana.R;
import id.dana.cardbinding.view.CardBindingDialogExtKt;
import id.dana.utils.NoUnderlineClickableSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aA\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001aG\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\t\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroid/content/Context;", "p0", "", "p1", "p2", "", "p3", "Lid/dana/utils/NoUnderlineClickableSpan;", "p4", "p5", "Landroid/text/SpannableString;", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILid/dana/utils/NoUnderlineClickableSpan;)Landroid/text/SpannableString;", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "Lid/dana/cashier/view/InputCardNumberView;", "Lio/reactivex/subjects/Subject;", "", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lid/dana/cashier/model/QueryCardPolicyInfoModel;Lid/dana/cashier/view/InputCardNumberView;Landroid/content/Context;Lio/reactivex/subjects/Subject;Z)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SupportedCardValidationExtKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARN: Type inference failed for: r11v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v6, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BuiltInFictitiousFunctionClassFactory(java.lang.String r19, id.dana.cashier.model.QueryCardPolicyInfoModel r20, id.dana.cashier.view.InputCardNumberView r21, final android.content.Context r22, io.reactivex.subjects.Subject<java.lang.Boolean> r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.model.SupportedCardValidationExtKt.BuiltInFictitiousFunctionClassFactory(java.lang.String, id.dana.cashier.model.QueryCardPolicyInfoModel, id.dana.cashier.view.InputCardNumberView, android.content.Context, io.reactivex.subjects.Subject, boolean):void");
    }

    private static final SpannableString getAuthRequestContext(Context context, String str, String str2, int i, NoUnderlineClickableSpan noUnderlineClickableSpan) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(noUnderlineClickableSpan, i, str2.length() + i, 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f22912131099753)), i, str2.length() + i, 33);
        spannableString.setSpan(new StyleSpan(0), i, str2.length() + i, 33);
        return spannableString;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Context context, Ref.ObjectRef objectRef) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(objectRef, "");
        CardBindingDialogExtKt.getAuthRequestContext(context, (String) objectRef.element);
    }
}
