package id.dana.playstorereview.mapper;

import id.dana.domain.playstorereview.model.AppReviewInfo;
import id.dana.playstorereview.model.AppReviewInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/playstorereview/model/AppReviewInfo;", "Lid/dana/playstorereview/model/AppReviewInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/playstorereview/model/AppReviewInfo;)Lid/dana/playstorereview/model/AppReviewInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppReviewInfoModelMapperKt {
    public static final AppReviewInfoModel BuiltInFictitiousFunctionClassFactory(AppReviewInfo appReviewInfo) {
        Intrinsics.checkNotNullParameter(appReviewInfo, "");
        return new AppReviewInfoModel(appReviewInfo.getShow(), appReviewInfo.getInApp());
    }
}
