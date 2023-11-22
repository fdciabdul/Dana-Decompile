package id.dana.lib.bio.faceauth;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.faceverificationenablement.FaceAuthenticationBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\fH&J$\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\u000bj\u0002`\u0010H&¨\u0006\u0011"}, d2 = {"Lid/dana/lib/bio/faceauth/FaceAuthentication;", "", FaceAuthenticationBridge.EVENT_NAME_ENROLL_FACE_AUTH, "", HummerConstants.CONTEXT, "Landroid/content/Context;", "userId", "", "queryParamsAuthStatus", "", "enrollmentFaceAuthentication", "Lid/dana/lib/bio/faceauth/FaceAuthenticationCallback;", "Lid/dana/lib/bio/faceauth/EnrollmentFaceAuthentication;", "verifyFaceAuth", BioUtilityBridge.SECURITY_ID, "verifyFaceAuthentication", "Lid/dana/lib/bio/faceauth/VerifyFaceAuthentication;", "bio_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FaceAuthentication {
    void MyBillsEntityDataFactory(Context context, String str, Map<String, ? extends Object> map, FaceAuthenticationCallback faceAuthenticationCallback);

    void PlaceComponentResult(Context context, String str, FaceAuthenticationCallback faceAuthenticationCallback);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FaceAuthentication faceAuthentication, Context context, String str, FaceAuthenticationCallback faceAuthenticationCallback) {
            faceAuthentication.MyBillsEntityDataFactory(context, str, MapsKt.mapOf(TuplesKt.to("sceneId", "dana_app_securitysetting"), TuplesKt.to("productCode", "FACE_ENROLL")), faceAuthenticationCallback);
        }
    }
}
