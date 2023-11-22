package io.split.android.client.storage.legacy;

import com.google.common.base.Strings;
import com.google.gson.JsonSyntaxException;
import io.split.android.client.dtos.ChunkHeader;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.MemoryUtils;
import io.split.android.client.utils.MemoryUtilsImpl;
import io.split.android.client.utils.logger.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/* loaded from: classes9.dex */
public class FileStorageHelper {
    public static final String LINE_SEPARATOR;
    private static final int MEMORY_ALLOCATION_TIMES = 2;
    private final MemoryUtils mMemoryUtils;

    static {
        LINE_SEPARATOR = System.getProperty("line.separator") != null ? System.getProperty("line.separator") : "\n";
    }

    public FileStorageHelper() {
        this(new MemoryUtilsImpl());
    }

    public FileStorageHelper(MemoryUtils memoryUtils) {
        this.mMemoryUtils = memoryUtils;
    }

    public List<ChunkHeader> readAndParseChunkHeadersFile(String str, IStorage iStorage) {
        if (isOutdated(iStorage.lastModified(str))) {
            return new ArrayList();
        }
        try {
            String read = iStorage.read(str);
            if (read != null) {
                return (List) Json.fromJson(read, ChunkHeader.CHUNK_HEADER_TYPE);
            }
            return null;
        } catch (JsonSyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to parse saved chunks headers: ");
            sb.append(e.getLocalizedMessage());
            Logger.e(e, sb.toString(), new Object[0]);
            return null;
        } catch (IOException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable chunks headers information from disk: ");
            sb2.append(e2.getLocalizedMessage());
            Logger.e(e2, sb2.toString(), new Object[0]);
            return null;
        } catch (Exception e3) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Error loading chunk headers from disk: ");
            sb3.append(e3.getLocalizedMessage());
            Logger.e(e3, sb3.toString(), new Object[0]);
            return null;
        }
    }

    public ChunkHeader chunkFromLine(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return newHeaderChunk();
        }
        try {
            return (ChunkHeader) Json.fromJson(str, ChunkHeader.class);
        } catch (JsonSyntaxException unused) {
            return newHeaderChunk();
        }
    }

    public FileWriter fileWriterFrom(File file, String str) throws IOException {
        return new FileWriter(new File(file, str));
    }

    public void closeFileInputStream(FileInputStream fileInputStream) {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error closing file input stream: ");
                sb.append(e.getLocalizedMessage());
                Logger.w(sb.toString());
            }
        }
    }

    public void closeScanner(Scanner scanner) {
        if (scanner != null) {
            scanner.close();
        }
    }

    public void closeFileWriter(FileWriter fileWriter) {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error closing file writer: ");
                sb.append(e.getLocalizedMessage());
                Logger.w(sb.toString());
            }
        }
    }

    public void logIfScannerException(Scanner scanner, String str) {
        if (scanner.ioException() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(scanner.ioException().getLocalizedMessage());
            Logger.e(sb.toString());
        }
    }

    public void writeChunkHeaderLine(ChunkHeader chunkHeader, FileWriter fileWriter) throws IOException {
        fileWriter.write(Json.toJson(chunkHeader));
        fileWriter.write(LINE_SEPARATOR);
    }

    public String checkMemoryAndReadFile(String str, IStorage iStorage) {
        if (isOutdated(iStorage.lastModified(str))) {
            return null;
        }
        long fileSize = iStorage.fileSize(str);
        if (fileSize > 0 && this.mMemoryUtils.isMemoryAvailableToAllocate(fileSize, 2)) {
            try {
                return iStorage.read(str);
            } catch (IOException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to load file from disk: ");
                sb.append(str);
                sb.append(" error: ");
                sb.append(e.getLocalizedMessage());
                Logger.e(e, sb.toString(), new Object[0]);
                return null;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to parse file ");
        sb2.append(str);
        sb2.append(". Memory not available");
        Logger.w(sb2.toString());
        return null;
    }

    private ChunkHeader newHeaderChunk() {
        return new ChunkHeader(UUID.randomUUID().toString(), 1);
    }

    public boolean isOutdated(long j) {
        return (System.currentTimeMillis() / 1000) - ServiceConstants.RECORDED_DATA_EXPIRATION_PERIOD > j;
    }
}
