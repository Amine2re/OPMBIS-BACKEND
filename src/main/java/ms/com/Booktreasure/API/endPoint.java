package ms.com.Booktreasure.API;

import ms.com.Booktreasure.dao.authorRepository;
import ms.com.Booktreasure.dao.warehouseRepository;
import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;
import ms.com.Booktreasure.model.data.book.book.Author;
import ms.com.Booktreasure.model.data.book.book.Book;
import ms.com.Booktreasure.services.AuthorService;
import ms.com.Booktreasure.services.booksImpl;
import ms.com.Booktreasure.services.goodsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:4200")
public class TestAPI {
    booksImpl bookService;
    goodsImpl goodService;
    AuthorService authService;
    warehouseRepository wRepos;
    warehouseRepository gRepos;
    authorRepository aRepos;


    public TestAPI(booksImpl bookService, goodsImpl goodService, warehouseRepository wRepos, warehouseRepository gRepos, authorRepository aRepos , AuthorService authService) {
        this.bookService = bookService;
        this.goodService = goodService;
        this.authService = authService;
        this.wRepos = wRepos;
        this.gRepos = gRepos;
        this.aRepos = aRepos;
    }




  /*

    @GetMapping("/testApi/newInsert")
    public void insert() {
        bookService.newBook();
    }

   */

    @GetMapping("/getBooks")
    public List<Book> getBook() {
      //  return bookService.getBooks();
        return null;
    }

    @GetMapping("/getAuthors")
    public List<Author> getAuthors() {
       // return bookService.authors();
        return null;
    }

    @GetMapping("/book/findBookByIdWarehouse/{idWarehouse}")
        public Object findBookByPrice(@PathVariable(name = "idWarehouse") Long idWarehouse){
        LocalDate date = LocalDate.of(2021,01,15);
        //String aat = "2021-01-15 00:56:35"


            return   bookService.findBookFromIdWarehouse(idWarehouse);
    }



    @PostMapping("/saveWarehouse")
    public String saveWarehouse() {

        Warehouse wh = new Warehouse("W_Dakar", "Dakar", "221338320038");

        if (wRepos.save(wh) != null) {
            return "Failed";
        } else {
            return "Failed";
        }
       // return "anyOne";
    }

    @GetMapping("/book/findByDaily/{idWarehouse}/{date}")
    public List<Object> findBookByDaily(@PathVariable(name = "idWarehouse") Long idWarehouse , @PathVariable(name = "date") String date){
        return bookService.dailyBookPurchaseByIdWarehouse(idWarehouse, date);
    }

    @GetMapping("/book/findByWeekly/{idWarehouse}/{date}/{week}")
    public List<Object> findBookByWeekly(@PathVariable(name = "idWarehouse") Long idWarehouse , @PathVariable(name = "date") String date , @PathVariable(name = "week") int week ){
       // LocalDate date = LocalDate.of(2021,01,15);
        return bookService.weeklyBookPurchaseByIdWarehouse(idWarehouse,week,date);
    }

    @GetMapping("/book/findByQuartly/{idWarehouse}/{date}/{trim}")
    public List<Object> findBookByQuartly(@PathVariable(name = "idWarehouse") Long idWarehouse ,@PathVariable(name = "date") String date,@PathVariable(name = "trim") int trim){
       // LocalDate date = LocalDate.of(2021,02,15);

        return bookService.quartlyBookPurchaseByIdWarehouse(idWarehouse,date,trim);

    }

    @GetMapping("/book/findByYearly/{idWarehouse}/{initDate}/{finalDate}")
    public List<Object> findBookByYearly(@PathVariable(name = "idWarehouse") Long idWarehouse , @PathVariable(name = "initDate") String initDate, @PathVariable(name = "finalDate") String finalDate ){


        return bookService.yearlyBookPurchaseByIdWarehouse(idWarehouse,initDate,finalDate);
    }

    @GetMapping("/conversion/{week}")
    public Object convertWeekToDate(@PathVariable(name = "week") int week){
        LocalDate date = LocalDate.of(2021,01,15);
        return null;
    }

    @GetMapping("/getObjectsByIdWarehouse/{idWarehouse}")
    public List<Object> getObjectByIdWarehouse(@PathVariable(name = "idWarehouse") Long idWarehouse){
        return null;
    }


    // API FOR GOODS


    @GetMapping("/findGooodByIdWarehouse/{idWarehouse}")
    public Object findGoodByPrice(@PathVariable(name = "idWarehouse") Long idWarehouse ){
        LocalDate date = LocalDate.of(2021,01,15);
        //String aat = "2021-01-15 00:56:35"
        return   goodService.findGoodFromIdWarehouse(idWarehouse);
    }


    @GetMapping("/good/findByDaily/{idWarehouse}/{date}")
    public List<Object> findGoodByDaily(@PathVariable(name = "idWarehouse") Long idWarehouse,@PathVariable(name = "date") String date){
        return goodService.dailyGoodPurchaseByIdWarehouse(idWarehouse, date);
    }

    @GetMapping("/good/findByWeekly/{idWarehouse}/{date}/{week}")
    public List<Object> findGoodByWeekly(@PathVariable(name = "idWarehouse") Long idWarehouse ,@PathVariable(name = "date") String date , @PathVariable(name = "week") int week ){
       // LocalDate date = LocalDate.of(2021,01,15);
        return goodService.weeklyGoodPurchaseByIdWarehouse(idWarehouse,week,date);
    }

    @GetMapping("/good/findByQuartly/{idWarehouse}/{date}/{trim}")
    public List<Object> findGoodByQuartly(@PathVariable(name = "idWarehouse") Long idWarehouse ,@PathVariable(name = "date") String date ,@PathVariable(name = "trim") int trim){
      //  LocalDate date = LocalDate.of(2021,02,15);

        return goodService.quartlyGoodPurchaseByIdWarehouse(idWarehouse,date,trim);

    }

    @GetMapping("/good/findByYearly/{idWarehouse}/{initDate}/{finalDate}")
    public List<Object> findGoodByYearly(@PathVariable(name = "idWarehouse") Long idWarehouse ,@PathVariable(name = "initDate") String initDate ,@PathVariable(name = "finalDate") String finalDate ){
        return goodService.yearlyGoodPurchaseByIdWarehouse(idWarehouse,initDate,finalDate);
    }

    @GetMapping("/findGoodByIdWarehouse/{idWarehouse}")
    public Object getDailyGood(@PathVariable(name = "idWarehouse") long idWarehouse){
        return goodService.findGoodFromIdWarehouse(idWarehouse);
    }
    
    @GetMapping("/getAuthor/{idAuthor}")
    public Object getAuthor(@PathVariable(name = "idAuthor") Long idAuthor){
        return authService.getAuthor(idAuthor);
    }



}
