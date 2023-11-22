package id.dana.toggle.locationpermission;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.OnLifecycleEvent;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.LifecycleUtil;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u0003\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011"}, d2 = {"Lid/dana/toggle/locationpermission/LocationPermissionObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "onCreate", "onDestroy", "Lio/reactivex/disposables/Disposable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/disposables/Disposable;", "getAuthRequestContext", "MyBillsEntityDataFactory", "Lid/dana/toggle/locationpermission/LocationPermissionSubject;", "getErrorConfigVersion", "Lid/dana/toggle/locationpermission/LocationPermissionSubject;", "Ljava/util/Vector;", "Lid/dana/toggle/locationpermission/ILocationPermissionObserver;", "Ljava/util/Vector;", "p0", "<init>", "(Lid/dana/toggle/locationpermission/LocationPermissionSubject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocationPermissionObserver implements LifecycleObserver {
    public static final byte[] $$a = {44, 104, -53, -66, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 45;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {56, -13, -61, 104, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 9;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Disposable getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Vector<ILocationPermissionObserver> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Disposable MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final LocationPermissionSubject BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.toggle.locationpermission.LocationPermissionObserver.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 + 105
            int r8 = r8 + 4
            int r9 = r9 * 3
            int r9 = r9 + 16
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.toggle.locationpermission.LocationPermissionObserver.a(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 42
            int r9 = r9 * 4
            int r9 = r9 + 75
            int r8 = r8 + 4
            byte[] r0 = id.dana.toggle.locationpermission.LocationPermissionObserver.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L19:
            r3 = 0
        L1a:
            int r8 = r8 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r10 = r10 + r7
            int r7 = r10 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.toggle.locationpermission.LocationPermissionObserver.b(byte, int, int, java.lang.Object[]):void");
    }

    public LocationPermissionObserver(LocationPermissionSubject locationPermissionSubject) {
        Intrinsics.checkNotNullParameter(locationPermissionSubject, "");
        this.BuiltInFictitiousFunctionClassFactory = locationPermissionSubject;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Vector<>();
        BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory = LifecycleUtil.getAuthRequestContext(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        try {
            Object[] objArr = new Object[1];
            a(BuiltInFictitiousFunctionClassFactory[5], (byte) (PlaceComponentResult + 5), (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            byte b2 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.getDefaultSize(0, 0), 3 - TextUtils.indexOf((CharSequence) "", '0'), (char) Color.green(0));
                    byte b3 = (byte) ($$a[35] - 1);
                    byte b4 = $$a[4];
                    Object[] objArr4 = new Object[1];
                    b(b3, b4, (byte) (b4 + 1), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionGroup(0L), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1681156762, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 18 - ExpandableListView.getPackedPositionType(0L), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                BuiltInFictitiousFunctionClassFactory();
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

    public static /* synthetic */ void getAuthRequestContext(LocationPermissionObserver locationPermissionObserver, Boolean bool) {
        Intrinsics.checkNotNullParameter(locationPermissionObserver, "");
        synchronized (locationPermissionObserver) {
            for (ILocationPermissionObserver iLocationPermissionObserver : locationPermissionObserver.KClassImpl$Data$declaredNonStaticMembers$2) {
                Intrinsics.checkNotNullExpressionValue(bool, "");
                iLocationPermissionObserver.MyBillsEntityDataFactory(bool.booleanValue());
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Disposable disposable = this.getAuthRequestContext;
        if (disposable != null) {
            disposable.dispose();
        }
        this.getAuthRequestContext = null;
        this.getAuthRequestContext = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.toggle.locationpermission.LocationPermissionObserver$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LocationPermissionObserver.getAuthRequestContext(LocationPermissionObserver.this, (Boolean) obj);
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Disposable disposable = this.getAuthRequestContext;
        if (disposable != null) {
            disposable.dispose();
        }
        this.getAuthRequestContext = null;
        Disposable disposable2 = this.MyBillsEntityDataFactory;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
