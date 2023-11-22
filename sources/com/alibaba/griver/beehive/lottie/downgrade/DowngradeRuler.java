package com.alibaba.griver.beehive.lottie.downgrade;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.player.LottieHelper;
import com.alibaba.griver.beehive.lottie.util.DeviceUtils;
import com.alibaba.griver.beehive.lottie.util.SceneUtils;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes6.dex */
public class DowngradeRuler {
    private static final String TAG = "LottiePlayer:DowngradeRuler";
    private static List<DowngradeMemRule> downgradeMemRuleList = new ArrayList();
    private String assetsAnimationPath;
    private boolean canDowngradeOnEmptyPlaceHolder = false;
    private String downgradeLevel;
    private String lottieDjangoId;
    private String lottiePath;
    private boolean optimize;
    private String placeHolder;
    private String scene;

    static {
        JSONObject parseObject;
        try {
            String configValue = SwitchConfigUtilsAdapter.getConfigValue("BeeLottiePlayer_downgrade");
            StringBuilder sb = new StringBuilder();
            sb.append("BeeLottiePlayer_downgrade：");
            sb.append(configValue);
            GriverLogger.d(TAG, sb.toString());
            if (TextUtils.isEmpty(configValue) || (parseObject = JSONObject.parseObject(configValue)) == null || parseObject.isEmpty()) {
                return;
            }
            for (String str : parseObject.keySet()) {
                JSONObject jSONObject = parseObject.getJSONObject(str);
                if (jSONObject != null && jSONObject.containsKey("android_mem")) {
                    downgradeMemRuleList.add(new DowngradeMemRule(str, (long) (Double.parseDouble(jSONObject.getString("android_mem")) * 1024.0d * 1024.0d * 1024.0d)));
                }
            }
            Collections.sort(downgradeMemRuleList, new Comparator<DowngradeMemRule>() { // from class: com.alibaba.griver.beehive.lottie.downgrade.DowngradeRuler.1
                @Override // java.util.Comparator
                public final int compare(DowngradeMemRule downgradeMemRule, DowngradeMemRule downgradeMemRule2) {
                    return downgradeMemRule2.getScene().length() - downgradeMemRule.getScene().length();
                }
            });
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("加载降级开关异常:");
            sb2.append(e);
            GriverLogger.w(TAG, sb2.toString());
        }
    }

    public boolean isOptimize() {
        return this.optimize;
    }

    public DowngradeRuler setOptimize(boolean z) {
        this.optimize = z;
        return this;
    }

    public String getScene() {
        return this.scene;
    }

    public DowngradeRuler setScene(String str) {
        this.scene = str;
        return this;
    }

    public String getLottieDjangoId() {
        return this.lottieDjangoId;
    }

    public DowngradeRuler setLottieDjangoId(String str) {
        this.lottieDjangoId = str;
        return this;
    }

    public String getPlaceHolder() {
        return this.placeHolder;
    }

    public DowngradeRuler setPlaceHolder(String str) {
        this.placeHolder = str;
        return this;
    }

    public String getDowngradeLevel() {
        return this.downgradeLevel;
    }

    public DowngradeRuler setDowngradeLevel(String str) {
        this.downgradeLevel = str;
        return this;
    }

    public String getLottiePath() {
        return this.lottiePath;
    }

    public DowngradeRuler setLottiePath(String str) {
        this.lottiePath = str;
        return this;
    }

    public String getAssetsAnimationPath() {
        return this.assetsAnimationPath;
    }

    public DowngradeRuler setAssetsAnimationPath(String str) {
        this.assetsAnimationPath = str;
        return this;
    }

    public boolean downgradeToPlaceholder() {
        ActivityManager.MemoryInfo memoryInfo = DeviceUtils.getMemoryInfo();
        int deviceLevel = DeviceUtils.getDeviceLevel();
        long totalRam = DeviceUtils.getTotalRam();
        String str = this.scene;
        if (TextUtils.isEmpty(str)) {
            str = SceneUtils.buildScene(this.lottieDjangoId, this.lottiePath, this.assetsAnimationPath);
        }
        try {
            if (!"L0".equals(this.downgradeLevel) && !"L1".equals(this.downgradeLevel) && !"L2".equals(this.downgradeLevel)) {
                if (!TextUtils.isEmpty(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("BeeLottie_d_");
                    sb.append(str);
                    String obj = sb.toString();
                    String configValue = SwitchConfigUtilsAdapter.getConfigValue(obj);
                    if (SummaryActivity.CHECKED.equals(configValue)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("业务场景降级,key=");
                        sb2.append(obj);
                        sb2.append(",value=");
                        sb2.append(configValue);
                        GriverLogger.d(TAG, sb2.toString());
                        return true;
                    }
                }
                if (!downgradeMemRuleList.isEmpty() && !TextUtils.isEmpty(str)) {
                    for (DowngradeMemRule downgradeMemRule : downgradeMemRuleList) {
                        if (downgradeMemRule.matchScene(str, totalRam)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("场景降级匹配:");
                            sb3.append(downgradeMemRule.getScene());
                            sb3.append(",downgradeMem=");
                            sb3.append(downgradeMemRule.getDowngradeMem());
                            sb3.append(",totalRam=");
                            sb3.append(totalRam);
                            GriverLogger.d(TAG, sb3.toString());
                            return true;
                        }
                    }
                }
                if (this.optimize && canDowngradeWithPlaceHolder() && deviceLevel <= 2) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("判定为低端设备降级:deviceLevel=");
                    sb4.append(deviceLevel);
                    GriverLogger.d(TAG, sb4.toString());
                    return true;
                } else if (this.optimize && canDowngradeWithPlaceHolder() && memoryInfo != null) {
                    boolean z = memoryInfo.lowMemory;
                    if (memoryInfo.lowMemory) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("低内存模式降级.");
                        sb5.append(this.lottieDjangoId);
                        GriverLogger.d(TAG, sb5.toString());
                        return true;
                    }
                    return false;
                } else {
                    return false;
                }
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("业务手动降级:downgradeLevel=");
            sb6.append(this.downgradeLevel);
            GriverLogger.d(TAG, sb6.toString());
            return true;
        } catch (Exception e) {
            GriverLogger.e(TAG, "降级处理流程异常：", e);
            return false;
        }
    }

    private boolean canDowngradeWithPlaceHolder() {
        return this.canDowngradeOnEmptyPlaceHolder || !TextUtils.isEmpty(this.placeHolder) || LottieHelper.containDowngradeFileInZip(this.lottieDjangoId) || LottieHelper.containDowngradeFileInAsset(this.assetsAnimationPath);
    }

    public boolean isCanDowngradeOnEmptyPlaceHolder() {
        return this.canDowngradeOnEmptyPlaceHolder;
    }

    public DowngradeRuler setCanDowngradeOnEmptyPlaceHolder(boolean z) {
        this.canDowngradeOnEmptyPlaceHolder = z;
        return this;
    }
}
