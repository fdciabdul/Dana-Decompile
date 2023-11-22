package id.dana.toggle.userloginlogout;

import android.graphics.ImageFormat;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.OnLifecycleEvent;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.LifecycleUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u0007\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/toggle/userloginlogout/LoginLogoutObserver;", "Landroidx/lifecycle/LifecycleObserver;", "Lid/dana/toggle/userloginlogout/ILoginLogoutObserver;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/toggle/userloginlogout/ILoginLogoutObserver;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "onCreate", "onDestroy", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "getAuthRequestContext", "Lid/dana/data/login/LoginLogoutSubject;", "Lid/dana/data/login/LoginLogoutSubject;", "Ljava/util/Vector;", "MyBillsEntityDataFactory", "Ljava/util/Vector;", "PlaceComponentResult", "<init>", "(Lid/dana/data/login/LoginLogoutSubject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginLogoutObserver implements LifecycleObserver {
    public static final byte[] $$a = {117, -10, 119, -11, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 143;
    public static final byte[] PlaceComponentResult = {42, -75, 2, Ascii.US, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int moveToNextValue = 151;
    public final LoginLogoutSubject BuiltInFictitiousFunctionClassFactory;
    public Disposable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Vector<ILoginLogoutObserver> PlaceComponentResult;
    public Disposable getAuthRequestContext;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = r8 + 4
            int r6 = r6 * 4
            int r6 = r6 + 16
            byte[] r0 = id.dana.toggle.userloginlogout.LoginLogoutObserver.PlaceComponentResult
            int r7 = r7 + 105
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L17:
            r3 = 0
        L18:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r8 = r8 + 1
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.toggle.userloginlogout.LoginLogoutObserver.a(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 75
            int r9 = r9 * 4
            int r9 = 42 - r9
            int r7 = r7 * 3
            int r7 = 3 - r7
            byte[] r0 = id.dana.toggle.userloginlogout.LoginLogoutObserver.$$a
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L19:
            r3 = 0
        L1a:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L34:
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.toggle.userloginlogout.LoginLogoutObserver.b(short, int, byte, java.lang.Object[]):void");
    }

    public LoginLogoutObserver(LoginLogoutSubject loginLogoutSubject) {
        Intrinsics.checkNotNullParameter(loginLogoutSubject, "");
        this.BuiltInFictitiousFunctionClassFactory = loginLogoutSubject;
        this.PlaceComponentResult = new Vector<>();
        BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext = LifecycleUtil.getAuthRequestContext(this);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(ILoginLogoutObserver p0) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (!this.PlaceComponentResult.contains(p0)) {
                this.PlaceComponentResult.addElement(p0);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        try {
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = PlaceComponentResult[5];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 495, 3 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0));
                    byte b5 = (byte) ($$a[35] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-786352285, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 18 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(LoginLogoutObserver loginLogoutObserver, LoginLogoutSubject.UserLogin userLogin) {
        Intrinsics.checkNotNullParameter(loginLogoutObserver, "");
        synchronized (loginLogoutObserver) {
            StringBuilder sb = new StringBuilder();
            sb.append("User is logged-in ");
            sb.append(userLogin.isLoggedIn());
            DanaLog.getAuthRequestContext("DanaLogin", sb.toString());
            for (ILoginLogoutObserver iLoginLogoutObserver : loginLogoutObserver.PlaceComponentResult) {
                Intrinsics.checkNotNullExpressionValue(userLogin, "");
                iLoginLogoutObserver.PlaceComponentResult(userLogin);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Disposable disposable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (disposable != null) {
            disposable.dispose();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.toObservable().subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.toggle.userloginlogout.LoginLogoutObserver$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LoginLogoutObserver.KClassImpl$Data$declaredNonStaticMembers$2(LoginLogoutObserver.this, (LoginLogoutSubject.UserLogin) obj);
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Disposable disposable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (disposable != null) {
            disposable.dispose();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        Disposable disposable2 = this.getAuthRequestContext;
        if (disposable2 != null) {
            disposable2.dispose();
        }
    }
}
