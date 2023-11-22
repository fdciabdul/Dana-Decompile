package com.alibaba.ariver.resource.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.resource.api.models.AppModel;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public interface RVResourcePresetProxy extends Proxiable {

    /* loaded from: classes3.dex */
    public interface InputStreamGetter {
        InputStream onGetInputStream();
    }

    Map<String, AppModel> getPresetAppInfos();

    Map<String, PresetPackage> getPresetPackage();

    /* loaded from: classes3.dex */
    public static class PresetPackage {
        private String appId;
        private boolean forceUse;
        private InputStreamGetter inputStreamGetter;
        private int tarSize = 0;
        private String version;

        public int getTarSize() {
            return this.tarSize;
        }

        public void setTarSize(int i) {
            this.tarSize = i;
        }

        public PresetPackage(String str, String str2, InputStreamGetter inputStreamGetter) {
            this.appId = str;
            this.version = str2;
            this.inputStreamGetter = inputStreamGetter;
        }

        public boolean isForceUse() {
            return this.forceUse;
        }

        public void setForceUse(boolean z) {
            this.forceUse = z;
        }

        public String getAppId() {
            return this.appId;
        }

        public String getVersion() {
            return this.version;
        }

        public InputStream getInputStream() {
            return this.inputStreamGetter.onGetInputStream();
        }
    }
}
