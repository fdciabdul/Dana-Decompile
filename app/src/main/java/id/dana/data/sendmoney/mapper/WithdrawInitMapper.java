package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawInitResult;
import id.dana.domain.sendmoney.model.WithdrawInit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/sendmoney/mapper/WithdrawInitMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/sendmoney/repository/source/network/result/WithdrawInitResult;", "Lid/dana/domain/sendmoney/model/WithdrawInit;", "oldItem", "map", "(Lid/dana/data/sendmoney/repository/source/network/result/WithdrawInitResult;)Lid/dana/domain/sendmoney/model/WithdrawInit;", "Lid/dana/data/sendmoney/mapper/WithdrawInitBaseResultMapper;", "withdrawInitBaseResultMapper", "Lid/dana/data/sendmoney/mapper/WithdrawInitBaseResultMapper;", "<init>", "(Lid/dana/data/sendmoney/mapper/WithdrawInitBaseResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WithdrawInitMapper extends BaseMapper<WithdrawInitResult, WithdrawInit> {
    private final WithdrawInitBaseResultMapper withdrawInitBaseResultMapper;

    @Inject
    public WithdrawInitMapper(WithdrawInitBaseResultMapper withdrawInitBaseResultMapper) {
        Intrinsics.checkNotNullParameter(withdrawInitBaseResultMapper, "");
        this.withdrawInitBaseResultMapper = withdrawInitBaseResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final WithdrawInit map(WithdrawInitResult oldItem) {
        return new WithdrawInit(oldItem != null ? oldItem.getEnableWithdrawSaveAccount() : null, oldItem != null ? oldItem.getMaxNumOfAssets() : null, oldItem != null ? oldItem.getNeedSenderName() : null, this.withdrawInitBaseResultMapper.apply(oldItem != null ? oldItem.getWithdrawMethodViewList() : null));
    }
}
