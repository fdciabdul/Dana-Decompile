package com.alibaba.jsi.standard.js;

import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.LeakUtil;
import com.alibaba.wireless.security.SecExceptionCode;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class JSArrayBuffer extends JSObject {
    public static final int kArrayBuffer = 0;
    public static final int kBigInt64Array = 12;
    public static final int kBigUint64Array = 11;
    public static final int kFloat32Array = 9;
    public static final int kFloat64Array = 10;
    public static final int kInt16Array = 6;
    public static final int kInt32Array = 8;
    public static final int kInt8Array = 4;
    public static final int kSharedArrayBuffer = 1;
    public static final int kUint16Array = 5;
    public static final int kUint32Array = 7;
    public static final int kUint8Array = 2;
    public static final int kUint8ClampedArray = 3;
    private int mArrayBufferType;
    private ByteBuffer mBuffer;
    private int mByteLength;
    private int mIsExternal;
    private int mLength;

    @Override // com.alibaba.jsi.standard.js.JSValue
    public boolean isArrayBuffer() {
        return true;
    }

    public JSArrayBuffer(JSContext jSContext, int i, int i2) {
        super(jSContext, Bridge.createNative(jSContext, 11, i, i2));
        this.mArrayBufferType = -1;
        this.mIsExternal = -1;
        this.mLength = -1;
        this.mByteLength = -1;
        this.mBuffer = null;
    }

    public JSArrayBuffer(JSContext jSContext, int i, ByteBuffer byteBuffer) {
        super(jSContext, 0L);
        this.mArrayBufferType = -1;
        this.mIsExternal = -1;
        this.mLength = -1;
        this.mByteLength = -1;
        this.mBuffer = null;
        if (byteBuffer == null) {
            throw new NullPointerException("buffer can not be null!");
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("buffer must be a direct ByteBuffer!");
        }
        this.mBuffer = byteBuffer;
        this.mNativePtr = Bridge.createNative(jSContext, 11, i, byteBuffer.limit(), new Object[]{byteBuffer});
        LeakUtil.add(jSContext, this);
    }

    public JSArrayBuffer(JSContext jSContext, long j) {
        super(jSContext, j);
        this.mArrayBufferType = -1;
        this.mIsExternal = -1;
        this.mLength = -1;
        this.mByteLength = -1;
        this.mBuffer = null;
    }

    public int getArrayBufferType(JSContext jSContext) {
        checkDeleted();
        if (this.mArrayBufferType == -1) {
            Object cmd = Bridge.cmd(jSContext, 500, this.mNativePtr);
            if (cmd instanceof Long) {
                this.mArrayBufferType = ((Long) cmd).intValue();
            } else {
                this.mArrayBufferType = 0;
            }
        }
        return this.mArrayBufferType;
    }

    public boolean isExternal(JSContext jSContext) {
        checkDeleted();
        if (this.mIsExternal == -1) {
            if (Bridge.cmd(jSContext, 501, this.mNativePtr) != null) {
                this.mIsExternal = 1;
            } else {
                this.mIsExternal = 0;
            }
        }
        return this.mIsExternal == 1;
    }

    public int length(JSContext jSContext) {
        checkDeleted();
        if (this.mLength == -1) {
            Object cmd = Bridge.cmd(jSContext, 502, this.mNativePtr);
            if (cmd instanceof Long) {
                this.mLength = ((Long) cmd).intValue();
            } else {
                this.mLength = 0;
            }
        }
        return this.mLength;
    }

    public int byteLength(JSContext jSContext) {
        checkDeleted();
        if (this.mByteLength == -1) {
            Object cmd = Bridge.cmd(jSContext, 503, this.mNativePtr);
            if (cmd instanceof Long) {
                this.mByteLength = ((Long) cmd).intValue();
            } else {
                this.mByteLength = 0;
            }
        }
        return this.mByteLength;
    }

    public int byteOffset(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_DYN_STORE_GET_DATA_FILE_KEY_FAILED, this.mNativePtr);
        if (cmd instanceof Long) {
            return ((Long) cmd).intValue();
        }
        return 0;
    }

    public ByteBuffer data(JSContext jSContext) {
        checkDeleted();
        if (this.mBuffer == null) {
            Object cmd = Bridge.cmd(jSContext, (int) SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED, this.mNativePtr);
            if (cmd instanceof ByteBuffer) {
                this.mBuffer = (ByteBuffer) cmd;
            }
        }
        return this.mBuffer;
    }

    public boolean detach(JSContext jSContext) {
        checkDeleted();
        Object cmd = Bridge.cmd(jSContext, 506, this.mNativePtr);
        this.mBuffer = null;
        return cmd != null;
    }
}
