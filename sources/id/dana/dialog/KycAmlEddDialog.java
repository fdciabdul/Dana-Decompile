package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r"}, d2 = {"Lid/dana/dialog/KycAmlEddDialog;", "", "Landroid/content/DialogInterface$OnCancelListener;", "PlaceComponentResult", "Landroid/content/DialogInterface$OnCancelListener;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "", "Z", "getAuthRequestContext", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "p3", "<init>", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;Landroid/view/View$OnClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycAmlEddDialog {
    public final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final boolean getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final DialogInterface.OnCancelListener MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final View.OnClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    public KycAmlEddDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(onCancelListener, "");
        Intrinsics.checkNotNullParameter(onClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = z;
        this.MyBillsEntityDataFactory = onCancelListener;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onClickListener;
    }
}
