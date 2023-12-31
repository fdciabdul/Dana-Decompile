package com.alibaba.griver.bluetooth.altbeacon.bluetooth;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class BleAdvertisement {
    private static final String TAG = "BleAdvertisement";
    private byte[] mBytes;
    private List<Pdu> mPdus = parsePdus();

    public BleAdvertisement(byte[] bArr) {
        this.mBytes = bArr;
    }

    private List<Pdu> parsePdus() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        do {
            Pdu parse = Pdu.parse(this.mBytes, i);
            if (parse != null) {
                i = i + parse.getDeclaredLength() + 1;
                arrayList.add(parse);
            }
            if (parse == null) {
                break;
            }
        } while (i < this.mBytes.length);
        return arrayList;
    }

    public List<Pdu> getPdus() {
        return this.mPdus;
    }
}
