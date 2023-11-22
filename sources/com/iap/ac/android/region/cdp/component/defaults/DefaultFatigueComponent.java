package com.iap.ac.android.region.cdp.component.defaults;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.component.FatigueComponent;
import com.iap.ac.android.region.cdp.component.LocalStorageComponent;
import com.iap.ac.android.region.cdp.model.CdpBehaviorInfo;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import com.iap.ac.android.region.cdp.model.CdpFatigueInfo;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import com.iap.ac.android.region.cdp.util.TimeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DefaultFatigueComponent extends BaseComponent implements FatigueComponent {
    public static final String TAG = CdpUtils.logTag("DefaultFatigueComponent");

    @Override // com.iap.ac.android.region.cdp.component.FatigueComponent
    public void filterExhaustedFatigue(CdpSpaceInfo cdpSpaceInfo) {
        if (cdpSpaceInfo == null || CdpUtils.isEmpty(cdpSpaceInfo.contentInfos)) {
            return;
        }
        LocalStorageComponent localStorageComponent = (LocalStorageComponent) getComponent(LocalStorageComponent.class);
        ArrayList arrayList = new ArrayList(cdpSpaceInfo.contentInfos.size());
        for (CdpContentInfo cdpContentInfo : cdpSpaceInfo.contentInfos) {
            boolean z = false;
            if (!CdpUtils.isEmpty(cdpContentInfo.fatigueInfos)) {
                Iterator<CdpFatigueInfo> it = cdpContentInfo.fatigueInfos.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CdpFatigueInfo next = it.next();
                    if (next != null) {
                        try {
                            CdpBehaviorInfo behaviorInfo = localStorageComponent.getBehaviorInfo(next.deliverId, next.action, next.period, next.userId, next.locale);
                            if (behaviorInfo == null) {
                                continue;
                            } else if (!TimeUtil.isInCurrentPeriod(behaviorInfo.period, behaviorInfo.periodStartTime, this.mWalletCdpKit.getTimezone())) {
                                localStorageComponent.deleteBehavior(behaviorInfo);
                            } else if (behaviorInfo.count >= next.limitTimes) {
                                z = true;
                                break;
                            }
                        } catch (Exception e) {
                            String str = TAG;
                            StringBuilder sb = new StringBuilder();
                            sb.append("filterExhaustedFatigue#getBehaviorInfo failed, error: ");
                            sb.append(e);
                            ACLog.w(str, sb.toString());
                        }
                    }
                }
            }
            if (!z) {
                arrayList.add(cdpContentInfo);
            }
        }
        cdpSpaceInfo.contentInfos = arrayList;
    }

    @Override // com.iap.ac.android.region.cdp.component.FatigueComponent
    public void filterExhaustedFatigue(Collection<CdpSpaceInfo> collection) {
        if (collection != null) {
            Iterator<CdpSpaceInfo> it = collection.iterator();
            while (it.hasNext()) {
                filterExhaustedFatigue(it.next());
            }
        }
    }
}
