package com.google.zxing.datamatrix.encoder;

import com.alibaba.ariver.resource.parser.tar.TarHeader;

/* loaded from: classes3.dex */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public final int getDataLengthForInterleavedBlock(int i) {
        if (i <= 8) {
            return 156;
        }
        return TarHeader.USTAR_FILENAME_PREFIX;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public final int getInterleavedBlockCount() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }
}
