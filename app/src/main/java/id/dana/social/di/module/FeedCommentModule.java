package id.dana.social.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.social.contract.FeedCommentContract;
import id.dana.social.presenter.FeedCommentPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/di/module/FeedCommentModule;", "", "Lid/dana/social/contract/FeedCommentContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/social/contract/FeedCommentContract$View;", "Lid/dana/social/presenter/FeedCommentPresenter;", "p0", "Lid/dana/social/contract/FeedCommentContract$Presenter;", "getAuthRequestContext", "(Lid/dana/social/presenter/FeedCommentPresenter;)Lid/dana/social/contract/FeedCommentContract$Presenter;", "MyBillsEntityDataFactory", "Lid/dana/social/contract/FeedCommentContract$View;", "<init>", "(Lid/dana/social/contract/FeedCommentContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class FeedCommentModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedCommentContract.View getAuthRequestContext;

    public FeedCommentModule(FeedCommentContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final FeedCommentContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    public final FeedCommentContract.Presenter getAuthRequestContext(FeedCommentPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
