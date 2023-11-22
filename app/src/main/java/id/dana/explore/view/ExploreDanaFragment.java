package id.dana.explore.view;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.flexbox.FlexboxLayoutManager;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.SwipeDelegateListener;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.contract.globalsearch.GlobalSearchModule;
import id.dana.contract.promoexplore.PromoExploreModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.mapper.ConnectivityModelMapperKt;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.constant.UrlTag;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerExploreDanaFragmentComponent;
import id.dana.di.modules.OauthModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.homeinfo.SkuAttribute;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.explore.model.ExploreProductModel;
import id.dana.explore.popularplaces.PopularPlacesContract;
import id.dana.explore.popularplaces.PopularPlacesModule;
import id.dana.explore.popularplaces.PopularPlacesView;
import id.dana.explore.popularplaces.model.ExplorePopularPlacesConfigModel;
import id.dana.explore.service.ExploreServiceView;
import id.dana.explore.view.PromoExploreContract;
import id.dana.globalsearch.adapter.PopularSearchAdapter;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.globalsearch.model.TrackerGlobalSearchOpen;
import id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker;
import id.dana.globalsearch.view.GlobalSearchActivity;
import id.dana.model.ThirdPartyService;
import id.dana.promocenter.model.PromoModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.userpersonalization.UserPersonalizationActivity;
import id.dana.utils.LocationUtil;
import id.dana.utils.UrlUtil;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 _2\u00020\u0001:\u0003_`aB\u0007¢\u0006\u0004\b^\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0017H\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0002H\u0002¢\u0006\u0004\b#\u0010\u0004J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010\u0004J\u0017\u0010$\u001a\u00020\u00022\u0006\u0010 \u001a\u00020(H\u0002¢\u0006\u0004\b$\u0010)J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\"J\u000f\u0010*\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u0004J\r\u0010+\u001a\u00020\u0002¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H\u0002¢\u0006\u0004\b,\u0010\u0004J\u000f\u0010-\u001a\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010\u0004J\u001b\u0010!\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020/0.¢\u0006\u0004\b!\u00100J\r\u00101\u001a\u00020\u0002¢\u0006\u0004\b1\u0010\u0004J\u001f\u0010+\u001a\u00020\u00022\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020.H\u0002¢\u0006\u0004\b+\u00100J\r\u00103\u001a\u00020\u0002¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\u0002H\u0002¢\u0006\u0004\b4\u0010\u0004R\u001b\u00109\u001a\u0002058CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u00106\u001a\u0004\b7\u00108R\u001b\u0010!\u001a\u00020:8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b9\u00106\u001a\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020=8\u0007X\u0087&¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010C\u001a\u00020B8\u0007X\u0087&¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\b9\u0010ER\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010FR\u0016\u0010$\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b3\u0010FR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u0010FR\u0016\u0010\u0003\u001a\u00020G8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0003\u0010HR\u0018\u00101\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010M\u001a\u00020L8\u0007X\u0087&¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0016\u0010J\u001a\u00020Q8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0010\u0010RR\u001a\u0010T\u001a\u00020S8\u0007X\u0087&¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001a\u0010Y\u001a\u00020X8\u0007X\u0087&¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b!\u0010[R\u0016\u0010\u0005\u001a\u00020\u00178\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010FR\u0016\u00103\u001a\u00020\\8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\n\u0010]"}, d2 = {"Lid/dana/explore/view/ExploreDanaFragment;", "Lid/dana/base/BaseFragment;", "", "lookAheadTest", "()V", "moveToNextValue", "Lid/dana/contract/globalsearch/GlobalSearchModule;", "GetContactSyncConfig", "()Lid/dana/contract/globalsearch/GlobalSearchModule;", "Lid/dana/home/HomeTabActivity;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Lid/dana/home/HomeTabActivity;", "", "getLayout", "()I", "Lid/dana/explore/popularplaces/PopularPlacesModule;", "DatabaseTableConfigUtil", "()Lid/dana/explore/popularplaces/PopularPlacesModule;", "newProxyInstance", "Lid/dana/contract/promoexplore/PromoExploreModule;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "()Lid/dana/contract/promoexplore/PromoExploreModule;", "PrepareContext", "", "NetworkUserEntityData$$ExternalSyntheticLambda8", "()Z", "BuiltInFictitiousFunctionClassFactory", IAPSyncCommand.COMMAND_INIT, "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda3", "FragmentBottomSheetPaymentSettingBinding", "p0", "getAuthRequestContext", "(Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda6", "PlaceComponentResult", "(I)V", "onPause", "onResume", "Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;", "(Lid/dana/explore/domain/globalsearch/model/GlobalSearchConfig;)V", "NetworkUserEntityData$$ExternalSyntheticLambda5", "MyBillsEntityDataFactory", "whenAvailable", "SubSequence", "", "Lid/dana/promocenter/model/PromoModel;", "(Ljava/util/List;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/homeinfo/SkuAttribute;", "getErrorConfigVersion", "getSupportButtonTintMode", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "Lkotlin/Lazy;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/dialog/DanaLoadingDialog;", "initRecordTimeStamp", "()Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "globalSearchAnalyticTracker", "Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "readMicros", "()Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "globalSearchPresenter", "Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "()Lid/dana/contract/globalsearch/GlobalSearchContract$Presenter;", "Z", "Lid/dana/explore/view/ExploreDanaFragment$ExploreDanaFragmentListener;", "Lid/dana/explore/view/ExploreDanaFragment$ExploreDanaFragmentListener;", "Lio/reactivex/disposables/Disposable;", "scheduleImpl", "Lio/reactivex/disposables/Disposable;", "Lid/dana/explore/popularplaces/PopularPlacesContract$Presenter;", "popularPlacesPresenter", "Lid/dana/explore/popularplaces/PopularPlacesContract$Presenter;", "C", "()Lid/dana/explore/popularplaces/PopularPlacesContract$Presenter;", "Lid/dana/globalsearch/adapter/PopularSearchAdapter;", "Lid/dana/globalsearch/adapter/PopularSearchAdapter;", "Lid/dana/explore/view/PromoExploreContract$Presenter;", "promoExplorePresenter", "Lid/dana/explore/view/PromoExploreContract$Presenter;", "BottomSheetCardBindingView$watcherCardNumberView$1", "()Lid/dana/explore/view/PromoExploreContract$Presenter;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readDeepLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "Lid/dana/home/SwipeDelegateListener;", "Lid/dana/home/SwipeDelegateListener;", "<init>", "Companion", "ExploreDanaFragmentListener", "ExplorePromoListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExploreDanaFragment extends BaseFragment {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
    private static char initRecordTimeStamp = 0;
    private static int isLayoutRequested = 1;
    private static int newProxyInstance;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private PopularSearchAdapter scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private SwipeDelegateListener getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    @Inject
    public GlobalSearchAnalyticTracker globalSearchAnalyticTracker;
    @Inject
    public GlobalSearchContract.Presenter globalSearchPresenter;
    private ExploreDanaFragmentListener lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    @Inject
    public PopularPlacesContract.Presenter popularPlacesPresenter;
    @Inject
    public PromoExploreContract.Presenter promoExplorePresenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readDeepLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.explore.view.ExploreDanaFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(ExploreDanaFragment.this.requireActivity());
        }
    });

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.explore.view.ExploreDanaFragment$connectivityMonitor$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityMonitor invoke() {
            BaseActivity baseActivity = ExploreDanaFragment.this.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            return new ConnectivityMonitor(baseActivity);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/view/ExploreDanaFragment$ExploreDanaFragmentListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ExploreDanaFragmentListener {
        void BuiltInFictitiousFunctionClassFactory(String p0);

        void PlaceComponentResult(String p0);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/view/ExploreDanaFragment$ExplorePromoListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ExplorePromoListener {
        void BuiltInFictitiousFunctionClassFactory(String p0);
    }

    static {
        scheduleImpl();
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = newProxyInstance + 27;
        isLayoutRequested = i % 128;
        if ((i % 2 == 0 ? '\t' : (char) 23) != 23) {
            defaultConstructorMarker.hashCode();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(LinearLayout linearLayout, List list) {
        int i = newProxyInstance + 113;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        moveToNextValue(linearLayout, list);
        try {
            int i3 = newProxyInstance + 75;
            isLayoutRequested = i3 % 128;
            if ((i3 % 2 == 0 ? 'D' : (char) 1) != 1) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ExploreDanaFragment exploreDanaFragment) {
        try {
            int i = newProxyInstance + 23;
            isLayoutRequested = i % 128;
            char c = i % 2 == 0 ? '\r' : (char) 20;
            scheduleImpl(exploreDanaFragment);
            if (c != '\r') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(LinearLayout linearLayout, List list) {
        int i = newProxyInstance + 57;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        getErrorConfigVersion(linearLayout, list);
        try {
            int i3 = isLayoutRequested + 75;
            newProxyInstance = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(LinearLayout linearLayout, List list, ExploreDanaFragment exploreDanaFragment) {
        try {
            int i = isLayoutRequested + 11;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            BuiltInFictitiousFunctionClassFactory(linearLayout, list, exploreDanaFragment);
            int i3 = newProxyInstance + 33;
            try {
                isLayoutRequested = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(LinearLayout linearLayout, List list) {
        int i = newProxyInstance + 47;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda0(linearLayout, list);
        int i3 = newProxyInstance + 55;
        isLayoutRequested = i3 % 128;
        if (i3 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ExploreDanaFragment exploreDanaFragment) {
        try {
            int i = isLayoutRequested + 23;
            newProxyInstance = i % 128;
            boolean z = i % 2 != 0;
            lookAheadTest(exploreDanaFragment);
            if (z) {
                int i2 = 1 / 0;
            }
            int i3 = newProxyInstance + 103;
            isLayoutRequested = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ExploreDanaFragment exploreDanaFragment, ConnectivityModel connectivityModel) {
        int i = newProxyInstance + 91;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        PlaceComponentResult(exploreDanaFragment, connectivityModel);
        int i3 = newProxyInstance + 113;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
    }

    @JvmStatic
    public static final ExploreDanaFragment PlaceComponentResult() {
        ExploreDanaFragment authRequestContext;
        int i = newProxyInstance + 21;
        isLayoutRequested = i % 128;
        if (i % 2 != 0) {
            authRequestContext = Companion.getAuthRequestContext();
        } else {
            authRequestContext = Companion.getAuthRequestContext();
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = newProxyInstance + 75;
            isLayoutRequested = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return authRequestContext;
            }
            int i3 = 7 / 0;
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(ExploreDanaFragment exploreDanaFragment, Location location) {
        int i = isLayoutRequested + 47;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(exploreDanaFragment, location);
        int i3 = isLayoutRequested + 59;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
    }

    public static /* synthetic */ void getAuthRequestContext(LinearLayout linearLayout, List list) {
        try {
            int i = newProxyInstance + 115;
            isLayoutRequested = i % 128;
            boolean z = i % 2 == 0;
            PlaceComponentResult(linearLayout, list);
            if (!z) {
                return;
            }
            int i2 = 50 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ExploreDanaFragment exploreDanaFragment) {
        try {
            int i = newProxyInstance + 17;
            isLayoutRequested = i % 128;
            if (!(i % 2 == 0)) {
                NetworkUserEntityData$$ExternalSyntheticLambda0(exploreDanaFragment);
            } else {
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda0(exploreDanaFragment);
                    int i2 = 27 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = isLayoutRequested + 125;
            newProxyInstance = i3 % 128;
            if (i3 % 2 == 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ExploreDanaFragment exploreDanaFragment, int i) {
        int i2 = newProxyInstance + 13;
        isLayoutRequested = i2 % 128;
        if ((i2 % 2 == 0 ? 'G' : '\t') != '\t') {
            BuiltInFictitiousFunctionClassFactory(exploreDanaFragment, i);
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            BuiltInFictitiousFunctionClassFactory(exploreDanaFragment, i);
        } catch (Exception e) {
            throw e;
        }
    }

    private void getCallingPid() {
        int i = newProxyInstance + 55;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult.clear();
        int i3 = newProxyInstance + 79;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
    }

    static void scheduleImpl() {
        initRecordTimeStamp = (char) 42070;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = new char[]{37292, 37305, 37295, 37294, 37286, 37276, 37309, 37308, 37290};
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0020, code lost:
    
        if ((r3 != null) != true) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        if ((r3 == null ? 1 : 'V') != 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003b, code lost:
    
        r1 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003d, code lost:
    
        r2 = getGetAuthRequestContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0041, code lost:
    
        if (r2 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0043, code lost:
    
        r2 = r2.findViewById(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0047, code lost:
    
        if (r2 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0049, code lost:
    
        r1 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested + 37;
        id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0053, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005a, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x005c, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x005d, code lost:
    
        throw r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getAuthRequestContext(int r6) {
        /*
            r5 = this;
            int r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r0 = r0 + 57
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L27
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5.PlaceComponentResult     // Catch: java.lang.Exception -> L25
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L25
            java.lang.Object r3 = r0.get(r3)     // Catch: java.lang.Exception -> L25
            android.view.View r3 = (android.view.View) r3
            int r4 = r1.length     // Catch: java.lang.Throwable -> L23
            if (r3 != 0) goto L1f
            r4 = 0
            goto L20
        L1f:
            r4 = 1
        L20:
            if (r4 == r2) goto L3b
            goto L3d
        L23:
            r6 = move-exception
            throw r6
        L25:
            r6 = move-exception
            throw r6
        L27:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5.PlaceComponentResult
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            java.lang.Object r3 = r0.get(r3)
            android.view.View r3 = (android.view.View) r3
            if (r3 != 0) goto L37
            r4 = 1
            goto L39
        L37:
            r4 = 86
        L39:
            if (r4 == r2) goto L3d
        L3b:
            r1 = r3
            goto L5e
        L3d:
            android.view.View r2 = r5.getGetAuthRequestContext()
            if (r2 == 0) goto L5e
            android.view.View r2 = r2.findViewById(r6)
            if (r2 == 0) goto L5e
            int r1 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r1 = r1 + 37
            int r3 = r1 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r3
            int r1 = r1 % 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L5c
            r0.put(r6, r2)     // Catch: java.lang.Exception -> L5c
            r1 = r2
            goto L5e
        L5c:
            r6 = move-exception
            throw r6
        L5e:
            int r6 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r6 = r6 + 23
            int r0 = r6 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r0
            int r6 = r6 % 2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.getAuthRequestContext(int):android.view.View");
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        int i = newProxyInstance + 47;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        int i3 = isLayoutRequested + 103;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
        return R.layout.fragment_explore_dana;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        int i = newProxyInstance + 111;
        isLayoutRequested = i % 128;
        boolean z = i % 2 == 0;
        super.onDestroyView();
        getCallingPid();
        if (z) {
            int i2 = 70 / 0;
        }
        try {
            int i3 = isLayoutRequested + 49;
            newProxyInstance = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 28 : 'F') != 28) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ PopularSearchAdapter KClassImpl$Data$declaredNonStaticMembers$2(ExploreDanaFragment exploreDanaFragment) {
        int i = isLayoutRequested + 79;
        newProxyInstance = i % 128;
        if ((i % 2 != 0 ? (char) 19 : 'Y') != 19) {
            return exploreDanaFragment.scheduleImpl;
        }
        PopularSearchAdapter popularSearchAdapter = exploreDanaFragment.scheduleImpl;
        Object[] objArr = null;
        int length = objArr.length;
        return popularSearchAdapter;
    }

    public static final /* synthetic */ DanaLoadingDialog PlaceComponentResult(ExploreDanaFragment exploreDanaFragment) {
        int i = isLayoutRequested + 119;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        DanaLoadingDialog initRecordTimeStamp2 = exploreDanaFragment.initRecordTimeStamp();
        try {
            int i3 = isLayoutRequested + 31;
            newProxyInstance = i3 % 128;
            int i4 = i3 % 2;
            return initRecordTimeStamp2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(ExploreDanaFragment exploreDanaFragment, GlobalSearchConfig globalSearchConfig) {
        int i = newProxyInstance + 83;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        exploreDanaFragment.PlaceComponentResult(globalSearchConfig);
        try {
            int i3 = newProxyInstance + 111;
            isLayoutRequested = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 83 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(ExploreDanaFragment exploreDanaFragment, List list) {
        int i = newProxyInstance + 31;
        isLayoutRequested = i % 128;
        char c = i % 2 == 0 ? (char) 30 : '*';
        exploreDanaFragment.MyBillsEntityDataFactory(list);
        if (c != '*') {
            int i2 = 10 / 0;
        }
        int i3 = isLayoutRequested + 21;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void getErrorConfigVersion(ExploreDanaFragment exploreDanaFragment) {
        try {
            int i = isLayoutRequested + 9;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            exploreDanaFragment.PlaceComponentResult = true;
            try {
                int i3 = isLayoutRequested + 13;
                newProxyInstance = i3 % 128;
                if ((i3 % 2 != 0 ? InputCardNumberView.DIVIDER : (char) 31) != 31) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ boolean moveToNextValue(ExploreDanaFragment exploreDanaFragment) {
        int i = isLayoutRequested + 15;
        newProxyInstance = i % 128;
        char c = i % 2 != 0 ? '-' : '0';
        boolean z = exploreDanaFragment.PlaceComponentResult;
        if (c != '0') {
            Object obj = null;
            obj.hashCode();
        }
        return z;
    }

    @JvmName(name = "getAuthRequestContext")
    public final ReadLinkPropertiesContract.Presenter getAuthRequestContext() {
        ReadLinkPropertiesContract.Presenter presenter = this.readDeepLinkPropertiesPresenter;
        Object[] objArr = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i = isLayoutRequested + 27;
            newProxyInstance = i % 128;
            if (i % 2 != 0) {
                int i2 = 22 / 0;
                return null;
            }
            return null;
        }
        try {
            int i3 = isLayoutRequested + 75;
            newProxyInstance = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return presenter;
            }
            int length = objArr.length;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0010, code lost:
    
        if (r0 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0020, code lost:
    
        if ((r0 != null ? 20 : ',') != 20) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0022, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested + 81;
        id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0031, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0034, code lost:
    
        r1 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested + 103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0038, code lost:
    
        id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003e, code lost:
    
        if ((r1 % 2) == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0040, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0042, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0043, code lost:
    
        if (r1 == true) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0048, code lost:
    
        r1 = 68 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0049, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x004d, code lost:
    
        throw r0;
     */
    @kotlin.jvm.JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.globalsearch.GlobalSearchContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r4 = this;
            int r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L15
            id.dana.contract.globalsearch.GlobalSearchContract$Presenter r0 = r4.globalSearchPresenter
            int r2 = r1.length     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L22
            goto L32
        L13:
            r0 = move-exception
            throw r0
        L15:
            id.dana.contract.globalsearch.GlobalSearchContract$Presenter r0 = r4.globalSearchPresenter
            r2 = 20
            if (r0 == 0) goto L1e
            r3 = 20
            goto L20
        L1e:
            r3 = 44
        L20:
            if (r3 == r2) goto L32
        L22:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r0 = r0 + 81
            int r2 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r2
            int r0 = r0 % 2
            return r1
        L32:
            int r1 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested     // Catch: java.lang.Exception -> L4c
            int r1 = r1 + 103
            int r2 = r1 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r2     // Catch: java.lang.Exception -> L4c
            int r1 = r1 % 2
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L42
            r1 = 1
            goto L43
        L42:
            r1 = 0
        L43:
            if (r1 == r2) goto L46
            goto L49
        L46:
            r1 = 68
            int r1 = r1 / r3
        L49:
            return r0
        L4a:
            r0 = move-exception
            throw r0
        L4c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.KClassImpl$Data$declaredNonStaticMembers$2():id.dana.contract.globalsearch.GlobalSearchContract$Presenter");
    }

    @JvmName(name = "C")
    private PopularPlacesContract.Presenter C() {
        int i = isLayoutRequested + 121;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        PopularPlacesContract.Presenter presenter = this.popularPlacesPresenter;
        if (!(presenter != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i3 = isLayoutRequested + 97;
            newProxyInstance = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 48 / 0;
            }
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "BottomSheetCardBindingView$watcherCardNumberView$1")
    private PromoExploreContract.Presenter BottomSheetCardBindingView$watcherCardNumberView$1() {
        int i = newProxyInstance + 33;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        PromoExploreContract.Presenter presenter = this.promoExplorePresenter;
        Object[] objArr = null;
        if (presenter != null) {
            int i3 = newProxyInstance + 73;
            isLayoutRequested = i3 % 128;
            if ((i3 % 2 == 0 ? '\n' : ']') != '\n') {
                return presenter;
            }
            objArr.hashCode();
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        try {
            int i4 = newProxyInstance + 123;
            try {
                isLayoutRequested = i4 % 128;
                if (i4 % 2 == 0) {
                    int length = objArr.length;
                    return null;
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "readMicros")
    private GlobalSearchAnalyticTracker readMicros() {
        try {
            int i = newProxyInstance + 101;
            isLayoutRequested = i % 128;
            int i2 = i % 2;
            try {
                GlobalSearchAnalyticTracker globalSearchAnalyticTracker = this.globalSearchAnalyticTracker;
                if ((globalSearchAnalyticTracker != null ? 'L' : 'H') == 'H') {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    return null;
                }
                int i3 = isLayoutRequested + 89;
                newProxyInstance = i3 % 128;
                int i4 = i3 % 2;
                return globalSearchAnalyticTracker;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "initRecordTimeStamp")
    private final DanaLoadingDialog initRecordTimeStamp() {
        int i = isLayoutRequested + 27;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.getAuthRequestContext.getValue();
        int i3 = newProxyInstance + 115;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
        return danaLoadingDialog;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda2")
    private final ConnectivityMonitor NetworkUserEntityData$$ExternalSyntheticLambda2() {
        ConnectivityMonitor connectivityMonitor;
        int i = isLayoutRequested + 61;
        newProxyInstance = i % 128;
        if (!(i % 2 != 0)) {
            try {
                connectivityMonitor = (ConnectivityMonitor) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            } catch (Exception e) {
                throw e;
            }
        } else {
            connectivityMonitor = (ConnectivityMonitor) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            int i2 = 11 / 0;
        }
        int i3 = isLayoutRequested + 67;
        newProxyInstance = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 43 / 0;
            return connectivityMonitor;
        }
        return connectivityMonitor;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        int i = newProxyInstance + 59;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        Bundle arguments = getArguments();
        boolean z = true;
        if ((arguments != null ? (char) 18 : ',') != ',') {
            int i3 = newProxyInstance + 75;
            isLayoutRequested = i3 % 128;
            if (!(i3 % 2 != 0)) {
            }
            getAuthRequestContext(z);
            NetworkUserEntityData$$ExternalSyntheticLambda6();
            NetworkUserEntityData$$ExternalSyntheticLambda3();
            isLayoutRequested();
            FragmentBottomSheetPaymentSettingBinding();
            NetworkUserEntityData$$ExternalSyntheticLambda4();
            SubSequence();
            this.getErrorConfigVersion = NetworkUserEntityData$$ExternalSyntheticLambda1().getSwipeDelegateListener();
        }
        z = false;
        getAuthRequestContext(z);
        NetworkUserEntityData$$ExternalSyntheticLambda6();
        NetworkUserEntityData$$ExternalSyntheticLambda3();
        isLayoutRequested();
        FragmentBottomSheetPaymentSettingBinding();
        NetworkUserEntityData$$ExternalSyntheticLambda4();
        SubSequence();
        this.getErrorConfigVersion = NetworkUserEntityData$$ExternalSyntheticLambda1().getSwipeDelegateListener();
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(ExploreDanaFragment exploreDanaFragment, Location location) {
        int i = newProxyInstance + 93;
        isLayoutRequested = i % 128;
        if ((i % 2 == 0 ? (char) 25 : '0') != 25) {
            Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
            exploreDanaFragment.moveToNextValue = false;
            exploreDanaFragment.BottomSheetCardBindingView$watcherCardNumberView$1().MyBillsEntityDataFactory(location);
            exploreDanaFragment.getSupportButtonTintMode();
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
            exploreDanaFragment.moveToNextValue = true;
            exploreDanaFragment.BottomSheetCardBindingView$watcherCardNumberView$1().MyBillsEntityDataFactory(location);
            exploreDanaFragment.getSupportButtonTintMode();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0019, code lost:
    
        if (r0 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0022, code lost:
    
        if (NetworkUserEntityData$$ExternalSyntheticLambda8() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0024, code lost:
    
        getSupportButtonTintMode();
        r0 = new id.dana.utils.LocationUtil.LocationRequestBuilder((android.app.Application) getBaseActivity().getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new id.dana.explore.view.ExploreDanaFragment$$ExternalSyntheticLambda3(r5));
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0;
        addDisposable(r0);
        r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance + 25;
        id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0052, code lost:
    
        if ((r0 % 2) != 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0054, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0055, code lost:
    
        if (r1 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x005a, code lost:
    
        r0 = 56 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x005e, code lost:
    
        BottomSheetCardBindingView$watcherCardNumberView$1().MyBillsEntityDataFactory(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0065, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void moveToNextValue() {
        /*
            r5 = this;
            int r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r0 = r0 + 77
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == 0) goto L1e
            boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8()
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L5e
            goto L24
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8()
            if (r0 == 0) goto L5e
        L24:
            r5.getSupportButtonTintMode()
            id.dana.utils.LocationUtil$LocationRequestBuilder r0 = new id.dana.utils.LocationUtil$LocationRequestBuilder
            id.dana.base.BaseActivity r3 = r5.getBaseActivity()
            id.dana.DanaApplication r3 = r3.getDanaApplication()
            android.app.Application r3 = (android.app.Application) r3
            r0.<init>(r3)
            io.reactivex.Observable r0 = r0.BuiltInFictitiousFunctionClassFactory()
            id.dana.explore.view.ExploreDanaFragment$$ExternalSyntheticLambda3 r3 = new id.dana.explore.view.ExploreDanaFragment$$ExternalSyntheticLambda3
            r3.<init>()
            io.reactivex.disposables.Disposable r0 = r0.subscribe(r3)
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            r5.addDisposable(r0)
            int r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r0 = r0 + 25
            int r3 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L55
            r1 = 0
        L55:
            if (r1 == 0) goto L58
            return
        L58:
            r0 = 56
            int r0 = r0 / r2
            return
        L5c:
            r0 = move-exception
            throw r0
        L5e:
            id.dana.explore.view.PromoExploreContract$Presenter r0 = r5.BottomSheetCardBindingView$watcherCardNumberView$1()
            r0.MyBillsEntityDataFactory(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.moveToNextValue():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        try {
            int i = isLayoutRequested + 105;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            ExplorePromoView explorePromoView = (ExplorePromoView) getAuthRequestContext(R.id.explore_promo_view);
            if (explorePromoView != null) {
                explorePromoView.refreshPromoItems();
                int i3 = newProxyInstance + 101;
                isLayoutRequested = i3 % 128;
                int i4 = i3 % 2;
            }
            moveToNextValue();
            int i5 = newProxyInstance + 31;
            isLayoutRequested = i5 % 128;
            if (!(i5 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void isLayoutRequested() {
        this.lookAheadTest = new ExploreDanaFragmentListener() { // from class: id.dana.explore.view.ExploreDanaFragment$initExploreDanaListener$1
            @Override // id.dana.explore.view.ExploreDanaFragment.ExploreDanaFragmentListener
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ExploreDanaFragment.this.getAuthRequestContext().MyBillsEntityDataFactory(p0);
            }

            @Override // id.dana.explore.view.ExploreDanaFragment.ExploreDanaFragmentListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ExploreDanaFragment.this.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(p0);
            }
        };
        ExploreProductView exploreProductView = (ExploreProductView) getAuthRequestContext(R.id.explore_product_view);
        if ((exploreProductView != null ? 'F' : '/') != 'F') {
            return;
        }
        int i = newProxyInstance + 107;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        ExploreDanaFragmentListener exploreDanaFragmentListener = this.lookAheadTest;
        if ((exploreDanaFragmentListener == null ? 'S' : 'M') == 'S') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            exploreDanaFragmentListener = null;
            int i3 = isLayoutRequested + 13;
            newProxyInstance = i3 % 128;
            int i4 = i3 % 2;
        }
        exploreProductView.setupExploreDanaListener(exploreDanaFragmentListener);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        DaggerExploreDanaFragmentComponent.Builder MyBillsEntityDataFactory = DaggerExploreDanaFragmentComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getBaseActivity();
        byte b = 0;
        Object[] objArr = new Object[1];
        a(new char[]{'\b', 2, 7, 0, 3, 1, 6, '\b'}, (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 22), 8 - Gravity.getAbsoluteGravity(0, 0), objArr);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = ((String) objArr[0]).intern();
        MyBillsEntityDataFactory.getAuthRequestContext = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        MyBillsEntityDataFactory.moveToNextValue = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.explore.view.ExploreDanaFragment$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }
        }));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getBaseActivity();
        MyBillsEntityDataFactory.getErrorConfigVersion = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getBaseActivity();
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory2 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory2, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getBaseActivity();
        MyBillsEntityDataFactory.PlaceComponentResult = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (GlobalSearchModule) Preconditions.getAuthRequestContext(GetContactSyncConfig());
        MyBillsEntityDataFactory.scheduleImpl = (PopularPlacesModule) Preconditions.getAuthRequestContext(DatabaseTableConfigUtil());
        MyBillsEntityDataFactory.lookAheadTest = (PromoExploreModule) Preconditions.getAuthRequestContext(NetworkUserEntityData$$ExternalSyntheticLambda7());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getErrorConfigVersion, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, OauthModule.class);
        if (MyBillsEntityDataFactory.moveToNextValue == null) {
            MyBillsEntityDataFactory.moveToNextValue = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, GlobalSearchModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.scheduleImpl, PopularPlacesModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.lookAheadTest, PromoExploreModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerExploreDanaFragmentComponent.ExploreDanaFragmentComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.getErrorConfigVersion, MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.moveToNextValue, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.scheduleImpl, MyBillsEntityDataFactory.lookAheadTest, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).PlaceComponentResult(this);
        int i = newProxyInstance + 75;
        isLayoutRequested = i % 128;
        if ((i % 2 == 0 ? '8' : '%') != '8') {
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
    }

    private final GlobalSearchModule GetContactSyncConfig() {
        GlobalSearchModule globalSearchModule = new GlobalSearchModule(new GlobalSearchContract.View() { // from class: id.dana.explore.view.ExploreDanaFragment$getGlobalSearchView$1
            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                GlobalSearchContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SearchResultModel searchResultModel) {
                Intrinsics.checkNotNullParameter(searchResultModel, "");
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
                GlobalSearchContract.View.CC.PlaceComponentResult(str);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2() {
                GlobalSearchContract.View.CC.scheduleImpl();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SearchResultModel searchResultModel) {
                GlobalSearchContract.View.CC.MyBillsEntityDataFactory(searchResultModel);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                GlobalSearchContract.View.CC.getAuthRequestContext(str);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(SearchResultModel searchResultModel) {
                GlobalSearchContract.View.CC.getAuthRequestContext(searchResultModel);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
                GlobalSearchContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void PlaceComponentResult(ThirdPartyServiceResponse thirdPartyServiceResponse, String str, String str2) {
                GlobalSearchContract.View.CC.MyBillsEntityDataFactory(thirdPartyServiceResponse, str);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void PlaceComponentResult(SearchResultModel searchResultModel) {
                GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(searchResultModel);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void PlaceComponentResult(List list) {
                GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void getAuthRequestContext() {
                GlobalSearchContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void getAuthRequestContext(ThirdPartyServiceResponse thirdPartyServiceResponse, String str) {
                GlobalSearchContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2(thirdPartyServiceResponse, str);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void getAuthRequestContext(SearchResultModel searchResultModel) {
                GlobalSearchContract.View.CC.PlaceComponentResult(searchResultModel);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void getAuthRequestContext(List list) {
                GlobalSearchContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void getAuthRequestContext(boolean z) {
                GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void lookAheadTest(SearchResultModel searchResultModel) {
                GlobalSearchContract.View.CC.scheduleImpl(searchResultModel);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final /* synthetic */ void scheduleImpl() {
                GlobalSearchContract.View.CC.moveToNextValue();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaH5.startContainerFullUrl(p0);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void MyBillsEntityDataFactory(List<String> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if ((!p0.isEmpty()) != false) {
                    PopularSearchAdapter KClassImpl$Data$declaredNonStaticMembers$2 = ExploreDanaFragment.KClassImpl$Data$declaredNonStaticMembers$2(ExploreDanaFragment.this);
                    if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.setItems(p0);
                    LinearLayout linearLayout = (LinearLayout) ExploreDanaFragment.this.getAuthRequestContext(R.id.ll_container_popular);
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                        return;
                    }
                    return;
                }
                LinearLayout linearLayout2 = (LinearLayout) ExploreDanaFragment.this.getAuthRequestContext(R.id.ll_container_popular);
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaLoadingDialog PlaceComponentResult = ExploreDanaFragment.PlaceComponentResult(ExploreDanaFragment.this);
                if (PlaceComponentResult.MyBillsEntityDataFactory.isShowing()) {
                    return;
                }
                PlaceComponentResult.MyBillsEntityDataFactory.show();
                PlaceComponentResult.getAuthRequestContext.startRefresh();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                ExploreDanaFragment.PlaceComponentResult(ExploreDanaFragment.this).PlaceComponentResult();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void MyBillsEntityDataFactory(GlobalSearchConfig p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ExploreDanaFragment.getAuthRequestContext(ExploreDanaFragment.this, p0);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<ThirdPartyServiceResponse> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ExploreProductView exploreProductView = (ExploreProductView) ExploreDanaFragment.this.getAuthRequestContext(R.id.explore_product_view);
                if (exploreProductView != null) {
                    exploreProductView.setPostPaidProfileKey(ExploreDanaFragment.this.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(p0));
                }
                ExploreDanaFragment exploreDanaFragment = ExploreDanaFragment.this;
                List<ThirdPartyServiceResponse> list = p0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ThirdPartyServiceResponse thirdPartyServiceResponse : list) {
                    SkuAttribute skuAttr = thirdPartyServiceResponse.getSkuAttr();
                    if (skuAttr != null) {
                        skuAttr.setAppId(thirdPartyServiceResponse.getAppId());
                    } else {
                        skuAttr = null;
                    }
                    arrayList.add(skuAttr);
                }
                ExploreDanaFragment.getAuthRequestContext(exploreDanaFragment, arrayList);
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void scheduleImpl(SearchResultModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ExploreOnlineMerchantView exploreOnlineMerchantView = (ExploreOnlineMerchantView) ExploreDanaFragment.this.getAuthRequestContext(R.id.explore_online_merchant);
                if (exploreOnlineMerchantView != null) {
                    exploreOnlineMerchantView.setListItem(p0.getAuthRequestContext);
                }
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void moveToNextValue() {
                Context context = ExploreDanaFragment.this.getContext();
                if (context != null) {
                    ExploreDanaFragment exploreDanaFragment = ExploreDanaFragment.this;
                    if (ExploreDanaFragment.moveToNextValue(exploreDanaFragment)) {
                        return;
                    }
                    UserPersonalizationActivity.Companion companion = UserPersonalizationActivity.INSTANCE;
                    UserPersonalizationActivity.Companion.MyBillsEntityDataFactory(context);
                    ExploreDanaFragment.getErrorConfigVersion(exploreDanaFragment);
                }
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void lookAheadTest() {
                ExploreDanaFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }

            @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
            public final void MyBillsEntityDataFactory() {
                ExploreDanaFragment.this.BuiltInFictitiousFunctionClassFactory();
            }
        });
        try {
            int i = isLayoutRequested + 49;
            try {
                newProxyInstance = i % 128;
                int i2 = i % 2;
                return globalSearchModule;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:203:0x005e, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x005e, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(id.dana.explore.domain.globalsearch.model.GlobalSearchConfig r10) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.PlaceComponentResult(id.dana.explore.domain.globalsearch.model.GlobalSearchConfig):void");
    }

    private static final void PlaceComponentResult(LinearLayout linearLayout, List list) {
        Object obj;
        int i = newProxyInstance + 57;
        isLayoutRequested = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(linearLayout, "");
            Intrinsics.checkNotNullParameter(list, "");
            obj = list.get(0);
        } else {
            Intrinsics.checkNotNullParameter(linearLayout, "");
            Intrinsics.checkNotNullParameter(list, "");
            obj = list.get(1);
        }
        linearLayout.addView((View) obj);
        int i2 = isLayoutRequested + 103;
        newProxyInstance = i2 % 128;
        int i3 = i2 % 2;
    }

    private static final void NetworkUserEntityData$$ExternalSyntheticLambda0(LinearLayout linearLayout, List list) {
        int i = isLayoutRequested + 51;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(linearLayout, "");
        Intrinsics.checkNotNullParameter(list, "");
        linearLayout.addView((View) list.get(1));
        try {
            int i3 = newProxyInstance + 125;
            try {
                isLayoutRequested = i3 % 128;
                if (i3 % 2 == 0) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void getErrorConfigVersion(LinearLayout linearLayout, List list) {
        int i = isLayoutRequested + 25;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(linearLayout, "");
        Intrinsics.checkNotNullParameter(list, "");
        linearLayout.addView((View) list.get(2));
        int i3 = isLayoutRequested + 111;
        newProxyInstance = i3 % 128;
        if ((i3 % 2 != 0 ? ',' : Typography.less) != ',') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private static final void moveToNextValue(LinearLayout linearLayout, List list) {
        int i;
        int i2 = newProxyInstance + 121;
        isLayoutRequested = i2 % 128;
        if ((i2 % 2 == 0 ? '0' : 'V') != '0') {
            Intrinsics.checkNotNullParameter(linearLayout, "");
            Intrinsics.checkNotNullParameter(list, "");
            i = 3;
        } else {
            Intrinsics.checkNotNullParameter(linearLayout, "");
            Intrinsics.checkNotNullParameter(list, "");
            i = 4;
        }
        linearLayout.addView((View) list.get(i));
        int i3 = isLayoutRequested + 75;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
    }

    private static final void BuiltInFictitiousFunctionClassFactory(LinearLayout linearLayout, List list, ExploreDanaFragment exploreDanaFragment) {
        int i = newProxyInstance + 63;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(linearLayout, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
            linearLayout.addView((View) list.get(4));
            exploreDanaFragment.moveToNextValue();
            int i3 = isLayoutRequested + 113;
            newProxyInstance = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final PopularPlacesModule DatabaseTableConfigUtil() {
        PopularPlacesModule popularPlacesModule = new PopularPlacesModule(new PopularPlacesContract.View() { // from class: id.dana.explore.view.ExploreDanaFragment$getPopularPlacesView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.explore.popularplaces.PopularPlacesContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                PopularPlacesView popularPlacesView = (PopularPlacesView) ExploreDanaFragment.this.getAuthRequestContext(R.id.res_0x7f0a0fc8_userpocketassetsdao_impl_2);
                if (popularPlacesView != null) {
                    popularPlacesView.showShimmer();
                }
            }

            @Override // id.dana.explore.popularplaces.PopularPlacesContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<ExplorePopularPlacesConfigModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PopularPlacesView popularPlacesView = (PopularPlacesView) ExploreDanaFragment.this.getAuthRequestContext(R.id.res_0x7f0a0fc8_userpocketassetsdao_impl_2);
                if (popularPlacesView != null) {
                    popularPlacesView.hideShimmer();
                    popularPlacesView.loadData(p0);
                }
            }

            @Override // id.dana.explore.popularplaces.PopularPlacesContract.View
            public final void MyBillsEntityDataFactory() {
                PopularPlacesView popularPlacesView = (PopularPlacesView) ExploreDanaFragment.this.getAuthRequestContext(R.id.res_0x7f0a0fc8_userpocketassetsdao_impl_2);
                if (popularPlacesView != null) {
                    popularPlacesView.hideShimmer();
                    popularPlacesView.setVisibility(8);
                }
            }
        });
        int i = isLayoutRequested + 89;
        newProxyInstance = i % 128;
        if (i % 2 == 0) {
            return popularPlacesModule;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return popularPlacesModule;
    }

    private final PromoExploreModule NetworkUserEntityData$$ExternalSyntheticLambda7() {
        PromoExploreModule promoExploreModule = new PromoExploreModule(new PromoExploreContract.View() { // from class: id.dana.explore.view.ExploreDanaFragment$getPromoExploreView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.explore.view.PromoExploreContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends PromoModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ExploreDanaFragment.this.getAuthRequestContext(p0);
            }

            @Override // id.dana.explore.view.PromoExploreContract.View
            public final void getAuthRequestContext() {
                ExplorePromoView explorePromoView = (ExplorePromoView) ExploreDanaFragment.this.getAuthRequestContext(R.id.explore_promo_view);
                if (explorePromoView != null) {
                    explorePromoView.setVisibility(8);
                }
            }
        });
        int i = isLayoutRequested + 49;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        return promoExploreModule;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x001d, code lost:
    
        if ((r0 == null) != true) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0031, code lost:
    
        if ((r0 != null ? '*' : 6) != 6) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0033, code lost:
    
        r0.requestFocus();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(boolean r6) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.getAuthRequestContext(boolean):void");
    }

    private static final void NetworkUserEntityData$$ExternalSyntheticLambda0(ExploreDanaFragment exploreDanaFragment) {
        try {
            Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
            Intent intent = new Intent(exploreDanaFragment.getContext(), GlobalSearchActivity.class);
            TrackerGlobalSearchOpen.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SourceType.EXPLORE);
            exploreDanaFragment.startActivity(intent);
            int i = newProxyInstance + 1;
            isLayoutRequested = i % 128;
            if ((i % 2 == 0 ? '7' : '9') != '7') {
                return;
            }
            int i2 = 3 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void lookAheadTest(ExploreDanaFragment exploreDanaFragment) {
        int i = isLayoutRequested + 63;
        newProxyInstance = i % 128;
        if ((i % 2 != 0 ? '=' : (char) 11) != 11) {
            Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
            exploreDanaFragment.requireActivity().onBackPressed();
            Object obj = null;
            obj.hashCode();
            return;
        }
        Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
        exploreDanaFragment.requireActivity().onBackPressed();
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x001a, code lost:
    
        if (r0 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x002c, code lost:
    
        if ((r0 == null) != true) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x002e, code lost:
    
        r4 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance + 17;
        id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0038, code lost:
    
        if ((r4 % 2) != 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x003a, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x003b, code lost:
    
        if (r2 == true) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x003d, code lost:
    
        r0 = r0.getLayoutParams();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0041, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0043, code lost:
    
        r0 = r0.getLayoutParams();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0047, code lost:
    
        r1.hashCode();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void whenAvailable() {
        /*
            r6 = this;
            int r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance     // Catch: java.lang.Exception -> L8e
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r1     // Catch: java.lang.Exception -> L8c
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1f
            int r0 = id.dana.R.id.complexToDimensionPixelOffset     // Catch: java.lang.Exception -> L8e
            android.view.View r0 = r6.getAuthRequestContext(r0)     // Catch: java.lang.Exception -> L8c
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0     // Catch: java.lang.Exception -> L8c
            r4 = 40
            int r4 = r4 / r2
            if (r0 == 0) goto L4d
            goto L2e
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            int r0 = id.dana.R.id.complexToDimensionPixelOffset
            android.view.View r0 = r6.getAuthRequestContext(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L2b
            r4 = 0
            goto L2c
        L2b:
            r4 = 1
        L2c:
            if (r4 == r3) goto L4d
        L2e:
            int r4 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r4 = r4 + 17
            int r5 = r4 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L3b
            r2 = 1
        L3b:
            if (r2 == r3) goto L43
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
        L41:
            r1 = r0
            goto L4d
        L43:
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r1.hashCode()     // Catch: java.lang.Throwable -> L4b
            goto L41
        L4b:
            r0 = move-exception
            throw r0
        L4d:
            if (r1 == 0) goto L84
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r0 = r1.leftMargin
            int r2 = r1.topMargin
            r3 = 10
            int r3 = id.dana.utils.SizeUtil.getAuthRequestContext(r3)
            int r4 = r1.bottomMargin
            r1.setMargins(r0, r2, r3, r4)
            int r0 = id.dana.R.id.complexToDimensionPixelOffset
            android.view.View r0 = r6.getAuthRequestContext(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L83
            int r2 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r2 = r2 + 25
            int r3 = r2 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r3
            int r2 = r2 % 2
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r0.setLayoutParams(r1)
            int r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1
            int r0 = r0 % 2
        L83:
            return
        L84:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams"
            r0.<init>(r1)
            throw r0
        L8c:
            r0 = move-exception
            throw r0
        L8e:
            r0 = move-exception
            goto L91
        L90:
            throw r0
        L91:
            goto L90
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.whenAvailable():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        PopularSearchAdapter popularSearchAdapter = new PopularSearchAdapter();
        try {
            popularSearchAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.explore.view.ExploreDanaFragment$$ExternalSyntheticLambda0
                @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
                public final void onItemClick(int i) {
                    ExploreDanaFragment.getAuthRequestContext(ExploreDanaFragment.this, i);
                }
            });
            this.scheduleImpl = popularSearchAdapter;
            RecyclerView recyclerView = (RecyclerView) getAuthRequestContext(R.id.rv_popular_search);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new FlexboxLayoutManager(recyclerView.getContext(), 0));
                PopularSearchAdapter popularSearchAdapter2 = this.scheduleImpl;
                if (popularSearchAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    popularSearchAdapter2 = null;
                    int i = isLayoutRequested + 75;
                    newProxyInstance = i % 128;
                    int i2 = i % 2;
                }
                try {
                    recyclerView.setAdapter(popularSearchAdapter2);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = isLayoutRequested + 107;
            newProxyInstance = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void BuiltInFictitiousFunctionClassFactory(ExploreDanaFragment exploreDanaFragment, int i) {
        try {
            int i2 = newProxyInstance + 9;
            isLayoutRequested = i2 % 128;
            if (i2 % 2 != 0) {
                Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
                exploreDanaFragment.PlaceComponentResult(i);
            } else {
                Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
                exploreDanaFragment.PlaceComponentResult(i);
                Object obj = null;
                obj.hashCode();
            }
            int i3 = newProxyInstance + 55;
            isLayoutRequested = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void PlaceComponentResult(int p0) {
        Intent intent = new Intent(getContext(), GlobalSearchActivity.class);
        PopularSearchAdapter popularSearchAdapter = this.scheduleImpl;
        Object[] objArr = null;
        if ((popularSearchAdapter == null ? (char) 28 : '9') == 28) {
            try {
                int i = isLayoutRequested + 27;
                newProxyInstance = i % 128;
                if ((i % 2 != 0 ? (char) 22 : ']') != 22) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    int length = objArr.length;
                }
                popularSearchAdapter = null;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            Intent putExtra = intent.putExtra("SEARCH_PARAMS", popularSearchAdapter.getItem(p0)).putExtra("IS_FROM_POPULAR_SEARCH_EXPLORE", true);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            TrackerGlobalSearchOpen.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.SourceType.EXPLORE);
            startActivity(putExtra);
            int i2 = isLayoutRequested + 93;
            newProxyInstance = i2 % 128;
            if (i2 % 2 != 0) {
                objArr.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void FragmentBottomSheetPaymentSettingBinding() {
        ((ExplorePromoView) getAuthRequestContext(R.id.explore_promo_view)).setPromoListener(new ExplorePromoListener() { // from class: id.dana.explore.view.ExploreDanaFragment$initPromoListener$explorePromoListener$1
            @Override // id.dana.explore.view.ExploreDanaFragment.ExplorePromoListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                HashMap hashMap = new HashMap();
                hashMap.put(UrlTag.DETAIL_SOURCE, "sponsored");
                hashMap.put("entryPoint", TopupSource.PROMOTION_CENTER);
                if (StringsKt.contains$default((CharSequence) p0, (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null)) {
                    ExploreDanaFragment.this.getAuthRequestContext().MyBillsEntityDataFactory(p0);
                    return;
                }
                String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(UrlUtil.getAuthRequestContext(p0, hashMap), TopupSource.PROMOTION_CENTER);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                DanaH5.startContainerFullUrl(BuiltInFictitiousFunctionClassFactory);
            }
        });
        try {
            int i = isLayoutRequested + 119;
            newProxyInstance = i % 128;
            if ((i % 2 != 0 ? 'Z' : 'G') != 'G') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void MyBillsEntityDataFactory(List<SkuAttribute> p0) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = p0.iterator();
            while (true) {
                if ((it.hasNext() ? (char) 21 : (char) 0) != 21) {
                    break;
                }
                int i = newProxyInstance + 7;
                isLayoutRequested = i % 128;
                int i2 = i % 2;
                SkuAttribute skuAttribute = (SkuAttribute) it.next();
                if ((skuAttribute != null ? 'A' : (char) 7) != 7) {
                    ExploreProductModel.Companion companion = ExploreProductModel.INSTANCE;
                    arrayList.add(ExploreProductModel.Companion.PlaceComponentResult(skuAttribute));
                }
            }
            ExploreProductView exploreProductView = (ExploreProductView) getAuthRequestContext(R.id.explore_product_view);
            if (exploreProductView != null) {
                try {
                    int i3 = newProxyInstance + 93;
                    isLayoutRequested = i3 % 128;
                    if (!(i3 % 2 == 0)) {
                        exploreProductView.setItems(arrayList);
                        return;
                    }
                    exploreProductView.setItems(arrayList);
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void PrepareContext() {
        try {
            if (this.globalSearchPresenter != null) {
                int i = newProxyInstance + 109;
                isLayoutRequested = i % 128;
                if (i % 2 == 0) {
                    KClassImpl$Data$declaredNonStaticMembers$2().moveToNextValue();
                    int i2 = 20 / 0;
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2().moveToNextValue();
                }
            }
            int i3 = newProxyInstance + 57;
            isLayoutRequested = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 2 : '9') != 2) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private final void lookAheadTest() {
        try {
            int i = isLayoutRequested + 115;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            if (!(this.globalSearchPresenter != null)) {
                return;
            }
            int i3 = isLayoutRequested + 81;
            try {
                newProxyInstance = i3 % 128;
                int i4 = i3 % 2;
                KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void newProxyInstance() {
        if (this.globalSearchPresenter != null) {
            int i = isLayoutRequested + 19;
            newProxyInstance = i % 128;
            if (!(i % 2 != 0)) {
                KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult();
            } else {
                try {
                    try {
                        KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult();
                        int i2 = 79 / 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        int i3 = isLayoutRequested + 53;
        newProxyInstance = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        try {
            int i = newProxyInstance + 119;
            isLayoutRequested = i % 128;
            int i2 = i % 2;
            super.onResume();
            if (this.moveToNextValue) {
                NetworkUserEntityData$$ExternalSyntheticLambda5();
                int i3 = isLayoutRequested + 121;
                newProxyInstance = i3 % 128;
                int i4 = i3 % 2;
            }
            NetworkUserEntityData$$ExternalSyntheticLambda2().PlaceComponentResult(this, new Observer() { // from class: id.dana.explore.view.ExploreDanaFragment$$ExternalSyntheticLambda2
                @Override // androidx.view.Observer
                public final void onChanged(Object obj) {
                    ExploreDanaFragment.MyBillsEntityDataFactory(ExploreDanaFragment.this, (ConnectivityModel) obj);
                }
            });
            int i5 = newProxyInstance + 85;
            isLayoutRequested = i5 % 128;
            if ((i5 % 2 == 0 ? '@' : '\'') != '\'') {
                int i6 = 71 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void PlaceComponentResult(ExploreDanaFragment exploreDanaFragment, ConnectivityModel connectivityModel) {
        int i = newProxyInstance + 57;
        isLayoutRequested = i % 128;
        if ((i % 2 == 0 ? '3' : 'E') != '3') {
            try {
                Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
                Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
                exploreDanaFragment.BuiltInFictitiousFunctionClassFactory(ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel));
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
            Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
            exploreDanaFragment.BuiltInFictitiousFunctionClassFactory(ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel));
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = newProxyInstance + 23;
        isLayoutRequested = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0027, code lost:
    
        if (r4.MyBillsEntityDataFactory == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x002f, code lost:
    
        if (r4.MyBillsEntityDataFactory == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0031, code lost:
    
        KClassImpl$Data$declaredNonStaticMembers$2().NetworkUserEntityData$$ExternalSyntheticLambda0();
        C().getAuthRequestContext();
        PrepareContext();
        lookAheadTest();
        newProxyInstance();
        r4.MyBillsEntityDataFactory = true;
        NetworkUserEntityData$$ExternalSyntheticLambda2().PlaceComponentResult((androidx.view.LifecycleOwner) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0054, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(boolean r5) {
        /*
            r4 = this;
            boolean r0 = r4.isVisible()
            if (r0 != 0) goto L7
            return
        L7:
            r0 = 1
            r1 = 0
            if (r5 == 0) goto Ld
            r2 = 1
            goto Le
        Ld:
            r2 = 0
        Le:
            if (r2 == 0) goto L57
            int r2 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r2 = r2 + 85
            int r3 = r2 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r3
            int r2 = r2 % 2
            r3 = 28
            if (r2 != 0) goto L21
            r2 = 28
            goto L23
        L21:
            r2 = 9
        L23:
            if (r2 == r3) goto L2a
            boolean r1 = r4.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L85
            if (r1 != 0) goto L57
            goto L31
        L2a:
            boolean r2 = r4.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L87
            r3 = 31
            int r3 = r3 / r1
            if (r2 != 0) goto L57
        L31:
            id.dana.contract.globalsearch.GlobalSearchContract$Presenter r5 = r4.KClassImpl$Data$declaredNonStaticMembers$2()
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0()
            id.dana.explore.popularplaces.PopularPlacesContract$Presenter r5 = r4.C()
            r5.getAuthRequestContext()
            r4.PrepareContext()
            r4.lookAheadTest()
            r4.newProxyInstance()
            r4.MyBillsEntityDataFactory = r0
            id.dana.core.ui.util.connectivity.ConnectivityMonitor r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2()
            r0 = r4
            androidx.lifecycle.LifecycleOwner r0 = (androidx.view.LifecycleOwner) r0
            r5.PlaceComponentResult(r0)
            return
        L55:
            r5 = move-exception
            throw r5
        L57:
            if (r5 == 0) goto L89
            int r5 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance     // Catch: java.lang.Exception -> L87
            int r5 = r5 + 89
            int r0 = r5 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r0     // Catch: java.lang.Exception -> L85
            int r5 = r5 % 2
            boolean r5 = r4.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L85
            r0 = 56
            if (r5 == 0) goto L6c
            r5 = 56
            goto L6e
        L6c:
            r5 = 48
        L6e:
            if (r5 == r0) goto L71
            goto L89
        L71:
            r4.PrepareContext()
            r4.lookAheadTest()
            r4.newProxyInstance()
            id.dana.core.ui.util.connectivity.ConnectivityMonitor r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda2()
            r0 = r4
            androidx.lifecycle.LifecycleOwner r0 = (androidx.view.LifecycleOwner) r0
            r5.PlaceComponentResult(r0)
            goto L89
        L85:
            r5 = move-exception
            throw r5
        L87:
            r5 = move-exception
            throw r5
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.BuiltInFictitiousFunctionClassFactory(boolean):void");
    }

    private final HomeTabActivity NetworkUserEntityData$$ExternalSyntheticLambda1() {
        try {
            int i = isLayoutRequested + 39;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            FragmentActivity activity = getActivity();
            if ((activity != null ? (char) 25 : (char) 30) == 25) {
                int i3 = newProxyInstance + 7;
                isLayoutRequested = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return (HomeTabActivity) activity;
                }
                HomeTabActivity homeTabActivity = (HomeTabActivity) activity;
                Object[] objArr = null;
                int length = objArr.length;
                return homeTabActivity;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.home.HomeTabActivity");
        } catch (Exception e) {
            throw e;
        }
    }

    public final void getErrorConfigVersion() {
        int i = newProxyInstance + 41;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        if ((this.globalSearchAnalyticTracker != null ? (char) 4 : '/') != '/') {
            try {
                int i3 = isLayoutRequested + 29;
                try {
                    newProxyInstance = i3 % 128;
                    if ((i3 % 2 != 0 ? 'V' : 'I') != 'I') {
                        readMicros().PlaceComponentResult();
                        Object[] objArr = null;
                        int length = objArr.length;
                        return;
                    }
                    readMicros().PlaceComponentResult();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        try {
            if ((getContext() == null ? 'a' : 'Y') != 'a') {
                try {
                    if (LocationUtil.BuiltInFictitiousFunctionClassFactory(getContext())) {
                        int i = newProxyInstance + 59;
                        isLayoutRequested = i % 128;
                        int i2 = i % 2;
                        return !(!LocationUtil.getAuthRequestContext(getContext()));
                    }
                    return false;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = newProxyInstance + 125;
            isLayoutRequested = i3 % 128;
            int i4 = i3 % 2;
            return false;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x001f, code lost:
    
        if ((r0 != null) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0026, code lost:
    
        if (r0 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0028, code lost:
    
        r1 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested + 105;
        id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0032, code lost:
    
        if ((r1 % 2) == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0034, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.dispose();
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003e, code lost:
    
        r0 = 42 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0042, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0.dispose();
        r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getSupportButtonTintMode() {
        /*
            r5 = this;
            int r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested     // Catch: java.lang.Exception -> L55
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1     // Catch: java.lang.Exception -> L55
            int r0 = r0 % 2
            r1 = 32
            if (r0 == 0) goto L11
            r0 = 70
            goto L13
        L11:
            r0 = 32
        L13:
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L24
            io.reactivex.disposables.Disposable r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r3.length     // Catch: java.lang.Throwable -> L22
            if (r0 == 0) goto L1e
            r1 = 1
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 == 0) goto L4a
            goto L28
        L22:
            r0 = move-exception
            throw r0
        L24:
            io.reactivex.disposables.Disposable r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r0 == 0) goto L4a
        L28:
            int r1 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r1 = r1 + 105
            int r4 = r1 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r4
            int r1 = r1 % 2
            if (r1 == 0) goto L42
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.dispose()
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3
            r0 = 42
            int r0 = r0 / r2
            goto L4a
        L40:
            r0 = move-exception
            throw r0
        L42:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r0.dispose()
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3
        L4a:
            int r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r1
            int r0 = r0 % 2
            return
        L55:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.getSupportButtonTintMode():void");
    }

    private final void SubSequence() {
        TextView textView = (TextView) getAuthRequestContext(R.id.getMinSeparation);
        if (!(textView == null)) {
            int i = isLayoutRequested + 103;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            textView.setContentDescription(getString(R.string.btn_x));
        }
        TextView textView2 = (TextView) getAuthRequestContext(R.id.getDataset2Color);
        if ((textView2 != null ? '.' : Typography.amp) != '&') {
            int i3 = newProxyInstance + 113;
            isLayoutRequested = i3 % 128;
            int i4 = i3 % 2;
            textView2.setContentDescription(getString(R.string.lbl_header));
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        int i = isLayoutRequested + 115;
        newProxyInstance = i % 128;
        if (i % 2 == 0) {
            super.onPause();
            this.moveToNextValue = true;
        } else {
            super.onPause();
            this.moveToNextValue = false;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2().PlaceComponentResult((LifecycleOwner) this);
    }

    public final void MyBillsEntityDataFactory() {
        try {
            int i = isLayoutRequested + 5;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            ExploreServiceView exploreServiceView = (ExploreServiceView) getAuthRequestContext(R.id.explore_service_view);
            if (exploreServiceView != null) {
                int i3 = newProxyInstance + 71;
                isLayoutRequested = i3 % 128;
                int i4 = i3 % 2;
                exploreServiceView.fetchData();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        try {
            int i = newProxyInstance + 79;
            isLayoutRequested = i % 128;
            int i2 = i % 2;
            LinearLayout linearLayout = (LinearLayout) getAuthRequestContext(R.id.ll_personalization_entry);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.explore.view.ExploreDanaFragment$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ExploreDanaFragment.BuiltInFictitiousFunctionClassFactory(ExploreDanaFragment.this);
                    }
                });
            }
            int i3 = newProxyInstance + 69;
            isLayoutRequested = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void scheduleImpl(ExploreDanaFragment exploreDanaFragment) {
        int i = newProxyInstance + 79;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(exploreDanaFragment, "");
        Context context = exploreDanaFragment.getContext();
        if ((context != null ? 'W' : Typography.dollar) != '$') {
            try {
                int i3 = newProxyInstance + 85;
                isLayoutRequested = i3 % 128;
                int i4 = i3 % 2;
                UserPersonalizationActivity.Companion companion = UserPersonalizationActivity.INSTANCE;
                UserPersonalizationActivity.Companion.MyBillsEntityDataFactory(context);
            } catch (Exception e) {
                throw e;
            }
        }
        int i5 = isLayoutRequested + 29;
        newProxyInstance = i5 % 128;
        int i6 = i5 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x002a, code lost:
    
        if ((r0 != null ? '/' : '+') != '+') goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0040, code lost:
    
        if ((r0 != null ? '-' : '#') != '#') goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0042, code lost:
    
        r0.setVisibility(0);
        r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance + 21;
        id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r0 % 128;
        r0 = r0 % 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        /*
            r5 = this;
            boolean r0 = r5.BuiltInFictitiousFunctionClassFactory
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            if (r0 == 0) goto L88
            int r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r0 = r0 + r2
            int r3 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L2f
            int r0 = id.dana.R.id.ll_personalization_entry
            android.view.View r0 = r5.getAuthRequestContext(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r3 = 17
            int r3 = r3 / r1
            r3 = 43
            if (r0 == 0) goto L28
            r4 = 47
            goto L2a
        L28:
            r4 = 43
        L2a:
            if (r4 == r3) goto L4f
            goto L42
        L2d:
            r0 = move-exception
            throw r0
        L2f:
            int r0 = id.dana.R.id.ll_personalization_entry
            android.view.View r0 = r5.getAuthRequestContext(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r3 = 35
            if (r0 == 0) goto L3e
            r4 = 45
            goto L40
        L3e:
            r4 = 35
        L40:
            if (r4 == r3) goto L4f
        L42:
            r0.setVisibility(r1)
            int r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r0 = r0 + 21
            int r3 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r3
            int r0 = r0 % 2
        L4f:
            int r0 = id.dana.R.id.ll_personalization_entry
            android.view.View r0 = r5.getAuthRequestContext(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L5b
            r3 = 0
            goto L5c
        L5b:
            r3 = 1
        L5c:
            if (r3 == r2) goto L86
            int r0 = r0.getHeight()     // Catch: java.lang.Exception -> L84
            int r3 = id.dana.R.id.ll_personalization_entry     // Catch: java.lang.Exception -> L84
            android.view.View r3 = r5.getAuthRequestContext(r3)     // Catch: java.lang.Exception -> L84
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3     // Catch: java.lang.Exception -> L84
            if (r3 == 0) goto L86
            android.view.ViewPropertyAnimator r3 = r3.animate()
            if (r3 == 0) goto L86
            float r0 = (float) r0
            android.view.ViewPropertyAnimator r0 = r3.translationY(r0)
            if (r0 == 0) goto L7a
            goto L7b
        L7a:
            r1 = 1
        L7b:
            if (r1 == 0) goto L7e
            goto L86
        L7e:
            r3 = 800(0x320, double:3.953E-321)
            r0.setDuration(r3)
            goto L86
        L84:
            r0 = move-exception
            throw r0
        L86:
            r5.BuiltInFictitiousFunctionClassFactory = r2
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.NetworkUserEntityData$$ExternalSyntheticLambda0():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x002d, code lost:
    
        if (r0 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003a, code lost:
    
        if (r0 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003c, code lost:
    
        r0.setVisibility(8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory() {
        /*
            r5 = this;
            int r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r1
            int r0 = r0 % 2
            boolean r0 = r5.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L72
            if (r0 == 0) goto L71
            int r0 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            if (r0 == r2) goto L32
            int r0 = id.dana.R.id.ll_personalization_entry
            android.view.View r0 = r5.getAuthRequestContext(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L41
            goto L3c
        L30:
            r0 = move-exception
            throw r0
        L32:
            int r0 = id.dana.R.id.ll_personalization_entry
            android.view.View r0 = r5.getAuthRequestContext(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L41
        L3c:
            r3 = 8
            r0.setVisibility(r3)
        L41:
            int r0 = id.dana.R.id.ll_personalization_entry
            android.view.View r0 = r5.getAuthRequestContext(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L6f
            android.view.ViewPropertyAnimator r0 = r0.animate()     // Catch: java.lang.Exception -> L6d
            if (r0 == 0) goto L6f
            int r3 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r3 = r3 + 25
            int r4 = r3 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r4
            int r3 = r3 % 2
            r3 = 0
            android.view.ViewPropertyAnimator r0 = r0.translationY(r3)
            if (r0 == 0) goto L64
            r3 = 0
            goto L65
        L64:
            r3 = 1
        L65:
            if (r3 == r2) goto L6f
            r2 = 800(0x320, double:3.953E-321)
            r0.setDuration(r2)
            goto L6f
        L6d:
            r0 = move-exception
            throw r0
        L6f:
            r5.BuiltInFictitiousFunctionClassFactory = r1
        L71:
            return
        L72:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.BuiltInFictitiousFunctionClassFactory():void");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/view/ExploreDanaFragment$Companion;", "", "", "p0", "Lid/dana/explore/view/ExploreDanaFragment;", "getAuthRequestContext", "()Lid/dana/explore/view/ExploreDanaFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static ExploreDanaFragment getAuthRequestContext() {
            ExploreDanaFragment exploreDanaFragment = new ExploreDanaFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("NAV_BAR_INSTANCE", true);
            exploreDanaFragment.setArguments(bundle);
            return exploreDanaFragment;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0087, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x002d, code lost:
    
        if ((r0 != null ? 'T' : 20) != 'T') goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0046, code lost:
    
        if ((r0 != null ? '0' : 'W') != 'W') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x004c, code lost:
    
        if (r5.isEmpty() == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x004e, code lost:
    
        r5 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested + 37;
        id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0058, code lost:
    
        if ((r5 % 2) == 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x005a, code lost:
    
        r0 = r0;
        r5 = 93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x005e, code lost:
    
        r0.setVisibility(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0061, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0062, code lost:
    
        r0 = r0;
        r5 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0067, code lost:
    
        r0.setVisibility(0);
        r0.setPromoItems(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0071, code lost:
    
        r5 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance + 59;
        id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x007b, code lost:
    
        if ((r5 % 2) != 0) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x007d, code lost:
    
        r5 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x007e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0081, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0082, code lost:
    
        r5 = move-exception;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(java.util.List<? extends id.dana.promocenter.model.PromoModel> r5) {
        /*
            r4 = this;
            int r0 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r1
            int r0 = r0 % 2
            r1 = 10
            if (r0 != 0) goto L11
            r0 = 75
            goto L13
        L11:
            r0 = 10
        L13:
            r2 = 0
            java.lang.String r3 = ""
            if (r0 == r1) goto L32
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            int r0 = id.dana.R.id.explore_promo_view
            android.view.View r0 = r4.getAuthRequestContext(r0)
            id.dana.explore.view.ExplorePromoView r0 = (id.dana.explore.view.ExplorePromoView) r0
            int r1 = r2.length     // Catch: java.lang.Throwable -> L30
            r1 = 84
            if (r0 == 0) goto L2b
            r3 = 84
            goto L2d
        L2b:
            r3 = 20
        L2d:
            if (r3 == r1) goto L48
            goto L71
        L30:
            r5 = move-exception
            throw r5
        L32:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)     // Catch: java.lang.Exception -> L84
            int r0 = id.dana.R.id.explore_promo_view     // Catch: java.lang.Exception -> L84
            android.view.View r0 = r4.getAuthRequestContext(r0)
            id.dana.explore.view.ExplorePromoView r0 = (id.dana.explore.view.ExplorePromoView) r0
            r1 = 87
            if (r0 == 0) goto L44
            r3 = 48
            goto L46
        L44:
            r3 = 87
        L46:
            if (r3 == r1) goto L71
        L48:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L67
            int r5 = id.dana.explore.view.ExploreDanaFragment.isLayoutRequested
            int r5 = r5 + 37
            int r1 = r5 % 128
            id.dana.explore.view.ExploreDanaFragment.newProxyInstance = r1
            int r5 = r5 % 2
            if (r5 == 0) goto L62
            android.view.View r0 = (android.view.View) r0
            r5 = 93
        L5e:
            r0.setVisibility(r5)
            return
        L62:
            android.view.View r0 = (android.view.View) r0
            r5 = 8
            goto L5e
        L67:
            r1 = r0
            android.view.View r1 = (android.view.View) r1
            r3 = 0
            r1.setVisibility(r3)
            r0.setPromoItems(r5)
        L71:
            int r5 = id.dana.explore.view.ExploreDanaFragment.newProxyInstance     // Catch: java.lang.Exception -> L82
            int r5 = r5 + 59
            int r0 = r5 % 128
            id.dana.explore.view.ExploreDanaFragment.isLayoutRequested = r0     // Catch: java.lang.Exception -> L82
            int r5 = r5 % 2
            if (r5 != 0) goto L81
            int r5 = r2.length     // Catch: java.lang.Throwable -> L7f
            return
        L7f:
            r5 = move-exception
            throw r5
        L81:
            return
        L82:
            r5 = move-exception
            goto L86
        L84:
            r5 = move-exception
            throw r5
        L86:
            goto L88
        L87:
            throw r5
        L88:
            goto L87
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.getAuthRequestContext(java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x007b, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0097, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult ? 5 : 21) != 21) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0099, code lost:
    
        r5[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r12);
        r5[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00ac, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r4;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r4;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r4;
        r0.lookAheadTest = r0.PlaceComponentResult % r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00c4, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00c6, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r4) - 1) % r4;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r4) - 1) % r4;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r4) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r4) + r0.lookAheadTest;
        r5[r0.getAuthRequestContext] = r1[r7];
        r5[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00f4, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00f6, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r4) - 1) % r4;
        r0.lookAheadTest = ((r0.lookAheadTest + r4) - 1) % r4;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r4) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r4) + r0.lookAheadTest;
        r5[r0.getAuthRequestContext] = r1[r7];
        r5[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0120, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r4) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r4) + r0.scheduleImpl;
        r5[r0.getAuthRequestContext] = r1[r7];
        r5[r0.getAuthRequestContext + 1] = r1[r8];
        r7 = id.dana.explore.view.ExploreDanaFragment.$10 + 121;
        id.dana.explore.view.ExploreDanaFragment.$11 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0182, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0184, code lost:
    
        throw r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r11, byte r12, int r13, java.lang.Object[] r14) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreDanaFragment.a(char[], byte, int, java.lang.Object[]):void");
    }
}
