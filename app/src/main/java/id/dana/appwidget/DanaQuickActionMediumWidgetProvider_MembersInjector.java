package id.dana.appwidget;

import dagger.MembersInjector;
import id.dana.appwidget.DanaAppWidgetContract;

/* loaded from: classes8.dex */
public final class DanaQuickActionMediumWidgetProvider_MembersInjector implements MembersInjector<DanaQuickActionMediumWidgetProvider> {
    public static void getAuthRequestContext(DanaQuickActionMediumWidgetProvider danaQuickActionMediumWidgetProvider, DanaAppWidgetContract.Presenter presenter) {
        danaQuickActionMediumWidgetProvider.danaAppWidgetPresenter = presenter;
    }
}
