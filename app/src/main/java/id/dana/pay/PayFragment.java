package id.dana.pay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.material.tabs.TabLayout;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.AppLifeCycleObserver;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.view.NavigationTabView;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.base.BaseFragmentViewPager2StateAdapter;
import id.dana.base.ViewPagerBaseFragment;
import id.dana.contract.deeplink.path.FeatureCardBinding;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.payqr.GetPaymentResultContract;
import id.dana.contract.payqr.GetPaymentResultModule;
import id.dana.contract.payqr.OfflinePayContract;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrContract;
import id.dana.contract.payqr.PayQrModule;
import id.dana.core.ui.util.DANAToast;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPayComponent;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.pay.PayScannerFragment;
import id.dana.pay.model.PayCardConfigModel;
import id.dana.pay.screen.AddNewCardFragment;
import id.dana.performancetracker.FirstActionTracker;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.richview.LogoProgressView;
import id.dana.rum.Rum;
import id.dana.scanner.ScannerFragment;
import id.dana.scanner.tracker.PayQrOpenTracker;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.DanaScreenshotDetector;
import id.dana.utils.OSUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.permission.PermissionHelper;
import id.dana.utils.showcase.Utils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000Ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b *\u0001x\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0004\u0095\u0001\u0096\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\\\u001a\u00020]H\u0002J\b\u0010^\u001a\u00020]H\u0002J\b\u0010_\u001a\u00020]H\u0002J\b\u0010`\u001a\u00020]H\u0002J \u0010a\u001a\u00020]2\u0006\u0010b\u001a\u00020\u00152\u000e\u0010c\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\u0010\u0010d\u001a\u00020]2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0006\u0010f\u001a\u00020]J\b\u0010g\u001a\u00020]H\u0016J\u0018\u0010h\u001a\u00020\u00052\u000e\u0010c\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100H\u0002J\b\u0010i\u001a\u00020\u0005H\u0014J\b\u0010j\u001a\u00020kH\u0002J\b\u0010l\u001a\u00020]H\u0014J\b\u0010m\u001a\u00020]H\u0002J\b\u0010n\u001a\u00020]H\u0002J\b\u0010o\u001a\u00020]H\u0002J\b\u0010p\u001a\u00020YH\u0002J\b\u0010q\u001a\u00020]H\u0002J\b\u0010r\u001a\u00020]H\u0016J\b\u0010s\u001a\u00020]H\u0016J\b\u0010t\u001a\u00020]H\u0016J\u0010\u0010u\u001a\u00020]2\u0006\u0010v\u001a\u00020\u0005H\u0002J\r\u0010w\u001a\u00020xH\u0002¢\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020]H\u0016J\u0010\u0010{\u001a\u00020]2\u0006\u0010|\u001a\u00020\u0015H\u0002J\u0010\u0010}\u001a\u00020]2\u0006\u0010~\u001a\u00020\u0015H\u0002J\u0019\u0010\u007f\u001a\u00020]2\u0006\u0010~\u001a\u00020\u00152\u0007\u0010\u0080\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0081\u0001\u001a\u00020]H\u0002J\t\u0010\u0082\u0001\u001a\u00020]H\u0002J0\u0010\u0083\u0001\u001a\u00020]2\u0007\u0010\u0084\u0001\u001a\u00020\u00152\u000e\u0010c\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J0\u0010\u0085\u0001\u001a\u00020]2\u0007\u0010\u0084\u0001\u001a\u00020\u00152\u000e\u0010c\u001a\n\u0012\u0004\u0012\u000201\u0018\u0001002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0007\u0010\u0086\u0001\u001a\u00020]J\t\u0010\u0087\u0001\u001a\u00020]H\u0002J\t\u0010\u0088\u0001\u001a\u00020]H\u0002J \u0010\u0089\u0001\u001a\u00020]2\u0007\u0010\u0084\u0001\u001a\u00020\u00152\f\u0010c\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\t\u0010\u008a\u0001\u001a\u00020]H\u0002J\t\u0010\u008b\u0001\u001a\u00020]H\u0002J\u001a\u0010\u008c\u0001\u001a\u00020]2\u0006\u0010~\u001a\u00020\u00152\u0007\u0010\u0080\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u008d\u0001\u001a\u00020]H\u0002J\u0012\u0010\u008e\u0001\u001a\u00020]2\u0007\u0010\u008f\u0001\u001a\u00020\u0015H\u0002J$\u0010\u0090\u0001\u001a\u00020]2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0091\u0001\u001a\u00020)H\u0002¢\u0006\u0003\u0010\u0092\u0001J\u001d\u0010\u0093\u0001\u001a\u00020]2\u0007\u0010\u0094\u0001\u001a\u00020\u00152\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0015H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007R$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u0014\u0010 \u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R$\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\u0014\u0010(\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u000e\u0010+\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u000e\u0010-\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R$\u00106\u001a\b\u0012\u0004\u0012\u0002070\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000e\"\u0004\b9\u0010\u0010R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR$\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u0014\u0010F\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0017R\u0014\u0010H\u001a\u00020I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR$\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010\u0010R\u0014\u0010P\u001a\u00020Q8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR$\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000e\"\u0004\bW\u0010\u0010R\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0007¨\u0006\u0097\u0001"}, d2 = {"Lid/dana/pay/PayFragment;", "Lid/dana/base/ViewPagerBaseFragment;", "Lid/dana/AppLifeCycleObserver$KeyBoardOperationListener;", "()V", "addCardPosition", "", "getAddCardPosition", "()I", "additionalCardSize", "getAdditionalCardSize", "appLifeCycleObserver", "Ldagger/Lazy;", "Lid/dana/AppLifeCycleObserver;", "getAppLifeCycleObserver", "()Ldagger/Lazy;", "setAppLifeCycleObserver", "(Ldagger/Lazy;)V", "baseFragments", "", "Lid/dana/base/BaseFragment;", "channelName", "", "getChannelName", "()Ljava/lang/String;", "defaultCardIndex", "getDefaultCardIndex", "defaultIndex", "getDefaultIndex", "featureCardBinding", "Lid/dana/contract/deeplink/path/FeatureCardBinding;", "getFeatureCardBinding", "setFeatureCardBinding", "getPaymentResultModule", "Lid/dana/contract/payqr/GetPaymentResultModule;", "getGetPaymentResultModule", "()Lid/dana/contract/payqr/GetPaymentResultModule;", "getPaymentResultPresenter", "Lid/dana/contract/payqr/GetPaymentResultContract$Presenter;", "getGetPaymentResultPresenter", "setGetPaymentResultPresenter", "isFirstFragmentScanner", "", "()Z", "isFromResultPage", "isPayFragmentPagerAdapterValid", "isViewInitialized", "lastPosition", "listPayCard", "", "Lid/dana/pay/PayCardInfo;", "offlinePayModule", "Lid/dana/contract/payqr/OfflinePayModule;", "getOfflinePayModule", "()Lid/dana/contract/payqr/OfflinePayModule;", "offlinePresenter", "Lid/dana/contract/payqr/OfflinePayContract$Presenter;", "getOfflinePresenter", "setOfflinePresenter", "payCardConfig", "Lid/dana/pay/model/PayCardConfigModel;", "payFragmentPagerAdapter", "Lid/dana/pay/PayFragment$PayFragmentPagerStateAdapter;", "payQrModule", "Lid/dana/contract/payqr/PayQrModule;", "getPayQrModule", "()Lid/dana/contract/payqr/PayQrModule;", "payQrPresenter", "Lid/dana/contract/payqr/PayQrContract$Presenter;", "getPayQrPresenter", "setPayQrPresenter", InvoiceConstant.PAYMENT_METHOD, "getPaymentMethod", "playStoreReviewModules", "Lid/dana/di/modules/PlayStoreReviewModules;", "getPlayStoreReviewModules", "()Lid/dana/di/modules/PlayStoreReviewModules;", "playStoreReviewPresenter", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "getPlayStoreReviewPresenter", "setPlayStoreReviewPresenter", "queryPayMethodModule", "Lid/dana/contract/payasset/QueryPayMethodModule;", "getQueryPayMethodModule", "()Lid/dana/contract/payasset/QueryPayMethodModule;", "queryPayMethodPresenter", "Lid/dana/contract/payasset/QueryPayMethodContract$Presenter;", "getQueryPayMethodPresenter", "setQueryPayMethodPresenter", "ssPermission", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "totalPaymentMethod", "getTotalPaymentMethod", "addScannerFragment", "", "adjustOffscreenPageLimit", "backToOpenHomeScanner", "checkNeedToCallOnSelectedPayMethod", "checkPayCardInfos", "defaultOption", "payCardInfos", "checkScannerReadyAndTrackOpenCard", "totalCard", "checkScreenshotPermission", "disposePresenter", "getCardSize", "getLayout", "getNavigationAddCard", "Lid/dana/home/view/NavigationTabView;", IAPSyncCommand.COMMAND_INIT, "initComponent", "initScanner", "initScreenshotListener", "initScreenshotPermission", "initViews", "onDestroy", "onDestroyView", "onHomeClicked", "onMenuSelected", "position", "onPageChangeListener", "id/dana/pay/PayFragment$onPageChangeListener$1", "()Lid/dana/pay/PayFragment$onPageChangeListener$1;", "onResume", "openCashierConfirmation", "cashierUrl", "openCashierH5", "tradeNo", "openCashierNativeGeneralProcessingPage", "merchantId", "openNewCard", "pauseQr", "populateBaseFragments", "balancePayIndex", "populateQrisBaseFragments", "refreshQr", "removeScanner", "screenshotWarning", "setPayFragments", "setupViewPager", "showAddCard", "showPaymentResult", "showScanner", "trackDisplayedError", "errorMessage", "trackOpenCard", "isScannerReady", "(Ljava/lang/Integer;Z)V", "trackPayQrResult", "result", "Companion", "PayFragmentPagerStateAdapter", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayFragment extends ViewPagerBaseFragment implements AppLifeCycleObserver.KeyBoardOperationListener {
    public static final Companion MyBillsEntityDataFactory = new Companion(null);
    private PayFragmentPagerStateAdapter DatabaseTableConfigUtil;
    private PayCardConfigModel GetContactSyncConfig;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
    private List<? extends PayCardInfo> NetworkUserEntityData$$ExternalSyntheticLambda1;
    @Inject
    public Lazy<AppLifeCycleObserver> appLifeCycleObserver;
    @Inject
    public Lazy<FeatureCardBinding> featureCardBinding;
    private final List<BaseFragment> getErrorConfigVersion;
    @Inject
    public Lazy<GetPaymentResultContract.Presenter> getPaymentResultPresenter;
    private boolean lookAheadTest;
    private boolean moveToNextValue;
    @Inject
    public Lazy<OfflinePayContract.Presenter> offlinePresenter;
    @Inject
    public Lazy<PayQrContract.Presenter> payQrPresenter;
    @Inject
    public Lazy<PlayStoreReviewContract.Presenter> playStoreReviewPresenter;
    @Inject
    public Lazy<QueryPayMethodContract.Presenter> queryPayMethodPresenter;
    final FragmentPermissionRequest scheduleImpl;

    @Override // id.dana.base.ViewPagerBaseFragment
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.ViewPagerBaseFragment
    public final View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
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
        return R.layout.fragment_pay;
    }

    public PayFragment() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = (String[]) Arrays.copyOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.pay.PayFragment$initScreenshotPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Object obj;
                Intrinsics.checkNotNullParameter(p0, "");
                Iterator<T> it = p0.BuiltInFictitiousFunctionClassFactory.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((PermissionReport) obj).KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.READ_EXTERNAL_STORAGE")) {
                        break;
                    }
                }
                PermissionReport permissionReport = (PermissionReport) obj;
                if (permissionReport != null && permissionReport.getBuiltInFictitiousFunctionClassFactory()) {
                    PayFragment.this.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.scheduleImpl = builder.PlaceComponentResult();
        this.GetContactSyncConfig = new PayCardConfigModel(false, false, false, 7, null);
        this.getErrorConfigVersion = new ArrayList();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        Lazy<PayQrContract.Presenter> lazy = this.payQrPresenter;
        Lazy<AppLifeCycleObserver> lazy2 = null;
        if (lazy != null) {
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            lazy.get().NetworkUserEntityData$$ExternalSyntheticLambda0();
            Lazy<PayQrContract.Presenter> lazy3 = this.payQrPresenter;
            if (lazy3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy3 = null;
            }
            lazy3.get().onDestroy();
        }
        Lazy<FeatureCardBinding> lazy4 = this.featureCardBinding;
        if (lazy4 != null) {
            if (lazy4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy4 = null;
            }
            lazy4.get().MyBillsEntityDataFactory.dispose();
        }
        Lazy<AppLifeCycleObserver> lazy5 = this.appLifeCycleObserver;
        if (lazy5 != null) {
            if (lazy5 != null) {
                lazy2 = lazy5;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            try {
                lazy2.get().MyBillsEntityDataFactory.remove(this);
            } catch (Exception unused) {
            }
        }
        super.onDestroy();
    }

    @Override // id.dana.base.BaseFragment
    public final void disposePresenter() {
        super.disposePresenter();
        Lazy<GetPaymentResultContract.Presenter> lazy = this.getPaymentResultPresenter;
        Lazy<FeatureCardBinding> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().onDestroy();
        Lazy<OfflinePayContract.Presenter> lazy3 = this.offlinePresenter;
        if (lazy3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy3 = null;
        }
        lazy3.get().onDestroy();
        Lazy<PlayStoreReviewContract.Presenter> lazy4 = this.playStoreReviewPresenter;
        if (lazy4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy4 = null;
        }
        lazy4.get().onDestroy();
        Lazy<QueryPayMethodContract.Presenter> lazy5 = this.queryPayMethodPresenter;
        if (lazy5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy5 = null;
        }
        lazy5.get().onDestroy();
        Lazy<FeatureCardBinding> lazy6 = this.featureCardBinding;
        if (lazy6 != null) {
            lazy2 = lazy6;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        lazy2.get().MyBillsEntityDataFactory.dispose();
    }

    @Override // id.dana.base.ViewPagerBaseFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ViewPager2 viewPager2 = (ViewPager2) MyBillsEntityDataFactory(R.id.getLeaderboards);
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(new PayFragment$onPageChangeListener$1(this));
            View childAt = viewPager2.getChildAt(0);
            if (childAt == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            RecyclerView recyclerView = (RecyclerView) childAt;
            viewPager2.setPageTransformer(null);
        }
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Lazy<OfflinePayContract.Presenter> lazy = this.offlinePresenter;
        Lazy<PayQrContract.Presenter> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        Boolean MyBillsEntityDataFactory2 = lazy.get().MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        if (MyBillsEntityDataFactory2.booleanValue() && !this.lookAheadTest) {
            Lazy<PayQrContract.Presenter> lazy3 = this.payQrPresenter;
            if (lazy3 != null) {
                lazy2 = lazy3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            lazy2.get().lookAheadTest();
        }
        this.lookAheadTest = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(Integer num, boolean z) {
        PayQrOpenTracker payQrOpenTracker = PayQrOpenTracker.INSTANCE;
        FragmentActivity activity = getActivity();
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        FragmentActivity activity2 = getActivity();
        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
        PayQrOpenTracker.MyBillsEntityDataFactory(applicationContext, payActivity != null ? payActivity.getSource() : null, num, this.GetContactSyncConfig.getGetAuthRequestContext(), z);
        Rum.Companion companion = Rum.getAuthRequestContext;
        Rum.Companion.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(TrackerKey.Event.FIRST_ACTION, TuplesKt.to("operation", TrackerKey.Event.PAY_QR_OPEN)).PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveToNextValue() {
        BaseFragment KClassImpl$Data$declaredNonStaticMembers$2 = ViewPagerBaseFragment.KClassImpl$Data$declaredNonStaticMembers$2(this);
        if (!(KClassImpl$Data$declaredNonStaticMembers$2 instanceof BasePayFragment)) {
            KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        BasePayFragment basePayFragment = (BasePayFragment) KClassImpl$Data$declaredNonStaticMembers$2;
        if (basePayFragment != null) {
            basePayFragment.getErrorConfigVersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(baseFragment, "");
        return !(baseFragment instanceof PayScannerFragment);
    }

    private final void getErrorConfigVersion() {
        PayFragmentPagerStateAdapter payFragmentPagerStateAdapter = this.DatabaseTableConfigUtil;
        PayFragmentPagerStateAdapter payFragmentPagerStateAdapter2 = null;
        if (payFragmentPagerStateAdapter == null) {
            if (isAdded()) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "");
                List<BaseFragment> list = this.getErrorConfigVersion;
                Lifecycle lifecycle = getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "");
                this.DatabaseTableConfigUtil = new PayFragmentPagerStateAdapter(childFragmentManager, list, lifecycle);
                ViewPager2 viewPager2 = (ViewPager2) MyBillsEntityDataFactory(R.id.getLeaderboards);
                if (viewPager2 != null) {
                    PayFragmentPagerStateAdapter payFragmentPagerStateAdapter3 = this.DatabaseTableConfigUtil;
                    if (payFragmentPagerStateAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        payFragmentPagerStateAdapter2 = payFragmentPagerStateAdapter3;
                    }
                    getAuthRequestContext(viewPager2, payFragmentPagerStateAdapter2);
                    return;
                }
                return;
            }
            return;
        }
        if (payFragmentPagerStateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            payFragmentPagerStateAdapter = null;
        }
        List<BaseFragment> list2 = this.getErrorConfigVersion;
        Intrinsics.checkNotNullParameter(list2, "");
        ((BaseFragmentViewPager2StateAdapter) payFragmentPagerStateAdapter).PlaceComponentResult = list2;
        if (((ViewPager2) MyBillsEntityDataFactory(R.id.getLeaderboards)) != null) {
            PayFragmentPagerStateAdapter payFragmentPagerStateAdapter4 = this.DatabaseTableConfigUtil;
            if (payFragmentPagerStateAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                payFragmentPagerStateAdapter2 = payFragmentPagerStateAdapter4;
            }
            payFragmentPagerStateAdapter2.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyBillsEntityDataFactory(BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(baseFragment, "");
        return baseFragment instanceof PayScannerFragment;
    }

    @JvmName(name = "isPayFragmentPagerAdapterValid")
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        PayFragmentPagerStateAdapter payFragmentPagerStateAdapter = this.DatabaseTableConfigUtil;
        if (payFragmentPagerStateAdapter != null) {
            if (payFragmentPagerStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                payFragmentPagerStateAdapter = null;
            }
            if (payFragmentPagerStateAdapter.getPlaceComponentResult() > 0) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "isFirstFragmentScanner")
    private final boolean PlaceComponentResult() {
        if (NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            PayFragmentPagerStateAdapter payFragmentPagerStateAdapter = this.DatabaseTableConfigUtil;
            if (payFragmentPagerStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                payFragmentPagerStateAdapter = null;
            }
            return ((BaseFragmentViewPager2StateAdapter) payFragmentPagerStateAdapter).PlaceComponentResult.get(0) instanceof PayScannerFragment;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        addDisposable(DanaScreenshotDetector.KClassImpl$Data$declaredNonStaticMembers$2(getActivity()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.pay.PayFragment$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                String str = (String) obj;
                PayFragment.getAuthRequestContext(PayFragment.this);
            }
        }));
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/pay/PayFragment$PayFragmentPagerStateAdapter;", "Lid/dana/base/BaseFragmentViewPager2StateAdapter;", "Landroidx/fragment/app/FragmentManager;", "p0", "", "Lid/dana/base/BaseFragment;", "p1", "Landroidx/lifecycle/Lifecycle;", "p2", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Landroidx/lifecycle/Lifecycle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class PayFragmentPagerStateAdapter extends BaseFragmentViewPager2StateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PayFragmentPagerStateAdapter(FragmentManager fragmentManager, List<? extends BaseFragment> list, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle, list);
            Intrinsics.checkNotNullParameter(fragmentManager, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(lifecycle, "");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/pay/PayFragment$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void PlaceComponentResult(PayFragment payFragment) {
        Intrinsics.checkNotNullParameter(payFragment, "");
        Lazy<FeatureCardBinding> lazy = payFragment.featureCardBinding;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        FeatureCardBinding featureCardBinding = lazy.get();
        BaseActivity baseActivity = payFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        featureCardBinding.BuiltInFictitiousFunctionClassFactory(baseActivity, TrackerKey.CardBindingSourceType.QR);
        FragmentActivity activity = payFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(PayFragment payFragment) {
        Intrinsics.checkNotNullParameter(payFragment, "");
        FragmentActivity activity = payFragment.getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        if (payActivity != null) {
            payActivity.showWarningDialog(payFragment.getString(R.string.screenshot_warning));
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(PayFragment payFragment) {
        ViewPager2 viewPager2 = (ViewPager2) payFragment.MyBillsEntityDataFactory(R.id.getLeaderboards);
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(5);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PayFragment payFragment, String str, List list) {
        if (!TextUtils.isEmpty(str) && !Intrinsics.areEqual("BALANCE", str)) {
            List list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                payFragment.PlaceComponentResult(payFragment.PlaceComponentResult() ? 2 : 1);
                return;
            }
        }
        if (payFragment.GetContactSyncConfig.getGetAuthRequestContext() || payFragment.getAuthRequestContext() == null) {
            return;
        }
        BaseFragment KClassImpl$Data$declaredNonStaticMembers$2 = ViewPagerBaseFragment.KClassImpl$Data$declaredNonStaticMembers$2(payFragment);
        if (!(KClassImpl$Data$declaredNonStaticMembers$2 instanceof BasePayFragment)) {
            KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        BasePayFragment basePayFragment = (BasePayFragment) KClassImpl$Data$declaredNonStaticMembers$2;
        if (basePayFragment != null) {
            basePayFragment.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PayFragment payFragment, int i) {
        BaseFragment KClassImpl$Data$declaredNonStaticMembers$2 = ViewPagerBaseFragment.KClassImpl$Data$declaredNonStaticMembers$2(payFragment);
        if (!(KClassImpl$Data$declaredNonStaticMembers$2 instanceof PayScannerFragment)) {
            KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        PayScannerFragment payScannerFragment = (PayScannerFragment) KClassImpl$Data$declaredNonStaticMembers$2;
        PayScannerFragment payScannerFragment2 = payScannerFragment != null ? payScannerFragment : null;
        boolean z = payScannerFragment2 != null && payScannerFragment2.getKClassImpl$Data$declaredNonStaticMembers$2();
        if (!payFragment.GetContactSyncConfig.getGetAuthRequestContext() || (payFragment.GetContactSyncConfig.getGetAuthRequestContext() && z)) {
            payFragment.getAuthRequestContext(Integer.valueOf(i), z);
        } else {
            PayQrOpenTracker payQrOpenTracker = PayQrOpenTracker.INSTANCE;
            PayQrOpenTracker.BuiltInFictitiousFunctionClassFactory(Integer.valueOf(i));
        }
        FirstActionTracker firstActionTracker = FirstActionTracker.INSTANCE;
        FirstActionTracker.PlaceComponentResult("Pay QR");
    }

    public static final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(PayFragment payFragment, List list) {
        if (list != null) {
            return list.size() + (payFragment.GetContactSyncConfig.getGetAuthRequestContext() ? 2 : 1);
        }
        return 0;
    }

    public static final /* synthetic */ void lookAheadTest(final PayFragment payFragment) {
        TabLayout.Tab tabAt;
        TabLayout tabLayout = (TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu);
        if (tabLayout != null) {
            tabLayout.addTab(((TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu)).newTab().setCustomView(new NavigationTabView(payFragment.getBaseActivity(), (int) R.drawable.ic_pay_scan, payFragment.getString(R.string.pay_scan_title))));
        }
        TabLayout tabLayout2 = (TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu);
        if (tabLayout2 != null) {
            tabLayout2.addTab(((TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu)).newTab().setCustomView(new NavigationTabView(payFragment.getBaseActivity(), (int) R.drawable.ic_pay_close, payFragment.getString(R.string.pay_close_title))));
        }
        TabLayout tabLayout3 = (TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu);
        if (tabLayout3 != null) {
            tabLayout3.addTab(((TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu)).newTab().setCustomView(new NavigationTabView(payFragment.getBaseActivity(), (int) R.drawable.ic_add_card_pay, payFragment.getString(R.string.add_card))));
        }
        TabLayout tabLayout4 = (TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu);
        if (tabLayout4 != null) {
            tabLayout4.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: id.dana.pay.PayFragment$initViews$1
                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public final void onTabUnselected(TabLayout.Tab p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public final void onTabSelected(TabLayout.Tab p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    View customView = p0.getCustomView();
                    if (customView != null) {
                        customView.setSelected(false);
                    }
                    PayFragment.KClassImpl$Data$declaredNonStaticMembers$2(PayFragment.this, p0.getPosition());
                }

                @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
                public final void onTabReselected(TabLayout.Tab p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    onTabSelected(p0);
                }
            });
        }
        Lazy<AppLifeCycleObserver> lazy = payFragment.appLifeCycleObserver;
        Lazy<OfflinePayContract.Presenter> lazy2 = null;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().MyBillsEntityDataFactory.add(payFragment);
        TabLayout tabLayout5 = (TabLayout) payFragment.MyBillsEntityDataFactory(R.id.bottom_tab_menu);
        View customView = (tabLayout5 == null || (tabAt = tabLayout5.getTabAt(0)) == null) ? null : tabAt.getCustomView();
        if (customView != null) {
            customView.setSelected(false);
        }
        Lazy<PayQrContract.Presenter> lazy3 = payFragment.payQrPresenter;
        if (lazy3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy3 = null;
        }
        lazy3.get().BuiltInFictitiousFunctionClassFactory();
        Lazy<QueryPayMethodContract.Presenter> lazy4 = payFragment.queryPayMethodPresenter;
        if (lazy4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy4 = null;
        }
        lazy4.get().KClassImpl$Data$declaredNonStaticMembers$2();
        Lazy<GetPaymentResultContract.Presenter> lazy5 = payFragment.getPaymentResultPresenter;
        if (lazy5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy5 = null;
        }
        lazy5.get().MyBillsEntityDataFactory();
        Lazy<GetPaymentResultContract.Presenter> lazy6 = payFragment.getPaymentResultPresenter;
        if (lazy6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy6 = null;
        }
        lazy6.get().KClassImpl$Data$declaredNonStaticMembers$2();
        Lazy<QueryPayMethodContract.Presenter> lazy7 = payFragment.queryPayMethodPresenter;
        if (lazy7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy7 = null;
        }
        lazy7.get().PlaceComponentResult(false);
        Lazy<OfflinePayContract.Presenter> lazy8 = payFragment.offlinePresenter;
        if (lazy8 != null) {
            lazy2 = lazy8;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        lazy2.get().BuiltInFictitiousFunctionClassFactory();
        payFragment.moveToNextValue = true;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PayFragment payFragment, int i) {
        if (i == 0) {
            if (payFragment.PlaceComponentResult()) {
                payFragment.PlaceComponentResult(0);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("cancel_to_scan", true);
            FragmentActivity activity = payFragment.getActivity();
            if (activity != null) {
                activity.setResult(0, intent);
            }
            FragmentActivity activity2 = payFragment.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (i == 1) {
            FragmentActivity activity3 = payFragment.getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        } else if (i == 2 && payFragment.GetContactSyncConfig.getPlaceComponentResult() && payFragment.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            PayFragmentPagerStateAdapter payFragmentPagerStateAdapter = payFragment.DatabaseTableConfigUtil;
            if (payFragmentPagerStateAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                payFragmentPagerStateAdapter = null;
            }
            payFragment.PlaceComponentResult(payFragmentPagerStateAdapter.getPlaceComponentResult() - 1);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PayFragment payFragment, String str) {
        Lazy<PayQrContract.Presenter> lazy = payFragment.payQrPresenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        if (lazy.get().MyBillsEntityDataFactory()) {
            FragmentActivity activity = payFragment.getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                PayActivity.processCashierUrl$default(payActivity, str, null, null, true, null, null, 54, null);
                return;
            }
            return;
        }
        DanaH5.startContainerFullUrl(str);
    }

    public static final /* synthetic */ void GetContactSyncConfig(PayFragment payFragment) {
        Collection.EL.BuiltInFictitiousFunctionClassFactory(payFragment.getErrorConfigVersion, new Predicate() { // from class: id.dana.pay.PayFragment$$ExternalSyntheticLambda3
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                boolean MyBillsEntityDataFactory2;
                MyBillsEntityDataFactory2 = PayFragment.MyBillsEntityDataFactory((BaseFragment) obj);
                return MyBillsEntityDataFactory2;
            }
        });
        payFragment.getErrorConfigVersion();
    }

    public static final /* synthetic */ void getAuthRequestContext(final PayFragment payFragment, String str, List list) {
        Collection.EL.BuiltInFictitiousFunctionClassFactory(payFragment.getErrorConfigVersion, new Predicate() { // from class: id.dana.pay.PayFragment$$ExternalSyntheticLambda1
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = PayFragment.BuiltInFictitiousFunctionClassFactory((BaseFragment) obj);
                return BuiltInFictitiousFunctionClassFactory;
            }
        });
        Lazy<PayQrContract.Presenter> lazy = payFragment.payQrPresenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        if (lazy.get().getAuthRequestContext()) {
            List<BaseFragment> list2 = payFragment.getErrorConfigVersion;
            BalanceQrisPayFragment KClassImpl$Data$declaredNonStaticMembers$2 = BalanceQrisPayFragment.KClassImpl$Data$declaredNonStaticMembers$2(str);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            list2.add(KClassImpl$Data$declaredNonStaticMembers$2);
            List list3 = list;
            if (!(list3 == null || list3.isEmpty())) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    CardQrisPayFragment MyBillsEntityDataFactory2 = CardQrisPayFragment.MyBillsEntityDataFactory((PayCardInfo) it.next());
                    Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
                    list2.add(MyBillsEntityDataFactory2);
                }
            }
        } else {
            List<BaseFragment> list4 = payFragment.getErrorConfigVersion;
            BalancePayFragment KClassImpl$Data$declaredNonStaticMembers$22 = BalancePayFragment.KClassImpl$Data$declaredNonStaticMembers$2(str);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
            list4.add(KClassImpl$Data$declaredNonStaticMembers$22);
            List list5 = list;
            if (!(list5 == null || list5.isEmpty())) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    CardPayFragment MyBillsEntityDataFactory3 = CardPayFragment.MyBillsEntityDataFactory((PayCardInfo) it2.next());
                    Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory3, "");
                    list4.add(MyBillsEntityDataFactory3);
                }
            }
        }
        if (payFragment.GetContactSyncConfig.getPlaceComponentResult()) {
            List<BaseFragment> list6 = payFragment.getErrorConfigVersion;
            AddNewCardFragment authRequestContext = AddNewCardFragment.getAuthRequestContext(new AddNewCardFragment.OnClickListener() { // from class: id.dana.pay.PayFragment$$ExternalSyntheticLambda2
                @Override // id.dana.pay.screen.AddNewCardFragment.OnClickListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    PayFragment.PlaceComponentResult(PayFragment.this);
                }
            });
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            list6.add(authRequestContext);
        }
        payFragment.getErrorConfigVersion();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final PayFragment payFragment, String str, String str2) {
        Lazy<PayQrContract.Presenter> lazy = payFragment.payQrPresenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        if (lazy.get().MyBillsEntityDataFactory()) {
            FragmentActivity activity = payFragment.getActivity();
            PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
            if (payActivity != null) {
                payActivity.startCashierProcessing(str, str2);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(DanaUrl.QR_PAY_PAYMENT_RESULT, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        sb.append(format);
        DanaH5.startContainerFullUrl(sb.toString(), new DanaH5Listener() { // from class: id.dana.pay.PayFragment$openCashierH5$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                Lazy<PlayStoreReviewContract.Presenter> lazy2 = PayFragment.this.playStoreReviewPresenter;
                if (lazy2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy2 = null;
                }
                lazy2.get().PlaceComponentResult();
            }
        });
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PayFragment payFragment, String str) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(payFragment.requireContext());
        builder.MyBillsEntityDataFactory = "Displayed Error";
        FragmentActivity activity = payFragment.getActivity();
        PayActivity payActivity = activity instanceof PayActivity ? (PayActivity) activity : null;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = builder.MyBillsEntityDataFactory("Source", payActivity != null ? payActivity.getSource() : null).MyBillsEntityDataFactory("Operation Type", "alipayplus.mobileprod.uniresultpage.query").MyBillsEntityDataFactory("Displayed Message", str).MyBillsEntityDataFactory("Error Message", str);
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
    }

    public static final /* synthetic */ void PlaceComponentResult(PayFragment payFragment, String str, String str2) {
        PayCardInfo payCardInfo;
        PayCardInfo payCardInfo2;
        FragmentActivity activity = payFragment.getActivity();
        String str3 = null;
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(activity != null ? activity.getApplicationContext() : null);
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PAY_QR_RESULT;
        FragmentActivity activity2 = payFragment.getActivity();
        PayActivity payActivity = activity2 instanceof PayActivity ? (PayActivity) activity2 : null;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = builder.MyBillsEntityDataFactory("Source", payActivity != null ? payActivity.getSource() : null);
        int MyBillsEntityDataFactory3 = payFragment.MyBillsEntityDataFactory();
        List<? extends PayCardInfo> list = payFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str4 = (list == null || (payCardInfo2 = (PayCardInfo) CollectionsKt.getOrNull(list, MyBillsEntityDataFactory3 + (-2))) == null) ? null : payCardInfo2.DatabaseTableConfigUtil;
        if (str4 == null) {
            str4 = "BALANCE";
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory4 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory(TrackerKey.Property.PAY_QR_PAYMENT_METHOD, str4);
        int MyBillsEntityDataFactory5 = payFragment.MyBillsEntityDataFactory();
        List<? extends PayCardInfo> list2 = payFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (list2 != null && (payCardInfo = (PayCardInfo) CollectionsKt.getOrNull(list2, MyBillsEntityDataFactory5 - 2)) != null) {
            str3 = payCardInfo.scheduleImpl;
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory6 = MyBillsEntityDataFactory4.MyBillsEntityDataFactory(TrackerKey.Property.PAY_QR_CHANNEL_NAME, str3 != null ? str3 : "BALANCE");
        List<? extends PayCardInfo> list3 = payFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        byte b = 0;
        EventTrackerModel.Builder BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory6.PlaceComponentResult(TrackerKey.Property.PAYMENT_METHOD_COUNT, list3 != null ? list3.size() : 0).MyBillsEntityDataFactory(TrackerKey.Property.QR_PAYMENT_PROCESSING_RESULT, str).MyBillsEntityDataFactory("Merchant ID", str2).BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(BuiltInFictitiousFunctionClassFactory, b));
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        DaggerPayComponent.Builder MyBillsEntityDataFactory2 = DaggerPayComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(getActivity())));
        MyBillsEntityDataFactory2.getAuthRequestContext = (GetPaymentResultModule) Preconditions.getAuthRequestContext(new GetPaymentResultModule(new GetPaymentResultContract.View() { // from class: id.dana.pay.PayFragment$getPaymentResultModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.payqr.GetPaymentResultContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Utils.getAuthRequestContext(PayFragment.this.getActivity(), 500L);
                PayFragment.KClassImpl$Data$declaredNonStaticMembers$2(PayFragment.this, p2, p3 != null ? p3 : "");
                PayFragment.PlaceComponentResult(PayFragment.this, "Success", p3);
                PayFragment.this.lookAheadTest = true;
                PayFragment.this.moveToNextValue();
            }

            @Override // id.dana.contract.payqr.GetPaymentResultContract.View
            public final void PlaceComponentResult(String p0, String p1, String p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Utils.getAuthRequestContext(PayFragment.this.getActivity(), 500L);
                PayFragment.KClassImpl$Data$declaredNonStaticMembers$2(PayFragment.this, p0);
                PayFragment.PlaceComponentResult(PayFragment.this, "Pending", p2);
                PayFragment.this.lookAheadTest = true;
                PayFragment.this.moveToNextValue();
            }

            @Override // id.dana.contract.payqr.GetPaymentResultContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                Utils.getAuthRequestContext(PayFragment.this.getActivity(), 500L);
                PayFragment.PlaceComponentResult(PayFragment.this, "Failed", p3);
                PayFragment.BuiltInFictitiousFunctionClassFactory(PayFragment.this, p2);
                PayFragment.this.lookAheadTest = true;
                FragmentActivity activity = PayFragment.this.getActivity();
                BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
                if (baseActivity != null) {
                    DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                    DANAToast.MyBillsEntityDataFactory(baseActivity, p2, "");
                }
                PayFragment.this.moveToNextValue();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PayFragment.BuiltInFictitiousFunctionClassFactory(PayFragment.this, p0);
                PayFragment.this.moveToNextValue();
            }
        }));
        MyBillsEntityDataFactory2.scheduleImpl = (QueryPayMethodModule) Preconditions.getAuthRequestContext(new QueryPayMethodModule(new QueryPayMethodContract.View() { // from class: id.dana.pay.PayFragment$queryPayMethodModule$1
            @Override // id.dana.contract.payasset.QueryPayMethodContract.View
            public final void MyBillsEntityDataFactory(int p0) {
            }

            @Override // id.dana.contract.payasset.QueryPayMethodContract.View
            public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(Boolean bool) {
            }

            @Override // id.dana.contract.payasset.QueryPayMethodContract.View
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.contract.payasset.QueryPayMethodContract.View
            public final void PlaceComponentResult(PayCardConfigModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PayFragment.this.GetContactSyncConfig = p0;
                if (p0.getGetAuthRequestContext()) {
                    return;
                }
                PayFragment.GetContactSyncConfig(PayFragment.this);
            }

            @Override // id.dana.contract.payasset.QueryPayMethodContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, List<? extends PayCardInfo> list) {
                PayCardConfigModel payCardConfigModel;
                PayCardConfigModel payCardConfigModel2;
                PayFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = list;
                PayFragment payFragment = PayFragment.this;
                if (str2 == null) {
                    str2 = "";
                }
                PayFragment.getAuthRequestContext(payFragment, str2, list == null ? CollectionsKt.emptyList() : list);
                payCardConfigModel = PayFragment.this.GetContactSyncConfig;
                if (payCardConfigModel.getGetAuthRequestContext()) {
                    payCardConfigModel2 = PayFragment.this.GetContactSyncConfig;
                    if (payCardConfigModel2.getMyBillsEntityDataFactory()) {
                        BaseFragment KClassImpl$Data$declaredNonStaticMembers$2 = ViewPagerBaseFragment.KClassImpl$Data$declaredNonStaticMembers$2(PayFragment.this);
                        if (!(KClassImpl$Data$declaredNonStaticMembers$2 instanceof ScannerFragment)) {
                            KClassImpl$Data$declaredNonStaticMembers$2 = null;
                        }
                        ScannerFragment scannerFragment = (ScannerFragment) KClassImpl$Data$declaredNonStaticMembers$2;
                        if (scannerFragment != null) {
                            scannerFragment.onSelected();
                        }
                        PayFragment payFragment2 = PayFragment.this;
                        PayFragment.BuiltInFictitiousFunctionClassFactory(payFragment2, PayFragment.KClassImpl$Data$declaredNonStaticMembers$2(payFragment2, list));
                        MixPanelTracker.getAuthRequestContext(TrackerKey.Event.PAY_QR_RESULT);
                    }
                }
                PayFragment payFragment3 = PayFragment.this;
                if (str == null) {
                    str = "";
                }
                PayFragment.KClassImpl$Data$declaredNonStaticMembers$2(payFragment3, str, list);
                PayFragment payFragment22 = PayFragment.this;
                PayFragment.BuiltInFictitiousFunctionClassFactory(payFragment22, PayFragment.KClassImpl$Data$declaredNonStaticMembers$2(payFragment22, list));
                MixPanelTracker.getAuthRequestContext(TrackerKey.Event.PAY_QR_RESULT);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                Lazy<OfflinePayContract.Presenter> lazy = PayFragment.this.offlinePresenter;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                if (lazy.get().MyBillsEntityDataFactory().booleanValue()) {
                    return;
                }
                LogoProgressView logoProgressView = (LogoProgressView) PayFragment.this.MyBillsEntityDataFactory(R.id.progress_view);
                if (logoProgressView != null) {
                    logoProgressView.setVisibility(0);
                }
                LogoProgressView logoProgressView2 = (LogoProgressView) PayFragment.this.MyBillsEntityDataFactory(R.id.progress_view);
                if (logoProgressView2 != null) {
                    logoProgressView2.startRefresh();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                Lazy<OfflinePayContract.Presenter> lazy = PayFragment.this.offlinePresenter;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                if (lazy.get().MyBillsEntityDataFactory().booleanValue()) {
                    return;
                }
                LogoProgressView logoProgressView = (LogoProgressView) PayFragment.this.MyBillsEntityDataFactory(R.id.progress_view);
                if (logoProgressView != null) {
                    logoProgressView.setVisibility(8);
                }
                LogoProgressView logoProgressView2 = (LogoProgressView) PayFragment.this.MyBillsEntityDataFactory(R.id.progress_view);
                if (logoProgressView2 != null) {
                    logoProgressView2.stopRefresh();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, DanaLogConstants.Prefix.QRCODE_QUERY_PAY_METHOD_PREFIX, p0);
            }
        }));
        MyBillsEntityDataFactory2.PlaceComponentResult = (PayQrModule) Preconditions.getAuthRequestContext(new PayQrModule(new PayQrContract.View() { // from class: id.dana.pay.PayFragment$payQrModule$1
            @Override // id.dana.contract.payqr.PayQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
            }

            @Override // id.dana.contract.payqr.PayQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.payqr.PayQrContract.View
            public final void MyBillsEntityDataFactory() {
            }

            @Override // id.dana.contract.payqr.PayQrContract.View
            public final void MyBillsEntityDataFactory(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.contract.payqr.PayQrContract.View
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.payqr.PayQrContract.View
            public final void PlaceComponentResult() {
                Lazy<QueryPayMethodContract.Presenter> lazy = PayFragment.this.queryPayMethodPresenter;
                if (lazy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    lazy = null;
                }
                lazy.get().PlaceComponentResult(false);
            }
        }));
        MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = (OfflinePayModule) Preconditions.getAuthRequestContext(new OfflinePayModule(new OfflinePayContract.View() { // from class: id.dana.pay.PayFragment$offlinePayModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.payqr.OfflinePayContract.View
            public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(Boolean bool) {
                PayFragment.MyBillsEntityDataFactory(PayFragment.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.getAuthRequestContext, GetPaymentResultModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.scheduleImpl, QueryPayMethodModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.PlaceComponentResult, PayQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, OfflinePayModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.MyBillsEntityDataFactory, PlayStoreReviewModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerPayComponent.PayComponentImpl(MyBillsEntityDataFactory2.getAuthRequestContext, MyBillsEntityDataFactory2.scheduleImpl, MyBillsEntityDataFactory2.PlaceComponentResult, MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory2.MyBillsEntityDataFactory, MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory, (byte) 0).getAuthRequestContext(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f33542131166003);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f33532131166002);
        ViewPager2 viewPager2 = (ViewPager2) MyBillsEntityDataFactory(R.id.getLeaderboards);
        if (viewPager2 != null) {
            View childAt = viewPager2.getChildAt(0);
            if (childAt == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
            RecyclerView recyclerView = (RecyclerView) childAt;
            recyclerView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            viewPager2.setPageTransformer(new MarginPageTransformer(dimensionPixelSize2));
            recyclerView.setClipToPadding(false);
        }
        ViewPager2 viewPager22 = (ViewPager2) MyBillsEntityDataFactory(R.id.getLeaderboards);
        if (viewPager22 != null) {
            viewPager22.registerOnPageChangeCallback(new PayFragment$onPageChangeListener$1(this));
        }
        ViewPager2 viewPager23 = (ViewPager2) MyBillsEntityDataFactory(R.id.getLeaderboards);
        if (viewPager23 != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewPager23.getCurrentItem();
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.pay.PayActivity");
        }
        PayActivity payActivity = (PayActivity) baseActivity;
        PayScannerFragment payScannerFragment = payActivity.getPayScannerFragment();
        payScannerFragment.PlaceComponentResult(payActivity.getBarcodeView());
        payScannerFragment.MyBillsEntityDataFactory = new PayScannerFragment.PayScannerListener() { // from class: id.dana.pay.PayFragment$addScannerFragment$1$1$1
            @Override // id.dana.pay.PayScannerFragment.PayScannerListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                PayFragment payFragment = PayFragment.this;
                if (!OSUtil.MyBillsEntityDataFactory()) {
                    Context requireContext = payFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "");
                    if (!PermissionHelper.MyBillsEntityDataFactory(requireContext, "android.permission.READ_EXTERNAL_STORAGE")) {
                        payFragment.scheduleImpl.check();
                        return;
                    }
                }
                payFragment.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.pay.PayScannerFragment.PayScannerListener
            public final void PlaceComponentResult(boolean p0) {
                boolean z;
                PayCardConfigModel payCardConfigModel;
                z = PayFragment.this.moveToNextValue;
                if (!z) {
                    PayFragment.lookAheadTest(PayFragment.this);
                }
                payCardConfigModel = PayFragment.this.GetContactSyncConfig;
                if (payCardConfigModel.getGetAuthRequestContext()) {
                    PayFragment.this.getAuthRequestContext((Integer) null, p0);
                }
            }
        };
        this.getErrorConfigVersion.add(payScannerFragment);
        getErrorConfigVersion();
        BaseFragment KClassImpl$Data$declaredNonStaticMembers$2 = ViewPagerBaseFragment.KClassImpl$Data$declaredNonStaticMembers$2(this);
        if (!(KClassImpl$Data$declaredNonStaticMembers$2 instanceof ScannerFragment)) {
            KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        ScannerFragment scannerFragment = (ScannerFragment) KClassImpl$Data$declaredNonStaticMembers$2;
        if (scannerFragment != null) {
            scannerFragment.onSelected();
        }
    }

    @Override // id.dana.AppLifeCycleObserver.KeyBoardOperationListener
    public final void onHomeClicked() {
        try {
            Lazy<OfflinePayContract.Presenter> lazy = this.offlinePresenter;
            if (lazy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                lazy = null;
            }
            Boolean MyBillsEntityDataFactory2 = lazy.get().MyBillsEntityDataFactory();
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            if (MyBillsEntityDataFactory2.booleanValue()) {
                moveToNextValue();
            }
        } catch (Exception unused) {
        }
    }
}
