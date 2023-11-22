package id.dana.cardbinding.data.model;

import id.dana.cardbinding.domain.model.BindingCardAddInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/data/model/BindingCardAddResult;", "Lid/dana/cardbinding/domain/model/BindingCardAddInfo;", "PlaceComponentResult", "(Lid/dana/cardbinding/data/model/BindingCardAddResult;)Lid/dana/cardbinding/domain/model/BindingCardAddInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BindingCardAddResultKt {
    public static final BindingCardAddInfo PlaceComponentResult(BindingCardAddResult bindingCardAddResult) {
        Intrinsics.checkNotNullParameter(bindingCardAddResult, "");
        return new BindingCardAddInfo(bindingCardAddResult.getBizType(), bindingCardAddResult.getCheckoutUrl());
    }
}
