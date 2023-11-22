package id.dana.social.presenter;

import android.content.Context;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.social.contract.SocialWidgetContract;
import id.dana.social.mapper.ActivityResponseListMapperKt;
import id.dana.social.model.SocialFeedWrapperModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/timeline/model/SocialFeed;", "socialFeed", "", BridgeDSL.INVOKE, "(Lid/dana/feeds/domain/timeline/model/SocialFeed;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SocialWidgetPresenter$refreshWidgetTimeline$1 extends Lambda implements Function1<SocialFeed, Unit> {
    final /* synthetic */ SocialWidgetPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SocialWidgetPresenter$refreshWidgetTimeline$1(SocialWidgetPresenter socialWidgetPresenter) {
        super(1);
        this.this$0 = socialWidgetPresenter;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
        invoke2(socialFeed);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SocialFeed socialFeed) {
        Intrinsics.checkNotNullParameter(socialFeed, "");
        List<ActivityResponse> activities = socialFeed.getActivities();
        SocialWidgetPresenter socialWidgetPresenter = this.this$0;
        SocialWidgetContract.View view = socialWidgetPresenter.DatabaseTableConfigUtil.get();
        Context context = socialWidgetPresenter.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(context, "");
        view.BuiltInFictitiousFunctionClassFactory(new SocialFeedWrapperModel(ActivityResponseListMapperKt.PlaceComponentResult(activities, context), socialFeed.getFromCache()));
    }
}
