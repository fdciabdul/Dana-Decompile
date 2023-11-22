package id.dana.dialog;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class DialogTncInformation_ViewBinding implements Unbinder {
    private DialogTncInformation getAuthRequestContext;

    public DialogTncInformation_ViewBinding(DialogTncInformation dialogTncInformation, View view) {
        this.getAuthRequestContext = dialogTncInformation;
        dialogTncInformation.btnTncOk = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_tnc_ok, "field 'btnTncOk'", Button.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DialogTncInformation dialogTncInformation = this.getAuthRequestContext;
        if (dialogTncInformation == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        dialogTncInformation.btnTncOk = null;
    }
}
