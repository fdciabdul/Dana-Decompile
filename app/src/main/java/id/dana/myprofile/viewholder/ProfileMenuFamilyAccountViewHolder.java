package id.dana.myprofile.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuFamilyAccountViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuFamilyAccountViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 != null) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.getLogSourceName);
            if (textView != null) {
                String title = settingModel2.getTitle();
                if (title == null) {
                    title = "";
                }
                textView.setText(title);
                TextView textView2 = textView;
                String title2 = settingModel2.getTitle();
                textView2.setVisibility((title2 == null || StringsKt.isBlank(title2)) ^ true ? 0 : 8);
            }
            TextView textView3 = (TextView) this.itemView.findViewById(R.id.f3433minWithzrEWJaI);
            if (textView3 != null) {
                String subtitle = settingModel2.getSubtitle();
                if (subtitle == null) {
                    subtitle = "";
                }
                textView3.setText(subtitle);
                TextView textView4 = textView3;
                String subtitle2 = settingModel2.getSubtitle();
                textView4.setVisibility((subtitle2 == null || StringsKt.isBlank(subtitle2)) ^ true ? 0 : 8);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.GetLeaderboardEntryBanner);
            if (appCompatImageView != null) {
                GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(settingModel2.getIconUrl()).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_family_account).PlaceComponentResult((int) R.drawable.ic_family_account).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            }
            TextView textView5 = (TextView) this.itemView.findViewById(R.id.toOpenSansSemiBold);
            if (textView5 != null) {
                String balance = settingModel2.getBalance();
                textView5.setText(balance != null ? balance : "");
                TextView textView6 = textView5;
                String balance2 = settingModel2.getBalance();
                textView6.setVisibility((balance2 == null || StringsKt.isBlank(balance2)) ^ true ? 0 : 8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuFamilyAccountViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_profile_setting_family_account, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
