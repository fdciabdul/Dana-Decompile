package id.dana.social.v2.viewholder;

import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.social.adapter.SocialFeedClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class GroupedFeedViewHolder$bindData$1$1$2 extends FunctionReferenceImpl implements Function2<String, DealsPayloadModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupedFeedViewHolder$bindData$1$1$2(Object obj) {
        super(2, obj, SocialFeedClickListener.class, "onDealsUniqueValueWidgetClicked", "onDealsUniqueValueWidgetClicked(Ljava/lang/String;Lid/dana/feeds/ui/model/DealsPayloadModel;)V", 0);
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
        ((SocialFeedClickListener) this.receiver).getAuthRequestContext(str, dealsPayloadModel);
    }
}
