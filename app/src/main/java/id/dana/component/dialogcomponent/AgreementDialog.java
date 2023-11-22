package id.dana.component.dialogcomponent;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import id.dana.component.R;
import id.dana.component.dialogcomponent.AgreementDialog;
import id.dana.component.dialogcomponent.CustomDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/component/dialogcomponent/AgreementDialog;", "", "<init>", "()V", "Builder"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class AgreementDialog {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/component/dialogcomponent/AgreementDialog$Builder;", "Lid/dana/component/dialogcomponent/CustomDialog$Builder;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "BuiltInFictitiousFunctionClassFactory", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/view/View$OnClickListener;", "readMicros", "Landroid/view/View$OnClickListener;", "getAuthRequestContext", "", "A", "Ljava/lang/CharSequence;", "PlaceComponentResult", "", "VerifyPinStateManager$executeRiskChallenge$2$1", "Z", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public static final class Builder extends CustomDialog.Builder {

        /* renamed from: A  reason: from kotlin metadata */
        private CharSequence PlaceComponentResult;

        /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
        private boolean MyBillsEntityDataFactory;

        /* renamed from: readMicros  reason: from kotlin metadata */
        private View.OnClickListener getAuthRequestContext;

        @Override // id.dana.component.dialogcomponent.CustomDialog.Builder
        public final MaterialDialog BuiltInFictitiousFunctionClassFactory() {
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.component.dialogcomponent.AgreementDialog$Builder$build$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public final void onClick(View p0) {
                    View.OnClickListener onClickListener;
                    Intrinsics.checkNotNullParameter(p0, "");
                    onClickListener = AgreementDialog.Builder.this.getAuthRequestContext;
                    if (onClickListener != null) {
                        onClickListener.onClick(p0);
                    }
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint p0) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(p0, "");
                    z = AgreementDialog.Builder.this.MyBillsEntityDataFactory;
                    p0.setUnderlineText(z);
                    p0.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(AgreementDialog.Builder.this.BuiltInFictitiousFunctionClassFactory, R.color.PlaceComponentResult));
                }
            };
            SpannableString spannableString = new SpannableString(this.PlaceComponentResult);
            spannableString.setSpan(clickableSpan, 0, spannableString.length(), 33);
            StringBuilder sb = new StringBuilder();
            sb.append(this.BuiltInFictitiousFunctionClassFactory.getString(R.string.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda6));
            sb.append(" ^1");
            this.GetContactSyncConfig = TextUtils.expandTemplate(sb.toString(), spannableString);
            MaterialDialog BuiltInFictitiousFunctionClassFactory = super.BuiltInFictitiousFunctionClassFactory();
            TextView textView = (TextView) DialogCustomViewExtKt.getCustomView(BuiltInFictitiousFunctionClassFactory).findViewById(16908304);
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            return BuiltInFictitiousFunctionClassFactory;
        }
    }
}
