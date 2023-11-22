package com.alibaba.ariver.remotedebug.datachannel;

import com.alibaba.ariver.remotedebug.datachannel.DataChannel;

/* loaded from: classes6.dex */
public abstract class AbsDataChannel implements DataChannel {

    /* renamed from: a  reason: collision with root package name */
    private DataChannel.DataStatusChangedListener f6189a;
    private String b;

    public AbsDataChannel(String str, DataChannel.DataStatusChangedListener dataStatusChangedListener) {
        this.f6189a = dataStatusChangedListener;
        this.b = str;
    }

    public DataChannel.DataStatusChangedListener getDataStatusChangedListener() {
        return this.f6189a;
    }

    public String getId() {
        return this.b;
    }
}
