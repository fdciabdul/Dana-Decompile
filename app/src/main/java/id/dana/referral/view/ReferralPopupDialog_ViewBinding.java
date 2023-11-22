package id.dana.referral.view;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ReferralPopupDialog_ViewBinding implements Unbinder {
    private ReferralPopupDialog BuiltInFictitiousFunctionClassFactory;

    public ReferralPopupDialog_ViewBinding(ReferralPopupDialog referralPopupDialog, View view) {
        this.BuiltInFictitiousFunctionClassFactory = referralPopupDialog;
        referralPopupDialog.tvTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        referralPopupDialog.tvDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_description, "field 'tvDescription'", TextView.class);
        referralPopupDialog.btnPrimaryAction = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_primary_action, "field 'btnPrimaryAction'", Button.class);
        referralPopupDialog.btnSecondaryAction = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_secondary_action, "field 'btnSecondaryAction'", Button.class);
        referralPopupDialog.cbDialogReferral = (CheckBox) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cb_dialog_referral, "field 'cbDialogReferral'", CheckBox.class);
        referralPopupDialog.tvCheckboxDescription = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_checkbox_description, "field 'tvCheckboxDescription'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ReferralPopupDialog referralPopupDialog = this.BuiltInFictitiousFunctionClassFactory;
        if (referralPopupDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        referralPopupDialog.tvTitle = null;
        referralPopupDialog.tvDescription = null;
        referralPopupDialog.btnPrimaryAction = null;
        referralPopupDialog.btnSecondaryAction = null;
        referralPopupDialog.cbDialogReferral = null;
        referralPopupDialog.tvCheckboxDescription = null;
    }
}
