package id.dana.data.electronicmoney.mock;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import id.dana.data.electronicmoney.ElectronicmoneyData;
import id.dana.data.electronicmoney.network.response.BrizziGetAccessTokenResponse;
import id.dana.data.electronicmoney.network.response.ElectronicMoneyGetBizIdResponse;
import id.dana.data.electronicmoney.network.response.EmoneyCardInfoResponse;
import id.dana.data.electronicmoney.network.response.EmoneyDataEntity;
import id.dana.data.electronicmoney.network.response.EmoneyReversalResponse;
import id.dana.domain.electronicmoney.model.request.BrizziReversalInfo;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyBaseResult;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0016¢\u0006\u0004\b\t\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\nJC\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0015J+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/data/electronicmoney/mock/MockElectronicmoneyEntityData;", "Lid/dana/data/electronicmoney/ElectronicmoneyData;", "", "p0", "p1", "", "p2", "Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyBaseResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "MyBillsEntityDataFactory", "(Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;)Lio/reactivex/Observable;", "Lid/dana/data/electronicmoney/network/response/ElectronicMoneyGetBizIdResponse;", "()Lio/reactivex/Observable;", "Lid/dana/data/electronicmoney/network/response/BrizziGetAccessTokenResponse;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;", "p3", "Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "getAuthRequestContext", "(Ljava/util/Map;)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MockElectronicmoneyEntityData implements ElectronicmoneyData {
    @Inject
    public MockElectronicmoneyEntityData() {
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<ElectronicMoneyBaseResult> MyBillsEntityDataFactory(BrizziReversalInfo p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ElectronicMoneyBaseResult electronicMoneyBaseResult = new ElectronicMoneyBaseResult(false, null, null, 7, null);
        electronicMoneyBaseResult.setSuccess(true);
        electronicMoneyBaseResult.setErrorCode("errorCode");
        electronicMoneyBaseResult.setErrorMessage("errorMessage");
        Observable<ElectronicMoneyBaseResult> just = Observable.just(electronicMoneyBaseResult);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<ElectronicMoneyGetBizIdResponse> BuiltInFictitiousFunctionClassFactory() {
        Observable<ElectronicMoneyGetBizIdResponse> just = Observable.just(new ElectronicMoneyGetBizIdResponse(""));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<EmoneyCardInfoResponse> getAuthRequestContext(Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<EmoneyCardInfoResponse> just = Observable.just(new EmoneyCardInfoResponse(new EmoneyDataEntity("", "", "", "", "", "", "", "", "", "", "", "", "", "")));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<EmoneyReversalResponse> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, Map<String, String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable<EmoneyReversalResponse> just = Observable.just(new EmoneyReversalResponse(new LinkedHashMap()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<EmoneyCardInfoResponse> MyBillsEntityDataFactory(String p0, String p1, String p2, Map<String, String> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable<EmoneyCardInfoResponse> just = Observable.just(new EmoneyCardInfoResponse(new EmoneyDataEntity("", "", "", "", "", "", "", "", "", "", "", "", "", "")));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<ElectronicMoneyBaseResult> BuiltInFictitiousFunctionClassFactory(String p0, String p1, Map<String, String> p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Observable<ElectronicMoneyBaseResult> just = Observable.just(new ElectronicMoneyBaseResult(false, null, null, 7, null));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    public static /* synthetic */ Observable KClassImpl$Data$declaredNonStaticMembers$2(BrizziGetAccessTokenResponse brizziGetAccessTokenResponse) {
        brizziGetAccessTokenResponse.setReffNumber("reffNumber");
        Observable just = Observable.just(brizziGetAccessTokenResponse);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.electronicmoney.ElectronicmoneyData
    public final Observable<BrizziGetAccessTokenResponse> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable just = Observable.just(new BrizziGetAccessTokenResponse("accessToken", "tokenType", "accessTokenExpireTime", ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME, "consumerSecret", "consumerKey", "username"));
        Intrinsics.checkNotNullExpressionValue(just, "");
        Observable<BrizziGetAccessTokenResponse> flatMap = just.flatMap(new Function() { // from class: id.dana.data.electronicmoney.mock.MockElectronicmoneyEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return MockElectronicmoneyEntityData.KClassImpl$Data$declaredNonStaticMembers$2((BrizziGetAccessTokenResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }
}
