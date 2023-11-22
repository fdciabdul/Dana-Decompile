package id.dana.social.fragment;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.richview.LoadingLottieAnimationView;
import id.dana.eventbus.base.BaseFragmentWithPageLoadTracker;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.adapter.SocialFeedsAdapter;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 D*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001DB\u0007¢\u0006\u0004\bC\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u000b\u0010\u0006J\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0006J\u0013\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001c\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\bH&¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001e\u001a\u00020\bH\u0004¢\u0006\u0004\b\u001e\u0010\nJ\u000f\u0010\u001f\u001a\u00020\bH\u0004¢\u0006\u0004\b\u001f\u0010\nJ\u000f\u0010 \u001a\u00020\bH&¢\u0006\u0004\b \u0010\nJ\u000f\u0010!\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\nJ\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\nJ\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010'\u001a\u00020\u0004H\u0014¢\u0006\u0004\b'\u0010\u0006J\u0017\u0010(\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b(\u0010\u0006J\u000f\u0010)\u001a\u00020\u0004H\u0004¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010*J\u000f\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010\u0006R\u0016\u0010\t\u001a\u00020,8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b-\u0010.R\"\u0010\u000b\u001a\u00020\b8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b-\u0010\n\"\u0004\b1\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u0016@\u0005X\u0085\n¢\u0006\f\n\u0004\b\u001f\u00102\"\u0004\b\u000b\u00103R\u0016\u0010\u0005\u001a\u0002048\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b$\u00105R\u0016\u0010\u0007\u001a\u0002068\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001a\u00107R\u0016\u0010/\u001a\u0002088\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b9\u0010:R*\u0010\u0017\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8\u0005@EX\u0085\u000e¢\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b/\u0010\n\"\u0004\b\u0005\u0010*R\u0016\u0010\u0010\u001a\u00020;8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001d\u0010<R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160=8\u0005X\u0085\u0006¢\u0006\f\n\u0004\b(\u0010>\u001a\u0004\b9\u0010\u0018R\u0011\u0010\u001a\u001a\u00020?X\u0005¢\u0006\u0006\n\u0004\b\u0010\u0010@R\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u00100R\u0016\u0010$\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b%\u0010B"}, d2 = {"Lid/dana/social/fragment/BaseFeedTimelineFragment;", "Landroidx/viewbinding/ViewBinding;", "V", "Lid/dana/eventbus/base/BaseFragmentWithPageLoadTracker;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", "PlaceComponentResult", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "scheduleImpl", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "getLayout", "()I", "", "Lid/dana/social/model/FeedViewHolderModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Ljava/util/List;", "Lid/dana/social/adapter/SocialFeedClickListener;", "lookAheadTest", "()Lid/dana/social/adapter/SocialFeedClickListener;", IAPSyncCommand.COMMAND_INIT, "GetContactSyncConfig", "readMicros", "DatabaseTableConfigUtil", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda1", "newProxyInstance", "isLayoutRequested", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "(Z)V", "FragmentBottomSheetPaymentSettingBinding", "Landroidx/cardview/widget/CardView;", "moveToNextValue", "Landroidx/cardview/widget/CardView;", "getErrorConfigVersion", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/social/model/FeedViewHolderModel;", "(Lid/dana/social/model/FeedViewHolderModel;)V", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lid/dana/core/ui/richview/LoadingLottieAnimationView;", "Lin/srain/cube/views/ptr/PtrClassicFrameLayout;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lin/srain/cube/views/ptr/PtrClassicFrameLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Ljava/util/List;", "Lid/dana/social/adapter/SocialFeedsAdapter;", "Lid/dana/social/adapter/SocialFeedsAdapter;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseFeedTimelineFragment<V extends ViewBinding> extends BaseFragmentWithPageLoadTracker<V> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private FeedViewHolderModel PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private RecyclerView scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private AppCompatImageView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private PtrClassicFrameLayout getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private List<FeedViewHolderModel> moveToNextValue;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    LoadingLottieAnimationView getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private CardView MyBillsEntityDataFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final SocialFeedsAdapter lookAheadTest;

    public abstract boolean GetContactSyncConfig();

    public void NetworkUserEntityData$$ExternalSyntheticLambda1() {
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_me_feed;
    }

    public abstract boolean initRecordTimeStamp();

    public void isLayoutRequested() {
    }

    public abstract SocialFeedClickListener lookAheadTest();

    public void newProxyInstance() {
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public BaseFeedTimelineFragment() {
        FeedModel.Companion companion = FeedModel.INSTANCE;
        this.PlaceComponentResult = new FeedViewHolderModel(2, FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2("", "%fetching%", "KYC0"), null, null, null, false, 60, null);
        this.moveToNextValue = new ArrayList();
        this.lookAheadTest = new SocialFeedsAdapter();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedViewHolderModel feedViewHolderModel) {
        Intrinsics.checkNotNullParameter(feedViewHolderModel, "");
        this.PlaceComponentResult = feedViewHolderModel;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda2")
    public final List<FeedViewHolderModel> NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.moveToNextValue;
    }

    @JvmName(name = "getErrorConfigVersion")
    /* renamed from: getErrorConfigVersion  reason: from getter */
    public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        PtrClassicFrameLayout ptrClassicFrameLayout = this.getErrorConfigVersion;
        if (ptrClassicFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout = null;
        }
        ptrClassicFrameLayout.setEnabled(z && DatabaseTableConfigUtil());
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda4")
    public final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
    }

    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public RecyclerView.Adapter<?> scheduleImpl() {
        SocialFeedsAdapter socialFeedsAdapter = this.lookAheadTest;
        socialFeedsAdapter.setItems(new ArrayList());
        return socialFeedsAdapter;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return this.getAuthRequestContext != null;
    }

    public final boolean DatabaseTableConfigUtil() {
        RecyclerView recyclerView = this.scheduleImpl;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        CardView cardView = this.MyBillsEntityDataFactory;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cardView = null;
        }
        cardView.setVisibility(p0 ? 0 : 8);
    }

    private boolean readMicros() {
        return this.lookAheadTest.getPlaceComponentResult() <= 0;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        if (!readMicros()) {
            if (this.lookAheadTest.getItem(r0.getPlaceComponentResult() - 1).getErrorConfigVersion == 6) {
                this.lookAheadTest.removeItem(r0.getPlaceComponentResult() - 1);
            }
        }
        PlaceComponentResult();
    }

    public final void PlaceComponentResult() {
        addDisposable(Observable.timer(500L, TimeUnit.MILLISECONDS).doOnComplete(new Action() { // from class: id.dana.social.fragment.BaseFeedTimelineFragment$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Action
            public final void run() {
                BaseFeedTimelineFragment.PlaceComponentResult(BaseFeedTimelineFragment.this);
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).subscribe());
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (readMicros() || !NetworkUserEntityData$$ExternalSyntheticLambda5() || NetworkUserEntityData$$ExternalSyntheticLambda6()) {
            return;
        }
        this.lookAheadTest.appendItem(new FeedViewHolderModel(7, null, null, null, null, false, 60, null));
    }

    public final void getAuthRequestContext() {
        if (NetworkUserEntityData$$ExternalSyntheticLambda5()) {
            this.lookAheadTest.appendItem(new FeedViewHolderModel(6, null, null, null, null, false, 60, null));
        }
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda6() {
        if (!readMicros()) {
            SocialFeedsAdapter socialFeedsAdapter = this.lookAheadTest;
            if (socialFeedsAdapter.getItem(socialFeedsAdapter.getPlaceComponentResult() - 1).getErrorConfigVersion == 7) {
                return true;
            }
        }
        return false;
    }

    public final boolean MyBillsEntityDataFactory() {
        return (readMicros() || this.KClassImpl$Data$declaredNonStaticMembers$2 || !NetworkUserEntityData$$ExternalSyntheticLambda5()) ? false : true;
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        SocialFeedsAdapter socialFeedsAdapter = this.lookAheadTest;
        FeedViewHolderModel item = socialFeedsAdapter.getItem(socialFeedsAdapter.getPlaceComponentResult() - 1);
        return item != null && (item.getErrorConfigVersion == 5 || item.getErrorConfigVersion == 9);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        this.lookAheadTest.setItems(new ArrayList());
        this.moveToNextValue = new ArrayList();
    }

    public static List<FeedViewHolderModel> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            FeedModel.Companion companion = FeedModel.INSTANCE;
            arrayList.add(FeedModel.Companion.BuiltInFictitiousFunctionClassFactory());
        }
        return arrayList;
    }

    public final void PrepareContext() {
        SocialFeedsAdapter socialFeedsAdapter = this.lookAheadTest;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.moveToNextValue);
        socialFeedsAdapter.setItems(arrayList);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.lookAheadTest.getItems().addAll(NetworkUserEntityData$$ExternalSyntheticLambda0());
    }

    public static /* synthetic */ void PlaceComponentResult(BaseFeedTimelineFragment baseFeedTimelineFragment) {
        Intrinsics.checkNotNullParameter(baseFeedTimelineFragment, "");
        baseFeedTimelineFragment.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    public static /* synthetic */ void getAuthRequestContext(BaseFeedTimelineFragment baseFeedTimelineFragment, int i) {
        Intrinsics.checkNotNullParameter(baseFeedTimelineFragment, "");
        if (baseFeedTimelineFragment.lookAheadTest.getPlaceComponentResult() > i) {
            int i2 = baseFeedTimelineFragment.lookAheadTest.getItem(i).getErrorConfigVersion;
            if (i2 == 2) {
                baseFeedTimelineFragment.NetworkUserEntityData$$ExternalSyntheticLambda1();
            } else if (i2 == 7) {
                if (!baseFeedTimelineFragment.readMicros() && baseFeedTimelineFragment.NetworkUserEntityData$$ExternalSyntheticLambda6()) {
                    baseFeedTimelineFragment.lookAheadTest.removeItem(r2.getPlaceComponentResult() - 1);
                }
                baseFeedTimelineFragment.isLayoutRequested();
            }
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseFeedTimelineFragment baseFeedTimelineFragment) {
        Intrinsics.checkNotNullParameter(baseFeedTimelineFragment, "");
        if (!baseFeedTimelineFragment.readMicros()) {
            RecyclerView recyclerView = baseFeedTimelineFragment.scheduleImpl;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recyclerView = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                RecyclerView recyclerView3 = baseFeedTimelineFragment.scheduleImpl;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recyclerView2 = recyclerView3;
                }
                layoutManager.smoothScrollToPosition(recyclerView2, new RecyclerView.State(), 0);
            }
        }
        baseFeedTimelineFragment.KClassImpl$Data$declaredNonStaticMembers$2(false);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(BaseFeedTimelineFragment baseFeedTimelineFragment) {
        LoadingLottieAnimationView loadingLottieAnimationView = baseFeedTimelineFragment.getAuthRequestContext;
        if (loadingLottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            loadingLottieAnimationView = null;
        }
        loadingLottieAnimationView.setupLoopMinMaxFrame(loadingLottieAnimationView);
        if (baseFeedTimelineFragment.initRecordTimeStamp) {
            loadingLottieAnimationView.setMaxFrame(loadingLottieAnimationView.getOutroMaxFrame());
            loadingLottieAnimationView.setLoopFinished(true);
        }
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        V binding = getBinding();
        if (binding != null) {
            View KClassImpl$Data$declaredNonStaticMembers$2 = binding.KClassImpl$Data$declaredNonStaticMembers$2();
            View findViewById = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.ptr_feeds);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            this.getErrorConfigVersion = (PtrClassicFrameLayout) findViewById;
            View findViewById2 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.f3717ViewPayConfirmationAddOnBinding_res_0x7f0a0572);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "");
            this.MyBillsEntityDataFactory = (CardView) findViewById2;
            View findViewById3 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.getMonitoredResourcesOrBuilder);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "");
            this.scheduleImpl = (RecyclerView) findViewById3;
            View findViewById4 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.iv_up);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "");
            this.BuiltInFictitiousFunctionClassFactory = (AppCompatImageView) findViewById4;
            View findViewById5 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.tv_back_to_top);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = (AppCompatTextView) findViewById5;
        }
        SocialFeedsAdapter socialFeedsAdapter = this.lookAheadTest;
        SocialFeedClickListener lookAheadTest = lookAheadTest();
        Intrinsics.checkNotNullParameter(lookAheadTest, "");
        socialFeedsAdapter.getErrorConfigVersion = lookAheadTest;
        this.lookAheadTest.PlaceComponentResult = !GetContactSyncConfig();
        PtrClassicFrameLayout ptrClassicFrameLayout = this.getErrorConfigVersion;
        CardView cardView = null;
        if (ptrClassicFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout = null;
        }
        ptrClassicFrameLayout.setPtrHandler(new PtrHandler(this) { // from class: id.dana.social.fragment.BaseFeedTimelineFragment$initPullToRefreshComponent$1
            final /* synthetic */ BaseFeedTimelineFragment<V> BuiltInFictitiousFunctionClassFactory;

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final boolean checkCanDoRefresh(PtrFrameLayout p0, View p1, View p2) {
                return true;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.BuiltInFictitiousFunctionClassFactory = this;
            }

            @Override // in.srain.cube.views.ptr.PtrHandler
            public final void onRefreshBegin(PtrFrameLayout p0) {
                boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
                LoadingLottieAnimationView loadingLottieAnimationView;
                NetworkUserEntityData$$ExternalSyntheticLambda3 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda3();
                if (NetworkUserEntityData$$ExternalSyntheticLambda3) {
                    loadingLottieAnimationView = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                    if (loadingLottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView = null;
                    }
                    loadingLottieAnimationView.playAnimation();
                }
                this.BuiltInFictitiousFunctionClassFactory.newProxyInstance();
            }
        });
        PtrClassicFrameLayout ptrClassicFrameLayout2 = this.getErrorConfigVersion;
        if (ptrClassicFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout2 = null;
        }
        ptrClassicFrameLayout2.disableWhenHorizontalMove(true);
        PtrClassicFrameLayout ptrClassicFrameLayout3 = this.getErrorConfigVersion;
        if (ptrClassicFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout3 = null;
        }
        ptrClassicFrameLayout3.setHeaderView(getLayoutInflater().inflate(R.layout.view_pull_to_refresh_header, (ViewGroup) null));
        PtrClassicFrameLayout ptrClassicFrameLayout4 = this.getErrorConfigVersion;
        if (ptrClassicFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ptrClassicFrameLayout4 = null;
        }
        View headerView = ptrClassicFrameLayout4.getHeaderView();
        LoadingLottieAnimationView loadingLottieAnimationView = headerView != null ? (LoadingLottieAnimationView) headerView.findViewById(R.id.lav_loading_animation) : null;
        if (loadingLottieAnimationView != null) {
            this.getAuthRequestContext = loadingLottieAnimationView;
            if (loadingLottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                loadingLottieAnimationView = null;
            }
            loadingLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener(this) { // from class: id.dana.social.fragment.BaseFeedTimelineFragment$initPullToRefreshHeaderView$1$1
                final /* synthetic */ BaseFeedTimelineFragment<V> getAuthRequestContext;

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.getAuthRequestContext = this;
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator p0) {
                    LoadingLottieAnimationView loadingLottieAnimationView2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    loadingLottieAnimationView2 = this.getAuthRequestContext.getAuthRequestContext;
                    if (loadingLottieAnimationView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        loadingLottieAnimationView2 = null;
                    }
                    loadingLottieAnimationView2.setupIntroMinMaxFrame(loadingLottieAnimationView2);
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator p0) {
                    PtrClassicFrameLayout ptrClassicFrameLayout5;
                    LoadingLottieAnimationView loadingLottieAnimationView2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    ptrClassicFrameLayout5 = ((BaseFeedTimelineFragment) this.getAuthRequestContext).getErrorConfigVersion;
                    LoadingLottieAnimationView loadingLottieAnimationView3 = null;
                    if (ptrClassicFrameLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        ptrClassicFrameLayout5 = null;
                    }
                    BaseFeedTimelineFragment<V> baseFeedTimelineFragment = this.getAuthRequestContext;
                    loadingLottieAnimationView2 = baseFeedTimelineFragment.getAuthRequestContext;
                    if (loadingLottieAnimationView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        loadingLottieAnimationView3 = loadingLottieAnimationView2;
                    }
                    loadingLottieAnimationView3.setLoopFinished(false);
                    ((BaseFeedTimelineFragment) baseFeedTimelineFragment).initRecordTimeStamp = false;
                    ptrClassicFrameLayout5.refreshComplete();
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator p0) {
                    boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
                    LoadingLottieAnimationView loadingLottieAnimationView2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    NetworkUserEntityData$$ExternalSyntheticLambda3 = this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda3();
                    if (NetworkUserEntityData$$ExternalSyntheticLambda3) {
                        loadingLottieAnimationView2 = this.getAuthRequestContext.getAuthRequestContext;
                        if (loadingLottieAnimationView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            loadingLottieAnimationView2 = null;
                        }
                        BaseFeedTimelineFragment<V> baseFeedTimelineFragment = this.getAuthRequestContext;
                        if (loadingLottieAnimationView2.getIsLoopFinished()) {
                            loadingLottieAnimationView2.cancelAnimation();
                        } else {
                            BaseFeedTimelineFragment.MyBillsEntityDataFactory(baseFeedTimelineFragment);
                        }
                    }
                }
            });
        }
        RecyclerView recyclerView = this.scheduleImpl;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recyclerView = null;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: id.dana.social.fragment.BaseFeedTimelineFragment$onRvFeedsScrolled$1
            final /* synthetic */ BaseFeedTimelineFragment<V> MyBillsEntityDataFactory;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.MyBillsEntityDataFactory = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                PtrClassicFrameLayout ptrClassicFrameLayout5;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                if (p1 == 0 && p2 == 0) {
                    return;
                }
                boolean DatabaseTableConfigUtil = this.MyBillsEntityDataFactory.DatabaseTableConfigUtil();
                this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p2 < 0 && !DatabaseTableConfigUtil);
                ptrClassicFrameLayout5 = ((BaseFeedTimelineFragment) this.MyBillsEntityDataFactory).getErrorConfigVersion;
                if (ptrClassicFrameLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    ptrClassicFrameLayout5 = null;
                }
                ptrClassicFrameLayout5.setEnabled(DatabaseTableConfigUtil && this.MyBillsEntityDataFactory.getNetworkUserEntityData$$ExternalSyntheticLambda0());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrollStateChanged(p0, p1);
                if (p0.canScrollVertically(130) || !this.MyBillsEntityDataFactory.initRecordTimeStamp()) {
                    return;
                }
                this.MyBillsEntityDataFactory.isLayoutRequested();
            }
        });
        RecyclerView recyclerView2 = this.scheduleImpl;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.setAdapter(scheduleImpl());
        recyclerView2.setAnimation(null);
        recyclerView2.setItemViewCacheSize(7);
        this.lookAheadTest.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.social.fragment.BaseFeedTimelineFragment$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                BaseFeedTimelineFragment.getAuthRequestContext(BaseFeedTimelineFragment.this, i);
            }
        });
        CardView cardView2 = this.MyBillsEntityDataFactory;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            cardView = cardView2;
        }
        cardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.fragment.BaseFeedTimelineFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseFeedTimelineFragment.KClassImpl$Data$declaredNonStaticMembers$2(BaseFeedTimelineFragment.this);
            }
        });
    }

    public void FragmentBottomSheetPaymentSettingBinding() {
        this.lookAheadTest.setItems(new ArrayList());
        this.moveToNextValue = new ArrayList();
        SocialFeedsAdapter socialFeedsAdapter = this.lookAheadTest;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FeedViewHolderModel(4, null, null, null, null, false, 60, null));
        socialFeedsAdapter.setItems(arrayList);
    }
}
