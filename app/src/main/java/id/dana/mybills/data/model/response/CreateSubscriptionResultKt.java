package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.CreateSubscription;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/data/model/response/CreateSubscriptionResult;", "Lid/dana/mybills/domain/model/CreateSubscription;", "toCreateSubscription", "(Lid/dana/mybills/data/model/response/CreateSubscriptionResult;)Lid/dana/mybills/domain/model/CreateSubscription;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateSubscriptionResultKt {
    public static final CreateSubscription toCreateSubscription(CreateSubscriptionResult createSubscriptionResult) {
        Intrinsics.checkNotNullParameter(createSubscriptionResult, "");
        return new CreateSubscription(createSubscriptionResult.getSubscriptionId(), createSubscriptionResult.getSecurityId(), createSubscriptionResult.getVerificationMethods());
    }
}
