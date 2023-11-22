package id.dana.promodiscovery.views;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.common.model.OptionModel;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promocenter.promo.PromoCenterContract;
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
import id.dana.di.component.DaggerPromoCenterComponent;
import id.dana.di.component.PromoCenterComponent;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.PromoCenterModule;
import id.dana.extension.view.ViewExtKt;
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
import id.dana.promocenter.views.PromoCenterBottomMenuView;
import id.dana.promocenter.views.PromoView;
import id.dana.promodiscovery.views.PromoDiscoveryListActivity;
import id.dana.richview.category.CategoryView;
import id.dana.richview.category.model.CategoryModel;
import id.dana.richview.promocenter.PromoCategoryView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.SizeUtil;
import id.dana.utils.StringWrapperKt;
import id.dana.utils.UrlUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\bY\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0016J\u001f\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\t\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004J+\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001aH\u0002¢\u0006\u0004\b\u0003\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010\u0004J\r\u0010 \u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0004\b!\u0010\u0004R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010#R\u0018\u0010\u001c\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010%R\u0013\u0010\t\u001a\u00020&X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u0016\u0010\u0003\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010(R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010(R\u0016\u0010\u0012\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010(R\u0018\u0010\u0013\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u001f\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\"\u00101\u001a\u0002008\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00108\u001a\u0002078\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010)\u001a\u00020>8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010!\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bB\u0010CR\"\u0010E\u001a\u00020D8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010L\u001a\u00020K8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010-\u001a\u00020R8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010*\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bU\u0010@R\u0016\u0010+\u001a\u00020V8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bW\u0010X"}, d2 = {"Lid/dana/promodiscovery/views/PromoDiscoveryListActivity;", "Lid/dana/base/BaseActivity;", "", "getAuthRequestContext", "()V", "", "p0", "", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Z)V", "", "getLayout", "()I", "BuiltInFictitiousFunctionClassFactory", "()Z", "PlaceComponentResult", "lookAheadTest", "moveToNextValue", "getErrorConfigVersion", IAPSyncCommand.COMMAND_INIT, "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Ljava/lang/String;)Z", "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;I)Z", "loadPromo", "Ljava/util/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "onPause", "onResume", "scheduleImpl", "showErrorScreen", "initRecordTimeStamp", "Lid/dana/richview/category/model/CategoryModel;", "Lid/dana/richview/category/model/CategoryModel;", "Lid/dana/di/component/PromoCenterComponent;", "Lid/dana/di/component/PromoCenterComponent;", "Lid/dana/core/ui/util/connectivity/ConnectivityMonitor;", "Lkotlin/Lazy;", "Z", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "Lio/reactivex/disposables/Disposable;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lio/reactivex/disposables/Disposable;", "PrepareContext", "Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;", "promoCenterPresenter", "Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;", "getPromoCenterPresenter", "()Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;", "setPromoCenterPresenter", "(Lid/dana/contract/promocenter/promo/PromoCenterContract$Presenter;)V", "Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "promoSpecialAdsAdapter", "Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "getPromoSpecialAdsAdapter", "()Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;", "setPromoSpecialAdsAdapter", "(Lid/dana/promocenter/adapter/PromoSpecialAdsAdapter;)V", "Lid/dana/promocenter/model/PromoSectionModel;", "isLayoutRequested", "Lid/dana/promocenter/model/PromoSectionModel;", "Lid/dana/promocenter/adapter/PromoSpecialAdsSectionAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/promocenter/adapter/PromoSpecialAdsSectionAdapter;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/promocenter/adapter/RegularPromoAdapter;", "regularPromoAdapter", "Lid/dana/promocenter/adapter/RegularPromoAdapter;", "getRegularPromoAdapter", "()Lid/dana/promocenter/adapter/RegularPromoAdapter;", "setRegularPromoAdapter", "(Lid/dana/promocenter/adapter/RegularPromoAdapter;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "newProxyInstance", "Landroidx/recyclerview/widget/LinearLayoutManager;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/promocenter/adapter/RegularPromoSectionAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/promocenter/adapter/RegularPromoSectionAdapter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoDiscoveryListActivity extends BaseActivity {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private CategoryModel PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Disposable getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private RegularPromoSectionAdapter DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private PromoSpecialAdsSectionAdapter initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private PromoSectionModel NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private Disposable scheduleImpl;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private PromoCenterComponent KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private PromoSectionModel GetContactSyncConfig;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private LinearLayoutManager NetworkUserEntityData$$ExternalSyntheticLambda1;
    @Inject
    public PromoCenterContract.Presenter promoCenterPresenter;
    public PromoSpecialAdsAdapter promoSpecialAdsAdapter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    public RegularPromoAdapter regularPromoAdapter;
    public static final byte[] $$a = {22, 66, -65, -82, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 22;
    public static final byte[] getAuthRequestContext = {2, -87, 98, TarHeader.LF_FIFO, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 78;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda5 = -8206078317151126569L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean getAuthRequestContext = true;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = true;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ConnectivityMonitor>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$connectivityMonitor$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ConnectivityMonitor invoke() {
            return new ConnectivityMonitor(PromoDiscoveryListActivity.this);
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 15
            int r8 = r8 + 4
            byte[] r0 = id.dana.promodiscovery.views.PromoDiscoveryListActivity.getAuthRequestContext
            int r9 = 106 - r9
            int r7 = r7 * 4
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r5 = 0
            r9 = r8
            r8 = r7
            goto L2c
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2c:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + 2
            int r9 = r9 + 1
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promodiscovery.views.PromoDiscoveryListActivity.b(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.promodiscovery.views.PromoDiscoveryListActivity.$$a
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r9 = r9 * 3
            int r9 = r9 + 21
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            int r8 = r8 + 1
            if (r5 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promodiscovery.views.PromoDiscoveryListActivity.c(short, byte, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void openActivity(Context context, String str, String str2, String str3) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, str, str2, str3);
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
        a((ViewConfiguration.getLongPressTimeout() >> 16) + 37489, new char[]{10997, 47243, 3602, 40373, 25407, 63176, 17494, 11181, 47475, 3870, 37584, 24607, 63402, 17734, 10457, 48750, 3575, 37734}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(44159 - ExpandableListView.getPackedPositionGroup(0L), new char[]{11001, 34450, 29247, 12160, 39692}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ViewConfiguration.getScrollDefaultDelay() >> 16) + 17093, new char[]{10915, 26674, 44840, 58083, 8624, 26409, 47667, 63951, 15499, 29212, 45381, 62597, 3021, 20135, 35939, 49961, 1781, 17840, 39800, 56938, 7572, 20702, 38425, 54545, 26760, 44954, 58030, 8247, 26410, 47777, 63971, 16170, 29197, 45511, 62604, 2626, 18758, 36052, 50066, 1703, 17515, 39807, 57074, 7605, 21290, 38406, 54724, 26842}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(47526 - TextUtils.lastIndexOf("", '0'), new char[]{10997, 37638, 23020, 1541, 52334, 35566, 29518, 14653, 59336, 44072, 27179, 53388, 39204, 18398, 3463, 51817, 45270, 32433, 10060, 60864, 44028, 4118, 57080, 33958, 19722, 3001, 61531, 48748, 25832, 11547, 60212, 20895, 7703, 50295, 33422, 19321, 12683, 65492, 42094, 25302, 10425, 37147, 24471, 1448, 49731, 35064, 30375, 16138, 58871, 41552, 26685, 55016, 40769, 17712, 926, 51268, 46636, 31882, 9505, 58251, 43393, 5735, 56450, 39614}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(37811 - TextUtils.getOffsetBefore("", 0), new char[]{10918, 47382, 3479, 37359, 25697, 51420, 23700, 9029, 46900, 7143, 61010, 29204, 50881, 43696, 14702, 36318, 4549, 58386, 18486, 56505, 41818, 14169, 39831, 28594, 62059, 18057, 10883, 47437, 3430, 37301, 25689, 51290, 23747, 8419, 46944, 7125, 61402, 29308, 50736, 43753, 14676, 36185, 4603, 58801, 18536, 56531, 41183, 14123, 39778, 28654, 61953, 18008, 11002, 48810, 3376, 37332, 25995, 51322, 23587, 8419, 46854, 6918, 61435, 29600}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 15881, new char[]{11004, 5353, 22258, 37119, 53955, 7299, 24205, 39044, 55992, 1188, 18080, 32918, 49878, 3221, 20098, 34913, 51809, 13420, 30274, 45148, 62017, 15450, 32294, 47221, 64043, 9216, 26143, 40981, 57868, 11746, 28651, 43510, 60373, 54735, 6083, 20865, 37811, 56758, 8111, 23012, 39837, 50581, 1927, 16696, 33649, 52591, 3949, 18774, 35671, 62809, 14201, 28969, 45938, 64870, 16151, 30989, 47881, 64251, 9450, 26356}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(9810 - ExpandableListView.getPackedPositionChild(0L), new char[]{10925, 3305, 26118, 22595, 46058, 38202}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 911, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (getAuthRequestContext[5] - 1);
                byte b2 = getAuthRequestContext[5];
                Object[] objArr13 = new Object[1];
                b(b, b2, (byte) (b2 - 1), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr14 = new Object[1];
                b(b3, b3, getAuthRequestContext[5], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 56, 3 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[47], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 800, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 800, 15 - View.combineMeasuredStates(0, 0), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - ExpandableListView.getPackedPositionChild(0L), 29 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), Color.green(0) + 15, (char) View.resolveSizeAndState(0, 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 'S' - AndroidCharacter.getMirror('0'), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {2112019836, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), Color.argb(0, 0, 0, 0) + 18, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (getAuthRequestContext[5] - 1);
                byte b5 = getAuthRequestContext[5];
                Object[] objArr19 = new Object[1];
                b(b4, b5, (byte) (b5 - 1), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr20 = new Object[1];
                b(b6, b6, getAuthRequestContext[5], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 61, 45 - TextUtils.lastIndexOf("", '0', 0), (char) (Process.getGidForName("") + 1));
                        Object[] objArr22 = new Object[1];
                        c($$a[9], (byte) $$b, (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {2112019836, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (getAuthRequestContext[5] - 1);
                byte b8 = getAuthRequestContext[5];
                Object[] objArr25 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b9 = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr26 = new Object[1];
                b(b9, b9, getAuthRequestContext[5], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), Gravity.getAbsoluteGravity(0, 0) + 3, (char) (38968 - (ViewConfiguration.getPressedStateDuration() >> 16)));
                        Object[] objArr28 = new Object[1];
                        c($$a[9], (byte) $$b, (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {2112019836, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 18 - KeyEvent.getDeadChar(0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (getAuthRequestContext[5] - 1);
                byte b11 = getAuthRequestContext[5];
                Object[] objArr31 = new Object[1];
                b(b10, b11, (byte) (b11 - 1), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b12 = (byte) (getAuthRequestContext[5] - 1);
                Object[] objArr32 = new Object[1];
                b(b12, b12, getAuthRequestContext[5], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 107, 2 - ImageFormat.getBitsPerPixel(0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), (byte) (-$$a[40]), $$a[8], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {2112019836, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_promo_discovery_list;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(37489 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{10997, 47243, 3602, 40373, 25407, 63176, 17494, 11181, 47475, 3870, 37584, 24607, 63402, 17734, 10457, 48750, 3575, 37734}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(getPackageName().codePointAt(0) + 44054, new char[]{11001, 34450, 29247, 12160, 39692}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(super.getResources().getString(R.string.profile_completion_task_description_dana_viz).substring(1, 2).codePointAt(0) + 35632, new char[]{10997, 41323, 15826, 34901, 1215, 37672, 28566, 64077, 30333, 49917, 22862, 54657, 40985, 15530, 35598, 1922, 37874, 28252, 64210, 28974, 52628, 22553, 54416, 41206, 16237, 35801}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(getPackageName().length() + 5430, new char[]{10999, 16348, 156, 5457, 32261, 16587, 21902, 48766, 33548, 38337, 65178, 50018, 54315, 16108, 950, 5230, 31019, 17399}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), AndroidCharacter.getMirror('0') - '\r', (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17092, new char[]{10915, 26674, 44840, 58083, 8624, 26409, 47667, 63951, 15499, 29212, 45381, 62597, 3021, 20135, 35939, 49961, 1781, 17840, 39800, 56938, 7572, 20702, 38425, 54545, 26760, 44954, 58030, 8247, 26410, 47777, 63971, 16170, 29197, 45511, 62604, 2626, 18758, 36052, 50066, 1703, 17515, 39807, 57074, 7605, 21290, 38406, 54724, 26842}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.dialog_camera_permission_desc).substring(29, 30).length() + 47526, new char[]{10997, 37638, 23020, 1541, 52334, 35566, 29518, 14653, 59336, 44072, 27179, 53388, 39204, 18398, 3463, 51817, 45270, 32433, 10060, 60864, 44028, 4118, 57080, 33958, 19722, 3001, 61531, 48748, 25832, 11547, 60212, 20895, 7703, 50295, 33422, 19321, 12683, 65492, 42094, 25302, 10425, 37147, 24471, 1448, 49731, 35064, 30375, 16138, 58871, 41552, 26685, 55016, 40769, 17712, 926, 51268, 46636, 31882, 9505, 58251, 43393, 5735, 56450, 39614}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(37811 - View.MeasureSpec.getSize(0), new char[]{10918, 47382, 3479, 37359, 25697, 51420, 23700, 9029, 46900, 7143, 61010, 29204, 50881, 43696, 14702, 36318, 4549, 58386, 18486, 56505, 41818, 14169, 39831, 28594, 62059, 18057, 10883, 47437, 3430, 37301, 25689, 51290, 23747, 8419, 46944, 7125, 61402, 29308, 50736, 43753, 14676, 36185, 4603, 58801, 18536, 56531, 41183, 14123, 39778, 28654, 61953, 18008, 11002, 48810, 3376, 37332, 25995, 51322, 23587, 8419, 46854, 6918, 61435, 29600}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(super.getResources().getString(R.string.passkey_enrollment_faq_description).substring(60, 61).codePointAt(0) + 15774, new char[]{11004, 5353, 22258, 37119, 53955, 7299, 24205, 39044, 55992, 1188, 18080, 32918, 49878, 3221, 20098, 34913, 51809, 13420, 30274, 45148, 62017, 15450, 32294, 47221, 64043, 9216, 26143, 40981, 57868, 11746, 28651, 43510, 60373, 54735, 6083, 20865, 37811, 56758, 8111, 23012, 39837, 50581, 1927, 16696, 33649, 52591, 3949, 18774, 35671, 62809, 14201, 28969, 45938, 64870, 16151, 30989, 47881, 64251, 9450, 26356}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(getPackageName().length() + 9804, new char[]{10925, 3305, 26118, 22595, 46058, 38202}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 18 - KeyEvent.normalizeMetaState(0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
        try {
            byte b = (byte) (getAuthRequestContext[5] - 1);
            byte b2 = getAuthRequestContext[5];
            Object[] objArr12 = new Object[1];
            b(b, b2, (byte) (b2 - 1), objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (getAuthRequestContext[5] - 1);
            Object[] objArr13 = new Object[1];
            b(b3, b3, getAuthRequestContext[5], objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), KeyEvent.normalizeMetaState(0) + 4, (char) View.resolveSize(0, 0));
                    Object[] objArr15 = new Object[1];
                    c((byte) ($$a[78] - 1), (byte) (-$$a[40]), $$a[8], objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1066213523, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), Gravity.getAbsoluteGravity(0, 0) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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
                super.onCreate(bundle);
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

    private final boolean moveToNextValue() {
        return getIntent().hasExtra("toolbar_title") && getIntent().getStringExtra("toolbar_title") != null;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(View.MeasureSpec.getSize(0) + 35729, new char[]{10997, 41323, 15826, 34901, 1215, 37672, 28566, 64077, 30333, 49917, 22862, 54657, 40985, 15530, 35598, 1922, 37874, 28252, 64210, 28974, 52628, 22553, 54416, 41206, 16237, 35801}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(5437 - (ViewConfiguration.getTouchSlop() >> 8), new char[]{10999, 16348, 156, 5457, 32261, 16587, 21902, 48766, 33548, 38337, 65178, 50018, 54315, 16108, 950, 5230, 31019, 17399}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            if (PlaceComponentResult() && LocationUtil.getAuthRequestContext(this)) {
                getAuthRequestContext();
            } else {
                getPromoCenterPresenter().PlaceComponentResult();
            }
        }
        ((ConnectivityMonitor) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult(this, new Observer() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda3
            @Override // androidx.view.Observer
            public final void onChanged(Object obj3) {
                PromoDiscoveryListActivity.$r8$lambda$x2smgQo0EXcD6SNNURZkrR2fXZo(PromoDiscoveryListActivity.this, (ConnectivityModel) obj3);
            }
        });
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.daily_check_error_text).substring(23, 25).length() + 35727, new char[]{10997, 41323, 15826, 34901, 1215, 37672, 28566, 64077, 30333, 49917, 22862, 54657, 40985, 15530, 35598, 1922, 37874, 28252, 64210, 28974, 52628, 22553, 54416, 41206, 16237, 35801}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.dynamic_qr_title).substring(0, 21).codePointAt(18) + 5357, new char[]{10999, 16348, 156, 5457, 32261, 16587, 21902, 48766, 33548, 38337, 65178, 50018, 54315, 16108, 950, 5230, 31019, 17399}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ExpandableListView.getPackedPositionChild(0L), View.resolveSizeAndState(0, 0, 0) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, KeyEvent.getDeadChar(0, 0) + 18, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        ((ConnectivityMonitor) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult((LifecycleOwner) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean MyBillsEntityDataFactory(Rect p0, int p1) {
        LinearLayoutManager linearLayoutManager = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        LinearLayoutManager linearLayoutManager2 = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayoutManager = null;
        }
        if (linearLayoutManager.getChildAt(p1) != null) {
            LinearLayoutManager linearLayoutManager3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
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

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return PlaceComponentResult(p0) && NetworkUserEntityData$$ExternalSyntheticLambda0() && PlaceComponentResult() && LocationUtil.getAuthRequestContext(this);
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

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        List<OptionModel> emptyList;
        CategoryModel categoryModel = this.PlaceComponentResult;
        boolean z = false;
        if (categoryModel != null) {
            if ((categoryModel != null ? categoryModel.getAuthRequestContext : null) != null) {
                CategoryModel categoryModel2 = this.PlaceComponentResult;
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

    private final boolean PlaceComponentResult() {
        return LocationUtil.BuiltInFictitiousFunctionClassFactory(this);
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        return getIntent().hasExtra("categoryId") && getIntent().getStringExtra("categoryId") != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleImpl() {
        if (lookAheadTest()) {
            String stringExtra = getIntent().getStringExtra("sort_option");
            if (stringExtra == null) {
                stringExtra = "";
            }
            if (StringsKt.equals(stringExtra, "NEAR_EXPIRED", true)) {
                getRegularPromoAdapter().BuiltInFictitiousFunctionClassFactory = true;
                getRegularPromoAdapter().getAuthRequestContext = true;
            }
            MyBillsEntityDataFactory(stringExtra, true);
            PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
            if (promoCenterBottomMenuView != null) {
                promoCenterBottomMenuView.setSelectedSort(stringExtra);
            }
        }
    }

    private final boolean lookAheadTest() {
        return getIntent().hasExtra("sort_option") && getIntent().getStringExtra("sort_option") != null;
    }

    private final void initRecordTimeStamp() {
        PromoSectionModel promoSectionModel = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (promoSectionModel != null) {
            PromoSectionModel.State state = PromoSectionModel.State.STATE_SHOW_LOADING;
            Intrinsics.checkNotNullParameter(state, "");
            promoSectionModel.getAuthRequestContext.onNext(state);
        }
        RegularPromoSectionAdapter regularPromoSectionAdapter = this.DatabaseTableConfigUtil;
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lid/dana/promodiscovery/views/PromoDiscoveryListActivity$Companion;", "", "()V", "NUMBER_OF_LAST_ITEM_TO_BE_SEEN", "", "SORT_OPTION", "", "TOOLBAR_TITLE", "detailSourceRegular", "detailSourceSponsored", "computeThresholdNumber", "totalItemCount", "openActivity", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "title", "category", "sortOption", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ int PlaceComponentResult(int i) {
            if (i < 4) {
                return 4;
            }
            return i - 4;
        }

        private Companion() {
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3, int i) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(context, str, str2, str3);
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intent intent = new Intent(context, PromoDiscoveryListActivity.class);
            intent.putExtra("toolbar_title", str);
            intent.putExtra("categoryId", str2);
            intent.putExtra("sort_option", str3);
            context.startActivity(intent);
        }
    }

    public static /* synthetic */ void $r8$lambda$5jHQCJ3FmlG9SzOPFg_6ISASv5Q(PromoDiscoveryListActivity promoDiscoveryListActivity, Location location) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        promoDiscoveryListActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2(location);
        Disposable disposable = promoDiscoveryListActivity.scheduleImpl;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public static /* synthetic */ void $r8$lambda$8tSohep5SvChPqdRa7Cu3zQ7FGg(PromoDiscoveryListActivity promoDiscoveryListActivity, String str, boolean z, Location location) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        promoDiscoveryListActivity.getPromoCenterPresenter().MyBillsEntityDataFactory(str, z, location);
        promoDiscoveryListActivity.dispose();
    }

    /* renamed from: $r8$lambda$Btwlc93ZRIDzC7FGSM-9PjPdvbQ  reason: not valid java name */
    public static /* synthetic */ void m2785$r8$lambda$Btwlc93ZRIDzC7FGSM9PjPdvbQ(PromoDiscoveryListActivity promoDiscoveryListActivity, int i) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        List list = promoDiscoveryListActivity.getPromoSpecialAdsAdapter().getItem(i).MyBillsEntityDataFactory;
        if (list == null) {
            list = new ArrayList();
        }
        String str = ((PromoActionModel) list.get(0)).PlaceComponentResult;
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put(UrlTag.DETAIL_SOURCE, "sponsored");
        hashMap2.put("entryPoint", TopupSource.PROMOTION_CENTER);
        Intrinsics.checkNotNullExpressionValue(str, "");
        promoDiscoveryListActivity.getAuthRequestContext(str, hashMap);
    }

    public static /* synthetic */ void $r8$lambda$IUCYVVZtnI9Ke0UsyOEmeh8eehM(PromoDiscoveryListActivity promoDiscoveryListActivity, View view) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        promoDiscoveryListActivity.finish();
    }

    /* renamed from: $r8$lambda$WV7gUvqq-ZUnvXaTnqmQzLxCWv4  reason: not valid java name */
    public static /* synthetic */ void m2786$r8$lambda$WV7gUvqqZUnvXaTnqmQzLxCWv4(PromoDiscoveryListActivity promoDiscoveryListActivity, PromoModel promoModel, String str) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        Intrinsics.checkNotNullParameter(promoModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        EventTrackerModel.Builder MyBillsEntityDataFactory = new EventTrackerModel.Builder(promoDiscoveryListActivity.getBaseContext().getApplicationContext()).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_ID, promoModel.PlaceComponentResult).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_TYPE, "");
        String str2 = promoModel.scheduleImpl;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = MyBillsEntityDataFactory.MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_CONTENT_NAME, str2 != null ? str2 : "").MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_EXPIRY_DATE, DateTimeUtil.MyBillsEntityDataFactory(new Date(promoModel.BuiltInFictitiousFunctionClassFactory), "yyyy-MM-dd'T'HH:mm:ss", LocaleUtil.getAuthRequestContext()));
        PromoCategoryView promoCategoryView = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
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
        hashMap2.put(UrlTag.HOT_PROMO, String.valueOf(z));
        promoDiscoveryListActivity.getAuthRequestContext(str, hashMap);
    }

    public static /* synthetic */ void $r8$lambda$X8akmhVj9huKTFBG2C1fcr2AT7g(PromoDiscoveryListActivity promoDiscoveryListActivity, View view) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        promoDiscoveryListActivity.getErrorConfigVersion();
        promoDiscoveryListActivity.initRecordTimeStamp();
        PromoCategoryView promoCategoryView = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
        if ((promoCategoryView != null && promoCategoryView.isHidden()) && !promoDiscoveryListActivity.BuiltInFictitiousFunctionClassFactory()) {
            PromoCategoryView promoCategoryView2 = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if (promoCategoryView2 != null) {
                promoCategoryView2.show();
            }
            PromoCategoryView promoCategoryView3 = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if (promoCategoryView3 != null) {
                promoCategoryView3.retryGetCategories();
            }
        }
        promoDiscoveryListActivity.loadPromo();
    }

    /* renamed from: $r8$lambda$XpSc_5dQWwwNrQN4o7dt-Ifzfhc  reason: not valid java name */
    public static /* synthetic */ void m2787$r8$lambda$XpSc_5dQWwwNrQN4o7dtIfzfhc(PromoDiscoveryListActivity promoDiscoveryListActivity, CategoryModel categoryModel, boolean z) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        Intrinsics.checkNotNullParameter(categoryModel, "");
        promoDiscoveryListActivity.PlaceComponentResult = categoryModel;
        Disposable disposable = promoDiscoveryListActivity.getErrorConfigVersion;
        if (disposable != null) {
            disposable.dispose();
        }
        PromoSectionModel promoSectionModel = null;
        PromoSpecialAdsSectionAdapter promoSpecialAdsSectionAdapter = null;
        promoDiscoveryListActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2((String) null, false);
        promoDiscoveryListActivity.getPromoCenterPresenter().MyBillsEntityDataFactory(null, false, null);
        promoDiscoveryListActivity.getAuthRequestContext = true;
        promoDiscoveryListActivity.getErrorConfigVersion();
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.setDefault();
        }
        PromoCenterBottomMenuView promoCenterBottomMenuView2 = (PromoCenterBottomMenuView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView2 != null) {
            promoCenterBottomMenuView2.setOnCategoryChange(categoryModel);
        }
        promoDiscoveryListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
        promoDiscoveryListActivity.scheduleImpl();
        if (z) {
            promoDiscoveryListActivity.getPromoSpecialAdsAdapter().removeAllItems();
            PromoSectionModel promoSectionModel2 = promoDiscoveryListActivity.GetContactSyncConfig;
            if (promoSectionModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                promoSectionModel2 = null;
            }
            PromoSectionModel.State state = PromoSectionModel.State.STATE_SHOW_LOADING;
            Intrinsics.checkNotNullParameter(state, "");
            promoSectionModel2.getAuthRequestContext.onNext(state);
            PromoSpecialAdsSectionAdapter promoSpecialAdsSectionAdapter2 = promoDiscoveryListActivity.initRecordTimeStamp;
            if (promoSpecialAdsSectionAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                promoSpecialAdsSectionAdapter = promoSpecialAdsSectionAdapter2;
            }
            promoSpecialAdsSectionAdapter.notifyDataSetChanged();
            promoDiscoveryListActivity.initRecordTimeStamp();
            promoDiscoveryListActivity.loadPromo();
            if (promoDiscoveryListActivity.PlaceComponentResult() && LocationUtil.getAuthRequestContext(promoDiscoveryListActivity)) {
                promoDiscoveryListActivity.getAuthRequestContext();
                return;
            } else {
                promoDiscoveryListActivity.getPromoCenterPresenter().PlaceComponentResult();
                return;
            }
        }
        PromoSectionModel promoSectionModel3 = promoDiscoveryListActivity.GetContactSyncConfig;
        if (promoSectionModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            promoSectionModel = promoSectionModel3;
        }
        PromoSectionModel.State state2 = PromoSectionModel.State.STATE_HIDDEN;
        Intrinsics.checkNotNullParameter(state2, "");
        promoSectionModel.getAuthRequestContext.onNext(state2);
        promoDiscoveryListActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2(false, categoryModel.MyBillsEntityDataFactory);
    }

    /* renamed from: $r8$lambda$umDVy8iPs3Cq7ED-dxd9QdgXz_w  reason: not valid java name */
    public static /* synthetic */ void m2788$r8$lambda$umDVy8iPs3Cq7EDdxd9QdgXz_w(PromoDiscoveryListActivity promoDiscoveryListActivity, View view) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        promoDiscoveryListActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$x2smgQo0EXcD6SNNURZkrR2fXZo(PromoDiscoveryListActivity promoDiscoveryListActivity, ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(promoDiscoveryListActivity, "");
        Intrinsics.checkNotNullExpressionValue(connectivityModel, "");
        promoDiscoveryListActivity.moveToNextValue = ConnectivityModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(connectivityModel);
    }

    public static final /* synthetic */ void access$doOnLoadFirstPage(PromoDiscoveryListActivity promoDiscoveryListActivity) {
        promoDiscoveryListActivity.getAuthRequestContext = true;
        promoDiscoveryListActivity.getErrorConfigVersion();
    }

    public static final /* synthetic */ void access$fetchPromoWithFilter(final PromoDiscoveryListActivity promoDiscoveryListActivity, final String str, final boolean z) {
        if (promoDiscoveryListActivity.KClassImpl$Data$declaredNonStaticMembers$2(str)) {
            promoDiscoveryListActivity.initRecordTimeStamp();
            Disposable disposable = promoDiscoveryListActivity.getErrorConfigVersion;
            if (disposable != null) {
                disposable.dispose();
            }
            Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) promoDiscoveryListActivity.getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PromoDiscoveryListActivity.$r8$lambda$8tSohep5SvChPqdRa7Cu3zQ7FGg(PromoDiscoveryListActivity.this, str, z, (Location) obj);
                }
            });
            promoDiscoveryListActivity.getErrorConfigVersion = subscribe;
            promoDiscoveryListActivity.addDisposable(subscribe);
            return;
        }
        promoDiscoveryListActivity.getPromoCenterPresenter().MyBillsEntityDataFactory(str, z, null);
    }

    public static final /* synthetic */ void access$hidePromoSpecialAdsSection(PromoDiscoveryListActivity promoDiscoveryListActivity) {
        PromoSectionModel promoSectionModel = promoDiscoveryListActivity.GetContactSyncConfig;
        if (promoSectionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel = null;
        }
        PromoSectionModel.State state = PromoSectionModel.State.STATE_HIDDEN;
        Intrinsics.checkNotNullParameter(state, "");
        promoSectionModel.getAuthRequestContext.onNext(state);
    }

    public static final /* synthetic */ void access$hideShimmerRegularPromo(PromoDiscoveryListActivity promoDiscoveryListActivity) {
        PromoSectionModel promoSectionModel = promoDiscoveryListActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (promoSectionModel != null) {
            PromoSectionModel.State state = PromoSectionModel.State.STATE_HIDE_LOADING;
            Intrinsics.checkNotNullParameter(state, "");
            promoSectionModel.getAuthRequestContext.onNext(state);
        }
    }

    public static final /* synthetic */ void access$initOnEmptyView(PromoDiscoveryListActivity promoDiscoveryListActivity, String str, String str2) {
        ImageView imageView = (ImageView) promoDiscoveryListActivity._$_findCachedViewById(R.id.iv_error_promocenter);
        if (imageView != null) {
            InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_empty_promo_discovery_list);
        }
        TextView textView = (TextView) promoDiscoveryListActivity._$_findCachedViewById(R.id.getFeatureForcedFirstCard);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) promoDiscoveryListActivity._$_findCachedViewById(R.id.tv_error_description);
        if (textView2 != null) {
            textView2.setText(str2);
        }
    }

    public static final /* synthetic */ void access$initOnErrorView(final PromoDiscoveryListActivity promoDiscoveryListActivity) {
        PromoSectionModel promoSectionModel = promoDiscoveryListActivity.GetContactSyncConfig;
        if (promoSectionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel = null;
        }
        PromoSectionModel.State state = PromoSectionModel.State.STATE_HIDDEN;
        Intrinsics.checkNotNullParameter(state, "");
        promoSectionModel.getAuthRequestContext.onNext(state);
        if (promoDiscoveryListActivity.moveToNextValue) {
            ImageView imageView = (ImageView) promoDiscoveryListActivity._$_findCachedViewById(R.id.iv_error_promocenter);
            if (imageView != null) {
                InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_maintenance_page);
            }
            TextView textView = (TextView) promoDiscoveryListActivity._$_findCachedViewById(R.id.getFeatureForcedFirstCard);
            if (textView != null) {
                textView.setText(promoDiscoveryListActivity.getString(R.string.promo_discovery_list_error_title));
            }
            TextView textView2 = (TextView) promoDiscoveryListActivity._$_findCachedViewById(R.id.tv_error_description);
            if (textView2 != null) {
                textView2.setText(promoDiscoveryListActivity.getString(R.string.promo_discovery_list_error_description));
            }
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.btnError);
            if (danaButtonPrimaryView != null) {
                danaButtonPrimaryView.setActiveButton(promoDiscoveryListActivity.getString(R.string.back), null);
            }
            DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.btnError);
            if (danaButtonPrimaryView2 != null) {
                danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PromoDiscoveryListActivity.m2788$r8$lambda$umDVy8iPs3Cq7EDdxd9QdgXz_w(PromoDiscoveryListActivity.this, view);
                    }
                });
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) promoDiscoveryListActivity._$_findCachedViewById(R.id.iv_error_promocenter);
        if (imageView2 != null) {
            InstrumentInjector.Resources_setImageResource(imageView2, R.drawable.ic_network_error);
        }
        TextView textView3 = (TextView) promoDiscoveryListActivity._$_findCachedViewById(R.id.getFeatureForcedFirstCard);
        if (textView3 != null) {
            textView3.setText(promoDiscoveryListActivity.getString(R.string.promo_discovery_error_network_title));
        }
        TextView textView4 = (TextView) promoDiscoveryListActivity._$_findCachedViewById(R.id.tv_error_description);
        if (textView4 != null) {
            textView4.setText(promoDiscoveryListActivity.getString(R.string.promo_discovery_error_network_description));
        }
        DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.btnError);
        if (danaButtonPrimaryView3 != null) {
            danaButtonPrimaryView3.setActiveButton(promoDiscoveryListActivity.getString(R.string.try_again), null);
        }
        DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.btnError);
        if (danaButtonPrimaryView4 != null) {
            danaButtonPrimaryView4.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromoDiscoveryListActivity.$r8$lambda$X8akmhVj9huKTFBG2C1fcr2AT7g(PromoDiscoveryListActivity.this, view);
                }
            });
        }
    }

    public static final /* synthetic */ void access$loadMoreLogic(PromoDiscoveryListActivity promoDiscoveryListActivity) {
        promoDiscoveryListActivity.lookAheadTest = true;
        promoDiscoveryListActivity.getRegularPromoAdapter().getAuthRequestContext(true);
        PromoCategoryView promoCategoryView = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
        if (Intrinsics.areEqual("promocenter_category_all", promoCategoryView != null ? promoCategoryView.getSelectedCategoryId() : null)) {
            promoDiscoveryListActivity.getPromoCenterPresenter().KClassImpl$Data$declaredNonStaticMembers$2(true);
            return;
        }
        PromoCenterContract.Presenter promoCenterPresenter = promoDiscoveryListActivity.getPromoCenterPresenter();
        PromoCategoryView promoCategoryView2 = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
        promoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(true, promoCategoryView2 != null ? promoCategoryView2.getSelectedCategoryId() : null);
    }

    public static final /* synthetic */ void access$setCategoryFromExtra(PromoDiscoveryListActivity promoDiscoveryListActivity) {
        PromoCenterBottomMenuView promoCenterBottomMenuView;
        if (promoDiscoveryListActivity.BuiltInFictitiousFunctionClassFactory()) {
            PromoCategoryView promoCategoryView = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if (promoCategoryView != null) {
                promoCategoryView.setCategory(promoDiscoveryListActivity.getIntent().getStringExtra("categoryId"));
            }
            PromoCategoryView promoCategoryView2 = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if (promoCategoryView2 != null) {
                promoCategoryView2.setVisibility(8);
            }
            PromoCategoryView promoCategoryView3 = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
            if ((promoCategoryView3 != null ? promoCategoryView3.getCategoryFromExtra() : null) == null || (promoCenterBottomMenuView = (PromoCenterBottomMenuView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcb_view)) == null) {
                return;
            }
            PromoCategoryView promoCategoryView4 = (PromoCategoryView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcv_promo_center);
            promoCenterBottomMenuView.setOnCategoryChange(promoCategoryView4 != null ? promoCategoryView4.getCategoryFromExtra() : null);
        }
    }

    public static final /* synthetic */ void access$showErrorScreenWithoutButton(PromoDiscoveryListActivity promoDiscoveryListActivity) {
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) promoDiscoveryListActivity._$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.hideMenu();
        }
        LinearLayout linearLayout = (LinearLayout) promoDiscoveryListActivity._$_findCachedViewById(R.id.res_0x7f0a0ddb_daggernewservicecardcomponent_newservicecardcomponentimpl_threadexecutorprovider);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) promoDiscoveryListActivity._$_findCachedViewById(R.id.clPromoErrorButton);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public static final /* synthetic */ void access$showPromoSpecialAdsSection(PromoDiscoveryListActivity promoDiscoveryListActivity) {
        PromoSectionModel promoSectionModel = promoDiscoveryListActivity.GetContactSyncConfig;
        if (promoSectionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel = null;
        }
        PromoSectionModel.State state = PromoSectionModel.State.STATE_SHOW;
        Intrinsics.checkNotNullParameter(state, "");
        promoSectionModel.getAuthRequestContext.onNext(state);
    }

    public static final /* synthetic */ void access$trackPromotionCenterOpen(PromoDiscoveryListActivity promoDiscoveryListActivity, String str, List list) {
        PromoSectionModel promoSectionModel = promoDiscoveryListActivity.GetContactSyncConfig;
        if (promoSectionModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel = null;
        }
        byte b = 0;
        boolean z = promoSectionModel.PlaceComponentResult() == PromoSectionModel.State.STATE_SHOW;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PromoModel promoModel = (PromoModel) it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            String str2 = promoModel.scheduleImpl;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(Typography.quote);
            arrayList.add(sb.toString());
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(promoDiscoveryListActivity.getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.PROMOTION_CENTER_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.PromotionProperty.MERCHANT_SPECIAL_SHOW, z).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.PROMOTION_LIST, TextUtils.join(",", arrayList)).MyBillsEntityDataFactory(TrackerKey.PromotionProperty.CATEGORY_NAME, str);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
    }

    private final void getAuthRequestContext() {
        Disposable disposable = this.scheduleImpl;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable subscribe = new LocationUtil.LocationRequestBuilder((Application) getDanaApplication()).BuiltInFictitiousFunctionClassFactory().subscribe(new Consumer() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromoDiscoveryListActivity.$r8$lambda$5jHQCJ3FmlG9SzOPFg_6ISASv5Q(PromoDiscoveryListActivity.this, (Location) obj);
            }
        });
        this.scheduleImpl = subscribe;
        addDisposable(subscribe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(String p0, boolean p1) {
        this.getAuthRequestContext = true;
        getErrorConfigVersion();
        PromoCenterContract.Presenter promoCenterPresenter = getPromoCenterPresenter();
        if (TextUtils.isEmpty(p0)) {
            p0 = null;
        }
        promoCenterPresenter.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getErrorConfigVersion() {
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.showMenu();
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0ddb_daggernewservicecardcomponent_newservicecardcomponentimpl_threadexecutorprovider);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.clPromoErrorButton);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        byte b = 0;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            DaggerPromoCenterComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerPromoCenterComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (PromoCenterModule) Preconditions.getAuthRequestContext(new PromoCenterModule(new PromoCenterContract.View() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$initInject$1
                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onSuccessGetPromoList(PromoResultModel p0) {
                    RecyclerView recyclerView;
                    Intrinsics.checkNotNullParameter(p0, "");
                    PromoCategoryView promoCategoryView = (PromoCategoryView) PromoDiscoveryListActivity.this._$_findCachedViewById(R.id.pcv_promo_center);
                    Intrinsics.checkNotNullExpressionValue(promoCategoryView, "");
                    if (!(promoCategoryView.getVisibility() == 0) && (recyclerView = (RecyclerView) PromoDiscoveryListActivity.this._$_findCachedViewById(R.id.rv_regular_promo)) != null) {
                        ViewExtKt.BuiltInFictitiousFunctionClassFactory(recyclerView, null, Integer.valueOf(SizeUtil.getAuthRequestContext(16)), null, null, 13);
                    }
                    PromoDiscoveryListActivity.this.getErrorConfigVersion();
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().setItems(p0.KClassImpl$Data$declaredNonStaticMembers$2);
                    PromoDiscoveryListActivity.access$hideShimmerRegularPromo(PromoDiscoveryListActivity.this);
                    PromoDiscoveryListActivity.this.getAuthRequestContext = false;
                    PromoDiscoveryListActivity.this.BuiltInFictitiousFunctionClassFactory = p0.PlaceComponentResult();
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onSuccessLoadMorePromo(PromoResultModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().getAuthRequestContext(false);
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().addItemsAt(PromoDiscoveryListActivity.this.getRegularPromoAdapter().getPlaceComponentResult(), p0.KClassImpl$Data$declaredNonStaticMembers$2);
                    PromoDiscoveryListActivity.this.BuiltInFictitiousFunctionClassFactory = p0.PlaceComponentResult();
                    PromoDiscoveryListActivity.this.lookAheadTest = false;
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onErrorLoadMorePromo(boolean p0) {
                    PromoDiscoveryListActivity.this.BuiltInFictitiousFunctionClassFactory = p0;
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().getAuthRequestContext(false);
                    PromoDiscoveryListActivity.this.lookAheadTest = false;
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onEmptyGetPromoList() {
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().removeAllItems();
                    PromoDiscoveryListActivity.access$hidePromoSpecialAdsSection(PromoDiscoveryListActivity.this);
                    PromoDiscoveryListActivity promoDiscoveryListActivity = PromoDiscoveryListActivity.this;
                    PromoDiscoveryListActivity.access$initOnEmptyView(promoDiscoveryListActivity, promoDiscoveryListActivity.getString(R.string.promo_empty_title), PromoDiscoveryListActivity.this.getString(R.string.promo_empty_description));
                    PromoDiscoveryListActivity.this.showErrorScreen();
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onErrorGetPromo() {
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().removeAllItems();
                    PromoDiscoveryListActivity.access$initOnErrorView(PromoDiscoveryListActivity.this);
                    PromoDiscoveryListActivity.this.showErrorScreen();
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onErrorGetPromoCategorized() {
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().removeAllItems();
                    PromoDiscoveryListActivity.access$initOnErrorView(PromoDiscoveryListActivity.this);
                    PromoDiscoveryListActivity.this.showErrorScreen();
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onEmptyGetPromoCategorized() {
                    PromoDiscoveryListActivity.this.getRegularPromoAdapter().removeAllItems();
                    PromoDiscoveryListActivity promoDiscoveryListActivity = PromoDiscoveryListActivity.this;
                    PromoDiscoveryListActivity.access$initOnEmptyView(promoDiscoveryListActivity, promoDiscoveryListActivity.getString(R.string.promo_discovery_list_empty_title), PromoDiscoveryListActivity.this.getString(R.string.promo_discovery_list_empty_description));
                    PromoDiscoveryListActivity.access$showErrorScreenWithoutButton(PromoDiscoveryListActivity.this);
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onGetPromoAdsSuccess(List<? extends PromoModel> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.isEmpty()) {
                        PromoDiscoveryListActivity.access$hidePromoSpecialAdsSection(PromoDiscoveryListActivity.this);
                        return;
                    }
                    PromoDiscoveryListActivity.access$showPromoSpecialAdsSection(PromoDiscoveryListActivity.this);
                    PromoDiscoveryListActivity.this.getPromoSpecialAdsAdapter().setItems(p0);
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void onGetPromoAdsError() {
                    PromoDiscoveryListActivity.access$hidePromoSpecialAdsSection(PromoDiscoveryListActivity.this);
                }

                @Override // id.dana.contract.promocenter.promo.PromoCenterContract.View
                public final void trackPromotionCenterOpen() {
                    CategoryModel categoryModel;
                    PromoDiscoveryListActivity promoDiscoveryListActivity = PromoDiscoveryListActivity.this;
                    Context baseContext = promoDiscoveryListActivity.getBaseContext();
                    Intrinsics.checkNotNullExpressionValue(baseContext, "");
                    categoryModel = PromoDiscoveryListActivity.this.PlaceComponentResult;
                    String authRequestContext = StringWrapperKt.getAuthRequestContext(baseContext, StringWrapperKt.MyBillsEntityDataFactory(categoryModel != null ? categoryModel.moveToNextValue : null));
                    List<PromoModel> items = PromoDiscoveryListActivity.this.getRegularPromoAdapter().getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "");
                    PromoDiscoveryListActivity.access$trackPromotionCenterOpen(promoDiscoveryListActivity, authRequestContext, items);
                }
            }));
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(new ServicesContract.View() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$initInject$2
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
            PromoDiscoveryListActivity promoDiscoveryListActivity = this;
            KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = promoDiscoveryListActivity;
            KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = TrackerKey.SourceType.PROMOTION;
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
            ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
            authRequestContext.MyBillsEntityDataFactory = promoDiscoveryListActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
            RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = promoDiscoveryListActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
            FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = promoDiscoveryListActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
            OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = promoDiscoveryListActivity;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }
        PromoCenterComponent promoCenterComponent = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNull(promoCenterComponent);
        promoCenterComponent.BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getReadLinkPropertiesPresenter(), getPromoCenterPresenter());
        Intent intent = getIntent();
        if (intent != null) {
            setCenterTitle(moveToNextValue() ? intent.getStringExtra("toolbar_title") : getString(R.string.promo));
        }
        setMenuLeftButton(R.drawable.btn_arrow_left);
        setRegularPromoAdapter(new RegularPromoAdapter());
        getRegularPromoAdapter().KClassImpl$Data$declaredNonStaticMembers$2 = new PromoView.Listener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda6
            @Override // id.dana.promocenter.views.PromoView.Listener
            public final void getAuthRequestContext(PromoModel promoModel, String str) {
                PromoDiscoveryListActivity.m2786$r8$lambda$WV7gUvqqZUnvXaTnqmQzLxCWv4(PromoDiscoveryListActivity.this, promoModel, str);
            }
        };
        PromoDiscoveryListActivity promoDiscoveryListActivity2 = this;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new LinearLayoutManager(promoDiscoveryListActivity2, 1, false);
        RegularPromoAdapter regularPromoAdapter = getRegularPromoAdapter();
        LinearLayoutManager linearLayoutManager = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        RegularPromoSectionAdapter regularPromoSectionAdapter = null;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayoutManager = null;
        }
        PromoSectionModel promoSectionModel = new PromoSectionModel(regularPromoAdapter, linearLayoutManager);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = promoSectionModel;
        Intrinsics.checkNotNull(promoSectionModel);
        this.DatabaseTableConfigUtil = new RegularPromoSectionAdapter(promoSectionModel);
        setPromoSpecialAdsAdapter(new PromoSpecialAdsAdapter(promoDiscoveryListActivity2));
        getPromoSpecialAdsAdapter().setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda2
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                PromoDiscoveryListActivity.m2785$r8$lambda$Btwlc93ZRIDzC7FGSM9PjPdvbQ(PromoDiscoveryListActivity.this, i);
            }
        });
        PromoSectionModel promoSectionModel2 = new PromoSectionModel(getPromoSpecialAdsAdapter(), new LinearLayoutManager(promoDiscoveryListActivity2, 0, false));
        this.GetContactSyncConfig = promoSectionModel2;
        if (promoSectionModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSectionModel2 = null;
        }
        this.initRecordTimeStamp = new PromoSpecialAdsSectionAdapter(promoSectionModel2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(promoDiscoveryListActivity2, 1, false);
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        PromoSpecialAdsSectionAdapter promoSpecialAdsSectionAdapter = this.initRecordTimeStamp;
        if (promoSpecialAdsSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            promoSpecialAdsSectionAdapter = null;
        }
        adapterArr[0] = promoSpecialAdsSectionAdapter;
        RegularPromoSectionAdapter regularPromoSectionAdapter2 = this.DatabaseTableConfigUtil;
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
            promoCategoryView.setListener(new CategoryView.OnClickListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda5
                @Override // id.dana.richview.category.CategoryView.OnClickListener
                public final void PlaceComponentResult(CategoryModel categoryModel, boolean z) {
                    PromoDiscoveryListActivity.m2787$r8$lambda$XpSc_5dQWwwNrQN4o7dtIfzfhc(PromoDiscoveryListActivity.this, categoryModel, z);
                }
            });
        }
        PromoCategoryView promoCategoryView2 = (PromoCategoryView) _$_findCachedViewById(R.id.pcv_promo_center);
        if (promoCategoryView2 != null) {
            promoCategoryView2.setOnGetCategoriesListener(new PromoCategoryView.SetOnGetCategoriesListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$initPromoCategoryView$2
                @Override // id.dana.richview.promocenter.PromoCategoryView.SetOnGetCategoriesListener
                public final void PlaceComponentResult(CategoryModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PromoDiscoveryListActivity.this.PlaceComponentResult = p0;
                    PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) PromoDiscoveryListActivity.this._$_findCachedViewById(R.id.pcb_view);
                    if (promoCenterBottomMenuView != null) {
                        promoCenterBottomMenuView.setOnCategoryChange(p0);
                    }
                    PromoCenterBottomMenuView promoCenterBottomMenuView2 = (PromoCenterBottomMenuView) PromoDiscoveryListActivity.this._$_findCachedViewById(R.id.pcb_view);
                    if (promoCenterBottomMenuView2 != null) {
                        promoCenterBottomMenuView2.setDefault();
                    }
                    PromoDiscoveryListActivity.access$setCategoryFromExtra(PromoDiscoveryListActivity.this);
                    PromoDiscoveryListActivity.this.scheduleImpl();
                    PromoDiscoveryListActivity.this.loadPromo();
                }

                @Override // id.dana.richview.promocenter.PromoCategoryView.SetOnGetCategoriesListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    PromoDiscoveryListActivity.this.showErrorScreen();
                }
            });
        }
        final Rect rect = new Rect();
        ((RecyclerView) _$_findCachedViewById(R.id.rv_regular_promo)).getHitRect(rect);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_regular_promo)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$getOnPromoCenterScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                boolean MyBillsEntityDataFactory2;
                boolean z;
                boolean z2;
                boolean z3;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                PromoDiscoveryListActivity.Companion companion = PromoDiscoveryListActivity.INSTANCE;
                MyBillsEntityDataFactory2 = PromoDiscoveryListActivity.this.MyBillsEntityDataFactory(rect, PromoDiscoveryListActivity.Companion.PlaceComponentResult(PromoDiscoveryListActivity.this.getRegularPromoAdapter().getPlaceComponentResult()));
                if (MyBillsEntityDataFactory2) {
                    z = PromoDiscoveryListActivity.this.BuiltInFictitiousFunctionClassFactory;
                    if (z) {
                        z2 = PromoDiscoveryListActivity.this.getAuthRequestContext;
                        if (z2) {
                            return;
                        }
                        z3 = PromoDiscoveryListActivity.this.lookAheadTest;
                        if (z3) {
                            return;
                        }
                        PromoDiscoveryListActivity.access$loadMoreLogic(PromoDiscoveryListActivity.this);
                    }
                }
            }
        });
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.setOnSubmitSortClicked(new Function2<String, Boolean, Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$initBottomMenu$1
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
                    PromoDiscoveryListActivity promoDiscoveryListActivity3 = PromoDiscoveryListActivity.this;
                    Intrinsics.checkNotNull(bool);
                    promoDiscoveryListActivity3.MyBillsEntityDataFactory(str, bool.booleanValue());
                }
            });
        }
        PromoCenterBottomMenuView promoCenterBottomMenuView2 = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView2 != null) {
            promoCenterBottomMenuView2.setOnSubmitFilterClicked(new Function2<String, Boolean, Unit>() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$initBottomMenu$2
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
                    PromoDiscoveryListActivity.access$doOnLoadFirstPage(PromoDiscoveryListActivity.this);
                    PromoDiscoveryListActivity promoDiscoveryListActivity3 = PromoDiscoveryListActivity.this;
                    if (TextUtils.isEmpty(str)) {
                        str = null;
                    }
                    PromoDiscoveryListActivity.access$fetchPromoWithFilter(promoDiscoveryListActivity3, str, z);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnError);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.views.PromoDiscoveryListActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromoDiscoveryListActivity.$r8$lambda$IUCYVVZtnI9Ke0UsyOEmeh8eehM(PromoDiscoveryListActivity.this, view);
                }
            });
        }
    }

    public final void showErrorScreen() {
        PromoCenterBottomMenuView promoCenterBottomMenuView = (PromoCenterBottomMenuView) _$_findCachedViewById(R.id.pcb_view);
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.hideMenu();
        }
        PromoCategoryView promoCategoryView = (PromoCategoryView) _$_findCachedViewById(R.id.pcv_promo_center);
        if (promoCategoryView != null) {
            promoCategoryView.hide();
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0ddb_daggernewservicecardcomponent_newservicecardcomponentimpl_threadexecutorprovider);
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.clPromoErrorButton);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (NetworkUserEntityData$$ExternalSyntheticLambda5 ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
