package com.alipay.android.phone.mobilesdk.socketcraft.handshake;

import java.util.Iterator;

/* loaded from: classes6.dex */
public interface Handshakedata {
    byte[] getContent();

    String getFieldValue(String str);

    boolean hasFieldValue(String str);

    Iterator<String> iterateHttpFields();
}
