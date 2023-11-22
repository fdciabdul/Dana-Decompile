package com.alibaba.griver.core.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.R;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverDialog extends AlertDialog {
    public static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 54;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {Ascii.EM, 16, -94, Ascii.FS, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 128;

    /* renamed from: a  reason: collision with root package name */
    private TextView f6469a;
    private TextView b;
    private FrameLayout c;
    private TextView d;
    private TextView e;
    private View f;
    private RelativeLayout g;
    private TextView h;
    private TextView i;
    private View j;
    private LinearLayout k;
    private LinearLayout l;
    private DialogParam m;
    private boolean n;

    /* loaded from: classes6.dex */
    public static class DialogParam {
        public String align;
        public DialogInterface.OnCancelListener cancelListener;
        public boolean cancelable = true;
        public String message;
        public DialogInterface.OnClickListener negativeListener;
        public String negativeString;
        public String negativeTextColor;
        public DialogInterface.OnClickListener positiveListener;
        public String positiveString;
        public String positiveTextColor;
        public String title;
        public View view;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void o(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 15
            int r7 = 19 - r7
            int r8 = r8 * 4
            int r8 = 16 - r8
            byte[] r0 = com.alibaba.griver.core.ui.dialog.GriverDialog.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 + 105
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            goto L32
        L17:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L1b:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L32:
            int r8 = r8 + r9
            int r8 = r8 + 2
            int r7 = r7 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.dialog.GriverDialog.o(int, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void p(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = r9 + 4
            byte[] r0 = com.alibaba.griver.core.ui.dialog.GriverDialog.$$a
            int r8 = r8 * 3
            int r8 = r8 + 75
            int r7 = r7 * 3
            int r7 = r7 + 42
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L1e:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L36:
            int r9 = r9 + r7
            int r7 = r10 + 1
            int r9 = r9 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.dialog.GriverDialog.p(int, short, int, java.lang.Object[]):void");
    }

    public GriverDialog(Context context) {
        super(context);
        this.m = new DialogParam();
        this.n = false;
    }

    protected GriverDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.m = new DialogParam();
        this.n = false;
    }

    protected GriverDialog(Context context, int i) {
        super(context, i);
        this.m = new DialogParam();
        this.n = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DialogParam a() {
        return this.m;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            Object[] objArr = new Object[1];
            o(b, b, (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            o(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - ExpandableListView.getPackedPositionChild(0L), 4 - TextUtils.getCapsMode("", 0, 0), (char) KeyEvent.getDeadChar(0, 0));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    p(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-429104343, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                super.onCreate(bundle);
                if (this.n) {
                    setContentView(R.layout.griver_core_uniform_dialog);
                    b();
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

    private void b() {
        this.f6469a = (TextView) findViewById(R.id.tv_title);
        this.b = (TextView) findViewById(R.id.tv_message);
        this.c = (FrameLayout) findViewById(R.id.custom_view_Layout);
        this.d = (TextView) findViewById(R.id.tv_negative_text);
        this.e = (TextView) findViewById(R.id.tv_positive_text);
        this.f = findViewById(R.id.button_view_divider);
        this.g = (RelativeLayout) findViewById(R.id.layout_button);
        this.l = (LinearLayout) findViewById(R.id.layout_dialog);
        this.h = (TextView) findViewById(R.id.tv_negative_vertical_text);
        this.i = (TextView) findViewById(R.id.tv_positive_vertical_text);
        this.j = findViewById(R.id.button_view_vertical_divider);
        this.k = (LinearLayout) findViewById(R.id.layout_vertical_button);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.n && this.m.view != null && canTextInput(this.m.view)) {
            setView(new EditText(getContext()));
        }
        super.show();
        if (this.n) {
            c();
        }
    }

    private void c() {
        f();
        g();
        h();
        i();
        e();
        d();
    }

    private void d() {
        if (this.m.view != null) {
            this.c.setVisibility(0);
            this.c.removeAllViews();
            this.c.addView(this.m.view, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void e() {
        setCancelable(this.m.cancelable);
        if (this.m.cancelListener != null) {
            setOnCancelListener(this.m.cancelListener);
        }
    }

    private void f() {
        if (TextUtils.isEmpty(this.m.title) && TextUtils.isEmpty(this.m.message) && TextUtils.isEmpty(this.m.positiveString) && TextUtils.isEmpty(this.m.negativeString)) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
        }
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            WindowManager windowManager = getWindow().getWindowManager();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            StringBuilder sb = new StringBuilder();
            sb.append("window width: ");
            sb.append(i);
            GriverLogger.d("GriverDialog", sb.toString());
            if (i > 540) {
                attributes.width = (i * 4) / 5;
            }
            int i2 = (displayMetrics.heightPixels * 3) / 5;
            if (this.l.getMeasuredHeight() > i2) {
                attributes.height = i2;
            }
            if (isShowing()) {
                window.setAttributes(attributes);
            }
            window.getDecorView().setBackgroundResource(R.drawable.griver_core_custom_dialog);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
    }

    private void g() {
        if (TextUtils.isEmpty(this.m.title)) {
            return;
        }
        this.f6469a.setVisibility(0);
        this.f6469a.setText(this.m.title);
    }

    private void h() {
        if (!TextUtils.isEmpty(this.m.message)) {
            this.b.setVisibility(0);
            this.b.setText(this.m.message);
        }
        if (TextUtils.equals(this.m.align, "left")) {
            this.b.setGravity(3);
        } else if (TextUtils.equals(this.m.align, "right")) {
            this.b.setGravity(5);
        } else {
            this.b.setGravity(17);
        }
    }

    private void i() {
        if (!TextUtils.isEmpty(this.m.positiveString) && !TextUtils.isEmpty(this.m.negativeString) && (a(this.m.positiveString) > 100.0f || a(this.m.negativeString) > 100.0f)) {
            this.k.setVisibility(0);
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            this.h.setText(this.m.negativeString);
            this.i.setText(this.m.positiveString);
            a(this.i, this.m.positiveTextColor);
            a(this.h, this.m.negativeTextColor);
            a(this.i);
            b(this.h);
            return;
        }
        if (!TextUtils.isEmpty(this.m.positiveString) || !TextUtils.isEmpty(this.m.negativeString)) {
            this.g.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.m.positiveString) && !TextUtils.isEmpty(this.m.negativeString)) {
            this.f.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.m.positiveString)) {
            this.e.setVisibility(0);
            this.e.setText(this.m.positiveString);
            a(this.e, this.m.positiveTextColor);
            a(this.e);
        }
        if (TextUtils.isEmpty(this.m.negativeString)) {
            return;
        }
        this.d.setVisibility(0);
        this.d.setText(this.m.negativeString);
        a(this.d, this.m.negativeTextColor);
        b(this.d);
    }

    private float a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setTextSize(15.0f);
        float measureText = paint.measureText(str);
        StringBuilder sb = new StringBuilder();
        sb.append("text length for ");
        sb.append(str);
        sb.append(" is: ");
        sb.append(measureText);
        GriverLogger.d("GriverDialog", sb.toString());
        return measureText;
    }

    private void a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse text color failed: ");
            sb.append(str);
            GriverLogger.e("GriverDialog", sb.toString(), e);
        }
    }

    private void a(TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.dialog.GriverDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GriverDialog.this.m.positiveListener != null) {
                    GriverDialog.this.m.positiveListener.onClick(GriverDialog.this, -1);
                }
                GriverDialog.this.dismiss();
            }
        });
    }

    private void b(TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.dialog.GriverDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GriverDialog.this.m.negativeListener != null) {
                    GriverDialog.this.m.negativeListener.onClick(GriverDialog.this, -2);
                }
                GriverDialog.this.dismiss();
            }
        });
    }

    static boolean canTextInput(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (canTextInput(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        GriverDialog griverDialog;

        public Builder(Context context) {
            this.griverDialog = new GriverDialog(context);
        }

        public Builder title(String str) {
            this.griverDialog.a().title = str;
            return this;
        }

        public Builder message(String str) {
            this.griverDialog.a().message = str;
            return this;
        }

        public Builder align(String str) {
            this.griverDialog.a().align = str;
            return this;
        }

        public Builder positiveString(String str) {
            this.griverDialog.a().positiveString = str;
            return this;
        }

        public Builder negativeString(String str) {
            this.griverDialog.a().negativeString = str;
            return this;
        }

        public Builder positiveTextColor(String str) {
            this.griverDialog.a().positiveTextColor = str;
            return this;
        }

        public Builder negativeTextColor(String str) {
            this.griverDialog.a().negativeTextColor = str;
            return this;
        }

        public Builder positiveListener(DialogInterface.OnClickListener onClickListener) {
            this.griverDialog.a().positiveListener = onClickListener;
            return this;
        }

        public Builder negativeListener(DialogInterface.OnClickListener onClickListener) {
            this.griverDialog.a().negativeListener = onClickListener;
            return this;
        }

        public Builder cancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.griverDialog.a().cancelListener = onCancelListener;
            return this;
        }

        public Builder cancelable(boolean z) {
            this.griverDialog.a().cancelable = z;
            return this;
        }

        public Builder view(View view) {
            this.griverDialog.a().view = view;
            return this;
        }

        public GriverDialog create() {
            this.griverDialog.n = true;
            return this.griverDialog;
        }
    }
}
