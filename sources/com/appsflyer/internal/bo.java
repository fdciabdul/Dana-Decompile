package com.appsflyer.internal;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AFLogger;
import id.dana.data.Source;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class bo extends bt {
    public final Map<String, Object> AFInAppEventType;

    public bo(Runnable runnable) {
        super(Source.GOOGLE, runnable);
        this.AFInAppEventType = new HashMap();
    }

    private static boolean AFInAppEventType(Context context) {
        ae.values();
        if (ae.valueOf(ae.values(context), "appsFlyerCount", false) > 0) {
            AFLogger.AFInAppEventParameterName("Install referrer will not load, the counter > 1, ");
            return false;
        }
        try {
            Class.forName("com.android.installreferrer.api.InstallReferrerClient");
            if (aa.AFInAppEventParameterName(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.values("Install referrer is allowed");
                return true;
            }
            AFLogger.values("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb = new StringBuilder("Class ");
            sb.append("com.android.installreferrer.api.InstallReferrerClient");
            sb.append(" not found");
            AFLogger.AFInAppEventParameterName(sb.toString());
            return false;
        } catch (Throwable th) {
            AFLogger.AFInAppEventType("An error occurred while trying to verify manifest : com.android.installreferrer.api.InstallReferrerClient", th);
            return false;
        }
    }

    @Override // com.appsflyer.internal.bt
    public final void AFInAppEventParameterName(final Context context) {
        if (AFInAppEventType(context)) {
            AFInAppEventParameterName();
            try {
                final InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
                AFLogger.values("Connecting to Install Referrer Library...");
                build.startConnection(new InstallReferrerStateListener() { // from class: com.appsflyer.internal.bo.5
                    {
                        bo.this = this;
                    }

                    @Override // com.android.installreferrer.api.InstallReferrerStateListener
                    public final void onInstallReferrerSetupFinished(int i) {
                        bo.this.AFInAppEventType.put("code", String.valueOf(i));
                        bo.this.AFKeystoreWrapper.put("api_ver", Long.valueOf(aa.values(context, "com.android.vending")));
                        bo.this.AFKeystoreWrapper.put("api_ver_name", aa.AFKeystoreWrapper(context, "com.android.vending"));
                        if (i == -1) {
                            AFLogger.init("InstallReferrer SERVICE_DISCONNECTED");
                            bo.this.AFKeystoreWrapper.put("response", "SERVICE_DISCONNECTED");
                        } else if (i == 0) {
                            bo.this.AFKeystoreWrapper.put("response", "OK");
                            try {
                                AFLogger.values("InstallReferrer connected");
                                if (build.isReady()) {
                                    ReferrerDetails installReferrer = build.getInstallReferrer();
                                    String installReferrer2 = installReferrer.getInstallReferrer();
                                    if (installReferrer2 != null) {
                                        bo.this.AFInAppEventType.put("val", installReferrer2);
                                        bo.this.AFKeystoreWrapper.put("referrer", installReferrer2);
                                    }
                                    long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                                    bo.this.AFInAppEventType.put("clk", Long.toString(referrerClickTimestampSeconds));
                                    bo.this.AFKeystoreWrapper.put("click_ts", Long.valueOf(referrerClickTimestampSeconds));
                                    long installBeginTimestampSeconds = installReferrer.getInstallBeginTimestampSeconds();
                                    bo.this.AFInAppEventType.put("install", Long.toString(installBeginTimestampSeconds));
                                    bo.this.AFKeystoreWrapper.put("install_begin_ts", Long.valueOf(installBeginTimestampSeconds));
                                    HashMap hashMap = new HashMap();
                                    try {
                                        boolean googlePlayInstantParam = installReferrer.getGooglePlayInstantParam();
                                        bo.this.AFInAppEventType.put("instant", Boolean.valueOf(googlePlayInstantParam));
                                        hashMap.put("instant", Boolean.valueOf(googlePlayInstantParam));
                                    } catch (NoSuchMethodError unused) {
                                    }
                                    try {
                                        hashMap.put("click_server_ts", Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                                        hashMap.put("install_begin_server_ts", Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                                        hashMap.put("install_version", installReferrer.getInstallVersion());
                                    } catch (NoSuchMethodError unused2) {
                                    }
                                    if (!hashMap.isEmpty()) {
                                        bo.this.AFKeystoreWrapper.put("google_custom", hashMap);
                                    }
                                } else {
                                    AFLogger.init("ReferrerClient: InstallReferrer is not ready");
                                    bo.this.AFInAppEventType.put("err", "ReferrerClient: InstallReferrer is not ready");
                                }
                            } catch (Throwable th) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Failed to get install referrer: ");
                                sb.append(th.getMessage());
                                AFLogger.init(sb.toString());
                                bo.this.AFInAppEventType.put("err", th.getMessage());
                            }
                        } else if (i == 1) {
                            bo.this.AFKeystoreWrapper.put("response", "SERVICE_UNAVAILABLE");
                            AFLogger.init("InstallReferrer not supported");
                        } else if (i == 2) {
                            AFLogger.init("InstallReferrer FEATURE_NOT_SUPPORTED");
                            bo.this.AFKeystoreWrapper.put("response", "FEATURE_NOT_SUPPORTED");
                        } else if (i == 3) {
                            AFLogger.init("InstallReferrer DEVELOPER_ERROR");
                            bo.this.AFKeystoreWrapper.put("response", "DEVELOPER_ERROR");
                        } else {
                            AFLogger.init("responseCode not found.");
                        }
                        AFLogger.values("Install Referrer collected locally");
                        bo.this.AFKeystoreWrapper();
                        build.endConnection();
                    }

                    @Override // com.android.installreferrer.api.InstallReferrerStateListener
                    public final void onInstallReferrerServiceDisconnected() {
                        AFLogger.values("Install Referrer service disconnected");
                    }
                });
            } catch (Throwable th) {
                AFLogger.AFInAppEventType("referrerClient -> startConnection", th);
            }
        }
    }
}
