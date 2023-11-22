package id.dana.richview.calculator.model;

import com.alibaba.ariver.resource.api.prepare.PrepareException;
import id.dana.richview.calculator.OperandType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class GenerateCalculatorData {
    private GenerateCalculatorData() {
    }

    public static List<CalculatorItemModel> getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        List<String> asList = Arrays.asList("7", "8", PrepareException.ERROR_OFFLINE_APP);
        CalculatorItemModel calculatorItemModel = new CalculatorItemModel();
        calculatorItemModel.BuiltInFictitiousFunctionClassFactory = asList;
        calculatorItemModel.KClassImpl$Data$declaredNonStaticMembers$2 = OperandType.PLUS;
        arrayList.add(calculatorItemModel);
        List<String> asList2 = Arrays.asList("4", "5", "6");
        CalculatorItemModel calculatorItemModel2 = new CalculatorItemModel();
        calculatorItemModel2.BuiltInFictitiousFunctionClassFactory = asList2;
        calculatorItemModel2.KClassImpl$Data$declaredNonStaticMembers$2 = OperandType.MINUS;
        arrayList.add(calculatorItemModel2);
        List<String> asList3 = Arrays.asList("1", "2", "3");
        CalculatorItemModel calculatorItemModel3 = new CalculatorItemModel();
        calculatorItemModel3.BuiltInFictitiousFunctionClassFactory = asList3;
        calculatorItemModel3.KClassImpl$Data$declaredNonStaticMembers$2 = OperandType.MULTIPLIER;
        arrayList.add(calculatorItemModel3);
        List<String> asList4 = Arrays.asList("0", "000", "99");
        CalculatorItemModel calculatorItemModel4 = new CalculatorItemModel();
        calculatorItemModel4.BuiltInFictitiousFunctionClassFactory = asList4;
        calculatorItemModel4.KClassImpl$Data$declaredNonStaticMembers$2 = OperandType.DIVIDER;
        arrayList.add(calculatorItemModel4);
        return arrayList;
    }
}
