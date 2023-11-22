package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.adapter.MyProfileAdapter;
import id.dana.richview.profile.switchautoroute.SwitchAutoRouteView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuAutoSwitchViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteView;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/richview/profile/switchautoroute/SwitchAutoRouteView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuAutoSwitchViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final SwitchAutoRouteView KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.onBind(settingModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuAutoSwitchViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_menu_switch_autoroute, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        SwitchAutoRouteView switchAutoRouteView = (SwitchAutoRouteView) this.itemView.findViewById(R.id.view_autoroute_switch);
        Intrinsics.checkNotNullExpressionValue(switchAutoRouteView, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = switchAutoRouteView;
        switchAutoRouteView.setViewVisibility(false);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setSwitchButtonOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMenuAutoSwitchViewHolder.getAuthRequestContext(ProfileMenuAutoSwitchViewHolder.this, p0);
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2.setSwitchButtonOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ProfileMenuAutoSwitchViewHolder.getAuthRequestContext(ProfileMenuAutoSwitchViewHolder.this, compoundButton, z);
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(ProfileMenuAutoSwitchViewHolder profileMenuAutoSwitchViewHolder, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(profileMenuAutoSwitchViewHolder, "");
        SwitchAutoRouteView switchAutoRouteView = profileMenuAutoSwitchViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(compoundButton, "");
        switchAutoRouteView.onCheckedChange(compoundButton, z);
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> bindingAdapter = profileMenuAutoSwitchViewHolder.getBindingAdapter();
        if (bindingAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.adapter.MyProfileAdapter");
        }
        MyProfileAdapter myProfileAdapter = (MyProfileAdapter) bindingAdapter;
        if (profileMenuAutoSwitchViewHolder.getBindingAdapterPosition() >= 0) {
            myProfileAdapter.getItems().get(profileMenuAutoSwitchViewHolder.getBindingAdapterPosition()).setAutoRouteSwitch(z);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ProfileMenuAutoSwitchViewHolder profileMenuAutoSwitchViewHolder, BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(profileMenuAutoSwitchViewHolder, "");
        if (profileMenuAutoSwitchViewHolder.getBindingAdapterPosition() < 0 || onItemClickListener == null) {
            return;
        }
        onItemClickListener.onItemClick(profileMenuAutoSwitchViewHolder.getBindingAdapterPosition());
    }
}
