package id.dana.kyb.helper.service.strategy;

import android.content.Context;
import id.dana.kyb.helper.service.listener.KybServiceListener;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.KybServiceRedirectValueModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/kyb/helper/service/strategy/KybServiceDeepLinkActionStrategy;", "Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategy;", "Landroid/content/Context;", "p0", "Lid/dana/kyb/model/KybServiceModel;", "p1", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "p2", "", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/kyb/model/KybServiceModel;Lid/dana/kyb/helper/service/listener/KybServiceListener;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceDeepLinkActionStrategy implements KybServiceActionStrategy {
    @Inject
    public KybServiceDeepLinkActionStrategy() {
    }

    @Override // id.dana.kyb.helper.service.strategy.KybServiceActionStrategy
    public final void PlaceComponentResult(Context p0, KybServiceModel p1, KybServiceListener p2) {
        String str;
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        KybServiceRedirectValueModel kybServiceRedirectValueModel = p1.MyBillsEntityDataFactory;
        if (kybServiceRedirectValueModel == null || (str = kybServiceRedirectValueModel.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
            return;
        }
        p2.MyBillsEntityDataFactory(str);
    }
}
