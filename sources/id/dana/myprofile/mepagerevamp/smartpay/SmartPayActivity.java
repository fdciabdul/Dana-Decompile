package id.dana.myprofile.mepagerevamp.smartpay;

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
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract;
import id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationModule;
import id.dana.danah5.DanaH5;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.LoadingDialog;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.mapper.SettingModelMapper;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.mepagerevamp.MePageRevampModule;
import id.dana.myprofile.mepagerevamp.smartpay.DaggerSmartPayComponent;
import id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract;
import id.dana.myprofile.mepagerevamp.smartpay.adapter.SmartPayOnboardingAdapter;
import id.dana.myprofile.mepagerevamp.smartpay.adapter.SmartPaySettingsAdapter;
import id.dana.myprofile.mepagerevamp.smartpay.viewholder.NewProfileMenuAutoSwitchViewHolder;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.SectionShowcaseBuilder;
import id.dana.showcase.Showcase;
import id.dana.utils.ErrorUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0002`aB\u0007¢\u0006\u0004\b_\u0010\bJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0004\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0004\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u000f\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\bJ)\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\bJ)\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0014¢\u0006\u0004\b%\u0010\bJ\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\bR\u0016\u0010\u000f\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010*8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00105\u001a\u0004\u0018\u00010*8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u0016\u00108\u001a\u00020\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0013\u0010\f\u001a\u000209X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010\u0004\u001a\u00020\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u00107R$\u0010G\u001a\u0004\u0018\u00010*8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010,\u001a\u0004\bE\u0010.\"\u0004\bF\u00100R\u001a\u0010M\u001a\u00020H8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u000b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u00102\u001a\u00020\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u00107R\u0018\u0010+\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\"\u0010V\u001a\u00020U8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010(\u001a\u00020\\8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b]\u0010^"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$View;", "Landroid/view/View;", "getAuthRequestContext", "()Landroid/view/View;", "", "dismissProgress", "()V", "", "p0", "Lid/dana/domain/profilemenu/model/SettingModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/myprofile/mepagerevamp/smartpay/viewholder/NewProfileMenuAutoSwitchViewHolder;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/myprofile/mepagerevamp/smartpay/viewholder/NewProfileMenuAutoSwitchViewHolder;", "Landroid/content/Intent;", "(Landroid/content/Intent;)Ljava/lang/String;", "", "getLayout", "()I", "(Ljava/lang/String;)I", IAPSyncCommand.COMMAND_INIT, RequestPermission.REQUEST_CODE, "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "onDestroy", "", "isVisible", "isSwitchActive", "authenticationType", "onGetAutoSwitchInitialState", "(ZZLjava/lang/String;)V", "onResume", "showProgress", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getErrorConfigVersion", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayActivity$Listener;", "lookAheadTest", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayActivity$Listener;", "getAutoRouteListener", "()Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayActivity$Listener;", "setAutoRouteListener", "(Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayActivity$Listener;)V", "autoRouteListener", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getFaceAuthListener", "setFaceAuthListener", "faceAuthListener", "scheduleImpl", "Z", "PlaceComponentResult", "Lid/dana/dialog/LoadingDialog;", "GetContactSyncConfig", "Lkotlin/Lazy;", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "mePageRevampPresenter", "Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "getMePageRevampPresenter", "()Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;", "setMePageRevampPresenter", "(Lid/dana/myprofile/mepagerevamp/MePageRevampContract$Presenter;)V", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "getPaymentAuthListener", "setPaymentAuthListener", "paymentAuthListener", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "DatabaseTableConfigUtil", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "getPhonePermission", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "phonePermission", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/profilemenu/model/SettingModel;", "MyBillsEntityDataFactory", "PrepareContext", "Lid/dana/showcase/Showcase;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/showcase/Showcase;", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$Presenter;", "smartPayPresenter", "Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$Presenter;", "getSmartPayPresenter", "()Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$Presenter;", "setSmartPayPresenter", "(Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayContract$Presenter;)V", "Lid/dana/myprofile/mepagerevamp/smartpay/adapter/SmartPaySettingsAdapter;", "isLayoutRequested", "Lid/dana/myprofile/mepagerevamp/smartpay/adapter/SmartPaySettingsAdapter;", "<init>", "Companion", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SmartPayActivity extends BaseActivity implements SmartPayContract.View {
    public static final int AUTO_ROUTE_BOTTOM_SHEET_REQUEST_CODE = 2001;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final String NETWORK_EXCEPTION = "NETWORK_EXCEPTION";
    private static char NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda5 = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
    public static final String SMARTPAY_COLLECTION = "setting_collection_payment_settings";
    private static char newProxyInstance;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final ActivityPermissionRequest phonePermission;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Listener faceAuthListener;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Listener paymentAuthListener;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private SettingModel MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private Showcase lookAheadTest;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private MaterialDialog BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Listener autoRouteListener;
    @Inject
    public MePageRevampContract.Presenter mePageRevampPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    @Inject
    public SmartPayContract.Presenter smartPayPresenter;
    public static final byte[] $$a = {105, Ascii.NAK, -43, 101, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 206;
    public static final byte[] PlaceComponentResult = {16, -117, -56, -112, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 100;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final SmartPaySettingsAdapter getErrorConfigVersion = new SmartPaySettingsAdapter();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean getAuthRequestContext = true;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<LoadingDialog>() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$loadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LoadingDialog invoke() {
            return new LoadingDialog(SmartPayActivity.this);
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        newProxyInstance = (char) 32463;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = (char) 25081;
        NetworkUserEntityData$$ExternalSyntheticLambda5 = (char) 41186;
        NetworkUserEntityData$$ExternalSyntheticLambda3 = (char) 33175;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0025 -> B:35:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            int r6 = 23 - r6
            int r7 = r7 + 97
            byte[] r0 = id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.PlaceComponentResult
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L15:
            r3 = 0
        L16:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L30:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.a(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002b -> B:35:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.$$a
            int r9 = r9 * 3
            int r9 = 42 - r9
            int r7 = 47 - r7
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L33
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1c:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L33:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.c(byte, short, byte, java.lang.Object[]):void");
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
        b(Process.getGidForName("") + 19, new char[]{14700, 54008, 10060, 59757, 56780, 42054, 30244, 54273, 21412, 556, 57694, 14943, 3787, 56349, 26748, 44852, 51456, 16457}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(5 - Color.blue(0), new char[]{35917, 65111, 40255, 15516, 3282, 43560}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.getDeadChar(0, 0), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((ViewConfiguration.getEdgeSlop() >> 16) + 48, new char[]{55111, 63605, 31057, 16697, 45508, 61339, 19468, 51001, 13731, 906, 20525, 53315, 60457, 38215, 1906, 53084, 16992, 20414, 20870, 64155, 55008, 63425, 48368, 35684, 28064, 10794, 54753, 4876, 22290, 61154, 19050, 9912, 42973, 18505, 33023, 3353, 47632, 20309, 22505, 10938, 43621, 49221, 54481, 63643, 58506, 41193, 16785, 5871}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((ViewConfiguration.getTapTimeout() >> 16) + 64, new char[]{6275, 55712, 30777, 41071, 47632, 20309, 64314, 13852, 55008, 63425, 30619, 27513, 13351, 20775, 34748, 53344, 6368, 635, 29415, 19691, 13351, 20775, 33585, 41262, 59461, 50179, 52490, 2779, 54753, 4876, 6368, 635, 40878, 64612, 29936, 11522, 34235, 14525, 45971, 8519, 15794, 1091, 40884, 22654, 29500, 8559, 15503, 28704, 33544, 49556, 30195, 3148, 24492, 2608, 18004, 59451, 18004, 59451, 41521, 57655, 21098, 184, 28064, 10794}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(Process.getGidForName("") + 65, new char[]{22398, 31208, 3551, 25538, 24492, 2608, 39242, 17606, 22094, 32049, 36600, 61677, 11061, 40342, 37698, 32822, 19050, 9912, 45792, 44408, 35908, 63379, 7067, 21906, 43621, 49221, 19468, 51001, 30887, 22514, 55111, 63605, 4962, 15865, 50363, 28845, 23161, 423, 31057, 16697, 54851, 42735, 34748, 53344, 22505, 10938, 44736, 41921, 47632, 20309, 26748, 44852, 22398, 31208, 36213, 63660, 12583, 33177, 42973, 18505, 36213, 63660, 45126, 54248}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((ViewConfiguration.getKeyRepeatDelay() >> 16) + 60, new char[]{29961, 46560, 5405, 40809, 38348, 14076, 40604, 44569, 24047, 21959, 37896, 3517, 49806, 17461, 65195, 51034, 17492, 35007, 937, 25750, 41065, 32373, 11131, 1444, 22419, 29418, 9005, 62215, 5426, 57265, 44345, 17467, 9005, 62215, 64894, 5659, 53612, 19701, 23315, 39027, 28282, 30985, 6669, 15728, 48173, 62512, 41461, 19449, 5433, 27209, 3914, 36621, 63830, 44251, 44099, 19790, 12961, 22535, 55711, 63258}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(KeyEvent.keyCodeFromString("") + 6, new char[]{3170, 41376, 3059, 48175, 22398, 31208}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[30];
                byte b2 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr13 = new Object[1];
                a(b, b2, (byte) (b2 << 2), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = PlaceComponentResult[30];
                Object[] objArr14 = new Object[1];
                a(b3, (byte) (b3 + 1), 21, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 54, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3, (char) ((Process.getThreadPriority(0) + 20) >> 6));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[2]), (byte) (-$$a[12]), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 800, 15 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) Color.green(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 800, 14 - ExpandableListView.getPackedPositionChild(0L), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 29, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 57993))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 800, 14 - ExpandableListView.getPackedPositionChild(0L), (char) (MotionEvent.axisFromString("") + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r11 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1055617888, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = PlaceComponentResult[30];
                byte b5 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr19 = new Object[1];
                a(b4, b5, (byte) (b5 << 2), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = PlaceComponentResult[30];
                Object[] objArr20 = new Object[1];
                a(b6, (byte) (b6 + 1), 21, objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 62, 46 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                        Object[] objArr22 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1055617888, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, TextUtils.getTrimmedLength("") + 18, (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = PlaceComponentResult[30];
                byte b8 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr25 = new Object[1];
                a(b7, b8, (byte) (b8 << 2), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b9 = PlaceComponentResult[30];
                Object[] objArr26 = new Object[1];
                a(b9, (byte) (b9 + 1), 21, objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) (38968 - TextUtils.getOffsetBefore("", 0)));
                        Object[] objArr28 = new Object[1];
                        c($$a[20], (byte) ($$a[47] - 1), (byte) (-$$a[8]), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1055617888, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), ImageFormat.getBitsPerPixel(0) + 19, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = PlaceComponentResult[30];
                byte b11 = (byte) (-PlaceComponentResult[32]);
                Object[] objArr31 = new Object[1];
                a(b10, b11, (byte) (b11 << 2), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b12 = PlaceComponentResult[30];
                Object[] objArr32 = new Object[1];
                a(b12, (byte) (b12 + 1), 21, objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (Process.myPid() >> 22) + 3, (char) (ViewConfiguration.getTouchSlop() >> 8));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1055617888, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), 18 - Gravity.getAbsoluteGravity(0, 0), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_smart_pay;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        b(super.getResources().getString(R.string.error_visa_card_only).substring(25, 26).codePointAt(0) - 92, new char[]{14700, 54008, 10060, 59757, 56780, 42054, 30244, 54273, 21412, 556, 57694, 14943, 3787, 56349, 26748, 44852, 51456, 16457}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        b(super.getResources().getString(R.string.lbl_account_deactivation_description).substring(14, 16).codePointAt(0) - 104, new char[]{35917, 65111, 40255, 15516, 3282, 43560}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                b(getPackageName().length() + 19, new char[]{14700, 54008, 10060, 59757, 56780, 42054, 30244, 54273, 28282, 30985, 61825, 53582, 43153, 40875, 15324, 2468, 5146, 5139, 50525, 12162, 19199, 34930, 29613, 26181, 65382, 30917}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(18 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{43233, 37252, 3219, 41187, 12961, 22535, 53518, 43488, 54026, 16394, 28580, 32198, 39914, 6398, 15324, 2468, 57022, 55048}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        byte b = PlaceComponentResult[25];
                        Object[] objArr5 = new Object[1];
                        a(b, b, PlaceComponentResult[7], objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        a(PlaceComponentResult[41], PlaceComponentResult[5], (byte) (-PlaceComponentResult[59]), objArr6);
                        Object[] objArr7 = new Object[1];
                        b(((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{55111, 63605, 31057, 16697, 45508, 61339, 19468, 51001, 13731, 906, 20525, 53315, 60457, 38215, 1906, 53084, 16992, 20414, 20870, 64155, 55008, 63425, 48368, 35684, 28064, 10794, 54753, 4876, 22290, 61154, 19050, 9912, 42973, 18505, 33023, 3353, 47632, 20309, 22505, 10938, 43621, 49221, 54481, 63643, 58506, 41193, 16785, 5871}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b(64 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{6275, 55712, 30777, 41071, 47632, 20309, 64314, 13852, 55008, 63425, 30619, 27513, 13351, 20775, 34748, 53344, 6368, 635, 29415, 19691, 13351, 20775, 33585, 41262, 59461, 50179, 52490, 2779, 54753, 4876, 6368, 635, 40878, 64612, 29936, 11522, 34235, 14525, 45971, 8519, 15794, 1091, 40884, 22654, 29500, 8559, 15503, 28704, 33544, 49556, 30195, 3148, 24492, 2608, 18004, 59451, 18004, 59451, 41521, 57655, 21098, 184, 28064, 10794}, objArr8);
                        String str2 = (String) objArr8[0];
                        try {
                            byte b2 = PlaceComponentResult[25];
                            Object[] objArr9 = new Object[1];
                            a(b2, b2, PlaceComponentResult[7], objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            a(PlaceComponentResult[41], PlaceComponentResult[5], (byte) (-PlaceComponentResult[59]), objArr10);
                            Object[] objArr11 = new Object[1];
                            b(((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 31, new char[]{22398, 31208, 3551, 25538, 24492, 2608, 39242, 17606, 22094, 32049, 36600, 61677, 11061, 40342, 37698, 32822, 19050, 9912, 45792, 44408, 35908, 63379, 7067, 21906, 43621, 49221, 19468, 51001, 30887, 22514, 55111, 63605, 4962, 15865, 50363, 28845, 23161, 423, 31057, 16697, 54851, 42735, 34748, 53344, 22505, 10938, 44736, 41921, 47632, 20309, 26748, 44852, 22398, 31208, 36213, 63660, 12583, 33177, 42973, 18505, 36213, 63660, 45126, 54248}, objArr11);
                            String str3 = (String) objArr11[0];
                            try {
                                byte b3 = PlaceComponentResult[25];
                                Object[] objArr12 = new Object[1];
                                a(b3, b3, PlaceComponentResult[7], objArr12);
                                Class<?> cls5 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                a(PlaceComponentResult[41], PlaceComponentResult[5], (byte) (-PlaceComponentResult[59]), objArr13);
                                Object[] objArr14 = new Object[1];
                                b(((ApplicationInfo) cls5.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 27, new char[]{29961, 46560, 5405, 40809, 38348, 14076, 40604, 44569, 24047, 21959, 37896, 3517, 49806, 17461, 65195, 51034, 17492, 35007, 937, 25750, 41065, 32373, 11131, 1444, 22419, 29418, 9005, 62215, 5426, 57265, 44345, 17467, 9005, 62215, 64894, 5659, 53612, 19701, 23315, 39027, 28282, 30985, 6669, 15728, 48173, 62512, 41461, 19449, 5433, 27209, 3914, 36621, 63830, 44251, 44099, 19790, 12961, 22535, 55711, 63258}, objArr14);
                                String str4 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                b(super.getResources().getString(R.string.title_bank_search).substring(2, 3).codePointAt(0) - 102, new char[]{3170, 41376, 3059, 48175, 22398, 31208}, objArr15);
                                try {
                                    Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 17 - ExpandableListView.getPackedPositionChild(0L), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr16);
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
                } catch (Throwable th5) {
                    Throwable cause5 = th5.getCause();
                    if (cause5 == null) {
                        throw th5;
                    }
                    throw cause5;
                }
            }
        }
        try {
            byte b4 = PlaceComponentResult[30];
            byte b5 = (byte) (-PlaceComponentResult[32]);
            Object[] objArr17 = new Object[1];
            a(b4, b5, (byte) (b5 << 2), objArr17);
            Class<?> cls6 = Class.forName((String) objArr17[0]);
            byte b6 = PlaceComponentResult[30];
            Object[] objArr18 = new Object[1];
            a(b6, (byte) (b6 + 1), 21, objArr18);
            try {
                Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 3, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                    Object[] objArr20 = new Object[1];
                    c((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr20);
                    obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                int i = ((int[]) objArr21[1])[0];
                if (((int[]) objArr21[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr22 = {-1942308223, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, View.combineMeasuredStates(0, 0) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr22);
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
                }
                super.onCreate(bundle);
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.unsafe_device_tamper_footer).substring(25, 30).codePointAt(3) - 52, new char[]{14700, 54008, 10060, 59757, 56780, 42054, 30244, 54273, 28282, 30985, 61825, 53582, 43153, 40875, 15324, 2468, 5146, 5139, 50525, 12162, 19199, 34930, 29613, 26181, 65382, 30917}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(17 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{43233, 37252, 3219, 41187, 12961, 22535, 53518, 43488, 54026, 16394, 28580, 32198, 39914, 6398, 15324, 2468, 57022, 55048}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 911, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    public SmartPayActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$phonePermission$1
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
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(SmartPayActivity.this, "1500445", true);
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.phonePermission = builder.PlaceComponentResult();
    }

    @JvmName(name = "getMePageRevampPresenter")
    public final MePageRevampContract.Presenter getMePageRevampPresenter() {
        MePageRevampContract.Presenter presenter = this.mePageRevampPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMePageRevampPresenter")
    public final void setMePageRevampPresenter(MePageRevampContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.mePageRevampPresenter = presenter;
    }

    @JvmName(name = "getSmartPayPresenter")
    public final SmartPayContract.Presenter getSmartPayPresenter() {
        SmartPayContract.Presenter presenter = this.smartPayPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSmartPayPresenter")
    public final void setSmartPayPresenter(SmartPayContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.smartPayPresenter = presenter;
    }

    @JvmName(name = "getPaymentAuthListener")
    public final Listener getPaymentAuthListener() {
        return this.paymentAuthListener;
    }

    @JvmName(name = "setPaymentAuthListener")
    public final void setPaymentAuthListener(Listener listener) {
        this.paymentAuthListener = listener;
    }

    @JvmName(name = "getFaceAuthListener")
    public final Listener getFaceAuthListener() {
        return this.faceAuthListener;
    }

    @JvmName(name = "setFaceAuthListener")
    public final void setFaceAuthListener(Listener listener) {
        this.faceAuthListener = listener;
    }

    @JvmName(name = "getAutoRouteListener")
    public final Listener getAutoRouteListener() {
        return this.autoRouteListener;
    }

    @JvmName(name = "setAutoRouteListener")
    public final void setAutoRouteListener(Listener listener) {
        this.autoRouteListener = listener;
    }

    @JvmName(name = "getPhonePermission")
    public final ActivityPermissionRequest getPhonePermission() {
        return this.phonePermission;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        SettingModel settingModel = null;
        if (baseContext == null) {
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                a(b, b, PlaceComponentResult[7], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[41], PlaceComponentResult[5], (byte) (-PlaceComponentResult[59]), new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{14700, 54008, 10060, 59757, 56780, 42054, 30244, 54273, 28282, 30985, 61825, 53582, 43153, 40875, 15324, 2468, 5146, 5139, 50525, 12162, 19199, 34930, 29613, 26181, 65382, 30917}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(MotionEvent.axisFromString("") + 19, new char[]{43233, 37252, 3219, 41187, 12961, 22535, 53518, 43488, 54026, 16394, 28580, 32198, 39914, 6398, 15324, 2468, 57022, 55048}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSizeAndState(0, 0, 0) + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        SettingModel settingModel2 = (SettingModel) getIntent().getParcelableExtra(MyProfileBundleKey.SETTING_MODEL);
        if (settingModel2 != null) {
            Intrinsics.checkNotNullExpressionValue(settingModel2, "");
            settingModel2.setCollection(SMARTPAY_COLLECTION);
            settingModel2.setTitle(getString(R.string.smartpay_toolbar_title));
            this.MyBillsEntityDataFactory = settingModel2;
            setTitle(settingModel2.getTitle());
            setMenuLeftButton(R.drawable.btn_arrow_left);
        }
        if (this.MyBillsEntityDataFactory != null && this.getAuthRequestContext) {
            MePageRevampContract.Presenter mePageRevampPresenter = getMePageRevampPresenter();
            SettingModel settingModel3 = this.MyBillsEntityDataFactory;
            if (settingModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                settingModel = settingModel3;
            }
            String collection = settingModel.getCollection();
            Intrinsics.checkNotNullExpressionValue(collection, "");
            mePageRevampPresenter.MyBillsEntityDataFactory(collection);
        }
        this.getAuthRequestContext = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r3, int resultCode, Intent data) {
        super.onActivityResult(r3, resultCode, data);
        if (r3 == 1001) {
            if (resultCode == -1) {
                Listener listener = this.paymentAuthListener;
                if (listener != null) {
                    listener.KClassImpl$Data$declaredNonStaticMembers$2(null);
                    return;
                }
                return;
            }
            Listener listener2 = this.paymentAuthListener;
            if (listener2 != null) {
                listener2.MyBillsEntityDataFactory(getAuthRequestContext(data));
            }
        } else if (r3 == 1006) {
            if (resultCode == -1) {
                Listener listener3 = this.autoRouteListener;
                if (listener3 != null) {
                    listener3.KClassImpl$Data$declaredNonStaticMembers$2(data != null ? data.getExtras() : null);
                    return;
                }
                return;
            }
            Listener listener4 = this.autoRouteListener;
            if (listener4 != null) {
                listener4.MyBillsEntityDataFactory(getAuthRequestContext(data));
            }
        } else if (r3 != 2001) {
        } else {
            this.getAuthRequestContext = true;
            if (resultCode == -1) {
                ViewGroup viewGroup = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNull(viewGroup);
                new NewProfileMenuAutoSwitchViewHolder(viewGroup).MyBillsEntityDataFactory.onProceedSwitchOn();
                return;
            }
            ViewGroup viewGroup2 = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNull(viewGroup2);
            new NewProfileMenuAutoSwitchViewHolder(viewGroup2).MyBillsEntityDataFactory.revertChecked();
        }
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (isTaskRoot()) {
            Intent addFlags = new Intent(this, HomeTabActivity.class).addFlags(335544320);
            Intrinsics.checkNotNullExpressionValue(addFlags, "");
            startActivity(addFlags);
            finish();
            return;
        }
        super.onBackPressed();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // id.dana.myprofile.mepagerevamp.smartpay.SmartPayContract.View
    public final void onGetAutoSwitchInitialState(boolean isVisible, boolean isSwitchActive, String authenticationType) {
        SettingModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.setAutoRouteSwitch(isSwitchActive);
            KClassImpl$Data$declaredNonStaticMembers$2.setNeedToShow(isVisible);
            KClassImpl$Data$declaredNonStaticMembers$2.setAutoRouteAuthenticationType(authenticationType);
            SmartPaySettingsAdapter smartPaySettingsAdapter = this.getErrorConfigVersion;
            String parent = KClassImpl$Data$declaredNonStaticMembers$2.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "");
            Intrinsics.checkNotNullParameter(parent, "");
            int authRequestContext = smartPaySettingsAdapter.getAuthRequestContext(parent);
            final int i = -1;
            if (authRequestContext != -1) {
                smartPaySettingsAdapter.notifyItemChanged(authRequestContext);
            }
            if (isVisible) {
                List<SettingModel> items = this.getErrorConfigVersion.getItems();
                if (items != null) {
                    Iterator<SettingModel> it = items.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(it.next().getName(), MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM)) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (this.PlaceComponentResult) {
                    ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1196_danapolyboardview_showboard_1)).scrollToPosition(i);
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    View authRequestContext2 = getAuthRequestContext();
                    if (authRequestContext2 == null) {
                        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1196_danapolyboardview_showboard_1);
                        if (recyclerView != null) {
                            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$checkToShowAutoRoutingHighlight$1
                                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                                    View authRequestContext3;
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    ((RecyclerView) SmartPayActivity.this._$_findCachedViewById(R.id.res_0x7f0a1196_danapolyboardview_showboard_1)).removeOnScrollListener(this);
                                    SmartPayActivity smartPayActivity = SmartPayActivity.this;
                                    int i3 = i;
                                    authRequestContext3 = smartPayActivity.getAuthRequestContext();
                                    SmartPayActivity.access$showAutoSwitchTooltip(smartPayActivity, i3, authRequestContext3);
                                }
                            });
                        }
                        ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1196_danapolyboardview_showboard_1)).scrollToPosition(i);
                    } else if (authRequestContext2 == null || this.lookAheadTest != null) {
                    } else {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                        authRequestContext2.post(new SmartPayActivity$$ExternalSyntheticLambda1(this, authRequestContext2, i));
                    }
                }
            }
        }
    }

    private final NewProfileMenuAutoSwitchViewHolder BuiltInFictitiousFunctionClassFactory() {
        int BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1196_danapolyboardview_showboard_1);
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView != null ? recyclerView.findViewHolderForLayoutPosition(BuiltInFictitiousFunctionClassFactory) : null;
        if (findViewHolderForLayoutPosition instanceof NewProfileMenuAutoSwitchViewHolder) {
            return (NewProfileMenuAutoSwitchViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    private final int BuiltInFictitiousFunctionClassFactory(String p0) {
        SettingModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0);
        String parent = KClassImpl$Data$declaredNonStaticMembers$2 != null ? KClassImpl$Data$declaredNonStaticMembers$2.getParent() : null;
        if (parent == null) {
            parent = "";
        }
        return new SmartPaySettingsAdapter().getAuthRequestContext(parent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SettingModel KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        SettingModel settingModel;
        Iterator<SettingModel> it = this.getErrorConfigVersion.getItems().iterator();
        do {
            settingModel = null;
            if (!it.hasNext()) {
                break;
            }
            List<SettingModel> settingChilds = it.next().getSettingChilds();
            Intrinsics.checkNotNullExpressionValue(settingChilds, "");
            Iterator<T> it2 = settingChilds.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((SettingModel) next).getName(), p0)) {
                    settingModel = next;
                    break;
                }
            }
            settingModel = settingModel;
        } while (settingModel == null);
        return settingModel;
    }

    public final View getAuthRequestContext() {
        View view;
        View findViewById;
        NewProfileMenuAutoSwitchViewHolder BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null || (view = BuiltInFictitiousFunctionClassFactory.itemView) == null || (findViewById = view.findViewById(R.id.f4574view_autoroute_switch)) == null) {
            return null;
        }
        return findViewById;
    }

    private static String getAuthRequestContext(Intent p0) {
        Bundle extras;
        String string = (p0 == null || (extras = p0.getExtras()) == null) ? null : extras.getString(ChallengeControl.Key.CANCEL_REASON);
        return string == null ? "" : string;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0014\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayActivity$Listener;", "", "onCancelled", "", ZdocRecordService.REASON, "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "onSuccess", "data", "Landroid/os/Bundle;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle);

        void MyBillsEntityDataFactory(String str);

        /* renamed from: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$Listener$-CC */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\f"}, d2 = {"Lid/dana/myprofile/mepagerevamp/smartpay/SmartPayActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)V", "", "AUTO_ROUTE_BOTTOM_SHEET_REQUEST_CODE", "I", "", "NETWORK_EXCEPTION", "Ljava/lang/String;", "SMARTPAY_COLLECTION", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void MyBillsEntityDataFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.startActivity(new Intent(p0, SmartPayActivity.class));
        }
    }

    public static /* synthetic */ void $r8$lambda$RQyeWosG4fVjv0g_S_61TkIW6Mg(SmartPayActivity smartPayActivity, View view, int i) {
        Intrinsics.checkNotNullParameter(smartPayActivity, "");
        SectionShowcaseBuilder sectionShowcaseBuilder = new SectionShowcaseBuilder(smartPayActivity, view);
        RecyclerView recyclerView = (RecyclerView) smartPayActivity._$_findCachedViewById(R.id.res_0x7f0a1196_danapolyboardview_showboard_1);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        Intrinsics.checkNotNullParameter(recyclerView, "");
        sectionShowcaseBuilder.PlaceComponentResult = recyclerView;
        sectionShowcaseBuilder.BuiltInFictitiousFunctionClassFactory = i;
        sectionShowcaseBuilder.MyBillsEntityDataFactory = true;
        smartPayActivity.lookAheadTest = sectionShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$showAutoSwitchTooltip$1$1
            @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
            public final void onFinished(int p0) {
                SmartPayActivity.this.lookAheadTest = null;
                SmartPayActivity.this.PlaceComponentResult = false;
            }
        }).BuiltInFictitiousFunctionClassFactory();
        smartPayActivity.PlaceComponentResult = true;
    }

    public static final /* synthetic */ void access$showAutoSwitchTooltip(SmartPayActivity smartPayActivity, int i, View view) {
        if (view == null || smartPayActivity.lookAheadTest != null) {
            return;
        }
        smartPayActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        view.post(new SmartPayActivity$$ExternalSyntheticLambda1(smartPayActivity, view, i));
    }

    public static final /* synthetic */ void access$smartPayAdapterOnItemClickListener(SmartPayActivity smartPayActivity, SettingModel settingModel) {
        String redirectUrl;
        String action = settingModel.getAction();
        if (Intrinsics.areEqual(action, MyProfileMenuAction.AUTO_ROUTING_SETTING_PARAM) || Intrinsics.areEqual(action, MyProfileMenuAction.PAYMENT_AUTHENTICATION) || (redirectUrl = settingModel.getRedirectUrl()) == null) {
            return;
        }
        String authRequestContext = UrlUtil.getAuthRequestContext(redirectUrl);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$openH5Container$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        ((LoadingDialog) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerSmartPayComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSmartPayComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (MePageRevampModule) Preconditions.getAuthRequestContext(new MePageRevampModule(new MePageRevampContract.View() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$getMePageRevampModule$1
            @Override // id.dana.myprofile.mepagerevamp.MePageRevampContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
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
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.myprofile.mepagerevamp.MePageRevampContract.View
            public final void getAuthRequestContext(List<? extends SettingModel> p0) {
                SmartPaySettingsAdapter smartPaySettingsAdapter;
                if (p0 != null) {
                    p0 = SettingModelMapper.PlaceComponentResult(p0, true);
                }
                smartPaySettingsAdapter = SmartPayActivity.this.getErrorConfigVersion;
                smartPaySettingsAdapter.setItems(p0);
                SmartPayActivity.this.getSmartPayPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                SmartPayActivity smartPayActivity = SmartPayActivity.this;
                Toast.makeText(smartPayActivity, ErrorUtil.BuiltInFictitiousFunctionClassFactory(smartPayActivity), 0).show();
            }
        }));
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (SmartPayModule) Preconditions.getAuthRequestContext(new SmartPayModule(this));
        Preconditions.getAuthRequestContext(new FaceAuthPopUpConsultationModule(new FaceAuthPopUpConsultationContract.View() { // from class: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity$initInjector$1
            @Override // id.dana.contract.switchfaceauth.FaceAuthPopUpConsultationContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                FaceAuthPopUpConsultationContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
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
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, SmartPayModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, MePageRevampModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerSmartPayComponent.SmartPayComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getMePageRevampPresenter(), getSmartPayPresenter());
        ViewPager2 viewPager2 = (ViewPager2) _$_findCachedViewById(R.id.vp_content);
        if (viewPager2 != null) {
            Context context = viewPager2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            viewPager2.setAdapter(new SmartPayOnboardingAdapter(context, new SmartPayActivity$setupViewPager$1$1(viewPager2)));
        }
        TabLayout tabLayout = (TabLayout) _$_findCachedViewById(R.id.tl_indicator);
        if (tabLayout != null) {
            ViewPager2 viewPager22 = (ViewPager2) _$_findCachedViewById(R.id.vp_content);
            Intrinsics.checkNotNullExpressionValue(viewPager22, "");
            ViewPagerExtKt.getAuthRequestContext(tabLayout, viewPager22, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b7: INVOKE 
                  (r0v9 'tabLayout' com.google.android.material.tabs.TabLayout)
                  (r2v18 'viewPager22' androidx.viewpager2.widget.ViewPager2)
                  (wrap: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1 : 0x0000: SGET  A[WRAPPED] (LINE:27) id.dana.extension.view.ViewPagerExtKt$attachViewPager$1.INSTANCE id.dana.extension.view.ViewPagerExtKt$attachViewPager$1)
                 type: STATIC call: id.dana.extension.view.ViewPagerExtKt.getAuthRequestContext(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2):void A[MD:(com.google.android.material.tabs.TabLayout, androidx.viewpager2.widget.ViewPager2, kotlin.jvm.functions.Function2<? super com.google.android.material.tabs.TabLayout$Tab, ? super java.lang.Integer, kotlin.Unit>):void (m)] (LINE:25) in method: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.init():void, file: classes2.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                	... 21 more
                */
            /*
                Method dump skipped, instructions count: 403
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.smartpay.SmartPayActivity.init():void");
        }

        @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
        public final void showProgress() {
            LoadingDialog loadingDialog = (LoadingDialog) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            if (loadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing()) {
                return;
            }
            try {
                loadingDialog.BuiltInFictitiousFunctionClassFactory.show();
            } catch (Exception unused) {
            }
        }

        private static void b(int i, char[] cArr, Object[] objArr) {
            C c = new C();
            char[] cArr2 = new char[cArr.length];
            c.BuiltInFictitiousFunctionClassFactory = 0;
            char[] cArr3 = new char[2];
            while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                for (int i3 = 0; i3 < 16; i3++) {
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda3 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda5 ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (newProxyInstance ^ 6353485791441662354L)))));
                    i2 -= 40503;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }
    }
