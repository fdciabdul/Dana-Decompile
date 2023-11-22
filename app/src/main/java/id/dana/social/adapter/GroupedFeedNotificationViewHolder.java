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

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/adapter/GroupedFeedNotificationViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "Lid/dana/social/adapter/SocialFeedClickListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupedFeedNotificationViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {
    private final SocialFeedClickListener MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedViewHolderModel feedViewHolderModel) {
        String str;
        Spannable PlaceComponentResult;
        FeedViewHolderModel feedViewHolderModel2 = feedViewHolderModel;
        Intrinsics.checkNotNullParameter(feedViewHolderModel2, "");
        GroupedFeedModel groupedFeedModel = feedViewHolderModel2.BuiltInFictitiousFunctionClassFactory;
        if (groupedFeedModel != null) {
            FeedModel feedModel = (FeedModel) CollectionsKt.firstOrNull((List) groupedFeedModel.BuiltInFictitiousFunctionClassFactory);
            if (feedModel == null || (str = feedModel.PlaceComponentResult) == null) {
                str = "";
            }
            ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.cl_feed_notification);
            if (constraintLayout != null) {
                constraintLayout.setBackground(!groupedFeedModel.getScheduleImpl() ? ContextCompat.PlaceComponentResult(getContext(), (int) R.color.f27132131100503) : null);
            }
            CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(R.id.civ_view_feed_notif_badge);
            if (circleImageView != null) {
                FeedContentType.Companion companion = FeedContentType.INSTANCE;
                int MyBillsEntityDataFactory = FeedContentType.Companion.MyBillsEntityDataFactory(str);
                if (circleImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(circleImageView, MyBillsEntityDataFactory);
                } else {
                    circleImageView.setImageResource(MyBillsEntityDataFactory);
                }
            }
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "");
            FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
            List<String> KClassImpl$Data$declaredNonStaticMembers$2 = FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(groupedFeedModel.BuiltInFictitiousFunctionClassFactory);
            Intrinsics.checkNotNullParameter(view, "");
            Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
            if (KClassImpl$Data$declaredNonStaticMembers$2.size() > 1) {
                CircleImageView circleImageView2 = (CircleImageView) view.findViewById(R.id.civ_multiple_avatar_image_1);
                if (circleImageView2 != null) {
                    SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView2, KClassImpl$Data$declaredNonStaticMembers$2.get(0), R.drawable.avatar_placeholder);
                }
                CircleImageView circleImageView3 = (CircleImageView) view.findViewById(R.id.civ_multiple_avatar_image_2);
                if (circleImageView3 != null) {
                    SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView3, KClassImpl$Data$declaredNonStaticMembers$2.get(1), R.drawable.avatar_placeholder);
                }
            } else if (KClassImpl$Data$declaredNonStaticMembers$2.size() == 1) {
                CircleImageView circleImageView4 = (CircleImageView) view.findViewById(R.id.civ_multiple_avatar_image_1);
                if (circleImageView4 != null) {
                    SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView4, KClassImpl$Data$declaredNonStaticMembers$2.get(0), R.drawable.avatar_placeholder);
                }
                CircleImageView circleImageView5 = (CircleImageView) view.findViewById(R.id.civ_multiple_avatar_image_2);
                if (circleImageView5 != null) {
                    SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView5, KClassImpl$Data$declaredNonStaticMembers$2.get(0), R.drawable.avatar_placeholder);
                }
            }
            FeedsContentUtils feedsContentUtils2 = FeedsContentUtils.MyBillsEntityDataFactory;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            FeedsContentUtils.MyBillsEntityDataFactory(context, groupedFeedModel);
            TextView textView = (TextView) this.itemView.findViewById(R.id.In);
            if (textView != null) {
                FeedsContentUtils feedsContentUtils3 = FeedsContentUtils.MyBillsEntityDataFactory;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                PlaceComponentResult = FeedsContentUtils.PlaceComponentResult(feedViewHolderModel2.getAuthRequestContext(context2, this.MyBillsEntityDataFactory), true, true);
                textView.setText(PlaceComponentResult);
            }
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.saveMonthOfFetchFreeTransfer);
            if (textView2 != null) {
                FeedModel feedModel2 = (FeedModel) CollectionsKt.firstOrNull((List) groupedFeedModel.BuiltInFictitiousFunctionClassFactory);
                String str2 = feedModel2 != null ? feedModel2.moveToNextValue : null;
                textView2.setText(str2 != null ? str2 : "");
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) this.itemView.findViewById(R.id.cl_feed_notification);
            if (constraintLayout2 != null) {
                constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.GroupedFeedNotificationViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        GroupedFeedNotificationViewHolder.getAuthRequestContext(GroupedFeedNotificationViewHolder.this);
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupedFeedNotificationViewHolder(ViewGroup viewGroup, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.item_grouped_feed_notification, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.MyBillsEntityDataFactory = socialFeedClickListener;
    }

    public static /* synthetic */ void getAuthRequestContext(GroupedFeedNotificationViewHolder groupedFeedNotificationViewHolder) {
        Intrinsics.checkNotNullParameter(groupedFeedNotificationViewHolder, "");
        if (groupedFeedNotificationViewHolder.getBindingAdapterPosition() >= 0) {
            groupedFeedNotificationViewHolder.MyBillsEntityDataFactory.getAuthRequestContext(groupedFeedNotificationViewHolder.getBindingAdapterPosition());
        }
    }
}
