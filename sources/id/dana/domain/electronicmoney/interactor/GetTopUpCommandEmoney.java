package id.dana.domain.electronicmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.electronicmoney.model.response.EmoneyCardInfo;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/electronicmoney/interactor/GetTopUpCommandEmoney;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "Lid/dana/domain/electronicmoney/interactor/GetTopUpCommandEmoney$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/electronicmoney/interactor/GetTopUpCommandEmoney$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "electronicmoneyRepository", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "<init>", "(Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetTopUpCommandEmoney extends BaseUseCase<EmoneyCardInfo, Params> {
    private final ElectronicmoneyRepository electronicmoneyRepository;

    @Inject
    public GetTopUpCommandEmoney(ElectronicmoneyRepository electronicmoneyRepository) {
        Intrinsics.checkNotNullParameter(electronicmoneyRepository, "");
        this.electronicmoneyRepository = electronicmoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<EmoneyCardInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.electronicmoneyRepository.getTopUpCommandEmoney(params.getCardType(), params.getCardProvider(), params.getState(), params.getData());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006"}, d2 = {"Lid/dana/domain/electronicmoney/interactor/GetTopUpCommandEmoney$Params;", "", "", "cardProvider", "Ljava/lang/String;", "getCardProvider", "()Ljava/lang/String;", "cardType", "getCardType", "", "data", "Ljava/util/Map;", "getData", "()Ljava/util/Map;", "state", "getState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Params {
        private final String cardProvider;
        private final String cardType;
        private final Map<String, String> data;
        private final String state;

        public Params(String str, String str2, String str3, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(map, "");
            this.cardType = str;
            this.cardProvider = str2;
            this.state = str3;
            this.data = map;
        }

        @JvmName(name = "getCardType")
        public final String getCardType() {
            return this.cardType;
        }

        @JvmName(name = "getCardProvider")
        public final String getCardProvider() {
            return this.cardProvider;
        }

        @JvmName(name = "getState")
        public final String getState() {
            return this.state;
        }

        @JvmName(name = "getData")
        public final Map<String, String> getData() {
            return this.data;
        }
    }
}
