package id.dana.di.component;

import dagger.internal.Preconditions;
import id.dana.di.modules.SocialShareModule;
import id.dana.di.modules.SocialShareModule_GetPresenterFactory;
import id.dana.di.modules.SocialShareModule_GetViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.socialshare.interactor.GetSocialMediaCategoryShare;
import id.dana.richview.socialshare.SocialShareView;
import id.dana.richview.socialshare.SocialShareView_MembersInjector;
import id.dana.richview.socialshare.presenter.SocialSharePresenter;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes4.dex */
public final class DaggerSocialShareComponent {
    private DaggerSocialShareComponent() {
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public SocialShareModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SocialShareComponentImpl implements SocialShareComponent {
        private final SocialShareModule BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent MyBillsEntityDataFactory;
        private final SocialShareComponentImpl getAuthRequestContext;

        public /* synthetic */ SocialShareComponentImpl(SocialShareModule socialShareModule, ApplicationComponent applicationComponent, byte b) {
            this(socialShareModule, applicationComponent);
        }

        private SocialShareComponentImpl(SocialShareModule socialShareModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.BuiltInFictitiousFunctionClassFactory = socialShareModule;
            this.MyBillsEntityDataFactory = applicationComponent;
        }

        @Override // id.dana.di.component.SocialShareComponent
        public final void BuiltInFictitiousFunctionClassFactory(SocialShareView socialShareView) {
            SocialShareView_MembersInjector.PlaceComponentResult(socialShareView, SocialShareModule_GetPresenterFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, new SocialSharePresenter(new GetSocialMediaCategoryShare((ThreadExecutor) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.isAuto()), (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5())), SocialShareModule_GetViewFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory))));
        }
    }
}
