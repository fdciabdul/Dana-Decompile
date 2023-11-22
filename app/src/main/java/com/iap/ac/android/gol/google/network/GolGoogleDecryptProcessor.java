package com.iap.ac.android.gol.google.network;

import android.content.Context;
import com.iap.ac.android.gol.google.model.DecryptRequest;
import com.iap.ac.android.gol.google.model.DecryptResult;

/* loaded from: classes8.dex */
public class GolGoogleDecryptProcessor extends BaseProcessor<DecryptRequest, DecryptResult> {
    @Override // com.iap.ac.android.gol.google.network.BaseProcessor
    String getPath() {
        return "/api/open/common_json/extensions/prepareTopUpInfo";
    }

    public GolGoogleDecryptProcessor(Context context) {
        super(context);
    }
}
