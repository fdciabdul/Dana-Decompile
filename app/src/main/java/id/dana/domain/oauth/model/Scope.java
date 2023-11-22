package id.dana.domain.oauth.model;

/* loaded from: classes4.dex */
public class Scope {
    private String scopeDescription;
    private String scopeName;
    private String scopeTitle;
    private String scopeType;

    public Scope() {
    }

    public Scope(String str, String str2) {
        this.scopeTitle = str;
        this.scopeDescription = str2;
    }

    public String getScopeTitle() {
        return this.scopeTitle;
    }

    public void setScopeTitle(String str) {
        this.scopeTitle = str;
    }

    public String getScopeDescription() {
        return this.scopeDescription;
    }

    public void setScopeDescription(String str) {
        this.scopeDescription = str;
    }

    public String getScopeName() {
        return this.scopeName;
    }

    public void setScopeName(String str) {
        this.scopeName = str;
    }

    public String getScopeType() {
        return this.scopeType;
    }

    public void setScopeType(String str) {
        this.scopeType = str;
    }
}
