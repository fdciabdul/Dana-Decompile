package id.dana.animation;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.animation.model.EddConsultModel;
import id.dana.animation.model.EddInfoModel;
import id.dana.animation.model.EddQuestionInfoDTOModel;
import id.dana.base.BaseActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerKycAmlEddActivityComponent;
import id.dana.di.modules.KycAmlEddModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.DefaultObserver;
import id.dana.domain.kycamledd.interactor.SubmitEddAmlKyc;
import id.dana.kycamledd.KycAmlEddContract;
import id.dana.kycamledd.KycAmlEddPresenter;
import id.dana.kycamledd.mapper.EddSubmitInfoModelToEddSubmitInfoMapperKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.RandomInteger;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0013\u0010\u0011\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010#\u001a\u00020!X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010\u0010"}, d2 = {"Lid/dana/home/KycAmlEddActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "onBackPressed", "", "lookAheadTest", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/dialog/DanaLoadingDialog;", "getErrorConfigVersion", "Lkotlin/Lazy;", "getAuthRequestContext", "Ljava/util/ArrayList;", "Lid/dana/home/model/EddQuestionInfoDTOModel;", "Lkotlin/collections/ArrayList;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/ArrayList;", "KClassImpl$Data$declaredNonStaticMembers$2", "GetContactSyncConfig", "PlaceComponentResult", "Lid/dana/kycamledd/KycAmlEddPresenter;", "kycAmlEddPresenter", "Lid/dana/kycamledd/KycAmlEddPresenter;", "getKycAmlEddPresenter", "()Lid/dana/kycamledd/KycAmlEddPresenter;", "setKycAmlEddPresenter", "(Lid/dana/kycamledd/KycAmlEddPresenter;)V", "Lid/dana/home/KycEmlAddAdapter;", "initRecordTimeStamp", "MyBillsEntityDataFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KycAmlEddActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long DatabaseTableConfigUtil = 0;
    public static final String KYC_AML_EDD_INTENT = "kyc_aml_edd_intent";
    private static int NetworkUserEntityData$$ExternalSyntheticLambda1;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static final int scheduleImpl;
    @Inject
    public KycAmlEddPresenter kycAmlEddPresenter;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$a = {104, -34, -42, -1, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 158;
    public static final byte[] getAuthRequestContext = {Ascii.ETB, -59, 18, 83, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = FileUtils.JPEG_MARKER_EOI;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final ArrayList<EddQuestionInfoDTOModel> PlaceComponentResult = new ArrayList<>();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ArrayList<EddQuestionInfoDTOModel> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList<>();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.home.KycAmlEddActivity$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLoadingDialog invoke() {
            return new DanaLoadingDialog(KycAmlEddActivity.this);
        }
    });

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<KycEmlAddAdapter>() { // from class: id.dana.home.KycAmlEddActivity$kycEmlAddAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KycEmlAddAdapter invoke() {
            final KycAmlEddActivity kycAmlEddActivity = KycAmlEddActivity.this;
            return new KycEmlAddAdapter(new Function2<String, String, Unit>() { // from class: id.dana.home.KycAmlEddActivity$kycEmlAddAdapter$2.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    KycAmlEddActivity.access$onRadioButtonSelectedListener(KycAmlEddActivity.this, str, str2);
                }
            });
        }
    });

    static void PlaceComponentResult() {
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 56020;
        DatabaseTableConfigUtil = 4360990799332652212L;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = -956812108;
    }

    private static void b(short s, short s2, int i, Object[] objArr) {
        int i2 = 55 - s;
        byte[] bArr = getAuthRequestContext;
        int i3 = i + 97;
        int i4 = s2 + 16;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i3 = (i3 + i2) - 4;
            i2 = i2;
            i6 = i6;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i3;
            int i8 = i2 + 1;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i8];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i3 = (i3 + b) - 4;
            i2 = i8;
            i6 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            byte[] r0 = id.dana.animation.KycAmlEddActivity.$$a
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = 47 - r6
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r4 = 0
            r3 = r6
            goto L26
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            r3 = r0[r6]
        L26:
            int r6 = r6 + 1
            int r3 = -r3
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.KycAmlEddActivity.c(byte, int, short, java.lang.Object[]):void");
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

    /* JADX WARN: Removed duplicated region for block: B:111:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0775  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0779  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0955  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x095a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0b30 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x02a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x029e  */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r33) {
        /*
            Method dump skipped, instructions count: 3272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.KycAmlEddActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
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
        return R.layout.activity_kyc_aml_edd;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{14419, 2414, 60716, 37863}, getPackageName().codePointAt(1) - 100, (char) ((Process.myPid() >> 22) + 59373), new char[]{21142, 39169, 32128, 58188, 7909, 13837, 19396, 23161, 44979, 34197, 64861, 29417, 24936, 7855, 36761, 42326, 10556, 34388}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {32739, 28751, 63236, 26985};
        int lastIndexOf = 74469246 - TextUtils.lastIndexOf("", '0', 0, 0);
        try {
            Object[] objArr3 = new Object[1];
            b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), objArr4);
            Object[] objArr5 = new Object[1];
            a(cArr, cArr2, lastIndexOf, (char) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 27094), new char[]{58512, 4954, 43450, 17594, 60585}, objArr5);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{37058, 39268, 33009, 29911}, super.getResources().getString(R.string.card_binding_oneklik_content).substring(9, 22).length() - 13, (char) (getPackageName().codePointAt(3) + 55068), new char[]{54958, 32622, 23268, 14496, 51772, 52432, 11003, 13351, 49202, 38029, 48125, 7485, 55734, 6056, 17502, 1313, 23775, 49240, 59944, 44317, 61056, 27055, 53214, 12619, 34961, 39268}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{25186, 34380, 17383, 3988}, super.getResources().getString(R.string.tooltip_dana_cicil_available_description).substring(0, 1).codePointAt(0) - 84, (char) (37955 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), new char[]{1645, 57839, 14266, 49032, 58633, 46058, 44727, 42996, 61189, 60387, 34349, 33980, 36957, 45077, 3831, 10943, 59993, 44296}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), Color.blue(0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{23315, 58240, 55642, 55713}, getPackageName().length() - 7, (char) (getPackageName().length() - 7), new char[]{3478, 33081, 51249, 2510, 1254, 27334, 33152, 24213, 9814, 47782, 31874, 58745, 38058, 24990, 40801, 65120, 55806, 46128, 51968, 6689, 57409, 3488, 5820, 15902, 7083, 32850, 50633, 38061, 19687, 24594, 4388, 61860, 11654, 38196, 18197, 61892, 55865, 51255, 20207, 21530, 20268, 26773, 58344, 30850, 14712, 18066, 63298, 45727}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{52098, 20275, 40626, 43859}, super.getResources().getString(R.string.desc_home_feed_onboarding_3).substring(28, 29).length() - 1, (char) (getPackageName().length() - 7), new char[]{18484, 27465, 22617, 27182, 31792, 28841, 23147, 64271, 26736, 369, 16731, 46119, 21481, 33354, 5180, 62387, 11147, 40159, 961, 21819, 34448, 1740, 4698, 53328, 3422, 39345, 6361, 31128, 38810, 10604, 33947, 423, 21229, 63699, 37675, 17278, 25398, 29736, 32316, 40607, 59734, 47057, 37738, 33621, 34766, 44070, 62981, 42800, 13269, 28380, 33253, 55496, 9916, 15296, 56651, 12549, 41010, 60632, 54714, 8067, 40017, 62601, 8359, 64745}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(new char[]{0, 0, 0, 0}, new char[]{16999, 61124, 40551, 56692}, super.getResources().getString(R.string.incorrect_expiry_date).substring(6, 7).length() - 1, (char) (super.getResources().getString(R.string.tv_empty_state_desc).substring(17, 18).length() - 1), new char[]{18266, 44330, 60955, 9732, 11494, 41153, 39474, 14766, 57236, 3787, 35427, 30540, 37226, 55603, 47797, 63070, 31063, 47912, 7094, 2343, 65006, 11816, 5909, 18352, 42358, 3661, 59443, 39730, 38947, 1543, 21939, 17654, 12392, 2116, 2816, 2604, 8654, 63802, 43023, 43579, 33838, 41853, 48337, 25452, 18580, 44806, 13887, 1695, 19028, 27974, 18454, 19455, 30683, 23176, 51065, 52378, 13459, 10437, 61797, 10736, 16999, 36162, 9783, 54508}, objArr10);
                        String str3 = (String) objArr10[0];
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {55667, 16509, 54047, 60251};
                        int i = (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                        try {
                            Object[] objArr11 = new Object[1];
                            b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                            Object[] objArr12 = new Object[1];
                            a(cArr3, cArr4, i, (char) (((ApplicationInfo) cls4.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{39441, 37715, 63484, 50006, 24064, 55759, 37686, 28527, 14651, 31464, 52729, 61901, 6914, 6456, 51816, 19840, 43688, 40926, 13471, 42155, 8949, 36397, 10074, 9611, 26418, 38787, 42828, 45748, 3366, 30237, 48281, 55116, 10607, 37403, 23340, 30470, 20168, 13808, 29807, 11614, 44172, 38949, 56303, 141, 59396, 23352, 65109, 33126, 33549, 13618, 48882, 213, 14789, 63376, 11392, 5732, 6282, 41163, 60603, 55893}, objArr12);
                            String str4 = (String) objArr12[0];
                            char[] cArr5 = {0, 0, 0, 0};
                            char[] cArr6 = {17295, 28674, 25801, 37249};
                            int length = super.getResources().getString(R.string.profile_completion_task_description_trusted_device).substring(1, 2).length() - 1;
                            try {
                                Object[] objArr13 = new Object[1];
                                b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr13);
                                Class<?> cls5 = Class.forName((String) objArr13[0]);
                                Object[] objArr14 = new Object[1];
                                b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), objArr14);
                                Object[] objArr15 = new Object[1];
                                a(cArr5, cArr6, length, (char) (((ApplicationInfo) cls5.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 33091), new char[]{8496, 20069, 35339, 29371, 22451, 37195}, objArr15);
                                try {
                                    Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                }
            }
            try {
                Object[] objArr17 = new Object[1];
                b(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr17);
                Class<?> cls6 = Class.forName((String) objArr17[0]);
                byte b = (byte) (getAuthRequestContext[34] + 1);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr18 = new Object[1];
                b(b, b2, (byte) (b2 | 8), objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - ImageFormat.getBitsPerPixel(0), 3 - TextUtils.lastIndexOf("", '0', 0), (char) (KeyEvent.getMaxKeyCode() >> 16));
                        Object[] objArr20 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[9]), (byte) ($$a[47] - 1), objArr20);
                        obj3 = cls7.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i2 = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, View.MeasureSpec.getSize(0) + 35, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr22 = {447214369, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr22);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{37058, 39268, 33009, 29911}, super.getResources().getString(R.string.error_zero_pending_balance).substring(24, 26).codePointAt(0) - 46, (char) (55168 - View.resolveSize(0, 0)), new char[]{54958, 32622, 23268, 14496, 51772, 52432, 11003, 13351, 49202, 38029, 48125, 7485, 55734, 6056, 17502, 1313, 23775, 49240, 59944, 44317, 61056, 27055, 53214, 12619, 34961, 39268}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {25186, 34380, 17383, 3988};
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                Object[] objArr3 = new Object[1];
                a(cArr, cArr2, ((ApplicationInfo) cls2.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(1) + 37855), new char[]{1645, 57839, 14266, 49032, 58633, 46058, 44727, 42996, 61189, 60387, 34349, 33980, 36957, 45077, 3831, 10943, 59993, 44296}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ExpandableListView.getPackedPositionChild(0L), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{37058, 39268, 33009, 29911}, View.resolveSize(0, 0), (char) (getPackageName().length() + 55161), new char[]{54958, 32622, 23268, 14496, 51772, 52432, 11003, 13351, 49202, 38029, 48125, 7485, 55734, 6056, 17502, 1313, 23775, 49240, 59944, 44317, 61056, 27055, 53214, 12619, 34961, 39268}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{25186, 34380, 17383, 3988}, super.getResources().getString(R.string.text_maintenance_country).substring(44, 45).length() - 1, (char) (super.getResources().getString(R.string.title_bank_search).substring(2, 3).codePointAt(0) + 37847), new char[]{1645, 57839, 14266, 49032, 58633, 46058, 44727, 42996, 61189, 60387, 34349, 33980, 36957, 45077, 3831, 10943, 59993, 44296}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, 35 - View.resolveSize(0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) (MotionEvent.axisFromString("") + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getKycAmlEddPresenter")
    public final KycAmlEddPresenter getKycAmlEddPresenter() {
        KycAmlEddPresenter kycAmlEddPresenter = this.kycAmlEddPresenter;
        if (kycAmlEddPresenter != null) {
            return kycAmlEddPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setKycAmlEddPresenter")
    public final void setKycAmlEddPresenter(KycAmlEddPresenter kycAmlEddPresenter) {
        Intrinsics.checkNotNullParameter(kycAmlEddPresenter, "");
        this.kycAmlEddPresenter = kycAmlEddPresenter;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/home/KycAmlEddActivity$Companion;", "", "", "scheduleImpl", "I", "getAuthRequestContext", "()I", "BuiltInFictitiousFunctionClassFactory", "", "KYC_AML_EDD_INTENT", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getAuthRequestContext")
        public static int getAuthRequestContext() {
            return KycAmlEddActivity.scheduleImpl;
        }
    }

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
        scheduleImpl = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void $r8$lambda$li7yiNXbQRSbW82boqQLcHayMFA(KycAmlEddActivity kycAmlEddActivity, View view) {
        Intrinsics.checkNotNullParameter(kycAmlEddActivity, "");
        final KycAmlEddPresenter kycAmlEddPresenter = kycAmlEddActivity.getKycAmlEddPresenter();
        String str = kycAmlEddActivity.BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        Intrinsics.checkNotNullParameter(str, "");
        kycAmlEddPresenter.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        kycAmlEddPresenter.MyBillsEntityDataFactory.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.kycamledd.KycAmlEddPresenter$submitKycAmlEdd$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                dagger.Lazy lazy;
                dagger.Lazy lazy2;
                dagger.Lazy lazy3;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                lazy = KycAmlEddPresenter.this.BuiltInFictitiousFunctionClassFactory;
                ((KycAmlEddContract.View) lazy.get()).dismissProgress();
                if (booleanValue) {
                    lazy3 = KycAmlEddPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    ((KycAmlEddContract.View) lazy3.get()).getAuthRequestContext();
                    return;
                }
                lazy2 = KycAmlEddPresenter.this.BuiltInFictitiousFunctionClassFactory;
                ((KycAmlEddContract.View) lazy2.get()).onError("");
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                dagger.Lazy lazy;
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.SUBMIT_KYC_AML_EDD, p0.getMessage());
                lazy = KycAmlEddPresenter.this.BuiltInFictitiousFunctionClassFactory;
                ((KycAmlEddContract.View) lazy.get()).onError("");
            }
        }, new SubmitEddAmlKyc.Params(EddSubmitInfoModelToEddSubmitInfoMapperKt.MyBillsEntityDataFactory(kycAmlEddPresenter.KClassImpl$Data$declaredNonStaticMembers$2(str))));
    }

    public static final /* synthetic */ void access$checkButtonAvailability(KycAmlEddActivity kycAmlEddActivity, int i) {
        Button button;
        if (i < kycAmlEddActivity.KClassImpl$Data$declaredNonStaticMembers$2.size() || (button = (Button) kycAmlEddActivity._$_findCachedViewById(R.id.btn_verify_kyc_aml)) == null) {
            return;
        }
        button.setEnabled(true);
    }

    public static final /* synthetic */ void access$onRadioButtonSelectedListener(KycAmlEddActivity kycAmlEddActivity, String str, String str2) {
        KycAmlEddPresenter kycAmlEddPresenter = kycAmlEddActivity.getKycAmlEddPresenter();
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        kycAmlEddPresenter.KClassImpl$Data$declaredNonStaticMembers$2.put(str, str2);
        KycAmlEddPresenter kycAmlEddPresenter2 = kycAmlEddActivity.getKycAmlEddPresenter();
        kycAmlEddPresenter2.BuiltInFictitiousFunctionClassFactory.get().MyBillsEntityDataFactory(kycAmlEddPresenter2.KClassImpl$Data$declaredNonStaticMembers$2.size());
    }

    public static final /* synthetic */ void access$showLoading(KycAmlEddActivity kycAmlEddActivity) {
        DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) kycAmlEddActivity.getAuthRequestContext.getValue();
        if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
            return;
        }
        danaLoadingDialog.MyBillsEntityDataFactory.show();
        danaLoadingDialog.getAuthRequestContext.startRefresh();
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerKycAmlEddActivityComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerKycAmlEddActivityComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (KycAmlEddModule) Preconditions.getAuthRequestContext(new KycAmlEddModule(new KycAmlEddContract.View() { // from class: id.dana.home.KycAmlEddActivity$initInjector$1
            @Override // id.dana.kycamledd.KycAmlEddContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0, EddConsultModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
            }

            @Override // id.dana.kycamledd.KycAmlEddContract.View
            public final void getAuthRequestContext() {
                KycAmlEddActivity.this.finish();
            }

            @Override // id.dana.kycamledd.KycAmlEddContract.View
            public final void MyBillsEntityDataFactory(int p0) {
                KycAmlEddActivity.access$checkButtonAvailability(KycAmlEddActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                KycAmlEddActivity.access$showLoading(KycAmlEddActivity.this);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                ((DanaLoadingDialog) KycAmlEddActivity.this.getAuthRequestContext.getValue()).PlaceComponentResult();
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((DanaLoadingDialog) KycAmlEddActivity.this.getAuthRequestContext.getValue()).PlaceComponentResult();
                KycAmlEddActivity kycAmlEddActivity = KycAmlEddActivity.this;
                CustomToastUtil.PlaceComponentResult(kycAmlEddActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_failed, kycAmlEddActivity.getString(R.string.kyc_aml_edd_activity_snackbar_text), 48, 60, false, null, 384);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KycAmlEddModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerKycAmlEddActivityComponent.KycAmlEddActivityComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getKycAmlEddPresenter());
        EddInfoModel eddInfoModel = (EddInfoModel) getIntent().getParcelableExtra(KYC_AML_EDD_INTENT);
        if (eddInfoModel != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.addAll(eddInfoModel.MyBillsEntityDataFactory);
            this.BuiltInFictitiousFunctionClassFactory = eddInfoModel.PlaceComponentResult;
        }
        setTitle(getString(R.string.kyc_aml_edd_activity_toolbar));
        Button button = (Button) _$_findCachedViewById(R.id.btn_verify_kyc_aml);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.KycAmlEddActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KycAmlEddActivity.$r8$lambda$li7yiNXbQRSbW82boqQLcHayMFA(KycAmlEddActivity.this, view);
                }
            });
        }
        this.PlaceComponentResult.add(new EddQuestionInfoDTOModel(null, null, null, 0, 7, null));
        this.PlaceComponentResult.addAll(this.KClassImpl$Data$declaredNonStaticMembers$2);
        ((KycEmlAddAdapter) this.MyBillsEntityDataFactory.getValue()).setItems(this.PlaceComponentResult);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a115e_collectioncodeauthentitydata_1);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter((KycEmlAddAdapter) this.MyBillsEntityDataFactory.getValue());
        }
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
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (DatabaseTableConfigUtil ^ 4360990799332652212L)) ^ ((int) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
