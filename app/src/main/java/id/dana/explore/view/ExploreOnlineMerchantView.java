package id.dana.explore.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseRichView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerExploreOnlineMerchantComponent;
import id.dana.di.modules.OnlineMerchantAnalyticModule;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.onlinemerchant.OnlineMerchantActivity;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;
import id.dana.onlinemerchant.view.OnlineMerchantListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/explore/view/ExploreOnlineMerchantView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "onlineMerchantList", "", "setListItem", "(Ljava/util/List;)V", "setup", "()V", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "tracker", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "getTracker", "()Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "setTracker", "(Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreOnlineMerchantView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private List<PaySearchInfoModel> KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public OnlineMerchantAnalyticTracker tracker;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExploreOnlineMerchantView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExploreOnlineMerchantView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_explore_online_merchant;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreOnlineMerchantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
    }

    public /* synthetic */ ExploreOnlineMerchantView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getTracker")
    public final OnlineMerchantAnalyticTracker getTracker() {
        OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker = this.tracker;
        if (onlineMerchantAnalyticTracker != null) {
            return onlineMerchantAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTracker")
    public final void setTracker(OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker) {
        Intrinsics.checkNotNullParameter(onlineMerchantAnalyticTracker, "");
        this.tracker = onlineMerchantAnalyticTracker;
    }

    public final void setListItem(List<PaySearchInfoModel> onlineMerchantList) {
        Intrinsics.checkNotNullParameter(onlineMerchantList, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onlineMerchantList;
        OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) _$_findCachedViewById(R.id.res_0x7f0a1102_descriptorvisibilities_9);
        if (onlineMerchantListView != null) {
            onlineMerchantListView.setMerchantListItem(onlineMerchantList);
        }
    }

    public static /* synthetic */ void $r8$lambda$WssrlfReo3NjqgzQL86KeZReWlI(ExploreOnlineMerchantView exploreOnlineMerchantView, View view) {
        Intrinsics.checkNotNullParameter(exploreOnlineMerchantView, "");
        exploreOnlineMerchantView.getContext().startActivity(new Intent(exploreOnlineMerchantView.getContext(), OnlineMerchantActivity.class).putParcelableArrayListExtra(OnlineMerchantActivity.TRENDING_MERCHANTS_EXTRA, new ArrayList<>(exploreOnlineMerchantView.KClassImpl$Data$declaredNonStaticMembers$2)));
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        DaggerExploreOnlineMerchantComponent.Builder MyBillsEntityDataFactory = DaggerExploreOnlineMerchantComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        if (MyBillsEntityDataFactory.getAuthRequestContext == null) {
            MyBillsEntityDataFactory.getAuthRequestContext = new OnlineMerchantAnalyticModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerExploreOnlineMerchantComponent.ExploreOnlineMerchantComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0).PlaceComponentResult(this);
        final OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) _$_findCachedViewById(R.id.res_0x7f0a1102_descriptorvisibilities_9);
        if (onlineMerchantListView != null) {
            onlineMerchantListView.showSmallSkeleton();
            onlineMerchantListView.setOnlineMerchantItemListener(new OnlineMerchantListView.OnlineMerchantItemListener() { // from class: id.dana.explore.view.ExploreOnlineMerchantView$setup$1$1
                @Override // id.dana.onlinemerchant.view.OnlineMerchantListView.OnlineMerchantItemListener
                public final void getAuthRequestContext(PaySearchInfoModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    OnlineMerchantListView.this.getTracker().BuiltInFictitiousFunctionClassFactory(TrackerKey.SourceType.EXPLORE_PAGE, p0);
                }
            });
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tvViewAllOnlineMerchant);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.explore.view.ExploreOnlineMerchantView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExploreOnlineMerchantView.$r8$lambda$WssrlfReo3NjqgzQL86KeZReWlI(ExploreOnlineMerchantView.this, view);
                }
            });
        }
    }
}
