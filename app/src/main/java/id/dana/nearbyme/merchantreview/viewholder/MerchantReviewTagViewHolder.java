package id.dana.nearbyme.merchantreview.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.request.BaseRequestOptions;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.nearbyme.merchantreview.MerchantReviewTagListener;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.utils.ImageResize;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/nearbyme/merchantreview/viewholder/MerchantReviewTagViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "Ljava/util/LinkedList;", "PlaceComponentResult", "Ljava/util/LinkedList;", "MyBillsEntityDataFactory", "p0", "Landroid/view/ViewGroup;", "p1", "Lid/dana/nearbyme/merchantreview/MerchantReviewTagListener;", "p2", "<init>", "(Ljava/util/LinkedList;Landroid/view/ViewGroup;Lid/dana/nearbyme/merchantreview/MerchantReviewTagListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewTagViewHolder extends BaseRecyclerViewHolder<MerchantReviewTagModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final LinkedList<MerchantReviewTagModel> MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(MerchantReviewTagModel merchantReviewTagModel) {
        MerchantReviewTagModel merchantReviewTagModel2 = merchantReviewTagModel;
        if (merchantReviewTagModel2 != null) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.MotionHelperInterface);
            if (textView != null) {
                textView.setText(merchantReviewTagModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            String str = merchantReviewTagModel2.getAuthRequestContext;
            boolean z = str == null || str.length() == 0;
            int i = R.drawable.bg_circle_grey_30;
            if (!z) {
                GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(merchantReviewTagModel2.getAuthRequestContext).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.bg_circle_grey_30).PlaceComponentResult((int) R.drawable.bg_circle_grey_30).MyBillsEntityDataFactory((ImageView) ((CircleImageView) this.itemView.findViewById(R.id.civ_tag_icon)));
            } else {
                CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(R.id.civ_tag_icon);
                Context context = getContext();
                String str2 = merchantReviewTagModel2 != null ? merchantReviewTagModel2.KClassImpl$Data$declaredNonStaticMembers$2 : null;
                if (Intrinsics.areEqual(str2, context.getString(R.string.positive_tag_delicious))) {
                    i = R.drawable.ic_positive_review_delicious;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.positive_tag_affordable))) {
                    i = R.drawable.ic_positive_review_affordable;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.positive_tag_comfortable))) {
                    i = R.drawable.ic_positive_review_comfortable;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.positive_tag_good_presentation))) {
                    i = R.drawable.ic_positive_review_good_presentation;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.positive_tag_good_service))) {
                    i = R.drawable.ic_positive_review_good_services;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.positive_tag_easy_find))) {
                    i = R.drawable.ic_positive_review_easy_to_find;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.negative_tag_not_delicious))) {
                    i = R.drawable.ic_negative_review_not_delicious;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.negative_tag_expensive))) {
                    i = R.drawable.ic_negative_review_expensive;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.negative_tag_uncomfortable))) {
                    i = R.drawable.ic_negative_review_uncomfortable;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.negative_tag_bad_presentation))) {
                    i = R.drawable.ic_negative_review_bad_presentation;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.negative_tag_bad_service))) {
                    i = R.drawable.ic_negative_review_bad_services;
                } else if (Intrinsics.areEqual(str2, context.getString(R.string.negative_tag_hard_find))) {
                    i = R.drawable.ic_negative_review_hard_to_find;
                }
                if (circleImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(circleImageView, i);
                } else {
                    circleImageView.setImageResource(i);
                }
            }
            if (merchantReviewTagModel2.getMyBillsEntityDataFactory()) {
                if (getContext() != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_selected_blue_bg);
                    if (appCompatImageView != null) {
                        appCompatImageView.setVisibility(0);
                    }
                    FrameLayout frameLayout = (FrameLayout) this.itemView.findViewById(R.id.fl_selected_checklist);
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                    ((FrameLayout) this.itemView.findViewById(R.id.isPerformanceLogEnable)).setAlpha(1.0f);
                    ((TextView) this.itemView.findViewById(R.id.MotionHelperInterface)).setAlpha(1.0f);
                    Unit unit = Unit.INSTANCE;
                }
            } else if (getContext() != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.itemView.findViewById(R.id.iv_selected_blue_bg);
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setVisibility(8);
                }
                FrameLayout frameLayout2 = (FrameLayout) this.itemView.findViewById(R.id.fl_selected_checklist);
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(8);
                }
                View view = this.itemView;
                if (this.MyBillsEntityDataFactory.size() >= 3) {
                    ((FrameLayout) view.findViewById(R.id.isPerformanceLogEnable)).setAlpha(0.4f);
                    ((TextView) view.findViewById(R.id.MotionHelperInterface)).setAlpha(0.4f);
                    return;
                }
                ((FrameLayout) view.findViewById(R.id.isPerformanceLogEnable)).setAlpha(1.0f);
                ((TextView) view.findViewById(R.id.MotionHelperInterface)).setAlpha(1.0f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewTagViewHolder(LinkedList<MerchantReviewTagModel> linkedList, ViewGroup viewGroup, final MerchantReviewTagListener merchantReviewTagListener) {
        super(viewGroup.getContext(), R.layout.item_merchant_review_tag, viewGroup);
        Intrinsics.checkNotNullParameter(linkedList, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(merchantReviewTagListener, "");
        this.MyBillsEntityDataFactory = linkedList;
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.viewholder.MerchantReviewTagViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantReviewTagViewHolder.PlaceComponentResult(MerchantReviewTagListener.this, this);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(MerchantReviewTagListener merchantReviewTagListener, MerchantReviewTagViewHolder merchantReviewTagViewHolder) {
        Intrinsics.checkNotNullParameter(merchantReviewTagListener, "");
        Intrinsics.checkNotNullParameter(merchantReviewTagViewHolder, "");
        merchantReviewTagListener.MyBillsEntityDataFactory(merchantReviewTagViewHolder.getBindingAdapterPosition());
    }
}
