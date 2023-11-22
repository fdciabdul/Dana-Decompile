package id.dana.social.view;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.request.BaseRequestOptions;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import id.dana.utils.ImageResize;
import id.dana.utils.UrlUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/view/ActivityReactionsItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/ActivityReactionsUserModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionsItemViewHolder extends BaseRecyclerViewHolder<ActivityReactionsUserModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ActivityReactionsUserModel activityReactionsUserModel) {
        ActivityReactionsUserModel activityReactionsUserModel2 = activityReactionsUserModel;
        Intrinsics.checkNotNullParameter(activityReactionsUserModel2, "");
        TextView textView = (TextView) this.itemView.findViewById(R.id.tv_reactor_display_name);
        if (textView != null) {
            textView.setText(activityReactionsUserModel2.BuiltInFictitiousFunctionClassFactory());
        }
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.res_0x7f0a0bff_itemkeyeddatasource_map_2);
        if (imageView != null) {
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            String str = activityReactionsUserModel2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullParameter(imageView, "");
            if (str != null) {
                GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(UrlUtil.getAuthRequestContext(str)).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_avatar_grey_default).PlaceComponentResult((int) R.drawable.ic_avatar_grey_default).MyBillsEntityDataFactory(imageView);
            } else {
                InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_avatar_grey_default);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityReactionsItemViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_activity_reactions_list, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
