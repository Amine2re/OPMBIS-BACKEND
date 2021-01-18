package ms.com.Booktreasure.services;

import ms.com.Booktreasure.dao.goodsRepository;
import ms.com.Booktreasure.model.data.good.Good;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class goodsImpl implements goodsInterface{

    List<Good> dailyGoodList , weeklyGoodList , quartlyGoodList, yearlyGoodList ;

    @Autowired
    goodsRepository gRepos;

    CommonService commonService;

    public goodsImpl(CommonService commonService) {
        this.commonService = commonService;
    }

    public List<Good> findGoodFromIdWarehouse(Long idWarehouse){
        List<Good> listOfGoodFoundByIdWarehouse = new ArrayList<>();
        gRepos.findAll().forEach( b->{

            if (b.getWarehouse().getIdWarehouse()==idWarehouse){
                listOfGoodFoundByIdWarehouse.add(b);
            }
        });
        return  listOfGoodFoundByIdWarehouse;
    }

    public Object findByDaily(){
        return commonService.findObjectByDaily((long)1,findGoodFromIdWarehouse((long)1), LocalDate.parse("2021-01-12"));
    }

    @Override
    public List<Object> dailyGoodPurchaseByIdWarehouse(Long idWarehouse, String today) {

        if(!findGoodFromIdWarehouse(idWarehouse).isEmpty()) {
            return commonService.findObjectByDaily(idWarehouse,findGoodFromIdWarehouse(idWarehouse),LocalDate.parse(today));
        }else
            return null;
    }

    @Override
    public List<Object> weeklyGoodPurchaseByIdWarehouse(Long idWarehouse, int week , String date) {
        List listOfObjectFoundByIdWarehouse = findGoodFromIdWarehouse(idWarehouse);
        if(!listOfObjectFoundByIdWarehouse.isEmpty()) {
            return commonService.findObjectByWeekly(listOfObjectFoundByIdWarehouse,week,LocalDate.parse(date),new Good());
        }else
            return null;
    }

    @Override
    public List<Object> quartlyGoodPurchaseByIdWarehouse(Long idWarehouse, String date, int trimestre) {
        List listOfObjectFoundByIdWarehouse = findGoodFromIdWarehouse(idWarehouse);
        if(!listOfObjectFoundByIdWarehouse.isEmpty()) {
            return commonService.findObjectByQuartly(listOfObjectFoundByIdWarehouse, LocalDate.parse(date), trimestre, new Good());
        }else
            return null;
    }

    @Override
    public List<Object> yearlyGoodPurchaseByIdWarehouse(Long idWarehouse, String initDate, String lastDate) {
        List listOfObjectFoundByIdWarehouse = findGoodFromIdWarehouse(idWarehouse);
        if(!listOfObjectFoundByIdWarehouse.isEmpty()) {
            System.out.println("Init Date value : " + initDate);
            System.out.println("Last Date value : " + lastDate);
            return commonService.findObjectByYearly(listOfObjectFoundByIdWarehouse,LocalDate.parse(initDate),LocalDate.parse(lastDate),new Good());
        }else
            return  null;
    }
}
