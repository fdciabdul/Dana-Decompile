package id.dana.riskChallenges.domain.passkey.interactor;

import id.dana.core.ui.util.OSUtil;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.passkey.model.DanaVizEntryPointConfig;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "getAuthRequestContext", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "PlaceComponentResult", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyEligibility extends BaseUseCase<Boolean, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeatureConfigRepository getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PasskeyRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Params params) {
        final Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        Observable<Boolean> flatMap = Observable.fromCallable(new Callable() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PasskeyEligibility.PlaceComponentResult();
            }
        }).flatMap(new Function() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyEligibility.PlaceComponentResult(PasskeyEligibility.this, (Boolean) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyEligibility.MyBillsEntityDataFactory(PasskeyEligibility.Params.this, this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Inject
    public PasskeyEligibility(FeatureConfigRepository featureConfigRepository, PasskeyRepository passkeyRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(passkeyRepository, "");
        this.getAuthRequestContext = featureConfigRepository;
        this.BuiltInFictitiousFunctionClassFactory = passkeyRepository;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000e\u001a\u00020\u0012X\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "getAuthRequestContext", "()Z", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Z", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor;", "p1", "p2", "<init>", "(ZZLid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor;)V", "TypeFor"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final TypeFor PlaceComponentResult;
        private final boolean MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public Params() {
            this(false, false, null, 7, null);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return this.MyBillsEntityDataFactory == params.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory == params.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.PlaceComponentResult, params.PlaceComponentResult);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean z = this.MyBillsEntityDataFactory;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            boolean z2 = this.BuiltInFictitiousFunctionClassFactory;
            return (((r0 * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.PlaceComponentResult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(')');
            return sb.toString();
        }

        public Params(boolean z, boolean z2, TypeFor typeFor) {
            Intrinsics.checkNotNullParameter(typeFor, "");
            this.MyBillsEntityDataFactory = z;
            this.BuiltInFictitiousFunctionClassFactory = z2;
            this.PlaceComponentResult = typeFor;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getBuiltInFictitiousFunctionClassFactory() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public /* synthetic */ Params(boolean z, boolean z2, TypeFor.Enrollment enrollment, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? TypeFor.Enrollment.INSTANCE : enrollment);
        }

        public final boolean getAuthRequestContext() {
            return Intrinsics.areEqual(this.PlaceComponentResult, TypeFor.Enrollment.INSTANCE);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor;", "", "<init>", "()V", "Challenge", "Enrollment", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor$Enrollment;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor$Challenge;"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static abstract class TypeFor {
            public /* synthetic */ TypeFor(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor$Enrollment;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes5.dex */
            public static final class Enrollment extends TypeFor {
                public static final Enrollment INSTANCE = new Enrollment();

                private Enrollment() {
                    super(null);
                }
            }

            private TypeFor() {
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor$Challenge;", "Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyEligibility$Params$TypeFor;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes9.dex */
            public static final class Challenge extends TypeFor {
                public static final Challenge INSTANCE = new Challenge();

                private Challenge() {
                    super(null);
                }
            }
        }
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(final Params params, PasskeyEligibility passkeyEligibility, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(passkeyEligibility, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue() && params.getMyBillsEntityDataFactory()) {
            just = passkeyEligibility.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(params.getBuiltInFictitiousFunctionClassFactory()).map(new Function() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PasskeyEligibility.KClassImpl$Data$declaredNonStaticMembers$2(PasskeyEligibility.Params.this, (List) obj);
                }
            });
        } else {
            just = Observable.just(bool);
        }
        return just;
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(Params params, List list) {
        boolean z;
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        if (params.getAuthRequestContext()) {
            z = list.isEmpty();
        } else {
            z = !list.isEmpty();
        }
        return Boolean.valueOf(z);
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(PasskeyEligibility passkeyEligibility, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(passkeyEligibility, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            just = passkeyEligibility.getAuthRequestContext.getFeatureDanaVizEntryPointConfig().map(new Function() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyEligibility$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PasskeyEligibility.PlaceComponentResult((DanaVizEntryPointConfig) obj);
                }
            });
        } else {
            just = Observable.just(Boolean.FALSE);
        }
        return just;
    }

    public static /* synthetic */ Boolean PlaceComponentResult(DanaVizEntryPointConfig danaVizEntryPointConfig) {
        Intrinsics.checkNotNullParameter(danaVizEntryPointConfig, "");
        return Boolean.valueOf(danaVizEntryPointConfig.getPasskeyEnrollment());
    }

    public static /* synthetic */ Boolean PlaceComponentResult() {
        boolean z;
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.moveToNextValue()) {
            OSUtil oSUtil2 = OSUtil.INSTANCE;
            if (OSUtil.getAuthRequestContext()) {
                z = true;
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
