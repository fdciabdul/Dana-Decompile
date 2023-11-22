package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static ICrashClient f7719a = null;
    private static int b = 3;
    private static volatile List<ValueCallback<Bundle>> c;
    private static volatile List<ValueCallback<Bundle>> d;
    private static volatile List<ValueCallback<Bundle>> e;
    private static Object f = new Object();

    public static void a(ICrashClient iCrashClient) {
        f7719a = iCrashClient;
    }

    public static void a(String str, String str2) {
        if (com.uc.crashsdk.a.h.a(str)) {
            com.uc.crashsdk.a.c.a("crashsdk", "onLogGenerated file name is null!");
            return;
        }
        if (f7719a != null) {
            try {
                f7719a.onLogGenerated(new File(str), str2);
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
        }
        if (c != null) {
            synchronized (c) {
                for (ValueCallback<Bundle> valueCallback : c) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        bundle.putString("logType", str2);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.a.a(th2, false);
                    }
                }
            }
        }
    }

    public static File a(File file) {
        ICrashClient iCrashClient = f7719a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
        }
        return file;
    }

    public static void a(boolean z) {
        ICrashClient iCrashClient = f7719a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (Throwable th) {
                com.uc.crashsdk.a.a.a(th, false);
            }
        }
        if (d != null) {
            synchronized (d) {
                for (ValueCallback<Bundle> valueCallback : d) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isJava", z);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.a.a(th2, false);
                    }
                }
            }
        }
    }

    public static boolean a(String str, int i, int i2) {
        ICrashClient iCrashClient = f7719a;
        boolean onAddCrashStats = iCrashClient != null ? iCrashClient.onAddCrashStats(str, i, i2) : false;
        if (e != null) {
            synchronized (e) {
                for (ValueCallback<Bundle> valueCallback : e) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("processName", str);
                        bundle.putInt("key", i);
                        bundle.putInt("count", i2);
                        valueCallback.onReceiveValue(bundle);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.a.a(th, false);
                    }
                }
            }
        }
        return onAddCrashStats;
    }

    public static String a(String str) {
        ICrashClient iCrashClient = f7719a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str) : "";
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (c == null) {
            synchronized (f) {
                if (c == null) {
                    c = new ArrayList();
                }
            }
        }
        synchronized (c) {
            if (c.size() >= b) {
                return false;
            }
            c.add(valueCallback);
            return true;
        }
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (d == null) {
            synchronized (f) {
                if (d == null) {
                    d = new ArrayList();
                }
            }
        }
        synchronized (d) {
            if (d.size() >= b) {
                return false;
            }
            d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (e == null) {
            synchronized (f) {
                if (e == null) {
                    e = new ArrayList();
                }
            }
        }
        synchronized (e) {
            if (e.size() >= b) {
                return false;
            }
            e.add(valueCallback);
            return true;
        }
    }
}
