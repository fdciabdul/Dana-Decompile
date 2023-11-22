package id.dana.referral.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.onboarding.referral.model.ReferralEngagementDialogModel;
import id.dana.referral.view.ReferralEngagementDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/referral/view/ReferralEngagementDialog;", "Lid/dana/base/BaseMaterialDialog;", "Lid/dana/referral/view/ReferralEngagementDialog$Builder;", "", "MyBillsEntityDataFactory", "()V", "Landroid/content/Context;", "p0", "p1", "<init>", "(Landroid/content/Context;Lid/dana/referral/view/ReferralEngagementDialog$Builder;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReferralEngagementDialog extends BaseMaterialDialog<Builder> {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\"¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0003\u001a\u00020\u0006X\u0086\"¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\bX\u0086\"¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0012\u0010\t\u001a\u00020\fX\u0086\"¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0012\u0010\u000f\u001a\u00020\u000eX\u0086\"¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/referral/view/ReferralEngagementDialog$Builder;", "Lid/dana/base/BaseMaterialDialog$Cancellation;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/view/View$OnClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View$OnClickListener;", "getAuthRequestContext", "Landroid/content/DialogInterface$OnShowListener;", "Landroid/content/DialogInterface$OnShowListener;", "Lid/dana/onboarding/referral/model/ReferralEngagementDialogModel;", "MyBillsEntityDataFactory", "Lid/dana/onboarding/referral/model/ReferralEngagementDialogModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder extends BaseMaterialDialog.Cancellation {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public Context PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public View.OnClickListener getAuthRequestContext;
        public ReferralEngagementDialogModel MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public DialogInterface.OnDismissListener BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public DialogInterface.OnShowListener KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public /* synthetic */ ReferralEngagementDialog(Context context, Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, builder);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Builder builder) {
        final Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(view, "");
        if (builder2 != null) {
            ((DanaButtonPrimaryView) view.findViewById(R.id.SummaryVoucherView$$ExternalSyntheticLambda2)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.referral.view.ReferralEngagementDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReferralEngagementDialog.getAuthRequestContext(ReferralEngagementDialog.Builder.this, view2);
                }
            });
            ((TextView) view.findViewById(R.id.M)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.referral.view.ReferralEngagementDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReferralEngagementDialog.PlaceComponentResult(ReferralEngagementDialog.this);
                }
            });
            MaterialDialog materialDialog = this.BuiltInFictitiousFunctionClassFactory;
            DialogInterface.OnShowListener onShowListener = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
            ReferralEngagementDialogModel referralEngagementDialogModel = null;
            if (onShowListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                onShowListener = null;
            }
            materialDialog.setOnShowListener(onShowListener);
            ReferralEngagementDialogModel referralEngagementDialogModel2 = builder2.MyBillsEntityDataFactory;
            if (referralEngagementDialogModel2 != null) {
                referralEngagementDialogModel = referralEngagementDialogModel2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (referralEngagementDialogModel != null) {
                ((TextView) view.findViewById(R.id.getLogSourceName)).setText(referralEngagementDialogModel.BuiltInFictitiousFunctionClassFactory);
                ((TextView) view.findViewById(R.id.isHelperTextDisplayed)).setText(referralEngagementDialogModel.getAuthRequestContext);
            }
        }
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void getAuthRequestContext(Builder builder, View view) {
        Intrinsics.checkNotNullParameter(builder, "");
        View.OnClickListener onClickListener = builder.getAuthRequestContext;
        if (onClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onClickListener = null;
        }
        onClickListener.onClick(view);
    }

    public static /* synthetic */ void PlaceComponentResult(ReferralEngagementDialog referralEngagementDialog) {
        Intrinsics.checkNotNullParameter(referralEngagementDialog, "");
        referralEngagementDialog.getAuthRequestContext();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private ReferralEngagementDialog(android.content.Context r3, id.dana.referral.view.ReferralEngagementDialog.Builder r4) {
        /*
            r2 = this;
            android.content.DialogInterface$OnDismissListener r0 = r4.BuiltInFictitiousFunctionClassFactory
            if (r0 == 0) goto L5
            goto Lb
        L5:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        Lb:
            r1 = 2131558791(0x7f0d0187, float:1.8742908E38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.<init>(r3, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.referral.view.ReferralEngagementDialog.<init>(android.content.Context, id.dana.referral.view.ReferralEngagementDialog$Builder):void");
    }
}
