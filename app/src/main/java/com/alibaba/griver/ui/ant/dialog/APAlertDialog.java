package com.alibaba.griver.ui.ant.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.ui.R;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public class APAlertDialog extends AUBasicDialog {
    public static final byte[] $$a = {83, 16, 71, 115, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 36;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {37, 81, 122, 15, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 235;

    /* renamed from: a  reason: collision with root package name */
    private Context f6671a;
    private LayoutInflater b;
    private View c;
    private Button d;
    private Button e;
    private View.OnClickListener f;
    private View.OnClickListener g;
    private RelativeLayout h;
    private LinearLayout i;
    private TextView j;
    private RelativeLayout k;
    private String l;
    private String m;
    private String n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6672o;

    private static void p(int i, short s, short s2, Object[] objArr) {
        int i2 = 106 - s2;
        int i3 = 19 - (i * 15);
        int i4 = 16 - (s * 3);
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        byte[] bArr2 = new byte[i4];
        int i5 = i4 - 1;
        int i6 = 0;
        if (bArr == null) {
            i3++;
            i2 = i2 + i3 + 2;
        }
        while (true) {
            bArr2[i6] = (byte) i2;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i3];
            i6++;
            i3++;
            i2 = i2 + b + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void q(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.APAlertDialog.$$a
            int r8 = r8 * 2
            int r8 = r8 + 42
            int r9 = r9 * 3
            int r9 = 3 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L36
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L36:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.APAlertDialog.q(short, int, int, java.lang.Object[]):void");
    }

    public View getContentView() {
        return null;
    }

    public APAlertDialog(Context context, String str, String str2, String str3) {
        this(context, str, str2, str3, true);
    }

    public APAlertDialog(Context context, String str, String str2, String str3, boolean z) {
        super(context, R.style.griver_dialog_with_no_title_style_trans_bg);
        this.f6671a = context;
        this.l = str;
        this.m = str2;
        this.n = str3;
        this.f6672o = z;
        this.b = LayoutInflater.from(context);
        this.f6672o = z;
        a();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            p(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            Object[] objArr2 = new Object[1];
            p(b3, (byte) (b3 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 494, 3 - TextUtils.lastIndexOf("", '0'), (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))));
                    byte b4 = (byte) ($$a[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    q(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Color.argb(0, 0, 0, 0), (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1468319357, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, Drawable.resolveOpacity(0, 0) + 18, (char) View.getDefaultSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    private void a() {
        View inflate = this.b.inflate(R.layout.griver_ui_alert_dialog, (ViewGroup) null);
        this.c = inflate;
        this.e = (Button) inflate.findViewById(R.id.btn_positive);
        this.d = (Button) inflate.findViewById(R.id.btn_negative);
        this.j = (TextView) inflate.findViewById(R.id.title);
        this.i = (LinearLayout) inflate.findViewById(R.id.button_ll);
        this.h = (RelativeLayout) inflate.findViewById(R.id.dialog_bg);
        this.k = (RelativeLayout) inflate.findViewById(R.id.container);
        this.j.setText(this.l);
        setCanceledOnTouchOutside(this.f6672o);
        b();
        initContentView();
    }

    public void initContentView() {
        View contentView = getContentView();
        if (contentView != null) {
            getContainerView().addView(contentView);
        }
    }

    private void b() {
        this.d.setText(this.n);
        if (TextUtils.isEmpty(this.n)) {
            this.d.setVisibility(4);
        }
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.dialog.APAlertDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APAlertDialog.this.cancel();
                if (APAlertDialog.this.g != null) {
                    APAlertDialog.this.g.onClick(view);
                }
            }
        });
        this.e.setText(this.m);
        if (TextUtils.isEmpty(this.m)) {
            this.e.setVisibility(4);
        }
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.dialog.APAlertDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                APAlertDialog.this.dismiss();
                if (APAlertDialog.this.f != null) {
                    APAlertDialog.this.f.onClick(view);
                }
            }
        });
    }

    @Override // com.alibaba.griver.ui.ant.dialog.AUBasicDialog, android.app.Dialog
    public void show() {
        super.show();
        setContentView(this.c);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        DisplayMetrics displayMetrics = this.f6671a.getResources().getDisplayMetrics();
        attributes.width = (displayMetrics.widthPixels > displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels) - DensityUtil.dip2px(this.f6671a, 80.0f);
        getWindow().setBackgroundDrawable(InstrumentInjector.Resources_getDrawable(this.f6671a.getResources(), R.color.griver_transparent));
        getWindow().setAttributes(attributes);
    }

    public void setPositiveListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void setNegativeListener(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }

    public TextView getTitleView() {
        return this.j;
    }

    public RelativeLayout getContainerView() {
        return this.k;
    }
}
