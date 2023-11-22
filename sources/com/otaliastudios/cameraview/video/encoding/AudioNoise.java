package com.otaliastudios.cameraview.video.encoding;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class AudioNoise {
    static final Random PlaceComponentResult = new Random();
    final ByteBuffer BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioNoise(AudioConfig audioConfig) {
        this.BuiltInFictitiousFunctionClassFactory = ByteBuffer.allocateDirect(audioConfig.MyBillsEntityDataFactory * 1024 * 1).order(ByteOrder.nativeOrder());
        double d = audioConfig.MyBillsEntityDataFactory * 1024;
        Double.isNaN(d);
        double d2 = 3.141592653589793d / (d / 2.0d);
        double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (this.BuiltInFictitiousFunctionClassFactory.hasRemaining()) {
            d3 += 1.0d;
            short sin = (short) (Math.sin(d3 * d2) * 10.0d);
            this.BuiltInFictitiousFunctionClassFactory.put((byte) sin);
            this.BuiltInFictitiousFunctionClassFactory.put((byte) (sin >> 8));
        }
        this.BuiltInFictitiousFunctionClassFactory.rewind();
    }
}
