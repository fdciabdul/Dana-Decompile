package id.dana.domain.qrbarcode.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.model.MccListConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172*\u0012\u0004\u0012\u00020\u0002\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00050\u0001:\u0001\u0017B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ3\u0010\n\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\f\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002¢\u0006\u0004\b\f\u0010\u000bJ3\u0010\r\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000bJA\u0010\u0010\u001a\u00020\u00022\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/domain/qrbarcode/interactor/ValidateNativelyDecodedQr;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/util/HashMap;)Lio/reactivex/Observable;", "isCrossBorder", "(Ljava/util/HashMap;)Z", "isMpm", "isStaticQr", "", "mccList", "isTciCo", "(Ljava/util/HashMap;Ljava/util/List;)Z", "Lid/dana/domain/qrbarcode/interactor/GetDecodeTciCoListConfig;", "getDecodeTciCoListConfig", "Lid/dana/domain/qrbarcode/interactor/GetDecodeTciCoListConfig;", "<init>", "(Lid/dana/domain/qrbarcode/interactor/GetDecodeTciCoListConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ValidateNativelyDecodedQr extends BaseUseCase<Boolean, HashMap<String, String>> {
    private static final String COUNTRY_CODE_TAG = "58";
    private static final String COUNTRY_CODE_VALUE_ID = "ID";
    private static final String MERCHANT_CATEGORY_CODE_TAG = "52";
    private static final String POINT_OF_INITIATION_METHOD_TAG = "01";
    private static final String POINT_OF_INITIATION_METHOD_VALUE_STATIC = "11";
    private final GetDecodeTciCoListConfig getDecodeTciCoListConfig;

    @Inject
    public ValidateNativelyDecodedQr(GetDecodeTciCoListConfig getDecodeTciCoListConfig) {
        Intrinsics.checkNotNullParameter(getDecodeTciCoListConfig, "");
        this.getDecodeTciCoListConfig = getDecodeTciCoListConfig;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "");
        if (isStaticQr(params) && isMpm(params) && !isCrossBorder(params)) {
            Observable flatMap = this.getDecodeTciCoListConfig.buildUseCase(NoParams.INSTANCE).flatMap(new Function() { // from class: id.dana.domain.qrbarcode.interactor.ValidateNativelyDecodedQr$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2441buildUseCase$lambda0;
                    m2441buildUseCase$lambda0 = ValidateNativelyDecodedQr.m2441buildUseCase$lambda0(ValidateNativelyDecodedQr.this, params, (MccListConfig) obj);
                    return m2441buildUseCase$lambda0;
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            return flatMap;
        }
        Observable<Boolean> just = Observable.just(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2441buildUseCase$lambda0(ValidateNativelyDecodedQr validateNativelyDecodedQr, HashMap hashMap, MccListConfig mccListConfig) {
        Intrinsics.checkNotNullParameter(validateNativelyDecodedQr, "");
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(mccListConfig, "");
        return Observable.just(Boolean.valueOf(!validateNativelyDecodedQr.isTciCo(hashMap, mccListConfig.getMccList())));
    }

    private final boolean isStaticQr(HashMap<String, String> params) {
        return Intrinsics.areEqual(params.get("01"), "11");
    }

    private final boolean isMpm(HashMap<String, String> params) {
        return params.get(MERCHANT_CATEGORY_CODE_TAG) != null;
    }

    private final boolean isCrossBorder(HashMap<String, String> params) {
        return !Intrinsics.areEqual(params.get(COUNTRY_CODE_TAG), "ID");
    }

    private final boolean isTciCo(HashMap<String, String> params, List<String> mccList) {
        return CollectionsKt.contains(mccList, params.get(MERCHANT_CATEGORY_CODE_TAG));
    }
}
