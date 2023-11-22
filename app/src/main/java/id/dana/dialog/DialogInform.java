package id.dana.dialog;

import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseMaterialDialog;

/* loaded from: classes8.dex */
public class DialogInform extends BaseMaterialDialog<Void> {
    @BindView(R.id.btn_left)
    TextView btnLeft;
    @BindView(R.id.btn_right)
    TextView btnRight;
    @BindView(R.id.tv_body)
    TextView tvBody;
    @BindView(R.id.f4415tv_header)
    TextView tvHeader;

    /* loaded from: classes8.dex */
    public static class Builder {
    }

    /* loaded from: classes8.dex */
    static class TextModel {
    }
}
