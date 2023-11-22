package id.dana.oauth.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.oauth.model.Agreement;
import id.dana.domain.oauth.model.Scope;
import id.dana.oauth.model.ScopeModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ScopeModelMapper extends BaseMapper<Scope, ScopeModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ ScopeModel map(Scope scope) {
        Scope scope2 = scope;
        if (scope2 != null) {
            ScopeModel scopeModel = new ScopeModel();
            scopeModel.MyBillsEntityDataFactory = scope2.getScopeTitle();
            scopeModel.PlaceComponentResult = scope2.getScopeDescription();
            return scopeModel;
        }
        return null;
    }

    @Inject
    public ScopeModelMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ScopeModel getAuthRequestContext(Scope scope) {
        if (scope != null) {
            ScopeModel scopeModel = new ScopeModel();
            scopeModel.MyBillsEntityDataFactory = scope.getScopeTitle();
            scopeModel.PlaceComponentResult = scope.getScopeDescription();
            return scopeModel;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ScopeModel BuiltInFictitiousFunctionClassFactory(Agreement agreement) {
        if (agreement != null) {
            ScopeModel scopeModel = new ScopeModel();
            scopeModel.MyBillsEntityDataFactory = agreement.getTitle();
            scopeModel.PlaceComponentResult = agreement.getDescription();
            scopeModel.getAuthRequestContext = agreement.getName();
            scopeModel.BuiltInFictitiousFunctionClassFactory = agreement.getType();
            return scopeModel;
        }
        return null;
    }
}
