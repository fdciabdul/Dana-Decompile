package id.dana.data.devicestats;

import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.devicestats.model.FileDirectoriesInMbModel;
import id.dana.domain.devicestats.storage.model.FileDirectoriesModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/devicestats/FileDirectoriesSizeMapper;", "", "", "p0", "", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "p1", "Lid/dana/data/devicestats/model/FileDirectoriesInMbModel;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "", "BuiltInFictitiousFunctionClassFactory", "(D)D", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileDirectoriesSizeMapper {
    @Inject
    public FileDirectoriesSizeMapper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<FileDirectoriesInMbModel> getAuthRequestContext(String p0, List<FileDirectoriesModel> p1) {
        List<FileDirectoriesModel> list = p1;
        int i = 1;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(1);
        FileDirectoriesInMbModel fileDirectoriesInMbModel = new FileDirectoriesInMbModel(sb.toString(), arrayList2);
        arrayList.add(fileDirectoriesInMbModel);
        int i2 = 0;
        for (FileDirectoriesModel fileDirectoriesModel : p1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fileDirectoriesModel.getPath());
            sb2.append(", ");
            double size = fileDirectoriesModel.getSize();
            double pow = Math.pow(10.0d, 1.0d);
            double roundToInt = MathKt.roundToInt(size * pow);
            Double.isNaN(roundToInt);
            sb2.append(roundToInt / pow);
            String obj = sb2.toString();
            if (i2 > 0 && obj.length() + i2 > 255) {
                ArrayList arrayList3 = new ArrayList();
                i++;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(p0);
                sb3.append(InputCardNumberView.DIVIDER);
                sb3.append(i);
                FileDirectoriesInMbModel fileDirectoriesInMbModel2 = new FileDirectoriesInMbModel(sb3.toString(), arrayList3);
                arrayList.add(fileDirectoriesInMbModel2);
                fileDirectoriesInMbModel = fileDirectoriesInMbModel2;
                i2 = 0;
            }
            fileDirectoriesInMbModel.PlaceComponentResult.add(obj);
            i2 += obj.length();
        }
        return CollectionsKt.toList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double BuiltInFictitiousFunctionClassFactory(double p0) {
        double pow = Math.pow(10.0d, 1.0d);
        double roundToInt = MathKt.roundToInt(p0 * pow);
        Double.isNaN(roundToInt);
        return roundToInt / pow;
    }
}
