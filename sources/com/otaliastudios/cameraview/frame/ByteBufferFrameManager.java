package com.otaliastudios.cameraview.frame;

import com.otaliastudios.cameraview.size.Size;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes8.dex */
public class ByteBufferFrameManager extends FrameManager<byte[]> {
    private LinkedBlockingQueue<byte[]> BuiltInFictitiousFunctionClassFactory;
    private BufferCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;

    /* loaded from: classes8.dex */
    public interface BufferCallback {
        void BuiltInFictitiousFunctionClassFactory(byte[] bArr);
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    protected final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(byte[] bArr, boolean z) {
        byte[] bArr2 = bArr;
        if (z && bArr2.length == PlaceComponentResult()) {
            if (this.MyBillsEntityDataFactory == 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(bArr2);
            } else {
                this.BuiltInFictitiousFunctionClassFactory.offer(bArr2);
            }
        }
    }

    public ByteBufferFrameManager(int i, BufferCallback bufferCallback) {
        super(i, byte[].class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bufferCallback;
        this.MyBillsEntityDataFactory = 0;
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public final void PlaceComponentResult(int i, Size size) {
        super.PlaceComponentResult(i, size);
        int PlaceComponentResult = PlaceComponentResult();
        for (int i2 = 0; i2 < BuiltInFictitiousFunctionClassFactory(); i2++) {
            if (this.MyBillsEntityDataFactory == 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(new byte[PlaceComponentResult]);
            } else {
                this.BuiltInFictitiousFunctionClassFactory.offer(new byte[PlaceComponentResult]);
            }
        }
    }

    @Override // com.otaliastudios.cameraview.frame.FrameManager
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        if (this.MyBillsEntityDataFactory == 1) {
            this.BuiltInFictitiousFunctionClassFactory.clear();
        }
    }
}
