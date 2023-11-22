package id.dana.data.senddigitalmoney.repository.source.network;

import id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData;
import id.dana.data.senddigitalmoney.repository.model.request.CardPrefixQueryRequest;
import id.dana.data.senddigitalmoney.repository.model.result.CardPrefixQueryResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0004\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/senddigitalmoney/repository/source/network/NetworkDigitalMoneyEntityData;", "Lid/dana/data/senddigitalmoney/SendDigitalMoneyEntityData;", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;", "p0", "Lid/dana/data/senddigitalmoney/repository/model/result/CardPrefixQueryResult;", "(Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;)Lio/reactivex/Observable;", "Lid/dana/data/senddigitalmoney/repository/source/network/CardQueryNoPrefixApi;", "PlaceComponentResult", "Lid/dana/data/senddigitalmoney/repository/source/network/CardQueryNoPrefixApi;", "getAuthRequestContext", "<init>", "(Lid/dana/data/senddigitalmoney/repository/source/network/CardQueryNoPrefixApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkDigitalMoneyEntityData implements SendDigitalMoneyEntityData {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CardQueryNoPrefixApi getAuthRequestContext;

    @Inject
    public NetworkDigitalMoneyEntityData(CardQueryNoPrefixApi cardQueryNoPrefixApi) {
        Intrinsics.checkNotNullParameter(cardQueryNoPrefixApi, "");
        this.getAuthRequestContext = cardQueryNoPrefixApi;
    }

    @Override // id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData
    public final Observable<CardPrefixQueryResult> KClassImpl$Data$declaredNonStaticMembers$2(CardPrefixQueryRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = this.getAuthRequestContext.PlaceComponentResult(p0).map(new Function() { // from class: id.dana.data.senddigitalmoney.repository.source.network.NetworkDigitalMoneyEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkDigitalMoneyEntityData.BuiltInFictitiousFunctionClassFactory((ResultResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData
    public final Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    public static /* synthetic */ CardPrefixQueryResult BuiltInFictitiousFunctionClassFactory(ResultResponse resultResponse) {
        Intrinsics.checkNotNullParameter(resultResponse, "");
        return (CardPrefixQueryResult) resultResponse.getResult();
    }
}
