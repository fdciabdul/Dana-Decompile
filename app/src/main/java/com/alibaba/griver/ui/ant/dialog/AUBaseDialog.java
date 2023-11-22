package com.alibaba.griver.ui.ant.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.api.OnItemClickListener;
import com.alibaba.griver.ui.ant.helper.TextButtonListAdapter;
import com.alibaba.griver.ui.ant.layout.AULinearLayout;
import com.alibaba.griver.ui.ant.listview.AUMaxItemCornerListView;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public abstract class AUBaseDialog extends AUDialog {
    public static final byte[] $$a = {Ascii.DC4, -68, -64, 70, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 236;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {121, 107, -47, -24, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 202;

    /* renamed from: a  reason: collision with root package name */
    private int f6673a;
    private AULinearLayout b;
    private AUMaxItemCornerListView c;
    private TextButtonListAdapter d;
    private AULinearLayout e;
    protected LayoutInflater inflater;
    protected Button mCancelBtn;
    protected Button mEnsureBtn;
    public AULinearLayout rootView;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void p(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.AUBaseDialog.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 * 4
            int r7 = 16 - r7
            int r8 = 106 - r8
            int r6 = r6 * 15
            int r6 = 19 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            int r7 = r7 + 1
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.AUBaseDialog.p(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void q(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.AUBaseDialog.$$a
            int r7 = r7 * 2
            int r7 = 75 - r7
            int r8 = r8 + 4
            int r6 = r6 * 2
            int r6 = r6 + 42
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.AUBaseDialog.q(short, byte, byte, java.lang.Object[]):void");
    }

    public abstract void initCustomView(AULinearLayout aULinearLayout);

    public abstract int initHorizonMaskSpace();

    public AUBaseDialog(Context context, int i) {
        super(context, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            p(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[5];
            Object[] objArr2 = new Object[1];
            p(b3, (byte) (b3 - 1), BuiltInFictitiousFunctionClassFactory[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 4 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) View.combineMeasuredStates(0, 0));
                    byte b4 = (byte) ($$a[35] - 1);
                    Object[] objArr4 = new Object[1];
                    q(b4, b4, $$a[4], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1698464371, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.getDefaultSize(0, 0), 18 - Color.blue(0), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                LayoutInflater from = LayoutInflater.from(getContext());
                this.inflater = from;
                AULinearLayout aULinearLayout = (AULinearLayout) from.inflate(R.layout.griver_ui_base_dailog, (ViewGroup) null);
                this.rootView = aULinearLayout;
                setContentView(aULinearLayout);
                AULinearLayout aULinearLayout2 = (AULinearLayout) this.rootView.findViewById(R.id.dialog_custom_view);
                this.e = aULinearLayout2;
                initCustomView(aULinearLayout2);
                setContentView(this.rootView);
                this.f6673a = initHorizonMaskSpace();
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

    @Override // com.alibaba.griver.ui.ant.dialog.AUBasicDialog, android.app.Dialog
    public void show() {
        super.show();
        if (isShowing()) {
            setWindowMaxWidth(this.f6673a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
    
        if (r3.measureText(r4.toString()) <= ((com.alibaba.griver.ui.ant.utils.ToolUtils.getScreenWidth_Height(getContext())[0] - (r7.f6673a * 2)) - getContext().getResources().getDimensionPixelSize(com.alibaba.griver.ui.R.dimen.griver_notice_max_button_width))) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setButtonStyle(java.lang.String r8, java.lang.String r9, com.alibaba.griver.ui.ant.api.OnItemClickListener r10) {
        /*
            r7 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 == 0) goto L9
            r0 = 0
            goto Ld
        L9:
            int r0 = r8.length()
        Ld:
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 == 0) goto L15
            r2 = 0
            goto L19
        L15:
            int r2 = r9.length()
        L19:
            if (r0 != 0) goto L1e
            if (r2 != 0) goto L1e
            return
        L1e:
            int r3 = r0 + r2
            r4 = 8
            if (r3 <= r4) goto L71
            android.text.TextPaint r3 = new android.text.TextPaint
            r3.<init>()
            android.content.Context r4 = r7.getContext()
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.alibaba.griver.ui.R.dimen.griver_AU_TEXTSIZE4
            int r4 = r4.getDimensionPixelSize(r5)
            float r4 = (float) r4
            r3.setTextSize(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            float r3 = r3.measureText(r4)
            android.content.Context r4 = r7.getContext()
            int[] r4 = com.alibaba.griver.ui.ant.utils.ToolUtils.getScreenWidth_Height(r4)
            r4 = r4[r1]
            int r5 = r7.f6673a
            android.content.Context r6 = r7.getContext()
            int r5 = r5 * 2
            int r4 = r4 - r5
            android.content.res.Resources r5 = r6.getResources()
            int r6 = com.alibaba.griver.ui.R.dimen.griver_notice_max_button_width
            int r5 = r5.getDimensionPixelSize(r6)
            int r4 = r4 - r5
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L72
        L71:
            r1 = 1
        L72:
            if (r1 == 0) goto L78
            r7.addHorizonButtonView(r8, r9, r10)
            return
        L78:
            r7.addDividerView()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r0 == 0) goto L85
            r1.add(r8)
        L85:
            if (r2 == 0) goto L8a
            r1.add(r9)
        L8a:
            r7.addListButtonView(r1, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.AUBaseDialog.setButtonStyle(java.lang.String, java.lang.String, com.alibaba.griver.ui.ant.api.OnItemClickListener):void");
    }

    public void setButtonStyle(List<String> list, OnItemClickListener onItemClickListener) {
        addListButtonView(list, onItemClickListener);
    }

    public void setButtonStyle(BaseAdapter baseAdapter) {
        if (this.c == null) {
            AUMaxItemCornerListView aUMaxItemCornerListView = new AUMaxItemCornerListView(getContext());
            this.c = aUMaxItemCornerListView;
            aUMaxItemCornerListView.setBackgroundColor(0);
            this.c.setDivider(new ColorDrawable(getContext().getResources().getColor(R.color.griver_AU_COLOR_DIALOG_DIVIDER_COLOR)));
            this.c.setDividerHeight(1);
            this.rootView.addView(this.c);
        }
        this.c.setAdapter((ListAdapter) baseAdapter);
    }

    public void addHorizonButtonView(String str, String str2, final OnItemClickListener onItemClickListener) {
        if (this.b == null) {
            AULinearLayout aULinearLayout = (AULinearLayout) this.inflater.inflate(R.layout.griver_ui_base_dialog_button, (ViewGroup) null);
            this.b = aULinearLayout;
            this.mEnsureBtn = (Button) aULinearLayout.findViewById(R.id.ensure);
            this.mCancelBtn = (Button) this.b.findViewById(R.id.cancel);
            this.rootView.addView(this.b);
        }
        if (TextUtils.isEmpty(str2)) {
            this.mCancelBtn.setVisibility(8);
        } else {
            this.mCancelBtn.setVisibility(0);
            this.mCancelBtn.setText(str2);
        }
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.dialog.AUBaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnItemClickListener onItemClickListener2 = onItemClickListener;
                if (onItemClickListener2 != null) {
                    onItemClickListener2.onClick(AUBaseDialog.this.mCancelBtn, 1);
                }
            }
        });
        if (TextUtils.isEmpty(str)) {
            this.mEnsureBtn.setVisibility(8);
        } else {
            this.mEnsureBtn.setText(str);
            this.mEnsureBtn.setVisibility(0);
        }
        this.mEnsureBtn.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.ant.dialog.AUBaseDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnItemClickListener onItemClickListener2 = onItemClickListener;
                if (onItemClickListener2 != null) {
                    onItemClickListener2.onClick(AUBaseDialog.this.mEnsureBtn, 0);
                }
            }
        });
    }

    public void addListButtonView(List<String> list, OnItemClickListener onItemClickListener) {
        if (this.c == null) {
            AUMaxItemCornerListView aUMaxItemCornerListView = new AUMaxItemCornerListView(getContext());
            this.c = aUMaxItemCornerListView;
            aUMaxItemCornerListView.setBackgroundColor(0);
            this.c.setDivider(new ColorDrawable(getContext().getResources().getColor(R.color.griver_AU_COLOR_DIALOG_DIVIDER_COLOR)));
            this.c.setDividerHeight(1);
            TextButtonListAdapter textButtonListAdapter = new TextButtonListAdapter(17, getContext().getResources().getColor(R.color.griver_AU_COLOR_LINK));
            this.d = textButtonListAdapter;
            this.c.setAdapter((ListAdapter) textButtonListAdapter);
            this.rootView.addView(this.c);
        }
        this.d.setData(getContext(), list, onItemClickListener);
    }

    public TextView getButtonItem(int i) {
        if (this.b != null) {
            return i == 0 ? this.mEnsureBtn : this.mCancelBtn;
        }
        AUMaxItemCornerListView aUMaxItemCornerListView = this.c;
        if (aUMaxItemCornerListView != null) {
            return (TextView) aUMaxItemCornerListView.getChildAt(i);
        }
        return null;
    }

    public void addDividerView() {
        View view = new View(getContext());
        view.setBackgroundColor(getContext().getResources().getColor(R.color.griver_AU_COLOR_DIALOG_DIVIDER_COLOR));
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
        this.rootView.addView(view);
    }
}
