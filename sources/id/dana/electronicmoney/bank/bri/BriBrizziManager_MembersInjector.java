package id.dana.electronicmoney.bank.bri;

import dagger.MembersInjector;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;

/* loaded from: classes8.dex */
public final class BriBrizziManager_MembersInjector implements MembersInjector<BriBrizziManager> {
    public static void MyBillsEntityDataFactory(BriBrizziManager briBrizziManager, ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker) {
        briBrizziManager.electronicMoneyMixpanelTracker = electronicMoneyAnalyticTracker;
    }
}
