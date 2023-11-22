package id.dana.domain.electronicmoney;

import id.dana.domain.electronicmoney.model.request.BrizziReversalInfo;
import id.dana.domain.electronicmoney.model.response.BrizziAccessTokenInfo;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyBaseResult;
import id.dana.domain.electronicmoney.model.response.ElectronicMoneyConfig;
import id.dana.domain.electronicmoney.model.response.EmoneyCardInfo;
import id.dana.domain.electronicmoney.model.response.EmoneyGenerateTransId;
import id.dana.domain.electronicmoney.model.response.EmoneyReversal;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J;\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u00050\u0007H&¢\u0006\u0004\b\u0017\u0010\u0011J;\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H&¢\u0006\u0004\b\u0019\u0010\nJC\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "", "", "cardType", "cardProvider", "", "data", "Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyBaseResult;", "confirmUpdateBalanceEmoney", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;", "brizziReversalInfo", "doBrizziManualReversal", "(Lid/dana/domain/electronicmoney/model/request/BrizziReversalInfo;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/EmoneyGenerateTransId;", "generateEmoneyTransId", "()Lio/reactivex/Observable;", "lowKey", "Lid/dana/domain/electronicmoney/model/response/BrizziAccessTokenInfo;", "getBrizziAccessToken", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/model/response/ElectronicMoneyConfig;", "getElectronicMoneyConfig", "Lid/dana/domain/electronicmoney/model/response/EmoneyReversal;", "getReversalEmoney", "state", "Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "getTopUpCommandEmoney", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "inquireBalance", "(Ljava/util/Map;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ElectronicmoneyRepository {
    Observable<ElectronicMoneyBaseResult> confirmUpdateBalanceEmoney(String cardType, String cardProvider, Map<String, String> data);

    Observable<ElectronicMoneyBaseResult> doBrizziManualReversal(BrizziReversalInfo brizziReversalInfo);

    Observable<EmoneyGenerateTransId> generateEmoneyTransId();

    Observable<BrizziAccessTokenInfo> getBrizziAccessToken(String lowKey);

    Observable<Map<String, ElectronicMoneyConfig>> getElectronicMoneyConfig();

    Observable<EmoneyReversal> getReversalEmoney(String cardType, String cardProvider, Map<String, String> data);

    Observable<EmoneyCardInfo> getTopUpCommandEmoney(String cardType, String cardProvider, String state, Map<String, String> data);

    Observable<EmoneyCardInfo> inquireBalance(Map<String, String> data);
}
