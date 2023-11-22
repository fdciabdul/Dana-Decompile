package id.dana.social.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.viewpager2.widget.ViewPager2;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.social.adapter.ActivityBannerAdapter;
import id.dana.social.adapter.SocialFeedClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\t\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/social/adapter/viewholder/FeedActivityBannerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "", "PlaceComponentResult", "()Z", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/ActivityBannerAdapter;", "Lid/dana/social/adapter/ActivityBannerAdapter;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "p1", "p2", "Lid/dana/social/adapter/SocialFeedClickListener;", "p3", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedActivityBannerViewHolder extends BaseRecyclerViewHolder<Integer> {
    public final ActivityBannerAdapter MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedActivityBannerViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1, final Function1<? super Integer, Unit> function12, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.view_feed_activity_banner, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        ActivityBannerAdapter activityBannerAdapter = new ActivityBannerAdapter(socialFeedClickListener);
        this.MyBillsEntityDataFactory = activityBannerAdapter;
        final View view = this.itemView;
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.res_0x7f0a1bbf_com_alibaba_ariver_engine_api_extopt_2);
        if (viewPager2 != null) {
            Intrinsics.checkNotNullExpressionValue(viewPager2, "");
            viewPager2.setUserInputEnabled(false);
            viewPager2.setAdapter(activityBannerAdapter);
        }
        Button button = (Button) view.findViewById(R.id.btn_skip_activity);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FeedActivityBannerViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedActivityBannerViewHolder.BuiltInFictitiousFunctionClassFactory(view, function1, this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) view.findViewById(R.id.res_0x7f0a0229_flowablecreate_bufferasyncemitter);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FeedActivityBannerViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FeedActivityBannerViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(Function1.this, view);
                }
            });
        }
    }

    public final void getAuthRequestContext() {
        if (PlaceComponentResult()) {
            String string = getContext().getString(R.string.activity_banner_close_button);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Button button = (Button) this.itemView.findViewById(R.id.btn_skip_activity);
            if (button != null) {
                button.setText(string);
            }
        }
    }

    public final void MyBillsEntityDataFactory() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22 = (ViewPager2) this.itemView.findViewById(R.id.res_0x7f0a1bbf_com_alibaba_ariver_engine_api_extopt_2);
        if (viewPager22 != null) {
            if (PlaceComponentResult() && (viewPager2 = (ViewPager2) this.itemView.findViewById(R.id.res_0x7f0a1bbf_com_alibaba_ariver_engine_api_extopt_2)) != null) {
                viewPager2.setCurrentItem(0);
            }
            viewPager22.setCurrentItem(viewPager22.getCurrentItem() + 1, true);
            getAuthRequestContext();
        }
    }

    private final boolean PlaceComponentResult() {
        ViewPager2 viewPager2 = (ViewPager2) this.itemView.findViewById(R.id.res_0x7f0a1bbf_com_alibaba_ariver_engine_api_extopt_2);
        return (viewPager2 != null && viewPager2.getCurrentItem() == this.MyBillsEntityDataFactory.getItems().size() - 1) || this.MyBillsEntityDataFactory.getItems().size() == 1;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(view, "");
        function1.invoke(Integer.valueOf(((ViewPager2) view.findViewById(R.id.res_0x7f0a1bbf_com_alibaba_ariver_engine_api_extopt_2)).getCurrentItem()));
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, Function1 function1, FeedActivityBannerViewHolder feedActivityBannerViewHolder) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(feedActivityBannerViewHolder, "");
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.res_0x7f0a1bbf_com_alibaba_ariver_engine_api_extopt_2);
        if (viewPager2 != null) {
            function1.invoke(Integer.valueOf(viewPager2.getCurrentItem()));
            feedActivityBannerViewHolder.MyBillsEntityDataFactory();
        }
    }
}
