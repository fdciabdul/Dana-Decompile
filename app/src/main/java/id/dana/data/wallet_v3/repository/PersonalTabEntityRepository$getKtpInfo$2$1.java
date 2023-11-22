package id.dana.data.wallet_v3.repository;

import id.dana.data.wallet.mapper.KtpInfoMapperKt;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.domain.wallet_v3.model.KtpInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class PersonalTabEntityRepository$getKtpInfo$2$1 extends FunctionReferenceImpl implements Function1<KtpResult, KtpInfo> {
    public static final PersonalTabEntityRepository$getKtpInfo$2$1 INSTANCE = new PersonalTabEntityRepository$getKtpInfo$2$1();

    PersonalTabEntityRepository$getKtpInfo$2$1() {
        super(1, KtpInfoMapperKt.class, "toKtpInfo", "toKtpInfo(Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;)Lid/dana/domain/wallet_v3/model/KtpInfo;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final KtpInfo invoke(KtpResult ktpResult) {
        Intrinsics.checkNotNullParameter(ktpResult, "");
        return KtpInfoMapperKt.BuiltInFictitiousFunctionClassFactory(ktpResult);
    }
}
