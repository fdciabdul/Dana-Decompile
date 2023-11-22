package id.dana.myprofile;

import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.afollestad.materialdialogs.MaterialDialog;
import id.dana.R;
import id.dana.base.extension.UnbinderKtx;
import id.dana.danah5.DanaH5;

/* loaded from: classes9.dex */
class H5InputDialog {
    private MaterialDialog MyBillsEntityDataFactory;
    @BindView(R.id.et_inputUrl)
    EditText etInputUrl;
    private Unbinder getAuthRequestContext;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_go)
    TextView tvGo;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.tv_go})
    public void onGoClick() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(this.etInputUrl.getText().toString());
        DanaH5.startContainerFullUrl(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.tv_cancel})
    public void onCancelClick() {
        if (this.MyBillsEntityDataFactory.isShowing()) {
            this.MyBillsEntityDataFactory.dismiss();
            UnbinderKtx.MyBillsEntityDataFactory(this.getAuthRequestContext);
        }
    }
}
