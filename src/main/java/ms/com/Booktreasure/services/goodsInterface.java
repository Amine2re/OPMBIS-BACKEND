package ms.com.Booktreasure.services;

import java.time.LocalDate;
import java.util.List;


public interface goodsInterface  {


    public List<Object> dailyGoodPurchaseByIdWarehouse(Long idWarehouse, String today);

    public List<Object> weeklyGoodPurchaseByIdWarehouse(Long idWarehouse, int week , String date);

    public List<Object> quartlyGoodPurchaseByIdWarehouse(Long idWarehouse, String date, int trimestre);

    public List<Object> yearlyGoodPurchaseByIdWarehouse(Long idWarehouse, String initDate, String lastDate);
}
