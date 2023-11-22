package com.iap.ac.android.gol.google.network;

import android.content.Context;
import com.iap.ac.android.gol.google.model.EncryptRequest;
import com.iap.ac.android.gol.google.model.EncryptResult;

/* loaded from: classes8.dex */
public class GolGoogleEncryptProcessor extends BaseProcessor<EncryptRequest, EncryptResult> {
    @Override // com.iap.ac.android.gol.google.network.BaseProcessor
    String getPath() {
        return "/api/open/common_json/extensions/finishTopUpInfo";
    }

    public GolGoogleEncryptProcessor(Context context) {
        super(context);
    }
}
