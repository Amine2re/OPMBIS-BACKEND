package ms.com.Booktreasure.services;

import ms.com.Booktreasure.dao.bookRepository;
import ms.com.Booktreasure.dao.goodsRepository;
import ms.com.Booktreasure.dao.warehouseRepository;
import ms.com.Booktreasure.model.data.Warehouse.warehouse.Warehouse;
import ms.com.Booktreasure.model.data.book.book.Book;
import ms.com.Booktreasure.model.data.good.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommonService extends warehouseImpl{

    @Autowired
    bookRepository br;
    @Autowired
    goodsRepository gr;
    @Autowired
    warehouseRepository wr;


    // Methode reutilisable !!

    public List<?> findByIdWarehouseFromListObjectFound(Long idWarehouse , List<?> listOfObjectFoundByIdWarehouse , Object objectType) {

        List<Object> finalListFound = new ArrayList<>();
        List<Object> lsFound = (List<Object>) listOfObjectFoundByIdWarehouse;


        if (objectType instanceof Book){
            lsFound.forEach(bookFound -> {
                if ( ((Book) bookFound).getWarehouse().getIdWarehouse()==idWarehouse) {
                    finalListFound.add(bookFound);
                }
            });
        } else if (objectType instanceof Good) {
            lsFound.forEach(goodFound -> {
                if (((Good) goodFound).getWarehouse().getIdWarehouse() == idWarehouse) {
                    finalListFound.add(goodFound);
                }
            });
        }

        return finalListFound;

    }

    public Object getObjectByType(Object objectType){
        if(objectType instanceof Good)
            objectType=new Good();
        else if(objectType instanceof Book)
            objectType = new Book();
        return objectType;
    }

    public List<?>  findAllObjectByType(Object typeObject){
        List<?> lsObjectFound = new ArrayList<>();
        if(typeObject instanceof Good){
            lsObjectFound = gr.findAll();
        }else if(typeObject instanceof Book){
            lsObjectFound = br.findAll();
        }
        return lsObjectFound;
    }


    public List<Object> findObjectByDaily(Long idWarehouse , List<?> listOfObjectFoundByIdWarehouse , LocalDate day ){
        List<Object> listOfObjectFoundByDaily = new ArrayList<>();
        if(listOfObjectFoundByIdWarehouse!=null){
            listOfObjectFoundByIdWarehouse.forEach(objectDailyFound-> {

                if (objectDailyFound instanceof Book) {
                    Book book = (Book) objectDailyFound;
                    if (book.getPublicationDate().equals(day)) {
                        listOfObjectFoundByDaily.add(book);
                    }
                }else if (objectDailyFound instanceof Good) {
                        Good good = (Good) objectDailyFound;
                        if (good.getPublicationDate().equals(day)) {
                            listOfObjectFoundByDaily.add(good);
                        }
                    } else
                        new RuntimeException("Not Object found for " + day);

            });
        }else{
            new RuntimeException("Pas d'objet trouvé ayant comme id " + idWarehouse);
        }
        return listOfObjectFoundByDaily;

    }

    public List<Object> findObjectByWeekly( List<?> listOfObjectFoundByIdWarehouse,int weekNumber , LocalDate date , Object object ){

        List<LocalDate> listDateByInterval = (List<LocalDate>) WeekConvertToDayInterval(date, weekNumber);
        LocalDate minDate = (LocalDate) listDateByInterval.get(0);
        LocalDate maxDate = (LocalDate) listDateByInterval.get(1);
        return (List<Object>) getObjectByIntervalDate(listOfObjectFoundByIdWarehouse,minDate.getDayOfMonth(),maxDate.getDayOfMonth(),object,"weekly");

    };

    public List<Object> findObjectByQuartly(List<?> listOfObjectFoundByIdWarehouse , LocalDate date , int trim , Object typeObject){

        List<LocalDate> listTrimByInterval = (List<LocalDate>) QuartlyConvertToMonthInterval(date, trim);
        LocalDate minTrim =  listTrimByInterval.get(0);
        LocalDate maxTrim =  listTrimByInterval.get(1);

        return (List<Object>) getObjectByIntervalDate(listOfObjectFoundByIdWarehouse,minTrim.getMonthValue(),maxTrim.getMonthValue(),typeObject,"quartly");

    }

    public List<Object> findObjectByYearly(List<?> listOfObjectFoundByIdWarehouse , LocalDate initDate , LocalDate lastDate , Object typeObject){

        List<LocalDate> listTrimByInterval = YearlyConvertToMonthInterval(initDate,lastDate);
        LocalDate minTrim =  listTrimByInterval.get(0);
        LocalDate maxTrim =  listTrimByInterval.get(1);

        return (List<Object>) getObjectByIntervalDate(listOfObjectFoundByIdWarehouse,minTrim.getYear(),maxTrim.getYear(),typeObject,"yearly");

    }


    // Methodes utilitaires !!

    public List<LocalDate> WeekConvertToDayInterval(LocalDate date , int week){

        int dayInterval = 0;
        List<LocalDate> lsLocalDate = new ArrayList<>();

        switch (week) {
            case 1: dayInterval = 9 ;break;
            case 2: dayInterval = 18;break;
            case 3: dayInterval = 27;break;
            case 4: dayInterval = 31;break;
            default:;
        }

        // min -> index 1 , max -> index 2

        lsLocalDate.add(LocalDate.of(date.getYear(),date.getMonthValue(),dayInterval-8));
        lsLocalDate.add(LocalDate.of(date.getYear(),date.getMonthValue(),dayInterval ));

        return lsLocalDate;
    }
    public List<LocalDate> QuartlyConvertToMonthInterval(LocalDate date , int trim){

        int trimInterval = 0;
        List<LocalDate> lsLocalDate = new ArrayList<>();

        switch (trim) {
            case 1: trimInterval = 4 ;break;
            case 2: trimInterval = 6;break;
            case 3: trimInterval = 9;break;
            case 4: trimInterval = 12;break;
            default:;
        }

        // min -> index 1 , max -> index 2


        lsLocalDate.add(LocalDate.of(date.getYear(),trimInterval-3,date.getDayOfMonth()));
        lsLocalDate.add(LocalDate.of(date.getYear(),trimInterval,date.getDayOfMonth()));

        return lsLocalDate;
    }
    public List<LocalDate> YearlyConvertToMonthInterval(LocalDate initDate , LocalDate finalDate){

        List<LocalDate> lsLocalDate = new ArrayList<>();

        lsLocalDate.add(initDate);
        lsLocalDate.add(finalDate);

        return lsLocalDate;
    }

    public Object getObjectByIntervalDate(List<?> listOfObjectFoundByIdWarehouse, int initDate , int finalDate , Object typeObject ,String keyword){
        List lsFound =  listOfObjectFoundByIdWarehouse;
        if(typeObject instanceof Book){

            List<Book> lsBookFound = new ArrayList<>();
            br.findAll().forEach(bookFound->{

                if(keyword.equals("quartly")){
                    if(bookFound.getPublicationDate().getMonthValue()>=initDate && bookFound.getPublicationDate().getMonthValue()<=finalDate){
                        lsBookFound.add(bookFound);
                    }
                }
                else if(keyword.equals("daily")){
                    if(bookFound.getPublicationDate().getDayOfMonth()>=initDate && bookFound.getPublicationDate().getDayOfMonth()<=finalDate){
                        lsBookFound.add(bookFound);
                    }
                }
                else if(keyword.equals("weekly")){
                    if(bookFound.getPublicationDate().getDayOfMonth()>=initDate && bookFound.getPublicationDate().getDayOfMonth()<=finalDate){
                        lsBookFound.add(bookFound);
                    }
                }
                else if(keyword.equals("yearly")){
                    if(bookFound.getPublicationDate().getYear()>=initDate && bookFound.getPublicationDate().getYear()<=finalDate){
                        lsBookFound.add(bookFound);
                    }
                }
            });
            lsFound = lsBookFound;
            // lsFound = Collections.singletonList(lsBookFound);

        }else if(typeObject instanceof Good){
            List<Good> lsGoodFound = new ArrayList<>();
            gr.findAll().forEach(goodFound->{
                if(keyword.equals("quartly")){
                    if(goodFound.getPublicationDate().getMonthValue()>=initDate && goodFound.getPublicationDate().getMonthValue()<=finalDate){
                        lsGoodFound.add(goodFound);
                    }
                }
                else if(keyword.equals("daily")){
                    if(goodFound.getPublicationDate().getDayOfMonth()>=initDate && goodFound.getPublicationDate().getDayOfMonth()<=finalDate){
                        lsGoodFound.add(goodFound);
                    }
                }
                else if(keyword.equals("weekly")){
                    if(goodFound.getPublicationDate().getDayOfMonth()>=initDate && goodFound.getPublicationDate().getDayOfMonth()<=finalDate){
                        lsGoodFound.add(goodFound);
                    }
                }
                else if(keyword.equals("yearly")){
                    if(goodFound.getPublicationDate().getYear()>=initDate && goodFound.getPublicationDate().getYear()<=finalDate){
                        lsGoodFound.add(goodFound);
                    }
                }
            });
            lsFound = lsGoodFound;
            // return lsGoodFound;

            //lsFound = Collections.singletonList(lsGoodFound);
        }

        return lsFound ;
    }


    @Override
    public Optional<Warehouse> getWarehouseById(Long idWarehouse) {
        return Optional.empty();
    }

    @Override
    public List<Warehouse> getAllWarehouse() {
        return null;
    }
}
