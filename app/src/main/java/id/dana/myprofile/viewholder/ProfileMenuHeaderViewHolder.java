package id.dana.myprofile.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;

/* loaded from: classes5.dex */
public class ProfileMenuHeaderViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @BindView(R.id.tv_header_menu)
    TextView headerMenu;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(SettingModel settingModel) {
        this.headerMenu.setText(settingModel.getTitle());
    }

    public ProfileMenuHeaderViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_header, viewGroup);
    }
}
