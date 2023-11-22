package com.alibaba.griver.api.constants;

import android.util.Pair;

/* loaded from: classes3.dex */
public interface GriverErrors {
    public static final int API_IS_BANNED = 10100;
    public static final String ERROR_APPID_EXCEPTION = "10001";
    public static final String ERROR_APPX_VERSION_TOO_LOW = "10012";
    public static final String ERROR_APP_CLOSED_ABNORMAL = "20000";
    public static final String ERROR_APP_EMBEDDED_URL_EMPTY = "10015";
    public static final String ERROR_APP_EXPIRES = "10005";
    public static final String ERROR_APP_PACKAGE_URL_EMPTY = "10014";
    public static final String ERROR_APP_SUSPENDED = "1002";
    public static final String ERROR_DOWNLOAD_FAILED = "10009";
    public static final String ERROR_DYNAMIC_RESOURCE_LOAD_FAILED = "10030";
    public static final String ERROR_INCREMENTAL_UPDATE = "10007";
    public static final String ERROR_LAST_LAUNCH_NOT_END = "10004";
    public static final String ERROR_LAUNCH_INTERCEPTED = "10011";
    public static final String ERROR_NO_APP_INFO = "10003";
    public static final String ERROR_NO_LOCAL_RESOURCE = "10008";
    public static final String ERROR_PREPARE_TIMEOUT = "10010";
    public static final String ERROR_REMOVED_CODE = "1001";
    public static final String ERROR_UNKNOWN = "10000";
    public static final String ERROR_UNZIP_FAILED = "10002";
    public static final String ERROR_VERIFY_APP = "10006";
    public static final int INITIALIZE_AUTHENTICATION_FAILED = 90001;
    public static final int INITIALIZE_EXCEPTION = 90000;
    public static final int INVALID_PARAMETER = 2;
    public static final int NETWORK_ERROR = 10104;
    public static final int UNKNOWN_ERROR = 3;
    public static final int INITIALIZE_ERROR_PARAM = 90002;
    public static final Pair<Integer, String> GRV_CONTAINER_API_ERROR_PARAM = new Pair<>(Integer.valueOf((int) INITIALIZE_ERROR_PARAM), "GRV_CONTAINER_API_ERROR_PARAM");
    public static final int GRV_CONTAINER_NOT_INITIALIZED_CODE = 90003;
    public static final Pair<Integer, String> GRV_CONTAINER_NOT_INITIALIZED = new Pair<>(Integer.valueOf((int) GRV_CONTAINER_NOT_INITIALIZED_CODE), "GRV_CONTAINER_NOT_INITIALIZED");
    public static final Pair<Integer, String> GRV_CONTAINER_NOT_UNKNOWN = new Pair<>(Integer.valueOf(Integer.parseInt("10000")), "GRV_CONTAINER_ERROR_UNKNOWN");
}
