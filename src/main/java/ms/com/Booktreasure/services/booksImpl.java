package ms.com.Booktreasure.services;

import ms.com.Booktreasure.dao.authorRepository;
import ms.com.Booktreasure.dao.bookRepository;
import ms.com.Booktreasure.dao.warehouseRepository;
import ms.com.Booktreasure.model.data.book.book.Author;
import ms.com.Booktreasure.model.data.book.book.Book;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class booksImpl  implements booksInterface {


    CommonService commonService;

    public booksImpl(CommonService commonService) {
        this.commonService = commonService;
    }

    List<Book> dailyBookList , weeklyBookList , quartlyBookList, yearlyBookList ;
    Book livre ;
    Author auteur;

    @Autowired
    bookRepository bRepos ;

    @Autowired
    authorRepository aRepos;

    @Autowired
    warehouseRepository wRepos;


    public List<Book> findBookFromIdWarehouse(Long idWarehouse){
        List<Book> listOfBookFoundByIdWarehouse = new ArrayList<>();
          bRepos.findAll().forEach( b->{

            if (b.getWarehouse().getIdWarehouse()==idWarehouse){
                listOfBookFoundByIdWarehouse.add(b);
            }
        });
          return  listOfBookFoundByIdWarehouse;
    }

    @Override
    public List<Object> dailyBookPurchaseByIdWarehouse(Long idWarehouse, String date) {

        LocalDate today= LocalDate.parse(date);
        if(!findBookFromIdWarehouse(idWarehouse).isEmpty()) {
          return commonService.findObjectByDaily(idWarehouse,findBookFromIdWarehouse(idWarehouse),today);
         }else
            return null;
    }

    @Override
    public List<Object> weeklyBookPurchaseByIdWarehouse(Long idWarehouse, int week , String date) {
        List listOfObjectFoundByIdWarehouse = findBookFromIdWarehouse(idWarehouse);
        if(!listOfObjectFoundByIdWarehouse.isEmpty()) {
            return commonService.findObjectByWeekly(listOfObjectFoundByIdWarehouse,week,LocalDate.parse(date),new Book());
        }else
            return null;
    }

    @Override
    public List<Object> quartlyBookPurchaseByIdWarehouse(Long idWarehouse, String date, int trimestre) {
        List listOfObjectFoundByIdWarehouse = findBookFromIdWarehouse(idWarehouse);
        if(!listOfObjectFoundByIdWarehouse.isEmpty()) {
            return commonService.findObjectByQuartly(listOfObjectFoundByIdWarehouse, LocalDate.parse(date), trimestre, new Book());
        }else
            return null;
    }



    @Override
    public List<Object> yearlyBookPurchaseByIdWarehouse(Long idWarehouse, String initDate, String lastDate){

        List listOfObjectFoundByIdWarehouse = findBookFromIdWarehouse(idWarehouse);
        if(!listOfObjectFoundByIdWarehouse.isEmpty()) {
          return commonService.findObjectByYearly(listOfObjectFoundByIdWarehouse,LocalDate.parse(initDate),LocalDate.parse(lastDate),new Book());
        }else
            return  null;
    }
}
