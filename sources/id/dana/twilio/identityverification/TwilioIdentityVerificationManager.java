package id.dana.twilio.identityverification;

import id.dana.danah5.twilioverifysecurityproduct.TwilioVerifySecurityProductManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/twilio/identityverification/TwilioIdentityVerificationManager;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TwilioIdentityVerificationManager {
    public static final TwilioIdentityVerificationManager INSTANCE = new TwilioIdentityVerificationManager();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public static String BuiltInFictitiousFunctionClassFactory = "";

    private TwilioIdentityVerificationManager() {
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TwilioVerifySecurityProductManager.DATE_FORMAT, Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }
}
