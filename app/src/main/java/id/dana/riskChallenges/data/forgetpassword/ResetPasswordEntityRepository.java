package id.dana.riskChallenges.data.forgetpassword;

import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.riskChallenges.data.forgetpassword.mapper.ResetPasswordMapperKt;
import id.dana.riskChallenges.data.forgetpassword.source.ResetPasswordEntityDataFactory;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.ResetPasswordResult;
import id.dana.riskChallenges.data.forgetpassword.source.network.result.RiskChallengesResult;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.domain.forgetpassword.ResetPasswordRepository;
import id.dana.riskChallenges.domain.forgetpassword.model.ResetPasswordResponseModel;
import id.dana.riskChallenges.domain.forgetpassword.model.RiskChallenges;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@RiskChallengesScope
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013"}, d2 = {"Lid/dana/riskChallenges/data/forgetpassword/ResetPasswordEntityRepository;", "Lid/dana/riskChallenges/domain/forgetpassword/ResetPasswordRepository;", "", "p0", "p1", "", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/forgetpassword/model/RiskChallenges;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;ZZ)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/forgetpassword/model/ResetPasswordResponseModel;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/forgetpassword/source/ResetPasswordEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/data/forgetpassword/source/ResetPasswordEntityDataFactory;", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "PlaceComponentResult", "<init>", "(Lid/dana/riskChallenges/data/forgetpassword/source/ResetPasswordEntityDataFactory;Lid/dana/data/security/source/SecurityEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResetPasswordEntityRepository implements ResetPasswordRepository {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SecurityEntityDataFactory PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ResetPasswordEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public ResetPasswordEntityRepository(ResetPasswordEntityDataFactory resetPasswordEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory) {
        Intrinsics.checkNotNullParameter(resetPasswordEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(securityEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = resetPasswordEntityDataFactory;
        this.PlaceComponentResult = securityEntityDataFactory;
    }

    public static /* synthetic */ RiskChallenges BuiltInFictitiousFunctionClassFactory(RiskChallengesResult riskChallengesResult) {
        Intrinsics.checkNotNullParameter(riskChallengesResult, "");
        return ResetPasswordMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(riskChallengesResult);
    }

    public static /* synthetic */ ResetPasswordResponseModel MyBillsEntityDataFactory(ResetPasswordResult resetPasswordResult) {
        Intrinsics.checkNotNullParameter(resetPasswordResult, "");
        return ResetPasswordMapperKt.PlaceComponentResult(resetPasswordResult);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(ResetPasswordEntityRepository resetPasswordEntityRepository, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(resetPasswordEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        ResetPasswordEntityDataFactory resetPasswordEntityDataFactory = resetPasswordEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter("network", "");
        return resetPasswordEntityDataFactory.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(str5, str, str2, str3, str4);
    }

    @Override // id.dana.riskChallenges.domain.forgetpassword.ResetPasswordRepository
    public final Observable<RiskChallenges> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, boolean p2, boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        ResetPasswordEntityDataFactory resetPasswordEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter("network", "");
        Observable map = resetPasswordEntityDataFactory.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0, p1, p2, p3).map(new Function() { // from class: id.dana.riskChallenges.data.forgetpassword.ResetPasswordEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPasswordEntityRepository.BuiltInFictitiousFunctionClassFactory((RiskChallengesResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.riskChallenges.domain.forgetpassword.ResetPasswordRepository
    public final Observable<ResetPasswordResponseModel> getAuthRequestContext(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable<ResetPasswordResponseModel> map = this.PlaceComponentResult.createData2("network").loginKey().flatMap(new Function() { // from class: id.dana.riskChallenges.data.forgetpassword.ResetPasswordEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPasswordEntityRepository.getAuthRequestContext(ResetPasswordEntityRepository.this, p0, p1, p2, p3, (String) obj);
            }
        }).map(new Function() { // from class: id.dana.riskChallenges.data.forgetpassword.ResetPasswordEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPasswordEntityRepository.MyBillsEntityDataFactory((ResetPasswordResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
