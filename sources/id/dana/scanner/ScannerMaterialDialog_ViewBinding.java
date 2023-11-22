package id.dana.scanner;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class ScannerMaterialDialog_ViewBinding implements Unbinder {
    private ScannerMaterialDialog MyBillsEntityDataFactory;

    public ScannerMaterialDialog_ViewBinding(ScannerMaterialDialog scannerMaterialDialog, View view) {
        this.MyBillsEntityDataFactory = scannerMaterialDialog;
        scannerMaterialDialog.tvErrorMsg = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_error_msg, "field 'tvErrorMsg'", TextView.class);
        scannerMaterialDialog.tvSubmit = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_submit, "field 'tvSubmit'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ScannerMaterialDialog scannerMaterialDialog = this.MyBillsEntityDataFactory;
        if (scannerMaterialDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        scannerMaterialDialog.tvErrorMsg = null;
        scannerMaterialDialog.tvSubmit = null;
    }
}
