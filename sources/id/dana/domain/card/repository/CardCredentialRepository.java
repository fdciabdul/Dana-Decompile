package id.dana.domain.card.repository;

import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/card/repository/CardCredentialRepository;", "", "", "", "cardCredentials", "Lio/reactivex/Observable;", "encryptCardCredentials", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "encryptCardCredentialsFlow", "(Ljava/util/Map;)Lkotlinx/coroutines/flow/Flow;", "getCardCredentialPublicKey", "()Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CardCredentialRepository {
    Observable<String> encryptCardCredentials(Map<String, String> cardCredentials);

    Flow<String> encryptCardCredentialsFlow(Map<String, String> cardCredentials);

    Observable<String> getCardCredentialPublicKey();
}
