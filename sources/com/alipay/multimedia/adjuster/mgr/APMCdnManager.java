package com.alipay.multimedia.adjuster.mgr;

import android.text.TextUtils;
import com.alipay.multimedia.adjuster.adapter.APMOssAdapter;
import com.alipay.multimedia.adjuster.adapter.APMTfsAdapter;
import com.alipay.multimedia.adjuster.adapter.ICdnAdapter;
import com.alipay.multimedia.adjuster.api.data.IConfig;
import com.alipay.multimedia.adjuster.api.data.ITraceId;
import com.alipay.multimedia.adjuster.builder.UriBuilder;
import com.alipay.multimedia.adjuster.config.ConfigMgr;
import com.alipay.multimedia.adjuster.config.HostItem;
import com.alipay.multimedia.adjuster.data.APMImageInfo;
import com.alipay.multimedia.adjuster.data.UrlInfo;
import com.alipay.multimedia.adjuster.utils.AliCdnUtils;
import com.alipay.multimedia.adjuster.utils.Log;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class APMCdnManager {

    /* renamed from: a  reason: collision with root package name */
    private static APMCdnManager f7334a;
    private static final Log d = Log.getLogger("APMCdnManager");
    private APMOssAdapter b;
    private APMTfsAdapter c;

    private APMCdnManager() {
        this.b = null;
        this.c = null;
        this.b = new APMOssAdapter();
        this.c = new APMTfsAdapter();
    }

    public static APMCdnManager getIns() {
        if (f7334a == null) {
            synchronized (APMCdnManager.class) {
                if (f7334a == null) {
                    f7334a = new APMCdnManager();
                }
            }
        }
        return f7334a;
    }

    public void registerConfig(IConfig iConfig) {
        ConfigMgr.getInc().registerConfig(iConfig);
    }

    public void registerITraceId(ITraceId iTraceId) {
        UriBuilder.registerITraceId(iTraceId);
    }

    private ICdnAdapter a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.b.canExecAdapterForUrl(str)) {
            return this.b;
        }
        if (this.c.canExecAdapterForUrl(str)) {
            return this.c;
        }
        return null;
    }

    public boolean canExecAdapterForUrl(String str) {
        return a(str) != null;
    }

    private boolean a(String str, UrlInfo.Size size, APMImageInfo.CutType cutType, ICdnAdapter iCdnAdapter) {
        if (iCdnAdapter == null || iCdnAdapter.hasNotSupportCdnRule(str, size, cutType)) {
            return false;
        }
        return !str.contains("%");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[Catch: Exception -> 0x0193, TRY_ENTER, TryCatch #1 {Exception -> 0x0193, blocks: (B:5:0x000e, B:8:0x0015, B:10:0x002c, B:12:0x0034, B:19:0x005b, B:22:0x006b, B:24:0x007b, B:26:0x0089, B:28:0x009d, B:30:0x00ba, B:34:0x00cc, B:36:0x00d3, B:39:0x00dc, B:42:0x00e4, B:44:0x00e8, B:46:0x00ec, B:59:0x012d, B:61:0x014f, B:65:0x0159, B:67:0x016d, B:68:0x017c, B:48:0x00f8, B:50:0x00fc, B:52:0x0100, B:54:0x0107, B:56:0x010b, B:58:0x010f, B:13:0x0040, B:15:0x0048, B:17:0x0050), top: B:80:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[Catch: Exception -> 0x0193, TryCatch #1 {Exception -> 0x0193, blocks: (B:5:0x000e, B:8:0x0015, B:10:0x002c, B:12:0x0034, B:19:0x005b, B:22:0x006b, B:24:0x007b, B:26:0x0089, B:28:0x009d, B:30:0x00ba, B:34:0x00cc, B:36:0x00d3, B:39:0x00dc, B:42:0x00e4, B:44:0x00e8, B:46:0x00ec, B:59:0x012d, B:61:0x014f, B:65:0x0159, B:67:0x016d, B:68:0x017c, B:48:0x00f8, B:50:0x00fc, B:52:0x0100, B:54:0x0107, B:56:0x010b, B:58:0x010f, B:13:0x0040, B:15:0x0048, B:17:0x0050), top: B:80:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[Catch: Exception -> 0x0193, TryCatch #1 {Exception -> 0x0193, blocks: (B:5:0x000e, B:8:0x0015, B:10:0x002c, B:12:0x0034, B:19:0x005b, B:22:0x006b, B:24:0x007b, B:26:0x0089, B:28:0x009d, B:30:0x00ba, B:34:0x00cc, B:36:0x00d3, B:39:0x00dc, B:42:0x00e4, B:44:0x00e8, B:46:0x00ec, B:59:0x012d, B:61:0x014f, B:65:0x0159, B:67:0x016d, B:68:0x017c, B:48:0x00f8, B:50:0x00fc, B:52:0x0100, B:54:0x0107, B:56:0x010b, B:58:0x010f, B:13:0x0040, B:15:0x0048, B:17:0x0050), top: B:80:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d3 A[Catch: Exception -> 0x0193, TryCatch #1 {Exception -> 0x0193, blocks: (B:5:0x000e, B:8:0x0015, B:10:0x002c, B:12:0x0034, B:19:0x005b, B:22:0x006b, B:24:0x007b, B:26:0x0089, B:28:0x009d, B:30:0x00ba, B:34:0x00cc, B:36:0x00d3, B:39:0x00dc, B:42:0x00e4, B:44:0x00e8, B:46:0x00ec, B:59:0x012d, B:61:0x014f, B:65:0x0159, B:67:0x016d, B:68:0x017c, B:48:0x00f8, B:50:0x00fc, B:52:0x0100, B:54:0x0107, B:56:0x010b, B:58:0x010f, B:13:0x0040, B:15:0x0048, B:17:0x0050), top: B:80:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014f A[Catch: Exception -> 0x0193, TryCatch #1 {Exception -> 0x0193, blocks: (B:5:0x000e, B:8:0x0015, B:10:0x002c, B:12:0x0034, B:19:0x005b, B:22:0x006b, B:24:0x007b, B:26:0x0089, B:28:0x009d, B:30:0x00ba, B:34:0x00cc, B:36:0x00d3, B:39:0x00dc, B:42:0x00e4, B:44:0x00e8, B:46:0x00ec, B:59:0x012d, B:61:0x014f, B:65:0x0159, B:67:0x016d, B:68:0x017c, B:48:0x00f8, B:50:0x00fc, B:52:0x0100, B:54:0x0107, B:56:0x010b, B:58:0x010f, B:13:0x0040, B:15:0x0048, B:17:0x0050), top: B:80:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016d A[Catch: Exception -> 0x0193, TryCatch #1 {Exception -> 0x0193, blocks: (B:5:0x000e, B:8:0x0015, B:10:0x002c, B:12:0x0034, B:19:0x005b, B:22:0x006b, B:24:0x007b, B:26:0x0089, B:28:0x009d, B:30:0x00ba, B:34:0x00cc, B:36:0x00d3, B:39:0x00dc, B:42:0x00e4, B:44:0x00e8, B:46:0x00ec, B:59:0x012d, B:61:0x014f, B:65:0x0159, B:67:0x016d, B:68:0x017c, B:48:0x00f8, B:50:0x00fc, B:52:0x0100, B:54:0x0107, B:56:0x010b, B:58:0x010f, B:13:0x0040, B:15:0x0048, B:17:0x0050), top: B:80:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String parseImageUrlForAliCdn(java.lang.String r16, com.alipay.multimedia.adjuster.data.APMImageInfo.Format r17, com.alipay.multimedia.adjuster.data.UrlInfo.Size r18, com.alipay.multimedia.adjuster.data.UrlInfo.Size r19, com.alipay.multimedia.adjuster.data.APMImageInfo.CutType r20) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.multimedia.adjuster.mgr.APMCdnManager.parseImageUrlForAliCdn(java.lang.String, com.alipay.multimedia.adjuster.data.APMImageInfo$Format, com.alipay.multimedia.adjuster.data.UrlInfo$Size, com.alipay.multimedia.adjuster.data.UrlInfo$Size, com.alipay.multimedia.adjuster.data.APMImageInfo$CutType):java.lang.String");
    }

    public ArrayList<String> buildHighAvailabilityUrls(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            HostItem a2 = a(str, str2);
            if (a2 != null && a2.checkPercent()) {
                String buildAftsFilecCdnUrl = a2.checkGraySwitch(AliCdnUtils.generateRandom(0, 100)) ? UriBuilder.buildAftsFilecCdnUrl(str, str2, z) : str;
                String buildAftsFileMasterUrl = UriBuilder.buildAftsFileMasterUrl(str, str2, z);
                if (!TextUtils.isEmpty(buildAftsFilecCdnUrl)) {
                    arrayList.add(buildAftsFilecCdnUrl);
                }
                if (!TextUtils.isEmpty(buildAftsFileMasterUrl)) {
                    arrayList.add(buildAftsFileMasterUrl);
                }
            } else {
                arrayList.add(str);
            }
        } catch (Exception e) {
            arrayList.clear();
            arrayList.add(str);
            d.e(e, "buildHighAvailabilityUrls exp", new Object[0]);
        }
        return arrayList;
    }

    private HostItem a(String str, String str2) {
        return ConfigMgr.getInc().getCdnConfigItem().checkHighAvailability(str, str2);
    }
}
