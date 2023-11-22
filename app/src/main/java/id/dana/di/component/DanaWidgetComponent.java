package id.dana.di.component;

import dagger.Component;
import id.dana.appwidget.DanaIncomeWidgetProvider;
import id.dana.appwidget.DanaQuickActionMediumWidgetProvider;
import id.dana.appwidget.DanaQuickActionWidgetProvider;
import id.dana.appwidget.DanaStatementLargeWidgetProvider;
import id.dana.appwidget.DanaStatementMediumWidgetProvider;
import id.dana.appwidget.DanaStatementWidgetProvider;
import id.dana.appwidget.collectionview.StatementListRemoteViewsFactory;
import id.dana.di.PerActivity;
import id.dana.di.modules.DanaAppWidgetModule;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {DanaAppWidgetModule.class})
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH&¢\u0006\u0004\b\u0005\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/DanaWidgetComponent;", "", "Lid/dana/appwidget/DanaQuickActionWidgetProvider;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/appwidget/DanaQuickActionWidgetProvider;)V", "Lid/dana/appwidget/DanaStatementWidgetProvider;", "(Lid/dana/appwidget/DanaStatementWidgetProvider;)V", "Lid/dana/appwidget/DanaIncomeWidgetProvider;", "(Lid/dana/appwidget/DanaIncomeWidgetProvider;)V", "Lid/dana/appwidget/DanaStatementLargeWidgetProvider;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/appwidget/DanaStatementLargeWidgetProvider;)V", "Lid/dana/appwidget/DanaStatementMediumWidgetProvider;", "(Lid/dana/appwidget/DanaStatementMediumWidgetProvider;)V", "Lid/dana/appwidget/DanaQuickActionMediumWidgetProvider;", "PlaceComponentResult", "(Lid/dana/appwidget/DanaQuickActionMediumWidgetProvider;)V", "Lid/dana/appwidget/collectionview/StatementListRemoteViewsFactory;", "MyBillsEntityDataFactory", "(Lid/dana/appwidget/collectionview/StatementListRemoteViewsFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes8.dex */
public interface DanaWidgetComponent {
    void BuiltInFictitiousFunctionClassFactory(DanaStatementLargeWidgetProvider p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(DanaIncomeWidgetProvider p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(DanaQuickActionWidgetProvider p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(DanaStatementMediumWidgetProvider p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(DanaStatementWidgetProvider p0);

    void MyBillsEntityDataFactory(StatementListRemoteViewsFactory p0);

    void PlaceComponentResult(DanaQuickActionMediumWidgetProvider p0);
}
