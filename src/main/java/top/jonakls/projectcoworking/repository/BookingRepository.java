package top.jonakls.projectcoworking.repository;

import top.jonakls.projectcoworking.entity.BookingEntity;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Repositorio sencillo para almacenar las reservas de los usuarios.
 * Implementa la interfaz Iterable para poder recorrer las reservas.
 * Utiliza un ConcurrentHashMap para almacenar las reservas. Este tipo de mapa es seguro para hilos.
 * Se implementa el patrón Singleton para asegurar que solo exista una instancia de este repositorio.
 * Se implementa el patrón Repository para separar la lógica de negocio de la lógica de persistencia.
 * <p>
 * Se tiene en cuenta repository de este estilo para lograr implementar la persistencia sin tanto esfuerzo.
 */
public class BookingRepository implements Iterable<BookingEntity> {

    private final Map<String, BookingEntity> bookings;

    /**
     * Constructor privado para asegurar que no se pueda instanciar esta clase.
     */
    private BookingRepository() {
        this.bookings = new ConcurrentHashMap<>();
    }


    @Override
    public Iterator<BookingEntity> iterator() {
        return this.bookings.values().iterator();
    }

    /**
     * Método para guardar una reserva en el repositorio.
     *
     * @param booking Reserva a guardar.
     */
    public void save(BookingEntity booking) {
        this.bookings.put(booking.getId(), booking);
    }

    /**
     * Método para buscar una reserva por su id.
     *
     * @param id Id de la reserva a buscar.
     */
    public void findById(String id) {
        this.bookings.get(id);
    }

    /**
     * Método para eliminar una reserva por su id.
     *
     * @param id Id de la reserva a eliminar.
     */
    public void deleteById(String id) {
        this.bookings.remove(id);
    }

    /**
     * Método para obtener todas las reservas.
     *
     * @return Todas las reservas.
     */
    public Collection<BookingEntity> findAll() {
        return this.bookings.values();
    }

    /**
     * Método para obtener la cantidad de reservas.
     *
     * @return Cantidad de reservas.
     */
    public static BookingRepository getInstance() {
        return BookingRepository.Singleton.INSTANCE;
    }

    /**
     * Clase interna para implementar el patrón Singleton.
     */
    private static class Singleton {
        private static final BookingRepository INSTANCE = new BookingRepository();
    }

}
