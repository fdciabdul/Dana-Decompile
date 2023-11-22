package id.dana.wallet_v3.presenter;

import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.wallet.mapper.KtpInfoModelMapperKt;
import id.dana.wallet_v3.model.KtpInfoModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final /* synthetic */ class KtpDetailPresenter$getKtpDetailAsset$1$pocketQueryListKtpInfoModel$1 extends FunctionReferenceImpl implements Function1<KtpInfo, KtpInfoModel> {
    public static final KtpDetailPresenter$getKtpDetailAsset$1$pocketQueryListKtpInfoModel$1 INSTANCE = new KtpDetailPresenter$getKtpDetailAsset$1$pocketQueryListKtpInfoModel$1();

    KtpDetailPresenter$getKtpDetailAsset$1$pocketQueryListKtpInfoModel$1() {
        super(1, KtpInfoModelMapperKt.class, "toKtpInfoModel", "toKtpInfoModel(Lid/dana/domain/wallet_v3/model/KtpInfo;)Lid/dana/wallet_v3/model/KtpInfoModel;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final KtpInfoModel invoke(KtpInfo ktpInfo) {
        Intrinsics.checkNotNullParameter(ktpInfo, "");
        return KtpInfoModelMapperKt.BuiltInFictitiousFunctionClassFactory(ktpInfo);
    }
}
