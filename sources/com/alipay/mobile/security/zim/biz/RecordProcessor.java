package com.alipay.mobile.security.zim.biz;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.mobile.security.bio.common.record.MetaRecord;
import com.alipay.mobile.security.bio.log.BehaviourIdEnum;
import com.alipay.mobile.security.bio.log.VerifyBehavior;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.ZimRecordService;
import com.alipay.mobile.security.bio.service.local.apsecurity.ApSecurityService;
import com.alipay.mobile.security.bio.service.local.monitorlog.MonitorLogService;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class RecordProcessor {
    static String KEY_AUTH_REQUEST = "authRequest";
    static String KEY_AUTH_RESPONSE = "authResponse";
    static String KEY_INITPROD_REQUEST = "initProdRequest";
    public static String KEY_INITPROD_RESPONSE = "initProdResponse";
    public static String KEY_VALIDATE_REQUEST = "validateRequest";
    public static String KEY_VALIDATE_RESPONSE = "validateResponse";
    static String KEY_VERIFY_REQUEST = "verifyRequest";
    static String KEY_VERIFY_RESPONSE = "verifyResponse";
    static String KEY_ZIM_EXIT = "zimExit";
    static String KEY_ZIM_START = "zimStart";
    static String KEY_ZTECH_ENRTER = "ztech_enter";
    static String KEY_ZTECH_EXIT = "ztech_exit";
    public static String KEY_ZTECH_RPC_ERROR = "ztech_rpc_error";
    private static RecordProcessor sInstance;
    protected Context mContext;
    private MonitorLogService mMonitorLogService;
    private String mUniqueID;
    private ZimRecordService mZimRecordService;
    private int mSequenceId = 0;
    private int mRetryId = 0;
    private boolean mDestroyable = true;
    private HashMap<String, MetaRecord> mRecords = new HashMap<>();
    protected Map<String, String> mExtParams = new HashMap();

    public MonitorLogService getMonitorLogService() {
        return this.mMonitorLogService;
    }

    public static RecordProcessor createInstance(Context context) {
        RecordProcessor recordProcessor;
        synchronized (RecordProcessor.class) {
            recordProcessor = new RecordProcessor(context);
            sInstance = recordProcessor;
        }
        return recordProcessor;
    }

    public static RecordProcessor getInstance() {
        return sInstance;
    }

    public RecordProcessor(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(UUID.randomUUID().toString());
        sb.append(random.nextInt());
        this.mUniqueID = sb.toString().replace("-", "").toLowerCase();
        this.mExtParams.put("logModelVersion", "V1.0");
        this.mExtParams.put("logPlanId", "ZOLOZ_LOGPLAN_ALIPAYCLOUD_V1");
        this.mExtParams.put("logType", "BI_C_V1");
        this.mRecords.put(KEY_ZIM_START, new MetaRecord("UC-RZHY-170807-01", "event", "20001117", KEY_ZIM_START, 1));
        this.mRecords.put(KEY_VERIFY_REQUEST, new MetaRecord("UC-RZHY-170807-01", "event", "20001117", KEY_VERIFY_REQUEST, 1));
        this.mRecords.put(KEY_INITPROD_REQUEST, new MetaRecord("UC-RZHY-170807-02", "event", "20001117", KEY_INITPROD_REQUEST, 1));
        this.mRecords.put(KEY_INITPROD_RESPONSE, new MetaRecord("UC-RZHY-170807-03", "event", "20001117", KEY_INITPROD_RESPONSE, 1));
        this.mRecords.put(KEY_AUTH_REQUEST, new MetaRecord("UC-RZHY-170807-04", "event", "20001117", KEY_AUTH_REQUEST, 1));
        this.mRecords.put(KEY_AUTH_RESPONSE, new MetaRecord("UC-RZHY-170807-05", "event", "20001117", KEY_AUTH_RESPONSE, 1));
        this.mRecords.put(KEY_VALIDATE_REQUEST, new MetaRecord("UC-RZHY-170807-06", "event", "20001117", KEY_VALIDATE_REQUEST, 1));
        this.mRecords.put(KEY_VALIDATE_RESPONSE, new MetaRecord("UC-RZHY-170807-07", "event", "20001117", KEY_VALIDATE_RESPONSE, 1));
        this.mRecords.put(KEY_VERIFY_RESPONSE, new MetaRecord("UC-RZHY-170807-08", "event", "20001117", KEY_VERIFY_RESPONSE, 1));
        this.mRecords.put(KEY_ZIM_EXIT, new MetaRecord("UC-RZHY-170807-09", "event", "20001117", KEY_ZIM_EXIT, 1));
        this.mRecords.put(KEY_ZTECH_RPC_ERROR, new MetaRecord("UC-RZHY-170807-10", "event", "20001117", KEY_ZTECH_RPC_ERROR, 1));
        this.mRecords.put(KEY_ZTECH_ENRTER, new MetaRecord("UC-RZHY-170807-11", "event", "20001117", KEY_ZTECH_ENRTER, 1));
        this.mRecords.put(KEY_ZTECH_EXIT, new MetaRecord("UC-RZHY-170807-11", "event", "20001117", KEY_ZTECH_EXIT, 1));
    }

    public void setUniqueID(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mUniqueID = str;
    }

    public String getUniqueID() {
        return this.mUniqueID;
    }

    public void zimInit(String str) {
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        if (this.mZimRecordService == null) {
            this.mZimRecordService = (ZimRecordService) currentInstance.getBioService(ZimRecordService.class.getName());
            this.mExtParams.put(HummerConstants.ZIM_ID, str);
            ApSecurityService apSecurityService = (ApSecurityService) currentInstance.getBioService(ApSecurityService.class);
            String apDidToken = apSecurityService != null ? apSecurityService.getApDidToken() : "";
            if (TextUtils.isEmpty(apDidToken)) {
                apDidToken = ApSecurityService.getStaticApDidToken();
            }
            this.mExtParams.put("apdidToken", apDidToken);
            this.mZimRecordService.init(this.mUniqueID, this.mSequenceId, this.mRetryId, this.mExtParams);
            MonitorLogService monitorLogService = this.mMonitorLogService;
            if (monitorLogService != null) {
                monitorLogService.destroy();
                this.mMonitorLogService = null;
            }
        }
    }

    public void addExtProperty(String str, String str2) {
        this.mExtParams.put(str, str2);
        ZimRecordService zimRecordService = this.mZimRecordService;
        if (zimRecordService != null) {
            zimRecordService.addExtProperty(str, str2);
        }
    }

    public void addExtProperties(Map<String, String> map) {
        this.mExtParams.putAll(map);
        ZimRecordService zimRecordService = this.mZimRecordService;
        if (zimRecordService != null) {
            zimRecordService.addExtProperties(map);
        }
    }

    public boolean record(String str) {
        return record(str, (Map<String, String>) null);
    }

    public boolean record(String str, Map<String, String> map) {
        if (this.mRecords.containsKey(str)) {
            return record(this.mRecords.get(str), map);
        }
        return false;
    }

    public boolean record(MetaRecord metaRecord) {
        return record(metaRecord, (Map<String, String>) null);
    }

    public boolean record(MetaRecord metaRecord, Map<String, String> map) {
        JSONObject jSONObject;
        ZimRecordService zimRecordService = this.mZimRecordService;
        if (zimRecordService == null) {
            if (this.mMonitorLogService == null) {
                MonitorLogService monitorLogService = (MonitorLogService) BioServiceManager.getLocalService(this.mContext, MonitorLogService.class);
                this.mMonitorLogService = monitorLogService;
                if (monitorLogService == null) {
                    new IllegalStateException("mZimRecordService == null && mMonitorLogService == null");
                    return false;
                }
                monitorLogService.create(null);
            }
            VerifyBehavior verifyBehavior = new VerifyBehavior();
            verifyBehavior.setUserCaseID(metaRecord.getCaseID());
            String actionID = metaRecord.getActionID();
            verifyBehavior.setAppID(metaRecord.getAppID());
            verifyBehavior.setSeedID(metaRecord.getSeedID());
            verifyBehavior.setParam1(this.mUniqueID);
            StringBuilder sb = new StringBuilder();
            int i = this.mSequenceId + 1;
            this.mSequenceId = i;
            sb.append(i);
            verifyBehavior.setParam2(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mRetryId);
            verifyBehavior.setParam3(sb2.toString());
            verifyBehavior.setBizType(metaRecord.getBizType());
            verifyBehavior.setLoggerLevel(metaRecord.getPriority());
            verifyBehavior.addExtParam("base64", SummaryActivity.CHECKED);
            HashMap hashMap = new HashMap();
            for (String str : this.mExtParams.keySet()) {
                String str2 = this.mExtParams.get(str);
                if (ZimRecordService.EXCLUDE_EXT_PARAMS.contains(str)) {
                    verifyBehavior.addExtParam(str, str2);
                } else {
                    hashMap.put(str, str2);
                }
            }
            verifyBehavior.addExtParam("publicParam", Base64.encodeToString(new JSONObject(hashMap).toString().getBytes(), 2));
            if (map != null) {
                jSONObject = new JSONObject(map);
            } else {
                jSONObject = new JSONObject();
            }
            verifyBehavior.addExtParam("extParam", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            BehaviourIdEnum convert = BehaviourIdEnum.convert(actionID);
            MonitorLogService monitorLogService2 = this.mMonitorLogService;
            if (monitorLogService2 != null) {
                monitorLogService2.logBehavior(convert, verifyBehavior);
                return true;
            }
            return true;
        }
        return zimRecordService.write(metaRecord, map);
    }

    public void retry() {
        this.mRetryId++;
    }

    public void destroy() {
        this.mExtParams.clear();
        this.mZimRecordService = null;
        this.mRetryId = 0;
        this.mSequenceId = 0;
        MonitorLogService monitorLogService = this.mMonitorLogService;
        if (monitorLogService != null) {
            monitorLogService.destroy();
            this.mMonitorLogService = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        ZimRecordService zimRecordService = this.mZimRecordService;
        if (zimRecordService != null) {
            this.mRetryId = zimRecordService.getRetryID();
            this.mSequenceId = this.mZimRecordService.getSequenceID();
            this.mZimRecordService = null;
        }
    }

    public void setDestroyable(boolean z) {
        this.mDestroyable = z;
    }

    public boolean destroyable() {
        return this.mDestroyable;
    }
}
