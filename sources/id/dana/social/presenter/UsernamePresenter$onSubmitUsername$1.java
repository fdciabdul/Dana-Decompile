package id.dana.social.presenter;

import id.dana.domain.social.model.InitFeed;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class UsernamePresenter$onSubmitUsername$1 extends FunctionReferenceImpl implements Function1<InitFeed, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UsernamePresenter$onSubmitUsername$1(Object obj) {
        super(1, obj, UsernamePresenter.class, "onInitFeedSuccess", "onInitFeedSuccess(Lid/dana/domain/social/model/InitFeed;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(InitFeed initFeed) {
        invoke2(initFeed);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(InitFeed initFeed) {
        Intrinsics.checkNotNullParameter(initFeed, "");
        UsernamePresenter usernamePresenter = (UsernamePresenter) this.receiver;
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.PROFILE_TAG, initFeed.getStatus().toString());
    }
}
