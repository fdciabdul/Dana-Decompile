package com.alipay.mobile.security.bio.service;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.exception.InvalidCallException;
import com.alipay.mobile.security.bio.module.MicroModule;
import com.alipay.mobile.security.bio.runtime.Runtime;
import com.alipay.mobile.security.bio.service.impl.BioServiceManagerImpl;
import com.alipay.mobile.security.bio.service.local.LocalService;
import com.alipay.mobile.security.bio.service.local.monitorlog.MonitorLogService;
import com.alipay.mobile.security.bio.workspace.Env;

/* loaded from: classes3.dex */
public abstract class BioServiceManager {
    private static Env ENV = Env.ONLINE;
    public static final String TAG = "BioServiceManager";
    protected static BioServiceManager sInstance;
    protected final Context mContext;
    private final String mZimId;

    protected abstract void destroy();

    public abstract <T> T getBioService(Class<T> cls);

    public abstract <T> T getBioService(String str);

    public abstract int preLoad();

    public abstract <T extends BioService> T putBioService(String str, Class<T> cls);

    public abstract String startBioActivity(BioAppDescription bioAppDescription, MicroModule microModule);

    public static Env getEnv() {
        return ENV;
    }

    public static void setEnv(Env env) {
        if (ENV != env) {
            ENV = env;
            String str = env.name;
        }
    }

    public BioServiceManager(Context context, String str) {
        if (context == null) {
            throw new BioIllegalArgumentException();
        }
        this.mContext = context;
        this.mZimId = str;
    }

    @Deprecated
    public static void createInstance(Context context) {
        synchronized (BioServiceManager.class) {
            if (sInstance == null) {
                sInstance = new BioServiceManagerImpl(context, null);
            } else {
                new InvalidCallException("BioServiceManager.createInstance(Context) : null != sInstance");
            }
        }
    }

    public static void createInstance(Context context, String str) {
        synchronized (BioServiceManager.class) {
            BioServiceManager bioServiceManager = sInstance;
            if (bioServiceManager == null) {
                sInstance = new BioServiceManagerImpl(context, str);
            } else if (TextUtils.isEmpty(bioServiceManager.mZimId)) {
                new InvalidCallException("BioServiceManager already exist with zimId=null");
                sInstance.destroy();
                sInstance = new BioServiceManagerImpl(context, str);
            } else if (!TextUtils.equals(sInstance.mZimId, str)) {
                MonitorLogService monitorLogService = (MonitorLogService) sInstance.getBioService(MonitorLogService.class);
                if (monitorLogService != null) {
                    monitorLogService.trigUpload();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("BioServiceManager already exist with zimId=");
                sb.append(sInstance.mZimId);
                new InvalidCallException(sb.toString());
                Process.killProcess(Process.myPid());
            }
        }
    }

    public static BioServiceManager getCurrentInstance() {
        return sInstance;
    }

    public static void destroyInstance() {
        BioServiceManager bioServiceManager = sInstance;
        if (bioServiceManager != null) {
            bioServiceManager.destroy();
            String str = sInstance.mZimId;
            sInstance = null;
        }
    }

    public Context getBioApplicationContext() {
        return this.mContext;
    }

    public static <T extends LocalService> T getLocalService(Context context, Class<T> cls) {
        return (T) getLocalService(context, Runtime.getBioServiceDescriptionByInterface(context, cls.getName()));
    }

    public static <T extends LocalService> T getLocalService(Context context, BioServiceDescription bioServiceDescription) {
        T t;
        Class<?> clazz;
        if (bioServiceDescription != null && (clazz = bioServiceDescription.getClazz()) != null) {
            try {
                t = (T) clazz.newInstance();
            } catch (Throwable unused) {
            }
            if (t != null && context != null) {
                t.setContext(context.getApplicationContext());
                t.create(null);
            }
            return t;
        }
        t = null;
        if (t != null) {
            t.setContext(context.getApplicationContext());
            t.create(null);
        }
        return t;
    }
}
