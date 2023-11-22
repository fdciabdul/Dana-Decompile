package id.dana.social.view.activity.detail;

import id.dana.feeds.ui.model.ActivityWidgetModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class SocialActivityDetail$setFeedDataOnNewActivityView$1$3 extends FunctionReferenceImpl implements Function1<ActivityWidgetModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SocialActivityDetail$setFeedDataOnNewActivityView$1$3(Object obj) {
        super(1, obj, SocialActivityDetail$socialFeedClickListener$1.class, "BuiltInFictitiousFunctionClassFactory", "BuiltInFictitiousFunctionClassFactory(Lid/dana/feeds/ui/model/ActivityWidgetModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(ActivityWidgetModel activityWidgetModel) {
        invoke2(activityWidgetModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ActivityWidgetModel activityWidgetModel) {
        Intrinsics.checkNotNullParameter(activityWidgetModel, "");
        ((SocialActivityDetail$socialFeedClickListener$1) this.receiver).BuiltInFictitiousFunctionClassFactory(activityWidgetModel);
    }
}
