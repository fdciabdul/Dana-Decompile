package id.dana.biometric.domain.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.biometric.domain.RiskTrackerRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/biometric/domain/interactor/SaveKeystrokeData;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/biometric/domain/interactor/SaveKeystrokeData$Params;", "Lid/dana/biometric/domain/RiskTrackerRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/biometric/domain/RiskTrackerRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/biometric/domain/RiskTrackerRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SaveKeystrokeData extends BaseUseCase<Unit, Params> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final RiskTrackerRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Unit> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        RiskTrackerRepository riskTrackerRepository = this.MyBillsEntityDataFactory;
        String str = params2.KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = params2.BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(params2.PlaceComponentResult);
        sb.append(',');
        sb.append(params2.getAuthRequestContext);
        return riskTrackerRepository.saveKeystrokeDataState(str, str2, sb.toString(), params2.MyBillsEntityDataFactory);
    }

    @Inject
    public SaveKeystrokeData(RiskTrackerRepository riskTrackerRepository) {
        Intrinsics.checkNotNullParameter(riskTrackerRepository, "");
        this.MyBillsEntityDataFactory = riskTrackerRepository;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0011\u001a\u00020\u0010X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0013X\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0013X\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015"}, d2 = {"Lid/dana/biometric/domain/interactor/SaveKeystrokeData$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "", "MyBillsEntityDataFactory", "J", "", "PlaceComponentResult", LogConstants.RESULT_FALSE, "p1", "p2", "p3", "p4", "<init>", "(Ljava/lang/String;Ljava/lang/String;FFJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final float getAuthRequestContext;
        final long MyBillsEntityDataFactory;
        final float PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, params.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual((Object) Float.valueOf(this.PlaceComponentResult), (Object) Float.valueOf(params.PlaceComponentResult)) && Intrinsics.areEqual((Object) Float.valueOf(this.getAuthRequestContext), (Object) Float.valueOf(params.getAuthRequestContext)) && this.MyBillsEntityDataFactory == params.MyBillsEntityDataFactory;
            }
            return false;
        }

        public final int hashCode() {
            return (((((((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + Float.floatToIntBits(this.PlaceComponentResult)) * 31) + Float.floatToIntBits(this.getAuthRequestContext)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.MyBillsEntityDataFactory);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, float f, float f2, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
            this.PlaceComponentResult = f;
            this.getAuthRequestContext = f2;
            this.MyBillsEntityDataFactory = j;
        }
    }
}
