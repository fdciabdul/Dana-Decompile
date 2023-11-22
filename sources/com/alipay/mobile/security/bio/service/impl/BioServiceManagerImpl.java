package com.alipay.mobile.security.bio.service.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipay.mobile.security.bio.common.record.impl.BioRecordServiceImpl;
import com.alipay.mobile.security.bio.common.record.impl.ZimRecordServiceImpl;
import com.alipay.mobile.security.bio.config.Constant;
import com.alipay.mobile.security.bio.exception.BioIllegalArgumentException;
import com.alipay.mobile.security.bio.module.MicroModule;
import com.alipay.mobile.security.bio.runtime.Runtime;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioAppManager;
import com.alipay.mobile.security.bio.service.BioExtService;
import com.alipay.mobile.security.bio.service.BioMetaInfo;
import com.alipay.mobile.security.bio.service.BioRecordService;
import com.alipay.mobile.security.bio.service.BioService;
import com.alipay.mobile.security.bio.service.BioServiceDescription;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioStoreService;
import com.alipay.mobile.security.bio.service.BioTaskService;
import com.alipay.mobile.security.bio.service.BioUploadService;
import com.alipay.mobile.security.bio.service.ZimRecordService;
import com.alipay.mobile.security.bio.service.local.LocalService;
import com.alipay.mobile.security.bio.utils.StringUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes7.dex */
public class BioServiceManagerImpl extends BioServiceManager {
    private static boolean isLoading;
    private Hashtable<String, BioAppDescription> mApps;
    private final HashMap<String, BioService> mExtServices;
    private HashMap<String, BioServiceDescription> mLazyLocalServices;
    private HashMap<String, LocalService> mLocalServices;
    private Hashtable<String, BioService> mSystemServices;

    public BioServiceManagerImpl(Context context, String str) {
        super(context, str);
        this.mSystemServices = new Hashtable<>();
        this.mExtServices = new HashMap<>();
        this.mApps = new Hashtable<>();
        this.mLocalServices = new HashMap<>();
        this.mLazyLocalServices = new HashMap<>();
        loadLocalServices(context);
        loadSystemServices();
        loadBioMetaInfos(this.mContext);
    }

    private void loadLocalServices(Context context) {
        Runtime.getLocalService(context, this.mLocalServices, this.mLazyLocalServices);
        Iterator<LocalService> it = this.mLocalServices.values().iterator();
        while (it.hasNext()) {
            it.next().create(this);
        }
    }

    private void loadSystemServices() {
        BioStoreServiceImpl bioStoreServiceImpl = new BioStoreServiceImpl();
        this.mSystemServices.put(BioStoreService.class.getName(), bioStoreServiceImpl);
        BioTaskServiceImpl bioTaskServiceImpl = new BioTaskServiceImpl(this.mContext);
        this.mSystemServices.put(BioTaskService.class.getName(), bioTaskServiceImpl);
        BioRecordServiceImpl bioRecordServiceImpl = new BioRecordServiceImpl();
        this.mSystemServices.put(BioRecordService.class.getName(), bioRecordServiceImpl);
        ZimRecordServiceImpl zimRecordServiceImpl = new ZimRecordServiceImpl();
        this.mSystemServices.put(ZimRecordService.class.getName(), zimRecordServiceImpl);
        BioUploadServiceImpl bioUploadServiceImpl = new BioUploadServiceImpl();
        this.mSystemServices.put(BioUploadService.class.getName(), bioUploadServiceImpl);
        BioAppManager bioAppManager = new BioAppManager();
        this.mSystemServices.put(BioAppManager.class.getName(), bioAppManager);
        bioStoreServiceImpl.create(this);
        bioTaskServiceImpl.create(this);
        bioRecordServiceImpl.create(this);
        zimRecordServiceImpl.create(this);
        bioUploadServiceImpl.create(this);
        bioAppManager.create(this);
    }

