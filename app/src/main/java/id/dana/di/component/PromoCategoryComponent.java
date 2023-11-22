package id.dana.di.component;

import dagger.Component;
import id.dana.contract.promocenter.PromoCategoryModule;
import id.dana.di.PerActivity;
import id.dana.richview.promocenter.PromoCategoryView;

@Component(dependencies = {ApplicationComponent.class}, modules = {PromoCategoryModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface PromoCategoryComponent {
    void PlaceComponentResult(PromoCategoryView promoCategoryView);
}
