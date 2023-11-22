package com.iap.ac.android.region.cdp.component.defaults;

import android.text.TextUtils;
import com.iap.ac.android.acs.operation.interceptor.Interceptor4addFatigueAction;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import com.iap.ac.android.region.cdp.component.BehaviorComponent;
import com.iap.ac.android.region.cdp.component.LocalStorageComponent;
import com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback;
import com.iap.ac.android.region.cdp.model.CdpBehaviorInfo;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import com.iap.ac.android.region.cdp.model.CdpUploadFatigueEvent;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import com.iap.ac.android.region.cdp.util.TimeUtil;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.danah5.scanqr.ScanQrBridge;
import java.util.Collection;

/* loaded from: classes3.dex */
public class DefaultBehaviorComponent extends BaseComponent implements BehaviorComponent {
    public static final String TAG = CdpUtils.logTag("DefaultBehaviorComponent");

    @Override // com.iap.ac.android.region.cdp.component.BehaviorComponent
    public void addBehavior(final String str, final String str2, final String str3, final boolean z, final AddFatigueActionCallback addFatigueActionCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            IAPAsyncTask.asyncTask(new IAPAsyncTask.Runner<Boolean>() { // from class: com.iap.ac.android.region.cdp.component.defaults.DefaultBehaviorComponent.1
                {
                    DefaultBehaviorComponent.this = this;
                }

                private CdpBehaviorInfo createNewBehaviorInfo(String str4, String str5, String str6, String str7, String str8, String str9) {
                    CdpBehaviorInfo cdpBehaviorInfo = new CdpBehaviorInfo();
                    cdpBehaviorInfo.spaceCode = str4;
                    cdpBehaviorInfo.deliverId = str5;
                    cdpBehaviorInfo.action = str6;
                    cdpBehaviorInfo.period = str7;
                    cdpBehaviorInfo.periodStartTime = TimeUtil.getPeriodStartTime(str7, DefaultBehaviorComponent.this.mWalletCdpKit.getTimezone());
                    cdpBehaviorInfo.userId = str8;
                    cdpBehaviorInfo.locale = str9;
                    cdpBehaviorInfo.count = 1;
                    return cdpBehaviorInfo;
                }

                private void uploadEventMonitor(String str4, String str5) {
                    try {
                        CdpContentInfo contentInfo = ((LocalStorageComponent) DefaultBehaviorComponent.this.getComponent(LocalStorageComponent.class)).getContentInfo(str2, str4, str5);
                        ACLogEvent.newLogger("mini_program_operation", CdpConstants.SEED_ID_ACTION_TRIGGERED).addParams("spaceCode", str).addParams(Interceptor4addFatigueAction.PARAM_DELIVER_ID, str2).addParams("trackingCode", contentInfo == null ? "" : contentInfo.trackingCode).addParams("actionType", str3).addParams("source", z ? TrackerDataKey.UserConsentProperties.UserConsentType.MINI_PROGRAM : ScanQrBridge.CODE_CONSUMER_NATIVE).event("region_biz");
                    } catch (Exception e) {
                        ACLog.w(DefaultBehaviorComponent.TAG, String.format("upload event monitor failed, save failed deliverId: %s, exception: %s", str2, e));
                    }
                }

                @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
                public void onFailure(Exception exc) {
                    AddFatigueActionCallback addFatigueActionCallback2 = addFatigueActionCallback;
                    if (addFatigueActionCallback2 != null) {
                        addFatigueActionCallback2.onFailure(exc);
                    }
                    String str4 = DefaultBehaviorComponent.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("add behavior info failed, error: ");
                    sb.append(exc);
                    ACLog.w(str4, sb.toString());
                }

                /* JADX WARN: Removed duplicated region for block: B:62:0x00b2  */
                /* JADX WARN: Removed duplicated region for block: B:63:0x00df  */
                /* JADX WARN: Removed duplicated region for block: B:69:0x0147  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x0149  */
                @Override // com.iap.ac.android.common.task.async.IAPAsyncTask.Runner
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Boolean execute() throws java.lang.Exception {
                    /*
                        Method dump skipped, instructions count: 391
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.region.cdp.component.defaults.DefaultBehaviorComponent.AnonymousClass1.execute():java.lang.Boolean");
                }

                @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
                public void onSuccess(Boolean bool) {
                    if (addFatigueActionCallback != null) {
                        addFatigueActionCallback.onSuccess(bool != null && bool.booleanValue());
                    }
                }
            });
        } else if (addFatigueActionCallback != null) {
            addFatigueActionCallback.onFailure(new RuntimeException("params is null"));
        }
    }

    @Override // com.iap.ac.android.region.cdp.component.BehaviorComponent
    public void updateLastUploadCount(Collection<CdpUploadFatigueEvent> collection) {
        if (CdpUtils.isEmpty(collection)) {
            return;
        }
        String openId = SPIManager.getInstance().getOpenId();
        String appLanguage = CdpUtils.getAppLanguage();
        LocalStorageComponent localStorageComponent = (LocalStorageComponent) getComponent(LocalStorageComponent.class);
        try {
            for (CdpUploadFatigueEvent cdpUploadFatigueEvent : collection) {
                CdpBehaviorInfo behaviorInfo = localStorageComponent.getBehaviorInfo(cdpUploadFatigueEvent.deliverId, cdpUploadFatigueEvent.action, cdpUploadFatigueEvent.period, openId, appLanguage);
                int i = behaviorInfo.lastUploadCount;
                int i2 = cdpUploadFatigueEvent.count;
                if (i != i2) {
                    behaviorInfo.lastUploadCount = i2;
                    localStorageComponent.insertOrReplaceBehaviorInfo(behaviorInfo);
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateLastUploadCount success, behaviorInfo: ");
                    sb.append(behaviorInfo);
                    ACLog.d(str, sb.toString());
                }
            }
        } catch (Exception e) {
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("updateLastUploadCount error: ");
            sb2.append(e);
            ACLog.w(str2, sb2.toString());
        }
    }
}
