package id.dana.data.wallet_v3.repository;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.danah5.DanaH5;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0006*\u00020\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", DanaH5.SERVICE_KEY, "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", BridgeDSL.INVOKE, "(Ljava/lang/String;)Lid/dana/data/homeinfo/model/ThirdPartyEntity;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletConfigEntityRepository$getListOfService$2 extends Lambda implements Function1<String, ThirdPartyEntity> {
    final /* synthetic */ WalletConfigEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletConfigEntityRepository$getListOfService$2(WalletConfigEntityRepository walletConfigEntityRepository) {
        super(1);
        this.this$0 = walletConfigEntityRepository;
    }

    @Override // kotlin.jvm.functions.Function1
    public final ThirdPartyEntity invoke(String str) {
        Observable serviceFromServiceKey;
        Intrinsics.checkNotNullParameter(str, "");
        serviceFromServiceKey = this.this$0.getServiceFromServiceKey(str);
        return (ThirdPartyEntity) serviceFromServiceKey.filter(new Predicate() { // from class: id.dana.data.wallet_v3.repository.WalletConfigEntityRepository$getListOfService$2$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m2177invoke$lambda0;
                m2177invoke$lambda0 = WalletConfigEntityRepository$getListOfService$2.m2177invoke$lambda0((ThirdPartyEntity) obj);
                return m2177invoke$lambda0;
            }
        }).blockingFirst();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final boolean m2177invoke$lambda0(ThirdPartyEntity thirdPartyEntity) {
        Intrinsics.checkNotNullParameter(thirdPartyEntity, "");
        return thirdPartyEntity.getKey() != null;
    }
}
