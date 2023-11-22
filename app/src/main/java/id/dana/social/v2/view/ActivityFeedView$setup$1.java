package id.dana.social.v2.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class ActivityFeedView$setup$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityFeedView$setup$1(Object obj) {
        super(1, obj, ActivityFeedView.class, "handleUgcPhotoClick", "handleUgcPhotoClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ActivityFeedView.access$handleUgcPhotoClick((ActivityFeedView) this.receiver, i);
    }
}
