package zoloz.ap.com.toolkit.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.security.bio.utils.StressTestUtil;
import com.alipay.mobile.security.faceauth.model.DetectTimerTask;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import zoloz.ap.com.toolkit.R;
import zoloz.ap.com.toolkit.R2;

/* loaded from: classes9.dex */
public class GenenalDialog extends AlertDialog {
    private static final int COUNT_TIME_OUT = 20;
    private GenenalDialog _self;
    private String cacelButtonText;
    private String confirmButtonText;
    private Context context;
    private ImageView garfieldIcon;
    private boolean isGarfieldFaceless;
    private DialogCallback mCallback;
    private TextView mCountTv;
    private Handler mHandler;
    private DetectTimerTask mTimerTask;
    private DialogInterface.OnClickListener negativeListener;
    private DialogInterface.OnClickListener positiveListener;
    private boolean showCloseButton;
    private boolean showProtocol;
    private String subTitle;
    private Object tag;
    private String title;
    public static final byte[] $$a = {76, 9, -56, 93, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 180;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {95, 98, 60, -42, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 200;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 105
            int r7 = r7 * 4
            int r7 = r7 + 16
            byte[] r0 = zoloz.ap.com.toolkit.ui.GenenalDialog.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2a
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2a:
            int r7 = r7 + r4
            int r7 = r7 + 2
            r5 = r8
            r8 = r7
            r7 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: zoloz.ap.com.toolkit.ui.GenenalDialog.a(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = zoloz.ap.com.toolkit.ui.GenenalDialog.$$a
            int r7 = r7 * 4
            int r7 = 75 - r7
            int r8 = r8 * 4
            int r8 = 3 - r8
            int r6 = r6 * 4
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
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r8 = r8 + 1
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L36:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: zoloz.ap.com.toolkit.ui.GenenalDialog.b(int, byte, int, java.lang.Object[]):void");
    }

    public GenenalDialog(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2, boolean z, boolean z2, boolean z3) {
        super(context, R.style.dialog_style);
        this.context = context;
        this.title = str;
        this.subTitle = str2;
        this.confirmButtonText = str3;
        this.cacelButtonText = str4;
        this.showCloseButton = z;
        this.showProtocol = z2;
        this.negativeListener = onClickListener2;
        this.positiveListener = onClickListener;
        this.isGarfieldFaceless = z3;
        this._self = this;
        this.mHandler = new Handler();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        try {
            Object[] objArr = new Object[1];
            a(14, (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = BuiltInFictitiousFunctionClassFactory[5];
            byte b2 = (byte) (b + 1);
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 494, 4 - TextUtils.getOffsetBefore("", 0), (char) View.MeasureSpec.getMode(0));
                    byte b3 = (byte) ($$a[4] - 1);
                    byte b4 = b3;
                    Object[] objArr4 = new Object[1];
                    b(b3, b4, b4, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionType(0L) + 35, (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-52839694, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 19, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                initViews();
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

    private void initViews() {
        ImageButton imageButton;
        LinearLayout linearLayout;
        TextView textView;
        View view;
        setContentView(!this.isGarfieldFaceless ? LayoutInflater.from(this.context).inflate(R.layout.general_dialog, (ViewGroup) null) : null);
        TextView textView2 = (TextView) findViewById(R.id.dialog_content_title);
        textView2.setTextColor(R2.color.dialog_title());
        textView2.setText(this.title);
        TextView textView3 = (TextView) findViewById(R.id.dialog_content_sub_title);
        textView3.setTextColor(R2.color.dialog_message());
        textView3.setText(this.subTitle);
        Button button = (Button) findViewById(R.id.dialog_btn_confirm);
        button.setTextColor(R2.color.dialog_ok());
        button.setText(this.confirmButtonText);
        Button button2 = (Button) findViewById(R.id.dialog_btn_cancel);
        button2.setTextColor(R2.color.dialog_cancel());
        button2.setText(this.cacelButtonText);
        if (this.isGarfieldFaceless) {
            imageButton = null;
            linearLayout = null;
            textView = null;
            view = null;
        } else {
            imageButton = (ImageButton) findViewById(R.id.btn_x);
            linearLayout = (LinearLayout) findViewById(R.id.dialog_protocol);
            textView = (TextView) findViewById(R.id.protocol);
            view = findViewById(R.id.dialog_btn_cancel_center);
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: zoloz.ap.com.toolkit.ui.GenenalDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
        }
        if (TextUtils.isEmpty(this.confirmButtonText)) {
            button.setVisibility(8);
            hideView(view);
            hideView(null);
        } else {
            button.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.cacelButtonText)) {
            button2.setVisibility(8);
            hideView(view);
            hideView(null);
        } else {
            button2.setVisibility(0);
        }
        if (!this.showProtocol && linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        if (!this.showCloseButton) {
            hideView(imageButton);
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        double d = this.context.getResources().getDisplayMetrics().widthPixels;
        Double.isNaN(d);
        attributes.width = (int) (d * 0.9d);
        window.setAttributes(attributes);
        button.setOnClickListener(new View.OnClickListener() { // from class: zoloz.ap.com.toolkit.ui.GenenalDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                GenenalDialog.this._self.dismiss();
                if (GenenalDialog.this.positiveListener != null) {
                    GenenalDialog.this.positiveListener.onClick(GenenalDialog.this._self, -1);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: zoloz.ap.com.toolkit.ui.GenenalDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                GenenalDialog.this._self.dismiss();
                if (GenenalDialog.this.negativeListener != null) {
                    GenenalDialog.this.negativeListener.onClick(GenenalDialog.this._self, -2);
                }
            }
        });
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: zoloz.ap.com.toolkit.ui.GenenalDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    GenenalDialog.this._self.dismiss();
                    if (GenenalDialog.this.negativeListener != null) {
                        GenenalDialog.this.negativeListener.onClick(GenenalDialog.this._self, -2);
                    }
                }
            });
        }
    }

    private void hideView(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public void setCallback(DialogCallback dialogCallback) {
        this.mCallback = dialogCallback;
    }

    private void startTimerTask() {
        if (this.mTimerTask != null) {
            stopTimerTask();
        }
        if (StressTestUtil.isStressTest()) {
            this.mTimerTask = new DetectTimerTask(3000);
        } else {
            this.mTimerTask = new DetectTimerTask(20000);
        }
        this.mTimerTask.setTimerTaskListener(new DetectTimerTask.TimerListener() { // from class: zoloz.ap.com.toolkit.ui.GenenalDialog.5
            @Override // com.alipay.mobile.security.faceauth.model.DetectTimerTask.TimerListener
            public void countdown(final int i) {
                GenenalDialog.this.mHandler.post(new Runnable() { // from class: zoloz.ap.com.toolkit.ui.GenenalDialog.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GenenalDialog.this.mTimerTask == null || !GenenalDialog.this.mTimerTask.isTimeOut()) {
                            if (GenenalDialog.this.mCountTv != null) {
                                TextView textView = GenenalDialog.this.mCountTv;
                                StringBuilder sb = new StringBuilder();
                                sb.append(i / 1000);
                                sb.append("S");
                                textView.setText(sb.toString());
                            }
                        } else if (GenenalDialog.this.mCallback != null) {
                            GenenalDialog.this.mCallback.onTimeOut();
                        }
                    }
                });
            }
        });
        this.mTimerTask.start();
    }

    private void stopTimerTask() {
        DetectTimerTask detectTimerTask = this.mTimerTask;
        if (detectTimerTask != null) {
            detectTimerTask.setTimerTaskListener(null);
            this.mTimerTask.stop();
            this.mTimerTask = null;
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopTimerTask();
    }

    /* loaded from: classes9.dex */
    public static class Builder {
        private String _cacelButtonText;
        private String _confirmButtonText;
        private Context _context;
        private boolean _isGarfieldFaceless;
        DialogInterface.OnClickListener _negativeListener;
        DialogInterface.OnClickListener _positiveListener;
        private boolean _showCloseButton;
        private boolean _showProtocol;
        private String _subTitle;
        private String _title;

        public Builder(Context context) {
            this._context = context;
        }

        public Builder setTitle(String str) {
            this._title = str;
            return this;
        }

        public Builder setMessage(String str) {
            this._subTitle = str;
            return this;
        }

        public Builder setMessage2(String str) {
            this._subTitle = str;
            return this;
        }

        public Builder setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
            this._confirmButtonText = str;
            this._positiveListener = onClickListener;
            return this;
        }

        public Builder showProtocol(boolean z) {
            this._showProtocol = z;
            return this;
        }

        public Builder showCloseButton(boolean z) {
            this._showCloseButton = z;
            return this;
        }

        public Builder setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
            this._cacelButtonText = str;
            this._negativeListener = onClickListener;
            return this;
        }

        public Builder setToGarfieldFaceless(boolean z) {
            this._isGarfieldFaceless = z;
            return this;
        }

        public GenenalDialog show() {
            GenenalDialog genenalDialog = new GenenalDialog(this._context, this._title, this._subTitle, this._confirmButtonText, this._positiveListener, this._cacelButtonText, this._negativeListener, this._showCloseButton, this._showProtocol, this._isGarfieldFaceless);
            try {
                genenalDialog.show();
            } catch (Exception unused) {
            }
            return genenalDialog;
        }
    }
}
