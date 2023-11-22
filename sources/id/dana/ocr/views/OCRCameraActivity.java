package id.dana.ocr.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.controls.Flash;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerOCRCameraComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.OCRCameraModule;
import id.dana.ocr.OCRCameraContract;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.model.OCRResultModel;
import id.dana.ocr.views.OCRPreviewImageActivity;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.LogoProgressView;
import id.dana.richview.camera.DanaCameraView;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0007¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\r\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\r\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0005J)\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b!\u0010\tJ\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\tJ\u001f\u0010(\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010\u0005R\"\u0010,\u001a\u00020+8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108"}, d2 = {"Lid/dana/ocr/views/OCRCameraActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/ocr/OCRCameraContract$View;", "", "capturePicture", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "configToolbar", "Lid/dana/usereducation/model/OnBoardingModel;", "getAuthRequestContext", "()Lid/dana/usereducation/model/OnBoardingModel;", "dismissProgress", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "initComponent", "initViews", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "Landroid/view/View;", "view", "onClickLeftMenuButton", "(Landroid/view/View;)V", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "errorCode", "onFailure", "Lcom/otaliastudios/cameraview/PictureResult;", "pictureResult", "Lid/dana/ocr/model/OCRRequestModel;", "ocrRequestModel", "openPreviewPage", "(Lcom/otaliastudios/cameraview/PictureResult;Lid/dana/ocr/model/OCRRequestModel;)V", "showProgress", "Lid/dana/ocr/OCRCameraContract$Presenter;", "ocrCameraPresenter", "Lid/dana/ocr/OCRCameraContract$Presenter;", "getOcrCameraPresenter", "()Lid/dana/ocr/OCRCameraContract$Presenter;", "setOcrCameraPresenter", "(Lid/dana/ocr/OCRCameraContract$Presenter;)V", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingPresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingPresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingPresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OCRCameraActivity extends BaseActivity implements OCRCameraContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final int OCR_CAMERA_REQUEST_CODE = 4103;
    public static final String OCR_REQUEST_MODEL_KEY = "OCR_REQUEST_MODEL_KEY";
    private static long getErrorConfigVersion;
    private static char lookAheadTest;
    private static int scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public OCRCameraContract.Presenter ocrCameraPresenter;
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingPresenter;
    public static final byte[] $$a = {59, -103, 22, 57, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 117;
    public static final byte[] getAuthRequestContext = {4, -41, 37, 5, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 43;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        lookAheadTest = (char) 18613;
        getErrorConfigVersion = 4360990799332652212L;
        scheduleImpl = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 23 - r7
            int r6 = 106 - r6
            byte[] r0 = id.dana.ocr.views.OCRCameraActivity.getAuthRequestContext
            int r8 = 55 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L14
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L14:
            r3 = 0
        L15:
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L31:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.views.OCRCameraActivity.a(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = 47 - r9
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = id.dana.ocr.views.OCRCameraActivity.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L33
        L17:
            r3 = 0
        L18:
            r6 = r9
            r9 = r8
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r9 = r9 + 1
            int r10 = r10 + r8
            int r8 = r10 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.views.OCRCameraActivity.c(byte, int, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent generateIntent(Context context, OCRRequestModel oCRRequestModel) {
        return Companion.MyBillsEntityDataFactory(context, oCRRequestModel);
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
        b(new char[]{0, 0, 0, 0}, new char[]{59392, 16696, 19292, 51505}, View.MeasureSpec.makeMeasureSpec(0, 0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 12618), new char[]{1973, 46207, 42567, 53940, 2574, 27773, 25632, 62831, 51009, 30159, 547, 9779, 40452, 33382, 63157, 35034, 29200, 25616}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{48411, 10609, 48943, 56588}, 791245245 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 3263), new char[]{25609, 38529, 40096, 41291, 3194}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{29541, 48047, 1919, 49789}, 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8), new char[]{21460, 60159, 15035, 26446, 6260, 4002, 1937, 17396, 22163, 46253, 8191, 683, 45233, 11880, 41858, 27219, 44692, 22813, 43253, 51374, 9878, 14623, 24821, 10270, 5870, 23042, 8330, 34869, 48007, 46311, 43272, 60598, 51350, 25561, 8016, 1787, 26533, 56900, 44829, 44964, 44569, 18011, 39824, 14621, 23199, 25193, 49489, 38279}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{51783, 18672, 48075, 41363}, AndroidCharacter.getMirror('0') - '0', (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), new char[]{8062, 18944, 59680, 34412, 40655, 41300, 15888, 2815, 53282, 23512, 2835, 11548, 61608, 46890, 7865, 64906, 40678, 50313, 45753, 43237, 62670, 3353, 51415, 1582, 29833, 13995, 59332, 54762, 47874, 42849, 8204, 15331, 34647, 29010, 63143, 26407, 27095, 52854, 46199, 61080, 58045, 11543, 32911, 16464, 58418, 39858, 2007, 30361, 9667, 43765, 40586, 9608, 33160, 10583, 28560, 8009, 22084, 20274, 4805, 10311, 10380, 21483, 43029, 43233}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{15455, 19838, 64351, 27935}, Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), new char[]{44966, 18110, 32625, 49492, 22215, 11556, 31430, 19718, 52562, 16687, 22826, 18710, 13555, 53613, 43946, 64649, 26856, 36820, 36275, 3889, 23971, 10955, 20660, 34567, 1073, 6621, 25707, 7382, 44472, 31676, 34889, 35646, 22460, 56940, 21313, 29408, 56002, 38174, 36315, 9047, 36294, 63416, 31904, 20991, 57298, 8393, 5980, 45652, 24753, 59806, 45821, 56902, 2830, 58958, 36196, 42224, 3393, 23920, 7977, 31628, 33260, 60668, 28101, 55003}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{54851, 64373, 4116, 52119}, TextUtils.indexOf("", "", 0, 0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)), new char[]{28043, 14881, 13154, 29733, 4809, 16848, 64242, 16912, 63310, 24516, 27023, 42504, 18169, 30419, 43757, 54797, 8586, 57040, 29094, 15843, 41878, 32484, 23247, 50309, 56535, 36516, 12327, 64655, 5295, 27650, 62486, 40581, 28378, 43023, 55819, 55602, 10059, 9900, 32948, 20150, 47545, 13823, 6281, 49329, 40022, 7518, 22448, 43600, 28525, 35455, 47456, 40744, 44002, 40702, 32687, 23321, 60027, 21393, 44314, 1723}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{4830, 20580, 26480, 42431}, TextUtils.indexOf("", "", 0, 0), (char) ((Process.myPid() >> 22) + 48999), new char[]{38048, 47990, 10826, 21182, 23547, 18096}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, TextUtils.indexOf("", "") + 18, (char) Color.blue(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(getAuthRequestContext[25], getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a(getAuthRequestContext[9], getAuthRequestContext[30], Ascii.RS, objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getJumpTapTimeout() >> 16), ((byte) KeyEvent.getModifierMetaStateMask()) + 4, (char) Color.argb(0, 0, 0, 0));
                        Object[] objArr17 = new Object[1];
                        c($$a[78], $$a[12], $$a[53], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 800, 15 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0), Color.red(0) + 15, (char) View.MeasureSpec.getSize(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - ExpandableListView.getPackedPositionType(0L), 28 - Process.getGidForName(""), (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 15, (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1344266117, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[25], getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                a(getAuthRequestContext[9], getAuthRequestContext[30], Ascii.RS, objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 45 - ExpandableListView.getPackedPositionChild(0L), (char) View.resolveSize(0, 0));
                        byte b = (byte) ($$a[78] - 1);
                        Object[] objArr24 = new Object[1];
                        c(b, b, $$a[84], objArr24);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ExpandableListView.getPackedPositionChild(0L), (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1344266117, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[25], getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                a(getAuthRequestContext[9], getAuthRequestContext[30], Ascii.RS, objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 119, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 2, (char) (TextUtils.getOffsetAfter("", 0) + 38968));
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr31 = new Object[1];
                        c(b2, b2, $$a[84], objArr31);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), TextUtils.getTrimmedLength("") + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1344266117, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[25], getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                a(getAuthRequestContext[9], getAuthRequestContext[30], Ascii.RS, objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 108, 4 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror('0')));
                        Object[] objArr38 = new Object[1];
                        c($$a[8], $$a[9], (byte) ($$a[78] - 1), objArr38);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetAfter("", 0) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1344266117, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_camera;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{59392, 16696, 19292, 51505}, AndroidCharacter.getMirror('0') - '0', (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 12619), new char[]{1973, 46207, 42567, 53940, 2574, 27773, 25632, 62831, 51009, 30159, 547, 9779, 40452, 33382, 63157, 35034, 29200, 25616}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {48411, 10609, 48943, 56588};
        try {
            byte b = (byte) (-getAuthRequestContext[32]);
            byte b2 = getAuthRequestContext[25];
            Object[] objArr3 = new Object[1];
            a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(getAuthRequestContext[48], getAuthRequestContext[3], getAuthRequestContext[25], objArr4);
            Object[] objArr5 = new Object[1];
            b(cArr, cArr2, ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 791245212, (char) (super.getResources().getString(R.string.dana_plus_home_last_updated).substring(0, 16).length() + 3247), new char[]{25609, 38529, 40096, 41291, 3194}, objArr5);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{54330, 58357, 26462, 753}, getPackageName().length() - 7, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 61800), new char[]{14877, 4356, 27011, 11494, 63291, 39771, 23972, 58828, 36816, 17094, 19866, 36365, 53284, 11981, 12792, 48923, 34700, 43862, 41489, 37125, 48825, 293, 33768, 49755, 16423, 2243}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{54228, 20260, 45263, 12183}, super.getResources().getString(R.string.msg_system_busy).substring(2, 7).length() - 5, (char) (super.getResources().getString(R.string.tooltip_onboarding_mapview_title_first).substring(1, 2).length() + 38831), new char[]{47870, 46664, 3464, 48194, 16864, 42343, 50989, 12181, 5324, 39292, 51959, 57472, 9160, 39231, 26389, 42960, 2085, 39107}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, KeyEvent.keyCodeFromString("") + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        b(new char[]{0, 0, 0, 0}, new char[]{29541, 48047, 1919, 49789}, super.getResources().getString(R.string.danapoly_banner_got_a_point_message).substring(0, 5).length() - 5, (char) (super.getResources().getString(R.string.temp_account_freeze_title).substring(10, 12).length() - 2), new char[]{21460, 60159, 15035, 26446, 6260, 4002, 1937, 17396, 22163, 46253, 8191, 683, 45233, 11880, 41858, 27219, 44692, 22813, 43253, 51374, 9878, 14623, 24821, 10270, 5870, 23042, 8330, 34869, 48007, 46311, 43272, 60598, 51350, 25561, 8016, 1787, 26533, 56900, 44829, 44964, 44569, 18011, 39824, 14621, 23199, 25193, 49489, 38279}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b(new char[]{0, 0, 0, 0}, new char[]{51783, 18672, 48075, 41363}, Color.argb(0, 0, 0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), new char[]{8062, 18944, 59680, 34412, 40655, 41300, 15888, 2815, 53282, 23512, 2835, 11548, 61608, 46890, 7865, 64906, 40678, 50313, 45753, 43237, 62670, 3353, 51415, 1582, 29833, 13995, 59332, 54762, 47874, 42849, 8204, 15331, 34647, 29010, 63143, 26407, 27095, 52854, 46199, 61080, 58045, 11543, 32911, 16464, 58418, 39858, 2007, 30361, 9667, 43765, 40586, 9608, 33160, 10583, 28560, 8009, 22084, 20274, 4805, 10311, 10380, 21483, 43029, 43233}, objArr9);
                        String str2 = (String) objArr9[0];
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {15455, 19838, 64351, 27935};
                        int scrollBarSize = ViewConfiguration.getScrollBarSize() >> 8;
                        try {
                            byte b3 = (byte) (-getAuthRequestContext[32]);
                            byte b4 = getAuthRequestContext[25];
                            Object[] objArr10 = new Object[1];
                            a(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            a(getAuthRequestContext[48], getAuthRequestContext[3], getAuthRequestContext[25], new Object[1]);
                            Object[] objArr11 = new Object[1];
                            b(cArr3, cArr4, scrollBarSize, (char) (((ApplicationInfo) cls4.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{44966, 18110, 32625, 49492, 22215, 11556, 31430, 19718, 52562, 16687, 22826, 18710, 13555, 53613, 43946, 64649, 26856, 36820, 36275, 3889, 23971, 10955, 20660, 34567, 1073, 6621, 25707, 7382, 44472, 31676, 34889, 35646, 22460, 56940, 21313, 29408, 56002, 38174, 36315, 9047, 36294, 63416, 31904, 20991, 57298, 8393, 5980, 45652, 24753, 59806, 45821, 56902, 2830, 58958, 36196, 42224, 3393, 23920, 7977, 31628, 33260, 60668, 28101, 55003}, objArr11);
                            String str3 = (String) objArr11[0];
                            char[] cArr5 = {0, 0, 0, 0};
                            char[] cArr6 = {54851, 64373, 4116, 52119};
                            int codePointAt = super.getResources().getString(R.string.join_invitation_success_button_text_awesome).substring(2, 3).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN;
                            try {
                                byte b5 = (byte) (-getAuthRequestContext[32]);
                                byte b6 = getAuthRequestContext[25];
                                Object[] objArr12 = new Object[1];
                                a(b5, b6, (byte) (b6 | TarHeader.LF_BLK), objArr12);
                                Class<?> cls5 = Class.forName((String) objArr12[0]);
                                a(getAuthRequestContext[48], getAuthRequestContext[3], getAuthRequestContext[25], new Object[1]);
                                Object[] objArr13 = new Object[1];
                                b(cArr5, cArr6, codePointAt, (char) (((ApplicationInfo) cls5.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{28043, 14881, 13154, 29733, 4809, 16848, 64242, 16912, 63310, 24516, 27023, 42504, 18169, 30419, 43757, 54797, 8586, 57040, 29094, 15843, 41878, 32484, 23247, 50309, 56535, 36516, 12327, 64655, 5295, 27650, 62486, 40581, 28378, 43023, 55819, 55602, 10059, 9900, 32948, 20150, 47545, 13823, 6281, 49329, 40022, 7518, 22448, 43600, 28525, 35455, 47456, 40744, 44002, 40702, 32687, 23321, 60027, 21393, 44314, 1723}, objArr13);
                                String str4 = (String) objArr13[0];
                                char[] cArr7 = {0, 0, 0, 0};
                                char[] cArr8 = {4830, 20580, 26480, 42431};
                                try {
                                    byte b7 = (byte) (-getAuthRequestContext[32]);
                                    byte b8 = getAuthRequestContext[25];
                                    Object[] objArr14 = new Object[1];
                                    a(b7, b8, (byte) (b8 | TarHeader.LF_BLK), objArr14);
                                    Class<?> cls6 = Class.forName((String) objArr14[0]);
                                    a(getAuthRequestContext[48], getAuthRequestContext[3], getAuthRequestContext[25], new Object[1]);
                                    Object[] objArr15 = new Object[1];
                                    b(cArr7, cArr8, ((ApplicationInfo) cls6.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(1) + 48899), new char[]{38048, 47990, 10826, 21182, 23547, 18096}, objArr15);
                                    try {
                                        Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), 18 - TextUtils.getOffsetBefore("", 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr17 = new Object[1];
                a(getAuthRequestContext[25], getAuthRequestContext[30], (byte) (-getAuthRequestContext[31]), objArr17);
                Class<?> cls7 = Class.forName((String) objArr17[0]);
                Object[] objArr18 = new Object[1];
                a(getAuthRequestContext[9], getAuthRequestContext[30], Ascii.RS, objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getEdgeSlop() >> 16), 4 - View.getDefaultSize(0, 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 1));
                        Object[] objArr20 = new Object[1];
                        c($$a[8], $$a[9], (byte) ($$a[78] - 1), objArr20);
                        obj3 = cls8.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollBarSize() >> 8) + 35, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr22 = {1206688528, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 912, KeyEvent.keyCodeFromString("") + 18, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {54330, 58357, 26462, 753};
            int codePointAt = getPackageName().codePointAt(0) + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS;
            try {
                byte b = (byte) (-getAuthRequestContext[32]);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[48], getAuthRequestContext[3], getAuthRequestContext[25], objArr2);
                Object[] objArr3 = new Object[1];
                b(cArr, cArr2, codePointAt, (char) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 61766), new char[]{14877, 4356, 27011, 11494, 63291, 39771, 23972, 58828, 36816, 17094, 19866, 36365, 53284, 11981, 12792, 48923, 34700, 43862, 41489, 37125, 48825, 293, 33768, 49755, 16423, 2243}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                char[] cArr3 = {0, 0, 0, 0};
                char[] cArr4 = {54228, 20260, 45263, 12183};
                try {
                    byte b3 = (byte) (-getAuthRequestContext[32]);
                    byte b4 = getAuthRequestContext[25];
                    Object[] objArr4 = new Object[1];
                    a(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    a(getAuthRequestContext[48], getAuthRequestContext[3], getAuthRequestContext[25], new Object[1]);
                    Object[] objArr5 = new Object[1];
                    b(cArr3, cArr4, ((ApplicationInfo) cls3.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().length() + 38825), new char[]{47870, 46664, 3464, 48194, 16864, 42343, 50989, 12181, 5324, 39292, 51959, 57472, 9160, 39231, 26389, 42960, 2085, 39107}, objArr5);
                    baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getEdgeSlop() >> 16), 17 - ExpandableListView.getPackedPositionChild(0L), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
        super.onPause();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{54330, 58357, 26462, 753}, super.getResources().getString(R.string.empty_state_investment_desc).substring(5, 6).length() - 1, (char) (61799 - TextUtils.getTrimmedLength("")), new char[]{14877, 4356, 27011, 11494, 63291, 39771, 23972, 58828, 36816, 17094, 19866, 36365, 53284, 11981, 12792, 48923, 34700, 43862, 41489, 37125, 48825, 293, 33768, 49755, 16423, 2243}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{54228, 20260, 45263, 12183}, getPackageName().length() - 7, (char) (38832 - (ViewConfiguration.getWindowTouchSlop() >> 8)), new char[]{47870, 46664, 3464, 48194, 16864, 42343, 50989, 12181, 5324, 39292, 51959, 57472, 9160, 39231, 26389, 42960, 2085, 39107}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 911, 17 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getOcrCameraPresenter")
    public final OCRCameraContract.Presenter getOcrCameraPresenter() {
        OCRCameraContract.Presenter presenter = this.ocrCameraPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOcrCameraPresenter")
    public final void setOcrCameraPresenter(OCRCameraContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.ocrCameraPresenter = presenter;
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

    @Override // id.dana.base.BaseActivity
    public final void init() {
        initComponent();
        registerPresenter(getOcrCameraPresenter());
        initViews();
        getOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("snap_receipt");
    }

    @Override // id.dana.ocr.OCRCameraContract.View
    public final void onFailure(String errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "");
        KClassImpl$Data$declaredNonStaticMembers$2(errorCode);
    }

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        getOcrCameraPresenter().PlaceComponentResult();
    }

    @Override // id.dana.ocr.OCRCameraContract.View
    public final void capturePicture() {
        ((DanaCameraView) _$_findCachedViewById(R.id.DecodeQrImageModule)).takePicture();
    }

    @Override // id.dana.ocr.OCRCameraContract.View
    public final void openPreviewPage(PictureResult pictureResult, OCRRequestModel ocrRequestModel) {
        Intrinsics.checkNotNullParameter(pictureResult, "");
        Intrinsics.checkNotNullParameter(ocrRequestModel, "");
        OCRPreviewImageActivity.Companion companion = OCRPreviewImageActivity.INSTANCE;
        OCRPreviewImageActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this, pictureResult, ocrRequestModel);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.progress_view);
        if (logoProgressView != null) {
            logoProgressView.setVisibility(0);
            logoProgressView.startRefresh();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.progress_view);
        if (logoProgressView != null) {
            logoProgressView.setVisibility(8);
            logoProgressView.startRefresh();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        showToast(errorMessage);
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickLeftMenuButton(View view) {
        getOcrCameraPresenter().PlaceComponentResult();
    }

    public final void initComponent() {
        OCRRequestModel oCRRequestModel = (OCRRequestModel) getIntent().getParcelableExtra(OCR_REQUEST_MODEL_KEY);
        DaggerOCRCameraComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerOCRCameraComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (OCRCameraModule) Preconditions.getAuthRequestContext(new OCRCameraModule(this, oCRRequestModel));
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.ocr.views.OCRCameraActivity$getBottomOnBoardingModule$1
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
                    OCRCameraActivity.access$openBottomSheetOnBoardingViewList(OCRCameraActivity.this);
                    OCRCameraActivity.this.getOnBoardingPresenter().MyBillsEntityDataFactory("snap_receipt");
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                StringBuilder sb = new StringBuilder();
                sb.append(getClass().getName());
                sb.append(" on Error: ");
                sb.append(p0);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, OCRCameraModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerOCRCameraComponent.OCRCameraComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).PlaceComponentResult(this);
    }

    public final void initViews() {
        setMenuLeftButton(R.drawable.btn_arrow_left);
        ((TextView) _$_findCachedViewById(R.id.res_0x7f0a08f7_checkelementindex_kotlin_stdlib)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.ocr.views.OCRCameraActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OCRCameraActivity.$r8$lambda$QBOzVL0dCEewd4NHWShDbjI0CDI(OCRCameraActivity.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.capture_button)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.ocr.views.OCRCameraActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OCRCameraActivity.$r8$lambda$uHQwCt9Wz_t2OTRHx6fMsz3agNU(OCRCameraActivity.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R.id.CoroutineContextImplKt)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.ocr.views.OCRCameraActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OCRCameraActivity.m2757$r8$lambda$2RtM8ykCucYqNpzMgY6z2VmZKE(OCRCameraActivity.this, view);
            }
        });
        ((DanaCameraView) _$_findCachedViewById(R.id.DecodeQrImageModule)).setDanaCameraListener(new DanaCameraView.DanaCameraListener() { // from class: id.dana.ocr.views.OCRCameraActivity$initViews$4
            @Override // id.dana.richview.camera.DanaCameraView.DanaCameraListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                OCRCameraActivity.this.KClassImpl$Data$declaredNonStaticMembers$2("005");
            }

            @Override // id.dana.richview.camera.DanaCameraView.DanaCameraListener
            public final void getAuthRequestContext(PictureResult p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OCRCameraActivity.this.getOcrCameraPresenter().MyBillsEntityDataFactory(p0);
            }
        });
    }

    private final OnBoardingModel getAuthRequestContext() {
        String string = getString(R.string.receipt_photo_intructions);
        Intrinsics.checkNotNullExpressionValue(string, "");
        ArrayList arrayList = new ArrayList();
        String string2 = getString(R.string.bottom_on_boarding_subtitle_snap_receipt_first);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = getString(R.string.bottom_on_boarding_body_snap_receipt_first);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.ic_clear_photo, string2, string3));
        String string4 = getString(R.string.bottom_on_boarding_subtitle_snap_receipt_second);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = getString(R.string.bottom_on_boarding_body_snap_receipt_second);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.ic_transaction_time, string4, string5));
        String string6 = getString(R.string.bottom_on_boarding_subtitle_snap_receipt_third);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        String string7 = getString(R.string.bottom_on_boarding_body_snap_receipt_third);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.ic_point_amount, string6, string7));
        String string8 = getString(R.string.bottom_on_boarding_subtitle_snap_receipt_fourth);
        Intrinsics.checkNotNullExpressionValue(string8, "");
        String string9 = getString(R.string.bottom_on_boarding_body_snap_receipt_fourth);
        Intrinsics.checkNotNullExpressionValue(string9, "");
        arrayList.add(new ContentOnBoardingModel((int) R.drawable.ic_claim_limit, string8, string9));
        return new OnBoardingModel(string, "list", arrayList, "snap_receipt", null, null, null, 112, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intent intent = new Intent();
        intent.putExtra(OCRPreviewImageActivity.KEY_OCR_RESULT_MODEL, new OCRResultModel.Builder(p0).getAuthRequestContext());
        setResult(0, intent);
        finish();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/ocr/views/OCRCameraActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/ocr/model/OCRRequestModel;", "p1", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Lid/dana/ocr/model/OCRRequestModel;)Landroid/content/Intent;", "", "OCR_CAMERA_REQUEST_CODE", "I", "", OCRCameraActivity.OCR_REQUEST_MODEL_KEY, "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0, OCRRequestModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, OCRCameraActivity.class);
            intent.putExtra(OCRCameraActivity.OCR_REQUEST_MODEL_KEY, p1);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$2-RtM8ykCucYqNpzMgY6z2VmZKE  reason: not valid java name */
    public static /* synthetic */ void m2757$r8$lambda$2RtM8ykCucYqNpzMgY6z2VmZKE(OCRCameraActivity oCRCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(oCRCameraActivity, "");
        ((DanaCameraView) oCRCameraActivity._$_findCachedViewById(R.id.DecodeQrImageModule)).toggleTorch();
        if (((ImageView) oCRCameraActivity._$_findCachedViewById(R.id.CoroutineContextImplKt)) != null) {
            Drawable BuiltInFictitiousFunctionClassFactory = Flash.OFF == ((DanaCameraView) oCRCameraActivity._$_findCachedViewById(R.id.DecodeQrImageModule)).getFlash() ? ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(oCRCameraActivity, R.drawable.bg_circle_transparent) : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(oCRCameraActivity, R.drawable.bg_circle_white_transparent);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ((ImageView) oCRCameraActivity._$_findCachedViewById(R.id.CoroutineContextImplKt)).setBackground(BuiltInFictitiousFunctionClassFactory);
            }
            InstrumentInjector.Resources_setImageResource((ImageView) oCRCameraActivity._$_findCachedViewById(R.id.CoroutineContextImplKt), Flash.OFF == ((DanaCameraView) oCRCameraActivity._$_findCachedViewById(R.id.DecodeQrImageModule)).getFlash() ? R.drawable.ic_flash_pay : R.drawable.ic_flash_pay_active);
        }
    }

    public static /* synthetic */ void $r8$lambda$QBOzVL0dCEewd4NHWShDbjI0CDI(OCRCameraActivity oCRCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(oCRCameraActivity, "");
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        oCRCameraActivity.startActivity(BottomSheetHelpActivity.Companion.PlaceComponentResult(oCRCameraActivity, oCRCameraActivity.getAuthRequestContext(), true));
    }

    public static /* synthetic */ void $r8$lambda$uHQwCt9Wz_t2OTRHx6fMsz3agNU(OCRCameraActivity oCRCameraActivity, View view) {
        Intrinsics.checkNotNullParameter(oCRCameraActivity, "");
        if (((DanaCameraView) oCRCameraActivity._$_findCachedViewById(R.id.DecodeQrImageModule)).isTakingPicture()) {
            return;
        }
        oCRCameraActivity.getOcrCameraPresenter().BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void access$openBottomSheetOnBoardingViewList(OCRCameraActivity oCRCameraActivity) {
        BottomSheetHelpActivity.Companion companion = BottomSheetHelpActivity.INSTANCE;
        oCRCameraActivity.startActivity(BottomSheetHelpActivity.Companion.PlaceComponentResult(oCRCameraActivity, oCRCameraActivity.getAuthRequestContext(), true));
    }

    @JvmStatic
    public static final void openOCRCamera(Activity activity, OCRRequestModel oCRRequestModel) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(oCRRequestModel, "");
        activity.startActivityForResult(Companion.MyBillsEntityDataFactory(activity, oCRRequestModel), OCR_CAMERA_REQUEST_CODE);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent;
        if (4626 == requestCode && -1 == resultCode) {
            if (data == null) {
                intent = new Intent();
                intent.putExtra(OCRPreviewImageActivity.KEY_OCR_RESULT_MODEL, new OCRResultModel.Builder("001").getAuthRequestContext());
            } else {
                intent = data;
            }
            setResult(resultCode, intent);
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
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
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getErrorConfigVersion ^ 4360990799332652212L)) ^ ((int) (scheduleImpl ^ 4360990799332652212L))) ^ ((char) (lookAheadTest ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
