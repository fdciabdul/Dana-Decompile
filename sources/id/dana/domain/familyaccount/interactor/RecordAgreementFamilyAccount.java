package id.dana.domain.familyaccount.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/familyaccount/interactor/RecordAgreementFamilyAccount;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/familyaccount/interactor/RecordAgreementFamilyAccount$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/familyaccount/interactor/RecordAgreementFamilyAccount$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "familyAccountRepository", "Lid/dana/domain/familyaccount/FamilyAccountRepository;", "<init>", "(Lid/dana/domain/familyaccount/FamilyAccountRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecordAgreementFamilyAccount extends BaseUseCase<Unit, Params> {
    private final FamilyAccountRepository familyAccountRepository;

    @Inject
    public RecordAgreementFamilyAccount(FamilyAccountRepository familyAccountRepository) {
        Intrinsics.checkNotNullParameter(familyAccountRepository, "");
        this.familyAccountRepository = familyAccountRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Unit> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.familyAccountRepository.recordAgreement(params.getAgreementKeys(), params.getUserAgree(), params.getAgreementType(), params.getOrganizerName(), params.getOrganizerPhoneNumber(), params.getMemberPhoneNumber(), params.getMemberRelationship(), params.getMemberLocation());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00138\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/domain/familyaccount/interactor/RecordAgreementFamilyAccount$Params;", "", "", "agreementKeys", "Ljava/lang/String;", "getAgreementKeys$domain_productionRelease", "()Ljava/lang/String;", "agreementType", "getAgreementType$domain_productionRelease", "memberLocation", "getMemberLocation$domain_productionRelease", "memberPhoneNumber", "getMemberPhoneNumber$domain_productionRelease", "memberRelationship", "getMemberRelationship$domain_productionRelease", "organizerName", "getOrganizerName$domain_productionRelease", "organizerPhoneNumber", "getOrganizerPhoneNumber$domain_productionRelease", "", "userAgree", "Z", "getUserAgree$domain_productionRelease", "()Z", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String agreementKeys;
        private final String agreementType;
        private final String memberLocation;
        private final String memberPhoneNumber;
        private final String memberRelationship;
        private final String organizerName;
        private final String organizerPhoneNumber;
        private final boolean userAgree;

        public Params(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "");
            this.agreementKeys = str;
            this.userAgree = z;
            this.agreementType = str2;
            this.organizerName = str3;
            this.organizerPhoneNumber = str4;
            this.memberPhoneNumber = str5;
            this.memberRelationship = str6;
            this.memberLocation = str7;
        }

        @JvmName(name = "getAgreementKeys$domain_productionRelease")
        /* renamed from: getAgreementKeys$domain_productionRelease  reason: from getter */
        public final String getAgreementKeys() {
            return this.agreementKeys;
        }

        @JvmName(name = "getUserAgree$domain_productionRelease")
        /* renamed from: getUserAgree$domain_productionRelease  reason: from getter */
        public final boolean getUserAgree() {
            return this.userAgree;
        }

        @JvmName(name = "getAgreementType$domain_productionRelease")
        /* renamed from: getAgreementType$domain_productionRelease  reason: from getter */
        public final String getAgreementType() {
            return this.agreementType;
        }

        @JvmName(name = "getOrganizerName$domain_productionRelease")
        /* renamed from: getOrganizerName$domain_productionRelease  reason: from getter */
        public final String getOrganizerName() {
            return this.organizerName;
        }

        @JvmName(name = "getOrganizerPhoneNumber$domain_productionRelease")
        /* renamed from: getOrganizerPhoneNumber$domain_productionRelease  reason: from getter */
        public final String getOrganizerPhoneNumber() {
            return this.organizerPhoneNumber;
        }

        @JvmName(name = "getMemberPhoneNumber$domain_productionRelease")
        /* renamed from: getMemberPhoneNumber$domain_productionRelease  reason: from getter */
        public final String getMemberPhoneNumber() {
            return this.memberPhoneNumber;
        }

        @JvmName(name = "getMemberRelationship$domain_productionRelease")
        /* renamed from: getMemberRelationship$domain_productionRelease  reason: from getter */
        public final String getMemberRelationship() {
            return this.memberRelationship;
        }

        @JvmName(name = "getMemberLocation$domain_productionRelease")
        /* renamed from: getMemberLocation$domain_productionRelease  reason: from getter */
        public final String getMemberLocation() {
            return this.memberLocation;
        }
    }
}
