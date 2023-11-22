package id.dana.social.view;

import id.dana.social.adapter.MyFeedHighlightListener;
import id.dana.social.model.FeedHighlightModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class FeedHighlightView$setupAdapter$1 extends FunctionReferenceImpl implements Function1<FeedHighlightModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedHighlightView$setupAdapter$1(Object obj) {
        super(1, obj, MyFeedHighlightListener.class, "MyBillsEntityDataFactory", "MyBillsEntityDataFactory(Lid/dana/social/model/FeedHighlightModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(FeedHighlightModel feedHighlightModel) {
        invoke2(feedHighlightModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(FeedHighlightModel feedHighlightModel) {
        Intrinsics.checkNotNullParameter(feedHighlightModel, "");
        ((MyFeedHighlightListener) this.receiver).MyBillsEntityDataFactory(feedHighlightModel);
    }
}
