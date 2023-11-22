package id.dana.social.view;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.social.presenter.NewSocialWidgetPresenter;
import javax.inject.Named;

/* loaded from: classes5.dex */
public final class NewSocialWidgetView_MembersInjector implements MembersInjector<NewSocialWidgetView> {
    @Named("newSocialWidgetPresenter")
    public static void MyBillsEntityDataFactory(NewSocialWidgetView newSocialWidgetView, Lazy<NewSocialWidgetPresenter> lazy) {
        newSocialWidgetView.presenter = lazy;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NewSocialWidgetView newSocialWidgetView, Lazy<HomeWidgetEntityData> lazy) {
        newSocialWidgetView.homeWidgetCache = lazy;
    }
}
