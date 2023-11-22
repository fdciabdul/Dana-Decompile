package id.dana.social.v2.viewholder;

import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.social.adapter.SocialFeedClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class GroupedFeedViewHolder$bindData$1$1$1 extends FunctionReferenceImpl implements Function1<ActivityWidgetModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupedFeedViewHolder$bindData$1$1$1(Object obj) {
        super(1, obj, SocialFeedClickListener.class, "onActivityWidgetClicked", "onActivityWidgetClicked(Lid/dana/feeds/ui/model/ActivityWidgetModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(ActivityWidgetModel activityWidgetModel) {
        invoke2(activityWidgetModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ActivityWidgetModel activityWidgetModel) {
        Intrinsics.checkNotNullParameter(activityWidgetModel, "");
        ((SocialFeedClickListener) this.receiver).BuiltInFictitiousFunctionClassFactory(activityWidgetModel);
    }
}
