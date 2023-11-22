package id.dana.social.view.activity.detail;

import id.dana.feeds.ui.model.DealsPayloadModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class SocialActivityDetail$setFeedDataOnNewActivityView$1$4 extends FunctionReferenceImpl implements Function2<String, DealsPayloadModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SocialActivityDetail$setFeedDataOnNewActivityView$1$4(Object obj) {
        super(2, obj, SocialActivityDetail$socialFeedClickListener$1.class, "getAuthRequestContext", "getAuthRequestContext(Ljava/lang/String;Lid/dana/feeds/ui/model/DealsPayloadModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(String str, DealsPayloadModel dealsPayloadModel) {
        invoke2(str, dealsPayloadModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str, DealsPayloadModel dealsPayloadModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(dealsPayloadModel, "");
        ((SocialActivityDetail$socialFeedClickListener$1) this.receiver).getAuthRequestContext(str, dealsPayloadModel);
    }
}
