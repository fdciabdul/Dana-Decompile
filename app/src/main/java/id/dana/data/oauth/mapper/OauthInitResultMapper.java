package id.dana.data.oauth.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.oauth.model.OauthInit;
import id.dana.domain.oauth.model.Scope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class OauthInitResultMapper extends BaseMapper<AuthCodeResult, OauthInit> {
    private final ScopeResultMapper scopeResultMapper;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public OauthInitResultMapper(ScopeResultMapper scopeResultMapper) {
        this.scopeResultMapper = scopeResultMapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public OauthInit map(AuthCodeResult authCodeResult) {
        if (authCodeResult != null) {
            OauthInit oauthInit = new OauthInit();
            oauthInit.setMerchantName(authCodeResult.getMerchantInfo().getMerchantName());
            oauthInit.setAvailableScope(mapScopeResultList(authCodeResult.getAgreements()));
            return oauthInit;
        }
        return null;
    }

    private List<Scope> mapScopeResultList(List<Agreement> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<Agreement> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.scopeResultMapper.map(it.next()));
        }
        return arrayList;
    }
}
