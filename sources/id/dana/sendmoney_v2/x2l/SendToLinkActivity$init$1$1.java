package id.dana.sendmoney_v2.x2l;

import id.dana.sendmoney_v2.x2l.model.SocialLinkModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* synthetic */ class SendToLinkActivity$init$1$1 extends FunctionReferenceImpl implements Function1<SocialLinkModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SendToLinkActivity$init$1$1(Object obj) {
        super(1, obj, SendToLinkActivity.class, "onSocialLinkSelected", "onSocialLinkSelected(Lid/dana/sendmoney_v2/x2l/model/SocialLinkModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(SocialLinkModel socialLinkModel) {
        invoke2(socialLinkModel);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SocialLinkModel socialLinkModel) {
        Intrinsics.checkNotNullParameter(socialLinkModel, "");
        SendToLinkActivity.access$onSocialLinkSelected((SendToLinkActivity) this.receiver, socialLinkModel);
    }
}
