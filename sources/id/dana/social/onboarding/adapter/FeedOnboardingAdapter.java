package id.dana.social.onboarding.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.onboarding.model.FeedOnboardingModel;
import id.dana.social.onboarding.viewholder.FeedOnboardingViewHolder;
import id.dana.social.v2.viewholder.FeedV2OnboardingViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/onboarding/adapter/FeedOnboardingAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/onboarding/model/FeedOnboardingModel;", "", "MyBillsEntityDataFactory", "Z", "PlaceComponentResult", "Landroid/content/Context;", "p0", "p1", "<init>", "(Landroid/content/Context;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedOnboardingAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FeedOnboardingModel>, FeedOnboardingModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FeedOnboardingViewHolder feedOnboardingViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (this.PlaceComponentResult) {
            feedOnboardingViewHolder = new FeedV2OnboardingViewHolder(viewGroup);
        } else {
            feedOnboardingViewHolder = new FeedOnboardingViewHolder(viewGroup);
        }
        return feedOnboardingViewHolder;
    }

    public FeedOnboardingAdapter(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = z;
        setItems(z ? Companion.KClassImpl$Data$declaredNonStaticMembers$2(context) : Companion.PlaceComponentResult(context));
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/onboarding/adapter/FeedOnboardingAdapter$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
            String string = context.getString(R.string.feed_onboarding_title_1);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = context.getString(R.string.feed_onboarding_desc_1);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String string3 = context.getString(R.string.lblOnboardingTitle1_v2);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            String string4 = context.getString(R.string.lblOnboardingDesc1_v2);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            String string5 = context.getString(R.string.imgLottieAnimation1);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            String string6 = context.getString(R.string.feed_onboarding_title_2);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            String string7 = context.getString(R.string.feed_onboarding_desc_2);
            Intrinsics.checkNotNullExpressionValue(string7, "");
            String string8 = context.getString(R.string.lblOnboardingTitle2_v2);
            Intrinsics.checkNotNullExpressionValue(string8, "");
            String string9 = context.getString(R.string.lblOnboardingDesc2_v2);
            Intrinsics.checkNotNullExpressionValue(string9, "");
            String string10 = context.getString(R.string.imgLottieAnimation2);
            Intrinsics.checkNotNullExpressionValue(string10, "");
            Function0 function0 = null;
            int i = 8;
            DefaultConstructorMarker defaultConstructorMarker = null;
            String string11 = context.getString(R.string.feed_onboarding_title_3);
            Intrinsics.checkNotNullExpressionValue(string11, "");
            String string12 = context.getString(R.string.feed_onboarding_desc_3);
            Intrinsics.checkNotNullExpressionValue(string12, "");
            String string13 = context.getString(R.string.lblOnboardingTitle3_v2);
            Intrinsics.checkNotNullExpressionValue(string13, "");
            String string14 = context.getString(R.string.lblOnboardingDesc3_v2);
            Intrinsics.checkNotNullExpressionValue(string14, "");
            String string15 = context.getString(R.string.imgLottieAnimation3);
            Intrinsics.checkNotNullExpressionValue(string15, "");
            return CollectionsKt.listOf((Object[]) new FeedOnboardingModel[]{new FeedOnboardingModel(R.raw.f46862131886087, string, string2, null, string3, string4, string5, 8, null), new FeedOnboardingModel(R.raw.f46872131886088, string6, string7, function0, string8, string9, string10, i, defaultConstructorMarker), new FeedOnboardingModel(R.raw.f46882131886089, string11, string12, function0, string13, string14, string15, i, defaultConstructorMarker)});
        }

        public static final /* synthetic */ List PlaceComponentResult(Context context) {
            String string = context.getString(R.string.feed_onboarding_first_page_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = context.getString(R.string.feed_onboarding_first_page_description);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String string3 = context.getString(R.string.lblOnboardingTitle1);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            String string4 = context.getString(R.string.lblOnboardingDesc1);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            String string5 = context.getString(R.string.imgLottieAnimation1);
            Intrinsics.checkNotNullExpressionValue(string5, "");
            String string6 = context.getString(R.string.feed_onboarding_second_page_title);
            Intrinsics.checkNotNullExpressionValue(string6, "");
            String string7 = context.getString(R.string.feed_onboarding_second_page_description);
            Intrinsics.checkNotNullExpressionValue(string7, "");
            String string8 = context.getString(R.string.lblOnboardingTitle2);
            Intrinsics.checkNotNullExpressionValue(string8, "");
            String string9 = context.getString(R.string.lblOnboardingDesc2);
            Intrinsics.checkNotNullExpressionValue(string9, "");
            String string10 = context.getString(R.string.imgLottieAnimation2);
            Intrinsics.checkNotNullExpressionValue(string10, "");
            Function0 function0 = null;
            int i = 8;
            DefaultConstructorMarker defaultConstructorMarker = null;
            String string11 = context.getString(R.string.feed_onboarding_third_page_title);
            Intrinsics.checkNotNullExpressionValue(string11, "");
            String string12 = context.getString(R.string.feed_onboarding_third_page_description);
            Intrinsics.checkNotNullExpressionValue(string12, "");
            String string13 = context.getString(R.string.lblOnboardingTitle3);
            Intrinsics.checkNotNullExpressionValue(string13, "");
            String string14 = context.getString(R.string.lblOnboardingDesc3);
            Intrinsics.checkNotNullExpressionValue(string14, "");
            String string15 = context.getString(R.string.imgLottieAnimation3);
            Intrinsics.checkNotNullExpressionValue(string15, "");
            return CollectionsKt.listOf((Object[]) new FeedOnboardingModel[]{new FeedOnboardingModel(R.raw.f46852131886086, string, string2, null, string3, string4, string5, 8, null), new FeedOnboardingModel(R.raw.f46832131886084, string6, string7, function0, string8, string9, string10, i, defaultConstructorMarker), new FeedOnboardingModel(R.raw.f46842131886085, string11, string12, function0, string13, string14, string15, i, defaultConstructorMarker)});
        }
    }
}
