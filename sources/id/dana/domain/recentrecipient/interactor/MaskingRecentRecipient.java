package id.dana.domain.recentrecipient.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/MaskingRecentRecipient;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "Lid/dana/domain/recentrecipient/interactor/MaskingRecentRecipient$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/recentrecipient/interactor/MaskingRecentRecipient$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "recentRecipientRepository", "Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;", "<init>", "(Lid/dana/domain/recentrecipient/repository/RecentRecipientRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MaskingRecentRecipient extends BaseUseCase<List<RecentRecipient>, Params> {
    private final RecentRecipientRepository recentRecipientRepository;

    @Inject
    public MaskingRecentRecipient(RecentRecipientRepository recentRecipientRepository) {
        Intrinsics.checkNotNullParameter(recentRecipientRepository, "");
        this.recentRecipientRepository = recentRecipientRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<RecentRecipient>> buildUseCase(Params params) {
        Observable<List<RecentRecipient>> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(params, "");
        Single list = Observable.fromIterable(params.getRecentRecipients()).flatMap(new Function() { // from class: id.dana.domain.recentrecipient.interactor.MaskingRecentRecipient$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2448buildUseCase$lambda0;
                m2448buildUseCase$lambda0 = MaskingRecentRecipient.m2448buildUseCase$lambda0(MaskingRecentRecipient.this, (RecentRecipient) obj);
                return m2448buildUseCase$lambda0;
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2448buildUseCase$lambda0(MaskingRecentRecipient maskingRecentRecipient, RecentRecipient recentRecipient) {
        Intrinsics.checkNotNullParameter(maskingRecentRecipient, "");
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        return maskingRecentRecipient.recentRecipientRepository.convertCardIndexNo(recentRecipient);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0005"}, d2 = {"Lid/dana/domain/recentrecipient/interactor/MaskingRecentRecipient$Params;", "", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "component1", "()Ljava/util/List;", "recentRecipients", "copy", "(Ljava/util/List;)Lid/dana/domain/recentrecipient/interactor/MaskingRecentRecipient$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getRecentRecipients", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final List<RecentRecipient> recentRecipients;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = params.recentRecipients;
            }
            return params.copy(list);
        }

        public final List<RecentRecipient> component1() {
            return this.recentRecipients;
        }

        public final Params copy(List<? extends RecentRecipient> recentRecipients) {
            Intrinsics.checkNotNullParameter(recentRecipients, "");
            return new Params(recentRecipients);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.recentRecipients, ((Params) other).recentRecipients);
        }

        public final int hashCode() {
            return this.recentRecipients.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(recentRecipients=");
            sb.append(this.recentRecipients);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Params(List<? extends RecentRecipient> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.recentRecipients = list;
        }

        @JvmName(name = "getRecentRecipients")
        public final List<RecentRecipient> getRecentRecipients() {
            return this.recentRecipients;
        }
    }
}
