import com.github.javafaker.Faker;
import entities.Evento;
import entities.EventoDAO;
import entities.TipoEvento;

import javax.persistence.EntityManager;
import java.util.Locale;
import java.util.function.Supplier;

import static utils.JpaUtil.getEntityManagerFactory;

public class Application {

    public static void main(String[] args) {
        EntityManager em=getEntityManagerFactory().createEntityManager();
        Faker faker=new Faker(Locale.ITALY);
        Supplier<Evento> privateEventSupplier=()-> new Evento(faker.name().fullName(),faker.date().birthday(),"Consuelnza per impianto fotovoltaico", TipoEvento.PRIVATO, faker.number().numberBetween(2,10) );
        Supplier<Evento> publicEventSupplier=()-> new Evento(faker.name().fullName(),faker.date().birthday(),"Matrimonio", TipoEvento.PUBBLICO, faker.number().numberBetween(30,100) );
try {
//    for (int i = 0; i < 2; i++) {
//        EventoDAO ed=new EventoDAO(em);
//        Evento event;
//        if(i%2==0){
//            event = privateEventSupplier.get();
//        }else{
//            event = publicEventSupplier.get();
//        }
//        ed.save(event);
//    }
    EventoDAO ed=new EventoDAO(em);

//    Evento eventFromDB= ed.findById(6);
//    if(eventFromDB!=null){
//        System.out.println(eventFromDB);
//    }
    ed.findByIdAndDelete(5);

    Evento eventFromDB = ed.findById(6);
    if (eventFromDB != null) {
        eventFromDB.setTipoevento(TipoEvento.PRIVATO);
        System.out.println("PRE REFRESH");
        System.out.println(eventFromDB);

        em.refresh(eventFromDB);
        System.out.println("POST REFRESH");
        System.out.println(eventFromDB);
    }

}catch (Exception ex){
    System.err.println(ex.getMessage());
}finally {
    em.close();
}
    }
}
