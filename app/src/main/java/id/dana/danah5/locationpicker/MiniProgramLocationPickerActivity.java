package id.dana.danah5.locationpicker;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.IntentSenderRequest;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda1;
import id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNearbyMerchantLocationComponent;
import id.dana.di.modules.NearbyMerchantLocationSearchModule;
import id.dana.domain.globalsearch.model.LatLng;
import id.dana.domain.globalsearch.model.LatLngKt;
import id.dana.domain.miniprogram.model.Address;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.extension.ContextExtKt;
import id.dana.extension.view.ActivityExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.DanaMapFragment;
import id.dana.nearbyme.adapter.NearbyDividerItemDecoration;
import id.dana.nearbyme.adapter.NearbyLocationResultAdapter;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.PinMapLottieAnimationView;
import id.dana.richview.SearchView;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.LocationUtil;
import id.dana.utils.MapHelper;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 n2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004onpqB\u0007¢\u0006\u0004\bm\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\nJ\u0017\u0010&\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b&\u0010\u0015J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\nJ\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\nJ\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\nJ\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\nJ\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\nJ\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\nJ\u001d\u00104\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0018H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\nR\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b;\u0010<R\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u00188CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001e\u0010J\u001a\f\u0012\b\u0012\u0006*\u00020I0I0H8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010T\u001a\u00020S8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0018\u0010Z\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010]\u001a\u00020\\8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bl\u0010k"}, d2 = {"Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity;", "Lid/dana/base/BaseActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "Lid/dana/domain/miniprogram/model/Address;", "geocode", "", "assembleReverseGeocodeOnBottomSheet", "(Lid/dana/domain/miniprogram/model/Address;)V", "configToolbar", "()V", "dismissSkeletonBottomSheet", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "injectComponent", "onDestroy", "Lcom/google/android/gms/maps/GoogleMap;", "maps", "onMapReady", "(Lcom/google/android/gms/maps/GoogleMap;)V", "Lcom/google/android/gms/maps/model/Marker;", "marker", "", "onMarkerClick", "(Lcom/google/android/gms/maps/model/Marker;)Z", "pullOutPinMap", "putDownPinMap", "requestLocationService", "Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$BottomSheetSelectedLocationState;", "state", "setBottomSheetSelectedLocationState", "(Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$BottomSheetSelectedLocationState;)V", "Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$SearchLocationState;", "setSearchLocationState", "(Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$SearchLocationState;)V", "setupBottomSheet", "setupCameraListener", "setupMaps", "setupMotionLayout", "setupRecyclerView", "setupSearchView", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "request", "showDialogPermission", "(Lcom/anggrayudi/storage/permission/PermissionRequest;)V", "showSkeletonBottomSheet", "showSkeletonLocationList", "", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "nearbyLocations", "updateLocationData", "(Ljava/util/List;)V", "centerToMyLocation", "updateMyCurrentLocationMarker", "(Z)V", "watchMyLocation", "Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter;", "adapter", "Lid/dana/nearbyme/adapter/NearbyLocationResultAdapter;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "bottomSheetSelectedLocation", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lid/dana/domain/globalsearch/model/LatLng;", "currentLocation", "Lid/dana/domain/globalsearch/model/LatLng;", "flagFromPullOutPinMap", "Ljava/lang/Boolean;", "isPutDownPinMap", "()Z", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Lio/reactivex/disposables/Disposable;", "locationRequestDisposable", "Lio/reactivex/disposables/Disposable;", "locationWatcherDisposable", "Lid/dana/nearbyme/DanaMapFragment;", MiniProgramLocationPickerActivity.TAG_MAP_FRAGMENT, "Lid/dana/nearbyme/DanaMapFragment;", "Lid/dana/utils/MapHelper;", "mapHelper", "Lid/dana/utils/MapHelper;", "getMapHelper", "()Lid/dana/utils/MapHelper;", "setMapHelper", "(Lid/dana/utils/MapHelper;)V", "myLocationMarker", "Lcom/google/android/gms/maps/model/Marker;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "permissionRequest", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchPresenter;", "presenter", "Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchPresenter;", "getPresenter", "()Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchPresenter;", "setPresenter", "(Lid/dana/contract/nearbyme/NearbyMerchantLocationSearchPresenter;)V", "Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$Place;", "selectedPlace", "Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$Place;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonBottomSheet", "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonLocationList", "<init>", "Companion", "BottomSheetSelectedLocationState", "Place", "SearchLocationState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MiniProgramLocationPickerActivity extends BaseActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    public static final String EXTRA_APP_NAME = "appName";
    public static final String EXTRA_INITIAL_LOCATION = "initialLocation";
    public static final String EXTRA_LOCATION_RESULT = "result";
    private static final String TAG_MAP_FRAGMENT = "mapFragment";
    private static long lookAheadTest;
    private NearbyLocationResultAdapter adapter;
    private BottomSheetBehavior<FrameLayout> bottomSheetSelectedLocation;
    private Boolean flagFromPullOutPinMap;
    private final ActivityResultLauncher<IntentSenderRequest> launcher;
    private Disposable locationRequestDisposable;
    private Disposable locationWatcherDisposable;
    private DanaMapFragment mapFragment;
    @Inject
    public MapHelper mapHelper;
    private Marker myLocationMarker;
    private final ActivityPermissionRequest permissionRequest;
    @Inject
    public NearbyMerchantLocationSearchPresenter presenter;
    private Place selectedPlace;
    private SkeletonScreen skeletonBottomSheet;
    private SkeletonScreen skeletonLocationList;
    public static final byte[] $$a = {Ascii.EM, -104, -116, 103, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 204;
    public static final byte[] PlaceComponentResult = {68, -4, -93, 76, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 223;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private LatLng currentLocation = LatLng.INSTANCE.monas();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$BottomSheetSelectedLocationState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "ERROR", "SUCCESS"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public enum BottomSheetSelectedLocationState {
        LOADING,
        ERROR,
        SUCCESS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b"}, d2 = {"Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$SearchLocationState;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY_KEYWORD", "SEARCHING", "SEARCH_ERROR", "SEARCH_EMPTY_RESULT", "SEARCH_RESULT_FOUND"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public enum SearchLocationState {
        EMPTY_KEYWORD,
        SEARCHING,
        SEARCH_ERROR,
        SEARCH_EMPTY_RESULT,
        SEARCH_RESULT_FOUND
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BottomSheetSelectedLocationState.values().length];
            iArr[BottomSheetSelectedLocationState.LOADING.ordinal()] = 1;
            iArr[BottomSheetSelectedLocationState.ERROR.ordinal()] = 2;
            iArr[BottomSheetSelectedLocationState.SUCCESS.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SearchLocationState.values().length];
            iArr2[SearchLocationState.SEARCHING.ordinal()] = 1;
            iArr2[SearchLocationState.EMPTY_KEYWORD.ordinal()] = 2;
            iArr2[SearchLocationState.SEARCH_EMPTY_RESULT.ordinal()] = 3;
            iArr2[SearchLocationState.SEARCH_ERROR.ordinal()] = 4;
            iArr2[SearchLocationState.SEARCH_RESULT_FOUND.ordinal()] = 5;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        lookAheadTest = 195433484433652687L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity.PlaceComponentResult
            int r7 = r7 + 4
            int r6 = r6 + 97
            int r8 = 23 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r7 = r7 + 1
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L31:
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity.b(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 + 4
            int r6 = r6 * 2
            int r6 = 103 - r6
            byte[] r0 = id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L18:
            r3 = 0
        L19:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity.c(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestLocationService$lambda-18  reason: not valid java name */
    public static final void m694requestLocationService$lambda18(Throwable th) {
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(-TextUtils.lastIndexOf("", '0', 0, 0), new char[]{23619, 16419, 64298, 23586, 30314, 58050, 38656, 16581, 33968, 20105, 49060, 39421, 60692, 42767, 59010, 45375, 54757, 65463, 3435, 52974, 15936, 55495}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(1 - (KeyEvent.getMaxKeyCode() >> 16), new char[]{4214, 61364, 50807, 4123, 55786, 6972, 43628, 47392, 51342}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(TextUtils.indexOf("", "", 0, 0) + 1, new char[]{48660, 63306, 4858, 48675, 49422, 4935, 32386, 45322, 26296, 63981, 22057, 26734, 3867, 4208, 3871, 16524, 14245, 18563, 58601, 16184, 56405, 28652, 56434, 6083, 34172, 34330, 46531, 52976, 44504, 48822, 27956, 42302, 21090, 54597, 18953, 40347, 31437, 3195, 9190, 29739, 8974, 9424, 6920, 11398, 51259, 23315, 61608, 3068, 61634, 29602, 43470, 57867}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(-ImageFormat.getBitsPerPixel(0), new char[]{25516, 30239, 7119, 25549, 16397, 42807, 30647, 1318, 47958, 30949, 24341, 56350, 54000, 37155, 1648, 62639, 59932, 51669, 60892, 35658, 494, 61114, 54551, 41955, 22724, 1821, 48291, 31365, 28722, 16306, 25600, 4431, 36816, 21520, 17263, 10684, 42799, 36220, 10965, 49242, 65203, 42463, 4661, 39157, 5505, 55824, 63948, 49035, 11643, 62195, 41212, 22057, 17615, 11099, 34918, 28363, 40057, 16443, 30661, 1383, 47892, 30849, 24442, 56744, 53945, 37228, 1753, 62621}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(View.MeasureSpec.getMode(0) + 1, new char[]{34418, 50073, 9146, 34368, 62863, 38210, 20369, 14165, 24279, 52589, 26466, 61031, 14194, 9470, 15876, 50910, 3991, 31825, 54696, 47420, 58467, 23403, 60720, 37315, 48460, 45768, 33921, 18672, 38381, 35376, 23669, 9063, 27216, 57748, 31519, 7064, 17061, 14586, 4774, 61999, 7020, 4109, 10822, 43659, 61522, 28608, 49645, 36347, 51454, 18290, 39129, 25609, 41284, 40663, 45127, 23778, 31148, 62907, 20454, 14102, 24269, 52483, 26453, 61321, 14128, 9447, 16125, 50914}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((Process.myTid() >> 22) + 1, new char[]{60868, 14456, 26139, 60844, 3627, 59723, 2593, 19278, 13611, 13953, 8926, 37493, 23704, 57158, 31731, 47751, 25662, 34807, 36945, 50544, 36817, 41102, 43217, 60877, 54953, 18744, 49461, 13540, 65035, 29122, 6540, 24356, 484, 6752, 16120, 26503, 10565, 49933, 22352, 36400, 28891, 60340, 28604, 54933, 39869, 37943, 33812, 61929, 41753, 48333, 56702, 6151, 51943, 25979, 62890, 8440, 4634, 3652, 2628, 19292, 13609, 14009, 8889, 37829}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(1 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{12612, 8517, 50284, 12669, 5964, 58866, 43030, 18345, 59882, 12215}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, TextUtils.indexOf("", "", 0) + 18, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[32];
                Object[] objArr13 = new Object[1];
                b(b, (byte) (b << 2), (byte) (-PlaceComponentResult[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (getAuthRequestContext & 40), (byte) (getAuthRequestContext & 53), (byte) (-PlaceComponentResult[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 54, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 2, (char) (KeyEvent.getMaxKeyCode() >> 16));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), $$a[78], $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - Process.getGidForName(""), 15 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (KeyEvent.getMaxKeyCode() >> 16), 15 - Gravity.getAbsoluteGravity(0, 0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 815, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 29, (char) (57994 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 16 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0') + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r5 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-744942628, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                byte b2 = PlaceComponentResult[32];
                Object[] objArr19 = new Object[1];
                b(b2, (byte) (b2 << 2), (byte) (-PlaceComponentResult[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (getAuthRequestContext & 40), (byte) (getAuthRequestContext & 53), (byte) (-PlaceComponentResult[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 61, (-16777170) - Color.rgb(0, 0, 0), (char) View.combineMeasuredStates(0, 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[28]), (byte) (-$$a[8]), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-744942628, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 911, (Process.myTid() >> 22) + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
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
                byte b3 = PlaceComponentResult[32];
                Object[] objArr25 = new Object[1];
                b(b3, (byte) (b3 << 2), (byte) (-PlaceComponentResult[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (getAuthRequestContext & 40), (byte) (getAuthRequestContext & 53), (byte) (-PlaceComponentResult[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 118, 2 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (38968 - View.resolveSizeAndState(0, 0, 0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[28]), (byte) (-$$a[8]), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.getDeadChar(0, 0) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-744942628, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
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
                byte b4 = PlaceComponentResult[32];
                Object[] objArr31 = new Object[1];
                b(b4, (byte) (b4 << 2), (byte) (-PlaceComponentResult[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (getAuthRequestContext & 40), (byte) (getAuthRequestContext & 53), (byte) (-PlaceComponentResult[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[9]), $$a[40], (byte) ($$a[47] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-744942628, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_mini_program_location_picker;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(1 - (ViewConfiguration.getTapTimeout() >> 16), new char[]{23619, 16419, 64298, 23586, 30314, 58050, 38656, 16581, 33968, 20105, 49060, 39421, 60692, 42767, 59010, 45375, 54757, 65463, 3435, 52974, 15936, 55495}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(-Process.getGidForName(""), new char[]{4214, 61364, 50807, 4123, 55786, 6972, 43628, 47392, 51342}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(View.combineMeasuredStates(0, 0) + 1, new char[]{35542, 5243, 27954, 35511, 8754, 5905, 280, 46358, 21029, 6865, 10684, 27694, 15247, 62292, 28868, 17554, 835, 44003, 39780, 15153, 59600, 35973, 41976, 5005, 45454, 25888, 51738, 51957, 39199, 24016}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    b(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[25], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    b((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[27], new Object[1]);
                    Object[] objArr6 = new Object[1];
                    a(((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{2395, 4013, 57576, 2360, 14847, 64587, 36052, 24140, 53666, 256, 42102, 34587, 47123, 59522, 64770, 44943, 33004, 45111, 5822, 53355, 27460, 38740}, objArr6);
                    baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.type_name_bank_or_phone_number).substring(7, 8).codePointAt(0) - 110, new char[]{48660, 63306, 4858, 48675, 49422, 4935, 32386, 45322, 26296, 63981, 22057, 26734, 3867, 4208, 3871, 16524, 14245, 18563, 58601, 16184, 56405, 28652, 56434, 6083, 34172, 34330, 46531, 52976, 44504, 48822, 27956, 42302, 21090, 54597, 18953, 40347, 31437, 3195, 9190, 29739, 8974, 9424, 6920, 11398, 51259, 23315, 61608, 3068, 61634, 29602, 43470, 57867}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(1 - Color.argb(0, 0, 0, 0), new char[]{25516, 30239, 7119, 25549, 16397, 42807, 30647, 1318, 47958, 30949, 24341, 56350, 54000, 37155, 1648, 62639, 59932, 51669, 60892, 35658, 494, 61114, 54551, 41955, 22724, 1821, 48291, 31365, 28722, 16306, 25600, 4431, 36816, 21520, 17263, 10684, 42799, 36220, 10965, 49242, 65203, 42463, 4661, 39157, 5505, 55824, 63948, 49035, 11643, 62195, 41212, 22057, 17615, 11099, 34918, 28363, 40057, 16443, 30661, 1383, 47892, 30849, 24442, 56744, 53945, 37228, 1753, 62621}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(getPackageName().codePointAt(5) - 109, new char[]{34418, 50073, 9146, 34368, 62863, 38210, 20369, 14165, 24279, 52589, 26466, 61031, 14194, 9470, 15876, 50910, 3991, 31825, 54696, 47420, 58467, 23403, 60720, 37315, 48460, 45768, 33921, 18672, 38381, 35376, 23669, 9063, 27216, 57748, 31519, 7064, 17061, 14586, 4774, 61999, 7020, 4109, 10822, 43659, 61522, 28608, 49645, 36347, 51454, 18290, 39129, 25609, 41284, 40663, 45127, 23778, 31148, 62907, 20454, 14102, 24269, 52483, 26453, 61321, 14128, 9447, 16125, 50914}, objArr9);
                    String str3 = (String) objArr9[0];
                    try {
                        Object[] objArr10 = new Object[1];
                        b(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[25], objArr10);
                        Class<?> cls4 = Class.forName((String) objArr10[0]);
                        b((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[27], new Object[1]);
                        Object[] objArr11 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{60868, 14456, 26139, 60844, 3627, 59723, 2593, 19278, 13611, 13953, 8926, 37493, 23704, 57158, 31731, 47751, 25662, 34807, 36945, 50544, 36817, 41102, 43217, 60877, 54953, 18744, 49461, 13540, 65035, 29122, 6540, 24356, 484, 6752, 16120, 26503, 10565, 49933, 22352, 36400, 28891, 60340, 28604, 54933, 39869, 37943, 33812, 61929, 41753, 48333, 56702, 6151, 51943, 25979, 62890, 8440, 4634, 3652, 2628, 19292, 13609, 14009, 8889, 37829}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(R.string.lbl_enter_phone_number_intro).substring(11, 13).codePointAt(0) - 108, new char[]{12612, 8517, 50284, 12669, 5964, 58866, 43030, 18345, 59882, 12215}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
            }
        }
        try {
            byte b = PlaceComponentResult[32];
            Object[] objArr14 = new Object[1];
            b(b, (byte) (b << 2), (byte) (-PlaceComponentResult[30]), objArr14);
            Class<?> cls5 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b((byte) (getAuthRequestContext & 40), (byte) (getAuthRequestContext & 53), (byte) (-PlaceComponentResult[30]), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 3, (char) TextUtils.indexOf("", "", 0));
                    Object[] objArr17 = new Object[1];
                    c((byte) (-$$a[9]), $$a[40], (byte) ($$a[47] - 1), objArr17);
                    obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {-1609775091, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
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
                super.onCreate(bundle);
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

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public final boolean onMarkerClick(Marker marker) {
        Intrinsics.checkNotNullParameter(marker, "");
        return true;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.back_to_services).substring(7, 8).codePointAt(0) - 31, new char[]{35542, 5243, 27954, 35511, 8754, 5905, 280, 46358, 21029, 6865, 10684, 27694, 15247, 62292, 28868, 17554, 835, 44003, 39780, 15153, 59600, 35973, 41976, 5005, 45454, 25888, 51738, 51957, 39199, 24016}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.category_transportation).substring(0, 10).length() - 9, new char[]{2395, 4013, 57576, 2360, 14847, 64587, 36052, 24140, 53666, 256, 42102, 34587, 47123, 59522, 64770, 44943, 33004, 45111, 5822, 53355, 27460, 38740}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[9], PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b((byte) (-PlaceComponentResult[5]), PlaceComponentResult[59], PlaceComponentResult[27], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{35542, 5243, 27954, 35511, 8754, 5905, 280, 46358, 21029, 6865, 10684, 27694, 15247, 62292, 28868, 17554, 835, 44003, 39780, 15153, 59600, 35973, 41976, 5005, 45454, 25888, 51738, 51957, 39199, 24016}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1, new char[]{2395, 4013, 57576, 2360, 14847, 64587, 36052, 24140, 53666, 256, 42102, 34587, 47123, 59522, 64770, 44943, 33004, 45111, 5822, 53355, 27460, 38740}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), View.resolveSizeAndState(0, 0, 0) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public MiniProgramLocationPickerActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$permissionRequest$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                Intrinsics.checkNotNullParameter(result, "");
                boolean MyBillsEntityDataFactory = result.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory) {
                    if (LocationUtil.getAuthRequestContext(MiniProgramLocationPickerActivity.this.getBaseContext())) {
                        MiniProgramLocationPickerActivity.this.watchMyLocation();
                    } else {
                        MiniProgramLocationPickerActivity.this.requestLocationService();
                    }
                }
                if (fromSystemDialog) {
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(MiniProgramLocationPickerActivity.this.getApplicationContext(), MyBillsEntityDataFactory);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> blockedPermissions) {
                Intrinsics.checkNotNullParameter(blockedPermissions, "");
                PermissionHelper.MyBillsEntityDataFactory(MiniProgramLocationPickerActivity.this);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest request) {
                Intrinsics.checkNotNullParameter(request, "");
                MiniProgramLocationPickerActivity.this.showDialogPermission(request);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.permissionRequest = builder.PlaceComponentResult();
        ActivityResultLauncher<IntentSenderRequest> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MiniProgramLocationPickerActivity.m692launcher$lambda19(MiniProgramLocationPickerActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.launcher = registerForActivityResult;
    }

    @JvmName(name = "getPresenter")
    public final NearbyMerchantLocationSearchPresenter getPresenter() {
        NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter = this.presenter;
        if (nearbyMerchantLocationSearchPresenter != null) {
            return nearbyMerchantLocationSearchPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(NearbyMerchantLocationSearchPresenter nearbyMerchantLocationSearchPresenter) {
        Intrinsics.checkNotNullParameter(nearbyMerchantLocationSearchPresenter, "");
        this.presenter = nearbyMerchantLocationSearchPresenter;
    }

    @JvmName(name = "getMapHelper")
    public final MapHelper getMapHelper() {
        MapHelper mapHelper = this.mapHelper;
        if (mapHelper != null) {
            return mapHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMapHelper")
    public final void setMapHelper(MapHelper mapHelper) {
        Intrinsics.checkNotNullParameter(mapHelper, "");
        this.mapHelper = mapHelper;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        injectComponent();
        setupSearchView();
        setupMotionLayout();
        setupRecyclerView();
        setupBottomSheet();
        setupMaps();
    }

    private final void setupMotionLayout() {
        ((MotionLayout) _$_findCachedViewById(R.id.motionLayout)).setTransitionListener(new MotionLayout.TransitionListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$setupMotionLayout$1
            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public final void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {
                Intrinsics.checkNotNullParameter(motionLayout, "");
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public final void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                Intrinsics.checkNotNullParameter(motionLayout, "");
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public final void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {
                Intrinsics.checkNotNullParameter(motionLayout, "");
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public final void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                Intrinsics.checkNotNullParameter(motionLayout, "");
                if (endId == R.id.layoutCollapsed) {
                    ((SearchView) MiniProgramLocationPickerActivity.this._$_findCachedViewById(R.id.searchBoxLocation)).clearFocus();
                    MiniProgramLocationPickerActivity miniProgramLocationPickerActivity = MiniProgramLocationPickerActivity.this;
                    ActivityExtKt.MyBillsEntityDataFactory(miniProgramLocationPickerActivity, (SearchView) miniProgramLocationPickerActivity._$_findCachedViewById(R.id.searchBoxLocation));
                } else if (endId == R.id.layoutExpanded) {
                    NearbyMerchantLocationSearchPresenter presenter = MiniProgramLocationPickerActivity.this.getPresenter();
                    String deviceUUID = presenter.PlaceComponentResult.getDeviceUUID();
                    Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
                    presenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = deviceUUID;
                }
            }
        });
    }

    private final void setupRecyclerView() {
        this.adapter = new NearbyLocationResultAdapter(new NearbyLocationResultAdapter.OnClickListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$setupRecyclerView$1
            @Override // id.dana.nearbyme.adapter.NearbyLocationResultAdapter.OnClickListener
            public final void onLocationClicked(String placeId, String name, String address, Location location) {
                Intrinsics.checkNotNullParameter(placeId, "");
                Intrinsics.checkNotNullParameter(name, "");
                Intrinsics.checkNotNullParameter(address, "");
                Intrinsics.checkNotNullParameter(location, "");
                MiniProgramLocationPickerActivity.this.setBottomSheetSelectedLocationState(MiniProgramLocationPickerActivity.BottomSheetSelectedLocationState.LOADING);
                ((TextView) MiniProgramLocationPickerActivity.this._$_findCachedViewById(R.id.getSupportButtonTintMode)).performClick();
                MiniProgramLocationPickerActivity.this.selectedPlace = new MiniProgramLocationPickerActivity.Place(placeId, name, address, LatLngKt.toLatLng(location));
                MiniProgramLocationPickerActivity.this.setBottomSheetSelectedLocationState(MiniProgramLocationPickerActivity.BottomSheetSelectedLocationState.SUCCESS);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        MiniProgramLocationPickerActivity miniProgramLocationPickerActivity = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(miniProgramLocationPickerActivity, 1, false));
        recyclerView.addItemDecoration(new NearbyDividerItemDecoration(miniProgramLocationPickerActivity, false));
        NearbyLocationResultAdapter nearbyLocationResultAdapter = this.adapter;
        if (nearbyLocationResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nearbyLocationResultAdapter = null;
        }
        recyclerView.setAdapter(nearbyLocationResultAdapter);
    }

    private final void setupBottomSheet() {
        BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from((FrameLayout) _$_findCachedViewById(R.id.initRecordTimeStamp_res_0x7f0a010e));
        from.setHideable(false);
        from.setPeekHeight(ViewExtKt.PlaceComponentResult(30.0f));
        from.setState(3);
        Intrinsics.checkNotNullExpressionValue(from, "");
        this.bottomSheetSelectedLocation = from;
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnSelectThisLocation)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniProgramLocationPickerActivity.m695setupBottomSheet$lambda2(MiniProgramLocationPickerActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupBottomSheet$lambda-2  reason: not valid java name */
    public static final void m695setupBottomSheet$lambda2(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, View view) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        Intent intent = new Intent();
        Place place = miniProgramLocationPickerActivity.selectedPlace;
        if (place == null) {
            return;
        }
        miniProgramLocationPickerActivity.setResult(-1, intent.putExtra("result", place));
        miniProgramLocationPickerActivity.finish();
    }

    private final void setupMaps() {
        setBottomSheetSelectedLocationState(BottomSheetSelectedLocationState.LOADING);
        LatLng latLng = (LatLng) getIntent().getParcelableExtra(EXTRA_INITIAL_LOCATION);
        if (latLng == null || latLng.isUndefined()) {
            latLng = LatLng.INSTANCE.monas();
        }
        CameraPosition build = new CameraPosition.Builder().target(latLng.toGoogleLatLng()).zoom(17.0f).build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        DanaMapFragment.Companion companion = DanaMapFragment.INSTANCE;
        GoogleMapOptions camera = new GoogleMapOptions().camera(build);
        Intrinsics.checkNotNullExpressionValue(camera, "");
        DanaMapFragment MyBillsEntityDataFactory = DanaMapFragment.Companion.MyBillsEntityDataFactory(camera);
        this.mapFragment = MyBillsEntityDataFactory;
        MyBillsEntityDataFactory.getMapAsync(this);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        DanaMapFragment danaMapFragment = this.mapFragment;
        if (danaMapFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaMapFragment = null;
        }
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(R.id.mapContainer, danaMapFragment, TAG_MAP_FRAGMENT, 2);
        beginTransaction.getAuthRequestContext();
        getPresenter().PlaceComponentResult(LatLngKt.toLocation(latLng));
        ((FloatingActionButton) _$_findCachedViewById(R.id.btnLocateMe)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniProgramLocationPickerActivity.m699setupMaps$lambda3(MiniProgramLocationPickerActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupMaps$lambda-3  reason: not valid java name */
    public static final void m699setupMaps$lambda3(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, View view) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        miniProgramLocationPickerActivity.permissionRequest.check();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialogPermission(final PermissionRequest request) {
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.SubSequence = getString(R.string.allow_location_access);
        builder.GetContactSyncConfig = getString(R.string.allow_location_for_experience);
        builder.DatabaseTableConfigUtil = R.drawable.ic_location_permission_icon;
        builder.moveToNextValue = 0L;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(getString(R.string.allow_access), new Function1<View, Unit>() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$showDialogPermission$1
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
        }).KClassImpl$Data$declaredNonStaticMembers$2(getString(17039360), new Function1<View, Unit>() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$showDialogPermission$2
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

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public final void onMapReady(GoogleMap maps) {
        Intrinsics.checkNotNullParameter(maps, "");
        getMapHelper().MyBillsEntityDataFactory(maps, this);
        setupCameraListener(maps);
        this.permissionRequest.check();
    }

    private final void setupCameraListener(GoogleMap maps) {
        maps.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
            public final void onCameraMove() {
                MiniProgramLocationPickerActivity.m696setupCameraListener$lambda4(MiniProgramLocationPickerActivity.this);
            }
        });
        maps.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
            public final void onCameraIdle() {
                MiniProgramLocationPickerActivity.m697setupCameraListener$lambda5(MiniProgramLocationPickerActivity.this);
            }
        });
        maps.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
            public final void onCameraMoveStarted(int i) {
                MiniProgramLocationPickerActivity.m698setupCameraListener$lambda6(MiniProgramLocationPickerActivity.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupCameraListener$lambda-4  reason: not valid java name */
    public static final void m696setupCameraListener$lambda4(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        miniProgramLocationPickerActivity.pullOutPinMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupCameraListener$lambda-5  reason: not valid java name */
    public static final void m697setupCameraListener$lambda5(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity) {
        Location location;
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        miniProgramLocationPickerActivity.putDownPinMap();
        GoogleMap googleMap = miniProgramLocationPickerActivity.getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            com.google.android.gms.maps.model.LatLng latLng = googleMap.getCameraPosition().target;
            location = LocationUtil.PlaceComponentResult(latLng.latitude, latLng.longitude);
        } else {
            location = null;
        }
        if (location == null || !Intrinsics.areEqual(miniProgramLocationPickerActivity.flagFromPullOutPinMap, Boolean.TRUE)) {
            return;
        }
        miniProgramLocationPickerActivity.getPresenter().PlaceComponentResult(location);
        miniProgramLocationPickerActivity.flagFromPullOutPinMap = Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupCameraListener$lambda-6  reason: not valid java name */
    public static final void m698setupCameraListener$lambda6(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, int i) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        if (i == 1) {
            miniProgramLocationPickerActivity.showSkeletonBottomSheet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void assembleReverseGeocodeOnBottomSheet(Address geocode) {
        String latitude;
        this.selectedPlace = (geocode == null || (latitude = geocode.getLatitude()) == null) ? null : new Place("", geocode.getLabel(), geocode.getAddressLine(), new LatLng(latitude, geocode.getLongitude()));
        setBottomSheetSelectedLocationState(BottomSheetSelectedLocationState.SUCCESS);
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ((TextView) _$_findCachedViewById(R.id.getDataset2Color)).setText(getIntent().getStringExtra("appName"));
            toolbar.setNavigationIcon(ContextExtKt.PlaceComponentResult(this, (int) R.drawable.arrow_left_white));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MiniProgramLocationPickerActivity.m691configToolbar$lambda10$lambda9(MiniProgramLocationPickerActivity.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: configToolbar$lambda-10$lambda-9  reason: not valid java name */
    public static final void m691configToolbar$lambda10$lambda9(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, View view) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        miniProgramLocationPickerActivity.setResult(0);
        miniProgramLocationPickerActivity.finish();
    }

    private final void setupSearchView() {
        addDisposable(((SearchView) _$_findCachedViewById(R.id.searchBoxLocation)).getKeyword().debounce(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MiniProgramLocationPickerActivity.m700setupSearchView$lambda11(MiniProgramLocationPickerActivity.this, (String) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setupSearchView$lambda-11  reason: not valid java name */
    public static final void m700setupSearchView$lambda11(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, String str) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        String obj = StringsKt.trim((CharSequence) str).toString();
        if (obj.length() == 0) {
            miniProgramLocationPickerActivity.setSearchLocationState(SearchLocationState.EMPTY_KEYWORD);
            return;
        }
        miniProgramLocationPickerActivity.setSearchLocationState(SearchLocationState.SEARCHING);
        LatLng latLng = miniProgramLocationPickerActivity.currentLocation;
        if (latLng == null) {
            latLng = LatLng.INSTANCE.monas();
        }
        miniProgramLocationPickerActivity.getPresenter().MyBillsEntityDataFactory(obj, LatLngKt.toLocation(latLng), "Mini Program");
    }

    private final void injectComponent() {
        DaggerNearbyMerchantLocationComponent.Builder PlaceComponentResult2 = DaggerNearbyMerchantLocationComponent.PlaceComponentResult();
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.MyBillsEntityDataFactory = (NearbyMerchantLocationSearchModule) Preconditions.getAuthRequestContext(new NearbyMerchantLocationSearchModule(new NearbyMerchantLocationSearchContract.View() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ String getNearbyMerchantListErrorTitle() {
                return NearbyMerchantLocationSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onErrorGetNearbyMerchantList() {
                NearbyMerchantLocationSearchContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetMerchantListPromo(List list) {
                NearbyMerchantLocationSearchContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessGetNearbyMerchantList(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessLoadMoreNearbyMerchantList(boolean z, List list) {
                NearbyMerchantLocationSearchContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final /* synthetic */ void onSuccessSearchNearbyMerchantList(boolean z, List list) {
                NearbyMerchantLocationSearchContract.View.CC.getAuthRequestContext(list);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessGetListLocations(List<NearbyLocation> nearbyLocations) {
                Intrinsics.checkNotNullParameter(nearbyLocations, "");
                MiniProgramLocationPickerActivity miniProgramLocationPickerActivity = MiniProgramLocationPickerActivity.this;
                ArrayList arrayList = new ArrayList();
                for (Object obj : nearbyLocations) {
                    if (((NearbyLocation) obj).getViewHolderType() == 0) {
                        arrayList.add(obj);
                    }
                }
                miniProgramLocationPickerActivity.updateLocationData(arrayList);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onErrorGetListLocations() {
                MiniProgramLocationPickerActivity.this.setSearchLocationState(MiniProgramLocationPickerActivity.SearchLocationState.SEARCH_ERROR);
            }

            @Override // id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract.View
            public final void onSuccessGetReverseGeocodeByLocation(Address address) {
                Intrinsics.checkNotNullParameter(address, "");
                MiniProgramLocationPickerActivity.this.assembleReverseGeocodeOnBottomSheet(address);
            }
        }));
        PlaceComponentResult2.getAuthRequestContext().getAuthRequestContext(this);
        registerPresenter(getPresenter());
        NearbyMerchantLocationSearchPresenter presenter = getPresenter();
        presenter.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(presenter.GetContactSyncConfig.subscribe(new NearbyMerchantLocationSearchPresenter$$ExternalSyntheticLambda1(presenter)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLocationData(List<NearbyLocation> nearbyLocations) {
        if (nearbyLocations.isEmpty()) {
            setSearchLocationState(SearchLocationState.SEARCH_EMPTY_RESULT);
            return;
        }
        NearbyLocationResultAdapter nearbyLocationResultAdapter = this.adapter;
        if (nearbyLocationResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            nearbyLocationResultAdapter = null;
        }
        nearbyLocationResultAdapter.setItems(nearbyLocations);
        setSearchLocationState(SearchLocationState.SEARCH_RESULT_FOUND);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBottomSheetSelectedLocationState(BottomSheetSelectedLocationState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1 || i == 2) {
            showSkeletonBottomSheet();
        } else if (i == 3) {
            dismissSkeletonBottomSheet();
            Place place = this.selectedPlace;
            if (place != null) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.tvLocationName);
                if (textView != null) {
                    textView.setText(place.getName());
                }
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.tvLocationAddress);
                if (textView2 != null) {
                    textView2.setText(place.getAddress());
                }
                MapHelper mapHelper = getMapHelper();
                com.google.android.gms.maps.model.LatLng googleLatLng = place.getLocation().toGoogleLatLng();
                GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
                if (googleMap != null) {
                    googleMap.animateCamera(MapHelper.getAuthRequestContext(googleLatLng, 15.0f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSearchLocationState(SearchLocationState state) {
        int i = WhenMappings.$EnumSwitchMapping$1[state.ordinal()];
        if (i == 1) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0cc7_kybpresenter_enablerealtimerefresh_2);
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            showSkeletonLocationList();
            return;
        }
        NearbyLocationResultAdapter nearbyLocationResultAdapter = null;
        if (i == 2) {
            NearbyLocationResultAdapter nearbyLocationResultAdapter2 = this.adapter;
            if (nearbyLocationResultAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                nearbyLocationResultAdapter = nearbyLocationResultAdapter2;
            }
            nearbyLocationResultAdapter.setItems(CollectionsKt.emptyList());
            SkeletonScreen skeletonScreen = this.skeletonLocationList;
            if (skeletonScreen != null) {
                skeletonScreen.PlaceComponentResult();
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.parentColumn);
            if (appCompatImageView != null) {
                id.dana.component.extension.ViewExtKt.getAuthRequestContext(appCompatImageView, (int) R.drawable.ic_general_search);
            }
            TextView textView = (TextView) _$_findCachedViewById(R.id.unsubscribe);
            if (textView != null) {
                textView.setText(R.string.lets_find_ur_location);
            }
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a145e_logfilemanager_1);
            if (textView2 != null) {
                textView2.setText(R.string.start_typing_for_suggestions);
            }
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0cc7_kybpresenter_enablerealtimerefresh_2);
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        } else if (i != 3 && i != 4) {
            if (i == 5) {
                SkeletonScreen skeletonScreen2 = this.skeletonLocationList;
                if (skeletonScreen2 != null) {
                    skeletonScreen2.PlaceComponentResult();
                }
                LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0cc7_kybpresenter_enablerealtimerefresh_2);
                if (linearLayout3 != null) {
                    linearLayout3.setVisibility(4);
                }
            }
        } else {
            NearbyLocationResultAdapter nearbyLocationResultAdapter3 = this.adapter;
            if (nearbyLocationResultAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                nearbyLocationResultAdapter = nearbyLocationResultAdapter3;
            }
            nearbyLocationResultAdapter.setItems(CollectionsKt.emptyList());
            SkeletonScreen skeletonScreen3 = this.skeletonLocationList;
            if (skeletonScreen3 != null) {
                skeletonScreen3.PlaceComponentResult();
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.parentColumn);
            if (appCompatImageView2 != null) {
                id.dana.component.extension.ViewExtKt.getAuthRequestContext(appCompatImageView2, (int) R.drawable.img_search_result_not_found);
            }
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.unsubscribe);
            if (textView3 != null) {
                textView3.setText(R.string.no_location_found);
            }
            TextView textView4 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a145e_logfilemanager_1);
            if (textView4 != null) {
                textView4.setText(R.string.no_location_found_desc);
            }
            LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0cc7_kybpresenter_enablerealtimerefresh_2);
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
        }
    }

    private final void showSkeletonLocationList() {
        SkeletonScreen skeletonScreen = this.skeletonLocationList;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator));
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator)).getAdapter();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.skeleton_search_location;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 4;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        this.skeletonLocationList = recyclerViewSkeletonScreen;
    }

    private final void showSkeletonBottomSheet() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.bottomSheetSelectedLocation;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(3);
        SkeletonScreen skeletonScreen = this.skeletonBottomSheet;
        byte b = 0;
        if (skeletonScreen == null) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((LinearLayout) _$_findCachedViewById(R.id.layoutLocationDetail));
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.skeleton_3_small_rows;
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
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnSelectThisLocation)).setEnabled(false);
    }

    private final void dismissSkeletonBottomSheet() {
        SkeletonScreen skeletonScreen = this.skeletonBottomSheet;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnSelectThisLocation)).setEnabled(true);
    }

    @JvmName(name = "isPutDownPinMap")
    private final boolean isPutDownPinMap() {
        PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) _$_findCachedViewById(R.id.ByteBufferGifDecoder);
        if (pinMapLottieAnimationView.getMaxFrame() == ((float) pinMapLottieAnimationView.getPullOutMaxFrame())) {
            return false;
        }
        return !((pinMapLottieAnimationView.getMinFrame() > ((float) pinMapLottieAnimationView.getPullOutMinFrame()) ? 1 : (pinMapLottieAnimationView.getMinFrame() == ((float) pinMapLottieAnimationView.getPullOutMinFrame()) ? 0 : -1)) == 0);
    }

    private final void pullOutPinMap() {
        if (isPutDownPinMap()) {
            PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) _$_findCachedViewById(R.id.ByteBufferGifDecoder);
            pinMapLottieAnimationView.setMinFrame(pinMapLottieAnimationView.getPullOutMinFrame());
            pinMapLottieAnimationView.setMaxFrame(pinMapLottieAnimationView.getPullOutMaxFrame());
            pinMapLottieAnimationView.playAnimation();
            this.flagFromPullOutPinMap = Boolean.TRUE;
        }
    }

    private final void putDownPinMap() {
        PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) _$_findCachedViewById(R.id.ByteBufferGifDecoder);
        pinMapLottieAnimationView.setMinFrame(pinMapLottieAnimationView.getPutDownMinFrame());
        pinMapLottieAnimationView.setMaxFrame(pinMapLottieAnimationView.getPutDownMaxFrame());
        pinMapLottieAnimationView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestLocationService() {
        LocationRequest create = LocationRequest.create();
        create.setPriority(102);
        create.setNumUpdates(1);
        Intrinsics.checkNotNullExpressionValue(create, "");
        LocationSettingsRequest build = new LocationSettingsRequest.Builder().addLocationRequest(create).setAlwaysShow(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        Disposable disposable = this.locationRequestDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.locationRequestDisposable = new ReactiveLocationProvider(this).BuiltInFictitiousFunctionClassFactory(build).subscribe(new Consumer() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MiniProgramLocationPickerActivity.m693requestLocationService$lambda17(MiniProgramLocationPickerActivity.this, (LocationSettingsResult) obj);
            }
        }, new Consumer() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MiniProgramLocationPickerActivity.m694requestLocationService$lambda18((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestLocationService$lambda-17  reason: not valid java name */
    public static final void m693requestLocationService$lambda17(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, LocationSettingsResult locationSettingsResult) {
        PendingIntent resolution;
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
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
                    ActivityResultLauncher<IntentSenderRequest> activityResultLauncher = miniProgramLocationPickerActivity.launcher;
                    IntentSenderRequest.Builder builder = new IntentSenderRequest.Builder(intentSender);
                    activityResultLauncher.MyBillsEntityDataFactory(new IntentSenderRequest(builder.PlaceComponentResult, builder.MyBillsEntityDataFactory, builder.BuiltInFictitiousFunctionClassFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2), null);
                } catch (IntentSender.SendIntentException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void watchMyLocation() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Disposable disposable = this.locationWatcherDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.locationWatcherDisposable = new LocationUtil.LocationRequestBuilder(getApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MiniProgramLocationPickerActivity.m701watchMyLocation$lambda20(MiniProgramLocationPickerActivity.this, booleanRef, (Location) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: watchMyLocation$lambda-20  reason: not valid java name */
    public static final void m701watchMyLocation$lambda20(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, Ref.BooleanRef booleanRef, Location location) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullExpressionValue(location, "");
        miniProgramLocationPickerActivity.currentLocation = LatLngKt.toLatLng(location);
        miniProgramLocationPickerActivity.updateMyCurrentLocationMarker(booleanRef.element);
        booleanRef.element = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void updateMyCurrentLocationMarker(boolean r6) {
        /*
            r5 = this;
            id.dana.domain.globalsearch.model.LatLng r0 = r5.currentLocation
            if (r0 == 0) goto L4a
            com.google.android.gms.maps.model.Marker r1 = r5.myLocationMarker
            if (r1 == 0) goto L11
            com.google.android.gms.maps.model.LatLng r2 = r0.toGoogleLatLng()
            r1.setPosition(r2)
            if (r1 != 0) goto L2c
        L11:
            id.dana.utils.MapHelper r1 = r5.getMapHelper()
            id.dana.utils.MapHelper r2 = r5.getMapHelper()
            android.location.Location r3 = id.dana.domain.globalsearch.model.LatLngKt.toLocation(r0)
            r4 = 0
            com.google.android.gms.maps.model.MarkerOptions r2 = r2.getAuthRequestContext(r3, r4)
            com.google.android.gms.maps.GoogleMap r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            if (r1 == 0) goto L2b
            com.google.android.gms.maps.model.Marker r1 = r1.addMarker(r2)
            goto L2c
        L2b:
            r1 = r4
        L2c:
            r5.myLocationMarker = r1
            if (r6 == 0) goto L4a
            id.dana.utils.MapHelper r6 = r5.getMapHelper()
            com.google.android.gms.maps.model.LatLng r0 = r0.toGoogleLatLng()
            com.google.android.gms.maps.GoogleMap r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            if (r6 == 0) goto L45
            r1 = 1097859072(0x41700000, float:15.0)
            com.google.android.gms.maps.CameraUpdate r0 = id.dana.utils.MapHelper.getAuthRequestContext(r0, r1)
            r6.animateCamera(r0)
        L45:
            id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity$BottomSheetSelectedLocationState r6 = id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity.BottomSheetSelectedLocationState.LOADING
            r5.setBottomSheetSelectedLocationState(r6)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.locationpicker.MiniProgramLocationPickerActivity.updateMyCurrentLocationMarker(boolean):void");
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

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004\"\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b$\u0010\u0004R\"\u0010\r\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010(R\"\u0010\u000b\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010#"}, d2 = {"Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$Place;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lid/dana/domain/globalsearch/model/LatLng;", "component4", "()Lid/dana/domain/globalsearch/model/LatLng;", "id", "name", "address", "location", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/LatLng;)Lid/dana/danah5/locationpicker/MiniProgramLocationPickerActivity$Place;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAddress", "setAddress", "(Ljava/lang/String;)V", "getId", "Lid/dana/domain/globalsearch/model/LatLng;", "getLocation", "setLocation", "(Lid/dana/domain/globalsearch/model/LatLng;)V", "getName", "setName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/globalsearch/model/LatLng;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Place implements Parcelable {
        public static final Parcelable.Creator<Place> CREATOR = new Creator();
        private String address;
        private final String id;
        private LatLng location;
        private String name;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Creator implements Parcelable.Creator<Place> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Place createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new Place(parcel.readString(), parcel.readString(), parcel.readString(), (LatLng) parcel.readParcelable(Place.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Place[] newArray(int i) {
                return new Place[i];
            }
        }

        public static /* synthetic */ Place copy$default(Place place, String str, String str2, String str3, LatLng latLng, int i, Object obj) {
            if ((i & 1) != 0) {
                str = place.id;
            }
            if ((i & 2) != 0) {
                str2 = place.name;
            }
            if ((i & 4) != 0) {
                str3 = place.address;
            }
            if ((i & 8) != 0) {
                latLng = place.location;
            }
            return place.copy(str, str2, str3, latLng);
        }

        /* renamed from: component1  reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2  reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3  reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        /* renamed from: component4  reason: from getter */
        public final LatLng getLocation() {
            return this.location;
        }

        public final Place copy(String id2, String name, String address, LatLng location) {
            Intrinsics.checkNotNullParameter(id2, "");
            Intrinsics.checkNotNullParameter(name, "");
            Intrinsics.checkNotNullParameter(address, "");
            Intrinsics.checkNotNullParameter(location, "");
            return new Place(id2, name, address, location);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Place) {
                Place place = (Place) other;
                return Intrinsics.areEqual(this.id, place.id) && Intrinsics.areEqual(this.name, place.name) && Intrinsics.areEqual(this.address, place.address) && Intrinsics.areEqual(this.location, place.location);
            }
            return false;
        }

        public final int hashCode() {
            return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.address.hashCode()) * 31) + this.location.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Place(id=");
            sb.append(this.id);
            sb.append(", name=");
            sb.append(this.name);
            sb.append(", address=");
            sb.append(this.address);
            sb.append(", location=");
            sb.append(this.location);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.address);
            parcel.writeParcelable(this.location, flags);
        }

        public Place(String str, String str2, String str3, LatLng latLng) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(latLng, "");
            this.id = str;
            this.name = str2;
            this.address = str3;
            this.location = latLng;
        }

        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @JvmName(name = "getName")
        public final String getName() {
            return this.name;
        }

        @JvmName(name = "setName")
        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.name = str;
        }

        @JvmName(name = "getAddress")
        public final String getAddress() {
            return this.address;
        }

        @JvmName(name = "setAddress")
        public final void setAddress(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.address = str;
        }

        public /* synthetic */ Place(String str, String str2, String str3, LatLng latLng, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? new LatLng(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 3, null) : latLng);
        }

        @JvmName(name = "getLocation")
        public final LatLng getLocation() {
            return this.location;
        }

        @JvmName(name = "setLocation")
        public final void setLocation(LatLng latLng) {
            Intrinsics.checkNotNullParameter(latLng, "");
            this.location = latLng;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: launcher$lambda-19  reason: not valid java name */
    public static final void m692launcher$lambda19(MiniProgramLocationPickerActivity miniProgramLocationPickerActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(miniProgramLocationPickerActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory == -1) {
            miniProgramLocationPickerActivity.watchMyLocation();
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(lookAheadTest ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (lookAheadTest ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
