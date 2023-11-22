package id.dana.drawable;

import android.app.Application;
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
import android.os.Build;
import android.os.Bundle;
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
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.ComponentActivity;
import androidx.view.LiveData;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import androidx.view.Transformations;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.card.MaterialCardView;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.LockableBaseBottomSheetBehavior;
import id.dana.bottomsheet.BottomsheetBehaviorExtKt;
import id.dana.component.utils.SizeUtil;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.core.ui.glide.GlideUtil;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNewNearbyComponent;
import id.dana.di.modules.MerchantDetailModule;
import id.dana.di.modules.MerchantModule;
import id.dana.di.modules.NearbyMeModule;
import id.dana.domain.account.Account;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.drawable.merchantdetail.MerchantDetailView;
import id.dana.drawable.merchantdetail.bottomsheet.MerchantDetailBottomsheetView;
import id.dana.drawable.merchantfilter.MerchantFilterView;
import id.dana.drawable.merchantlist.NewMerchantListView;
import id.dana.drawable.otherstore.OtherStoreResultView;
import id.dana.drawable.search.NearbySearchFragment;
import id.dana.drawable.search.NearbySearchResultListener;
import id.dana.drawable.search.adapter.MerchantSearchResultAdapter;
import id.dana.drawable.search.searchresult.MerchantSearchResultFragment;
import id.dana.drawable.view.NearbySearchToolbar;
import id.dana.eventbus.base.BaseActivityWithPageLoadTracker;
import id.dana.eventbus.models.TimerEvent;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.DanaMapFragment;
import id.dana.nearbyme.MerchantContract;
import id.dana.nearbyme.NearbyMeActivity;
import id.dana.nearbyme.OnCategoryCheckedListener;
import id.dana.nearbyme.di.module.PhotoGalleryModule;
import id.dana.nearbyme.enums.SearchType;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantreview.MyReviewListActivity;
import id.dana.nearbyme.model.HighlightedShopModel;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.NearbyShopsModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.PinMapLottieAnimationView;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocationUtil;
import id.dana.utils.MapHelper;
import id.dana.utils.OSUtil;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ¢\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0006¢\u0001£\u0001¤\u0001B\b¢\u0006\u0005\b¡\u0001\u0010\fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0007\u0010\u0012J\u000f\u0010\n\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\n\u0010\u0013J\u001b\u0010\n\u001a\u0006*\u00020\u00140\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u000f\u0010\u0019\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\fJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\fJ\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u001aJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\"J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010\u001aJ\u000f\u0010$\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010\u001aJ\u001f\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b'\u0010\bJ%\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010&\u001a\u00020*H\u0002¢\u0006\u0004\b\n\u0010+J)\u00100\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010.H\u0014¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0006H\u0016¢\u0006\u0004\b2\u0010\fJ\u000f\u00103\u001a\u00020\u0006H\u0014¢\u0006\u0004\b3\u0010\fJ\u0017\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020%H\u0002¢\u0006\u0004\b\u000e\u00108J\u000f\u00109\u001a\u00020\u0006H\u0014¢\u0006\u0004\b9\u0010\fJ\u000f\u0010:\u001a\u00020\u0006H\u0014¢\u0006\u0004\b:\u0010\fJ\u001f\u0010?\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@J\u001d\u0010\u0010\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bA\u0010\fJ\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020BH\u0002¢\u0006\u0004\b'\u0010CJ\u000f\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bD\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010EJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0010\u0010FJ\u000f\u0010G\u001a\u00020\u0006H\u0002¢\u0006\u0004\bG\u0010\fJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0002¢\u0006\u0004\b\n\u0010EJ\u0017\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0002¢\u0006\u0004\b'\u0010EJ\u000f\u0010H\u001a\u00020\u0006H\u0002¢\u0006\u0004\bH\u0010\fJ\u000f\u0010I\u001a\u00020\u0006H\u0002¢\u0006\u0004\bI\u0010\fJ\u001d\u0010\u000e\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040JH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\fJ\u000f\u0010L\u001a\u00020\rH\u0002¢\u0006\u0004\bL\u0010\u001aJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0007\u0010EJ\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010EJ\u0017\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0004H\u0016¢\u0006\u0004\bN\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020*H\u0002¢\u0006\u0004\b\u0010\u0010OR\u0018\u0010'\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010QR\u0018\u0010\u000e\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010TR\u0016\u0010\u0007\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010UR\u0016\u0010\n\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010UR\u001a\u0010\u0017\u001a\u0006*\u00020B0B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010VR\u0016\u0010R\u001a\u00020W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010XR\u001a\u0010\u0018\u001a\u0006*\u00020B0B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010VR(\u0010[\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010ZR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010]R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010TR\u0016\u0010 \u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010TR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010TR\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010TR\u0014\u0010\u001b\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010_R\u0018\u0010!\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010aR\u0018\u0010#\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010aR\u0015\u0010D\u001a\u0004\u0018\u00010bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010m\u001a\u00020l8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010t\u001a\u00020s8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001d\u0010$\u001a\f\u0012\b\u0012\u0006*\u00020{0{0zX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b|\u0010dR\u001d\u0010A\u001a\f\u0012\b\u0012\u0006*\u00020{0{0zX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b}\u0010dR\u0018\u0010L\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR*\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0017\u0010K\u001a\u00020*8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010SR*\u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R)\u0010H\u001a\u00030\u0096\u00012\u0007\u0010\u0005\u001a\u00030\u0096\u00018\u0002@CX\u0083\u000e¢\u0006\u000f\n\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0005\b\u0010\u0010\u0099\u0001R6\u0010G\u001a \u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020%0\u009a\u0001j\u000f\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020%`\u009b\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010I\u001a\u00020\r8CX\u0083\u0084\u0002¢\u0006\r\n\u0005\b\u009e\u0001\u0010d\u001a\u0004\b[\u0010\u001aR\u001c\u0010}\u001a\u00020\r8CX\u0083\u0084\u0002¢\u0006\r\n\u0005\b\u009f\u0001\u0010d\u001a\u0004\bR\u0010\u001aR\u0019\u0010~\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b \u0001\u0010V"}, d2 = {"Lid/dana/nearbyrevamp/NewNearbyMeActivity;", "Lid/dana/eventbus/base/BaseActivityWithPageLoadTracker;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantDetailInteraction;", "Lid/dana/nearbyme/model/ShopModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/model/ShopModel;)V", "", "getAuthRequestContext", "(Ljava/util/List;)V", "()V", "", "MyBillsEntityDataFactory", "(Z)Z", "PlaceComponentResult", "", "(I)Z", "()I", "Lcom/google/android/gms/maps/model/MarkerOptions;", "(Lid/dana/nearbyme/model/ShopModel;)Lcom/google/android/gms/maps/model/MarkerOptions;", "getLayout", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "getErrorConfigVersion", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", IAPSyncCommand.COMMAND_INIT, "GetContactSyncConfig", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda8", "(Lid/dana/nearbyme/model/ShopModel;)Z", "isLayoutRequested", "PrepareContext", "Lcom/google/android/gms/maps/model/Marker;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/google/android/gms/maps/model/Marker;Lid/dana/nearbyme/model/ShopModel;)V", "", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "onDestroy", "Lcom/google/android/gms/maps/GoogleMap;", "map", "onMapReady", "(Lcom/google/android/gms/maps/GoogleMap;)V", "(Lcom/google/android/gms/maps/model/Marker;)Z", "onResume", "onStart", "Lid/dana/eventbus/models/TimerEvent;", "timerEvent", "", "millisecond", "onTimerEnd", "(Lid/dana/eventbus/models/TimerEvent;J)V", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Landroid/location/Location;", "(Landroid/location/Location;)V", "newProxyInstance", "(Z)V", "(I)V", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda6", "shopModel", "updatePromoBadge", "(Ljava/lang/String;)V", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "scheduleImpl", "Ljava/lang/String;", "Z", "I", "Landroid/location/Location;", "Lid/dana/nearbyrevamp/NewNearbyMeActivity$MapState;", "Lid/dana/nearbyrevamp/NewNearbyMeActivity$MapState;", "Lkotlin/Pair;", "Lkotlin/Pair;", "lookAheadTest", "Lid/dana/nearbyme/model/HighlightedShopModel;", "Lid/dana/nearbyme/model/HighlightedShopModel;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "Lid/dana/nearbyme/DanaMapFragment;", "readMicros", "Lkotlin/Lazy;", "Lid/dana/utils/MapHelper;", "mapHelper", "Lid/dana/utils/MapHelper;", "getMapHelper", "()Lid/dana/utils/MapHelper;", "setMapHelper", "(Lid/dana/utils/MapHelper;)V", "Lid/dana/nearbyme/MerchantContract$Presenter;", "merchantCategoryPresenter", "Lid/dana/nearbyme/MerchantContract$Presenter;", "getMerchantCategoryPresenter", "()Lid/dana/nearbyme/MerchantContract$Presenter;", "setMerchantCategoryPresenter", "(Lid/dana/nearbyme/MerchantContract$Presenter;)V", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;", "merchantDetailPresenter", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;", "getMerchantDetailPresenter", "()Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;", "setMerchantDetailPresenter", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailContract$Presenter;)V", "Lid/dana/base/LockableBaseBottomSheetBehavior;", "Landroid/widget/FrameLayout;", "getCallingPid", "whenAvailable", "SubSequence", "Lcom/google/android/gms/maps/model/Marker;", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "getNearbyAnalyticTracker", "()Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "setNearbyAnalyticTracker", "(Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;)V", "Lid/dana/contract/nearbyme/NearbyMeContract$Presenter;", "nearbyPresenter", "Lid/dana/contract/nearbyme/NearbyMeContract$Presenter;", "getNearbyPresenter", "()Lid/dana/contract/nearbyme/NearbyMeContract$Presenter;", "setNearbyPresenter", "(Lid/dana/contract/nearbyme/NearbyMeContract$Presenter;)V", "getSupportButtonTintMode", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "photoPreviewPresenter", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "getPhotoPreviewPresenter", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "setPhotoPreviewPresenter", "(Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;)V", "Lid/dana/nearbyrevamp/NewNearbyMeActivity$RefreshCondition;", DiskFormatter.B, "Lid/dana/nearbyrevamp/NewNearbyMeActivity$RefreshCondition;", "(Lid/dana/nearbyrevamp/NewNearbyMeActivity$RefreshCondition;)V", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Ljava/util/LinkedHashMap;", "A", "C", "VerifyPinStateManager$executeRiskChallenge$2$1", "<init>", "Companion", "MapState", "RefreshCondition"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NewNearbyMeActivity extends BaseActivityWithPageLoadTracker implements OnMapReadyCallback, MerchantDetailInteraction {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int D = 0;
    private static short[] E = null;
    public static final String EXTRA_TARGET_SCREEN = "targetScreen";
    public static final String NEARBY_DETAIL_BOTTOMSHEET = "nearby_detail_bottomsheet";
    private static int VerifyPinStateManager$executeRiskChallenge$2$2;
    private static int getOnBoardingScenario;
    private static byte[] getValueOfTouchPositionAbsolute;

    /* renamed from: A  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: C  reason: from kotlin metadata */
    private final Lazy whenAvailable;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Drawable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private Disposable isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private HighlightedShopModel getErrorConfigVersion;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private Marker NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private Location SubSequence;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private int getAuthRequestContext;
    @Inject
    public MapHelper mapHelper;
    @Inject
    public MerchantContract.Presenter merchantCategoryPresenter;
    @Inject
    public MerchantDetailContract.Presenter merchantDetailPresenter;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;
    @Inject
    public NearbyMeContract.Presenter nearbyPresenter;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private Location moveToNextValue;
    @Inject
    public PhotoGalleryContract.Presenter photoPreviewPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    public static final byte[] $$g = {Ascii.RS, 119, -63, 113, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 242;
    public static final byte[] lookAheadTest = {107, 78, -84, 46, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getErrorConfigVersion = 86;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean initRecordTimeStamp = true;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Location NetworkUserEntityData$$ExternalSyntheticLambda0 = LocationUtil.getAuthRequestContext();

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private LinkedHashMap<String, Marker> FragmentBottomSheetPaymentSettingBinding = new LinkedHashMap<>();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private Pair<? extends Marker, ? extends Marker> lookAheadTest = new Pair<>(null, null);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean PlaceComponentResult = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory = 2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private MapState scheduleImpl = MapState.MERCHANT_LIST;

    /* renamed from: B */
    private RefreshCondition NetworkUserEntityData$$ExternalSyntheticLambda3 = RefreshCondition.INIT;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final Lazy PrepareContext = LazyKt.lazy(new Function0<LockableBaseBottomSheetBehavior<FrameLayout>>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$merchantListBottomsheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LockableBaseBottomSheetBehavior<FrameLayout> invoke() {
            return (LockableBaseBottomSheetBehavior) BottomSheetBehavior.from((FrameLayout) NewNearbyMeActivity.this._$_findCachedViewById(R.id.res_0x7f0a071a_amountformfragment_onbackpressedcallback_1));
        }
    });

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda7 = LazyKt.lazy(new Function0<LockableBaseBottomSheetBehavior<FrameLayout>>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$merchantOtherStoreBottomsheet$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LockableBaseBottomSheetBehavior<FrameLayout> invoke() {
            return (LockableBaseBottomSheetBehavior) BottomSheetBehavior.from((FrameLayout) NewNearbyMeActivity.this._$_findCachedViewById(R.id.flBottomsheetOtherMerchant));
        }
    });

    /* renamed from: readMicros  reason: from kotlin metadata */
    private final Lazy newProxyInstance = LazyKt.lazy(new Function0<DanaMapFragment>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$mapFragment$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaMapFragment invoke() {
            Fragment findFragmentById = NewNearbyMeActivity.this.getSupportFragmentManager().findFragmentById(R.id.map);
            if (findFragmentById instanceof DanaMapFragment) {
                return (DanaMapFragment) findFragmentById;
            }
            return null;
        }
    });

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2 = {"Lid/dana/nearbyrevamp/NewNearbyMeActivity$MapState;", "", "<init>", "(Ljava/lang/String;I)V", "MERCHANT_LIST", "MERCHANT_OTHER_STORE", "MERCHANT_DETAIL_DEEPLINK", "SEARCH_RESULT"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum MapState {
        MERCHANT_LIST,
        MERCHANT_OTHER_STORE,
        MERCHANT_DETAIL_DEEPLINK,
        SEARCH_RESULT
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2 = {"Lid/dana/nearbyrevamp/NewNearbyMeActivity$RefreshCondition;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "ERROR", NearbyMeActivity.RefreshCondition.FETCHED, NearbyMeActivity.RefreshCondition.REFRESHING}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum RefreshCondition {
        INIT,
        ERROR,
        FETCHED,
        REFRESHING
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[MapState.values().length];
            iArr[MapState.SEARCH_RESULT.ordinal()] = 1;
            iArr[MapState.MERCHANT_OTHER_STORE.ordinal()] = 2;
            iArr[MapState.MERCHANT_LIST.ordinal()] = 3;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        D = 1257195667;
        getOnBoardingScenario = 1861996611;
        getValueOfTouchPositionAbsolute = new byte[]{-100, 99, 108, -107, -117, 68, -102, -108, 108, -110, 106, -114, -67, -116, 33, -97, -112, -84, 85, 100, 101, 98, -111, 105, -110, 96, -103, 106, -116, 97, 101, 98, 99, -97, -80, 82, -103, -106, 108, -97, 98, -115, -97, -111, -99, 107, 98, -67, -67, 36, -101, -34, 85, 100, 101, 98, -111, 105, -110, 100, -117, 67, -109, -80, -100, 78, -77, -99, 81, -80, -104, 103, 96, 76, -78, -104, 99, 98, 75, -101, 98, -83, 81, -77, -102, 80, -79, 76, -97, 96, -100, -76, -102, -97, 100, -102, 96, 82, 96, -100, 97, -79, 96, 96, 74, -85, 103, -99, 76, -77, 80, -77, -104, 80, 96, -83, -98, 96, -98, 102, 97, -97, -99, -101, -97, 99, -103, 101, 75, -83, 83, -86, 100, -99, -100, 82, -97, -76, -101, 79, -98, -82, -97, 81, -77, 76, -77, 72, -77, -100, 98, -102, 82, -84, 84, -85, -97, 97, -100, -97, 82, -80, 99, 73, 96, -77, -105, 104, 76, -99, -79, -98, 75, -101, -97, 80, -81, 98, -101, 97, -99, 80, -86, 96, 82, -99, -75, 76, -101, -98, -82, 103, -101, -100, 84, -79, -97, -99, 96, 74, -75, -103, 81, -78, 75, -77, 78, -97, -79, 96, 76, -80, -101, 77, 96, -81, 81, -81, 80, -101, -75, -104, 98, -99, -97, 102, -97, -97, -101, -99, 100, 97, 72, 98, -85, 96, 96, -103, -106, 112, -114, -87, 98, 35, -40, 36, -98, -111, 97, 102, -102, -91, 89, 102, -112, -83, 93, 97, -109, -86, 86, 108, -114, 115, -101, 97, -112, 109, -114, 115, -111, -90, 37, -98, -115, 97, 112, -116, 99, 108, -107, 107, -39, 82, 108, -110, 98, -86, -97, 106, 88, -100, 99, -97, -109, 96, -101, 101, -103, 106, -97, -97, -97, -97, -97, -97, -97, -97, -97};
        VerifyPinStateManager$executeRiskChallenge$2$2 = 56728726;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0023 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.drawable.NewNearbyMeActivity.lookAheadTest
            int r6 = r6 + 97
            int r8 = r8 + 16
            int r7 = 56 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2e
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
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2e:
            int r7 = r7 + 1
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.NewNearbyMeActivity.g(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.drawable.NewNearbyMeActivity.$$g
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r6 = r6 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-7)
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.NewNearbyMeActivity.j(short, byte, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void openMerchantDetailBottomsheet(Context context, ShopModel shopModel, String str) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, shopModel, str);
    }

    @JvmStatic
    public static final void openMerchantDetailBottomsheet(Context context, String str, String str2, String str3) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, str, str2, str3);
    }

    @JvmStatic
    public static final void openOtherStoreBottomsheet(Context context, String str, String str2) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, str, str2);
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
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

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Method method;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        h(MotionEvent.axisFromString("") - 605329530, (-1234097119) - Gravity.getAbsoluteGravity(0, 0), (short) TextUtils.getTrimmedLength(""), (byte) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 6 - Drawable.resolveOpacity(0, 0), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        h((-605329519) - Gravity.getAbsoluteGravity(0, 0), MotionEvent.axisFromString("") - 1234097101, (short) ((Process.getThreadPriority(0) + 20) >> 6), (byte) ((-1) - TextUtils.lastIndexOf("", '0', 0)), (ViewConfiguration.getPressedStateDuration() >> 16) - 7, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    h(TextUtils.indexOf((CharSequence) "", '0') - 605329572, TextUtils.lastIndexOf("", '0') - 1234097097, (short) (ViewConfiguration.getScrollBarSize() >> 8), (byte) (TextUtils.lastIndexOf("", '0') + 1), Process.getGidForName("") + 37, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    h((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 605329532, (-1234097051) - KeyEvent.keyCodeFromString(""), (short) View.MeasureSpec.getMode(0), (byte) KeyEvent.getDeadChar(0, 0), 52 - ((Process.getThreadPriority(0) + 20) >> 6), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    h(View.combineMeasuredStates(0, 0) - 605329578, (-1234096988) - Color.alpha(0), (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (byte) KeyEvent.normalizeMetaState(0), TextUtils.indexOf("", "", 0, 0) + 52, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    h((-605329523) - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1234096926, (short) ExpandableListView.getPackedPositionType(0L), (byte) (ImageFormat.getBitsPerPixel(0) + 1), Color.argb(0, 0, 0, 0) + 48, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    h(Color.red(0) - 605329571, (-1234096866) - Color.alpha(0), (short) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1), (byte) View.MeasureSpec.getSize(0), (-6) - (ViewConfiguration.getPressedStateDuration() >> 16), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) Color.red(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = new Object[1];
                g((byte) (-lookAheadTest[32]), (byte) (-lookAheadTest[31]), lookAheadTest[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (lookAheadTest[30] + 1);
                Object[] objArr14 = new Object[1];
                g(b, (byte) (b | 22), lookAheadTest[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.red(0) + 3, (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        byte b2 = $$g[78];
                        byte b3 = $$g[47];
                        Object[] objArr16 = new Object[1];
                        j(b2, b3, b3, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 14 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (KeyEvent.getMaxKeyCode() >> 16), 16 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getCapsMode("", 0, 0), MotionEvent.axisFromString("") + 30, (char) (57994 - Color.blue(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getTrimmedLength(""), 15 - Color.red(0), (char) (ViewConfiguration.getEdgeSlop() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-305017630, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = new Object[1];
                g((byte) (-lookAheadTest[32]), (byte) (-lookAheadTest[31]), lookAheadTest[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = (byte) (lookAheadTest[30] + 1);
                Object[] objArr20 = new Object[1];
                g(b4, (byte) (b4 | 22), lookAheadTest[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 60, TextUtils.indexOf("", "", 0, 0) + 46, (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr22 = new Object[1];
                        j((byte) (-$$g[28]), (byte) (-$$g[9]), (byte) ($$g[47] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r4 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.getDeadChar(0, 0) + 35, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-305017630, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), AndroidCharacter.getMirror('0') - 30, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr25 = new Object[1];
                g((byte) (-lookAheadTest[32]), (byte) (-lookAheadTest[31]), lookAheadTest[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (lookAheadTest[30] + 1);
                Object[] objArr26 = new Object[1];
                g(b5, (byte) (b5 | 22), lookAheadTest[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 3, (char) (38968 - Color.blue(0)));
                        Object[] objArr28 = new Object[1];
                        j((byte) (-$$g[28]), (byte) (-$$g[9]), (byte) ($$g[47] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r4 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-305017630, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), TextUtils.getOffsetAfter("", 0) + 18, (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr31 = new Object[1];
                g((byte) (-lookAheadTest[32]), (byte) (-lookAheadTest[31]), lookAheadTest[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b6 = (byte) (lookAheadTest[30] + 1);
                Object[] objArr32 = new Object[1];
                g(b6, (byte) (b6 | 22), lookAheadTest[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 107, 3 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) Color.red(0));
                        Object[] objArr34 = new Object[1];
                        j($$g[40], (byte) ($$g[47] - 1), (byte) (-$$g[8]), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r4 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                method = obj16;
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, 35 - Color.green(0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke6 = ((Method) method).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-305017630, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final /* synthetic */ void dismissLoadingDialog() {
        MerchantDetailInteraction.CC.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_new_nearby_me;
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        h((-605329530) - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (-1234097118) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (short) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (byte) (super.getResources().getString(R.string.ep_paylater_activation_tnc_remark).substring(39, 40).length() - 1), super.getResources().getString(R.string.unbind_dialog_confirmation_title).substring(15, 16).codePointAt(0) - 91, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        int codePointAt = super.getResources().getString(R.string.otp_error_invalid_otp).substring(1, 2).codePointAt(0) - 605329616;
        int length = getPackageName().length() - 1234097109;
        try {
            byte b = lookAheadTest[25];
            Object[] objArr3 = new Object[1];
            g(b, (byte) (b | TarHeader.LF_BLK), lookAheadTest[30], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
            Object[] objArr4 = new Object[1];
            h(codePointAt, length, (short) (((ApplicationInfo) cls2.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33), (byte) (getPackageName().length() - 7), super.getResources().getString(R.string.danapoly_banner_you_are_lucky).substring(8, 9).codePointAt(0) - 124, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    try {
                        byte b2 = lookAheadTest[25];
                        Object[] objArr5 = new Object[1];
                        g(b2, (byte) (b2 | TarHeader.LF_BLK), lookAheadTest[30], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], objArr6);
                        int i = ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion - 605329564;
                        try {
                            byte b3 = lookAheadTest[25];
                            Object[] objArr7 = new Object[1];
                            g(b3, (byte) (b3 | TarHeader.LF_BLK), lookAheadTest[30], objArr7);
                            Class<?> cls4 = Class.forName((String) objArr7[0]);
                            Object[] objArr8 = new Object[1];
                            g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], objArr8);
                            int i2 = ((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion - 1234097194;
                            short s = (short) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1));
                            byte rgb = (byte) (Color.rgb(0, 0, 0) + 16777216);
                            try {
                                byte b4 = lookAheadTest[25];
                                Object[] objArr9 = new Object[1];
                                g(b4, (byte) (b4 | TarHeader.LF_BLK), lookAheadTest[30], objArr9);
                                Class<?> cls5 = Class.forName((String) objArr9[0]);
                                g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
                                Object[] objArr10 = new Object[1];
                                h(i, i2, s, rgb, ((ApplicationInfo) cls5.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 19, objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                int length2 = getPackageName().length() - 605329536;
                                int lastIndexOf = (-1234097137) - TextUtils.lastIndexOf("", '0');
                                short codePointAt2 = (short) (getPackageName().codePointAt(5) - 110);
                                try {
                                    byte b5 = lookAheadTest[25];
                                    Object[] objArr11 = new Object[1];
                                    g(b5, (byte) (b5 | TarHeader.LF_BLK), lookAheadTest[30], objArr11);
                                    Class<?> cls7 = Class.forName((String) objArr11[0]);
                                    g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
                                    Object[] objArr12 = new Object[1];
                                    h(length2, lastIndexOf, codePointAt2, (byte) (((ApplicationInfo) cls7.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.bottomsheet_no_asset_subtittle).substring(18, 20).codePointAt(1) - 95, objArr12);
                                    baseContext = (Context) cls6.getMethod((String) objArr12[0], new Class[0]).invoke(null, null);
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
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        int codePointAt3 = super.getResources().getString(R.string.res_0x7f130439_networkuserentitydata_externalsyntheticlambda0).substring(1, 2).codePointAt(0) - 605329670;
                        try {
                            byte b6 = lookAheadTest[25];
                            Object[] objArr13 = new Object[1];
                            g(b6, (byte) (b6 | TarHeader.LF_BLK), lookAheadTest[30], objArr13);
                            Class<?> cls8 = Class.forName((String) objArr13[0]);
                            g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
                            Object[] objArr14 = new Object[1];
                            h(codePointAt3, ((ApplicationInfo) cls8.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 1234097131, (short) (TextUtils.lastIndexOf("", '0', 0) + 1), (byte) ExpandableListView.getPackedPositionGroup(0L), 36 - (ViewConfiguration.getTouchSlop() >> 8), objArr14);
                            String str = (String) objArr14[0];
                            int length3 = super.getResources().getString(R.string.zdoc_title).substring(0, 5).length() - 605329536;
                            int length4 = super.getResources().getString(R.string.referral_too_much_attempt_message).substring(9, 10).length() - 1234097052;
                            short codePointAt4 = (short) (getPackageName().codePointAt(4) - 97);
                            byte length5 = (byte) (super.getResources().getString(R.string.family_account_setting_revoked_subtitle).substring(13, 14).length() - 1);
                            try {
                                byte b7 = lookAheadTest[25];
                                Object[] objArr15 = new Object[1];
                                g(b7, (byte) (b7 | TarHeader.LF_BLK), lookAheadTest[30], objArr15);
                                Class<?> cls9 = Class.forName((String) objArr15[0]);
                                Object[] objArr16 = new Object[1];
                                g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], objArr16);
                                Object[] objArr17 = new Object[1];
                                h(length3, length4, codePointAt4, length5, ((ApplicationInfo) cls9.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 19, objArr17);
                                String str2 = (String) objArr17[0];
                                Object[] objArr18 = new Object[1];
                                h(super.getResources().getString(R.string.near_merchant).substring(1, 2).length() - 605329579, super.getResources().getString(R.string.updates_ready_to_install).substring(9, 12).length() - 1234096991, (short) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (byte) (getPackageName().codePointAt(1) - 100), super.getResources().getString(R.string.tooltip_dana_cicil_available_description).substring(0, 1).length() + 51, objArr18);
                                String str3 = (String) objArr18[0];
                                try {
                                    byte b8 = lookAheadTest[25];
                                    Object[] objArr19 = new Object[1];
                                    g(b8, (byte) (b8 | TarHeader.LF_BLK), lookAheadTest[30], objArr19);
                                    Class<?> cls10 = Class.forName((String) objArr19[0]);
                                    Object[] objArr20 = new Object[1];
                                    g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], objArr20);
                                    int i3 = ((ApplicationInfo) cls10.getMethod((String) objArr20[0], null).invoke(this, null)).targetSdkVersion - 605329557;
                                    try {
                                        byte b9 = lookAheadTest[25];
                                        Object[] objArr21 = new Object[1];
                                        g(b9, (byte) (b9 | TarHeader.LF_BLK), lookAheadTest[30], objArr21);
                                        Class<?> cls11 = Class.forName((String) objArr21[0]);
                                        g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
                                        Object[] objArr22 = new Object[1];
                                        h(i3, ((ApplicationInfo) cls11.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 1234096958, (short) (getPackageName().length() - 7), (byte) (super.getResources().getString(R.string.family_account_success_remove_family_member_message).substring(16, 17).length() - 1), super.getResources().getString(R.string.negative_referral_engagement_dialog_button).substring(1, 2).length() + 47, objArr22);
                                        String str4 = (String) objArr22[0];
                                        int i4 = (-605329570) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1));
                                        int length6 = super.getResources().getString(R.string.loyalty_header_title).substring(0, 7).length() - 1234096873;
                                        short longPressTimeout = (short) (ViewConfiguration.getLongPressTimeout() >> 16);
                                        byte modifierMetaStateMask = (byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 1);
                                        try {
                                            byte b10 = lookAheadTest[25];
                                            Object[] objArr23 = new Object[1];
                                            g(b10, (byte) (b10 | TarHeader.LF_BLK), lookAheadTest[30], objArr23);
                                            Class<?> cls12 = Class.forName((String) objArr23[0]);
                                            g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
                                            Object[] objArr24 = new Object[1];
                                            h(i4, length6, longPressTimeout, modifierMetaStateMask, ((ApplicationInfo) cls12.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 39, objArr24);
                                            try {
                                                Object[] objArr25 = {baseContext, str, str2, str3, str4, true, (String) objArr24[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr25);
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
            }
            try {
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                g((byte) (-lookAheadTest[32]), (byte) (-lookAheadTest[31]), lookAheadTest[25], objArr27);
                Class<?> cls13 = Class.forName((String) objArr27[0]);
                byte b11 = (byte) (lookAheadTest[30] + 1);
                Object[] objArr28 = new Object[1];
                g(b11, (byte) (b11 | 22), lookAheadTest[25], objArr28);
                try {
                    Object[] objArr29 = {Integer.valueOf(((Integer) cls13.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls14 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 4 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                        Object[] objArr30 = new Object[1];
                        j($$g[40], (byte) ($$g[47] - 1), (byte) (-$$g[8]), objArr30);
                        obj3 = cls14.getMethod((String) objArr30[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj3).invoke(null, objArr29);
                    int i5 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i5) {
                        long j = ((r0 ^ i5) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, 35 - View.MeasureSpec.getSize(0), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr32 = {1787784091, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, 18 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr32);
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
                    super.onCreate(bundle);
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
        } catch (Throwable th16) {
            Throwable cause16 = th16.getCause();
            if (cause16 == null) {
                throw th16;
            }
            throw cause16;
        }
    }

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final /* synthetic */ void onImageLoaded(List list) {
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Class<?> cls;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            h(super.getResources().getString(R.string.internet_description).substring(6, 7).codePointAt(0) - 605329563, getPackageName().length() - 1234097168, (short) (super.getResources().getString(R.string.option_continue).substring(2, 3).codePointAt(0) - 110), (byte) (super.getResources().getString(R.string.card_binding_success_save_card_text).substring(0, 5).length() - 5), 15 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr);
            Class<?> cls2 = Class.forName((String) objArr[0]);
            try {
                byte b = lookAheadTest[25];
                Object[] objArr2 = new Object[1];
                g(b, (byte) (b | TarHeader.LF_BLK), lookAheadTest[30], objArr2);
                cls = Class.forName((String) objArr2[0]);
                g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr3 = new Object[1];
                h(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 605329562, (-1234097136) - (ViewConfiguration.getTouchSlop() >> 8), (short) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (byte) (super.getResources().getString(R.string.investment_me_title).substring(9, 10).length() - 1), getPackageName().codePointAt(5) - 104, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), 18 - ExpandableListView.getPackedPositionType(0L), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onPause();
    }

    public final /* synthetic */ ShopModel provideShopModel() {
        return MerchantDetailInteraction.CC.getAuthRequestContext();
    }

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final /* synthetic */ void showLoadingDialog() {
        MerchantDetailInteraction.CC.PlaceComponentResult();
    }

    public NewNearbyMeActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$locationPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    if (LocationUtil.getAuthRequestContext(NewNearbyMeActivity.this)) {
                        MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(NewNearbyMeActivity.this.getApplicationContext(), true);
                        NewNearbyMeActivity.this.GetContactSyncConfig();
                        return;
                    }
                    NewNearbyMeActivity.access$showLocationRequest(NewNearbyMeActivity.this);
                } else if (PermissionHelper.KClassImpl$Data$declaredNonStaticMembers$2(NewNearbyMeActivity.this, p0.BuiltInFictitiousFunctionClassFactory.get(0).KClassImpl$Data$declaredNonStaticMembers$2)) {
                } else {
                    MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(NewNearbyMeActivity.this.getApplicationContext(), false);
                    NewNearbyMeActivity.this.finish();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PermissionHelper.MyBillsEntityDataFactory(NewNearbyMeActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.PlaceComponentResult();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$shouldOpenMerchantDetail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle extras;
                Intent intent = NewNearbyMeActivity.this.getIntent();
                return Boolean.valueOf(Intrinsics.areEqual((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString(NewNearbyMeActivity.EXTRA_TARGET_SCREEN), NewNearbyMeActivity.NEARBY_DETAIL_BOTTOMSHEET));
            }
        });
        this.whenAvailable = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$shouldOpenOtherStore$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Bundle extras;
                Intent intent = NewNearbyMeActivity.this.getIntent();
                return Boolean.valueOf(Intrinsics.areEqual((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString(NewNearbyMeActivity.EXTRA_TARGET_SCREEN), "nearby_other_store"));
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = "";
        this.DatabaseTableConfigUtil = true;
        this.moveToNextValue = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(RefreshCondition refreshCondition) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = refreshCondition;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MobilePaymentLoginRequest);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(NetworkUserEntityData$$ExternalSyntheticLambda6() ? 0 : 8);
        }
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

    @JvmName(name = "getNearbyPresenter")
    public final NearbyMeContract.Presenter getNearbyPresenter() {
        NearbyMeContract.Presenter presenter = this.nearbyPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyPresenter")
    public final void setNearbyPresenter(NearbyMeContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.nearbyPresenter = presenter;
    }

    @JvmName(name = "getMerchantDetailPresenter")
    public final MerchantDetailContract.Presenter getMerchantDetailPresenter() {
        MerchantDetailContract.Presenter presenter = this.merchantDetailPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMerchantDetailPresenter")
    public final void setMerchantDetailPresenter(MerchantDetailContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.merchantDetailPresenter = presenter;
    }

    @JvmName(name = "getMerchantCategoryPresenter")
    public final MerchantContract.Presenter getMerchantCategoryPresenter() {
        MerchantContract.Presenter presenter = this.merchantCategoryPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMerchantCategoryPresenter")
    public final void setMerchantCategoryPresenter(MerchantContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.merchantCategoryPresenter = presenter;
    }

    @JvmName(name = "getPhotoPreviewPresenter")
    public final PhotoGalleryContract.Presenter getPhotoPreviewPresenter() {
        PhotoGalleryContract.Presenter presenter = this.photoPreviewPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPhotoPreviewPresenter")
    public final void setPhotoPreviewPresenter(PhotoGalleryContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.photoPreviewPresenter = presenter;
    }

    @JvmName(name = "getNearbyAnalyticTracker")
    public final NearbyAnalyticTracker getNearbyAnalyticTracker() {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker != null) {
            return nearbyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyAnalyticTracker")
    public final void setNearbyAnalyticTracker(NearbyAnalyticTracker nearbyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(nearbyAnalyticTracker, "");
        this.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    @JvmName(name = "lookAheadTest")
    private final boolean lookAheadTest() {
        return ((Boolean) this.NetworkUserEntityData$$ExternalSyntheticLambda4.getValue()).booleanValue();
    }

    @JvmName(name = "scheduleImpl")
    private final boolean scheduleImpl() {
        return ((Boolean) this.whenAvailable.getValue()).booleanValue();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = getPackageName().codePointAt(1) - 605329631;
            int codePointAt2 = (-1234097261) + getPackageName().codePointAt(3);
            short length = (short) (super.getResources().getString(R.string.request_money_amount_calculator_action).substring(2, 3).length() - 1);
            try {
                byte b = lookAheadTest[25];
                Object[] objArr = new Object[1];
                g(b, (byte) (b | TarHeader.LF_BLK), lookAheadTest[30], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
                Object[] objArr2 = new Object[1];
                h(codePointAt, codePointAt2, length, (byte) (((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), getPackageName().codePointAt(5) - 96, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                int i = (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) - 605329529;
                int codePointAt3 = super.getResources().getString(R.string.referral_tracker_register).substring(0, 8).codePointAt(1) - 1234097237;
                try {
                    byte b2 = lookAheadTest[25];
                    Object[] objArr3 = new Object[1];
                    g(b2, (byte) (b2 | TarHeader.LF_BLK), lookAheadTest[30], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    g(lookAheadTest[5], lookAheadTest[25], lookAheadTest[8], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    h(i, codePointAt3, (short) (((ApplicationInfo) cls3.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), (byte) (super.getResources().getString(R.string.make_sure_your_card_number_visible_description).substring(0, 4).length() - 4), super.getResources().getString(R.string.setting_security_settings).substring(1, 2).codePointAt(0) - 95, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.getDefaultSize(0, 0), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onResume();
        ViewCompat.MyBillsEntityDataFactory(getWindow().getDecorView(), new OnApplyWindowInsetsListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return NewNearbyMeActivity.$r8$lambda$lMYm3sSU6KsEkVa_fTyA62vBFmM(NewNearbyMeActivity.this, view, windowInsetsCompat);
            }
        });
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        getWindow().setFlags(512, 512);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.view_gradient);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "");
        _$_findCachedViewById.setVisibility(0);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ShopModel p0) {
        p0.getValueOfTouchPositionAbsolute = !Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, "Home");
        p0.whenAvailable = 1;
        p0.A = 1;
        getMerchantCategoryPresenter().PlaceComponentResult(CollectionsKt.mutableListOf(p0), 1);
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.showMerchantDetailFromNonMaps(p0, this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            if (merchantDetailBottomsheetView.isMerchantDetailFullyDisplayed() || merchantDetailBottomsheetView.isMerchantDetailPreviewDisplayed()) {
                this.getErrorConfigVersion = new HighlightedShopModel(p0);
                getPhotoPreviewPresenter().BuiltInFictitiousFunctionClassFactory(p0);
            }
        }
        NewMerchantListView newMerchantListView = (NewMerchantListView) _$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            NewMerchantListView.setMerchantList$default(newMerchantListView, CollectionsKt.mutableListOf(p0), 0, 2, null);
        }
        PlaceComponentResult(CollectionsKt.mutableListOf(p0));
        MapHelper mapHelper = getMapHelper();
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(LocationUtil.PlaceComponentResult(p0.DatabaseTableConfigUtil, p0.PrepareContext));
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            googleMap.animateCamera(MapHelper.getAuthRequestContext(authRequestContext, 15.0f));
        }
    }

    static /* synthetic */ void getAuthRequestContext$default(NewNearbyMeActivity newNearbyMeActivity, Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        newNearbyMeActivity.getAuthRequestContext(th, str);
    }

    public final void getAuthRequestContext(Throwable p0, String p1) {
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.setNonDraggableExpandBottomsheet();
        }
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.showErrorState(true);
            merchantDetailView.trackDisplayedErrorMessage(p0, p1);
        }
        NewMerchantListView newMerchantListView = (NewMerchantListView) _$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.showEmptyState();
        }
        BuiltInFictitiousFunctionClassFactory(true);
        setTitle(getString(R.string.merchant_detail));
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        Location location;
        GoogleMap googleMap = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            LatLng latLng = googleMap.getCameraPosition().target;
            location = LocationUtil.PlaceComponentResult(latLng.latitude, latLng.longitude);
        } else {
            location = null;
        }
        if (location != null) {
            this.moveToNextValue = location;
            getNearbyPresenter().DatabaseTableConfigUtil();
            getNearbyPresenter().getAuthRequestContext(location, 5000, false);
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Location p0) {
        this.moveToNextValue = p0;
        MapHelper mapHelper = getMapHelper();
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(p0);
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            googleMap.animateCamera(MapHelper.getAuthRequestContext(authRequestContext, 15.0f));
        }
        PlaceComponentResult();
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.reset();
        }
        MerchantDetailBottomsheetView merchantDetailBottomsheetView2 = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView2 != null) {
            merchantDetailBottomsheetView2.hideMerchantDetailBottomsheet();
        }
        getNearbyPresenter().DatabaseTableConfigUtil();
        getNearbyPresenter().getAuthRequestContext(p0, 5000, false);
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda6() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda3 == RefreshCondition.ERROR) {
            DanaMapFragment danaMapFragment = (DanaMapFragment) this.newProxyInstance.getValue();
            return (danaMapFragment != null && danaMapFragment.getKClassImpl$Data$declaredNonStaticMembers$2()) && PrepareContext();
        }
        return false;
    }

    private final boolean PrepareContext() {
        return isLayoutRequested() || this.scheduleImpl == MapState.MERCHANT_DETAIL_DEEPLINK;
    }

    public final void moveToNextValue(boolean p0) {
        endTimer(new TimerEvent(TimerEventKey.NEARBY_OPEN, MapsKt.hashMapOf(new Pair("With Maps Load", String.valueOf(p0)), TuplesKt.to("Source", this.NetworkUserEntityData$$ExternalSyntheticLambda5)), this.initRecordTimeStamp));
        this.initRecordTimeStamp = false;
    }

    private final void MyBillsEntityDataFactory(List<ShopModel> p0) {
        NewMerchantListView newMerchantListView = (NewMerchantListView) _$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.setMerchantList(p0, getNearbyPresenter().KClassImpl$Data$declaredNonStaticMembers$2());
            newMerchantListView.setCenterRecyclerView(BottomsheetBehaviorExtKt.PlaceComponentResult((LockableBaseBottomSheetBehavior) this.PrepareContext.getValue()));
            PlaceComponentResult(newMerchantListView.getMerchantList());
            if (getNearbyPresenter().lookAheadTest() && (!p0.isEmpty()) == true) {
                newMerchantListView.showLoadMore();
            }
        }
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker
    public final void onTimerEnd(TimerEvent timerEvent, long millisecond) {
        Intrinsics.checkNotNullParameter(timerEvent, "");
        track(this, timerEvent, millisecond);
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        if (Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, "Home")) {
            moveToNextValue(false);
        }
    }

    public final void PlaceComponentResult(boolean p0) {
        getAuthRequestContext(p0);
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MobilePaymentLoginRequest);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(p0 && NetworkUserEntityData$$ExternalSyntheticLambda6() ? 0 : 8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0023, code lost:
    
        if ((r4 != null && r4.getKClassImpl$Data$declaredNonStaticMembers$2()) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(boolean r4) {
        /*
            r3 = this;
            int r0 = id.dana.R.id.cvGoToMyLocation
            android.view.View r0 = r3._$_findCachedViewById(r0)
            androidx.cardview.widget.CardView r0 = (androidx.cardview.widget.CardView) r0
            if (r0 == 0) goto L2f
            android.view.View r0 = (android.view.View) r0
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L26
            kotlin.Lazy r4 = r3.newProxyInstance
            java.lang.Object r4 = r4.getValue()
            id.dana.nearbyme.DanaMapFragment r4 = (id.dana.nearbyme.DanaMapFragment) r4
            if (r4 == 0) goto L22
            boolean r4 = r4.getKClassImpl$Data$declaredNonStaticMembers$2()
            if (r4 != r1) goto L22
            r4 = 1
            goto L23
        L22:
            r4 = 0
        L23:
            if (r4 == 0) goto L26
            goto L27
        L26:
            r1 = 0
        L27:
            if (r1 == 0) goto L2a
            goto L2c
        L2a:
            r2 = 8
        L2c:
            r0.setVisibility(r2)
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.NewNearbyMeActivity.getAuthRequestContext(boolean):void");
    }

    public final void PlaceComponentResult(int p0) {
        View _$_findCachedViewById;
        if (BuiltInFictitiousFunctionClassFactory(p0) || (_$_findCachedViewById = _$_findCachedViewById(R.id.actualDraw)) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = _$_findCachedViewById.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        layoutParams2.moveToNextValue = null;
        layoutParams2.getErrorConfigVersion = null;
        layoutParams2.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(int p0) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.actualDraw);
        ViewGroup.LayoutParams layoutParams = _$_findCachedViewById != null ? _$_findCachedViewById.getLayoutParams() : null;
        if (layoutParams != null) {
            return ((CoordinatorLayout.LayoutParams) layoutParams).NetworkUserEntityData$$ExternalSyntheticLambda0 == p0;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.toolbar_layout);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(p0 ? 0 : 8);
        }
        AppBarLayout appBarLayout = (AppBarLayout) _$_findCachedViewById(R.id.res_0x7f0a0094_networkuserentitydata_externalsyntheticlambda0);
        if (appBarLayout != null) {
            appBarLayout.setVisibility(p0 ? 0 : 4);
        }
    }

    public final void PlaceComponentResult(String p0) {
        String str = p0;
        if (str.length() == 0) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.setDanaContactPresenter);
            if (appCompatTextView != null) {
                appCompatTextView.setText(getString(R.string.search_nearby_hint));
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.setDanaContactPresenter);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.f27012131100470));
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id._release);
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(8);
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.setDanaContactPresenter);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(str);
        }
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) _$_findCachedViewById(R.id.setDanaContactPresenter);
        if (appCompatTextView4 != null) {
            appCompatTextView4.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.f22832131099732));
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id._release);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r2, int resultCode, Intent data) {
        if (data != null && r2 == 100) {
            if (resultCode == -1) {
                GetContactSyncConfig();
            } else if (resultCode == 0) {
                finish();
            }
        }
        super.onActivityResult(r2, resultCode, data);
    }

    public final void GetContactSyncConfig() {
        if (getErrorConfigVersion()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LocationUtil.getAuthRequestContext();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.check();
            return;
        }
        Disposable disposable = this.isLayoutRequested;
        if (disposable != null) {
            disposable.dispose();
        }
        this.isLayoutRequested = null;
        this.getAuthRequestContext = 0;
        Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewNearbyMeActivity.m2738$r8$lambda$gqON97v3r76qBr_OQ_VQVgy1Q(NewNearbyMeActivity.this, (Location) obj);
            }
        });
        this.isLayoutRequested = subscribe;
        addDisposable(subscribe);
    }

    private final boolean getErrorConfigVersion() {
        return OSUtil.GetContactSyncConfig() && ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, "android.permission.ACCESS_FINE_LOCATION") != 0;
    }

    private final void initRecordTimeStamp() {
        NetworkUserEntityData$$ExternalSyntheticLambda3();
        Location location = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (location != null) {
            MapHelper mapHelper = getMapHelper();
            LatLng BuiltInFictitiousFunctionClassFactory = NearbyExtensionKt.BuiltInFictitiousFunctionClassFactory(location);
            GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
            if (googleMap != null) {
                googleMap.animateCamera(MapHelper.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, 16.0f));
            }
        }
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[this.scheduleImpl.ordinal()];
        if (i == 2) {
            newProxyInstance();
        } else if (i == 3) {
            moveToNextValue();
        }
    }

    public final void moveToNextValue() {
        this.moveToNextValue = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        getNearbyPresenter().DatabaseTableConfigUtil();
        if (this.SubSequence != null) {
            this.PlaceComponentResult = false;
            getNearbyPresenter().getAuthRequestContext(this.SubSequence, 5000, false);
            this.SubSequence = null;
            return;
        }
        getNearbyPresenter().getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, 5000, false);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        GlideUtil glideUtil = GlideUtil.INSTANCE;
        NewNearbyMeActivity newNearbyMeActivity = this;
        String str = this.MyBillsEntityDataFactory;
        if (str == null) {
            str = "";
        }
        GlideUtil.PlaceComponentResult(newNearbyMeActivity, str, new NewNearbyMeActivity$setMyLocation$1(this), new Drawable(this));
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        Marker marker;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            NetworkUserEntityData$$ExternalSyntheticLambda3();
            return;
        }
        MarkerOptions authRequestContext = getMapHelper().getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.KClassImpl$Data$declaredNonStaticMembers$2);
        Marker marker2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if ((marker2 != null && marker2.isVisible()) && (marker = this.NetworkUserEntityData$$ExternalSyntheticLambda6) != null) {
            marker.setVisible(false);
        }
        GoogleMap googleMap = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = googleMap != null ? googleMap.addMarker(authRequestContext) : null;
        MapHelper mapHelper = getMapHelper();
        Marker marker3 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (marker3 != null) {
            GoogleMap googleMap2 = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
            float f = googleMap2 != null ? googleMap2.getCameraPosition().zoom / 30.0f : 0.0f;
            marker3.setAnchor(f, f);
        }
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public final void onMapReady(GoogleMap map) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(map, "");
        MapHelper mapHelper = getMapHelper();
        mapHelper.MyBillsEntityDataFactory(map, new GoogleMap.OnMarkerClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                boolean MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = NewNearbyMeActivity.this.MyBillsEntityDataFactory(marker);
                return MyBillsEntityDataFactory;
            }
        });
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            googleMap.setIndoorEnabled(false);
            mapHelper.KClassImpl$Data$declaredNonStaticMembers$2.setBuildingsEnabled(false);
        }
        GoogleMap.OnMapClickListener onMapClickListener = new GoogleMap.OnMapClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                NewNearbyMeActivity.$r8$lambda$t6Ix2vcxrpC6HtA8cyvXvr7ECac(NewNearbyMeActivity.this, latLng);
            }
        };
        GoogleMap googleMap2 = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap2 != null) {
            googleMap2.setOnMapClickListener(onMapClickListener);
        }
        GoogleMap googleMap3 = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap3 != null) {
            googleMap3.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda7
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
                public final void onCameraMove() {
                    NewNearbyMeActivity.m2735$r8$lambda$1SkxS_XiBYuBNphhMKxyhRchgM(NewNearbyMeActivity.this);
                }
            });
            googleMap3.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda8
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
                public final void onCameraIdle() {
                    NewNearbyMeActivity.m2737$r8$lambda$Xx88hALBnJfU1Y0wC4i5UuDSU(NewNearbyMeActivity.this);
                }
            });
            googleMap3.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda9
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
                public final void onCameraMoveStarted(int i) {
                    NewNearbyMeActivity.$r8$lambda$CapHwZYf6D3xBvIavBAJFYjgXuQ(NewNearbyMeActivity.this, i);
                }
            });
        }
        PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) _$_findCachedViewById(R.id.ConstraintAnchor);
        if (pinMapLottieAnimationView != null) {
            pinMapLottieAnimationView.setVisibility(8);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LocationUtil.getAuthRequestContext();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.check();
        if (!lookAheadTest()) {
            if (scheduleImpl()) {
                PlaceComponentResult();
                BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory((LockableBaseBottomSheetBehavior) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
                OtherStoreResultView otherStoreResultView = (OtherStoreResultView) _$_findCachedViewById(R.id.WriteAbortedException);
                if (otherStoreResultView != null) {
                    otherStoreResultView.showShimmer();
                }
            }
        } else {
            final String stringExtra = getIntent().getStringExtra("EXTRA_SHOP_ID");
            getIntent().removeExtra("EXTRA_SHOP_ID");
            final String stringExtra2 = getIntent().getStringExtra("EXTRA_MERCHANT_ID");
            getIntent().removeExtra("EXTRA_MERCHANT_ID");
            Intent intent = getIntent();
            ShopModel shopModel = (intent == null || (extras = intent.getExtras()) == null) ? null : (ShopModel) extras.getParcelable("shopModel");
            if (!(shopModel instanceof ShopModel)) {
                shopModel = null;
            }
            if (shopModel != null) {
                KClassImpl$Data$declaredNonStaticMembers$2(shopModel);
            } else {
                String str = stringExtra;
                if (!(str == null || str.length() == 0)) {
                    getMerchantDetailPresenter().MyBillsEntityDataFactory(stringExtra2 != null ? stringExtra2 : "", stringExtra);
                    MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
                    if (merchantDetailView != null) {
                        merchantDetailView.setTryAgainListener(new Function0<Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$openMerchantDetailFromNonMaps$2$1
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
                                NewNearbyMeActivity newNearbyMeActivity = NewNearbyMeActivity.this;
                                String str2 = stringExtra2;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                NewNearbyMeActivity.access$refreshMerchantDetail(newNearbyMeActivity, str2, stringExtra);
                                NewNearbyMeActivity.this.BuiltInFictitiousFunctionClassFactory(false);
                            }
                        });
                    }
                } else {
                    getAuthRequestContext$default(this, new IllegalArgumentException("No shop id found"), null, 2, null);
                }
            }
        }
        this.GetContactSyncConfig = true;
    }

    private final boolean isLayoutRequested() {
        if (this.scheduleImpl == MapState.MERCHANT_LIST) {
            MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
            if ((merchantDetailBottomsheetView == null || merchantDetailBottomsheetView.isShowing()) ? false : true) {
                return true;
            }
        }
        return false;
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        Collection<Marker> values = this.FragmentBottomSheetPaymentSettingBinding.values();
        Intrinsics.checkNotNullExpressionValue(values, "");
        List list = CollectionsKt.toList(values);
        int lastIndex = CollectionsKt.getLastIndex(list);
        if (lastIndex < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = lastIndex - i;
            Object obj = list.get(i2);
            Intrinsics.checkNotNullExpressionValue(obj, "");
            Marker marker = (Marker) obj;
            if (!getMapHelper().MyBillsEntityDataFactory(LocationUtil.KClassImpl$Data$declaredNonStaticMembers$2(marker.getPosition()))) {
                if (i2 > 0 && i2 > 0) {
                    int i3 = 1;
                    while (true) {
                        Object obj2 = list.get(i2 - i3);
                        Intrinsics.checkNotNullExpressionValue(obj2, "");
                        Marker marker2 = (Marker) obj2;
                        MapHelper mapHelper = getMapHelper();
                        HighlightedShopModel highlightedShopModel = this.getErrorConfigVersion;
                        z = mapHelper.BuiltInFictitiousFunctionClassFactory(marker, marker2, highlightedShopModel != null ? highlightedShopModel.MyBillsEntityDataFactory : null);
                        if (z || i3 == i2) {
                            break;
                        }
                        i3++;
                    }
                } else {
                    z = false;
                }
                MapHelper mapHelper2 = getMapHelper();
                HighlightedShopModel highlightedShopModel2 = this.getErrorConfigVersion;
                Pair<? extends Marker, ? extends Marker> pair = this.lookAheadTest;
                mapHelper2.MyBillsEntityDataFactory(marker, highlightedShopModel2, pair != null ? pair.getFirst() : null, z);
            }
            if (i == lastIndex) {
                return;
            }
            i++;
        }
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        Location location;
        this.scheduleImpl = MapState.MERCHANT_LIST;
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.reset();
            merchantDetailBottomsheetView.hideMerchantDetailBottomsheet();
        }
        GoogleMap googleMap = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            LatLng latLng = googleMap.getCameraPosition().target;
            location = LocationUtil.PlaceComponentResult(latLng.latitude, latLng.longitude);
        } else {
            location = null;
        }
        if (location != null) {
            this.moveToNextValue = location;
            getNearbyPresenter().DatabaseTableConfigUtil();
            getNearbyPresenter().getAuthRequestContext(location);
        }
    }

    public final boolean MyBillsEntityDataFactory(Marker p0) {
        MutableLiveData<ShopModel> shopModelLiveData;
        if (p0.getTag() instanceof ShopModel) {
            Object tag = p0.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.nearbyme.model.ShopModel");
            }
            ShopModel shopModel = (ShopModel) tag;
            MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
            if (merchantDetailBottomsheetView != null && (shopModelLiveData = merchantDetailBottomsheetView.getShopModelLiveData()) != null) {
                Object obj = shopModelLiveData.BuiltInFictitiousFunctionClassFactory;
                r3 = obj != LiveData.MyBillsEntityDataFactory ? obj : null;
            }
            if (!Intrinsics.areEqual(r3, shopModel)) {
                NetworkUserEntityData$$ExternalSyntheticLambda2();
                KClassImpl$Data$declaredNonStaticMembers$2(p0, shopModel);
                MerchantDetailBottomsheetView merchantDetailBottomsheetView2 = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
                if (merchantDetailBottomsheetView2 != null) {
                    merchantDetailBottomsheetView2.reset();
                    merchantDetailBottomsheetView2.getShopModelLiveData().PlaceComponentResult((MutableLiveData<ShopModel>) shopModel);
                    merchantDetailBottomsheetView2.showMerchantDetailPreview(shopModel, WhenMappings.BuiltInFictitiousFunctionClassFactory[this.scheduleImpl.ordinal()] == 1 ? TrackerKey.SourceType.RESULT_ON_MAP : TrackerKey.SourceType.NEARBY_MAPS);
                    BottomsheetBehaviorExtKt.getAuthRequestContext((LockableBaseBottomSheetBehavior) this.PrepareContext.getValue());
                }
                getPhotoPreviewPresenter().BuiltInFictitiousFunctionClassFactory(shopModel);
                MapHelper mapHelper = getMapHelper();
                Location PlaceComponentResult = LocationUtil.PlaceComponentResult(shopModel.DatabaseTableConfigUtil, shopModel.PrepareContext);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                LatLng BuiltInFictitiousFunctionClassFactory = NearbyExtensionKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
                GoogleMap googleMap = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
                float f = googleMap != null ? googleMap.getCameraPosition().zoom : 17.0f;
                GoogleMap googleMap2 = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
                if (googleMap2 != null) {
                    googleMap2.animateCamera(MapHelper.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, f));
                }
                NetworkUserEntityData$$ExternalSyntheticLambda1();
            }
            BuiltInFictitiousFunctionClassFactory();
        } else if (p0.getTag() instanceof HighlightedShopModel) {
            MerchantDetailBottomsheetView merchantDetailBottomsheetView3 = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
            if (merchantDetailBottomsheetView3 != null) {
                merchantDetailBottomsheetView3.reset();
            }
            NetworkUserEntityData$$ExternalSyntheticLambda2();
            MerchantDetailBottomsheetView merchantDetailBottomsheetView4 = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
            if (merchantDetailBottomsheetView4 != null) {
                merchantDetailBottomsheetView4.hideMerchantDetailBottomsheet();
            }
            NetworkUserEntityData$$ExternalSyntheticLambda1();
            BuiltInFictitiousFunctionClassFactory();
        }
        return true;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        Marker first;
        Pair<? extends Marker, ? extends Marker> pair = this.lookAheadTest;
        if (pair != null && (first = pair.getFirst()) != null) {
            first.remove();
        }
        Pair<? extends Marker, ? extends Marker> pair2 = this.lookAheadTest;
        Marker second = pair2 != null ? pair2.getSecond() : null;
        if (second != null) {
            second.setVisible(true);
        }
        this.lookAheadTest = null;
        this.getErrorConfigVersion = null;
    }

    public final void DatabaseTableConfigUtil() {
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if ((merchantDetailBottomsheetView != null && merchantDetailBottomsheetView.isMerchantDetailFullyDisplayed()) || this.getErrorConfigVersion == null) {
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        MerchantDetailBottomsheetView merchantDetailBottomsheetView2 = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView2 != null) {
            Intrinsics.checkNotNullExpressionValue(merchantDetailBottomsheetView2, "");
            merchantDetailBottomsheetView2.reset();
            merchantDetailBottomsheetView2.hideMerchantDetailBottomsheet();
        }
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void PlaceComponentResult(List<? extends ShopModel> p0) {
        PlaceComponentResult();
        if (p0.isEmpty()) {
            return;
        }
        getMapHelper().scheduleImpl = new LatLngBounds.Builder();
        List<? extends ShopModel> take = CollectionsKt.take(p0, 100);
        getAuthRequestContext(take);
        BuiltInFictitiousFunctionClassFactory(take);
    }

    private final void getAuthRequestContext(List<? extends ShopModel> p0) {
        for (ShopModel shopModel : p0) {
            shopModel.A = p0.size() - shopModel.whenAvailable;
            if (shopModel.BottomSheetCardBindingView$watcherCardNumberView$1 != null) {
                BuiltInFictitiousFunctionClassFactory(shopModel);
            }
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(List<? extends ShopModel> p0) {
        if (this.GetContactSyncConfig) {
            List<? extends ShopModel> list = p0;
            ShopModel shopModel = (ShopModel) CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$animateCamera$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Double.valueOf(((ShopModel) t).getErrorConfigVersion), Double.valueOf(((ShopModel) t2).getErrorConfigVersion));
                }
            }).get(CollectionsKt.getLastIndex(p0));
            if (this.PlaceComponentResult) {
                this.PlaceComponentResult = false;
                MapHelper mapHelper = getMapHelper();
                getMapHelper();
                LatLngBounds.Builder builder = getMapHelper().scheduleImpl;
                Location location = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullExpressionValue(location, "");
                mapHelper.scheduleImpl = MapHelper.PlaceComponentResult(builder, NearbyExtensionKt.BuiltInFictitiousFunctionClassFactory(location), shopModel.getErrorConfigVersion);
            } else {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ShopModel shopModel2 : list) {
                    MapHelper mapHelper2 = getMapHelper();
                    LatLngBounds.Builder builder2 = getMapHelper().scheduleImpl;
                    Location PlaceComponentResult = LocationUtil.PlaceComponentResult(shopModel2.DatabaseTableConfigUtil, shopModel2.PrepareContext);
                    Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                    builder2.include(NearbyExtensionKt.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult));
                    mapHelper2.scheduleImpl = builder2;
                    arrayList.add(Unit.INSTANCE);
                }
            }
            KClassImpl$Data$declaredNonStaticMembers$2(true);
            MapHelper mapHelper3 = getMapHelper();
            LatLngBounds.Builder builder3 = getMapHelper().scheduleImpl;
            CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder3.build(), SizeUtil.PlaceComponentResult(48));
            GoogleMap googleMap = mapHelper3.KClassImpl$Data$declaredNonStaticMembers$2;
            if (googleMap != null) {
                googleMap.animateCamera(newLatLngBounds);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(false);
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        if (p0) {
            MapHelper mapHelper = getMapHelper();
            MerchantFilterView merchantFilterView = (MerchantFilterView) _$_findCachedViewById(R.id.mfvMerchantMapsCategory);
            int bottom = merchantFilterView != null ? merchantFilterView.getBottom() : 0;
            int PlaceComponentResult = SizeUtil.PlaceComponentResult(16);
            int authRequestContext = getAuthRequestContext();
            int i = bottom + PlaceComponentResult;
            GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
            if (googleMap != null) {
                googleMap.setPadding(0, i, 0, authRequestContext);
                return;
            }
            return;
        }
        GoogleMap googleMap2 = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap2 != null) {
            googleMap2.setPadding(0, 0, 0, 0);
        }
    }

    private final int getAuthRequestContext() {
        if (((CardView) _$_findCachedViewById(R.id.cvMerchantList)) != null) {
            return ((int) (((LockableBaseBottomSheetBehavior) this.PrepareContext.getValue()).getHalfExpandedRatio() * r0.getMeasuredHeight())) - SizeUtil.PlaceComponentResult(36);
        }
        return 0;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(Marker p0, ShopModel p1) {
        Marker first;
        MapHelper mapHelper = getMapHelper();
        MarkerOptions authRequestContext = getAuthRequestContext(p1);
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        Marker addMarker = googleMap != null ? googleMap.addMarker(authRequestContext) : null;
        if (addMarker != null) {
            addMarker.setTitle(getString(R.string.iconMerchant));
            HighlightedShopModel highlightedShopModel = new HighlightedShopModel(p1);
            this.getErrorConfigVersion = highlightedShopModel;
            addMarker.setTag(highlightedShopModel);
            Pair<? extends Marker, ? extends Marker> pair = this.lookAheadTest;
            if (pair != null && (first = pair.getFirst()) != null) {
                first.remove();
            }
            this.lookAheadTest = new Pair<>(addMarker, p0);
            p0.setVisible(false);
        }
    }

    private final boolean PlaceComponentResult(ShopModel p0) {
        HighlightedShopModel highlightedShopModel = this.getErrorConfigVersion;
        return Intrinsics.areEqual(highlightedShopModel != null ? highlightedShopModel.MyBillsEntityDataFactory : null, p0);
    }

    private final MarkerOptions getAuthRequestContext(ShopModel p0) {
        MapHelper mapHelper = getMapHelper();
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(LocationUtil.PlaceComponentResult(p0.DatabaseTableConfigUtil, p0.PrepareContext));
        String PlaceComponentResult = MapHelper.PlaceComponentResult(LocationUtil.PlaceComponentResult(p0.DatabaseTableConfigUtil, p0.PrepareContext), p0.BottomSheetCardBindingView$watcherCardNumberView$1, p0.whenAvailable, true, true);
        MarkerOptions markerOptions = mapHelper.MyBillsEntityDataFactory.get(PlaceComponentResult);
        if (markerOptions == null) {
            MarkerOptions anchor = new MarkerOptions().position(authRequestContext).icon(NewShopMarkerHelper.getAuthRequestContext(mapHelper.BuiltInFictitiousFunctionClassFactory, p0, true)).zIndex(Float.MAX_VALUE).anchor(0.5f, 1.0f);
            mapHelper.MyBillsEntityDataFactory.put(PlaceComponentResult, anchor);
            return anchor;
        }
        return markerOptions;
    }

    private final void PlaceComponentResult() {
        GoogleMap googleMap = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            googleMap.clear();
        }
        this.FragmentBottomSheetPaymentSettingBinding.clear();
        this.lookAheadTest = null;
        if (getMapHelper().moveToNextValue != null) {
            NetworkUserEntityData$$ExternalSyntheticLambda4();
        }
    }

    @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction
    public final void updatePromoBadge(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        List<? extends ShopModel> listOf = CollectionsKt.listOf(shopModel);
        NewMerchantListView newMerchantListView = (NewMerchantListView) _$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.updateShops(listOf);
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.scheduleImpl == MapState.SEARCH_RESULT) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("NearbySearchFragment");
            if (findFragmentByTag != null && findFragmentByTag.isHidden()) {
                Fragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag("NearbySearchFragment");
                if (findFragmentByTag2 != null) {
                    getSupportFragmentManager().beginTransaction().KClassImpl$Data$declaredNonStaticMembers$2(findFragmentByTag2).getAuthRequestContext();
                }
                finish();
                return;
            }
        }
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            Fragment findFragmentByTag3 = getSupportFragmentManager().findFragmentByTag("NearbySearchFragment");
            NearbySearchFragment nearbySearchFragment = findFragmentByTag3 instanceof NearbySearchFragment ? (NearbySearchFragment) findFragmentByTag3 : null;
            if (nearbySearchFragment != null) {
                nearbySearchFragment.onBackPressed();
            }
            NetworkUserEntityData$$ExternalSyntheticLambda5();
            Location location = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(location, "");
            KClassImpl$Data$declaredNonStaticMembers$2(location);
            return;
        }
        if (((MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet)).isMerchantDetailFullyDisplayed()) {
            MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
            if ((merchantDetailView != null ? merchantDetailView.getMerchantDetailState() : null) != MerchantDetailView.MerchantDetailState.ERROR) {
                NetworkUserEntityData$$ExternalSyntheticLambda5();
                ((MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet)).collapseBottomsheet();
                BuiltInFictitiousFunctionClassFactory(false);
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // id.dana.eventbus.base.BaseActivityWithPageLoadTracker, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.isLayoutRequested;
        if (disposable != null) {
            disposable.dispose();
        }
        this.isLayoutRequested = null;
        Disposable disposable2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
    }

    private final boolean MyBillsEntityDataFactory(boolean p0) {
        return p0 && isLayoutRequested() && !getNearbyPresenter().scheduleImpl();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ3\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rJ)\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/nearbyrevamp/NewNearbyMeActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/nearbyme/model/ShopModel;", "p1", "", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;)V", "p3", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "EXTRA_TARGET_SCREEN", "Ljava/lang/String;", "NEARBY_DETAIL_BOTTOMSHEET", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context p0, String p1, String p2, String p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intent intent = new Intent(p0, NewNearbyMeActivity.class);
            intent.putExtra(NewNearbyMeActivity.EXTRA_TARGET_SCREEN, NewNearbyMeActivity.NEARBY_DETAIL_BOTTOMSHEET);
            intent.putExtra("EXTRA_SHOP_ID", p2);
            intent.putExtra("EXTRA_MERCHANT_ID", p1);
            intent.putExtra("EXTRA_SOURCE", p3);
            p0.startActivity(intent);
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, ShopModel p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, NewNearbyMeActivity.class);
            intent.putExtra(NewNearbyMeActivity.EXTRA_TARGET_SCREEN, NewNearbyMeActivity.NEARBY_DETAIL_BOTTOMSHEET);
            intent.putExtra("shopModel", p1);
            intent.putExtra("EXTRA_SOURCE", p2);
            p0.startActivity(intent);
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context p0, String p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, NewNearbyMeActivity.class);
            intent.putExtra(NewNearbyMeActivity.EXTRA_TARGET_SCREEN, "nearby_other_store");
            intent.putExtra("EXTRA_MERCHANT_ID", p1);
            intent.putExtra("EXTRA_SOURCE", p2);
            p0.startActivity(intent);
        }
    }

    /* renamed from: $r8$lambda$1SkxS_XiBYuBNphhMKxyhRchg-M */
    public static /* synthetic */ void m2735$r8$lambda$1SkxS_XiBYuBNphhMKxyhRchgM(NewNearbyMeActivity newNearbyMeActivity) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        if (newNearbyMeActivity.scheduleImpl != MapState.SEARCH_RESULT) {
            newNearbyMeActivity.getAuthRequestContext(!newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda8());
            MapHelper mapHelper = newNearbyMeActivity.getMapHelper();
            Marker marker = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
            if (marker != null) {
                GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
                float f = googleMap != null ? googleMap.getCameraPosition().zoom / 30.0f : 0.0f;
                marker.setAnchor(f, f);
            }
            if (newNearbyMeActivity.BuiltInFictitiousFunctionClassFactory == 1) {
                if (newNearbyMeActivity.isLayoutRequested()) {
                    newNearbyMeActivity.PlaceComponentResult(false);
                    BottomsheetBehaviorExtKt.MyBillsEntityDataFactory((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue());
                }
                PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) newNearbyMeActivity._$_findCachedViewById(R.id.ConstraintAnchor);
                if (pinMapLottieAnimationView != null) {
                    pinMapLottieAnimationView.pullOutPinMap();
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$7siQHXtLFuhVebtwp5nlHDVFD5E(NewNearbyMeActivity newNearbyMeActivity) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity._$_findCachedViewById(R.id.view_gradient).bringToFront();
        newNearbyMeActivity._$_findCachedViewById(R.id.clLocationContainer).bringToFront();
        ((MerchantFilterView) newNearbyMeActivity._$_findCachedViewById(R.id.mfvMerchantMapsCategory)).bringToFront();
        ((CoordinatorLayout) newNearbyMeActivity._$_findCachedViewById(R.id.PaylaterRegistrationCooldownCache)).bringToFront();
        ConstraintLayout constraintLayout = (ConstraintLayout) newNearbyMeActivity._$_findCachedViewById(R.id.res_0x7f0a04ae_eventloopimplbase_delayedrunnabletask);
        if (constraintLayout != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                constraintLayout.setElevation(constraintLayout.getResources().getDimension(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f));
                constraintLayout.setOutlineAmbientShadowColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout.getContext(), R.color.f25472131100154));
                constraintLayout.setOutlineSpotShadowColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(constraintLayout.getContext(), R.color.f25472131100154));
                constraintLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
                return;
            }
            ConstraintLayout constraintLayout2 = (ConstraintLayout) newNearbyMeActivity._$_findCachedViewById(R.id.res_0x7f0a04ae_eventloopimplbase_delayedrunnabletask);
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
            ViewExtKt.PlaceComponentResult(constraintLayout2, 8.0f);
        }
    }

    /* renamed from: $r8$lambda$BsuOoXlpR-veT9G9gEfBHZ9t9X0 */
    public static /* synthetic */ void m2736$r8$lambda$BsuOoXlpRveT9G9gEfBHZ9t9X0(NewNearbyMeActivity newNearbyMeActivity, View view) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        MyReviewListActivity.Companion companion = MyReviewListActivity.INSTANCE;
        MyReviewListActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(newNearbyMeActivity, TrackerKey.SourceType.NEARBY_OPEN);
    }

    public static /* synthetic */ void $r8$lambda$CapHwZYf6D3xBvIavBAJFYjgXuQ(NewNearbyMeActivity newNearbyMeActivity, int i) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity.BuiltInFictitiousFunctionClassFactory = i;
        PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) newNearbyMeActivity._$_findCachedViewById(R.id.ConstraintAnchor);
        if (pinMapLottieAnimationView != null) {
            pinMapLottieAnimationView.setVisibility(i == 1 ? 0 : 8);
        }
    }

    public static /* synthetic */ void $r8$lambda$MAb2QEnLe4AYNrWBot1y92L4OSI(NewNearbyMeActivity newNearbyMeActivity, View view) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity.getWindow().clearFlags(512);
        View _$_findCachedViewById = newNearbyMeActivity._$_findCachedViewById(R.id.view_gradient);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
        if (newNearbyMeActivity.scheduleImpl == MapState.SEARCH_RESULT) {
            Fragment findFragmentByTag = newNearbyMeActivity.getSupportFragmentManager().findFragmentByTag("NearbySearchFragment");
            if (findFragmentByTag != null) {
                Fragment PlaceComponentResult = ((NearbySearchFragment) findFragmentByTag).PlaceComponentResult("merchant");
                MerchantSearchResultAdapter merchantSearchResultAdapter = null;
                MerchantSearchResultFragment merchantSearchResultFragment = PlaceComponentResult instanceof MerchantSearchResultFragment ? (MerchantSearchResultFragment) PlaceComponentResult : null;
                if (merchantSearchResultFragment != null) {
                    MerchantSearchResultAdapter merchantSearchResultAdapter2 = merchantSearchResultFragment.PlaceComponentResult;
                    if (merchantSearchResultAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantSearchResultAdapter2 = null;
                    }
                    MerchantSearchResultAdapter merchantSearchResultAdapter3 = merchantSearchResultFragment.PlaceComponentResult;
                    if (merchantSearchResultAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantSearchResultAdapter3 = null;
                    }
                    List<ShopModel> items = merchantSearchResultAdapter3.getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "");
                    merchantSearchResultAdapter2.setItems(CollectionsKt.take(items, 20));
                    MerchantSearchResultAdapter merchantSearchResultAdapter4 = merchantSearchResultFragment.PlaceComponentResult;
                    if (merchantSearchResultAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        merchantSearchResultAdapter = merchantSearchResultAdapter4;
                    }
                    List<ShopModel> items2 = merchantSearchResultAdapter.getItems();
                    Intrinsics.checkNotNullExpressionValue(items2, "");
                    merchantSearchResultFragment.MyBillsEntityDataFactory = ((ShopModel) CollectionsKt.last((List) items2)).whenAvailable;
                }
                FragmentTransaction beginTransaction = newNearbyMeActivity.getSupportFragmentManager().beginTransaction();
                beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = R.anim.f4722130772014;
                beginTransaction.GetContactSyncConfig = R.anim.f4732130772016;
                beginTransaction.newProxyInstance = R.anim.f4722130772014;
                beginTransaction.PrepareContext = R.anim.f4732130772016;
                beginTransaction.BuiltInFictitiousFunctionClassFactory(findFragmentByTag).getAuthRequestContext();
                return;
            }
            return;
        }
        FragmentTransaction beginTransaction2 = newNearbyMeActivity.getSupportFragmentManager().beginTransaction();
        beginTransaction2.NetworkUserEntityData$$ExternalSyntheticLambda2 = R.anim.f4722130772014;
        beginTransaction2.GetContactSyncConfig = R.anim.f4732130772016;
        beginTransaction2.newProxyInstance = R.anim.f4722130772014;
        beginTransaction2.PrepareContext = R.anim.f4732130772016;
        NearbySearchFragment.Companion companion = NearbySearchFragment.INSTANCE;
        Location location = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(location, "");
        beginTransaction2.KClassImpl$Data$declaredNonStaticMembers$2(16908290, NearbySearchFragment.Companion.PlaceComponentResult(location, new NearbySearchResultListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$getNearbySearchListener$1
            @Override // id.dana.drawable.search.NearbySearchResultListener
            public final /* synthetic */ void PlaceComponentResult(NearbyLocation nearbyLocation) {
                NearbySearchResultListener.CC.getAuthRequestContext(nearbyLocation);
            }

            @Override // id.dana.drawable.search.NearbySearchResultListener
            public final void getAuthRequestContext(Location p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                KeyboardHelper.MyBillsEntityDataFactory(NewNearbyMeActivity.this);
                NewNearbyMeActivity.this.getSupportFragmentManager().popBackStack();
                NewNearbyMeActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                NewNearbyMeActivity.access$showSearchResultBottomsheet(NewNearbyMeActivity.this);
                NewNearbyMeActivity.this.scheduleImpl = NewNearbyMeActivity.MapState.MERCHANT_LIST;
            }

            @Override // id.dana.drawable.search.NearbySearchResultListener
            public final void BuiltInFictitiousFunctionClassFactory(List<? extends ShopModel> p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                KeyboardHelper.MyBillsEntityDataFactory(NewNearbyMeActivity.this);
                NewNearbyMeActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda5();
                Fragment findFragmentByTag2 = NewNearbyMeActivity.this.getSupportFragmentManager().findFragmentByTag("NearbySearchFragment");
                if (findFragmentByTag2 != null) {
                    FragmentTransaction beginTransaction3 = NewNearbyMeActivity.this.getSupportFragmentManager().beginTransaction();
                    beginTransaction3.NetworkUserEntityData$$ExternalSyntheticLambda2 = R.anim.f4722130772014;
                    beginTransaction3.GetContactSyncConfig = R.anim.f4732130772016;
                    beginTransaction3.newProxyInstance = R.anim.f4722130772014;
                    beginTransaction3.PrepareContext = R.anim.f4732130772016;
                    beginTransaction3.PlaceComponentResult(findFragmentByTag2).getAuthRequestContext();
                }
                NewNearbyMeActivity.access$showSearchResultBottomsheet(NewNearbyMeActivity.this);
                NewNearbyMeActivity newNearbyMeActivity2 = NewNearbyMeActivity.this;
                NearbySearchToolbar nearbySearchToolbar = (NearbySearchToolbar) newNearbyMeActivity2._$_findCachedViewById(R.id.tsvSearchBox);
                String keyword = nearbySearchToolbar != null ? nearbySearchToolbar.getKeyword() : null;
                newNearbyMeActivity2.PlaceComponentResult(keyword != null ? keyword : "");
                NewNearbyMeActivity.this.getNearbyPresenter().DatabaseTableConfigUtil();
                NewNearbyMeActivity.access$populateSearchResultData(NewNearbyMeActivity.this, CollectionsKt.toMutableList((Collection) p0), p1);
                NewNearbyMeActivity.this.scheduleImpl = NewNearbyMeActivity.MapState.SEARCH_RESULT;
                AppCompatTextView appCompatTextView = (AppCompatTextView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.MobilePaymentLoginRequest);
                if (appCompatTextView != null) {
                    appCompatTextView.setVisibility(8);
                }
            }

            @Override // id.dana.drawable.search.NearbySearchResultListener
            public final void BuiltInFictitiousFunctionClassFactory(ShopModel p0, List<? extends ShopModel> p1, boolean p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                KeyboardHelper.MyBillsEntityDataFactory(NewNearbyMeActivity.this);
                Fragment findFragmentByTag2 = NewNearbyMeActivity.this.getSupportFragmentManager().findFragmentByTag("NearbySearchFragment");
                if (findFragmentByTag2 != null) {
                    NearbySearchFragment nearbySearchFragment = (NearbySearchFragment) findFragmentByTag2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    String str = p0.newProxyInstance;
                    if (str == null) {
                        str = "";
                    }
                    TextView textView = nearbySearchFragment.toolbarTitle;
                    if (textView != null) {
                        textView.setText(str);
                    }
                    MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) nearbySearchFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a11d4_daggercommonrichviewcomponent_1);
                    if (merchantDetailBottomsheetView != null) {
                        merchantDetailBottomsheetView.showMerchantDetailFromList(p0, TrackerKey.SourceType.SEARCH_LIST);
                    }
                    Intrinsics.checkNotNullParameter(p0, "");
                    PhotoGalleryContract.Presenter presenter = nearbySearchFragment.photoPreviewPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                    }
                    presenter.BuiltInFictitiousFunctionClassFactory(p0);
                }
            }

            @Override // id.dana.drawable.search.NearbySearchResultListener
            public final void PlaceComponentResult() {
                NewNearbyMeActivity.this.scheduleImpl = NewNearbyMeActivity.MapState.MERCHANT_LIST;
                NewNearbyMeActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        }), "NearbySearchFragment", 2);
        if (!beginTransaction2.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        beginTransaction2.scheduleImpl = true;
        beginTransaction2.NetworkUserEntityData$$ExternalSyntheticLambda8 = "NearbySearchFragment";
        beginTransaction2.getAuthRequestContext();
        newNearbyMeActivity.scheduleImpl = MapState.MERCHANT_LIST;
        newNearbyMeActivity.moveToNextValue = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* renamed from: $r8$lambda$Xx88hALBnJfU1Y0w-C4i5UuDS-U */
    public static /* synthetic */ void m2737$r8$lambda$Xx88hALBnJfU1Y0wC4i5UuDSU(NewNearbyMeActivity newNearbyMeActivity) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity.BuiltInFictitiousFunctionClassFactory();
        if (newNearbyMeActivity.BuiltInFictitiousFunctionClassFactory == 1) {
            newNearbyMeActivity.PlaceComponentResult(RefreshCondition.ERROR);
            PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) newNearbyMeActivity._$_findCachedViewById(R.id.ConstraintAnchor);
            if (pinMapLottieAnimationView != null) {
                pinMapLottieAnimationView.putDownPinMap();
                if (((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue()).getState() != 6 && newNearbyMeActivity.isLayoutRequested()) {
                    BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue());
                }
                if (newNearbyMeActivity.MyBillsEntityDataFactory(pinMapLottieAnimationView.getVisibility() == 0)) {
                    newNearbyMeActivity.PlaceComponentResult();
                    NewMerchantListView newMerchantListView = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                    if (newMerchantListView != null) {
                        newMerchantListView.clearMerchantList();
                    }
                    newNearbyMeActivity.getNearbyPresenter().DatabaseTableConfigUtil();
                    newNearbyMeActivity.moveToNextValue = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$a45xUenXogwQnGXZyVtVjDV5Lwo(NewNearbyMeActivity newNearbyMeActivity, View view) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) newNearbyMeActivity._$_findCachedViewById(R.id.ConstraintAnchor);
        if (pinMapLottieAnimationView != null) {
            pinMapLottieAnimationView.setVisibility(8);
        }
        MapHelper mapHelper = newNearbyMeActivity.getMapHelper();
        Location location = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(location, "");
        LatLng BuiltInFictitiousFunctionClassFactory = NearbyExtensionKt.BuiltInFictitiousFunctionClassFactory(location);
        GoogleMap googleMap = mapHelper.KClassImpl$Data$declaredNonStaticMembers$2;
        if (googleMap != null) {
            googleMap.animateCamera(MapHelper.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory, 16.0f));
        }
        DanaMapFragment danaMapFragment = (DanaMapFragment) newNearbyMeActivity.newProxyInstance.getValue();
        if (danaMapFragment != null) {
            danaMapFragment.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
        CardView cardView = (CardView) newNearbyMeActivity._$_findCachedViewById(R.id.cvGoToMyLocation);
        if (cardView != null) {
            cardView.setVisibility(8);
        }
    }

    /* renamed from: $r8$lambda$gqON97v3r7--6qBr_OQ_VQVgy1Q */
    public static /* synthetic */ void m2738$r8$lambda$gqON97v3r76qBr_OQ_VQVgy1Q(NewNearbyMeActivity newNearbyMeActivity, Location location) {
        if (newNearbyMeActivity.getAuthRequestContext >= 5) {
            newNearbyMeActivity.getAuthRequestContext = 0;
            newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = LocationUtil.getAuthRequestContext();
            newNearbyMeActivity.initRecordTimeStamp();
            Disposable disposable = newNearbyMeActivity.isLayoutRequested;
            if (disposable != null) {
                disposable.dispose();
            }
            newNearbyMeActivity.isLayoutRequested = null;
        }
        if (location == null) {
            newNearbyMeActivity.getAuthRequestContext++;
            return;
        }
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = location;
        newNearbyMeActivity.initRecordTimeStamp();
        Disposable disposable2 = newNearbyMeActivity.isLayoutRequested;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        newNearbyMeActivity.isLayoutRequested = null;
    }

    /* renamed from: $r8$lambda$iZuSAaUlseOek2-yYfAosOU9wu4 */
    public static /* synthetic */ void m2739$r8$lambda$iZuSAaUlseOek2yYfAosOU9wu4(NewNearbyMeActivity newNearbyMeActivity, LocationSettingsResult locationSettingsResult) {
        int statusCode;
        Unit unit;
        IntentSender intentSender;
        if (locationSettingsResult == null || locationSettingsResult.getStatus() == null || (statusCode = locationSettingsResult.getStatus().getStatusCode()) == 0) {
            return;
        }
        if (statusCode != 6) {
            if (statusCode != 8502) {
                newNearbyMeActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                return;
            }
            return;
        }
        PendingIntent resolution = locationSettingsResult.getStatus().getResolution();
        if (resolution == null || (intentSender = resolution.getIntentSender()) == null) {
            unit = null;
        } else {
            LocationUtil.MyBillsEntityDataFactory(newNearbyMeActivity, intentSender);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            newNearbyMeActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    public static /* synthetic */ WindowInsetsCompat $r8$lambda$lMYm3sSU6KsEkVa_fTyA62vBFmM(NewNearbyMeActivity newNearbyMeActivity, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "");
        if (windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat.Type.MyBillsEntityDataFactory()).getAuthRequestContext > 0) {
            NewMerchantListView newMerchantListView = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
            if (newMerchantListView != null) {
                ViewExtKt.BuiltInFictitiousFunctionClassFactory(newMerchantListView, null, null, null, Integer.valueOf(windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat.Type.MyBillsEntityDataFactory()).getAuthRequestContext), 7);
            }
            OtherStoreResultView otherStoreResultView = (OtherStoreResultView) newNearbyMeActivity._$_findCachedViewById(R.id.WriteAbortedException);
            if (otherStoreResultView != null) {
                ViewExtKt.BuiltInFictitiousFunctionClassFactory(otherStoreResultView, null, null, null, Integer.valueOf(windowInsetsCompat.KClassImpl$Data$declaredNonStaticMembers$2(WindowInsetsCompat.Type.MyBillsEntityDataFactory()).getAuthRequestContext), 7);
            }
        }
        return WindowInsetsCompat.getAuthRequestContext;
    }

    public static /* synthetic */ void $r8$lambda$mAB5tdtZAspf4p3TWohEpJZZQVw(NewNearbyMeActivity newNearbyMeActivity, View view) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        super.onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$t6Ix2vcxrpC6HtA8cyvXvr7ECac(NewNearbyMeActivity newNearbyMeActivity, LatLng latLng) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        Intrinsics.checkNotNullParameter(latLng, "");
        newNearbyMeActivity.DatabaseTableConfigUtil();
    }

    public static /* synthetic */ void $r8$lambda$vgoK1j2jUhlTu3iDk1N0wTvvzM0(NewNearbyMeActivity newNearbyMeActivity, View view) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity.PlaceComponentResult(RefreshCondition.REFRESHING);
        newNearbyMeActivity.PlaceComponentResult();
        PinMapLottieAnimationView pinMapLottieAnimationView = (PinMapLottieAnimationView) newNearbyMeActivity._$_findCachedViewById(R.id.ConstraintAnchor);
        if (pinMapLottieAnimationView != null) {
            pinMapLottieAnimationView.setVisibility(8);
        }
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda2();
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.hideMerchantDetailBottomsheet();
        }
        BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue());
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7();
    }

    /* renamed from: $r8$lambda$z4Mj1F4egIvFAf5Dnjdi-zn-ox4 */
    public static /* synthetic */ void m2740$r8$lambda$z4Mj1F4egIvFAf5Dnjdiznox4(NewNearbyMeActivity newNearbyMeActivity, View view) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        newNearbyMeActivity.PlaceComponentResult("");
        if (newNearbyMeActivity.scheduleImpl == MapState.SEARCH_RESULT) {
            newNearbyMeActivity.scheduleImpl = MapState.MERCHANT_LIST;
            newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7();
        }
    }

    /* renamed from: $r8$lambda$zj5zMc3R0TxXRQvTqN6gFWP-y2E */
    public static /* synthetic */ void m2741$r8$lambda$zj5zMc3R0TxXRQvTqN6gFWPy2E(NewNearbyMeActivity newNearbyMeActivity, ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(newNearbyMeActivity, "");
        if (shopModel == null) {
            MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
            if (merchantDetailBottomsheetView != null) {
                merchantDetailBottomsheetView.resetMerchantDetailContent();
                return;
            }
            return;
        }
        String str = shopModel.newProxyInstance;
        newNearbyMeActivity.setTitle(str != null ? str : "");
        newNearbyMeActivity.setToolbarTitleContentDescription(newNearbyMeActivity.getString(R.string.lblMerchantName));
    }

    public static final /* synthetic */ LockableBaseBottomSheetBehavior access$getMerchantListBottomsheet(NewNearbyMeActivity newNearbyMeActivity) {
        return (LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue();
    }

    public static final /* synthetic */ LockableBaseBottomSheetBehavior access$getMerchantOtherStoreBottomsheet(NewNearbyMeActivity newNearbyMeActivity) {
        return (LockableBaseBottomSheetBehavior) newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
    }

    public static final /* synthetic */ void access$onCollapseMerchantDetailBottomsheet(NewNearbyMeActivity newNearbyMeActivity) {
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
        newNearbyMeActivity.FragmentBottomSheetPaymentSettingBinding();
        newNearbyMeActivity.getAuthRequestContext(false);
        newNearbyMeActivity.BuiltInFictitiousFunctionClassFactory(false);
    }

    public static final /* synthetic */ void access$onExpandMerchantDetailBottomsheet(NewNearbyMeActivity newNearbyMeActivity) {
        MerchantFilterView merchantFilterView;
        newNearbyMeActivity.getWindow().clearFlags(512);
        View _$_findCachedViewById = newNearbyMeActivity._$_findCachedViewById(R.id.view_gradient);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
        newNearbyMeActivity.getAuthRequestContext(true);
        newNearbyMeActivity.FragmentBottomSheetPaymentSettingBinding();
        ((MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet)).onMerchantDetailFullyShown();
        if (newNearbyMeActivity.scheduleImpl == MapState.MERCHANT_OTHER_STORE || (merchantFilterView = (MerchantFilterView) newNearbyMeActivity._$_findCachedViewById(R.id.mfvMerchantMapsCategory)) == null) {
            return;
        }
        merchantFilterView.setVisibility(0);
    }

    public static final /* synthetic */ void access$onHideMerchantDetailBottomsheet(NewNearbyMeActivity newNearbyMeActivity) {
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda5();
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.reset();
        }
        ((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue()).MyBillsEntityDataFactory = false;
        if (newNearbyMeActivity.scheduleImpl != MapState.MERCHANT_OTHER_STORE && !BottomsheetBehaviorExtKt.KClassImpl$Data$declaredNonStaticMembers$2((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue())) {
            newNearbyMeActivity.PlaceComponentResult(R.id.f3775res_0x7f0a071a_amountformfragment_onbackpressedcallback_1);
            BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue());
        } else if (newNearbyMeActivity.scheduleImpl == MapState.MERCHANT_OTHER_STORE) {
            newNearbyMeActivity.PlaceComponentResult(R.id.f3776flBottomsheetOtherMerchant);
            BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory((LockableBaseBottomSheetBehavior) newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
        }
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public static final /* synthetic */ void access$openOtherStoreBottomsheet(NewNearbyMeActivity newNearbyMeActivity, ShopModel shopModel) {
        newNearbyMeActivity.PlaceComponentResult();
        newNearbyMeActivity.scheduleImpl = MapState.MERCHANT_OTHER_STORE;
        BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory((LockableBaseBottomSheetBehavior) newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
        BottomsheetBehaviorExtKt.getAuthRequestContext((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue());
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.hideMerchantDetailBottomsheet();
        }
        OtherStoreResultView otherStoreResultView = (OtherStoreResultView) newNearbyMeActivity._$_findCachedViewById(R.id.WriteAbortedException);
        if (otherStoreResultView != null) {
            Location location = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(location, "");
            String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Intrinsics.checkNotNullExpressionValue(str, "");
            otherStoreResultView.searchOtherMerchantByMerchantId(location, str, SearchType.MERCHANTID_SORTED_BY_DISTANCE, TrackerKey.SourceType.MERCHANT_DETAIL);
        }
    }

    public static final /* synthetic */ void access$populateOtherStoreList(NewNearbyMeActivity newNearbyMeActivity, List list) {
        if ((!newNearbyMeActivity.FragmentBottomSheetPaymentSettingBinding.isEmpty()) != false) {
            newNearbyMeActivity.PlaceComponentResult();
        }
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda2();
        newNearbyMeActivity.getMapHelper().scheduleImpl = new LatLngBounds.Builder();
        if ((!list.isEmpty()) == true) {
            List<? extends ShopModel> take = CollectionsKt.take(list, 100);
            newNearbyMeActivity.getAuthRequestContext(take);
            newNearbyMeActivity.BuiltInFictitiousFunctionClassFactory(take);
        }
    }

    public static final /* synthetic */ void access$populateSearchResultData(NewNearbyMeActivity newNearbyMeActivity, List list, boolean z) {
        NearbyMeContract.Presenter nearbyPresenter = newNearbyMeActivity.getNearbyPresenter();
        NearbyShopsModel nearbyShopsModel = new NearbyShopsModel();
        nearbyShopsModel.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        nearbyShopsModel.MyBillsEntityDataFactory = list;
        nearbyPresenter.BuiltInFictitiousFunctionClassFactory(nearbyShopsModel);
        newNearbyMeActivity.getNearbyPresenter().MyBillsEntityDataFactory(z);
        newNearbyMeActivity.getMerchantCategoryPresenter().PlaceComponentResult(list, newNearbyMeActivity.getNearbyPresenter().KClassImpl$Data$declaredNonStaticMembers$2());
        newNearbyMeActivity.MyBillsEntityDataFactory(list);
        NearbyMeContract.Presenter nearbyPresenter2 = newNearbyMeActivity.getNearbyPresenter();
        NearbySearchToolbar nearbySearchToolbar = (NearbySearchToolbar) newNearbyMeActivity._$_findCachedViewById(R.id.tsvSearchBox);
        nearbyPresenter2.KClassImpl$Data$declaredNonStaticMembers$2(nearbySearchToolbar != null ? nearbySearchToolbar.getKeyword() : null);
    }

    public static final /* synthetic */ void access$refreshMerchantDetail(NewNearbyMeActivity newNearbyMeActivity, String str, String str2) {
        NewMerchantListView newMerchantListView = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.showShimmerMerchantList();
        }
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.onMerchantDetailRefreshed();
        }
        newNearbyMeActivity.getMerchantDetailPresenter().MyBillsEntityDataFactory();
        newNearbyMeActivity.getMerchantDetailPresenter().MyBillsEntityDataFactory(str, str2);
    }

    public static final /* synthetic */ void access$renderNearbyReviewPageEntryPoint(NewNearbyMeActivity newNearbyMeActivity, boolean z) {
        MaterialCardView materialCardView = (MaterialCardView) newNearbyMeActivity._$_findCachedViewById(R.id.res_0x7f0a056b_mybillsactivity_provideservicesmodule_1);
        if (materialCardView != null) {
            materialCardView.setVisibility(z ? 0 : 8);
        }
    }

    public static final /* synthetic */ void access$resetStatusBar(NewNearbyMeActivity newNearbyMeActivity) {
        newNearbyMeActivity.getWindow().clearFlags(512);
        View _$_findCachedViewById = newNearbyMeActivity._$_findCachedViewById(R.id.view_gradient);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(8);
        }
    }

    public static final /* synthetic */ void access$setupBottomSheetWithSearchResult(NewNearbyMeActivity newNearbyMeActivity, List list, boolean z) {
        newNearbyMeActivity.DatabaseTableConfigUtil = false;
        NewMerchantListView newMerchantListView = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.removeLoading();
            List list2 = list;
            if (list2 == null || list2.isEmpty()) {
                if (newNearbyMeActivity.getNearbyPresenter().lookAheadTest()) {
                    newMerchantListView.showLoadMore();
                    return;
                }
                return;
            }
            NewMerchantListView newMerchantListView2 = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
            if (newMerchantListView2 != null) {
                newMerchantListView2.appendItem(list);
                newNearbyMeActivity.PlaceComponentResult(newMerchantListView2.getMerchantList());
                if (newNearbyMeActivity.getNearbyPresenter().lookAheadTest()) {
                    newMerchantListView2.showLoadMore();
                }
                newNearbyMeActivity.getNearbyPresenter().MyBillsEntityDataFactory(z);
            }
        }
    }

    public static final /* synthetic */ void access$setupMerchantShopListByPassedMerchantId(NewNearbyMeActivity newNearbyMeActivity, List list) {
        if (newNearbyMeActivity.getNearbyPresenter().PlaceComponentResult() == null) {
            newNearbyMeActivity.MyBillsEntityDataFactory(list);
            return;
        }
        List<ShopModel> PlaceComponentResult = newNearbyMeActivity.getNearbyPresenter().PlaceComponentResult(list, newNearbyMeActivity.getNearbyPresenter().PlaceComponentResult());
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        newNearbyMeActivity.MyBillsEntityDataFactory(PlaceComponentResult);
        newNearbyMeActivity.getNearbyPresenter().PlaceComponentResult((String) null);
    }

    public static final /* synthetic */ void access$showLoading(NewNearbyMeActivity newNearbyMeActivity) {
        NewMerchantListView newMerchantListView = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.showShimmerMerchantList();
        }
    }

    public static final /* synthetic */ void access$showLocationRequest(NewNearbyMeActivity newNearbyMeActivity) {
        Disposable disposable = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (disposable != null) {
            disposable.dispose();
        }
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder((Application) newNearbyMeActivity.getDanaApplication());
        locationRequestBuilder.MyBillsEntityDataFactory.setAlwaysShow(true);
        locationRequestBuilder.MyBillsEntityDataFactory.addLocationRequest(LocationUtil.LocationRequestBuilder.PlaceComponentResult());
        newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda8 = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(locationRequestBuilder.MyBillsEntityDataFactory.build()).subscribe(new Consumer() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewNearbyMeActivity.m2739$r8$lambda$iZuSAaUlseOek2yYfAosOU9wu4(NewNearbyMeActivity.this, (LocationSettingsResult) obj);
            }
        });
    }

    public static final /* synthetic */ void access$showMerchantDetailFromOtherStoreList(NewNearbyMeActivity newNearbyMeActivity, ShopModel shopModel) {
        BottomsheetBehaviorExtKt.getAuthRequestContext((LockableBaseBottomSheetBehavior) newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.showMerchantDetailFromList(shopModel, TrackerKey.SourceType.NEARBY_SHOP_LIST);
        }
        newNearbyMeActivity.getPhotoPreviewPresenter().BuiltInFictitiousFunctionClassFactory(shopModel);
    }

    public static final /* synthetic */ void access$showSearchResultBottomsheet(NewNearbyMeActivity newNearbyMeActivity) {
        if (BottomsheetBehaviorExtKt.KClassImpl$Data$declaredNonStaticMembers$2((LockableBaseBottomSheetBehavior) newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue())) {
            BottomsheetBehaviorExtKt.getAuthRequestContext((LockableBaseBottomSheetBehavior) newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
        }
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) newNearbyMeActivity._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            merchantDetailBottomsheetView.hideMerchantDetailBottomsheet();
        }
        NewMerchantListView newMerchantListView = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.clearMerchantList();
        }
        BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory((LockableBaseBottomSheetBehavior) newNearbyMeActivity.PrepareContext.getValue());
    }

    public static final /* synthetic */ void access$updateShopModelInListAndMap(NewNearbyMeActivity newNearbyMeActivity, List list) {
        NewMerchantListView newMerchantListView = (NewMerchantListView) newNearbyMeActivity._$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.updateShops(list);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(ShopModel p0) {
        MapHelper mapHelper = getMapHelper();
        LatLng authRequestContext = LocationUtil.getAuthRequestContext(LocationUtil.PlaceComponentResult(p0.DatabaseTableConfigUtil, p0.PrepareContext));
        String PlaceComponentResult = MapHelper.PlaceComponentResult(LocationUtil.PlaceComponentResult(p0.DatabaseTableConfigUtil, p0.PrepareContext), p0.BottomSheetCardBindingView$watcherCardNumberView$1, p0.whenAvailable, false, true);
        BitmapDescriptor bitmapDescriptor = mapHelper.PlaceComponentResult.get(PlaceComponentResult);
        if (bitmapDescriptor == null) {
            bitmapDescriptor = NewShopMarkerHelper.KClassImpl$Data$declaredNonStaticMembers$2(mapHelper.BuiltInFictitiousFunctionClassFactory, p0, true);
            mapHelper.PlaceComponentResult.put(PlaceComponentResult, bitmapDescriptor);
        }
        MarkerOptions markerOptions = mapHelper.MyBillsEntityDataFactory.get(PlaceComponentResult);
        if (markerOptions == null) {
            markerOptions = new MarkerOptions().position(authRequestContext).icon(bitmapDescriptor).zIndex(p0.A).anchor(0.5f, 1.0f);
            mapHelper.MyBillsEntityDataFactory.put(PlaceComponentResult, markerOptions);
        }
        MarkerOptions zIndex = markerOptions.zIndex(p0.A);
        if (zIndex == null) {
            zIndex = null;
        } else if (PlaceComponentResult(p0)) {
            zIndex.visible(false);
        }
        GoogleMap googleMap = getMapHelper().KClassImpl$Data$declaredNonStaticMembers$2;
        Marker addMarker = googleMap != null ? googleMap.addMarker(zIndex) : null;
        if (addMarker != null) {
            addMarker.setTitle(getString(R.string.iconMerchant));
            addMarker.setTag(p0);
            LinkedHashMap<String, Marker> linkedHashMap = this.FragmentBottomSheetPaymentSettingBinding;
            String str = p0.BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(str, "");
            linkedHashMap.put(str, addMarker);
            if (PlaceComponentResult(p0)) {
                KClassImpl$Data$declaredNonStaticMembers$2(addMarker, p0);
            }
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (BottomsheetBehaviorExtKt.KClassImpl$Data$declaredNonStaticMembers$2((LockableBaseBottomSheetBehavior) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue())) {
            BottomsheetBehaviorExtKt.getAuthRequestContext((LockableBaseBottomSheetBehavior) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue());
        }
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        if (!BottomsheetBehaviorExtKt.PlaceComponentResult((LockableBaseBottomSheetBehavior) this.PrepareContext.getValue()) && !BottomsheetBehaviorExtKt.PlaceComponentResult((LockableBaseBottomSheetBehavior) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue())) {
            MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
            if (!(merchantDetailBottomsheetView != null && merchantDetailBottomsheetView.isShowing())) {
                return false;
            }
        }
        return true;
    }

    private final void newProxyInstance() {
        OtherStoreResultView otherStoreResultView;
        String stringExtra = getIntent().getStringExtra("EXTRA_MERCHANT_ID");
        getIntent().removeExtra("EXTRA_MERCHANT_ID");
        if (stringExtra == null || (otherStoreResultView = (OtherStoreResultView) _$_findCachedViewById(R.id.WriteAbortedException)) == null) {
            return;
        }
        Location location = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(location, "");
        otherStoreResultView.searchOtherMerchantByMerchantId(location, stringExtra, SearchType.MERCHANTID_SORTED_BY_DISTANCE, TrackerKey.SourceType.DEEP_LINK);
    }

    private final void FragmentBottomSheetPaymentSettingBinding() {
        if (!BottomsheetBehaviorExtKt.KClassImpl$Data$declaredNonStaticMembers$2((LockableBaseBottomSheetBehavior) this.PrepareContext.getValue())) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MobilePaymentLoginRequest);
            if (appCompatTextView != null) {
                appCompatTextView.setVisibility(8);
            }
            PlaceComponentResult(R.id.f4039mdbvMerchantDetailBottomsheet);
            return;
        }
        PlaceComponentResult(R.id.f3775res_0x7f0a071a_amountformfragment_onbackpressedcallback_1);
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        String stringExtra = getIntent().getStringExtra("EXTRA_SOURCE");
        getIntent().removeExtra("EXTRA_SOURCE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = stringExtra;
        if (!Intrinsics.areEqual(stringExtra, "Home")) {
            startTimer(TimerEventKey.NEARBY_OPEN);
        }
        DaggerNewNearbyComponent.Builder PlaceComponentResult = DaggerNewNearbyComponent.PlaceComponentResult();
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (NearbyMeModule) Preconditions.getAuthRequestContext(new NearbyMeModule(new NearbyMeContract.View() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$injectComponent$1
            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void BuiltInFictitiousFunctionClassFactory(IntentSender p0) {
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void MyBillsEntityDataFactory() {
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void PlaceComponentResult(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final String getAuthRequestContext() {
                return "Nearby Maps (Home)";
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void getAuthRequestContext(boolean p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                MerchantFilterView merchantFilterView = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mfvMerchantMapsCategory);
                if (merchantFilterView != null) {
                    merchantFilterView.showShimmer();
                }
                NewNearbyMeActivity.access$showLoading(NewNearbyMeActivity.this);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                NewMerchantListView newMerchantListView;
                NewMerchantListView newMerchantListView2 = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                if (newMerchantListView2 != null) {
                    newMerchantListView2.removeLoading();
                }
                if (NewNearbyMeActivity.this.getNearbyPresenter().KClassImpl$Data$declaredNonStaticMembers$2() > 1) {
                    if (NewNearbyMeActivity.this.getNearbyPresenter().lookAheadTest() && (newMerchantListView = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity)) != null) {
                        newMerchantListView.showLoadMore();
                    }
                } else {
                    NewMerchantListView newMerchantListView3 = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                    if (newMerchantListView3 != null) {
                        newMerchantListView3.showEmptyState();
                    }
                }
                NewNearbyMeActivity.this.PlaceComponentResult(NewNearbyMeActivity.RefreshCondition.ERROR);
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                String str;
                str = NewNearbyMeActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                if (Intrinsics.areEqual(str, "Home")) {
                    return;
                }
                NewNearbyMeActivity.this.moveToNextValue(false);
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<ShopModel> p0) {
                NewNearbyMeActivity.MapState mapState;
                NewNearbyMeActivity.RefreshCondition refreshCondition;
                Intrinsics.checkNotNullParameter(p0, "");
                mapState = NewNearbyMeActivity.this.scheduleImpl;
                if (mapState != NewNearbyMeActivity.MapState.MERCHANT_OTHER_STORE) {
                    NewNearbyMeActivity.access$setupMerchantShopListByPassedMerchantId(NewNearbyMeActivity.this, p0);
                }
                refreshCondition = NewNearbyMeActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (refreshCondition != NewNearbyMeActivity.RefreshCondition.ERROR) {
                    NewNearbyMeActivity.this.PlaceComponentResult(NewNearbyMeActivity.RefreshCondition.FETCHED);
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final String PlaceComponentResult() {
                return NewNearbyMeActivity.this.getString(R.string.nearby_no_merchant_list_view_title);
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void PlaceComponentResult(List<ShopModel> p0) {
                if (p0 != null) {
                    NewNearbyMeActivity.access$updateShopModelInListAndMap(NewNearbyMeActivity.this, p0);
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void getAuthRequestContext(Account p0) {
                String str;
                NewNearbyMeActivity newNearbyMeActivity = NewNearbyMeActivity.this;
                if (p0 == null || (str = p0.getAvatarUrl()) == null) {
                    str = "";
                }
                newNearbyMeActivity.MyBillsEntityDataFactory = str;
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void MyBillsEntityDataFactory(List<ShopModel> p0) {
                if (p0 != null) {
                    NewNearbyMeActivity newNearbyMeActivity = NewNearbyMeActivity.this;
                    newNearbyMeActivity.getMerchantCategoryPresenter().PlaceComponentResult(p0, newNearbyMeActivity.getNearbyPresenter().KClassImpl$Data$declaredNonStaticMembers$2());
                }
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void MyBillsEntityDataFactory(List<? extends ShopModel> p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                NewNearbyMeActivity.access$setupBottomSheetWithSearchResult(NewNearbyMeActivity.this, p0, p1);
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                boolean z;
                NewNearbyMeActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0;
                NewNearbyMeActivity newNearbyMeActivity = NewNearbyMeActivity.this;
                z = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                NewNearbyMeActivity.access$renderNearbyReviewPageEntryPoint(newNearbyMeActivity, z);
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.SseAuthenticationResponseParser);
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(p0 ? 0 : 8);
            }

            @Override // id.dana.contract.nearbyme.NearbyMeContract.View
            public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                String shownErrorMessage;
                shownErrorMessage = NewNearbyMeActivity.this.getShownErrorMessage();
                return shownErrorMessage == null ? "" : shownErrorMessage;
            }
        }));
        PlaceComponentResult.MyBillsEntityDataFactory = (MerchantDetailModule) Preconditions.getAuthRequestContext(new MerchantDetailModule(new MerchantDetailContract.View() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$getMerchantDetailModule$1
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

            @Override // id.dana.nearbyme.merchantdetail.MerchantDetailContract.View
            public final void BuiltInFictitiousFunctionClassFactory(ShopModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                NewNearbyMeActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // id.dana.nearbyme.merchantdetail.MerchantDetailContract.View
            public final void MyBillsEntityDataFactory(Throwable p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                NewNearbyMeActivity.this.getAuthRequestContext(p0, p1);
            }
        }));
        PlaceComponentResult.PlaceComponentResult = (MerchantModule) Preconditions.getAuthRequestContext(new MerchantModule(new MerchantContract.View() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$getMerchantModule$1
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

            @Override // id.dana.nearbyme.MerchantContract.View
            public final /* synthetic */ void onGetMerchantCategories(List list) {
                MerchantContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.nearbyme.MerchantContract.View
            public final void onCheckMerchantFilterFeatureEnableSuccess(boolean p0) {
                MerchantFilterView merchantFilterView = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
                if (merchantFilterView != null) {
                    merchantFilterView.setFilterEnabled(p0);
                }
            }

            @Override // id.dana.nearbyme.MerchantContract.View
            public final void onGetNewMerchantListCategories(List<MerchantCategoryModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantFilterView merchantFilterView = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
                if (merchantFilterView != null) {
                    merchantFilterView.setMerchantCategories(p0);
                }
                MerchantFilterView merchantFilterView2 = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.ViewMonthlyAutoTopupContainerBinding);
                if (merchantFilterView2 != null) {
                    merchantFilterView2.setMerchantCategories(p0);
                }
            }

            @Override // id.dana.nearbyme.MerchantContract.View
            public final void onGetNewMerchantMapsCategories(List<MerchantCategoryModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantFilterView merchantFilterView = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mfvMerchantMapsCategory);
                if (merchantFilterView != null) {
                    merchantFilterView.setMerchantCategories(p0);
                }
            }

            @Override // id.dana.nearbyme.MerchantContract.View
            public final void onErrorGetNewMerchantCategories(MerchantCategoryType p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0 == MerchantCategoryType.MAPS) {
                    MerchantFilterView merchantFilterView = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mfvMerchantMapsCategory);
                    if (merchantFilterView != null) {
                        merchantFilterView.hideShimmer();
                    }
                    MerchantFilterView merchantFilterView2 = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mfvMerchantMapsCategory);
                    if (merchantFilterView2 != null) {
                        merchantFilterView2.setVisibility(8);
                        return;
                    }
                    return;
                }
                MerchantFilterView merchantFilterView3 = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
                if (merchantFilterView3 != null) {
                    merchantFilterView3.hideShimmer();
                }
                MerchantFilterView merchantFilterView4 = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
                if (merchantFilterView4 != null) {
                    merchantFilterView4.setVisibility(8);
                }
            }
        }));
        PlaceComponentResult.getAuthRequestContext = (PhotoGalleryModule) Preconditions.getAuthRequestContext(new PhotoGalleryModule("", "", new PhotoGalleryContract.View() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$getPhotoGalleryModule$1
            @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

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

            @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<MerchantImageModel> p0, ShopModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                NewMerchantListView newMerchantListView = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                if (newMerchantListView != null) {
                    newMerchantListView.updateImage(p0, p1);
                }
                MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
                if (merchantDetailBottomsheetView != null) {
                    merchantDetailBottomsheetView.updateImage(p0, p1);
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, NearbyMeModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, MerchantDetailModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, MerchantModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, PhotoGalleryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerNewNearbyComponent.NewNearbyComponentImpl(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getNearbyPresenter(), getMerchantDetailPresenter(), getMerchantCategoryPresenter(), getPhotoPreviewPresenter());
        setMenuLeftButton(R.drawable.ic_close_white);
        setMenuLeftContentDescription(getString(R.string.btnX));
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(this);
        }
        getMapHelper().NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        View getAuthRequestContext = getSupportFragmentManager().findFragmentById(R.id.setColumnOrderPreserved).getGetAuthRequestContext();
        if (getAuthRequestContext != null) {
            getAuthRequestContext.post(new Runnable() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NewNearbyMeActivity.$r8$lambda$7siQHXtLFuhVebtwp5nlHDVFD5E(NewNearbyMeActivity.this);
                }
            });
        }
        CardView cardView = (CardView) _$_findCachedViewById(R.id.GifDrawableTransformation_res_0x7f0a055a);
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeActivity.$r8$lambda$mAB5tdtZAspf4p3TWohEpJZZQVw(NewNearbyMeActivity.this, view);
                }
            });
        }
        CardView cardView2 = (CardView) _$_findCachedViewById(R.id.cvGoToMyLocation);
        if (cardView2 != null) {
            cardView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeActivity.$r8$lambda$a45xUenXogwQnGXZyVtVjDV5Lwo(NewNearbyMeActivity.this, view);
                }
            });
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.MobilePaymentLoginRequest);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeActivity.$r8$lambda$vgoK1j2jUhlTu3iDk1N0wTvvzM0(NewNearbyMeActivity.this, view);
                }
            });
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.setDanaContactPresenter);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeActivity.$r8$lambda$MAb2QEnLe4AYNrWBot1y92L4OSI(NewNearbyMeActivity.this, view);
                }
            });
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id._release);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeActivity.m2740$r8$lambda$z4Mj1F4egIvFAf5Dnjdiznox4(NewNearbyMeActivity.this, view);
                }
            });
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.toolbar_layout);
        if (constraintLayout != null) {
            ViewExtKt.BuiltInFictitiousFunctionClassFactory(constraintLayout, null, Integer.valueOf(SizeUtil.MyBillsEntityDataFactory(this)), null, null, 13);
        }
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a056b_mybillsactivity_provideservicesmodule_1);
        if (materialCardView != null) {
            materialCardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewNearbyMeActivity.m2736$r8$lambda$BsuOoXlpRveT9G9gEfBHZ9t9X0(NewNearbyMeActivity.this, view);
                }
            });
        }
        NetworkUserEntityData$$ExternalSyntheticLambda5();
        MerchantDetailBottomsheetView merchantDetailBottomsheetView = (MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
        if (merchantDetailBottomsheetView != null) {
            BottomSheetBehavior<MerchantDetailBottomsheetView> from = BottomSheetBehavior.from((MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet));
            Intrinsics.checkNotNullExpressionValue(from, "");
            merchantDetailBottomsheetView.setBottomsheetBehavior(from);
            merchantDetailBottomsheetView.setDimBackground(_$_findCachedViewById(R.id.vDimBackgroundMerchantDetail));
            merchantDetailBottomsheetView.addBottomsheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantDetailBottomsheet$1$1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onSlide(View p0, float p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onStateChanged(View p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p1 != 3) {
                        if (p1 == 4) {
                            NewNearbyMeActivity.access$onCollapseMerchantDetailBottomsheet(NewNearbyMeActivity.this);
                            return;
                        } else if (p1 == 5) {
                            NewNearbyMeActivity.access$onHideMerchantDetailBottomsheet(NewNearbyMeActivity.this);
                            return;
                        } else if (p1 != 6) {
                            return;
                        }
                    }
                    NewNearbyMeActivity.access$onExpandMerchantDetailBottomsheet(NewNearbyMeActivity.this);
                }
            });
            if (lookAheadTest()) {
                merchantDetailBottomsheetView.setInitialState(3);
            } else {
                merchantDetailBottomsheetView.setInitialState(5);
            }
            merchantDetailBottomsheetView.setOnScrollListener(new Function1<Boolean, Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantDetailBottomsheet$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    NewNearbyMeActivity.this.BuiltInFictitiousFunctionClassFactory(z);
                }
            });
        }
        MerchantDetailView merchantDetailView = (MerchantDetailView) _$_findCachedViewById(R.id.res_0x7f0a0e87_windowinsetscontrollercompat_impl23);
        if (merchantDetailView != null) {
            merchantDetailView.setOnOtherStoreClicked(new Function1<ShopModel, Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantDetailBottomsheet$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ShopModel shopModel) {
                    invoke2(shopModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ShopModel shopModel) {
                    Intrinsics.checkNotNullParameter(shopModel, "");
                    NewNearbyMeActivity.access$openOtherStoreBottomsheet(NewNearbyMeActivity.this, shopModel);
                }
            });
        }
        LiveData KClassImpl$Data$declaredNonStaticMembers$2 = Transformations.KClassImpl$Data$declaredNonStaticMembers$2(((MerchantDetailBottomsheetView) _$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet)).getShopModelLiveData());
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this, new Observer() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$$ExternalSyntheticLambda6
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                NewNearbyMeActivity.m2741$r8$lambda$zj5zMc3R0TxXRQvTqN6gFWPy2E(NewNearbyMeActivity.this, (ShopModel) obj);
            }
        });
        LockableBaseBottomSheetBehavior lockableBaseBottomSheetBehavior = (LockableBaseBottomSheetBehavior) this.PrepareContext.getValue();
        lockableBaseBottomSheetBehavior.setFitToContents(false);
        lockableBaseBottomSheetBehavior.setHalfExpandedRatio(0.4f);
        lockableBaseBottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantListBottomsheet$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View p0, float p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View p0, int p1) {
                boolean z;
                boolean z2;
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 == 3) {
                    ((NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity)).setCenterRecyclerView(true);
                    NewNearbyMeActivity.this.PlaceComponentResult(false);
                    NewNearbyMeActivity.access$renderNearbyReviewPageEntryPoint(NewNearbyMeActivity.this, false);
                    NewNearbyMeActivity.access$getMerchantListBottomsheet(NewNearbyMeActivity.this).setHideable(false);
                } else if (p1 == 4) {
                    ((NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity)).setCenterRecyclerView(false);
                    NewNearbyMeActivity.this.PlaceComponentResult(true);
                    NewNearbyMeActivity newNearbyMeActivity = NewNearbyMeActivity.this;
                    z = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    NewNearbyMeActivity.access$renderNearbyReviewPageEntryPoint(newNearbyMeActivity, z);
                    NewNearbyMeActivity.access$getMerchantListBottomsheet(NewNearbyMeActivity.this).setHideable(false);
                } else if (p1 == 6) {
                    ((NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity)).setCenterRecyclerView(false);
                    NewNearbyMeActivity.this.PlaceComponentResult(true);
                    NewNearbyMeActivity newNearbyMeActivity2 = NewNearbyMeActivity.this;
                    z2 = newNearbyMeActivity2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    NewNearbyMeActivity.access$renderNearbyReviewPageEntryPoint(newNearbyMeActivity2, z2);
                    NewNearbyMeActivity.this.PlaceComponentResult((int) R.id.f3775res_0x7f0a071a_amountformfragment_onbackpressedcallback_1);
                    NewNearbyMeActivity.access$getMerchantListBottomsheet(NewNearbyMeActivity.this).setHideable(false);
                }
            }
        });
        if (lookAheadTest() || scheduleImpl()) {
            BottomsheetBehaviorExtKt.getAuthRequestContext(lockableBaseBottomSheetBehavior);
        } else {
            BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory(lockableBaseBottomSheetBehavior);
        }
        NewMerchantListView newMerchantListView = (NewMerchantListView) _$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView != null) {
            newMerchantListView.setOnMerchantListClicked(new Function1<ShopModel, Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantListBottomsheet$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ShopModel shopModel) {
                    invoke2(shopModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ShopModel shopModel) {
                    Intrinsics.checkNotNullParameter(shopModel, "");
                    NewNearbyMeActivity.access$resetStatusBar(NewNearbyMeActivity.this);
                    MerchantDetailBottomsheetView merchantDetailBottomsheetView2 = (MerchantDetailBottomsheetView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
                    MutableLiveData<ShopModel> shopModelLiveData = merchantDetailBottomsheetView2 != null ? merchantDetailBottomsheetView2.getShopModelLiveData() : null;
                    if (shopModelLiveData != null) {
                        shopModelLiveData.PlaceComponentResult((MutableLiveData<ShopModel>) shopModel);
                    }
                    NewNearbyMeActivity.access$getMerchantListBottomsheet(NewNearbyMeActivity.this).MyBillsEntityDataFactory = true;
                    MerchantDetailBottomsheetView merchantDetailBottomsheetView3 = (MerchantDetailBottomsheetView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mdbvMerchantDetailBottomsheet);
                    if (merchantDetailBottomsheetView3 != null) {
                        merchantDetailBottomsheetView3.showMerchantDetailFromList(shopModel, TrackerKey.SourceType.NEARBY_SHOP_LIST);
                    }
                    NewNearbyMeActivity.this.getPhotoPreviewPresenter().BuiltInFictitiousFunctionClassFactory(shopModel);
                }
            });
        }
        NewMerchantListView newMerchantListView2 = (NewMerchantListView) _$_findCachedViewById(R.id.DeeplinkServiceEntity);
        if (newMerchantListView2 != null) {
            newMerchantListView2.setOnLoadMoreClicked(new Function0<Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantListBottomsheet$3
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
                    NewNearbyMeActivity.MapState mapState;
                    Location location;
                    Location location2;
                    NewMerchantListView newMerchantListView3 = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                    if (newMerchantListView3 != null) {
                        newMerchantListView3.removeLoadMore();
                    }
                    NewMerchantListView newMerchantListView4 = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                    if (newMerchantListView4 != null) {
                        newMerchantListView4.showLoading();
                    }
                    mapState = NewNearbyMeActivity.this.scheduleImpl;
                    if (mapState == NewNearbyMeActivity.MapState.SEARCH_RESULT) {
                        NearbyMeContract.Presenter nearbyPresenter = NewNearbyMeActivity.this.getNearbyPresenter();
                        location2 = NewNearbyMeActivity.this.moveToNextValue;
                        nearbyPresenter.PlaceComponentResult(location2);
                        return;
                    }
                    NearbyMeContract.Presenter nearbyPresenter2 = NewNearbyMeActivity.this.getNearbyPresenter();
                    location = NewNearbyMeActivity.this.moveToNextValue;
                    nearbyPresenter2.BuiltInFictitiousFunctionClassFactory(location);
                }
            });
        }
        LockableBaseBottomSheetBehavior lockableBaseBottomSheetBehavior2 = (LockableBaseBottomSheetBehavior) this.NetworkUserEntityData$$ExternalSyntheticLambda7.getValue();
        lockableBaseBottomSheetBehavior2.setHalfExpandedRatio(0.4f);
        lockableBaseBottomSheetBehavior2.setFitToContents(false);
        BottomsheetBehaviorExtKt.getAuthRequestContext(lockableBaseBottomSheetBehavior2);
        lockableBaseBottomSheetBehavior2.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantOtherStoreBottomsheet$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View p0, float p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View p0, int p1) {
                boolean z;
                boolean z2;
                String merchantName;
                String str = "";
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 == 3) {
                    NewNearbyMeActivity.this.getAuthRequestContext(false);
                    NewNearbyMeActivity.access$renderNearbyReviewPageEntryPoint(NewNearbyMeActivity.this, false);
                } else if (p1 == 4) {
                    NewNearbyMeActivity.this.getAuthRequestContext(true);
                    NewNearbyMeActivity newNearbyMeActivity = NewNearbyMeActivity.this;
                    z = newNearbyMeActivity.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    NewNearbyMeActivity.access$renderNearbyReviewPageEntryPoint(newNearbyMeActivity, z);
                } else if (p1 == 6) {
                    NewNearbyMeActivity.access$getMerchantOtherStoreBottomsheet(NewNearbyMeActivity.this).setHideable(false);
                    NewNearbyMeActivity.this.PlaceComponentResult((int) R.id.f3776flBottomsheetOtherMerchant);
                    NewNearbyMeActivity.this.getAuthRequestContext(true);
                    NewNearbyMeActivity newNearbyMeActivity2 = NewNearbyMeActivity.this;
                    z2 = newNearbyMeActivity2.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    NewNearbyMeActivity.access$renderNearbyReviewPageEntryPoint(newNearbyMeActivity2, z2);
                    NewNearbyMeActivity newNearbyMeActivity3 = NewNearbyMeActivity.this;
                    OtherStoreResultView otherStoreResultView = (OtherStoreResultView) newNearbyMeActivity3._$_findCachedViewById(R.id.WriteAbortedException);
                    if (otherStoreResultView != null && (merchantName = otherStoreResultView.getMerchantName()) != null) {
                        str = merchantName;
                    }
                    newNearbyMeActivity3.PlaceComponentResult(str);
                    MerchantFilterView merchantFilterView = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mfvMerchantMapsCategory);
                    if (merchantFilterView != null) {
                        merchantFilterView.setVisibility(8);
                    }
                }
            }
        });
        final OtherStoreResultView otherStoreResultView = (OtherStoreResultView) _$_findCachedViewById(R.id.WriteAbortedException);
        if (otherStoreResultView != null) {
            otherStoreResultView.setOnShopLoaded(new Function1<List<? extends ShopModel>, Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantOtherStoreBottomsheet$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ShopModel> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends ShopModel> list) {
                    Intrinsics.checkNotNullParameter(list, "");
                    NewNearbyMeActivity.this.scheduleImpl = NewNearbyMeActivity.MapState.MERCHANT_OTHER_STORE;
                    if (BottomsheetBehaviorExtKt.moveToNextValue(NewNearbyMeActivity.access$getMerchantOtherStoreBottomsheet(NewNearbyMeActivity.this))) {
                        return;
                    }
                    NewNearbyMeActivity.access$populateOtherStoreList(NewNearbyMeActivity.this, list);
                    NewNearbyMeActivity newNearbyMeActivity = NewNearbyMeActivity.this;
                    String str = ((ShopModel) CollectionsKt.first((List) list)).NetworkUserEntityData$$ExternalSyntheticLambda6;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    newNearbyMeActivity.PlaceComponentResult(str);
                }
            });
            otherStoreResultView.setOnMerchantSearchClosed(new Function0<Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantOtherStoreBottomsheet$2$2
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
                    NewNearbyMeActivity.this.scheduleImpl = NewNearbyMeActivity.MapState.MERCHANT_LIST;
                    BottomsheetBehaviorExtKt.getAuthRequestContext(NewNearbyMeActivity.access$getMerchantOtherStoreBottomsheet(NewNearbyMeActivity.this));
                    otherStoreResultView.onMerchantOtherStoreClosed();
                    MerchantFilterView merchantFilterView = (MerchantFilterView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.mfvMerchantMapsCategory);
                    if (merchantFilterView != null) {
                        merchantFilterView.setVisibility(0);
                    }
                    NewNearbyMeActivity.this.PlaceComponentResult("");
                    BottomsheetBehaviorExtKt.BuiltInFictitiousFunctionClassFactory(NewNearbyMeActivity.access$getMerchantListBottomsheet(NewNearbyMeActivity.this));
                    NewNearbyMeActivity.this.moveToNextValue();
                }
            });
            otherStoreResultView.setOnOtherStoreClickedListener(new Function1<ShopModel, Unit>() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupMerchantOtherStoreBottomsheet$2$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ShopModel shopModel) {
                    invoke2(shopModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ShopModel shopModel) {
                    Intrinsics.checkNotNullParameter(shopModel, "");
                    NewNearbyMeActivity.this.scheduleImpl = NewNearbyMeActivity.MapState.MERCHANT_OTHER_STORE;
                    NewNearbyMeActivity.access$showMerchantDetailFromOtherStoreList(NewNearbyMeActivity.this, shopModel);
                }
            });
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.onTooManyRedirects_res_0x7f0a0352);
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        ConstraintLayout constraintLayout3 = constraintLayout2;
        if (ViewCompat.getValueOfTouchPositionAbsolute(constraintLayout3) && !constraintLayout3.isLayoutRequested()) {
            access$getMerchantListBottomsheet(this).setExpandedOffset(_$_findCachedViewById(R.id.clLocationContainer).getBottom() + SizeUtil.PlaceComponentResult(8));
            access$getMerchantOtherStoreBottomsheet(this).setExpandedOffset(access$getMerchantListBottomsheet(this).getExpandedOffset());
        } else {
            constraintLayout3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$setupBottomsheetsHeight$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    p0.removeOnLayoutChangeListener(this);
                    NewNearbyMeActivity.access$getMerchantListBottomsheet(NewNearbyMeActivity.this).setExpandedOffset(NewNearbyMeActivity.this._$_findCachedViewById(R.id.clLocationContainer).getBottom() + SizeUtil.PlaceComponentResult(8));
                    NewNearbyMeActivity.access$getMerchantOtherStoreBottomsheet(NewNearbyMeActivity.this).setExpandedOffset(NewNearbyMeActivity.access$getMerchantListBottomsheet(NewNearbyMeActivity.this).getExpandedOffset());
                }
            });
        }
        MerchantFilterView merchantFilterView = (MerchantFilterView) _$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
        if (merchantFilterView != null) {
            final MerchantCategoryType merchantCategoryType = MerchantCategoryType.LIST;
            merchantFilterView.setOnCategoryCheckedListener(new OnCategoryCheckedListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$getOnCategoryCheckedListener$1
                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final /* synthetic */ void onMulitpleCategorySelected(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final void onMulitpleCategorySelected(List<MerchantCategoryModel> p0, boolean p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewMerchantListView newMerchantListView3 = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                    if (newMerchantListView3 != null) {
                        newMerchantListView3.clearMerchantList();
                    }
                    NewNearbyMeActivity.this.DatabaseTableConfigUtil();
                    NewNearbyMeActivity.this.getNearbyPresenter().BuiltInFictitiousFunctionClassFactory(p0, merchantCategoryType);
                }

                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final void onCategoryClick(MerchantCategoryModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NearbyAnalyticTracker nearbyAnalyticTracker = NewNearbyMeActivity.this.getNearbyAnalyticTracker();
                    String str = p0.getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    nearbyAnalyticTracker.BuiltInFictitiousFunctionClassFactory(str);
                }
            });
        }
        MerchantFilterView merchantFilterView2 = (MerchantFilterView) _$_findCachedViewById(R.id.mfvMerchantMapsCategory);
        if (merchantFilterView2 != null) {
            final MerchantCategoryType merchantCategoryType2 = MerchantCategoryType.MAPS;
            merchantFilterView2.setOnCategoryCheckedListener(new OnCategoryCheckedListener() { // from class: id.dana.nearbyrevamp.NewNearbyMeActivity$getOnCategoryCheckedListener$1
                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final /* synthetic */ void onMulitpleCategorySelected(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final void onMulitpleCategorySelected(List<MerchantCategoryModel> p0, boolean p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NewMerchantListView newMerchantListView3 = (NewMerchantListView) NewNearbyMeActivity.this._$_findCachedViewById(R.id.DeeplinkServiceEntity);
                    if (newMerchantListView3 != null) {
                        newMerchantListView3.clearMerchantList();
                    }
                    NewNearbyMeActivity.this.DatabaseTableConfigUtil();
                    NewNearbyMeActivity.this.getNearbyPresenter().BuiltInFictitiousFunctionClassFactory(p0, merchantCategoryType2);
                }

                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final void onCategoryClick(MerchantCategoryModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    NearbyAnalyticTracker nearbyAnalyticTracker = NewNearbyMeActivity.this.getNearbyAnalyticTracker();
                    String str = p0.getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    nearbyAnalyticTracker.BuiltInFictitiousFunctionClassFactory(str);
                }
            });
        }
        MerchantFilterView merchantFilterView3 = (MerchantFilterView) _$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
        if (merchantFilterView3 != null) {
            merchantFilterView3.showShimmer();
        }
        MerchantFilterView merchantFilterView4 = (MerchantFilterView) _$_findCachedViewById(R.id.mfvMerchantMapsCategory);
        if (merchantFilterView4 != null) {
            merchantFilterView4.showShimmer();
        }
        MerchantFilterView merchantFilterView5 = (MerchantFilterView) _$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
        if (merchantFilterView5 != null) {
            merchantFilterView5.setFilterType(1);
        }
        MerchantFilterView merchantFilterView6 = (MerchantFilterView) _$_findCachedViewById(R.id.mfvMerchantMapsCategory);
        if (merchantFilterView6 != null) {
            merchantFilterView6.setFilterType(0);
        }
        getMerchantCategoryPresenter().BuiltInFictitiousFunctionClassFactory();
        getMerchantCategoryPresenter().MyBillsEntityDataFactory();
        getNearbyPresenter().BuiltInFictitiousFunctionClassFactory(true);
        getNearbyPresenter().GetContactSyncConfig();
        getNearbyPresenter().getAuthRequestContext();
        getNearbyPresenter().MyBillsEntityDataFactory();
        getNearbyPresenter().NetworkUserEntityData$$ExternalSyntheticLambda0();
        getNearbyPresenter().BuiltInFictitiousFunctionClassFactory();
        getNearbyPresenter().moveToNextValue();
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("EXTRA_SHOP_ID", "") : null;
        if (lookAheadTest()) {
            this.scheduleImpl = MapState.MERCHANT_DETAIL_DEEPLINK;
        } else if (scheduleImpl()) {
            this.scheduleImpl = MapState.MERCHANT_OTHER_STORE;
        } else {
            String str = string;
            if (str == null || str.length() == 0) {
                NearbyMeContract.Presenter nearbyPresenter = getNearbyPresenter();
                String stringExtra2 = getIntent().getStringExtra("EXTRA_MERCHANT_ID");
                getIntent().removeExtra("EXTRA_MERCHANT_ID");
                nearbyPresenter.PlaceComponentResult(stringExtra2);
                String stringExtra3 = getIntent().getStringExtra(NearbyMeActivity.EXTRA_CATEGORY);
                getIntent().removeExtra(NearbyMeActivity.EXTRA_CATEGORY);
                String str2 = stringExtra3;
                if (!(str2 == null || str2.length() == 0)) {
                    MerchantFilterView merchantFilterView7 = (MerchantFilterView) _$_findCachedViewById(R.id.mfvMerchantMapsCategory);
                    if (merchantFilterView7 != null) {
                        merchantFilterView7.setPreselectedCategoryId(stringExtra3);
                    }
                    MerchantFilterView merchantFilterView8 = (MerchantFilterView) _$_findCachedViewById(R.id.res_0x7f0a0eab_openwalletidentitysection_lambda_43);
                    if (merchantFilterView8 != null) {
                        merchantFilterView8.setPreselectedCategoryId(stringExtra3);
                    }
                }
                Bundle extras2 = getIntent().getExtras();
                double d = extras2 != null ? extras2.getDouble(NearbyMeActivity.EXTRA_LOCATION_LAT) : 0.0d;
                Bundle extras3 = getIntent().getExtras();
                double d2 = extras3 != null ? extras3.getDouble(NearbyMeActivity.EXTRA_LOCATION_LON) : 0.0d;
                if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return;
                }
                if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return;
                }
                this.SubSequence = LocationUtil.PlaceComponentResult(d, d2);
            }
        }
    }

    private static void h(int i, int i2, short s, byte b, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i3 + ((int) (D ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = getValueOfTouchPositionAbsolute;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (getValueOfTouchPositionAbsolute[i2 + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (D ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (E[i2 + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (D ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i2 + i4) - 2) + ((int) (VerifyPinStateManager$executeRiskChallenge$2$2 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getOnBoardingScenario ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = getValueOfTouchPositionAbsolute;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = getValueOfTouchPositionAbsolute;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = E;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
