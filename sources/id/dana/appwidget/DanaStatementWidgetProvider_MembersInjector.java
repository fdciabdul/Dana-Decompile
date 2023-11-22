package id.dana.appwidget;

import dagger.MembersInjector;
import id.dana.appwidget.DanaAppWidgetContract;

/* loaded from: classes8.dex */
public final class DanaStatementWidgetProvider_MembersInjector implements MembersInjector<DanaStatementWidgetProvider> {
    public static void getAuthRequestContext(DanaStatementWidgetProvider danaStatementWidgetProvider, DanaAppWidgetContract.Presenter presenter) {
        danaStatementWidgetProvider.danaAppWidgetPresenter = presenter;
    }
}
