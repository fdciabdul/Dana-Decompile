package id.dana.requestmoney;

import android.app.Application;
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
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.bank.BankSelectorActivity;
import id.dana.base.AbstractContractKt;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.databinding.ActivityRequestMoneyBinding;
import id.dana.databinding.LayoutToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerRequestMoneyComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.OauthModule;
import id.dana.di.modules.UserBankModule;
import id.dana.extension.view.ViewExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.popup.WrapContentHeightViewPager;
import id.dana.requestmoney.adapter.RequestMoneyStatePagerAdapterV2;
import id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment;
import id.dana.requestmoney.bank.UserBankContract;
import id.dana.requestmoney.model.BannerRequestMoneyModel;
import id.dana.requestmoney.model.RequestMoneyInitModel;
import id.dana.requestmoney.model.UserBankModel;
import id.dana.sendmoney.Amount;
import id.dana.sendmoney.model.BankModel;
import id.dana.sendmoney.model.RecipientModelExtKt;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.showcase.Content;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.TargetBuilder;
import id.dana.splitbill.view.SplitBillIntroductionActivity;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.constant.BottomSheetType;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.RandomInteger;
import id.dana.utils.SizeUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\bJ\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\tH\u0014¢\u0006\u0004\b#\u0010\u000bJ\r\u0010$\u001a\u00020\t¢\u0006\u0004\b$\u0010\u000bJ\u001d\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0002¢\u0006\u0004\b\b\u0010&J\r\u0010'\u001a\u00020\t¢\u0006\u0004\b'\u0010\u000bJ\u0017\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\b\u0010(R\u0016\u0010\u0006\u001a\u00020)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010\u0007\u001a\u00020:8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b;\u0010<R\u0013\u0010\u0004\u001a\u00020=X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0013\u001a\u00020@8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I"}, d2 = {"Lid/dana/requestmoney/RequestMoneyActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityRequestMoneyBinding;", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/usereducation/model/ContentOnBoardingModel;", "PlaceComponentResult", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityRequestMoneyBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "", "p0", "", "getAuthRequestContext", "(I)Z", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Lid/dana/requestmoney/model/UserBankModel;", "deletedBank", "onBankDeleted", "(Lid/dana/requestmoney/model/UserBankModel;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "refreshSavedUserBank", "", "(Ljava/util/List;)V", "startAddBankAccountActivity", "(I)V", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "scheduleImpl", "Lid/dana/component/customsnackbarcomponent/CustomSnackbar;", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "getFeaturePresenter", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "setFeaturePresenter", "(Lid/dana/contract/deeplink/path/FeatureContract$Presenter;)V", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingPresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingPresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingPresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "Lid/dana/requestmoney/adapter/RequestMoneyStatePagerAdapterV2;", "lookAheadTest", "Lid/dana/requestmoney/adapter/RequestMoneyStatePagerAdapterV2;", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "GetContactSyncConfig", "Lkotlin/Lazy;", "", "moveToNextValue", "()Ljava/lang/String;", "Lid/dana/requestmoney/bank/UserBankContract$Presenter;", "userBankPresenter", "Lid/dana/requestmoney/bank/UserBankContract$Presenter;", "getUserBankPresenter", "()Lid/dana/requestmoney/bank/UserBankContract$Presenter;", "setUserBankPresenter", "(Lid/dana/requestmoney/bank/UserBankContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyActivity extends BaseViewBindingActivity<ActivityRequestMoneyBinding> {
    private static final int KClassImpl$Data$declaredNonStaticMembers$2;
    private static final int getErrorConfigVersion;
    private static long initRecordTimeStamp;
    @Inject
    public FeatureContract.Presenter featurePresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private RequestMoneyStatePagerAdapterV2 MyBillsEntityDataFactory;
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private CustomSnackbar PlaceComponentResult;
    @Inject
    public UserBankContract.Presenter userBankPresenter;
    public static final byte[] $$a = {103, 121, -60, -41, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 232;
    public static final byte[] getAuthRequestContext = {14, -73, -90, 103, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 108;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.requestmoney.RequestMoneyActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.requestmoney.RequestMoneyActivity.getAuthRequestContext
            int r8 = 56 - r8
            int r7 = 106 - r7
            int r9 = 23 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L31
        L14:
            r3 = 0
        L15:
            r6 = r8
            r8 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L31:
            int r8 = r8 + 1
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.RequestMoneyActivity.b(int, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = 47 - r9
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = id.dana.requestmoney.RequestMoneyActivity.$$a
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r8]
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
            r6 = r9
            r9 = r7
        L1b:
            r7 = r6
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r7]
            r6 = r10
            r10 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L34:
            int r8 = -r8
            int r9 = r9 + r8
            int r9 = r9 + (-7)
            int r8 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.requestmoney.RequestMoneyActivity.c(short, int, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        initRecordTimeStamp = 398981990886033263L;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Method method;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18439 - View.MeasureSpec.getSize(0), new char[]{38477, 56901, 1606, 20043, 46687, 65126, 9826, 28211, 54907, 7776, 17988, 36401, 62986, 15896, 26157, 44576, 5679, 24104}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(55074 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{38465, 16756, 14395, 4902, 51916}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), AndroidCharacter.getMirror('0') - '\r', (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(63659 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{38427, 28388, 26444, 31765, 29872, 19743, 16919, 23225, 21315, 10314, 8417, 14611, 15949, 14001, 3911, 1055, 7341, 5446, 59932, 58108, 64276, 61512, 51453, 49479, 50752, 57004, 55114, 44097, 42154, 48407, 45639, 35580, 33653, 38929, 37032, 26996, 28230, 26274, 32630, 29713, 19619, 17705, 23062, 21155, 11050, 8208, 14496, 12588}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(Color.red(0) + 43541, new char[]{38477, 15372, 49712, 26743, 15902, 50300, 27234, 12423, 50912, 27890, 12999, 55550, 28340, 13580, 56123, 24867, 14158, 56699, 25392, 2450, 57324, 26020, 3028, 53756, 26594, 2627, 53303, 26238, 3160, 53801, 30824, 3733, 54511, 31485, 210, 54987, 31931, 838, 43266, 32556, 1361, 43841, 28987, 1946, 44499, 29610, 6619, 44992, 30191, 6170, 44545, 29754, 6737, 41026, 30322, 7326, 41604, 18608, 7821, 42137, 19185, 4373, 42846, 19764}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(40087 - (Process.myTid() >> 22), new char[]{38430, 2698, 44903, 17291, 58441, 39144, 15764, 56889, 29356, 5979, 35826, 11360, 49417, 26036, 1630, 47810, 24381, 61518, 38022, 2429, 44498, 20013, 58039, 34702, 14387, 56565, 28995, 5625, 46798, 11089, 53161, 24582, 1275, 47423, 23056, 65201, 37746, 14280, 43120, 19733, 57740, 33381, 9947, 56133, 32736, 4247, 46447, 10743, 51738, 28402, 817, 42076, 22706, 64862, 37264, 12904, 55059, 19334, 60451, 32983, 9518, 55778, 31371, 7996}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((Process.myPid() >> 22) + 15601, new char[]{38468, 43689, 61370, 8335, 26011, 42659, 64421, 15508, 29120, 45620, 63272, 2070, 19790, 36453, 50026, 1089, 22873, 39500, 57002, 5036, 21657, 27034, 43758, 61349, 8403, 26064, 42551, 64309, 15380, 28946, 45667, 63350, 2157, 19791, 36427, 49905, 1963, 22678, 40327, 57012, 5093, 21701, 27087, 43640, 61225, 8223, 25861, 42614, 64367, 15481, 28945, 45657, 63210, 3046, 19615, 33181, 49905, 2027, 22722, 40404}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(57191 - AndroidCharacter.getMirror('0'), new char[]{38421, 18741, 10358, 2983, 60098, 51726}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, 18 - TextUtils.getCapsMode("", 0, 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getTapTimeout() >> 16), View.getDefaultSize(0, 0) + 3, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), $$a[47], (byte) (-$$a[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, 15 - (Process.myTid() >> 22), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 15 - ExpandableListView.getPackedPositionGroup(0L), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 815, TextUtils.lastIndexOf("", '0', 0, 0) + 30, (char) (57994 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ExpandableListView.getPackedPositionChild(0L), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 15, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {230324361, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 910, 18 - TextUtils.indexOf("", "", 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                Object[] objArr21 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 61, 46 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0')));
                        byte b = (byte) ($$a[47] - 1);
                        Object[] objArr23 = new Object[1];
                        c(b, b, $$a[20], objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), TextUtils.getOffsetBefore("", 0) + 35, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr25 = {230324361, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, 18 - Drawable.resolveOpacity(0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr27 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                Object[] objArr28 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 118, 3 - ((Process.getThreadPriority(0) + 20) >> 6), (char) (38968 - (ViewConfiguration.getScrollBarSize() >> 8)));
                        byte b2 = (byte) ($$a[47] - 1);
                        Object[] objArr30 = new Object[1];
                        c(b2, b2, $$a[20], objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {230324361, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr34 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                Object[] objArr35 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 107, KeyEvent.normalizeMetaState(0) + 3, (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))));
                        Object[] objArr37 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr37);
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
                                method = obj16;
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), TextUtils.lastIndexOf("", '0', 0, 0) + 36, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke6 = ((Method) method).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr39 = {230324361, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), 18 - (ViewConfiguration.getTouchSlop() >> 8), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(R.string.twilio_notification_title).substring(0, 4).length() + 61777, new char[]{38477, 26391, 29922, 17825, 21271, 8428, 12726, 3921, 7397, 60833, 64270, 51365, 55697, 55070, 42238, 46526, 33546, 37088, 24994, 32538, 19676, 23997, 11024, 14570, 2485, 1797}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(55547 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new char[]{38479, 20130, 10152, 7343, 62885, 43685, 33722, 30896, 20868, 13967, 61326, 50316, 48523, 37618, 19426, 8432, 6643, 65257}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(61780 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{38477, 26391, 29922, 17825, 21271, 8428, 12726, 3921, 7397, 60833, 64270, 51365, 55697, 55070, 42238, 46526, 33546, 37088, 24994, 32538, 19676, 23997, 11024, 14570, 2485, 1797}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(55547 - (ViewConfiguration.getScrollBarSize() >> 8), new char[]{38479, 20130, 10152, 7343, 62885, 43685, 33722, 30896, 20868, 13967, 61326, 50316, 48523, 37618, 19426, 8432, 6643, 65257}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    }

    @JvmName(name = "getUserBankPresenter")
    public final UserBankContract.Presenter getUserBankPresenter() {
        UserBankContract.Presenter presenter = this.userBankPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUserBankPresenter")
    public final void setUserBankPresenter(UserBankContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.userBankPresenter = presenter;
    }

    @JvmName(name = "getOnBoardingPresenter")
    public final BottomSheetOnBoardingContract.Presenter getOnBoardingPresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnBoardingPresenter")
    public final void setOnBoardingPresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.onBoardingPresenter = presenter;
    }

    @JvmName(name = "getFeaturePresenter")
    public final FeatureContract.Presenter getFeaturePresenter() {
        FeatureContract.Presenter presenter = this.featurePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeaturePresenter")
    public final void setFeaturePresenter(FeatureContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.featurePresenter = presenter;
    }

    @JvmName(name = "moveToNextValue")
    private final String moveToNextValue() {
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("source") : null;
        return string == null ? "" : string;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityRequestMoneyBinding inflateViewBinding() {
        ActivityRequestMoneyBinding MyBillsEntityDataFactory = ActivityRequestMoneyBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        ActivityRequestMoneyBinding binding = getBinding();
        FloatingActionButton floatingActionButton = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton, "");
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(floatingActionButton, p0 != 0);
        FloatingActionButton floatingActionButton2 = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(floatingActionButton2, "");
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(floatingActionButton2, getAuthRequestContext(p0));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerRequestMoneyComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerRequestMoneyComponent.BuiltInFictitiousFunctionClassFactory();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (UserBankModule) Preconditions.getAuthRequestContext(new UserBankModule(new UserBankContract.View() { // from class: id.dana.requestmoney.RequestMoneyActivity$getUserBankModule$1
            @Override // id.dana.requestmoney.bank.UserBankContract.View
            public final void getAuthRequestContext(List<UserBankModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyActivity.access$onGetSavedUserBank(RequestMoneyActivity.this, p0);
            }

            @Override // id.dana.requestmoney.bank.UserBankContract.View
            public final void getAuthRequestContext(RequestMoneyInitModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RequestMoneyActivity.access$onInitRequestMoney(RequestMoneyActivity.this, p0);
            }

            @Override // id.dana.requestmoney.bank.UserBankContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                if (p0) {
                    RequestMoneyActivity.this.refreshSavedUserBank();
                    RequestMoneyActivity.access$showAddBankSuccessSnackBar(RequestMoneyActivity.this);
                }
            }

            @Override // id.dana.requestmoney.bank.UserBankContract.View
            public final void PlaceComponentResult() {
                RequestMoneyActivity.access$showUserBankExistSnackbar(RequestMoneyActivity.this);
            }

            @Override // id.dana.requestmoney.bank.UserBankContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0, UserBankModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                RequestMoneyActivity.this.onBankDeleted(p1);
            }
        }));
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.requestmoney.RequestMoneyActivity$getBottomOnBoardingModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
                if (p0) {
                    RequestMoneyActivity.access$openBottomOnBoardingPageView(RequestMoneyActivity.this);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append("on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
            }
        }));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        RequestMoneyActivity requestMoneyActivity = this;
        authRequestContext.MyBillsEntityDataFactory = requestMoneyActivity;
        byte b = 0;
        Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = requestMoneyActivity;
        Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = requestMoneyActivity;
        MyBillsEntityDataFactory.PlaceComponentResult = "Request Money";
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory2 = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = requestMoneyActivity;
        Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory2, b));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, UserBankModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerRequestMoneyComponent.RequestMoneyComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (byte) 0).PlaceComponentResult(this);
    }

    public final void refreshSavedUserBank() {
        getUserBankPresenter().BuiltInFictitiousFunctionClassFactory();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(List<ContentOnBoardingModel> p0) {
        p0.add(KClassImpl$Data$declaredNonStaticMembers$2());
        p0.add(BuiltInFictitiousFunctionClassFactory());
        p0.add(PlaceComponentResult());
        p0.add(MyBillsEntityDataFactory());
    }

    private final ContentOnBoardingModel KClassImpl$Data$declaredNonStaticMembers$2() {
        String string = getString(R.string.bottom_on_boarding_subtitle_request_money_first);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.bottom_on_boarding_body_text_request_money_first);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return new ContentOnBoardingModel((int) R.drawable.on_boarding_enter_pin, string, string2);
    }

    private final ContentOnBoardingModel BuiltInFictitiousFunctionClassFactory() {
        String string = getString(R.string.bottom_on_boarding_subtitle_request_money_second);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.bottom_on_boarding_body_text_request_money_second);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return new ContentOnBoardingModel((int) R.drawable.onboarding_input_amount, string, string2);
    }

    private final ContentOnBoardingModel PlaceComponentResult() {
        String string = getString(R.string.bottom_on_boarding_subtitle_request_money_third);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.bottom_on_boarding_body_text_request_money_third);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return new ContentOnBoardingModel((int) R.drawable.on_boarding_finish_register, string, string2);
    }

    private final ContentOnBoardingModel MyBillsEntityDataFactory() {
        String string = getString(R.string.bottom_on_boarding_subtitle_request_money_fourth);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = getString(R.string.bottom_on_boarding_body_text_request_money_fourth);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return new ContentOnBoardingModel((int) R.drawable.on_boarding_bank_account, string, string2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r8, int resultCode, Intent data) {
        BankModel bankModel;
        if (-1 == resultCode) {
            if (r8 == KClassImpl$Data$declaredNonStaticMembers$2) {
                TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                TextView textView2 = textView;
                RequestMoneyActivity requestMoneyActivity = this;
                SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(requestMoneyActivity);
                simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = new TargetBuilder(requestMoneyActivity).getAuthRequestContext(textView2).BuiltInFictitiousFunctionClassFactory(new CircleShape(SplitBillIntroductionActivity.SPOTLIGHT_SIZE)).getAuthRequestContext(new Content(getResources().getString(R.string.tooltip_highlight_title), getResources().getString(R.string.tooltip_highlight_description_request_money))).KClassImpl$Data$declaredNonStaticMembers$2();
                simpleShowcaseBuilder.getAuthRequestContext(SizeUtil.getAuthRequestContext(16)).BuiltInFictitiousFunctionClassFactory(getString(R.string.btnDismissOnboarding)).BuiltInFictitiousFunctionClassFactory(false).PlaceComponentResult();
                String string = getString(R.string.btnDismissOnboarding);
                Intrinsics.checkNotNullExpressionValue(string, "");
                if (textView2 != null) {
                    textView2.setContentDescription(string);
                }
            } else if (r8 == getErrorConfigVersion && data != null && (bankModel = (BankModel) data.getParcelableExtra(BankSelectorActivity.EXTRA_SELECTED_BANK)) != null) {
                getUserBankPresenter().BuiltInFictitiousFunctionClassFactory(RecipientModelExtKt.BuiltInFictitiousFunctionClassFactory(bankModel));
            }
        }
        super.onActivityResult(r8, resultCode, data);
    }

    public final void startAddBankAccountActivity() {
        BankSelectorActivity.Companion companion = BankSelectorActivity.INSTANCE;
        startActivityForResult(BankSelectorActivity.Companion.PlaceComponentResult(this, null, null, true, true, false, null, null, false, "Request Money", 486), getErrorConfigVersion);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getUserBankPresenter().onDestroy();
        getOnBoardingPresenter().onDestroy();
    }

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        KClassImpl$Data$declaredNonStaticMembers$2 = RandomInteger.BuiltInFictitiousFunctionClassFactory();
        getErrorConfigVersion = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void $r8$lambda$14vZTz6PJUs0djA9lI4qdoRr4XU(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        CustomSnackbar customSnackbar = requestMoneyActivity.PlaceComponentResult;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.dismiss();
    }

    public static /* synthetic */ void $r8$lambda$97mminBCqMOXNcWLGLcuC4DbGIs(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        CustomSnackbar customSnackbar = requestMoneyActivity.PlaceComponentResult;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.dismiss();
    }

    public static /* synthetic */ void $r8$lambda$FIrdgMx07y2vAjZq97opl8_hQIA(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        requestMoneyActivity.getBinding().scheduleImpl.arrowScroll(17);
    }

    public static /* synthetic */ void $r8$lambda$YBIzchGrd8BAPk13PF9XSh5CC7E(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        ArrayList arrayList = new ArrayList();
        requestMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        String string = requestMoneyActivity.getString(R.string.bottom_on_boarding_title_request_money);
        Intrinsics.checkNotNullExpressionValue(string, "");
        requestMoneyActivity.startActivity(BottomSheetHelpActivity.Companion.PlaceComponentResult(requestMoneyActivity, new OnBoardingModel(string, "list", arrayList, "request_money", null, null, null, 112, null), true));
    }

    /* renamed from: $r8$lambda$ZUqayxjfuc_DFaFR5L-lR88v9cU */
    public static /* synthetic */ void m2796$r8$lambda$ZUqayxjfuc_DFaFR5LlR88v9cU(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        requestMoneyActivity.getBinding().scheduleImpl.arrowScroll(66);
    }

    public static /* synthetic */ void $r8$lambda$__1jgx1ZF3oFeUW0lmCHJ02sqQA(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        CustomSnackbar customSnackbar = requestMoneyActivity.PlaceComponentResult;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.dismiss();
    }

    /* renamed from: $r8$lambda$djPdFhxGMIPg2PjDEqFd0PSJ-70 */
    public static /* synthetic */ void m2797$r8$lambda$djPdFhxGMIPg2PjDEqFd0PSJ70(BannerRequestMoneyModel bannerRequestMoneyModel, final RequestMoneyActivity requestMoneyActivity, View view) {
        View decorView;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(bannerRequestMoneyModel, "");
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        RequestMoneyStatePagerAdapterV2 requestMoneyStatePagerAdapterV2 = null;
        if (bannerRequestMoneyModel.getPlaceComponentResult()) {
            RequestMoneyStatePagerAdapterV2 requestMoneyStatePagerAdapterV22 = requestMoneyActivity.MyBillsEntityDataFactory;
            if (requestMoneyStatePagerAdapterV22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                requestMoneyStatePagerAdapterV22 = null;
            }
            byte b = 0;
            if (requestMoneyStatePagerAdapterV22.BuiltInFictitiousFunctionClassFactory()) {
                requestMoneyActivity.startAddBankAccountActivity();
                EventTrackerModel.Builder builder = new EventTrackerModel.Builder(requestMoneyActivity);
                builder.MyBillsEntityDataFactory = TrackerKey.Event.REQUEST_MONEY_QR_BANK_CREATE;
                EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", TrackerKey.SourceType.BANNER);
                MyBillsEntityDataFactory.PlaceComponentResult();
                EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
                return;
            }
            Window window = requestMoneyActivity.getWindow();
            if (window == null || (decorView = window.getDecorView()) == null || (viewGroup = (ViewGroup) decorView.findViewById(16908290)) == null) {
                return;
            }
            CustomSnackbar.Builder builder2 = new CustomSnackbar.Builder(viewGroup);
            builder2.lookAheadTest = requestMoneyActivity.getString(R.string.close);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = requestMoneyActivity.getString(R.string.request_money_add_bank_limit_reached);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Object[] objArr = new Object[1];
            RequestMoneyStatePagerAdapterV2 requestMoneyStatePagerAdapterV23 = requestMoneyActivity.MyBillsEntityDataFactory;
            if (requestMoneyStatePagerAdapterV23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                requestMoneyStatePagerAdapterV2 = requestMoneyStatePagerAdapterV23;
            }
            objArr[0] = Integer.valueOf(requestMoneyStatePagerAdapterV2.PlaceComponentResult);
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            builder2.initRecordTimeStamp = format;
            builder2.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_24_yellow50;
            builder2.moveToNextValue = 0;
            builder2.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_yellow_50;
            builder2.scheduleImpl = new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RequestMoneyActivity.$r8$lambda$97mminBCqMOXNcWLGLcuC4DbGIs(RequestMoneyActivity.this, view2);
                }
            };
            CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder2.BuiltInFictitiousFunctionClassFactory();
            requestMoneyActivity.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory.show();
            return;
        }
        String str = bannerRequestMoneyModel.MyBillsEntityDataFactory;
        String str2 = str != null ? str : "";
        if (UrlUtil.getErrorConfigVersion(str2)) {
            requestMoneyActivity.getFeaturePresenter().getAuthRequestContext(BranchLinkConstant.ActionTarget.SPLIT_BILL, null);
        } else {
            DanaH5.startContainerFullUrl(str2);
        }
    }

    /* renamed from: $r8$lambda$jAZ13eoQCrFESU8BAKHhvAyH-ro */
    public static /* synthetic */ void m2798$r8$lambda$jAZ13eoQCrFESU8BAKHhvAyHro(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        CustomSnackbar customSnackbar = requestMoneyActivity.PlaceComponentResult;
        if (customSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            customSnackbar = null;
        }
        customSnackbar.dismiss();
    }

    public static /* synthetic */ void $r8$lambda$vEL96zbN15tMUK3JkZJpSAyFo2E(RequestMoneyActivity requestMoneyActivity, View view) {
        Intrinsics.checkNotNullParameter(requestMoneyActivity, "");
        requestMoneyActivity.finish();
    }

    public static final /* synthetic */ void access$onGetSavedUserBank(RequestMoneyActivity requestMoneyActivity, List list) {
        RequestMoneyStatePagerAdapterV2 requestMoneyStatePagerAdapterV2 = requestMoneyActivity.MyBillsEntityDataFactory;
        if (requestMoneyStatePagerAdapterV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            requestMoneyStatePagerAdapterV2 = null;
        }
        Intrinsics.checkNotNullParameter(list, "");
        requestMoneyStatePagerAdapterV2.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.toMutableList((Collection) list);
        requestMoneyStatePagerAdapterV2.notifyDataSetChanged();
        requestMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2(requestMoneyActivity.getBinding().scheduleImpl.getCurrentItem());
    }

    public static final /* synthetic */ void access$onInitRequestMoney(RequestMoneyActivity requestMoneyActivity, RequestMoneyInitModel requestMoneyInitModel) {
        RequestMoneyStatePagerAdapterV2 requestMoneyStatePagerAdapterV2 = requestMoneyActivity.MyBillsEntityDataFactory;
        if (requestMoneyStatePagerAdapterV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            requestMoneyStatePagerAdapterV2 = null;
        }
        Intrinsics.checkNotNullParameter(requestMoneyInitModel, "");
        requestMoneyStatePagerAdapterV2.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.toMutableList((Collection) requestMoneyInitModel.MyBillsEntityDataFactory);
        requestMoneyStatePagerAdapterV2.PlaceComponentResult = requestMoneyInitModel.getAuthRequestContext;
        requestMoneyStatePagerAdapterV2.notifyDataSetChanged();
        requestMoneyActivity.getBinding().scheduleImpl.setOffscreenPageLimit(requestMoneyInitModel.getAuthRequestContext + 2);
        boolean z = requestMoneyInitModel.getAuthRequestContext > 0;
        ActivityRequestMoneyBinding binding = requestMoneyActivity.getBinding();
        MaterialCardView materialCardView = binding.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        materialCardView.setVisibility(z ? 0 : 8);
        TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(z ? 0 : 8);
        requestMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2(requestMoneyActivity.getBinding().scheduleImpl.getCurrentItem());
    }

    public static final /* synthetic */ void access$openBottomOnBoardingPageView(RequestMoneyActivity requestMoneyActivity) {
        ArrayList arrayList = new ArrayList();
        requestMoneyActivity.KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
        String string = requestMoneyActivity.getString(R.string.bottom_on_boarding_title_request_money);
        Intrinsics.checkNotNullExpressionValue(string, "");
        requestMoneyActivity.startActivityForResult(BottomSheetOnBoardingActivity.createOnBoardingIntent(requestMoneyActivity, new OnBoardingModel(string, BottomSheetType.VIEW_PAGER, arrayList, "request_money", null, null, null, 112, null)), KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static final /* synthetic */ void access$showAddBankSuccessSnackBar(final RequestMoneyActivity requestMoneyActivity) {
        View decorView;
        ViewGroup viewGroup;
        Window window = requestMoneyActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (viewGroup = (ViewGroup) decorView.findViewById(16908290)) == null) {
            return;
        }
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder(viewGroup);
        builder.lookAheadTest = requestMoneyActivity.getString(R.string.close);
        builder.initRecordTimeStamp = requestMoneyActivity.getString(R.string.request_money_add_bank_message_success);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_check_24_green50_filled_circle;
        builder.moveToNextValue = 0;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_green_50;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestMoneyActivity.$r8$lambda$14vZTz6PJUs0djA9lI4qdoRr4XU(RequestMoneyActivity.this, view);
            }
        };
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        requestMoneyActivity.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    public static final /* synthetic */ void access$showUserBankExistSnackbar(final RequestMoneyActivity requestMoneyActivity) {
        View decorView;
        ViewGroup viewGroup;
        Window window = requestMoneyActivity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (viewGroup = (ViewGroup) decorView.findViewById(16908290)) == null) {
            return;
        }
        CustomSnackbar.Builder builder = new CustomSnackbar.Builder(viewGroup);
        builder.lookAheadTest = requestMoneyActivity.getString(R.string.close);
        builder.initRecordTimeStamp = requestMoneyActivity.getString(R.string.request_money_add_bank_exist_error);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_orange;
        builder.moveToNextValue = 0;
        builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_yellow_50;
        builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestMoneyActivity.m2798$r8$lambda$jAZ13eoQCrFESU8BAKHhvAyHro(RequestMoneyActivity.this, view);
            }
        };
        CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        requestMoneyActivity.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.show();
    }

    private final boolean getAuthRequestContext(int p0) {
        return p0 != getBinding().scheduleImpl.getChildCount() - 1;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        LayoutToolbarBinding layoutToolbarBinding = getBinding().BuiltInFictitiousFunctionClassFactory;
        TextView textView = layoutToolbarBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = layoutToolbarBinding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        layoutToolbarBinding.initRecordTimeStamp.setText(getString(R.string.request_money_title));
        LayoutToolbarBinding layoutToolbarBinding2 = getBinding().BuiltInFictitiousFunctionClassFactory;
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationIcon(R.drawable.arrow_left_white);
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestMoneyActivity.$r8$lambda$vEL96zbN15tMUK3JkZJpSAyFo2E(RequestMoneyActivity.this, view);
            }
        });
        layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(4);
        Toolbar toolbar = layoutToolbarBinding2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = toolbar.getChildAt(i);
            ImageButton imageButton = childAt instanceof ImageButton ? (ImageButton) childAt : null;
            if (imageButton != null) {
                imageButton.setContentDescription(getResources().getString(R.string.imgBtnLeft));
            }
        }
        ViewGroup.LayoutParams layoutParams = getBinding().BuiltInFictitiousFunctionClassFactory.scheduleImpl.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, SizeUtil.getAuthRequestContext(10), marginLayoutParams.bottomMargin);
            getBinding().BuiltInFictitiousFunctionClassFactory.scheduleImpl.setLayoutParams(marginLayoutParams);
            TextView textView2 = getBinding().BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion;
            textView2.setBackground(ContextCompat.PlaceComponentResult(this, (int) R.drawable.ic_tooltip_help));
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            textView2.setVisibility(0);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RequestMoneyActivity.$r8$lambda$YBIzchGrd8BAPk13PF9XSh5CC7E(RequestMoneyActivity.this, view);
                }
            });
            getBinding().BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2.setContentDescription(getString(R.string.lblRequestMoney));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Bundle extras;
        String string;
        Fragment fragment;
        WrapContentHeightViewPager wrapContentHeightViewPager = getBinding().scheduleImpl;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        String moveToNextValue = moveToNextValue();
        this.MyBillsEntityDataFactory = new RequestMoneyStatePagerAdapterV2(supportFragmentManager, null, moveToNextValue == null ? "" : moveToNextValue, 2, null);
        int dimensionPixelSize = wrapContentHeightViewPager.getResources().getDimensionPixelSize(R.dimen.f33702131166046);
        byte b = 0;
        wrapContentHeightViewPager.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        wrapContentHeightViewPager.setPageMargin(wrapContentHeightViewPager.getResources().getDimensionPixelSize(R.dimen.f33692131166045));
        wrapContentHeightViewPager.setClipToPadding(false);
        wrapContentHeightViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$getOnPageChangeListener$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int p0) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int p0, float p1, int p2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int p0) {
                RequestMoneyActivity.this.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }
        });
        RequestMoneyStatePagerAdapterV2 requestMoneyStatePagerAdapterV2 = this.MyBillsEntityDataFactory;
        if (requestMoneyStatePagerAdapterV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            requestMoneyStatePagerAdapterV2 = null;
        }
        wrapContentHeightViewPager.setAdapter(requestMoneyStatePagerAdapterV2);
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && (string = extras.getString("amount")) != null) {
            Amount amount = new Amount(string);
            if (amount.KClassImpl$Data$declaredNonStaticMembers$2(new Amount((byte) 0)) && (fragment = getSupportFragmentManager().getFragments().get(0)) != null && (fragment instanceof RequestMoneyBalanceQrCardFragment)) {
                RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment = (RequestMoneyBalanceQrCardFragment) fragment;
                Intrinsics.checkNotNullParameter(amount, "");
                Intrinsics.checkNotNullParameter("", "");
                requestMoneyBalanceQrCardFragment.MyBillsEntityDataFactory(amount);
                requestMoneyBalanceQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2("");
                requestMoneyBalanceQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda2();
            }
        }
        final BannerRequestMoneyModel bannerRequestMoneyModel = new BannerRequestMoneyModel(null, "https://link.dana.id/splitbill", false, 1, null);
        MaterialCardView materialCardView = getBinding().moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2;
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().moveToNextValue.BuiltInFictitiousFunctionClassFactory, Intrinsics.areEqual(Locale.getDefault().getLanguage(), "en") ? R.drawable.ic_banner_split_bill_en : R.drawable.ic_banner_split_bill_in);
        materialCardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestMoneyActivity.m2797$r8$lambda$djPdFhxGMIPg2PjDEqFd0PSJ70(BannerRequestMoneyModel.this, this, view);
            }
        });
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestMoneyActivity.$r8$lambda$FIrdgMx07y2vAjZq97opl8_hQIA(RequestMoneyActivity.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RequestMoneyActivity.m2796$r8$lambda$ZUqayxjfuc_DFaFR5LlR88v9cU(RequestMoneyActivity.this, view);
            }
        });
        getOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("request_money");
        getUserBankPresenter().PlaceComponentResult();
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REQUEST_MONEY_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", moveToNextValue());
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
        Application application = getApplication();
        DanaApplication danaApplication = application instanceof DanaApplication ? (DanaApplication) application : null;
        if (danaApplication != null) {
            danaApplication.chckTmprdApp();
        }
    }

    public final void onBankDeleted(UserBankModel deletedBank) {
        View decorView;
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(deletedBank, "");
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null && (viewGroup = (ViewGroup) decorView.findViewById(16908290)) != null) {
            CustomSnackbar.Builder builder = new CustomSnackbar.Builder(viewGroup);
            builder.lookAheadTest = getString(R.string.close);
            String string = getString(R.string.request_money_success_delete_message);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{deletedBank.BuiltInFictitiousFunctionClassFactory, deletedBank.getAuthRequestContext}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            builder.initRecordTimeStamp = format;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_orange;
            builder.moveToNextValue = 0;
            builder.MyBillsEntityDataFactory = R.drawable.bg_rounded_border_yellow_50;
            builder.scheduleImpl = new View.OnClickListener() { // from class: id.dana.requestmoney.RequestMoneyActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RequestMoneyActivity.$r8$lambda$__1jgx1ZF3oFeUW0lmCHJ02sqQA(RequestMoneyActivity.this, view);
                }
            };
            CustomSnackbar BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
            BuiltInFictitiousFunctionClassFactory.show();
        }
        refreshSavedUserBank();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a((ViewConfiguration.getScrollDefaultDelay() >> 16) + 18439, new char[]{38477, 56901, 1606, 20043, 46687, 65126, 9826, 28211, 54907, 7776, 17988, 36401, 62986, 15896, 26157, 44576, 5679, 24104}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            Object[] objArr3 = new Object[1];
            b(getAuthRequestContext[32], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr4);
            Object[] objArr5 = new Object[1];
            a(((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 55040, new char[]{38465, 16756, 14395, 4902, 51916}, objArr5);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    a(61782 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new char[]{38477, 26391, 29922, 17825, 21271, 8428, 12726, 3921, 7397, 60833, 64270, 51365, 55697, 55070, 42238, 46526, 33546, 37088, 24994, 32538, 19676, 23997, 11024, 14570, 2485, 1797}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0') + 55548, new char[]{38479, 20130, 10152, 7343, 62885, 43685, 33722, 30896, 20868, 13967, 61326, 50316, 48523, 37618, 19426, 8432, 6643, 65257}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, Drawable.resolveOpacity(0, 0) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.mix_pay_promo_not_available_dialog_description).substring(57, 59).length() + 63657, new char[]{38427, 28388, 26444, 31765, 29872, 19743, 16919, 23225, 21315, 10314, 8417, 14611, 15949, 14001, 3911, 1055, 7341, 5446, 59932, 58108, 64276, 61512, 51453, 49479, 50752, 57004, 55114, 44097, 42154, 48407, 45639, 35580, 33653, 38929, 37032, 26996, 28230, 26274, 32630, 29713, 19619, 17705, 23062, 21155, 11050, 8208, 14496, 12588}, objArr8);
                        String str = (String) objArr8[0];
                        try {
                            Object[] objArr9 = new Object[1];
                            b(getAuthRequestContext[32], (byte) (getAuthRequestContext[59] + 1), getAuthRequestContext[25], objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            Object[] objArr10 = new Object[1];
                            b(getAuthRequestContext[13], getAuthRequestContext[25], getAuthRequestContext[27], objArr10);
                            Object[] objArr11 = new Object[1];
                            a(((ApplicationInfo) cls4.getMethod((String) objArr10[0], null).invoke(this, null)).targetSdkVersion + 43508, new char[]{38477, 15372, 49712, 26743, 15902, 50300, 27234, 12423, 50912, 27890, 12999, 55550, 28340, 13580, 56123, 24867, 14158, 56699, 25392, 2450, 57324, 26020, 3028, 53756, 26594, 2627, 53303, 26238, 3160, 53801, 30824, 3733, 54511, 31485, 210, 54987, 31931, 838, 43266, 32556, 1361, 43841, 28987, 1946, 44499, 29610, 6619, 44992, 30191, 6170, 44545, 29754, 6737, 41026, 30322, 7326, 41604, 18608, 7821, 42137, 19185, 4373, 42846, 19764}, objArr11);
                            String str2 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            a(TextUtils.indexOf((CharSequence) "", '0', 0) + 40088, new char[]{38430, 2698, 44903, 17291, 58441, 39144, 15764, 56889, 29356, 5979, 35826, 11360, 49417, 26036, 1630, 47810, 24381, 61518, 38022, 2429, 44498, 20013, 58039, 34702, 14387, 56565, 28995, 5625, 46798, 11089, 53161, 24582, 1275, 47423, 23056, 65201, 37746, 14280, 43120, 19733, 57740, 33381, 9947, 56133, 32736, 4247, 46447, 10743, 51738, 28402, 817, 42076, 22706, 64862, 37264, 12904, 55059, 19334, 60451, 32983, 9518, 55778, 31371, 7996}, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a(super.getResources().getString(R.string.msg_location_dialog_verifynumber_desc).substring(142, 144).length() + 15599, new char[]{38468, 43689, 61370, 8335, 26011, 42659, 64421, 15508, 29120, 45620, 63272, 2070, 19790, 36453, 50026, 1089, 22873, 39500, 57002, 5036, 21657, 27034, 43758, 61349, 8403, 26064, 42551, 64309, 15380, 28946, 45667, 63350, 2157, 19791, 36427, 49905, 1963, 22678, 40327, 57012, 5093, 21701, 27087, 43640, 61225, 8223, 25861, 42614, 64367, 15481, 28945, 45657, 63210, 3046, 19615, 33181, 49905, 2027, 22722, 40404}, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            a(super.getResources().getString(R.string.confirmation_page_title).substring(1, 2).length() + 57142, new char[]{38421, 18741, 10358, 2983, 60098, 51726}, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                }
            }
            try {
                Object[] objArr16 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[31], (byte) (-getAuthRequestContext[30]), objArr16);
                Class<?> cls5 = Class.forName((String) objArr16[0]);
                Object[] objArr17 = new Object[1];
                b(getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), (byte) (-getAuthRequestContext[30]), objArr17);
                try {
                    Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.lastIndexOf("", '0', 0), 4 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ExpandableListView.getPackedPositionChild(0L) + 1));
                        Object[] objArr19 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[8]), (byte) ($$a[47] - 1), objArr19);
                        obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                    int i = ((int[]) objArr20[1])[0];
                    if (((int[]) objArr20[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Color.argb(0, 0, 0, 0) + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr21 = {5976470, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr21);
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
                    ((SendMoneyFeatureTime) this.BuiltInFictitiousFunctionClassFactory.getValue()).getAuthRequestContext();
                    ((SendMoneyFeatureTime) this.BuiltInFictitiousFunctionClassFactory.getValue()).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                    super.onCreate(savedInstanceState);
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
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (initRecordTimeStamp ^ 4796183387843776835L);
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
