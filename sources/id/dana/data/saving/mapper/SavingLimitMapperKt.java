package id.dana.data.saving.mapper;

import id.dana.data.saving.model.SavingLimitEntity;
import id.dana.domain.saving.model.SavingLimit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/saving/model/SavingLimitEntity;", "Lid/dana/domain/saving/model/SavingLimit;", "toSavingLimit", "(Lid/dana/data/saving/model/SavingLimitEntity;)Lid/dana/domain/saving/model/SavingLimit;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SavingLimitMapperKt {
    public static final SavingLimit toSavingLimit(SavingLimitEntity savingLimitEntity) {
        Intrinsics.checkNotNullParameter(savingLimitEntity, "");
        return new SavingLimit(savingLimitEntity.getMaxSavingCountNonKyc(), savingLimitEntity.getMaxSavingAmountNonKyc(), savingLimitEntity.getMaxSavingAmountKyc());
    }
}
