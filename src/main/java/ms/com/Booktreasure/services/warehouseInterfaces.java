package ms.com.Booktreasure.services;

import ms.com.Booktreasure.dao.bookRepository;
import ms.com.Booktreasure.dao.goodsRepository;
import ms.com.Booktreasure.dao.warehouseRepository;
import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;
import ms.com.Booktreasure.model.data.book.book.Book;
import ms.com.Booktreasure.model.data.good.Good;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public interface warehouseInterfaces  {

    public Optional<Warehouse> getWarehouseById(Long idWarehouse);

    public List<Warehouse> getAllWarehouse();

    public List<Good> dailyGoodPurchaseByIdWarehouse(Long idWarehouse, LocalDate today);

    public List<Good> weeklyGoodPurchaseByIdWarehouse(Long idWarehouse, int Week);
    public List<Good> quartlyGoodPurchaseByIdWarehouse(Long idWarehouse, LocalDate year, int trimestre);

    public List<Good> yearlyGoodPurchaseByIdWarehouse(Long idWarehouse, LocalDate year);

}
