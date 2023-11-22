package com.alipay.mobile.security.bio.security;

import android.util.Base64;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes7.dex */
public class RSAEncrypt {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final String privateKeyName = "privateKey.keystore";
    public static final String publickKeyName = "publicKey.keystore";

    public static void genKeyPair(String str) {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(RSAHelper.DEFAULT_ALGORITHM);
        } catch (NoSuchAlgorithmException unused) {
            keyPairGenerator = null;
        }
        keyPairGenerator.initialize(2048, new SecureRandom());
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        try {
            String encodeToString = Base64.encodeToString(((RSAPublicKey) generateKeyPair.getPublic()).getEncoded(), 0);
            String encodeToString2 = Base64.encodeToString(rSAPrivateKey.getEncoded(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append("publicKey.keystore");
            FileWriter fileWriter = new FileWriter(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("/");
            sb2.append("privateKey.keystore");
            FileWriter fileWriter2 = new FileWriter(sb2.toString());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
            bufferedWriter.write(encodeToString);
            bufferedWriter2.write(encodeToString2);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
            bufferedWriter2.flush();
            bufferedWriter2.close();
            fileWriter2.close();
        } catch (Exception unused2) {
        }
    }

    public static RSAPublicKey loadPublicKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.charAt(0) != '-') {
                        sb.append(readLine);
                        sb.append('\r');
                    }
                } else {
                    return loadPublicKeyByStr(sb.toString());
                }
            }
        } catch (IOException unused) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException unused2) {
            throw new Exception("公钥输入流为空");
        }
    }

    public static String loadPublicKeyByFile(String str) throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append("publicKey.keystore");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sb.toString()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.charAt(0) != '-') {
                        sb2.append(readLine);
                        sb2.append('\r');
                    }
                } else {
                    bufferedReader.close();
                    return sb2.toString();
                }
            }
        } catch (IOException unused) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException unused2) {
            throw new Exception("公钥输入流为空");
        }
    }

    public static RSAPublicKey loadPublicKeyByStr(String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("\n")) {
            if (str2.charAt(0) != '-') {
                sb.append(str2);
                sb.append('\r');
            }
        }
        try {
            return (RSAPublicKey) KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(sb.toString(), 0)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static RSAPrivateKey loadPrivateKey(InputStream inputStream) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.charAt(0) != '-') {
                        sb.append(readLine);
                        sb.append('\r');
                    }
                } else {
                    return loadPrivateKeyByStr(sb.toString());
                }
            }
        } catch (IOException unused) {
            throw new Exception("私钥数据读取错误");
        } catch (NullPointerException unused2) {
            throw new Exception("私钥输入流为空");
        }
    }

    public static String loadPrivateKeyByFile(String str) throws Exception {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append("privateKey.keystore");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sb.toString()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.charAt(0) != '-') {
                        sb2.append(readLine);
                        sb2.append('\r');
                    }
                } else {
                    bufferedReader.close();
                    return sb2.toString();
                }
            }
        } catch (IOException unused) {
            throw new Exception("私钥数据读取错误");
        } catch (NullPointerException unused2) {
            throw new Exception("私钥输入流为空");
        }
    }

    public static RSAPrivateKey loadPrivateKeyByStr(String str) throws Exception {
        try {
            return (RSAPrivateKey) KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("私钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("私钥非法");
        }
    }

    public static byte[] encrypt(RSAPublicKey rSAPublicKey, byte[] bArr) throws Exception {
        if (rSAPublicKey == null) {
            throw new Exception("加密公钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION);
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new Exception("加密公钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此加密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("明文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("明文长度非法");
        } catch (NoSuchPaddingException unused5) {
            return null;
        }
    }

    public static byte[] encrypt(RSAPrivateKey rSAPrivateKey, byte[] bArr) throws Exception {
        if (rSAPrivateKey == null) {
            throw new Exception("加密私钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION);
            cipher.init(1, rSAPrivateKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new Exception("加密私钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此加密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("明文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("明文长度非法");
        } catch (NoSuchPaddingException unused5) {
            return null;
        }
    }

    public static byte[] decrypt(RSAPrivateKey rSAPrivateKey, byte[] bArr) throws Exception {
        if (rSAPrivateKey == null) {
            throw new Exception("解密私钥为空, 请设置");
        }
        try {
            Cipher cipher = Cipher.getInstance(RSAHelper.DEFAULT_TRANSFORMATION);
            cipher.init(2, rSAPrivateKey);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException unused) {
            throw new Exception("解密私钥非法,请检查");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此解密算法");
        } catch (BadPaddingException unused3) {
            throw new Exception("密文数据已损坏");
        } catch (IllegalBlockSizeException unused4) {
            throw new Exception("密文长度非法");
        } catch (NoSuchPaddingException unused5) {
            return null;
        }
    }
}
