package id.dana.myprofile.viewholder;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0004\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuShareFeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/View;", "", "getAuthRequestContext", "(Landroid/view/View;Z)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuShareFeedViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 != null) {
            View view = this.itemView;
            ((TextView) view.findViewById(R.id.setDrawValueAboveBar)).setText(settingModel2.getTitle());
            ((SwitchCompat) view.findViewById(R.id.sb_share_feed)).setChecked(settingModel2.isShareFeed());
            Intrinsics.checkNotNullExpressionValue(view, "");
            getAuthRequestContext(view, settingModel2.isShareFeed());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuShareFeedViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_menu_share_feed_view, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        final View view = this.itemView;
        ((SwitchCompat) view.findViewById(R.id.sb_share_feed)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuShareFeedViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ProfileMenuShareFeedViewHolder.PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener.this, this);
            }
        });
        ((SwitchCompat) view.findViewById(R.id.sb_share_feed)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuShareFeedViewHolder$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ProfileMenuShareFeedViewHolder.MyBillsEntityDataFactory(ProfileMenuShareFeedViewHolder.this, view, z);
            }
        });
    }

    private static void getAuthRequestContext(View view, boolean z) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        SwitchCompat switchCompat = (SwitchCompat) view.findViewById(R.id.sb_share_feed);
        Intrinsics.checkNotNullExpressionValue(switchCompat, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0.getResources(), R.color.colorWhite, switchCompat.getContext().getTheme());
        switchCompat.setThumbTintList(KClassImpl$Data$declaredNonStaticMembers$2);
        switchCompat.setTrackTintList(z ? ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r3.getResources(), R.color.azure, switchCompat.getContext().getTheme()) : ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r3.getResources(), R.color.f27012131100470, switchCompat.getContext().getTheme()));
    }

    public static /* synthetic */ void PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, ProfileMenuShareFeedViewHolder profileMenuShareFeedViewHolder) {
        Intrinsics.checkNotNullParameter(profileMenuShareFeedViewHolder, "");
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(profileMenuShareFeedViewHolder.getAdapterPosition());
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ProfileMenuShareFeedViewHolder profileMenuShareFeedViewHolder, View view, boolean z) {
        Intrinsics.checkNotNullParameter(profileMenuShareFeedViewHolder, "");
        Intrinsics.checkNotNullParameter(view, "");
        getAuthRequestContext(view, z);
    }
}
