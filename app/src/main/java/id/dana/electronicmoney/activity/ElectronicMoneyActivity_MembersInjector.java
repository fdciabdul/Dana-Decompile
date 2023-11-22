package id.dana.electronicmoney.activity;

import dagger.MembersInjector;
import id.dana.electronicmoney.ElectronicMoneyManager;
import id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker;

/* loaded from: classes8.dex */
public final class ElectronicMoneyActivity_MembersInjector implements MembersInjector<ElectronicMoneyActivity> {
    public static void MyBillsEntityDataFactory(ElectronicMoneyActivity electronicMoneyActivity, ElectronicMoneyManager electronicMoneyManager) {
        electronicMoneyActivity.manager = electronicMoneyManager;
    }

    public static void MyBillsEntityDataFactory(ElectronicMoneyActivity electronicMoneyActivity, ElectronicMoneyAnalyticTracker electronicMoneyAnalyticTracker) {
        electronicMoneyActivity.electronicMoneyMixpanelTracker = electronicMoneyAnalyticTracker;
    }
}
