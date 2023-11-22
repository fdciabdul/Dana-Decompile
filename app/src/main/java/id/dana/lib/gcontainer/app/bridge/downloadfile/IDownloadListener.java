package id.dana.lib.gcontainer.app.bridge.downloadfile;

import io.reactivex.Observable;
import java.io.File;

/* loaded from: classes9.dex */
public interface IDownloadListener {
    Observable<File> download(String str, String str2, String str3);
}
