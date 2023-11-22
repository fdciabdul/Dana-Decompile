package com.alibaba.griver.core.ui.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.R;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public class H5PromptDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f6474a;
    private LayoutInflater b;
    private View c;
    private Button d;
    private Button e;
    private EditText f;
    private LinearLayout g;
    private TextView h;
    private TextView i;
    private String j;
    private String k;
    private OnClickPositiveListener l;
    private OnClickNegativeListener m;
    private RelativeLayout n;

    /* renamed from: o  reason: collision with root package name */
    private String f6475o;
    private String p;
    private boolean q;
    public static final byte[] $$a = {111, -54, 77, -36, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 245;
    public static final byte[] getAuthRequestContext = {Ascii.EM, -104, -116, 103, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 149;

    /* loaded from: classes6.dex */
    public interface OnClickNegativeListener {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface OnClickPositiveListener {
        void onClick(String str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void r(byte r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.alibaba.griver.core.ui.view.H5PromptDialog.getAuthRequestContext
            int r9 = r9 + 105
            int r8 = r8 * 15
            int r8 = 19 - r8
            int r7 = r7 * 4
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r5 = 0
            r9 = r8
            r8 = r7
            goto L2c
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2c:
            int r7 = r7 + r3
            int r9 = r9 + 1
            int r7 = r7 + 2
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.view.H5PromptDialog.r(byte, short, byte, java.lang.Object[]):void");
    }

    private static void s(byte b, int i, short s, Object[] objArr) {
        int i2 = i + 4;
        byte[] bArr = $$a;
        int i3 = 75 - (b * 3);
        int i4 = (s * 2) + 42;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i3 = (i3 + i6) - 7;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            i2++;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            Object[] objArr2 = objArr;
            int i8 = i6;
            byte[] bArr3 = bArr2;
            byte[] bArr4 = bArr;
            i3 = (i3 + bArr[i2]) - 7;
            i6 = i8;
            objArr = objArr2;
            bArr = bArr4;
            bArr2 = bArr3;
            i5 = i7;
        }
    }

    public H5PromptDialog(Context context, String str, String str2, String str3, String str4) {
        this(context, str, str2, str3, str4, false);
    }

    public H5PromptDialog(Context context, String str, String str2, String str3, String str4, boolean z) {
        super(context, R.style.griver_core_prompt_noTitleTransBgDialogStyle);
        this.f6474a = context;
        this.j = str;
        this.k = str2;
        this.f6475o = str3;
        this.p = str4;
        this.q = z;
        LayoutInflater from = LayoutInflater.from(context);
        this.b = from;
        View inflate = from.inflate(R.layout.griver_core_prompt_input_dialog, (ViewGroup) null);
        this.c = inflate;
        this.e = (Button) inflate.findViewById(R.id.ensure);
        this.d = (Button) inflate.findViewById(R.id.cancel);
        this.h = (TextView) inflate.findViewById(R.id.title);
        this.i = (TextView) inflate.findViewById(R.id.message);
        this.f = (EditText) inflate.findViewById(R.id.inputContent);
        this.g = (LinearLayout) inflate.findViewById(R.id.bottom_ll);
        this.n = (RelativeLayout) inflate.findViewById(R.id.dialog_bg);
        if (TextUtils.isEmpty(this.k)) {
            this.i.setVisibility(8);
        } else {
            this.i.setText(this.k);
            this.i.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.j)) {
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.h.setText(this.j);
        }
        setCanceledOnTouchOutside(this.q);
        a();
    }

    private static int a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (getAuthRequestContext[5] + 1);
            Object[] objArr = new Object[1];
            r(b, b, (byte) (-getAuthRequestContext[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext[5] + 1);
            byte b3 = (byte) (-getAuthRequestContext[5]);
            Object[] objArr2 = new Object[1];
            r(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 494, 4 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = $$a[4];
                    Object[] objArr4 = new Object[1];
                    s(b4, b5, (byte) (b5 + 1), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1821876498, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public EditText getInputContent() {
        return this.f;
    }

    private void a() {
        if (TextUtils.isEmpty(this.p) && TextUtils.isEmpty(this.f6475o)) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        this.d.setText(this.p);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.view.H5PromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                H5PromptDialog.this.cancel();
                if (H5PromptDialog.this.m != null) {
                    H5PromptDialog.this.m.onClick();
                }
            }
        });
        this.e.setText(this.f6475o);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.view.H5PromptDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                H5PromptDialog.this.dismiss();
                if (H5PromptDialog.this.l != null) {
                    if (H5PromptDialog.this.f.getText() == null) {
                        H5PromptDialog.this.l.onClick(null);
                    } else {
                        H5PromptDialog.this.l.onClick(H5PromptDialog.this.f.getText().toString());
                    }
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        setContentView(this.c);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = a(this.f6474a) - (this.f6474a.getResources().getDimensionPixelSize(R.dimen.griver_core_prompt_height) * 2);
        getWindow().setAttributes(attributes);
    }

    public Button getCancelBtn() {
        return this.d;
    }

    public Button getEnsureBtn() {
        return this.e;
    }

    public TextView getTitle() {
        return this.h;
    }

    public TextView getMsg() {
        return this.i;
    }

    public LinearLayout getBottomLayout() {
        return this.g;
    }

    public RelativeLayout getDialogBg() {
        return this.n;
    }

    public void setPositiveListener(OnClickPositiveListener onClickPositiveListener) {
        this.l = onClickPositiveListener;
    }

    public void setNegativeListener(OnClickNegativeListener onClickNegativeListener) {
        this.m = onClickNegativeListener;
    }
}
