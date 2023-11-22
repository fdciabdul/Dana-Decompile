package com.iap.ac.android.acs.plugin.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.acs.plugin.R;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.PhoneNumberFacade;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.model.MobilePhoneInfo;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.request.UserPhoneRequest;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.request.UserPhoneValidateCodeVerifyRequest;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.result.UserPhoneValidateCodeSendResult;
import com.iap.ac.android.acs.plugin.ui.utils.MultiLanguageUtils;
import com.iap.ac.android.acs.plugin.ui.utils.UIConstants;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.plugin.ui.view.ACPluginActionBar;
import com.iap.ac.android.acs.plugin.ui.view.ACPluginLoadingDialog;
import com.iap.ac.android.acs.plugin.ui.view.ACPluginToast;
import com.iap.ac.android.acs.plugin.ui.view.VerificationCodeInputView;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class VerificationCodeActivity extends Activity implements View.OnClickListener {
    public static final int COUNTDOWN_TIME = 60;
    private static short[] getErrorConfigVersion;
    public ACPluginActionBar mActionBar;
    public TextView mActionDescText;
    public CountDownTimer mCountDownTimer;
    public TextView mDescText;
    public String mFailText;
    public boolean mIsSavePhoneInfo;
    public ACPluginLoadingDialog mLoadingDialog;
    public String mLoadingText;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public String mNetworkErrorText;
    public MobilePhoneInfo mPhoneInfo;
    public TextView mPhoneNumText;
    public String mResendDesc;
    public TextView mResendDescText;
    public TextView mResendText;
    public String mSuccessText;
    public String mValidateId;
    public VerificationCodeInputView mVerificationCodeInputView;
    public static final byte[] $$a = {22, 66, -65, -82, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 124;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {45, -79, -67, -1, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int MyBillsEntityDataFactory = 135;
    private static int PlaceComponentResult = 1257195665;
    private static int getAuthRequestContext = 1340156926;
    private static byte[] scheduleImpl = {-101, 16, Ascii.RS, 18, -28, -19, TarHeader.LF_SYMLINK, TarHeader.LF_SYMLINK, -85, Ascii.DC4, 81, -38, -21, -22, -19, Ascii.RS, -26, Ascii.GS, 104, -53, 36, -20, 60, -109, 92, -93, -84, 85, 75, -124, 90, 84, -84, 82, -86, 78, 125, 76, -31, 95, 80, 108, -107, -92, -91, -94, 81, -87, 82, -101, -26, Ascii.US, -20, 10, -25, -29, -28, -27, Ascii.EM, TarHeader.LF_FIFO, -44, Ascii.US, 16, -22, Ascii.EM, -28, 11, -67, 126, 82, Byte.MIN_VALUE, 125, 83, -97, 126, 86, -87, -82, -126, 124, 86, -83, -84, -123, 85, -84, 99, -97, 125, 84, -98, Byte.MAX_VALUE, -126, 81, -82, 82, 122, 84, 81, -86, 84, -82, -100, -82, 82, -81, Byte.MAX_VALUE, -82, -82, -124, 101, -87, 83, -126, 125, -83, -81, 76, 103, -81, -97, 82, 97, -97, 97, -103, -98, 96, 98, 100, 96, -100, 102, -102, -76, 82, -84, 85, -101, 98, 99, -83, 96, 75, 100, -80, 97, 81, 96, -82, 76, -77, 76, -73, 76, 99, -99, 101, -83, 83, -85, 84, 96, -98, 99, 96, -83, 79, -100, -74, -97, 76, 104, -105, -77, 98, 78, 97, -76, -83, -73, -77, 124, -125, 78, -73, 77, -79, 124, -122, 76, 126, -79, -103, 96, -73, -78, -126, 75, -73, -80, 120, -99, -77, -79, 76, 102, -103, -75, 125, -98, 103, -97, 98, -77, -99, 76, 96, -100, -73, 97, 76, -125, 125, -125, 124, -73, -103, -76, 78, -79, -77, 74, -77, -77, -73, -79, 72, 77, 100, 78, -121, 76, -79, 0, -7, -10, 16, -18, -55, 2, 67, -72, 68, -2, -15, 1, 6, -6, -59, 57, 6, -16, -51, 61, 1, -13, -54, TarHeader.LF_FIFO, 12, -18, 19, -5, 1, -16, 13, -18, 19, -15, -58, 69, -2, -19, 1, 16, -20, 3, 12, -11, 11, -71, TarHeader.LF_SYMLINK, 12, -14, 2, -54, -1, 10, 56, -4, 3, -1, -13, 103, -91, 94, -96, 92, -81};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -1911307152;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0024 -> B:11:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = 106 - r7
            int r9 = r9 + 4
            int r8 = r8 + 16
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2d
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2d:
            int r7 = r7 + r8
            int r8 = r10 + 1
            int r7 = r7 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.a(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.$$a
            int r6 = r6 + 4
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            int r6 = r6 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.c(short, int, short, java.lang.Object[]):void");
    }

    private void fillText() {
        this.mActionBar.setTitle(getString(R.string.acplugin_verify_phone));
        this.mResendDesc = getString(R.string.acplugin_resend_desc);
        this.mLoadingText = getString(R.string.acplugin_loading);
        this.mNetworkErrorText = getString(R.string.acplugin_network_error);
        this.mSuccessText = getString(R.string.acplugin_operation_success);
        this.mFailText = getString(R.string.acplugin_verification_code_error);
        this.mPhoneNumText.setText(UIUtils.encryptPhoneNumber(this.mPhoneInfo.mobilePhoneNumber));
        MultiLanguageUtils.getMultiLanguageTextMap(new MultiLanguageUtils.Callback() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.1
            @Override // com.iap.ac.android.acs.plugin.ui.utils.MultiLanguageUtils.Callback
            public void onGetMultiLanguageText(Map<String, String> map) {
                VerificationCodeActivity.this.mActionBar.setTitle(map.get("VerifyPhone"));
                VerificationCodeActivity.this.mDescText.setText(map.get("EnterVerificationCode"));
                VerificationCodeActivity.this.mActionDescText.setText(map.get("SendVerificationCodeDesc"));
                VerificationCodeActivity.this.mResendText.setText(map.get("Resend"));
                VerificationCodeActivity.this.mResendDesc = map.get("ResendDesc");
                VerificationCodeActivity.this.mLoadingText = map.get("Loading");
                VerificationCodeActivity.this.mNetworkErrorText = map.get("NetworkError");
                VerificationCodeActivity.this.mSuccessText = map.get("OperationSuccess");
                VerificationCodeActivity.this.mFailText = map.get("VerificationCodeError");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#finishActivity");
        setResult(-1, new Intent());
        finish();
    }

    private void initData() {
        this.mIsSavePhoneInfo = getIntent().getBooleanExtra(UIConstants.KEY_SAVE_PHONE_INFO, false);
        this.mPhoneInfo = (MobilePhoneInfo) getIntent().getParcelableExtra(UIConstants.KEY_PHONE_INFO);
        StringBuilder a2 = a.a("VerificationCodeActivity#initData, is save: ");
        a2.append(this.mIsSavePhoneInfo);
        a2.append(", phone info: ");
        a2.append(this.mPhoneInfo);
        ACLog.d("IAPConnectPlugin", a2.toString());
    }

    private void initVerificationCodeInputView() {
        VerificationCodeInputView verificationCodeInputView = (VerificationCodeInputView) findViewById(R.id.verification_code_input_view);
        this.mVerificationCodeInputView = verificationCodeInputView;
        verificationCodeInputView.setOnCompleteListener(new VerificationCodeInputView.OnCompleteListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.2
            @Override // com.iap.ac.android.acs.plugin.ui.view.VerificationCodeInputView.OnCompleteListener
            public void onComplete(String str) {
                VerificationCodeActivity.this.showLoadingDialog();
                VerificationCodeActivity.this.verify(str);
            }
        });
        this.mVerificationCodeInputView.requestFocus();
    }

    private void initView() {
        this.mActionBar = (ACPluginActionBar) findViewById(R.id.action_bar);
        this.mDescText = (TextView) findViewById(R.id.desc_text);
        this.mActionDescText = (TextView) findViewById(R.id.action_desc_text);
        this.mPhoneNumText = (TextView) findViewById(R.id.phone_num_text);
        this.mResendDescText = (TextView) findViewById(R.id.resend_desc_text);
        TextView textView = (TextView) findViewById(R.id.resend_text);
        this.mResendText = textView;
        textView.setOnClickListener(this);
        fillText();
        initVerificationCodeInputView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remindToVerify() {
        ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#remindToVerify");
        this.mMainHandler.post(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.4
            @Override // java.lang.Runnable
            public void run() {
                VerificationCodeActivity.this.startCountDown();
                VerificationCodeActivity.this.mVerificationCodeInputView.showSoftInput();
            }
        });
    }

    private void sendVerificationCode() {
        StringBuilder a2 = a.a("VerificationCodeActivity#sendVerificationCode, prefix: ");
        a2.append(this.mPhoneInfo.mobilePhoneRegionCode);
        a2.append(", phone number: ");
        a2.append(UIUtils.encryptPhoneNumber(this.mPhoneInfo.mobilePhoneNumber));
        ACLog.d("IAPConnectPlugin", a2.toString());
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    PhoneNumberFacade phoneNumberFacade = (PhoneNumberFacade) RPCProxyHost.getInterfaceProxy(PhoneNumberFacade.class, "ac_biz");
                    UserPhoneRequest userPhoneRequest = new UserPhoneRequest();
                    userPhoneRequest.mobilePhoneNumber = VerificationCodeActivity.this.mPhoneInfo.mobilePhoneNumber;
                    userPhoneRequest.mobilePhoneRegionCode = VerificationCodeActivity.this.mPhoneInfo.mobilePhoneRegionCode;
                    UserPhoneValidateCodeSendResult sendUserPhoneValidateCode = phoneNumberFacade.sendUserPhoneValidateCode(userPhoneRequest);
                    MonitorUtil.monitorRPC(PhoneNumberFacade.OPERATION_TYPE_SEND_VALIDATE_CODE, SystemClock.elapsedRealtime() - elapsedRealtime, sendUserPhoneValidateCode);
                    if (sendUserPhoneValidateCode == null) {
                        ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#sendVerificationCode, rpc result is null");
                        VerificationCodeActivity.this.showNetworkError();
                    } else if (!sendUserPhoneValidateCode.success) {
                        StringBuilder a3 = a.a("VerificationCodeActivity#sendVerificationCode, rpc result fail, error: ");
                        a3.append(sendUserPhoneValidateCode.errorCode);
                        a3.append(", errorMessage: ");
                        a3.append(sendUserPhoneValidateCode.errorMessage);
                        ACLog.e("IAPConnectPlugin", a3.toString());
                        VerificationCodeActivity.this.showNetworkError();
                    } else {
                        VerificationCodeActivity.this.mValidateId = sendUserPhoneValidateCode.validateId;
                        StringBuilder sb = new StringBuilder();
                        sb.append("VerificationCodeActivity#sendVerificationCode success, validateId: ");
                        sb.append(VerificationCodeActivity.this.mValidateId);
                        ACLog.d("IAPConnectPlugin", sb.toString());
                        VerificationCodeActivity.this.remindToVerify();
                    }
                } catch (Throwable th) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VerificationCodeActivity#sendVerificationCode, rpc error: ");
                    sb2.append(th);
                    ACLog.e("IAPConnectPlugin", sb2.toString());
                    VerificationCodeActivity.this.showNetworkError();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFail() {
        this.mMainHandler.post(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (UIUtils.isActivityDisabled(VerificationCodeActivity.this)) {
                    ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#showFail, activity disabled");
                    return;
                }
                ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#showFail");
                if (VerificationCodeActivity.this.mLoadingDialog != null) {
                    VerificationCodeActivity.this.mLoadingDialog.dismiss();
                }
                VerificationCodeActivity verificationCodeActivity = VerificationCodeActivity.this;
                ACPluginToast.makeToast(verificationCodeActivity, 2, verificationCodeActivity.mFailText, 0, new ACPluginToast.OnToastDismissListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.9.1
                    @Override // com.iap.ac.android.acs.plugin.ui.view.ACPluginToast.OnToastDismissListener
                    public void onDismiss() {
                        if (UIUtils.isActivityDisabled(VerificationCodeActivity.this)) {
                            ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#showFail, activity disabled");
                            return;
                        }
                        ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#on fail toast dismiss, clear view");
                        VerificationCodeActivity.this.mVerificationCodeInputView.clear();
                        VerificationCodeActivity.this.mVerificationCodeInputView.showSoftInput();
                    }
                }).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog() {
        if (UIUtils.isActivityDisabled(this)) {
            ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#showLoadingDialog, activity disabled");
            return;
        }
        if (this.mLoadingDialog == null) {
            ACPluginLoadingDialog aCPluginLoadingDialog = new ACPluginLoadingDialog(this);
            this.mLoadingDialog = aCPluginLoadingDialog;
            aCPluginLoadingDialog.setText(this.mLoadingText);
        }
        this.mLoadingDialog.show();
        ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#showLoadingDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetworkError() {
        this.mMainHandler.post(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (UIUtils.isActivityDisabled(VerificationCodeActivity.this)) {
                    ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#showNetworkError, activity disabled");
                    return;
                }
                ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#showNetworkError");
                VerificationCodeActivity verificationCodeActivity = VerificationCodeActivity.this;
                ACPluginToast.makeToast(verificationCodeActivity, 2, verificationCodeActivity.mNetworkErrorText, 0).show();
                VerificationCodeActivity.this.mResendDescText.setVisibility(8);
                VerificationCodeActivity.this.mResendText.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSuccess() {
        this.mMainHandler.post(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.8
            @Override // java.lang.Runnable
            public void run() {
                if (UIUtils.isActivityDisabled(VerificationCodeActivity.this)) {
                    ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#showSuccess, activity disabled");
                    return;
                }
                ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#showSuccess");
                if (VerificationCodeActivity.this.mLoadingDialog != null) {
                    VerificationCodeActivity.this.mLoadingDialog.dismiss();
                }
                VerificationCodeActivity verificationCodeActivity = VerificationCodeActivity.this;
                ACPluginToast.makeToast(verificationCodeActivity, 1, verificationCodeActivity.mSuccessText, 0, new ACPluginToast.OnToastDismissListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.8.1
                    @Override // com.iap.ac.android.acs.plugin.ui.view.ACPluginToast.OnToastDismissListener
                    public void onDismiss() {
                        if (UIUtils.isActivityDisabled(VerificationCodeActivity.this)) {
                            ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#showSuccess, activity disabled");
                            return;
                        }
                        ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#on success toast dismiss, finish activity");
                        VerificationCodeActivity.this.finishActivity();
                    }
                }).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCountDown() {
        ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#startCountDown");
        this.mResendDescText.setVisibility(0);
        this.mResendText.setVisibility(8);
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(60150L, 1000L) { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.5
            @Override // android.os.CountDownTimer
            public void onFinish() {
                VerificationCodeActivity.this.mResendDescText.setVisibility(8);
                VerificationCodeActivity.this.mResendText.setVisibility(0);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                double d = j;
                Double.isNaN(d);
                VerificationCodeActivity.this.mResendDescText.setText(String.format(VerificationCodeActivity.this.mResendDesc, Long.valueOf(Math.round(d / 1000.0d))));
            }
        };
        this.mCountDownTimer = countDownTimer2;
        countDownTimer2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verify(final String str) {
        StringBuilder a2 = a.a("VerificationCodeActivity#verify, is save: ");
        a2.append(this.mIsSavePhoneInfo);
        a2.append(", validateId: ");
        a2.append(this.mValidateId);
        a2.append(", code: ");
        a2.append(str);
        a2.append(", prefix: ");
        a2.append(this.mPhoneInfo.mobilePhoneRegionCode);
        a2.append(", phone number: ");
        a2.append(UIUtils.encryptPhoneNumber(this.mPhoneInfo.mobilePhoneNumber));
        ACLog.d("IAPConnectPlugin", a2.toString());
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    PhoneNumberFacade phoneNumberFacade = (PhoneNumberFacade) RPCProxyHost.getInterfaceProxy(PhoneNumberFacade.class, "ac_biz");
                    UserPhoneValidateCodeVerifyRequest userPhoneValidateCodeVerifyRequest = new UserPhoneValidateCodeVerifyRequest();
                    userPhoneValidateCodeVerifyRequest.validateId = VerificationCodeActivity.this.mValidateId;
                    userPhoneValidateCodeVerifyRequest.validateCode = str;
                    userPhoneValidateCodeVerifyRequest.mobilePhoneNumber = VerificationCodeActivity.this.mPhoneInfo.mobilePhoneNumber;
                    userPhoneValidateCodeVerifyRequest.mobilePhoneRegionCode = VerificationCodeActivity.this.mPhoneInfo.mobilePhoneRegionCode;
                    userPhoneValidateCodeVerifyRequest.saveMobilePhoneNumber = VerificationCodeActivity.this.mIsSavePhoneInfo;
                    BaseRpcResult verifyUserPhoneValidateCode = phoneNumberFacade.verifyUserPhoneValidateCode(userPhoneValidateCodeVerifyRequest);
                    MonitorUtil.monitorRPC(PhoneNumberFacade.OPERATION_TYPE_VERIFY_VALIDATE_CODE, SystemClock.elapsedRealtime() - elapsedRealtime, verifyUserPhoneValidateCode);
                    if (verifyUserPhoneValidateCode == null) {
                        ACLog.e("IAPConnectPlugin", "VerificationCodeActivity#verify, rpc result is null");
                        VerificationCodeActivity.this.showFail();
                    } else if (!verifyUserPhoneValidateCode.success) {
                        StringBuilder a3 = a.a("VerificationCodeActivity#verify, rpc result fail, error: ");
                        a3.append(verifyUserPhoneValidateCode.errorCode);
                        a3.append(", errorMessage: ");
                        a3.append(verifyUserPhoneValidateCode.errorMessage);
                        ACLog.e("IAPConnectPlugin", a3.toString());
                        VerificationCodeActivity.this.showFail();
                    } else {
                        ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#verify, rpc result success");
                        VerificationCodeActivity.this.showSuccess();
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("VerificationCodeActivity#verify, rpc error: ");
                    sb.append(th);
                    ACLog.e("IAPConnectPlugin", sb.toString());
                    VerificationCodeActivity.this.showFail();
                }
            }
        });
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(TextUtils.indexOf((CharSequence) "", '0') - 84828927, (-14) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) - 112), (short) TextUtils.indexOf("", ""), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 990081809, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 84828917, (ViewConfiguration.getPressedStateDuration() >> 16) - 15, (byte) ((-81) - TextUtils.indexOf("", "", 0)), (short) (ViewConfiguration.getFadingEdgeLength() >> 16), Process.getGidForName("") + 990081828, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.getDefaultSize(0, 0), TextUtils.indexOf("", "", 0, 0) + 35, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((-84828970) - (ViewConfiguration.getWindowTouchSlop() >> 8), (-15) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (byte) ((ViewConfiguration.getScrollDefaultDelay() >> 16) - 50), (short) View.MeasureSpec.getSize(0), ExpandableListView.getPackedPositionType(0L) + 990081876, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((-84828928) - (ViewConfiguration.getKeyRepeatDelay() >> 16), KeyEvent.getDeadChar(0, 0) - 15, (byte) ((-1) - View.combineMeasuredStates(0, 0)), (short) ((-1) - ExpandableListView.getPackedPositionChild(0L)), 990081924 - KeyEvent.getDeadChar(0, 0), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((-84828974) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (-16) - Process.getGidForName(""), (byte) (44 - View.resolveSizeAndState(0, 0, 0)), (short) (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 990081988, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((-84828921) - TextUtils.indexOf("", "", 0, 0), (-15) - View.getDefaultSize(0, 0), (byte) (View.MeasureSpec.makeMeasureSpec(0, 0) + 96), (short) (ViewConfiguration.getTapTimeout() >> 16), 990082052 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(((byte) KeyEvent.getModifierMetaStateMask()) - 84828967, (ViewConfiguration.getEdgeSlop() >> 16) - 15, (byte) ((-60) - TextUtils.indexOf((CharSequence) "", '0')), (short) ((-1) - ImageFormat.getBitsPerPixel(0)), 990082112 - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = {this};
                byte b = BuiltInFictitiousFunctionClassFactory[25];
                byte b2 = b;
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 | 37), objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[35], objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(54 - ImageFormat.getBitsPerPixel(0), 2 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ExpandableListView.getPackedPositionType(0L));
                        Object[] objArr17 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[68], $$a[47], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 15 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.argb(0, 0, 0, 0), AndroidCharacter.getMirror('0') - '!', (char) KeyEvent.getDeadChar(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getOffsetBefore("", 0), 29 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (57994 - (Process.myTid() >> 22)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 800, 15 - (ViewConfiguration.getScrollBarSize() >> 8), (char) KeyEvent.keyCodeFromString("")));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 35 - KeyEvent.getDeadChar(0, 0), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1568589332, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), 18 - View.MeasureSpec.getSize(0), (char) KeyEvent.keyCodeFromString(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr20 = {this};
                byte b3 = BuiltInFictitiousFunctionClassFactory[25];
                byte b4 = b3;
                Object[] objArr21 = new Object[1];
                a(b3, b4, (byte) (b4 | 37), objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[35], objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - TextUtils.indexOf((CharSequence) "", '0', 0), 46 - TextUtils.getOffsetBefore("", 0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr24 = new Object[1];
                        c((byte) ($$a[0] + 1), (byte) (-$$a[8]), (byte) (-$$a[9]), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r5 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, MotionEvent.axisFromString("") + 36, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1568589332, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 17 - TextUtils.lastIndexOf("", '0', 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr27 = {this};
                byte b5 = BuiltInFictitiousFunctionClassFactory[25];
                byte b6 = b5;
                Object[] objArr28 = new Object[1];
                a(b5, b6, (byte) (b6 | 37), objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[35], objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 3, (char) (View.combineMeasuredStates(0, 0) + 38968));
                        Object[] objArr31 = new Object[1];
                        c((byte) ($$a[0] + 1), (byte) (-$$a[8]), (byte) (-$$a[9]), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r5 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, View.getDefaultSize(0, 0) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1568589332, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr34 = {this};
                byte b7 = BuiltInFictitiousFunctionClassFactory[25];
                byte b8 = b7;
                Object[] objArr35 = new Object[1];
                a(b7, b8, (byte) (b8 | 37), objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[7], BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[35], objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 107, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 3, (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        byte b9 = (byte) (-$$a[53]);
                        byte b10 = (byte) ($$a[47] - 1);
                        Object[] objArr38 = new Object[1];
                        c(b9, b10, b10, objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r5 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1568589332, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.resend_text) {
            ACLog.d("IAPConnectPlugin", "VerificationCodeActivity#onClick, click resend text");
            sendVerificationCode();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x065d A[Catch: all -> 0x07b1, TryCatch #1 {all -> 0x07b1, blocks: (B:74:0x0645, B:78:0x06a9, B:77:0x065d), top: B:125:0x0645 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x06c0  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r33) {
        /*
            Method dump skipped, instructions count: 1998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.VerificationCodeActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[13], BuiltInFictitiousFunctionClassFactory[56], (byte) (BuiltInFictitiousFunctionClassFactory[59] + 1), objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 84828961;
                try {
                    Object[] objArr3 = new Object[1];
                    a(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[25], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a(BuiltInFictitiousFunctionClassFactory[13], BuiltInFictitiousFunctionClassFactory[56], (byte) (BuiltInFictitiousFunctionClassFactory[59] + 1), new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(i, ((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 48, (byte) (getPackageName().length() - 71), (short) TextUtils.indexOf("", "", 0, 0), super.getResources().getString(id.dana.R.string.min_send_amount_error_message).substring(12, 13).length() + 990081831, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b(super.getResources().getString(id.dana.R.string.tix_button_title).substring(0, 1).length() - 84828927, super.getResources().getString(id.dana.R.string.bottom_help_family_account_dashboard_third_body_text).substring(23, 24).length() - 16, (byte) ((-122) - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), (short) Drawable.resolveOpacity(0, 0), super.getResources().getString(id.dana.R.string.detail_referral).substring(0, 7).length() + 990081851, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
            int codePointAt = super.getResources().getString(id.dana.R.string.sendmoney_save_continue).substring(0, 1).codePointAt(0) - 84829011;
            int indexOf = TextUtils.indexOf((CharSequence) "", '0', 0) - 14;
            byte codePointAt2 = (byte) (getPackageName().codePointAt(2) - 110);
            try {
                Object[] objArr = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[32], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(BuiltInFictitiousFunctionClassFactory[13], BuiltInFictitiousFunctionClassFactory[56], (byte) (BuiltInFictitiousFunctionClassFactory[59] + 1), new Object[1]);
                Object[] objArr2 = new Object[1];
                b(codePointAt, indexOf, codePointAt2, (short) (((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(id.dana.R.string.ep_general_error_header).substring(24, 26).codePointAt(0) + 990081717, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(TextUtils.getCapsMode("", 0, 0) - 84828926, super.getResources().getString(id.dana.R.string.family_account_text_organizer_summary_error_cashier_native_disabled).substring(41, 42).length() - 16, (byte) (getPackageName().codePointAt(2) - 168), (short) (getPackageName().length() - 7), getPackageName().length() + 990081851, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, Color.argb(0, 0, 0, 0) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) Drawable.resolveOpacity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        }
        super.onResume();
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (PlaceComponentResult ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = scheduleImpl;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (scheduleImpl[i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (getErrorConfigVersion[i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (getAuthRequestContext ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = scheduleImpl;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = scheduleImpl;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = getErrorConfigVersion;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
