package androidx.multidex;

import id.dana.data.constant.BranchLinkConstant;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
final class ZipUtil {

    /* loaded from: classes.dex */
    static class CentralDirectory {
        long KClassImpl$Data$declaredNonStaticMembers$2;
        long MyBillsEntityDataFactory;

        CentralDirectory() {
        }
    }

    ZipUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long MyBillsEntityDataFactory(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, BranchLinkConstant.PayloadKey.REFERRAL);
        try {
            long length = randomAccessFile.length() - 22;
            if (length < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("File too short to be a zip file: ");
                sb.append(randomAccessFile.length());
                throw new ZipException(sb.toString());
            }
            long j = length - 65536;
            if (j < 0) {
                j = 0;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    CentralDirectory centralDirectory = new CentralDirectory();
                    centralDirectory.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    centralDirectory.MyBillsEntityDataFactory = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                    CRC32 crc32 = new CRC32();
                    long j2 = centralDirectory.KClassImpl$Data$declaredNonStaticMembers$2;
                    randomAccessFile.seek(centralDirectory.MyBillsEntityDataFactory);
                    byte[] bArr = new byte[16384];
                    int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
                    while (read != -1) {
                        crc32.update(bArr, 0, read);
                        j2 -= read;
                        if (j2 == 0) {
                            break;
                        }
                        read = randomAccessFile.read(bArr, 0, (int) Math.min(16384L, j2));
                    }
                    return crc32.getValue();
                }
                length--;
            } while (length >= j);
            throw new ZipException("End Of Central Directory signature not found");
        } finally {
            randomAccessFile.close();
        }
    }
}
