package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.challenge.otp.AbstractOtpContract;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\t\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/di/modules/OtpChallengeModule;", "", "Lid/dana/challenge/otp/OtpRegistrationPresenter;", "p0", "Lid/dana/challenge/otp/OtpLoginPresenter;", "p1", "Lid/dana/challenge/otp/OtpTwilioPresenter;", "p2", "Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/challenge/otp/OtpRegistrationPresenter;Lid/dana/challenge/otp/OtpLoginPresenter;Lid/dana/challenge/otp/OtpTwilioPresenter;)Lid/dana/challenge/otp/AbstractOtpContract$Presenter;", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/challenge/otp/AbstractOtpContract$View;", "", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/challenge/otp/AbstractOtpContract$View;", "<init>", "(Lid/dana/challenge/otp/AbstractOtpContract$View;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class OtpChallengeModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AbstractOtpContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public OtpChallengeModule(AbstractOtpContract.View view, String str) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final AbstractOtpContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return r6;
     */
    @dagger.Provides
    @id.dana.di.PerActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.challenge.otp.AbstractOtpContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(id.dana.challenge.otp.OtpRegistrationPresenter r4, id.dana.challenge.otp.OtpLoginPresenter r5, id.dana.challenge.otp.OtpTwilioPresenter r6) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = r3.BuiltInFictitiousFunctionClassFactory
            int r1 = r0.hashCode()
            r2 = -1999183539(0xffffffff88d6e14d, float:-1.29326245E-33)
            if (r1 == r2) goto L34
            r4 = 1124674296(0x43092af8, float:137.16785)
            if (r1 == r4) goto L29
            r4 = 1667024159(0x635cc51f, float:4.0724878E21)
            if (r1 != r4) goto L40
            java.lang.String r4 = "auth_agreement_otp"
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L31
            goto L40
        L29:
            java.lang.String r4 = "twilio_otp"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L40
        L31:
            id.dana.challenge.otp.AbstractOtpContract$Presenter r6 = (id.dana.challenge.otp.AbstractOtpContract.Presenter) r6
            goto L43
        L34:
            java.lang.String r6 = "otp_registration"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L40
            r6 = r4
            id.dana.challenge.otp.AbstractOtpContract$Presenter r6 = (id.dana.challenge.otp.AbstractOtpContract.Presenter) r6
            goto L43
        L40:
            r6 = r5
            id.dana.challenge.otp.AbstractOtpContract$Presenter r6 = (id.dana.challenge.otp.AbstractOtpContract.Presenter) r6
        L43:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.di.modules.OtpChallengeModule.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.challenge.otp.OtpRegistrationPresenter, id.dana.challenge.otp.OtpLoginPresenter, id.dana.challenge.otp.OtpTwilioPresenter):id.dana.challenge.otp.AbstractOtpContract$Presenter");
    }
}
