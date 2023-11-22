package id.dana.globalsearch.view;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.globalsearch.AbstractGlobalSearchView;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.NetworkUtils;
import id.dana.databinding.FragmentGlobalSearchBinding;
import id.dana.databinding.ItemGlobalSearchLoadingBinding;
import id.dana.databinding.ViewPopularRecentSearchBinding;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.eventbus.models.TimerEvent;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.explore.domain.globalsearch.model.GlobalSearchConfig;
import id.dana.extension.lang.StringExtKt;
import id.dana.globalsearch.adapter.AutoCompleteAdapter;
import id.dana.globalsearch.adapter.PopularSearchAdapter;
import id.dana.globalsearch.adapter.RecentSearchAdapter;
import id.dana.globalsearch.basecategory.CategoryVerticalView;
import id.dana.globalsearch.constants.GlobalSearchErrorCode;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.RecentAutoComplete;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker;
import id.dana.globalsearch.tracker.model.SearchResultOpenTrackerModel;
import id.dana.globalsearch.view.sku.CategorySKUView;
import id.dana.globalsearch.view.widget.GlobalSearchErrorStateView;
import id.dana.lib.gcontainer.GContainer;
import id.dana.richview.globalsearch.ToolbarGlobalSearchView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.util.permission.Permission;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001LB\u0007¢\u0006\u0004\bK\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u0006J)\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0006J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\b\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0006J\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001f\u0010!J)\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\b\u0010\"J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020$H\u0016¢\u0006\u0004\b\b\u0010%J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016¢\u0006\u0004\b\b\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u0018J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020+H\u0002¢\u0006\u0004\b\b\u0010,J\u001d\u0010\u001c\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00160'H\u0016¢\u0006\u0004\b\u001c\u0010)J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0006J\u001d\u0010\u001f\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00160'H\u0016¢\u0006\u0004\b\u001f\u0010)J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010\u0018J\u0017\u0010/\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u0016H\u0002¢\u0006\u0004\b/\u00100R\u0016\u0010\u001a\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u00102R\u0013\u0010\u001c\u001a\u000203X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\b\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00106R\u0012\u00108\u001a\u000207X\u0087\"¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\u001d\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u00106R\u0016\u0010\u001f\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u00106R\u0016\u0010/\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u00106R\u0016\u0010*\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u00106R\u0018\u0010\u001e\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010.\u001a\u00020@8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010&\u001a\u00020C8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010:\u001a\u00020F8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u00104\u001a\u00020I8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010J"}, d2 = {"Lid/dana/globalsearch/view/GlobalSearchFragment;", "Lid/dana/contract/globalsearch/AbstractGlobalSearchView;", "Lid/dana/databinding/FragmentGlobalSearchBinding;", "Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "", "GetContactSyncConfig", "()V", "dismissProgress", "PlaceComponentResult", "()Lid/dana/contract/globalsearch/GlobalSearchContract$View;", "", "getLayout", "()I", "NetworkUserEntityData$$ExternalSyntheticLambda2", IAPSyncCommand.COMMAND_INIT, "p0", "p1", "Landroid/content/Intent;", "p2", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroyView", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "Lid/dana/globalsearch/model/SearchResultModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/globalsearch/model/SearchResultModel;)V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "getAuthRequestContext", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;Ljava/lang/String;)V", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/eventbus/models/TimerEvent;", "", "(Lid/dana/eventbus/models/TimerEvent;J)V", "initRecordTimeStamp", "", "Lid/dana/globalsearch/model/RecentAutoComplete;", "(Ljava/util/List;)V", "scheduleImpl", "", "(Z)V", "showProgress", "moveToNextValue", "getErrorConfigVersion", "(Ljava/lang/String;)Z", "Lid/dana/globalsearch/adapter/AutoCompleteAdapter;", "Lid/dana/globalsearch/adapter/AutoCompleteAdapter;", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/Lazy;", "Z", "Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "globalSearchAnalyticTracker", "Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "DatabaseTableConfigUtil", "Lio/reactivex/disposables/Disposable;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lio/reactivex/disposables/Disposable;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "newProxyInstance", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lid/dana/globalsearch/adapter/PopularSearchAdapter;", "isLayoutRequested", "Lid/dana/globalsearch/adapter/PopularSearchAdapter;", "Lid/dana/globalsearch/adapter/RecentSearchAdapter;", "PrepareContext", "Lid/dana/globalsearch/adapter/RecentSearchAdapter;", "Lid/dana/globalsearch/tracker/model/SearchResultOpenTrackerModel;", "Lid/dana/globalsearch/tracker/model/SearchResultOpenTrackerModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSearchFragment extends AbstractGlobalSearchView<FragmentGlobalSearchBinding> implements GlobalSearchContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private Disposable lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private RecentSearchAdapter DatabaseTableConfigUtil;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    boolean PlaceComponentResult;
    @Inject
    public GlobalSearchAnalyticTracker globalSearchAnalyticTracker;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private PopularSearchAdapter initRecordTimeStamp;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final FragmentPermissionRequest moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private AutoCompleteAdapter BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> lookAheadTest = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(GlobalSearchFragment.this.requireActivity());
        }
    });

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    SearchResultOpenTrackerModel NetworkUserEntityData$$ExternalSyntheticLambda1 = new SearchResultOpenTrackerModel();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean getAuthRequestContext = true;

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str) {
        GlobalSearchContract.View.CC.PlaceComponentResult(str);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(List list) {
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory() {
        GlobalSearchContract.View.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory(GlobalSearchConfig globalSearchConfig) {
        GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(globalSearchConfig);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
        GlobalSearchContract.View.CC.getAuthRequestContext();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void PlaceComponentResult(String str) {
        GlobalSearchContract.View.CC.MyBillsEntityDataFactory(str);
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.lookAheadTest.clear();
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.lookAheadTest;
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

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void getAuthRequestContext(SearchResultModel searchResultModel) {
        GlobalSearchContract.View.CC.PlaceComponentResult(searchResultModel);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void getAuthRequestContext(boolean z) {
        GlobalSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_global_search;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void lookAheadTest() {
        GlobalSearchContract.View.CC.lookAheadTest();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void moveToNextValue() {
        GlobalSearchContract.View.CC.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final /* synthetic */ void scheduleImpl(SearchResultModel searchResultModel) {
        GlobalSearchContract.View.CC.moveToNextValue(searchResultModel);
    }

    public GlobalSearchFragment() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$permissionRequest$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    GlobalSearchFragment.DatabaseTableConfigUtil(GlobalSearchFragment.this);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Context requireContext = GlobalSearchFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                PermissionHelper.MyBillsEntityDataFactory(requireContext);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Context requireContext = GlobalSearchFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                PermissionHelper.getAuthRequestContext(requireContext, p0);
                GlobalSearchAnalyticTracker globalSearchAnalyticTracker = GlobalSearchFragment.this.globalSearchAnalyticTracker;
                if (globalSearchAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    globalSearchAnalyticTracker = null;
                }
                globalSearchAnalyticTracker.getAuthRequestContext();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.moveToNextValue = builder.PlaceComponentResult();
    }

    public static final /* synthetic */ FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment globalSearchFragment) {
        return (FragmentGlobalSearchBinding) globalSearchFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentGlobalSearchBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentGlobalSearchBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        CategoryVerticalView categoryVerticalView;
        CategoryVerticalView categoryVerticalView2;
        CategoryVerticalView categoryVerticalView3;
        CategoryVerticalView categoryVerticalView4;
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding;
        RecyclerView recyclerView;
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding2;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        ToolbarGlobalSearchView toolbarGlobalSearchView;
        l_().BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(k_(), j_(), h_(), i_(), NetworkUserEntityData$$ExternalSyntheticLambda0());
        GetContactSyncConfig();
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding != null && (toolbarGlobalSearchView = fragmentGlobalSearchBinding.moveToNextValue) != null) {
            toolbarGlobalSearchView.setPointerFocus();
            toolbarGlobalSearchView.setMenuButtonListener();
            toolbarGlobalSearchView.setListener(new ToolbarGlobalSearchView.Listener() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$initToolbar$1$1
                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void BuiltInFictitiousFunctionClassFactory() {
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void MyBillsEntityDataFactory(CharSequence p0) {
                    boolean errorConfigVersion;
                    NestedScrollView nestedScrollView;
                    boolean z;
                    GlobalSearchErrorStateView globalSearchErrorStateView;
                    boolean z2;
                    GlobalSearchContract.Presenter k_;
                    boolean z3;
                    boolean z4;
                    FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory;
                    GlobalSearchErrorStateView globalSearchErrorStateView2;
                    GlobalSearchFragment.this.PlaceComponentResult(CollectionsKt.emptyList());
                    String obj = p0 != null ? p0.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    String obj2 = StringsKt.trim((CharSequence) obj).toString();
                    errorConfigVersion = GlobalSearchFragment.getErrorConfigVersion(obj2);
                    if (errorConfigVersion) {
                        k_ = GlobalSearchFragment.this.k_();
                        k_.MyBillsEntityDataFactory(obj2);
                        GlobalSearchFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2();
                        z3 = GlobalSearchFragment.this.getErrorConfigVersion;
                        if (!z3 && (BuiltInFictitiousFunctionClassFactory = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this)) != null && (globalSearchErrorStateView2 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2) != null) {
                            globalSearchErrorStateView2.setErrorState("success");
                        }
                        z4 = GlobalSearchFragment.this.PlaceComponentResult;
                        if (!z4) {
                            FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory2 = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this);
                            RecyclerView recyclerView4 = BuiltInFictitiousFunctionClassFactory2 != null ? BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
                            if (recyclerView4 != null) {
                                recyclerView4.setVisibility(0);
                            }
                            FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory3 = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this);
                            nestedScrollView = BuiltInFictitiousFunctionClassFactory3 != null ? BuiltInFictitiousFunctionClassFactory3.lookAheadTest : null;
                            if (nestedScrollView != null) {
                                nestedScrollView.setVisibility(0);
                            }
                        }
                    } else {
                        GlobalSearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                        FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory4 = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this);
                        if (BuiltInFictitiousFunctionClassFactory4 != null && (globalSearchErrorStateView = BuiltInFictitiousFunctionClassFactory4.NetworkUserEntityData$$ExternalSyntheticLambda2) != null) {
                            GlobalSearchFragment globalSearchFragment = GlobalSearchFragment.this;
                            if (!globalSearchErrorStateView.isShown()) {
                                globalSearchFragment.GetContactSyncConfig();
                            }
                        }
                        FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory5 = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this);
                        RecyclerView recyclerView5 = BuiltInFictitiousFunctionClassFactory5 != null ? BuiltInFictitiousFunctionClassFactory5.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
                        if (recyclerView5 != null) {
                            recyclerView5.setVisibility(8);
                        }
                        FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory6 = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this);
                        nestedScrollView = BuiltInFictitiousFunctionClassFactory6 != null ? BuiltInFictitiousFunctionClassFactory6.lookAheadTest : null;
                        if (nestedScrollView != null) {
                            nestedScrollView.setVisibility(8);
                        }
                        z = GlobalSearchFragment.this.scheduleImpl;
                        if (!z) {
                            GlobalSearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchFragment.this, obj2);
                        }
                    }
                    z2 = GlobalSearchFragment.this.getErrorConfigVersion;
                    if (z2) {
                        GlobalSearchFragment.this.getErrorConfigVersion = false;
                    }
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void MyBillsEntityDataFactory() {
                    GlobalSearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    GlobalSearchFragment.this.GetContactSyncConfig();
                    FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this);
                    NestedScrollView nestedScrollView = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.lookAheadTest : null;
                    if (nestedScrollView != null) {
                        nestedScrollView.setVisibility(8);
                    }
                    FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory2 = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this);
                    RecyclerView recyclerView4 = BuiltInFictitiousFunctionClassFactory2 != null ? BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
                    if (recyclerView4 != null) {
                        recyclerView4.setVisibility(8);
                    }
                    GlobalSearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchFragment.this);
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void getAuthRequestContext() {
                    GlobalSearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    GlobalSearchFragment.this.initRecordTimeStamp();
                    GlobalSearchFragment.this.requireActivity().onBackPressed();
                }

                @Override // id.dana.richview.globalsearch.ToolbarGlobalSearchView.Listener
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    boolean errorConfigVersion;
                    SearchResultOpenTrackerModel searchResultOpenTrackerModel;
                    SearchResultOpenTrackerModel searchResultOpenTrackerModel2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    GlobalSearchFragment.this.BuiltInFictitiousFunctionClassFactory(TimerEventKey.EXPLORE_SEARCH);
                    GlobalSearchFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                    GlobalSearchFragment.this.getErrorConfigVersion = true;
                    errorConfigVersion = GlobalSearchFragment.getErrorConfigVersion(p0);
                    if (errorConfigVersion) {
                        r1.k_().PlaceComponentResult(new GlobalSearchFragment$suggestEnableLocation$1(GlobalSearchFragment.this, p0, null));
                    }
                    searchResultOpenTrackerModel = GlobalSearchFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    Intrinsics.checkNotNullParameter("Custom", "");
                    searchResultOpenTrackerModel.BuiltInFictitiousFunctionClassFactory = "Custom";
                    searchResultOpenTrackerModel2 = GlobalSearchFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    Intrinsics.checkNotNullParameter(p0, "");
                    searchResultOpenTrackerModel2.PlaceComponentResult = p0;
                }
            });
        }
        AutoCompleteAdapter autoCompleteAdapter = new AutoCompleteAdapter();
        autoCompleteAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                GlobalSearchFragment.PlaceComponentResult(GlobalSearchFragment.this, i);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = autoCompleteAdapter;
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding2 != null && (recyclerView3 = fragmentGlobalSearchBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext(), 1, false));
            AutoCompleteAdapter autoCompleteAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (autoCompleteAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                autoCompleteAdapter2 = null;
            }
            recyclerView3.setAdapter(autoCompleteAdapter2);
        }
        PopularSearchAdapter popularSearchAdapter = new PopularSearchAdapter();
        popularSearchAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda2
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                GlobalSearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchFragment.this, i);
            }
        });
        this.initRecordTimeStamp = popularSearchAdapter;
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding3 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding3 != null && (viewPopularRecentSearchBinding2 = fragmentGlobalSearchBinding3.scheduleImpl) != null && (recyclerView2 = viewPopularRecentSearchBinding2.MyBillsEntityDataFactory) != null) {
            recyclerView2.setLayoutManager(new FlexboxLayoutManager(recyclerView2.getContext(), 0));
            PopularSearchAdapter popularSearchAdapter2 = this.initRecordTimeStamp;
            if (popularSearchAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                popularSearchAdapter2 = null;
            }
            recyclerView2.setAdapter(popularSearchAdapter2);
        }
        RecentSearchAdapter recentSearchAdapter = new RecentSearchAdapter(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda3
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment.this, i);
            }
        });
        recentSearchAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda4
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                GlobalSearchFragment.getAuthRequestContext(GlobalSearchFragment.this, i);
            }
        });
        this.DatabaseTableConfigUtil = recentSearchAdapter;
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding4 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding4 != null && (viewPopularRecentSearchBinding = fragmentGlobalSearchBinding4.scheduleImpl) != null && (recyclerView = viewPopularRecentSearchBinding.BuiltInFictitiousFunctionClassFactory) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            RecentSearchAdapter recentSearchAdapter2 = this.DatabaseTableConfigUtil;
            if (recentSearchAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recentSearchAdapter2 = null;
            }
            recyclerView.setAdapter(recentSearchAdapter2);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding5 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding5 != null) {
            CategoryVerticalView categoryVerticalView5 = fragmentGlobalSearchBinding5.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(categoryVerticalView5, "");
            CategorySKUView categorySKUView = fragmentGlobalSearchBinding5.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(categorySKUView, "");
            CategoryVerticalView categoryVerticalView6 = fragmentGlobalSearchBinding5.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(categoryVerticalView6, "");
            View[] viewArr = {categoryVerticalView5, categorySKUView, categoryVerticalView6};
            for (int i = 0; i < 3; i++) {
                viewArr[i].findViewById(R.id.btn_permission_location).setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GlobalSearchFragment.MyBillsEntityDataFactory(GlobalSearchFragment.this);
                    }
                });
            }
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding6 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding6 != null && (categoryVerticalView4 = fragmentGlobalSearchBinding6.getAuthRequestContext) != null) {
            categoryVerticalView4.setSeeAllClickListener(new Function0<Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$setupSeeAllHeader$1$1
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
                    GlobalSearchFragment.getAuthRequestContext(GlobalSearchFragment.this, "OFFLINE_MERCHANT");
                }
            });
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding7 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding7 != null && (categoryVerticalView3 = fragmentGlobalSearchBinding7.PlaceComponentResult) != null) {
            categoryVerticalView3.setSeeAllClickListener(new Function0<Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$setupSeeAllHeader$2$1
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
                    GlobalSearchFragment.getAuthRequestContext(GlobalSearchFragment.this, "SERVICE");
                }
            });
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding8 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding8 != null && (categoryVerticalView2 = fragmentGlobalSearchBinding8.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            categoryVerticalView2.setSeeAllClickListener(new Function0<Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$setupSeeAllHeader$3$1
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
                    GlobalSearchFragment.getAuthRequestContext(GlobalSearchFragment.this, "DF");
                }
            });
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding9 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding9 != null && (categoryVerticalView = fragmentGlobalSearchBinding9.BuiltInFictitiousFunctionClassFactory) != null) {
            categoryVerticalView.setSeeAllClickListener(new Function0<Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$setupSeeAllHeader$4$1
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
                    GlobalSearchFragment.getAuthRequestContext(GlobalSearchFragment.this, "ONLINE_MERCHANT");
                }
            });
        }
        k_().getErrorConfigVersion();
        k_().PlaceComponentResult();
        k_().MyBillsEntityDataFactory();
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("SEARCH_PARAMS")) {
            return;
        }
        String string = arguments.getString("SEARCH_PARAMS");
        k_().PlaceComponentResult(new GlobalSearchFragment$suggestEnableLocation$1(this, string != null ? string : "", null));
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView
    public final GlobalSearchContract.View PlaceComponentResult() {
        return this;
    }

    @Override // id.dana.eventbus.base.BaseFragmentWithPageLoadTracker
    public final void PlaceComponentResult(TimerEvent p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = p0.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory("Ready in Milliseconds", p1).BuiltInFictitiousFunctionClassFactory(p0.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.INITIAL_LOAD, p0.getBuiltInFictitiousFunctionClassFactory());
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, (byte) 0));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int p0, int p1, Intent p2) {
        if (p0 == 10) {
            if (p1 == -1) {
                k_().NetworkUserEntityData$$ExternalSyntheticLambda1();
            }
        } else if (p0 == 24 && p2 != null && p1 == 29) {
            String stringExtra = p2.getStringExtra(SeeAllActivity.GLOBAL_SEARCH_KEYWORD);
            if (stringExtra == null) {
                stringExtra = "";
            }
            FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
            if (fragmentGlobalSearchBinding != null) {
                fragmentGlobalSearchBinding.moveToNextValue.showKeyword(stringExtra);
            }
            k_().PlaceComponentResult(new GlobalSearchFragment$suggestEnableLocation$1(this, stringExtra, null));
        }
    }

    @Override // id.dana.contract.globalsearch.AbstractGlobalSearchView, id.dana.eventbus.base.BaseFragmentWithPageLoadTracker, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Disposable disposable = this.lookAheadTest;
        if (disposable != null) {
            disposable.dispose();
        }
        k_().getAuthRequestContext();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void PlaceComponentResult(List<RecentAutoComplete> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(false);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        AutoCompleteAdapter autoCompleteAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (autoCompleteAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            autoCompleteAdapter = null;
        }
        autoCompleteAdapter.setItems(p0);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void scheduleImpl() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        MyBillsEntityDataFactory("003");
    }

    public static boolean getErrorConfigVersion(String p0) {
        return p0.length() >= 3;
    }

    public final void GetContactSyncConfig() {
        GlobalSearchErrorStateView globalSearchErrorStateView;
        ItemGlobalSearchLoadingBinding itemGlobalSearchLoadingBinding;
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        RelativeLayout relativeLayout = (fragmentGlobalSearchBinding == null || (itemGlobalSearchLoadingBinding = fragmentGlobalSearchBinding.getErrorConfigVersion) == null) ? null : itemGlobalSearchLoadingBinding.BuiltInFictitiousFunctionClassFactory;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding2 == null || (globalSearchErrorStateView = fragmentGlobalSearchBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) {
            return;
        }
        globalSearchErrorStateView.setErrorState(GlobalSearchErrorCode.INITIAL_STATE);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final SearchResultModel p0) {
        CategoryVerticalView categoryVerticalView;
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding == null || (categoryVerticalView = fragmentGlobalSearchBinding.getAuthRequestContext) == null) {
            return;
        }
        categoryVerticalView.setData(p0);
        categoryVerticalView.setItemClickCallback(new Function1<Integer, Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$onGetOfflineMerchantCategory$1$1
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
                GlobalSearchFragment.MyBillsEntityDataFactory(GlobalSearchFragment.this, p0.getAuthRequestContext.get(i));
            }
        });
    }

    private final void moveToNextValue(String p0) {
        TimerEvent timerEvent = new TimerEvent(TimerEventKey.EXPLORE_SEARCH, MapsKt.hashMapOf(new Pair("Global Search Category", p0)), this.getAuthRequestContext);
        Intrinsics.checkNotNullParameter(timerEvent, "");
        EventBus.getDefault().post(timerEvent);
        this.getAuthRequestContext = false;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void getAuthRequestContext(ThirdPartyServiceResponse p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (UrlUtil.getErrorConfigVersion(p1)) {
            getErrorConfigVersion().MyBillsEntityDataFactory(p1);
            return;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(p1);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, authRequestContext, null, null);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void PlaceComponentResult(ThirdPartyServiceResponse p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String authRequestContext = UrlUtil.getAuthRequestContext(p1);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, authRequestContext, p2, g_().getDeviceUUID());
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        ToolbarGlobalSearchView toolbarGlobalSearchView;
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding != null && (toolbarGlobalSearchView = fragmentGlobalSearchBinding.moveToNextValue) != null) {
            toolbarGlobalSearchView.showKeyword(p0);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        NestedScrollView nestedScrollView = fragmentGlobalSearchBinding2 != null ? fragmentGlobalSearchBinding2.lookAheadTest : null;
        if (nestedScrollView != null) {
            nestedScrollView.setVisibility(0);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding3 = (FragmentGlobalSearchBinding) getBinding();
        RecyclerView recyclerView = fragmentGlobalSearchBinding3 != null ? fragmentGlobalSearchBinding3.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding;
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding2;
        ToolbarGlobalSearchView toolbarGlobalSearchView;
        ToolbarGlobalSearchView toolbarGlobalSearchView2;
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        if (NetworkUtils.isNetworkAvailable(baseActivity)) {
            if (Intrinsics.areEqual(str, "004")) {
                getBaseActivity().showWarningDialog(getString(R.string.global_search_error_message_dialog));
            } else if (str != null) {
                MyBillsEntityDataFactory(str);
            }
            if (Intrinsics.areEqual(str, "003")) {
                FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
                if (fragmentGlobalSearchBinding != null && (toolbarGlobalSearchView2 = fragmentGlobalSearchBinding.moveToNextValue) != null) {
                    toolbarGlobalSearchView2.hideClearSearchButton();
                }
                FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
                if (fragmentGlobalSearchBinding2 != null && (toolbarGlobalSearchView = fragmentGlobalSearchBinding2.moveToNextValue) != null) {
                    toolbarGlobalSearchView.clearPointerFocus();
                }
            }
        } else {
            MyBillsEntityDataFactory("002");
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding3 = (FragmentGlobalSearchBinding) getBinding();
        GlobalSearchAnalyticTracker globalSearchAnalyticTracker = null;
        LinearLayout linearLayout = (fragmentGlobalSearchBinding3 == null || (viewPopularRecentSearchBinding2 = fragmentGlobalSearchBinding3.scheduleImpl) == null) ? null : viewPopularRecentSearchBinding2.PlaceComponentResult;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding4 = (FragmentGlobalSearchBinding) getBinding();
        LinearLayout linearLayout2 = (fragmentGlobalSearchBinding4 == null || (viewPopularRecentSearchBinding = fragmentGlobalSearchBinding4.scheduleImpl) == null) ? null : viewPopularRecentSearchBinding.getAuthRequestContext;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory = Intrinsics.areEqual(str, "003") ? TrackerKey.ResultStatusType.NO_RESULT_PAGE : TrackerKey.ResultStatusType.ERROR_PAGE;
        GlobalSearchAnalyticTracker globalSearchAnalyticTracker2 = this.globalSearchAnalyticTracker;
        if (globalSearchAnalyticTracker2 != null) {
            globalSearchAnalyticTracker = globalSearchAnalyticTracker2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        globalSearchAnalyticTracker.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SearchResultOpenTrackerModel();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        GlobalSearchErrorStateView globalSearchErrorStateView;
        this.scheduleImpl = true;
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.MyBillsEntityDataFactory.getValue();
        if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        RecyclerView recyclerView = fragmentGlobalSearchBinding != null ? fragmentGlobalSearchBinding.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding2 == null || (globalSearchErrorStateView = fragmentGlobalSearchBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) {
            return;
        }
        globalSearchErrorStateView.setErrorState("success");
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        KeyboardHelper.MyBillsEntityDataFactory(getActivity());
        GetContactSyncConfig();
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void MyBillsEntityDataFactory(List<String> p0) {
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding;
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding2;
        Intrinsics.checkNotNullParameter(p0, "");
        LinearLayout linearLayout = null;
        if ((!p0.isEmpty()) != false) {
            PopularSearchAdapter popularSearchAdapter = this.initRecordTimeStamp;
            if (popularSearchAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                popularSearchAdapter = null;
            }
            popularSearchAdapter.setItems(p0);
            FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
            if (fragmentGlobalSearchBinding != null && (viewPopularRecentSearchBinding2 = fragmentGlobalSearchBinding.scheduleImpl) != null) {
                linearLayout = viewPopularRecentSearchBinding2.getAuthRequestContext;
            }
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            PlaceComponentResult(true);
            return;
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding2 != null && (viewPopularRecentSearchBinding = fragmentGlobalSearchBinding2.scheduleImpl) != null) {
            linearLayout = viewPopularRecentSearchBinding.getAuthRequestContext;
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private final void PlaceComponentResult(boolean p0) {
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding;
        GlobalSearchErrorStateView globalSearchErrorStateView;
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding2;
        if (!p0 || this.KClassImpl$Data$declaredNonStaticMembers$2) {
            FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
            if (fragmentGlobalSearchBinding != null && (viewPopularRecentSearchBinding = fragmentGlobalSearchBinding.scheduleImpl) != null) {
                r1 = viewPopularRecentSearchBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (r1 != null) {
                r1.setVisibility(8);
                return;
            }
            return;
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        LinearLayout linearLayout = (fragmentGlobalSearchBinding2 == null || (viewPopularRecentSearchBinding2 = fragmentGlobalSearchBinding2.scheduleImpl) == null) ? null : viewPopularRecentSearchBinding2.KClassImpl$Data$declaredNonStaticMembers$2;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding3 = (FragmentGlobalSearchBinding) getBinding();
        r1 = fragmentGlobalSearchBinding3 != null ? fragmentGlobalSearchBinding3.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (r1 != null) {
            r1.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding4 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding4 == null || (globalSearchErrorStateView = fragmentGlobalSearchBinding4.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) {
            return;
        }
        globalSearchErrorStateView.setErrorState(GlobalSearchErrorCode.INITIAL_STATE);
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void getAuthRequestContext(List<String> p0) {
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding;
        GlobalSearchErrorStateView globalSearchErrorStateView;
        ViewPopularRecentSearchBinding viewPopularRecentSearchBinding2;
        Intrinsics.checkNotNullParameter(p0, "");
        LinearLayout linearLayout = null;
        if ((!p0.isEmpty()) != false) {
            RecentSearchAdapter recentSearchAdapter = this.DatabaseTableConfigUtil;
            if (recentSearchAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recentSearchAdapter = null;
            }
            recentSearchAdapter.setItems(p0);
            FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
            if (fragmentGlobalSearchBinding == null || (globalSearchErrorStateView = fragmentGlobalSearchBinding.NetworkUserEntityData$$ExternalSyntheticLambda2) == null || globalSearchErrorStateView.isShown()) {
                return;
            }
            FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
            if (fragmentGlobalSearchBinding2 != null && (viewPopularRecentSearchBinding2 = fragmentGlobalSearchBinding2.scheduleImpl) != null) {
                linearLayout = viewPopularRecentSearchBinding2.PlaceComponentResult;
            }
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            PlaceComponentResult(true);
            return;
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding3 = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding3 != null && (viewPopularRecentSearchBinding = fragmentGlobalSearchBinding3.scheduleImpl) != null) {
            linearLayout = viewPopularRecentSearchBinding.PlaceComponentResult;
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        CategoryVerticalView categoryVerticalView = fragmentGlobalSearchBinding != null ? fragmentGlobalSearchBinding.getAuthRequestContext : null;
        if (categoryVerticalView != null) {
            categoryVerticalView.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        CategoryVerticalView categoryVerticalView2 = fragmentGlobalSearchBinding2 != null ? fragmentGlobalSearchBinding2.BuiltInFictitiousFunctionClassFactory : null;
        if (categoryVerticalView2 != null) {
            categoryVerticalView2.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding3 = (FragmentGlobalSearchBinding) getBinding();
        CategoryVerticalView categoryVerticalView3 = fragmentGlobalSearchBinding3 != null ? fragmentGlobalSearchBinding3.PlaceComponentResult : null;
        if (categoryVerticalView3 != null) {
            categoryVerticalView3.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding4 = (FragmentGlobalSearchBinding) getBinding();
        CategorySKUView categorySKUView = fragmentGlobalSearchBinding4 != null ? fragmentGlobalSearchBinding4.MyBillsEntityDataFactory : null;
        if (categorySKUView != null) {
            categorySKUView.setVisibility(8);
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding5 = (FragmentGlobalSearchBinding) getBinding();
        CategoryVerticalView categoryVerticalView4 = fragmentGlobalSearchBinding5 != null ? fragmentGlobalSearchBinding5.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (categoryVerticalView4 != null) {
            categoryVerticalView4.setVisibility(8);
        }
    }

    private final void MyBillsEntityDataFactory(String p0) {
        GlobalSearchErrorStateView globalSearchErrorStateView;
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding == null || (globalSearchErrorStateView = fragmentGlobalSearchBinding.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) {
            return;
        }
        globalSearchErrorStateView.setErrorState(p0);
        globalSearchErrorStateView.setTryAgainClickListener(new Function0<Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$showErrorState$1$1
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
                ToolbarGlobalSearchView toolbarGlobalSearchView;
                GlobalSearchFragment globalSearchFragment = GlobalSearchFragment.this;
                FragmentGlobalSearchBinding BuiltInFictitiousFunctionClassFactory = GlobalSearchFragment.BuiltInFictitiousFunctionClassFactory(globalSearchFragment);
                globalSearchFragment.k_().PlaceComponentResult(new GlobalSearchFragment$suggestEnableLocation$1(globalSearchFragment, StringsKt.trim((CharSequence) String.valueOf((BuiltInFictitiousFunctionClassFactory == null || (toolbarGlobalSearchView = BuiltInFictitiousFunctionClassFactory.moveToNextValue) == null) ? null : toolbarGlobalSearchView.getKeyword())).toString(), null));
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/globalsearch/view/GlobalSearchFragment$Companion;", "", "Lid/dana/globalsearch/view/GlobalSearchFragment;", "PlaceComponentResult", "()Lid/dana/globalsearch/view/GlobalSearchFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static GlobalSearchFragment PlaceComponentResult() {
            return new GlobalSearchFragment();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GlobalSearchFragment globalSearchFragment) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        globalSearchFragment.moveToNextValue.check();
    }

    public static /* synthetic */ void PlaceComponentResult(GlobalSearchFragment globalSearchFragment, int i) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        AutoCompleteAdapter autoCompleteAdapter = globalSearchFragment.BuiltInFictitiousFunctionClassFactory;
        if (autoCompleteAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            autoCompleteAdapter = null;
        }
        RecentAutoComplete item = autoCompleteAdapter.getItem(i);
        if (item != null) {
            globalSearchFragment.k_().PlaceComponentResult(new GlobalSearchFragment$suggestEnableLocation$1(globalSearchFragment, item.BuiltInFictitiousFunctionClassFactory, item.getAuthRequestContext));
            SearchResultOpenTrackerModel searchResultOpenTrackerModel = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str = item.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullParameter(str, "");
            if (!Intrinsics.areEqual("RECENT", str)) {
                searchResultOpenTrackerModel.BuiltInFictitiousFunctionClassFactory = TrackerKey.KeywordType.SUGGESTION;
                searchResultOpenTrackerModel.getAuthRequestContext = i != 0 ? i != 1 ? i != 2 ? i != 3 ? TrackerKey.SuggestionOrderType.ORDER_MORE_THAN_FOUR : TrackerKey.SuggestionOrderType.ORDER_FOUR : TrackerKey.SuggestionOrderType.ORDER_THREE : TrackerKey.SuggestionOrderType.ORDER_TWO : TrackerKey.SuggestionOrderType.ORDER_ONE;
            } else {
                searchResultOpenTrackerModel.BuiltInFictitiousFunctionClassFactory = TrackerKey.KeywordType.HISTORY;
            }
            SearchResultOpenTrackerModel searchResultOpenTrackerModel2 = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str2 = item.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(str2, "");
            searchResultOpenTrackerModel2.PlaceComponentResult = str2;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(GlobalSearchFragment globalSearchFragment) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        globalSearchFragment.k_().NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    public static /* synthetic */ void PlaceComponentResult(GlobalSearchFragment globalSearchFragment, String str, List list) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        globalSearchFragment.BuiltInFictitiousFunctionClassFactory(TimerEventKey.EXPLORE_SEARCH);
        GlobalSearchContract.Presenter.CC.getAuthRequestContext(globalSearchFragment.k_(), str, 0, 0, list, null, 22);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(GlobalSearchFragment globalSearchFragment, int i) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        GlobalSearchContract.Presenter k_ = globalSearchFragment.k_();
        RecentSearchAdapter recentSearchAdapter = globalSearchFragment.DatabaseTableConfigUtil;
        if (recentSearchAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recentSearchAdapter = null;
        }
        String item = recentSearchAdapter.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        k_.BuiltInFictitiousFunctionClassFactory(item);
    }

    public static /* synthetic */ void getAuthRequestContext(GlobalSearchFragment globalSearchFragment, int i) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        RecentSearchAdapter recentSearchAdapter = globalSearchFragment.DatabaseTableConfigUtil;
        if (recentSearchAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recentSearchAdapter = null;
        }
        String item = recentSearchAdapter.getItem(i);
        if (item != null) {
            globalSearchFragment.k_().PlaceComponentResult(new GlobalSearchFragment$suggestEnableLocation$1(globalSearchFragment, item, null));
            SearchResultOpenTrackerModel searchResultOpenTrackerModel = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullParameter(TrackerKey.KeywordType.HISTORY, "");
            searchResultOpenTrackerModel.BuiltInFictitiousFunctionClassFactory = TrackerKey.KeywordType.HISTORY;
            SearchResultOpenTrackerModel searchResultOpenTrackerModel2 = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullParameter(item, "");
            searchResultOpenTrackerModel2.PlaceComponentResult = item;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(GlobalSearchFragment globalSearchFragment, String str, List list, Location location) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        globalSearchFragment.BuiltInFictitiousFunctionClassFactory(TimerEventKey.EXPLORE_SEARCH);
        GlobalSearchContract.Presenter.CC.getAuthRequestContext(globalSearchFragment.k_(), str, 0, 0, list, location, 6);
        Disposable disposable = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (disposable != null) {
            disposable.dispose();
            globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchFragment globalSearchFragment, int i) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        PopularSearchAdapter popularSearchAdapter = globalSearchFragment.initRecordTimeStamp;
        if (popularSearchAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            popularSearchAdapter = null;
        }
        String item = popularSearchAdapter.getItem(i);
        if (item != null) {
            globalSearchFragment.k_().PlaceComponentResult(new GlobalSearchFragment$suggestEnableLocation$1(globalSearchFragment, item, null));
            SearchResultOpenTrackerModel searchResultOpenTrackerModel = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullParameter(TrackerKey.KeywordType.POPULAR, "");
            searchResultOpenTrackerModel.BuiltInFictitiousFunctionClassFactory = TrackerKey.KeywordType.POPULAR;
            SearchResultOpenTrackerModel searchResultOpenTrackerModel2 = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullParameter(item, "");
            searchResultOpenTrackerModel2.PlaceComponentResult = item;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(GlobalSearchFragment globalSearchFragment, LocationSettingsResult locationSettingsResult) {
        PendingIntent resolution;
        Intrinsics.checkNotNullParameter(globalSearchFragment, "");
        Status status = locationSettingsResult.getStatus();
        IntentSender intentSender = (status == null || (resolution = status.getResolution()) == null) ? null : resolution.getIntentSender();
        if (intentSender != null) {
            Status status2 = locationSettingsResult.getStatus();
            boolean z = false;
            if (status2 != null && status2.getStatusCode() == 6) {
                z = true;
            }
            if (z) {
                try {
                    globalSearchFragment.startIntentSenderForResult(intentSender, 10, null, 0, 0, 0, null);
                    return;
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }
        globalSearchFragment.k_().NetworkUserEntityData$$ExternalSyntheticLambda1();
    }

    public static final /* synthetic */ void PlaceComponentResult(GlobalSearchFragment globalSearchFragment, String str) {
        if (str != null) {
            if (StringsKt.contains$default((CharSequence) StringExtKt.PlaceComponentResult(str), (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null)) {
                ReadLinkPropertiesContract.Presenter errorConfigVersion = globalSearchFragment.getErrorConfigVersion();
                String PlaceComponentResult = TextUtil.PlaceComponentResult(str, "");
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                errorConfigVersion.MyBillsEntityDataFactory(PlaceComponentResult);
            } else if (GContainer.isOpeningH5()) {
            } else {
                String authRequestContext = UrlUtil.getAuthRequestContext(str);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext);
            }
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchFragment globalSearchFragment) {
        globalSearchFragment.k_().PlaceComponentResult();
        globalSearchFragment.k_().MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void getAuthRequestContext(final GlobalSearchFragment globalSearchFragment, final String str, final List list) {
        Disposable disposable = globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (disposable != null) {
            disposable.dispose();
            globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        }
        globalSearchFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LocationUtil.LocationRequestBuilder((Application) globalSearchFragment.getBaseActivity().getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalSearchFragment.MyBillsEntityDataFactory(GlobalSearchFragment.this, str, list, (Location) obj);
            }
        }, new Consumer() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                GlobalSearchFragment.PlaceComponentResult(GlobalSearchFragment.this, str, list);
            }
        });
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(GlobalSearchFragment globalSearchFragment, String str) {
        GlobalSearchErrorStateView globalSearchErrorStateView;
        if (str.length() > 0) {
            FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) globalSearchFragment.getBinding();
            if (fragmentGlobalSearchBinding == null || (globalSearchErrorStateView = fragmentGlobalSearchBinding.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) {
                return;
            }
            globalSearchErrorStateView.setErrorState(GlobalSearchErrorCode.EMPTY_KEYWORD);
            return;
        }
        globalSearchFragment.PlaceComponentResult(true);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(GlobalSearchFragment globalSearchFragment, PaySearchInfoModel paySearchInfoModel) {
        GlobalSearchBottomSheetDialog globalSearchBottomSheetDialog = new GlobalSearchBottomSheetDialog();
        Intrinsics.checkNotNullParameter(paySearchInfoModel, "");
        globalSearchBottomSheetDialog.getAuthRequestContext = paySearchInfoModel;
        globalSearchBottomSheetDialog.show(globalSearchFragment.getBaseActivity().getSupportFragmentManager(), "Show Nearby Bottom Sheet for Global Search");
        GlobalSearchAnalyticTracker globalSearchAnalyticTracker = globalSearchFragment.globalSearchAnalyticTracker;
        GlobalSearchAnalyticTracker globalSearchAnalyticTracker2 = null;
        if (globalSearchAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSearchAnalyticTracker = null;
        }
        globalSearchAnalyticTracker.MyBillsEntityDataFactory();
        GlobalSearchAnalyticTracker globalSearchAnalyticTracker3 = globalSearchFragment.globalSearchAnalyticTracker;
        if (globalSearchAnalyticTracker3 != null) {
            globalSearchAnalyticTracker2 = globalSearchAnalyticTracker3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        globalSearchAnalyticTracker2.getAuthRequestContext(paySearchInfoModel);
    }

    public static final /* synthetic */ void DatabaseTableConfigUtil(final GlobalSearchFragment globalSearchFragment) {
        LocationRequest create = LocationRequest.create();
        create.setPriority(102);
        create.setNumUpdates(1);
        Intrinsics.checkNotNullExpressionValue(create, "");
        LocationSettingsRequest build = new LocationSettingsRequest.Builder().addLocationRequest(create).setAlwaysShow(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        globalSearchFragment.lookAheadTest = new ReactiveLocationProvider(globalSearchFragment.requireContext()).BuiltInFictitiousFunctionClassFactory(build).subscribe(new Consumer() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalSearchFragment.getAuthRequestContext(GlobalSearchFragment.this, (LocationSettingsResult) obj);
            }
        }, new Consumer() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                GlobalSearchFragment.PlaceComponentResult(GlobalSearchFragment.this);
            }
        });
    }

    public static final /* synthetic */ void getAuthRequestContext(GlobalSearchFragment globalSearchFragment, String str) {
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) globalSearchFragment.getBinding();
        if (fragmentGlobalSearchBinding != null) {
            Intent putExtra = new Intent(globalSearchFragment.getContext(), SeeAllActivity.class).putExtra(SeeAllActivity.GLOBAL_SEARCH_CATEGORY, str).putExtra(SeeAllActivity.GLOBAL_SEARCH_KEYWORD, StringsKt.trim((CharSequence) fragmentGlobalSearchBinding.moveToNextValue.getKeyword().toString()).toString());
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            globalSearchFragment.startActivityForResult(putExtra, 24);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        ((DanaLoadingDialog) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult();
        this.scheduleImpl = false;
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void BuiltInFictitiousFunctionClassFactory(final SearchResultModel p0) {
        CategoryVerticalView categoryVerticalView;
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        moveToNextValue(str != null ? str : "");
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding == null || (categoryVerticalView = fragmentGlobalSearchBinding.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        categoryVerticalView.setData(p0);
        categoryVerticalView.setItemClickCallback(new Function1<Integer, Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$onGetDFRestaurant$1$1
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
                PaySearchInfoModel paySearchInfoModel = SearchResultModel.this.getAuthRequestContext.get(i);
                GlobalSearchFragment globalSearchFragment = this;
                PaySearchInfoModel paySearchInfoModel2 = paySearchInfoModel;
                GlobalSearchFragment.PlaceComponentResult(globalSearchFragment, paySearchInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda7.get("DETAIL"));
                GlobalSearchAnalyticTracker globalSearchAnalyticTracker = globalSearchFragment.globalSearchAnalyticTracker;
                if (globalSearchAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    globalSearchAnalyticTracker = null;
                }
                globalSearchAnalyticTracker.getAuthRequestContext(paySearchInfoModel2);
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void MyBillsEntityDataFactory(final SearchResultModel p0) {
        CategorySKUView categorySKUView;
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        moveToNextValue(str != null ? str : "");
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding == null || (categorySKUView = fragmentGlobalSearchBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        categorySKUView.setData(p0);
        categorySKUView.setItemClickCallback(new Function1<Integer, Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$onGetDFSku$1$1
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
                PaySearchInfoModel paySearchInfoModel = SearchResultModel.this.getAuthRequestContext.get(i);
                GlobalSearchFragment globalSearchFragment = this;
                PaySearchInfoModel paySearchInfoModel2 = paySearchInfoModel;
                GlobalSearchFragment.PlaceComponentResult(globalSearchFragment, paySearchInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda7.get("DETAIL"));
                GlobalSearchAnalyticTracker globalSearchAnalyticTracker = globalSearchFragment.globalSearchAnalyticTracker;
                if (globalSearchAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    globalSearchAnalyticTracker = null;
                }
                globalSearchAnalyticTracker.getAuthRequestContext(paySearchInfoModel2);
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void PlaceComponentResult(final SearchResultModel p0) {
        CategoryVerticalView categoryVerticalView;
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        moveToNextValue(str != null ? str : "");
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding == null || (categoryVerticalView = fragmentGlobalSearchBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        categoryVerticalView.setData(p0);
        categoryVerticalView.setItemClickCallback(new Function1<Integer, Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$onGetOnlineMerchantCategory$1$1
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
                PaySearchInfoModel paySearchInfoModel = SearchResultModel.this.getAuthRequestContext.get(i);
                GlobalSearchFragment globalSearchFragment = this;
                PaySearchInfoModel paySearchInfoModel2 = paySearchInfoModel;
                GlobalSearchFragment.PlaceComponentResult(globalSearchFragment, paySearchInfoModel2.NetworkUserEntityData$$ExternalSyntheticLambda7.get("REDIRECT_URL"));
                GlobalSearchAnalyticTracker globalSearchAnalyticTracker = globalSearchFragment.globalSearchAnalyticTracker;
                if (globalSearchAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    globalSearchAnalyticTracker = null;
                }
                globalSearchAnalyticTracker.getAuthRequestContext(paySearchInfoModel2);
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void lookAheadTest(final SearchResultModel p0) {
        final CategoryVerticalView categoryVerticalView;
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        moveToNextValue(str != null ? str : "");
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding == null || (categoryVerticalView = fragmentGlobalSearchBinding.PlaceComponentResult) == null) {
            return;
        }
        categoryVerticalView.setData(p0);
        categoryVerticalView.setItemClickCallback(new Function1<Integer, Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$onGetServiceCategory$1$1
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
                GlobalSearchContract.Presenter k_;
                PaySearchInfoModel paySearchInfoModel = SearchResultModel.this.getAuthRequestContext.get(i);
                CategoryVerticalView categoryVerticalView2 = categoryVerticalView;
                GlobalSearchFragment globalSearchFragment = this;
                PaySearchInfoModel paySearchInfoModel2 = paySearchInfoModel;
                BaseActivity baseActivity = categoryVerticalView2.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                if (NetworkUtils.isNetworkAvailable(baseActivity)) {
                    k_ = globalSearchFragment.k_();
                    k_.getAuthRequestContext(paySearchInfoModel2);
                } else {
                    globalSearchFragment.getBaseActivity().showWarningDialog(globalSearchFragment.getString(R.string.global_search_error_message_dialog));
                }
                GlobalSearchAnalyticTracker globalSearchAnalyticTracker = globalSearchFragment.globalSearchAnalyticTracker;
                if (globalSearchAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    globalSearchAnalyticTracker = null;
                }
                globalSearchAnalyticTracker.getAuthRequestContext(paySearchInfoModel2);
            }
        });
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void getAuthRequestContext() {
        getBaseActivity().showWarningDialog(getString(R.string.global_search_error_message_dialog));
    }

    @Override // id.dana.contract.globalsearch.GlobalSearchContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        boolean KClassImpl$Data$declaredNonStaticMembers$2 = Permission.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), "android.permission.ACCESS_FINE_LOCATION");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2 ? TrackerKey.ResultStatusType.RESULT_WITH_LOCATION : TrackerKey.ResultStatusType.RESULT_NO_LOCATION;
        GlobalSearchAnalyticTracker globalSearchAnalyticTracker = this.globalSearchAnalyticTracker;
        if (globalSearchAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSearchAnalyticTracker = null;
        }
        globalSearchAnalyticTracker.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new SearchResultOpenTrackerModel();
    }

    public final void initRecordTimeStamp() {
        ToolbarGlobalSearchView toolbarGlobalSearchView;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        KeyboardHelper.MyBillsEntityDataFactory(getActivity());
        GetContactSyncConfig();
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding = (FragmentGlobalSearchBinding) getBinding();
        if (fragmentGlobalSearchBinding != null && (toolbarGlobalSearchView = fragmentGlobalSearchBinding.moveToNextValue) != null) {
            toolbarGlobalSearchView.clearSearch();
        }
        FragmentGlobalSearchBinding fragmentGlobalSearchBinding2 = (FragmentGlobalSearchBinding) getBinding();
        RecyclerView recyclerView = fragmentGlobalSearchBinding2 != null ? fragmentGlobalSearchBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }
}
