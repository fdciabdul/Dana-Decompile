package com.iap.ac.android.biz.common.model.remoteconfig.cpm;

/* loaded from: classes3.dex */
public class CPMConfig {
    public int clientIndexValidHours;
    public int clientOtpSeedValidHours;
    public String clientPublicKey;
    public String codeIssuer;
    public String codeType;
    public int otpGenerateInterval;
    public boolean onlineCode = true;
    public int encodeNum = 5;
    public int encodeFrequency = 30;
    public int decodeWindowLeft = -60;
    public int decodeWindowRight = 60;
}