    private void loadBioMetaInfos(Context context) {
        for (BioMetaInfo bioMetaInfo : Runtime.getBioMetaInfoList()) {
            Iterator<BioServiceDescription> it = bioMetaInfo.getExtServices().iterator();
            while (it.hasNext()) {
                addExtService(it.next());
            }
            Iterator<BioAppDescription> it2 = bioMetaInfo.getApplications().iterator();
            while (it2.hasNext()) {
                addAppInfo(it2.next());
            }
        }
        synchronized (this.mExtServices) {
            Iterator<String> it3 = this.mExtServices.keySet().iterator();
            while (it3.hasNext()) {
                this.mExtServices.get(it3.next()).create(this);
            }
        }
    }

    private void addExtService(BioServiceDescription bioServiceDescription) {
        try {
            BioService bioService = (BioService) bioServiceDescription.getClazz().newInstance();
            synchronized (this.mExtServices) {
                this.mExtServices.put(bioServiceDescription.getInterfaceName(), bioService);
            }
        } catch (IllegalAccessException unused) {
            bioServiceDescription.getInterfaceName();
        } catch (InstantiationException unused2) {
            bioServiceDescription.getInterfaceName();
        } catch (Throwable unused3) {
            bioServiceDescription.getInterfaceName();
        }
    }

