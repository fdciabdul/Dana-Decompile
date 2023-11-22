package id.dana.dialog;

import android.app.Activity;
import android.app.Dialog;
import id.dana.R;
import id.dana.richview.LogoProgressView;
import id.dana.utils.ContextUtil;

/* loaded from: classes2.dex */
public class DanaLoadingDialog {
    private Activity BuiltInFictitiousFunctionClassFactory;
    public Dialog MyBillsEntityDataFactory;
    public LogoProgressView getAuthRequestContext;

    public DanaLoadingDialog(Activity activity) {
        this.BuiltInFictitiousFunctionClassFactory = activity;
        Dialog dialog = new Dialog(this.BuiltInFictitiousFunctionClassFactory);
        this.MyBillsEntityDataFactory = dialog;
        dialog.requestWindowFeature(1);
        this.MyBillsEntityDataFactory.setCancelable(false);
        this.MyBillsEntityDataFactory.setContentView(R.layout.dialog_loading_dana);
        if (this.MyBillsEntityDataFactory.getWindow() != null) {
            this.MyBillsEntityDataFactory.getWindow().setBackgroundDrawable(null);
        }
        this.getAuthRequestContext = (LogoProgressView) this.MyBillsEntityDataFactory.findViewById(R.id.f4081progress_view);
    }

    public final void PlaceComponentResult() {
        if (ContextUtil.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory) && this.MyBillsEntityDataFactory.isShowing()) {
            this.MyBillsEntityDataFactory.dismiss();
            this.getAuthRequestContext.stopRefresh();
        }
    }
}
