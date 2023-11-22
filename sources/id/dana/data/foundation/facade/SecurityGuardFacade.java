package id.dana.data.foundation.facade;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import id.dana.data.BuildConfig;
import id.dana.utils.foundation.SignatureUtils;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes.dex */
public class SecurityGuardFacade {
    private static final String getAuthRequestContext = "SecurityGuardFacade";
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory = BuildConfig.APHOME_APPKEY;
    private final String PlaceComponentResult;

    @Inject
    public SecurityGuardFacade(Context context) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        if (SignatureUtils.getAuthRequestContext(context)) {
            this.PlaceComponentResult = "0ce8";
        } else {
            this.PlaceComponentResult = "0ce8_1";
        }
        try {
            SecurityGuardManager.getInitializer().initialize(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (SecException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, "Error SecurityGuardFacade.init()", e);
        }
    }

    public final String PlaceComponentResult(String str) throws SecException {
        String str2 = this.MyBillsEntityDataFactory;
        String str3 = this.PlaceComponentResult;
        HashMap hashMap = new HashMap();
        hashMap.put("INPUT", str);
        hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_ATLAS, "c");
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 7;
        return PlaceComponentResult().getSecureSignatureComp().signRequest(securityGuardParamContext, str3);
    }

    public final SecurityGuardManager PlaceComponentResult() throws SecException {
        try {
            return SecurityGuardManager.getInstance(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (SecException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, "SecurityGuard error on SecurityGuardFacade.getManager()", e);
            throw e;
        }
    }
}
