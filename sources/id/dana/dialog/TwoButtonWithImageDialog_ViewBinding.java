package id.dana.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.richview.LogoProgressView;

/* loaded from: classes8.dex */
public class TwoButtonWithImageDialog_ViewBinding implements Unbinder {
    private TwoButtonWithImageDialog BuiltInFictitiousFunctionClassFactory;

    public TwoButtonWithImageDialog_ViewBinding(TwoButtonWithImageDialog twoButtonWithImageDialog, View view) {
        this.BuiltInFictitiousFunctionClassFactory = twoButtonWithImageDialog;
        twoButtonWithImageDialog.ivImage = (ImageView) Utils.PlaceComponentResult(view, R.id.iv_image, "field 'ivImage'", ImageView.class);
        twoButtonWithImageDialog.tvTitle = (TextView) Utils.PlaceComponentResult(view, R.id.tv_title, "field 'tvTitle'", TextView.class);
        twoButtonWithImageDialog.tvMessage = (TextView) Utils.PlaceComponentResult(view, R.id.tv_description, "field 'tvMessage'", TextView.class);
        twoButtonWithImageDialog.btnNegative = (Button) Utils.PlaceComponentResult(view, R.id.btn_negative, "field 'btnNegative'", Button.class);
        twoButtonWithImageDialog.btnNegativeGhost = (Button) Utils.PlaceComponentResult(view, R.id.btn_negative_ghost, "field 'btnNegativeGhost'", Button.class);
        twoButtonWithImageDialog.btnPositive = (Button) Utils.PlaceComponentResult(view, R.id.btn_positive, "field 'btnPositive'", Button.class);
        twoButtonWithImageDialog.lpvLoading = (LogoProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.lpv_loading_dialog, "field 'lpvLoading'", LogoProgressView.class);
        twoButtonWithImageDialog.cbNoDialogAnymore = (DanaCheckboxButtonView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cb_no_dialog_anymore, "field 'cbNoDialogAnymore'", DanaCheckboxButtonView.class);
        twoButtonWithImageDialog.tvDialogFooterText = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_dialog_footer_text, "field 'tvDialogFooterText'", TextView.class);
        twoButtonWithImageDialog.cvLayout = (CardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.card_view, "field 'cvLayout'", CardView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        TwoButtonWithImageDialog twoButtonWithImageDialog = this.BuiltInFictitiousFunctionClassFactory;
        if (twoButtonWithImageDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        twoButtonWithImageDialog.ivImage = null;
        twoButtonWithImageDialog.tvTitle = null;
        twoButtonWithImageDialog.tvMessage = null;
        twoButtonWithImageDialog.btnNegative = null;
        twoButtonWithImageDialog.btnNegativeGhost = null;
        twoButtonWithImageDialog.btnPositive = null;
        twoButtonWithImageDialog.lpvLoading = null;
        twoButtonWithImageDialog.cbNoDialogAnymore = null;
        twoButtonWithImageDialog.tvDialogFooterText = null;
        twoButtonWithImageDialog.cvLayout = null;
    }
}
