package id.dana.social.adapter;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.social.model.FeedViewHolderModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/EmptyStateViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "getAuthRequestContext", "p0", "Lid/dana/social/adapter/SocialFeedClickListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyStateViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* bridge */ /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateViewHolder(ViewGroup viewGroup, final SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.view_social_feeds_empty_state, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.getAuthRequestContext = viewGroup;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) this.itemView.findViewById(R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a0127);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.EmptyStateViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EmptyStateViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(SocialFeedClickListener.this);
                }
            });
            danaButtonPrimaryView.setVisibility(0);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SocialFeedClickListener socialFeedClickListener) {
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        socialFeedClickListener.getAuthRequestContext();
    }
}
