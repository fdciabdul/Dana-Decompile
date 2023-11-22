package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SplitBillSectionModule;
import id.dana.splitbill.view.SplitBillSectionView;

@Component(dependencies = {ApplicationComponent.class}, modules = {SplitBillSectionModule.class})
@PerActivity
/* loaded from: classes8.dex */
public interface SplitBillSectionComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillSectionView splitBillSectionView);
}
