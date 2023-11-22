package id.dana.oauth;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.oauth.model.ScopeModel;

/* loaded from: classes5.dex */
public class ScopeViewHolder extends BaseRecyclerViewHolder<ScopeModel> {
    @BindView(R.id.iv_tick)
    ImageView ivTick;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_dot)
    TextView tvDot;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(ScopeModel scopeModel) {
        this.tvDescription.setText(scopeModel.PlaceComponentResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScopeViewHolder(ViewGroup viewGroup, boolean z) {
        super(viewGroup.getContext(), R.layout.item_scope, viewGroup);
        if (z) {
            this.tvDot.setVisibility(4);
            this.ivTick.setVisibility(0);
        }
    }
}
