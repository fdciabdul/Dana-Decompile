package id.dana.data.di;

import android.content.Context;
import com.alipay.iap.android.common.securityprofiles.extractor.SecurityProfileExtractor;

/* loaded from: classes8.dex */
public class Injection {
    public static SecurityProfileExtractor provideSecurityProfileExtractor(Context context, String str) {
        return new SecurityProfileExtractor(context, str);
    }
}
