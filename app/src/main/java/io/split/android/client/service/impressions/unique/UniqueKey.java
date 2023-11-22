package io.split.android.client.service.impressions.unique;

import com.alibaba.ariver.kernel.RVStartParams;
import com.google.gson.annotations.SerializedName;
import io.split.android.client.dtos.Identifiable;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class UniqueKey implements Identifiable {
    @SerializedName(RVStartParams.KEY_FULLSCREEN_SHORT)
    private final Set<String> mFeatures;
    @SerializedName("k")
    private final String mKey;
    private transient long storageId;

    public UniqueKey(String str, Set<String> set) {
        this.mKey = str;
        this.mFeatures = set;
    }

    public UniqueKey(String str) {
        this(str, new HashSet());
    }

    public String getKey() {
        return this.mKey;
    }

    public Set<String> getFeatures() {
        return this.mFeatures;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.storageId;
    }

    public void setStorageId(long j) {
        this.storageId = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UniqueKey uniqueKey = (UniqueKey) obj;
        return this.mKey.equals(uniqueKey.mKey) && this.mFeatures.equals(uniqueKey.mFeatures);
    }

    public int hashCode() {
        return this.mKey.hashCode() + this.mFeatures.hashCode();
    }
}
