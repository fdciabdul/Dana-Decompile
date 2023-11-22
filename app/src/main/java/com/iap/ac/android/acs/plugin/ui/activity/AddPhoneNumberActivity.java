package com.iap.ac.android.acs.plugin.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.acs.plugin.R;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.model.MobilePhoneInfo;
import com.iap.ac.android.acs.plugin.ui.utils.MultiLanguageUtils;
import com.iap.ac.android.acs.plugin.ui.utils.UIConstants;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.plugin.ui.view.ACPluginActionBar;
import com.iap.ac.android.acs.plugin.ui.view.ACPluginDialog;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.common.log.ACLog;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class AddPhoneNumberActivity extends Activity implements View.OnClickListener {
    public ACPluginActionBar mActionBar;
    public String mCancelText;
    public String mConfirmDialogDesc;
    public String mConfirmText;
    public String mDefaultRegionFormat;
    public Button mNextStepButton;
    public TextView mOTPDescText;
    public MobilePhoneInfo mPhoneInfo = new MobilePhoneInfo();
    public ArrayList<MobilePhoneInfo> mPhoneInfoList;
    public EditText mPhoneNumEditText;
    public TextView mRegionText;
    public CheckBox mSavePhoneNumCheck;
    public static final byte[] $$a = {75, -23, 102, -23, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 232;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {3, -83, -69, 19, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int MyBillsEntityDataFactory = 40;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = -7022287297577034210L;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.AddPhoneNumberActivity.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 + 16
            int r6 = r6 + 4
            int r8 = r8 + 97
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L30
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L30:
            int r6 = r6 + 1
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.AddPhoneNumberActivity.b(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r6 = r6 + 4
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.AddPhoneNumberActivity.$$a
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L34:
            int r9 = r9 + r6
            int r6 = r7 + 1
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.AddPhoneNumberActivity.c(short, short, int, java.lang.Object[]):void");
    }

    private void fillText() {
        this.mActionBar.setTitle(getString(R.string.acplugin_set_phone));
        this.mConfirmDialogDesc = getString(R.string.acplugin_phone_exist_desc);
        this.mCancelText = getString(R.string.acplugin_cancel);
        this.mConfirmText = getString(R.string.acplugin_confirm);
        this.mDefaultRegionFormat = getString(R.string.acplugin_default_region_format);
        MultiLanguageUtils.getMultiLanguageTextMap(new MultiLanguageUtils.Callback() { // from class: com.iap.ac.android.acs.plugin.ui.activity.AddPhoneNumberActivity.1
            {
                AddPhoneNumberActivity.this = this;
            }

            @Override // com.iap.ac.android.acs.plugin.ui.utils.MultiLanguageUtils.Callback
            public void onGetMultiLanguageText(Map<String, String> map) {
                AddPhoneNumberActivity.this.mActionBar.setTitle(map.get("SetPhone"));
                AddPhoneNumberActivity.this.mPhoneNumEditText.setHint(map.get("EnterPhone"));
                AddPhoneNumberActivity.this.mOTPDescText.setText(map.get("VerificationCodeDesc"));
                AddPhoneNumberActivity.this.mSavePhoneNumCheck.setText(map.get("SavePhone"));
                AddPhoneNumberActivity.this.mNextStepButton.setText(map.get("Next"));
                AddPhoneNumberActivity.this.mConfirmDialogDesc = map.get("PhoneExistDesc");
                AddPhoneNumberActivity.this.mCancelText = map.get(MyBillsPurposeAction.CANCEL);
                AddPhoneNumberActivity.this.mConfirmText = map.get("Confirm");
                if (!TextUtils.isEmpty(map.get("DefaultRegionFormat"))) {
                    AddPhoneNumberActivity.this.mDefaultRegionFormat = map.get("DefaultRegionFormat");
                }
                if (TextUtils.isEmpty(AddPhoneNumberActivity.this.mPhoneInfo.region) || TextUtils.isEmpty(AddPhoneNumberActivity.this.mPhoneInfo.mobilePhoneRegionCode) || TextUtils.isEmpty(map.get(AddPhoneNumberActivity.this.mPhoneInfo.region))) {
                    AddPhoneNumberActivity.this.mRegionText.setText(map.get("ChooseRegion"));
                } else {
                    AddPhoneNumberActivity.this.mRegionText.setText(String.format(AddPhoneNumberActivity.this.mDefaultRegionFormat, map.get(AddPhoneNumberActivity.this.mPhoneInfo.region), AddPhoneNumberActivity.this.mPhoneInfo.mobilePhoneRegionCode));
                }
            }
        });
    }

    public void finishActivity() {
        StringBuilder a2 = a.a("AddPhoneNumberActivity#finishActivity, phone info: ");
        a2.append(this.mPhoneInfo);
        ACLog.d("IAPConnectPlugin", a2.toString());
        Intent intent = new Intent();
        intent.putExtra(UIConstants.KEY_PHONE_INFO, this.mPhoneInfo);
        setResult(-1, intent);
        finish();
    }

    private void initData() {
        CommonConfig commonConfig = ACManager.getInstance().getCommonConfig();
        if (commonConfig != null) {
            MobilePhoneInfo mobilePhoneInfo = this.mPhoneInfo;
            mobilePhoneInfo.region = commonConfig.defaultRegion;
            mobilePhoneInfo.mobilePhoneRegionCode = commonConfig.defaultMobilePhoneRegionCode;
            StringBuilder a2 = a.a("AddPhoneNumberActivity#initData, region: ");
            a2.append(this.mPhoneInfo.region);
            a2.append(", code: ");
            a2.append(this.mPhoneInfo.mobilePhoneRegionCode);
            ACLog.d("IAPConnectPlugin", a2.toString());
        }
        this.mPhoneInfoList = getIntent().getParcelableArrayListExtra(UIConstants.KEY_PHONE_INFO_LIST);
        StringBuilder a3 = a.a("AddPhoneNumberActivity#initData, phone info list: ");
        a3.append(this.mPhoneInfoList);
        ACLog.d("IAPConnectPlugin", a3.toString());
    }

    private void initPhoneNumEditText() {
        this.mPhoneNumEditText.addTextChangedListener(new TextWatcher() { // from class: com.iap.ac.android.acs.plugin.ui.activity.AddPhoneNumberActivity.2
            {
                AddPhoneNumberActivity.this = this;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence != null) {
                    AddPhoneNumberActivity.this.mNextStepButton.setEnabled(charSequence.length() >= 7);
                }
            }
        });
        this.mPhoneNumEditText.requestFocus();
        UIUtils.showSoftInput(this, this.mPhoneNumEditText);
    }

    private void initSavePhoneNumCheck() {
        Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.acplugin_checkbox);
        int dp2px = UIUtils.dp2px(this, 19);
        Resources_getDrawable.setBounds(0, 0, dp2px, dp2px);
        this.mSavePhoneNumCheck.setCompoundDrawables(Resources_getDrawable, null, null, null);
    }

    private void initView() {
        this.mActionBar = (ACPluginActionBar) findViewById(R.id.action_bar);
        findViewById(R.id.region_layout).setOnClickListener(this);
        this.mRegionText = (TextView) findViewById(R.id.region_text);
        this.mPhoneNumEditText = (EditText) findViewById(R.id.phone_num_edit_text);
        this.mOTPDescText = (TextView) findViewById(R.id.otp_desc_text);
        this.mSavePhoneNumCheck = (CheckBox) findViewById(R.id.save_phone_num_check);
        Button button = (Button) findViewById(R.id.next_step_button);
        this.mNextStepButton = button;
        button.setOnClickListener(this);
        fillText();
        initSavePhoneNumCheck();
        initPhoneNumEditText();
    }

    private boolean isPhoneNumberExist() {
        ArrayList<MobilePhoneInfo> arrayList = this.mPhoneInfoList;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<MobilePhoneInfo> it = this.mPhoneInfoList.iterator();
        while (it.hasNext()) {
            MobilePhoneInfo next = it.next();
            if (TextUtils.equals(this.mPhoneInfo.mobilePhoneNumber, next.mobilePhoneNumber) && TextUtils.equals(this.mPhoneInfo.mobilePhoneRegionCode, next.mobilePhoneRegionCode)) {
                return true;
            }
        }
        return false;
    }

    private void showPhoneNumberExistDialog() {
        if (UIUtils.isActivityDisabled(this)) {
            ACLog.e("IAPConnectPlugin", "AddPhoneNumberActivity#showPhoneNumberExistDialog, activity disabled");
            return;
        }
        ACPluginDialog aCPluginDialog = new ACPluginDialog(this, this.mConfirmDialogDesc, this.mCancelText, this.mConfirmText);
        aCPluginDialog.setConfirmListener(new ACPluginDialog.OnConfirmListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.AddPhoneNumberActivity.3
            {
                AddPhoneNumberActivity.this = this;
            }

            @Override // com.iap.ac.android.acs.plugin.ui.view.ACPluginDialog.OnConfirmListener
            public void onConfirm() {
                ACLog.d("IAPConnectPlugin", "AddPhoneNumberActivity#onConfirm, confirm to use old phone number");
                AddPhoneNumberActivity.this.finishActivity();
            }
        });
        aCPluginDialog.show();
    }

    private void startPhoneRegionActivity() {
        ACLog.d("IAPConnectPlugin", "AddPhoneNumberActivity#startPhoneRegionActivity");
        startActivityForResult(new Intent(this, PhoneRegionActivity.class), 122);
    }

    private void startVerificationCodeActivity() {
        StringBuilder a2 = a.a("AddPhoneNumberActivity#startVerificationCodeActivity, phone info: ");
        a2.append(this.mPhoneInfo);
        ACLog.d("IAPConnectPlugin", a2.toString());
        Intent intent = new Intent(this, VerificationCodeActivity.class);
        intent.putExtra(UIConstants.KEY_PHONE_INFO, this.mPhoneInfo);
        intent.putExtra(UIConstants.KEY_SAVE_PHONE_INFO, this.mSavePhoneNumCheck.isChecked());
        startActivityForResult(intent, 123);
    }

    private void triggerNextStep() {
        this.mPhoneInfo.mobilePhoneNumber = this.mPhoneNumEditText.getText().toString();
        if (isPhoneNumberExist()) {
            ACLog.d("IAPConnectPlugin", "AddPhoneNumberActivity#triggerNextStep, phone number existed, show dialog to remind");
            showPhoneNumberExistDialog();
            return;
        }
        startVerificationCodeActivity();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(ViewConfiguration.getMaximumDrawingCacheSize() >> 24, new char[]{60957, 61052, 421, 37437, 26324, 1845, 41386, 29082, 14076, 46897, 16732, 48293, 29122, 41448, 34542, 59239, 487, 4396, 22091, 6058, 53518, 16664}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(Gravity.getAbsoluteGravity(0, 0), new char[]{13591, 13690, 42188, 14147, 47628, 12446, 31403, 40373, 35605}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), new char[]{15261, 15274, 41909, 12320, 30459, 9390, 29813, 54154, 9948, 38134, 20769, 40820, 42010, 995, 38622, 50304, 54384, 45932, 18020, 13352, 1228, 58183, 13915, 25687, 46273, 4973, 58982, 54360, 58601, 17173, 22501, 1506, 5447, 62106, 1940, 30171, 17764, 8864, 63423, 42479, 62819, 21143, 42909, 5438, 9690, 33312, 5961, 17680, 21943, 12845, 50979, 46395}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(Drawable.resolveOpacity(0, 0), new char[]{40828, 40733, 25513, 61546, 56582, 21235, 53442, 5021, 36136, 58103, 64220, 59765, 168, 50095, 15737, 45778, 28816, 29477, 60825, 16939, 41006, 8974, 40438, 4614, 4128, 54133, 19918, 41564, 16474, 33550, 64537, 29666, 45484, 13008, 44090, 909, 57823, 58040, 23620, 54255, 20871, 37511, 3176, 25404, 33081, 16956, 48357, 13078, 61783, 62051, 27865, 50024, 8559, 41551, 7399, 37710, 37565, 20915, 53000, 8350, 49820, 413, 32515, 61605, 13029, 45516, 12076, 32972}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(KeyEvent.getMaxKeyCode() >> 16, new char[]{2505, 2555, 28629, 64530, 28693, 32768, 17960, 8171, 8298, 12302, 22428, 15232, 38465, 53132, 36920, 24611, 58992, 32607, 16600, 37085, 14024, 12065, 12516, 49318, 34499, 57182, 57561, 28841, 55022, 36722, 20825, 41290, 10055, 16042, 383, 53545, 30526, 61120, 61698, 282, 50995, 40619, 41262, 45506, 6017, 19986, 4593, 57830, 26553, 65052, 49609, 4552, 46991, 44605, 45555, 16871, 1027, 24013, 25118, 62063, 21550, 3553, 53785, 8708, 41991, 48569, 33341, 21043}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(View.combineMeasuredStates(0, 0), new char[]{4408, 4432, 43884, 14574, 9754, 3012, 24211, 56090, 30313, 48067, 386, 45142, 36588, 2857, 50800, 60325, 65182, 48100, 5790, 6990, 11837, 60377, 26298, 19319, 40545, 7091, 46802, 64354, 52815, 19357, 1823, 10966, 16308, 64067, 22311, 23273, 28569, 10794, 42827, 35546, 57283, 23055, 63339, 14851, 3881, 35576, 18359, 27179, 32537, 15038, 38865, 39449, 44907, 27276, 59297, 51746, 7410, 39215, 13315, 31226, 19597, 51526, 33866, 43415}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(ViewConfiguration.getMaximumFlingVelocity() >> 16, new char[]{56558, 56535, 15491, 44891, 64874, 14562, 37636, 19620, 55986, 33582}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) View.combineMeasuredStates(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = new Object[1];
                b((byte) (MyBillsEntityDataFactory - 3), BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = BuiltInFictitiousFunctionClassFactory[35];
                byte b2 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr14 = new Object[1];
                b(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 3 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) View.resolveSize(0, 0));
                        Object[] objArr16 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[31], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 15 - Color.red(0), (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 800, View.MeasureSpec.makeMeasureSpec(0, 0) + 15, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 815, Color.blue(0) + 29, (char) (57994 - (ViewConfiguration.getEdgeSlop() >> 16)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 801, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1449146618, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), Color.blue(0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                Object[] objArr19 = new Object[1];
                b((byte) (MyBillsEntityDataFactory - 3), BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = BuiltInFictitiousFunctionClassFactory[35];
                byte b4 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr20 = new Object[1];
                b(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 61, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 46, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[1]), $$a[8], (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), 34 - TextUtils.lastIndexOf("", '0', 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1449146618, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, TextUtils.getCapsMode("", 0, 0) + 18, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
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
                Object[] objArr25 = new Object[1];
                b((byte) (MyBillsEntityDataFactory - 3), BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = BuiltInFictitiousFunctionClassFactory[35];
                byte b6 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr26 = new Object[1];
                b(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(117 - TextUtils.indexOf((CharSequence) "", '0', 0), 3 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (38968 - View.MeasureSpec.makeMeasureSpec(0, 0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[1]), $$a[8], (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 36, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1449146618, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - TextUtils.getOffsetAfter("", 0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
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
                Object[] objArr31 = new Object[1];
                b((byte) (MyBillsEntityDataFactory - 3), BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = BuiltInFictitiousFunctionClassFactory[35];
                byte b8 = BuiltInFictitiousFunctionClassFactory[25];
                Object[] objArr32 = new Object[1];
                b(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 108, 3 - (ViewConfiguration.getScrollBarSize() >> 8), (char) Color.alpha(0));
                        Object[] objArr34 = new Object[1];
                        c($$a[53], (byte) ($$a[78] - 1), $$a[9], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1449146618, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, 18 - Drawable.resolveOpacity(0, 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
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

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append("AddPhoneNumberActivity#onActivityResult, requestCode: ");
        sb.append(i);
        sb.append(", resultCode: ");
        sb.append(i2);
        ACLog.d("IAPConnectPlugin", sb.toString());
        if (i != 122 || i2 != -1) {
            if (i == 123 && i2 == -1) {
                ACLog.d("IAPConnectPlugin", "AddPhoneNumberActivity#onActivityResult, verify code successfully, finish");
                finishActivity();
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("region");
        String stringExtra2 = intent.getStringExtra(UIConstants.KEY_PHONE_PREFIX);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AddPhoneNumberActivity#onActivityResult, get result region: ");
        sb2.append(stringExtra);
        sb2.append(", phonePrefix: ");
        sb2.append(stringExtra2);
        ACLog.d("IAPConnectPlugin", sb2.toString());
        this.mRegionText.setText(String.format(this.mDefaultRegionFormat, stringExtra, stringExtra2));
        this.mPhoneInfo.mobilePhoneRegionCode = stringExtra2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.region_layout) {
            ACLog.d("IAPConnectPlugin", "AddPhoneNumberActivity#onClick, click region layout");
            startPhoneRegionActivity();
        } else if (view.getId() == R.id.next_step_button) {
            ACLog.d("IAPConnectPlugin", "AddPhoneNumberActivity#onClick, click next step button");
            triggerNextStep();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a((-1) - ImageFormat.getBitsPerPixel(0), new char[]{60957, 61052, 421, 37437, 26324, 1845, 41386, 29082, 14076, 46897, 16732, 48293, 29122, 41448, 34542, 59239, 487, 4396, 22091, 6058, 53518, 16664}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(super.getResources().getString(id.dana.R.string.hint_form_city).substring(2, 3).length() - 1, new char[]{13591, 13690, 42188, 14147, 47628, 12446, 31403, 40373, 35605}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(getPackageName().codePointAt(3) - 100, new char[]{28007, 27910, 35008, 7000, 60926, 40969, 8912, 63743, 48598, 4109, 51830, 7065, 62134, 10382, 3482, 16421, 33454, 38981, 56694, 45210, 21105, 51303, 44366, 57506, 57867, 14366, 32032, 20710, 45590, 26682}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    b(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[25], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    b((byte) (BuiltInFictitiousFunctionClassFactory[59] + 1), BuiltInFictitiousFunctionClassFactory[56], (byte) (-BuiltInFictitiousFunctionClassFactory[5]), new Object[1]);
                    Object[] objArr6 = new Object[1];
                    a(((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{40889, 40922, 16051, 44336, 62697, 55089, 53252, 20112, 42183, 26458, 54135, 27809, 'y', 40678, 5255, 14170, 28754, 11823, 50295, 51106, 41142, 32264}, objArr6);
                    baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetAfter("", 0) + 35, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(ViewConfiguration.getPressedStateDuration() >> 16, new char[]{15261, 15274, 41909, 12320, 30459, 9390, 29813, 54154, 9948, 38134, 20769, 40820, 42010, 995, 38622, 50304, 54384, 45932, 18020, 13352, 1228, 58183, 13915, 25687, 46273, 4973, 58982, 54360, 58601, 17173, 22501, 1506, 5447, 62106, 1940, 30171, 17764, 8864, 63423, 42479, 62819, 21143, 42909, 5438, 9690, 33312, 5961, 17680, 21943, 12845, 50979, 46395}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(super.getResources().getString(id.dana.R.string.dana_user).substring(0, 9).codePointAt(3) - 65, new char[]{40828, 40733, 25513, 61546, 56582, 21235, 53442, 5021, 36136, 58103, 64220, 59765, 168, 50095, 15737, 45778, 28816, 29477, 60825, 16939, 41006, 8974, 40438, 4614, 4128, 54133, 19918, 41564, 16474, 33550, 64537, 29666, 45484, 13008, 44090, 909, 57823, 58040, 23620, 54255, 20871, 37511, 3176, 25404, 33081, 16956, 48357, 13078, 61783, 62051, 27865, 50024, 8559, 41551, 7399, 37710, 37565, 20915, 53000, 8350, 49820, 413, 32515, 61605, 13029, 45516, 12076, 32972}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(super.getResources().getString(id.dana.R.string.risk_reject_blacklist_title).substring(2, 3).length() - 1, new char[]{2505, 2555, 28629, 64530, 28693, 32768, 17960, 8171, 8298, 12302, 22428, 15232, 38465, 53132, 36920, 24611, 58992, 32607, 16600, 37085, 14024, 12065, 12516, 49318, 34499, 57182, 57561, 28841, 55022, 36722, 20825, 41290, 10055, 16042, 383, 53545, 30526, 61120, 61698, 282, 50995, 40619, 41262, 45506, 6017, 19986, 4593, 57830, 26553, 65052, 49609, 4552, 46991, 44605, 45555, 16871, 1027, 24013, 25118, 62063, 21550, 3553, 53785, 8708, 41991, 48569, 33341, 21043}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{4408, 4432, 43884, 14574, 9754, 3012, 24211, 56090, 30313, 48067, 386, 45142, 36588, 2857, 50800, 60325, 65182, 48100, 5790, 6990, 11837, 60377, 26298, 19319, 40545, 7091, 46802, 64354, 52815, 19357, 1823, 10966, 16308, 64067, 22311, 23273, 28569, 10794, 42827, 35546, 57283, 23055, 63339, 14851, 3881, 35576, 18359, 27179, 32537, 15038, 38865, 39449, 44907, 27276, 59297, 51746, 7410, 39215, 13315, 31226, 19597, 51526, 33866, 43415}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(super.getResources().getString(id.dana.R.string.add_new_panin_card).substring(1, 2).length() - 1, new char[]{56558, 56535, 15491, 44891, 64874, 14562, 37636, 19620, 55986, 33582}, objArr11);
                    try {
                        Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), View.MeasureSpec.getMode(0) + 18, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        try {
            Object[] objArr13 = new Object[1];
            b((byte) (MyBillsEntityDataFactory - 3), BuiltInFictitiousFunctionClassFactory[25], BuiltInFictitiousFunctionClassFactory[32], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            byte b = BuiltInFictitiousFunctionClassFactory[35];
            byte b2 = BuiltInFictitiousFunctionClassFactory[25];
            Object[] objArr14 = new Object[1];
            b(b, b2, (byte) (b2 | 8), objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getTouchSlop() >> 8), 4 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getTouchSlop() >> 8));
                    Object[] objArr16 = new Object[1];
                    c($$a[53], (byte) ($$a[78] - 1), $$a[9], objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 35 - View.resolveSizeAndState(0, 0, 0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr18 = {1835963379, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, TextUtils.getOffsetAfter("", 0) + 18, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                super.onCreate(bundle);
                setContentView(R.layout.acplugin_activity_add_phone_num);
                initData();
                initView();
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
    }

    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(id.dana.R.string.zdoc_camera_permission_msg).substring(18, 20).length() - 2, new char[]{28007, 27910, 35008, 7000, 60926, 40969, 8912, 63743, 48598, 4109, 51830, 7065, 62134, 10382, 3482, 16421, 33454, 38981, 56694, 45210, 21105, 51303, 44366, 57506, 57867, 14366, 32032, 20710, 45590, 26682}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(Process.myTid() >> 22, new char[]{40889, 40922, 16051, 44336, 62697, 55089, 53252, 20112, 42183, 26458, 54135, 27809, 'y', 40678, 5255, 14170, 28754, 11823, 50295, 51106, 41142, 32264}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), TextUtils.indexOf("", "", 0) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                b(BuiltInFictitiousFunctionClassFactory[25], (byte) (-BuiltInFictitiousFunctionClassFactory[30]), BuiltInFictitiousFunctionClassFactory[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b((byte) (BuiltInFictitiousFunctionClassFactory[59] + 1), BuiltInFictitiousFunctionClassFactory[56], (byte) (-BuiltInFictitiousFunctionClassFactory[5]), new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{28007, 27910, 35008, 7000, 60926, 40969, 8912, 63743, 48598, 4109, 51830, 7065, 62134, 10382, 3482, 16421, 33454, 38981, 56694, 45210, 21105, 51303, 44366, 57506, 57867, 14366, 32032, 20710, 45590, 26682}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{40889, 40922, 16051, 44336, 62697, 55089, 53252, 20112, 42183, 26458, 54135, 27809, 'y', 40678, 5255, 14170, 28754, 11823, 50295, 51106, 41142, 32264}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.getOffsetBefore("", 0) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
    }
}
