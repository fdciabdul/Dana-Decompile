package com.alipay.iap.android.f2fpay.util;

import android.os.SystemClock;
import com.alipay.iap.android.f2fpay.logger.BehaviorLogger;
import com.iap.ac.android.biz.common.utils.log.LogConstants;

/* loaded from: classes3.dex */
public class MonitorUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6971a = true;
    private static boolean b = true;
    private static boolean c = true;
    private static boolean d = true;
    private static boolean e = true;
    private static boolean f = true;
    private static long g;
    private static long h;

    public static void checkOpen(String str, String str2, long j, boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.CHECK_OPEN).addParams(BehaviorLogger.Key.ERROR_MESSAGE, str2).addParams(BehaviorLogger.Key.ERROR_CODE, str).addParams(BehaviorLogger.Key.TIME_COST, Long.valueOf(j)).addParams("Result", z ? "T" : LogConstants.RESULT_FALSE).event();
    }

    public static void checkOpenState(boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.CHECK_OPEN_STATE).addParams(BehaviorLogger.Key.OPEN_FLAG, Boolean.valueOf(z)).event();
        if (z) {
            funnelSwitchOn();
            funnelInitOtp();
        }
    }

    public static void funnelGenCode() {
        if (e) {
            e = false;
            BehaviorLogger.newLogger(BehaviorLogger.Event.FUNNEL_GEN_CODE).addParams(BehaviorLogger.Key.TIME_INTERVAL_FROM_START_TO_GEN_CODE, Long.valueOf(SystemClock.elapsedRealtime() - h)).event();
        }
    }

    public static void funnelInitClient() {
        if (f6971a) {
            f6971a = false;
            g = SystemClock.elapsedRealtime();
            BehaviorLogger.newLogger(BehaviorLogger.Event.FUNNEL_INIT_CLIENT).event();
        }
    }

    public static void funnelInitOtp() {
        if (c) {
            c = false;
            BehaviorLogger.newLogger(BehaviorLogger.Event.FUNNEL_INIT_OTP).addParams(BehaviorLogger.Key.TIME_INTERVAL_FROM_START_TO_INIT_OTP, Long.valueOf(SystemClock.elapsedRealtime() - h)).event();
        }
    }

    public static void funnelStart() {
        if (b) {
            b = false;
            h = SystemClock.elapsedRealtime();
            BehaviorLogger.newLogger(BehaviorLogger.Event.FUNNEL_START).addParams(BehaviorLogger.Key.TIME_INTERVAL_FROM_INIT_CLIENT_TO_START, Long.valueOf(h - g)).event();
        }
    }

    public static void funnelSwitchOn() {
        if (d) {
            d = false;
            BehaviorLogger.newLogger(BehaviorLogger.Event.FUNNEL_SWITCH_ON).addParams(BehaviorLogger.Key.TIME_INTERVAL_FROM_START_TO_SWITCH_ON, Long.valueOf(SystemClock.elapsedRealtime() - h)).event();
        }
    }

    public static void funnelUniResult() {
        if (f) {
            f = false;
            BehaviorLogger.newLogger(BehaviorLogger.Event.FUNNEL_UNI_RESULT).addParams(BehaviorLogger.Key.TIME_INTERVAL_FROM_START_TO_UNI_RESULT, Long.valueOf(SystemClock.elapsedRealtime() - h)).event();
        }
    }

    public static void generatePaymentCode(String str, String str2, long j, boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.GENERATE_PAYMENT_CODE).addParams(BehaviorLogger.Key.ERROR_CODE, str).addParams(BehaviorLogger.Key.ERROR_MESSAGE, str2).addParams(BehaviorLogger.Key.TIME_COST, Long.valueOf(j)).addParams("Result", z ? "T" : LogConstants.RESULT_FALSE).event();
    }

    public static void initializeOtp(String str, String str2, long j, boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.INITIALIZE_OTP_SEED).addParams(BehaviorLogger.Key.ERROR_MESSAGE, str2).addParams(BehaviorLogger.Key.ERROR_CODE, str).addParams(BehaviorLogger.Key.TIME_COST, Long.valueOf(j)).addParams("Result", z ? "T" : LogConstants.RESULT_FALSE).event();
    }

    public static void otpSeedExpired(long j) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.INITIALIZE_OTP_SEED_EXPIRED).addParams(BehaviorLogger.Key.OTP_SEED_EXPIRED_TIME, Long.valueOf(j)).event();
    }

    public static void resultHandle(String str, String str2, long j, boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.HANDLE_RESULT).addParams(BehaviorLogger.Key.ERROR_CODE, str).addParams(BehaviorLogger.Key.ERROR_MESSAGE, str2).addParams(BehaviorLogger.Key.TIME_COST, Long.valueOf(j)).addParams("Result", z ? "T" : LogConstants.RESULT_FALSE).event();
    }

    public static void resultHandleFrom(String str) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.HANDLE_PAYMENT_RESULT_FROM).addParams(BehaviorLogger.Key.PAYMENT_RESULT_FROM, str).event();
    }

    public static void switchOff(String str, String str2, long j, boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.SWITCH_OFF).addParams(BehaviorLogger.Key.ERROR_CODE, str).addParams(BehaviorLogger.Key.ERROR_MESSAGE, str2).addParams(BehaviorLogger.Key.TIME_COST, Long.valueOf(j)).addParams("Result", z ? "T" : LogConstants.RESULT_FALSE).event();
    }

    public static void switchOn(String str, String str2, long j, boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.SWITCH_ON).addParams(BehaviorLogger.Key.ERROR_MESSAGE, str2).addParams(BehaviorLogger.Key.ERROR_CODE, str).addParams(BehaviorLogger.Key.TIME_COST, Long.valueOf(j)).addParams("Result", z ? "T" : LogConstants.RESULT_FALSE).event();
    }

    public static void syncInitOtp(boolean z) {
        BehaviorLogger.newLogger(BehaviorLogger.Event.SYNC_INIT_OTP).addParams(BehaviorLogger.Key.SYNC_INIT_STATUS, Boolean.valueOf(z)).event();
    }
}
