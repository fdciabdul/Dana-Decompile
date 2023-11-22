package com.alipay.mobile.security.bio.service.local.transfer;

import com.alipay.mobile.security.bio.service.local.LocalService;

/* loaded from: classes7.dex */
public abstract class TransferService<Source, Target, Result> extends LocalService {
    public abstract void transfer(Source source, Target target, boolean z, ProgressCallback<Source, Result> progressCallback);
}
