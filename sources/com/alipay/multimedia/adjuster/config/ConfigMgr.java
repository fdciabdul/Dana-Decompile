package com.alipay.multimedia.adjuster.config;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alipay.multimedia.adjuster.api.data.IConfig;
import com.alipay.multimedia.adjuster.utils.AliCdnUtils;
import com.alipay.multimedia.adjuster.utils.Log;

/* loaded from: classes7.dex */
public class ConfigMgr {

    /* renamed from: a  reason: collision with root package name */
    private static final Log f7333a = Log.getLogger("ConfigMgr");
    static ConfigMgr mInstance;
    private CdnConfigItem b = new CdnConfigItem();
    private IConfig c;

    private ConfigMgr() {
    }

    public static ConfigMgr getInc() {
        if (mInstance == null) {
            synchronized (ConfigMgr.class) {
                if (mInstance == null) {
                    mInstance = new ConfigMgr();
                }
            }
        }
        return mInstance;
    }

    public void registerConfig(IConfig iConfig) {
        this.c = iConfig;
    }

    public CdnConfigItem getCdnConfigItem() {
        CdnConfigItem cdnConfigItem;
        synchronized (this.b) {
            if (this.b.needUpdate()) {
                AliCdnUtils.getSingleExecutor().execute(new Runnable() { // from class: com.alipay.multimedia.adjuster.config.ConfigMgr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ConfigMgr.this.b) {
                            if (ConfigMgr.this.c != null) {
                                String config = ConfigMgr.this.c.getConfig(ConfigConst.CONFIG_KEY_CDN);
                                if (!TextUtils.isEmpty(config)) {
                                    try {
                                        ConfigMgr.this.b = (CdnConfigItem) JSON.parseObject(config, CdnConfigItem.class);
                                    } catch (Throwable th) {
                                        Log log = ConfigMgr.f7333a;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("getCdnConfigItem update error: ");
                                        sb.append(config);
                                        sb.append(", e: ");
                                        sb.append(th.toString());
                                        log.d(sb.toString(), new Object[0]);
                                    }
                                }
                            }
                            ConfigMgr.this.b.updateTime();
                            Log log2 = ConfigMgr.f7333a;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("getCdnConfigItem config: ");
                            sb2.append(ConfigMgr.this.b);
                            log2.d(sb2.toString(), new Object[0]);
                        }
                    }
                });
            }
            cdnConfigItem = this.b;
        }
        return cdnConfigItem;
    }
}
