package id.dana.domain.paylater.interactor;

import id.dana.domain.core.usecase.BlockingUseCase;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.UserLoanInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/paylater/interactor/GetUserLoanInfo;", "Lid/dana/domain/core/usecase/BlockingUseCase;", "Lid/dana/domain/paylater/model/UserLoanInfo;", "Lid/dana/domain/paylater/interactor/GetUserLoanInfo$Params;", "params", "Lio/reactivex/Single;", "buildUseCase", "(Lid/dana/domain/paylater/interactor/GetUserLoanInfo$Params;)Lio/reactivex/Single;", "Lid/dana/domain/paylater/PaylaterRepository;", "payLaterRepository", "Lid/dana/domain/paylater/PaylaterRepository;", "<init>", "(Lid/dana/domain/paylater/PaylaterRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetUserLoanInfo extends BlockingUseCase<UserLoanInfo, Params> {
    private final PaylaterRepository payLaterRepository;

    @Inject
    public GetUserLoanInfo(PaylaterRepository paylaterRepository) {
        Intrinsics.checkNotNullParameter(paylaterRepository, "");
        this.payLaterRepository = paylaterRepository;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    @Override // id.dana.domain.core.usecase.BlockingUseCase
    public final Single<UserLoanInfo> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Single firstOrError = this.payLaterRepository.getPayLaterLoanStatus().flatMap(new Function() { // from class: id.dana.domain.paylater.interactor.GetUserLoanInfo$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2388buildUseCase$lambda1;
                m2388buildUseCase$lambda1 = GetUserLoanInfo.m2388buildUseCase$lambda1(GetUserLoanInfo.Params.this, (List) obj);
                return m2388buildUseCase$lambda1;
            }
        }).firstOrError();
        ?? r2 = 0;
        UserLoanInfo userLoanInfo = new UserLoanInfo(r2, r2, 3, r2);
        ObjectHelper.PlaceComponentResult(userLoanInfo, "value is null");
        Single<UserLoanInfo> BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(firstOrError, null, userLoanInfo));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final ObservableSource m2388buildUseCase$lambda1(Params params, List list) {
        Object obj;
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.contains((CharSequence) params.getSelectedService(), (CharSequence) ((LoanStatusWhitelist) obj).getType(), true)) {
                break;
            }
        }
        LoanStatusWhitelist loanStatusWhitelist = (LoanStatusWhitelist) obj;
        return Observable.just(new UserLoanInfo(loanStatusWhitelist != null ? Boolean.valueOf(loanStatusWhitelist.isWhitelistedUser()) : null, loanStatusWhitelist != null ? loanStatusWhitelist.isStatusRegistered() : null));
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/paylater/interactor/GetUserLoanInfo$Params;", "", "", "component1", "()Ljava/lang/String;", "selectedService", "copy", "(Ljava/lang/String;)Lid/dana/domain/paylater/interactor/GetUserLoanInfo$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSelectedService", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String selectedService;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.selectedService;
            }
            return params.copy(str);
        }

        /* renamed from: component1  reason: from getter */
        public final String getSelectedService() {
            return this.selectedService;
        }

        public final Params copy(String selectedService) {
            Intrinsics.checkNotNullParameter(selectedService, "");
            return new Params(selectedService);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.selectedService, ((Params) other).selectedService);
        }

        public final int hashCode() {
            return this.selectedService.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(selectedService=");
            sb.append(this.selectedService);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.selectedService = str;
        }

        @JvmName(name = "getSelectedService")
        public final String getSelectedService() {
            return this.selectedService;
        }
    }
}
