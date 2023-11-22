package id.dana.data.holdlogin.v1;

import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.base.AuthenticatedEntityRepository;
import id.dana.data.errorconfig.ErrorConfigFactory;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.holdlogin.v2.HoldLoginFeatureFlag;
import id.dana.data.login.source.LoginEntityDataFactory;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Singleton
@Deprecated(level = DeprecationLevel.WARNING, message = "This class has deprecated since Hold Login V2")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/base/AuthenticatedEntityRepository;", "T", "Lkotlinx/coroutines/flow/Flow;", "p0", "PlaceComponentResult", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/login/source/LoginEntityDataFactory;", "p1", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "p2", "Lid/dana/data/errorconfig/ErrorConfigFactory;", "p3", "Lid/dana/data/holdlogin/v2/HoldLoginFeatureFlag;", "p4", "<init>", "(Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/login/source/LoginEntityDataFactory;Lid/dana/data/foundation/facade/SecurityGuardFacade;Lid/dana/data/errorconfig/ErrorConfigFactory;Lid/dana/data/holdlogin/v2/HoldLoginFeatureFlag;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HoldLoginV1EntityRepository extends AuthenticatedEntityRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public HoldLoginV1EntityRepository(AccountEntityDataFactory accountEntityDataFactory, LoginEntityDataFactory loginEntityDataFactory, SecurityGuardFacade securityGuardFacade, ErrorConfigFactory errorConfigFactory, HoldLoginFeatureFlag holdLoginFeatureFlag) {
        super(accountEntityDataFactory, loginEntityDataFactory, securityGuardFacade, errorConfigFactory, holdLoginFeatureFlag);
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(loginEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(securityGuardFacade, "");
        Intrinsics.checkNotNullParameter(errorConfigFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginFeatureFlag, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Flow<T> PlaceComponentResult(Flow<? extends T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return !this.holdLoginFeatureFlag.BuiltInFictitiousFunctionClassFactory() ? FlowKt.m4649catch(p0, new HoldLoginV1EntityRepository$authenticatedRequest$1(this, p0, null)) : p0;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Ref.BooleanRef booleanRef) {
        Intrinsics.checkNotNullParameter(booleanRef, "");
        booleanRef.element = true;
    }

    public static final /* synthetic */ Flow getAuthRequestContext(HoldLoginV1EntityRepository holdLoginV1EntityRepository, Throwable th, Flow flow) {
        Observable error = Observable.error(th);
        Intrinsics.checkNotNullExpressionValue(error, "");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        error.onErrorResumeNext(holdLoginV1EntityRepository.holdLoginAndRetry(error)).doFinally(new Action() { // from class: id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                HoldLoginV1EntityRepository.MyBillsEntityDataFactory(Ref.BooleanRef.this);
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory()).subscribe();
        do {
        } while (!booleanRef.element);
        return flow;
    }
}
