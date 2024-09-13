package top.jonakls.projectcoworking.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase utilitaria para el manejo de fechas.
 * <p>
 * Esta clase contiene métodos para convertir fechas de tipo {@link String} a {@link Date} y viceversa.
 * Además, contiene un método para formatear una fecha en un {@link String} con un formato específico.
 * El formato de fecha utilizado es "yyyy-MM-dd".
 * El formato de fecha utilizado para formatear es "EEEE, d 'de' MMMM 'de' yyyy". en español.
 * </p>
 */
public final class DateUtil {
    private DateUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Convierte una fecha de tipo {@link String} a {@link Date}.
     *
     * <p>
     * El formato de fecha utilizado es "yyyy-MM-dd".
     * Si la fecha no puede ser convertida, se retorna {@code null}.
     * </p>
     *
     * @param date la fecha a convertir.
     * @return la fecha convertida a {@link Date}.
     */
    public static Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Convierte una fecha de tipo {@link Date} a {@link String}.
     * <p>
     * El formato de fecha utilizado es "yyyy-MM-dd".
     * Si la fecha no puede ser convertida, se retorna {@code null}.
     * </p>
     *
     * @param date la fecha a convertir.
     * @return la fecha convertida a {@link String}.
     */
    public static String parseStringDate(Date date) {
        final SimpleDateFormat sdf = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        return sdf.format(date);
    }
}
