package id.dana.cashier.domain.model.paylater;

import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/cashier/domain/model/paylater/PaylaterOnboardingContent;", "", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "consultAgreement", "Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "getConsultAgreement", "()Lid/dana/domain/useragreement/model/ConsultAgreementResponse;", "setConsultAgreement", "(Lid/dana/domain/useragreement/model/ConsultAgreementResponse;)V", "", "consultAgreementError", "Ljava/lang/Throwable;", "getConsultAgreementError", "()Ljava/lang/Throwable;", "setConsultAgreementError", "(Ljava/lang/Throwable;)V", "", "onBoardingImageUrl", "Ljava/lang/String;", "getOnBoardingImageUrl", "()Ljava/lang/String;", "setOnBoardingImageUrl", "(Ljava/lang/String;)V", "<init>", "(Lid/dana/domain/useragreement/model/ConsultAgreementResponse;Ljava/lang/Throwable;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterOnboardingContent {
    private ConsultAgreementResponse consultAgreement;
    private Throwable consultAgreementError;
    private String onBoardingImageUrl;

    public PaylaterOnboardingContent() {
        this(null, null, null, 7, null);
    }

    public PaylaterOnboardingContent(ConsultAgreementResponse consultAgreementResponse, Throwable th, String str) {
        Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.consultAgreement = consultAgreementResponse;
        this.consultAgreementError = th;
        this.onBoardingImageUrl = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ PaylaterOnboardingContent(id.dana.domain.useragreement.model.ConsultAgreementResponse r3, java.lang.Throwable r4, java.lang.String r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = r6 & 1
            r0 = 0
            if (r7 == 0) goto Lc
            id.dana.domain.useragreement.model.ConsultAgreementResponse r3 = new id.dana.domain.useragreement.model.ConsultAgreementResponse
            r7 = 0
            r1 = 2
            r3.<init>(r7, r0, r1, r0)
        Lc:
            r7 = r6 & 2
            if (r7 == 0) goto L11
            r4 = r0
        L11:
            r6 = r6 & 4
            if (r6 == 0) goto L17
            java.lang.String r5 = ""
        L17:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.domain.model.paylater.PaylaterOnboardingContent.<init>(id.dana.domain.useragreement.model.ConsultAgreementResponse, java.lang.Throwable, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getConsultAgreement")
    public final ConsultAgreementResponse getConsultAgreement() {
        return this.consultAgreement;
    }

    @JvmName(name = "setConsultAgreement")
    public final void setConsultAgreement(ConsultAgreementResponse consultAgreementResponse) {
        Intrinsics.checkNotNullParameter(consultAgreementResponse, "");
        this.consultAgreement = consultAgreementResponse;
    }

    @JvmName(name = "getConsultAgreementError")
    public final Throwable getConsultAgreementError() {
        return this.consultAgreementError;
    }

    @JvmName(name = "setConsultAgreementError")
    public final void setConsultAgreementError(Throwable th) {
        this.consultAgreementError = th;
    }

    @JvmName(name = "getOnBoardingImageUrl")
    public final String getOnBoardingImageUrl() {
        return this.onBoardingImageUrl;
    }

    @JvmName(name = "setOnBoardingImageUrl")
    public final void setOnBoardingImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.onBoardingImageUrl = str;
    }
}
