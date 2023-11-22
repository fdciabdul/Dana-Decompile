package id.dana.data.wallet_v3.repository;

import id.dana.data.wallet.mapper.InsuranceAssetMapperKt;
import id.dana.data.wallet_v3.repository.source.network.result.InsuranceResult;
import id.dana.domain.wallet_v3.model.InsuranceAsset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class PersonalTabEntityRepository$getInsuranceAssets$1$1 extends FunctionReferenceImpl implements Function1<InsuranceResult, InsuranceAsset> {
    public static final PersonalTabEntityRepository$getInsuranceAssets$1$1 INSTANCE = new PersonalTabEntityRepository$getInsuranceAssets$1$1();

    PersonalTabEntityRepository$getInsuranceAssets$1$1() {
        super(1, InsuranceAssetMapperKt.class, "toInsuranceAsset", "toInsuranceAsset(Lid/dana/data/wallet_v3/repository/source/network/result/InsuranceResult;)Lid/dana/domain/wallet_v3/model/InsuranceAsset;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final InsuranceAsset invoke(InsuranceResult insuranceResult) {
        Intrinsics.checkNotNullParameter(insuranceResult, "");
        return InsuranceAssetMapperKt.MyBillsEntityDataFactory(insuranceResult);
    }
}
