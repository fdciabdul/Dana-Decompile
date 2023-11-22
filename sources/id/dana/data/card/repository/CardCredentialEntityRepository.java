package id.dana.data.card.repository;

import android.text.TextUtils;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.encryptcardno.EncryptCardNumber;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.domain.card.repository.CardCredentialRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0015\u001a\u0006*\u00020\u00100\u00108CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u001a\u001a\u0006*\u00020\u00160\u00168CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/data/card/repository/CardCredentialEntityRepository;", "Lid/dana/domain/card/repository/CardCredentialRepository;", "", "", "cardCredentials", "Lio/reactivex/Observable;", "encryptCardCredentials", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "encryptCardCredentialsFlow", "(Ljava/util/Map;)Lkotlinx/coroutines/flow/Flow;", "getCardCredentialPublicKey", "()Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityData;", "localAccountEntityData$delegate", "Lkotlin/Lazy;", "getLocalAccountEntityData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "localAccountEntityData", "Lid/dana/data/security/source/SecurityEntityData;", "networkSecurityEntityData$delegate", "getNetworkSecurityEntityData", "()Lid/dana/data/security/source/SecurityEntityData;", "networkSecurityEntityData", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "securityEntityDataFactory", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "<init>", "(Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/security/source/SecurityEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CardCredentialEntityRepository implements CardCredentialRepository {
    private final AccountEntityDataFactory accountEntityDataFactory;

    /* renamed from: localAccountEntityData$delegate  reason: from kotlin metadata */
    private final Lazy localAccountEntityData;

    /* renamed from: networkSecurityEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkSecurityEntityData;
    private final SecurityEntityDataFactory securityEntityDataFactory;

    @Inject
    public CardCredentialEntityRepository(AccountEntityDataFactory accountEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory) {
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(securityEntityDataFactory, "");
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.securityEntityDataFactory = securityEntityDataFactory;
        this.localAccountEntityData = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.data.card.repository.CardCredentialEntityRepository$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                AccountEntityDataFactory accountEntityDataFactory2;
                accountEntityDataFactory2 = CardCredentialEntityRepository.this.accountEntityDataFactory;
                return accountEntityDataFactory2.createData2("local");
            }
        });
        this.networkSecurityEntityData = LazyKt.lazy(new Function0<SecurityEntityData>() { // from class: id.dana.data.card.repository.CardCredentialEntityRepository$networkSecurityEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SecurityEntityData invoke() {
                SecurityEntityDataFactory securityEntityDataFactory2;
                securityEntityDataFactory2 = CardCredentialEntityRepository.this.securityEntityDataFactory;
                return securityEntityDataFactory2.createData2("network");
            }
        });
    }

    @JvmName(name = "getLocalAccountEntityData")
    private final AccountEntityData getLocalAccountEntityData() {
        return (AccountEntityData) this.localAccountEntityData.getValue();
    }

    @JvmName(name = "getNetworkSecurityEntityData")
    private final SecurityEntityData getNetworkSecurityEntityData() {
        return (SecurityEntityData) this.networkSecurityEntityData.getValue();
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Observable<String> getCardCredentialPublicKey() {
        Observable flatMap = getLocalAccountEntityData().getCardCredentialPublicKey().onErrorReturnItem("").flatMap(new Function() { // from class: id.dana.data.card.repository.CardCredentialEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m825getCardCredentialPublicKey$lambda1;
                m825getCardCredentialPublicKey$lambda1 = CardCredentialEntityRepository.m825getCardCredentialPublicKey$lambda1(CardCredentialEntityRepository.this, (String) obj);
                return m825getCardCredentialPublicKey$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCardCredentialPublicKey$lambda-1  reason: not valid java name */
    public static final ObservableSource m825getCardCredentialPublicKey$lambda1(final CardCredentialEntityRepository cardCredentialEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(cardCredentialEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (TextUtils.isEmpty(str)) {
            return cardCredentialEntityRepository.getNetworkSecurityEntityData().cardCredentialKey().flatMap(new Function() { // from class: id.dana.data.card.repository.CardCredentialEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m826getCardCredentialPublicKey$lambda1$lambda0;
                    m826getCardCredentialPublicKey$lambda1$lambda0 = CardCredentialEntityRepository.m826getCardCredentialPublicKey$lambda1$lambda0(CardCredentialEntityRepository.this, (String) obj);
                    return m826getCardCredentialPublicKey$lambda1$lambda0;
                }
            });
        }
        return Observable.just(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCardCredentialPublicKey$lambda-1$lambda-0  reason: not valid java name */
    public static final ObservableSource m826getCardCredentialPublicKey$lambda1$lambda0(CardCredentialEntityRepository cardCredentialEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(cardCredentialEntityRepository, "");
        return cardCredentialEntityRepository.getLocalAccountEntityData().setCardCredentialPublicKey(str);
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Observable<String> encryptCardCredentials(final Map<String, String> cardCredentials) {
        Intrinsics.checkNotNullParameter(cardCredentials, "");
        Observable flatMap = getCardCredentialPublicKey().flatMap(new Function() { // from class: id.dana.data.card.repository.CardCredentialEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m824encryptCardCredentials$lambda2;
                m824encryptCardCredentials$lambda2 = CardCredentialEntityRepository.m824encryptCardCredentials$lambda2(cardCredentials, (String) obj);
                return m824encryptCardCredentials$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: encryptCardCredentials$lambda-2  reason: not valid java name */
    public static final ObservableSource m824encryptCardCredentials$lambda2(Map map, String str) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Observable.just(EncryptCardNumber.BuiltInFictitiousFunctionClassFactory(map, str, true));
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Flow<String> encryptCardCredentialsFlow(Map<String, String> cardCredentials) {
        Intrinsics.checkNotNullParameter(cardCredentials, "");
        return FlowKt.flow(new CardCredentialEntityRepository$encryptCardCredentialsFlow$1(this, cardCredentials, null));
    }
}
