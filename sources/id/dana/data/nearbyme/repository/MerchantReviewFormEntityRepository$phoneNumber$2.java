package id.dana.data.nearbyme.repository;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u0006*\u00020\u00000\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantReviewFormEntityRepository$phoneNumber$2 extends Lambda implements Function0<String> {
    final /* synthetic */ MerchantReviewFormEntityRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantReviewFormEntityRepository$phoneNumber$2(MerchantReviewFormEntityRepository merchantReviewFormEntityRepository) {
        super(0);
        this.this$0 = merchantReviewFormEntityRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final String m1511invoke$lambda0(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return accountEntity.getPhoneNumber();
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        PreferenceAccountEntityData preferenceAccountEntityData;
        preferenceAccountEntityData = this.this$0.preferenceAccountEntityData;
        return (String) preferenceAccountEntityData.getAccount().map(new Function() { // from class: id.dana.data.nearbyme.repository.MerchantReviewFormEntityRepository$phoneNumber$2$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m1511invoke$lambda0;
                m1511invoke$lambda0 = MerchantReviewFormEntityRepository$phoneNumber$2.m1511invoke$lambda0((AccountEntity) obj);
                return m1511invoke$lambda0;
            }
        }).blockingFirst();
    }
}
