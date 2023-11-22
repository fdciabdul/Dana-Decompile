package zoloz.ap.com.toolkit.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import zoloz.ap.com.toolkit.R;
import zoloz.ap.com.toolkit.ui.GenenalDialog;

/* loaded from: classes9.dex */
public class DialogHelper {
    protected static final String TAG = "DialogHelper";
    private Activity mActivity;
    private AlertDialog mAlertDialog;

    public DialogHelper(Activity activity) {
        this.mActivity = activity;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        alert(str, str2, str3, onClickListener, str4, onClickListener2, Boolean.FALSE);
    }

    public void alert(String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, Boolean bool) {
        Boolean bool2 = Boolean.FALSE;
        alert(str, str2, str3, onClickListener, str4, onClickListener2, bool2, bool2);
    }

    public void alert(final String str, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2, Boolean bool, Boolean bool2) {
        dismissDialog();
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.mActivity.runOnUiThread(new Runnable() { // from class: zoloz.ap.com.toolkit.ui.DialogHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DialogHelper.this.mActivity == null || DialogHelper.this.mActivity.isFinishing()) {
                        return;
                    }
                    GenenalDialog.Builder builder = new GenenalDialog.Builder(DialogHelper.this.mActivity);
                    String str5 = str;
                    if (str5 != null) {
                        builder.setTitle(str5);
                    }
                    String str6 = str2;
                    if (str6 != null) {
                        builder.setMessage(str6);
                    }
                    String str7 = str3;
                    if (str7 != null) {
                        builder.setPositiveButton(str7, onClickListener);
                    }
                    String str8 = str4;
                    if (str8 != null) {
                        builder.setNegativeButton(str8, onClickListener2);
                    }
                    builder.setToGarfieldFaceless(false);
                    builder.showCloseButton(false);
                    builder.showProtocol(false);
                    GenenalDialog show = builder.show();
                    DialogHelper.this.mAlertDialog = show;
                    show.setCancelable(false);
                    show.setCanceledOnTouchOutside(false);
                    show.getWindow().setGravity(17);
                }
            });
        }
    }

    public void showProgressDialog(final String str, final boolean z, final DialogInterface.OnCancelListener onCancelListener, final boolean z2) {
        dismissDialog();
        this.mActivity.runOnUiThread(new Runnable() { // from class: zoloz.ap.com.toolkit.ui.DialogHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (DialogHelper.this.mActivity == null || DialogHelper.this.mActivity.isFinishing()) {
                    return;
                }
                DialogHelper dialogHelper = DialogHelper.this;
                dialogHelper.mAlertDialog = new ZolozProgressDialog(dialogHelper.mActivity);
                DialogHelper.this.mAlertDialog.setMessage(str);
                ((ZolozProgressDialog) DialogHelper.this.mAlertDialog).setProgressVisiable(z2);
                DialogHelper.this.mAlertDialog.setCancelable(z);
                DialogHelper.this.mAlertDialog.setOnCancelListener(onCancelListener);
                DialogHelper.this.mAlertDialog.setCanceledOnTouchOutside(false);
                DialogHelper.this.mAlertDialog.getWindow().setGravity(17);
                DialogHelper.this.mAlertDialog.show();
            }
        });
    }

    public void dismissDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: zoloz.ap.com.toolkit.ui.DialogHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (DialogHelper.this.mAlertDialog == null || !DialogHelper.this.mAlertDialog.isShowing() || DialogHelper.this.mActivity.isFinishing()) {
                    return;
                }
                try {
                    DialogHelper.this.mAlertDialog.dismiss();
                } catch (Throwable unused) {
                }
                DialogHelper.this.mAlertDialog = null;
            }
        });
    }

    public void forceDismissDialog() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: zoloz.ap.com.toolkit.ui.DialogHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (DialogHelper.this.mAlertDialog == null || !DialogHelper.this.mAlertDialog.isShowing()) {
                    return;
                }
                try {
                    DialogHelper.this.mAlertDialog.dismiss();
                } catch (Throwable unused) {
                }
                DialogHelper.this.mAlertDialog = null;
            }
        });
    }

    public void showSuccessDialog(final boolean z, final DialogInterface.OnCancelListener onCancelListener) {
        dismissDialog();
        this.mActivity.runOnUiThread(new Runnable() { // from class: zoloz.ap.com.toolkit.ui.DialogHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (DialogHelper.this.mActivity == null || DialogHelper.this.mActivity.isFinishing()) {
                    return;
                }
                DialogHelper dialogHelper = DialogHelper.this;
                dialogHelper.mAlertDialog = new ZolozSuccessDialog(dialogHelper.mActivity);
                DialogHelper.this.mAlertDialog.setCancelable(z);
                DialogHelper.this.mAlertDialog.setOnCancelListener(onCancelListener);
                DialogHelper.this.mAlertDialog.setCanceledOnTouchOutside(false);
                DialogHelper.this.mAlertDialog.getWindow().setGravity(17);
                DialogHelper.this.mAlertDialog.show();
            }
        });
    }

    public void release() {
        this.mActivity = null;
        this.mAlertDialog = null;
    }

    public boolean isShowing() {
        AlertDialog alertDialog = this.mAlertDialog;
        return alertDialog != null && alertDialog.isShowing();
    }

    /* loaded from: classes9.dex */
    public class ZolozProgressDialog extends AlertDialog {
        private boolean mIndeterminate;
        private CharSequence mMessage;
        private TextView mMessageView;
        private ProgressBar mProgress;
        private boolean mProgressVisiable;
        public static final byte[] $$a = {14, -73, -90, 103, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
        public static final int $$b = 170;
        public static final byte[] getAuthRequestContext = {71, Ascii.US, 113, 39, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int BuiltInFictitiousFunctionClassFactory = 140;

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 * 4
                int r8 = r8 + 16
                int r6 = r6 + 4
                int r7 = r7 + 105
                byte[] r0 = zoloz.ap.com.toolkit.ui.DialogHelper.ZolozProgressDialog.getAuthRequestContext
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
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
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                int r6 = r6 + 1
                if (r3 != r8) goto L2b
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2b:
                r3 = r0[r6]
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
                int r8 = r8 + r6
                int r6 = r8 + 2
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r7
                r7 = r6
                r6 = r5
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: zoloz.ap.com.toolkit.ui.DialogHelper.ZolozProgressDialog.a(short, byte, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void b(short r7, short r8, short r9, java.lang.Object[] r10) {
            /*
                int r8 = r8 * 3
                int r8 = r8 + 42
                byte[] r0 = zoloz.ap.com.toolkit.ui.DialogHelper.ZolozProgressDialog.$$a
                int r7 = r7 * 3
                int r7 = 4 - r7
                int r9 = r9 * 2
                int r9 = 75 - r9
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L33
            L1a:
                r3 = 0
            L1b:
                int r4 = r3 + 1
                byte r5 = (byte) r9
                r1[r3] = r5
                if (r4 != r8) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r3 = r0[r7]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L33:
                int r10 = r10 + r8
                int r7 = r7 + 1
                int r8 = r10 + (-7)
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r9
                r9 = r8
                r8 = r6
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: zoloz.ap.com.toolkit.ui.DialogHelper.ZolozProgressDialog.b(short, short, short, java.lang.Object[]):void");
        }

        public ZolozProgressDialog(Context context) {
            super(context, R.style.process_style);
        }

        public ZolozProgressDialog(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            try {
                byte b = (byte) (getAuthRequestContext[8] + 1);
                byte b2 = getAuthRequestContext[5];
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-getAuthRequestContext[5]);
                byte b4 = (byte) (b3 + 1);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                try {
                    Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj == null) {
                        Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getScrollDefaultDelay() >> 16), Drawable.resolveOpacity(0, 0) + 4, (char) (ViewConfiguration.getEdgeSlop() >> 16));
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
                        long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTapTimeout() >> 16), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                            }
                            Object invoke = ((Method) obj2).invoke(null, null);
                            try {
                                Object[] objArr6 = {-2124636191, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 911, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    setContentView(R.layout.layout_progress_dialog);
                    this.mProgress = (ProgressBar) findViewById(16908301);
                    this.mMessageView = (TextView) findViewById(R.id.message);
                    setMessageAndView();
                    setIndeterminate(this.mIndeterminate);
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

        private void setMessageAndView() {
            this.mMessageView.setText(this.mMessage);
            CharSequence charSequence = this.mMessage;
            if (charSequence == null || "".equals(charSequence)) {
                this.mMessageView.setVisibility(8);
            }
            this.mProgress.setVisibility(this.mProgressVisiable ? 0 : 8);
        }

        @Override // android.app.AlertDialog
        public void setMessage(CharSequence charSequence) {
            this.mMessage = charSequence;
        }

        public void setProgressVisiable(boolean z) {
            this.mProgressVisiable = z;
        }

        public void setIndeterminate(boolean z) {
            ProgressBar progressBar = this.mProgress;
            if (progressBar != null) {
                progressBar.setIndeterminate(z);
            } else {
                this.mIndeterminate = z;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class ZolozSuccessDialog extends AlertDialog {
        public static final byte[] $$a = {3, -83, -69, 19, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
        public static final int $$b = 10;
        public static final byte[] MyBillsEntityDataFactory = {TarHeader.LF_LINK, 16, -25, 45, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int getAuthRequestContext = 200;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r6, byte r7, short r8, java.lang.Object[] r9) {
            /*
                int r7 = r7 * 2
                int r7 = r7 + 16
                int r6 = 106 - r6
                byte[] r0 = zoloz.ap.com.toolkit.ui.DialogHelper.ZolozSuccessDialog.MyBillsEntityDataFactory
                int r8 = r8 * 15
                int r8 = 19 - r8
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
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
                if (r3 != r7) goto L27
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L27:
                int r3 = r3 + 1
                r4 = r0[r8]
                r5 = r8
                r8 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r5
            L33:
                int r8 = r8 + r6
                int r6 = r8 + 2
                int r8 = r9 + 1
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: zoloz.ap.com.toolkit.ui.DialogHelper.ZolozSuccessDialog.a(byte, byte, short, java.lang.Object[]):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0037). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void b(short r6, short r7, byte r8, java.lang.Object[] r9) {
            /*
                int r8 = r8 + 4
                byte[] r0 = zoloz.ap.com.toolkit.ui.DialogHelper.ZolozSuccessDialog.$$a
                int r7 = r7 * 3
                int r7 = r7 + 42
                int r6 = r6 * 3
                int r6 = 75 - r6
                byte[] r1 = new byte[r7]
                int r7 = r7 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                goto L37
            L1a:
                r3 = 0
            L1b:
                int r8 = r8 + 1
                byte r4 = (byte) r6
                r1[r3] = r4
                if (r3 != r7) goto L2a
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2a:
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
            L37:
                int r6 = -r6
                int r7 = r7 + r6
                int r6 = r7 + (-7)
                r7 = r8
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: zoloz.ap.com.toolkit.ui.DialogHelper.ZolozSuccessDialog.b(short, short, byte, java.lang.Object[]):void");
        }

        public ZolozSuccessDialog(Context context) {
            super(context);
        }

        @Override // android.app.AlertDialog, android.app.Dialog
        protected void onCreate(Bundle bundle) {
            try {
                byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
                Object[] objArr2 = new Object[1];
                a(b3, (byte) (b3 - 1), (byte) (-MyBillsEntityDataFactory[5]), objArr2);
                try {
                    Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj == null) {
                        Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.lastIndexOf("", '0', 0, 0), 4 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) ExpandableListView.getPackedPositionType(0L));
                        byte b4 = (byte) ($$a[4] - 1);
                        Object[] objArr4 = new Object[1];
                        b(b4, b4, $$a[35], objArr4);
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
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                            }
                            Object invoke = ((Method) obj2).invoke(null, null);
                            try {
                                Object[] objArr6 = {-1867894711, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj3 == null) {
                                    obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - TextUtils.getCapsMode("", 0, 0), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    setContentView(R.layout.layout_upload_success);
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
    }
}
