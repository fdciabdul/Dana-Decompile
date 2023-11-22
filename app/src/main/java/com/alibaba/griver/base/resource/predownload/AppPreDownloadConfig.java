package com.alibaba.griver.base.resource.predownload;

import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AppPreDownloadConfig {
    public List<ConfigUnitsBean> configUnits = new ArrayList();
    public boolean enabled = false;
    public int maxConcurrentCount = 1;
    public long availableExpiredTime = 82400;
    public boolean disableUpdateOnAMCS = false;
    public long updateAppInfoInterval = TimeUtils.DAY_TO_SECOND;
    public long appInfoAvailableTime = 864000;
    public int maxTopAppPreCount = 0;
    public long topAppOpenTime = 0;

    public List<ConfigUnitsBean> getConfigUnits() {
        return this.configUnits;
    }

    public void setConfigUnits(List<ConfigUnitsBean> list) {
        this.configUnits = list;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public int getMaxConcurrentCount() {
        return this.maxConcurrentCount;
    }

    public void setMaxConcurrentCount(int i) {
        this.maxConcurrentCount = i;
    }

    public long getAvailableExpiredTime() {
        return this.availableExpiredTime;
    }

    public void setAvailableExpiredTime(long j) {
        this.availableExpiredTime = j;
    }

    public boolean isDisableUpdateOnAMCS() {
        return this.disableUpdateOnAMCS;
    }

    public void setDisableUpdateOnAMCS(boolean z) {
        this.disableUpdateOnAMCS = z;
    }

    public long getUpdateAppInfoInterval() {
        return this.updateAppInfoInterval;
    }

    public void setUpdateAppInfoInterval(long j) {
        this.updateAppInfoInterval = j;
    }

    public long getAppInfoAvailableTime() {
        return this.appInfoAvailableTime;
    }

    public void setAppInfoAvailableTime(long j) {
        this.appInfoAvailableTime = j;
    }

    public int getMaxTopAppPreCount() {
        return this.maxTopAppPreCount;
    }

    public void setMaxTopAppPreCount(int i) {
        this.maxTopAppPreCount = i;
    }

    public long getTopAppOpenTime() {
        return this.topAppOpenTime;
    }

    public void setTopAppOpenTime(long j) {
        this.topAppOpenTime = j;
    }

    /* loaded from: classes3.dex */
    public static class ConfigUnitsBean {
        public List<String> appIds = new ArrayList();
        public int delay;
        public int downloadType;
        public String fireMoment;
        public int retryCount;
        public String type;

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getFireMoment() {
            return this.fireMoment;
        }

        public void setFireMoment(String str) {
            this.fireMoment = str;
        }

        public int getDelay() {
            return this.delay;
        }

        public void setDelay(int i) {
            this.delay = i;
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public void setRetryCount(int i) {
            this.retryCount = i;
        }

        public int getDownloadType() {
            return this.downloadType;
        }

        public void setDownloadType(int i) {
            this.downloadType = i;
        }

        public List<String> getAppIds() {
            return this.appIds;
        }
    }
}
