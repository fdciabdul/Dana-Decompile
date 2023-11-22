package id.dana.promodiscovery.views;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.gms.location.LocationSettingsResult;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesPresenter;
import id.dana.contract.promodiscovery.PromoDiscoveryContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.richview.DanaDefaultPullToRefresh;
import id.dana.core.ui.richview.DanaPullToRefreshListener;
import id.dana.core.ui.util.connectivity.ConnectivityMonitor;
import id.dana.core.ui.util.connectivity.mapper.ConnectivityModelMapperKt;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import id.dana.danah5.DanaH5;
import id.dana.data.util.NetworkUtils;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPromoDiscoveryComponent;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PromoDiscoveryModule;
import id.dana.dialog.DialogPermission;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.promocenter.model.PromoActionModel;
import id.dana.promocenter.model.PromoActionType;
import id.dana.promocenter.model.PromoModel;
import id.dana.promocode.views.RedeemPromoCodeActivity;
import id.dana.promodiscovery.adapter.BankPromoSectionAdapter;
import id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters;
import id.dana.promodiscovery.adapter.DanaDealsSectionAdapter;
import id.dana.promodiscovery.adapter.ExpiredVouchersSectionAdapter;
import id.dana.promodiscovery.adapter.FourKingSectionAdapter;
import id.dana.promodiscovery.adapter.NearbySectionAdapter;
import id.dana.promodiscovery.adapter.ReferralAndPromoCodeSectionAdapter;
import id.dana.promodiscovery.adapter.VoucherListSectionAdapter;
import id.dana.promodiscovery.annotation.PromoDiscovery;
import id.dana.promodiscovery.model.ActionButtonModel;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.model.FourKingItem;
import id.dana.promodiscovery.model.FourKingModel;
import id.dana.promodiscovery.model.PromoDiscoverySectionConfigModel;
import id.dana.promodiscovery.model.SectionState;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.richview.PromoDiscoverySectionListener;
import id.dana.promodiscovery.tracker.PromoDiscoveryAnalyticTracker;
import id.dana.promodiscovery.views.PromoDiscoveryListActivity;
import id.dana.promoquest.activity.MissionListActivity;
import id.dana.referral.MyReferralDetailActivity;
import id.dana.referral.model.MyReferralConsult;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.service.ServiceMaintenanceUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import id.dana.utils.showcase.Utils;
import in.srain.cube.views.ptr.PtrFrameLayout;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bO\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0003\u001a\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0004\b\u0003\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001fR\u0013\u0010\u0019\u001a\u00020 X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u001b\u001a\u00020#8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0003\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010'\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010*\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010$\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010!\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010.R\u0016\u0010-\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0012\u0010;\u001a\u00020:X\u0087\"¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u00107\u001a\u00020=8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010>R\u0012\u0010@\u001a\u00020?X\u0087\"¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\b\u0012\u0004\u0012\u00020C0BX\u0087\"¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u00100\u001a\u00020F8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u00102\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u00104\u001a\u00020L8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bM\u0010N"}, d2 = {"Lid/dana/promodiscovery/views/PromoDiscoveryFragment;", "Lid/dana/base/BaseFragment;", "", "MyBillsEntityDataFactory", "()V", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "getLayout", "()I", "Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;", "p0", "(Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;)V", IAPSyncCommand.COMMAND_INIT, "getAuthRequestContext", "(Ljava/lang/String;)V", "p1", "Landroid/content/Intent;", "p2", "onActivityResult", "(IILandroid/content/Intent;)V", "onPause", "onResume", "Lid/dana/promocenter/model/PromoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/promocenter/model/PromoModel;)V", "PlaceComponentResult", "Lid/dana/promodiscovery/adapter/BankPromoSectionAdapter;", "Lid/dana/promodiscovery/adapter/BankPromoSectionAdapter;", "Landroidx/recyclerview/widget/ConcatAdapter;", "Landroidx/recyclerview/widget/ConcatAdapter;", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "moveToNextValue", "Lkotlin/Lazy;", "Lid/dana/promodiscovery/adapter/DanaDealsSectionAdapter;", "lookAheadTest", "Lid/dana/promodiscovery/adapter/DanaDealsSectionAdapter;", "Lid/dana/promodiscovery/adapter/ExpiredVouchersSectionAdapter;", "scheduleImpl", "Lid/dana/promodiscovery/adapter/ExpiredVouchersSectionAdapter;", "Lid/dana/promodiscovery/adapter/FourKingSectionAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/promodiscovery/adapter/FourKingSectionAdapter;", "Lio/reactivex/disposables/Disposable;", "getErrorConfigVersion", "Lio/reactivex/disposables/Disposable;", "", "GetContactSyncConfig", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/promodiscovery/adapter/NearbySectionAdapter;", "initRecordTimeStamp", "Lid/dana/promodiscovery/adapter/NearbySectionAdapter;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "DatabaseTableConfigUtil", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$Presenter;", "promoDiscoveryPresenter", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$Presenter;", "Lid/dana/promodiscovery/model/PromoDiscoverySectionConfigModel;", "Lid/dana/promodiscovery/model/PromoDiscoverySectionConfigModel;", "Lid/dana/promodiscovery/tracker/PromoDiscoveryAnalyticTracker;", "promoDiscoveryTracker", "Lid/dana/promodiscovery/tracker/PromoDiscoveryAnalyticTracker;", "Ldagger/Lazy;", "Lid/dana/contract/deeplink/ReadLinkPropertiesPresenter;", "readLinkPropertiesPresenter", "Ldagger/Lazy;", "Lid/dana/promodiscovery/adapter/ReferralAndPromoCodeSectionAdapter;", "isLayoutRequested", "Lid/dana/promodiscovery/adapter/ReferralAndPromoCodeSectionAdapter;", "Lid/dana/dialog/DialogPermission;", "PrepareContext", "Lid/dana/dialog/DialogPermission;", "Lid/dana/promodiscovery/adapter/VoucherListSectionAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/promodiscovery/adapter/VoucherListSectionAdapter;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoDiscoveryFragment extends BaseFragment {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BankPromoSectionAdapter getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private FourKingSectionAdapter scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Disposable moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private VoucherListSectionAdapter initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private ConcatAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private DialogPermission NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private NearbySectionAdapter getErrorConfigVersion;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private ReferralAndPromoCodeSectionAdapter GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private DanaDealsSectionAdapter PlaceComponentResult;
    @Inject
    public PromoDiscoveryContract.Presenter promoDiscoveryPresenter;
    @Inject
    public PromoDiscoveryAnalyticTracker promoDiscoveryTracker;
    @Inject
    public Lazy<ReadLinkPropertiesPresenter> readLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ExpiredVouchersSectionAdapter MyBillsEntityDataFactory;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final kotlin.Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$connectivityMonitor$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityMonitor invoke() {
            BaseActivity baseActivity = PromoDiscoveryFragment.this.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            return new ConnectivityMonitor(baseActivity);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private PromoDiscoverySectionConfigModel DatabaseTableConfigUtil = new PromoDiscoverySectionConfigModel(null, null, null, null, null, 31, null);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[FourKingItem.values().length];
            iArr[FourKingItem.POINT.ordinal()] = 1;
            iArr[FourKingItem.VOUCHER.ordinal()] = 2;
            iArr[FourKingItem.LOYALTY.ordinal()] = 3;
            iArr[FourKingItem.QUEST.ordinal()] = 4;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    public final View PlaceComponentResult(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
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
    public final int getLayout() {
        return R.layout.promo_discovery_fragment;
    }

    public PromoDiscoveryFragment() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$permissionRequest$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PromoDiscoveryFragment.this.MyBillsEntityDataFactory();
                } else {
                    PromoDiscoveryFragment.this.getAuthRequestContext();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BaseActivity baseActivity = PromoDiscoveryFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                PermissionHelper.MyBillsEntityDataFactory(baseActivity);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.PlaceComponentResult();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        ((ConnectivityMonitor) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult(this, new Observer() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda8
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this, (ConnectivityModel) obj);
            }
        });
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        ((ConnectivityMonitor) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).PlaceComponentResult((LifecycleOwner) this);
    }

    private final void MyBillsEntityDataFactory(BaseDiscoverySectionAdapters<?> p0) {
        p0.PlaceComponentResult();
        ConcatAdapter concatAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (concatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            concatAdapter = null;
        }
        concatAdapter.MyBillsEntityDataFactory(p0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(String p0) {
        final Ref.IntRef intRef = new Ref.IntRef();
        Disposable subscribe = Observable.interval(1L, TimeUnit.MILLISECONDS).doOnNext(new Consumer() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Long l = (Long) obj;
                PromoDiscoveryFragment.getAuthRequestContext(Ref.IntRef.this);
            }
        }).subscribe();
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        subscribe.dispose();
        StringBuilder sb = new StringBuilder();
        sb.append(UrlUtil.getAuthRequestContext(p0));
        sb.append("?millis=");
        sb.append(intRef.element);
        sb.append("&params=");
        sb.append(BuiltInFictitiousFunctionClassFactory);
        DanaH5.startContainerFullUrl(sb.toString());
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
            DialogPermission.Builder builder = new DialogPermission.Builder(getBaseActivity(), new DialogInterface.OnDismissListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this);
                }
            });
            builder.scheduleImpl = R.drawable.ic_location_graphic;
            builder.lookAheadTest = getString(R.string.msg_location_dialog_desc);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = getString(R.string.msg_check_permission);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DialogPermission.DialogListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$showSettingLocationPermission$2
                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onDialogDismissed() {
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onPositiveButtonClicked() {
                    Utils.PlaceComponentResult(PromoDiscoveryFragment.this.getContext());
                    PromoDiscoveryFragment.getAuthRequestContext(PromoDiscoveryFragment.this);
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onNegativeButtonClicked() {
                    PromoDiscoveryFragment.getAuthRequestContext(PromoDiscoveryFragment.this);
                }
            };
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new DialogPermission(builder.BuiltInFictitiousFunctionClassFactory, builder.moveToNextValue, builder, (byte) 0);
        }
        DialogPermission dialogPermission = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (dialogPermission != null) {
            dialogPermission.MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        DanaDealsSectionAdapter danaDealsSectionAdapter = this.PlaceComponentResult;
        if (danaDealsSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaDealsSectionAdapter = null;
        }
        danaDealsSectionAdapter.MyBillsEntityDataFactory();
        if (LocationUtil.BuiltInFictitiousFunctionClassFactory(getContext())) {
            if (!LocationUtil.getAuthRequestContext(getContext())) {
                PlaceComponentResult();
                return;
            }
            Disposable disposable = this.moveToNextValue;
            if (disposable != null) {
                Intrinsics.checkNotNull(disposable);
                disposable.dispose();
                this.moveToNextValue = null;
            }
            Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getBaseActivity().getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PromoDiscoveryFragment.MyBillsEntityDataFactory(PromoDiscoveryFragment.this, (Location) obj);
                }
            });
            this.moveToNextValue = subscribe;
            addDisposable(subscribe);
            return;
        }
        getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        DanaDealsSectionAdapter danaDealsSectionAdapter = this.PlaceComponentResult;
        DanaDealsSectionAdapter danaDealsSectionAdapter2 = null;
        if (danaDealsSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaDealsSectionAdapter = null;
        }
        danaDealsSectionAdapter.MyBillsEntityDataFactory(SectionState.ERROR_LOCATION_PERMISSION);
        DanaDealsSectionAdapter danaDealsSectionAdapter3 = this.PlaceComponentResult;
        if (danaDealsSectionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            danaDealsSectionAdapter2 = danaDealsSectionAdapter3;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setDanaDealsErrorNoGpsPermission$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentPermissionRequest fragmentPermissionRequest;
                fragmentPermissionRequest = PromoDiscoveryFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                fragmentPermissionRequest.check();
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        danaDealsSectionAdapter2.getAuthRequestContext = function0;
        danaDealsSectionAdapter2.notifyItemChanged(0);
    }

    private final void PlaceComponentResult() {
        DanaDealsSectionAdapter danaDealsSectionAdapter = this.PlaceComponentResult;
        DanaDealsSectionAdapter danaDealsSectionAdapter2 = null;
        if (danaDealsSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaDealsSectionAdapter = null;
        }
        danaDealsSectionAdapter.MyBillsEntityDataFactory(SectionState.ERROR_LOCATION_PERMISSION);
        DanaDealsSectionAdapter danaDealsSectionAdapter3 = this.PlaceComponentResult;
        if (danaDealsSectionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            danaDealsSectionAdapter2 = danaDealsSectionAdapter3;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setDanaDealsErrorGpsInactive$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder((Application) PromoDiscoveryFragment.this.getBaseActivity().getDanaApplication());
                locationRequestBuilder.MyBillsEntityDataFactory.addLocationRequest(LocationUtil.LocationRequestBuilder.PlaceComponentResult());
                Observable<LocationSettingsResult> BuiltInFictitiousFunctionClassFactory = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(locationRequestBuilder.MyBillsEntityDataFactory.build());
                final PromoDiscoveryFragment promoDiscoveryFragment2 = PromoDiscoveryFragment.this;
                promoDiscoveryFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory.subscribe(new Consumer() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setDanaDealsErrorGpsInactive$1$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        PromoDiscoveryFragment.getAuthRequestContext(PromoDiscoveryFragment.this, (LocationSettingsResult) obj);
                    }
                });
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        danaDealsSectionAdapter2.getAuthRequestContext = function0;
        danaDealsSectionAdapter2.notifyItemChanged(0);
    }

    public static /* synthetic */ void PlaceComponentResult(PromoDiscoveryFragment promoDiscoveryFragment, PromoModel promoModel) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker = promoDiscoveryFragment.promoDiscoveryTracker;
        if (promoDiscoveryAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoDiscoveryAnalyticTracker = null;
        }
        promoDiscoveryAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PromoCenterSourceType.ONLY_FOR_YOU);
        promoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(promoModel);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment promoDiscoveryFragment, PromoModel promoModel) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker = promoDiscoveryFragment.promoDiscoveryTracker;
        if (promoDiscoveryAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoDiscoveryAnalyticTracker = null;
        }
        promoDiscoveryAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PromoCenterSourceType.EXPIRING_VOUCHER);
        promoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(promoModel);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PromoDiscoveryFragment promoDiscoveryFragment, Location location) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        PromoDiscoveryContract.Presenter presenter = promoDiscoveryFragment.promoDiscoveryPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory(Integer.valueOf(promoDiscoveryFragment.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2), promoDiscoveryFragment.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, location);
        Disposable disposable = promoDiscoveryFragment.moveToNextValue;
        if (disposable != null) {
            Intrinsics.checkNotNull(disposable);
            disposable.dispose();
            promoDiscoveryFragment.moveToNextValue = null;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(PromoDiscoveryFragment promoDiscoveryFragment) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        promoDiscoveryFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    }

    public static /* synthetic */ void PlaceComponentResult(PromoDiscoveryFragment promoDiscoveryFragment, ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
        promoDiscoveryFragment.lookAheadTest = ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PromoDiscoveryFragment promoDiscoveryFragment, PromoModel promoModel) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker = promoDiscoveryFragment.promoDiscoveryTracker;
        if (promoDiscoveryAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoDiscoveryAnalyticTracker = null;
        }
        promoDiscoveryAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PromoCenterSourceType.BANK_PROMO);
        promoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(promoModel);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment promoDiscoveryFragment, FourKingModel fourKingModel) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        Intrinsics.checkNotNullParameter(fourKingModel, "");
        FourKingItem fourKingItem = fourKingModel.PlaceComponentResult;
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[fourKingItem.ordinal()];
        PromoDiscoveryContract.Presenter presenter = null;
        if (i == 1) {
            PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker = promoDiscoveryFragment.promoDiscoveryTracker;
            if (promoDiscoveryAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                promoDiscoveryAnalyticTracker = null;
            }
            promoDiscoveryAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PromoCenterSourceType.DANA_POINTS);
            promoDiscoveryFragment.getAuthRequestContext(PromoDiscovery.DANA_PROMOTION_POINTS);
        } else if (i == 2) {
            PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker2 = promoDiscoveryFragment.promoDiscoveryTracker;
            if (promoDiscoveryAnalyticTracker2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                promoDiscoveryAnalyticTracker2 = null;
            }
            promoDiscoveryAnalyticTracker2.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PromoCenterSourceType.MY_VOUCHER);
            Lazy<ReadLinkPropertiesPresenter> lazy = promoDiscoveryFragment.readLinkPropertiesPresenter;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            lazy.get().MyBillsEntityDataFactory(PromoDiscovery.DANA_WALLET_VOUCHER);
        } else if (i == 3) {
            PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker3 = promoDiscoveryFragment.promoDiscoveryTracker;
            if (promoDiscoveryAnalyticTracker3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                promoDiscoveryAnalyticTracker3 = null;
            }
            promoDiscoveryAnalyticTracker3.KClassImpl$Data$declaredNonStaticMembers$2("Loyalty");
            Lazy<ReadLinkPropertiesPresenter> lazy2 = promoDiscoveryFragment.readLinkPropertiesPresenter;
            if (lazy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy2 = null;
            }
            lazy2.get().MyBillsEntityDataFactory(PromoDiscovery.DANA_WALLET_LOYALTY);
        } else if (i == 4) {
            PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker4 = promoDiscoveryFragment.promoDiscoveryTracker;
            if (promoDiscoveryAnalyticTracker4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                promoDiscoveryAnalyticTracker4 = null;
            }
            promoDiscoveryAnalyticTracker4.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PromoCenterSourceType.PROMO_QUEST);
            FourKingSectionAdapter fourKingSectionAdapter = promoDiscoveryFragment.scheduleImpl;
            if (fourKingSectionAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                fourKingSectionAdapter = null;
            }
            if (fourKingSectionAdapter.PlaceComponentResult == FourKingSectionAdapter.PromoQuestStatus.ENABLED) {
                MissionListActivity.Companion companion = MissionListActivity.INSTANCE;
                FragmentActivity requireActivity = promoDiscoveryFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                MissionListActivity.Companion.getAuthRequestContext(requireActivity);
            } else {
                ServiceMaintenanceUtil.getAuthRequestContext(TrackerKey.PromoCenterSourceType.PROMO_QUEST);
            }
        }
        PromoDiscoveryContract.Presenter presenter2 = promoDiscoveryFragment.promoDiscoveryPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.getAuthRequestContext(fourKingItem);
    }

    public static /* synthetic */ void getAuthRequestContext(Ref.IntRef intRef) {
        Intrinsics.checkNotNullParameter(intRef, "");
        intRef.element++;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoDiscoveryFragment promoDiscoveryFragment, ProductInfoDiscoveryModel productInfoDiscoveryModel) {
        Intrinsics.checkNotNullParameter(promoDiscoveryFragment, "");
        Intrinsics.checkNotNullParameter(productInfoDiscoveryModel, "");
        PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker = promoDiscoveryFragment.promoDiscoveryTracker;
        if (promoDiscoveryAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoDiscoveryAnalyticTracker = null;
        }
        promoDiscoveryAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.PromoCenterSourceType.DANA_DEALS);
        Uri parse = Uri.parse(PromoDiscovery.DANA_DEALS_DETAIL_URL);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.appendQueryParameter("goodsId", productInfoDiscoveryModel.getGoodsId());
        buildUpon.appendQueryParameter("voucherV2", SummaryActivity.CHECKED);
        String obj = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        promoDiscoveryFragment.getAuthRequestContext(obj);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final PromoDiscoveryFragment promoDiscoveryFragment, final MyReferralConsult myReferralConsult) {
        Resources resources;
        Context context = promoDiscoveryFragment.getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        ReferralAndPromoCodeSectionAdapter referralAndPromoCodeSectionAdapter = promoDiscoveryFragment.GetContactSyncConfig;
        if (referralAndPromoCodeSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralAndPromoCodeSectionAdapter = null;
        }
        String string = resources.getString(R.string.referral_discovery_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = resources.getString(R.string.referral_discovery_subtitle);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        ActionButtonModel actionButtonModel = new ActionButtonModel(R.drawable.ic_referral_discovery, string, string2, new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$addReferralButtonToReferralAndPromoCodeSectionAdapter$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryFragment.BuiltInFictitiousFunctionClassFactory(PromoDiscoveryFragment.this, myReferralConsult);
            }
        });
        List<DiscoverySectionModel<T>> items = referralAndPromoCodeSectionAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        List mutableList = CollectionsKt.toMutableList(((DiscoverySectionModel) CollectionsKt.first((List) items)).KClassImpl$Data$declaredNonStaticMembers$2);
        mutableList.add(actionButtonModel);
        referralAndPromoCodeSectionAdapter.KClassImpl$Data$declaredNonStaticMembers$2(mutableList);
    }

    public static final /* synthetic */ void getAuthRequestContext(final PromoDiscoveryFragment promoDiscoveryFragment, PromoDiscoverySectionConfigModel promoDiscoverySectionConfigModel) {
        promoDiscoveryFragment.DatabaseTableConfigUtil = promoDiscoverySectionConfigModel;
        FourKingSectionAdapter fourKingSectionAdapter = promoDiscoveryFragment.scheduleImpl;
        DanaDealsSectionAdapter danaDealsSectionAdapter = null;
        if (fourKingSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fourKingSectionAdapter = null;
        }
        new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$applyConfigurationPerSection$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryContract.Presenter presenter = PromoDiscoveryFragment.this.promoDiscoveryPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.PlaceComponentResult();
            }
        }.invoke();
        boolean getAuthRequestContext = promoDiscoverySectionConfigModel.PlaceComponentResult.getGetAuthRequestContext();
        VoucherListSectionAdapter voucherListSectionAdapter = promoDiscoveryFragment.initRecordTimeStamp;
        if (voucherListSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            voucherListSectionAdapter = null;
        }
        VoucherListSectionAdapter voucherListSectionAdapter2 = voucherListSectionAdapter;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$applyConfigurationPerSection$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryFragment.DatabaseTableConfigUtil(PromoDiscoveryFragment.this);
            }
        };
        if (getAuthRequestContext) {
            function0.invoke();
        } else {
            promoDiscoveryFragment.MyBillsEntityDataFactory(voucherListSectionAdapter2);
        }
        boolean getAuthRequestContext2 = promoDiscoverySectionConfigModel.KClassImpl$Data$declaredNonStaticMembers$2.getGetAuthRequestContext();
        ExpiredVouchersSectionAdapter expiredVouchersSectionAdapter = promoDiscoveryFragment.MyBillsEntityDataFactory;
        if (expiredVouchersSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            expiredVouchersSectionAdapter = null;
        }
        ExpiredVouchersSectionAdapter expiredVouchersSectionAdapter2 = expiredVouchersSectionAdapter;
        Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$applyConfigurationPerSection$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryFragment.scheduleImpl(PromoDiscoveryFragment.this);
            }
        };
        if (getAuthRequestContext2) {
            function02.invoke();
        } else {
            promoDiscoveryFragment.MyBillsEntityDataFactory(expiredVouchersSectionAdapter2);
        }
        boolean getAuthRequestContext3 = promoDiscoverySectionConfigModel.getAuthRequestContext.getGetAuthRequestContext();
        BankPromoSectionAdapter bankPromoSectionAdapter = promoDiscoveryFragment.getAuthRequestContext;
        if (bankPromoSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bankPromoSectionAdapter = null;
        }
        BankPromoSectionAdapter bankPromoSectionAdapter2 = bankPromoSectionAdapter;
        Function0<Unit> function03 = new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$applyConfigurationPerSection$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment.this);
            }
        };
        if (getAuthRequestContext3) {
            function03.invoke();
        } else {
            promoDiscoveryFragment.MyBillsEntityDataFactory(bankPromoSectionAdapter2);
        }
        boolean getAuthRequestContext4 = promoDiscoverySectionConfigModel.BuiltInFictitiousFunctionClassFactory.getGetAuthRequestContext();
        DanaDealsSectionAdapter danaDealsSectionAdapter2 = promoDiscoveryFragment.PlaceComponentResult;
        if (danaDealsSectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            danaDealsSectionAdapter = danaDealsSectionAdapter2;
        }
        DanaDealsSectionAdapter danaDealsSectionAdapter3 = danaDealsSectionAdapter;
        Function0<Unit> function04 = new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$applyConfigurationPerSection$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryFragment.this.MyBillsEntityDataFactory();
            }
        };
        if (getAuthRequestContext4) {
            function04.invoke();
        } else {
            promoDiscoveryFragment.MyBillsEntityDataFactory(danaDealsSectionAdapter3);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment promoDiscoveryFragment, BaseDiscoverySectionAdapters baseDiscoverySectionAdapters, final Function0 function0) {
        if (promoDiscoveryFragment.lookAheadTest) {
            baseDiscoverySectionAdapters.MyBillsEntityDataFactory(SectionState.ERROR_GENERAL);
        } else {
            baseDiscoverySectionAdapters.MyBillsEntityDataFactory(SectionState.ERROR_NETWORK);
        }
        Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$decideError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function0.invoke();
            }
        };
        Intrinsics.checkNotNullParameter(function02, "");
        baseDiscoverySectionAdapters.getAuthRequestContext = function02;
        baseDiscoverySectionAdapters.notifyItemChanged(0);
    }

    public static final /* synthetic */ void getAuthRequestContext(PromoDiscoveryFragment promoDiscoveryFragment) {
        DialogPermission dialogPermission = promoDiscoveryFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (dialogPermission != null) {
            if (dialogPermission != null) {
                dialogPermission.getAuthRequestContext();
            }
            promoDiscoveryFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment promoDiscoveryFragment) {
        PromoDiscoveryContract.Presenter presenter = promoDiscoveryFragment.promoDiscoveryPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult(Integer.valueOf(promoDiscoveryFragment.DatabaseTableConfigUtil.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    public static final /* synthetic */ void scheduleImpl(PromoDiscoveryFragment promoDiscoveryFragment) {
        PromoDiscoveryContract.Presenter presenter = promoDiscoveryFragment.promoDiscoveryPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory(Integer.valueOf(promoDiscoveryFragment.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    public static final /* synthetic */ void initRecordTimeStamp(PromoDiscoveryFragment promoDiscoveryFragment) {
        PromoDiscoveryContract.Presenter presenter = promoDiscoveryFragment.promoDiscoveryPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void DatabaseTableConfigUtil(PromoDiscoveryFragment promoDiscoveryFragment) {
        PromoDiscoveryContract.Presenter presenter = promoDiscoveryFragment.promoDiscoveryPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.getAuthRequestContext(Integer.valueOf(promoDiscoveryFragment.DatabaseTableConfigUtil.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoDiscoveryFragment promoDiscoveryFragment, BaseDiscoverySectionAdapters baseDiscoverySectionAdapters, List list) {
        if (list.isEmpty()) {
            promoDiscoveryFragment.MyBillsEntityDataFactory(baseDiscoverySectionAdapters);
            return;
        }
        baseDiscoverySectionAdapters.KClassImpl$Data$declaredNonStaticMembers$2(list);
        baseDiscoverySectionAdapters.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void getAuthRequestContext(PromoDiscoveryFragment promoDiscoveryFragment, LocationSettingsResult locationSettingsResult) {
        Unit unit;
        int statusCode = locationSettingsResult.getStatus().getStatusCode();
        if (statusCode == 6) {
            PendingIntent resolution = locationSettingsResult.getStatus().getResolution();
            if (resolution != null) {
                promoDiscoveryFragment.startIntentSenderForResult(resolution.getIntentSender(), 100, null, 0, 0, 0, null);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                promoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } else if (statusCode != 8502) {
            promoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Disposable disposable = promoDiscoveryFragment.moveToNextValue;
        if (disposable != null) {
            Intrinsics.checkNotNull(disposable);
            disposable.dispose();
            promoDiscoveryFragment.moveToNextValue = null;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PromoDiscoveryFragment promoDiscoveryFragment, MyReferralConsult myReferralConsult) {
        Intent intent = new Intent(promoDiscoveryFragment.getContext(), MyReferralDetailActivity.class);
        intent.putExtra(MyReferralDetailActivity.BundleKey.BUNDLE_REFERRAL_CONSULT, myReferralConsult);
        promoDiscoveryFragment.startActivity(intent);
    }

    public static final /* synthetic */ void PrepareContext(PromoDiscoveryFragment promoDiscoveryFragment) {
        VoucherListSectionAdapter voucherListSectionAdapter = promoDiscoveryFragment.initRecordTimeStamp;
        ReferralAndPromoCodeSectionAdapter referralAndPromoCodeSectionAdapter = null;
        if (voucherListSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            voucherListSectionAdapter = null;
        }
        voucherListSectionAdapter.MyBillsEntityDataFactory();
        FourKingSectionAdapter fourKingSectionAdapter = promoDiscoveryFragment.scheduleImpl;
        if (fourKingSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fourKingSectionAdapter = null;
        }
        fourKingSectionAdapter.MyBillsEntityDataFactory();
        NearbySectionAdapter nearbySectionAdapter = promoDiscoveryFragment.getErrorConfigVersion;
        if (nearbySectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nearbySectionAdapter = null;
        }
        nearbySectionAdapter.MyBillsEntityDataFactory();
        BankPromoSectionAdapter bankPromoSectionAdapter = promoDiscoveryFragment.getAuthRequestContext;
        if (bankPromoSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bankPromoSectionAdapter = null;
        }
        bankPromoSectionAdapter.MyBillsEntityDataFactory();
        ExpiredVouchersSectionAdapter expiredVouchersSectionAdapter = promoDiscoveryFragment.MyBillsEntityDataFactory;
        if (expiredVouchersSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            expiredVouchersSectionAdapter = null;
        }
        expiredVouchersSectionAdapter.MyBillsEntityDataFactory();
        ReferralAndPromoCodeSectionAdapter referralAndPromoCodeSectionAdapter2 = promoDiscoveryFragment.GetContactSyncConfig;
        if (referralAndPromoCodeSectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            referralAndPromoCodeSectionAdapter = referralAndPromoCodeSectionAdapter2;
        }
        referralAndPromoCodeSectionAdapter.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void PlaceComponentResult(PromoDiscoveryFragment promoDiscoveryFragment, String str) {
        PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker = promoDiscoveryFragment.promoDiscoveryTracker;
        if (promoDiscoveryAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoDiscoveryAnalyticTracker = null;
        }
        promoDiscoveryAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(str);
    }

    private final String BuiltInFictitiousFunctionClassFactory() {
        PromoDiscoveryContract.Presenter presenter = this.promoDiscoveryPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        String cityName = presenter.getAuthRequestContext().getIndoSubdivisions().getCityName();
        Context context = getContext();
        Boolean valueOf = context != null ? Boolean.valueOf(NetworkUtils.isWifiEnable(context)) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("\n            {\n                \"os_version\":\"");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("\",\n                \"device_brand\":\"");
        sb.append(Build.BRAND);
        sb.append("\",\n                \"device_model\":\"");
        sb.append(Build.MODEL);
        sb.append("\",\n                \"wifi\":\"");
        sb.append(valueOf);
        sb.append("\",\n                \"location\":\"");
        sb.append(cityName);
        sb.append("\"\n            }\n        ");
        return String.valueOf(UrlUtil.MyBillsEntityDataFactory(StringsKt.trimIndent(sb.toString())));
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(PromoModel p0) {
        Object obj;
        Iterable iterable = p0.MyBillsEntityDataFactory;
        if (iterable == null) {
            iterable = new ArrayList();
        }
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (StringsKt.equals(((PromoActionModel) obj).getAuthRequestContext, PromoActionType.SECONDARY, true)) {
                    break;
                }
            }
            PromoActionModel promoActionModel = (PromoActionModel) obj;
            if (promoActionModel != null) {
                String str = promoActionModel.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(str, "");
                getAuthRequestContext(str);
            }
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DaggerPromoDiscoveryComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPromoDiscoveryComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
        byte b = 0;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        BuiltInFictitiousFunctionClassFactory.scheduleImpl = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getActivity();
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = getActivity();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (PromoDiscoveryModule) Preconditions.getAuthRequestContext(new PromoDiscoveryModule(new PromoDiscoveryContract.View() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupInject$component$1
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

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoverySectionConfigModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((DanaDefaultPullToRefresh) PromoDiscoveryFragment.this.PlaceComponentResult(R.id.GetKybCompressQrConfig_Factory_res_0x7f0a059f)).cancelRefreshProgress();
                PromoDiscoveryFragment.getAuthRequestContext(PromoDiscoveryFragment.this, p0);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                PromoDiscoverySectionConfigModel promoDiscoverySectionConfigModel;
                ((DanaDefaultPullToRefresh) PromoDiscoveryFragment.this.PlaceComponentResult(R.id.GetKybCompressQrConfig_Factory_res_0x7f0a059f)).cancelRefreshProgress();
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                promoDiscoverySectionConfigModel = promoDiscoveryFragment.DatabaseTableConfigUtil;
                PromoDiscoveryFragment.getAuthRequestContext(promoDiscoveryFragment, promoDiscoverySectionConfigModel);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void MyBillsEntityDataFactory(List<? extends PromoModel> p0) {
                VoucherListSectionAdapter voucherListSectionAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                voucherListSectionAdapter = promoDiscoveryFragment.initRecordTimeStamp;
                if (voucherListSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    voucherListSectionAdapter = null;
                }
                PromoDiscoveryFragment.BuiltInFictitiousFunctionClassFactory(promoDiscoveryFragment, voucherListSectionAdapter, p0);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void getErrorConfigVersion() {
                VoucherListSectionAdapter voucherListSectionAdapter;
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                voucherListSectionAdapter = promoDiscoveryFragment.initRecordTimeStamp;
                if (voucherListSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    voucherListSectionAdapter = null;
                }
                final PromoDiscoveryFragment promoDiscoveryFragment2 = PromoDiscoveryFragment.this;
                PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(promoDiscoveryFragment, voucherListSectionAdapter, new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupInject$component$1$onErrorGetVoucherListItem$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PromoDiscoveryFragment.DatabaseTableConfigUtil(PromoDiscoveryFragment.this);
                    }
                });
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends PromoModel> p0) {
                ExpiredVouchersSectionAdapter expiredVouchersSectionAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                expiredVouchersSectionAdapter = promoDiscoveryFragment.MyBillsEntityDataFactory;
                if (expiredVouchersSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    expiredVouchersSectionAdapter = null;
                }
                PromoDiscoveryFragment.BuiltInFictitiousFunctionClassFactory(promoDiscoveryFragment, expiredVouchersSectionAdapter, p0);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void MyBillsEntityDataFactory() {
                ExpiredVouchersSectionAdapter expiredVouchersSectionAdapter;
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                expiredVouchersSectionAdapter = promoDiscoveryFragment.MyBillsEntityDataFactory;
                if (expiredVouchersSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    expiredVouchersSectionAdapter = null;
                }
                final PromoDiscoveryFragment promoDiscoveryFragment2 = PromoDiscoveryFragment.this;
                PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(promoDiscoveryFragment, expiredVouchersSectionAdapter, new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupInject$component$1$onErrorGetExpiringPromoItem$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PromoDiscoveryFragment.scheduleImpl(PromoDiscoveryFragment.this);
                    }
                });
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void getAuthRequestContext(List<? extends PromoModel> p0) {
                BankPromoSectionAdapter bankPromoSectionAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                bankPromoSectionAdapter = promoDiscoveryFragment.getAuthRequestContext;
                if (bankPromoSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bankPromoSectionAdapter = null;
                }
                PromoDiscoveryFragment.BuiltInFictitiousFunctionClassFactory(promoDiscoveryFragment, bankPromoSectionAdapter, p0);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void PlaceComponentResult() {
                BankPromoSectionAdapter bankPromoSectionAdapter;
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                bankPromoSectionAdapter = promoDiscoveryFragment.getAuthRequestContext;
                if (bankPromoSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bankPromoSectionAdapter = null;
                }
                final PromoDiscoveryFragment promoDiscoveryFragment2 = PromoDiscoveryFragment.this;
                PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(promoDiscoveryFragment, bankPromoSectionAdapter, new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupInject$component$1$onErrorGetBankPromo$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment.this);
                    }
                });
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void getAuthRequestContext(boolean p0) {
                if (p0) {
                    PromoDiscoveryContract.Presenter presenter = PromoDiscoveryFragment.this.promoDiscoveryPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    PromoDiscoveryFragment.MyBillsEntityDataFactory(PromoDiscoveryFragment.this, presenter.MyBillsEntityDataFactory());
                }
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<ProductInfoDiscoveryModel> p0) {
                DanaDealsSectionAdapter danaDealsSectionAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                danaDealsSectionAdapter = promoDiscoveryFragment.PlaceComponentResult;
                if (danaDealsSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    danaDealsSectionAdapter = null;
                }
                PromoDiscoveryFragment.BuiltInFictitiousFunctionClassFactory(promoDiscoveryFragment, danaDealsSectionAdapter, p0);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void getAuthRequestContext() {
                DanaDealsSectionAdapter danaDealsSectionAdapter;
                PromoDiscoveryFragment promoDiscoveryFragment = PromoDiscoveryFragment.this;
                danaDealsSectionAdapter = promoDiscoveryFragment.PlaceComponentResult;
                if (danaDealsSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    danaDealsSectionAdapter = null;
                }
                final PromoDiscoveryFragment promoDiscoveryFragment2 = PromoDiscoveryFragment.this;
                PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(promoDiscoveryFragment, danaDealsSectionAdapter, new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupInject$component$1$onErrorGetDanaDeals$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PromoDiscoveryFragment.this.MyBillsEntityDataFactory();
                    }
                });
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void PlaceComponentResult(List<FourKingModel> p0) {
                FourKingSectionAdapter fourKingSectionAdapter;
                FourKingSectionAdapter fourKingSectionAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                fourKingSectionAdapter = PromoDiscoveryFragment.this.scheduleImpl;
                FourKingSectionAdapter fourKingSectionAdapter3 = null;
                if (fourKingSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    fourKingSectionAdapter = null;
                }
                fourKingSectionAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
                fourKingSectionAdapter2 = PromoDiscoveryFragment.this.scheduleImpl;
                if (fourKingSectionAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    fourKingSectionAdapter3 = fourKingSectionAdapter2;
                }
                fourKingSectionAdapter3.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void scheduleImpl(List<FourKingModel> p0) {
                FourKingSectionAdapter fourKingSectionAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                fourKingSectionAdapter = PromoDiscoveryFragment.this.scheduleImpl;
                if (fourKingSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    fourKingSectionAdapter = null;
                }
                fourKingSectionAdapter.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(ThirdPartyServiceResponse p0) {
                FourKingSectionAdapter fourKingSectionAdapter;
                FourKingSectionAdapter.PromoQuestStatus promoQuestStatus;
                Intrinsics.checkNotNullParameter(p0, "");
                fourKingSectionAdapter = PromoDiscoveryFragment.this.scheduleImpl;
                if (fourKingSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    fourKingSectionAdapter = null;
                }
                if (p0.isEnable()) {
                    promoQuestStatus = FourKingSectionAdapter.PromoQuestStatus.ENABLED;
                } else {
                    String name = p0.getName();
                    if (!(name == null || name.length() == 0)) {
                        promoQuestStatus = FourKingSectionAdapter.PromoQuestStatus.DISABLED;
                    } else {
                        promoQuestStatus = FourKingSectionAdapter.PromoQuestStatus.MAINTENANCE;
                    }
                }
                Intrinsics.checkNotNullParameter(promoQuestStatus, "");
                fourKingSectionAdapter.PlaceComponentResult = promoQuestStatus;
            }

            @Override // id.dana.contract.promodiscovery.PromoDiscoveryContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                FourKingSectionAdapter fourKingSectionAdapter;
                fourKingSectionAdapter = PromoDiscoveryFragment.this.scheduleImpl;
                if (fourKingSectionAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    fourKingSectionAdapter = null;
                }
                FourKingSectionAdapter.PromoQuestStatus promoQuestStatus = FourKingSectionAdapter.PromoQuestStatus.DISABLED;
                Intrinsics.checkNotNullParameter(promoQuestStatus, "");
                fourKingSectionAdapter.PlaceComponentResult = promoQuestStatus;
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, PromoDiscoveryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.scheduleImpl, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, OauthModule.class);
        if (BuiltInFictitiousFunctionClassFactory.lookAheadTest == null) {
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerPromoDiscoveryComponent.PromoDiscoveryComponentImpl(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.scheduleImpl, BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.lookAheadTest, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker = this.promoDiscoveryTracker;
        PromoDiscoveryContract.Presenter presenter = null;
        if (promoDiscoveryAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoDiscoveryAnalyticTracker = null;
        }
        promoDiscoveryAnalyticTracker.MyBillsEntityDataFactory();
        this.scheduleImpl = new FourKingSectionAdapter(new PromoDiscoveryListItemListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda7
            @Override // id.dana.promodiscovery.richview.PromoDiscoveryListItemListener
            public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment.this, (FourKingModel) obj);
            }
        });
        this.initRecordTimeStamp = new VoucherListSectionAdapter(new PromoDiscoverySectionListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupVoucherListSectionAdapter$1
            @Override // id.dana.promodiscovery.richview.PromoDiscoverySectionListener
            public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this, TrackerKey.PromoCenterSourceType.ONLY_FOR_YOU);
                PromoDiscoveryListActivity.Companion companion = PromoDiscoveryListActivity.INSTANCE;
                BaseActivity baseActivity = PromoDiscoveryFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                PromoDiscoveryListActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, str, null, str3, 4);
            }
        }, new PromoDiscoveryListItemListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda2
            @Override // id.dana.promodiscovery.richview.PromoDiscoveryListItemListener
            public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this, (PromoModel) obj);
            }
        });
        this.MyBillsEntityDataFactory = new ExpiredVouchersSectionAdapter(new PromoDiscoverySectionListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupExpiredVoucherSectionAdapter$1
            @Override // id.dana.promodiscovery.richview.PromoDiscoverySectionListener
            public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this, TrackerKey.PromoCenterSourceType.EXPIRING_VOUCHER);
                PromoDiscoveryListActivity.Companion companion = PromoDiscoveryListActivity.INSTANCE;
                BaseActivity baseActivity = PromoDiscoveryFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                PromoDiscoveryListActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, str, null, str3, 4);
            }
        }, new PromoDiscoveryListItemListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda5
            @Override // id.dana.promodiscovery.richview.PromoDiscoveryListItemListener
            public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                PromoDiscoveryFragment.KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment.this, (PromoModel) obj);
            }
        });
        this.getAuthRequestContext = new BankPromoSectionAdapter(new PromoDiscoverySectionListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupBankPromoSectionAdapter$1
            @Override // id.dana.promodiscovery.richview.PromoDiscoverySectionListener
            public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this, TrackerKey.PromoCenterSourceType.BANK_PROMO);
                PromoDiscoveryListActivity.Companion companion = PromoDiscoveryListActivity.INSTANCE;
                BaseActivity baseActivity = PromoDiscoveryFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                PromoDiscoveryListActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, str, str2, null, 8);
            }
        }, new PromoDiscoveryListItemListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda1
            @Override // id.dana.promodiscovery.richview.PromoDiscoveryListItemListener
            public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                PromoDiscoveryFragment.MyBillsEntityDataFactory(PromoDiscoveryFragment.this, (PromoModel) obj);
            }
        });
        ReferralAndPromoCodeSectionAdapter referralAndPromoCodeSectionAdapter = new ReferralAndPromoCodeSectionAdapter();
        Context context = getContext();
        if (context != null) {
            String string = context.getString(R.string.promo_code_discovery_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = context.getString(R.string.promo_code_discovery_subtitle);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            referralAndPromoCodeSectionAdapter.KClassImpl$Data$declaredNonStaticMembers$2(CollectionsKt.mutableListOf(new ActionButtonModel(R.drawable.ic_promo_code_discovery, string, string2, new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupReferralAndPromoCodeSection$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    r0.startActivity(new Intent(PromoDiscoveryFragment.this.getContext(), RedeemPromoCodeActivity.class));
                }
            })));
        }
        this.GetContactSyncConfig = referralAndPromoCodeSectionAdapter;
        this.PlaceComponentResult = new DanaDealsSectionAdapter(new PromoDiscoverySectionListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupDanaDealsSectionAdapter$1
            @Override // id.dana.promodiscovery.richview.PromoDiscoverySectionListener
            public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "");
                PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this, TrackerKey.PromoCenterSourceType.DANA_DEALS);
                PromoDiscoveryFragment.this.getAuthRequestContext(PromoDiscovery.DANA_DEALS_URL);
            }
        }, new PromoDiscoveryListItemListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$$ExternalSyntheticLambda6
            @Override // id.dana.promodiscovery.richview.PromoDiscoveryListItemListener
            public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                PromoDiscoveryFragment.BuiltInFictitiousFunctionClassFactory(PromoDiscoveryFragment.this, (ProductInfoDiscoveryModel) obj);
            }
        });
        this.getErrorConfigVersion = new NearbySectionAdapter(new Function0<Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupNearbySection$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PromoDiscoveryFragment.PlaceComponentResult(PromoDiscoveryFragment.this, "Nearby");
                r0.startActivity(new Intent(PromoDiscoveryFragment.this.getContext(), NewNearbyMeActivity.class));
            }
        });
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[7];
        FourKingSectionAdapter fourKingSectionAdapter = this.scheduleImpl;
        if (fourKingSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            fourKingSectionAdapter = null;
        }
        adapterArr[0] = fourKingSectionAdapter;
        VoucherListSectionAdapter voucherListSectionAdapter = this.initRecordTimeStamp;
        if (voucherListSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            voucherListSectionAdapter = null;
        }
        adapterArr[1] = voucherListSectionAdapter;
        NearbySectionAdapter nearbySectionAdapter = this.getErrorConfigVersion;
        if (nearbySectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nearbySectionAdapter = null;
        }
        adapterArr[2] = nearbySectionAdapter;
        ExpiredVouchersSectionAdapter expiredVouchersSectionAdapter = this.MyBillsEntityDataFactory;
        if (expiredVouchersSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            expiredVouchersSectionAdapter = null;
        }
        adapterArr[3] = expiredVouchersSectionAdapter;
        DanaDealsSectionAdapter danaDealsSectionAdapter = this.PlaceComponentResult;
        if (danaDealsSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaDealsSectionAdapter = null;
        }
        adapterArr[4] = danaDealsSectionAdapter;
        ReferralAndPromoCodeSectionAdapter referralAndPromoCodeSectionAdapter2 = this.GetContactSyncConfig;
        if (referralAndPromoCodeSectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            referralAndPromoCodeSectionAdapter2 = null;
        }
        adapterArr[5] = referralAndPromoCodeSectionAdapter2;
        BankPromoSectionAdapter bankPromoSectionAdapter = this.getAuthRequestContext;
        if (bankPromoSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bankPromoSectionAdapter = null;
        }
        adapterArr[6] = bankPromoSectionAdapter;
        this.BuiltInFictitiousFunctionClassFactory = new ConcatAdapter(adapterArr);
        RecyclerView recyclerView = (RecyclerView) PlaceComponentResult(R.id.rv_sections);
        if (recyclerView != null) {
            ConcatAdapter concatAdapter = this.BuiltInFictitiousFunctionClassFactory;
            if (concatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                concatAdapter = null;
            }
            recyclerView.setAdapter(concatAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        }
        RecyclerView recyclerView2 = (RecyclerView) PlaceComponentResult(R.id.rv_sections);
        RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
        if (layoutManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        RecyclerView recyclerView3 = (RecyclerView) PlaceComponentResult(R.id.rv_sections);
        if (recyclerView3 != null) {
            recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$setupRecyclerView$2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrolled(p0, p1, p2);
                    ((DanaDefaultPullToRefresh) PromoDiscoveryFragment.this.PlaceComponentResult(R.id.GetKybCompressQrConfig_Factory_res_0x7f0a059f)).setEnable(linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0);
                }
            });
        }
        PromoDiscoveryContract.Presenter presenter2 = this.promoDiscoveryPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        presenter2.BuiltInFictitiousFunctionClassFactory();
        PromoDiscoveryContract.Presenter presenter3 = this.promoDiscoveryPresenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.KClassImpl$Data$declaredNonStaticMembers$2();
        DanaDefaultPullToRefresh danaDefaultPullToRefresh = (DanaDefaultPullToRefresh) PlaceComponentResult(R.id.GetKybCompressQrConfig_Factory_res_0x7f0a059f);
        if (danaDefaultPullToRefresh != null) {
            danaDefaultPullToRefresh.setDanaPullToRefreshListener(new DanaPullToRefreshListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryFragment$initPullToRefresh$1
                @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
                public final void PlaceComponentResult(PtrFrameLayout p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PromoDiscoveryFragment.PrepareContext(PromoDiscoveryFragment.this);
                    PromoDiscoveryFragment.initRecordTimeStamp(PromoDiscoveryFragment.this);
                }

                @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    ((DanaDefaultPullToRefresh) PromoDiscoveryFragment.this.PlaceComponentResult(R.id.GetKybCompressQrConfig_Factory_res_0x7f0a059f)).cancelRefreshProgress();
                }
            });
        }
        PromoDiscoveryContract.Presenter presenter4 = this.promoDiscoveryPresenter;
        if (presenter4 != null) {
            presenter = presenter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.getErrorConfigVersion();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int p0, int p1, Intent p2) {
        if (p2 != null) {
            if (p0 != 100) {
                super.onActivityResult(p0, p1, p2);
            } else if (p1 == -1) {
                MyBillsEntityDataFactory();
            }
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
