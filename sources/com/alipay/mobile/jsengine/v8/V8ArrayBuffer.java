package com.alipay.mobile.jsengine.v8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public class V8ArrayBuffer extends V8Value {
    ByteBuffer byteBuffer;

    public V8ArrayBuffer(V8 v8, int i) {
        super(v8);
        initialize(v8.getV8RuntimePtr(), Integer.valueOf(i));
        ByteBuffer createV8ArrayBufferBackingStore = v8.createV8ArrayBufferBackingStore(v8.getV8RuntimePtr(), this.objectHandle, i);
        this.byteBuffer = createV8ArrayBufferBackingStore;
        createV8ArrayBufferBackingStore.order(ByteOrder.nativeOrder());
    }

    public V8ArrayBuffer(V8 v8, ByteBuffer byteBuffer) {
        super(v8);
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("ByteBuffer must be a allocated as a direct ByteBuffer");
        }
        initialize(v8.getV8RuntimePtr(), byteBuffer);
        this.byteBuffer = byteBuffer;
        byteBuffer.order(ByteOrder.nativeOrder());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public void initialize(long j, Object obj) {
        this.v8.checkThread();
        if (obj instanceof ByteBuffer) {
            ByteBuffer byteBuffer = (ByteBuffer) obj;
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), byteBuffer, byteBuffer.limit());
        } else {
            this.objectHandle = this.v8.initNewV8ArrayBuffer(this.v8.getV8RuntimePtr(), ((Integer) obj).intValue());
        }
        this.released = false;
        addObjectReference(this.objectHandle);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    protected V8Value createTwin() {
        return new V8ArrayBuffer(this.v8, this.byteBuffer);
    }

    @Override // com.alipay.mobile.jsengine.v8.V8Value
    public V8ArrayBuffer twin() {
        this.v8.checkThread();
        checkReleased();
        return (V8ArrayBuffer) super.twin();
    }

    public final V8ArrayBuffer put(byte[] bArr) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.put(bArr);
        return this;
    }

    public V8ArrayBuffer put(ByteBuffer byteBuffer) {
        this.v8.checkThread();
        checkReleased();
        this.byteBuffer.put(byteBuffer);
        return this;
    }
}
