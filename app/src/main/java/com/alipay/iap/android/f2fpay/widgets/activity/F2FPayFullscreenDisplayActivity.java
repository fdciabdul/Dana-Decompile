package com.alipay.iap.android.f2fpay.widgets.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.f2fpay.common.F2FPayConstants;
import com.alipay.iap.android.f2fpay.paymentcode.F2FPaymentCodeInfo;
import com.alipay.iap.android.f2fpay.widgets.data.BarCodeConfiguration;
import com.alipay.iap.android.f2fpay.widgets.data.QRCodeConfiguration;
import com.alipay.iap.android.f2fpay.widgets.widget.F2FPayBarcodeView;
import com.alipay.iap.android.f2fpay.widgets.widget.F2FPayQRCodeView;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import java.lang.reflect.Method;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class F2FPayFullscreenDisplayActivity extends Activity {
    private static short[] moveToNextValue;

    /* renamed from: a  reason: collision with root package name */
    private String f6972a;
    private Rect b = new Rect();
    private c c;
    private int d;
    private int e;
    private View f;
    private FrameLayout g;
    public static final byte[] $$a = {10, -99, -17, -84, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 177;
    public static final byte[] PlaceComponentResult = {123, 85, -72, 69, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int MyBillsEntityDataFactory = 228;
    private static int BuiltInFictitiousFunctionClassFactory = 1257195766;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1992424981;
    private static byte[] lookAheadTest = {TarHeader.LF_FIFO, 109, -97, 107, 121, 112, -117, -117, TarHeader.LF_SYMLINK, 105, -84, 35, 114, 115, 112, -97, 119, 96, 3, -20, 19, -53, Ascii.ESC, 46, -103, 96, 105, -110, -120, 65, -105, -111, 105, -113, 103, -117, -70, -119, 94, -100, -115, -87, 82, 97, 98, -97, -114, 102, -113, TarHeader.LF_FIFO, -81, -88, -71, -37, -80, -76, -79, -78, -82, -1, 97, -88, -91, -69, -82, -79, -36, 88, 14, -6, -84, 17, -5, -81, 14, -10, -59, -2, -86, 16, -10, -63, -64, -87, -7, -64, 11, -81, 17, -8, -82, 15, -86, -3, -2, -6, 18, -8, -3, -62, -8, -2, -80, -2, -6, -1, 15, -2, -2, -88, 9, -59, -5, -86, 17, 72, 103, -54, -81, 103, -73, -60, -75, -73, -75, -67, -72, -74, -76, -78, -74, -70, -80, -68, 98, -60, 106, -63, -69, -76, -77, 105, -74, -53, -78, 102, -75, -59, -74, 104, -54, 99, -54, -97, -54, -77, -71, -79, 105, -61, 107, -62, -74, -72, -77, -74, 105, -57, -70, 96, -73, -54, -82, -65, 99, -76, -56, -75, 98, 72, 33, 37, 22, 117, 40, 33, 39, 35, 22, 112, 38, Ascii.CAN, 35, 123, 18, 33, 36, 116, 45, 33, 34, Ascii.SUB, 119, 37, 35, 38, 16, 123, 95, Ascii.ETB, 120, 17, 121, Ascii.DC4, 37, 119, 38, 18, 118, 33, 19, 38, 117, Ascii.ETB, 117, 22, 33, 123, 94, 40, 35, 37, 44, 37, 37, 33, 35, 42, 39, 14, 40, 113, 38, 76, -38, -45, -48, -86, -56, -29, -36, -99, 18, -98, -40, -53, -37, -96, -44, Ascii.US, -109, -96, -54, -25, -105, -37, -51, -28, -112, -90, -56, -83, -43, -37, -54, -89, -56, -83, -53, -32, -97, -40, -57, -37, -86, -58, -35, -90, -49, -91, 19, -116, -90, -52, -36, -28, -39, -92, -110, -42, -35, -39, -51, 2, 63, 58, 4, 56, 9};
    private static int getAuthRequestContext = 825231020;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = F2FPayFullscreenDisplayActivity.this.g.getWidth();
            int height = F2FPayFullscreenDisplayActivity.this.g.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            F2FPayFullscreenDisplayActivity.this.a(width, height);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            F2FPayFullscreenDisplayActivity.this.finish();
        }
    }

    /* loaded from: classes6.dex */
    public enum c {
        QRCode,
        Barcode
    }

    private void a() {
        a(this.b, this.g);
        c cVar = this.c;
        if (cVar == c.QRCode) {
            Rect rect = this.b;
            int i = this.d;
            rect.inset(i, i);
        } else if (cVar == c.Barcode) {
            this.b.inset(0, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        float f;
        if (this.f == null) {
            return;
        }
        int i3 = this.d * 2;
        c cVar = this.c;
        float f2 = 0.0f;
        if (cVar == c.QRCode) {
            f = ((i - i3) * 1.0f) / this.b.width();
        } else if (cVar == c.Barcode) {
            f = ((i2 - i3) * 1.0f) / this.b.width();
            f2 = 90.0f;
        } else {
            f = 0.0f;
        }
        this.f.setScaleX(f);
        this.f.setScaleY(f);
        this.f.setRotation(f2);
        this.f.forceLayout();
        this.f.invalidate();
    }

    public static void a(Rect rect, View view) {
        view.getWindowVisibleDisplayFrame(rect);
        Point point = new Point(rect.left, rect.top);
        view.getGlobalVisibleRect(rect);
        rect.offset(-point.x, -point.y);
        int height = view.getHeight() - rect.height();
        if (height > 0) {
            int i = rect.top;
            if (i <= 0) {
                rect.top = i - height;
            } else {
                rect.bottom += height;
            }
        }
    }

    private void b() {
        FrameLayout frameLayout = new FrameLayout(this);
        this.g = frameLayout;
        frameLayout.setBackgroundColor(this.e);
        addContentView(this.g, new ViewGroup.LayoutParams(-1, -1));
        a();
        this.g.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.b.width(), this.b.height());
        Intent intent = getIntent();
        c cVar = this.c;
        if (cVar == c.QRCode) {
            F2FPayQRCodeView f2FPayQRCodeView = new F2FPayQRCodeView(this);
            this.f = f2FPayQRCodeView;
            f2FPayQRCodeView.setConfiguration((QRCodeConfiguration) intent.getParcelableExtra("QR_CODE_CONFIGURATION"));
            F2FPaymentCodeInfo f2FPaymentCodeInfo = new F2FPaymentCodeInfo();
            f2FPaymentCodeInfo.paymentCode = this.f6972a;
            f2FPayQRCodeView.updatePaymentCode(f2FPaymentCodeInfo);
        } else if (cVar == c.Barcode) {
            F2FPayBarcodeView f2FPayBarcodeView = new F2FPayBarcodeView(this);
            this.f = f2FPayBarcodeView;
            f2FPayBarcodeView.setConfiguration((BarCodeConfiguration) intent.getParcelableExtra("BARCODE_CONFIGURATION"));
            F2FPaymentCodeInfo f2FPaymentCodeInfo2 = new F2FPaymentCodeInfo();
            f2FPaymentCodeInfo2.paymentCode = this.f6972a;
            f2FPayBarcodeView.updatePaymentCode(f2FPaymentCodeInfo2);
            layoutParams.height = -2;
        }
        View view = this.f;
        if (view != null) {
            layoutParams.gravity = 17;
            this.g.addView(view, layoutParams);
        }
        View view2 = new View(this);
        view2.setOnClickListener(new b());
        this.g.addView(view2, -1, -1);
    }

    private boolean c() {
        this.d = com.alipay.iap.android.f2fpay.b.a.a.a(getResources(), 30.0f);
        try {
            Intent intent = getIntent();
            this.f6972a = intent.getStringExtra("PAYMENT_CODE");
            this.e = intent.getIntExtra("BACKGROUND_COLOR", -1);
            this.c = (c) intent.getSerializableExtra("DISPLAY_PATTERN");
            return true;
        } catch (Exception e) {
            LoggerWrapper.e(F2FPayConstants.TAG, e.getMessage(), e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity.PlaceComponentResult
            int r6 = r6 + 16
            int r8 = r8 + 97
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L11
            r4 = r8
            r3 = 0
            r8 = r7
            goto L28
        L11:
            r3 = 0
        L12:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L28:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-4)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity.h(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity.$$a
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r6 = -r6
            int r8 = r8 + r6
            int r7 = r7 + 1
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity.j(byte, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x059d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0941  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0945  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0b0d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x02c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02c0  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r33) {
        /*
            Method dump skipped, instructions count: 2830
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0787 A[Catch: all -> 0x08d7, TryCatch #12 {all -> 0x08d7, blocks: (B:97:0x076f, B:101:0x07d5, B:100:0x0787), top: B:179:0x076f }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x07ec  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x08cf  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x08d3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0786  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(android.os.Bundle r34) {
        /*
            Method dump skipped, instructions count: 2301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.f2fpay.widgets.activity.F2FPayFullscreenDisplayActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = super.getResources().getString(R.string.sendmoney_remarks_add_title).substring(5, 6).codePointAt(0) - 1009694281;
            int i = (-106) - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
            try {
                Object[] objArr = new Object[1];
                h(PlaceComponentResult[30], PlaceComponentResult[7], PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                h(PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], new Object[1]);
                byte b2 = (byte) (((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33);
                try {
                    Object[] objArr2 = new Object[1];
                    h(PlaceComponentResult[30], PlaceComponentResult[7], PlaceComponentResult[25], objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    h(PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], new Object[1]);
                    Object[] objArr3 = new Object[1];
                    i(codePointAt, i, b2, (short) (((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 36), TextUtils.lastIndexOf("", '0') - 2078232091, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    i((-1009694248) - MotionEvent.axisFromString(""), (-106) - View.MeasureSpec.getSize(0), (byte) (super.getResources().getString(R.string.passkey_enrollment_main_description).substring(0, 8).codePointAt(1) - 97), (short) (super.getResources().getString(R.string.toast_edit_saving_goal_success).substring(9, 11).length() - 51), super.getResources().getString(R.string.group_send_type_contact).substring(4, 5).codePointAt(0) - 2078232098, objArr4);
                    baseContext = (Context) cls3.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int codePointAt = super.getResources().getString(R.string.topup_and_pay_amount_monthly_limit_error_message).substring(9, 10).codePointAt(0) - 1009694346;
            int length = super.getResources().getString(R.string.expired).substring(0, 7).length() - 113;
            try {
                Object[] objArr = new Object[1];
                h(PlaceComponentResult[30], PlaceComponentResult[7], PlaceComponentResult[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                h(PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], new Object[1]);
                byte b2 = (byte) (((ApplicationInfo) cls.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33);
                try {
                    Object[] objArr2 = new Object[1];
                    h(PlaceComponentResult[30], PlaceComponentResult[7], PlaceComponentResult[25], objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    h(PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], new Object[1]);
                    short s = (short) (((ApplicationInfo) cls2.getMethod((String) r2[0], null).invoke(this, null)).targetSdkVersion - 36);
                    try {
                        Object[] objArr3 = new Object[1];
                        h(PlaceComponentResult[30], PlaceComponentResult[7], PlaceComponentResult[25], objArr3);
                        Class<?> cls3 = Class.forName((String) objArr3[0]);
                        Object[] objArr4 = new Object[1];
                        h(PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], objArr4);
                        int i = ((ApplicationInfo) cls3.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 2078232125;
                        Object[] objArr5 = new Object[1];
                        i(codePointAt, length, b2, s, i, objArr5);
                        Class<?> cls4 = Class.forName((String) objArr5[0]);
                        int scrollBarSize = (ViewConfiguration.getScrollBarSize() >> 8) - 1009694247;
                        int combineMeasuredStates = View.combineMeasuredStates(0, 0) - 106;
                        try {
                            Object[] objArr6 = new Object[1];
                            h(PlaceComponentResult[30], PlaceComponentResult[7], PlaceComponentResult[25], objArr6);
                            Class<?> cls5 = Class.forName((String) objArr6[0]);
                            h(PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), PlaceComponentResult[5], new Object[1]);
                            Object[] objArr7 = new Object[1];
                            i(scrollBarSize, combineMeasuredStates, (byte) (((ApplicationInfo) cls5.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33), (short) (super.getResources().getString(R.string.dana_plus_home_last_updated).substring(0, 16).length() - 65), (-2078232066) - KeyEvent.getDeadChar(0, 0), objArr7);
                            baseContext = (Context) cls4.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr8 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), Color.red(0) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr8);
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
        super.onResume();
    }

    private static void i(int i, int i2, byte b2, short s, int i3, Object[] objArr) {
        B b3 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = lookAheadTest;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (lookAheadTest[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (moveToNextValue[i3 + ((int) (getAuthRequestContext ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b3.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (getAuthRequestContext ^ 3097486228508854431L)) + i5;
            b3.MyBillsEntityDataFactory = (char) (i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
            sb.append(b3.MyBillsEntityDataFactory);
            b3.PlaceComponentResult = b3.MyBillsEntityDataFactory;
            byte[] bArr3 = lookAheadTest;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b3.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b3.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = lookAheadTest;
                    b3.getAuthRequestContext = b3.getAuthRequestContext - 1;
                    b3.MyBillsEntityDataFactory = (char) (b3.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b2));
                } else {
                    short[] sArr = moveToNextValue;
                    b3.getAuthRequestContext = b3.getAuthRequestContext - 1;
                    b3.MyBillsEntityDataFactory = (char) (b3.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b2));
                }
                sb.append(b3.MyBillsEntityDataFactory);
                b3.PlaceComponentResult = b3.MyBillsEntityDataFactory;
                b3.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
