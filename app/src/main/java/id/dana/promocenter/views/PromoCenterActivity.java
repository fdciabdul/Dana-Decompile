package id.dana.promocenter.views;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.AudioTrack;
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
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.bumptech.glide.Glide;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.common.model.OptionModel;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promocenter.promo.PromoCenterContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.constant.UrlTag;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPromoCenterComponent;
import id.dana.di.component.PromoCenterComponent;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PromoCenterModule;
import id.dana.model.ThirdPartyService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.promocenter.adapter.PromoSpecialAdsAdapter;
import id.dana.promocenter.adapter.PromoSpecialAdsSectionAdapter;
import id.dana.promocenter.adapter.RegularPromoAdapter;
import id.dana.promocenter.adapter.RegularPromoSectionAdapter;
import id.dana.promocenter.model.PromoActionModel;
import id.dana.promocenter.model.PromoModel;
import id.dana.promocenter.model.PromoResultModel;
import id.dana.promocenter.model.PromoSectionModel;
import id.dana.promocenter.views.PromoCenterActivity;
import id.dana.promocenter.views.PromoView;
import id.dana.richview.category.CategoryView;
import id.dana.richview.category.model.CategoryModel;
import id.dana.richview.promocenter.PromoCategoryView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.StringWrapperKt;
import id.dana.utils.UrlUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0001wB\u0007¢\u0006\u0004\bv\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J#\u0010\u0006\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0006\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u0019\u0010\u0018\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u0005J+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001dH\u0002¢\u0006\u0004\b\u0006\u0010\u001eJ\u0019\u0010\u0004\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0004\u0010\u0019J\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010\u0005J\u0017\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010\u0005J\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b)\u0010\u0005J\u001d\u0010-\u001a\u00020\u00032\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016¢\u0006\u0004\b-\u0010.J/\u00104\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\t2\u000e\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013002\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0003H\u0014¢\u0006\u0004\b6\u0010\u0005J\u0017\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00032\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b;\u0010:J\u0015\u0010=\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\f¢\u0006\u0004\b=\u0010(J\u000f\u0010>\u001a\u00020\u0003H\u0002¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0003H\u0016¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010@\u001a\u00020\u0003H\u0002¢\u0006\u0004\b@\u0010\u0005J\u000f\u0010A\u001a\u00020\u0003H\u0002¢\u0006\u0004\bA\u0010\u0005J\u000f\u0010B\u001a\u00020\u0003H\u0016¢\u0006\u0004\bB\u0010\u0005R\u0018\u0010E\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010DR\u0018\u0010\u0006\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010GR\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010HR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010HR\u0016\u0010\u0004\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010HR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010HR\u0018\u0010\u0010\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010\u0017\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010LR\"\u0010N\u001a\u00020M8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010\u0011\u001a\u00020[8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010>\u001a\u00020^8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b_\u0010`R\"\u0010b\u001a\u00020a8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010i\u001a\u00020h8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010K\u001a\u00020o8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010@\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\br\u0010]R\u0016\u0010A\u001a\u00020s8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bt\u0010u"}, d2 = {"Lid/dana/promocenter/views/PromoCenterActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/contract/promocenter/promo/PromoCenterContract$View;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "getAuthRequestContext", "configToolbar", "dismissProgress", "", "getLayout", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "getErrorConfigVersion", IAPSyncCommand.COMMAND_INIT, "", "p0", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "lookAheadTest", "PlaceComponentResult", "(Ljava/lang/String;)Z", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;I)Z", "loadPromo", "Ljava/util/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;)V", "onEmptyGetPromoCategorized", "onEmptyGetPromoList", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onErrorGetPromo", "onErrorGetPromoCategorized", "hasMore", "onErrorLoadMorePromo", "(Z)V", "onGetPromoAdsError", "", "Lid/dana/promocenter/model/PromoModel;", "promoModels", "onGetPromoAdsSuccess", "(Ljava/util/List;)V", RequestPermission.REQUEST_CODE, "", RequestPermission.PERMISSIONS, "", RequestPermission.GRANT_RESULTS, "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "Lid/dana/promocenter/model/PromoResultModel;", "promoResultModel", "onSuccessGetPromoList", "(Lid/dana/promocenter/model/PromoResultModel;)V", "onSuccessLoadMorePromo", "tryEnable", "showErrorScreen", "scheduleImpl", "showProgress", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda1", "trackPromotionCenterOpen", "Lid/dana/richview/category/model/CategoryModel;", "Lid/dana/richview/category/model/CategoryModel;", "MyBillsEntityDataFactory", "Lid/dana/di/component/PromoCenterComponent;", "Lid/dana/di/component/PromoCenterComponent;", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lio/reactivex/disposables/Disposable;", "DatabaseTableConfigUtil", "Lio/reactivex/disposables/Disposable;", "Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;", "promoCenterPresenter", "Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;", "getPromoCenterPresenter", "()Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;", "setPromoCenterPresenter", "(Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;)V", "Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "promoSpecialAdsAdapter", "Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "getPromoSpecialAdsAdapter", "()Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "setPromoSpecialAdsAdapter", "(Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;)V", "Lid/dana/promocenter/model/PromoSectionModel;", "initRecordTimeStamp", "Lid/dana/promocenter/model/PromoSectionModel;", "Lid/dana/promocenter/adapter/PromoSpecialAdsSectionAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/promocenter/adapter/PromoSpecialAdsSectionAdapter;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/promocenter/adapter/RegularPromoAdapter;", "regularPromoAdapter", "Lid/dana/promocenter/adapter/RegularPromoAdapter;", "getRegularPromoAdapter", "()Lid/dana/promocenter/adapter/RegularPromoAdapter;", "setRegularPromoAdapter", "(Lid/dana/promocenter/adapter/RegularPromoAdapter;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "PrepareContext", "Landroidx/recyclerview/widget/LinearLayoutManager;", "newProxyInstance", "Lid/dana/promocenter/adapter/RegularPromoSectionAdapter;", "isLayoutRequested", "Lid/dana/promocenter/adapter/RegularPromoSectionAdapter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoCenterActivity extends BaseActivity implements PromoCenterContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Disposable moveToNextValue;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Disposable lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private PromoSpecialAdsSectionAdapter scheduleImpl;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private LinearLayoutManager DatabaseTableConfigUtil;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private CategoryModel MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private PromoSectionModel getErrorConfigVersion;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private RegularPromoSectionAdapter NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private PromoCenterComponent getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private PromoSectionModel GetContactSyncConfig;
    @Inject
    public PromoCenterContract.Presenter promoCenterPresenter;
    public PromoSpecialAdsAdapter promoSpecialAdsAdapter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    public RegularPromoAdapter regularPromoAdapter;
    public static final byte[] $$a = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 164;
    public static final byte[] getAuthRequestContext = {116, 58, -28, -63, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 223;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory = true;

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda7 = 269894799;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.promocenter.views.PromoCenterActivity.getAuthRequestContext
            int r7 = r7 + 97
            int r8 = 23 - r8
            int r9 = 56 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2e
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r9]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2e:
            int r9 = r9 + r8
            int r8 = r10 + 1
            int r9 = r9 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promocenter.views.PromoCenterActivity.a(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = id.dana.promocenter.views.PromoCenterActivity.$$a
            int r7 = r7 + 4
            int r6 = r6 * 3
            int r6 = 42 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promocenter.views.PromoCenterActivity.c(byte, int, int, java.lang.Object[]):void");
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
        b(true, 269 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 12, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, new char[]{65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2, 0, '\f', 15}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(true, (ViewConfiguration.getPressedStateDuration() >> 16) + 274, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 5 - Gravity.getAbsoluteGravity(0, 0), new char[]{5, 65532, 1, 65517, 17}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(false, 241 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 13 - TextUtils.indexOf("", "", 0), TextUtils.indexOf("", "") + 48, new char[]{65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(false, (ViewConfiguration.getWindowTouchSlop() >> 8) + 236, ImageFormat.getBitsPerPixel(0) + 60, 64 - Color.green(0), new char[]{65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(true, (ViewConfiguration.getJumpTapTimeout() >> 16) + 238, Color.alpha(0) + 40, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 65, new char[]{65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(true, TextUtils.getTrimmedLength("") + 267, TextUtils.lastIndexOf("", '0') + 22, 60 - View.resolveSizeAndState(0, 0, 0), new char[]{0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(false, ExpandableListView.getPackedPositionType(0L) + WheelView.DIVIDER_ALPHA, TextUtils.indexOf("", "") + 4, (ViewConfiguration.getFadingEdgeLength() >> 16) + 6, new char[]{2, 65532, 0, 65535, 7, 65532}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr14 = new Object[1];
                a(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a((byte) (PlaceComponentResult & 40), (byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult & 62), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getLongPressTimeout() >> 16), 3 - (KeyEvent.getMaxKeyCode() >> 16), (char) Color.argb(0, 0, 0, 0));
                        Object[] objArr17 = new Object[1];
                        c($$a[68], (byte) ($$a[47] - 1), (byte) (-$$a[12]), objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.combineMeasuredStates(0, 0), ExpandableListView.getPackedPositionGroup(0L) + 15, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 815, KeyEvent.keyCodeFromString("") + 29, (char) (57994 - Color.alpha(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetBefore("", 0), Process.getGidForName("") + 16, (char) TextUtils.getOffsetAfter("", 0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-629925838, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), 18 - (Process.myTid() >> 22), (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr21 = new Object[1];
                a(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                a((byte) (PlaceComponentResult & 40), (byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult & 62), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 61, Color.alpha(0) + 46, (char) (ImageFormat.getBitsPerPixel(0) + 1));
                        byte b = (byte) (-$$a[8]);
                        Object[] objArr24 = new Object[1];
                        c(b, (byte) (b | 16), (byte) ($$a[47] - 1), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-629925838, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.getCapsMode("", 0, 0) + 18, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr28 = new Object[1];
                a(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                a((byte) (PlaceComponentResult & 40), (byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult & 62), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 3 - KeyEvent.getDeadChar(0, 0), (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 38968));
                        byte b2 = (byte) (-$$a[8]);
                        Object[] objArr31 = new Object[1];
                        c(b2, (byte) (b2 | 16), (byte) ($$a[47] - 1), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-629925838, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 17 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr35 = new Object[1];
                a(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                a((byte) (PlaceComponentResult & 40), (byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult & 62), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 108, '3' - AndroidCharacter.getMirror('0'), (char) (AndroidCharacter.getMirror('0') - '0'));
                        Object[] objArr38 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), View.resolveSizeAndState(0, 0, 0) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-629925838, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
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
        return R.layout.activity_promo_center;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        int length = super.getResources().getString(R.string.title_saving).substring(0, 10).length() + DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN;
        int absoluteGravity = Gravity.getAbsoluteGravity(0, 0) + 12;
        try {
            byte b = getAuthRequestContext[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(true, length, absoluteGravity, ((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{65517, 65483, 16, '\f', 65483, 1, 6, '\f', 15, 1, 11, 65534, 16, 16, 2, 0, '\f', 15}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(true, super.getResources().getString(R.string.emergency_page_timer).substring(10, 11).codePointAt(0) + 164, 1 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), super.getResources().getString(R.string.my_bills_next_schedule_payment_today).substring(0, 1).length() + 4, new char[]{5, 65532, 1, 65517, 17}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b(false, 269 - KeyEvent.normalizeMetaState(0), super.getResources().getString(R.string.request_consent_dialog_title).substring(6, 13).codePointAt(0) - 14, TextUtils.indexOf("", "") + 26, new char[]{65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(false, super.getResources().getString(R.string.payment_processing).substring(0, 1).length() + 275, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 16, getPackageName().length() + 11, new char[]{'\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        b(false, getPackageName().codePointAt(6) + 144, Color.red(0) + 13, View.MeasureSpec.getMode(0) + 48, new char[]{65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30, 28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b(false, super.getResources().getString(R.string.family_account_failed_delete_family_account_message).substring(48, 49).length() + 235, 58 - MotionEvent.axisFromString(""), super.getResources().getString(R.string.res_0x7f130f5e_summaryvoucherview_externalsyntheticlambda1).substring(0, 4).length() + 60, new char[]{65527, 65518, 65526, Typography.quote, '!', 65527, 65523, Typography.quote, 65519, 65519, 65522, 65520, 65520, Typography.dollar, 65519, Typography.quote, 65519, 65524, 65521, 65524, InputCardNumberView.DIVIDER, 65527, '#', 65526, Typography.quote, 65520, 65520, '!', Typography.quote, 65522, 65526, '!', '!', 65518, 65521, 65523, 65518, '#', 65519, '!', 65525, 65519, 65525, 65521, 65521, 65525, 65527, 65527, 65525, 65518, 65519, 65518, 65519, '!', InputCardNumberView.DIVIDER, 65519, 65526, Typography.quote, 65521, 31, 65523, 65524, Typography.quote, Typography.dollar}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(true, super.getResources().getString(R.string.card_list_error_desc).substring(9, 10).codePointAt(0) + 206, TextUtils.getTrimmedLength("") + 40, (-16777152) - Color.rgb(0, 0, 0), new char[]{65524, 65522, 65523, 30, 65524, 65518, InputCardNumberView.DIVIDER, 65523, 31, 65523, Typography.quote, Typography.quote, 65524, 65525, Typography.quote, 65523, 65519, 29, 30, 65518, InputCardNumberView.DIVIDER, 65520, '!', 29, 65523, 65516, 65519, 65517, 65517, 65524, 65524, 65524, 65520, 65518, 65523, 65525, 30, '!', 65517, 65518, 65525, 65521, 65521, Typography.quote, 65522, 65525, 65521, 65523, 65521, Typography.quote, 65517, 65518, '!', 31, 65525, Typography.quote, 30, 29, 65516, 65524, 65520, 65517, Typography.quote, 65524}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        b(true, Drawable.resolveOpacity(0, 0) + 267, (ViewConfiguration.getPressedStateDuration() >> 16) + 21, super.getResources().getString(R.string.device_limit_error_subtitle).substring(29, 30).codePointAt(0) + 28, new char[]{0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6, 65485, 19, 18}, objArr10);
                        String str4 = (String) objArr10[0];
                        try {
                            byte b3 = getAuthRequestContext[25];
                            byte b4 = b3;
                            Object[] objArr11 = new Object[1];
                            a(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            Object[] objArr12 = new Object[1];
                            a((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], objArr12);
                            int i = ((ApplicationInfo) cls4.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 187;
                            int codePointAt = super.getResources().getString(R.string.tooltip_home_send_desc).substring(0, 9).codePointAt(1) - 110;
                            try {
                                byte b5 = getAuthRequestContext[25];
                                byte b6 = b5;
                                Object[] objArr13 = new Object[1];
                                a(b5, b6, (byte) (b6 | TarHeader.LF_BLK), objArr13);
                                Class<?> cls5 = Class.forName((String) objArr13[0]);
                                a((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], new Object[1]);
                                Object[] objArr14 = new Object[1];
                                b(false, i, codePointAt, ((ApplicationInfo) cls5.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 27, new char[]{2, 65532, 0, 65535, 7, 65532}, objArr14);
                                try {
                                    Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 17 - ExpandableListView.getPackedPositionChild(0L), (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr15);
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
            }
            try {
                Object[] objArr16 = new Object[1];
                a(getAuthRequestContext[32], (byte) (-getAuthRequestContext[30]), getAuthRequestContext[31], objArr16);
                Class<?> cls6 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                a((byte) (PlaceComponentResult & 40), (byte) (-getAuthRequestContext[30]), (byte) (PlaceComponentResult & 62), objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 494, View.resolveSizeAndState(0, 0, 0) + 4, (char) (ExpandableListView.getPackedPositionChild(0L) + 1));
                        Object[] objArr19 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) (-$$a[9]), objArr19);
                        obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i2 = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {-36818261, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 18 - Color.green(0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
        } catch (Throwable th9) {
            Throwable cause9 = th9.getCause();
            if (cause9 == null) {
                throw th9;
            }
            throw cause9;
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(false, super.getResources().getString(R.string.feed_comment_sending_failed).substring(1, 2).length() + 268, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26, new char[]{65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(false, super.getResources().getString(R.string.family_organizer_account_freeze_title).substring(2, 3).codePointAt(0) + 179, TextUtils.indexOf("", "", 0, 0) + 16, super.getResources().getString(R.string.split_bill_non_payer_title).substring(15, 16).length() + 17, new char[]{'\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 34, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), Color.rgb(0, 0, 0) + 16777234, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
    }

    @JvmName(name = "getPromoCenterPresenter")
    public final PromoCenterContract.Presenter getPromoCenterPresenter() {
        PromoCenterContract.Presenter presenter = this.promoCenterPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPromoCenterPresenter")
    public final void setPromoCenterPresenter(PromoCenterContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.promoCenterPresenter = presenter;
    }

    @JvmName(name = "getPromoSpecialAdsAdapter")
    public final PromoSpecialAdsAdapter getPromoSpecialAdsAdapter() {
        PromoSpecialAdsAdapter promoSpecialAdsAdapter = this.promoSpecialAdsAdapter;
        if (promoSpecialAdsAdapter != null) {
            return promoSpecialAdsAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPromoSpecialAdsAdapter")
    public final void setPromoSpecialAdsAdapter(PromoSpecialAdsAdapter promoSpecialAdsAdapter) {
        Intrinsics.checkNotNullParameter(promoSpecialAdsAdapter, "");
        this.promoSpecialAdsAdapter = promoSpecialAdsAdapter;
    }

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readLinkPropertiesPresenter = presenter;
    }

    @JvmName(name = "getRegularPromoAdapter")
    public final RegularPromoAdapter getRegularPromoAdapter() {
        RegularPromoAdapter regularPromoAdapter = this.regularPromoAdapter;
        if (regularPromoAdapter != null) {
            return regularPromoAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRegularPromoAdapter")
    public final void setRegularPromoAdapter(RegularPromoAdapter regularPromoAdapter) {
        Intrinsics.checkNotNullParameter(regularPromoAdapter, "");
        this.regularPromoAdapter = regularPromoAdapter;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.promo));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = getAuthRequestContext[25];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (-getAuthRequestContext[5]), getAuthRequestContext[27], getAuthRequestContext[25], objArr2);
                Object[] objArr3 = new Object[1];
                b(false, ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 236, TextUtils.lastIndexOf("", '0', 0, 0) + 19, 25 - MotionEvent.axisFromString(""), new char[]{65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5, 15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(false, super.getResources().getString(R.string.error_network_by_timout).substring(58, 60).codePointAt(0) + 179, super.getResources().getString(R.string.sendmoney_recent_collapsed_title).substring(1, 2).length() + 15, 18 - View.MeasureSpec.getSize(0), new char[]{'\b', '\b', 65531, 4, '\n', 65495, 6, 6, 2, 65535, 65529, 65527, '\n', 65535, 5, 4, 65529, 11}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.rgb(0, 0, 0) + 16777251, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 911, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        if (this.getAuthRequestContext != null) {
            getAuthRequestContext();
        }
    }

    private final void getAuthRequestContext() {
        PromoCenterActivity promoCenterActivity = this;
        if (LocationUtil.BuiltInFictitiousFunctionClassFactory(promoCenterActivity) && LocationUtil.getAuthRequestContext(promoCenterActivity)) {
            BuiltInFictitiousFunctionClassFactory();
        } else {
            getPromoCenterPresenter().PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Rect p0, int p1) {
        LinearLayoutManager linearLayoutManager = this.DatabaseTableConfigUtil;
        LinearLayoutManager linearLayoutManager2 = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayoutManager = null;
        }
        if (linearLayoutManager.getChildAt(p1) != null) {
            LinearLayoutManager linearLayoutManager3 = this.DatabaseTableConfigUtil;
            if (linearLayoutManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                linearLayoutManager2 = linearLayoutManager3;
            }
            View childAt = linearLayoutManager2.getChildAt(p1);
            Intrinsics.checkNotNull(childAt);
            return childAt.getLocalVisibleRect(p0);
        }
        return false;
    }

    private final void getAuthRequestContext(String p0, HashMap<String, String> p1) {
        if (StringsKt.contains$default((CharSequence) p0, (CharSequence) DanaUrl.DEEPLINK_URL, false, 2, (Object) null)) {
            getReadLinkPropertiesPresenter().MyBillsEntityDataFactory(p0);
            return;
        }
        String BuiltInFictitiousFunctionClassFactory = UrlUtil.BuiltInFictitiousFunctionClassFactory(UrlUtil.getAuthRequestContext(p0, p1), TopupSource.PROMOTION_CENTER);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        DanaH5.startContainerFullUrl(BuiltInFictitiousFunctionClassFactory);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        return PlaceComponentResult(p0) && lookAheadTest() && NetworkUserEntityData$$ExternalSyntheticLambda0() && LocationUtil.getAuthRequestContext(this);
    }

    private static boolean PlaceComponentResult(String p0) {
        if (TextUtils.isEmpty(p0)) {
            return false;
        }
        Intrinsics.checkNotNull(p0);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String upperCase = p0.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "");
        String upperCase2 = "NEAREST_LOCATION".toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "");
        return StringsKt.contains$default((CharSequence) upperCase, (CharSequence) upperCase2, false, 2, (Object) null);
    }

    private final boolean lookAheadTest() {
        List<OptionModel> emptyList;
        CategoryModel categoryModel = this.MyBillsEntityDataFactory;
        boolean z = false;
        if (categoryModel != null) {
            if ((categoryModel != null ? categoryModel.getAuthRequestContext : null) != null) {
                CategoryModel categoryModel2 = this.MyBillsEntityDataFactory;
                if (categoryModel2 == null || (emptyList = categoryModel2.getAuthRequestContext) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                for (int i = 0; !z && i < emptyList.size(); i++) {
                    z = Intrinsics.areEqual("NEAREST_LOCATION", emptyList.get(i).getAuthRequestContext);
                }
            }
        }
        return z;
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return LocationUtil.BuiltInFictitiousFunctionClassFactory(this);
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onSuccessGetPromoList(PromoResultModel promoResultModel) {
        Intrinsics.checkNotNullParameter(promoResultModel, "");
        moveToNextValue();
        getRegularPromoAdapter().setItems(promoResultModel.KClassImpl$Data$declaredNonStaticMembers$2);
        PromoSectionModel promoSectionModel = this.GetContactSyncConfig;
        if (promoSectionModel != null) {
            PromoSectionModel.State state = PromoSectionModel.State.STATE_HIDE_LOADING;
            Intrinsics.checkNotNullParameter(state, "");
            promoSectionModel.getAuthRequestContext.onNext(state);
        }
        this.PlaceComponentResult = false;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoResultModel.PlaceComponentResult();
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onSuccessLoadMorePromo(PromoResultModel promoResultModel) {
        Intrinsics.checkNotNullParameter(promoResultModel, "");
        getRegularPromoAdapter().getAuthRequestContext(false);
        getRegularPromoAdapter().addItemsAt(getRegularPromoAdapter().getPlaceComponentResult(), promoResultModel.KClassImpl$Data$declaredNonStaticMembers$2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = promoResultModel.PlaceComponentResult();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onErrorLoadMorePromo(boolean hasMore) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = hasMore;
        getRegularPromoAdapter().getAuthRequestContext(false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onEmptyGetPromoList() {
        getRegularPromoAdapter().removeAllItems();
        getErrorConfigVersion();
        getAuthRequestContext(getString(R.string.promo_empty_title), getString(R.string.promo_empty_description));
        showErrorScreen(false);
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onErrorGetPromo() {
        getRegularPromoAdapter().removeAllItems();
        Glide.getAuthRequestContext((FragmentActivity) this).getAuthRequestContext(Integer.valueOf((int) R.drawable.ic_no_connection)).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.iv_error_promocenter));
        getErrorConfigVersion();
        TextView textView = (TextView) _$_findCachedViewById(R.id.getFeatureForcedFirstCard);
        if (textView != null) {
            textView.setText(getString(R.string.error_promo_title));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_error_description);
        if (textView2 != null) {
            textView2.setText(getString(R.string.error_promo_description));
        }
        showErrorScreen(true);
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onErrorGetPromoCategorized() {
        getRegularPromoAdapter().removeAllItems();
        scheduleImpl();
    }

    private final void scheduleImpl() {
        dismissProgress();
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0ddb_daggernewservicecardcomponent_newservicecardcomponentimpl_threadexecutorprovider);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.ll_promo_error_button);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onEmptyGetPromoCategorized() {
        getRegularPromoAdapter().removeAllItems();
        getAuthRequestContext(getString(R.string.promo_category_empty_title), getString(R.string.promo_category_empty_description));
        scheduleImpl();
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onGetPromoAdsSuccess(List<? extends PromoModel> promoModels) {
        Intrinsics.checkNotNullParameter(promoModels, "");
        if (promoModels.isEmpty()) {
            getErrorConfigVersion();
            return;
        }
        PromoSectionModel promoSectionModel = this.getErrorConfigVersion;
        if (promoSectionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel = null;
        }
        PromoSectionModel.State state = PromoSectionModel.State.STATE_SHOW;
        Intrinsics.checkNotNullParameter(state, "");
        promoSectionModel.getAuthRequestContext.onNext(state);
        getPromoSpecialAdsAdapter().setItems(promoModels);
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void onGetPromoAdsError() {
        getErrorConfigVersion();
    }

    @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
    public final void trackPromotionCenterOpen() {
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "");
        CategoryModel categoryModel = this.MyBillsEntityDataFactory;
        PromoSectionModel promoSectionModel = null;
        String authRequestContext = StringWrapperKt.getAuthRequestContext(baseContext, StringWrapperKt.MyBillsEntityDataFactory(categoryModel != null ? categoryModel.moveToNextValue : null));
        List<PromoModel> items = getRegularPromoAdapter().getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        PromoSectionModel promoSectionModel2 = this.getErrorConfigVersion;
        if (promoSectionModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            promoSectionModel = promoSectionModel2;
        }
        byte b = 0;
        boolean z = promoSectionModel.PlaceComponentResult() == PromoSectionModel.State.STATE_SHOW;
        ArrayList arrayList = new ArrayList();
        for (PromoModel promoModel : items) {
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            String str = promoModel.scheduleImpl;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(Typography.quote);
            arrayList.add(sb.toString());
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMOTION_CENTER_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.PromotionProperty.MERCHANT_SPECIAL_SHOW, z).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_LIST, TextUtils.join(",", arrayList)).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.CATEGORY_NAME, authRequestContext);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
    }

    private final void getErrorConfigVersion() {
        PromoSectionModel promoSectionModel = this.getErrorConfigVersion;
        if (promoSectionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel = null;
        }
        PromoSectionModel.State state = PromoSectionModel.State.STATE_HIDDEN;
        Intrinsics.checkNotNullParameter(state, "");
        promoSectionModel.getAuthRequestContext.onNext(state);
    }

    private final void getAuthRequestContext(String p0, String p1) {
        Glide.getAuthRequestContext((FragmentActivity) this).getAuthRequestContext(Integer.valueOf((int) R.drawable.feeds_empty)).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.iv_error_promocenter));
        TextView textView = (TextView) _$_findCachedViewById(R.id.getFeatureForcedFirstCard);
        if (textView != null) {
            textView.setText(p0);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_error_description);
        if (textView2 != null) {
            textView2.setText(p1);
        }
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return getIntent().hasExtra("categoryId");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        PromoSectionModel promoSectionModel = this.GetContactSyncConfig;
        if (promoSectionModel != null) {
            PromoSectionModel.State state = PromoSectionModel.State.STATE_SHOW_LOADING;
            Intrinsics.checkNotNullParameter(state, "");
            promoSectionModel.getAuthRequestContext.onNext(state);
        }
        RegularPromoSectionAdapter regularPromoSectionAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (regularPromoSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            regularPromoSectionAdapter = null;
        }
        regularPromoSectionAdapter.notifyDataSetChanged();
    }

    public final void loadPromo() {
        PromoCategoryView promoCategoryView = (PromoCategoryView) _$_findCachedViewById(R.id.pcv_promo_center);
        if (Intrinsics.areEqual("promocenter_category_all", promoCategoryView != null ? promoCategoryView.getSelectedCategoryId() : null)) {
            getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2(false);
            return;
        }
        PromoCenterContract.Presenter promoCenterPresenter = getPromoCenterPresenter();
        PromoCategoryView promoCategoryView2 = (PromoCategoryView) _$_findCachedViewById(R.id.pcv_promo_center);
        promoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(false, promoCategoryView2 != null ? promoCategoryView2.getSelectedCategoryId() : null);
    }

    private final void GetContactSyncConfig() {
        PromoSectionModel promoSectionModel = this.getErrorConfigVersion;
        PromoSpecialAdsSectionAdapter promoSpecialAdsSectionAdapter = null;
        if (promoSectionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel = null;
        }
        PromoSectionModel.State state = PromoSectionModel.State.STATE_SHOW_LOADING;
        Intrinsics.checkNotNullParameter(state, "");
        promoSectionModel.getAuthRequestContext.onNext(state);
        PromoSpecialAdsSectionAdapter promoSpecialAdsSectionAdapter2 = this.scheduleImpl;
        if (promoSpecialAdsSectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            promoSpecialAdsSectionAdapter = promoSpecialAdsSectionAdapter2;
        }
        promoSpecialAdsSectionAdapter.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "");
        Intrinsics.checkNotNullParameter(grantResults, "");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/promocenter/views/PromoCenterActivity$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ int BuiltInFictitiousFunctionClassFactory(int i) {
            if (i < 4) {
                return 4;
            }
            return i - 4;
        }

        private Companion() {
        }
    }

    /* renamed from: $r8$lambda$5D-rCE4QhDH2LBoMzv8SliyxI-4  reason: not valid java name */
    public static /* synthetic */ void m2780$r8$lambda$5DrCE4QhDH2LBoMzv8SliyxI4(PromoCenterActivity promoCenterActivity, PromoModel promoModel, String str) {
        Intrinsics.checkNotNullParameter(promoCenterActivity, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory = new EventTrackerModel.Builder(promoCenterActivity.getBaseContext().getApplicationContext()).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_ID, promoModel.PlaceComponentResult).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_TYPE, "");
        String str2 = promoModel.scheduleImpl;
        if (str2 == null) {
            str2 = "";
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_NAME, str2).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(new Date(promoModel.BuiltInFictitiousFunctionClassFactory), "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext()));
        PromoCategoryView promoCategoryView = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
        EventTrackerModel.Builder MyBillsEntityDataFactory3 = MyBillsEntityDataFactory2.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_SPACE_CODE, promoCategoryView != null ? promoCategoryView.getSelectedCategoryId() : null);
        MyBillsEntityDataFactory3.MyBillsEntityDataFactory = TrackerKey.Event.PROMOTION_BANNER_OPEN;
        MyBillsEntityDataFactory3.PlaceComponentResult();
        boolean z = false;
        z = false;
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory3, z ? (byte) 1 : (byte) 0));
        if (promoModel.moveToNextValue <= 10 && promoModel.moveToNextValue >= 0) {
            z = true;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put(UrlTag.DETAIL_SOURCE, "regular");
        hashMap2.put("entryPoint", TopupSource.PROMOTION_CENTER);
        String bool = Boolean.toString(z);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        hashMap2.put(UrlTag.HOT_PROMO, bool);
        promoCenterActivity.getAuthRequestContext(str, hashMap);
    }

    public static /* synthetic */ void $r8$lambda$BeJQECN8ofreOIFcLmzgOjlUh_8(PromoCenterActivity promoCenterActivity, String str, boolean z, Location location) {
        Intrinsics.checkNotNullParameter(promoCenterActivity, "");
        promoCenterActivity.getPromoCenterPresenter().MyBillsEntityDataFactory(str, z, location);
        promoCenterActivity.dispose();
    }

    public static /* synthetic */ void $r8$lambda$ECEYDvS4oEGbzmFJtp9jGBaJIuk(PromoCenterActivity promoCenterActivity, Location location) {
        Intrinsics.checkNotNullParameter(promoCenterActivity, "");
        promoCenterActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2(location);
        Disposable disposable = promoCenterActivity.lookAheadTest;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public static /* synthetic */ void $r8$lambda$GWeBkAf9v4Of5isUERIzSn_NsYk(PromoCenterActivity promoCenterActivity, View view) {
        Intrinsics.checkNotNullParameter(promoCenterActivity, "");
        promoCenterActivity.moveToNextValue();
        if (!promoCenterActivity.BuiltInFictitiousFunctionClassFactory) {
            promoCenterActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
        } else {
            promoCenterActivity.GetContactSyncConfig();
            promoCenterActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        PromoCategoryView promoCategoryView = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
        if (promoCategoryView != null && promoCategoryView.isHidden()) {
            PromoCategoryView promoCategoryView2 = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if (promoCategoryView2 != null) {
                promoCategoryView2.show();
            }
            PromoCategoryView promoCategoryView3 = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if (promoCategoryView3 != null) {
                promoCategoryView3.retryGetCategories();
                return;
            }
            return;
        }
        promoCenterActivity.loadPromo();
    }

    public static /* synthetic */ void $r8$lambda$HcHDSVVEANbtwBkb73HYt6EZ_Ik(PromoCenterActivity promoCenterActivity, int i) {
        Intrinsics.checkNotNullParameter(promoCenterActivity, "");
        List list = promoCenterActivity.getPromoSpecialAdsAdapter().getItem(i).MyBillsEntityDataFactory;
        if (list == null) {
            list = new ArrayList();
        }
        String str = ((PromoActionModel) list.get(0)).PlaceComponentResult;
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put(UrlTag.DETAIL_SOURCE, "sponsored");
        hashMap2.put("entryPoint", TopupSource.PROMOTION_CENTER);
        Intrinsics.checkNotNullExpressionValue(str, "");
        promoCenterActivity.getAuthRequestContext(str, hashMap);
    }

    public static /* synthetic */ void $r8$lambda$Rhz2rLgbOhzkVQORie_x8zQ_14k(PromoCenterActivity promoCenterActivity, CategoryModel categoryModel, boolean z) {
        Intrinsics.checkNotNullParameter(promoCenterActivity, "");
        Intrinsics.checkNotNullParameter(categoryModel, "");
        promoCenterActivity.MyBillsEntityDataFactory = categoryModel;
        Disposable disposable = promoCenterActivity.moveToNextValue;
        if (disposable != null) {
            disposable.dispose();
        }
        PromoSectionModel promoSectionModel = null;
        promoCenterActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2((String) null, false);
        promoCenterActivity.getPromoCenterPresenter().MyBillsEntityDataFactory(null, false, null);
        promoCenterActivity.PlaceComponentResult = true;
        promoCenterActivity.moveToNextValue();
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) promoCenterActivity._$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.setDefault();
        }
        PromoCenterBottomMenuView promoCenterBottomMenuView2 = (PromoCenterBottomMenuView) promoCenterActivity._$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView2 != null) {
            promoCenterBottomMenuView2.setOnCategoryChange(categoryModel);
        }
        promoCenterActivity.BuiltInFictitiousFunctionClassFactory = z;
        if (z) {
            promoCenterActivity.getPromoSpecialAdsAdapter().removeAllItems();
            promoCenterActivity.GetContactSyncConfig();
            promoCenterActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
            promoCenterActivity.loadPromo();
            promoCenterActivity.getAuthRequestContext();
            return;
        }
        PromoSectionModel promoSectionModel2 = promoCenterActivity.getErrorConfigVersion;
        if (promoSectionModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            promoSectionModel = promoSectionModel2;
        }
        PromoSectionModel.State state = PromoSectionModel.State.STATE_HIDDEN;
        Intrinsics.checkNotNullParameter(state, "");
        promoSectionModel.getAuthRequestContext.onNext(state);
        promoCenterActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2(false, categoryModel.MyBillsEntityDataFactory);
    }

    public static /* synthetic */ void $r8$lambda$VFOsfLCcCPmqjx67ZcZJeMXq6Rc(PromoCenterActivity promoCenterActivity, View view) {
        Intrinsics.checkNotNullParameter(promoCenterActivity, "");
        promoCenterActivity.finish();
    }

    public static final /* synthetic */ void access$doOnLoadFirstPage(PromoCenterActivity promoCenterActivity) {
        promoCenterActivity.PlaceComponentResult = true;
        promoCenterActivity.moveToNextValue();
    }

    public static final /* synthetic */ void access$fetchPromoWithFilter(final PromoCenterActivity promoCenterActivity, final String str, final boolean z) {
        if (promoCenterActivity.BuiltInFictitiousFunctionClassFactory(str)) {
            promoCenterActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
            Disposable disposable = promoCenterActivity.moveToNextValue;
            if (disposable != null) {
                disposable.dispose();
            }
            Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) promoCenterActivity.getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.promocenter.views.PromoCenterActivity$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PromoCenterActivity.$r8$lambda$BeJQECN8ofreOIFcLmzgOjlUh_8(PromoCenterActivity.this, str, z, (Location) obj);
                }
            });
            promoCenterActivity.moveToNextValue = subscribe;
            promoCenterActivity.addDisposable(subscribe);
            return;
        }
        promoCenterActivity.getPromoCenterPresenter().MyBillsEntityDataFactory(str, z, null);
    }

    public static final /* synthetic */ void access$loadMoreLogic(PromoCenterActivity promoCenterActivity) {
        promoCenterActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        promoCenterActivity.getRegularPromoAdapter().getAuthRequestContext(true);
        PromoCategoryView promoCategoryView = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
        if (Intrinsics.areEqual("promocenter_category_all", promoCategoryView != null ? promoCategoryView.getSelectedCategoryId() : null)) {
            promoCenterActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2(true);
            return;
        }
        PromoCenterContract.Presenter promoCenterPresenter = promoCenterActivity.getPromoCenterPresenter();
        PromoCategoryView promoCategoryView2 = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
        promoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(true, promoCategoryView2 != null ? promoCategoryView2.getSelectedCategoryId() : null);
    }

    public static final /* synthetic */ void access$setCategoryFromExtra(PromoCenterActivity promoCenterActivity) {
        PromoCenterBottomMenuView promoCenterBottomMenuView;
        if (promoCenterActivity.KClassImpl$Data$declaredNonStaticMembers$2()) {
            PromoCategoryView promoCategoryView = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if (promoCategoryView != null) {
                promoCategoryView.setCategory(promoCenterActivity.getIntent().getStringExtra("categoryId"));
            }
            PromoCategoryView promoCategoryView2 = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if ((promoCategoryView2 != null ? promoCategoryView2.getCategoryFromExtra() : null) == null || (promoCenterBottomMenuView = (PromoCenterBottomMenuView) promoCenterActivity._$_findCachedViewById(R.id.pcb_view)) == null) {
                return;
            }
            PromoCategoryView promoCategoryView3 = (PromoCategoryView) promoCenterActivity._$_findCachedViewById(R.id.pcv_promo_center);
            promoCenterBottomMenuView.setOnCategoryChange(promoCategoryView3 != null ? promoCategoryView3.getCategoryFromExtra() : null);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Disposable disposable = this.lookAheadTest;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.promocenter.views.PromoCenterActivity$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromoCenterActivity.$r8$lambda$ECEYDvS4oEGbzmFJtp9jGBaJIuk(PromoCenterActivity.this, (Location) obj);
            }
        });
        this.lookAheadTest = subscribe;
        addDisposable(subscribe);
    }

    private final void moveToNextValue() {
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.showMenu();
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0ddb_daggernewservicecardcomponent_newservicecardcomponentimpl_threadexecutorprovider);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.ll_promo_error_button);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        byte b = 0;
        if (this.getAuthRequestContext == null) {
            DaggerPromoCenterComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerPromoCenterComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (PromoCenterModule) Preconditions.getAuthRequestContext(new PromoCenterModule(this));
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.promocenter.views.PromoCenterActivity$initInject$1
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
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            PromoCenterActivity promoCenterActivity = this;
            KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = promoCenterActivity;
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = TrackerKey.SourceType.PROMOTION;
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = promoCenterActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = promoCenterActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = promoCenterActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = promoCenterActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            this.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }
        PromoCenterComponent promoCenterComponent = this.getAuthRequestContext;
        Intrinsics.checkNotNull(promoCenterComponent);
        promoCenterComponent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getReadLinkPropertiesPresenter(), getPromoCenterPresenter());
        setRegularPromoAdapter(new RegularPromoAdapter());
        getRegularPromoAdapter().KClassImpl$Data$declaredNonStaticMembers$2 = new PromoView.Listener() { // from class: id.dana.promocenter.views.PromoCenterActivity$$ExternalSyntheticLambda5
            @Override // id.dana.promocenter.views.PromoView.Listener
            public final void getAuthRequestContext(PromoModel promoModel, String str) {
                PromoCenterActivity.m2780$r8$lambda$5DrCE4QhDH2LBoMzv8SliyxI4(PromoCenterActivity.this, promoModel, str);
            }
        };
        PromoCenterActivity promoCenterActivity2 = this;
        this.DatabaseTableConfigUtil = new LinearLayoutManager(promoCenterActivity2, 1, false);
        RegularPromoAdapter regularPromoAdapter = getRegularPromoAdapter();
        LinearLayoutManager linearLayoutManager = this.DatabaseTableConfigUtil;
        RegularPromoSectionAdapter regularPromoSectionAdapter = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayoutManager = null;
        }
        PromoSectionModel promoSectionModel = new PromoSectionModel(regularPromoAdapter, linearLayoutManager);
        this.GetContactSyncConfig = promoSectionModel;
        Intrinsics.checkNotNull(promoSectionModel);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new RegularPromoSectionAdapter(promoSectionModel);
        setPromoSpecialAdsAdapter(new PromoSpecialAdsAdapter(promoCenterActivity2));
        getPromoSpecialAdsAdapter().setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.promocenter.views.PromoCenterActivity$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                PromoCenterActivity.$r8$lambda$HcHDSVVEANbtwBkb73HYt6EZ_Ik(PromoCenterActivity.this, i);
            }
        });
        PromoSectionModel promoSectionModel2 = new PromoSectionModel(getPromoSpecialAdsAdapter(), new LinearLayoutManager(promoCenterActivity2, 0, false));
        this.getErrorConfigVersion = promoSectionModel2;
        if (promoSectionModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel2 = null;
        }
        this.scheduleImpl = new PromoSpecialAdsSectionAdapter(promoSectionModel2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(promoCenterActivity2, 1, false);
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        PromoSpecialAdsSectionAdapter promoSpecialAdsSectionAdapter = this.scheduleImpl;
        if (promoSpecialAdsSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSpecialAdsSectionAdapter = null;
        }
        adapterArr[0] = promoSpecialAdsSectionAdapter;
        RegularPromoSectionAdapter regularPromoSectionAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (regularPromoSectionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            regularPromoSectionAdapter = regularPromoSectionAdapter2;
        }
        adapterArr[1] = regularPromoSectionAdapter;
        ConcatAdapter concatAdapter = new ConcatAdapter(adapterArr);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_regular_promo);
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rv_regular_promo);
        Intrinsics.checkNotNull(recyclerView2);
        recyclerView2.setAdapter(concatAdapter);
        PromoCategoryView promoCategoryView = (PromoCategoryView) _$_findCachedViewById(R.id.pcv_promo_center);
        if (promoCategoryView != null) {
            promoCategoryView.setListener(new CategoryView.OnClickListener() { // from class: id.dana.promocenter.views.PromoCenterActivity$$ExternalSyntheticLambda6
                @Override // id.dana.richview.category.CategoryView.OnClickListener
                public final void PlaceComponentResult(CategoryModel categoryModel, boolean z) {
                    PromoCenterActivity.$r8$lambda$Rhz2rLgbOhzkVQORie_x8zQ_14k(PromoCenterActivity.this, categoryModel, z);
                }
            });
        }
        PromoCategoryView promoCategoryView2 = (PromoCategoryView) _$_findCachedViewById(R.id.pcv_promo_center);
        if (promoCategoryView2 != null) {
            promoCategoryView2.setOnGetCategoriesListener(new PromoCategoryView.SetOnGetCategoriesListener() { // from class: id.dana.promocenter.views.PromoCenterActivity$initPromoCategoryView$2
                @Override // id.dana.richview.promocenter.PromoCategoryView.SetOnGetCategoriesListener
                public final void PlaceComponentResult(CategoryModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PromoCenterActivity.this.MyBillsEntityDataFactory = p0;
                    PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) PromoCenterActivity.this._$_findCachedViewById(R.id.pcb_view);
                    if (promoCenterBottomMenuView != null) {
                        promoCenterBottomMenuView.setOnCategoryChange(p0);
                    }
                    PromoCenterBottomMenuView promoCenterBottomMenuView2 = (PromoCenterBottomMenuView) PromoCenterActivity.this._$_findCachedViewById(R.id.pcb_view);
                    if (promoCenterBottomMenuView2 != null) {
                        promoCenterBottomMenuView2.setDefault();
                    }
                    PromoCenterActivity.access$setCategoryFromExtra(PromoCenterActivity.this);
                    PromoCenterActivity.this.loadPromo();
                }

                @Override // id.dana.richview.promocenter.PromoCategoryView.SetOnGetCategoriesListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    PromoCenterActivity.this.showErrorScreen(true);
                }
            });
        }
        final Rect rect = new Rect();
        ((RecyclerView) _$_findCachedViewById(R.id.rv_regular_promo)).getHitRect(rect);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_regular_promo)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.promocenter.views.PromoCenterActivity$getOnPromoCenterScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                boolean KClassImpl$Data$declaredNonStaticMembers$24;
                boolean z;
                boolean z2;
                boolean z3;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                PromoCenterActivity.Companion companion = PromoCenterActivity.INSTANCE;
                KClassImpl$Data$declaredNonStaticMembers$24 = PromoCenterActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(rect, PromoCenterActivity.Companion.BuiltInFictitiousFunctionClassFactory(PromoCenterActivity.this.getRegularPromoAdapter().getPlaceComponentResult()));
                if (KClassImpl$Data$declaredNonStaticMembers$24) {
                    z = PromoCenterActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (z) {
                        z2 = PromoCenterActivity.this.PlaceComponentResult;
                        if (z2) {
                            return;
                        }
                        z3 = PromoCenterActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (z3) {
                            return;
                        }
                        PromoCenterActivity.access$loadMoreLogic(PromoCenterActivity.this);
                    }
                }
            }
        });
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.setOnSubmitSortClicked(new Function2<String, Boolean, Unit>() { // from class: id.dana.promocenter.views.PromoCenterActivity$initBottomMenu$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(String str, Boolean bool) {
                    invoke2(str, bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str, Boolean bool) {
                    PromoCenterActivity.access$doOnLoadFirstPage(PromoCenterActivity.this);
                    PromoCenterContract.Presenter promoCenterPresenter = PromoCenterActivity.this.getPromoCenterPresenter();
                    if (TextUtils.isEmpty(str)) {
                        str = null;
                    }
                    Intrinsics.checkNotNull(bool);
                    promoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str, bool.booleanValue());
                }
            });
        }
        PromoCenterBottomMenuView promoCenterBottomMenuView2 = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView2 != null) {
            promoCenterBottomMenuView2.setOnSubmitFilterClicked(new Function2<String, Boolean, Unit>() { // from class: id.dana.promocenter.views.PromoCenterActivity$initBottomMenu$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                    invoke(str, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(String str, boolean z) {
                    PromoCenterActivity.access$doOnLoadFirstPage(PromoCenterActivity.this);
                    PromoCenterActivity promoCenterActivity3 = PromoCenterActivity.this;
                    if (TextUtils.isEmpty(str)) {
                        str = null;
                    }
                    PromoCenterActivity.access$fetchPromoWithFilter(promoCenterActivity3, str, z);
                }
            });
        }
        Button button = (Button) _$_findCachedViewById(R.id.res_0x7f0a023f_apistatus_availablesince);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.PromoCenterActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromoCenterActivity.$r8$lambda$GWeBkAf9v4Of5isUERIzSn_NsYk(PromoCenterActivity.this, view);
                }
            });
        }
        Button button2 = (Button) _$_findCachedViewById(R.id.btn_home);
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.PromoCenterActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromoCenterActivity.$r8$lambda$VFOsfLCcCPmqjx67ZcZJeMXq6Rc(PromoCenterActivity.this, view);
                }
            });
        }
    }

    public final void showErrorScreen(boolean tryEnable) {
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.hideMenu();
        }
        Button button = (Button) _$_findCachedViewById(R.id.res_0x7f0a023f_apistatus_availablesince);
        if (button != null) {
            button.setVisibility(tryEnable ? 0 : 8);
        }
        dismissProgress();
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0ddb_daggernewservicecardcomponent_newservicecardcomponentimpl_threadexecutorprovider);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.ll_promo_error_button);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
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
            cArr2[i4] = (char) (cArr2[i4] - ((int) (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ (-5694784870793460699L))));
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
