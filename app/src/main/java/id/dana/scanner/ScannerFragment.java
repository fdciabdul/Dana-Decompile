package id.dana.scanner;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import butterknife.BindView;
import butterknife.OnClick;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CameraPreview;
import com.journeyapps.barcodescanner.Size;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseFragment;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.contract.deeplink.DeepLinkCallback;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureCallback;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.DecodeQrImageContract;
import id.dana.contract.staticqr.DecodeQrImageModule;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerScannerComponent;
import id.dana.di.component.ScannerComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.di.modules.ScanQrAnalyticModule;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.currency.GlobalNetworkListener;
import id.dana.h5event.CheckoutH5EventContract;
import id.dana.kybcpm.constant.KybCpmConstants;
import id.dana.kybcpm.view.KybCpmLoadingActivity;
import id.dana.model.BizInfoModel;
import id.dana.model.DeepLinkPayloadModel;
import id.dana.model.ScanModel;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import id.dana.pay.PayActivity;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewContractView;
import id.dana.playstorereview.model.AppReviewInfoModel;
import id.dana.richview.CustomDecoratedBarcodeView;
import id.dana.richview.EllipseTextView;
import id.dana.scanner.gallery.DecodeImage;
import id.dana.scanner.handler.ScannerActionState;
import id.dana.scanner.handler.ScannerViewType;
import id.dana.scanner.tracker.ScannerMixpanelTracker;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.sharepay.SharePayManager;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.splitbill.view.SplitBillDetailsActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.constant.TrackerType;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.tracker.model.TrackScanQrModel;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.constant.BottomSheetType;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.BitmapUtil;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.ErrorUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.ImagePicker;
import id.dana.utils.SizeUtil;
import id.dana.utils.TextUtil;
import id.dana.utils.TimerUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.Predicate;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes5.dex */
public class ScannerFragment extends BaseFragment {
    private static final int MyBillsEntityDataFactory = SizeUtil.getAuthRequestContext(24);
    private String A;
    private Showcase BottomSheetCardBindingView$watcherCardNumberView$1;
    private CpmToSendMoneyDialogHandler DatabaseTableConfigUtil;
    private boolean FragmentBottomSheetPaymentSettingBinding;
    private ScannerComponent GetContactSyncConfig;
    protected CustomDecoratedBarcodeView KClassImpl$Data$declaredNonStaticMembers$2;
    private List<ContentOnBoardingModel> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    private FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda5;
    private FeatureTimeModel NetworkUserEntityData$$ExternalSyntheticLambda7;
    private String PlaceComponentResult;
    private ActivityResultLauncher<Intent> PrepareContext;
    private ActivityResultLauncher<Intent> SubSequence;
    @Inject
    Lazy<BottomSheetOnBoardingContract.Presenter> bottomSheetOnBoardingPresenter;
    @Inject
    DecodeQrImageContract.Presenter decodePresenter;
    @Inject
    Lazy<DeepLinkContract.Presenter> deepLinkPresenter;
    @Inject
    Lazy<FeatureContract.Presenter> featurePresenter;
    private List<String> getCallingPid;
    String getErrorConfigVersion;
    private boolean getSupportButtonTintMode;
    @Inject
    Lazy<GlobalNetworkContract.Presenter> globalNetworkPresenter;
    @Inject
    Lazy<CheckoutH5EventContract.Presenter> h5EventPresenter;
    @BindView(R.id.ic_image_fg)
    ImageView icImageFg;
    @BindView(R.id.iv_scan_gallery)
    ImageView imgScanGallery;
    private FragmentPermissionRequest initRecordTimeStamp;
    private boolean isLayoutRequested;
    boolean lookAheadTest;
    protected boolean moveToNextValue;
    private String newProxyInstance;
    @Inject
    Lazy<PlayStoreReviewContract.Presenter> playStoreReviewPresenter;
    @Inject
    Lazy<ScanQrContract.Presenter> presenter;
    @Inject
    Lazy<ReadLinkPropertiesContract.Presenter> readDeepLinkPropertiesPresenter;
    private List<String> readMicros;
    @Inject
    Lazy<RestoreUrlContract.Presenter> restoreUrlPresenter;
    @BindView(R.id.rlBarcodeScanner)
    RelativeLayout rlBarcodeScanner;
    @BindView(R.id.rl_help_scan_qr)
    RelativeLayout rlHelpScanQr;
    @BindView(R.id.rl_scan_gallery)
    RelativeLayout rlScanGallery;
    @BindView(R.id.group_loading_scanner)
    Group rlScanner;
    @Inject
    public Lazy<ScanQrContract.Presenter> scanQrPresenter;
    @Inject
    Lazy<ScannerMixpanelTracker> scannerMixpanelTracker;
    @Inject
    Lazy<TimerUtil> timerUtil;
    @BindView(R.id.etv_note_scanner)
    EllipseTextView tvNoteScanner;
    private String whenAvailable;
    public final TrackScanQrModel NetworkUserEntityData$$ExternalSyntheticLambda2 = new TrackScanQrModel();
    public boolean scheduleImpl = true;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6 = false;

    /* loaded from: classes5.dex */
    public interface ScannerListener {
        void MyBillsEntityDataFactory();

        void PlaceComponentResult();
    }

    static /* synthetic */ String getAuthRequestContext(boolean z) {
        return z ? "NATIVE" : "ONLINE";
    }

    protected void BuiltInFictitiousFunctionClassFactory() {
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_scanner;
    }

    static /* synthetic */ boolean DatabaseTableConfigUtil(ScannerFragment scannerFragment) {
        scannerFragment.scheduleImpl = true;
        return true;
    }

    static /* synthetic */ boolean NetworkUserEntityData$$ExternalSyntheticLambda5(ScannerFragment scannerFragment) {
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        return true;
    }

    static /* synthetic */ boolean newProxyInstance(ScannerFragment scannerFragment) {
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        return true;
    }

    static /* synthetic */ Showcase readMicros(ScannerFragment scannerFragment) {
        scannerFragment.BottomSheetCardBindingView$watcherCardNumberView$1 = null;
        return null;
    }

