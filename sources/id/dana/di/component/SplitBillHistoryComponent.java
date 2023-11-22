package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SplitBillHistoryModule;
import id.dana.splitbill.view.SplitBillHistoryView;

@Component(dependencies = {ApplicationComponent.class}, modules = {SplitBillHistoryModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SplitBillHistoryComponent {
    void PlaceComponentResult(SplitBillHistoryView splitBillHistoryView);
}
