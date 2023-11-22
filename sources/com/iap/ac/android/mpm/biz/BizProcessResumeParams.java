package com.iap.ac.android.mpm.biz;

import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.container.js.ContainerBridgeContext;
import com.iap.ac.android.mpm.biz.base.EntranceType;

/* loaded from: classes3.dex */
public class BizProcessResumeParams {
    public ContainerBridgeContext bridgeContext;
    public IContainerPresenter containerPresenter;
    public final EntranceType entranceType;

    public BizProcessResumeParams(EntranceType entranceType, IContainerPresenter iContainerPresenter) {
        this.entranceType = entranceType;
        this.containerPresenter = iContainerPresenter;
    }

    public BizProcessResumeParams(EntranceType entranceType, IContainerPresenter iContainerPresenter, ContainerBridgeContext containerBridgeContext) {
        this.entranceType = entranceType;
        this.containerPresenter = iContainerPresenter;
        this.bridgeContext = containerBridgeContext;
    }
}
