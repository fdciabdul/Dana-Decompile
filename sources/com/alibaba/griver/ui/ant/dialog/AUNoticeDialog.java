package com.alibaba.griver.ui.ant.dialog;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.api.OnItemClickListener;
import com.alibaba.griver.ui.ant.layout.AULinearLayout;
import com.alibaba.griver.ui.ant.text.AUTextView;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class AUNoticeDialog extends AUBaseDialog {
    public static final byte[] $$d = {36, -18, 4, 125, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 76;
    public static final byte[] PlaceComponentResult = {111, 16, 84, -34, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 253;

    /* renamed from: a  reason: collision with root package name */
    private Context f6678a;
    private AUTextView b;
    private AUTextView c;
    private ScrollView d;
    private CharSequence e;
    private CharSequence f;
    private OnClickPositiveListener g;
    private OnClickNegativeListener h;
    private String i;
    private String j;
    private boolean k;
    private List<View> l;
    private MovementMethod m;
    private String n;

    /* renamed from: o  reason: collision with root package name */
    private String f6679o;

    /* loaded from: classes6.dex */
    public interface OnClickNegativeListener {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public interface OnClickPositiveListener {
        void onClick();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void r(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 105
            int r6 = r6 * 15
            int r6 = 19 - r6
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.AUNoticeDialog.PlaceComponentResult
            int r7 = r7 * 2
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = 0
            r8 = r7
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r6 = r6 + r3
            int r6 = r6 + 2
            int r7 = r7 + 1
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.AUNoticeDialog.r(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void s(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r6 = r6 * 4
            int r6 = 75 - r6
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.AUNoticeDialog.$$d
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L38
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.AUNoticeDialog.s(int, int, byte, java.lang.Object[]):void");
    }

    public AUNoticeDialog(Context context, CharSequence charSequence, CharSequence charSequence2, String str, String str2) {
        this(context, charSequence, charSequence2, str, str2, false);
    }

    public AUNoticeDialog(Context context, CharSequence charSequence, CharSequence charSequence2, String str, String str2, boolean z) {
        super(context, R.style.griver_noTitleTransBgDialogStyle);
        this.k = false;
        this.l = new ArrayList();
        a(context, charSequence, charSequence2, str, str2, z);
    }

    public AUNoticeDialog(Context context, CharSequence charSequence, CharSequence charSequence2, String str, String str2, boolean z, View view) {
        super(context, R.style.griver_noTitleTransBgDialogStyle);
        this.k = false;
        this.l = new ArrayList();
        a(context, charSequence, charSequence2, str, str2, z);
        this.l.clear();
        this.l.add(view);
    }

    @Deprecated
    public AUNoticeDialog(Context context, CharSequence charSequence, CharSequence charSequence2, String str, String str2, boolean z, List<View> list) {
        super(context, R.style.griver_noTitleTransBgDialogStyle);
        this.k = false;
        this.l = new ArrayList();
        a(context, charSequence, charSequence2, str, str2, z);
        this.l.clear();
        this.l.addAll(list);
    }

    private void a(Context context, CharSequence charSequence, CharSequence charSequence2, String str, String str2, boolean z) {
        this.f6678a = context;
        this.e = charSequence;
        this.f = charSequence2;
        this.i = str;
        this.j = str2;
        this.k = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.griver.ui.ant.dialog.AUBaseDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            Object[] objArr = new Object[1];
            r(b, b, (byte) (-PlaceComponentResult[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-PlaceComponentResult[5]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            r(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 494, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 4, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                    byte b4 = (byte) ($$d[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    s(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-525855312, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 19, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                this.rootView.setMinimumHeight(this.f6678a.getResources().getDimensionPixelSize(R.dimen.griver_dialog_min_height));
                addDescriptionView();
                setCanceledOnTouchOutside(this.k);
                setButtonStyle(this.i, this.j, new OnItemClickListener() { // from class: com.alibaba.griver.ui.ant.dialog.AUNoticeDialog.1
                    @Override // com.alibaba.griver.ui.ant.api.OnItemClickListener
                    public void onClick(View view, int i2) {
                        if (i2 == 0) {
                            AUNoticeDialog.this.dismiss();
                            if (AUNoticeDialog.this.g != null) {
                                AUNoticeDialog.this.g.onClick();
                            }
                        } else if (i2 == 1) {
                            AUNoticeDialog.this.cancel();
                            if (AUNoticeDialog.this.h != null) {
                                AUNoticeDialog.this.h.onClick();
                            }
                        }
                    }
                });
                if (!TextUtils.isEmpty(this.n) && this.mEnsureBtn != null) {
                    try {
                        this.mEnsureBtn.setTextColor(Color.parseColor(this.n));
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("set positiveTextColor failed: ");
                        sb.append(this.n);
                        sb.append(", ");
                        sb.append(e.getLocalizedMessage());
                        GriverLogger.e("AUNoticeDialog", sb.toString());
                    }
                }
                if (TextUtils.isEmpty(this.f6679o) || this.mCancelBtn == null) {
                    return;
                }
                try {
                    this.mCancelBtn.setTextColor(Color.parseColor(this.f6679o));
                } catch (Exception e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("set negativeTextColor failed: ");
                    sb2.append(this.f6679o);
                    sb2.append(", ");
                    sb2.append(e2.getLocalizedMessage());
                    GriverLogger.e("AUNoticeDialog", sb2.toString());
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

    private void a(AUTextView aUTextView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            aUTextView.setVisibility(8);
            return;
        }
        aUTextView.setVisibility(0);
        if (charSequence instanceof String) {
            aUTextView.setAutoSplitText((String) charSequence);
        } else {
            aUTextView.setText(charSequence);
        }
    }

    @Override // com.alibaba.griver.ui.ant.dialog.AUBaseDialog
    public int initHorizonMaskSpace() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.griver_notice_size);
    }

    @Override // com.alibaba.griver.ui.ant.dialog.AUBaseDialog
    public void initCustomView(AULinearLayout aULinearLayout) {
        aULinearLayout.setOrientation(1);
        int dimensionPixelSize = this.f6678a.getResources().getDimensionPixelSize(R.dimen.griver_AU_SPACE6);
        int dimensionPixelSize2 = this.f6678a.getResources().getDimensionPixelSize(R.dimen.griver_dialog_padding_top);
        aULinearLayout.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        setCustomLayout(getContext(), R.layout.griver_ui_notice_dialog, aULinearLayout);
    }

    public void addDescriptionView() {
        int size = this.l.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.rootView.addView(this.l.get(i));
            }
        }
    }

    public void setCustomLayout(Context context, int i, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(i, viewGroup);
        this.b = (AUTextView) inflate.findViewById(R.id.title);
        this.c = (AUTextView) inflate.findViewById(R.id.message);
        this.d = (ScrollView) inflate.findViewById(R.id.message_content);
        MovementMethod movementMethod = this.m;
        if (movementMethod != null) {
            this.c.setMovementMethod(movementMethod);
        }
        this.b.setOnVisibilityChangeListener(new AUTextView.OnVisibilityChangeListener() { // from class: com.alibaba.griver.ui.ant.dialog.AUNoticeDialog.2
            @Override // com.alibaba.griver.ui.ant.text.AUTextView.OnVisibilityChangeListener
            public void onChange(int i2) {
                if (i2 == 8) {
                    AUNoticeDialog.this.c.setGravity(19);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) AUNoticeDialog.this.d.getLayoutParams();
                    layoutParams.topMargin = 0;
                    AUNoticeDialog.this.d.setLayoutParams(layoutParams);
                    return;
                }
                AUNoticeDialog.this.c.setGravity(51);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) AUNoticeDialog.this.d.getLayoutParams();
                layoutParams2.topMargin = AUNoticeDialog.this.f6678a.getResources().getDimensionPixelSize(R.dimen.griver_AU_SPACE4);
                AUNoticeDialog.this.d.setLayoutParams(layoutParams2);
            }
        });
        this.c.setOnVisibilityChangeListener(new AUTextView.OnVisibilityChangeListener() { // from class: com.alibaba.griver.ui.ant.dialog.AUNoticeDialog.3
            @Override // com.alibaba.griver.ui.ant.text.AUTextView.OnVisibilityChangeListener
            public void onChange(int i2) {
                if (i2 == 8) {
                    AUNoticeDialog.this.b.setGravity(19);
                } else {
                    AUNoticeDialog.this.b.setGravity(51);
                }
            }
        });
        a(this.b, this.e);
        a(this.c, this.f);
    }

    public TextView getTitle() {
        return this.b;
    }

    public TextView getMsg() {
        return this.c;
    }

    public void setPositiveListener(OnClickPositiveListener onClickPositiveListener) {
        this.g = onClickPositiveListener;
    }

    public void setNegativeListener(OnClickNegativeListener onClickNegativeListener) {
        this.h = onClickNegativeListener;
    }

    public CharSequence getTitleText() {
        AUTextView aUTextView = this.b;
        if (aUTextView != null) {
            return aUTextView.getText();
        }
        return this.e;
    }

    public CharSequence getMsgText() {
        AUTextView aUTextView = this.c;
        if (aUTextView != null) {
            return aUTextView.getText();
        }
        return this.f;
    }
}
