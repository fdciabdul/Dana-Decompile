package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.WithdrawBizMethodViewResult;
import id.dana.domain.withdraw.model.WithdrawMethodOption;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class WithdrawMethodOptionsResultMapper extends BaseMapper<List<WithdrawBizMethodViewResult>, List<WithdrawMethodOption>> {
    private final WithdrawChannelViewResultMapper withdrawChannelViewResultMapper;
    private final WithdrawSavedCardChannelViewResultMapper withdrawSavedCardChannelViewResultMapper;

    @Inject
    public WithdrawMethodOptionsResultMapper(WithdrawChannelViewResultMapper withdrawChannelViewResultMapper, WithdrawSavedCardChannelViewResultMapper withdrawSavedCardChannelViewResultMapper) {
        this.withdrawChannelViewResultMapper = withdrawChannelViewResultMapper;
        this.withdrawSavedCardChannelViewResultMapper = withdrawSavedCardChannelViewResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<WithdrawMethodOption> map(List<WithdrawBizMethodViewResult> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (WithdrawBizMethodViewResult withdrawBizMethodViewResult : list) {
            arrayList.add(new WithdrawMethodOption.Builder().withdrawCardOptions(this.withdrawSavedCardChannelViewResultMapper.apply(withdrawBizMethodViewResult.getWithdrawCardOptionViews())).withdrawChannelOptions(this.withdrawChannelViewResultMapper.apply(withdrawBizMethodViewResult.getWithdrawChannelOptionViews())).withdrawMethod(withdrawBizMethodViewResult.getPayMethod()).build());
        }
        return arrayList;
    }
}
