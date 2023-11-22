package id.dana.data.verifytoken.repository.model;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class VerifyToken implements Serializable {
    private String separator;
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getSeparator() {
        return this.separator;
    }

    public void setSeparator(String str) {
        this.separator = str;
    }
}
