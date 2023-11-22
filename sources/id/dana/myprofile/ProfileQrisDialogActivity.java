package id.dana.myprofile;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerProfileQrisDialogComponent;
import id.dana.myprofile.model.QrisTciCoConfigModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.QRView;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.BrightnessUtil;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.UrlUtil;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u00020\u000e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0015\u0010\fR\"\u0010\u0018\u001a\u00020\u00178\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001e\u0010\f"}, d2 = {"Lid/dana/myprofile/ProfileQrisDialogActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "onPause", "onStart", "", "scheduleImpl", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "getStaticQrPresenter", "Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "getGetStaticQrPresenter", "()Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;", "setGetStaticQrPresenter", "(Lid/dana/contract/staticqr/GetStaticQrContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "profileQrDeepLinkPresenter", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "getProfileQrDeepLinkPresenter", "()Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "setProfileQrDeepLinkPresenter", "(Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;)V", "getErrorConfigVersion", "MyBillsEntityDataFactory", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileQrisDialogActivity extends BaseActivity {
    public static final byte[] $$a = {61, 16, -46, 32, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 1;
    public static final byte[] PlaceComponentResult = {96, 83, 72, -80, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 222;
    private static int[] lookAheadTest = {524690540, -302876486, -1721347733, 1507729495, 2141272825, -705053825, 1999494412, -839516109, -1085478697, -1629806612, 660460710, 1772099509, 1222865452, -1912949423, 200491556, 1949956161, 1979166615, 1245565778};

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    @Inject
    public GetStaticQrContract.Presenter getStaticQrPresenter;
    @Inject
    public GenerateDeepLinkContract.ProfilePresenter profileQrDeepLinkPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String getAuthRequestContext;

    public static /* synthetic */ void $r8$lambda$g1D2LPECIAoedCzqIiy47GIIjQU(View view) {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.myprofile.ProfileQrisDialogActivity.PlaceComponentResult
            int r9 = 55 - r9
            int r7 = r7 + 97
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L15
            r7 = r9
            r3 = r1
            r4 = 0
            r9 = r8
            r1 = r0
            r0 = r10
            r10 = r7
            goto L33
        L15:
            r3 = 0
            r6 = r9
            r9 = r7
            r7 = r6
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.ProfileQrisDialogActivity.b(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 46 - r7
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.myprofile.ProfileQrisDialogActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.ProfileQrisDialogActivity.c(short, byte, short, java.lang.Object[]):void");
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
        a((Process.myPid() >> 22) + 18, new int[]{-429901492, -1085708547, -1051116964, -1263935874, 601459435, 2062605180, 1483567776, -552356150, 805360650, 1331654339}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(TextUtils.indexOf((CharSequence) "", '0') + 6, new int[]{645378854, -950563762, -1222265240, 1007908757}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), 34 - ExpandableListView.getPackedPositionChild(0L), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new int[]{-1007839079, -1285953444, -1902074100, -1054400279, -1824772381, 1262063411, -1558356431, 1246311849, 1949487223, 1890533246, -1314382799, 530667281, 418629498, -200279664, 686570389, 1078099121, 1006816887, 1521784473, -1062603301, -580804963, 550310385, 1639366666, -2105957179, 1122424048}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((ViewConfiguration.getScrollBarSize() >> 8) + 64, new int[]{591604989, 1838144508, 122623239, 1475501994, -143146283, -1445990341, -1598440550, -940568333, 623535097, 335090103, 1388049125, 721184613, 1325150404, 1806855364, 715552574, 470050936, -959156100, 1530109109, -1220146052, 480328440, -1224056881, -18828742, -1285147866, -1281423151, -874028431, 1691094171, -1132743383, 1918523463, -2005764942, 2002840793, -323463357, -1632753286}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - View.combineMeasuredStates(0, 0), new int[]{529119757, 536001132, -1018751404, 899077211, -1559809275, 2034420642, 614788387, -806435301, -835819856, 145686811, -497520709, 1299533466, 1005752934, -476716343, -243836424, -158229660, 2065084640, -1986241913, -44993915, -391220723, -1600907125, 377779168, -987762037, -2106908274, -1683210938, -1532691688, -837198006, -1111543938, 786058249, -1979635892, -300424570, 1844810564}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(59 - TextUtils.lastIndexOf("", '0', 0, 0), new int[]{1970432297, -2119963377, 1932140347, -2110053183, 2040316479, 1064584547, 1055357415, 1951147510, 675057123, 520659013, -582361353, -664967601, -80617079, 1990587627, -913143588, 1843019384, -431492649, 253784126, 1963984161, -1024428514, -741763879, -1486191901, 1277393911, 71271485, -874730016, -1933548135, -125791801, -1689943638, -1176380310, -273361914}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(KeyEvent.normalizeMetaState(0) + 6, new int[]{1908176098, 830892759, -80026501, 394254169}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                byte b = (byte) (getAuthRequestContext & 40);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr15 = new Object[1];
                b(b, b2, (byte) (b2 | Ascii.RS), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - View.MeasureSpec.makeMeasureSpec(0, 0), 3 - TextUtils.getCapsMode("", 0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        Object[] objArr17 = new Object[1];
                        c((byte) $$b, $$a[53], (byte) $$b, objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 800, 15 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((-1) - Process.getGidForName("")))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Drawable.resolveOpacity(0, 0), 15 - Color.red(0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - Process.getGidForName(""), 29 - View.MeasureSpec.getSize(0), (char) (57994 - (ViewConfiguration.getKeyRepeatDelay() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSizeAndState(0, 0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 16, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.makeMeasureSpec(0, 0) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {1570647386, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 17 - TextUtils.lastIndexOf("", '0', 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                byte b3 = (byte) (getAuthRequestContext & 40);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr22 = new Object[1];
                b(b3, b4, (byte) (b4 | Ascii.RS), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext('m' - AndroidCharacter.getMirror('0'), ExpandableListView.getPackedPositionType(0L) + 46, (char) (ExpandableListView.getPackedPositionChild(0L) + 1));
                        Object[] objArr24 = new Object[1];
                        c((byte) ($$b - 1), $$a[84], $$a[9], objArr24);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), 34 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {1570647386, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), Color.rgb(0, 0, 0) + 16777234, (char) TextUtils.indexOf("", "", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                byte b5 = (byte) (getAuthRequestContext & 40);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr29 = new Object[1];
                b(b5, b6, (byte) (b6 | Ascii.RS), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 118, TextUtils.indexOf("", "") + 3, (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 38968));
                        Object[] objArr31 = new Object[1];
                        c((byte) ($$b - 1), $$a[84], $$a[9], objArr31);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {1570647386, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), 17 - TextUtils.lastIndexOf("", '0'), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                byte b7 = (byte) (getAuthRequestContext & 40);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr36 = new Object[1];
                b(b7, b8, (byte) (b8 | Ascii.RS), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Color.green(0), KeyEvent.getDeadChar(0, 0) + 3, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                        byte b9 = $$a[8];
                        byte b10 = (byte) ($$b - 1);
                        Object[] objArr38 = new Object[1];
                        c(b9, b10, b10, objArr38);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), ExpandableListView.getPackedPositionChild(0L) + 36, (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {1570647386, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_profile_qris_dialog;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(18 - (ViewConfiguration.getScrollBarSize() >> 8), new int[]{-429901492, -1085708547, -1051116964, -1263935874, 601459435, 2062605180, 1483567776, -552356150, 805360650, 1331654339}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(R.string.send_money_save_rename_bank_account).substring(0, 1).length() + 4, new int[]{645378854, -950563762, -1222265240, 1007908757}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr4 = new Object[1];
                    b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-429901492, -1085708547, -1051116964, -1263935874, 254148600, -2086805413, -1502175757, -1705669803, -1132496454, 1527030499, 1801597558, 570805249, -1747996223, 1461923588}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(View.MeasureSpec.getSize(0) + 18, new int[]{90216, 670978076, 1711863381, -1542206354, -1231981274, -1244789453, -1463805563, 2066180053, -1359821856, 2121854719}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", "", 0), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr7 = new Object[1];
                        b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr8);
                        Object[] objArr9 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 15, new int[]{-1007839079, -1285953444, -1902074100, -1054400279, -1824772381, 1262063411, -1558356431, 1246311849, 1949487223, 1890533246, -1314382799, 530667281, 418629498, -200279664, 686570389, 1078099121, 1006816887, 1521784473, -1062603301, -580804963, 550310385, 1639366666, -2105957179, 1122424048}, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(65 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new int[]{591604989, 1838144508, 122623239, 1475501994, -143146283, -1445990341, -1598440550, -940568333, 623535097, 335090103, 1388049125, 721184613, 1325150404, 1806855364, 715552574, 470050936, -959156100, 1530109109, -1220146052, 480328440, -1224056881, -18828742, -1285147866, -1281423151, -874028431, 1691094171, -1132743383, 1918523463, -2005764942, 2002840793, -323463357, -1632753286}, objArr10);
                        String str2 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 63, new int[]{529119757, 536001132, -1018751404, 899077211, -1559809275, 2034420642, 614788387, -806435301, -835819856, 145686811, -497520709, 1299533466, 1005752934, -476716343, -243836424, -158229660, 2065084640, -1986241913, -44993915, -391220723, -1600907125, 377779168, -987762037, -2106908274, -1683210938, -1532691688, -837198006, -1111543938, 786058249, -1979635892, -300424570, 1844810564}, objArr11);
                        String str3 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(KeyEvent.keyCodeFromString("") + 60, new int[]{1970432297, -2119963377, 1932140347, -2110053183, 2040316479, 1064584547, 1055357415, 1951147510, 675057123, 520659013, -582361353, -664967601, -80617079, 1990587627, -913143588, 1843019384, -431492649, 253784126, 1963984161, -1024428514, -741763879, -1486191901, 1277393911, 71271485, -874730016, -1933548135, -125791801, -1689943638, -1176380310, -273361914}, objArr12);
                        String str4 = (String) objArr12[0];
                        try {
                            Object[] objArr13 = new Object[1];
                            b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr13);
                            Class<?> cls5 = Class.forName((String) objArr13[0]);
                            b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                            Object[] objArr14 = new Object[1];
                            a(((ApplicationInfo) cls5.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 27, new int[]{1908176098, 830892759, -80026501, 394254169}, objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.MeasureSpec.getSize(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
            Object[] objArr16 = new Object[1];
            b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr16);
            Class<?> cls6 = Class.forName((String) objArr16[0]);
            byte b = (byte) (getAuthRequestContext & 40);
            byte b2 = PlaceComponentResult[25];
            Object[] objArr17 = new Object[1];
            b(b, b2, (byte) (b2 | Ascii.RS), objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.green(0), 4 - (Process.myPid() >> 22), (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                    byte b3 = $$a[8];
                    byte b4 = (byte) ($$b - 1);
                    Object[] objArr19 = new Object[1];
                    c(b3, b4, b4, objArr19);
                    obj3 = cls7.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-222780653, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 912, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(getPackageName().length() + 19, new int[]{-429901492, -1085708547, -1051116964, -1263935874, 254148600, -2086805413, -1502175757, -1705669803, -1132496454, 1527030499, 1801597558, 570805249, -1747996223, 1461923588}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{90216, 670978076, 1711863381, -1542206354, -1231981274, -1244789453, -1463805563, 2066180053, -1359821856, 2121854719}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getGetStaticQrPresenter")
    public final GetStaticQrContract.Presenter getGetStaticQrPresenter() {
        GetStaticQrContract.Presenter presenter = this.getStaticQrPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetStaticQrPresenter")
    public final void setGetStaticQrPresenter(GetStaticQrContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.getStaticQrPresenter = presenter;
    }

    @JvmName(name = "getProfileQrDeepLinkPresenter")
    public final GenerateDeepLinkContract.ProfilePresenter getProfileQrDeepLinkPresenter() {
        GenerateDeepLinkContract.ProfilePresenter profilePresenter = this.profileQrDeepLinkPresenter;
        if (profilePresenter != null) {
            return profilePresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setProfileQrDeepLinkPresenter")
    public final void setProfileQrDeepLinkPresenter(GenerateDeepLinkContract.ProfilePresenter profilePresenter) {
        Intrinsics.checkNotNullParameter(profilePresenter, "");
        this.profileQrDeepLinkPresenter = profilePresenter;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        BrightnessUtil.KClassImpl$Data$declaredNonStaticMembers$2(this);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("USER_ID");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.MyBillsEntityDataFactory = stringExtra;
            String stringExtra2 = intent.getStringExtra(ShareQrDialog.AVATAR_URL);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.getAuthRequestContext = stringExtra2;
            String stringExtra3 = intent.getStringExtra(ShareQrDialog.KYC_STATUS);
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.BuiltInFictitiousFunctionClassFactory = stringExtra3;
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_userid_static);
        byte b = 0;
        if (textView != null) {
            String str = this.MyBillsEntityDataFactory;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            textView.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(str, false));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_main_qr_profile);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.ProfileQrisDialogActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileQrisDialogActivity.$r8$lambda$BI1sIPlLGwr2qT6No0bumaZVqbs(ProfileQrisDialogActivity.this, view);
                }
            });
        }
        DaggerProfileQrisDialogComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerProfileQrisDialogComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (GetStaticQrModule) Preconditions.getAuthRequestContext(new GetStaticQrModule(new GetStaticQrContract.View() { // from class: id.dana.myprofile.ProfileQrisDialogActivity$initComponent$1
            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final void PlaceComponentResult(String p0, String p1, String p2, String p3, String p4) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final void getAuthRequestContext(QrisTciCoConfigModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final void getAuthRequestContext(Long p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.contract.staticqr.GetStaticQrContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                if (p0 != null) {
                    ProfileQrisDialogActivity profileQrisDialogActivity = ProfileQrisDialogActivity.this;
                    if (p0.length() > 0) {
                        if (!UrlUtil.getErrorConfigVersion(p0)) {
                            ProfileQrisDialogActivity.access$showQrImage(profileQrisDialogActivity, p0);
                            return;
                        } else {
                            profileQrisDialogActivity.getProfileQrDeepLinkPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0, profileQrisDialogActivity.getString(R.string.deeplink_title_request_money), profileQrisDialogActivity.getString(R.string.deeplink_description_request_money), true);
                            return;
                        }
                    }
                    ProfileQrisDialogActivity.access$onQrEmpty(profileQrisDialogActivity);
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                ProfileQrisDialogActivity.access$onQrEmpty(ProfileQrisDialogActivity.this);
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (GenerateDeepLinkModule) Preconditions.getAuthRequestContext(new GenerateDeepLinkModule(new GenerateDeepLinkContract.ProfileView() { // from class: id.dana.myprofile.ProfileQrisDialogActivity$initComponent$2
            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void MyBillsEntityDataFactory(Long p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                QRView qRView = (QRView) ProfileQrisDialogActivity.this._$_findCachedViewById(R.id.KycInProgressBottomSheet);
                if (qRView != null) {
                    qRView.showSkeleton();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                QRView qRView = (QRView) ProfileQrisDialogActivity.this._$_findCachedViewById(R.id.KycInProgressBottomSheet);
                if (qRView != null) {
                    qRView.hideSkeleton();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                ProfileQrisDialogActivity.this.showToast(p0);
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                ProfileQrisDialogActivity.access$showQrImage(ProfileQrisDialogActivity.this, String.valueOf(p0));
            }

            @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
            public final void PlaceComponentResult() {
                ProfileQrisDialogActivity.this.getGetStaticQrPresenter().getAuthRequestContext();
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, GetStaticQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, GenerateDeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerProfileQrisDialogComponent.ProfileQrisDialogComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, b).getAuthRequestContext(this);
        registerPresenter(getGetStaticQrPresenter(), getProfileQrDeepLinkPresenter());
        getGetStaticQrPresenter().getAuthRequestContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(27 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new int[]{-429901492, -1085708547, -1051116964, -1263935874, 254148600, -2086805413, -1502175757, -1705669803, -1132496454, 1527030499, 1801597558, 570805249, -1747996223, 1461923588}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.pushverify_list_empty_title).substring(5, 6).length() + 17, new int[]{90216, 670978076, 1711863381, -1542206354, -1231981274, -1244789453, -1463805563, 2066180053, -1359821856, 2121854719}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 35 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    public static /* synthetic */ void $r8$lambda$BI1sIPlLGwr2qT6No0bumaZVqbs(ProfileQrisDialogActivity profileQrisDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(profileQrisDialogActivity, "");
        profileQrisDialogActivity.finish();
    }

    /* renamed from: $r8$lambda$Ut6s8h-n_aChik3HRm5YQwFxlNg */
    public static /* synthetic */ void m2690$r8$lambda$Ut6s8hn_aChik3HRm5YQwFxlNg(ProfileQrisDialogActivity profileQrisDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(profileQrisDialogActivity, "");
        profileQrisDialogActivity.getGetStaticQrPresenter().getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$atxlAv9mca23esSxWz2Aa6wMHYI(QRView qRView, ProfileQrisDialogActivity profileQrisDialogActivity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(qRView, "");
        Intrinsics.checkNotNullParameter(profileQrisDialogActivity, "");
        qRView.hideSkeleton();
        ImageView qrImageView = qRView.getQrImageView();
        if (qrImageView != null) {
            qrImageView.setImageBitmap(bitmap);
        }
        String str = profileQrisDialogActivity.BuiltInFictitiousFunctionClassFactory;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        qRView.setKycView(str);
        String str3 = profileQrisDialogActivity.getAuthRequestContext;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            str2 = str3;
        }
        qRView.displayUserAvatar(str2);
    }

    public static /* synthetic */ void $r8$lambda$tbn2CdRhnbQ6T746U_2bW3dku6o(QRView qRView, ProfileQrisDialogActivity profileQrisDialogActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(qRView, "");
        Intrinsics.checkNotNullParameter(profileQrisDialogActivity, "");
        qRView.hideSkeleton();
        QRView qRView2 = (QRView) profileQrisDialogActivity._$_findCachedViewById(R.id.KycInProgressBottomSheet);
        if (qRView2 != null) {
            qRView2.showEmptyQr();
            qRView2.setOnClickListener(new ProfileQrisDialogActivity$$ExternalSyntheticLambda4(profileQrisDialogActivity));
        }
    }

    public static final /* synthetic */ void access$onQrEmpty(ProfileQrisDialogActivity profileQrisDialogActivity) {
        QRView qRView = (QRView) profileQrisDialogActivity._$_findCachedViewById(R.id.KycInProgressBottomSheet);
        if (qRView != null) {
            qRView.showEmptyQr();
            qRView.setOnClickListener(new ProfileQrisDialogActivity$$ExternalSyntheticLambda4(profileQrisDialogActivity));
        }
    }

    public static final /* synthetic */ void access$showQrImage(final ProfileQrisDialogActivity profileQrisDialogActivity, String str) {
        final QRView qRView = (QRView) profileQrisDialogActivity._$_findCachedViewById(R.id.KycInProgressBottomSheet);
        if (qRView != null) {
            qRView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.ProfileQrisDialogActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileQrisDialogActivity.$r8$lambda$g1D2LPECIAoedCzqIiy47GIIjQU(view);
                }
            });
            qRView.showSkeleton();
            qRView.addDisposable(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(str).subscribe(new Consumer() { // from class: id.dana.myprofile.ProfileQrisDialogActivity$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ProfileQrisDialogActivity.$r8$lambda$atxlAv9mca23esSxWz2Aa6wMHYI(QRView.this, profileQrisDialogActivity, (Bitmap) obj);
                }
            }, new Consumer() { // from class: id.dana.myprofile.ProfileQrisDialogActivity$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ProfileQrisDialogActivity.$r8$lambda$tbn2CdRhnbQ6T746U_2bW3dku6o(QRView.this, profileQrisDialogActivity, (Throwable) obj);
                }
            }));
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = lookAheadTest;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = lookAheadTest;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
