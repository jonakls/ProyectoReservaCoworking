package top.jonakls.projectcoworking.repository;

import top.jonakls.projectcoworking.entity.BookingEntity;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingRepository implements Iterable<BookingEntity> {

    private final Map<String, BookingEntity> bookings;

    private BookingRepository() {
        this.bookings = new ConcurrentHashMap<>();
    }


    @Override
    public Iterator<BookingEntity> iterator() {
        return this.bookings.values().iterator();
    }

    public void save(BookingEntity booking) {
        this.bookings.put(booking.getId(), booking);
    }

    public void findById(String id) {
        this.bookings.get(id);
    }

    public void deleteById(String id) {
        this.bookings.remove(id);
    }

    public Collection<BookingEntity> findAll() {
        return this.bookings.values();
    }

    public static BookingRepository getInstance() {
        return BookingRepository.Singleton.INSTANCE;
    }

    private static class Singleton {
        private static final BookingRepository INSTANCE = new BookingRepository();
    }

}
