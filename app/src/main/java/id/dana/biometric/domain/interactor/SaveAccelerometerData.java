package id.dana.biometric.domain.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.biometric.domain.RiskTrackerRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/biometric/domain/interactor/SaveAccelerometerData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/biometric/domain/interactor/SaveAccelerometerData$Params;", "Lid/dana/biometric/domain/RiskTrackerRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/biometric/domain/RiskTrackerRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/biometric/domain/RiskTrackerRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SaveAccelerometerData extends BaseUseCase<Boolean, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final RiskTrackerRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        RiskTrackerRepository riskTrackerRepository = this.MyBillsEntityDataFactory;
        String str = params2.MyBillsEntityDataFactory;
        String str2 = params2.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(params2.getAuthRequestContext);
        sb.append(',');
        sb.append(params2.PlaceComponentResult);
        sb.append(',');
        sb.append(params2.NetworkUserEntityData$$ExternalSyntheticLambda0);
        return riskTrackerRepository.saveAndGetAccelerometerDataState(str, str2, sb.toString(), params2.BuiltInFictitiousFunctionClassFactory);
    }

    @Inject
    public SaveAccelerometerData(RiskTrackerRepository riskTrackerRepository) {
        Intrinsics.checkNotNullParameter(riskTrackerRepository, "");
        this.MyBillsEntityDataFactory = riskTrackerRepository;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0011\u001a\u00020\u0010X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0013X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0013X\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0013X\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014"}, d2 = {"Lid/dana/biometric/domain/interactor/SaveAccelerometerData$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory", "J", "", LogConstants.RESULT_FALSE, "getAuthRequestContext", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;FFFJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        final long BuiltInFictitiousFunctionClassFactory;
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final float getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final float PlaceComponentResult;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        final float NetworkUserEntityData$$ExternalSyntheticLambda0;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, params.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual((Object) Float.valueOf(this.getAuthRequestContext), (Object) Float.valueOf(params.getAuthRequestContext)) && Intrinsics.areEqual((Object) Float.valueOf(this.PlaceComponentResult), (Object) Float.valueOf(params.PlaceComponentResult)) && Intrinsics.areEqual((Object) Float.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda0), (Object) Float.valueOf(params.NetworkUserEntityData$$ExternalSyntheticLambda0)) && this.BuiltInFictitiousFunctionClassFactory == params.BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.MyBillsEntityDataFactory.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + Float.floatToIntBits(this.getAuthRequestContext)) * 31) + Float.floatToIntBits(this.PlaceComponentResult)) * 31) + Float.floatToIntBits(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.BuiltInFictitiousFunctionClassFactory);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, float f, float f2, float f3, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.MyBillsEntityDataFactory = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.getAuthRequestContext = f;
            this.PlaceComponentResult = f2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f3;
            this.BuiltInFictitiousFunctionClassFactory = j;
        }
    }
}
