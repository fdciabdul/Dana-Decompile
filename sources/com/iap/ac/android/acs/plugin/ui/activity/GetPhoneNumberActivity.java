package com.iap.ac.android.acs.plugin.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.acs.plugin.R;
import com.iap.ac.android.acs.plugin.a.a;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.PhoneNumberFacade;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.model.MobilePhoneInfo;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.request.UserPhoneRequest;
import com.iap.ac.android.acs.plugin.rpc.getphonenumber.result.UserPhoneQueryResult;
import com.iap.ac.android.acs.plugin.ui.adapter.PhoneNumberListAdapter;
import com.iap.ac.android.acs.plugin.ui.utils.MultiLanguageUtils;
import com.iap.ac.android.acs.plugin.ui.utils.UIConstants;
import com.iap.ac.android.acs.plugin.ui.utils.UIUtils;
import com.iap.ac.android.acs.plugin.ui.view.ConstraintHeightListView;
import com.iap.ac.android.acs.plugin.utils.MonitorUtil;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.rpc.RPCProxyHost;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.rpccommon.model.domain.request.BaseRpcRequest;
import com.iap.ac.android.rpccommon.model.domain.result.BaseRpcResult;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes8.dex */
public class GetPhoneNumberActivity extends Activity implements View.OnClickListener {
    public TextView mAddPhoneNumText;
    public LinearLayout mAddPhoneNumView;
    public Button mAgreeButton;
    public Button mCancelButton;
    public String mCancelText;
    public String mConfirmDeleteText;
    public String mDeleteDialogDesc;
    public String mDeleteText;
    public TextView mDescText;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public String mMiniProgramName;
    public MobilePhoneInfo mPhoneInfo;
    public ArrayList<MobilePhoneInfo> mPhoneInfoList;
    public PhoneNumberListAdapter mPhoneNumAdapter;
    public ConstraintHeightListView mPhoneNumList;
    public int mPhoneNumListMaxHeight;
    public LinearLayout mRootView;
    public TextView mUseOtherPhoneNumText;
    public static final byte[] $$a = {36, -25, -14, -85, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 45;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {11, 41, -68, -59, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 255;
    private static char[] BuiltInFictitiousFunctionClassFactory = {62255, 5838, 14582, 17142, 25753, 36481, 37054, 47842, 56401, 58979, 2092, 4644, 13332, 24119, 24617, 35801, 44509, 47091, 19932, 43046, 34360, 64530, 55917, 62255, 5838, 14582, 17142, 25753, 36481, 37054, 47842, 56415, 58976, 2162, 4698, 13351, 24123, 24638, 35797, 44504, 47081, 55686, 58269, 1410, 12192, 12616, 23369, 32127, 34580, 62253, 5845, 14560, 17142, 25747, 36486, 37038, 47757, 56398, 58976, 2158, 4637, 13317, 24121, 24638, 35797, 44481, 47086, 19150, 44916, 33043, 64267, 56689, 14139, 10580, 835, 26046, 24514, 45526, 43941, 36276, 59357, 55756, 12861, 5160, 3590, 24691, 23090, 48133, 38428, 35054, 58029, 50381, 16116, 4333, 2695, 27843, 16747, 47996, 40270, 63232, 59745, 50007, 9546, 8167, 29094, 27541, 19851, 43006, 39297, 62401, 54325, 52851, Typography.leftDoubleQuote, 6667, 31790, 62255, 5781, 14500, 17120, 25744, 36561, 37098, 47860, 56410, 58995, 2107, 4673, 13314, 24169, 24699, 35720, 44444, 47026, 55700, 58325, 1458, 12281, 12556, 23327, 32040, 34578, 43355, 45873, 54654, 63708, 664, 9390, 20205, 20612, 31462, 40188, 42581, 51275, 53802, 62527, 7755, 8288, 18983, 28037, 30661, 39343, 41915, 50635, 61405, 61939, 6917, 15645, 18223, 26943, 29514, 38237, 49006, 49793, 58561, 3830, 4279, 15040, 23694, 26351, 26340, 33545, 44399, 55166, 61783, 6983, 1392, 12128, 18846, 29616, 40354, 34781, 41423, 52211, 62946, 7699, 14423, 8829, 19550, 30232, 36988, 47666, 42179, 52871, 59569, 4750, 15555, 9972, 16568, 27974, 38661, 45415, 56097, 50460, 61304, 2404, 13260, 23943, 18356, 25004, 35806, 46510, 57323, 63512, 57862, 3120, 13939, 20486, 31248, 25697, 36553, 43225, 53948, 64673, 59012, 193, 10993, 22301, 28931, 39738, 34168, 44885, 51527, 62333, 48867, 23313, 29987, 3889, 10560, 49943, 56624, 63270, 37279, 43956, 17833, 24528, 31117, 5097, 11751, 50699, 57358, 64036, 37955, 44610, 18546, 25214, 31883, 5831, 12476, 51904, 58566, 65251, 39143, 46350, 20254, 26924, 810, 7511, 14194, 53551, 60304, 34178, 40882, 47590, 21466, 28133, 2030, 8286, 14858, 54323, 60968, 34908, 41560, 48241, 22232, 28823, 2785, 9442, 16090, 55519, 62206, 36635, 43283, 17186, 34373, 25532, 19860, 14232, 4598, 64491};
    private static long PlaceComponentResult = -2292558795474463072L;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 16
            int r8 = 106 - r8
            int r7 = r7 + 4
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L34
        L17:
            r3 = 0
        L18:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r7]
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
            int r6 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.a(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            int r7 = r7 + 4
            byte[] r0 = com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.$$a
            int r6 = r6 * 3
            int r6 = 42 - r6
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L19
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            int r6 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.c(short, short, byte, java.lang.Object[]):void");
    }

    private void calculatePhoneNumListMaxHeight() {
        this.mRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = GetPhoneNumberActivity.this.mRootView.getHeight();
                int screenHeight = UIUtils.getScreenHeight(GetPhoneNumberActivity.this);
                GetPhoneNumberActivity getPhoneNumberActivity = GetPhoneNumberActivity.this;
                getPhoneNumberActivity.mPhoneNumListMaxHeight = UIUtils.dp2px(getPhoneNumberActivity, 25) + (((screenHeight * 3) / 4) - height);
                StringBuilder sb = new StringBuilder();
                sb.append("GetPhoneNumberActivity#calculatePhoneNumListMaxHeight: ");
                sb.append(GetPhoneNumberActivity.this.mPhoneNumListMaxHeight);
                ACLog.d("IAPConnectPlugin", sb.toString());
                GetPhoneNumberActivity.this.mRootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void fillText() {
        this.mDescText.setText(String.format("%s %s\n%s", this.mMiniProgramName, getString(R.string.acplugin_require), getString(R.string.acplugin_get_phone_desc)));
        this.mDeleteText = getString(R.string.acplugin_delete);
        this.mDeleteDialogDesc = getString(R.string.acplugin_confirm_delete_desc);
        this.mCancelText = getString(R.string.acplugin_cancel);
        this.mConfirmDeleteText = getString(R.string.acplugin_confirm_delete);
        MultiLanguageUtils.getMultiLanguageTextMap(new MultiLanguageUtils.Callback() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.2
            @Override // com.iap.ac.android.acs.plugin.ui.utils.MultiLanguageUtils.Callback
            public void onGetMultiLanguageText(Map<String, String> map) {
                GetPhoneNumberActivity.this.mDescText.setText(String.format("%s %s\n%s", GetPhoneNumberActivity.this.mMiniProgramName, map.get("Require"), map.get("GetPhoneDesc")));
                GetPhoneNumberActivity.this.mAddPhoneNumText.setText(map.get("AddPhone"));
                GetPhoneNumberActivity.this.mUseOtherPhoneNumText.setText(map.get("UseOtherPhone"));
                GetPhoneNumberActivity.this.mCancelButton.setText(map.get(MyBillsPurposeAction.CANCEL));
                GetPhoneNumberActivity.this.mAgreeButton.setText(map.get("Allow"));
                GetPhoneNumberActivity.this.mDeleteText = map.get(MyBillsPurposeAction.DELETE);
                GetPhoneNumberActivity.this.mDeleteDialogDesc = map.get("ConfirmDeleteDesc");
                GetPhoneNumberActivity.this.mCancelText = map.get(MyBillsPurposeAction.CANCEL);
                GetPhoneNumberActivity.this.mConfirmDeleteText = map.get("ConfirmDelete");
                GetPhoneNumberActivity.this.initPhoneNumberList();
            }
        });
    }

    private void filterPhoneInfoList(List<MobilePhoneInfo> list) {
        this.mPhoneInfoList = new ArrayList<>(list.size());
        for (MobilePhoneInfo mobilePhoneInfo : list) {
            if (mobilePhoneInfo != null && !TextUtils.isEmpty(mobilePhoneInfo.mobilePhoneRegionCode) && !TextUtils.isEmpty(mobilePhoneInfo.mobilePhoneNumber) && !TextUtils.isEmpty(mobilePhoneInfo.formattedMobilePhoneNumber)) {
                this.mPhoneInfoList.add(mobilePhoneInfo);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("GetPhoneNumberActivity#filterPhoneInfoList, phone info illegal");
                sb.append(mobilePhoneInfo);
                ACLog.e("IAPConnectPlugin", sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getPhoneNumber() {
        ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#getPhoneNumber");
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            UserPhoneQueryResult query = ((PhoneNumberFacade) RPCProxyHost.getInterfaceProxy(PhoneNumberFacade.class, "ac_biz")).query(new BaseRpcRequest());
            MonitorUtil.monitorRPC("ac.mobilepayment.user.phone.query", SystemClock.elapsedRealtime() - elapsedRealtime, query);
            if (query != null && query.success) {
                List<MobilePhoneInfo> list = query.mobilePhoneInfoList;
                if (list != null && !list.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GetPhoneNumberActivity#getPhoneNumber, rpc phone number list: ");
                    sb.append(list);
                    ACLog.d("IAPConnectPlugin", sb.toString());
                    filterPhoneInfoList(list);
                    return true;
                }
                ACLog.e("IAPConnectPlugin", "GetPhoneNumberActivity#getPhoneNumber, rpc phone number list is empty");
                return false;
            }
            ACLog.e("IAPConnectPlugin", "GetPhoneNumberActivity#getPhoneNumber, rpc result is null or fail");
            return false;
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GetPhoneNumberActivity#getPhoneNumber, rpc error: ");
            sb2.append(th);
            ACLog.e("IAPConnectPlugin", sb2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hidePhoneNumberList() {
        ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#hidePhoneNumList");
        this.mAddPhoneNumView.setVisibility(0);
        this.mPhoneNumList.setVisibility(8);
        this.mUseOtherPhoneNumText.setVisibility(8);
        this.mAgreeButton.setEnabled(false);
    }

    private void initData() {
        String stringExtra = getIntent().getStringExtra("locale");
        StringBuilder sb = new StringBuilder();
        sb.append("GetPhoneNumberActivity#initData, locale from JS parameter: ");
        sb.append(stringExtra);
        ACLog.d("IAPConnectPlugin", sb.toString());
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = UIUtils.getLocale(this);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GetPhoneNumberActivity#initData, local from JS parameter is empty, get system locale: ");
            sb2.append(stringExtra);
            ACLog.d("IAPConnectPlugin", sb2.toString());
        }
        MultiLanguageUtils.locale = stringExtra;
        this.mMiniProgramName = getIntent().getStringExtra(UIConstants.KEY_MINI_PROGRAM_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPhoneNumberAdapter() {
        ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#initPhoneNumberAdapter");
        PhoneNumberListAdapter phoneNumberListAdapter = new PhoneNumberListAdapter(this, this.mPhoneInfoList);
        this.mPhoneNumAdapter = phoneNumberListAdapter;
        phoneNumberListAdapter.setMultiLanguageText(this.mDeleteText, this.mDeleteDialogDesc, this.mCancelText, this.mConfirmDeleteText);
        this.mPhoneNumAdapter.setOnDeleteAllListener(new PhoneNumberListAdapter.OnDeleteAllListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.7
            @Override // com.iap.ac.android.acs.plugin.ui.adapter.PhoneNumberListAdapter.OnDeleteAllListener
            public void onDeleteAll() {
                GetPhoneNumberActivity.this.hidePhoneNumberList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPhoneNumberList() {
        this.mPhoneNumList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (GetPhoneNumberActivity.this.mPhoneNumAdapter != null) {
                    GetPhoneNumberActivity.this.mPhoneNumAdapter.onItemClick(i);
                }
            }
        });
        this.mPhoneNumList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (GetPhoneNumberActivity.this.mPhoneNumAdapter != null) {
                    return GetPhoneNumberActivity.this.mPhoneNumAdapter.onItemLongClick(view);
                }
                return false;
            }
        });
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (GetPhoneNumberActivity.this.getPhoneNumber()) {
                    GetPhoneNumberActivity.this.refreshPhoneNumberList();
                } else {
                    ACLog.e("IAPConnectPlugin", "GetPhoneNumberActivity#initPhoneNumberList, rpc result false, do not show list view");
                }
            }
        });
    }

    private void initView() {
        this.mRootView = (LinearLayout) findViewById(R.id.root_view);
        this.mDescText = (TextView) findViewById(R.id.desc_text);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.add_phone_num_view);
        this.mAddPhoneNumView = linearLayout;
        linearLayout.setOnClickListener(this);
        this.mAddPhoneNumText = (TextView) findViewById(R.id.add_phone_num_text);
        this.mPhoneNumList = (ConstraintHeightListView) findViewById(R.id.phone_num_list);
        TextView textView = (TextView) findViewById(R.id.use_other_phone_num_text);
        this.mUseOtherPhoneNumText = textView;
        textView.setOnClickListener(this);
        Button button = (Button) findViewById(R.id.agree_button);
        this.mAgreeButton = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.cancel_button);
        this.mCancelButton = button2;
        button2.setOnClickListener(this);
        calculatePhoneNumListMaxHeight();
        fillText();
    }

