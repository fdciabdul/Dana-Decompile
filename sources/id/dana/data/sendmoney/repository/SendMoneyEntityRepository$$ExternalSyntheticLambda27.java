package id.dana.data.sendmoney.repository;

import id.dana.data.sendmoney.mapper.SendMoneyMapper;
import id.dana.data.sendmoney.repository.source.network.result.SendMoneyResult;
import io.reactivex.functions.Function;

/* loaded from: classes4.dex */
public final /* synthetic */ class SendMoneyEntityRepository$$ExternalSyntheticLambda27 implements Function {
    public final /* synthetic */ SendMoneyMapper f$0;

    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return this.f$0.transform((SendMoneyResult) obj);
    }
}