    public static ScannerFragment NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return new ScannerFragment();
    }

    @OnClick({R.id.rl_light_scan_qr})
    public void setTorch() {
        if (this.moveToNextValue) {
            this.moveToNextValue = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTorchOff();
            return;
        }
        this.moveToNextValue = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setTorchOn();
    }

    public void isLayoutRequested() {
        Completable BuiltInFictitiousFunctionClassFactory = Completable.BuiltInFictitiousFunctionClassFactory(1500L, TimeUnit.MILLISECONDS);
        Scheduler PlaceComponentResult = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(BuiltInFictitiousFunctionClassFactory, PlaceComponentResult));
        Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
        Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2));
        Action action = new Action() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                ScannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(ScannerFragment.this);
            }
        };
        Consumer<? super Disposable> PlaceComponentResult3 = Functions.PlaceComponentResult();
        Consumer<? super Throwable> PlaceComponentResult4 = Functions.PlaceComponentResult();
        Action action2 = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        addDisposable(KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3, PlaceComponentResult4, action, action2, action2, Functions.KClassImpl$Data$declaredNonStaticMembers$2).q_());
    }

    @OnClick({R.id.rl_scan_gallery})
    public void openGallery() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.PrepareContext;
        if (activityResultLauncher != null) {
            this.scheduleImpl = false;
            activityResultLauncher.MyBillsEntityDataFactory(ImagePicker.getAuthRequestContext(), null);
        }
    }

    public final void lookAheadTest() {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setStatusText("");
        }
        newProxyInstance();
        CustomDecoratedBarcodeView customDecoratedBarcodeView2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView2 != null) {
            customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
        }
    }

    public void PlaceComponentResult(boolean z) {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            if (z) {
                customDecoratedBarcodeView.setVisibility(8);
            } else {
                customDecoratedBarcodeView.setVisibility(0);
            }
        }
        ImageView imageView = this.imgScanGallery;
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    /* renamed from: id.dana.scanner.ScannerFragment$2 */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 implements BarcodeCallback {
        AnonymousClass2() {
            ScannerFragment.this = r1;
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public final void getAuthRequestContext(BarcodeResult barcodeResult) {
            ScannerFragment.newProxyInstance(ScannerFragment.this);
            TrackScanQrModel trackScanQrModel = ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            trackScanQrModel.initRecordTimeStamp = TrackScanQrModel.BuiltInFictitiousFunctionClassFactory(trackScanQrModel.newProxyInstance);
            if (barcodeResult.getAuthRequestContext().length() > 8) {
                ScannerFragment.PlaceComponentResult(ScannerFragment.this, "Scan");
                ScannerFragment.this.getAuthRequestContext(barcodeResult.getAuthRequestContext(), ScannerFragment.this.getErrorConfigVersion, Boolean.FALSE);
                return;
            }
            ScannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(barcodeResult.getAuthRequestContext());
            ScannerFragment.this.isLayoutRequested();
        }

        @Override // com.journeyapps.barcodescanner.BarcodeCallback
        public final void getAuthRequestContext(List<ResultPoint> list) {
            if (ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                return;
            }
            ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.newProxyInstance = Long.valueOf(System.currentTimeMillis());
        }
    }

    protected final void DatabaseTableConfigUtil() {
        PrepareContext();
    }

    protected void getAuthRequestContext() {
        if (this.getSupportButtonTintMode) {
            return;
        }
        if (getActivity() instanceof HomeTabActivity) {
            ((HomeTabActivity) getActivity()).setSwipeable(false);
        }
        this.getSupportButtonTintMode = true;
        this.bottomSheetOnBoardingPresenter.get().KClassImpl$Data$declaredNonStaticMembers$2("scan_qr");
    }

    private CpmToSendMoneyDialogHandler MyBillsEntityDataFactory() {
        if (this.DatabaseTableConfigUtil == null) {
            this.DatabaseTableConfigUtil = new CpmToSendMoneyDialogHandler(requireContext(), new Function0() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ScannerFragment.this.scanQrPresenter.get().BuiltInFictitiousFunctionClassFactory();
                    return Unit.INSTANCE;
                }
            }, new Function0() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScannerFragment.this.getErrorConfigVersion();
                }
            });
        }
        return this.DatabaseTableConfigUtil;
    }

    public final /* synthetic */ Unit getErrorConfigVersion() {
        Intent intentClassWithTracking = getIntentClassWithTracking(SendMoneyActivity.class, TrackerKey.SourceType.CPM);
        intentClassWithTracking.putExtra("transferScenario", "sendMoney");
        requireActivity().startActivity(intentClassWithTracking);
        return Unit.INSTANCE;
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (z) {
            getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.PROCESSING), true);
            KClassImpl$Data$declaredNonStaticMembers$2(false);
            return;
        }
        getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.IDLE), false);
        KClassImpl$Data$declaredNonStaticMembers$2(false);
    }

    public void getAuthRequestContext(String str, String str2, Boolean bool) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            return;
        }
        if (getBaseActivity().getIntent() == null || !getBaseActivity().getIntent().hasExtra(ScannerActivity.CODE_CONSUMER)) {
            getAuthRequestContext(str, str2, bool.booleanValue());
        } else {
            BuiltInFictitiousFunctionClassFactory(str, str2);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = true;
        if (!"miniprogram".equals(getBaseActivity().getIntent().getStringExtra(ScannerActivity.CODE_CONSUMER))) {
            getAuthRequestContext(str, str2, false);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.getErrorConfigVersion = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.ScannerAction.DECODE_CODE;
        NetworkUserEntityData$$ExternalSyntheticLambda6();
        getAuthRequestContext(str);
    }

    public final void getAuthRequestContext(String str) {
        Intent intent = new Intent();
        intent.putExtra("success", true);
        intent.putExtra("code", str);
        getBaseActivity().setResult(-1, intent);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void getAuthRequestContext(String str, String str2, boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.getErrorConfigVersion = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda7 = Long.valueOf(System.currentTimeMillis());
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            MyBillsEntityDataFactory(str);
        } else if (scheduleImpl(str)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult = DecodeQrBizType.DEEP_LINK;
            PlaceComponentResult(false);
            moveToNextValue(str);
        } else {
            if (PlaceComponentResult(str, this.readMicros)) {
                this.scanQrPresenter.get().getAuthRequestContext(str, "Scan QR");
            } else if (!BuiltInFictitiousFunctionClassFactory(str, this.getCallingPid)) {
                if (this.scanQrPresenter.get().getAuthRequestContext(str)) {
                    MyBillsEntityDataFactory().PlaceComponentResult();
                } else {
                    this.scanQrPresenter.get().MyBillsEntityDataFactory(str, z ? "Gallery" : "Scan QR", str2, this.NetworkUserEntityData$$ExternalSyntheticLambda3, true);
                }
            } else {
                DanaH5.startContainerFullUrlWithSendCredentials(str, new DanaH5Listener() { // from class: id.dana.scanner.ScannerFragment.3
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public /* synthetic */ void onContainerDestroyed(Bundle bundle) {
                        DanaH5Listener.CC.MyBillsEntityDataFactory();
                    }

                    {
                        ScannerFragment.this = this;
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public void onContainerCreated(Bundle bundle) {
                        DanaH5Listener.CC.getAuthRequestContext();
                    }
                });
            }
        }
    }

    private void MyBillsEntityDataFactory(String str) {
        if (getErrorConfigVersion(str)) {
            startActivity(KybCpmLoadingActivity.createIntentKybCpmLoadingActivity(getBaseActivity(), str, NetworkUserEntityData$$ExternalSyntheticLambda1() ? getActivity().getIntent().getExtras().getString(KybCpmConstants.KEY_INPUT_AMOUNT, "") : ""));
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
            return;
        }
        moveToNextValue();
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setStatusText("");
        }
        newProxyInstance();
        CustomDecoratedBarcodeView customDecoratedBarcodeView2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView2 != null) {
            customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
        }
        this.scanQrPresenter.get().PlaceComponentResult();
        isLayoutRequested();
        getBaseActivity().showToast(getString(R.string.invalid_qr_code));
    }

    private static boolean PlaceComponentResult(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (Pattern.compile(it.next()).matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                if (new URL(str).getHost().equals(it.next())) {
                    return true;
                }
            } catch (MalformedURLException unused) {
                return false;
            }
        }
        return false;
    }

    private static boolean scheduleImpl(String str) {
        return str != null && str.trim().contains(DanaUrl.DEEPLINK_URL);
    }

    public void getAuthRequestContext(String str, boolean z) {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.clearBubbleView();
            this.KClassImpl$Data$declaredNonStaticMembers$2.setBubbleStatusText(str);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setPlaceholderShow(z);
            this.KClassImpl$Data$declaredNonStaticMembers$2.setIsNeedToShowPaylaterCicilLogo(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            if (!str.isEmpty() && !z) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibilityQrisSupportedStamp(true, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
                this.KClassImpl$Data$declaredNonStaticMembers$2.showBubbleText();
                return;
            }
            CustomDecoratedBarcodeView customDecoratedBarcodeView2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (customDecoratedBarcodeView2 != null) {
                customDecoratedBarcodeView2.setVisibilityToastText(false);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibilityQrisStampWithPlaceholder(false, false);
        }
    }

    private void newProxyInstance() {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView == null || customDecoratedBarcodeView.getViewFinderView() == null) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getViewFinderView().setMaskColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.res_0x7f060353_networkuserentitydata_externalsyntheticlambda0));
        this.KClassImpl$Data$declaredNonStaticMembers$2.setFramingRect(new Size(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels));
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        if (z) {
            this.timerUtil.get().PlaceComponentResult(3, new TimerUtil.OnTimerCallback() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda4
                @Override // id.dana.utils.TimerUtil.OnTimerCallback
                public final void onFinish() {
                    ScannerFragment.this.GetContactSyncConfig();
                }
            });
            return;
        }
        TimerUtil timerUtil = this.timerUtil.get();
        Disposable disposable = timerUtil.BuiltInFictitiousFunctionClassFactory;
        if (disposable != null && !disposable.isDisposed()) {
            timerUtil.BuiltInFictitiousFunctionClassFactory.dispose();
        }
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setVisibilityToastText(true);
        }
    }

    public final /* synthetic */ void GetContactSyncConfig() {
        PlaceComponentResult(false);
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setVisibilityToastText(false);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibilityQrisStampWithPlaceholder(false, false);
        if (!NetworkUserEntityData$$ExternalSyntheticLambda2() && !this.FragmentBottomSheetPaymentSettingBinding) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.setVisibilityQrisSupportedStamp(true, this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        }
        TimerUtil timerUtil = this.timerUtil.get();
        Disposable disposable = timerUtil.BuiltInFictitiousFunctionClassFactory;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        timerUtil.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return customDecoratedBarcodeView != null && customDecoratedBarcodeView.isBubbleQrisSupportedVisible();
    }

    @OnClick({R.id.rl_help_scan_qr})
    public void onHelpClicked() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.SCAN_QR_HELP;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        ArrayList arrayList = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = arrayList;
        BuiltInFictitiousFunctionClassFactory(arrayList);
        startActivity(BottomSheetHelpActivity.createBottomSheetHelpIntent(getActivity(), new OnBoardingModel(getString(R.string.bottom_on_boarding_title_scan), "list", this.NetworkUserEntityData$$ExternalSyntheticLambda1, "scan_qr")));
    }

    @Override // id.dana.base.BaseFragment
    public boolean onBackPressed() {
        this.getSupportButtonTintMode = false;
        Showcase showcase = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (showcase != null) {
            showcase.PlaceComponentResult();
        }
        return super.onBackPressed();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            CustomDecoratedBarcodeView customDecoratedBarcodeView = new CustomDecoratedBarcodeView(context);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = customDecoratedBarcodeView;
            customDecoratedBarcodeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        AnonymousClass15 anonymousClass15 = new AnonymousClass15();
        Intrinsics.checkNotNullParameter(anonymousClass15, "");
        builder.BuiltInFictitiousFunctionClassFactory = anonymousClass15;
        this.initRecordTimeStamp = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(this);
        String[] strArr2 = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda10
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                ScannerFragment.this.getAuthRequestContext(permissionResult);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder2.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = builder2.PlaceComponentResult();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayout(), viewGroup, false);
        bindView(inflate);
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            this.rlBarcodeScanner.addView(customDecoratedBarcodeView);
        }
        return inflate;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.scheduleImpl) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory();
        }
        moveToNextValue();
        lookAheadTest();
        this.scanQrPresenter.get().PlaceComponentResult();
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.pause();
        super.onPause();
    }

    @Override // id.dana.base.BaseFragment
    public void onSelected() {
        if (getContext() == null) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        lookAheadTest();
        if (NetworkUserEntityData$$ExternalSyntheticLambda8()) {
            getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.IDLE), false);
            KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
        super.onSelected();
    }

    @Override // id.dana.base.BaseFragment
    public void onUnSelected() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        if (this.moveToNextValue) {
            this.moveToNextValue = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTorchOff();
        }
        getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.IDLE), false);
        KClassImpl$Data$declaredNonStaticMembers$2(false);
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.pause();
        }
        super.onUnSelected();
    }

    @Override // id.dana.base.BaseFragment
    public void disposePresenter() {
        super.disposePresenter();
        this.h5EventPresenter.get().onDestroy();
        this.playStoreReviewPresenter.get().onDestroy();
        this.presenter.get().onDestroy();
        this.globalNetworkPresenter.get().onDestroy();
        this.readDeepLinkPropertiesPresenter.get().onDestroy();
        this.deepLinkPresenter.get().onDestroy();
        this.restoreUrlPresenter.get().onDestroy();
        this.featurePresenter.get().onDestroy();
        this.scanQrPresenter.get().onDestroy();
        this.bottomSheetOnBoardingPresenter.get().onDestroy();
    }

    public final void PlaceComponentResult(CustomDecoratedBarcodeView customDecoratedBarcodeView) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = customDecoratedBarcodeView;
        customDecoratedBarcodeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    /* renamed from: id.dana.scanner.ScannerFragment$5 */
    /* loaded from: classes5.dex */
    public class AnonymousClass5 implements CameraPreview.StateListener {
        final /* synthetic */ ScannerListener BuiltInFictitiousFunctionClassFactory;

        @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
        public final void MyBillsEntityDataFactory() {
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
        public final void getAuthRequestContext() {
        }

        AnonymousClass5(ScannerListener scannerListener) {
            ScannerFragment.this = r1;
            this.BuiltInFictitiousFunctionClassFactory = scannerListener;
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            Long l;
            if (!ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext()) {
                TrackScanQrModel trackScanQrModel = ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                CameraReadyTimeHelper cameraReadyTimeHelper = CameraReadyTimeHelper.INSTANCE;
                l = CameraReadyTimeHelper.MyBillsEntityDataFactory;
                trackScanQrModel.getAuthRequestContext = TrackScanQrModel.BuiltInFictitiousFunctionClassFactory(l);
                CameraReadyTimeHelper.getAuthRequestContext();
            }
            ScannerListener scannerListener = this.BuiltInFictitiousFunctionClassFactory;
            if (scannerListener != null) {
                scannerListener.MyBillsEntityDataFactory();
            }
            if (ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
                return;
            }
            ScannerFragment.this.getAuthRequestContext();
        }

        @Override // com.journeyapps.barcodescanner.CameraPreview.StateListener
        public final void getAuthRequestContext(Exception exc) {
            ScannerListener scannerListener = this.BuiltInFictitiousFunctionClassFactory;
            if (scannerListener != null) {
                scannerListener.PlaceComponentResult();
            }
        }
    }

    public final void PlaceComponentResult(ScannerListener scannerListener) {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView == null) {
            return;
        }
        customDecoratedBarcodeView.setStateListener(new AnonymousClass5(scannerListener));
    }

    public final /* synthetic */ void MyBillsEntityDataFactory(DecodeImage decodeImage) throws Exception {
        try {
            getAuthRequestContext(decodeImage.MyBillsEntityDataFactory().getText(), "", Boolean.TRUE);
        } catch (NotFoundException unused) {
            getAuthRequestContext(getString(R.string.decode_code_gallery_error), false);
            KClassImpl$Data$declaredNonStaticMembers$2(true);
            isLayoutRequested();
        }
        FileUtil.MyBillsEntityDataFactory(getContext(), SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2);
        SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }

    public final void moveToNextValue() {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.pause();
            if (NetworkUserEntityData$$ExternalSyntheticLambda8()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.resume();
                lookAheadTest();
                if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                    getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.ADD_PARTICIPANT), false);
                    KClassImpl$Data$declaredNonStaticMembers$2(true);
                    return;
                }
                getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.IDLE), false);
                KClassImpl$Data$declaredNonStaticMembers$2(true);
            }
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return getUserVisibleHint() && PermissionHelper.MyBillsEntityDataFactory(getBaseActivity(), "android.permission.CAMERA");
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return (getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getExtras() == null) ? false : true;
    }

    private static boolean getErrorConfigVersion(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("hQVDUFY");
    }

    public final /* synthetic */ void initRecordTimeStamp() {
        lookAheadTest();
        if (this.FragmentBottomSheetPaymentSettingBinding) {
            Target KClassImpl$Data$declaredNonStaticMembers$2 = new TargetBuilder(getActivity()).BuiltInFictitiousFunctionClassFactory(this.rlHelpScanQr).BuiltInFictitiousFunctionClassFactory(new CircleShape(MyBillsEntityDataFactory)).getAuthRequestContext(new Content(getResources().getString(R.string.tooltip_highlight_title), getResources().getString(R.string.tooltip_highlight_description_scan_qr))).KClassImpl$Data$declaredNonStaticMembers$2();
            if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == null) {
                SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(getActivity());
                simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = KClassImpl$Data$declaredNonStaticMembers$2;
                this.BottomSheetCardBindingView$watcherCardNumberView$1 = simpleShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(getResources().getString(R.string.btnQrOnboarding)).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.scanner.ScannerFragment.14
                    {
                        ScannerFragment.this = this;
                    }

                    @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                    public void onFinished(int i) {
                        ScannerFragment.readMicros(ScannerFragment.this);
                        ScannerFragment.getErrorConfigVersion(ScannerFragment.this);
                    }
                }).PlaceComponentResult();
            }
            this.FragmentBottomSheetPaymentSettingBinding = false;
            getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.IDLE), false);
            KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.lookAheadTest = this.moveToNextValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.DatabaseTableConfigUtil = TrackerQRScanner.MyBillsEntityDataFactory();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.GetContactSyncConfig = this.whenAvailable;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.MyBillsEntityDataFactory = this.PlaceComponentResult;
        final ScannerMixpanelTracker scannerMixpanelTracker = this.scannerMixpanelTracker.get();
        final TrackScanQrModel trackScanQrModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullParameter(trackScanQrModel, "");
        Function1<EventTrackerModel.Builder, Unit> function1 = new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.scanner.tracker.ScannerMixpanelTracker$trackScannerResult$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = "Scan QR";
                TrackScanQrModel trackScanQrModel2 = TrackScanQrModel.this;
                ScannerMixpanelTracker scannerMixpanelTracker2 = scannerMixpanelTracker;
                builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.CAMERA_LIGHT_TURNED_ON, String.valueOf(trackScanQrModel2.lookAheadTest));
                builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.QR_SCAN_TIME, String.valueOf(trackScanQrModel2.initRecordTimeStamp));
                builder.MyBillsEntityDataFactory("Source", trackScanQrModel2.DatabaseTableConfigUtil);
                builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.QR_RESULT_ACTION, trackScanQrModel2.KClassImpl$Data$declaredNonStaticMembers$2);
                String str = trackScanQrModel2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (str == null) {
                    str = "";
                }
                builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.QR_SOURCE, str);
                builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.QR_DECODE_TIME, String.valueOf(trackScanQrModel2.BuiltInFictitiousFunctionClassFactory));
                builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.QR_DECODE_RESULT, trackScanQrModel2.getErrorConfigVersion);
                String str2 = trackScanQrModel2.PlaceComponentResult;
                if (str2 != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.QR_BIZ_TYPE, str2);
                }
                builder.MyBillsEntityDataFactory("Service Key", trackScanQrModel2.GetContactSyncConfig);
                builder.MyBillsEntityDataFactory("App ID", trackScanQrModel2.MyBillsEntityDataFactory);
                String str3 = trackScanQrModel2.moveToNextValue;
                if (str3 != null) {
                    String lowerCase = str3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    builder.MyBillsEntityDataFactory("Fail Reason", lowerCase);
                }
                Long l = trackScanQrModel2.getAuthRequestContext;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.ScanQRProperties.SCANNER_READY_TIME, l != null ? l.longValue() : 0L);
                builder.MyBillsEntityDataFactory(TrackerKey.ScanQRProperties.DECODE_TYPE, trackScanQrModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                builder.BuiltInFictitiousFunctionClassFactory();
                ScannerMixpanelTracker.getAuthRequestContext(scannerMixpanelTracker2, trackScanQrModel2);
            }
        };
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(scannerMixpanelTracker.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        function1.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
        NetworkUserEntityData$$ExternalSyntheticLambda7();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory();
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        long longValue = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext == null ? 0L : this.NetworkUserEntityData$$ExternalSyntheticLambda2.getAuthRequestContext.longValue();
        long longValue2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.initRecordTimeStamp == null ? 0L : this.NetworkUserEntityData$$ExternalSyntheticLambda2.initRecordTimeStamp.longValue();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new FeatureTimeModel(getActivity() instanceof PayActivity ? "Camera Card" : "Scan QR", longValue + longValue2 + (this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory != null ? this.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory.longValue() : 0L));
    }

    public void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.pause();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
            getAuthRequestContext("");
        }
        if ((getActivity() instanceof ScannerActivity) && this.isLayoutRequested && getActivity() != null) {
            getActivity().finish();
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return !TextUtils.isEmpty(this.newProxyInstance) && "split_bill".equals(this.newProxyInstance);
    }

    public final /* synthetic */ void PlaceComponentResult(String str) {
        if ("split_bill".equals(this.newProxyInstance) && BranchLinkConstant.ActionTarget.SPLIT_BILL_DETAIL.equals(str)) {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(ScannerActionState.INVALID_QR_CODE);
            scheduleImpl();
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
            lookAheadTest();
            getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, false);
            KClassImpl$Data$declaredNonStaticMembers$2(true);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_QR_BARCODE;
            NetworkUserEntityData$$ExternalSyntheticLambda6();
        } else if (BranchLinkConstant.ActionTarget.PROFILE_QRIS_ALERT.equals(str)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ScannerFragment.PlaceComponentResult(ScannerFragment.this);
                }
            }, 2000L);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String BuiltInFictitiousFunctionClassFactory(String str) {
        char c;
        str.hashCode();
        switch (str.hashCode()) {
            case -1879307469:
                if (str.equals(ScannerActionState.PROCESSING)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1145597085:
                if (str.equals(ScannerActionState.INVALID_QR_CODE)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1109161484:
                if (str.equals(ScannerActionState.ADD_PARTICIPANT)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -755483303:
                if (str.equals(ScannerActionState.SEND_TO_SELF)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2274292:
                if (str.equals(ScannerActionState.IDLE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        return c != 4 ? str : "";
                    }
                    return getString(R.string.send_to_self);
                }
                return getString(R.string.scan_qr_note_to_add_participant);
            }
            return getString(R.string.invalid_qr_code);
        }
        return getString(R.string.processing);
    }

    public final void scheduleImpl() {
        Group group = this.rlScanner;
        if (group != null) {
            group.setVisibility(8);
        }
        ImageView imageView = this.icImageFg;
        if (imageView != null) {
            imageView.clearAnimation();
            this.icImageFg.setVisibility(8);
        }
    }

    /* renamed from: id.dana.scanner.ScannerFragment$15 */
    /* loaded from: classes5.dex */
    class AnonymousClass15 implements PermissionCallback {
        @Override // com.anggrayudi.storage.permission.PermissionCallback
        public /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
            PermissionCallback.CC.getAuthRequestContext(permissionRequest);
        }

        AnonymousClass15() {
            ScannerFragment.this = r1;
        }

        @Override // com.anggrayudi.storage.permission.PermissionCallback
        public void onShouldRedirectToSystemSettings(List<PermissionReport> list) {
            PermissionHelper.MyBillsEntityDataFactory(ScannerFragment.this.requireContext());
        }

        @Override // com.anggrayudi.storage.permission.PermissionCallback
        public void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
            Optional NetworkUserEntityData$$ExternalSyntheticLambda7 = Collection.EL.getAuthRequestContext(permissionResult.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext(new Predicate() { // from class: id.dana.scanner.ScannerFragment$15$$ExternalSyntheticLambda0
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
                    boolean equals;
                    equals = ((PermissionReport) obj).KClassImpl$Data$declaredNonStaticMembers$2.equals("android.permission.CAMERA");
                    return equals;
                }
            }).NetworkUserEntityData$$ExternalSyntheticLambda7();
            if (NetworkUserEntityData$$ExternalSyntheticLambda7.KClassImpl$Data$declaredNonStaticMembers$2()) {
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult;
                if (obj != null) {
                    if (((PermissionReport) obj).getBuiltInFictitiousFunctionClassFactory()) {
                        ScannerFragment.this.DatabaseTableConfigUtil();
                    } else {
                        PermissionHelper.MyBillsEntityDataFactory(ScannerFragment.this.requireContext());
                    }
                } else {
                    throw new NoSuchElementException("No value present");
                }
            }
            ScannerFragment.this.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public final /* synthetic */ void getAuthRequestContext(PermissionResult permissionResult) {
        if (permissionResult.MyBillsEntityDataFactory()) {
            this.globalNetworkPresenter.get().PlaceComponentResult();
        } else {
            this.KClassImpl$Data$declaredNonStaticMembers$2.resume();
        }
    }

    private void moveToNextValue(String str) {
        FragmentActivity requireActivity = requireActivity();
        Intent intent = requireActivity.getIntent();
        intent.setData(Uri.parse(TextUtil.PlaceComponentResult(str, this.getErrorConfigVersion)));
        intent.putExtra(TrackerType.BRANCH, str);
        intent.putExtra("branch_force_new_session", true);
        intent.putExtra("in_app_deeplink_process", true);
        requireActivity.setIntent(intent);
        this.deepLinkPresenter.get().BuiltInFictitiousFunctionClassFactory(requireActivity);
    }

    public static /* synthetic */ void PlaceComponentResult(ScannerFragment scannerFragment) {
        scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2.resume();
        scannerFragment.scheduleImpl();
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        CustomDecoratedBarcodeView customDecoratedBarcodeView = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setStatusText("");
        }
        scannerFragment.newProxyInstance();
        CustomDecoratedBarcodeView customDecoratedBarcodeView2 = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView2 != null) {
            customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
        }
        scannerFragment.PlaceComponentResult(false);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ScannerFragment scannerFragment) {
        scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2.resume();
        scannerFragment.scheduleImpl();
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        CustomDecoratedBarcodeView customDecoratedBarcodeView = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setStatusText("");
        }
        scannerFragment.newProxyInstance();
        CustomDecoratedBarcodeView customDecoratedBarcodeView2 = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView2 != null) {
            customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
        }
        scannerFragment.PlaceComponentResult(false);
    }

    static /* synthetic */ void lookAheadTest(ScannerFragment scannerFragment) {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setStatusText("");
        }
        scannerFragment.newProxyInstance();
        CustomDecoratedBarcodeView customDecoratedBarcodeView2 = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView2 != null) {
            customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(ScannerFragment scannerFragment, String str) {
        scannerFragment.scheduleImpl();
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        CustomDecoratedBarcodeView customDecoratedBarcodeView = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setStatusText("");
        }
        scannerFragment.newProxyInstance();
        CustomDecoratedBarcodeView customDecoratedBarcodeView2 = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView2 != null) {
            customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
        }
        scannerFragment.getAuthRequestContext(str, false);
        scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(true);
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_QR_BARCODE;
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(ScannerFragment scannerFragment) {
        if (scannerFragment.getContext() != null) {
            scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda5.check();
        }
    }

    static /* synthetic */ void moveToNextValue(ScannerFragment scannerFragment) {
        ArrayList arrayList = new ArrayList();
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = arrayList;
        scannerFragment.BuiltInFictitiousFunctionClassFactory(arrayList);
        scannerFragment.SubSequence.MyBillsEntityDataFactory(BottomSheetOnBoardingActivity.createOnBoardingIntent(scannerFragment.getActivity(), new OnBoardingModel(scannerFragment.getString(R.string.bottom_on_boarding_title_scan), BottomSheetType.VIEW_PAGER, scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda1, "scan_qr")), null);
    }

    static /* synthetic */ void getErrorConfigVersion(ScannerFragment scannerFragment) {
        if (scannerFragment.getActivity() instanceof HomeTabActivity) {
            ((HomeTabActivity) scannerFragment.getActivity()).setSwipeable(true);
        }
    }

    static /* synthetic */ void PlaceComponentResult(ScannerFragment scannerFragment, String str) {
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
    }

    static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(ScannerFragment scannerFragment) {
        if (!ScannerViewType.ACTIVITY.equals(scannerFragment.A) || scannerFragment.getActivity() == null) {
            return;
        }
        scannerFragment.getActivity().finish();
    }

    static /* synthetic */ void MyBillsEntityDataFactory(ScannerFragment scannerFragment, ScanModel scanModel) {
        if (DecodeQrBizType.GN_AC_CODE.equals(scanModel.getBizType())) {
            scannerFragment.globalNetworkPresenter.get().KClassImpl$Data$declaredNonStaticMembers$2(scanModel.getBizInfo().NetworkUserEntityData$$ExternalSyntheticLambda6, scanModel.getAcDecodeConfig());
        } else {
            scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda2.PlaceComponentResult = scanModel.getBizType();
            scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.ScannerAction.DECODE_CODE;
            scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda6();
            scannerFragment.PlaceComponentResult(false);
            CustomDecoratedBarcodeView customDecoratedBarcodeView = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            if (customDecoratedBarcodeView != null) {
                customDecoratedBarcodeView.setStatusText("");
            }
            scannerFragment.newProxyInstance();
            CustomDecoratedBarcodeView customDecoratedBarcodeView2 = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            if (customDecoratedBarcodeView2 != null) {
                customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
            }
        }
        BizInfoModel bizInfo = scanModel.getBizInfo();
        if (bizInfo != null && bizInfo.isLayoutRequested != null) {
            scannerFragment.isLayoutRequested = bizInfo.isLayoutRequested.contains("mini://") || scannerFragment.isLayoutRequested;
        }
        scannerFragment.PlaceComponentResult();
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ScannerFragment scannerFragment, String str) {
        scannerFragment.getAuthRequestContext(str, false);
        scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(true);
        scannerFragment.isLayoutRequested();
    }

    static /* synthetic */ void PrepareContext(ScannerFragment scannerFragment) {
        scannerFragment.lookAheadTest = false;
        scannerFragment.h5EventPresenter.get().MyBillsEntityDataFactory();
    }

    static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda7(ScannerFragment scannerFragment) {
        CustomToastUtil.getAuthRequestContext(scannerFragment.getBaseActivity(), R.drawable.ic_close_red, scannerFragment.getBaseActivity().getString(R.string.qr_expired_scanner_error_message));
        scannerFragment.scheduleImpl();
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        CustomDecoratedBarcodeView customDecoratedBarcodeView = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView != null) {
            customDecoratedBarcodeView.setStatusText("");
        }
        scannerFragment.newProxyInstance();
        CustomDecoratedBarcodeView customDecoratedBarcodeView2 = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (customDecoratedBarcodeView2 != null) {
            customDecoratedBarcodeView2.decodeSingle(new AnonymousClass2());
        }
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_QR_BARCODE;
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda6();
    }

    static /* synthetic */ void FragmentBottomSheetPaymentSettingBinding(ScannerFragment scannerFragment) {
        if (scannerFragment.getActivity() != null) {
            scannerFragment.getActivity().finish();
        }
    }

    static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda4(ScannerFragment scannerFragment) {
        if (scannerFragment.getContext() != null && scannerFragment.icImageFg != null) {
            scannerFragment.getAuthRequestContext(scannerFragment.BuiltInFictitiousFunctionClassFactory(ScannerActionState.PROCESSING), true);
            scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(false);
            Animation loadAnimation = AnimationUtils.loadAnimation(scannerFragment.getContext(), R.anim.res_0x7f010050_kclassimpl_data_declarednonstaticmembers_2);
            loadAnimation.setInterpolator(new LinearInterpolator());
            scannerFragment.icImageFg.startAnimation(loadAnimation);
        }
        Group group = scannerFragment.rlScanner;
        if (group != null) {
            group.setVisibility(0);
        }
    }

    static /* synthetic */ void whenAvailable(ScannerFragment scannerFragment) {
        scannerFragment.scheduleImpl();
        scannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
    }

    static /* synthetic */ void getErrorConfigVersion(ScannerFragment scannerFragment, String str) {
        scannerFragment.getAuthRequestContext(str, false);
        scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(false);
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("case", "");
        Intrinsics.checkNotNullParameter("QrCodeNotValid", "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("case", "QrCodeNotValid");
        StringBuilder sb = new StringBuilder();
        sb.append("QR length: ");
        sb.append(str.length());
        String obj = sb.toString();
        Intrinsics.checkNotNullParameter(obj, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("QR value: ");
        sb2.append(str);
        String obj2 = sb2.toString();
        Intrinsics.checkNotNullParameter(obj2, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj2);
        Exception exc = new Exception("QrCodeNotValid: Decoded QR text length invalid. Please check Crashlytics Logs");
        Intrinsics.checkNotNullParameter(exc, "");
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(exc);
    }

    static /* synthetic */ void SubSequence(final ScannerFragment scannerFragment) {
        CustomDecoratedBarcodeView customDecoratedBarcodeView;
        if (SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2 == null || scannerFragment.getContext() == null || (customDecoratedBarcodeView = scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2) == null || customDecoratedBarcodeView.getMeasuredWidth() <= 0 || scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2.getMeasuredHeight() <= 0) {
            return;
        }
        try {
            final DecodeImage decodeImage = new DecodeImage(BitmapUtil.KClassImpl$Data$declaredNonStaticMembers$2(scannerFragment.getContext(), SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2, scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2.getMeasuredWidth(), scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2.getMeasuredHeight()));
            Completable BuiltInFictitiousFunctionClassFactory = Completable.BuiltInFictitiousFunctionClassFactory(1L, TimeUnit.SECONDS);
            Scheduler PlaceComponentResult = AndroidSchedulers.PlaceComponentResult();
            ObjectHelper.PlaceComponentResult(PlaceComponentResult, "scheduler is null");
            Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(BuiltInFictitiousFunctionClassFactory, PlaceComponentResult));
            Scheduler PlaceComponentResult2 = AndroidSchedulers.PlaceComponentResult();
            ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "scheduler is null");
            Completable KClassImpl$Data$declaredNonStaticMembers$22 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2));
            Action action = new Action() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Action
                public final void run() {
                    ScannerFragment.this.MyBillsEntityDataFactory(decodeImage);
                }
            };
            Consumer<? super Disposable> PlaceComponentResult3 = Functions.PlaceComponentResult();
            Consumer<? super Throwable> PlaceComponentResult4 = Functions.PlaceComponentResult();
            Action action2 = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
            scannerFragment.addDisposable(KClassImpl$Data$declaredNonStaticMembers$22.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult3, PlaceComponentResult4, action, action2, action2, Functions.KClassImpl$Data$declaredNonStaticMembers$2).q_());
        } catch (IOException unused) {
            scannerFragment.getAuthRequestContext(scannerFragment.getString(R.string.decode_code_gallery_error), false);
            scannerFragment.KClassImpl$Data$declaredNonStaticMembers$2(true);
            scannerFragment.isLayoutRequested();
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(List<ContentOnBoardingModel> list) {
        list.add(new ContentOnBoardingModel((int) R.drawable.on_boarding_send_money, getString(R.string.bottom_on_boarding_subtitle_scan_first), getString(R.string.bottom_on_boarding_body_text_scan_first)));
        list.add(new ContentOnBoardingModel((int) R.drawable.onboarding_easy_trx, getString(R.string.bottom_on_boarding_subtitle_scan_second), getString(R.string.bottom_on_boarding_body_text_scan_second)));
        list.add(new ContentOnBoardingModel((int) R.drawable.on_boarding_qris, getString(R.string.bottom_on_boarding_subtitle_scan_third), getString(R.string.bottom_on_boarding_body_text_scan_third)));
        list.add(new ContentOnBoardingModel((int) R.drawable.on_boarding_request, getString(R.string.bottom_on_boarding_subtitle_scan_fourth), getString(R.string.bottom_on_boarding_body_text_scan_fourth)));
    }

    private void PrepareContext() {
        Lazy<ScanQrContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            lazy.get().getAuthRequestContext();
        }
        Lazy<ScanQrContract.Presenter> lazy2 = this.scanQrPresenter;
        if (lazy2 != null) {
            lazy2.get().KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (getActivity() instanceof ScannerActivity) {
            ScannerListener scannerListener = new ScannerListener() { // from class: id.dana.scanner.ScannerFragment.4
                @Override // id.dana.scanner.ScannerFragment.ScannerListener
                public final void PlaceComponentResult() {
                }

                {
                    ScannerFragment.this = this;
                }

                @Override // id.dana.scanner.ScannerFragment.ScannerListener
                public final void MyBillsEntityDataFactory() {
                    ScannerFragment.SubSequence(ScannerFragment.this);
                }
            };
            CustomDecoratedBarcodeView customDecoratedBarcodeView = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (customDecoratedBarcodeView != null) {
                customDecoratedBarcodeView.setStateListener(new AnonymousClass5(scannerListener));
            }
            lookAheadTest();
            if (getActivity() != null && getActivity().getIntent() != null) {
                this.newProxyInstance = getActivity().getIntent().getStringExtra(ScannerActivity.FROM_VIEW_TYPE);
                if (KClassImpl$Data$declaredNonStaticMembers$2()) {
                    getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(ScannerActionState.ADD_PARTICIPANT), false);
                    KClassImpl$Data$declaredNonStaticMembers$2(true);
                }
            }
            try {
                if (getBaseActivity().getIntent() != null && getBaseActivity().getIntent().getExtras() != null) {
                    this.isLayoutRequested = getBaseActivity().getIntent().getBooleanExtra(ScannerActivity.CLOSE_AFTER_SCAN, false);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda6 = getBaseActivity().getIntent().getBooleanExtra("kyb_cpm", false);
                    if (getBaseActivity().getIntent().hasExtra(ScannerActivity.SERVICE_KEY) && getBaseActivity().getIntent().hasExtra("APP_ID")) {
                        this.whenAvailable = getBaseActivity().getIntent().getStringExtra(ScannerActivity.SERVICE_KEY);
                        this.PlaceComponentResult = getBaseActivity().getIntent().getStringExtra("APP_ID");
                    }
                }
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SCANNER_FRAGMENT, e.getMessage());
            }
            this.getErrorConfigVersion = getBaseActivity().getIntent().getStringExtra("scene");
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda6) {
            this.rlScanGallery.setVisibility(8);
            this.rlHelpScanQr.setVisibility(8);
        }
    }

    @OnClick({R.id.tv_done_scan})
    public void doneScan() {
        if (this.moveToNextValue) {
            this.moveToNextValue = false;
            this.KClassImpl$Data$declaredNonStaticMembers$2.setTorchOff();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
        getBaseActivity().onBackPressed();
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        if (this.GetContactSyncConfig != null) {
            this.GetContactSyncConfig = null;
        }
        this.PrepareContext = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScannerFragment.this.getAuthRequestContext((ActivityResult) obj);
            }
        });
        this.SubSequence = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda5
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityResult activityResult = (ActivityResult) obj;
                ScannerFragment.this.initRecordTimeStamp();
            }
        });
        DaggerScannerComponent.Builder MyBillsEntityDataFactory2 = DaggerScannerComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory = (CheckoutH5EventModule) Preconditions.getAuthRequestContext(new CheckoutH5EventModule(new CheckoutH5EventContract.View() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda9
            @Override // id.dana.h5event.CheckoutH5EventContract.View
            public final void getAuthRequestContext(boolean z) {
                ScannerFragment.this.lookAheadTest = z;
            }
        }));
        MyBillsEntityDataFactory2.DatabaseTableConfigUtil = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.scanner.ScannerFragment.11
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onActionFailed(String str) {
                ServicesContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                Intrinsics.checkNotNullParameter(thirdPartyService, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                ServicesContract.View.CC.MyBillsEntityDataFactory(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onGetThirdPartyServices(List list) {
                ServicesContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            {
                ScannerFragment.this = this;
            }
        }));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new DeepLinkCallback() { // from class: id.dana.scanner.ScannerFragment.6
            @Override // id.dana.contract.deeplink.DeepLinkCallback
            public final void KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkPayloadModel deepLinkPayloadModel) {
            }

            {
                ScannerFragment.this = this;
            }

            @Override // id.dana.contract.deeplink.DeepLinkCallback
            public final void getAuthRequestContext() {
                ScannerFragment.this.PlaceComponentResult();
            }

            @Override // id.dana.contract.deeplink.DeepLinkCallback
            public final void PlaceComponentResult(String str) {
                if (ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda3) {
                    ScannerFragment.this.getAuthRequestContext("");
                }
            }
        };
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = "Scan QR";
        byte b = 0;
        MyBillsEntityDataFactory2.getAuthRequestContext = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = getActivity();
        authRequestContext.BuiltInFictitiousFunctionClassFactory = new ScanQrContract.View() { // from class: id.dana.scanner.ScannerFragment.13
            {
                ScannerFragment.this = this;
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void PlaceComponentResult(ScanModel scanModel) {
                ScannerFragment.MyBillsEntityDataFactory(ScannerFragment.this, scanModel);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(ScanModel scanModel) {
                ScannerFragment.MyBillsEntityDataFactory(ScannerFragment.this, scanModel);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_CODE_NOT_WHITE_LIST;
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String str) {
                ScannerFragment scannerFragment = ScannerFragment.this;
                ScannerFragment.BuiltInFictitiousFunctionClassFactory(scannerFragment, scannerFragment.BuiltInFictitiousFunctionClassFactory(str));
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_QR_BARCODE;
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void PlaceComponentResult(String str) {
                ScannerFragment.this.A = str;
                ScannerFragment.PrepareContext(ScannerFragment.this);
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.ScannerAction.ERROR_NON_SPLITBILL_PAYER;
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void getAuthRequestContext() {
                ScannerFragment.this.getBaseActivity().startActivity(SplitBillDetailsActivity.createNonEligibleUserIntent(ScannerFragment.this.getContext(), "Scan QR"));
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_NON_SPLITBILL_PAYER;
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final String PlaceComponentResult() {
                return ScannerFragment.this.newProxyInstance;
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void getErrorConfigVersion() {
                ScannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(ScannerFragment.this);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void getAuthRequestContext(ScanModel scanModel, boolean z) {
                ScannerFragment.MyBillsEntityDataFactory(ScannerFragment.this, scanModel);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean z, String str) {
                Intent intent = new Intent();
                intent.putExtra("success", z);
                intent.putExtra("code", str);
                ScannerFragment.this.getBaseActivity().setResult(-1, intent);
                ScannerFragment.FragmentBottomSheetPaymentSettingBinding(ScannerFragment.this);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void PlaceComponentResult(boolean z) {
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0 = ScannerFragment.getAuthRequestContext(z);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list) {
                ScannerFragment.this.readMicros = list;
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void moveToNextValue() {
                TrackScanQrModel trackScanQrModel = ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                trackScanQrModel.BuiltInFictitiousFunctionClassFactory = TrackScanQrModel.BuiltInFictitiousFunctionClassFactory(trackScanQrModel.NetworkUserEntityData$$ExternalSyntheticLambda7);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void getAuthRequestContext(QrBindingConfig qrBindingConfig) {
                if (qrBindingConfig.getEnable()) {
                    ScannerFragment.this.getCallingPid = qrBindingConfig.getQrIdentifier();
                }
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void MyBillsEntityDataFactory(boolean z) {
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda8 = z;
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void PlaceComponentResult(String str, String str2, String str3, Throwable th) {
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(ScannerFragment.this.getContext(), str2, str3, str, th);
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final FeatureTimeModel MyBillsEntityDataFactory() {
                return ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
                ScannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(ScannerFragment.this);
                if (ScannerFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    ScannerFragment.this.KClassImpl$Data$declaredNonStaticMembers$2.pause();
                }
                ScannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda4(ScannerFragment.this);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
                ScannerFragment.whenAvailable(ScannerFragment.this);
                ScannerFragment scannerFragment = ScannerFragment.this;
                ScannerFragment.getErrorConfigVersion(scannerFragment, scannerFragment.BuiltInFictitiousFunctionClassFactory(ScannerActionState.IDLE));
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
                String BuiltInFictitiousFunctionClassFactory = ScannerFragment.this.BuiltInFictitiousFunctionClassFactory(str);
                ScannerFragment.BuiltInFictitiousFunctionClassFactory(ScannerFragment.this, BuiltInFictitiousFunctionClassFactory);
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = BuiltInFictitiousFunctionClassFactory;
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
            }

            @Override // id.dana.contract.staticqr.ScanQrContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                if ("split_bill".equals(ScannerFragment.this.newProxyInstance)) {
                    String BuiltInFictitiousFunctionClassFactory = ScannerFragment.this.BuiltInFictitiousFunctionClassFactory(ScannerActionState.INVALID_QR_CODE);
                    ScannerFragment scannerFragment = ScannerFragment.this;
                    ScannerFragment.BuiltInFictitiousFunctionClassFactory(scannerFragment, scannerFragment.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory));
                    ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_QR_BARCODE;
                    ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
                    ScannerFragment.this.PlaceComponentResult(false);
                    ScannerFragment.lookAheadTest(ScannerFragment.this);
                } else {
                    ScannerFragment scannerFragment2 = ScannerFragment.this;
                    ScannerFragment.BuiltInFictitiousFunctionClassFactory(scannerFragment2, scannerFragment2.BuiltInFictitiousFunctionClassFactory(ScannerActionState.SEND_TO_SELF));
                }
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.ERROR_SCAN_IT_SELF;
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
            }
        };
        authRequestContext.getAuthRequestContext = new DanaH5Listener() { // from class: id.dana.scanner.ScannerFragment.12
            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerCreated(Bundle bundle) {
            }

            {
                ScannerFragment.this = this;
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerDestroyed(Bundle bundle) {
                ScannerFragment.this.h5EventPresenter.get().BuiltInFictitiousFunctionClassFactory();
                if (ScannerFragment.this.lookAheadTest) {
                    ScannerFragment.this.playStoreReviewPresenter.get().PlaceComponentResult();
                } else {
                    ScannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(ScannerFragment.this);
                }
            }
        };
        MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda2 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = getActivity();
        MyBillsEntityDataFactory2.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory3 = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory3.BuiltInFictitiousFunctionClassFactory = getActivity();
        MyBillsEntityDataFactory3.getAuthRequestContext = new FeatureCallback() { // from class: id.dana.scanner.ScannerFragment$$ExternalSyntheticLambda6
            @Override // id.dana.contract.deeplink.path.FeatureCallback
            public final void BuiltInFictitiousFunctionClassFactory(String str) {
                ScannerFragment.this.PlaceComponentResult(str);
            }
        };
        MyBillsEntityDataFactory2.moveToNextValue = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory3, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = getActivity();
        MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        MyBillsEntityDataFactory2.PlaceComponentResult = (DecodeQrImageModule) Preconditions.getAuthRequestContext(new DecodeQrImageModule(new DecodeQrImageContract.View() { // from class: id.dana.scanner.ScannerFragment.10
            {
                ScannerFragment.this = this;
            }

            @Override // id.dana.contract.staticqr.DecodeQrImageContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String str) {
                TrackScanQrModel trackScanQrModel = ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                trackScanQrModel.initRecordTimeStamp = TrackScanQrModel.BuiltInFictitiousFunctionClassFactory(trackScanQrModel.newProxyInstance);
                ScannerFragment.DatabaseTableConfigUtil(ScannerFragment.this);
                ScannerFragment scannerFragment = ScannerFragment.this;
                scannerFragment.getAuthRequestContext(str, scannerFragment.getErrorConfigVersion, Boolean.TRUE);
            }

            @Override // id.dana.contract.staticqr.DecodeQrImageContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3, Throwable th) {
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(ScannerFragment.this.getContext(), str2, str3, str, th);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
                ScannerFragment.this.BuiltInFictitiousFunctionClassFactory(true);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
                ScannerFragment.this.BuiltInFictitiousFunctionClassFactory(false);
                ScannerFragment.this.scheduleImpl();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
                ScannerFragment.DatabaseTableConfigUtil(ScannerFragment.this);
                ScannerFragment.this.BuiltInFictitiousFunctionClassFactory(false);
                ScannerFragment.this.PlaceComponentResult(false);
                ScannerFragment.this.getAuthRequestContext(str, false);
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.moveToNextValue = TrackerKey.ScannerAction.DECODE_CODE_GALLERY_ERROR;
                ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda6();
            }
        }));
        MyBillsEntityDataFactory2.scheduleImpl = (PlayStoreReviewModules) Preconditions.getAuthRequestContext(new PlayStoreReviewModules(new PlayStoreReviewContractView(getActivity()) { // from class: id.dana.scanner.ScannerFragment.9
            {
                ScannerFragment.this = this;
            }

            @Override // id.dana.playstorereview.PlayStoreReviewContractView, id.dana.playstorereview.PlayStoreReviewContract.View
            public final void BuiltInFictitiousFunctionClassFactory(AppReviewInfoModel appReviewInfoModel) {
                super.BuiltInFictitiousFunctionClassFactory(appReviewInfoModel);
                ScannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(ScannerFragment.this);
            }
        }));
        MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.scanner.ScannerFragment.8
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public void showProgress() {
            }

            {
                ScannerFragment.this = this;
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                ScannerFragment.this.FragmentBottomSheetPaymentSettingBinding = z;
                if (z) {
                    ScannerFragment.moveToNextValue(ScannerFragment.this);
                } else {
                    ScannerFragment.getErrorConfigVersion(ScannerFragment.this);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public void onError(String str) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append(" onErrorGetBottomSheetOnBoardingAvailability: ");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), str);
            }
        }));
        MyBillsEntityDataFactory2.lookAheadTest = (GlobalNetworkModule) Preconditions.getAuthRequestContext(new GlobalNetworkModule(new GlobalNetworkListener() { // from class: id.dana.scanner.ScannerFragment.7
            {
                ScannerFragment.this = this;
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String str, final boolean z, boolean z2) {
                DanaH5.startContainerFullUrl(str, new DanaH5Listener() { // from class: id.dana.scanner.ScannerFragment.7.1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public void onContainerCreated(Bundle bundle) {
                    }

                    {
                        AnonymousClass7.this = this;
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public void onContainerDestroyed(Bundle bundle) {
                        ScannerFragment.this.globalNetworkPresenter.get().MyBillsEntityDataFactory();
                        ScannerFragment.this.globalNetworkPresenter.get().getAuthRequestContext(z, null);
                        ScannerFragment.this.PlaceComponentResult(false);
                        ScannerFragment.lookAheadTest(ScannerFragment.this);
                    }
                });
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void MyBillsEntityDataFactory() {
                ScannerFragment.this.PlaceComponentResult(false);
                ScannerFragment.lookAheadTest(ScannerFragment.this);
                ((BaseActivity) ScannerFragment.this.getContext()).showToast(ScannerFragment.this.getString(R.string.general_error_msg));
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory(Throwable th) {
                ScannerFragment.this.PlaceComponentResult(false);
                ScannerFragment.lookAheadTest(ScannerFragment.this);
                ScannerFragment.this.getBaseActivity().showToast(ErrorUtil.PlaceComponentResult(th, ScannerFragment.this.getContext()));
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String str) {
                ScannerFragment.this.getBaseActivity().showWarningDialog(str);
                Intent intent = new Intent(ScannerFragment.this.getContext(), LocalConfigSplashActivity.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ScannerFragment.this.startActivity(intent);
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void getAuthRequestContext() {
                ScannerFragment scannerFragment = ScannerFragment.this;
                ScannerFragment.MyBillsEntityDataFactory(scannerFragment, scannerFragment.BuiltInFictitiousFunctionClassFactory(ScannerActionState.INVALID_QR_CODE));
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void PlaceComponentResult() {
                ScannerFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(ScannerFragment.this);
            }

            @Override // id.dana.globalnetwork.currency.GlobalNetworkListener, id.dana.globalnetwork.currency.GlobalNetworkContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ScannerFragment.this.getBaseActivity().showWarningDialog(ScannerFragment.this.getString(R.string.cscanb_blacklist_warning_dialog));
                ScannerFragment.lookAheadTest(ScannerFragment.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda2, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.PlaceComponentResult, DecodeQrImageModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.getAuthRequestContext, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.getErrorConfigVersion, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.moveToNextValue, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0, OauthModule.class);
        if (MyBillsEntityDataFactory2.DatabaseTableConfigUtil == null) {
            MyBillsEntityDataFactory2.DatabaseTableConfigUtil = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.scheduleImpl, PlayStoreReviewModules.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory, CheckoutH5EventModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.lookAheadTest, GlobalNetworkModule.class);
        if (MyBillsEntityDataFactory2.GetContactSyncConfig == null) {
            MyBillsEntityDataFactory2.GetContactSyncConfig = new ScanQrAnalyticModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2.MyBillsEntityDataFactory, ApplicationComponent.class);
        DaggerScannerComponent.ScannerComponentImpl scannerComponentImpl = new DaggerScannerComponent.ScannerComponentImpl(MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda2, MyBillsEntityDataFactory2.PlaceComponentResult, MyBillsEntityDataFactory2.getAuthRequestContext, MyBillsEntityDataFactory2.getErrorConfigVersion, MyBillsEntityDataFactory2.moveToNextValue, MyBillsEntityDataFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0, MyBillsEntityDataFactory2.DatabaseTableConfigUtil, MyBillsEntityDataFactory2.scheduleImpl, MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory2.lookAheadTest, MyBillsEntityDataFactory2.GetContactSyncConfig, MyBillsEntityDataFactory2.MyBillsEntityDataFactory, (byte) 0);
        this.GetContactSyncConfig = scannerComponentImpl;
        scannerComponentImpl.MyBillsEntityDataFactory(this);
        registerPresenter(this.decodePresenter);
        if (getContext() != null) {
            if (!PermissionHelper.MyBillsEntityDataFactory(getContext(), "android.permission.CAMERA")) {
                this.initRecordTimeStamp.check();
            } else {
                PrepareContext();
            }
        }
    }

    public final /* synthetic */ void getAuthRequestContext(ActivityResult activityResult) {
        if (activityResult.MyBillsEntityDataFactory != null) {
            final Uri data = activityResult.MyBillsEntityDataFactory.getData();
            PlaceComponentResult(true);
            GlideApp.KClassImpl$Data$declaredNonStaticMembers$2(this).MyBillsEntityDataFactory(data).PlaceComponentResult((int) R.drawable.res_0x7f080891_networkuserentitydata_externalsyntheticlambda7).PlaceComponentResult(new RequestListener<Drawable>() { // from class: id.dana.scanner.ScannerFragment.1
                @Override // com.bumptech.glide.request.RequestListener
                public boolean onLoadFailed(GlideException glideException, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, boolean z) {
                    return false;
                }

                {
                    ScannerFragment.this = this;
                }

                @Override // com.bumptech.glide.request.RequestListener
                public /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, com.bumptech.glide.request.target.Target<Drawable> target, DataSource dataSource, boolean z) {
                    return MyBillsEntityDataFactory(drawable);
                }

                private boolean MyBillsEntityDataFactory(Drawable drawable) {
                    ScannerFragment.this.imgScanGallery.setImageDrawable(drawable);
                    ScannerFragment.this.BuiltInFictitiousFunctionClassFactory(true);
                    ScannerFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2.newProxyInstance = Long.valueOf(System.currentTimeMillis());
                    ScannerFragment.this.decodePresenter.PlaceComponentResult(data, ScannerFragment.this.KClassImpl$Data$declaredNonStaticMembers$2.getMeasuredWidth(), ScannerFragment.this.KClassImpl$Data$declaredNonStaticMembers$2.getMeasuredHeight());
                    ScannerFragment.PlaceComponentResult(ScannerFragment.this, "Gallery");
                    return false;
                }
            }).MyBillsEntityDataFactory(this.imgScanGallery);
        }
    }
}
