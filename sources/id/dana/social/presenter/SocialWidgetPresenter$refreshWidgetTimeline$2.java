package id.dana.social.presenter;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.feeds.domain.activation.interactor.GetFriendsFeedWithInitFeedAndFeatureCheck;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", BridgeDSL.INVOKE, "(Ljava/lang/Throwable;)Ljava/lang/String;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SocialWidgetPresenter$refreshWidgetTimeline$2 extends Lambda implements Function1<Throwable, String> {
    final /* synthetic */ SocialWidgetPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SocialWidgetPresenter$refreshWidgetTimeline$2(SocialWidgetPresenter socialWidgetPresenter) {
        super(1);
        this.this$0 = socialWidgetPresenter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, ErrorUtil.MyBillsEntityDataFactory(GetFriendsFeedWithInitFeedAndFeatureCheck.class, this.this$0.getClass(), String.valueOf(new Exception(th).getCause())));
        return this.this$0.DatabaseTableConfigUtil.get().BuiltInFictitiousFunctionClassFactory();
    }
}
