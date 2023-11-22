package com.google.common.io;

import com.google.common.base.StandardSystemProperty;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
abstract class TempFileCreator {
    static final TempFileCreator INSTANCE = pickSecureCreator();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract File createTempDir();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract File createTempFile(String str) throws IOException;

    private static TempFileCreator pickSecureCreator() {
        try {
            try {
                Class.forName("java.nio.file.Path");
                return new JavaNioCreator();
            } catch (ClassNotFoundException unused) {
                return new ThrowingCreator();
            } catch (IllegalAccessException unused2) {
                return new ThrowingCreator();
            } catch (NoSuchFieldException unused3) {
                return new ThrowingCreator();
            }
        } catch (ClassNotFoundException unused4) {
            if (((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get(null)).intValue()) {
                return new ThrowingCreator();
            }
            return new JavaIoCreator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class JavaNioCreator extends TempFileCreator {
        private static final FileAttribute<Set<PosixFilePermission>> RWX_USER_ONLY = PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rwx------"));
        private static final FileAttribute<Set<PosixFilePermission>> RW_USER_ONLY = PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("rw-------"));

        private JavaNioCreator() {
            super();
        }

        @Override // com.google.common.io.TempFileCreator
        final File createTempDir() {
            try {
                return java.nio.file.Files.createTempDirectory(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), null, RWX_USER_ONLY).toFile();
            } catch (IOException e) {
                throw new IllegalStateException("Failed to create directory", e);
            }
        }

        @Override // com.google.common.io.TempFileCreator
        final File createTempFile(String str) throws IOException {
            return java.nio.file.Files.createTempFile(Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]), str, null, RW_USER_ONLY).toFile();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class JavaIoCreator extends TempFileCreator {
        private static final int TEMP_DIR_ATTEMPTS = 10000;

        private JavaIoCreator() {
            super();
        }

        @Override // com.google.common.io.TempFileCreator
        final File createTempDir() {
            File file = new File(StandardSystemProperty.JAVA_IO_TMPDIR.value());
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            sb.append("-");
            String obj = sb.toString();
            for (int i = 0; i < 10000; i++) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(i);
                File file2 = new File(file, sb2.toString());
                if (file2.mkdir()) {
                    return file2;
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create directory within 10000 attempts (tried ");
            sb3.append(obj);
            sb3.append("0 to ");
            sb3.append(obj);
            sb3.append(9999);
            sb3.append(')');
            throw new IllegalStateException(sb3.toString());
        }

        @Override // com.google.common.io.TempFileCreator
        final File createTempFile(String str) throws IOException {
            return File.createTempFile(str, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ThrowingCreator extends TempFileCreator {
        private static final String MESSAGE = "Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().";

        private ThrowingCreator() {
            super();
        }

        @Override // com.google.common.io.TempFileCreator
        final File createTempDir() {
            throw new IllegalStateException(MESSAGE);
        }

        @Override // com.google.common.io.TempFileCreator
        final File createTempFile(String str) throws IOException {
            throw new IOException(MESSAGE);
        }
    }

    private TempFileCreator() {
    }
}
