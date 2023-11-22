package id.dana.domain.account.interactor;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.model.Transaction;
import id.dana.domain.core.usecase.BaseUseCase;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/account/interactor/SaveLastTransaction;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/account/interactor/SaveLastTransaction$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/account/interactor/SaveLastTransaction$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/account/AccountRepository;", "accountRepository", "Lid/dana/domain/account/AccountRepository;", "<init>", "(Lid/dana/domain/account/AccountRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaveLastTransaction extends BaseUseCase<Boolean, Params> {
    private final AccountRepository accountRepository;

    @Inject
    public SaveLastTransaction(AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.accountRepository = accountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> saveLastTransaction = this.accountRepository.saveLastTransaction(params.getTransaction());
        Intrinsics.checkNotNullExpressionValue(saveLastTransaction, "");
        return saveLastTransaction;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/account/interactor/SaveLastTransaction$Params;", "", "Lid/dana/domain/account/model/Transaction;", SemanticAttributes.MessagingRocketmqMessageTypeValues.TRANSACTION, "Lid/dana/domain/account/model/Transaction;", "getTransaction$domain_productionRelease", "()Lid/dana/domain/account/model/Transaction;", "<init>", "(Lid/dana/domain/account/model/Transaction;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Transaction transaction;

        public /* synthetic */ Params(Transaction transaction, DefaultConstructorMarker defaultConstructorMarker) {
            this(transaction);
        }

        @JvmStatic
        public static final Params lastTransaction(String str, String str2) {
            return INSTANCE.lastTransaction(str, str2);
        }

        private Params(Transaction transaction) {
            this.transaction = transaction;
        }

        @JvmName(name = "getTransaction$domain_productionRelease")
        /* renamed from: getTransaction$domain_productionRelease  reason: from getter */
        public final Transaction getTransaction() {
            return this.transaction;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/account/interactor/SaveLastTransaction$Params$Companion;", "", "", "type", MaintenanceBroadcastResult.KEY_DATE, "Lid/dana/domain/account/interactor/SaveLastTransaction$Params;", "lastTransaction", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/account/interactor/SaveLastTransaction$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params lastTransaction(String type, String date) {
                Intrinsics.checkNotNullParameter(type, "");
                Intrinsics.checkNotNullParameter(date, "");
                return new Params(new Transaction(type, date), null);
            }
        }
    }
}
