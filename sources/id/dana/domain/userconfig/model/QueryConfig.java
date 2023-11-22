package id.dana.domain.userconfig.model;

/* loaded from: classes4.dex */
public class QueryConfig<T> {
    private final String bizType;
    private final Class<T> contentType;

    public QueryConfig(String str, Class<T> cls) {
        this.bizType = str;
        this.contentType = cls;
    }

    public String getBizType() {
        return this.bizType;
    }

    public Class<T> getContentType() {
        return this.contentType;
    }
}
