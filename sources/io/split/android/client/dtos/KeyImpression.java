package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.impressions.Impression;
import io.split.android.client.storage.common.InBytesSizable;

/* loaded from: classes6.dex */
public class KeyImpression implements InBytesSizable, Identifiable {
    static final String FIELD_BUCKETING_KEY = "b";
    static final String FIELD_CHANGE_NUMBER = "c";
    static final String FIELD_KEY_NAME = "k";
    static final String FIELD_LABEL = "r";
    static final String FIELD_PREVIOUS_TIME = "pt";
    static final String FIELD_TIME = "m";
    static final String FIELD_TREATMENT = "t";
    @SerializedName("b")
    public String bucketingKey;
    @SerializedName("c")
    public Long changeNumber;
    public transient String feature;
    @SerializedName(FIELD_KEY_NAME)
    public String keyName;
    @SerializedName("r")
    public String label;
    @SerializedName(FIELD_PREVIOUS_TIME)
    public Long previousTime;
    public transient long storageId;
    @SerializedName(FIELD_TIME)
    public long time;
    @SerializedName("t")
    public String treatment;

    @Override // io.split.android.client.storage.common.InBytesSizable
    public long getSizeInBytes() {
        return 150L;
    }

    public KeyImpression() {
    }

    public KeyImpression(Impression impression) {
        this.feature = impression.split();
        this.keyName = impression.key();
        this.bucketingKey = impression.bucketingKey();
        this.label = impression.appliedRule();
        this.treatment = impression.treatment();
        this.time = impression.time();
        this.changeNumber = impression.changeNumber();
        this.previousTime = impression.previousTime();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyImpression keyImpression = (KeyImpression) obj;
        if (this.time != keyImpression.time) {
            return false;
        }
        String str = this.feature;
        if (str == null ? keyImpression.feature == null : str.equals(keyImpression.feature)) {
            if (this.keyName.equals(keyImpression.keyName) && this.treatment.equals(keyImpression.treatment)) {
                if (this.bucketingKey == null) {
                    return keyImpression.bucketingKey == null;
                } else if (this.previousTime.equals(keyImpression.previousTime)) {
                    return this.bucketingKey.equals(keyImpression.bucketingKey);
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.feature;
        int hashCode = str != null ? str.hashCode() : 0;
        int hashCode2 = this.keyName.hashCode();
        String str2 = this.bucketingKey;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        int hashCode4 = this.treatment.hashCode();
        long j = this.time;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.previousTime.hashCode();
    }

    public static KeyImpression fromImpression(Impression impression) {
        KeyImpression keyImpression = new KeyImpression();
        keyImpression.feature = impression.split();
        keyImpression.keyName = impression.key();
        keyImpression.bucketingKey = impression.bucketingKey();
        keyImpression.time = impression.time();
        keyImpression.changeNumber = impression.changeNumber();
        keyImpression.treatment = impression.treatment();
        keyImpression.label = impression.appliedRule();
        keyImpression.previousTime = impression.previousTime();
        return keyImpression;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.storageId;
    }
}
