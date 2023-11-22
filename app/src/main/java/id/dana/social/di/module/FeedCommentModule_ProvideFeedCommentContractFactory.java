package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FeedCommentContract;

/* loaded from: classes5.dex */
public final class FeedCommentModule_ProvideFeedCommentContractFactory implements Factory<FeedCommentContract.View> {
    private final FeedCommentModule getAuthRequestContext;

    public static FeedCommentContract.View BuiltInFictitiousFunctionClassFactory(FeedCommentModule feedCommentModule) {
        return (FeedCommentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(feedCommentModule.getGetAuthRequestContext());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedCommentContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getGetAuthRequestContext());
    }
}
