package id.dana.dialog;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class DialogInform_ViewBinding implements Unbinder {
    private DialogInform KClassImpl$Data$declaredNonStaticMembers$2;

    public DialogInform_ViewBinding(DialogInform dialogInform, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = dialogInform;
        dialogInform.btnLeft = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_left, "field 'btnLeft'", TextView.class);
        dialogInform.btnRight = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_right, "field 'btnRight'", TextView.class);
        dialogInform.tvBody = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_body, "field 'tvBody'", TextView.class);
        dialogInform.tvHeader = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4415tv_header, "field 'tvHeader'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        DialogInform dialogInform = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (dialogInform == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        dialogInform.btnLeft = null;
        dialogInform.btnRight = null;
        dialogInform.tvBody = null;
        dialogInform.tvHeader = null;
    }
}
