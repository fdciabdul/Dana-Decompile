package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B!\b\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\t"}, d2 = {"Lid/dana/dialog/CVVInfoDialog;", "Lid/dana/base/BaseMaterialDialog;", "Lid/dana/dialog/CVVInfoDialog$Builder;", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "getAuthRequestContext", "Lid/dana/component/buttoncomponent/DanaButtonPrimaryView;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/TextView;", "PlaceComponentResult", "Landroid/widget/TextView;", "MyBillsEntityDataFactory", "scheduleImpl", "Landroid/content/Context;", "p0", "p1", "Landroid/content/DialogInterface$OnDismissListener;", "p2", "<init>", "(Landroid/content/Context;Lid/dana/dialog/CVVInfoDialog$Builder;Landroid/content/DialogInterface$OnDismissListener;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CVVInfoDialog extends BaseMaterialDialog<Builder> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private TextView MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private DanaButtonPrimaryView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TextView getAuthRequestContext;

    public /* synthetic */ CVVInfoDialog(Context context, Builder builder, DialogInterface.OnDismissListener onDismissListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, builder, onDismissListener);
    }

    @Override // id.dana.base.BaseMaterialDialog
    public final /* synthetic */ void getAuthRequestContext(View view, Builder builder) {
        DanaButtonPrimaryView danaButtonPrimaryView;
        Builder builder2 = builder;
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(builder2, "");
        if (view != null) {
            this.getAuthRequestContext = (TextView) view.findViewById(R.id.tvDialogTitle);
            this.MyBillsEntityDataFactory = (TextView) view.findViewById(R.id.tvDialogDescription);
            this.BuiltInFictitiousFunctionClassFactory = (DanaButtonPrimaryView) view.findViewById(R.id.f3481btnOk);
        }
        TextView textView = this.getAuthRequestContext;
        if (textView != null) {
            String str = builder2.MyBillsEntityDataFactory;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
        }
        TextView textView2 = this.MyBillsEntityDataFactory;
        if (textView2 != null) {
            String str2 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
            textView2.setText(str2 != null ? str2 : "");
        }
        View.OnClickListener onClickListener = builder2.getAuthRequestContext;
        if (onClickListener == null || (danaButtonPrimaryView = this.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        danaButtonPrimaryView.setOnClickListener(onClickListener);
    }

    private CVVInfoDialog(Context context, Builder builder, DialogInterface.OnDismissListener onDismissListener) {
        super(context, onDismissListener, Integer.valueOf((int) R.layout.dialog_cvv_info), builder);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0016X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0014\u0010\n\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0014"}, d2 = {"Lid/dana/dialog/CVVInfoDialog$Builder;", "Lid/dana/base/BaseMaterialDialog$Cancellation;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/dialog/CVVInfoDialog$Builder;", "", "toString", "()Ljava/lang/String;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "PlaceComponentResult", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "p1", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnDismissListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Builder extends BaseMaterialDialog.Cancellation {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final DialogInterface.OnDismissListener BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final Context PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public View.OnClickListener getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Builder) {
                Builder builder = (Builder) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, builder.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, builder.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (this.PlaceComponentResult.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Builder(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public Builder(Context context, DialogInterface.OnDismissListener onDismissListener) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(onDismissListener, "");
            this.PlaceComponentResult = context;
            this.BuiltInFictitiousFunctionClassFactory = onDismissListener;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory() {
            BuiltInFictitiousFunctionClassFactory(false);
            return this;
        }
    }
}
