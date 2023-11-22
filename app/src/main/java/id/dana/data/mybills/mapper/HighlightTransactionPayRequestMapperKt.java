package id.dana.data.mybills.mapper;

import id.dana.data.mybills.model.request.HighlightTransactionPayRequestEntity;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.wallet.mapper.UserAssetsMapperKt;
import id.dana.domain.mybills.model.HighlightTransactionPayRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;", "Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;)Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HighlightTransactionPayRequestMapperKt {
    public static final HighlightTransactionPayRequestEntity BuiltInFictitiousFunctionClassFactory(HighlightTransactionPayRequest highlightTransactionPayRequest) {
        Intrinsics.checkNotNullParameter(highlightTransactionPayRequest, "");
        return new HighlightTransactionPayRequestEntity(highlightTransactionPayRequest.getSubscriptionId(), UserAssetsMapperKt.getAuthRequestContext(highlightTransactionPayRequest.getTransactionAmount()), highlightTransactionPayRequest.getPayMode(), MoneyViewEntityMapperKt.toMoneyViewEntity(highlightTransactionPayRequest.getAdminFee()), MoneyViewEntityMapperKt.toMoneyViewEntity(highlightTransactionPayRequest.getBaseAmount()));
    }
}
