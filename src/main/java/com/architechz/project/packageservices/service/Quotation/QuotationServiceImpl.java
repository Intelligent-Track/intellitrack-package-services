package com.architechz.project.packageservices.service.Quotation;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.architechz.project.packageservices.models.City;
import com.architechz.project.packageservices.payload.InsertionRequest.QuotationRequest;
import com.architechz.project.packageservices.repository.CityRepository;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Autowired
    CityRepository cityRepository;

    List<List<? extends Number>> prices = Arrays.asList(
        Arrays.asList(0.0,147088.02,51435.21,90867.55,37188.58,25244.58,141831.01,6226.27,129564.08,91604.83,81360.80,15977.40,110146.80,16158.00,53478.20,95267.72,106598.44,45584.61,93023.40,6714.30,48372.69,188134.49,146487.17,116749.99,84415.54,140460.66,149713.92,77904.60,110856.13),
        Arrays.asList(147088.02,0,137272.09,83390.47,178630.52,166668.91,14070.86,144632.31,96450.85,143677.71,224939.36,142337.02,249811.24,129831.66,101648.62,238876.87,50133.48,164545.22,234243.72,134418.54,187573.53,42586.17,11910.01,32809.81,139761.06,277784.90,46770.83,164488.22,168392.50),
        Arrays.asList(51435.21,138233.82,0,55255.22,89187.92,77043.29,135233.75,54842.99,92171.94,35006.67,84220.29,31395.20,160911.25,49692.97,62323.89,98130.08,118254.94,47110.43,145233.02,55359.04,99123.05,174708.22,130892.80,128776.44,30340.24,194100.54,136279.15,21374.71,60821.25),
        Arrays.asList(90867.55,83390.47,55255.22,0,131675.22,117840.86,88596.13,91558.30,34641.23,58901.60,148179.89,73840.73,204654.47,79268.42,69881.52,162106.85,109926.36,108335.14,188954.02,86425.16,131948.99,109425.00,72681.46,92592.50,48009.32,222895.83,70963.23,85645.65,85044.63),
        Arrays.asList(37188.58,178630.52,89187.92,131675.22,0,25595.66,168678.93,36927.18,167304.49,129349.34,89400.94,53921.04,110966.93,51646.55,83029.98,88345.56,138165.03,84570.79,95360.70,40470.06,47119.67,223907.24,182885.80,148715.83,122565.86,142636.98,185496.87,115527.09,154195.64),
        Arrays.asList(25244.58,166668.91,77043.29,117840.86,25595.66,0,161392.86,28809.41,154936.42,118851.36,60862.23,42088.72,82857.70,39675.44,71387.91,59806.48,130051.14,53005.44,67235.92,28658.10,16881.42,215809.66,169830.80,140598.63,114475.84,112179.98,177392.03,103527.19,135633.56),
        Arrays.asList(142208.58,14070.86,134649.58,88596.13,169056.50,161770.43,0,138169.95,97456.06,145265.02,218499.98,135025.80,244978.97,124938.27,96732.67,232355.29,42877.12,157430.28,229331.70,129469.00,184886.34,61970.02,27199.35,25562.63,148200.43,283610.40,55197.09,160943.14,160604.28),
        Arrays.asList(6226.27,143855.34,62257.02,91911.13,37331.10,25534.45,135942.05,0,128637.82,88156.61,88424.25,22609.90,102797.21,14192.00,45831.05,102342.20,101246.89,52036.70,91879.88,3144.68,48849.96,187016.25,144553.59,110899.42,91476.37,132229.83,148544.32,84377.68,117182.64),
        Arrays.asList(129564.08,92457.87,92171.94,34641.23,167304.49,154936.42,97456.06,122424.23,0,93125.18,177464.59,111393.51,240830.07,117287.90,97230.14,191360.62,120142.57,145492.91,225157.91,123565.89,166192.54,120557.59,85054.37,102801.70,77290.99,259971.55,82913.51,122465.48,121360.24),
        Arrays.asList(92534.51,143677.71,25647.67,58901.60,130279.02,119781.03,145265.02,89086.28,93125.18,0,118466.57,65012.14,195381.91,80262.43,89891.11,132374.42,150401.17,91085.67,174824.40,88107.56,131736.29,155422.94,132846.48,160912.46,3315.64,220492.19,116960.64,55685.26,26347.48),
        Arrays.asList(81360.80,224939.36,84220.29,148179.89,89400.94,60862.23,218122.41,88424.25,177464.59,117536.89,0,65449.88,93334.94,98986.19,122050.98,39595.70,181556.97,33815.81,80069.16,88613.14,40983.88,238010.47,210142.33,191730.14,120846.42,122798.16,199598.73,106740.61,147670.99),
        Arrays.asList(15977.40,143163.40,31395.20,73840.73,53921.04,42088.72,135474.61,19382.05,111393.51,64082.46,65449.88,0,125707.58,32954.45,67250.72,79355.11,116124.87,26087.01,110086.04,23649.94,61038.07,172578.16,127693.40,131592.86,68496.88,157541.81,134149.09,57750.54,96261.68),
        Arrays.asList(110146.80,249811.24,160911.25,204654.47,110966.93,82857.70,244601.40,102797.21,240830.07,194452.23,93334.94,125707.58,0,126318.21,154868.58,34947.93,204061.95,94806.10,14636.79,111878.14,52666.68,289774.86,261466.56,214210.97,188445.31,33115.08,251304.16,187353.41,226087.88 ),
        Arrays.asList(16158.00,129831.66,48731.24,79268.42,51646.55,39675.44,124560.70,13604.69,117287.90,78371.02,98986.19,32954.45,126318.21,0,34464.37,112891.12,90586.55,64674.27,110967.24,8861.84,64360.47,173413.13,129922.00,100740.06,77257.50,156215.72,134942.58,61728.84,107911.59),
        Arrays.asList(53478.20,101648.62,61362.15,69881.52,83029.98,71387.91,96355.10,39835.30,97230.14,87999.70,122050.98,67250.72,154868.58,34464.37,0,142877.78,57291.78,77605.25,139285.52,38227.13,94915.90,155537.39,118586.37,69681.61,99306.17,193275.02,116352.75,86944.42,120838.92),
        Arrays.asList(95267.72,238876.87,98130.08,162106.85,89118.51,60579.43,231977.72,102342.20,191360.62,131444.75,39595.70,79355.11,34014.69,112891.12,142877.78,0,200145.15,47719.63,20782.20,102243.49,39833.93,252646.67,224312.28,210321.19,134033.35,63416.27,213396.38,120645.55,159622.87),
        Arrays.asList(106598.44,49738.10,117293.20,109530.98,138165.03,130051.14,42877.12,101246.89,119747.19,148509.76,181556.97,116124.87,204061.95,90586.55,57291.78,200145.15,0,151300.49,186871.37,91716.79,148087.10,104211.98,75891.00,16105.83,156614.17,229528.67,65006.38,144923.52,174843.38),
        Arrays.asList(45584.61,162931.65,48724.01,108335.14,84570.79,53005.44,156589.65,53457.38,145492.91,90155.99,33815.81,26087.01,94806.10,64674.27,77605.25,47719.63,151300.49,0,79893.47,52848.04,38525.03,202936.31,151223.95,161837.75,85881.31,134362.16,163782.37,73504.29,111867.48),
        Arrays.asList(93023.40,234243.72,145233.02,188954.02,95360.70,67235.92,228954.13,89524.95,225157.91,173894.72,80069.16,11086.04,14636.79,110967.24,139285.52,20782.20,186871.37,79893.47,0,96265.51,37104.12,275965.85,245838.34,197006.96,172537.58,46613.06,235870.77,171684.69,210340.98),
        Arrays.asList(6714.30,134418.54,54397.30,86425.16,40470.06,28658.10,129091.43,3664.22,123565.89,86216.15,88613.14,23649.94,111878.14,8861.84,38227.13,102243.49,91859.70,52848.04,96265.51,0,53312.89,181437.87,139765.54,102006.70,85553.86,141051.47,143005.35,80365.01,108021.52),
        Arrays.asList(48372.69,187573.53,99123.05,131948.99,47119.67,16881.42,184508.77,48849.96,166192.54,130806.61,40983.88,61038.07,52666.68,64360.47,94915.90,39833.93,148087.10,38525.03,37104.12,53312.89,0,237131.30,206958.15,158216.62,133709.27,90272.58,197934.04,127966.05,162271.37),
        Arrays.asList(188134.49,42586.17,173746.49,109425.00,223907.24,215809.66,61970.02,187016.25,121359.04,155422.94,238010.47,172578.16,289774.86,173413.13,155537.39,252646.67,104607.36,203737.75,275965.85,181437.87,237131.30,0,26293.01,88104.47,164474.29,318738.55,31818.79,197384.98,186880.42),      
        Arrays.asList(146487.17,11910.01,129931.07,72681.46,182885.80,169830.80,27199.35,159107.23,85054.37,132846.48,210142.33,126090.51,261466.56,129922.00,118586.37,224312.28,76286.38,152025.40,245838.34,139765.54,205647.34,26293.01,0,59783.35,136144.35,299808.79,38155.81,157136.57,160904.12),       
        Arrays.asList(116749.99,32809.81,127437.14,92592.50,148338.26,140221.06,25562.63,110521.85,102801.70,158643.48,191730.14,126268.81,214210.97,100740.06,69681.61,210321.19,16105.83,161460.18,197006.96,101875.32,158216.62,88104.47,59783.35,0,166761.29,239669.14,48898.83,155098.53,192510.57),
        Arrays.asList(85345.22,136659.41,28666.99,52803.35,124480.28,104111.10,130195.05,92406.05,89039.71,3315.64,121776.10,66103.30,189374.99,82576.77,101834.74,135678.44,158505.58,81710.37,180603.82,81353.44,135424.67,164474.29,134393.03,168652.70,0,218850.59,125267.49,53930.78,25243.27),        
        Arrays.asList(140460.66,277784.90,194100.54,222895.83,142636.98,112179.98,283232.83,132229.83,259971.55,219562.52,122798.16,157541.81,33115.08,156215.72,193275.02,64349.51,229528.67,134362.16,46613.06,141051.47,90272.58,318738.55,299808.79,239669.14,215331.80,0,279547.94,226102.55,264916.19), 
        Arrays.asList(149713.92,46770.83,135317.42,70963.23,185496.87,177392.03,55197.09,148544.32,82913.51,116960.64,199598.73,134149.09,251304.16,134942.58,116352.75,213519.83,65401.76,164626.41,238036.19,143006.51,197406.33,31818.79,38155.81,48898.83,125267.49,280842.86,0,158184.36,147700.94),
        Arrays.asList(77904.60,165449.95,21374.71,85645.65,115527.09,103527.19,161527.30,77356.53,122465.48,54755.58,106740.61,57750.54,187353.41,62690.58,87906.16,120645.55,145885.26,73504.29,171684.69,81326.74,127966.05,196808.57,158098.31,156060.26,53606.04,226102.55,159146.10,0,31142.35),
        Arrays.asList(110856.13,168392.50,60821.25,85044.63,154195.64,135633.56,160604.28,118916.96,121360.24,26347.48,147670.99,96261.68,226087.88,108873.32,121800.66,161557.22,175805.11,111867.48,210340.98,108983.25,162271.37,186880.42,160904.12,185992.15,21811.81,264916.19,146899.49,31142.35,0)
    );

    @Override
    public List<City> listAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public float getPrice(QuotationRequest quotationRequest){

        List<City> listCities = cityRepository.findAll();
        int origin=1;
        int destination=1;
        float cost;
        int hoursWaitting=10;
        float costPerTon;
        int aditionalCost=1;
        int truckTypeFactor=1;
        float costoRuta;
        
        for (int i = 0; i < listCities.size(); i++) if(quotationRequest.getOriginCity().getName().equals(listCities.get(i).getName())) origin=i;
        for (int i = 0; i < listCities.size(); i++) if(quotationRequest.getDestinationCity().getName().equals(listCities.get(i).getName())) destination=i;    
        
        Float weigh=quotationRequest.getWeight();
        

        if(weigh<=18) {
            truckTypeFactor = 9;
            aditionalCost = 1817;
        }
        else if(weigh<=25) {
            truckTypeFactor = 16;
            aditionalCost =  1422;
        }
        else if(weigh<31) {
            truckTypeFactor = 34;
            aditionalCost =  812;
        }

        costoRuta=prices.get(origin).get(destination).floatValue();
        if(costoRuta!=0){
            costPerTon= prices.get(origin).get(destination).floatValue()+(aditionalCost*hoursWaitting);
            cost=costPerTon*truckTypeFactor*(weigh); 
            return cost;
        }
        

        return 0;

    }

    
}

