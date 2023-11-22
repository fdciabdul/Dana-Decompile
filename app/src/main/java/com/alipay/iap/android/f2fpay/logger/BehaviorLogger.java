package com.alipay.iap.android.f2fpay.logger;

import com.alipay.iap.android.common.log.MonitorWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BehaviorLogger {
    private static final String BizType = "F2FPay";
    private String mEventId;
    private Map<String, String> mParams;

    /* loaded from: classes6.dex */
    public static class Event {
        public static final String CHECK_OPEN = "F2FPayCheckOpen";
        public static final String CHECK_OPEN_STATE = "F2FPayCheckOpenState";
        public static final String FAILED_TO_CLOSE_F2FPAY = "F2FPayFailedToCloseF2fpay";
        public static final String FAILED_TO_DELETE_OTP_SEED = "F2FPayFailedToDeleteOtpSeed";
        public static final String FAILED_TO_DESTROY = "F2FPayFailedToDestroy";
        public static final String FAILED_TO_REFRESH_PAYMENT_CODE = "F2FPayFailedToRefreshPaymentCode";
        public static final String FAILED_TO_START_F2FPAY = "F2FPayFailedToStartF2fpay";
        public static final String FAILED_TO_START_REFRESH_TASK = "F2FPayFailedToStartRefreshTask";
        public static final String FAILED_TO_STOP_REFRESH_TASK = "F2FPayFailedToStopRefreshTask";
        public static final String FUNNEL_GEN_CODE = "F2FPayFunnelGenCode";
        public static final String FUNNEL_INIT_CLIENT = "F2FPayFunnelInitClient";
        public static final String FUNNEL_INIT_OTP = "F2FPayFunnelInitOtp";
        public static final String FUNNEL_START = "F2FPayFunnelStart";
        public static final String FUNNEL_SWITCH_ON = "F2FPayFunnelSwitchOn";
        public static final String FUNNEL_UNI_RESULT = "F2FPayFunnelUniResult";
        public static final String GENERATE_PAYMENT_CODE = "F2FPayGeneratePaymentCode";
        public static final String HANDLE_PAYMENT_RESULT_FROM = "F2FPayPaymentResultFrom";
        public static final String HANDLE_RESULT = "F2FPayHandleResult";
        public static final String INITIALIZE_OTP_SEED = "F2FPayInitializeOtpSeed";
        public static final String INITIALIZE_OTP_SEED_EXPIRED = "F2FPayInitializeOtpSeedExpired";
        public static final String SWITCH_OFF = "F2FPaySwitchOff";
        public static final String SWITCH_ON = "F2FPaySwitchOn";
        public static final String SYNC_INIT_OTP = "F2FPaySyncInitOtp";
    }

    /* loaded from: classes6.dex */
    public static class Key {
        public static final String ERROR_CODE = "ErrorCode";
        public static final String ERROR_MESSAGE = "ErrorMessage";
        public static final String OPEN_FLAG = "OpenFlag";
        public static final String OTP_SEED_EXPIRED_TIME = "OtpSeedExpiredTime";
        public static final String PAYMENT_RESULT_FROM = "PaymentResultFrom";
        public static final String RESULT = "Result";
        public static final String SYNC_INIT_STATUS = "SyncInitStatus";
        public static final String TIME_COST = "TimeCost";
        public static final String TIME_INTERVAL_FROM_INIT_CLIENT_TO_START = "TimeIntervalFromInitClientToStart";
        public static final String TIME_INTERVAL_FROM_START_TO_GEN_CODE = "TimeIntervalFromStartToGenCode";
        public static final String TIME_INTERVAL_FROM_START_TO_INIT_OTP = "TimeIntervalFromStartToInitOtp";
        public static final String TIME_INTERVAL_FROM_START_TO_SWITCH_ON = "TimeIntervalFromStartToSwitchOn";
        public static final String TIME_INTERVAL_FROM_START_TO_UNI_RESULT = "TimeIntervalFromStartToUniResult";
    }

    /* loaded from: classes6.dex */
    public static class errorCode {
        public static final String DEVICE_OFFLINE = "ERROR_DEVICE_OFFLINE";
        public static final String HANDLE_PAYMENT_RESULT_ALREADY_HANDLED = "ERROR_HANDLE_PAYMENT_RESULT_ALREADY_HANDLED";
        public static final String HANDLE_PAYMENT_RESULT_EXCEPTION = "ERROR_HANDLE_PAYMENT_RESULT_EXCEPTION";
        public static final String HANDLE_PAYMENT_RESULT_FAILED_CLASS_NOT_MATCH = "ERROR_HANDLE_PAYMENT_RESULT_FAILED_CLASS_NOT_MATCH";
        public static final String HANDLE_PAYMENT_RESULT_FAILED_DECODE_FAILED = "ERROR_HANDLE_PAYMENT_RESULT_FAILED_DECODE_FAILED";
        public static final String HANDLE_PAYMENT_RESULT_FAILED_ORIGINAL_INFO_NULL = "ERROR_HANDLE_PAYMENT_RESULT_FAILED_ORIGINAL_INFO_NULL";
        public static final String HANDLE_PAYMENT_RESULT_FAILED_USER_ID_NOT_MATCH = "ERROR_HANDLE_PAYMENT_RESULT_FAILED_USER_ID_NOT_MATCH";
        public static final String HANDLE_PAYMENT_RESULT_SUCCESS = "SUCCESS_HANDLE_PAYMENT_RESULT_SUCCESS";
        public static final String IDENTITY_EMPTY = "ERROR_IDENTITY_NULL";
        public static final String INITIALIZE_OTP_SUCCESS_LOCAL_VALID = "SUCCESS_INITIALIZE_OTP_LOCAL_VALID";
        public static final String NO_USER_PERMISSION = "ERROR_NO_USER_PERMISSION";
        public static final String OPEN_CHECK_OPEN_SUCCESS_RPC_RESULT_CLOSE = "SUCCESS_OPEN_CHECK_SUCCESS_RPC_RESULT_CLOSE";
        public static final String OPEN_CHECK_OPEN_SUCCESS_RPC_RESULT_OPEN = "SUCCESS_OPEN_CHECK_SUCCESS_RPC_RESULT_OPEN";
        public static final String PAYMENT_CODE_GENERATE_FAILED_F2FPAY_CLOSE = "ERROR_PAYMENT_CODE_GENERATE_FAILED_F2FPAY_CLOSE";
        public static final String PAYMENT_CODE_GENERATE_FAILED_PAYMENT_CODE_EMPTY = "ERROR_PAYMENT_CODE_GENERATE_FAILED_PAYMENT_CODE_EMPTY";
        public static final String PAYMENT_CODE_GENERATE_FAILED_RUNNABLE_EXCEPTION = "ERROR_PAYMENT_CODE_GENERATE_FAILED_RUNNABLE_EXCEPTION";
        public static final String PAYMENT_CODE_GENERATE_SUCCESS = "SUCCESS_PAYMENT_CODE_GENERATE_SUCCESS";
        public static final String PAYMENT_CODE_NO_OTP_SEED = "ERROR_NO_OTP_SEED";
        public static final String RPC_RESULT_EXCEPTION = "ERROR_RPC_RESULT_EXCEPTION";
        public static final String RPC_RESULT_FAILED = "ERROR_RPC_RESULT_FAILED";
        public static final String RPC_RESULT_SUCCESS_ZERO = "ERROR_RPC_RESULT_SUCCESS_ZERO";
        public static final String RPC_SUCCESS = "SUCCESS_RPC_SUCCESS";
        public static final String TERMINAL_ID_EMPTY = "ERROR_TERMINAL_ID_EMPTY";
    }

    private BehaviorLogger(String str) {
        this.mEventId = str;
    }

    public static void event(String str) {
        newLogger(str).event();
    }

    public static BehaviorLogger newLogger() {
        return new BehaviorLogger(null);
    }

    public static BehaviorLogger newLogger(String str) {
        return new BehaviorLogger(str);
    }

    public BehaviorLogger addAll(Map<String, String> map) {
        if (this.mParams == null) {
            this.mParams = new HashMap();
        }
        this.mParams.putAll(map);
        return this;
    }

    public BehaviorLogger addParams(String str, Object obj) {
        return addParams(str, String.valueOf(obj));
    }

    public BehaviorLogger addParams(String str, String str2) {
        if (this.mParams == null) {
            this.mParams = new HashMap();
        }
        this.mParams.put(str, str2);
        return this;
    }

    public void event() {
        MonitorWrapper.behaviour(this.mEventId, this.mParams);
    }

    public BehaviorLogger setEventId(String str) {
        this.mEventId = str;
        return this;
    }
}
