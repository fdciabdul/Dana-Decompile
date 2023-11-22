package id.dana.animation.subscription;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.flexbox.FlexboxLayoutManager;
import id.dana.R;
import id.dana.animation.banner.NewPromotionBannerAdapter;
import id.dana.animation.subscription.adapter.AnnouncementAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.danah5.DanaH5;
import id.dana.model.CdpContentModel;
import id.dana.onboarding.view.BaseSimpleView;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ShimmeringUtil;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001d\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u0011¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\t\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000eX\u0086\"¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u000eX\u0086\"¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0012\u0010\u0012\u001a\u00020\u0018X\u0086\"¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/home/subscription/SubscriptionBannerView;", "Lid/dana/onboarding/view/BaseSimpleView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lid/dana/home/subscription/adapter/AnnouncementAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/home/subscription/adapter/AnnouncementAdapter;", "Landroid/view/View;", "Landroid/view/View;", "MyBillsEntityDataFactory", "Lid/dana/home/banner/NewPromotionBannerAdapter$OnSubscriptionItemClickListener;", "lookAheadTest", "Lid/dana/home/banner/NewPromotionBannerAdapter$OnSubscriptionItemClickListener;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "moveToNextValue", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "", "Lid/dana/model/CdpContentModel;", "getErrorConfigVersion", "Ljava/util/List;", "p0", "p1", "<init>", "(Ljava/util/List;Lid/dana/home/banner/NewPromotionBannerAdapter$OnSubscriptionItemClickListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionBannerView extends BaseSimpleView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public View MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public View PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private AnnouncementAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public SkeletonScreen lookAheadTest;
    private List<? extends CdpContentModel> getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final NewPromotionBannerAdapter.OnSubscriptionItemClickListener getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private RecyclerView.LayoutManager KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.view_subscription_banner;
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    public SubscriptionBannerView(List<? extends CdpContentModel> list, NewPromotionBannerAdapter.OnSubscriptionItemClickListener onSubscriptionItemClickListener) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(onSubscriptionItemClickListener, "");
        this.getErrorConfigVersion = list;
        this.getAuthRequestContext = onSubscriptionItemClickListener;
    }

    public static /* synthetic */ void PlaceComponentResult(RecyclerView recyclerView, SubscriptionBannerView subscriptionBannerView, AnnouncementAdapter announcementAdapter, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(subscriptionBannerView, "");
        Intrinsics.checkNotNullParameter(announcementAdapter, "");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        boolean z = false;
        if (adapter != null && adapter.getItemViewType(i) == 2) {
            z = true;
        }
        if (z) {
            return;
        }
        subscriptionBannerView.getAuthRequestContext.getAuthRequestContext(announcementAdapter.getItem(i));
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SubscriptionBannerView subscriptionBannerView) {
        Intrinsics.checkNotNullParameter(subscriptionBannerView, "");
        DanaH5.startContainerFullUrl("https://m.dana.id/i/dana-my-bills/subscription/autodeduction?openSection=gn_section");
    }

    public static final /* synthetic */ int MyBillsEntityDataFactory(String str) {
        Locale locale;
        Date parse;
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        locale = Locale.getDefault();
        parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).parse(str);
        return (int) DateTimeUtil.BuiltInFictitiousFunctionClassFactory(date, parse);
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        View findViewById = m_().findViewById(R.id.shimmerView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        Intrinsics.checkNotNullParameter(findViewById, "");
        this.PlaceComponentResult = findViewById;
        View view = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            findViewById = null;
        }
        findViewById.setVisibility(0);
        View view2 = this.PlaceComponentResult;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view2 = null;
        }
        ViewSkeletonScreen PlaceComponentResult = ShimmeringUtil.PlaceComponentResult(view2, R.layout.view_skeleton_subscription_banner);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        ViewSkeletonScreen viewSkeletonScreen = PlaceComponentResult;
        Intrinsics.checkNotNullParameter(viewSkeletonScreen, "");
        this.lookAheadTest = viewSkeletonScreen;
        final RecyclerView recyclerView = (RecyclerView) m_().findViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        if (recyclerView != null) {
            final AnnouncementAdapter announcementAdapter = new AnnouncementAdapter();
            this.BuiltInFictitiousFunctionClassFactory = announcementAdapter;
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext(), 2);
            flexboxLayoutManager.setJustifyContent(2);
            FlexboxLayoutManager flexboxLayoutManager2 = flexboxLayoutManager;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = flexboxLayoutManager2;
            recyclerView.setLayoutManager(flexboxLayoutManager2);
            announcementAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.home.subscription.SubscriptionBannerView$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i) {
                    SubscriptionBannerView.PlaceComponentResult(RecyclerView.this, this, announcementAdapter, i);
                }
            });
            recyclerView.setAdapter(announcementAdapter);
        }
        View findViewById2 = m_().findViewById(R.id.groupLabel);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        Intrinsics.checkNotNullParameter(findViewById2, "");
        this.MyBillsEntityDataFactory = findViewById2;
        List<? extends CdpContentModel> sortedWith = CollectionsKt.sortedWith(this.getErrorConfigVersion, ComparisonsKt.compareBy(new Function1<CdpContentModel, Comparable<?>>() { // from class: id.dana.home.subscription.SubscriptionBannerView$subscriptionItemSortByExpiryAndType$1
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(CdpContentModel cdpContentModel) {
                Intrinsics.checkNotNullParameter(cdpContentModel, "");
                return Boolean.valueOf(!Intrinsics.areEqual(cdpContentModel.MyBillsEntityDataFactory, "FAILED"));
            }
        }, new Function1<CdpContentModel, Comparable<?>>() { // from class: id.dana.home.subscription.SubscriptionBannerView$subscriptionItemSortByExpiryAndType$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(CdpContentModel cdpContentModel) {
                Intrinsics.checkNotNullParameter(cdpContentModel, "");
                String str = cdpContentModel.moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(str, "");
                return Integer.valueOf(SubscriptionBannerView.MyBillsEntityDataFactory(str));
            }
        }, new Function1<CdpContentModel, Comparable<?>>() { // from class: id.dana.home.subscription.SubscriptionBannerView$subscriptionItemSortByExpiryAndType$3
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(CdpContentModel cdpContentModel) {
                Intrinsics.checkNotNullParameter(cdpContentModel, "");
                return Boolean.valueOf(!Intrinsics.areEqual(cdpContentModel.KClassImpl$Data$declaredNonStaticMembers$2, "GN_MERCHANT"));
            }
        }));
        this.getErrorConfigVersion = sortedWith;
        boolean z = sortedWith.size() > 3;
        int size = this.getErrorConfigVersion.size() - 3;
        View m_ = m_();
        View findViewById3 = m_.findViewById(R.id.viewIndicator);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        CardView cardView = (CardView) findViewById3;
        View findViewById4 = m_.findViewById(R.id.tvIndicatorCount);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "");
        TextView textView = (TextView) findViewById4;
        cardView.setVisibility(z ? 0 : 8);
        cardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.subscription.SubscriptionBannerView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SubscriptionBannerView.MyBillsEntityDataFactory(SubscriptionBannerView.this);
            }
        });
        textView.setText(m_.getContext().getString(R.string.subscription_banner_more_indicator, String.valueOf(size)));
        AnnouncementAdapter announcementAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
        if (announcementAdapter2 != null) {
            announcementAdapter2.setItems(CollectionsKt.take(this.getErrorConfigVersion, 3));
        }
        View view3 = this.MyBillsEntityDataFactory;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view3 = null;
        }
        view3.setVisibility(0);
        SkeletonScreen skeletonScreen = this.lookAheadTest;
        if (skeletonScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            skeletonScreen = null;
        }
        skeletonScreen.PlaceComponentResult();
        View view4 = this.PlaceComponentResult;
        if (view4 != null) {
            view = view4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        view.setVisibility(8);
    }
}
