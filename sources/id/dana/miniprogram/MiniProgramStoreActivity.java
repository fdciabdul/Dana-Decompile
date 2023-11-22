package id.dana.miniprogram;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.ExpandableListView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.MiniProgramModule;
import id.dana.di.modules.OauthModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.miniprogram.model.MiniProgram;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.miniprogram.MiniProgramStoreActivity;
import id.dana.miniprogram.adapter.AllMiniProgramsAdapter;
import id.dana.miniprogram.adapter.GridMiniProgramAdapter;
import id.dana.miniprogram.di.DaggerMiniProgramComponent;
import id.dana.miniprogram.di.MiniProgramContract;
import id.dana.miniprogram.di.MiniProgramPresenter;
import id.dana.miniprogram.di.MiniProgramPresenter$getFavoriteMiniPrograms$1;
import id.dana.miniprogram.di.MiniProgramPresenter$getRecentMiniPrograms$1;
import id.dana.miniprogram.view.SectionView;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.SearchView;
import id.dana.util.IapConnectKtx;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0002PQB\u0007¢\u0006\u0004\bO\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\u0014\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J\u001f\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0005R(\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u0015R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010$R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010*\u001a\u00020:8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010#\u001a\u00020=2\u0006\u0010>\u001a\u00020=8\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\b?\u0010@\"\u0004\b2\u0010AR\"\u0010C\u001a\u00020B8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010-\u001a\u00020/8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bI\u00101R\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u00100\u001a\u0002068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bN\u00108"}, d2 = {"Lid/dana/miniprogram/MiniProgramStoreActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/miniprogram/di/MiniProgramContract$View;", "", "dismissProgress", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "onDestroy", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "appId", "onFavoriteLimitExceeded", "", "Lid/dana/domain/miniprogram/model/MiniProgram;", "miniPrograms", "onGetMiniPrograms", "(Ljava/util/List;)V", "favoriteMiniPrograms", "onLoadFavoriteMiniPrograms", "recentMiniPrograms", "onLoadRecentMiniPrograms", "", TrackerKey.SendMoneyProperties.IS_FAVORITE, "onSetFavoriteMiniPrograms", "(Ljava/lang/String;Z)V", "", "lastOpen", "onSetRecentMiniProgram", "(Ljava/lang/String;J)V", "showProgress", "getErrorConfigVersion", "Ljava/util/List;", "getAllMiniProgramAppIds", "()Ljava/util/List;", "setAllMiniProgramAppIds", "allMiniProgramAppIds", "Lid/dana/miniprogram/adapter/AllMiniProgramsAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/miniprogram/adapter/AllMiniProgramsAdapter;", "MyBillsEntityDataFactory", "lookAheadTest", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/miniprogram/adapter/GridMiniProgramAdapter;", "scheduleImpl", "Lid/dana/miniprogram/adapter/GridMiniProgramAdapter;", "PlaceComponentResult", "DatabaseTableConfigUtil", "Z", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CoroutineScope;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlinx/coroutines/CoroutineScope;", "getAuthRequestContext", "Lkotlinx/coroutines/CompletableJob;", "GetContactSyncConfig", "Lkotlinx/coroutines/CompletableJob;", "Lid/dana/miniprogram/MiniProgramStoreActivity$PageState;", "p0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/miniprogram/MiniProgramStoreActivity$PageState;", "(Lid/dana/miniprogram/MiniProgramStoreActivity$PageState;)V", "Lid/dana/miniprogram/di/MiniProgramPresenter;", "presenter", "Lid/dana/miniprogram/di/MiniProgramPresenter;", "getPresenter", "()Lid/dana/miniprogram/di/MiniProgramPresenter;", "setPresenter", "(Lid/dana/miniprogram/di/MiniProgramPresenter;)V", "initRecordTimeStamp", "Lcom/ethanhua/skeleton/SkeletonScreen;", "isLayoutRequested", "Lcom/ethanhua/skeleton/SkeletonScreen;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda8", "<init>", "Companion", "PageState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MiniProgramStoreActivity extends BaseActivity implements MiniProgramContract.View {
    private static long NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    private static char PrepareContext = 0;
    public static final int SEARCH_CHARACTERS = 3;
    private static int newProxyInstance;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final CompletableJob NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private AllMiniProgramsAdapter MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private PageState getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final CoroutineScope getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final CoroutineScope scheduleImpl;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private GridMiniProgramAdapter lookAheadTest;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private SkeletonScreen moveToNextValue;
    @Inject
    public MiniProgramPresenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private GridMiniProgramAdapter PlaceComponentResult;
    public static final byte[] $$a = {22, 66, -65, -82, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 247;
    public static final byte[] getAuthRequestContext = {116, 58, -28, -63, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 198;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<MiniProgram> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private List<String> allMiniProgramAppIds = CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/miniprogram/MiniProgramStoreActivity$PageState;", "", "<init>", "(Ljava/lang/String;I)V", "DISPLAYING_EMPTY_SEARCH_RESULT", "MINI_PROGRAM_ERROR", "SUCCESS"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum PageState {
        DISPLAYING_EMPTY_SEARCH_RESULT,
        MINI_PROGRAM_ERROR,
        SUCCESS
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[PageState.values().length];
            iArr[PageState.MINI_PROGRAM_ERROR.ordinal()] = 1;
            iArr[PageState.DISPLAYING_EMPTY_SEARCH_RESULT.ordinal()] = 2;
            iArr[PageState.SUCCESS.ordinal()] = 3;
            MyBillsEntityDataFactory = iArr;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        PrepareContext = (char) 13492;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = -4515831936135884216L;
        newProxyInstance = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 16
            byte[] r0 = id.dana.miniprogram.MiniProgramStoreActivity.getAuthRequestContext
            int r6 = r6 + 97
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L14:
            r3 = 0
        L15:
            r5 = r7
            r7 = r6
            r6 = r5
            byte r4 = (byte) r7
            int r8 = r8 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.MiniProgramStoreActivity.b(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 2
            int r9 = 103 - r9
            byte[] r0 = id.dana.miniprogram.MiniProgramStoreActivity.$$a
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = 47 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r9
            r4 = 0
            r9 = r8
            goto L2a
        L15:
            r3 = 0
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L25
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L25:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r6
        L2a:
            int r3 = -r3
            int r7 = r7 + 1
            int r8 = r8 + r3
            int r8 = r8 + (-7)
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.MiniProgramStoreActivity.c(short, byte, short, java.lang.Object[]):void");
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
        a(new char[]{42748, 27577, 53441, 64977}, new char[]{20018, 62096, 29056, 57976}, Color.blue(0), (char) (30833 - (Process.myTid() >> 22)), new char[]{29791, 11416, 36441, 7907, 8499, 41290, 48427, 31775, 61665, 52763, 37874, 61460, 37380, 17406, 51471, 22354, 59396, 8514}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(new char[]{42748, 27577, 53441, 64977}, new char[]{34111, 44989, 40171, 47178}, (-340804219) - Color.red(0), (char) (19100 - (Process.myTid() >> 22)), new char[]{20104, 18006, 14003, 20524, 62407}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(new char[]{42748, 27577, 53441, 64977}, new char[]{48674, 51390, 7293, 34267}, ViewConfiguration.getTouchSlop() >> 8, (char) KeyEvent.getDeadChar(0, 0), new char[]{43969, 55151, 64113, 30722, 41207, 16095, 33704, 57125, 56235, 57368, 40050, 29212, 48195, 65398, 44524, 19188, 46648, 49225, 55381, 39094, 1487, 43583, 2894, 36623, 2190, 37710, 54377, 3067, 39568, 3271, 46445, 11166, 17365, 58877, 14038, 6634, 24994, 13150, 3862, 25785, 22295, 11171, 38435, 13893, 13546, 9610, 29812, 24696}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(new char[]{42748, 27577, 53441, 64977}, new char[]{50690, 51769, 55072, 58291}, View.MeasureSpec.getMode(0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), new char[]{8613, 29000, 27851, 39199, 39249, 4844, 1084, 10696, 28478, 14542, 6086, 62801, 35898, 3256, 33755, 48332, 5429, 20401, 60372, 25493, 49241, 49659, 60706, 28413, 52042, 9084, 56176, 24342, 9825, 52875, 10062, 30735, 31305, 37753, 1968, 11231, 8886, 37874, 62686, 58458, 55069, 50620, 7254, 32936, 16798, 16226, 58328, 38062, 31248, 12665, 43245, 19446, 26012, 5923, 18687, 26617, 43297, 29873, 23426, 17418, 2975, 12386, 16339, 23599}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{42748, 27577, 53441, 64977}, new char[]{39545, 38302, 2772, 23290}, (-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) View.resolveSize(0, 0), new char[]{54512, 39311, 37767, 38145, 27869, 21883, 645, 41073, 24009, 34433, 2598, 57375, 58160, 43342, 63679, 60189, 1403, 63803, 23556, 55446, 3640, 30126, 26989, 30540, 52789, 47568, 49335, 48219, 64862, 50134, 53008, 53810, 53711, 37755, 34246, 38840, 59471, 54163, 12201, 62144, 52957, 45056, 23923, 1381, 28130, 8262, 17321, 37680, 60276, 46455, 18276, 50752, 60688, 21118, 26966, 25500, 63813, 20748, 29905, 19324, 24358, 13924, 8730, 47122}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(new char[]{42748, 27577, 53441, 64977}, new char[]{7000, 62727, 32439, 62715}, TextUtils.indexOf("", "", 0, 0), (char) ExpandableListView.getPackedPositionType(0L), new char[]{8620, 16332, 43940, 62058, 15088, 4539, 18217, 58677, 35083, 14979, 39943, 6982, 22312, 58733, 45415, 62903, 7018, 61904, 11463, 30668, 28298, 34556, 38760, 45729, 1189, 6530, 15727, 8007, 16375, 36633, 21587, 33870, 62634, 61680, 32216, 46428, 61808, 58716, 50596, 19069, 52146, 56223, 63634, 12808, 24689, 11911, 21344, 7981, 56489, 62875, 64941, 31447, 27319, 10975, 43978, 33450, 65294, 62484, 61244, 38252}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(new char[]{42748, 27577, 53441, 64977}, new char[]{51313, 15733, 4664, 4013}, ViewConfiguration.getFadingEdgeLength() >> 16, (char) (44306 - TextUtils.indexOf("", "", 0, 0)), new char[]{4300, 890, 2573, 52511, 42546, 54373}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 18 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.resolveSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (-getAuthRequestContext[32]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 36), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b3 = (byte) (getAuthRequestContext[30] + 1);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr15 = new Object[1];
                b(b3, b4, (byte) (b4 | Ascii.NAK), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (Process.myPid() >> 22), 3 - (Process.myPid() >> 22), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        Object[] objArr17 = new Object[1];
                        c((byte) (-$$a[53]), $$a[68], (byte) (-$$a[12]), objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 15 - KeyEvent.getDeadChar(0, 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 815, (ViewConfiguration.getPressedStateDuration() >> 16) + 29, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getSize(0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 15, (char) (AndroidCharacter.getMirror('0') - '0')));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1782816912, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (-getAuthRequestContext[32]);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr21 = new Object[1];
                b(b5, b6, (byte) (b6 | 36), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b7 = (byte) (getAuthRequestContext[30] + 1);
                byte b8 = getAuthRequestContext[25];
                Object[] objArr22 = new Object[1];
                b(b7, b8, (byte) (b8 | Ascii.NAK), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), Color.red(0) + 46, (char) (Color.rgb(0, 0, 0) + 16777216));
                        Object[] objArr24 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr24);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), Process.getGidForName("") + 36, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1782816912, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, 18 - TextUtils.getOffsetAfter("", 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (-getAuthRequestContext[32]);
                byte b10 = getAuthRequestContext[25];
                Object[] objArr28 = new Object[1];
                b(b9, b10, (byte) (b10 | 36), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b11 = (byte) (getAuthRequestContext[30] + 1);
                byte b12 = getAuthRequestContext[25];
                Object[] objArr29 = new Object[1];
                b(b11, b12, (byte) (b12 | Ascii.NAK), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 118, 3 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (38968 - View.MeasureSpec.getSize(0)));
                        Object[] objArr31 = new Object[1];
                        c($$a[20], (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr31);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1782816912, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), TextUtils.indexOf("", "", 0) + 18, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (-getAuthRequestContext[32]);
                byte b14 = getAuthRequestContext[25];
                Object[] objArr35 = new Object[1];
                b(b13, b14, (byte) (b14 | 36), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b15 = (byte) (getAuthRequestContext[30] + 1);
                byte b16 = getAuthRequestContext[25];
                Object[] objArr36 = new Object[1];
                b(b15, b16, (byte) (b16 | Ascii.NAK), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 107, View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        byte b17 = (byte) ($$a[47] - 1);
                        Object[] objArr38 = new Object[1];
                        c(b17, b17, (byte) (-$$a[9]), objArr38);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1782816912, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, KeyEvent.getDeadChar(0, 0) + 18, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_mini_program_store;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(new char[]{42748, 27577, 53441, 64977}, new char[]{20018, 62096, 29056, 57976}, super.getResources().getString(R.string.dana_plus_term_and_condition_remark).substring(5, 6).codePointAt(0) - 110, (char) (getPackageName().codePointAt(2) + 30787), new char[]{29791, 11416, 36441, 7907, 8499, 41290, 48427, 31775, 61665, 52763, 37874, 61460, 37380, 17406, 51471, 22354, 59396, 8514}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(new char[]{42748, 27577, 53441, 64977}, new char[]{34111, 44989, 40171, 47178}, getPackageName().length() - 340804226, (char) (getPackageName().codePointAt(3) + 19000), new char[]{20104, 18006, 14003, 20524, 62407}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                char[] cArr = {42748, 27577, 53441, 64977};
                char[] cArr2 = {65044, 28181, 31762, 39074};
                try {
                    Object[] objArr4 = new Object[1];
                    b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[7], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b(getAuthRequestContext[5], getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), objArr5);
                    int i = ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion - 33;
                    try {
                        Object[] objArr6 = new Object[1];
                        b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[7], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(getAuthRequestContext[5], getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), objArr7);
                        Object[] objArr8 = new Object[1];
                        a(cArr, cArr2, i, (char) (((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 41563), new char[]{21518, 9629, 38423, 27095, 49378, 13311, 3848, 28546, 9717, 53024, 64501, 19747, 21271, 2109, 46066, 2190, 6108, 62751, 35421, 26352, 35076, 35781, 54398, 30732, 47742, 30934}, objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        a(new char[]{42748, 27577, 53441, 64977}, new char[]{41539, 64417, 5069, 47550}, KeyEvent.getMaxKeyCode() >> 16, (char) (48659 - KeyEvent.getDeadChar(0, 0)), new char[]{61915, 37472, 8052, 15206, 59474, 37636, 14183, 1588, 21701, 51471, 14003, 18715, 59044, 48264, 17152, 64021, 18960, 6282}, objArr9);
                        baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), 35 - ExpandableListView.getPackedPositionType(0L), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr10 = new Object[1];
                    a(new char[]{42748, 27577, 53441, 64977}, new char[]{48674, 51390, 7293, 34267}, super.getResources().getString(R.string.auto_top_up_day).substring(1, 2).codePointAt(0) - 97, (char) (getPackageName().length() - 7), new char[]{43969, 55151, 64113, 30722, 41207, 16095, 33704, 57125, 56235, 57368, 40050, 29212, 48195, 65398, 44524, 19188, 46648, 49225, 55381, 39094, 1487, 43583, 2894, 36623, 2190, 37710, 54377, 3067, 39568, 3271, 46445, 11166, 17365, 58877, 14038, 6634, 24994, 13150, 3862, 25785, 22295, 11171, 38435, 13893, 13546, 9610, 29812, 24696}, objArr10);
                    String str = (String) objArr10[0];
                    char[] cArr3 = {42748, 27577, 53441, 64977};
                    char[] cArr4 = {50690, 51769, 55072, 58291};
                    int i2 = (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1;
                    try {
                        Object[] objArr11 = new Object[1];
                        b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[7], objArr11);
                        Class<?> cls5 = Class.forName((String) objArr11[0]);
                        b(getAuthRequestContext[5], getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), new Object[1]);
                        Object[] objArr12 = new Object[1];
                        a(cArr3, cArr4, i2, (char) (((ApplicationInfo) cls5.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{8613, 29000, 27851, 39199, 39249, 4844, 1084, 10696, 28478, 14542, 6086, 62801, 35898, 3256, 33755, 48332, 5429, 20401, 60372, 25493, 49241, 49659, 60706, 28413, 52042, 9084, 56176, 24342, 9825, 52875, 10062, 30735, 31305, 37753, 1968, 11231, 8886, 37874, 62686, 58458, 55069, 50620, 7254, 32936, 16798, 16226, 58328, 38062, 31248, 12665, 43245, 19446, 26012, 5923, 18687, 26617, 43297, 29873, 23426, 17418, 2975, 12386, 16339, 23599}, objArr12);
                        String str2 = (String) objArr12[0];
                        char[] cArr5 = {42748, 27577, 53441, 64977};
                        char[] cArr6 = {39545, 38302, 2772, 23290};
                        try {
                            Object[] objArr13 = new Object[1];
                            b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[7], objArr13);
                            Class<?> cls6 = Class.forName((String) objArr13[0]);
                            b(getAuthRequestContext[5], getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), new Object[1]);
                            Object[] objArr14 = new Object[1];
                            a(cArr5, cArr6, ((ApplicationInfo) cls6.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().length() - 7), new char[]{54512, 39311, 37767, 38145, 27869, 21883, 645, 41073, 24009, 34433, 2598, 57375, 58160, 43342, 63679, 60189, 1403, 63803, 23556, 55446, 3640, 30126, 26989, 30540, 52789, 47568, 49335, 48219, 64862, 50134, 53008, 53810, 53711, 37755, 34246, 38840, 59471, 54163, 12201, 62144, 52957, 45056, 23923, 1381, 28130, 8262, 17321, 37680, 60276, 46455, 18276, 50752, 60688, 21118, 26966, 25500, 63813, 20748, 29905, 19324, 24358, 13924, 8730, 47122}, objArr14);
                            String str3 = (String) objArr14[0];
                            Object[] objArr15 = new Object[1];
                            a(new char[]{42748, 27577, 53441, 64977}, new char[]{7000, 62727, 32439, 62715}, KeyEvent.getMaxKeyCode() >> 16, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{8620, 16332, 43940, 62058, 15088, 4539, 18217, 58677, 35083, 14979, 39943, 6982, 22312, 58733, 45415, 62903, 7018, 61904, 11463, 30668, 28298, 34556, 38760, 45729, 1189, 6530, 15727, 8007, 16375, 36633, 21587, 33870, 62634, 61680, 32216, 46428, 61808, 58716, 50596, 19069, 52146, 56223, 63634, 12808, 24689, 11911, 21344, 7981, 56489, 62875, 64941, 31447, 27319, 10975, 43978, 33450, 65294, 62484, 61244, 38252}, objArr15);
                            String str4 = (String) objArr15[0];
                            Object[] objArr16 = new Object[1];
                            a(new char[]{42748, 27577, 53441, 64977}, new char[]{51313, 15733, 4664, 4013}, (-1) - TextUtils.lastIndexOf("", '0'), (char) (getPackageName().codePointAt(1) + 44206), new char[]{4300, 890, 2573, 52511, 42546, 54373}, objArr16);
                            try {
                                Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, (char) (Process.getGidForName("") + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr17);
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
            byte b = (byte) (-getAuthRequestContext[32]);
            byte b2 = getAuthRequestContext[25];
            Object[] objArr18 = new Object[1];
            b(b, b2, (byte) (b2 | 36), objArr18);
            Class<?> cls7 = Class.forName((String) objArr18[0]);
            byte b3 = (byte) (getAuthRequestContext[30] + 1);
            byte b4 = getAuthRequestContext[25];
            Object[] objArr19 = new Object[1];
            b(b3, b4, (byte) (b4 | Ascii.NAK), objArr19);
            try {
                Object[] objArr20 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.getDefaultSize(0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 4, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))));
                    byte b5 = (byte) ($$a[47] - 1);
                    Object[] objArr21 = new Object[1];
                    c(b5, b5, (byte) (-$$a[9]), objArr21);
                    obj3 = cls8.getMethod((String) objArr21[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                int i3 = ((int[]) objArr22[1])[0];
                if (((int[]) objArr22[0])[0] != i3) {
                    long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr23 = {666432913, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, Process.getGidForName("") + 19, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr23);
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
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Class<?> cls;
        Object[] objArr;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr2 = new Object[1];
            a(new char[]{42748, 27577, 53441, 64977}, new char[]{65044, 28181, 31762, 39074}, super.getResources().getString(R.string.home_shopping_tutorial_pay_step_4).substring(12, 13).codePointAt(0) - 114, (char) (KeyEvent.getDeadChar(0, 0) + 41596), new char[]{21518, 9629, 38423, 27095, 49378, 13311, 3848, 28546, 9717, 53024, 64501, 19747, 21271, 2109, 46066, 2190, 6108, 62751, 35421, 26352, 35076, 35781, 54398, 30732, 47742, 30934}, objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            char[] cArr = {42748, 27577, 53441, 64977};
            char[] cArr2 = {41539, 64417, 5069, 47550};
            int length = super.getResources().getString(R.string.family_account_text_how_much_do_you_want_to_top_up).substring(3, 4).length() - 1;
            try {
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[7], objArr3);
                cls = Class.forName((String) objArr3[0]);
                objArr = new Object[1];
                b(getAuthRequestContext[5], getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), objArr);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr4 = new Object[1];
                a(cArr, cArr2, length, (char) (((ApplicationInfo) cls.getMethod((String) objArr[0], null).invoke(this, null)).targetSdkVersion + 48626), new char[]{61915, 37472, 8052, 15206, 59474, 37636, 14183, 1588, 21701, 51471, 14003, 18715, 59044, 48264, 17152, 64021, 18960, 6282}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", ""), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), View.MeasureSpec.getSize(0) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{42748, 27577, 53441, 64977}, new char[]{65044, 28181, 31762, 39074}, Color.blue(0), (char) (super.getResources().getString(R.string.input_card_oneklik_error).substring(21, 22).length() + 41595), new char[]{21518, 9629, 38423, 27095, 49378, 13311, 3848, 28546, 9717, 53024, 64501, 19747, 21271, 2109, 46066, 2190, 6108, 62751, 35421, 26352, 35076, 35781, 54398, 30732, 47742, 30934}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {42748, 27577, 53441, 64977};
            char[] cArr2 = {41539, 64417, 5069, 47550};
            int length = super.getResources().getString(R.string.installment_simulation_bill_amount_title).substring(3, 4).length() - 1;
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[30], getAuthRequestContext[7], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(getAuthRequestContext[5], getAuthRequestContext[8], (byte) (-getAuthRequestContext[59]), objArr3);
                Object[] objArr4 = new Object[1];
                a(cArr, cArr2, length, (char) (((ApplicationInfo) cls2.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 48626), new char[]{61915, 37472, 8052, 15206, 59474, 37636, 14183, 1588, 21701, 51471, 14003, 18715, 59044, 48264, 17152, 64021, 18960, 6282}, objArr4);
                baseContext = (Context) cls.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776305) - Color.rgb(0, 0, 0), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) Color.alpha(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    }

    public MiniProgramStoreActivity() {
        CompletableJob Job$default;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Job$default;
        CompletableJob completableJob = Job$default;
        this.getAuthRequestContext = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(completableJob));
        this.scheduleImpl = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(completableJob));
        this.getErrorConfigVersion = PageState.MINI_PROGRAM_ERROR;
    }

    @JvmName(name = "getPresenter")
    public final MiniProgramPresenter getPresenter() {
        MiniProgramPresenter miniProgramPresenter = this.presenter;
        if (miniProgramPresenter != null) {
            return miniProgramPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MiniProgramPresenter miniProgramPresenter) {
        Intrinsics.checkNotNullParameter(miniProgramPresenter, "");
        this.presenter = miniProgramPresenter;
    }

    @JvmName(name = "getAllMiniProgramAppIds")
    public final List<String> getAllMiniProgramAppIds() {
        return this.allMiniProgramAppIds;
    }

    @JvmName(name = "setAllMiniProgramAppIds")
    public final void setAllMiniProgramAppIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.allMiniProgramAppIds = list;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        AlipayConnectInitializer alipayConnectInitializer = getDanaApplication().getAlipayConnectInitializer();
        Intrinsics.checkNotNullExpressionValue(alipayConnectInitializer, "");
        IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(alipayConnectInitializer, new Function0<Unit>() { // from class: id.dana.miniprogram.MiniProgramStoreActivity$init$1
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
                CoroutineScope coroutineScope;
                CoroutineScope coroutineScope2;
                MiniProgramStoreActivity.access$initInjector(MiniProgramStoreActivity.this);
                MiniProgramStoreActivity.access$initView(MiniProgramStoreActivity.this);
                MiniProgramStoreActivity.access$setupSearchView(MiniProgramStoreActivity.this);
                final MiniProgramPresenter presenter = MiniProgramStoreActivity.this.getPresenter();
                MiniProgramStoreActivity miniProgramStoreActivity = MiniProgramStoreActivity.this;
                coroutineScope = miniProgramStoreActivity.getAuthRequestContext;
                Intrinsics.checkNotNullParameter(coroutineScope, "");
                presenter.getAuthRequestContext = coroutineScope;
                coroutineScope2 = miniProgramStoreActivity.scheduleImpl;
                Intrinsics.checkNotNullParameter(coroutineScope2, "");
                presenter.NetworkUserEntityData$$ExternalSyntheticLambda0 = coroutineScope2;
                presenter.PlaceComponentResult.showProgress();
                presenter.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<List<? extends MiniProgram>, Unit>() { // from class: id.dana.miniprogram.di.MiniProgramPresenter$getMiniPrograms$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends MiniProgram> list) {
                        invoke2((List<MiniProgram>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<MiniProgram> list) {
                        MiniProgramContract.View view;
                        MiniProgramContract.View view2;
                        Intrinsics.checkNotNullParameter(list, "");
                        view = MiniProgramPresenter.this.PlaceComponentResult;
                        view.dismissProgress();
                        view2 = MiniProgramPresenter.this.PlaceComponentResult;
                        view2.onGetMiniPrograms(list);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.miniprogram.di.MiniProgramPresenter$getMiniPrograms$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        MiniProgramContract.View view;
                        MiniProgramContract.View view2;
                        Intrinsics.checkNotNullParameter(th, "");
                        view = MiniProgramPresenter.this.PlaceComponentResult;
                        view.dismissProgress();
                        view2 = MiniProgramPresenter.this.PlaceComponentResult;
                        view2.onError(th.getMessage());
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
    
        if ((!r3.isEmpty()) != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    @kotlin.jvm.JvmName(name = "PlaceComponentResult")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(id.dana.miniprogram.MiniProgramStoreActivity.PageState r7) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.MiniProgramStoreActivity.PlaceComponentResult(id.dana.miniprogram.MiniProgramStoreActivity$PageState):void");
    }

    @Override // id.dana.miniprogram.di.MiniProgramContract.View
    public final void onGetMiniPrograms(List<MiniProgram> miniPrograms) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        PageState pageState;
        Intrinsics.checkNotNullParameter(miniPrograms, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = miniPrograms;
        List<MiniProgram> list = miniPrograms;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MiniProgram) it.next()).getAppId());
        }
        this.allMiniProgramAppIds = arrayList;
        MiniProgramPresenter presenter = getPresenter();
        Intrinsics.checkNotNullParameter(miniPrograms, "");
        CoroutineScope coroutineScope3 = presenter.getAuthRequestContext;
        AllMiniProgramsAdapter allMiniProgramsAdapter = null;
        if (coroutineScope3 != null) {
            coroutineScope = coroutineScope3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            coroutineScope = null;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MiniProgramPresenter$getFavoriteMiniPrograms$1(miniPrograms, presenter, null), 3, null);
        MiniProgramPresenter presenter2 = getPresenter();
        Intrinsics.checkNotNullParameter(miniPrograms, "");
        CoroutineScope coroutineScope4 = presenter2.getAuthRequestContext;
        if (coroutineScope4 != null) {
            coroutineScope2 = coroutineScope4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            coroutineScope2 = null;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new MiniProgramPresenter$getRecentMiniPrograms$1(miniPrograms, presenter2, null), 3, null);
        AllMiniProgramsAdapter allMiniProgramsAdapter2 = this.MyBillsEntityDataFactory;
        if (allMiniProgramsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            allMiniProgramsAdapter = allMiniProgramsAdapter2;
        }
        allMiniProgramsAdapter.setItems(miniPrograms);
        allMiniProgramsAdapter.notifyDataSetChanged();
        ((NestedScrollView) _$_findCachedViewById(R.id.judgeRes)).smoothScrollTo(0, 0);
        if (miniPrograms.isEmpty()) {
            pageState = PageState.MINI_PROGRAM_ERROR;
        } else {
            pageState = PageState.SUCCESS;
        }
        PlaceComponentResult(pageState);
    }

    @Override // id.dana.miniprogram.di.MiniProgramContract.View
    public final void onLoadFavoriteMiniPrograms(List<MiniProgram> favoriteMiniPrograms) {
        Intrinsics.checkNotNullParameter(favoriteMiniPrograms, "");
        GridMiniProgramAdapter gridMiniProgramAdapter = this.PlaceComponentResult;
        if (gridMiniProgramAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            gridMiniProgramAdapter = null;
        }
        gridMiniProgramAdapter.setItems(favoriteMiniPrograms);
        gridMiniProgramAdapter.notifyDataSetChanged();
        ((NestedScrollView) _$_findCachedViewById(R.id.judgeRes)).smoothScrollTo(0, 0);
        SectionView sectionView = (SectionView) _$_findCachedViewById(R.id.sectionFavoriteMiniPrograms);
        if (sectionView != null) {
            Intrinsics.checkNotNullExpressionValue(sectionView, "");
            sectionView.setVisibility((favoriteMiniPrograms.isEmpty() ^ true) && !this.BuiltInFictitiousFunctionClassFactory ? 0 : 8);
        }
    }

    @Override // id.dana.miniprogram.di.MiniProgramContract.View
    public final void onLoadRecentMiniPrograms(List<MiniProgram> recentMiniPrograms) {
        Intrinsics.checkNotNullParameter(recentMiniPrograms, "");
        GridMiniProgramAdapter gridMiniProgramAdapter = this.lookAheadTest;
        if (gridMiniProgramAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            gridMiniProgramAdapter = null;
        }
        gridMiniProgramAdapter.setItems(recentMiniPrograms);
        gridMiniProgramAdapter.notifyDataSetChanged();
        ((NestedScrollView) _$_findCachedViewById(R.id.judgeRes)).smoothScrollTo(0, 0);
        SectionView sectionView = (SectionView) _$_findCachedViewById(R.id.sectionRecentMiniPrograms);
        if (sectionView != null) {
            Intrinsics.checkNotNullExpressionValue(sectionView, "");
            sectionView.setVisibility((recentMiniPrograms.isEmpty() ^ true) && !this.BuiltInFictitiousFunctionClassFactory ? 0 : 8);
        }
    }

    @Override // id.dana.miniprogram.di.MiniProgramContract.View
    public final void onSetFavoriteMiniPrograms(String appId, boolean isFavorite) {
        Object obj;
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(appId, "");
        Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.contains$default((CharSequence) ((MiniProgram) obj).getAppId(), (CharSequence) appId, false, 2, (Object) null)) {
                break;
            }
        }
        MiniProgram miniProgram = (MiniProgram) obj;
        if (miniProgram != null) {
            miniProgram.setFavorite(isFavorite);
        }
        MiniProgramPresenter presenter = getPresenter();
        List<MiniProgram> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(list, "");
        CoroutineScope coroutineScope2 = presenter.getAuthRequestContext;
        if (coroutineScope2 != null) {
            coroutineScope = coroutineScope2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            coroutineScope = null;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MiniProgramPresenter$getFavoriteMiniPrograms$1(list, presenter, null), 3, null);
    }

    @Override // id.dana.miniprogram.di.MiniProgramContract.View
    public final void onSetRecentMiniProgram(String appId, long lastOpen) {
        Object obj;
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(appId, "");
        Iterator<T> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.contains$default((CharSequence) ((MiniProgram) obj).getAppId(), (CharSequence) appId, false, 2, (Object) null)) {
                break;
            }
        }
        MiniProgram miniProgram = (MiniProgram) obj;
        if (miniProgram != null) {
            miniProgram.setLastOpen(lastOpen);
        }
        MiniProgramPresenter presenter = getPresenter();
        List<MiniProgram> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(list, "");
        CoroutineScope coroutineScope2 = presenter.getAuthRequestContext;
        if (coroutineScope2 != null) {
            coroutineScope = coroutineScope2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            coroutineScope = null;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MiniProgramPresenter$getRecentMiniPrograms$1(list, presenter, null), 3, null);
    }

    @Override // id.dana.miniprogram.di.MiniProgramContract.View
    public final void onFavoriteLimitExceeded(String appId) {
        Intrinsics.checkNotNullParameter(appId, "");
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        String string = getString(R.string.mp_maximum_favorite_items);
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToast.MyBillsEntityDataFactory(this, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_red_border, string);
        BuildersKt__Builders_commonKt.launch$default(this.getAuthRequestContext, null, null, new MiniProgramStoreActivity$onFavoriteLimitExceeded$1(this, appId, null), 3, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        byte b = 0;
        ((SectionView) _$_findCachedViewById(R.id.res_0x7f0a11f8_getenableexpresspayinfo_lambda_21)).setTitleVisibility(false);
        SectionView sectionView = (SectionView) _$_findCachedViewById(R.id.sectionFavoriteMiniPrograms);
        Intrinsics.checkNotNullExpressionValue(sectionView, "");
        sectionView.setVisibility(8);
        SectionView sectionView2 = (SectionView) _$_findCachedViewById(R.id.sectionRecentMiniPrograms);
        Intrinsics.checkNotNullExpressionValue(sectionView2, "");
        sectionView2.setVisibility(8);
        SkeletonScreen skeletonScreen = this.moveToNextValue;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((RecyclerView) ((SectionView) _$_findCachedViewById(R.id.res_0x7f0a11f8_getenableexpresspayinfo_lambda_21))._$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator));
        AllMiniProgramsAdapter allMiniProgramsAdapter = this.MyBillsEntityDataFactory;
        if (allMiniProgramsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            allMiniProgramsAdapter = null;
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = allMiniProgramsAdapter;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_mini_program_skeleton;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 10;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f23952131099990);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        this.moveToNextValue = recyclerViewSkeletonScreen;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        ((SectionView) _$_findCachedViewById(R.id.res_0x7f0a11f8_getenableexpresspayinfo_lambda_21)).setTitleVisibility(true);
        SectionView sectionView = (SectionView) _$_findCachedViewById(R.id.sectionFavoriteMiniPrograms);
        Intrinsics.checkNotNullExpressionValue(sectionView, "");
        sectionView.setVisibility(0);
        SectionView sectionView2 = (SectionView) _$_findCachedViewById(R.id.sectionRecentMiniPrograms);
        Intrinsics.checkNotNullExpressionValue(sectionView2, "");
        sectionView2.setVisibility(0);
        SkeletonScreen skeletonScreen = this.moveToNextValue;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        PlaceComponentResult(PageState.MINI_PROGRAM_ERROR);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        Job.DefaultImpls.cancel$default(this.NetworkUserEntityData$$ExternalSyntheticLambda0, null, 1, null);
        DanaH5.dispose();
        super.onDestroy();
    }

    public static /* synthetic */ void $r8$lambda$Bez_aCDQLbFb5SSKMzrOh0HCCTc(MiniProgramStoreActivity miniProgramStoreActivity, View view) {
        Intrinsics.checkNotNullParameter(miniProgramStoreActivity, "");
        miniProgramStoreActivity.finish();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [id.dana.contract.services.ServicesContract$View, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final /* synthetic */ void access$initInjector(MiniProgramStoreActivity miniProgramStoreActivity) {
        DaggerMiniProgramComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMiniProgramComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(miniProgramStoreActivity.getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (MiniProgramModule) Preconditions.getAuthRequestContext(new MiniProgramModule(miniProgramStoreActivity));
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        MiniProgramStoreActivity miniProgramStoreActivity2 = miniProgramStoreActivity;
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = miniProgramStoreActivity2;
        byte b = 0;
        Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = miniProgramStoreActivity2;
        Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = miniProgramStoreActivity2;
        Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = miniProgramStoreActivity2;
        Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = miniProgramStoreActivity2;
        Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        ?? r3 = 0;
        Preconditions.getAuthRequestContext(new ServicesModule(r3, 1, r3));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, MiniProgramModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerMiniProgramComponent.MiniProgramComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, b).KClassImpl$Data$declaredNonStaticMembers$2(miniProgramStoreActivity);
        miniProgramStoreActivity.registerPresenter(miniProgramStoreActivity.getPresenter());
    }

    public static final /* synthetic */ void access$initView(final MiniProgramStoreActivity miniProgramStoreActivity) {
        miniProgramStoreActivity.setCenterTitle(miniProgramStoreActivity.getString(R.string.mp_store_title));
        miniProgramStoreActivity.setMenuLeftButton(R.drawable.btn_arrow_left);
        ((DanaButtonSecondaryView) miniProgramStoreActivity._$_findCachedViewById(R.id.res_0x7f0a012f_networkuserentitydata_externalsyntheticlambda6)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.MiniProgramStoreActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniProgramStoreActivity.$r8$lambda$Bez_aCDQLbFb5SSKMzrOh0HCCTc(MiniProgramStoreActivity.this, view);
            }
        });
        SectionView sectionView = (SectionView) miniProgramStoreActivity._$_findCachedViewById(R.id.res_0x7f0a11f8_getenableexpresspayinfo_lambda_21);
        sectionView.setSectionTitle(miniProgramStoreActivity.getText(R.string.mp_all_mini_programs));
        AllMiniProgramsAdapter allMiniProgramsAdapter = new AllMiniProgramsAdapter();
        miniProgramStoreActivity.MyBillsEntityDataFactory = allMiniProgramsAdapter;
        sectionView.setupLinearRecyclerView(allMiniProgramsAdapter);
        SectionView sectionView2 = (SectionView) miniProgramStoreActivity._$_findCachedViewById(R.id.sectionFavoriteMiniPrograms);
        sectionView2.setSectionTitle(miniProgramStoreActivity.getText(R.string.favorites));
        GridMiniProgramAdapter gridMiniProgramAdapter = new GridMiniProgramAdapter();
        miniProgramStoreActivity.PlaceComponentResult = gridMiniProgramAdapter;
        sectionView2.setupGridRecyclerView(gridMiniProgramAdapter);
        SectionView sectionView3 = (SectionView) miniProgramStoreActivity._$_findCachedViewById(R.id.sectionRecentMiniPrograms);
        sectionView3.setSectionTitle(miniProgramStoreActivity.getText(R.string.mp_recently_open_mini_program));
        GridMiniProgramAdapter gridMiniProgramAdapter2 = new GridMiniProgramAdapter();
        miniProgramStoreActivity.lookAheadTest = gridMiniProgramAdapter2;
        sectionView3.setupGridRecyclerView(gridMiniProgramAdapter2);
    }

    public static final /* synthetic */ void access$setupSearchView(final MiniProgramStoreActivity miniProgramStoreActivity) {
        ((SearchView) miniProgramStoreActivity._$_findCachedViewById(R.id.ReflectKotlinClassFinderKt)).setSearchHint(miniProgramStoreActivity.getString(R.string.mp_find_favorite_mini_program));
        EditText editText = ((SearchView) miniProgramStoreActivity._$_findCachedViewById(R.id.ReflectKotlinClassFinderKt)).getEditText();
        Intrinsics.checkNotNullExpressionValue(editText, "");
        editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.miniprogram.MiniProgramStoreActivity$setupSearchView$$inlined$onTextAfterChanged$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
                AllMiniProgramsAdapter allMiniProgramsAdapter;
                List list;
                boolean z;
                MiniProgramStoreActivity.PageState pageState;
                List list2;
                AllMiniProgramsAdapter allMiniProgramsAdapter2 = null;
                String obj = p0 != null ? p0.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                allMiniProgramsAdapter = MiniProgramStoreActivity.this.MyBillsEntityDataFactory;
                if (allMiniProgramsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    allMiniProgramsAdapter2 = allMiniProgramsAdapter;
                }
                String obj2 = StringsKt.trim((CharSequence) obj).toString();
                MiniProgramStoreActivity miniProgramStoreActivity2 = MiniProgramStoreActivity.this;
                if (obj2.length() < 3) {
                    list = MiniProgramStoreActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    allMiniProgramsAdapter2.setItems(list);
                    z = false;
                } else {
                    MiniProgramStoreActivity miniProgramStoreActivity3 = MiniProgramStoreActivity.this;
                    list2 = miniProgramStoreActivity3.KClassImpl$Data$declaredNonStaticMembers$2;
                    allMiniProgramsAdapter2.setItems(MiniProgramStoreActivity.access$toFilterBySearch(miniProgramStoreActivity3, list2, obj2));
                    z = true;
                }
                miniProgramStoreActivity2.BuiltInFictitiousFunctionClassFactory = z;
                allMiniProgramsAdapter2.notifyDataSetChanged();
                MiniProgramStoreActivity miniProgramStoreActivity4 = MiniProgramStoreActivity.this;
                if (allMiniProgramsAdapter2.getItems().isEmpty()) {
                    pageState = MiniProgramStoreActivity.PageState.DISPLAYING_EMPTY_SEARCH_RESULT;
                } else {
                    pageState = MiniProgramStoreActivity.PageState.SUCCESS;
                }
                miniProgramStoreActivity4.PlaceComponentResult(pageState);
            }
        });
    }

    public static final /* synthetic */ List access$toFilterBySearch(MiniProgramStoreActivity miniProgramStoreActivity, List list, String str) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (StringsKt.contains((CharSequence) ((MiniProgram) obj).getTitle(), (CharSequence) str, true)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.sortedWith(arrayList, ComparisonsKt.compareBy(new Function1<MiniProgram, Comparable<?>>() { // from class: id.dana.miniprogram.MiniProgramStoreActivity$toFilterBySearch$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(MiniProgram miniProgram) {
                Intrinsics.checkNotNullParameter(miniProgram, "");
                return Boolean.valueOf(!miniProgram.isFavorite());
            }
        }, new Function1<MiniProgram, Comparable<?>>() { // from class: id.dana.miniprogram.MiniProgramStoreActivity$toFilterBySearch$3
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(MiniProgram miniProgram) {
                Intrinsics.checkNotNullParameter(miniProgram, "");
                return miniProgram.getTitle();
            }
        }));
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ 4360990799332652212L)) ^ ((int) (newProxyInstance ^ 4360990799332652212L))) ^ ((char) (PrepareContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
