package com.alipay.mobile.security.bio.runtime;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.security.bio.runtime.FrameworkDesc;
import com.alipay.mobile.security.bio.service.BioMetaInfo;
import com.alipay.mobile.security.bio.service.BioServiceDescription;
import com.alipay.mobile.security.bio.service.local.NotImplementedException;
import com.alipay.mobile.security.bio.utils.FileUtil;
import com.alipay.mobile.security.bio.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ModuleDesc {
    @JSONField(name = "local_services")
    public List<LocalServiceDesc> localServiceDescs;
    public List<BioMetaInfo> mBioMetaInfoList;
    public List<BioServiceDescription> mBioServiceDescription;
    public String mBundleName;
    @JSONField(name = "meta_info")
    public List<String> metaInfoList;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ModuleDesc{metaInfoList=");
        sb.append(StringUtil.collection2String(this.metaInfoList));
        sb.append(", localServiceDescs=");
        sb.append(StringUtil.collection2String(this.localServiceDescs));
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class LocalServiceDesc {
        @JSONField(name = "class")
        public String className;
        @JSONField(name = "interface")
        public String interfaceName;
        @JSONField(name = "essential")
        public boolean isEssential = true;
        @JSONField(name = "lazy")
        public boolean isLazy = true;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("LocalServiceDesc{interfaceName='");
            sb.append(this.interfaceName);
            sb.append('\'');
            sb.append(", isEssential=");
            sb.append(this.isEssential);
            sb.append(", className='");
            sb.append(this.className);
            sb.append('\'');
            sb.append(", isLazy=");
            sb.append(this.isLazy);
            sb.append('}');
            return sb.toString();
        }
    }

    public static ModuleDesc create(Context context, boolean z, FrameworkDesc.ConfigDesc configDesc) {
        byte[] assetsData;
        Resources resourcesByBundleName;
        byte[] assetsData2;
        ModuleDesc moduleDesc = null;
        String str = (TextUtils.isEmpty(configDesc.bundleName) || !configDesc.dynamic || !z || (resourcesByBundleName = Runtime.getResourcesByBundleName(configDesc.bundleName)) == null || (assetsData2 = FileUtil.getAssetsData(resourcesByBundleName, configDesc.configFileName)) == null || assetsData2.length <= 0) ? null : new String(assetsData2);
        if (TextUtils.isEmpty(str) && (assetsData = FileUtil.getAssetsData(context.getResources(), configDesc.configFileName)) != null && assetsData.length > 0) {
            str = new String(assetsData);
        }
        if (!TextUtils.isEmpty(str)) {
            moduleDesc = (ModuleDesc) JSON.parseObject(str, ModuleDesc.class);
            moduleDesc.mBundleName = configDesc.bundleName;
            List<String> list = moduleDesc.metaInfoList;
            if (list != null && !list.isEmpty()) {
                moduleDesc.mBioMetaInfoList = new ArrayList(moduleDesc.metaInfoList.size());
                Iterator<String> it = moduleDesc.metaInfoList.iterator();
                while (it.hasNext()) {
                    BioMetaInfo createMetaInfo = createMetaInfo(context, z, it.next(), configDesc.bundleName);
                    if (createMetaInfo != null) {
                        moduleDesc.mBioMetaInfoList.add(createMetaInfo);
                    }
                }
            }
            List<LocalServiceDesc> list2 = moduleDesc.localServiceDescs;
            if (list2 != null && !list2.isEmpty()) {
                moduleDesc.mBioServiceDescription = new ArrayList(moduleDesc.localServiceDescs.size());
                for (LocalServiceDesc localServiceDesc : moduleDesc.localServiceDescs) {
                    if (localServiceDesc.isEssential) {
                        TextUtils.isEmpty(localServiceDesc.className);
                    }
                    if (TextUtils.isEmpty(localServiceDesc.className) || TextUtils.isEmpty(localServiceDesc.interfaceName)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid LocalServiceDesc: ");
                        sb.append(localServiceDesc);
                        throw new RuntimeException(sb.toString());
                    }
                    BioServiceDescription createBioServiceDescription = createBioServiceDescription(context, z, localServiceDesc, configDesc.bundleName);
                    if (createBioServiceDescription != null) {
                        moduleDesc.mBioServiceDescription.add(createBioServiceDescription);
                    }
                }
            }
        }
        return moduleDesc;
    }

    private static BioMetaInfo createMetaInfo(Context context, boolean z, String str, String str2) {
        try {
            return (BioMetaInfo) Runtime.loadClass(context, z, str, str2).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static BioServiceDescription createBioServiceDescription(Context context, boolean z, LocalServiceDesc localServiceDesc, String str) {
        try {
            Class<?> loadClass = Runtime.loadClass(context, z, localServiceDesc.className, str);
            if (loadClass == null) {
                throw new NotImplementedException();
            }
            BioServiceDescription bioServiceDescription = new BioServiceDescription();
            try {
                bioServiceDescription.setClazz(loadClass);
                bioServiceDescription.setInterfaceName(localServiceDesc.interfaceName);
                bioServiceDescription.setLazy(localServiceDesc.isLazy);
                return bioServiceDescription;
            } catch (Throwable unused) {
                return bioServiceDescription;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
