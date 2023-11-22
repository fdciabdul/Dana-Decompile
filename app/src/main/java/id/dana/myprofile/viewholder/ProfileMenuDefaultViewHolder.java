package id.dana.myprofile.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;

/* loaded from: classes9.dex */
public class ProfileMenuDefaultViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @BindView(R.id.cl_normal_menu)
    ConstraintLayout clNormalMenu;
    @BindView(R.id.tv_title)
    TextView title;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 != null) {
            this.title.setText(settingModel2.getTitle());
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.clNormalMenu.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuDefaultViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onItemClickListener.onItemClick(ProfileMenuDefaultViewHolder.this.getAdapterPosition());
            }
        });
    }
}
