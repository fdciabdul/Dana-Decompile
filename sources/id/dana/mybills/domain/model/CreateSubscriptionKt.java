package id.dana.mybills.domain.model;

import id.dana.mybills.ui.model.SaveMyBillsSubscriptionModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/domain/model/CreateSubscription;", "Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;", "toSaveMyBillsSubscriptionModel", "(Lid/dana/mybills/domain/model/CreateSubscription;)Lid/dana/mybills/ui/model/SaveMyBillsSubscriptionModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class CreateSubscriptionKt {
    public static final SaveMyBillsSubscriptionModel toSaveMyBillsSubscriptionModel(CreateSubscription createSubscription) {
        Intrinsics.checkNotNullParameter(createSubscription, "");
        return new SaveMyBillsSubscriptionModel(createSubscription.getSubscriptionId(), createSubscription.getSecurityId(), createSubscription.getVerificationMethods(), null, 8, null);
    }
}
