package id.dana.core.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Window;
import id.dana.core.ui.databinding.DialogDanaLoadingBinding;
import id.dana.core.ui.util.ContextUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012"}, d2 = {"Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "", "", "PlaceComponentResult", "()V", "Lid/dana/core/ui/databinding/DialogDanaLoadingBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/databinding/DialogDanaLoadingBinding;", "getAuthRequestContext", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/core/ui/dialog/DanaLogoProgressView;", "MyBillsEntityDataFactory", "Lid/dana/core/ui/dialog/DanaLogoProgressView;", "Landroid/app/Dialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/app/Dialog;", "", "Z", "p0", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaLogoLoadingDialog {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private DialogDanaLoadingBinding getAuthRequestContext;
    public Dialog KClassImpl$Data$declaredNonStaticMembers$2;
    public DanaLogoProgressView MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    public DanaLogoLoadingDialog(Context context) {
        Window window;
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
        this.getAuthRequestContext = DialogDanaLoadingBinding.getAuthRequestContext(LayoutInflater.from(context));
        Dialog dialog = new Dialog(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dialog;
        dialog.requestWindowFeature(1);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setCanceledOnTouchOutside(false);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setCancelable(this.BuiltInFictitiousFunctionClassFactory);
        Dialog dialog2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        DialogDanaLoadingBinding dialogDanaLoadingBinding = this.getAuthRequestContext;
        if (dialogDanaLoadingBinding != null) {
            dialog2.setContentView(dialogDanaLoadingBinding.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getWindow() != null && (window = this.KClassImpl$Data$declaredNonStaticMembers$2.getWindow()) != null) {
                window.setBackgroundDrawable(null);
            }
            DialogDanaLoadingBinding dialogDanaLoadingBinding2 = this.getAuthRequestContext;
            if (dialogDanaLoadingBinding2 != null) {
                DanaLogoProgressView danaLogoProgressView = dialogDanaLoadingBinding2.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(danaLogoProgressView, "");
                this.MyBillsEntityDataFactory = danaLogoProgressView;
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void PlaceComponentResult() {
        ContextUtil contextUtil = ContextUtil.INSTANCE;
        if (ContextUtil.getAuthRequestContext(this.PlaceComponentResult) && this.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dismiss();
            this.MyBillsEntityDataFactory.stopRefresh();
            this.getAuthRequestContext = null;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }
}
