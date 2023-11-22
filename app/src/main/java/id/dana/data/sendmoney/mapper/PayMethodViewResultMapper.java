package id.dana.data.sendmoney.mapper;

import android.text.TextUtils;
import id.dana.data.base.BaseMapper;
import id.dana.data.sendmoney.model.PayChannelResult;
import id.dana.data.sendmoney.model.PayMethodViewResult;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.domain.sendmoney.model.AddPayMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class PayMethodViewResultMapper extends BaseMapper<PayMethodViewResult, PayMethodView> {
    private List<AddPayMethod> addPayMethods;
    private final PayChannelResultMapper payChannelResultMapper;
    private final PayOptionsResultMapper payOptionsResultMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public PayMethodViewResultMapper(PayOptionsResultMapper payOptionsResultMapper, PayChannelResultMapper payChannelResultMapper) {
        this.payOptionsResultMapper = payOptionsResultMapper;
        this.payChannelResultMapper = payChannelResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public PayMethodView map(PayMethodViewResult payMethodViewResult) {
        if (payMethodViewResult == null) {
            return null;
        }
        PayMethodView payMethodView = new PayMethodView();
        payMethodView.setPayMethod(payMethodViewResult.payMethod);
        payMethodView.setPayCardOptionViews(this.payOptionsResultMapper.apply(payMethodViewResult.payCardOptionViews));
        payMethodView.setPayChannelOptionViews(this.payChannelResultMapper.apply(payMethodViewResult.payChannelOptionViews));
        List<AddPayMethod> list = this.addPayMethods;
        if (list != null && !list.isEmpty()) {
            payMethodView.setAddPayMethods(checkAddPayMethod(payMethodViewResult));
        }
        return payMethodView;
    }

    private List<AddPayMethod> checkAddPayMethod(PayMethodViewResult payMethodViewResult) {
        ArrayList arrayList = new ArrayList();
        for (AddPayMethod addPayMethod : this.addPayMethods) {
            if (!TextUtils.isEmpty(addPayMethod.getPayMethod())) {
                Iterator<PayChannelResult> it = payMethodViewResult.payChannelOptionViews.iterator();
                while (true) {
                    if (it.hasNext()) {
                        PayChannelResult next = it.next();
                        if (isAddPayMethodValid(addPayMethod, next)) {
                            addPayMethod.setInstLocalName(next.instLocalName);
                            arrayList.add(addPayMethod);
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean isAddPayMethodValid(AddPayMethod addPayMethod, PayChannelResult payChannelResult) {
        return !TextUtils.isEmpty(payChannelResult.payMethod) && payChannelResult.enableStatus && addPayMethod.getPayMethod().equals(payChannelResult.payMethod) && (addPayMethod.getInstId() == null || TextUtils.equals(addPayMethod.getInstId(), payChannelResult.instId));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAddPayMethods(List<AddPayMethod> list) {
        this.addPayMethods = list;
    }
}
