package id.dana.domain.electronicmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.electronicmoney.model.response.BrizziAccessTokenInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/electronicmoney/interactor/GetBrizziAccessToken;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/electronicmoney/model/response/BrizziAccessTokenInfo;", "", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "electronicmoneyRepository", "Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;", "<init>", "(Lid/dana/domain/electronicmoney/ElectronicmoneyRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetBrizziAccessToken extends BaseUseCase<BrizziAccessTokenInfo, String> {
    private final ElectronicmoneyRepository electronicmoneyRepository;

    @Inject
    public GetBrizziAccessToken(ElectronicmoneyRepository electronicmoneyRepository) {
        Intrinsics.checkNotNullParameter(electronicmoneyRepository, "");
        this.electronicmoneyRepository = electronicmoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<BrizziAccessTokenInfo> buildUseCase(String params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.electronicmoneyRepository.getBrizziAccessToken(params).map(new Function() { // from class: id.dana.domain.electronicmoney.interactor.GetBrizziAccessToken$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BrizziAccessTokenInfo m2297buildUseCase$lambda1;
                m2297buildUseCase$lambda1 = GetBrizziAccessToken.m2297buildUseCase$lambda1((BrizziAccessTokenInfo) obj);
                return m2297buildUseCase$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final BrizziAccessTokenInfo m2297buildUseCase$lambda1(BrizziAccessTokenInfo brizziAccessTokenInfo) {
        Intrinsics.checkNotNullParameter(brizziAccessTokenInfo, "");
        String substring = brizziAccessTokenInfo.getConsumerKey().substring(16);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        brizziAccessTokenInfo.setConsumerKey(substring);
        String substring2 = brizziAccessTokenInfo.getConsumerSecret().substring(16);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        brizziAccessTokenInfo.setConsumerSecret(substring2);
        return brizziAccessTokenInfo;
    }
}
