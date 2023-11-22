package io.split.android.client.service.sseclient.notifications;

import io.split.android.client.exceptions.MySegmentsParsingException;
import io.split.android.client.service.sseclient.notifications.KeyList;
import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.CompressionUtil;
import io.split.android.client.utils.MurmurHash3;
import io.split.android.client.utils.StringHelper;
import java.math.BigInteger;
import java.util.HashSet;

/* loaded from: classes6.dex */
public class MySegmentsV2PayloadDecoder {
    public final int FIELD_SIZE = 8;

    public String decodeAsString(String str, CompressionUtil compressionUtil) throws MySegmentsParsingException {
        return StringHelper.stringFromBytes(decodeAsBytes(str, compressionUtil));
    }

    public byte[] decodeAsBytes(String str, CompressionUtil compressionUtil) throws MySegmentsParsingException {
        byte[] bytesDecode = Base64Util.bytesDecode(str);
        if (bytesDecode == null) {
            throw new MySegmentsParsingException("Could not decode payload");
        }
        byte[] decompress = compressionUtil.decompress(bytesDecode);
        if (decompress != null) {
            return decompress;
        }
        throw new MySegmentsParsingException("Could not decompress payload");
    }

    public boolean isKeyInBitmap(byte[] bArr, int i) {
        int i2 = i / 8;
        return i2 <= bArr.length - 1 && (bArr[i2] & (1 << ((byte) (i % 8)))) != 0;
    }

    public BigInteger hashKey(String str) {
        return MurmurHash3.unsignedHash128x64(str.getBytes(StringHelper.defaultCharset()))[0];
    }

    public int computeKeyIndex(BigInteger bigInteger, int i) {
        return bigInteger.remainder(BigInteger.valueOf(i * 8)).intValue();
    }

    public KeyList.Action getKeyListAction(KeyList keyList, BigInteger bigInteger) {
        if (new HashSet(keyList.getAdded()).contains(bigInteger)) {
            return KeyList.Action.ADD;
        }
        if (new HashSet(keyList.getRemoved()).contains(bigInteger)) {
            return KeyList.Action.REMOVE;
        }
        return KeyList.Action.NONE;
    }
}
