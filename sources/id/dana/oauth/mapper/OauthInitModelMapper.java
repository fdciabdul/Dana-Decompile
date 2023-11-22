package id.dana.oauth.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.oauth.model.MerchantInfo;
import id.dana.domain.oauth.model.OauthInit;
import id.dana.domain.oauth.model.Scope;
import id.dana.oauth.model.OauthInitModel;
import id.dana.oauth.model.ScopeModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class OauthInitModelMapper extends BaseMapper<OauthInit, OauthInitModel> {
    public List<String> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ScopeModelMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ OauthInitModel map(OauthInit oauthInit) {
        OauthInit oauthInit2 = oauthInit;
        if (oauthInit2 != null) {
            OauthInitModel oauthInitModel = new OauthInitModel();
            oauthInitModel.getAuthRequestContext = oauthInit2.getMerchantName();
            List<Scope> availableScope = oauthInit2.getAvailableScope();
            ArrayList arrayList = new ArrayList();
            if (availableScope != null && this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                for (Scope scope : availableScope) {
                    Iterator<String> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
                    while (it.hasNext()) {
                        if (it.next().equals(scope.getScopeTitle())) {
                            arrayList.add(ScopeModelMapper.getAuthRequestContext(scope));
                        }
                    }
                }
            }
            oauthInitModel.BuiltInFictitiousFunctionClassFactory = arrayList;
            return oauthInitModel;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public OauthInitModelMapper(ScopeModelMapper scopeModelMapper) {
        this.getAuthRequestContext = scopeModelMapper;
    }

    public final OauthInitModel getAuthRequestContext(AuthCodeResult authCodeResult) {
        String merchantLogo;
        if (authCodeResult != null) {
            OauthInitModel oauthInitModel = new OauthInitModel();
            oauthInitModel.getAuthRequestContext = authCodeResult.getMerchantInfo().getMerchantName();
            oauthInitModel.BuiltInFictitiousFunctionClassFactory = getAuthRequestContext(authCodeResult.getAgreements());
            MerchantInfo merchantInfo = authCodeResult.getMerchantInfo();
            if (merchantInfo.getMerchantPCLogo() != null) {
                merchantLogo = merchantInfo.getMerchantPCLogo();
            } else {
                merchantLogo = merchantInfo.getMerchantLogo() != null ? merchantInfo.getMerchantLogo() : "";
            }
            oauthInitModel.MyBillsEntityDataFactory = merchantLogo;
            return oauthInitModel;
        }
        return null;
    }

    private List<ScopeModel> getAuthRequestContext(List<Agreement> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<Agreement> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ScopeModelMapper.BuiltInFictitiousFunctionClassFactory(it.next()));
            }
        }
        return arrayList;
    }
}
