package io.split.android.client.service.impressions.unique;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class MTK {
    @SerializedName(UserMetadata.KEYDATA_FILENAME)
    private final List<UniqueKey> mKeys;

    public MTK(List<UniqueKey> list) {
        this.mKeys = list == null ? new ArrayList<>() : list;
    }

    public MTK() {
        this(new ArrayList());
    }

    public List<UniqueKey> getKeys() {
        return this.mKeys;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mKeys.equals(((MTK) obj).mKeys);
    }

    public int hashCode() {
        return this.mKeys.hashCode();
    }
}
