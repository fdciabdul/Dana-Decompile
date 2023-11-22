package id.dana.data.electronicmoney;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.electronicmoney.extension.ElectronicMoneyExtensionKt;
import id.dana.data.electronicmoney.network.response.BrizziGetAccessTokenResponse;
import id.dana.data.electronicmoney.network.response.ElectronicMoneyGetBizIdResponse;
import id.dana.data.electronicmoney.network.response.EmoneyCardInfoResponse;
import id.dana.data.electronicmoney.network.response.EmoneyReversalResponse;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.electronicmoney.model.request.BrizziReversalInfo;
import id.dana.domain.electronicmoney.model.response.BrizziAccessTokenInfo;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyBaseResult;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyConfig;
import id.dana.domain.electronicmoney.model.response.EmoneyCardInfo;
import id.dana.domain.electronicmoney.model.response.EmoneyGenerateTransId;
import id.dana.domain.electronicmoney.model.response.EmoneyReversal;
import id.dana.domain.util.RSAUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020#\u0012\u0006\u0010\u0005\u001a\u00020\u001f\u0012\u0006\u0010\u0007\u001a\u00020'¢\u0006\u0004\b,\u0010-J;\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u00060\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJC\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\b2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010$\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0013\u0010 \u001a\u00020*X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010+"}, d2 = {"Lid/dana/data/electronicmoney/ElectronicmoneyEntityRepository;", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "p1", "", "p2", "Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyBaseResult;", "confirmUpdateBalanceEmoney", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "doBrizziManualReversal", "(Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/EmoneyGenerateTransId;", "generateEmoneyTransId", "()Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/BrizziAccessTokenInfo;", "getBrizziAccessToken", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyConfig;", "getElectronicMoneyConfig", "Lid/dana/domain/electronicmoney/model/response/EmoneyReversal;", "getReversalEmoney", "p3", "Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "getTopUpCommandEmoney", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "inquireBalance", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "getAuthRequestContext", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/electronicmoney/ElectronicmoneyEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/electronicmoney/ElectronicmoneyEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/electronicmoney/ElectronicmoneyData;", "Lkotlin/Lazy;", "<init>", "(Lid/dana/data/electronicmoney/ElectronicmoneyEntityDataFactory;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ElectronicmoneyEntityRepository implements ElectronicmoneyRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ElectronicmoneyEntityDataFactory MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ConfigEntityDataFactory PlaceComponentResult;

    @Inject
    public ElectronicmoneyEntityRepository(ElectronicmoneyEntityDataFactory electronicmoneyEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(electronicmoneyEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = electronicmoneyEntityDataFactory;
        this.PlaceComponentResult = configEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<ElectronicmoneyData>() { // from class: id.dana.data.electronicmoney.ElectronicmoneyEntityRepository$networkElectronicmoneyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ElectronicmoneyData invoke() {
                ElectronicmoneyEntityDataFactory electronicmoneyEntityDataFactory2;
                electronicmoneyEntityDataFactory2 = ElectronicmoneyEntityRepository.this.MyBillsEntityDataFactory;
                return Intrinsics.areEqual("network", "network") ? electronicmoneyEntityDataFactory2.BuiltInFictitiousFunctionClassFactory : electronicmoneyEntityDataFactory2.PlaceComponentResult;
            }
        });
    }

    public static /* synthetic */ EmoneyReversal KClassImpl$Data$declaredNonStaticMembers$2(EmoneyReversalResponse emoneyReversalResponse) {
        Intrinsics.checkNotNullParameter(emoneyReversalResponse, "");
        return ElectronicMoneyExtensionKt.PlaceComponentResult(emoneyReversalResponse);
    }

    public static /* synthetic */ BrizziAccessTokenInfo PlaceComponentResult(String str, BrizziGetAccessTokenResponse brizziGetAccessTokenResponse) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(brizziGetAccessTokenResponse, "");
        return new BrizziAccessTokenInfo(brizziGetAccessTokenResponse.getAccessToken(), RSAUtil.decrypt(brizziGetAccessTokenResponse.getConsumerSecret(), str), RSAUtil.decrypt(brizziGetAccessTokenResponse.getConsumerKey(), str), brizziGetAccessTokenResponse.getUsername(), brizziGetAccessTokenResponse.getReffNumber());
    }

    public static /* synthetic */ EmoneyCardInfo getAuthRequestContext(EmoneyCardInfoResponse emoneyCardInfoResponse) {
        Intrinsics.checkNotNullParameter(emoneyCardInfoResponse, "");
        return ElectronicMoneyExtensionKt.getAuthRequestContext(emoneyCardInfoResponse);
    }

    public static /* synthetic */ EmoneyCardInfo MyBillsEntityDataFactory(EmoneyCardInfoResponse emoneyCardInfoResponse) {
        Intrinsics.checkNotNullParameter(emoneyCardInfoResponse, "");
        return ElectronicMoneyExtensionKt.getAuthRequestContext(emoneyCardInfoResponse);
    }

    public static /* synthetic */ EmoneyGenerateTransId getAuthRequestContext(ElectronicMoneyGetBizIdResponse electronicMoneyGetBizIdResponse) {
        Intrinsics.checkNotNullParameter(electronicMoneyGetBizIdResponse, "");
        return ElectronicMoneyExtensionKt.KClassImpl$Data$declaredNonStaticMembers$2(electronicMoneyGetBizIdResponse);
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<ElectronicMoneyBaseResult> confirmUpdateBalanceEmoney(String p0, String p1, Map<String, String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        return ((ElectronicmoneyData) this.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory(p0, p1, p2);
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<ElectronicMoneyBaseResult> doBrizziManualReversal(BrizziReversalInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((ElectronicmoneyData) this.getAuthRequestContext.getValue()).MyBillsEntityDataFactory(p0);
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<EmoneyGenerateTransId> generateEmoneyTransId() {
        Observable map = ((ElectronicmoneyData) this.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory().map(new Function() { // from class: id.dana.data.electronicmoney.ElectronicmoneyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ElectronicmoneyEntityRepository.getAuthRequestContext((ElectronicMoneyGetBizIdResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<BrizziAccessTokenInfo> getBrizziAccessToken(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = ((ElectronicmoneyData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.electronicmoney.ElectronicmoneyEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ElectronicmoneyEntityRepository.PlaceComponentResult(p0, (BrizziGetAccessTokenResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<Map<String, ElectronicMoneyConfig>> getElectronicMoneyConfig() {
        ConfigEntityData createData2 = this.PlaceComponentResult.createData2("split");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        Observable<Map<String, ElectronicMoneyConfig>> electronicMoneyConfig = createData2.getElectronicMoneyConfig();
        Intrinsics.checkNotNullExpressionValue(electronicMoneyConfig, "");
        return electronicMoneyConfig;
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<EmoneyReversal> getReversalEmoney(String p0, String p1, Map<String, String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable map = ((ElectronicmoneyData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2).map(new Function() { // from class: id.dana.data.electronicmoney.ElectronicmoneyEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ElectronicmoneyEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((EmoneyReversalResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<EmoneyCardInfo> getTopUpCommandEmoney(String p0, String p1, String p2, Map<String, String> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable map = ((ElectronicmoneyData) this.getAuthRequestContext.getValue()).MyBillsEntityDataFactory(p0, p1, p2, p3).map(new Function() { // from class: id.dana.data.electronicmoney.ElectronicmoneyEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ElectronicmoneyEntityRepository.getAuthRequestContext((EmoneyCardInfoResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.electronicmoney.ElectronicmoneyRepository
    public final Observable<EmoneyCardInfo> inquireBalance(Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = ((ElectronicmoneyData) this.getAuthRequestContext.getValue()).getAuthRequestContext(p0).map(new Function() { // from class: id.dana.data.electronicmoney.ElectronicmoneyEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ElectronicmoneyEntityRepository.MyBillsEntityDataFactory((EmoneyCardInfoResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
