package id.dana.kyb.helper.service.strategy;

import android.content.Context;
import id.dana.kyb.constant.KybServiceAction;
import id.dana.kyb.helper.service.listener.KybServiceListener;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.KybServiceRedirectValueModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/kyb/helper/service/strategy/KybServiceActionTypeStrategy;", "Lid/dana/kyb/helper/service/strategy/KybServiceActionStrategy;", "Landroid/content/Context;", "p0", "Lid/dana/kyb/model/KybServiceModel;", "p1", "Lid/dana/kyb/helper/service/listener/KybServiceListener;", "p2", "", "PlaceComponentResult", "(Landroid/content/Context;Lid/dana/kyb/model/KybServiceModel;Lid/dana/kyb/helper/service/listener/KybServiceListener;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceActionTypeStrategy implements KybServiceActionStrategy {
    @Inject
    public KybServiceActionTypeStrategy() {
    }

    @Override // id.dana.kyb.helper.service.strategy.KybServiceActionStrategy
    public final void PlaceComponentResult(Context p0, KybServiceModel p1, KybServiceListener p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        KybServiceRedirectValueModel kybServiceRedirectValueModel = p1.MyBillsEntityDataFactory;
        String str = kybServiceRedirectValueModel != null ? kybServiceRedirectValueModel.getAuthRequestContext : null;
        String str2 = str != null ? str : "";
        if (str2.length() == 0) {
            return;
        }
        int hashCode = str2.hashCode();
        if (hashCode == -263792747) {
            if (str2.equals("kyb_cpm")) {
                p2.MyBillsEntityDataFactory();
            }
        } else if (hashCode == -199046058) {
            if (str2.equals(KybServiceAction.REQUEST_PAYMENT)) {
                p2.PlaceComponentResult();
            }
        } else if (hashCode == 1153865332 && str2.equals(KybServiceAction.QRIS_BUSINESS)) {
            p2.getAuthRequestContext();
        }
    }
}
