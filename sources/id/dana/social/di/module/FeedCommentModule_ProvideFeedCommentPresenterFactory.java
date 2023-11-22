package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FeedCommentContract;
import id.dana.social.presenter.FeedCommentPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedCommentModule_ProvideFeedCommentPresenterFactory implements Factory<FeedCommentContract.Presenter> {
    private final Provider<FeedCommentPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final FeedCommentModule getAuthRequestContext;

    public static FeedCommentContract.Presenter BuiltInFictitiousFunctionClassFactory(FeedCommentModule feedCommentModule, FeedCommentPresenter feedCommentPresenter) {
        return (FeedCommentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(feedCommentModule.getAuthRequestContext(feedCommentPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedCommentContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