    private void initWindow() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPhoneNumberList() {
        ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#refreshPhoneNumberList");
        this.mMainHandler.post(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (!UIUtils.isActivityDisabled(GetPhoneNumberActivity.this)) {
                    GetPhoneNumberActivity.this.initPhoneNumberAdapter();
                    GetPhoneNumberActivity.this.mPhoneNumList.setMaxHeight(GetPhoneNumberActivity.this.mPhoneNumListMaxHeight);
                    GetPhoneNumberActivity.this.mPhoneNumList.setAdapter((ListAdapter) GetPhoneNumberActivity.this.mPhoneNumAdapter);
                    GetPhoneNumberActivity.this.showPhoneNumberList();
                    return;
                }
                ACLog.e("IAPConnectPlugin", "GetPhoneNumberActivity#refreshPhoneNumberList, activity disabled");
            }
        });
    }

    private void refreshUsagePhoneInfo() {
        StringBuilder a2 = a.a("GetPhoneNumberActivity#refreshUsagePhoneInfo, prefix: ");
        a2.append(this.mPhoneInfo.mobilePhoneRegionCode);
        a2.append(", phone number: ");
        a2.append(UIUtils.encryptPhoneNumber(this.mPhoneInfo.mobilePhoneNumber));
        ACLog.d("IAPConnectPlugin", a2.toString());
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.acs.plugin.ui.activity.GetPhoneNumberActivity.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    PhoneNumberFacade phoneNumberFacade = (PhoneNumberFacade) RPCProxyHost.getInterfaceProxy(PhoneNumberFacade.class, "ac_biz");
                    UserPhoneRequest userPhoneRequest = new UserPhoneRequest();
                    userPhoneRequest.mobilePhoneNumber = GetPhoneNumberActivity.this.mPhoneInfo.mobilePhoneNumber;
                    userPhoneRequest.mobilePhoneRegionCode = GetPhoneNumberActivity.this.mPhoneInfo.mobilePhoneRegionCode;
                    BaseRpcResult refreshUsage = phoneNumberFacade.refreshUsage(userPhoneRequest);
                    MonitorUtil.monitorRPC(PhoneNumberFacade.OPERATION_TYPE_REFRESH_USAGE, SystemClock.elapsedRealtime() - elapsedRealtime, refreshUsage);
                    if (refreshUsage == null) {
                        ACLog.e("IAPConnectPlugin", "GetPhoneNumberActivity#refreshUsagePhoneInfo, rpc result is null");
                    } else if (!refreshUsage.success) {
                        StringBuilder a3 = a.a("GetPhoneNumberActivity#refreshUsagePhoneInfo, rpc result fail, error: ");
                        a3.append(refreshUsage.errorCode);
                        a3.append(", errorMessage: ");
                        a3.append(refreshUsage.errorMessage);
                        ACLog.e("IAPConnectPlugin", a3.toString());
                    } else {
                        ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#refreshUsagePhoneInfo, rpc result success");
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("GetPhoneNumberActivity#refreshUsagePhoneInfo, rpc error: ");
                    sb.append(th);
                    ACLog.e("IAPConnectPlugin", sb.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPhoneNumberList() {
        ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#showPhoneNumList");
        this.mAddPhoneNumView.setVisibility(8);
        this.mPhoneNumList.setVisibility(0);
        this.mUseOtherPhoneNumText.setVisibility(0);
        this.mAgreeButton.setEnabled(true);
    }

    private void startAddPhoneNumberActivity() {
        Intent intent = new Intent(this, AddPhoneNumberActivity.class);
        intent.putParcelableArrayListExtra(UIConstants.KEY_PHONE_INFO_LIST, this.mPhoneInfoList);
        startActivityForResult(intent, 121);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Method method;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(18 - TextUtils.indexOf("", "", 0, 0), ViewConfiguration.getFadingEdgeLength() >> 16, (char) (ViewConfiguration.getJumpTapTimeout() >> 16), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(Color.green(0) + 5, 'B' - AndroidCharacter.getMirror('0'), (char) (48894 - TextUtils.lastIndexOf("", '0', 0)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 36 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 47, 66 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 47544), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(Color.argb(0, 0, 0, 0) + 64, 116 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(64 - (ViewConfiguration.getScrollBarSize() >> 8), ((Process.getThreadPriority(0) + 20) >> 6) + 179, (char) (Color.argb(0, 0, 0, 0) + 38296), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b('l' - AndroidCharacter.getMirror('0'), TextUtils.indexOf((CharSequence) "", '0', 0) + 244, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 19908), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6, KeyEvent.normalizeMetaState(0) + 303, (char) (Color.red(0) + 30002), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 912, 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr13 = new Object[1];
                a(b, (byte) (b | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr14 = new Object[1];
                a(b2, (byte) (b2 | Ascii.NAK), KClassImpl$Data$declaredNonStaticMembers$2[7], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), View.resolveSize(0, 0) + 3, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr16 = new Object[1];
                        c($$a[31], (byte) ($$a[78] - 1), $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - KeyEvent.normalizeMetaState(0), 15 - (ViewConfiguration.getScrollBarSize() >> 8), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 800, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 14, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - TextUtils.indexOf((CharSequence) "", '0'), 29 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - TextUtils.getOffsetBefore("", 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-789349239, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr19 = new Object[1];
                a(b3, (byte) (b3 | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr20 = new Object[1];
                a(b4, (byte) (b4 | Ascii.NAK), KClassImpl$Data$declaredNonStaticMembers$2[7], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 60, TextUtils.lastIndexOf("", '0', 0) + 47, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        byte b5 = $$a[8];
                        Object[] objArr22 = new Object[1];
                        c(b5, (byte) (b5 | 16), (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), Process.getGidForName("") + 36, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-789349239, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 911, 17 - ExpandableListView.getPackedPositionChild(0L), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr25 = new Object[1];
                a(b6, (byte) (b6 | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b7 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr26 = new Object[1];
                a(b7, (byte) (b7 | Ascii.NAK), KClassImpl$Data$declaredNonStaticMembers$2[7], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 3 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 38969));
                        byte b8 = $$a[8];
                        Object[] objArr28 = new Object[1];
                        c(b8, (byte) (b8 | 16), (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (-16777181) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-789349239, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr31 = new Object[1];
                a(b9, (byte) (b9 | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b10 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr32 = new Object[1];
                a(b10, (byte) (b10 | Ascii.NAK), KClassImpl$Data$declaredNonStaticMembers$2[7], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 107, 3 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) Color.argb(0, 0, 0, 0));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[53], $$a[9], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                method = obj16;
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), TextUtils.getOffsetBefore("", 0) + 35, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke6 = ((Method) method).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-789349239, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), View.MeasureSpec.getMode(0) + 18, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        sb.append("GetPhoneNumberActivity#onActivityResult, requestCode: ");
        sb.append(i);
        sb.append(", resultCode: ");
        sb.append(i2);
        ACLog.d("IAPConnectPlugin", sb.toString());
        if (i == 121 && i2 == -1) {
            this.mPhoneInfo = (MobilePhoneInfo) intent.getParcelableExtra(UIConstants.KEY_PHONE_INFO);
            StringBuilder a2 = a.a("GetPhoneNumberActivity#onActivityResult, get result phone info: ");
            a2.append(this.mPhoneInfo);
            ACLog.d("IAPConnectPlugin", a2.toString());
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.agree_button) {
            ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#onClick, click agree button");
            PhoneNumberListAdapter phoneNumberListAdapter = this.mPhoneNumAdapter;
            if (phoneNumberListAdapter != null) {
                this.mPhoneInfo = phoneNumberListAdapter.getSelectedPhoneInfo();
            }
            finish();
        } else if (view.getId() == R.id.cancel_button) {
            ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#onClick, click cancel button");
            finish();
        } else if (view.getId() == R.id.use_other_phone_num_text) {
            ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#onClick, click use other phone number text");
            startAddPhoneNumberActivity();
        } else if (view.getId() == R.id.add_phone_num_view) {
            ACLog.d("IAPConnectPlugin", "GetPhoneNumberActivity#onClick, click add phone number view");
            startAddPhoneNumberActivity();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 15, getPackageName().length() - 7, (char) (super.getResources().getString(id.dana.R.string.add_new_bills_second_onboarding_subtitle).substring(4, 5).length() - 1), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            int codePointAt = super.getResources().getString(id.dana.R.string.credit_card_tnc_agreement_description).substring(13, 14).codePointAt(0) - 99;
            int codePointAt2 = super.getResources().getString(id.dana.R.string.header_redeem_promo_code).substring(41, 42).codePointAt(0) - 98;
            try {
                Object[] objArr4 = new Object[1];
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], objArr5);
                Object[] objArr6 = new Object[1];
                b(codePointAt, codePointAt2, (char) (((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 48862), objArr6);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr7 = new Object[1];
                        b(getPackageName().codePointAt(4) - 71, super.getResources().getString(id.dana.R.string.add_asset_card_success_dialog_message).substring(38, 39).codePointAt(0) - 74, (char) (ViewConfiguration.getPressedStateDuration() >> 16), objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        int codePointAt3 = super.getResources().getString(id.dana.R.string.option_no_i_did_not).substring(5, 6).codePointAt(0) - 14;
                        int codePointAt4 = super.getResources().getString(id.dana.R.string.send_money_edit).substring(0, 4).codePointAt(0) - 20;
                        try {
                            Object[] objArr8 = new Object[1];
                            a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            b(codePointAt3, codePointAt4, (char) (((ApplicationInfo) cls5.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33), objArr9);
                            baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.lastIndexOf("", '0', 0) + 36, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr10 = new Object[1];
                            b(super.getResources().getString(id.dana.R.string.profile_completion_task_description_email).substring(2, 3).length() + 47, 68 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (TextUtils.getTrimmedLength("") + 47543), objArr10);
                            String str = (String) objArr10[0];
                            int deadChar = KeyEvent.getDeadChar(0, 0) + 64;
                            try {
                                Object[] objArr11 = new Object[1];
                                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], objArr12);
                                Object[] objArr13 = new Object[1];
                                b(deadChar, ((ApplicationInfo) cls6.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 82, (char) (getPackageName().codePointAt(2) - 46), objArr13);
                                String str2 = (String) objArr13[0];
                                try {
                                    Object[] objArr14 = new Object[1];
                                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr14);
                                    Class<?> cls7 = Class.forName((String) objArr14[0]);
                                    Object[] objArr15 = new Object[1];
                                    a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], objArr15);
                                    Object[] objArr16 = new Object[1];
                                    b(((ApplicationInfo) cls7.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 31, getPackageName().length() + 172, (char) (38297 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), objArr16);
                                    String str3 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    b(61 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), super.getResources().getString(id.dana.R.string.all).substring(0, 3).length() + 240, (char) (getPackageName().codePointAt(2) + 19863), objArr17);
                                    String str4 = (String) objArr17[0];
                                    int indexOf = TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 7;
                                    try {
                                        Object[] objArr18 = new Object[1];
                                        a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr18);
                                        Class<?> cls8 = Class.forName((String) objArr18[0]);
                                        Object[] objArr19 = new Object[1];
                                        a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], objArr19);
                                        int i = ((ApplicationInfo) cls8.getMethod((String) objArr19[0], null).invoke(this, null)).targetSdkVersion + 270;
                                        try {
                                            Object[] objArr20 = new Object[1];
                                            a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr20);
                                            Class<?> cls9 = Class.forName((String) objArr20[0]);
                                            Object[] objArr21 = new Object[1];
                                            a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], objArr21);
                                            Object[] objArr22 = new Object[1];
                                            b(indexOf, i, (char) (((ApplicationInfo) cls9.getMethod((String) objArr21[0], null).invoke(this, null)).targetSdkVersion + 29969), objArr22);
                                            try {
                                                Object[] objArr23 = {baseContext, str, str2, str3, str4, true, (String) objArr22[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 912, ImageFormat.getBitsPerPixel(0) + 19, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr23);
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
                        } catch (Throwable th7) {
                            Throwable cause7 = th7.getCause();
                            if (cause7 == null) {
                                throw th7;
                            }
                            throw cause7;
                        }
                    }
                }
                try {
                    byte b = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    Object[] objArr24 = new Object[1];
                    a(b, (byte) (b | 36), KClassImpl$Data$declaredNonStaticMembers$2[25], objArr24);
                    Class<?> cls10 = Class.forName((String) objArr24[0]);
                    byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    Object[] objArr25 = new Object[1];
                    a(b2, (byte) (b2 | Ascii.NAK), KClassImpl$Data$declaredNonStaticMembers$2[7], objArr25);
                    try {
                        Object[] objArr26 = {Integer.valueOf(((Integer) cls10.getMethod((String) objArr25[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls11 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 494, TextUtils.getTrimmedLength("") + 4, (char) (ViewConfiguration.getTouchSlop() >> 8));
                            Object[] objArr27 = new Object[1];
                            c((byte) ($$a[78] - 1), $$a[53], $$a[9], objArr27);
                            obj3 = cls11.getMethod((String) objArr27[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr28 = (Object[]) ((Method) obj3).invoke(null, objArr26);
                        int i2 = ((int[]) objArr28[1])[0];
                        if (((int[]) objArr28[0])[0] != i2) {
                            long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr29 = {1458666902, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.red(0), KeyEvent.keyCodeFromString("") + 18, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr29);
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
                        super.onCreate(bundle);
                        setContentView(R.layout.acplugin_activity_get_phone_num);
                        initWindow();
                        initData();
                        initView();
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

    @Override // android.app.Activity
    public void onDestroy() {
        StringBuilder a2 = a.a("GetPhoneNumberActivity#onDestroy, phone info: ");
        a2.append(this.mPhoneInfo);
        ACLog.d("IAPConnectPlugin", a2.toString());
        if (this.mPhoneInfo != null) {
            refreshUsagePhoneInfo();
        }
        Intent intent = new Intent("com.iap.ac.android.acs.plugin.action.GET_PHONE_NUMBER");
        MobilePhoneInfo mobilePhoneInfo = this.mPhoneInfo;
        if (mobilePhoneInfo != null) {
            intent.putExtra("regionCode", mobilePhoneInfo.mobilePhoneRegionCode);
            intent.putExtra("phoneNumber", this.mPhoneInfo.mobilePhoneNumber);
        }
        sendBroadcast(intent);
        MultiLanguageUtils.clear();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(id.dana.R.string.show_and_scan).substring(67, 69).codePointAt(1) - 90, getPackageName().codePointAt(5) - 87, (char) (TextUtils.lastIndexOf("", '0') + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(super.getResources().getString(id.dana.R.string.passkey_activate).substring(8, 16).length() + 10, getPackageName().length() + 42, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetAfter("", 0), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, ExpandableListView.getPackedPositionType(0L) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 7;
                try {
                    Object[] objArr3 = new Object[1];
                    a((byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[9], KClassImpl$Data$declaredNonStaticMembers$2[32], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    a(KClassImpl$Data$declaredNonStaticMembers$2[56], KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[13], new Object[1]);
                    Object[] objArr4 = new Object[1];
                    b(i, ((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 10, (char) (super.getResources().getString(id.dana.R.string.promo_description).substring(10, 11).codePointAt(0) - 115), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b(super.getResources().getString(id.dana.R.string.input_password_payment_auth).substring(14, 15).codePointAt(0) - 47, getPackageName().codePointAt(4) - 48, (char) (getPackageName().codePointAt(4) - 97), objArr5);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetBefore("", 0) + 35, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (BuiltInFictitiousFunctionClassFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ PlaceComponentResult))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
