package id.dana.nearbyme.merchantdetail.mediaviewer;

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
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.mobile.security.bio.utils.DisplayUtil;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.nearbyme.di.component.DaggerPhotoGalleryComponent;
import id.dana.nearbyme.di.module.PhotoGalleryModule;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.GridAutofitLayoutManager;
import id.dana.utils.LazyLoadScrollListener;
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
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u0013\u0010\u000e\u001a\u00020\u000bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u00020\u000bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MerchantPhotoGalleryActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "getAuthRequestContext", "()Z", "", "getErrorConfigVersion", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryAdapter;", "lookAheadTest", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "presenter", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "getPresenter", "()Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;", "setPresenter", "(Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryContract$Presenter;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotoGalleryActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean DatabaseTableConfigUtil = false;
    public static final String EXTRA_IMAGES = "EXTRA_IMAGES";
    public static final String EXTRA_MERCHANT_ID = "EXTRA_MERCHANT_ID";
    public static final String EXTRA_MERCHANT_NAME = "EXTRA_MERCHANT_NAME";
    public static final String EXTRA_PREPOPULATE_IMAGES = "EXTRA_PRE_POPULATE_IMAGES";
    public static final String EXTRA_SHOP_ID = "EXTRA_SHOP_ID";
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static int initRecordTimeStamp;
    private static char[] scheduleImpl;
    @Inject
    public PhotoGalleryContract.Presenter presenter;
    public static final byte[] $$a = {Ascii.RS, 119, -63, 113, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 108;
    public static final byte[] PlaceComponentResult = {71, Ascii.US, 113, 39, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 84;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<String>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity$merchantName$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle extras = MerchantPhotoGalleryActivity.this.getIntent().getExtras();
            String string = extras != null ? extras.getString(MerchantPhotoGalleryActivity.EXTRA_MERCHANT_NAME) : null;
            return string == null ? "" : string;
        }
    });

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<String>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity$merchantId$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle extras = MerchantPhotoGalleryActivity.this.getIntent().getExtras();
            String string = extras != null ? extras.getString("EXTRA_MERCHANT_ID") : null;
            return string == null ? "" : string;
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final PhotoGalleryAdapter KClassImpl$Data$declaredNonStaticMembers$2 = new PhotoGalleryAdapter(new Function1<Integer, Unit>() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity$photoAdapter$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i) {
            MerchantPhotoGalleryActivity.access$openMerchantPhotoViewer(MerchantPhotoGalleryActivity.this, i);
        }
    });

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        scheduleImpl = new char[]{39437, 39550, 39432, 39546, 39551, 39429, 39486, 39548, 39469, 39435, 39544, 39542, 39541, 39448, 39428, 39433, 39545, 39424, 39547, 39452, 39425, 39449, 39479, 39478, 39476, 39484, 39477, 39430, 39482, 39485, 39483, 39480, 39434, 39481, 39474, 39487, 39431, 39549};
        NetworkUserEntityData$$ExternalSyntheticLambda2 = true;
        DatabaseTableConfigUtil = true;
        initRecordTimeStamp = 909155308;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 16
            int r6 = r6 + 4
            byte[] r0 = id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity.PlaceComponentResult
            int r7 = r7 + 97
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L31
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L31:
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity.b(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity.c(short, int, short, java.lang.Object[]):void");
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
        a(null, 127 - View.MeasureSpec.makeMeasureSpec(0, 0), new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, TextUtils.getOffsetBefore("", 0) + 127, new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 35, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, 127 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, KeyEvent.normalizeMetaState(0) + 127, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, KeyEvent.keyCodeFromString("") + 127, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, TextUtils.getOffsetAfter("", 0) + 127, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, (ViewConfiguration.getFadingEdgeLength() >> 16) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, KeyEvent.keyCodeFromString("") + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b((short) 37, PlaceComponentResult[32], PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 56, 2 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        byte b = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b, (byte) (b - 1), $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 800, 14 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 800, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 14, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776401) - Color.rgb(0, 0, 0), 29 - View.resolveSize(0, 0), (char) (TextUtils.indexOf("", "") + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) (ViewConfiguration.getTapTimeout() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {490899855, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), KeyEvent.keyCodeFromString("") + 18, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((short) 37, PlaceComponentResult[32], PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), PlaceComponentResult[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 61, 46 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) TextUtils.getTrimmedLength(""));
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b2, (byte) (b2 | Ascii.ETB), $$a[9], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {490899855, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((short) 37, PlaceComponentResult[32], PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), PlaceComponentResult[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 119, 3 - View.getDefaultSize(0, 0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 38967));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b3, (byte) (b3 | Ascii.ETB), $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), TextUtils.getOffsetBefore("", 0) + 35, (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {490899855, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.normalizeMetaState(0), 18 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b((short) 37, PlaceComponentResult[32], PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), PlaceComponentResult[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (Process.myPid() >> 22) + 3, (char) KeyEvent.keyCodeFromString(""));
                        Object[] objArr34 = new Object[1];
                        c($$a[8], $$a[53], (byte) ($$a[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSizeAndState(0, 0, 0), 35 - Color.blue(0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {490899855, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, 18 - View.resolveSize(0, 0), (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_merchant_photo_gallery;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr2 = new Object[1];
            b(b, b, (byte) (-PlaceComponentResult[30]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            b((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[56], objArr3);
            Object[] objArr4 = new Object[1];
            a(null, ((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            try {
                byte b2 = PlaceComponentResult[25];
                Object[] objArr5 = new Object[1];
                b(b2, b2, (byte) (-PlaceComponentResult[30]), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                Object[] objArr6 = new Object[1];
                b((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[56], objArr6);
                Object[] objArr7 = new Object[1];
                a(null, ((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-125, -122, -106, -115, -107}, null, objArr7);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr8 = new Object[1];
                        a(null, 128 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        a(null, 127 - (ViewConfiguration.getKeyRepeatDelay() >> 16), new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr9);
                        baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr10 = new Object[1];
                            a(null, 127 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr10);
                            String str = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            a(null, 127 - TextUtils.indexOf("", "", 0, 0), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr11);
                            String str2 = (String) objArr11[0];
                            try {
                                byte b3 = PlaceComponentResult[25];
                                Object[] objArr12 = new Object[1];
                                b(b3, b3, (byte) (-PlaceComponentResult[30]), objArr12);
                                Class<?> cls5 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                b((byte) (PlaceComponentResult[59] + 1), (byte) (-PlaceComponentResult[5]), PlaceComponentResult[56], objArr13);
                                Object[] objArr14 = new Object[1];
                                a(null, ((ApplicationInfo) cls5.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr14);
                                String str3 = (String) objArr14[0];
                                Object[] objArr15 = new Object[1];
                                a(null, super.getResources().getString(R.string.saving_withdrawal_address).substring(2, 3).length() + 126, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr15);
                                String str4 = (String) objArr15[0];
                                Object[] objArr16 = new Object[1];
                                a(null, super.getResources().getString(R.string.pushverify_list_binding).substring(17, 20).codePointAt(0) + 95, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr16);
                                try {
                                    Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 17 - ExpandableListView.getPackedPositionChild(0L), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr17);
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
                    Object[] objArr18 = new Object[1];
                    b((short) 37, PlaceComponentResult[32], PlaceComponentResult[25], objArr18);
                    Class<?> cls6 = Class.forName((String) objArr18[0]);
                    Object[] objArr19 = new Object[1];
                    b(PlaceComponentResult[35], (byte) (PlaceComponentResult[32] - 1), PlaceComponentResult[25], objArr19);
                    try {
                        Object[] objArr20 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.indexOf("", "", 0), 3 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ImageFormat.getBitsPerPixel(0) + 1));
                            Object[] objArr21 = new Object[1];
                            c($$a[8], $$a[53], (byte) ($$a[78] - 1), objArr21);
                            obj3 = cls7.getMethod((String) objArr21[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                        int i = ((int[]) objArr22[1])[0];
                        if (((int[]) objArr22[0])[0] != i) {
                            long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), (Process.myPid() >> 22) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr23 = {1710416820, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, View.MeasureSpec.getMode(0) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr23);
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
                        super.onCreate(bundle);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, super.getResources().getString(R.string.pop_up_positive_button_cancel_edit_saving_goal).substring(1, 2).codePointAt(0) + 58, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 127, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, TextUtils.getOffsetBefore("", 0) + 35, (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, (ViewConfiguration.getTapTimeout() >> 16) + 18, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            Object[] objArr = new Object[1];
            a(null, 128 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, super.getResources().getString(R.string.error_merchant_list_title).substring(2, 7).codePointAt(0) + 12, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 35 - View.getDefaultSize(0, 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) Drawable.resolveOpacity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getPresenter")
    public final PhotoGalleryContract.Presenter getPresenter() {
        PhotoGalleryContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(PhotoGalleryContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    private final boolean getAuthRequestContext() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            return extras.getBoolean(EXTRA_PREPOPULATE_IMAGES);
        }
        return false;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ+\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mediaviewer/MerchantPhotoGalleryActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "p3", "Landroid/content/Intent;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "PlaceComponentResult", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", MerchantPhotoGalleryActivity.EXTRA_IMAGES, "Ljava/lang/String;", "EXTRA_MERCHANT_ID", MerchantPhotoGalleryActivity.EXTRA_MERCHANT_NAME, "EXTRA_PREPOPULATE_IMAGES", "EXTRA_SHOP_ID", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1, String p2, String p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intent intent = new Intent(p0, MerchantPhotoGalleryActivity.class);
            intent.putExtra("EXTRA_MERCHANT_ID", p1);
            intent.putExtra("EXTRA_SHOP_ID", p2);
            intent.putExtra(MerchantPhotoGalleryActivity.EXTRA_MERCHANT_NAME, p3);
            return intent;
        }

        public static Intent PlaceComponentResult(Context p0, List<MerchantImageModel> p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(p0, MerchantPhotoGalleryActivity.class);
            intent.putExtra(MerchantPhotoGalleryActivity.EXTRA_PREPOPULATE_IMAGES, true);
            intent.putExtra(MerchantPhotoGalleryActivity.EXTRA_MERCHANT_NAME, p2);
            intent.putParcelableArrayListExtra(MerchantPhotoGalleryActivity.EXTRA_IMAGES, new ArrayList<>(p1));
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$csH503iEHDzHkVOOqCHIAIcLwbw(MerchantPhotoGalleryActivity merchantPhotoGalleryActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantPhotoGalleryActivity, "");
        ((RecyclerView) merchantPhotoGalleryActivity._$_findCachedViewById(R.id.res_0x7f0a1178_platformimplementations_reflectthrowable)).smoothScrollToPosition(0);
    }

    public static /* synthetic */ void $r8$lambda$roR_KzObhSsHqeg9PePzobIz_cA(MerchantPhotoGalleryActivity merchantPhotoGalleryActivity, View view) {
        Intrinsics.checkNotNullParameter(merchantPhotoGalleryActivity, "");
        merchantPhotoGalleryActivity.finish();
    }

    public static final /* synthetic */ void access$openMerchantPhotoViewer(MerchantPhotoGalleryActivity merchantPhotoGalleryActivity, int i) {
        MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
        FragmentManager supportFragmentManager = merchantPhotoGalleryActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        String str = (String) merchantPhotoGalleryActivity.PlaceComponentResult.getValue();
        String str2 = (String) merchantPhotoGalleryActivity.MyBillsEntityDataFactory.getValue();
        int builtInFictitiousFunctionClassFactory = merchantPhotoGalleryActivity.getPresenter().getBuiltInFictitiousFunctionClassFactory();
        List<MerchantImageModel> items = merchantPhotoGalleryActivity.KClassImpl$Data$declaredNonStaticMembers$2.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, new MerchantPhotoViewerModel(str, str2, new MediaViewerModel(i, 50, builtInFictitiousFunctionClassFactory, 0, false, items, 16, null)));
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1178_platformimplementations_reflectthrowable);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        byte b = 0;
        recyclerView.addOnScrollListener(new LazyLoadScrollListener(0, new LazyLoadScrollListener.LazyLoadInteraction() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity$initScrollListener$1
            @Override // id.dana.utils.LazyLoadScrollListener.LazyLoadInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                MerchantPhotoGalleryActivity.this.getPresenter().MyBillsEntityDataFactory();
            }

            @Override // id.dana.utils.LazyLoadScrollListener.LazyLoadInteraction
            public final void BuiltInFictitiousFunctionClassFactory() {
                ((CardView) MerchantPhotoGalleryActivity.this._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572)).setVisibility(0);
            }

            @Override // id.dana.utils.LazyLoadScrollListener.LazyLoadInteraction
            public final void PlaceComponentResult() {
                ((CardView) MerchantPhotoGalleryActivity.this._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572)).setVisibility(8);
            }
        }));
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        recyclerView.setLayoutManager(new GridAutofitLayoutManager(applicationContext, DisplayUtil.dip2px(getApplicationContext(), 110.0f)));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(this.KClassImpl$Data$declaredNonStaticMembers$2);
        ((CardView) _$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantPhotoGalleryActivity.$r8$lambda$csH503iEHDzHkVOOqCHIAIcLwbw(MerchantPhotoGalleryActivity.this, view);
            }
        });
        ((Toolbar) _$_findCachedViewById(R.id.tb_merchant_photo_gallery)).setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MerchantPhotoGalleryActivity.$r8$lambda$roR_KzObhSsHqeg9PePzobIz_cA(MerchantPhotoGalleryActivity.this, view);
            }
        });
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("EXTRA_SHOP_ID") : null;
        String str = string != null ? string : "";
        DaggerPhotoGalleryComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerPhotoGalleryComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (PhotoGalleryModule) Preconditions.getAuthRequestContext(new PhotoGalleryModule((String) this.MyBillsEntityDataFactory.getValue(), str, new PhotoGalleryContract.View() { // from class: id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity$injectDagger$1
            @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(List list, ShopModel shopModel) {
                PhotoGalleryContract.View.CC.MyBillsEntityDataFactory(list, shopModel);
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
            public final /* synthetic */ void onError(String str2) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract.View
            public final void MyBillsEntityDataFactory(List<MerchantImageModel> p0) {
                PhotoGalleryAdapter photoGalleryAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                photoGalleryAdapter = MerchantPhotoGalleryActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                photoGalleryAdapter.setItems(p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, PhotoGalleryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerPhotoGalleryComponent.PhotoGalleryComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, b).BuiltInFictitiousFunctionClassFactory(this);
        if (getAuthRequestContext()) {
            PhotoGalleryAdapter photoGalleryAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Bundle extras2 = getIntent().getExtras();
            List parcelableArrayList = extras2 != null ? extras2.getParcelableArrayList(EXTRA_IMAGES) : null;
            if (parcelableArrayList == null) {
                parcelableArrayList = CollectionsKt.emptyList();
            }
            photoGalleryAdapter.setItems(parcelableArrayList);
            return;
        }
        getPresenter().MyBillsEntityDataFactory();
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = scheduleImpl;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ initRecordTimeStamp);
        if (DatabaseTableConfigUtil) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda2) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
