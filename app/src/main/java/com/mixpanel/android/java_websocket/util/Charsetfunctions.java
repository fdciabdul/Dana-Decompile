package com.mixpanel.android.java_websocket.util;

import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* loaded from: classes3.dex */
public class Charsetfunctions {
    public static CodingErrorAction getAuthRequestContext = CodingErrorAction.REPORT;

    public static byte[] PlaceComponentResult(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String BuiltInFictitiousFunctionClassFactory(byte[] bArr, int i) {
        try {
            return new String(bArr, 0, i, "ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String PlaceComponentResult(ByteBuffer byteBuffer) throws InvalidDataException {
        CharsetDecoder newDecoder = Charset.forName("UTF8").newDecoder();
        newDecoder.onMalformedInput(getAuthRequestContext);
        newDecoder.onUnmappableCharacter(getAuthRequestContext);
        try {
            byteBuffer.mark();
            String obj = newDecoder.decode(byteBuffer).toString();
            byteBuffer.reset();
            return obj;
        } catch (CharacterCodingException e) {
            throw new InvalidDataException(1007, e);
        }
    }
}
