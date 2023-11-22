package id.dana.ocr.views;

import android.app.NotificationChannel;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.IBinder;
import android.os.PowerManager;
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
import android.widget.ExpandableListView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSnapReceiptServiceComponent;
import id.dana.di.modules.PreprocessingAndOcrModule;
import id.dana.di.modules.UploadSnapReceiptModule;
import id.dana.notification.NotificationData;
import id.dana.notification.NotificationDirector;
import id.dana.notification.NotificationDirectorFactory;
import id.dana.notification.NotificationUtils;
import id.dana.ocr.PreprocessingAndOcrContract;
import id.dana.ocr.UploadSnapReceiptContract;
import id.dana.ocr.model.OCRRequestModel;
import id.dana.ocr.model.OCRResultModel;
import id.dana.ocr.model.OcrAndUploadTaskModel;
import id.dana.ocr.model.ReuploadReceiptTaskModel;
import id.dana.ocr.model.SnapReceiptBroadcastData;
import id.dana.ocr.model.SnapReceiptTaskModel;
import id.dana.ocr.model.SubmitReceiptResultModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.rum.Rum;
import id.dana.utils.FileUtil;
import id.dana.utils.OSUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\bB\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\nJ)\u0010\u001b\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\nR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020,8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u00103R\u001c\u00108\u001a\b\u0018\u000104R\u0002058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00107R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020:098\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010\u0011\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010>R\u001c\u0010\t\u001a\u00020\u000e8C@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b\f\u0010A"}, d2 = {"Lid/dana/ocr/views/SnapReceiptService;", "Landroid/app/Service;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "", "()I", "MyBillsEntityDataFactory", "()V", "Lid/dana/ocr/model/SnapReceiptBroadcastData;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/ocr/model/SnapReceiptBroadcastData;)V", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onCreate", "intent", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "preprocessingAndOcrPresenter", "Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "getPreprocessingAndOcrPresenter", "()Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;", "setPreprocessingAndOcrPresenter", "(Lid/dana/ocr/PreprocessingAndOcrContract$Presenter;)V", "Lid/dana/ocr/UploadSnapReceiptContract$Presenter;", "uploadSnapReceiptPresenter", "Lid/dana/ocr/UploadSnapReceiptContract$Presenter;", "getUploadSnapReceiptPresenter", "()Lid/dana/ocr/UploadSnapReceiptContract$Presenter;", "setUploadSnapReceiptPresenter", "(Lid/dana/ocr/UploadSnapReceiptContract$Presenter;)V", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Ljava/lang/String;", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "getErrorConfigVersion", "Landroid/os/PowerManager$WakeLock;", "getAuthRequestContext", "Lj$/util/concurrent/ConcurrentHashMap;", "Lid/dana/ocr/model/SnapReceiptTaskModel;", "moveToNextValue", "Lj$/util/concurrent/ConcurrentHashMap;", "Ljava/util/Timer;", "Ljava/util/Timer;", "scheduleImpl", "Z", "()Z", "<init>", "Companion"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class SnapReceiptService extends Service {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String PlaceComponentResult;
    private static char[] lookAheadTest;
    private volatile String BuiltInFictitiousFunctionClassFactory;
    private Timer KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private PowerManager.WakeLock getAuthRequestContext;
    @Inject
    public PreprocessingAndOcrContract.Presenter preprocessingAndOcrPresenter;
    @Inject
    public UploadSnapReceiptContract.Presenter uploadSnapReceiptPresenter;
    public static final byte[] $$a = {18, 119, 36, -59, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 47;
    public static final byte[] MyBillsEntityDataFactory = {75, -23, 102, -23, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 7;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ConcurrentHashMap<String, SnapReceiptTaskModel> PlaceComponentResult = new ConcurrentHashMap<>();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory = true;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        lookAheadTest = new char[]{35500, 35578, 35575, 35566, 35583, 35489, 35534, 35567, 35536, 35543, 35576, 35570, 35566, 35573, 35575, 35577, 35572, 35565, 35500, 35574, 35565, 35577, 35521, 35500, 35539, 35498, 35540, 35538, 35499, 35539, 35536, 35501, 35498, 35494, 35537, 35537, 35499, 35498, 35497, 35537, 35581, 35580, 35541, 35541, 35536, 35499, 35541, 35539, 35538, 35581, 35581, 35580, 35541, 35501, 35503, 35501, 35501, 35503, 35541, 35579, 35578, 35578, 35536, 35497, 35494, 35536, 35540, 35498, 35497, 35538, 35539, 35571, 35436, 35437, 35395, 35435, 35731, 35433, 35394, 35394, 35432, 35733, 35432, 35393, 35434, 35436, 35399, 35396, 35397, 35396, 35434, 35437, 35436, 35436, 35397, 35394, 35394, 35434, 35435, 35433, 35432, 35432, 35437, 35396, 35436, 35733, 35434, 35392, 35435, 35733, 35439, 35399, 35394, 35396, 35436, 35437, 35436, 35435, 35394, 35394, 35395, 35397, 35395, 35454, 35455, 35454, 35397, 35398, 35398, 35398, 35436, 35732, 35439, 35394, 35432, 35503, 35536, 35537, 35578, 35583, 35542, 35498, 35496, 35500, 35541, 35537, 35494, 35497, 35496, 35538, 35539, 35499, 35541, 35539, 35539, 35539, 35536, 35576, 35537, 35494, 35537, 35536, 35499, 35540, 35583, 35540, 35541, 35538, 35538, 35581, 35538, 35501, 35503, 35500, 35503, 35498, 35494, 35494, 35496, 35501, 35498, 35494, 35539, 35581, 35541, 35503, 35499, 35497, 35499, 35539, 35536, 35497, 35497, 35496, 35496, 35539, 35541, 35503, 35541, 35489, 35582, 35524, 35556, 35552, 35520, 35520, 35555, 35554, 35558, 35552, 35355, 35581, 35578, 35576, 35548, 35522, 35553, 35553, 35557, 35357, 35355, 35553, 35358, 35352, 35354, 35357, 35574, 35544, 35551, 35525, 35562, 35559, 35559, 35527, 35581, 35358, 35553, 35555, 35563, 35554, 35555, 35562, 35554, 35355, 35581, 35522, 35358, 35555, 35557, 35555, 35555, 35354, 35355, 35555, 35557, 35555, 35525, 35524, 35557, 35462, 35503, 35502, 35503, 35503, 35501};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 105
            int r6 = r6 * 2
            int r6 = r6 + 16
            byte[] r0 = id.dana.ocr.views.SnapReceiptService.MyBillsEntityDataFactory
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L35
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            int r7 = r7 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.views.SnapReceiptService.a(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r6 = r6 + 4
            byte[] r0 = id.dana.ocr.views.SnapReceiptService.$$a
            int r7 = r7 * 3
            int r7 = r7 + 21
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1b:
            r3 = 0
        L1c:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.ocr.views.SnapReceiptService.b(int, short, byte, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void startUpload(Context context, SnapReceiptTaskModel snapReceiptTaskModel) {
        Companion.getAuthRequestContext(context, snapReceiptTaskModel);
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        c(true, new int[]{0, 18, 0, 16}, new byte[]{1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        c(false, new int[]{18, 5, 0, 1}, new byte[]{0, 1, 0, 0, 0}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - Drawable.resolveOpacity(0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    c(true, new int[]{23, 48, 0, 0}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    c(false, new int[]{71, 64, 168, 1}, new byte[]{1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    c(true, new int[]{135, 64, 0, 51}, new byte[]{1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    c(false, new int[]{SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, 60, 18, 22}, new byte[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    c(true, new int[]{DeepRecoverARiverProxy.TYPE_ENTITY_PLUGIN, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr13 = new Object[1];
                a(b, (byte) (b | 14), MyBillsEntityDataFactory[5], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = (byte) (MyBillsEntityDataFactory[5] - 1);
                byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr14 = new Object[1];
                a(b2, b3, (byte) (b3 + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 3 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16));
                        byte b4 = $$a[47];
                        byte b5 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        b(b4, b5, b5, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 14, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 752, View.resolveSize(0, 0) + 15, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 816, 29 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (View.MeasureSpec.getMode(0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, (ViewConfiguration.getEdgeSlop() >> 16) + 15, (char) (ViewConfiguration.getFadingEdgeLength() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {354611596, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr19 = new Object[1];
                a(b6, (byte) (b6 | 14), MyBillsEntityDataFactory[5], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = (byte) (MyBillsEntityDataFactory[5] - 1);
                byte b8 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr20 = new Object[1];
                a(b7, b8, (byte) (b8 + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - TextUtils.getOffsetAfter("", 0), TextUtils.getTrimmedLength("") + 46, (char) ExpandableListView.getPackedPositionType(0L));
                        Object[] objArr22 = new Object[1];
                        b($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getEdgeSlop() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {354611596, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 18 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr25 = new Object[1];
                a(b9, (byte) (b9 | 14), MyBillsEntityDataFactory[5], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b10 = (byte) (MyBillsEntityDataFactory[5] - 1);
                byte b11 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr26 = new Object[1];
                a(b10, b11, (byte) (b11 + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - KeyEvent.keyCodeFromString(""), AndroidCharacter.getMirror('0') - '-', (char) (38968 - (ViewConfiguration.getJumpTapTimeout() >> 16)));
                        Object[] objArr28 = new Object[1];
                        b($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Gravity.getAbsoluteGravity(0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {354611596, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b12 = (byte) (MyBillsEntityDataFactory[5] - 1);
                Object[] objArr31 = new Object[1];
                a(b12, (byte) (b12 | 14), MyBillsEntityDataFactory[5], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b13 = (byte) (MyBillsEntityDataFactory[5] - 1);
                byte b14 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr32 = new Object[1];
                a(b13, b14, (byte) (b14 + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 107, 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (MotionEvent.axisFromString("") + 1));
                        Object[] objArr34 = new Object[1];
                        b((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {354611596, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 17, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent p0) {
        return null;
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

    @JvmName(name = "getUploadSnapReceiptPresenter")
    public final UploadSnapReceiptContract.Presenter getUploadSnapReceiptPresenter() {
        UploadSnapReceiptContract.Presenter presenter = this.uploadSnapReceiptPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUploadSnapReceiptPresenter")
    public final void setUploadSnapReceiptPresenter(UploadSnapReceiptContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.uploadSnapReceiptPresenter = presenter;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    @Override // android.app.Service
    public final void onCreate() {
        try {
            byte b = 0;
            byte b2 = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr = new Object[1];
            a(b2, (byte) (b2 | 14), MyBillsEntityDataFactory[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[5] - 1);
            byte b4 = (byte) (-MyBillsEntityDataFactory[5]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (b4 + 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), ((Process.getThreadPriority(0) + 20) >> 6) + 4, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                    Object[] objArr4 = new Object[1];
                    b((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-809455027, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
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
                super.onCreate();
                Rum.Companion companion = Rum.getAuthRequestContext;
                Rum.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult("SnapReceiptService.onCreate");
                if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                    String string = getString(R.string.loading_info_text_preprocessing);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    NotificationData PlaceComponentResult2 = NotificationUtils.PlaceComponentResult(true, SnapReceiptBroadcastData.Status.InProgress, string);
                    NotificationUtils notificationUtils = NotificationUtils.BuiltInFictitiousFunctionClassFactory;
                    SnapReceiptService snapReceiptService = this;
                    NotificationUtils.MyBillsEntityDataFactory(snapReceiptService, SnapReceiptBroadcastData.Status.InProgress);
                    startForeground(1, NotificationUtils.PlaceComponentResult(snapReceiptService, PlaceComponentResult2));
                }
                DaggerSnapReceiptServiceComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerSnapReceiptServiceComponent.KClassImpl$Data$declaredNonStaticMembers$2();
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(ComponentHolder.getAuthRequestContext());
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (PreprocessingAndOcrModule) Preconditions.getAuthRequestContext(new PreprocessingAndOcrModule(new PreprocessingAndOcrContract.View() { // from class: id.dana.ocr.views.SnapReceiptService$initComponent$1
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

                    @Override // id.dana.ocr.PreprocessingAndOcrContract.View
                    public final File KClassImpl$Data$declaredNonStaticMembers$2() {
                        File PlaceComponentResult3 = FileUtil.PlaceComponentResult(SnapReceiptService.this);
                        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
                        return PlaceComponentResult3;
                    }

                    @Override // id.dana.ocr.PreprocessingAndOcrContract.View
                    public final void getAuthRequestContext(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        SnapReceiptService snapReceiptService2 = SnapReceiptService.this;
                        String string2 = snapReceiptService2.getString(R.string.loading_info_text_ocr);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        snapReceiptService2.BuiltInFictitiousFunctionClassFactory(new SnapReceiptBroadcastData(SnapReceiptBroadcastData.Status.InProgress, string2, null, null));
                    }

                    @Override // id.dana.ocr.PreprocessingAndOcrContract.View
                    public final void MyBillsEntityDataFactory(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        SnapReceiptService snapReceiptService2 = SnapReceiptService.this;
                        String string2 = snapReceiptService2.getString(R.string.loading_info_text_preprocessing);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        snapReceiptService2.BuiltInFictitiousFunctionClassFactory(new SnapReceiptBroadcastData(SnapReceiptBroadcastData.Status.InProgress, string2, null, null));
                    }

                    @Override // id.dana.ocr.PreprocessingAndOcrContract.View
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        SnapReceiptService snapReceiptService2 = SnapReceiptService.this;
                        String string2 = snapReceiptService2.getString(R.string.loading_info_text_submission);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        snapReceiptService2.BuiltInFictitiousFunctionClassFactory(new SnapReceiptBroadcastData(SnapReceiptBroadcastData.Status.InProgress, string2, null, null));
                    }

                    @Override // id.dana.ocr.PreprocessingAndOcrContract.View
                    public final void BuiltInFictitiousFunctionClassFactory(String p0, OCRRequestModel p1, OCRResultModel p2) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        Intrinsics.checkNotNullParameter(p2, "");
                        if (p2.getLookAheadTest() || Intrinsics.areEqual(p2.getAuthRequestContext, "004")) {
                            SnapReceiptService.this.getUploadSnapReceiptPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2);
                        } else {
                            SnapReceiptService.access$onError(SnapReceiptService.this, p0, "OCR Failed", p2.getAuthRequestContext);
                        }
                    }
                }));
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (UploadSnapReceiptModule) Preconditions.getAuthRequestContext(new UploadSnapReceiptModule(new UploadSnapReceiptContract.View() { // from class: id.dana.ocr.views.SnapReceiptService$initComponent$2
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

                    @Override // id.dana.ocr.UploadSnapReceiptContract.View
                    public final void PlaceComponentResult(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        SnapReceiptService snapReceiptService2 = SnapReceiptService.this;
                        String string2 = snapReceiptService2.getString(R.string.loading_info_text_upload_receipt);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        snapReceiptService2.BuiltInFictitiousFunctionClassFactory(new SnapReceiptBroadcastData(SnapReceiptBroadcastData.Status.InProgress, string2, null, null));
                    }

                    @Override // id.dana.ocr.UploadSnapReceiptContract.View
                    public final void getAuthRequestContext(String p0, SubmitReceiptResultModel p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        SnapReceiptService snapReceiptService2 = SnapReceiptService.this;
                        String string2 = snapReceiptService2.getString(R.string.loading_info_text_upload_succeeded);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        SnapReceiptService.access$onSuccess(snapReceiptService2, p0, string2, p1);
                    }

                    @Override // id.dana.ocr.UploadSnapReceiptContract.View
                    public final void MyBillsEntityDataFactory(String p0, String p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        SnapReceiptService snapReceiptService2 = SnapReceiptService.this;
                        String string2 = snapReceiptService2.getString(R.string.loading_info_text_upload_failed);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        SnapReceiptService.access$onError(snapReceiptService2, p0, string2, p1);
                    }

                    @Override // id.dana.ocr.UploadSnapReceiptContract.View
                    public final void MyBillsEntityDataFactory(String p0) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        FileUtil.getAuthRequestContext(SnapReceiptService.this, p0);
                    }
                }));
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, PreprocessingAndOcrModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, UploadSnapReceiptModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, ApplicationComponent.class);
                new DaggerSnapReceiptServiceComponent.SnapReceiptServiceComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, b).BuiltInFictitiousFunctionClassFactory(this);
                SnapReceiptService snapReceiptService2 = this;
                PowerManager.WakeLock wakeLock = this.getAuthRequestContext;
                String str = PlaceComponentResult;
                if (!(wakeLock != null && wakeLock.isHeld())) {
                    Object systemService = snapReceiptService2.getSystemService("power");
                    if (systemService == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
                    }
                    wakeLock = ((PowerManager) systemService).newWakeLock(1, str);
                    wakeLock.setReferenceCounted(false);
                    if (!wakeLock.isHeld()) {
                        wakeLock.acquire();
                    }
                    Intrinsics.checkNotNullExpressionValue(wakeLock, "");
                }
                this.getAuthRequestContext = wakeLock;
                Rum.Companion companion2 = Rum.getAuthRequestContext;
                Rum.Companion.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory("SnapReceiptService.onCreate");
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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int flags, int startId) {
        NotificationUtils notificationUtils = NotificationUtils.BuiltInFictitiousFunctionClassFactory;
        String str = PlaceComponentResult;
        Intrinsics.checkNotNullParameter("SnapReceiptServiceNotificationChannel", "");
        Intrinsics.checkNotNullParameter(str, "");
        if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
            NotificationChannel notificationChannel = new NotificationChannel("SnapReceiptServiceNotificationChannel", str, 4);
            notificationChannel.enableLights(true);
            NotificationManagerCompat MyBillsEntityDataFactory2 = NotificationManagerCompat.MyBillsEntityDataFactory(ComponentHolder.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2());
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory(notificationChannel);
        }
        if (intent == null) {
            PlaceComponentResult();
        } else if (TextUtils.isEmpty(intent.getAction())) {
            PlaceComponentResult();
        } else {
            String action = intent.getAction();
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode != -2146930587) {
                    if (hashCode == 311947419 && action.equals("ocr_and_upload_task_action")) {
                        OcrAndUploadTaskModel ocrAndUploadTaskModel = (OcrAndUploadTaskModel) intent.getParcelableExtra("snapReceiptParamKey");
                        if (ocrAndUploadTaskModel == null) {
                            PlaceComponentResult();
                        } else {
                            if (this.PlaceComponentResult.containsKey(ocrAndUploadTaskModel.BuiltInFictitiousFunctionClassFactory)) {
                                PlaceComponentResult();
                            }
                            MyBillsEntityDataFactory();
                            this.PlaceComponentResult.put(ocrAndUploadTaskModel.BuiltInFictitiousFunctionClassFactory, ocrAndUploadTaskModel);
                            getPreprocessingAndOcrPresenter().KClassImpl$Data$declaredNonStaticMembers$2(ocrAndUploadTaskModel.PlaceComponentResult);
                            getPreprocessingAndOcrPresenter().MyBillsEntityDataFactory(ocrAndUploadTaskModel.BuiltInFictitiousFunctionClassFactory, ocrAndUploadTaskModel.MyBillsEntityDataFactory);
                        }
                    }
                } else if (action.equals("reupload_task_action")) {
                    ReuploadReceiptTaskModel reuploadReceiptTaskModel = (ReuploadReceiptTaskModel) intent.getParcelableExtra("snapReceiptParamKey");
                    if (reuploadReceiptTaskModel == null) {
                        PlaceComponentResult();
                    } else {
                        if (this.PlaceComponentResult.containsKey(reuploadReceiptTaskModel.PlaceComponentResult)) {
                            PlaceComponentResult();
                        }
                        MyBillsEntityDataFactory();
                        this.PlaceComponentResult.put(reuploadReceiptTaskModel.PlaceComponentResult, reuploadReceiptTaskModel);
                        getUploadSnapReceiptPresenter().BuiltInFictitiousFunctionClassFactory(reuploadReceiptTaskModel.PlaceComponentResult, reuploadReceiptTaskModel.getAuthRequestContext);
                    }
                }
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        getPreprocessingAndOcrPresenter().onDestroy();
        getUploadSnapReceiptPresenter().onDestroy();
        PowerManager.WakeLock wakeLock = this.getAuthRequestContext;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        wakeLock.release();
    }

    private final void PlaceComponentResult(String p0) {
        SnapReceiptTaskModel remove = this.PlaceComponentResult.remove(p0);
        if (BuiltInFictitiousFunctionClassFactory() && remove != null && Intrinsics.areEqual(remove.getPlaceComponentResult(), this.BuiltInFictitiousFunctionClassFactory)) {
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
        if (BuiltInFictitiousFunctionClassFactory() && this.PlaceComponentResult.isEmpty()) {
            stopForeground(true);
            PlaceComponentResult();
        }
    }

    private final int PlaceComponentResult() {
        if (this.PlaceComponentResult.isEmpty()) {
            MyBillsEntityDataFactory();
            StringBuilder sb = new StringBuilder();
            sb.append(PlaceComponentResult);
            sb.append("IdleTimer");
            Timer timer = new Timer(sb.toString());
            timer.schedule(new TimerTask() { // from class: id.dana.ocr.views.SnapReceiptService$shutdownIfThereArentAnyActiveTasks$1$1
                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    String str;
                    str = SnapReceiptService.PlaceComponentResult;
                    DanaLog.getAuthRequestContext(str, "Service is about to be stopped because idle timeout of 10s has been reached");
                    SnapReceiptService.this.stopSelf();
                }
            }, 10000L);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = timer;
            return 2;
        }
        return 1;
    }

    private final void MyBillsEntityDataFactory() {
        synchronized (this) {
            Timer timer = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (timer != null) {
                DanaLog.getAuthRequestContext(PlaceComponentResult, "Clearing idle timer");
                timer.cancel();
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        NotificationDirector PlaceComponentResult2 = new NotificationDirectorFactory(getDynamicUrlWrapper()).PlaceComponentResult(getApplicationContext(), NotificationUtils.PlaceComponentResult(false, str, str2));
        if (PlaceComponentResult2 != null) {
            PlaceComponentResult2.MyBillsEntityDataFactory();
        }
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    private final boolean BuiltInFictitiousFunctionClassFactory() {
        return OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda1() || this.MyBillsEntityDataFactory;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/ocr/views/SnapReceiptService$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/ocr/model/SnapReceiptTaskModel;", "p1", "", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/ocr/model/SnapReceiptTaskModel;)V", "", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void getAuthRequestContext(Context p0, SnapReceiptTaskModel p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, SnapReceiptService.class);
            intent.setAction(p1.getMyBillsEntityDataFactory());
            intent.putExtra("snapReceiptParamKey", p1);
            ContextCompat.PlaceComponentResult(p0, intent);
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
        Intrinsics.checkNotNullExpressionValue("SnapReceiptService", "");
        PlaceComponentResult = "SnapReceiptService";
    }

    public static final /* synthetic */ void access$onError(SnapReceiptService snapReceiptService, String str, String str2, String str3) {
        snapReceiptService.BuiltInFictitiousFunctionClassFactory(new SnapReceiptBroadcastData("Error", str2, str3, null));
        snapReceiptService.PlaceComponentResult(str);
    }

    public static final /* synthetic */ void access$onSuccess(SnapReceiptService snapReceiptService, String str, String str2, SubmitReceiptResultModel submitReceiptResultModel) {
        snapReceiptService.BuiltInFictitiousFunctionClassFactory(new SnapReceiptBroadcastData("Success", str2, null, submitReceiptResultModel));
        snapReceiptService.PlaceComponentResult(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(SnapReceiptBroadcastData p0) {
        String str = p0.PlaceComponentResult;
        String str2 = p0.MyBillsEntityDataFactory;
        if (str2 == null) {
            str2 = "";
        }
        KClassImpl$Data$declaredNonStaticMembers$2(str, str2);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(p0.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    private static void c(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = lookAheadTest;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i6 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i6, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i6);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
