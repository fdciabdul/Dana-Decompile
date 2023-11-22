package id.dana.scanner;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import id.dana.R;
import id.dana.base.extension.UnbinderKtx;

/* loaded from: classes9.dex */
public class ScannerMaterialDialog {
    Unbinder MyBillsEntityDataFactory;
    public MaterialDialog getAuthRequestContext;
    @BindView(R.id.tv_error_msg)
    TextView tvErrorMsg;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    public ScannerMaterialDialog(Context context, DialogInterface.OnDismissListener onDismissListener, String str) {
        View inflate = View.inflate(context, R.layout.dialog_failed_scan, null);
        MaterialDialog materialDialog = new MaterialDialog(context, MaterialDialog.getDEFAULT_BEHAVIOR());
        this.getAuthRequestContext = materialDialog;
        materialDialog.setOnDismissListener(onDismissListener);
        DialogCustomViewExtKt.customView(this.getAuthRequestContext, null, inflate, false, false, false, false);
        ButterKnife.BuiltInFictitiousFunctionClassFactory(inflate, inflate);
        this.MyBillsEntityDataFactory = ButterKnife.BuiltInFictitiousFunctionClassFactory(this, inflate);
        this.tvSubmit.setOnClickListener(new View.OnClickListener() { // from class: id.dana.scanner.ScannerMaterialDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScannerMaterialDialog scannerMaterialDialog = ScannerMaterialDialog.this;
                if (scannerMaterialDialog.getAuthRequestContext.isShowing()) {
                    scannerMaterialDialog.getAuthRequestContext.dismiss();
                    UnbinderKtx.MyBillsEntityDataFactory(scannerMaterialDialog.MyBillsEntityDataFactory);
                }
            }
        });
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.tvErrorMsg.setText(str);
    }
}
