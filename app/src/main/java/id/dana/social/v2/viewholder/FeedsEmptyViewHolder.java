package id.dana.social.v2.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.FeedViewHolderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/v2/viewholder/FeedsEmptyViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "Lid/dana/social/adapter/SocialFeedClickListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsEmptyViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SocialFeedClickListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        super.bindData(feedViewHolderModel);
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) this.itemView.findViewById(R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a0127);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.viewholder.FeedsEmptyViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedsEmptyViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(FeedsEmptyViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsEmptyViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.view_feeds_empty, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = socialFeedClickListener;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedsEmptyViewHolder feedsEmptyViewHolder) {
        Intrinsics.checkNotNullParameter(feedsEmptyViewHolder, "");
        feedsEmptyViewHolder.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
    }
}
