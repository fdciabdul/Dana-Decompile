package id.dana.data.senddigitalmoney.repository.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.senddigitalmoney.repository.model.result.CardPrefixQueryResult;
import id.dana.domain.senddigitalmoney.model.CardPrefixQueryInfo;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/senddigitalmoney/repository/mapper/CardPrefixQueryResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/senddigitalmoney/repository/model/result/CardPrefixQueryResult;", "Lid/dana/domain/senddigitalmoney/model/CardPrefixQueryInfo;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardPrefixQueryResultMapper extends BaseMapper<CardPrefixQueryResult, CardPrefixQueryInfo> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ CardPrefixQueryInfo map(CardPrefixQueryResult cardPrefixQueryResult) {
        CardPrefixQueryResult cardPrefixQueryResult2 = cardPrefixQueryResult;
        if (cardPrefixQueryResult2 != null) {
            return new CardPrefixQueryInfo(cardPrefixQueryResult2.getCardNoPrefix());
        }
        return null;
    }

    @Inject
    public CardPrefixQueryResultMapper() {
    }
}
