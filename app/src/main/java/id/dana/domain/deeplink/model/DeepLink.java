package id.dana.domain.deeplink.model;

import java.util.Objects;

/* loaded from: classes4.dex */
public class DeepLink {
    private final String link;

    public DeepLink(String str) {
        this.link = str;
    }

    public String getLink() {
        return this.link;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.link, ((DeepLink) obj).link);
    }

    public int hashCode() {
        return Objects.hash(this.link);
    }
}
