package id.dana.ocr.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.otaliastudios.cameraview.PictureResult;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerOCRPreviewImageComponent;
import id.dana.di.modules.OCRPreviewImageModule;
import id.dana.di.modules.PreprocessingAndOcrModule;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import id.dana.ocr.OCRPreviewImageContract;
import id.dana.ocr.PreprocessingAndOcrContract;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.model.OCRResultModel;
import id.dana.ocr.model.OcrAndUploadTaskModel;
import id.dana.ocr.preview.BottomSheetPromptView;
import id.dana.ocr.views.SnapReceiptService;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.LogoProgressView;
import id.dana.richview.imageview.ZoomableImageView;
import id.dana.utils.FileUtil;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0007¢\u0006\u0004\b6\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0005J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\r\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0019\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0019H\u0016¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010\u0005J\u001b\u0010&\u001a\u00020\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b&\u0010\u0016J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010\u0005R\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105"}, d2 = {"Lid/dana/ocr/views/OCRPreviewImageActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/ocr/OCRPreviewImageContract$View;", "", "closePage", "()V", "configToolbar", "dismissProgress", "", "getLayout", "()I", "Ljava/io/File;", "getStorageDir", "()Ljava/io/File;", "hideBottomPrompt", "PlaceComponentResult", IAPSyncCommand.COMMAND_INIT, "initComponent", "initViews", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onFailConvertBitmap", "onFilePathNull", "Landroid/graphics/Bitmap;", "bitmap", "onSuccessConvertImage", "(Landroid/graphics/Bitmap;)V", "Lid/dana/ocr/model/OCRRequestModel;", "ocrRequestModel", BridgeKey.FILE_PATH, "processImageOnBackground", "(Lid/dana/ocr/model/OCRRequestModel;Ljava/lang/String;)V", "imageOrigin", "processImageOnForeground", "showBottomPrompt", "p0", "BuiltInFictitiousFunctionClassFactory", "showProgress", "Lid/dana/ocr/OCRPreviewImageContract$Presenter;", "ocrPreviewImagePresenter", "Lid/dana/ocr/OCRPreviewImageContract$Presenter;", "getOcrPreviewImagePresenter", "()Lid/dana/ocr/OCRPreviewImageContract$Presenter;", "setOcrPreviewImagePresenter", "(Lid/dana/ocr/OCRPreviewImageContract$Presenter;)V", "Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "preprocessingAndOcrPresenter", "Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "getPreprocessingAndOcrPresenter", "()Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "setPreprocessingAndOcrPresenter", "(Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class OCRPreviewImageActivity extends BaseActivity implements OCRPreviewImageContract.View {
    public static final String KEY_OCR_RESULT_MODEL = "KEY_OCR_RESULT_MODEL";
    public static final int OCR_PREVIEW_IMAGE_REQUEST_CODE = 4626;
    private static PictureResult scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public OCRPreviewImageContract.Presenter ocrPreviewImagePresenter;
    @Inject
    public PreprocessingAndOcrContract.Presenter preprocessingAndOcrPresenter;
    public static final byte[] $$a = {97, -108, 86, -98, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 115;
    public static final byte[] getAuthRequestContext = {Ascii.RS, 119, -63, 113, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 58;
    private static long getErrorConfigVersion = 2778007474884504032L;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 4
            int r9 = r9 + 97
            int r7 = 23 - r7
            byte[] r0 = id.dana.ocr.views.OCRPreviewImageActivity.getAuthRequestContext
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L12
            r9 = r8
            r3 = r9
            r4 = 0
            r8 = r7
            goto L2a
        L12:
            r3 = 0
        L13:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            int r8 = r8 + 1
            r1[r3] = r5
            if (r4 != r7) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2a:
            int r7 = r7 + r3
            int r7 = r7 + (-4)
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.views.OCRPreviewImageActivity.b(byte, int, byte, java.lang.Object[]):void");
    }

    private static void c(int i, short s, int i2, Object[] objArr) {
        byte[] bArr = $$a;
        int i3 = (i2 * 2) + 75;
        int i4 = s + 4;
        int i5 = 42 - (i * 3);
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            i3 = (i4 + (-i3)) - 7;
            i4 = i4;
        }
        while (true) {
            i6++;
            bArr2[i6] = (byte) i3;
            if (i6 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i8 = i4 + 1;
            i3 = (i3 + (-bArr[i8])) - 7;
            i4 = i8;
        }
    }

    @JvmStatic
    public static final Intent generateIntent(Context context, PictureResult pictureResult, OCRRequestModel oCRRequestModel) {
        return Companion.BuiltInFictitiousFunctionClassFactory(context, pictureResult, oCRRequestModel);
    }

    @JvmStatic
    public static final void openOCRPreviewImage(Activity activity, PictureResult pictureResult, OCRRequestModel oCRRequestModel) {
        Companion.KClassImpl$Data$declaredNonStaticMembers$2(activity, pictureResult, oCRRequestModel);
    }

    @JvmStatic
    public static final void setPictureResult(PictureResult pictureResult) {
        Companion.MyBillsEntityDataFactory(pictureResult);
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
        a(View.getDefaultSize(0, 0), new char[]{11740, 15720, 42842, 11709, 33383, 39182, 61230, 28173, 48531, 2345, 32526, 65137, 3571, 63827, 53028, 36463, 40398, 26991, 24393, 7802, 27951, 55699}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1, new char[]{44357, 40229, 13320, 44328, 26716, 14676, 31821, 33837, 15617}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(Color.green(0), new char[]{39412, 46186, 7833, 39363, 30202, 4097, 22207, 39386, 2532, 32806, 50832, 2554, 47491, 28743, 30378, 31172, 10737, 57392, 59096, 59828, 55621, 20691, 38463, 22787, 18736, 49313, 1610, 51572, 63824, 45201, 46705, 14662, 26918, 8422, 9736, 43367, 6349, 37204, 55227, 6363, 34994, 379, 18321, 35058, 14467, 61764, 63485, 63636, 43254, 24881, 26591, 26855}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(Color.alpha(0), new char[]{58228, 9916, 35147, 58133, 57119, 33409, 49517, 13155, 29490, 4781, 20811, 41759, 50000, 58007, 57634, 54130, 21360, 29413, 28938, 17235, 41926, 49670, 445, 62390, 13232, 21029, 37325, 25492, 33666, 8726, 8610, 37794, 5036, 45616, 45449, 981, 25111, 976, 16495, 45631, 62007, 37879, 53323, 8724, 16897, 25540, 24702, 21110, 53879, 62435, 61450, 49744, 8903, 17159, 33004, 29374, 45805, 54051, 4299, 58006, 644, 41797, 41208, 4773, 37541, 13164, 12511, 33492}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(View.getDefaultSize(0, 0), new char[]{50643, 17522, 55293, 50657, 52017, 57419, 40840, 10059, 21962, 28781, 4095, 46909, 58795, 32770, 49045, 51032, 30082, 4137, 12221, 22398, 34098, 41119, 24409, 59341, 5441, 12472, 53036, 30650, 42276, 16604, 32532, 34769, 13653, 53500, 61242, 6058, 17636, 24862, 7903, 42513, 54417, 61805, 36603, 13873, 25771, 348, 16028, 18013, 62603, 37162, 44780, 54827, 1077, 8643, 56846, 26316, 37953, 45547, 20011, 63164, 9252, 49551, 65044, 1759, 46165, 20911, 28216, 38640}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1, new char[]{11732, 38051, 5295, 11708, 39252, 12511, 23755, 30012, 48519, 41137, 52400, 58691, 3568, 20618, 31889, 38253, 40346, 49343, 60599, 1374, 27953, 28746, 40011, 46511, 64789, 57464, 3179, 9666, 19827, 36894, 48158, 54782, 56656, '8', 11310, 17881, 44213, 45529, 56794, 62562, 15511, 8676, 19954, 25667, 36085, 53659, 64918, 5155, 7389, 16805, 28088, 33865, 60455, 61791, 7440, 13498, 31814, 24868, 36218, 42138, 52337, 4357, 15627, 21759}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{19284, 33551, 28979, 19309, 17495, 10025, 14615, 43105, 56134, 46870}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, 18 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), (byte) (PlaceComponentResult & 12), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 3, (char) TextUtils.getOffsetBefore("", 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[68], $$a[78], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 800, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 14, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getCapsMode("", 0, 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 14, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 814, 29 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 16, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {632578445, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0) + 19, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), (byte) (PlaceComponentResult & 12), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getCapsMode("", 0, 0), 45 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[28]), (byte) (-$$a[9]), objArr22);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), 35 - TextUtils.getOffsetAfter("", 0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {632578445, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), (byte) (PlaceComponentResult & 12), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - KeyEvent.normalizeMetaState(0), 3 - Drawable.resolveOpacity(0, 0), (char) (38968 - View.MeasureSpec.makeMeasureSpec(0, 0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[8]), (byte) (-$$a[28]), (byte) (-$$a[9]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "", 0) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {632578445, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), 18 - KeyEvent.getDeadChar(0, 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), (byte) (PlaceComponentResult & 12), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - Color.argb(0, 0, 0, 0), 3 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[40], (byte) ($$a[47] - 1), objArr34);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {632578445, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, 18 - (Process.myPid() >> 22), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_preview_image;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(ViewConfiguration.getWindowTouchSlop() >> 8, new char[]{11740, 15720, 42842, 11709, 33383, 39182, 61230, 28173, 48531, 2345, 32526, 65137, 3571, 63827, 53028, 36463, 40398, 26991, 24393, 7802, 27951, 55699}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            Object[] objArr3 = new Object[1];
            b(getAuthRequestContext[25], getAuthRequestContext[9], getAuthRequestContext[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            b(getAuthRequestContext[27], getAuthRequestContext[59], (byte) (-getAuthRequestContext[5]), new Object[1]);
            Object[] objArr4 = new Object[1];
            a(((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{44357, 40229, 13320, 44328, 26716, 14676, 31821, 33837, 15617}, objArr4);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    a(getPackageName().length() - 7, new char[]{40779, 987, 18030, 40746, 26881, 42941, 3610, 34155, 3844, 14234, 40506, 5399, 49002, 51171, 11854, 25975, 12138, 22480, 48746, 62736, 57277, 59194, 52874, 17888, 20415, 30491, 24236, 54748, 65514, 1911}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(R.string.promo_quest_error_mission_description).substring(14, 15).length() - 1, new char[]{32820, 11359, 40045, 32855, 23673, 34850, 54287, 45075, 4209, 6169, 17449, 8192, 40964, 59495, 62545, 20552, 12343, 30806, 25705, 49256, 49371, 51385}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        a(super.getResources().getString(R.string.bottom_on_boarding_body_text_saving_goal_third).substring(13, 14).codePointAt(0) - 32, new char[]{39412, 46186, 7833, 39363, 30202, 4097, 22207, 39386, 2532, 32806, 50832, 2554, 47491, 28743, 30378, 31172, 10737, 57392, 59096, 59828, 55621, 20691, 38463, 22787, 18736, 49313, 1610, 51572, 63824, 45201, 46705, 14662, 26918, 8422, 9736, 43367, 6349, 37204, 55227, 6363, 34994, 379, 18321, 35058, 14467, 61764, 63485, 63636, 43254, 24881, 26591, 26855}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.input_card_expired_date_placeholder).substring(12, 13).length() - 1, new char[]{58228, 9916, 35147, 58133, 57119, 33409, 49517, 13155, 29490, 4781, 20811, 41759, 50000, 58007, 57634, 54130, 21360, 29413, 28938, 17235, 41926, 49670, 445, 62390, 13232, 21029, 37325, 25492, 33666, 8726, 8610, 37794, 5036, 45616, 45449, 981, 25111, 976, 16495, 45631, 62007, 37879, 53323, 8724, 16897, 25540, 24702, 21110, 53879, 62435, 61450, 49744, 8903, 17159, 33004, 29374, 45805, 54051, 4299, 58006, 644, 41797, 41208, 4773, 37541, 13164, 12511, 33492}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(super.getResources().getString(R.string.device_limit_error_subtitle).substring(29, 30).length() - 1, new char[]{50643, 17522, 55293, 50657, 52017, 57419, 40840, 10059, 21962, 28781, 4095, 46909, 58795, 32770, 49045, 51032, 30082, 4137, 12221, 22398, 34098, 41119, 24409, 59341, 5441, 12472, 53036, 30650, 42276, 16604, 32532, 34769, 13653, 53500, 61242, 6058, 17636, 24862, 7903, 42513, 54417, 61805, 36603, 13873, 25771, 348, 16028, 18013, 62603, 37162, 44780, 54827, 1077, 8643, 56846, 26316, 37953, 45547, 20011, 63164, 9252, 49551, 65044, 1759, 46165, 20911, 28216, 38640}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(View.MeasureSpec.getMode(0), new char[]{11732, 38051, 5295, 11708, 39252, 12511, 23755, 30012, 48519, 41137, 52400, 58691, 3568, 20618, 31889, 38253, 40346, 49343, 60599, 1374, 27953, 28746, 40011, 46511, 64789, 57464, 3179, 9666, 19827, 36894, 48158, 54782, 56656, '8', 11310, 17881, 44213, 45529, 56794, 62562, 15511, 8676, 19954, 25667, 36085, 53659, 64918, 5155, 7389, 16805, 28088, 33865, 60455, 61791, 7440, 13498, 31814, 24868, 36218, 42138, 52337, 4357, 15627, 21759}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.request_money_success_delete_message).substring(5, 6).length() - 1, new char[]{19284, 33551, 28979, 19309, 17495, 10025, 14615, 43105, 56134, 46870}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            try {
                Object[] objArr13 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), 36, getAuthRequestContext[32], objArr13);
                Class<?> cls4 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), (byte) (getAuthRequestContext[35] - 1), (byte) (PlaceComponentResult & 12), objArr14);
                try {
                    Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 494, 4 - Gravity.getAbsoluteGravity(0, 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[40], (byte) ($$a[47] - 1), objArr16);
                        obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                    int i = ((int[]) objArr17[1])[0];
                    if (((int[]) objArr17[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr18 = {1526802970, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr18);
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
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(KeyEvent.normalizeMetaState(0), new char[]{40779, 987, 18030, 40746, 26881, 42941, 3610, 34155, 3844, 14234, 40506, 5399, 49002, 51171, 11854, 25975, 12138, 22480, 48746, 62736, 57277, 59194, 52874, 17888, 20415, 30491, 24236, 54748, 65514, 1911}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(getPackageName().codePointAt(3) - 100, new char[]{32820, 11359, 40045, 32855, 23673, 34850, 54287, 45075, 4209, 6169, 17449, 8192, 40964, 59495, 62545, 20552, 12343, 30806, 25705, 49256, 49371, 51385}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - KeyEvent.getDeadChar(0, 0), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 910, TextUtils.indexOf("", "", 0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
                b(getAuthRequestContext[25], getAuthRequestContext[9], getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(getAuthRequestContext[27], getAuthRequestContext[59], (byte) (-getAuthRequestContext[5]), new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{40779, 987, 18030, 40746, 26881, 42941, 3610, 34155, 3844, 14234, 40506, 5399, 49002, 51171, 11854, 25975, 12138, 22480, 48746, 62736, 57277, 59194, 52874, 17888, 20415, 30491, 24236, 54748, 65514, 1911}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    Object[] objArr3 = new Object[1];
                    b(getAuthRequestContext[25], getAuthRequestContext[9], getAuthRequestContext[25], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b(getAuthRequestContext[27], getAuthRequestContext[59], (byte) (-getAuthRequestContext[5]), new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(((ApplicationInfo) cls3.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{32820, 11359, 40045, 32855, 23673, 34850, 54287, 45075, 4209, 6169, 17449, 8192, 40964, 59495, 62545, 20552, 12343, 30806, 25705, 49256, 49371, 51385}, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - Drawable.resolveOpacity(0, 0), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, Color.green(0) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
    }

    @JvmName(name = "getOcrPreviewImagePresenter")
    public final OCRPreviewImageContract.Presenter getOcrPreviewImagePresenter() {
        OCRPreviewImageContract.Presenter presenter = this.ocrPreviewImagePresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOcrPreviewImagePresenter")
    public final void setOcrPreviewImagePresenter(OCRPreviewImageContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.ocrPreviewImagePresenter = presenter;
    }

    @JvmName(name = "getPreprocessingAndOcrPresenter")
    public final PreprocessingAndOcrContract.Presenter getPreprocessingAndOcrPresenter() {
        PreprocessingAndOcrContract.Presenter presenter = this.preprocessingAndOcrPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPreprocessingAndOcrPresenter")
    public final void setPreprocessingAndOcrPresenter(PreprocessingAndOcrContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.preprocessingAndOcrPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        initComponent();
        registerPresenter(getOcrPreviewImagePresenter(), getOcrPreviewImagePresenter());
        OCRRequestModel oCRRequestModel = (OCRRequestModel) getIntent().getParcelableExtra(OCRCameraActivity.OCR_REQUEST_MODEL_KEY);
        if (oCRRequestModel != null) {
            getOcrPreviewImagePresenter().PlaceComponentResult(oCRRequestModel);
            getPreprocessingAndOcrPresenter().KClassImpl$Data$declaredNonStaticMembers$2(oCRRequestModel);
        }
        initViews();
    }

    public final void initComponent() {
        DaggerOCRPreviewImageComponent.Builder PlaceComponentResult2 = DaggerOCRPreviewImageComponent.PlaceComponentResult();
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.getAuthRequestContext = (OCRPreviewImageModule) Preconditions.getAuthRequestContext(new OCRPreviewImageModule(this));
        PlaceComponentResult2.PlaceComponentResult = (PreprocessingAndOcrModule) Preconditions.getAuthRequestContext(new PreprocessingAndOcrModule(new PreprocessingAndOcrContract.View() { // from class: id.dana.ocr.views.OCRPreviewImageActivity$initComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                OCRPreviewImageActivity.BuiltInFictitiousFunctionClassFactory$default(OCRPreviewImageActivity.this, null, 1, null);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                OCRPreviewImageActivity.this.PlaceComponentResult();
            }

            @Override // id.dana.ocr.PreprocessingAndOcrContract.View
            public final File KClassImpl$Data$declaredNonStaticMembers$2() {
                File PlaceComponentResult3 = FileUtil.PlaceComponentResult(OCRPreviewImageActivity.this);
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
                return PlaceComponentResult3;
            }

            @Override // id.dana.ocr.PreprocessingAndOcrContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                r2.BuiltInFictitiousFunctionClassFactory(OCRPreviewImageActivity.this.getString(R.string.loading_info_text_ocr));
            }

            @Override // id.dana.ocr.PreprocessingAndOcrContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                r2.BuiltInFictitiousFunctionClassFactory(OCRPreviewImageActivity.this.getString(R.string.loading_info_text_preprocessing));
            }

            @Override // id.dana.ocr.PreprocessingAndOcrContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                r2.BuiltInFictitiousFunctionClassFactory(OCRPreviewImageActivity.this.getString(R.string.loading_info_text_submission));
            }

            @Override // id.dana.ocr.PreprocessingAndOcrContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0, OCRRequestModel p1, OCRResultModel p2) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                OCRPreviewImageActivity.access$setResultActivityAndFinish(OCRPreviewImageActivity.this, p2);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, OCRPreviewImageModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, PreprocessingAndOcrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerOCRPreviewImageComponent.OCRPreviewImageComponentImpl(PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2.PlaceComponentResult, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).getAuthRequestContext(this);
    }

    public final void initViews() {
        OCRPreviewImageContract.Presenter ocrPreviewImagePresenter = getOcrPreviewImagePresenter();
        PictureResult pictureResult = scheduleImpl;
        if (pictureResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            pictureResult = null;
        }
        ocrPreviewImagePresenter.BuiltInFictitiousFunctionClassFactory(pictureResult);
        ((BottomSheetPromptView) _$_findCachedViewById(R.id.res_0x7f0a0100_networkuserentitydata_externalsyntheticlambda2)).setListener(new BottomSheetPromptView.BottomSheetPromptCallback() { // from class: id.dana.ocr.views.OCRPreviewImageActivity$initViews$1
            @Override // id.dana.ocr.preview.BottomSheetPromptView.BottomSheetPromptCallback
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                OCRPreviewImageActivity.this.getOcrPreviewImagePresenter().BuiltInFictitiousFunctionClassFactory(p0);
            }
        });
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.View
    public final File getStorageDir() {
        File PlaceComponentResult2 = FileUtil.PlaceComponentResult(this);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.View
    public final void processImageOnForeground(Bitmap imageOrigin) {
        Intrinsics.checkNotNullParameter(imageOrigin, "");
        getPreprocessingAndOcrPresenter().KClassImpl$Data$declaredNonStaticMembers$2("1", imageOrigin);
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.View
    public final void processImageOnBackground(OCRRequestModel ocrRequestModel, String filePath) {
        Intrinsics.checkNotNullParameter(ocrRequestModel, "");
        Intrinsics.checkNotNullParameter(filePath, "");
        String obj = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        OcrAndUploadTaskModel ocrAndUploadTaskModel = new OcrAndUploadTaskModel(obj, null, ocrRequestModel, filePath, 2, null);
        SnapReceiptService.Companion companion = SnapReceiptService.INSTANCE;
        SnapReceiptService.Companion.getAuthRequestContext(this, ocrAndUploadTaskModel);
        Intent putExtra = new Intent().putExtra(KEY_OCR_RESULT_MODEL, new OCRResultModel.Builder().getAuthRequestContext());
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        setResult(-1, putExtra);
        finish();
    }

    public final void showBottomPrompt() {
        BottomSheetPromptView bottomSheetPromptView = (BottomSheetPromptView) _$_findCachedViewById(R.id.res_0x7f0a0100_networkuserentitydata_externalsyntheticlambda2);
        if (bottomSheetPromptView != null) {
            bottomSheetPromptView.show();
        }
    }

    public final void hideBottomPrompt() {
        BottomSheetPromptView bottomSheetPromptView = (BottomSheetPromptView) _$_findCachedViewById(R.id.res_0x7f0a0100_networkuserentitydata_externalsyntheticlambda2);
        if (bottomSheetPromptView != null) {
            bottomSheetPromptView.hide();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        BuiltInFictitiousFunctionClassFactory$default(this, null, 1, null);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        PlaceComponentResult();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        showToast(errorMessage);
        finish();
    }

    public final void onFailConvertBitmap() {
        onError(getString(R.string.fail_convert_bitmap));
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.View
    public final void onFilePathNull() {
        onError(getString(R.string.file_path_null));
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.View
    public final void closePage() {
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory$default(OCRPreviewImageActivity oCRPreviewImageActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        oCRPreviewImageActivity.BuiltInFictitiousFunctionClassFactory(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.progress_view);
        if (logoProgressView != null) {
            logoProgressView.setVisibility(0);
            logoProgressView.startRefresh();
        }
        if (p0 != null) {
            ((TextView) _$_findCachedViewById(R.id.tv_progress)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.tv_progress)).setText(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.progress_view);
        if (logoProgressView != null) {
            logoProgressView.stopRefresh();
            logoProgressView.setVisibility(8);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_progress);
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/ocr/views/OCRPreviewImageActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lcom/otaliastudios/cameraview/PictureResult;", "p1", "Lid/dana/ocr/model/OCRRequestModel;", "p2", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lcom/otaliastudios/cameraview/PictureResult;Lid/dana/ocr/model/OCRRequestModel;)Landroid/content/Intent;", "Landroid/app/Activity;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Lcom/otaliastudios/cameraview/PictureResult;Lid/dana/ocr/model/OCRRequestModel;)V", "MyBillsEntityDataFactory", "(Lcom/otaliastudios/cameraview/PictureResult;)V", "", OCRPreviewImageActivity.KEY_OCR_RESULT_MODEL, "Ljava/lang/String;", "", "OCR_PREVIEW_IMAGE_REQUEST_CODE", "I", "scheduleImpl", "Lcom/otaliastudios/cameraview/PictureResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(PictureResult p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            OCRPreviewImageActivity.scheduleImpl = p0;
        }

        @JvmStatic
        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, PictureResult p1, OCRRequestModel p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p1, "");
            OCRPreviewImageActivity.scheduleImpl = p1;
            Intent intent = new Intent(p0, OCRPreviewImageActivity.class);
            intent.putExtra(OCRCameraActivity.OCR_REQUEST_MODEL_KEY, p2);
            return intent;
        }

        @JvmStatic
        public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, PictureResult p1, OCRRequestModel p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            p0.startActivityForResult(BuiltInFictitiousFunctionClassFactory(p0, p1, p2), OCRPreviewImageActivity.OCR_PREVIEW_IMAGE_REQUEST_CODE);
        }
    }

    public static final /* synthetic */ void access$setResultActivityAndFinish(OCRPreviewImageActivity oCRPreviewImageActivity, OCRResultModel oCRResultModel) {
        Intent intent = new Intent();
        intent.putExtra(KEY_OCR_RESULT_MODEL, oCRResultModel);
        oCRPreviewImageActivity.setResult(-1, intent);
        oCRPreviewImageActivity.finish();
    }

    @Override // id.dana.ocr.OCRPreviewImageContract.View
    public final void onSuccessConvertImage(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "");
        ((ZoomableImageView) _$_findCachedViewById(R.id.image_preview)).setImageBitmap(bitmap);
        showBottomPrompt();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(getErrorConfigVersion ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (getErrorConfigVersion ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
