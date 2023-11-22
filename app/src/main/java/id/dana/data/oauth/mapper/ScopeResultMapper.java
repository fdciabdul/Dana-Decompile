package id.dana.data.oauth.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.oauth.model.Scope;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ScopeResultMapper extends BaseMapper<Agreement, Scope> {
    @Inject
    public ScopeResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public Scope map(Agreement agreement) {
        if (agreement != null) {
            Scope scope = new Scope();
            scope.setScopeTitle(agreement.getTitle());
            scope.setScopeDescription(agreement.getDescription());
            scope.setScopeName(agreement.getName());
            scope.setScopeType(agreement.getType());
            return scope;
        }
        return null;
    }
}
