package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private FileChannel f6801a = null;
    private FileLock b = null;
    private RandomAccessFile c = null;
    private File d = null;
    private boolean e;
    private String f;

    public c(Context context, String str) {
        this.e = true;
        this.f = str;
        this.e = c();
    }

    private boolean c() {
        try {
            File file = new File(this.f);
            this.d = file;
            if (!file.exists()) {
                this.d.createNewFile();
            }
        } catch (Exception unused) {
            if (!this.d.exists()) {
                try {
                    this.d.createNewFile();
                } catch (Exception unused2) {
                }
            }
        }
        File file2 = this.d;
        return file2 != null && file2.exists();
    }

    public boolean a() {
        if (!this.e) {
            boolean c = c();
            this.e = c;
            if (!c) {
                return true;
            }
        }
        try {
            if (this.d != null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.d, "rw");
                this.c = randomAccessFile;
                FileChannel channel = randomAccessFile.getChannel();
                this.f6801a = channel;
                this.b = channel.lock();
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean b() {
        boolean z = true;
        if (this.e) {
            try {
                FileLock fileLock = this.b;
                if (fileLock != null) {
                    fileLock.release();
                    this.b = null;
                }
            } catch (IOException unused) {
                z = false;
            }
            try {
                FileChannel fileChannel = this.f6801a;
                if (fileChannel != null) {
                    fileChannel.close();
                    this.f6801a = null;
                }
            } catch (IOException unused2) {
                z = false;
            }
            try {
                RandomAccessFile randomAccessFile = this.c;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                    this.c = null;
                }
                return z;
            } catch (IOException unused3) {
                return false;
            }
        }
        return true;
    }
}
