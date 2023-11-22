package com.alibaba.ariver.remotedebug.datachannel;

import com.alibaba.ariver.remotedebug.datachannel.DataChannel;

/* loaded from: classes6.dex */
public class DataChannelFactory {
    public static DataChannel createDataChannel(int i, String str, DataChannel.DataStatusChangedListener dataStatusChangedListener) {
        return new WebSocketDataChannel(str, dataStatusChangedListener);
    }
}
