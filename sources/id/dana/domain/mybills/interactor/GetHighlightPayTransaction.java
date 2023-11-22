package id.dana.domain.mybills.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.model.HighlightTransactionPay;
import id.dana.domain.mybills.model.HighlightTransactionPayRequest;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/mybills/interactor/GetHighlightPayTransaction;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/mybills/model/HighlightTransactionPay;", "Lid/dana/domain/mybills/interactor/GetHighlightPayTransaction$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/mybills/interactor/GetHighlightPayTransaction$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/MyBillsRepository;", "repository", "Lid/dana/domain/mybills/MyBillsRepository;", "<init>", "(Lid/dana/domain/mybills/MyBillsRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetHighlightPayTransaction extends BaseUseCase<HighlightTransactionPay, Params> {
    private final MyBillsRepository repository;

    @Inject
    public GetHighlightPayTransaction(MyBillsRepository myBillsRepository) {
        Intrinsics.checkNotNullParameter(myBillsRepository, "");
        this.repository = myBillsRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<HighlightTransactionPay> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.repository.getHighlightTransactionPay(params.getHighlightTransactionPayRequest$domain_productionRelease());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/mybills/interactor/GetHighlightPayTransaction$Params;", "", "Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;", "component1$domain_productionRelease", "()Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;", "highlightTransactionPayRequest", "copy", "(Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;)Lid/dana/domain/mybills/interactor/GetHighlightPayTransaction$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;", "getHighlightTransactionPayRequest$domain_productionRelease", "<init>", "(Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final HighlightTransactionPayRequest highlightTransactionPayRequest;

        public static /* synthetic */ Params copy$default(Params params, HighlightTransactionPayRequest highlightTransactionPayRequest, int i, Object obj) {
            if ((i & 1) != 0) {
                highlightTransactionPayRequest = params.highlightTransactionPayRequest;
            }
            return params.copy(highlightTransactionPayRequest);
        }

        /* renamed from: component1$domain_productionRelease  reason: from getter */
        public final HighlightTransactionPayRequest getHighlightTransactionPayRequest() {
            return this.highlightTransactionPayRequest;
        }

        public final Params copy(HighlightTransactionPayRequest highlightTransactionPayRequest) {
            Intrinsics.checkNotNullParameter(highlightTransactionPayRequest, "");
            return new Params(highlightTransactionPayRequest);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.highlightTransactionPayRequest, ((Params) other).highlightTransactionPayRequest);
        }

        public final int hashCode() {
            return this.highlightTransactionPayRequest.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(highlightTransactionPayRequest=");
            sb.append(this.highlightTransactionPayRequest);
            sb.append(')');
            return sb.toString();
        }

        public Params(HighlightTransactionPayRequest highlightTransactionPayRequest) {
            Intrinsics.checkNotNullParameter(highlightTransactionPayRequest, "");
            this.highlightTransactionPayRequest = highlightTransactionPayRequest;
        }

        @JvmName(name = "getHighlightTransactionPayRequest$domain_productionRelease")
        public final HighlightTransactionPayRequest getHighlightTransactionPayRequest$domain_productionRelease() {
            return this.highlightTransactionPayRequest;
        }
    }
}
