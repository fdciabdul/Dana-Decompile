package id.dana.electronicmoney.bank.mandiri;

import dagger.MembersInjector;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;

/* loaded from: classes8.dex */
public final class MandiriEmoneyManager_MembersInjector implements MembersInjector<MandiriEmoneyManager> {
    public static void getAuthRequestContext(MandiriEmoneyManager mandiriEmoneyManager, ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker) {
        mandiriEmoneyManager.electronicMoneyMixpanelTracker = electronicMoneyAnalyticTracker;
    }
}
