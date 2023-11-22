package id.dana.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import id.dana.R;
import id.dana.databinding.DialogLoadingBinding;
import id.dana.utils.ContextUtil;

/* loaded from: classes2.dex */
public class LoadingDialog {
    public final MaterialDialog BuiltInFictitiousFunctionClassFactory;
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    private DialogLoadingBinding getAuthRequestContext;

    public LoadingDialog(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_loading, (ViewGroup) null);
        MaterialDialog cancelable = new MaterialDialog(context, MaterialDialog.getDEFAULT_BEHAVIOR()).cancelable(false);
        this.BuiltInFictitiousFunctionClassFactory = cancelable;
        DialogCustomViewExtKt.customView(cancelable, null, inflate, false, false, false, false);
        this.getAuthRequestContext = DialogLoadingBinding.PlaceComponentResult(inflate);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (ContextUtil.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2) && this.BuiltInFictitiousFunctionClassFactory.isShowing()) {
            try {
                this.BuiltInFictitiousFunctionClassFactory.dismiss();
            } catch (Exception unused) {
            }
            this.getAuthRequestContext = null;
        }
    }

    public final boolean MyBillsEntityDataFactory() {
        MaterialDialog materialDialog = this.BuiltInFictitiousFunctionClassFactory;
        return materialDialog != null && materialDialog.isShowing();
    }
}
