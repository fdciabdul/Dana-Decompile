package id.dana.oauth;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.LogoProgressView;

/* loaded from: classes9.dex */
public class MatchPhoneNumberDialog_ViewBinding implements Unbinder {
    private MatchPhoneNumberDialog KClassImpl$Data$declaredNonStaticMembers$2;

    public MatchPhoneNumberDialog_ViewBinding(MatchPhoneNumberDialog matchPhoneNumberDialog, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = matchPhoneNumberDialog;
        matchPhoneNumberDialog.btnCancel = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_cancel, "field 'btnCancel'", Button.class);
        matchPhoneNumberDialog.btnLogin = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_login, "field 'btnLogin'", Button.class);
        matchPhoneNumberDialog.lpvLoading = (LogoProgressView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.lpv_loading, "field 'lpvLoading'", LogoProgressView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        MatchPhoneNumberDialog matchPhoneNumberDialog = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (matchPhoneNumberDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        matchPhoneNumberDialog.btnCancel = null;
        matchPhoneNumberDialog.btnLogin = null;
        matchPhoneNumberDialog.lpvLoading = null;
    }
}
