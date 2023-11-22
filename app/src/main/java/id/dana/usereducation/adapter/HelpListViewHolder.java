package id.dana.usereducation.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.dana.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class HelpListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.description)
    TextView tvDescription;
    @BindView(R.id.title)
    TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HelpListViewHolder(View view) {
        super(view);
        ButterKnife.BuiltInFictitiousFunctionClassFactory(this, view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String MyBillsEntityDataFactory(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}
