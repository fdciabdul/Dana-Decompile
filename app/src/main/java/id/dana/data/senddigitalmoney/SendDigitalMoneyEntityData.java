package id.dana.data.senddigitalmoney;

import id.dana.data.senddigitalmoney.repository.model.request.CardPrefixQueryRequest;
import id.dana.data.senddigitalmoney.repository.model.result.CardPrefixQueryResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0004\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/senddigitalmoney/SendDigitalMoneyEntityData;", "", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;", "p0", "Lid/dana/data/senddigitalmoney/repository/model/result/CardPrefixQueryResult;", "(Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SendDigitalMoneyEntityData {
    Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<CardPrefixQueryResult> KClassImpl$Data$declaredNonStaticMembers$2(CardPrefixQueryRequest p0);
}
