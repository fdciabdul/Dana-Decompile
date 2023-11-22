package id.dana.cashier.utils;

import android.app.Activity;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/utils/CashierOtpUtil;", "", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/app/Activity;", "Lkotlin/Function0;", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierOtpUtil {
    public static final CashierOtpUtil INSTANCE = new CashierOtpUtil();

    private CashierOtpUtil() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(Activity p0, final Function0<Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        SmsRetrieverClient client = SmsRetriever.getClient(p0);
        Intrinsics.checkNotNullExpressionValue(client, "");
        Task<Void> startSmsUserConsent = client.startSmsUserConsent(null);
        Intrinsics.checkNotNullExpressionValue(startSmsUserConsent, "");
        startSmsUserConsent.addOnSuccessListener(new OnSuccessListener() { // from class: id.dana.cashier.utils.CashierOtpUtil$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                Void r2 = (Void) obj;
                CashierOtpUtil.PlaceComponentResult(Function0.this);
            }
        });
        startSmsUserConsent.addOnFailureListener(new OnFailureListener() { // from class: id.dana.cashier.utils.CashierOtpUtil$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.OTP_CHALLENGE_TAG, "[OtpCashier] :onError Retrieve Listener", exc);
            }
        });
    }

    public static String MyBillsEntityDataFactory(String p0) {
        if (p0 == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+)").matcher(p0);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static /* synthetic */ void PlaceComponentResult(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        DanaLog.getAuthRequestContext(DanaLogConstants.TAG.OTP_CHALLENGE_TAG, "[OtpCashier] :onSuccess Retrieve Listener");
        function0.invoke();
    }
}
