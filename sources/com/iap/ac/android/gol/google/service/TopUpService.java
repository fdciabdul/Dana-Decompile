package com.iap.ac.android.gol.google.service;

import com.iap.ac.android.gol.callback.Callback;
import com.iap.ac.android.gol.google.model.TopUpParams;
import com.iap.ac.android.gol.google.model.TopUpResult;

/* loaded from: classes3.dex */
public interface TopUpService {
    void topUp(TopUpParams topUpParams, Callback<TopUpResult> callback);
}
