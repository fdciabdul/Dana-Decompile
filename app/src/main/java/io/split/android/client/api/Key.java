package io.split.android.client.api;

import java.util.Objects;

/* loaded from: classes6.dex */
public final class Key {
    private final String mBucketingKey;
    private final String mMatchingKey;

    public Key(String str, String str2) {
        this.mMatchingKey = str;
        this.mBucketingKey = str2;
    }

    public Key(String str) {
        this(str, null);
    }

    public final String matchingKey() {
        return this.mMatchingKey;
    }

    public final String bucketingKey() {
        return this.mBucketingKey;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Key) {
            Key key = (Key) obj;
            return this.mMatchingKey.equals(key.mMatchingKey) && Objects.equals(this.mBucketingKey, key.mBucketingKey);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.mMatchingKey.hashCode() ^ 17000051) * 1000003;
        String str = this.mBucketingKey;
        return str != null ? hashCode ^ str.hashCode() : hashCode;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mMatchingKey);
        sb.append(", ");
        sb.append(this.mBucketingKey);
        return sb.toString();
    }
}
