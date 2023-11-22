package id.dana.social.adapter;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.constant.FeedContentType;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.utils.FeedsContentUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/FeedNotificationViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/social/adapter/SocialFeedClickListener;", "PlaceComponentResult", "Lid/dana/social/adapter/SocialFeedClickListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedNotificationViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SocialFeedClickListener MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        FeedModel feedModel;
        Spannable PlaceComponentResult;
        List<FeedModel> list;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        if (feedViewHolderModel2 != null) {
            if (feedViewHolderModel2.MyBillsEntityDataFactory == null) {
                GroupedFeedModel groupedFeedModel = feedViewHolderModel2.BuiltInFictitiousFunctionClassFactory;
                feedModel = (groupedFeedModel == null || (list = groupedFeedModel.BuiltInFictitiousFunctionClassFactory) == null) ? null : (FeedModel) CollectionsKt.firstOrNull((List) list);
            } else {
                feedModel = feedViewHolderModel2.MyBillsEntityDataFactory;
            }
            if (feedModel != null) {
                View view = this.itemView;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_feed_notification);
                if (constraintLayout != null) {
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    if (!feedModel.getNewProxyInstance()) {
                        constraintLayout.setContentDescription(constraintLayout.getResources().getString(R.string.lblHighlightedNotif));
                        constraintLayout.setBackground(ContextCompat.PlaceComponentResult(constraintLayout.getContext(), (int) R.color.f27132131100503));
                    } else {
                        constraintLayout.setContentDescription(constraintLayout.getResources().getString(R.string.lblNotif));
                        constraintLayout.setBackground(null);
                    }
                }
                TextView textView = (TextView) view.findViewById(R.id.In);
                if (textView != null) {
                    FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    PlaceComponentResult = FeedsContentUtils.PlaceComponentResult(feedViewHolderModel2.getAuthRequestContext(context, this.MyBillsEntityDataFactory), true, true);
                    textView.setText(PlaceComponentResult);
                }
                TextView textView2 = (TextView) view.findViewById(R.id.saveMonthOfFetchFreeTransfer);
                if (textView2 != null) {
                    textView2.setText(feedModel.moveToNextValue);
                }
                CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.civ_view_feed_notif_badge);
                if (circleImageView != null) {
                    FeedContentType.Companion companion = FeedContentType.INSTANCE;
                    String str = feedModel.PlaceComponentResult;
                    if (str == null) {
                        str = "";
                    }
                    int MyBillsEntityDataFactory = FeedContentType.Companion.MyBillsEntityDataFactory(str);
                    if (circleImageView instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(circleImageView, MyBillsEntityDataFactory);
                    } else {
                        circleImageView.setImageResource(MyBillsEntityDataFactory);
                    }
                }
                CircleImageView circleImageView2 = (CircleImageView) view.findViewById(R.id.civ_profile_avatar);
                if (circleImageView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(circleImageView2, "");
                    FeedsContentUtils feedsContentUtils2 = FeedsContentUtils.MyBillsEntityDataFactory;
                    SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView2, FeedsContentUtils.BuiltInFictitiousFunctionClassFactory(feedViewHolderModel2), R.drawable.avatar_placeholder);
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_feed_notification);
                if (constraintLayout2 != null) {
                    constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.FeedNotificationViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            FeedNotificationViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(FeedNotificationViewHolder.this);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedNotificationViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.item_feed_notification, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.MyBillsEntityDataFactory = socialFeedClickListener;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedNotificationViewHolder feedNotificationViewHolder) {
        Intrinsics.checkNotNullParameter(feedNotificationViewHolder, "");
        if (feedNotificationViewHolder.getBindingAdapterPosition() >= 0) {
            feedNotificationViewHolder.MyBillsEntityDataFactory.MyBillsEntityDataFactory(feedNotificationViewHolder.getBindingAdapterPosition());
        }
    }
}
