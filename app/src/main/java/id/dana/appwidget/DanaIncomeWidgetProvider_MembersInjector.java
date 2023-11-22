package id.dana.appwidget;

import dagger.MembersInjector;
import id.dana.appwidget.DanaAppWidgetContract;

/* loaded from: classes8.dex */
public final class DanaIncomeWidgetProvider_MembersInjector implements MembersInjector<DanaIncomeWidgetProvider> {
    public static void MyBillsEntityDataFactory(DanaIncomeWidgetProvider danaIncomeWidgetProvider, DanaAppWidgetContract.Presenter presenter) {
        danaIncomeWidgetProvider.danaAppWidgetPresenter = presenter;
    }
}
