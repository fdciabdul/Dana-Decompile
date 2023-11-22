package id.dana.danah5.locationpicker;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.view.ComponentActivity;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import androidx.view.Transformations;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.util.OSUtil;
import id.dana.core.ui.util.connectivity.ConnectivityMonitorKt;
import id.dana.danah5.locationpicker.contract.MapPageContract;
import id.dana.danah5.locationpicker.model.MapPageResult;
import id.dana.databinding.ActivityMapPageBinding;
import id.dana.databinding.BottomSheetMapPageBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMapPageComponent;
import id.dana.di.modules.MapPageModule;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.globalsearch.model.LatLngKt;
import id.dana.extension.lang.StringExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.LocationUtil;
import id.dana.utils.MapHelper;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001hB\u0007¢\u0006\u0004\bg\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0007J\u000f\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u0007J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0007J\u000f\u0010\u001f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001f\u0010\u0007J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\u0007J\u000f\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b)\u0010\u0007J\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\u0007J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b+\u0010#J\u000f\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010\u0007J\u000f\u0010-\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010\u0007J\u000f\u0010.\u001a\u00020\u0005H\u0002¢\u0006\u0004\b.\u0010\u0007J\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0005H\u0002¢\u0006\u0004\b3\u0010\u0007J\u0017\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u0010\u0007J\u0019\u0010:\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b:\u0010\u000fJ\u0017\u0010;\u001a\u00020\u00052\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b;\u00107J\u0017\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\bH\u0002¢\u0006\u0004\b=\u0010\u000bJ\u0017\u0010>\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b>\u0010\u0013J\u000f\u0010?\u001a\u00020\u0005H\u0002¢\u0006\u0004\b?\u0010\u0007R\u001c\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u001e\u0010K\u001a\f\u0012\b\u0012\u0006*\u00020J0J0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010N\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010OR\u001b\u0010V\u001a\u00020Q8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020W8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\"\u0010[\u001a\u00020Z8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00100a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\be\u0010f"}, d2 = {"Lid/dana/danah5/locationpicker/MapPageActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityMapPageBinding;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "", "dismissSkeletonBottomSheet", "()V", "", "enable", "enableButtonAction", "(Z)V", "", "choice", "finishJSAPI", "(Ljava/lang/String;)V", "Landroid/location/Location;", "location", "getDetailLocation", "(Landroid/location/Location;)V", "getLatestSelectedLocationDetail", "Lid/dana/di/modules/MapPageModule;", "getMapPageModule", "()Lid/dana/di/modules/MapPageModule;", "getUserLocation", IAPSyncCommand.COMMAND_INIT, "initInjection", "initViewBinding", "()Lid/dana/databinding/ActivityMapPageBinding;", "observeSelectedLocation", "onBackPressed", "onDestroy", "Lcom/google/android/gms/maps/GoogleMap;", "maps", "onMapReady", "(Lcom/google/android/gms/maps/GoogleMap;)V", "Lcom/google/android/gms/maps/model/Marker;", "marker", "onMarkerClick", "(Lcom/google/android/gms/maps/model/Marker;)Z", "requestLocationService", "setDefaultLocation", "setupBottomSheet", "setupCameraListener", "setupLocation", "setupStatusBar", "setupView", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "request", "showDialogPermission", "(Lcom/anggrayudi/storage/permission/PermissionRequest;)V", "showErrorState", "Lid/dana/danah5/locationpicker/model/MapPageResult;", "result", "showFormattedAddress", "(Lid/dana/danah5/locationpicker/model/MapPageResult;)V", "showSkeletonBottomSheet", "errorMessage", "trackReverseGeocodeError", "updateDetailLocation", "centerToMyLocation", "updateMyCurrentLocation", "updateSelectedLocation", "watchMyLocation", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "bottomSheetSelectedLocation", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lid/dana/domain/globalsearch/model/LatLng;", "currentLocation", "Lid/dana/domain/globalsearch/model/LatLng;", "currentResult", "Lid/dana/danah5/locationpicker/model/MapPageResult;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Lio/reactivex/disposables/Disposable;", "locationRequestDisposable", "Lio/reactivex/disposables/Disposable;", "locationWatcherDisposable", "Lid/dana/utils/MapHelper;", "mapHelper$delegate", "Lkotlin/Lazy;", "getMapHelper", "()Lid/dana/utils/MapHelper;", "mapHelper", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "permissionRequest", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lid/dana/danah5/locationpicker/contract/MapPageContract$Presenter;", "presenter", "Lid/dana/danah5/locationpicker/contract/MapPageContract$Presenter;", "getPresenter", "()Lid/dana/danah5/locationpicker/contract/MapPageContract$Presenter;", "setPresenter", "(Lid/dana/danah5/locationpicker/contract/MapPageContract$Presenter;)V", "Landroidx/lifecycle/MutableLiveData;", "selectedLocationStream", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonBottomSheet", "Lcom/ethanhua/skeleton/SkeletonScreen;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MapPageActivity extends ViewBindingActivity<ActivityMapPageBinding> implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    public static final String INITIAL_LOCATION = "INITIAL LOCATION";
    public static final String KEY_CHOICE = "KEY_CHOICE";
    public static final String KEY_RESULT = "KEY_RESPONSE";
    private static final String OPERATION_TYPE_GET_DETAIL_LOCATION = "HERE Reverse Geocode";
    private static final long SELECT_LOCATION_DEBOUNCE_DURATION = 2000;
    private BottomSheetBehavior<FrameLayout> bottomSheetSelectedLocation;
    private MapPageResult currentResult;
    private final ActivityResultLauncher<IntentSenderRequest> launcher;
    private Disposable locationRequestDisposable;
    private Disposable locationWatcherDisposable;
    private final ActivityPermissionRequest permissionRequest;
    @Inject
    public MapPageContract.Presenter presenter;
    private SkeletonScreen skeletonBottomSheet;
    public static final byte[] $$a = {TarHeader.LF_CHR, -70, 75, 72, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 103;
    public static final byte[] getAuthRequestContext = {4, -87, 42, 65, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 183;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 269894883;
    private static final List<String> STREET_NAME_VARIANTS = CollectionsKt.listOf((Object[]) new String[]{"Jalan", "Jl", "Jln", "Jl.", "Jln."});
    private static String TAG = MapPageActivity.class.getName();
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: mapHelper$delegate  reason: from kotlin metadata */
    private final Lazy mapHelper = LazyKt.lazy(new Function0<MapHelper>() { // from class: id.dana.danah5.locationpicker.MapPageActivity$mapHelper$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MapHelper invoke() {
            return new MapHelper(MapPageActivity.this);
        }
    });
    private LatLng currentLocation = LatLng.INSTANCE.monas();
    private final MutableLiveData<Location> selectedLocationStream = new MutableLiveData<>();

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r8 = r8 + 97
            byte[] r0 = id.dana.danah5.locationpicker.MapPageActivity.getAuthRequestContext
            int r6 = r6 + 16
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L17:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.locationpicker.MapPageActivity.a(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = id.dana.danah5.locationpicker.MapPageActivity.$$a
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.locationpicker.MapPageActivity.c(int, int, short, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestLocationService$lambda-9  reason: not valid java name */
    public static final void m677requestLocationService$lambda9(Throwable th) {
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(false, Process.getGidForName("") + 298, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 15, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new char[]{'\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1, 15}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(true, 302 - Drawable.resolveOpacity(0, 0), 3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 5 - TextUtils.indexOf("", "", 0), new char[]{65517, 17, 5, 65532, 1}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getPressedStateDuration() >> 16) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(false, (Process.myTid() >> 22) + 269, (ViewConfiguration.getEdgeSlop() >> 16) + 23, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 48, new char[]{65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(false, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 264, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, 64 - Gravity.getAbsoluteGravity(0, 0), new char[]{Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(false, Color.red(0) + 266, ExpandableListView.getPackedPositionGroup(0L) + 23, 63 - TextUtils.lastIndexOf("", '0'), new char[]{Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(true, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 295, Color.argb(0, 0, 0, 0) + 38, 60 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f'}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(true, ExpandableListView.getPackedPositionGroup(0L) + 248, 2 - KeyEvent.normalizeMetaState(0), (ViewConfiguration.getEdgeSlop() >> 16) + 6, new char[]{65532, 7, 65535, 0, 65532, 2}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = {this};
                byte b = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                a(b, (byte) (b | 36), (byte) (-getAuthRequestContext[32]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr15 = new Object[1];
                a(b2, (byte) (b2 | Ascii.NAK), (byte) (getAuthRequestContext[30] + 1), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 55, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 3, (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr17 = new Object[1];
                        c((byte) (-$$a[12]), (byte) ($$a[47] - 1), $$a[47], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (Process.myPid() >> 22) + 15, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), 14 - ImageFormat.getBitsPerPixel(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getPressedStateDuration() >> 16), 29 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (MotionEvent.axisFromString("") + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 800, 15 - Color.red(0), (char) TextUtils.getOffsetBefore("", 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetAfter("", 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1874687425, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
                                        } catch (Throwable th3) {
                                            Throwable cause3 = th3.getCause();
                                            if (cause3 == null) {
                                                throw th3;
                                            }
                                            throw cause3;
                                        }
                                    } catch (Throwable th4) {
                                        Throwable cause4 = th4.getCause();
                                        if (cause4 == null) {
                                            throw th4;
                                        }
                                        throw cause4;
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr20 = {this};
                byte b3 = getAuthRequestContext[25];
                Object[] objArr21 = new Object[1];
                a(b3, (byte) (b3 | 36), (byte) (-getAuthRequestContext[32]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr22 = new Object[1];
                a(b4, (byte) (b4 | Ascii.NAK), (byte) (getAuthRequestContext[30] + 1), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getTrimmedLength(""), 46 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Color.red(0));
                        byte b5 = (byte) ($$a[47] - 1);
                        Object[] objArr24 = new Object[1];
                        c(b5, (byte) (b5 | Ascii.ETB), (byte) ($$a[47] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, Color.rgb(0, 0, 0) + 16777251, (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1874687425, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) (Process.myTid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr27 = {this};
                byte b6 = getAuthRequestContext[25];
                Object[] objArr28 = new Object[1];
                a(b6, (byte) (b6 | 36), (byte) (-getAuthRequestContext[32]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b7 = getAuthRequestContext[25];
                Object[] objArr29 = new Object[1];
                a(b7, (byte) (b7 | Ascii.NAK), (byte) (getAuthRequestContext[30] + 1), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 118, 3 - (ViewConfiguration.getTapTimeout() >> 16), (char) (38969 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        byte b8 = (byte) ($$a[47] - 1);
                        Object[] objArr31 = new Object[1];
                        c(b8, (byte) (b8 | Ascii.ETB), (byte) ($$a[47] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1874687425, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.getTrimmedLength("") + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr34 = {this};
                byte b9 = getAuthRequestContext[25];
                Object[] objArr35 = new Object[1];
                a(b9, (byte) (b9 | 36), (byte) (-getAuthRequestContext[32]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b10 = getAuthRequestContext[25];
                Object[] objArr36 = new Object[1];
                a(b10, (byte) (b10 | Ascii.NAK), (byte) (getAuthRequestContext[30] + 1), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.getDefaultSize(0, 0), 3 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        Object[] objArr38 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) (-$$a[8]), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1874687425, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        b(false, super.getResources().getString(R.string.loyalty_tooltip_title).substring(1, 2).codePointAt(0) + 186, getPackageName().length() + 7, super.getResources().getString(R.string.tooltip_split_bill_title).substring(1, 3).codePointAt(0) - 90, new char[]{'\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0, 2, 16, 16, 65534, 11, 1, 15}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        try {
            Object[] objArr2 = new Object[1];
            a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], objArr3);
            int i = ((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 269;
            int scrollBarFadeDuration = (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3;
            try {
                Object[] objArr4 = new Object[1];
                a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], new Object[1]);
                Object[] objArr5 = new Object[1];
                b(true, i, scrollBarFadeDuration, ((ApplicationInfo) cls3.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 28, new char[]{65517, 17, 5, 65532, 1}, objArr5);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        int length = super.getResources().getString(R.string.merchant_highlighted_review_label).substring(6, 7).length() + 296;
                        try {
                            Object[] objArr6 = new Object[1];
                            a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], new Object[1]);
                            Object[] objArr7 = new Object[1];
                            b(true, length, ((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 28, ImageFormat.getBitsPerPixel(0) + 27, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, objArr7);
                            Class<?> cls5 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            b(false, super.getResources().getString(R.string.res_0x7f1313a0_securitysettingsactivity_createpinlauncher_2_1).substring(5, 6).codePointAt(0) + 207, super.getResources().getString(R.string.later).substring(1, 2).length() + 16, super.getResources().getString(R.string.powered_by).substring(0, 10).codePointAt(8) - 80, new char[]{11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529}, objArr8);
                            baseContext = (Context) cls5.getMethod((String) objArr8[0], new Class[0]).invoke(null, null);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            int length2 = getPackageName().length() + 262;
                            int codePointAt = getPackageName().codePointAt(3) - 77;
                            try {
                                Object[] objArr9 = new Object[1];
                                a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr9);
                                Class<?> cls6 = Class.forName((String) objArr9[0]);
                                Object[] objArr10 = new Object[1];
                                a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], objArr10);
                                Object[] objArr11 = new Object[1];
                                b(false, length2, codePointAt, ((ApplicationInfo) cls6.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29}, objArr11);
                                String str = (String) objArr11[0];
                                Object[] objArr12 = new Object[1];
                                b(false, TextUtils.getTrimmedLength("") + 264, getPackageName().length() + 28, 64 - (Process.myTid() >> 22), new char[]{Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar, 65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526}, objArr12);
                                String str2 = (String) objArr12[0];
                                try {
                                    Object[] objArr13 = new Object[1];
                                    a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr13);
                                    Class<?> cls7 = Class.forName((String) objArr13[0]);
                                    Object[] objArr14 = new Object[1];
                                    a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], objArr14);
                                    int i2 = ((ApplicationInfo) cls7.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 233;
                                    int length3 = super.getResources().getString(R.string.go_upgrade_now).substring(10, 11).length() + 22;
                                    try {
                                        Object[] objArr15 = new Object[1];
                                        a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr15);
                                        Class<?> cls8 = Class.forName((String) objArr15[0]);
                                        Object[] objArr16 = new Object[1];
                                        a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], objArr16);
                                        Object[] objArr17 = new Object[1];
                                        b(false, i2, length3, ((ApplicationInfo) cls8.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31, '!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524}, objArr17);
                                        String str3 = (String) objArr17[0];
                                        Object[] objArr18 = new Object[1];
                                        b(true, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 295, TextUtils.lastIndexOf("", '0', 0) + 39, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 61, new char[]{14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f'}, objArr18);
                                        String str4 = (String) objArr18[0];
                                        Object[] objArr19 = new Object[1];
                                        b(true, super.getResources().getString(R.string.unsafe_device_tamper_image_description).substring(6, 7).length() + 247, super.getResources().getString(R.string.add_new_bills_first_onboarding_subtitle).substring(1, 2).codePointAt(0) - 99, super.getResources().getString(R.string.pushverify_list_empty_title).substring(5, 6).codePointAt(0) - 26, new char[]{65532, 7, 65535, 0, 65532, 2}, objArr19);
                                        try {
                                            Object[] objArr20 = {baseContext, str, str2, str3, str4, true, (String) objArr19[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr20);
                                        } catch (Throwable th2) {
                                            Throwable cause2 = th2.getCause();
                                            if (cause2 == null) {
                                                throw th2;
                                            }
                                            throw cause2;
                                        }
                                    } catch (Throwable th3) {
                                        Throwable cause3 = th3.getCause();
                                        if (cause3 == null) {
                                            throw th3;
                                        }
                                        throw cause3;
                                    }
                                } catch (Throwable th4) {
                                    Throwable cause4 = th4.getCause();
                                    if (cause4 == null) {
                                        throw th4;
                                    }
                                    throw cause4;
                                }
                            } catch (Throwable th5) {
                                Throwable cause5 = th5.getCause();
                                if (cause5 == null) {
                                    throw th5;
                                }
                                throw cause5;
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    }
                }
                try {
                    byte b = getAuthRequestContext[25];
                    Object[] objArr21 = new Object[1];
                    a(b, (byte) (b | 36), (byte) (-getAuthRequestContext[32]), objArr21);
                    Class<?> cls9 = Class.forName((String) objArr21[0]);
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr22 = new Object[1];
                    a(b2, (byte) (b2 | Ascii.NAK), (byte) (getAuthRequestContext[30] + 1), objArr22);
                    try {
                        Object[] objArr23 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr22[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - KeyEvent.keyCodeFromString(""), 4 - TextUtils.getOffsetAfter("", 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')));
                            Object[] objArr24 = new Object[1];
                            c((byte) (-$$a[9]), (byte) (-$$a[53]), (byte) (-$$a[8]), objArr24);
                            obj3 = cls10.getMethod((String) objArr24[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr25 = (Object[]) ((Method) obj3).invoke(null, objArr23);
                        int i3 = ((int[]) objArr25[1])[0];
                        if (((int[]) objArr25[0])[0] != i3) {
                            long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 == null) {
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(null, null);
                                try {
                                    Object[] objArr26 = {-1552788252, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr26);
                                } catch (Throwable th7) {
                                    Throwable cause7 = th7.getCause();
                                    if (cause7 == null) {
                                        throw th7;
                                    }
                                    throw cause7;
                                }
                            } catch (Throwable th8) {
                                Throwable cause8 = th8.getCause();
                                if (cause8 == null) {
                                    throw th8;
                                }
                                throw cause8;
                            }
                        }
                        super.onCreate(bundle);
                    } catch (Throwable th9) {
                        Throwable cause9 = th9.getCause();
                        if (cause9 == null) {
                            throw th9;
                        }
                        throw cause9;
                    }
                } catch (Throwable th10) {
                    Throwable cause10 = th10.getCause();
                    if (cause10 == null) {
                        throw th10;
                    }
                    throw cause10;
                }
            } catch (Throwable th11) {
                Throwable cause11 = th11.getCause();
                if (cause11 == null) {
                    throw th11;
                }
                throw cause11;
            }
        } catch (Throwable th12) {
            Throwable cause12 = th12.getCause();
            if (cause12 == null) {
                throw th12;
            }
            throw cause12;
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public final boolean onMarkerClick(Marker marker) {
        Intrinsics.checkNotNullParameter(marker, "");
        return true;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = getPackageName().codePointAt(5) + 187;
            try {
                Object[] objArr = new Object[1];
                a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(true, codePointAt, ((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 28, super.getResources().getString(R.string.empty_state_bank_cards_desc).substring(13, 14).length() + 25, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(false, super.getResources().getString(R.string.help).substring(0, 3).length() + 301, (ViewConfiguration.getWindowTouchSlop() >> 8) + 17, (ViewConfiguration.getPressedStateDuration() >> 16) + 18, new char[]{11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Drawable.resolveOpacity(0, 0), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, 18 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        super.onPause();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = super.getResources().getString(R.string.success_brizzi_activated_balance).substring(24, 26).codePointAt(0) + 182;
            int codePointAt2 = super.getResources().getString(R.string.installment_month).substring(0, 3).codePointAt(0) - 32;
            try {
                Object[] objArr = new Object[1];
                a(getAuthRequestContext[30], getAuthRequestContext[7], getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), getAuthRequestContext[5], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(true, codePointAt, codePointAt2, ((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{'\f', 15, 1, 11, 65534, 1, 65534, 2, 15, 5, 65521, 22, 17, 6, 19, 6, 17, 0, 65502, 65483, '\r', '\r', 65534, 65483, 1, 6}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(false, (KeyEvent.getMaxKeyCode() >> 16) + SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 16, 17 - ExpandableListView.getPackedPositionChild(0L), new char[]{11, '\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), ImageFormat.getBitsPerPixel(0) + 19, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        super.onResume();
    }

    public MapPageActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.danah5.locationpicker.MapPageActivity$permissionRequest$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                Intrinsics.checkNotNullParameter(result, "");
                boolean MyBillsEntityDataFactory = result.MyBillsEntityDataFactory();
                if (!MyBillsEntityDataFactory) {
                    MapPageActivity.this.setDefaultLocation();
                } else if (LocationUtil.getAuthRequestContext(MapPageActivity.this.getBaseContext())) {
                    MapPageActivity.this.watchMyLocation();
                } else {
                    MapPageActivity.this.requestLocationService();
                }
                if (fromSystemDialog) {
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(MapPageActivity.this.getApplicationContext(), MyBillsEntityDataFactory);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> blockedPermissions) {
                Intrinsics.checkNotNullParameter(blockedPermissions, "");
                PermissionHelper.MyBillsEntityDataFactory(MapPageActivity.this);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest request) {
                Intrinsics.checkNotNullParameter(request, "");
                MapPageActivity.this.showDialogPermission(request);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.permissionRequest = builder.PlaceComponentResult();
        ActivityResultLauncher<IntentSenderRequest> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MapPageActivity.m674launcher$lambda10(MapPageActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.launcher = registerForActivityResult;
    }

    @JvmName(name = "getPresenter")
    public final MapPageContract.Presenter getPresenter() {
        MapPageContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MapPageContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getMapHelper")
    private final MapHelper getMapHelper() {
        return (MapHelper) this.mapHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityMapPageBinding initViewBinding() {
        ActivityMapPageBinding BuiltInFictitiousFunctionClassFactory = ActivityMapPageBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        initInjection();
        registerPresenter(getPresenter());
        setupView();
        setupBottomSheet();
        setupStatusBar();
        observeSelectedLocation();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        finishJSAPI("CANCEL");
    }

    private final void initInjection() {
        DaggerMapPageComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMapPageComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (MapPageModule) Preconditions.getAuthRequestContext(getMapPageModule());
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, MapPageModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerMapPageComponent.MapPageComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
    }

    private final MapPageModule getMapPageModule() {
        return new MapPageModule(new MapPageContract.View() { // from class: id.dana.danah5.locationpicker.MapPageActivity$getMapPageModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                MapPageActivity.this.showSkeletonBottomSheet();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                MapPageActivity.this.dismissSkeletonBottomSheet();
            }

            @Override // id.dana.danah5.locationpicker.contract.MapPageContract.View
            public final void onGetDetailLocationSuccess(MapPageResult result) {
                Intrinsics.checkNotNullParameter(result, "");
                MapPageActivity.this.updateDetailLocation(result);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String errorMessage) {
                MapPageActivity.this.trackReverseGeocodeError(errorMessage);
                MapPageActivity.this.showErrorState();
            }
        });
    }

    private final void setupView() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.mapContainer);
        SupportMapFragment supportMapFragment = findFragmentById instanceof SupportMapFragment ? (SupportMapFragment) findFragmentById : null;
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
        ActivityMapPageBinding binding = getBinding();
        binding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapPageActivity.m679setupView$lambda4$lambda0(MapPageActivity.this, view);
            }
        });
        binding.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapPageActivity.m680setupView$lambda4$lambda1(MapPageActivity.this, view);
            }
        });
        binding.PlaceComponentResult.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapPageActivity.m681setupView$lambda4$lambda2(MapPageActivity.this, view);
            }
        });
        AppCompatImageView appCompatImageView = binding.PlaceComponentResult.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
        binding.PlaceComponentResult.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapPageActivity.m682setupView$lambda4$lambda3(MapPageActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupView$lambda-4$lambda-0  reason: not valid java name */
    public static final void m679setupView$lambda4$lambda0(MapPageActivity mapPageActivity, View view) {
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        mapPageActivity.getUserLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupView$lambda-4$lambda-1  reason: not valid java name */
    public static final void m680setupView$lambda4$lambda1(MapPageActivity mapPageActivity, View view) {
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        mapPageActivity.finishJSAPI("CHOOSE_ANOTHER_ADDRESS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupView$lambda-4$lambda-2  reason: not valid java name */
    public static final void m681setupView$lambda4$lambda2(MapPageActivity mapPageActivity, View view) {
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        mapPageActivity.finishJSAPI("CHOOSE_THIS_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m682setupView$lambda4$lambda3(MapPageActivity mapPageActivity, View view) {
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        mapPageActivity.getLatestSelectedLocationDetail();
    }

    private final void setupBottomSheet() {
        BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(getBinding().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
        from.setHideable(false);
        from.setPeekHeight(ViewExtKt.PlaceComponentResult(48.0f));
        from.setState(3);
        Intrinsics.checkNotNullExpressionValue(from, "");
        this.bottomSheetSelectedLocation = from;
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public final void onMapReady(GoogleMap maps) {
        Intrinsics.checkNotNullParameter(maps, "");
        getMapHelper().MyBillsEntityDataFactory(maps, this);
        setupCameraListener(maps);
        setupLocation();
    }

    private final void setupLocation() {
        Parcelable parcelable;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "");
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.PlaceComponentResult()) {
            parcelable = (Parcelable) intent.getParcelableExtra(INITIAL_LOCATION, LatLng.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra(INITIAL_LOCATION);
            if (!(parcelableExtra instanceof LatLng)) {
                parcelableExtra = null;
            }
            parcelable = (LatLng) parcelableExtra;
        }
        LatLng latLng = (LatLng) parcelable;
        LatLng monas = latLng == null ? LatLng.INSTANCE.monas() : latLng;
        MapHelper mapHelper = getMapHelper();
        com.google.android.gms.maps.model.LatLng googleLatLng = monas.toGoogleLatLng();
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            googleMap.animateCamera(MapHelper.getAuthRequestContext(googleLatLng, 15.0f));
        }
        if (latLng == null) {
            getUserLocation();
        }
    }

    private final void getUserLocation() {
        this.permissionRequest.check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void watchMyLocation() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Disposable disposable = this.locationWatcherDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.locationWatcherDisposable = new LocationUtil.LocationRequestBuilder(getApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapPageActivity.m683watchMyLocation$lambda6(MapPageActivity.this, booleanRef, (Location) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: watchMyLocation$lambda-6  reason: not valid java name */
    public static final void m683watchMyLocation$lambda6(MapPageActivity mapPageActivity, Ref.BooleanRef booleanRef, Location location) {
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullExpressionValue(location, "");
        mapPageActivity.currentLocation = LatLngKt.toLatLng(location);
        mapPageActivity.updateMyCurrentLocation(booleanRef.element);
        booleanRef.element = false;
    }

    private final void updateMyCurrentLocation(boolean centerToMyLocation) {
        LatLng latLng = this.currentLocation;
        if (latLng == null || !centerToMyLocation) {
            return;
        }
        MapHelper mapHelper = getMapHelper();
        com.google.android.gms.maps.model.LatLng googleLatLng = latLng.toGoogleLatLng();
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            googleMap.animateCamera(MapHelper.getAuthRequestContext(googleLatLng, 15.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLocationService() {
        LocationRequest numUpdates = LocationRequest.create().setPriority(102).setNumUpdates(1);
        Intrinsics.checkNotNullExpressionValue(numUpdates, "");
        LocationSettingsRequest build = new LocationSettingsRequest.Builder().addLocationRequest(numUpdates).setAlwaysShow(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        Disposable disposable = this.locationRequestDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.locationRequestDisposable = new ReactiveLocationProvider(this).BuiltInFictitiousFunctionClassFactory(build).subscribe(new Consumer() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapPageActivity.m676requestLocationService$lambda8(MapPageActivity.this, (LocationSettingsResult) obj);
            }
        }, new Consumer() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MapPageActivity.m677requestLocationService$lambda9((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestLocationService$lambda-8  reason: not valid java name */
    public static final void m676requestLocationService$lambda8(MapPageActivity mapPageActivity, LocationSettingsResult locationSettingsResult) {
        PendingIntent resolution;
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
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
                    ActivityResultLauncher<IntentSenderRequest> activityResultLauncher = mapPageActivity.launcher;
                    IntentSenderRequest.Builder builder = new IntentSenderRequest.Builder(intentSender);
                    activityResultLauncher.MyBillsEntityDataFactory(new IntentSenderRequest(builder.PlaceComponentResult, builder.MyBillsEntityDataFactory, builder.BuiltInFictitiousFunctionClassFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2), null);
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDefaultLocation() {
        LatLng monas = LatLng.INSTANCE.monas();
        this.currentLocation = monas;
        if (monas != null) {
            MapHelper mapHelper = getMapHelper();
            com.google.android.gms.maps.model.LatLng googleLatLng = monas.toGoogleLatLng();
            GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
            if (googleMap != null) {
                googleMap.animateCamera(MapHelper.getAuthRequestContext(googleLatLng, 15.0f));
            }
        }
    }

    private final void setupCameraListener(GoogleMap maps) {
        maps.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void onCameraIdle() {
                MapPageActivity.m678setupCameraListener$lambda13(MapPageActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupCameraListener$lambda-13  reason: not valid java name */
    public static final void m678setupCameraListener$lambda13(MapPageActivity mapPageActivity) {
        Location location;
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        GoogleMap googleMap = mapPageActivity.getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            com.google.android.gms.maps.model.LatLng latLng = googleMap.getCameraPosition().target;
            location = LocationUtil.PlaceComponentResult(latLng.latitude, latLng.longitude);
        } else {
            location = null;
        }
        if (location != null) {
            mapPageActivity.updateSelectedLocation(location);
        }
    }

    private final void finishJSAPI(String choice) {
        Intent intent = new Intent();
        intent.putExtra(KEY_CHOICE, choice);
        intent.putExtra(KEY_RESULT, this.currentResult);
        setResult(-1, intent);
        finish();
    }

    private final void observeSelectedLocation() {
        LiveData KClassImpl$Data$declaredNonStaticMembers$2 = Transformations.KClassImpl$Data$declaredNonStaticMembers$2(this.selectedLocationStream);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        ConnectivityMonitorKt.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, (long) SELECT_LOCATION_DEBOUNCE_DURATION).PlaceComponentResult(this, new Observer() { // from class: id.dana.danah5.locationpicker.MapPageActivity$$ExternalSyntheticLambda2
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                MapPageActivity.m675observeSelectedLocation$lambda15(MapPageActivity.this, (Location) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeSelectedLocation$lambda-15  reason: not valid java name */
    public static final void m675observeSelectedLocation$lambda15(MapPageActivity mapPageActivity, Location location) {
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        Intrinsics.checkNotNullExpressionValue(location, "");
        mapPageActivity.getDetailLocation(location);
    }

    private final void getLatestSelectedLocationDetail() {
        Object obj = this.selectedLocationStream.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        Location location = (Location) obj;
        if (location != null) {
            getDetailLocation(location);
        }
    }

    private final void updateSelectedLocation(Location location) {
        this.selectedLocationStream.BuiltInFictitiousFunctionClassFactory((MutableLiveData<Location>) location);
    }

    private final void getDetailLocation(Location location) {
        if (MapPageActivityKt.isMonas(location)) {
            updateDetailLocation(MapPageResult.INSTANCE.monas());
        } else {
            getPresenter().getDetailLocation(location);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSkeletonBottomSheet() {
        AppCompatImageView appCompatImageView = getBinding().PlaceComponentResult.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.bottomSheetSelectedLocation;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(3);
        SkeletonScreen skeletonScreen = this.skeletonBottomSheet;
        byte b = 0;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().PlaceComponentResult.moveToNextValue);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_map_page;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            this.skeletonBottomSheet = viewSkeletonScreen;
        } else if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
        enableButtonAction(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissSkeletonBottomSheet() {
        SkeletonScreen skeletonScreen = this.skeletonBottomSheet;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        enableButtonAction(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDetailLocation(MapPageResult result) {
        this.currentResult = result;
        showFormattedAddress(result);
    }

    private final void showFormattedAddress(MapPageResult result) {
        boolean BuiltInFictitiousFunctionClassFactory;
        String format;
        BuiltInFictitiousFunctionClassFactory = StringExtKt.BuiltInFictitiousFunctionClassFactory(result.getStreetName(), STREET_NAME_VARIANTS);
        if (BuiltInFictitiousFunctionClassFactory) {
            format = result.getStreetName();
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.map_page_address_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            format = String.format(string, Arrays.copyOf(new Object[]{result.getStreetName()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.map_page_address_description);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{result.getDistrictName(), result.getSubdistrictName(), result.getPostalCode()}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        BottomSheetMapPageBinding bottomSheetMapPageBinding = getBinding().PlaceComponentResult;
        bottomSheetMapPageBinding.getAuthRequestContext.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.ic_location_small_blue));
        bottomSheetMapPageBinding.scheduleImpl.setText(format);
        bottomSheetMapPageBinding.lookAheadTest.setText(format2);
        AppCompatImageView appCompatImageView = bottomSheetMapPageBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
    }

    private final void enableButtonAction(boolean enable) {
        getBinding().PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setEnabled(enable);
        getBinding().PlaceComponentResult.MyBillsEntityDataFactory.setEnabled(enable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialogPermission(final PermissionRequest request) {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = getString(R.string.map_page_dialog_permission_title);
        builder.GetContactSyncConfig = getString(R.string.map_page_dialog_permission_description);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_location_small_blue;
        builder.moveToNextValue = 0L;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(getString(R.string.map_page_dialog_permission_allow), new Function1<View, Unit>() { // from class: id.dana.danah5.locationpicker.MapPageActivity$showDialogPermission$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                PermissionRequest.this.continueToPermissionRequest();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(getString(R.string.map_page_dialog_permission_reject), new Function1<View, Unit>() { // from class: id.dana.danah5.locationpicker.MapPageActivity$showDialogPermission$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        });
        id.dana.component.extension.ViewExtKt.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(), KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue);
    }

    private final void setupStatusBar() {
        getWindow().setFlags(512, 512);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackReverseGeocodeError(String errorMessage) {
        String string = getString(R.string.map_page_general_error_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        MixPanelTracker.BuiltInFictitiousFunctionClassFactory(this, OPERATION_TYPE_GET_DETAIL_LOCATION, errorMessage == null ? "" : errorMessage, string, "JSAPI", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorState() {
        BottomSheetMapPageBinding bottomSheetMapPageBinding = getBinding().PlaceComponentResult;
        bottomSheetMapPageBinding.getAuthRequestContext.setImageDrawable(ContextCompat.PlaceComponentResult(this, (int) R.drawable.ic_warning_24));
        bottomSheetMapPageBinding.scheduleImpl.setText(getString(R.string.map_page_general_error_title));
        bottomSheetMapPageBinding.lookAheadTest.setText(getString(R.string.map_page_general_error_description));
        AppCompatImageView appCompatImageView = bottomSheetMapPageBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        bottomSheetMapPageBinding.MyBillsEntityDataFactory.setEnabled(false);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        Disposable disposable = this.locationWatcherDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.locationRequestDisposable;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: launcher$lambda-10  reason: not valid java name */
    public static final void m674launcher$lambda10(MapPageActivity mapPageActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(mapPageActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            mapPageActivity.watchMyLocation();
        }
    }

    private static void b(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (a2.MyBillsEntityDataFactory < i3) {
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (a2.MyBillsEntityDataFactory < i3) {
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
