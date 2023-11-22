package id.dana.myprofile.viewholder;

import android.view.ViewGroup;
import com.alipay.iap.android.wallet.acl.oauth.OAuthService;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.social.view.UsernameView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuUsernameViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuUsernameViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        String username;
        SettingModel settingModel2 = settingModel;
        super.bindData(settingModel2);
        if (settingModel2 == null || (username = settingModel2.getUsername()) == null) {
            return;
        }
        if (!(username.length() > 0) || StringsKt.equals(username, OAuthService.SCOPE_USER_NAME, true)) {
            return;
        }
        UsernameView usernameView = (UsernameView) this.itemView.findViewById(R.id.view_username);
        if (usernameView != null) {
            usernameView.hideUsernameEmptyState();
        }
        UsernameView usernameView2 = (UsernameView) this.itemView.findViewById(R.id.view_username);
        if (usernameView2 != null) {
            usernameView2.setUsername(username);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuUsernameViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_profile_username, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
