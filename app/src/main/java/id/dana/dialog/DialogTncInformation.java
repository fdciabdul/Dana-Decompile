package id.dana.dialog;

import android.widget.Button;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;

/* loaded from: classes8.dex */
public class DialogTncInformation extends BaseMaterialDialog<Builder> {
    @BindView(R.id.btn_tnc_ok)
    Button btnTncOk;

    /* loaded from: classes8.dex */
    public static class Builder extends BaseMaterialDialog.Cancellation {
    }
}
