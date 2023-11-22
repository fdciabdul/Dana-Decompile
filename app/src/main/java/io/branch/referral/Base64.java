package io.branch.referral;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
class Base64 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class Coder {
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public byte[] PlaceComponentResult;

        Coder() {
        }
    }

    public static byte[] MyBillsEntityDataFactory(byte[] bArr) {
        return PlaceComponentResult(bArr, bArr.length);
    }

    private static byte[] PlaceComponentResult(byte[] bArr, int i) {
        Decoder decoder = new Decoder(2, new byte[(i * 3) / 4]);
        if (!decoder.BuiltInFictitiousFunctionClassFactory(bArr, i)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (decoder.KClassImpl$Data$declaredNonStaticMembers$2 == decoder.PlaceComponentResult.length) {
            return decoder.PlaceComponentResult;
        }
        byte[] bArr2 = new byte[decoder.KClassImpl$Data$declaredNonStaticMembers$2];
        System.arraycopy(decoder.PlaceComponentResult, 0, bArr2, 0, decoder.KClassImpl$Data$declaredNonStaticMembers$2);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Decoder extends Coder {
        private static final int[] MyBillsEntityDataFactory = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] getAuthRequestContext = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private final int[] BuiltInFictitiousFunctionClassFactory;
        private int getErrorConfigVersion;
        private int lookAheadTest;

        public Decoder(int i, byte[] bArr) {
            this.PlaceComponentResult = bArr;
            this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
            this.lookAheadTest = 0;
            this.getErrorConfigVersion = 0;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) {
            int i2 = this.lookAheadTest;
            if (i2 == 6) {
                return false;
            }
            int i3 = i + 0;
            int i4 = this.getErrorConfigVersion;
            byte[] bArr2 = this.PlaceComponentResult;
            int[] iArr = this.BuiltInFictitiousFunctionClassFactory;
            int i5 = 0;
            int i6 = 0;
            while (i6 < i3) {
                if (i2 == 0) {
                    while (true) {
                        int i7 = i6 + 4;
                        if (i7 > i3 || (i4 = (iArr[bArr[i6] & 255] << 18) | (iArr[bArr[i6 + 1] & 255] << 12) | (iArr[bArr[i6 + 2] & 255] << 6) | iArr[bArr[i6 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i5 + 2] = (byte) i4;
                        bArr2[i5 + 1] = (byte) (i4 >> 8);
                        bArr2[i5] = (byte) (i4 >> 16);
                        i5 += 3;
                        i6 = i7;
                    }
                    if (i6 >= i3) {
                        break;
                    }
                }
                int i8 = iArr[bArr[i6] & 255];
                if (i2 != 0) {
                    if (i2 == 1) {
                        if (i8 < 0) {
                            if (i8 != -1) {
                                this.lookAheadTest = 6;
                                return false;
                            }
                        }
                        i8 |= i4 << 6;
                    } else if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5 && i8 != -1) {
                                    this.lookAheadTest = 6;
                                    return false;
                                }
                            } else if (i8 == -2) {
                                i2++;
                            } else if (i8 != -1) {
                                this.lookAheadTest = 6;
                                return false;
                            }
                        } else if (i8 >= 0) {
                            int i9 = (i4 << 6) | i8;
                            bArr2[i5 + 2] = (byte) i9;
                            bArr2[i5 + 1] = (byte) (i9 >> 8);
                            bArr2[i5] = (byte) (i9 >> 16);
                            i5 += 3;
                            i4 = i9;
                            i2 = 0;
                        } else if (i8 == -2) {
                            bArr2[i5 + 1] = (byte) (i4 >> 2);
                            bArr2[i5] = (byte) (i4 >> 10);
                            i5 += 2;
                            i2 = 5;
                        } else if (i8 != -1) {
                            this.lookAheadTest = 6;
                            return false;
                        }
                    } else if (i8 >= 0) {
                        i8 |= i4 << 6;
                    } else if (i8 == -2) {
                        bArr2[i5] = (byte) (i4 >> 4);
                        i5++;
                        i2 = 4;
                    } else if (i8 != -1) {
                        this.lookAheadTest = 6;
                        return false;
                    }
                    i2++;
                    i4 = i8;
                } else {
                    if (i8 < 0) {
                        if (i8 != -1) {
                            this.lookAheadTest = 6;
                            return false;
                        }
                    }
                    i2++;
                    i4 = i8;
                }
                i6++;
            }
            if (i2 == 1) {
                this.lookAheadTest = 6;
                return false;
            }
            if (i2 == 2) {
                bArr2[i5] = (byte) (i4 >> 4);
                i5++;
            } else if (i2 == 3) {
                int i10 = i5 + 1;
                bArr2[i5] = (byte) (i4 >> 10);
                i5 = i10 + 1;
                bArr2[i10] = (byte) (i4 >> 2);
            } else if (i2 == 4) {
                this.lookAheadTest = 6;
                return false;
            }
            this.lookAheadTest = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
            return true;
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        try {
            return new String(PlaceComponentResult(bArr), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private static byte[] PlaceComponentResult(byte[] bArr) {
        return KClassImpl$Data$declaredNonStaticMembers$2(bArr, bArr.length, 2);
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, int i, int i2) {
        Encoder encoder = new Encoder(2);
        int i3 = (i / 3) * 4;
        if (encoder.MyBillsEntityDataFactory) {
            if (i % 3 > 0) {
                i3 += 4;
            }
        } else {
            int i4 = i % 3;
            if (i4 == 1) {
                i3 += 2;
            } else if (i4 == 2) {
                i3 += 3;
            }
        }
        if (encoder.BuiltInFictitiousFunctionClassFactory && i > 0) {
            i3 += (((i - 1) / 57) + 1) * (encoder.getAuthRequestContext ? 2 : 1);
        }
        encoder.PlaceComponentResult = new byte[i3];
        encoder.MyBillsEntityDataFactory(bArr, i);
        return encoder.PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Encoder extends Coder {
        private static final byte[] moveToNextValue = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 43, 47};
        private static final byte[] scheduleImpl = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 45, 95};
        public final boolean BuiltInFictitiousFunctionClassFactory;
        public final boolean MyBillsEntityDataFactory;
        private final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final byte[] NetworkUserEntityData$$ExternalSyntheticLambda1;
        public final boolean getAuthRequestContext;
        private int getErrorConfigVersion;
        int lookAheadTest;

        public Encoder(int i) {
            this.PlaceComponentResult = null;
            this.MyBillsEntityDataFactory = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.BuiltInFictitiousFunctionClassFactory = z;
            this.getAuthRequestContext = (i & 4) != 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = (i & 8) == 0 ? moveToNextValue : scheduleImpl;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new byte[2];
            this.lookAheadTest = 0;
            this.getErrorConfigVersion = z ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ee  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00e1 -> B:30:0x00e7). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00ea -> B:32:0x00eb). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean MyBillsEntityDataFactory(byte[] r18, int r19) {
            /*
                Method dump skipped, instructions count: 438
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Base64.Encoder.MyBillsEntityDataFactory(byte[], int):boolean");
        }
    }

    private Base64() {
    }
}
