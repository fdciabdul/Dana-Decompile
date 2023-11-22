package io.split.android.client.service.sseclient.notifications;

import com.google.gson.annotations.SerializedName;
import java.math.BigInteger;
import java.util.List;

/* loaded from: classes6.dex */
public class KeyList {
    static final String FIELD_ADDED = "a";
    static final String FIELD_REMOVED = "r";
    @SerializedName("a")
    private List<BigInteger> added;
    @SerializedName("r")
    private List<BigInteger> removed;

    /* loaded from: classes6.dex */
    public enum Action {
        NONE,
        ADD,
        REMOVE
    }

    public List<BigInteger> getAdded() {
        return this.added;
    }

    public List<BigInteger> getRemoved() {
        return this.removed;
    }
}
