package id.dana.social.v2.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.onboarding.model.FeedOnboardingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/v2/viewholder/FeedV2OnboardingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/onboarding/model/FeedOnboardingModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedV2OnboardingViewHolder extends BaseRecyclerViewHolder<FeedOnboardingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FeedOnboardingModel feedOnboardingModel) {
        FeedOnboardingModel feedOnboardingModel2 = feedOnboardingModel;
        if (feedOnboardingModel2 != null) {
            View view = this.itemView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.lavAnimation);
            if (lottieAnimationView != null) {
                lottieAnimationView.setAnimation(feedOnboardingModel2.getAuthRequestContext);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.getLogSourceName);
            if (appCompatTextView != null) {
                appCompatTextView.setText(feedOnboardingModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.isHelperTextDisplayed);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(feedOnboardingModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) view.findViewById(R.id.lavAnimation);
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setContentDescription(feedOnboardingModel2.BuiltInFictitiousFunctionClassFactory);
            }
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) view.findViewById(R.id.getLogSourceName);
            if (appCompatTextView3 != null) {
                appCompatTextView3.setContentDescription(feedOnboardingModel2.lookAheadTest);
            }
            AppCompatTextView appCompatTextView4 = (AppCompatTextView) view.findViewById(R.id.isHelperTextDisplayed);
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(feedOnboardingModel2.MyBillsEntityDataFactory);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedV2OnboardingViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.viewholder_feed_onboarding_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
