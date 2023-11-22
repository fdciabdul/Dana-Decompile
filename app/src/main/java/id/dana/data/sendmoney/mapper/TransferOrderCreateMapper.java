package id.dana.data.sendmoney.mapper;

import id.dana.data.sendmoney.repository.source.network.request.BizTransferOrderCreateRequest;
import id.dana.data.sendmoney.repository.source.network.result.BizTransferOrderCreateResult;
import id.dana.domain.sendmoney.model.SendMoneyConfirm;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/sendmoney/mapper/TransferOrderCreateMapper;", "", "Lid/dana/data/sendmoney/repository/source/network/result/BizTransferOrderCreateResult;", "result", "Lid/dana/domain/sendmoney/model/SendMoneyConfirm;", "transform", "(Lid/dana/data/sendmoney/repository/source/network/result/BizTransferOrderCreateResult;)Lid/dana/domain/sendmoney/model/SendMoneyConfirm;", "Lid/dana/domain/sendmoney/model/SendMoneyConfirmParam;", "params", "Lid/dana/data/sendmoney/repository/source/network/request/BizTransferOrderCreateRequest;", "(Lid/dana/domain/sendmoney/model/SendMoneyConfirmParam;)Lid/dana/data/sendmoney/repository/source/network/request/BizTransferOrderCreateRequest;", "Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateRequestMapper;", "bizTransferOrderCreateRequestMapper", "Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateRequestMapper;", "Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateResultMapper;", "bizTransferOrderCreateResultMapper", "Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateResultMapper;", "<init>", "(Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateRequestMapper;Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransferOrderCreateMapper {
    private final BizTransferOrderCreateRequestMapper bizTransferOrderCreateRequestMapper;
    private final BizTransferOrderCreateResultMapper bizTransferOrderCreateResultMapper;

    @Inject
    public TransferOrderCreateMapper(BizTransferOrderCreateRequestMapper bizTransferOrderCreateRequestMapper, BizTransferOrderCreateResultMapper bizTransferOrderCreateResultMapper) {
        Intrinsics.checkNotNullParameter(bizTransferOrderCreateRequestMapper, "");
        Intrinsics.checkNotNullParameter(bizTransferOrderCreateResultMapper, "");
        this.bizTransferOrderCreateRequestMapper = bizTransferOrderCreateRequestMapper;
        this.bizTransferOrderCreateResultMapper = bizTransferOrderCreateResultMapper;
    }

    public final BizTransferOrderCreateRequest transform(SendMoneyConfirmParam params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.bizTransferOrderCreateRequestMapper.map(params);
    }

    public final SendMoneyConfirm transform(BizTransferOrderCreateResult result) {
        Intrinsics.checkNotNullParameter(result, "");
        return this.bizTransferOrderCreateResultMapper.map(result);
    }
}
