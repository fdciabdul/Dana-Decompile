package com.cyberfend.cyfsecurity;

import android.util.Pair;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class SensorDataBuilder {
    private static final SensorDataBuilder MyBillsEntityDataFactory = new SensorDataBuilder();

    public final native synchronized String buildN(ArrayList<Pair<String, String>> arrayList);

    public final native synchronized void initializeKeyN();

    SensorDataBuilder() {
    }

    static {
        System.loadLibrary("m7dcae");
    }

    public static SensorDataBuilder MyBillsEntityDataFactory() {
        return MyBillsEntityDataFactory;
    }
}
