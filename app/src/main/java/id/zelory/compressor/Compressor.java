package id.zelory.compressor;

import android.content.Context;
import android.graphics.Bitmap;
import com.alibaba.wireless.security.SecExceptionCode;
import io.reactivex.Flowable;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public class Compressor {
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    public int BuiltInFictitiousFunctionClassFactory = SecExceptionCode.SEC_ERROR_SIGNATURE_ILLEGEL_KEY;
    public int getAuthRequestContext = 816;
    public Bitmap.CompressFormat PlaceComponentResult = Bitmap.CompressFormat.JPEG;
    private int MyBillsEntityDataFactory = 80;

    public Compressor(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().getPath());
        sb.append(File.separator);
        sb.append("images");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sb.toString();
    }

    public final File BuiltInFictitiousFunctionClassFactory(File file, String str) throws IOException {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = this.getAuthRequestContext;
        Bitmap.CompressFormat compressFormat = this.PlaceComponentResult;
        int i3 = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(File.separator);
        sb.append(str);
        return ImageUtil.getAuthRequestContext(file, i, i2, compressFormat, i3, sb.toString());
    }

    /* renamed from: id.zelory.compressor.Compressor$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Callable<Flowable<File>> {
        final /* synthetic */ String BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Compressor PlaceComponentResult;
        final /* synthetic */ File getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public Flowable<File> call() {
            try {
                return Flowable.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory));
            } catch (IOException e) {
                return Flowable.MyBillsEntityDataFactory(e);
            }
        }
    }

    /* renamed from: id.zelory.compressor.Compressor$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements Callable<Flowable<Bitmap>> {
        final /* synthetic */ File KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Compressor getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
        public Flowable<Bitmap> call() {
            try {
                Compressor compressor = this.getAuthRequestContext;
                return Flowable.KClassImpl$Data$declaredNonStaticMembers$2(ImageUtil.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, compressor.BuiltInFictitiousFunctionClassFactory, compressor.getAuthRequestContext));
            } catch (IOException e) {
                return Flowable.MyBillsEntityDataFactory(e);
            }
        }
    }
}
