package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuSettingMoreViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuSettingMoreViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        this.itemView.setVisibility(0);
        if (settingModel2 != null) {
            View view = this.itemView;
            view.setVisibility(0);
            view.setContentDescription(view.getContext().getString(R.string.lbl_profile_settings));
            TextView textView = (TextView) view.findViewById(R.id.setDrawValueAboveBar);
            if (textView != null) {
                String title = settingModel2.getTitle();
                if (title == null) {
                    title = "";
                }
                textView.setText(title);
            }
            String subtitle = settingModel2.getSubtitle();
            if (!(subtitle == null || subtitle.length() == 0)) {
                TextView textView2 = (TextView) view.findViewById(R.id.paramsForAnalyticsIntent);
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = (TextView) view.findViewById(R.id.paramsForAnalyticsIntent);
                if (textView3 != null) {
                    textView3.setText(settingModel2.getSubtitle());
                    return;
                }
                return;
            }
            TextView textView4 = (TextView) view.findViewById(R.id.paramsForAnalyticsIntent);
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuSettingMoreViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_profile_setting_more, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuSettingMoreViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMenuSettingMoreViewHolder.MyBillsEntityDataFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, ProfileMenuSettingMoreViewHolder profileMenuSettingMoreViewHolder) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        Intrinsics.checkNotNullParameter(profileMenuSettingMoreViewHolder, "");
        onItemClickListener.onItemClick(profileMenuSettingMoreViewHolder.getAdapterPosition());
    }
}
