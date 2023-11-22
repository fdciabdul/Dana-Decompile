package id.dana.social.utils;

import id.dana.social.adapter.SocialFeedClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class FeedsContentUtils$toFeedRegexData$1 extends FunctionReferenceImpl implements Function1<Content, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedsContentUtils$toFeedRegexData$1(Object obj) {
        super(1, obj, SocialFeedClickListener.class, "onSocialFeedSpanClicked", "onSocialFeedSpanClicked(Lid/dana/social/utils/Content;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Content content) {
        invoke2(content);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Content content) {
        Intrinsics.checkNotNullParameter(content, "");
        ((SocialFeedClickListener) this.receiver).getAuthRequestContext(content);
    }
}
