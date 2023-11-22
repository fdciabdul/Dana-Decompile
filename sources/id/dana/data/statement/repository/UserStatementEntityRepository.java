package id.dana.data.statement.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.statement.repository.source.UserStatementDataFactory;
import id.dana.data.statement.repository.source.UserStatementEntityData;
import id.dana.data.statement.repository.source.mock.MockUserStatementEntityData;
import id.dana.data.statement.repository.source.network.response.StatementDetailResult;
import id.dana.data.statement.repository.source.network.response.StatementDetailResultKt;
import id.dana.data.statement.repository.source.network.response.UserAccumulateQuerySummaryResult;
import id.dana.data.statement.repository.source.network.response.UserAccumulateQuerySummaryResultKt;
import id.dana.domain.statement.StatementType;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.statement.model.UserStatement;
import id.dana.domain.statement.model.UserStatementDetail;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u001b\u0012\u0006\u0010\b\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0016\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/data/statement/repository/UserStatementEntityRepository;", "Lid/dana/domain/statement/UserStatementRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/data/statement/repository/source/UserStatementEntityData;", "PlaceComponentResult", "()Lid/dana/data/statement/repository/source/UserStatementEntityData;", "", "p0", "p1", "Lio/reactivex/Observable;", "", "Lid/dana/domain/statement/model/UserStatement;", "getAllStatementSummary", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/domain/statement/StatementType;", "p2", "Lid/dana/domain/statement/model/UserStatementDetail;", "getStatementDetail", "(JJLid/dana/domain/statement/StatementType;)Lio/reactivex/Observable;", "getStatementSummary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "MyBillsEntityDataFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/statement/repository/source/UserStatementDataFactory;", "getAuthRequestContext", "Lid/dana/data/statement/repository/source/UserStatementDataFactory;", "<init>", "(Lid/dana/data/statement/repository/source/UserStatementDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserStatementEntityRepository implements UserStatementRepository, HoldLoginV1Repository {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final UserStatementDataFactory BuiltInFictitiousFunctionClassFactory;

    @Inject
    public UserStatementEntityRepository(UserStatementDataFactory userStatementDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(userStatementDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = userStatementDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.statement.UserStatementRepository
    public final Observable<UserStatement> getStatementSummary(String p0, String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        ObservableSource map = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2).map(new Function() { // from class: id.dana.data.statement.repository.UserStatementEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserStatementEntityRepository.getAuthRequestContext(p2, (UserAccumulateQuerySummaryResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<UserStatement> authenticatedRequest = this.KClassImpl$Data$declaredNonStaticMembers$2.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.statement.UserStatementRepository
    public final Observable<UserStatementDetail> getStatementDetail(long p0, long p1, final StatementType p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        ObservableSource map = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2.toString()).map(new Function() { // from class: id.dana.data.statement.repository.UserStatementEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserStatementEntityRepository.MyBillsEntityDataFactory(StatementType.this, (StatementDetailResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Intrinsics.checkNotNullParameter(map, "");
        Observable<UserStatementDetail> authenticatedRequest = this.KClassImpl$Data$declaredNonStaticMembers$2.authenticatedRequest(map);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }

    @Override // id.dana.domain.statement.UserStatementRepository
    public final Observable<List<UserStatement>> getAllStatementSummary(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable zipWith = BuiltInFictitiousFunctionClassFactory(p0, p1, StatementType.INCOME.name()).zipWith(BuiltInFictitiousFunctionClassFactory(p0, p1, StatementType.EXPENSE.name()), new BiFunction() { // from class: id.dana.data.statement.repository.UserStatementEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return UserStatementEntityRepository.getAuthRequestContext(UserStatementEntityRepository.this, (UserStatement) obj, (UserStatement) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }

    private final Observable<UserStatement> BuiltInFictitiousFunctionClassFactory(String p0, String p1, final String p2) {
        Observable map = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2).onErrorResumeNext(Observable.error(new Exception())).map(new Function() { // from class: id.dana.data.statement.repository.UserStatementEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return UserStatementEntityRepository.MyBillsEntityDataFactory(p2, (UserAccumulateQuerySummaryResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private final UserStatementEntityData PlaceComponentResult() {
        UserStatementDataFactory userStatementDataFactory = this.BuiltInFictitiousFunctionClassFactory;
        if (Intrinsics.areEqual("network", "mock")) {
            return new MockUserStatementEntityData();
        }
        return userStatementDataFactory.getAuthRequestContext;
    }

    public static /* synthetic */ UserStatementDetail MyBillsEntityDataFactory(StatementType statementType, StatementDetailResult statementDetailResult) {
        Intrinsics.checkNotNullParameter(statementType, "");
        Intrinsics.checkNotNullParameter(statementDetailResult, "");
        return StatementDetailResultKt.MyBillsEntityDataFactory(statementDetailResult, statementType);
    }

    public static /* synthetic */ UserStatement getAuthRequestContext(String str, UserAccumulateQuerySummaryResult userAccumulateQuerySummaryResult) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(userAccumulateQuerySummaryResult, "");
        return UserAccumulateQuerySummaryResultKt.PlaceComponentResult(userAccumulateQuerySummaryResult, str);
    }

    public static /* synthetic */ List getAuthRequestContext(UserStatementEntityRepository userStatementEntityRepository, UserStatement userStatement, UserStatement userStatement2) {
        Intrinsics.checkNotNullParameter(userStatementEntityRepository, "");
        Intrinsics.checkNotNullParameter(userStatement, "");
        Intrinsics.checkNotNullParameter(userStatement2, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UserStatement(userStatement.getAccumulateAmount(), userStatement.getUserStatement(), StatementType.INCOME.name(), 0));
        arrayList.add(new UserStatement(userStatement.getAccumulateAmount(), userStatement.getUserStatement(), StatementType.INCOME.name(), 1));
        arrayList.add(new UserStatement(userStatement2.getAccumulateAmount(), userStatement2.getUserStatement(), StatementType.EXPENSE.name(), 0));
        arrayList.add(new UserStatement(userStatement2.getAccumulateAmount(), userStatement2.getUserStatement(), StatementType.EXPENSE.name(), 1));
        return arrayList;
    }

    public static /* synthetic */ UserStatement MyBillsEntityDataFactory(String str, UserAccumulateQuerySummaryResult userAccumulateQuerySummaryResult) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(userAccumulateQuerySummaryResult, "");
        return UserAccumulateQuerySummaryResultKt.PlaceComponentResult(userAccumulateQuerySummaryResult, str);
    }
}
