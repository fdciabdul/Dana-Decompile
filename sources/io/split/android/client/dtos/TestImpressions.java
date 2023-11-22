package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class TestImpressions {
    static final String FIELD_KEY_IMPRESSIONS = "i";
    static final String FIELD_TEST_NAME = "f";
    @SerializedName("i")
    public List<KeyImpression> keyImpressions;
    @SerializedName("f")
    public String testName;
}
