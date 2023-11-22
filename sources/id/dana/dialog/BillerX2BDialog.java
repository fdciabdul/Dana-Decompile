package id.dana.dialog;

import android.content.Context;
import android.content.DialogInterface;
import id.dana.R;
import id.dana.dialog.DialogWithImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0006\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\t"}, d2 = {"Lid/dana/dialog/BillerX2BDialog;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface$OnClickListener;", "PlaceComponentResult", "p0", "p1", "<init>", "(Landroid/content/Context;Landroid/content/DialogInterface$OnClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BillerX2BDialog {
    public final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DialogInterface.OnClickListener PlaceComponentResult;

    public BillerX2BDialog(Context context, DialogInterface.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(onClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = onClickListener;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.MyBillsEntityDataFactory = R.drawable.ic_allbiller_x2b;
        builder.moveToNextValue = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.allbiller_x2b_title);
        builder.PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.allbiller_x2b_desc);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.BuiltInFictitiousFunctionClassFactory.getString(R.string.allbiller_x2b_button);
        builder.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult;
        new DialogWithImage(this.BuiltInFictitiousFunctionClassFactory, builder.lookAheadTest, builder, (byte) 0).MyBillsEntityDataFactory();
    }
}
