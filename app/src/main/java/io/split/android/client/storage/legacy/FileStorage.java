package io.split.android.client.storage.legacy;

import io.split.android.client.utils.logger.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class FileStorage implements IStorage {
    protected final File mDataFolder;

    public FileStorage(File file, String str) {
        File file2 = new File(file, str);
        this.mDataFolder = file2;
        if (file2.exists() || file2.mkdir()) {
            return;
        }
        Logger.e("There was a problem creating Split cache folder");
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public String getRootPath() {
        return this.mDataFolder.getAbsolutePath();
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public String read(String str) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(this.mDataFolder, str));
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        sb.append(new String(bArr, 0, read));
                    } else {
                        return sb.toString();
                    }
                } catch (IOException e) {
                    Logger.e(e, "Can't read file", new Object[0]);
                    throw e;
                }
            }
        } catch (FileNotFoundException e2) {
            Logger.d(e2.getMessage());
            return null;
        }
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public boolean write(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(this.mDataFolder, str));
                try {
                    fileOutputStream.write(str2.getBytes());
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        Logger.e(e, "Failed to stop file", new Object[0]);
                        return true;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    Logger.e(e, "Failed to write content", new Object[0]);
                    throw e;
                } catch (IOException e3) {
                    e = e3;
                    Logger.e(e, "Failed to write content", new Object[0]);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            Logger.e(e4, "Failed to stop file", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public void delete(String str) {
        if (new File(this.mDataFolder, str).delete()) {
            return;
        }
        Logger.e("There was a problem removing Split cache file");
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public void delete(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            delete(it.next());
        }
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public String[] getAllIds() {
        File[] listFiles = new File(this.mDataFolder, ".").listFiles();
        if (listFiles == null) {
            return new String[0];
        }
        String[] strArr = new String[listFiles.length];
        int i = 0;
        for (File file : listFiles) {
            strArr[i] = file.getName();
            i++;
        }
        return strArr;
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public List<String> getAllIds(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : getAllIds()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public boolean rename(String str, String str2) {
        return new File(this.mDataFolder, str).renameTo(new File(this.mDataFolder, str2));
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public boolean exists(String str) {
        return new File(this.mDataFolder, str).exists();
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public long lastModified(String str) {
        File file = new File(this.mDataFolder, str);
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    @Override // io.split.android.client.storage.legacy.IStorage
    public long fileSize(String str) {
        return new File(this.mDataFolder, str).length();
    }
}
