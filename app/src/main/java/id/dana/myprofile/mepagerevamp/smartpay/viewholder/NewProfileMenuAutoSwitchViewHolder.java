package id.dana.myprofile.mepagerevamp.smartpay.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.smartpay.adapter.SmartPaySettingsAdapter;
import id.dana.myprofile.mepagerevamp.smartpay.view.NewSwitchAutoRouteView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/viewholder/NewProfileMenuAutoSwitchViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/myprofile/mepagerevamp/smartpay/view/NewSwitchAutoRouteView;", "getAuthRequestContext", "Lid/dana/myprofile/mepagerevamp/smartpay/view/NewSwitchAutoRouteView;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileMenuAutoSwitchViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final NewSwitchAutoRouteView MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        this.MyBillsEntityDataFactory.onBind(settingModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileMenuAutoSwitchViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.new_item_menu_switch_autoroute, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        NewSwitchAutoRouteView newSwitchAutoRouteView = (NewSwitchAutoRouteView) this.itemView.findViewById(R.id.view_autoroute_switch);
        Intrinsics.checkNotNullExpressionValue(newSwitchAutoRouteView, "");
        this.MyBillsEntityDataFactory = newSwitchAutoRouteView;
        newSwitchAutoRouteView.setViewVisibility(false);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.MyBillsEntityDataFactory.setSwitchButtonOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.viewholder.NewProfileMenuAutoSwitchViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewProfileMenuAutoSwitchViewHolder.PlaceComponentResult(NewProfileMenuAutoSwitchViewHolder.this, p0);
            }
        });
        this.MyBillsEntityDataFactory.setSwitchButtonOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.viewholder.NewProfileMenuAutoSwitchViewHolder$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NewProfileMenuAutoSwitchViewHolder.PlaceComponentResult(NewProfileMenuAutoSwitchViewHolder.this, compoundButton, z);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(NewProfileMenuAutoSwitchViewHolder newProfileMenuAutoSwitchViewHolder, BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        Intrinsics.checkNotNullParameter(newProfileMenuAutoSwitchViewHolder, "");
        if (newProfileMenuAutoSwitchViewHolder.getBindingAdapterPosition() < 0 || onItemClickListener == null) {
            return;
        }
        onItemClickListener.onItemClick(newProfileMenuAutoSwitchViewHolder.getBindingAdapterPosition());
    }

    public static /* synthetic */ void PlaceComponentResult(NewProfileMenuAutoSwitchViewHolder newProfileMenuAutoSwitchViewHolder, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(newProfileMenuAutoSwitchViewHolder, "");
        NewSwitchAutoRouteView newSwitchAutoRouteView = newProfileMenuAutoSwitchViewHolder.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(compoundButton, "");
        newSwitchAutoRouteView.onCheckedChange(compoundButton, z);
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> bindingAdapter = newProfileMenuAutoSwitchViewHolder.getBindingAdapter();
        if (bindingAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.smartpay.adapter.SmartPaySettingsAdapter");
        }
        SmartPaySettingsAdapter smartPaySettingsAdapter = (SmartPaySettingsAdapter) bindingAdapter;
        if (newProfileMenuAutoSwitchViewHolder.getBindingAdapterPosition() >= 0) {
            smartPaySettingsAdapter.getItems().get(newProfileMenuAutoSwitchViewHolder.getBindingAdapterPosition()).setAutoRouteSwitch(z);
        }
    }
}
