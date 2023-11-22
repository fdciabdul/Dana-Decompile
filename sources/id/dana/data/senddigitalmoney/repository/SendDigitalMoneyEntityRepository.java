package id.dana.data.senddigitalmoney.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.senddigitalmoney.SendDigitalMoneyEntityData;
import id.dana.data.senddigitalmoney.repository.mapper.CardPrefixQueryResultMapper;
import id.dana.data.senddigitalmoney.repository.model.request.CardPrefixQueryRequest;
import id.dana.data.senddigitalmoney.repository.model.result.CardPrefixQueryResult;
import id.dana.data.senddigitalmoney.repository.source.SendDigitalMoneyEntityDataFactory;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import id.dana.domain.senddigitalmoney.model.CardPrefixQueryInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0011\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015"}, d2 = {"Lid/dana/data/senddigitalmoney/repository/SendDigitalMoneyEntityRepository;", "Lid/dana/domain/senddigitalmoney/SendDigitalMoneyRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/domain/senddigitalmoney/model/CardPrefixQueryInfo;", "doQueryCardWithoutPrefix", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "getCardWithoutPrefixFeaturedEnabled", "()Lio/reactivex/Observable;", "Lid/dana/data/senddigitalmoney/repository/mapper/CardPrefixQueryResultMapper;", "PlaceComponentResult", "Lid/dana/data/senddigitalmoney/repository/mapper/CardPrefixQueryResultMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "getAuthRequestContext", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "MyBillsEntityDataFactory", "Lid/dana/data/senddigitalmoney/SendDigitalMoneyEntityData;", "Lkotlin/Lazy;", "Lid/dana/data/senddigitalmoney/repository/source/SendDigitalMoneyEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/senddigitalmoney/repository/source/SendDigitalMoneyEntityDataFactory;", "p1", "p2", "<init>", "(Lid/dana/data/senddigitalmoney/repository/source/SendDigitalMoneyEntityDataFactory;Lid/dana/data/senddigitalmoney/repository/mapper/CardPrefixQueryResultMapper;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendDigitalMoneyEntityRepository implements SendDigitalMoneyRepository, HoldLoginV1Repository {
    private final SendDigitalMoneyEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CardPrefixQueryResultMapper KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository MyBillsEntityDataFactory;

    @Inject
    public SendDigitalMoneyEntityRepository(SendDigitalMoneyEntityDataFactory sendDigitalMoneyEntityDataFactory, CardPrefixQueryResultMapper cardPrefixQueryResultMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(sendDigitalMoneyEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(cardPrefixQueryResultMapper, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = sendDigitalMoneyEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cardPrefixQueryResultMapper;
        this.MyBillsEntityDataFactory = holdLoginV1EntityRepository;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<SendDigitalMoneyEntityData>() { // from class: id.dana.data.senddigitalmoney.repository.SendDigitalMoneyEntityRepository$networkDigitalMoneyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SendDigitalMoneyEntityData invoke() {
                SendDigitalMoneyEntityDataFactory sendDigitalMoneyEntityDataFactory2;
                sendDigitalMoneyEntityDataFactory2 = SendDigitalMoneyEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return sendDigitalMoneyEntityDataFactory2.createData2("network");
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<SendDigitalMoneyEntityData>() { // from class: id.dana.data.senddigitalmoney.repository.SendDigitalMoneyEntityRepository$splitDigitalMoneyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SendDigitalMoneyEntityData invoke() {
                SendDigitalMoneyEntityDataFactory sendDigitalMoneyEntityDataFactory2;
                sendDigitalMoneyEntityDataFactory2 = SendDigitalMoneyEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return sendDigitalMoneyEntityDataFactory2.createData2("split");
            }
        });
    }

    @Override // id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository
    public final Observable<CardPrefixQueryInfo> doQueryCardWithoutPrefix(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<CardPrefixQueryResult> KClassImpl$Data$declaredNonStaticMembers$2 = ((SendDigitalMoneyEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(new CardPrefixQueryRequest(p0));
        final CardPrefixQueryResultMapper cardPrefixQueryResultMapper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ObservableSource map = KClassImpl$Data$declaredNonStaticMembers$2.map(new Function() { // from class: id.dana.data.senddigitalmoney.repository.SendDigitalMoneyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CardPrefixQueryResultMapper.this.apply((CardPrefixQueryResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<CardPrefixQueryInfo> authenticatedRequest = this.MyBillsEntityDataFactory.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository
    public final Observable<Boolean> getCardWithoutPrefixFeaturedEnabled() {
        return ((SendDigitalMoneyEntityData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
