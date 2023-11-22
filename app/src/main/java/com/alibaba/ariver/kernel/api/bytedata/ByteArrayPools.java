package com.alibaba.ariver.kernel.api.bytedata;

/* loaded from: classes6.dex */
class ByteArrayPools {
    ByteArrayPools() {
    }

    /* loaded from: classes6.dex */
    static abstract class ByteArrayPool extends Pool<byte[]> {
        private ByteArrayPool() {
            super(1, 8);
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] obtain() {
            byte[] bArr;
            synchronized (this) {
                bArr = (byte[]) super.obtain();
            }
            return bArr;
        }

        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public void free(byte[] bArr) {
            synchronized (this) {
                super.free((ByteArrayPool) bArr);
            }
        }
    }

    /* loaded from: classes6.dex */
    static class ByteArray2Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[2];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray2Pool() {
            super();
        }
    }

    /* loaded from: classes6.dex */
    static class ByteArray4Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[4];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray4Pool() {
            super();
        }
    }

    /* loaded from: classes6.dex */
    static class ByteArray8Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[8];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray8Pool() {
            super();
        }
    }

    /* loaded from: classes6.dex */
    static class ByteArray127Pool extends ByteArrayPool {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.api.bytedata.Pool
        public byte[] newObject() {
            return new byte[127];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteArray127Pool() {
            super();
        }
    }
}
