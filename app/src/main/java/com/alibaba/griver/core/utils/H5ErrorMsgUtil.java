package com.alibaba.griver.core.utils;

import id.dana.wallet_v3.identity.presenter.PersonalPresenter;

/* loaded from: classes6.dex */
public class H5ErrorMsgUtil {
    public static final int H5_NETWORK_AUTH_ERROR = 8;
    public static final int H5_NETWORK_CANCEL_ERROR = 13;
    public static final int H5_NETWORK_CONNECTION_EXCEPTION = 3;
    public static final int H5_NETWORK_DNS_ERROR = 9;
    public static final int H5_NETWORK_IO_EXCEPTION = 6;
    public static final int H5_NETWORK_SCHEDULE_ERROR = 7;
    public static final int H5_NETWORK_SERVER_EXCEPTION = 5;
    public static final int H5_NETWORK_SOCKET_EXCEPTION = 4;
    public static final int H5_NETWORK_SSL_EXCEPTION = 2;
    public static final int H5_NETWORK_TRAFIC_BEYOND_LIMIT = 11;
    public static final int H5_NETWORK_UNAVAILABLE = 1;
    public static final int H5_NETWORK_UNKNOWN_ERROR = 0;
    public static final int H5_UC_NETWORK_UNAVAILABLE = -80;
    public static final int H5_URL_ERROR = 10;

    public static String getErrorMsg(int i, boolean z) {
        if (i == -6 || i == -7 || i == -80 || i == 1 || i == -8 || i == 3 || i == 4) {
            return z ? "Please check the network connection" : "Not Connected To Internet";
        }
        if (i == 400 || i == 503 || i == 401 || i == 403 || i == 404 || i == 409 || i == 410 || i == 411 || i == 412 || i == 500 || i == 501 || i == 502 || i == -9 || i == -2 || i == 9 || i == -4 || i == -12 || i == -5 || i == -10 || i == -11 || i == 10 || i == 8 || i == 7 || i == -1 || i == -3 || i == -13 || i == -14 || i == -15 || i == 0 || i == 5 || i == 6 || i == 11 || i == 13 || i == 2) {
            if (!z) {
                return "Failed to open this page";
            }
        } else if (!z) {
            return PersonalPresenter.UNKNOWN_ERROR;
        }
        return "Please refresh later";
    }
}
