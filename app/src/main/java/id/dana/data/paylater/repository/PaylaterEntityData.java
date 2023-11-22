package id.dana.data.paylater.repository;

import id.dana.data.paylater.repository.source.network.result.LoanRegisterResult;
import id.dana.data.paylater.repository.source.network.result.LoanWhitelistResult;
import id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult;
import id.dana.data.paylater.repository.source.network.result.PaylaterHomeInfoResult;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0019H\u0016J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010&\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006'À\u0006\u0001"}, d2 = {"Lid/dana/data/paylater/repository/PaylaterEntityData;", "", "clearCacheLoanWhitelist", "Lio/reactivex/Observable;", "", "phoneNumber", "", "getLoanConsultWhitelist", "Lid/dana/data/paylater/repository/source/network/result/LoanWhitelistResult;", "userId", "withBill", "getLoanRegisterInfo", "Lid/dana/data/paylater/repository/source/network/result/LoanRegisterResult;", "agreementKey", "getPayLaterCacheWhitelistValue", "Lid/dana/domain/paylater/model/LoanWhitelist;", "getPayLaterLoanStatus", "", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "getPaylaterCicilMethodConfig", "Lid/dana/data/paylater/repository/source/network/result/PaylaterCicilMethodConfigResult;", "getPaylaterHomeInfo", "Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;", "skipBillInfo", "getPaylaterRotationDelayTime", "", "resetPayLaterCacheLoanWhitelist", "savePayLaterCacheWhitelistValue", "loanWhitelist", "savePayLaterLoanStatus", "loanStatus", "savePaylaterRotationDelayTime", "rotationDelayTime", "setLoanServicesState", "type", "state", "setOffLoanServicesState", "setPaylaterChannel", "paylaterChannel", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PaylaterEntityData {
    Observable<Boolean> clearCacheLoanWhitelist(String phoneNumber);

    Observable<LoanWhitelistResult> getLoanConsultWhitelist(String userId, boolean withBill);

    Observable<LoanRegisterResult> getLoanRegisterInfo(String agreementKey);

    Observable<LoanWhitelist> getPayLaterCacheWhitelistValue(String phoneNumber);

    Observable<List<LoanStatusWhitelist>> getPayLaterLoanStatus(String phoneNumber);

    Observable<PaylaterCicilMethodConfigResult> getPaylaterCicilMethodConfig();

    Observable<PaylaterHomeInfoResult> getPaylaterHomeInfo(boolean skipBillInfo);

    Observable<Long> getPaylaterRotationDelayTime(String phoneNumber);

    Observable<Boolean> resetPayLaterCacheLoanWhitelist();

    Observable<Boolean> savePayLaterCacheWhitelistValue(String phoneNumber, LoanWhitelist loanWhitelist);

    Observable<Boolean> savePayLaterLoanStatus(List<LoanStatusWhitelist> loanStatus, String phoneNumber);

    Observable<Boolean> savePaylaterRotationDelayTime(String phoneNumber, long rotationDelayTime);

    Observable<Boolean> setLoanServicesState(String type, String state);

    Observable<Boolean> setOffLoanServicesState(LoanWhitelist loanWhitelist);

    Observable<Boolean> setPaylaterChannel(String paylaterChannel);

    /* renamed from: id.dana.data.paylater.repository.PaylaterEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static Observable $default$getPaylaterHomeInfo(PaylaterEntityData paylaterEntityData, boolean z) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getLoanConsultWhitelist(PaylaterEntityData paylaterEntityData, String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getLoanRegisterInfo(PaylaterEntityData paylaterEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getPaylaterCicilMethodConfig(PaylaterEntityData paylaterEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$setOffLoanServicesState(PaylaterEntityData paylaterEntityData, LoanWhitelist loanWhitelist) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$setPaylaterChannel(PaylaterEntityData paylaterEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$setLoanServicesState(PaylaterEntityData paylaterEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$savePayLaterCacheWhitelistValue(PaylaterEntityData paylaterEntityData, String str, LoanWhitelist loanWhitelist) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(loanWhitelist, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getPayLaterCacheWhitelistValue(PaylaterEntityData paylaterEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$resetPayLaterCacheLoanWhitelist(PaylaterEntityData paylaterEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$clearCacheLoanWhitelist(PaylaterEntityData paylaterEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$savePayLaterLoanStatus(PaylaterEntityData paylaterEntityData, List list, String str) {
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getPayLaterLoanStatus(PaylaterEntityData paylaterEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$savePaylaterRotationDelayTime(PaylaterEntityData paylaterEntityData, String str, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getPaylaterRotationDelayTime(PaylaterEntityData paylaterEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }
    }
}
