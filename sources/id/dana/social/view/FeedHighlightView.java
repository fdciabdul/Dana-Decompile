package id.dana.social.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.GestureListener;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewFeedHighlightBinding;
import id.dana.social.adapter.FeedHighlightAdapter;
import id.dana.social.adapter.MyFeedHighlightListener;
import id.dana.social.model.FeedHighlightModel;
import id.dana.social.model.MyFeedHighlightModel;
import id.dana.social.state.MyFeedHighlightState;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b&\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u0015*\u00020\u0014H\u0002¢\u0006\u0004\b\u0011\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0011\u0010\""}, d2 = {"Lid/dana/social/view/FeedHighlightView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFeedHighlightBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFeedHighlightBinding;", "Lid/dana/social/model/MyFeedHighlightModel;", "data", "", "render", "(Lid/dana/social/model/MyFeedHighlightModel;)V", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "setup", "setupAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "", "(Landroidx/recyclerview/widget/RecyclerView;)Z", "Lid/dana/social/adapter/FeedHighlightAdapter;", "getAuthRequestContext", "Lid/dana/social/adapter/FeedHighlightAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/MyFeedHighlightListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lid/dana/social/adapter/MyFeedHighlightListener;", "getListener", "()Lid/dana/social/adapter/MyFeedHighlightListener;", "setListener", "(Lid/dana/social/adapter/MyFeedHighlightListener;)V", "Lid/dana/social/model/MyFeedHighlightModel;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedHighlightView extends ViewBindingRichView<ViewFeedHighlightBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MyFeedHighlightModel BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FeedHighlightAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    public MyFeedHighlightListener listener;

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_feed_highlight;
    }

    @JvmName(name = "getListener")
    public final MyFeedHighlightListener getListener() {
        MyFeedHighlightListener myFeedHighlightListener = this.listener;
        if (myFeedHighlightListener != null) {
            return myFeedHighlightListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setListener")
    public final void setListener(MyFeedHighlightListener myFeedHighlightListener) {
        Intrinsics.checkNotNullParameter(myFeedHighlightListener, "");
        this.listener = myFeedHighlightListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedHighlightView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedHighlightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewFeedHighlightBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFeedHighlightBinding PlaceComponentResult = ViewFeedHighlightBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        PlaceComponentResult();
        final RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.social.view.FeedHighlightView$setupRecyclerView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                MyFeedHighlightModel myFeedHighlightModel;
                MyFeedHighlightModel myFeedHighlightModel2;
                boolean PlaceComponentResult;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrollStateChanged(p0, p1);
                myFeedHighlightModel = FeedHighlightView.this.BuiltInFictitiousFunctionClassFactory;
                if (myFeedHighlightModel != null) {
                    myFeedHighlightModel2 = FeedHighlightView.this.BuiltInFictitiousFunctionClassFactory;
                    if (myFeedHighlightModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        myFeedHighlightModel2 = null;
                    }
                    FeedHighlightView feedHighlightView = FeedHighlightView.this;
                    RecyclerView recyclerView2 = recyclerView;
                    Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
                    PlaceComponentResult = FeedHighlightView.PlaceComponentResult(recyclerView2);
                    if (PlaceComponentResult && myFeedHighlightModel2.MyBillsEntityDataFactory()) {
                        myFeedHighlightModel2.PlaceComponentResult = true;
                        feedHighlightView.getListener().MyBillsEntityDataFactory(myFeedHighlightModel2.getAuthRequestContext);
                    }
                }
            }
        });
        BaseActivity baseActivity = getBaseActivity();
        RecyclerView recyclerView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
        final GestureDetector gestureDetector = new GestureDetector(baseActivity, new GestureListener(recyclerView2));
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() { // from class: id.dana.social.view.FeedHighlightView$setupNestedScroll$1
            @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final boolean MyBillsEntityDataFactory(RecyclerView p0, MotionEvent p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                gestureDetector.onTouchEvent(p1);
                return false;
            }
        });
    }

    public final void render(MyFeedHighlightModel data) {
        Unit unit;
        FeedHighlightModel feedHighlightModel;
        List<FeedHighlightModel> items;
        Intrinsics.checkNotNullParameter(data, "");
        FeedHighlightView$render$1$1 feedHighlightView$render$1$1 = new FeedHighlightView$render$1$1(this);
        Intrinsics.checkNotNullParameter(feedHighlightView$render$1$1, "");
        data.BuiltInFictitiousFunctionClassFactory = feedHighlightView$render$1$1;
        this.BuiltInFictitiousFunctionClassFactory = data;
        MyFeedHighlightState myFeedHighlightState = data.KClassImpl$Data$declaredNonStaticMembers$2;
        if (myFeedHighlightState instanceof MyFeedHighlightState.Loading) {
            PlaceComponentResult();
            return;
        }
        if (!(myFeedHighlightState instanceof MyFeedHighlightState.Success)) {
            if (myFeedHighlightState instanceof MyFeedHighlightState.Error ? true : myFeedHighlightState instanceof MyFeedHighlightState.Disabled) {
                MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        List<FeedHighlightModel> list = ((MyFeedHighlightState.Success) data.KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2;
        MyFeedHighlightModel myFeedHighlightModel = null;
        if ((list.isEmpty() ? list : null) != null) {
            MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getBinding().lookAheadTest.setVisibility(0);
            getBinding().MyBillsEntityDataFactory.setVisibility(8);
            getBinding().getAuthRequestContext.setVisibility(0);
            FeedHighlightAdapter feedHighlightAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (feedHighlightAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedHighlightAdapter = null;
            }
            List<FeedHighlightModel> items2 = feedHighlightAdapter.getItems();
            if (items2 != null && (feedHighlightModel = (FeedHighlightModel) CollectionsKt.lastOrNull((List) items2)) != null) {
                if (feedHighlightModel.lookAheadTest == 1 && (items = feedHighlightAdapter.getItems()) != null) {
                    Intrinsics.checkNotNullExpressionValue(items, "");
                    items.remove(CollectionsKt.getLastIndex(items));
                    feedHighlightAdapter.notifyItemRemoved(items.size());
                }
                Unit unit2 = Unit.INSTANCE;
            }
            FeedHighlightAdapter feedHighlightAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (feedHighlightAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedHighlightAdapter2 = null;
            }
            MyFeedHighlightModel myFeedHighlightModel2 = this.BuiltInFictitiousFunctionClassFactory;
            if (myFeedHighlightModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                myFeedHighlightModel = myFeedHighlightModel2;
            }
            boolean myBillsEntityDataFactory = myFeedHighlightModel.getMyBillsEntityDataFactory();
            Intrinsics.checkNotNullParameter(list, "");
            if (myBillsEntityDataFactory) {
                list = CollectionsKt.plus((Collection<? extends FeedHighlightModel>) list, new FeedHighlightModel(null, null, null, false, null, 1, null, 95, null));
            }
            if (feedHighlightAdapter2.getPlaceComponentResult() == 0) {
                feedHighlightAdapter2.setItems(list);
                return;
            }
            int placeComponentResult = feedHighlightAdapter2.getPlaceComponentResult();
            feedHighlightAdapter2.getItems().addAll(list);
            feedHighlightAdapter2.notifyItemInserted(placeComponentResult);
        }
    }

    private final void PlaceComponentResult() {
        getBinding().lookAheadTest.setVisibility(0);
        getBinding().MyBillsEntityDataFactory.setVisibility(0);
        getBinding().getAuthRequestContext.setVisibility(8);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.scrollToPosition(0);
    }

    private final void MyBillsEntityDataFactory() {
        FeedHighlightAdapter feedHighlightAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedHighlightAdapter != null) {
            if (feedHighlightAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedHighlightAdapter = null;
            }
            List<FeedHighlightModel> items = feedHighlightAdapter.getItems();
            if (!(items == null || items.isEmpty())) {
                return;
            }
        }
        getBinding().lookAheadTest.setVisibility(8);
        getBinding().MyBillsEntityDataFactory.setVisibility(8);
        getBinding().getAuthRequestContext.setVisibility(8);
    }

    public final void setupAdapter() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new FeedHighlightAdapter(new FeedHighlightView$setupAdapter$1(getListener()));
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        FeedHighlightAdapter feedHighlightAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedHighlightAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedHighlightAdapter = null;
        }
        recyclerView.setAdapter(feedHighlightAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        return linearLayoutManager != null && linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1;
    }

    public static final /* synthetic */ void access$onRefresh(FeedHighlightView feedHighlightView) {
        FeedHighlightAdapter feedHighlightAdapter = feedHighlightView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedHighlightAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedHighlightAdapter = null;
        }
        feedHighlightAdapter.removeAllItems();
        feedHighlightView.PlaceComponentResult();
    }
}
