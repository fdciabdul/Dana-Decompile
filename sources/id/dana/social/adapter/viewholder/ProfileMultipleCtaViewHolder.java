package id.dana.social.adapter.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.ResourceUtil;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.social.utils.FeedsContentUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/viewholder/ProfileMultipleCtaViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMultipleCtaViewHolder extends BaseRecyclerViewHolder<ProfileCtaConfig> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ProfileCtaConfig profileCtaConfig) {
        String titleEn;
        ProfileCtaConfig profileCtaConfig2 = profileCtaConfig;
        Intrinsics.checkNotNullParameter(profileCtaConfig2, "");
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(profileCtaConfig2.getIcon()).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.GlobalSearchFragment_MembersInjector)));
        FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
        String BuiltInFictitiousFunctionClassFactory = FeedsContentUtils.BuiltInFictitiousFunctionClassFactory(profileCtaConfig2.getKey(), "_multiple");
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        if (!LocaleUtil.PlaceComponentResult() ? (titleEn = profileCtaConfig2.getTitleEn()) == null : (titleEn = profileCtaConfig2.getTitleId()) == null) {
            titleEn = "";
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.res_0x7f0a140e_devicelimiterrorfragment_danaloadingdialog_2);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        appCompatTextView.setText(ResourceUtil.KClassImpl$Data$declaredNonStaticMembers$2(context, BuiltInFictitiousFunctionClassFactory, titleEn));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMultipleCtaViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_profile_multiple_cta, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
