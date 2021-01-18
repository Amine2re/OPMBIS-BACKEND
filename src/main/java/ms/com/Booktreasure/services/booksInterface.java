package ms.com.Booktreasure.services;

import java.time.LocalDate;
import java.util.List;

public interface booksInterface {


    public List<Object> dailyBookPurchaseByIdWarehouse(Long idWarehouse, String today);
    public List<Object> quartlyBookPurchaseByIdWarehouse(Long idWarehouse, String year, int trimestre);

    public List<Object> weeklyBookPurchaseByIdWarehouse(Long idWarehouse, int week , String date);

    public List<Object> yearlyBookPurchaseByIdWarehouse(Long idWarehouse, String initDate, String lastDate);


    //public List<Object> quartlyBookPurchaseByIdWarehouse(List<?> listOfObjectFoundByIdWarehouse, LocalDate date, int trimestre) {
      //  return findObjectByQuartly(listOfObjectFoundByIdWarehouse,date,trimestre,new Book());
    //}

    //public List<Object> yearlyBookPurchaseByIdWarehouse(List<?> listOfObjectFoundByIdWarehouse , LocalDate dateInit , LocalDate lastDate) {
     //   return findObjectByYearly(listOfObjectFoundByIdWarehouse,dateInit,lastDate,new Book());
    //}
}
