package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: classes3.dex */
public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {
    protected Transformer DatabaseTableConfigUtil;
    protected float[] GetContactSyncConfig = new float[2];
    protected ViewPortHandler NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected View initRecordTimeStamp;
    protected float isLayoutRequested;
    protected float newProxyInstance;

    public ViewPortJob(ViewPortHandler viewPortHandler, float f, float f2, Transformer transformer, View view) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = viewPortHandler;
        this.isLayoutRequested = f;
        this.newProxyInstance = f2;
        this.DatabaseTableConfigUtil = transformer;
        this.initRecordTimeStamp = view;
    }
}
