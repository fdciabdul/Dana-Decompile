package id.dana.richview.moreforyou.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.ethanhua.skeleton.SkeletonScreen;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.richview.moreforyou.model.MoreForYouModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/richview/moreforyou/viewholder/MoreForYouItem;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/richview/moreforyou/model/MoreForYouModel;", "data", "", "bindData", "(Lid/dana/richview/moreforyou/model/MoreForYouModel;)V", "bindImage", "bindText", "", CdpConstants.CONTENT_CORNER_RADIUS, "I", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getSkeletonScreen", "()Lcom/ethanhua/skeleton/SkeletonScreen;", "setSkeletonScreen", "(Lcom/ethanhua/skeleton/SkeletonScreen;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoreForYouItem extends BaseRecyclerViewHolder<MoreForYouModel> {
    public static final int CORNER_RADIUS_DP = 8;
    private final int cornerRadius;
    public SkeletonScreen skeletonScreen;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreForYouItem(Context context, ViewGroup viewGroup) {
        super(context, R.layout.item_more_for_you, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.cornerRadius = (int) (context.getResources().getDisplayMetrics().density * 8.0f);
    }

    @JvmName(name = "getSkeletonScreen")
    public final SkeletonScreen getSkeletonScreen() {
        SkeletonScreen skeletonScreen = this.skeletonScreen;
        if (skeletonScreen != null) {
            return skeletonScreen;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSkeletonScreen")
    public final void setSkeletonScreen(SkeletonScreen skeletonScreen) {
        Intrinsics.checkNotNullParameter(skeletonScreen, "");
        this.skeletonScreen = skeletonScreen;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(MoreForYouModel data) {
        Intrinsics.checkNotNullParameter(data, "");
        bindImage(data);
        bindText(data);
    }

    private final void bindImage(MoreForYouModel data) {
        Object icon;
        if (data.getLocalIconId() != null) {
            Integer localIconId = data.getLocalIconId();
            Intrinsics.checkNotNull(localIconId);
            if (localIconId.intValue() >= 0) {
                Integer localIconId2 = data.getLocalIconId();
                if (localIconId2 != null && localIconId2.intValue() == R.drawable.csat_survey_banner) {
                    ((TextView) this.itemView.findViewById(R.id.tv_widget_title)).setTextColor(-16777216);
                    ((TextView) this.itemView.findViewById(R.id.tv_widget_subtitle)).setTextColor(-16777216);
                }
                icon = data.getLocalIconId();
                GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory(icon).PlaceComponentResult(new CenterCrop(), new RoundedCornersTransformation(this.cornerRadius, 0)).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.res_0x7f0a0b17_daggernewpromocentercomponent_newpromocentercomponentimpl_oauthrepositoryprovider)));
            }
        }
        icon = data.getIcon();
        GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory(icon).PlaceComponentResult(new CenterCrop(), new RoundedCornersTransformation(this.cornerRadius, 0)).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) this.itemView.findViewById(R.id.res_0x7f0a0b17_daggernewpromocentercomponent_newpromocentercomponentimpl_oauthrepositoryprovider)));
    }

    private final void bindText(MoreForYouModel data) {
        TextView textView = (TextView) this.itemView.findViewById(R.id.tv_widget_title);
        if (textView != null) {
            textView.setText(data.getTitle());
        }
        TextView textView2 = (TextView) this.itemView.findViewById(R.id.tv_widget_subtitle);
        if (textView2 != null) {
            textView2.setText(data.getSubtitle());
        }
    }
}
