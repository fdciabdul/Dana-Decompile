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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/biometric/domain/interactor/SaveGyroscopeData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/biometric/domain/interactor/SaveGyroscopeData$Params;", "Lid/dana/biometric/domain/RiskTrackerRepository;", "MyBillsEntityDataFactory", "Lid/dana/biometric/domain/RiskTrackerRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/biometric/domain/RiskTrackerRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SaveGyroscopeData extends BaseUseCase<Boolean, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final RiskTrackerRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        RiskTrackerRepository riskTrackerRepository = this.getAuthRequestContext;
        String str = params2.PlaceComponentResult;
        String str2 = params2.getAuthRequestContext;
        StringBuilder sb = new StringBuilder();
        sb.append(params2.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(',');
        sb.append(params2.BuiltInFictitiousFunctionClassFactory);
        sb.append(',');
        sb.append(params2.getErrorConfigVersion);
        return riskTrackerRepository.saveAndGetGyroscopeDataState(str, str2, sb.toString(), params2.MyBillsEntityDataFactory);
    }

    @Inject
    public SaveGyroscopeData(RiskTrackerRepository riskTrackerRepository) {
        Intrinsics.checkNotNullParameter(riskTrackerRepository, "");
        this.getAuthRequestContext = riskTrackerRepository;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u0013\u001a\u00020\u0010X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0011\u001a\u00020\u0014X\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0014X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0014X\u0007¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015"}, d2 = {"Lid/dana/biometric/domain/interactor/SaveGyroscopeData$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "", "KClassImpl$Data$declaredNonStaticMembers$2", "J", "MyBillsEntityDataFactory", "", LogConstants.RESULT_FALSE, "moveToNextValue", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;FFFJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final long MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final float BuiltInFictitiousFunctionClassFactory;
        final String PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final float KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        final float getErrorConfigVersion;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, params.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, params.getAuthRequestContext) && Intrinsics.areEqual((Object) Float.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), (Object) Float.valueOf(params.KClassImpl$Data$declaredNonStaticMembers$2)) && Intrinsics.areEqual((Object) Float.valueOf(this.BuiltInFictitiousFunctionClassFactory), (Object) Float.valueOf(params.BuiltInFictitiousFunctionClassFactory)) && Intrinsics.areEqual((Object) Float.valueOf(this.getErrorConfigVersion), (Object) Float.valueOf(params.getErrorConfigVersion)) && this.MyBillsEntityDataFactory == params.MyBillsEntityDataFactory;
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.PlaceComponentResult.hashCode() * 31) + this.getAuthRequestContext.hashCode()) * 31) + Float.floatToIntBits(this.KClassImpl$Data$declaredNonStaticMembers$2)) * 31) + Float.floatToIntBits(this.BuiltInFictitiousFunctionClassFactory)) * 31) + Float.floatToIntBits(this.getErrorConfigVersion)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.MyBillsEntityDataFactory);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, float f, float f2, float f3, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = f;
            this.BuiltInFictitiousFunctionClassFactory = f2;
            this.getErrorConfigVersion = f3;
            this.MyBillsEntityDataFactory = j;
        }
    }
}
