package id.dana.explore.popularplaces;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.base.GestureListener;
import id.dana.base.ThrottledOnItemClickListener;
import id.dana.explore.popularplaces.adapter.PopularPlacesAdapter;
import id.dana.explore.popularplaces.model.ExplorePopularPlacesConfigModel;
import id.dana.nearbyme.OtherStoreListActivity;
import id.dana.nearbyme.enums.SearchType;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B'\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eB+\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/explore/popularplaces/PopularPlacesView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideShimmer", "()V", "", "Lid/dana/explore/popularplaces/model/ExplorePopularPlacesConfigModel;", "explorePopularPlacesConfigModels", "loadData", "(Ljava/util/List;)V", "setup", "setupRecyclerView", "()Lkotlin/Unit;", "showShimmer", "Lid/dana/explore/popularplaces/adapter/PopularPlacesAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/explore/popularplaces/adapter/PopularPlacesAdapter;", "getAuthRequestContext", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PopularPlacesView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private PopularPlacesAdapter getAuthRequestContext;
    private SkeletonScreen PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopularPlacesView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PopularPlacesView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_popular_places;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopularPlacesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ PopularPlacesView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopularPlacesView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        setupRecyclerView();
    }

    public final void showShimmer() {
        SkeletonScreen skeletonScreen = this.PlaceComponentResult;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((ConstraintLayout) _$_findCachedViewById(R.id.cv_popular_places));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_popular_places;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.PlaceComponentResult = viewSkeletonScreen;
    }

    public final void hideShimmer() {
        SkeletonScreen skeletonScreen = this.PlaceComponentResult;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.PlaceComponentResult = null;
    }

    public final Unit setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_popular_places);
        if (recyclerView != null) {
            final PopularPlacesAdapter popularPlacesAdapter = new PopularPlacesAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            this.getAuthRequestContext = popularPlacesAdapter;
            recyclerView.setAdapter(popularPlacesAdapter);
            popularPlacesAdapter.setOnItemClickListener(new ThrottledOnItemClickListener(0L, new Function1<Integer, Unit>() { // from class: id.dana.explore.popularplaces.PopularPlacesView$setupRecyclerView$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    ExplorePopularPlacesConfigModel item = PopularPlacesAdapter.this.getItem(i);
                    if (item != null) {
                        PopularPlacesView.access$onItemClicked(this, item);
                    }
                }
            }, 1, null));
            BaseActivity baseActivity = getBaseActivity();
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rv_popular_places);
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
            final GestureDetector gestureDetector = new GestureDetector(baseActivity, new GestureListener(recyclerView2));
            RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(R.id.rv_popular_places);
            if (recyclerView3 != null) {
                recyclerView3.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: id.dana.explore.popularplaces.PopularPlacesView$setupNestedScroll$1
                    @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
                    public final boolean MyBillsEntityDataFactory(RecyclerView p0, MotionEvent p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        gestureDetector.onTouchEvent(p1);
                        return false;
                    }
                });
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void loadData(List<ExplorePopularPlacesConfigModel> explorePopularPlacesConfigModels) {
        Intrinsics.checkNotNullParameter(explorePopularPlacesConfigModels, "");
        PopularPlacesAdapter popularPlacesAdapter = this.getAuthRequestContext;
        if (popularPlacesAdapter != null) {
            popularPlacesAdapter.setItems(explorePopularPlacesConfigModels);
        }
    }

    public static final /* synthetic */ void access$onItemClicked(PopularPlacesView popularPlacesView, ExplorePopularPlacesConfigModel explorePopularPlacesConfigModel) {
        OtherStoreListActivity.Companion companion = OtherStoreListActivity.INSTANCE;
        Context context = popularPlacesView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        OtherStoreListActivity.Companion.BuiltInFictitiousFunctionClassFactory(context, explorePopularPlacesConfigModel.getAuthRequestContext, explorePopularPlacesConfigModel.MyBillsEntityDataFactory, SearchType.MERCHANTID_SORTED_BY_DISTANCE, "", TrackerKey.SourceType.EXPLORE_PAGE);
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(popularPlacesView.getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_SHOP_LIST_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TrackerKey.SourceType.EXPLORE_PAGE);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }
}
