package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class StreamEncoder implements Encoder<InputStream> {
    private final ArrayPool PlaceComponentResult;

    @Override // com.bumptech.glide.load.Encoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream, File file, Options options) {
        return getAuthRequestContext(inputStream, file);
    }

    public StreamEncoder(ArrayPool arrayPool) {
        this.PlaceComponentResult = arrayPool;
    }

    private boolean getAuthRequestContext(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        byte[] bArr = (byte[]) this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(65536, byte[].class);
        boolean z = true;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            InstrumentInjector.log_d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused) {
                            }
                        }
                        z = false;
                        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
                        throw th;
                    }
                }
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (IOException e2) {
            e = e2;
        }
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((ArrayPool) bArr);
        return z;
    }
}
