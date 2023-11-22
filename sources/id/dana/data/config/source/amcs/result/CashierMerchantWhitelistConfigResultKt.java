package id.dana.data.config.source.amcs.result;

import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "toCashierMerchantWhitelistConfig", "(Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;)Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CashierMerchantWhitelistConfigResultKt {
    public static final CashierMerchantWhitelistConfig toCashierMerchantWhitelistConfig(CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult) {
        Intrinsics.checkNotNullParameter(cashierMerchantWhitelistConfigResult, "");
        String mode = cashierMerchantWhitelistConfigResult.getMode();
        String str = mode != null ? mode : "";
        List<String> mids = cashierMerchantWhitelistConfigResult.getMids();
        if (mids == null) {
            mids = CollectionsKt.emptyList();
        }
        return new CashierMerchantWhitelistConfig(str, mids);
    }
}
