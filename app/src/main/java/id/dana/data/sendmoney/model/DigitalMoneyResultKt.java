package id.dana.data.sendmoney.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/sendmoney/model/DigitalMoneyResult;", "", "prefix", "Lid/dana/data/sendmoney/model/DigitalMoneyEntity;", "toDigitalMoneyEntity", "(Lid/dana/data/sendmoney/model/DigitalMoneyResult;Ljava/lang/String;)Lid/dana/data/sendmoney/model/DigitalMoneyEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DigitalMoneyResultKt {
    public static final DigitalMoneyEntity toDigitalMoneyEntity(DigitalMoneyResult digitalMoneyResult, String str) {
        Intrinsics.checkNotNullParameter(digitalMoneyResult, "");
        Intrinsics.checkNotNullParameter(str, "");
        return new DigitalMoneyEntity(digitalMoneyResult.getInstId(), str, digitalMoneyResult.getBankName(), digitalMoneyResult.getEWalletName(), digitalMoneyResult.getIdentifier());
    }
}