    private void addAppInfo(BioAppDescription bioAppDescription) {
        if (bioAppDescription != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("bio_type_");
            sb.append(bioAppDescription.getBioType());
            sb.append("_");
            sb.append(bioAppDescription.getBioAction());
            String obj = sb.toString();
            if (!this.mApps.containsKey(obj)) {
                this.mApps.put(obj, bioAppDescription);
            } else {
                this.mApps.get(obj);
            }
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioServiceManager
    public <T> T getBioService(Class<T> cls) {
        return (T) getBioService(cls.getName());
    }

    @Override // com.alipay.mobile.security.bio.service.BioServiceManager
    public <T> T getBioService(String str) {
        LocalService localService;
        try {
            localService = this.mLocalServices.get(str);
        } catch (Throwable unused) {
            localService = null;
        }
        if (localService == null) {
            try {
                BioServiceDescription remove = this.mLazyLocalServices.remove(str);
                if (remove != null) {
                    LocalService localService2 = (LocalService) remove.getClazz().newInstance();
                    localService2.create(this);
                    this.mLocalServices.put(remove.getInterfaceName(), localService2);
                    localService = localService2;
                }
            } catch (Throwable unused2) {
            }
        }
        if (localService == null) {
            try {
                localService = this.mSystemServices.get(str);
            } catch (Throwable unused3) {
            }
        }
        if (localService == null) {
            try {
                synchronized (this.mExtServices) {
                    localService = (T) this.mExtServices.get(str);
                }
            } catch (Throwable unused4) {
            }
        }
        return (T) localService;
    }

    @Override // com.alipay.mobile.security.bio.service.BioServiceManager
    public <T extends BioService> T putBioService(String str, Class<T> cls) {
        try {
            T newInstance = cls.newInstance();
            try {
                newInstance.create(this);
                this.mSystemServices.put(str, newInstance);
                return newInstance;
            } catch (Throwable unused) {
                return newInstance;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioServiceManager
    public void destroy() {
        HashMap<String, BioService> hashMap = this.mExtServices;
        if (hashMap != null) {
            synchronized (hashMap) {
                Iterator<String> it = this.mExtServices.keySet().iterator();
                while (it.hasNext()) {
                    this.mExtServices.get(it.next()).destroy();
                }
                this.mExtServices.clear();
            }
        }
        Hashtable<String, BioService> hashtable = this.mSystemServices;
        if (hashtable != null) {
            Iterator<String> it2 = hashtable.keySet().iterator();
            while (it2.hasNext()) {
                this.mSystemServices.get(it2.next()).destroy();
            }
            this.mSystemServices.clear();
        }
        HashMap<String, LocalService> hashMap2 = this.mLocalServices;
        if (hashMap2 != null) {
            Iterator<String> it3 = hashMap2.keySet().iterator();
            while (it3.hasNext()) {
                this.mLocalServices.get(it3.next()).destroy();
            }
            this.mLocalServices.clear();
        }
        HashMap<String, BioServiceDescription> hashMap3 = this.mLazyLocalServices;
        if (hashMap3 != null) {
            hashMap3.clear();
        }
        Hashtable<String, BioAppDescription> hashtable2 = this.mApps;
        if (hashtable2 != null) {
            hashtable2.clear();
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioServiceManager
    public String startBioActivity(BioAppDescription bioAppDescription, MicroModule microModule) {
        if (bioAppDescription != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("bio_type_");
            sb.append(bioAppDescription.getBioType());
            sb.append("_");
            sb.append(bioAppDescription.getBioAction());
            String obj = sb.toString();
            if (this.mApps.containsKey(obj)) {
                BioAppDescription bioAppDescription2 = this.mApps.get(obj);
                bioAppDescription.setAppName(bioAppDescription2.getAppName());
                bioAppDescription.setAppInterfaceName(bioAppDescription2.getAppInterfaceName());
                bioAppDescription.setAppType(bioAppDescription2.getAppType());
                startApp(bioAppDescription, microModule);
                return obj;
            }
        }
        return "";
    }

    private boolean isAuthInBackground(BioAppDescription bioAppDescription) {
        Map<String, String> extProperty = bioAppDescription.getExtProperty();
        return extProperty != null && !extProperty.isEmpty() && extProperty.containsKey(BioDetector.EXT_KEY_AUTH_IN_BACKGROUND) && Boolean.parseBoolean(extProperty.get(BioDetector.EXT_KEY_AUTH_IN_BACKGROUND));
    }

    private void startApp(BioAppDescription bioAppDescription, MicroModule microModule) {
        String appInterfaceName = bioAppDescription.getAppInterfaceName();
        if (StringUtil.isNullorEmpty(appInterfaceName)) {
            throw new BioIllegalArgumentException();
        }
        Intent intent = new Intent();
        intent.setClassName(this.mContext, appInterfaceName);
        intent.setFlags(isAuthInBackground(bioAppDescription) ? 536903680 : 536870912);
        intent.putExtra(Constant.BIOLOGY_INTENT_ACTION_INFO, bioAppDescription.getTag());
        boolean z = false;
        if (Runtime.isRunningOnQuinox(this.mContext)) {
            Map<String, String> extProperty = bioAppDescription.getExtProperty();
            if ((extProperty == null || extProperty.isEmpty() || !extProperty.containsKey(BioDetector.EXT_KEY_USE_CONTEXT)) ? false : Boolean.parseBoolean(extProperty.remove(BioDetector.EXT_KEY_USE_CONTEXT))) {
                if (this.mContext instanceof Activity) {
                    intent.setFlags(0);
                } else {
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                this.mContext.startActivity(intent);
                z = true;
            } else {
                try {
                    z = Runtime.startActivity(intent);
                } catch (Throwable unused) {
                }
            }
        }
        if (z) {
            return;
        }
        if (bioAppDescription.getAppType() == 1) {
            this.mContext.startService(intent);
        } else {
            this.mContext.startActivity(intent);
        }
    }

    @Override // com.alipay.mobile.security.bio.service.BioServiceManager
    public int preLoad() {
        if (isLoading) {
            return 0;
        }
        isLoading = true;
        new Thread(new Runnable() { // from class: com.alipay.mobile.security.bio.service.impl.BioServiceManagerImpl.1
            {
                BioServiceManagerImpl.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Collection<BioService> values;
                synchronized (BioServiceManagerImpl.this.mExtServices) {
                    values = BioServiceManagerImpl.this.mExtServices.values();
                }
                for (BioService bioService : values) {
                    if (bioService instanceof BioExtService) {
                        BioExtService bioExtService = (BioExtService) bioService;
                        if (!bioExtService.isPreparing()) {
                            bioExtService.loadingResource();
                        }
                    }
                }
                boolean unused = BioServiceManagerImpl.isLoading = false;
            }
        }, "loadingResource").start();
        return 1;
    }
}
