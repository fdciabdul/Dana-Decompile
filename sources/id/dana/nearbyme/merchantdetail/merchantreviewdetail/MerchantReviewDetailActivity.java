package id.dana.nearbyme.merchantdetail.merchantreviewdetail;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantDetailReviewComponent;
import id.dana.di.modules.MerchantDetailReviewModule;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLatestReviewAdapter;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewResultModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import id.dana.nearbyme.model.ShopModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.ShimmeringUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0007¢\u0006\u0004\b@\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0005R\u0013\u0010%\u001a\u00020\"X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u000e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0013\u0010+\u001a\u00020\u0015X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010(\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u0010&\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantreviewdetail/MerchantReviewDetailActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;", "", "configToolbar", "()V", "dismissProgress", "", "getLayout", "()I", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", IAPSyncCommand.COMMAND_INIT, "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/recyclerview/widget/LinearLayoutManager;)Z", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewResultModel;", "merchantReviewsModel", "onSuccessGetReviewList", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewResultModel;)V", "onSuccessLoadMoreReview", "p1", "getAuthRequestContext", "(II)Z", "showProgress", "Lid/dana/nearbyme/model/ShopModel;", "lookAheadTest", "Lkotlin/Lazy;", "PlaceComponentResult", "getErrorConfigVersion", "Z", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewAdapter;", "initRecordTimeStamp", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewAdapter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "reviewPresenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "getReviewPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "setReviewPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "DatabaseTableConfigUtil", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "tracker", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "getTracker", "()Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "setTracker", "(Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewDetailActivity extends BaseActivity implements MerchantDetailReviewContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String EXTRA_SHOP_MODEL = "EXTRA_SHOP_MODEL";
    public static final String EXTRA_SOURCE = "EXTRA_SOURCE";
    public static final int FIRST_POSITION = 0;
    private static char GetContactSyncConfig = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda8 = 0;
    public static final int PAGE_SIZE = 10;
    private static char isLayoutRequested;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private SkeletonScreen getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MerchantLatestReviewAdapter scheduleImpl;
    @Inject
    public MerchantDetailReviewContract.Presenter reviewPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public MerchantDetailAnalyticTracker tracker;
    public static final byte[] $$a = {108, -22, 67, 3, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 175;
    public static final byte[] PlaceComponentResult = {22, 66, -65, -82, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 6;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<ShopModel>() { // from class: id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity$currentShopModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ShopModel invoke() {
            Bundle extras;
            Intent intent = MerchantReviewDetailActivity.this.getIntent();
            ShopModel shopModel = (intent == null || (extras = intent.getExtras()) == null) ? null : (ShopModel) extras.getParcelable("EXTRA_SHOP_MODEL");
            ShopModel shopModel2 = shopModel instanceof ShopModel ? shopModel : null;
            return shopModel2 == null ? new ShopModel() : shopModel2;
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<String>() { // from class: id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity$pageSource$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle extras = MerchantReviewDetailActivity.this.getIntent().getExtras();
            String string = extras != null ? extras.getString("EXTRA_SOURCE") : null;
            return string == null ? "" : string;
        }
    });

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        GetContactSyncConfig = (char) 57330;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 25396;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = (char) 42252;
        isLayoutRequested = (char) 29406;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity.PlaceComponentResult
            int r7 = r7 + 16
            int r6 = 56 - r6
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r8
            r4 = 0
            r8 = r7
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-4)
            int r6 = r6 + 1
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity.b(int, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r7 = 46 - r7
            byte[] r0 = id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2e
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            int r7 = r7 + 1
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity.c(int, byte, byte, java.lang.Object[]):void");
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
        a(19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{2367, 61334, 58947, 65286, 12763, 46921, 21333, 17333, 46920, 19259, 49093, 60033, 14438, 53457, 61399, 25967, 55333, 45992}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(5 - (Process.myPid() >> 22), new char[]{7274, 3281, 5495, 50424, 9379, 54691}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(Gravity.getAbsoluteGravity(0, 0) + 48, new char[]{3188, 37641, 16693, 18193, 57930, 32589, 48139, 5085, 22206, 47034, 16767, 1374, 50702, 6513, 8198, 10666, 14286, 34262, 4715, 39642, 3460, 31546, 16969, 55841, 42543, 14114, 24092, 13206, 6064, 11080, 22587, 14734, 938, 31267, 64172, 63344, 11535, 62492, 55877, 63262, 12990, 43792, 11433, 15913, 11585, 62799, 57348, 46807}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(Color.alpha(0) + 64, new char[]{26103, 23584, 34403, 35435, 11535, 62492, 47550, 41193, 3460, 31546, 16223, 11053, 22415, 62215, 23481, 45174, 35520, 576, 52481, 26351, 22415, 62215, 57898, 58353, 2953, 20342, 58577, 63721, 24092, 13206, 35520, 576, 6936, 20993, 9216, 56026, 64938, 38650, 60996, 49527, 26027, 20675, 31553, 54579, 17488, 37233, 32270, Typography.tm, 1787, 45289, 39118, 46876, 10701, 15286, 28038, 8569, 28038, 8569, 21820, 37770, 50744, 8840, 42543, 14114}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - TextUtils.getTrimmedLength(""), new char[]{5876, 29710, 35302, 57719, 10701, 15286, 21926, 62492, 63069, 40291, 18431, 57138, 22956, 6590, 43393, 28719, 22587, 14734, 20264, 27728, 11154, 54753, 15743, 24486, 12990, 43792, 48139, 5085, 1582, 10391, 3188, 37641, 31088, 10825, 56676, 14413, 49340, 18812, 16693, 18193, 26724, 36272, 23481, 45174, 55877, 63262, 49096, 42920, 11535, 62492, 61399, 25967, 5876, 29710, 28308, 12010, 30721, 17132, 938, 31267, 28308, 12010, 15732, 4530}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - TextUtils.getOffsetAfter("", 0), new char[]{59943, 59674, 30168, 36659, 11903, 26524, 31307, 22402, 48413, 39525, 6071, 788, 20215, 303, 48541, 57600, 45905, 59994, 37502, 61495, 6161, 53551, 41532, 34343, 39677, 23817, 24910, 53460, 63392, 6864, 4899, 36225, 24910, 53460, 18280, 12969, 60810, 22003, 41155, 32414, 31033, 55021, 41456, 63322, 55064, 51916, 56042, 16854, 62239, 58147, 5535, 4016, 1288, 46089, 396, 18895, 30180, 33107, 49075, 19438}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.rgb(0, 0, 0) + 16777222, new char[]{20324, 30590, 1101, 48608, 5876, 29710}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (-PlaceComponentResult[31]);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (getAuthRequestContext | 24), PlaceComponentResult[25], PlaceComponentResult[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], (byte) (-$$a[53]), (byte) (-$$a[12]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0, 0), '?' - AndroidCharacter.getMirror('0'), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 14 - MotionEvent.axisFromString(""), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - KeyEvent.keyCodeFromString(""), ImageFormat.getBitsPerPixel(0) + 30, (char) (57994 - (ViewConfiguration.getPressedStateDuration() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 15, (char) ExpandableListView.getPackedPositionGroup(0L)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r8 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1468803975, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - View.MeasureSpec.getMode(0), (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = {this};
                byte b3 = (byte) (-PlaceComponentResult[31]);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                b(b3, b4, b4, objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                b((byte) (getAuthRequestContext | 24), PlaceComponentResult[25], PlaceComponentResult[9], objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 62, 46 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) KeyEvent.getDeadChar(0, 0));
                        Object[] objArr23 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[20], (byte) ($$a[47] - 1), objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {-1468803975, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = {this};
                byte b5 = (byte) (-PlaceComponentResult[31]);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr27 = new Object[1];
                b(b5, b6, b6, objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b((byte) (getAuthRequestContext | 24), PlaceComponentResult[25], PlaceComponentResult[9], objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 4, (char) (Drawable.resolveOpacity(0, 0) + 38968));
                        Object[] objArr30 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[20], (byte) ($$a[47] - 1), objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myPid() >> 22) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {-1468803975, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
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
                Object[] objArr33 = {this};
                byte b7 = (byte) (-PlaceComponentResult[31]);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr34 = new Object[1];
                b(b7, b8, b8, objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                b((byte) (getAuthRequestContext | 24), PlaceComponentResult[25], PlaceComponentResult[9], objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), Gravity.getAbsoluteGravity(0, 0) + 3, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr37 = new Object[1];
                        c((byte) (-$$a[8]), (byte) ($$a[47] - 1), (byte) (-$$a[9]), objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {-1468803975, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
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
        return R.layout.activity_merchant_review_detail;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(R.string.family_status_invited_canceled_description).substring(3, 4).length() + 17, new char[]{2367, 61334, 58947, 65286, 12763, 46921, 21333, 17333, 46920, 19259, 49093, 60033, 14438, 53457, 61399, 25967, 55333, 45992}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(getPackageName().length() - 2, new char[]{7274, 3281, 5495, 50424, 9379, 54691}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(super.getResources().getString(R.string.msg_payment_authentication_failed).substring(27, 28).length() + 25, new char[]{2367, 61334, 58947, 65286, 12763, 46921, 21333, 17333, 31033, 55021, 21903, 5781, 52605, 51850, 17056, 50745, 14564, 50689, 54106, 35958, 38318, 53378, 35191, 49951, 8466, 54445}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(super.getResources().getString(R.string.tap_to_refresh).substring(0, 4).length() + 14, new char[]{55834, 44892, 24687, 29056, 30180, 33107, 32407, 22853, 55402, 1634, 24841, 18939, 42381, 36198, 17056, 50745, 4135, 5270}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0') + 36, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a(47 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{3188, 37641, 16693, 18193, 57930, 32589, 48139, 5085, 22206, 47034, 16767, 1374, 50702, 6513, 8198, 10666, 14286, 34262, 4715, 39642, 3460, 31546, 16969, 55841, 42543, 14114, 24092, 13206, 6064, 11080, 22587, 14734, 938, 31267, 64172, 63344, 11535, 62492, 55877, 63262, 12990, 43792, 11433, 15913, 11585, 62799, 57348, 46807}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(super.getResources().getString(R.string.error_global_transfer_init_desc).substring(1, 2).length() + 63, new char[]{26103, 23584, 34403, 35435, 11535, 62492, 47550, 41193, 3460, 31546, 16223, 11053, 22415, 62215, 23481, 45174, 35520, 576, 52481, 26351, 22415, 62215, 57898, 58353, 2953, 20342, 58577, 63721, 24092, 13206, 35520, 576, 6936, 20993, 9216, 56026, 64938, 38650, 60996, 49527, 26027, 20675, 31553, 54579, 17488, 37233, 32270, Typography.tm, 1787, 45289, 39118, 46876, 10701, 15286, 28038, 8569, 28038, 8569, 21820, 37770, 50744, 8840, 42543, 14114}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(getPackageName().length() + 57, new char[]{5876, 29710, 35302, 57719, 10701, 15286, 21926, 62492, 63069, 40291, 18431, 57138, 22956, 6590, 43393, 28719, 22587, 14734, 20264, 27728, 11154, 54753, 15743, 24486, 12990, 43792, 48139, 5085, 1582, 10391, 3188, 37641, 31088, 10825, 56676, 14413, 49340, 18812, 16693, 18193, 26724, 36272, 23481, 45174, 55877, 63262, 49096, 42920, 11535, 62492, 61399, 25967, 5876, 29710, 28308, 12010, 30721, 17132, 938, 31267, 28308, 12010, 15732, 4530}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((Process.myPid() >> 22) + 60, new char[]{59943, 59674, 30168, 36659, 11903, 26524, 31307, 22402, 48413, 39525, 6071, 788, 20215, 303, 48541, 57600, 45905, 59994, 37502, 61495, 6161, 53551, 41532, 34343, 39677, 23817, 24910, 53460, 63392, 6864, 4899, 36225, 24910, 53460, 18280, 12969, 60810, 22003, 41155, 32414, 31033, 55021, 41456, 63322, 55064, 51916, 56042, 16854, 62239, 58147, 5535, 4016, 1288, 46089, 396, 18895, 30180, 33107, 49075, 19438}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(super.getResources().getString(R.string.mybills_detail_label_family_member_number).substring(1, 3).length() + 4, new char[]{20324, 30590, 1101, 48608, 5876, 29710}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (-PlaceComponentResult[31]);
            byte b2 = PlaceComponentResult[25];
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            Object[] objArr13 = new Object[1];
            b((byte) (getAuthRequestContext | 24), PlaceComponentResult[25], PlaceComponentResult[9], objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 494, 3 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                    Object[] objArr15 = new Object[1];
                    c((byte) (-$$a[8]), (byte) ($$a[47] - 1), (byte) (-$$a[9]), objArr15);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "") + 35, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1535477818, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, Color.alpha(0) + 18, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.referral_learn_how).substring(1, 2).length() + 25, new char[]{2367, 61334, 58947, 65286, 12763, 46921, 21333, 17333, 31033, 55021, 21903, 5781, 52605, 51850, 17056, 50745, 14564, 50689, 54106, 35958, 38318, 53378, 35191, 49951, 8466, 54445}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().codePointAt(1) - 82, new char[]{55834, 44892, 24687, 29056, 30180, 33107, 32407, 22853, 55402, 1634, 24841, 18939, 42381, 36198, 17056, 50745, 4135, 5270}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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
                b((byte) (PlaceComponentResult[49] - 1), PlaceComponentResult[30], (byte) (-PlaceComponentResult[32]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(PlaceComponentResult[25], PlaceComponentResult[8], PlaceComponentResult[48], new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{2367, 61334, 58947, 65286, 12763, 46921, 21333, 17333, 31033, 55021, 21903, 5781, 52605, 51850, 17056, 50745, 14564, 50689, 54106, 35958, 38318, 53378, 35191, 49951, 8466, 54445}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a(18 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{55834, 44892, 24687, 29056, 30180, 33107, 32407, 22853, 55402, 1634, 24841, 18939, 42381, 36198, 17056, 50745, 4135, 5270}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getLongPressTimeout() >> 16) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getTracker")
    public final MerchantDetailAnalyticTracker getTracker() {
        MerchantDetailAnalyticTracker merchantDetailAnalyticTracker = this.tracker;
        if (merchantDetailAnalyticTracker != null) {
            return merchantDetailAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTracker")
    public final void setTracker(MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        Intrinsics.checkNotNullParameter(merchantDetailAnalyticTracker, "");
        this.tracker = merchantDetailAnalyticTracker;
    }

    @JvmName(name = "getReviewPresenter")
    public final MerchantDetailReviewContract.Presenter getReviewPresenter() {
        MerchantDetailReviewContract.Presenter presenter = this.reviewPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReviewPresenter")
    public final void setReviewPresenter(MerchantDetailReviewContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.reviewPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setMenuLeftButton(R.drawable.btn_arrow_left);
        setCenterTitle(getResources().getString(R.string.merchant_rating_title));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getAuthRequestContext(int p0, int p1) {
        return this.BuiltInFictitiousFunctionClassFactory && !this.KClassImpl$Data$declaredNonStaticMembers$2 && !this.getAuthRequestContext && p0 <= p1 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean BuiltInFictitiousFunctionClassFactory(LinearLayoutManager p0) {
        return p0.findFirstCompletelyVisibleItemPosition() == 0;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.View
    public final void onSuccessGetReviewList(MerchantReviewResultModel merchantReviewsModel) {
        Intrinsics.checkNotNullParameter(merchantReviewsModel, "");
        dismissProgress();
        MerchantLatestReviewAdapter merchantLatestReviewAdapter = this.scheduleImpl;
        if (merchantLatestReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewAdapter = null;
        }
        merchantLatestReviewAdapter.appendItems(KClassImpl$Data$declaredNonStaticMembers$2(merchantReviewsModel.BuiltInFictitiousFunctionClassFactory));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.BuiltInFictitiousFunctionClassFactory = merchantReviewsModel.getPlaceComponentResult();
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.View
    public final void onSuccessLoadMoreReview(MerchantReviewResultModel merchantReviewsModel) {
        Intrinsics.checkNotNullParameter(merchantReviewsModel, "");
        MerchantLatestReviewAdapter merchantLatestReviewAdapter = this.scheduleImpl;
        MerchantLatestReviewAdapter merchantLatestReviewAdapter2 = null;
        if (merchantLatestReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewAdapter = null;
        }
        merchantLatestReviewAdapter.PlaceComponentResult(false);
        MerchantLatestReviewAdapter merchantLatestReviewAdapter3 = this.scheduleImpl;
        if (merchantLatestReviewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantLatestReviewAdapter2 = merchantLatestReviewAdapter3;
        }
        merchantLatestReviewAdapter2.appendItems(KClassImpl$Data$declaredNonStaticMembers$2(merchantReviewsModel.BuiltInFictitiousFunctionClassFactory));
        this.BuiltInFictitiousFunctionClassFactory = merchantReviewsModel.getPlaceComponentResult();
        this.getAuthRequestContext = false;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        this.BuiltInFictitiousFunctionClassFactory = true;
        MerchantLatestReviewAdapter merchantLatestReviewAdapter = this.scheduleImpl;
        if (merchantLatestReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewAdapter = null;
        }
        merchantLatestReviewAdapter.PlaceComponentResult(false);
        this.getAuthRequestContext = false;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        this.getErrorConfigVersion = ShimmeringUtil.PlaceComponentResult((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a118b_danapolycardsviewmodel_getallrewardlist_1), R.layout.view_skeleton_merchant_latest_view);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        SkeletonScreen skeletonScreen = this.getErrorConfigVersion;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    private static List<MerchantReviewViewModel> KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantReviewModel> p0) {
        List<MerchantReviewModel> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (MerchantReviewModel merchantReviewModel : list) {
            MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
            arrayList.add(MerchantReviewModel.Companion.BuiltInFictitiousFunctionClassFactory(merchantReviewModel));
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantreviewdetail/MerchantReviewDetailActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Lid/dana/nearbyme/model/ShopModel;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;Lid/dana/nearbyme/model/ShopModel;)V", "EXTRA_SHOP_MODEL", "Ljava/lang/String;", "EXTRA_SOURCE", "", "FIRST_POSITION", "I", "PAGE_SIZE", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1, ShopModel p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent putExtra = new Intent(p0, MerchantReviewDetailActivity.class).putExtra("EXTRA_SOURCE", p1).putExtra("EXTRA_SHOP_MODEL", p2);
            Intrinsics.checkNotNullExpressionValue(putExtra, "");
            p0.startActivity(putExtra);
        }
    }

    /* renamed from: $r8$lambda$ToCGyPi3ZTM-hjn5WY76puyNv5c  reason: not valid java name */
    public static /* synthetic */ void m2732$r8$lambda$ToCGyPi3ZTMhjn5WY76puyNv5c(MerchantReviewDetailActivity merchantReviewDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantReviewDetailActivity, "");
        ((RecyclerView) merchantReviewDetailActivity._$_findCachedViewById(R.id.res_0x7f0a118b_danapolycardsviewmodel_getallrewardlist_1)).smoothScrollToPosition(0);
    }

    public static final /* synthetic */ ShopModel access$getCurrentShopModel(MerchantReviewDetailActivity merchantReviewDetailActivity) {
        return (ShopModel) merchantReviewDetailActivity.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ void access$getLoadMoreLogic(MerchantReviewDetailActivity merchantReviewDetailActivity) {
        merchantReviewDetailActivity.getAuthRequestContext = true;
        MerchantLatestReviewAdapter merchantLatestReviewAdapter = merchantReviewDetailActivity.scheduleImpl;
        if (merchantLatestReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewAdapter = null;
        }
        merchantLatestReviewAdapter.PlaceComponentResult(true);
        MerchantDetailReviewContract.Presenter reviewPresenter = merchantReviewDetailActivity.getReviewPresenter();
        String str = ((ShopModel) merchantReviewDetailActivity.PlaceComponentResult.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str2 = ((ShopModel) merchantReviewDetailActivity.PlaceComponentResult.getValue()).BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        reviewPresenter.PlaceComponentResult(str, str2);
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerMerchantDetailReviewComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMerchantDetailReviewComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (MerchantDetailReviewModule) Preconditions.getAuthRequestContext(new MerchantDetailReviewModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, MerchantDetailReviewModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerMerchantDetailReviewComponent.MerchantDetailReviewComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        MerchantDetailAnalyticTracker tracker = getTracker();
        String str = (String) this.MyBillsEntityDataFactory.getValue();
        String str2 = ((ShopModel) this.PlaceComponentResult.getValue()).getAuthRequestContext;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = ((ShopModel) this.PlaceComponentResult.getValue()).newProxyInstance;
        if (str3 == null) {
            str3 = "";
        }
        String authRequestContext = ((ShopModel) this.PlaceComponentResult.getValue()).getAuthRequestContext(true, " ");
        if (authRequestContext == null) {
            authRequestContext = "";
        }
        tracker.PlaceComponentResult(str, str2, str3, authRequestContext);
        this.scheduleImpl = new MerchantLatestReviewAdapter((ShopModel) this.PlaceComponentResult.getValue(), new Function1<MediaViewerModel, Unit>() { // from class: id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity$initRecycleView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MediaViewerModel mediaViewerModel) {
                invoke2(mediaViewerModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MediaViewerModel mediaViewerModel) {
                Intrinsics.checkNotNullParameter(mediaViewerModel, "");
                String str4 = MerchantReviewDetailActivity.access$getCurrentShopModel(MerchantReviewDetailActivity.this).newProxyInstance;
                Intrinsics.checkNotNullExpressionValue(str4, "");
                String str5 = MerchantReviewDetailActivity.access$getCurrentShopModel(MerchantReviewDetailActivity.this).NetworkUserEntityData$$ExternalSyntheticLambda3;
                Intrinsics.checkNotNullExpressionValue(str5, "");
                MerchantPhotoViewerModel merchantPhotoViewerModel = new MerchantPhotoViewerModel(str4, str5, mediaViewerModel);
                MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
                FragmentManager supportFragmentManager = MerchantReviewDetailActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, merchantPhotoViewerModel);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a118b_danapolycardsviewmodel_getallrewardlist_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        MerchantLatestReviewAdapter merchantLatestReviewAdapter = this.scheduleImpl;
        if (merchantLatestReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewAdapter = null;
        }
        recyclerView.setAdapter(merchantLatestReviewAdapter);
        ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a118b_danapolycardsviewmodel_getallrewardlist_1)).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity$onRvReviewScrolled$1

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            public LinearLayoutManager getAuthRequestContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) MerchantReviewDetailActivity.this._$_findCachedViewById(R.id.res_0x7f0a118b_danapolycardsviewmodel_getallrewardlist_1)).getLayoutManager();
                if (layoutManager == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
                this.getAuthRequestContext = (LinearLayoutManager) layoutManager;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                boolean BuiltInFictitiousFunctionClassFactory;
                boolean authRequestContext2;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                MerchantReviewDetailActivity merchantReviewDetailActivity = MerchantReviewDetailActivity.this;
                BuiltInFictitiousFunctionClassFactory = MerchantReviewDetailActivity.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
                MerchantReviewDetailActivity merchantReviewDetailActivity2 = MerchantReviewDetailActivity.this;
                boolean z = p2 < 0 && !BuiltInFictitiousFunctionClassFactory;
                ((CardView) merchantReviewDetailActivity2._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572)).setVisibility(r2 ? 0 : 8);
                authRequestContext2 = MerchantReviewDetailActivity.this.getAuthRequestContext(this.getAuthRequestContext.getItemCount(), this.getAuthRequestContext.findLastVisibleItemPosition());
                if (authRequestContext2) {
                    MerchantReviewDetailActivity.access$getLoadMoreLogic(MerchantReviewDetailActivity.this);
                }
            }
        });
        ((CardView) _$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantReviewDetailActivity.m2732$r8$lambda$ToCGyPi3ZTMhjn5WY76puyNv5c(MerchantReviewDetailActivity.this, view);
            }
        });
        MerchantAverageRatingView merchantAverageRatingView = (MerchantAverageRatingView) _$_findCachedViewById(R.id.merchant_average_rating);
        if (merchantAverageRatingView != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            merchantAverageRatingView.loadAverageRating(supportFragmentManager, (ShopModel) this.PlaceComponentResult.getValue(), true, false);
        }
        showProgress();
        MerchantDetailReviewContract.Presenter reviewPresenter = getReviewPresenter();
        String str4 = ((ShopModel) this.PlaceComponentResult.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(str4, "");
        String str5 = ((ShopModel) this.PlaceComponentResult.getValue()).BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(str5, "");
        reviewPresenter.PlaceComponentResult(str4, str5);
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (isLayoutRequested ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda8 ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (GetContactSyncConfig ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
