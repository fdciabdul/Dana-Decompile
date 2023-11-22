package com.alibaba.ariver.resource.parser.tar;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import java.io.File;
import java.util.Date;

/* loaded from: classes6.dex */
public class TarEntry {

    /* renamed from: a  reason: collision with root package name */
    private TarHeader f6231a;
    protected File file;

    private TarEntry() {
        this.file = null;
        this.f6231a = new TarHeader();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TarEntry(byte[] bArr) {
        this();
        parseTarHeader(bArr);
    }

    public TarEntry(TarHeader tarHeader) {
        this.file = null;
        this.f6231a = tarHeader;
    }

    public boolean equals(TarEntry tarEntry) {
        return this.f6231a.name.toString().equals(tarEntry.f6231a.name.toString());
    }

    public boolean isDescendent(TarEntry tarEntry) {
        return tarEntry.f6231a.name.toString().startsWith(this.f6231a.name.toString());
    }

    public TarHeader getHeader() {
        return this.f6231a;
    }

    public String getName() {
        String obj = this.f6231a.name.toString();
        if (this.f6231a.namePrefix == null || this.f6231a.namePrefix.toString().equals("")) {
            return obj;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6231a.namePrefix.toString());
        sb.append("/");
        sb.append(obj);
        return sb.toString();
    }

    public void setName(String str) {
        this.f6231a.name = new StringBuffer(str);
    }

    public int getUserId() {
        return this.f6231a.userId;
    }

    public void setUserId(int i) {
        this.f6231a.userId = i;
    }

    public int getGroupId() {
        return this.f6231a.groupId;
    }

    public void setGroupId(int i) {
        this.f6231a.groupId = i;
    }

    public String getUserName() {
        return this.f6231a.userName.toString();
    }

    public void setUserName(String str) {
        this.f6231a.userName = new StringBuffer(str);
    }

    public String getGroupName() {
        return this.f6231a.groupName.toString();
    }

    public void setGroupName(String str) {
        this.f6231a.groupName = new StringBuffer(str);
    }

    public void setIds(int i, int i2) {
        setUserId(i);
        setGroupId(i2);
    }

    public void setModTime(long j) {
        this.f6231a.modTime = j / 1000;
    }

    public Date getModTime() {
        return new Date(this.f6231a.modTime * 1000);
    }

    public void setModTime(Date date) {
        this.f6231a.modTime = date.getTime() / 1000;
    }

    public File getFile() {
        return this.file;
    }

    public long getSize() {
        return this.f6231a.size;
    }

    public void setSize(long j) {
        this.f6231a.size = j;
    }

    public boolean isDirectory() {
        File file = this.file;
        if (file != null) {
            return file.isDirectory();
        }
        TarHeader tarHeader = this.f6231a;
        if (tarHeader != null) {
            return tarHeader.linkFlag == 53 || this.f6231a.name.toString().endsWith("/");
        }
        return false;
    }

    public void extractTarHeader(String str) {
        this.f6231a = TarHeader.createHeader(str, this.file.length(), this.file.lastModified() / 1000, this.file.isDirectory());
    }

    public long computeCheckSum(byte[] bArr) {
        long j = 0;
        for (byte b : bArr) {
            j += b & 255;
        }
        return j;
    }

    public void writeEntryHeader(byte[] bArr) {
        int longOctalBytes = Octal.getLongOctalBytes(this.f6231a.modTime, bArr, Octal.getLongOctalBytes(this.f6231a.size, bArr, Octal.getOctalBytes(this.f6231a.groupId, bArr, Octal.getOctalBytes(this.f6231a.userId, bArr, Octal.getOctalBytes(this.f6231a.mode, bArr, TarHeader.getNameBytes(this.f6231a.name, bArr, 0, 100), 8), 8), 8), 12), 12);
        int i = longOctalBytes;
        int i2 = 0;
        while (i2 < 8) {
            bArr[i] = 32;
            i2++;
            i++;
        }
        bArr[i] = this.f6231a.linkFlag;
        for (int nameBytes = TarHeader.getNameBytes(this.f6231a.namePrefix, bArr, Octal.getOctalBytes(this.f6231a.devMinor, bArr, Octal.getOctalBytes(this.f6231a.devMajor, bArr, TarHeader.getNameBytes(this.f6231a.groupName, bArr, TarHeader.getNameBytes(this.f6231a.userName, bArr, TarHeader.getNameBytes(this.f6231a.magic, bArr, TarHeader.getNameBytes(this.f6231a.linkName, bArr, i + 1, 100), 8), 32), 32), 8), 8), TarHeader.USTAR_FILENAME_PREFIX); nameBytes < bArr.length; nameBytes++) {
            bArr[nameBytes] = 0;
        }
        Octal.getCheckSumOctalBytes(computeCheckSum(bArr), bArr, longOctalBytes, 8);
    }

    public void parseTarHeader(byte[] bArr) {
        this.f6231a.name = TarHeader.parseName(bArr, 0, 100);
        this.f6231a.mode = (int) Octal.parseOctal(bArr, 100, 8);
        this.f6231a.userId = (int) Octal.parseOctal(bArr, 108, 8);
        this.f6231a.groupId = (int) Octal.parseOctal(bArr, 116, 8);
        this.f6231a.size = Octal.parseOctal(bArr, 124, 12);
        this.f6231a.modTime = Octal.parseOctal(bArr, 136, 12);
        this.f6231a.checkSum = (int) Octal.parseOctal(bArr, 148, 8);
        this.f6231a.linkFlag = bArr[156];
        this.f6231a.linkName = TarHeader.parseName(bArr, 157, 100);
        this.f6231a.magic = TarHeader.parseName(bArr, DeepRecoverARiverProxy.TYPE_ENTITY_APP, 8);
        this.f6231a.userName = TarHeader.parseName(bArr, 265, 32);
        this.f6231a.groupName = TarHeader.parseName(bArr, 297, 32);
        this.f6231a.devMajor = (int) Octal.parseOctal(bArr, 329, 8);
        this.f6231a.devMinor = (int) Octal.parseOctal(bArr, 337, 8);
        this.f6231a.namePrefix = TarHeader.parseName(bArr, 345, TarHeader.USTAR_FILENAME_PREFIX);
    }
}
